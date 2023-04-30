<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

            <jsp:include page="../include/header.jsp" />

            <body>
                <section class="vh-100">
                    <div class="container h-100">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col-lg-12 col-xl-12">
                                <div class="card text-black">
                                    <style>
                                        .card {
                                            border-radius: 25px;
                                            backdrop-filter: blur(2px);
                                            background-color: rgba(255, 255, 255, 0.901);
                                        }
                                    </style>
                                    <section class="pt-5 pb-5 bg-light-grey">
                                        <div class="container">
                                            <center>
                                                <h1 class="pb-5">Product Details</h1>
                                            </center>
                                            <div class="row">
                                                <div class="col-lg-8 col-xl-8">
                                                    <form action="/user/editSubmit" method="POST">
                                                        <input type="hidden" name="id" value="${form.id}">
                                                        <table class="table table-striped border">
                                                            <tr>
                                                                <td>First Name</td>
                                                                <td><input type="text" class="form-control"
                                                                        id="firstName" name="firstName"
                                                                        aria-describedby="nameHelp" required
                                                                        aria-required="name required"
                                                                        value="${form.firstName}" /></td>
                                                            </tr>
                                                            <tr>
                                                                <td>Last Name</td>
                                                                <td><input type="text" class="form-control"
                                                                        id="lastName" name="lastName"
                                                                        aria-describedby="nameHelp" required
                                                                        aria-required="name required"
                                                                        value="${form.lastName}" /></td>
                                                            </tr>
                                                            <tr>
                                                                <td>Email</td>
                                                                <td><input type="text" class="form-control" id="email"
                                                                        name="email" aria-describedby="emailHelp"
                                                                        required aria-required="email required"
                                                                        value="${form.email}" />
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>Password</td>
                                                                <td><input type="text" class="form-control"
                                                                        id="password" name="password"
                                                                        aria-describedby="emailHelp" required
                                                                        aria-required="email required"
                                                                        value="${form.password}" />
                                                                    <div id="passwordHelp" class="form-text">Password
                                                                        must
                                                                        contain at
                                                                        least one uppercase letter,
                                                                        one
                                                                        lowercase letter, and one digit
                                                                    </div>
                                                                    <c:if
                                                                        test="${bindingResult.hasFieldErrors('password')}">
                                                                        <c:forEach
                                                                            items="${bindingResult.getFieldErrors('password')}"
                                                                            var="error">
                                                                            <div class="errorMessage"
                                                                                style="color: red;">
                                                                                ${error.getDefaultMessage()}</div>
                                                                        </c:forEach>
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>Job</td>
                                                                <td><select id="job" name="job" class="form-select"
                                                                        aria-label="Default select example">
                                                                        <option selected>${form.job}</option>
                                                                        <option value="Manager">Manager</option>
                                                                        <option value="Employee">Employee</option>
                                                                        <option value="Sales">Sales</option>
                                                                    </select></td>
                                                            </tr>
                                                        </table>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="row justify-content-center gap-2">
                                            <div class="col-3 col-md-2 col-xl-1">
                                                <button type="submit" id="submit"
                                                    class="btn btn-primary">Submit</button>
                                            </div>
                                            <div class="col-3 col-md-2 col-xl-1">
                                                <button id="cancel-btn" class="btn btn-secondary"
                                                    type="button">Cancel</button>
                                            </div>
                                        </div>
                                        </form>
                                    </section>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </body>

            <jsp:include page="../include/footer.jsp" />