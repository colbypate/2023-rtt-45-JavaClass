<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
                                        background-color: rgba(255, 255, 255, 0.901);
                                    }
                                </style>
                                <section class="pt-5 bg-light-grey">
                                    <div class="container text-end">
                                        <div class="row justify-content-end">
                                            <div class="col-4">
                                                <form>
                                                    <p class="fw-bold text-start mb-1">Search Employees:</p>
                                                    <div class="input-group mb-3">
                                                        <input type="text" class="form-control" name="firstName"
                                                            placeholder="Employee First Name"
                                                            aria-label="Employee First Name"
                                                            value="${searchParamFirst}">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <input type="text" class="form-control" name="lastName"
                                                            placeholder="Employee Last Name"
                                                            aria-label="Employee First Name" value="${searchParamLast}">
                                                    </div>
                                                    <button class="btn btn-outline-secondary"
                                                        id="search">Search</button>

                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </section>
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <section class="pb-5 bg-dark-grey">
                                            <center>
                                                <h1 class="mb-5">Employees</h1>
                                            </center>
                                            <div class="container text-center">

                                                <h4 class="pb-2">${usersList.size()} Items</h4>

                                                <table class="table table-striped border">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">Id</th>
                                                            <th scope="col">First Name</th>
                                                            <th scope="col">Last Name</th>
                                                            <th scope="col">Email</th>
                                                            <th scope="col">Job</th>
                                                            <th scope="col">Total Sales</th>
                                                            <sec:authorize access="hasAnyAuthority('ADMIN')">
                                                                <th scope="col">Edit</th>
                                                            </sec:authorize>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${usersList}" var="user">
                                                            <tr>
                                                                <td><a href="/user/details/${user.id}">${user.id}</a>
                                                                </td>
                                                                <td>${user.firstName}</td>
                                                                <td>${user.lastName}</td>
                                                                <td>${user.email}</td>
                                                                <td>${user.job}</td>
                                                                <td>${user.totalSales}</td>
                                                                <sec:authorize access="hasAnyAuthority('ADMIN')">
                                                                    <td><a href="/user/edit/${user.id}"
                                                                            class="btn btn-primary">Edit</a></td>
                                                                </sec:authorize>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </section>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </section>

        </body>

        <jsp:include page="../include/footer.jsp" />