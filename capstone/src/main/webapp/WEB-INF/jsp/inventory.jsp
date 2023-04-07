<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="./include/header.jsp" />
<body>
    <section class="py-5 bg-light-grey">
        <div class="container text-center">
            <h1>Inventory</h1>
        </div>
    </section>
    <section class="py-5 bg-light-grey">
        <div class="container text-center">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Job Title</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                      <td>1</td>
                      <td>2</td>
                      <td>3</td>
                      <td>4</td>
                      <td>5</td>
                    </tr>
                  </tbody>

            </table>
        </div>
    </section>
</body>

<jsp:include page="./include/footer.jsp" />