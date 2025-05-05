import './menubar.css'

function Menubar() {
    return (
        <>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-2">
                <a class="navbar-brand" href="#">
                    <img src="https://www.svgrepo.com/show/303109/adobe-xd-logo.svg" alt="Logo" height="40" />
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse p-2" id="navbarNav">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Dashboard</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Explore</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Manage Items</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Manage Categories</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Manage Users</a>
                        </li>
                    </ul>
                    {/* add dropdown for user profile */}
                </div>
            </nav>
        </>
    )
}

export default Menubar;