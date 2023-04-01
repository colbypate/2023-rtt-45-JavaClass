<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-light-grey">
    <div class="container text-center">
        <h1>Create Employee</h1>
    </div>
</section>

<section class="py-5 bg-dark-blue">
    <div class="container">
        <div class="row text-center justify-content-center">
            <div class="col-7">
                <form action="/employee/createSubmit">
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="firstName" placeholder="Employee First Name"
                        aria-label="Employee First Name" aria-describedby="search" value="${firstName}">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="lastName" placeholder="Employee Last Name"
                        aria-label="Employee Last Name" aria-describedby="search" value="${lastName}">
                    </div>
                    <div class="input-group mb-3">
                        <label type="text" class="form-control" name="officeId" <label>
                        <select class ="form-select" name="officeId">
                            <c:forEach items ="${offices}" var = "office">
                                <option values="${office.id}">${office.city}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="email" placeholder="Employee Email"
                        aria-label="Employee Email" aria-describedby="search" value="${email}">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="jobTitle" placeholder="Employee Job Title"
                        aria-label="Employee Job Title" aria-describedby="search" value="${jobTitle}">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="vacationHours" placeholder="Employee Vacation Hours"
                        aria-label="Employee Vacation Hours" aria-describedby="search" value="${vacationHours}">
                    </div>
                    <div class="input-group mb-3">
                      <input type="text" class="form-control" name="extension" placeholder="Employee Extension"
                      aria-label="Employee Extension" aria-describedby="search" value="${extension}">
                  </div>
                        <button class="btn btn-outline-secondary" id="firstName">Create Employee</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../include/footer.jsp" />