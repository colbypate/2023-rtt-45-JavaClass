<jsp:include page="include/header.jsp" />


<body>


    <!-- Carousel -->
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
        <center>
            <h2
                style=" margin-top: 50px; width: fit-content; backdrop-filter: blur(20px); background-color: rgba(255, 255, 255, 0.589); ">
                Inventory needed for:</h2>
        </center>
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://images.unsplash.com/photo-1521536343910-07219690b9b8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
                    class="mx-auto d-block" alt="..." id="photo1" onmouseover="changeImage()">
            </div>
            <div class="carousel-item">
                <img src="https://images.unsplash.com/photo-1612328289561-0edd72aefc43?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80"
                    class="mx-auto d-block" alt="..." id="photo2">
            </div>
            <div class="carousel-item">
                <img src="https://images.pexels.com/photos/343957/pexels-photo-343957.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                    class="mx-auto d-block" alt="..." id="photo3">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <!-- Carousel -->

    <center>
        <center style="width: fit-content; backdrop-filter: blur(20px); background-color: rgba(255, 255, 255, 0.849);">
            <h1 class="m-4">
                Flowers of the Month
            </h1>
            <h4 class="ms-4">
                March 2023
            </h4>
        </center>
    </center>
    <div class="container d-flex mt-4 p-4 justify-content-center">
        <div class="card mb-3" style="max-width:540px;">
            <div class="row g-0">
                <div class="col-md-6">
                    <img src="https://images.unsplash.com/photo-1587235442308-8980bb6e0f17?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=688&q=80"
                        class="img-fluid img-thumbnail rounded-start" alt="..." style="width:540px; height:405px;">
                </div>
                <div class="col-md-6">
                    <div class="card-body">
                        <h5 class="card-title">
                            Tulips
                        </h5>
                        <p class="card-text">
                            Much like daffodils, tulips are a classic late winter and early spring flower. Tulips (which
                            come in shades as varied as vibrant yellow to pastel pink) bring an elegant, refined feel to
                            wedding arrangements.
                        </p>
                        <p class="card-text">
                            <small class="text-muted">
                                Last updated now
                            </small>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="card mb-3" style="max-width:540px;">
            <div class="row g-0">
                <div class="col-md-6">
                    <img src="https://images.unsplash.com/photo-1587317996270-908c352f1b09?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=715&q=80"
                        class="img-fluid img-thumbnail rounded-start" alt="..." style="width:540px; height:405px;">
                </div>
                <div class="col-md-6">
                    <div class="card-body">
                        <h5 class="card-title">Ranunculus</h5>
                        <p class="card-text">
                            Ranunculus naturally blooms during late winter and early spring so it'll look especially
                            fresh and sprightly at a March wedding.
                        </p>
                        <p class="card-text">
                            <small class="text-muted">
                                Last updated now
                            </small>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
