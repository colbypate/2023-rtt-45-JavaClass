<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                                    <section class="pt-5 bg-light-grey">
                                        <div class="container text-end">
                                            <div class="row justify-content-end">
                                                <div class="col-4">
                                                    <form>
                                                        <p class="fw-bold text-start mb-1">Search Inventory:</p>
                                                        <div class="input-group mb-3">
                                                            <input type="text" class="form-control" name="productName"
                                                                placeholder="Product Name" aria-label="Product Name"
                                                                value="${searchParam}">
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
                                                    <h1 class="mb-5">Inventory</h1>
                                                </center>
                                                <div class="container text-center">

                                                    <h4 class="pb-2">${inventoryList.size()} Items</h4>
                                                    <form action="/orders/addToCart">
                                                        <input type="hidden" name="inventoryId" value="${inventory.id}">
                                                        <table class="table table-striped border">
                                                            <thead>
                                                                <tr>
                                                                    <th scope="col">Product Name</th>
                                                                    <th scope="col">Quantity</th>
                                                                    <th scope="col">Price</th>
                                                                    <th scope="col">Add To Cart</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach items="${inventoryList}" var="inv">
                                                                    <tr>
                                                                        <td><a
                                                                                href="/inventory/details/${inv.productName}">${inv.productName}</a>
                                                                        </td>
                                                                        <td>${inv.quantity}</td>
                                                                        <td>
                                                                            <fmt:formatNumber value="${inv.price}"
                                                                                pattern="$#,##0.00" />
                                                                        </td>
                                                                        <!-- <sec:authorize access="hasAnyAuthority('ADMIN')">
                                                                        <td><a href="/inventory/edit/${inv.id}"
                                                                                class="btn btn-primary">Edit</a></td>
                                                                    </sec:authorize> -->
                                                                        <td><a href="/orders/addToCart/${inv.id}"
                                                                                class="btn btn-primary btn-lg">Add To
                                                                                Cart</a></td>
                                                                        <!-- <td><button value="${inv.id}" onclick="formSubmit()"
                                                                            type="submit" class="btn btn-secondary">Add
                                                                            to
                                                                            Cart</button></td> -->
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                        </table>
                                                    </form>
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