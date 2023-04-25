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
                                    /* background-color: rgba(255, 255, 255, 0.2); */
                                    background-color: #ffffffe4;
                                }
                            </style>
                            <div class="card-body p-md-5">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Register User</p>
                                <div class="row justify-content-center">
                                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                        <form id="form" action="/user/registerSubmit" method="POST">
                                            <div class="row justify-content-center">
                                                <div class="mb-3 col-8 col-xl-5">
                                                    <label for="firstName" class="form-label">First Name</label>
                                                    <input type="text" class="form-control" id="firstName"
                                                        name="firstName" aria-describedby="firstNameHelp"
                                                        value="${form.firstName}">
                                                    <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                                                        <c:forEach items="${bindingResult.getFieldErrors('firstName')}"
                                                            var="error">
                                                            <div style="color:red;">${error.getDefaultMessage()}</div>
                                                        </c:forEach>
                                                    </c:if>
                                                </div>
                                                <div class="mb-3 col-8 col-xl-5">
                                                    <label for="lastName" class="form-label">Last Name</label>
                                                    <input type="text" class="form-control" id="lastName"
                                                        name="lastName" aria-describedby="lastNameHelp"
                                                        value="${form.lastName}">
                                                    <c:if test="${bindingResult.hasFieldErrors('lastName')}">
                                                        <c:forEach items="${bindingResult.getFieldErrors('lastName')}"
                                                            var="error">
                                                            <div style="color:red;">${error.getDefaultMessage()}</div>
                                                        </c:forEach>
                                                    </c:if>
                                                </div>
                                            </div>

                                            <div class="row justify-content-center">
                                                <div class="mb-3 col-8 col-xl-6">
                                                    <label for="emailInput" class="form-label">Email address</label>
                                                    <input type="text" placeholder="Email address" class="form-control"
                                                        id="exampleInputEmail1" name="email"
                                                        aria-describedby="emailHelp" value="${form.email}">
                                                    <c:if test="${bindingResult.hasFieldErrors('email')}">
                                                        <c:forEach items="${bindingResult.getFieldErrors('email')}"
                                                            var="error">
                                                            <div style="color:red;">${error.getDefaultMessage()}</div>
                                                        </c:forEach>
                                                    </c:if>
                                                    <div id="emailHelp" class="form-text">Company Email Address</div>
                                                </div>

                                                <div class="col-4 mb-3">
                                                    <label for="job" class="form-label">Job Title</label>
                                                    <select id="job" name="job" class="form-select"
                                                        aria-label="Default select example">
                                                        <option selected>Job</option>
                                                        <option value="Manager">Manager</option>
                                                        <option value="Employee">Employee</option>
                                                        <option value="Sales">Sales</option>
                                                    </select>
                                                </div>
                                            </div>


                                            <div class="row justify-content-center">
                                                <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                                                    <label for="passwordInput" class="form-label">Password</label>
                                                    <input type="text" class="form-control" id="password"
                                                        name="password" aria-describedby="passwordHelp">
                                                    <div id="passwordHelp" class="form-text">Password must contain at
                                                        least one uppercase letter,
                                                        one
                                                        lowercase letter, and one digit
                                                    </div>
                                                    <c:if test="${bindingResult.hasFieldErrors('password')}">
                                                        <c:forEach items="${bindingResult.getFieldErrors('password')}"
                                                            var="error">
                                                            <div class="errorMessage" style="color: red;">
                                                                ${error.getDefaultMessage()}</div>
                                                        </c:forEach>
                                                    </c:if>
                                                </div>
                                                <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                                                    <label for="confirmPasswordInput" class="form-label">Confirm
                                                        Password</label>
                                                    <input type="text" class="form-control" id="confirmPassword"
                                                        name="confirmPassword" aria-describedby="confirmPasswordHelp">
                                                    <c:if test="${bindingResult.hasFieldErrors('confirmPassword')}">
                                                        <c:forEach
                                                            items="${bindingResult.getFieldErrors('confirmPassword')}"
                                                            var="error">
                                                            <div class="errorMessage" style="color: red;">
                                                                ${error.getDefaultMessage()}</div>
                                                        </c:forEach>
                                                    </c:if>
                                                </div>
                                            </div>

                                            <div class="row justify-content-center">
                                                <div class="col col-3">
                                                    <button type="submit" id="submitBtn"
                                                        class="btn btn-primary">Submit</button>
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