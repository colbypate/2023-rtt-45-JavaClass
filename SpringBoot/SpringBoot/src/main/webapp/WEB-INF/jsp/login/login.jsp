<jsp:include page="../include/header.jsp" />
<section class="pt-5 pb-5" style="background-color:rgb(218, 225, 234)">
    <div class="container text-center">
        <h2 class="m-0">User Login</h2>
    </div>
</section>

<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
                <!--the method must always be POST and the action must match the securty config .login -->
                <form method="POST" action="/login/loginpost">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Email address</label>
                        <input type="text" placeholder="Email address" name="username" class="form-control"
                            id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" placeholder="Password" class="form-control" name="password" id="password"
                            aria-describedby="passwordHelp">
                    </div>
                    <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2">Login</button>
                </form>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../include/footer.jsp" />