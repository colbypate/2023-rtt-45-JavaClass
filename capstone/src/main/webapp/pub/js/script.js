// function formSubmit(event) {
//   let formInput = document.getElementById("form");
//   let formValue = formInput.value;
//   console.log(formValue);

//   if (emailValue == "") {
//     alert("Email is required");
//     //add the bootstrap class "is invalid" to show an error
//     emailInput.classList.add("is-invalid");
//     //this will set the value of the email input field to whatever text
//     emailInput.value = "Enter Your Email";
//     // now we can add an individual style to the input field
//     emailInput.style.color = "red";

//     //here we can change the css in the style tage to be what we want
//     emailInput.style.cssText = "color:red";
//   }
// }

// function changeImage() {
//   var img1 = document.getElementById("photo1");
//   var img2 =
//     "https://images.unsplash.com/photo-1589244159943-460088ed5c92?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1190&q=80";
//   img1.src = img2;
// }

// let c1 = { name: "JetFresh", location: "Ontario, Canada", orders: 74 };
// let c2 = { name: "Flowers101", location: "Guatemala", orders: 38 };
// let c3 = { name: "CaliFlowers", location: "Fresno, California", orders: 12 };
// let c4 = { name: "FlowerWorld", location: "Nicaragua", orders: 55 };
// let c5 = { name: "Blooms", location: "Brazil", orders: 26 };

// let vendors = [c1, c2, c3, c4, c5];

// let vendorShown = false;

// function displayVendors() {
//   if (!vendorShown) {
//     vendorShown = true;
//     let tableLocation = document.getElementById("vendor-table");
//     var tableInfo =
//       "<tr><th>Company Name</th><th>Location</th><th>Times Ordered from this year</th></tr>";

//     // for loop
//     for (let v of vendors) {
//       tableInfo += "<tr>";
//       tableInfo += "<td>" + v.name + "</td>";
//       tableInfo += "<td>" + v.location + "</td>";
//       tableInfo += "<td>" + v.orders + "</td>";
//       tableInfo += "</tr>";
//     }
//     tableLocation.innerHTML = tableInfo;
//   }
// }

// function dontShow() {
//   document.getElementById("chooseVendor").style.display = "none";
// }
// function show() {
//   document.getElementById("chooseVendor").style.display = "block";
// }
