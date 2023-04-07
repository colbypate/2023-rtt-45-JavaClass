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
<nav class="navbar fixed-top navbar-expand-lg shadow-lg">
    <a class="navbar-brand d-lg-none" href="#"><img src="/pub/images/ScottsStaticeSmallLogoTransparent.png"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item-logo">
                <a class="d-none d-lg-block" href="#"><img src="/pub/images/ScottsStaticeSmallLogoTransparent.png"
                        style="width: 250px; margin-left: 50px; margin-right: 50px;"></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/dashboard">Dashboard <span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/inventory">Inventory</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/vendor">Vendors</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Sales</a>
            </li>
        </ul>
        <div class="navbar-nav ms-auto">
            <div class="dropdown">
                <a class="btn dropdown-toggle nav-link" href="#" role="button" id="dropdownMenuLink"
                    data-bs-toggle="dropdown" aria-expanded="false">
                    Account
                </a>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <li><a class="dropdown-item" href="#">Profile</a></li>
                    <li><a class="dropdown-item" href="/user/login">Login</a></li>
                    <li><a class="dropdown-item" href="/user/register">Register</a></li>
                </ul>
            </div>
        </div>
        <div class="toggle-btn">
            <i class="fa-solid fa-bars"></i>
        </div>
    </div>
</nav>
<!-- Navbar -->
