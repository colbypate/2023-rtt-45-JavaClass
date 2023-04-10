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
                                    background-color: rgba(255, 255, 255, 0.2);
                                }
                            </style>
                            <section class="pt-5 pb-5 bg-light-grey">
                                <div class="container">
                                    <center>
                                        <h1> Search Inventory</h1>
                                    </center>
                                    <div class="row text-center justify-content-center">
                                        <div class="col-5">
                                            <form>
                                                <div class="input-group mb-3">
                                                    <input type="text" class="form-control" name="productName"
                                                        placeholder="Product Name" aria-label="Product Name"
                                                        value="${searchParam}">
                                                </div>
                                                <button class="btn btn-outline-secondary" id="search">Search</button>

                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </section>
                            <div class="container">
                                <div class="row justify-content-center">
                                    <section class="pt-5 pb-5 bg-dark-grey">
                                        <div class="container text-center">

                                            <h4 class="pb-2">${inv.productName} Details</h4>

                                            <table class="table table-striped border">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Id</th>
                                                        <th scope="col">Product Name</th>
                                                        <th scope="col">Quantity</th>
                                                        <th scope="col">Price</th>
                                                        <!-- <th scope="col">Photo</th> -->
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${inventoryList}" var="inv">
                                                        <tr>
                                                            <!-- <td><a href="/employee/detail/${emp.id}">${emp.id}</a></td> -->
                                                            <td>${inv.id}</td>
                                                            <td><a
                                                                    href="inventory/details/${inv.productName}">${inv.productName}</a>
                                                            </td>
                                                            <td>${inv.quantity}</td>
                                                            <td>${inv.price}</td>
                                                            <!-- <td>${inv.photoURL}</td> -->
                                                            <!-- <td><a href="/employee/edit/${emp.id}">Edit</a></td> -->
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