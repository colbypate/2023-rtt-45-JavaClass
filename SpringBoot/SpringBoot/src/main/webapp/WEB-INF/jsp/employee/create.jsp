<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp"/>

<section class="pt-5 pb-5 bg-dark-grey">
    <div class="container text-center">
        <!-- if the form.id is empty then we know this is a create -->
        <c:if test="${empty form.id}">
            <h1>Create Employee</h1>
        </c:if>
        <!-- if the form.id is NOT empty then we know this is an edit -->
        <c:if test="${not empty form.id}">
            <h1>Edit Employee</h1>
        </c:if>
    </div>
</section>


<section class="pt-5 pb-5 bg-light-grey">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
                <form action="/employee/createSubmit" method="POST">
                    <input type="hidden" name="id" value="${form.id}"/>
                    <div class="mb-4">
                        <label for="exampleInputEmail1" class="form-label">Email address</label>
                        <input type="text" placeholder="Email address" class="form-control" id="exampleInputEmail1" name="email"
                               aria-describedby="emailHelp" value="${form.email}">
                    </div>
                    <div class="mb-4">
                        <label for="firstName" class="form-label">First Name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" aria-describedby="firstNameHelp" value="${form.firstName}">
                    </div>
                    <div class="mb-4">
                        <label for="lastName" class="form-label">Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" aria-describedby="lastNameHelp" value="${form.lastName}">
                    </div>
                    <div class="mb-4">
                        <label for="office" class="form-label">Office</label>
                        <select id="office" name="officeId" class="form-select">
                            <c:forEach items="${offices}" var="office">
                                <option value="${office.id}"
                                        <c:if test="${office.id eq form.officeId}">
                                            selected
                                        </c:if>
                                >${office.city}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-4">
                        <label for="jobTitle" class="form-label">Job Title</label>
                        <input type="text" class="form-control" id="jobTitle" name="jobTitle" aria-describedby="jobTitleHelp" value="${form.jobTitle}">
                    </div>
                    <div class="mb-4">
                        <label for="profileImage" class="form-label">Profile Image</label>
                        <input type="text" class="form-control" id="profileImage" name="profileImage" aria-describedby="profileImageHelp" value="${form.profileImage}">
                    </div>
                    <div class="mb-4">
                        <label for="vacationHours" class="form-label">Vacation Hours</label>
                        <input type="number" class="form-control" id="vacationHours" name="vacationHours" aria-describedby="vacationHoursHelp" value="${form.vacationHours}">
                    </div>
                    <div class="mb-4">
                        <label for="extension" class="form-label">Extension</label>
                        <input type="text" class="form-control" id="extension" name="extension" aria-describedby="extensionHelp" value="${form.extension}">
                    </div>


                    <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2" onclick="formSubmit()">Create
                        Account</button>
                </form>
            </div>
        </div>
    </div>
</section>



<jsp:include page="../include/footer.jsp"/>