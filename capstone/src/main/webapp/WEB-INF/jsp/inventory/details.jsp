<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                                            <form action="/orders/addToCart">
                                                <input type="hidden" name="inventoryId" value="${inventory.id}">
                                                <table class="table table-striped border">
                                                    <tr>
                                                        <td>Inventory Id</td>
                                                        <td>${inventory.id}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Product Name</td>
                                                        <td>${inventory.productName}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Quantity</td>
                                                        <td>${inventory.quantity}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Price</td>
                                                        <td>${inventory.price}</td>
                                                    </tr>
                                                </table>
                                        </div>
                                        <div class="col-lg-4 col-xl-4">
                                            <table class="table table-striped border">
                                                <tr>
                                                    <td>Product Image</td>
                                                    <td><img src="${inventory.photoURL}" class="img-fluid"></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <td><button value="${inv.id}" onclick="formSubmit()" type="submit"
                                            class="btn btn-secondary">Add
                                            to
                                            Cart</button></td>
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