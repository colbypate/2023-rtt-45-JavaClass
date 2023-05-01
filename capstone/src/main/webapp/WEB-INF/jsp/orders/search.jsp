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
                                                    <p class="fw-bold text-start mb-1">Search Orders:</p>
                                                    <div class="input-group mb-3">
                                                        <input type="text" class="form-control" name="id"
                                                            placeholder="Order ID" aria-label="id" value="${id}">
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
                                                <h1 class="mb-5">Orders</h1>
                                            </center>
                                            <div class="container text-center">

                                                <h4 class="pb-2">${orderList.size()} Orders</h4>

                                                <table class="table table-striped border">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">Id</th>
                                                            <th scope="col">Order Date</th>
                                                            <th scope="col">Orderer</th>
                                                            <th scope="col">Status</th>
                                                            <th scope="col">More Info</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${orderList}" var="ord">
                                                            <tr>
                                                                <td>${ord.id}</td>
                                                                <td>${ord.orderDate}</td>
                                                                <td>${ord.userId}</td>
                                                                <!-- <td>${orrd.totalPrice}</td> -->
                                                                <td>${ord.status}</td>
                                                                <td><a href="/orders/orderDetails/${ord.id}"
                                                                        class="btn btn-primary">Details</a></td>
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
                </div>
            </section>

        </body>

        <jsp:include page="../include/footer.jsp" />