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
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <section class="pb-5 bg-dark-grey">
                                            <center>
                                                <h1 class="mb-5">Order Details</h1>
                                            </center>
                                            <div class="container text-center">

                                                <h4 class="pb-2">${orderDetailsList.size()} Items in this Order</h4>

                                                <table class="table table-striped border">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">Order ID</th>
                                                            <th scope="col">ID</th>
                                                            <th scope="col">Inventory ID</th>
                                                            <th scope="col">Quantity</th>
                                                            <th scope="col">Total Price</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${orderDetailsList}" var="ord">
                                                            <tr>
                                                                <td>${ord.orderId}</td>
                                                                <td>${ord.id}</td>
                                                                <td>${ord.inventoryId}</td>
                                                                <td>${ord.quantity}</td>
                                                                <td>${ord.totalPrice}</td>

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