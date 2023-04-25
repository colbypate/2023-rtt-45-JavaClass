<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
                                <section class="pt-5 pb-5 bg-dark-grey">
                                    <div class="container text-center">
                                        <h1>Employee Details</h1>
                                    </div>
                                </section>


                                <div class="row">
                                    <section class="col-7 pt-5 pb-5 bg-light-grey">
                                        <div class="container">
                                            <table class="table table-striped border">
                                                <tr>
                                                    <td>Employee Id</td>
                                                    <td>${user.id}</td>
                                                </tr>
                                                <tr>
                                                    <td>First Name</td>
                                                    <td>${user.firstName}</td>
                                                </tr>
                                                <tr>
                                                    <td>Last Name</td>
                                                    <td>${user.lastName}</td>
                                                </tr>
                                                <tr>
                                                    <td>Email</td>
                                                    <td>${user.email}</td>
                                                </tr>
                                                <tr>
                                                    <td>Job</td>
                                                    <td>${user.job}</td>
                                                </tr>
                                            </table>
                                        </div>
                                    </section>
                                    <section class="col-5 pt-5 pb-5 bg-light-grey">
                                        <div class="container">
                                            <table class="table table-striped border">
                                                <tr>
                                                    <td>
                                                        <h3 class="">Total Sales</h3>
                                                    </td>
                                                    <td> </td>
                                                </tr>
                                                <tr>
                                                    <td style="font-size: 50px; color: green;">$${user.totalSales}</td>
                                                </tr>
                                            </table>
                                        </div>
                                    </section>


                                    <jsp:include page="../include/footer.jsp" />
                                </div>
                            </div>
                        </div>
                    </div>
            </section>
        </body>