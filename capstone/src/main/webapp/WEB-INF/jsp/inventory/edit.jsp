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
                                            <form action="/inventory/editSubmit" method="POST">
                                                <input type="hidden" name="id" value="${form.id}">
                                                <table class="table table-striped border">
                                                    <tr>
                                                        <td>Product Name</td>
                                                        <td><input type="text" class="form-control" id="productName"
                                                                name="productName" aria-describedby="nameHelp" required
                                                                aria-required="name required"
                                                                value="${form.productName}" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Quantity</td>
                                                        <td><input type="number" class="form-control" id="quantity"
                                                                name="quantity" aria-describedby="quantityHelp" required
                                                                aria-required="quantity required"
                                                                value="${form.quantity}" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Price</td>
                                                        <td><input type="number" step="0.01" class="form-control"
                                                                id="price" name="price" aria-describedby="priceHelp"
                                                                required aria-required="price required"
                                                                value="${form.price}" />
                                                        </td>
                                                    </tr>
                                                </table>
                                        </div>
                                        <div class="col-lg-4 col-xl-4">
                                            <table class="table table-striped border">
                                                <h3 class="bg-dark text-light">Change inventory image:</h3>
                                                <input type="text" name="photoURL" class="form-control " id="photo_url"
                                                    aria-describedby="fileHelp" />

                                                <tr>
                                                    <td>Product Image</td>
                                                    <td><img src="${form.photoURL}"
                                                            alt="image of ${inventory.productName}" class=" img-fluid">
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="row justify-content-center gap-2">
                                    <div class="col-3 col-md-2 col-xl-1">
                                        <button type="submit" id="submit" class="btn btn-primary">Submit</button>
                                    </div>
                                    <div class="col-3 col-md-2 col-xl-1">
                                        <button id="cancel-btn" class="btn btn-secondary" type="button">Cancel</button>
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