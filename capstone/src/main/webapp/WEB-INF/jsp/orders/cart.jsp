<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                                <c:if test="${!hasProducts}">
                                    <section class="pt-5 pb-5 bg-dark-grey">
                                        <div class="container text-center">
                                            <img width="400px" height='500px'
                                                src="https://z0sqrs-a.akamaihd.net/4566_storetheme/Template-Assets/images/empty-cart.svg">
                                            <h3 style="margin-top: 25px;">Looks like your cart is empty! <a href="/inventory/search">Add Items to Order</a></h3>
                                        </div>
                                    </section>
                                </c:if>
                                <c:if test="${hasProducts}">
                                    <div class="container">
                                        <div class="row justify-content-center">
                                            <section class="pb-5 bg-dark-grey">
                                                <center>
                                                    <h1 class="mb-5">Cart</h1>
                                                </center>
                                                <div class="container text-center">

                                                    <h4 class="pb-2">${productList.size()} Items</h4>

                                                    <table class="table table-striped border">
                                                        <thead>
                                                            <tr>
                                                                <th scope="col">Product Name</th>
                                                                <th scope="col">Price</th>
                                                                <th scope="col">Quantity</th>
                                                                <th scope="col">Delete From Cart</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${productList}" var="inv">
                                                                <tr>
                                                                    <td>${inv.product_name}</td>
                                                                    <td>${inv.price}</td>
                                                                    <td>${inv.quantity}</td>

                                                                    <td><a href="/orders/deleteFromCart?inventoryId=${inv.id}"
                                                                            class="btn btn-primary btn-lg">Delete</a>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="row justify-content-center">
                                                    <div class="col col-3">
                                                        <form action="/orders/submitOrder">

                                                            <button type="submit"
                                                                class="btn btn-primary">Checkout</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </section>
                                        </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </body>

        <jsp:include page="../include/footer.jsp" />