<jsp:include page="include/header.jsp" />
<section class="pt-5 pb-5" style="background-color:rgb(218, 225, 234)">
    <div class="container text-center">
        <h2 class="m-0">Create New Account</h2>
    </div>
</section>

<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
                <form method="POST" action="/signup">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">* Email address</label>
                        <input type="text" placeholder="Email address" name="email" class="form-control"
                            id="exampleInputEmail1" aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label">Full Name</label>
                        <input type="text" class="form-control" name="fullName" id="name" aria-describedby="nameHelp">
                        <div id="nameHelp" class="form-text">Let us know who you are</div>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password" id="password"
                            aria-describedby="passwordHelp">
                        <div id="passwordHelp" class="form-text">Minimum 8 characaters with uppercase, lowercase,
                            and a number</div>
                    </div>
                    <div class="mb-3">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <input type="password" class="form-control" name="confirmPassword" id="confirmPassword"
                            aria-describedby="confirmPasswordHelp">
                        <div id="confirmPasswordHelp" class="form-text">Re-enter your password.</div>
                    </div>


                    <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2">Create Account</button>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- <section class="vh-100" style="background-color: #eee;">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-lg-12 col-xl-11">
                    <div class="card text-black" style="border-radius: 25px;">
                        <div class="card-body p-md-5">
                            <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">New User Form</p>
                            <div class="row justify-content-center">
                                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                    <form id="form">
                                        <div class="row justify-content-center">
                                            <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                                                <label for="firstNameInput" class="form-label">First Name</label>
                                                <input type="text" class="form-control" id="firstNameInput">
                                            </div>
                                            <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                                                <label for="lastNameInput" class="form-label">Last Name</label>
                                                <input type="password" class="form-control" id="lastNameInput">
                                            </div>
                                        </div>

                                        <div class="row justify-content-center">
                                            <div class="mb-3 col-8 col-xl-6">
                                                <label for="emailInput" class="form-label">Email address</label>
                                                <input type="email" class="form-control" id="emailInput"
                                                    aria-describedby="emailHelp">
                                                <div id="emailHelp" class="form-text">We'll never share your email with
                                                    anyone else.</div>
                                            </div>

                                            <div class="col-4 mb-3">
                                                <label for="countryInput" class="form-label">Country</label>
                                                <select id="countryInput" class="form-select"
                                                    aria-label="Default select example">
                                                    <option selected>Country</option>
                                                    <option value="USA">USA</option>
                                                    <option value="GBR">United Kingdom</option>
                                                    <option value="AUS">Australia</option>
                                                    <option value="JPN">Japan</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row justify-content-center">
                                            <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                                                <label for="passwordInput" class="form-label">Password</label>
                                                <input type="password" class="form-control" id="passwordInput">
                                                <div id="emailHelp" class="form-text">Minimum of 8 characters, including uppercase, lowercase, and a number</div>
                                            </div>
                                            <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                                                <label for="confirmPasswordInput" class="form-label">Confirm
                                                    Password</label>
                                                <input type="password" class="form-control" id="confirmPasswordInput">
                                            </div>
                                        </div>

                                        <div class="row justify-content-start">
                                            <div class="col-2 mb-3 offset-xl-1">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="flexRadioDefault"
                                                        id="maleRadio" checked>
                                                    <label class="form-check-label" for="maleRadio">
                                                        Male
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-2 mb-3">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="flexRadioDefault"
                                                        id="femaleRadio">
                                                    <label class="form-check-label" for="femaleRadio">
                                                        Female
                                                    </label>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="row justify-content-start align-items-center">
                                            <p class="col-6 col-md-2 col-lg-3 col-xxl-3 offset-xl-1">Favorite Color:
                                            </p>
                                            <div class="mb-3 form-check col-2 col-lg-1 me-lg-4">
                                                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                                <label class="form-check-label" for="exampleCheck1">Blue</label>
                                            </div>
                                            <div class="mb-3 form-check col-2 col-lg-1 me-lg-4">
                                                <input type="checkbox" class="form-check-input" id="redCheck">
                                                <label class="form-check-label" for="redCheck">Red</label>
                                            </div>
                                            <div class="mb-3 form-check col-2 col-lg-1">
                                                <input type="checkbox" class="form-check-input" id="indigoCheck">
                                                <label class="form-check-label" for="indigoCheck">Indigo</label>
                                            </div>
                                        </div>

                                        <div class="row justify-content-center">
                                            <div class="col col-3">
                                                <button type="submit" class="btn btn-primary" onclick="formSubmit()">Submit</button>
                                            </div>
                                            <div class="col col-3">
                                                <button type="button" class="btn btn-secondary" onclick="cancelClicked()">Cancel</button>
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
    </section> -->
<jsp:include page="include/footer.jsp" />