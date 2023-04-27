<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="../include/header.jsp" />


    <body>
        <section class="vh-100">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-12 col-xl-11">
                        <div class="card text-black">
                            <style>
                                .card {
                                    border-radius: 25px;
                                    backdrop-filter: blur(2px);
                                    background-color: #ffffffe4;
                                }
                            </style>
                            <div class="card-body p-md-5">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">User Login</p>
                                <div class="row justify-content-center">
                                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                        <form id="form" method="POST" action="/login/loginpost">


                                            <div class="row justify-content-center">
                                                <div class="mb-3 col-12 col-xl-10">
                                                    <label for="emailInput" class="form-label">Email address</label>
                                                    <input type="text" class="form-control" id="emailInput"
                                                        name="username" aria-describedby="emailHelp">
                                                    <div id="emailHelp" class="form-text">Company Email Address</div>
                                                </div>
                                            </div>


                                            <div class="row justify-content-center">
                                                <div class="mb-3 col-md-12 col-sm-12 col-xl-10">
                                                    <label for="passwordInput" class="form-label">Password</label>
                                                    <input type="password" name="password" class="form-control"
                                                        id="passwordInput">
                                                    <div id="emailHelp" class="form-text"></div>
                                                </div>
                                            </div>

                                            <div class="row justify-content-center">
                                                <div class="col col-3">
                                                    <button type="submit" id="create_btn"
                                                        class="btn btn-primary">Login</button>
                                                </div>
                                                <div class="col col-3">
                                                    <button type="button" class="btn btn-secondary">Cancel</button>
                                                </div>
                                            </div>

                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </body>

    <jsp:include page="../include/footer.jsp" />