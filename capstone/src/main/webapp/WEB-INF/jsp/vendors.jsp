<jsp: include page="include/header.jsp" />

<body onload="displayVendors()">

    <table id="vendor-table" style="width:100vh; background-color: azure;" align="center">

    </table>

    <div class="container py-5 text-center justify-content-center">
        <p>Would you like to place an order with a vendor?</p>
        <input type="radio" id="yes" name="response" value="Yes" onclick="show();" />
        <label for="yes">Yes</label><br>
        <input type="radio" id="no" name="response" value="No" onclick="dontShow();" />
        <label for="no">No</label><br>
    </div>
    <div class="hide container py-2 text-center justify-content-center" id="chooseVendor">
        <form>
            <p>Who would you like to place an order with?</p>
            <div>
                <input type="checkbox" name="JetFresh" id="JetFresh" />
                <label for="JetFresh">JetFresh</label>
            </div>
            <div>
                <input type="checkbox" name="Flowers101" id="Flowers101" value="Flowers101" />
                <label for="Flowers101">Flowers101</label>
            </div>
            <div>
                <input type="checkbox" name="CaliFlowers" id="CaliFlowers" value="CaliFlowers" />
                <label for="CaliFlowers">CaliFlowers</label>
            </div>
            <div>
                <input type="checkbox" name="FlowerWorld" id="FlowerWorld" value="FlowerWorld" />
                <label for="FlowerWorld">FlowerWorld</label>
            </div>
            <div>
                <input type="checkbox" name="Blooms" id="Blooms" value="Blooms" />
                <label for="Blooms">Blooms</label>
            </div>
            <div>
                <input type="submit" name="submit" value="Submit" />
            </div>
        </form>
    </div>
</body>
