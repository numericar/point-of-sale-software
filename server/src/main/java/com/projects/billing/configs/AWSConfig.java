package com.projects.billing.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AWSConfig {
	@Value("${aws.keys.access}")
	private String accessKey;
	
	@Value("${aws.keys.secret}")
	private String secretKey;
	
	@Value("${aws.s3.region}")
	private String region;
	
	@Bean
	S3Client s3Client() {
		return S3Client
				.builder()
				.region(Region.of(this.region))
				.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
				.build();
	}
}
