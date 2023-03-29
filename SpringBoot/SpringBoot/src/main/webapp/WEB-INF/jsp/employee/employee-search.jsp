<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-light-grey">
    <div class="container text-center">
        <h1>Employee Search</h1>
    </div>
</section>

<section class="py-5 bg-dark-blue">
    <div class="container">
        <div class="row text-center justify-content-center">
            <div class="col-7">
                <form>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="firstName" placeholder="Employee First Name"
                        aria-label="Employee First Name" aria-describedby="search" value="${firstName}">
                        <button class="btn btn-outline-secondary" id="firstName">Search</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<section class="py-5 bg-light-grey">
    <div class="container text-center">
    <h3 class="pb-2">${employeesList.size()} Search Results</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Job Title</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${employeesList}" var="emp">
                <tr>
                  <th scope="row">${emp.firstName}</th>
                  <td>${emp.lastName}</td>
                  <td>${emp.email}</td>
                  <td>${emp.jobTitle}</td>
                </tr>
                </c:forEach>
              </tbody>

        </table>
    </div>
</section>
<jsp:include page="../include/footer.jsp" />