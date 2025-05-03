package com.projects.billing.services.impl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.projects.billing.services.FileUploadService;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

	@Value("${aws.s3.bucket-name}")
	private String bucketName;

	private final S3Client s3Client;

	@Override
	public String uploadFile(MultipartFile file) {
		String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		String key = UUID.randomUUID().toString() + "." + fileExtension; // fileName

		try {
			PutObjectRequest putObjectRequest = PutObjectRequest
				.builder()
				.bucket(this.bucketName)
				.key(key)
				.acl("public-read")
				.contentType(file.getContentType())
				.build();

			PutObjectResponse response = s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));
			if (response.sdkHttpResponse().isSuccessful()) {
				return "https://" + this.bucketName + ".s3.amazons.com/" + key;
			} else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error uploading file");
			}
		} catch (IOException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error uploading file");
		}
	}

	@Override
	public boolean deleteFile(String imgUrl) {
		String fileName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1);

		DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest
			.builder()
			.bucket(this.bucketName)
			.key(fileName)
			.build();
		
		this.s3Client.deleteObject(deleteObjectRequest);

		return true;
	}

}
