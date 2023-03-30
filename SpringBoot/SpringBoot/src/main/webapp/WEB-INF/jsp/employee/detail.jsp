<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-light-grey">
    <div class="container text-center">
        <h1>Employee Detail</h1>
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
                  <td>${employee.id}</td>
                  <td><a href="/employee/search?firstName=${employee.firstName}">${employee.firstName}</a></td>
                  <td><a href="/employee/search?lastName=${employee.lastName}">${employee.lastName}</a></td>
                  <td>${employee.email}</td>
                  <td>${employee.jobTitle}</td>
                </tr>
              </tbody>

        </table>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />