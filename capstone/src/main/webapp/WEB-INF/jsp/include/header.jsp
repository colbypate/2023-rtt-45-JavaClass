<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Scott's Statice</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
            </script>
        <script src="https://kit.fontawesome.com/bbd562719d.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="/pub/css/style.css">
        <script src="/pub/js/script.js"></script>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Dancing+Script:wght@600&display=swap');
        </style>
    </head>

    <!-- Navbar -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-light shadow-lg">
        <div class="container-fluid">
            <a class="d-sm-block d-md-block d-lg-block" href="#"><img
                    src="/pub/images/ScottsStaticeSmallLogoTransparent.png"
                    style="height: 65px; margin-left: 50px; margin-right: 50px;"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/dashboard">Dashboard <span class="sr-only"></span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/inventory/search">Inventory</a>
                    </li>
                    <div class="dropdown">
                        <sec:authorize access="isAuthenticated()">
                            <a class="btn dropdown-toggle nav-link" href="#" role="button" id="dropdownMenuLink"
                                data-bs-toggle="dropdown" aria-expanded="false">
                                Orders
                            </a>
                            <ul class="dropdown-menu" style="margin-right: auto;" aria-labelledby="dropdownMenuLink">
                                <li>
                                    <a class="dropdown-item" href="/orders/search">View Orders</a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="/orders/create">Create Order</a>
                                </li>
                        </sec:authorize>
                    </div>
                    <li class="nav-item">
                        <a class="nav-link" href="/sales">Sales</a>
                    </li>
                    <div class="dropdown">
                        <sec:authorize access="hasAnyAuthority('ADMIN')">
                            <a class="btn dropdown-toggle nav-link" href="#" role="button" id="dropdownMenuLink"
                                data-bs-toggle="dropdown" aria-expanded="false">
                                Employees
                            </a>
                            <ul class="dropdown-menu" style="margin-right: auto;" aria-labelledby="dropdownMenuLink">
                                <li>
                                    <a class="dropdown-item" href="/user/search">Find Employee</a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="/user/register">Register Employee</a>
                                </li>
                        </sec:authorize>
                </ul>
            </div>
            </ul>
            <div class="navbar-nav ms-auto">
                <div>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="">
                                <sec:authentication property="principal.username" />
                            </a>
                        </li>
                    </sec:authorize>
                </div>
                <div class="dropdown">
                    <a class="btn dropdown-toggle nav-link" href="#" role="button" id="dropdownMenuLink"
                        data-bs-toggle="dropdown" aria-expanded="false">
                        Account
                    </a>
                    <ul class="dropdown-menu" style="margin-right: auto;" aria-labelledby="dropdownMenuLink">
                        <sec:authorize access="isAuthenticated()">
                            <li><a class="dropdown-item" href="/user/details">Profile</a></li>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <li><a class="dropdown-item" href="/login/loginPage">Login</a></li>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <li class="nav-item">
                                <a class="dropdown-item" href="/login/logout">Logout</a>
                            </li>
                        </sec:authorize>
                    </ul>
                </div>
            </div>
        </div>
        </div>
    </nav>
    <!-- Navbar -->