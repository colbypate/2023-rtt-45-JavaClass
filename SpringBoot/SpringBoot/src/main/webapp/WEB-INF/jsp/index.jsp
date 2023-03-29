<jsp:include page="include/header.jsp" />


<script>
    function onClickFunction(){
        console.log("on click clicked");
        let name = document.getElementById("name");
        console.log(name.value);

        const re = new RegExp("[a-zA-Z]+");
        const found =name.value.match(re);
        if(found){
            console.log("name matches the regex");
        }else{
            console.log("sdcdsc");
        }

    }
</script>

<section class="pt-5 pb-5" style="background-color: blanchedalmond;">
    <div class="container">
    <form>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">* Email address</label>
            <input type="text" placeholder="Email address" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Full Name</label>
            <input type="text" class="form-control" id="name" aria-describedby="nameHelp">
            <div id="nameHelp" class="form-text">Let us know who you are</div>
        </div>
        <button type="button" class="btn btn-primary" onclick="onClickFunction()">Submit</button>
    </form>
    </div>
</section>

    <section class="container pt-5 pb-5" style="background-color: bisque">
        <div class="container">

            <h1 class="pb-2" style="text-align: center;">We need to decide what kind of cat we want...</h1>

            <p id="paragraph"><a href="https://cats.com/cat-breeds/sphynx" target="new">Click here for info on all of
                    the
                    cats
                    that will be mentioned</a></p>
            <img height="200px" src="https://cats.com/wp-content/uploads/2020/10/Cheetoh-Cat-compressed-768x384.jpg" />


            <table border="2">
                <tr>
                    <td>Cat Breed</td>
                    <td>Pros</td>
                    <td>Cons</td>
                </tr>
                <tr>
                    <td>Cheetoh</td>
                    <td>Playful, Long life span </td>
                    <td>Price $500 - $3000</td>
                </tr>
            </table>

            <ul>
                <li>List item1 </li>
                <li>List item2 </li>
                <li>List item2 </li>

            </ul>
        </div>
    </section>
    <section class="container pt-5 pb-5" style="background-color: blanchedalmond;">
    <div class="container">
        <h2 style="text-align: center;">This is the second section</h2>
    </div>

    </section>

<jsp:include page="include/footer.jsp" />