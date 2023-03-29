<jsp:include page="include/header.jsp"/>

<style>
    .page-header {
        margin-left: 100px;
        margin-top: 30px;
        color: chartreuse;

    }

    h1 {
        border: 1px solid;
    }

    a:visited {
        color: purple;
    }

    a:hover {
        color: orange;
    }

    .absolute-example{
        width: 200px;
        height: 400px;
        background-color: aqua;
        position: absolute;
    }
</style>

<h1 class="page-header">Header</h1>
    <h1 class="page-header" style="background-color: grey;">Another header</h1>


    <br>
    <p><a href="/bootstrap.html">This is a link</a></p>
    <div class="container" style="margin-top:30px">
        <table class="table table-striped table-hover table-bordered">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                </tr>
            </tbody>
        </table>
        <button type="button" class="btn btn-primary btn-sm">Save</button>
        <button type="button" class="btn btn-secondary btn-sm">Cancel</button>
    </div>

    <jsp:include page="include/footer.jsp"/>