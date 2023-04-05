<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-light-grey">
    <div class="container text-center">
        <c:if test="${empty form.id}">
            <h1>Create Employee</h1>
        </c:if>
        <c:if test="${not empty form.id}">
            <h1>Edit Employee</h1>
        </c:if>
    </div>
</section>

<section class="py-5 bg-dark-blue">
    <div class="container">

        <div class="row text-center justify-content-center">
            <div class="col-7">
                <form action="/employee/createSubmit">
                <input type="hidden" name="id" value="${form.id}"/>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="firstName" placeholder="Employee First Name"
                        aria-label="Employee First Name" aria-describedby="search" value="${form.firstName}">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="lastName" placeholder="Employee Last Name"
                        aria-label="Employee Last Name" aria-describedby="search" value="${form.lastName}">
                    </div>
                    <div class="input-group mb-3">
                        <label type="text" class="form-control" name="officeId" <label>
                        <select class ="form-select" name="officeId">
                            <c:forEach items ="${offices}" var = "office">
                                <option value="${office.id}"
                                <c:if test="${office.id eq form.officeId}">
                                selected
                                </c:if>
                                >${office.city}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="email" placeholder="Email"
                        aria-label="Email" aria-describedby="search" value="${form.email}">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="profileImage" placeholder="Profile Image"
                        aria-label="Profile Image" aria-describedby="search" value="${form.profileImage}">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="jobTitle" placeholder="Employee Job Title"
                        aria-label="Employee Job Title" aria-describedby="search" value="${form.jobTitle}">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="vacationHours" placeholder="Employee Vacation Hours"
                        aria-label="Employee Vacation Hours" aria-describedby="search" value="${form.vacationHours}">
                    </div>
                    <div class="input-group mb-3">
                      <input type="text" class="form-control" name="extension" placeholder="Employee Extension"
                      aria-label="Employee Extension" aria-describedby="search" value="${form.extension}">
                  </div>
                        <button class="btn btn-outline-secondary" id="firstName">Create Employee</button>
                    </div>
                    <button type="submit" onclick>
                            <c:if test="${empty form.id}">
                                <h1>Create Employee</h1>
                            </c:if>
                            <c:if test="${not empty form.id}">
                                <h1>Edit Employee</h1>
                            </c:if>
                    </button>
                </form>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../include/footer.jsp" />