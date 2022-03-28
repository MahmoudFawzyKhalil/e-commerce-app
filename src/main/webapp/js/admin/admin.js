 // Handle profile menu
// const profileDropDown = document.getElementById("profileDropDown");
// const toggleProfileButton = document.getElementById("toggleProfileButton");
// toggleProfileButton.addEventListener('click', (e) => {
//         profileDropDown.classList.toggle('hidden')
// });
//
// document.body.addEventListener('click', (e) => {
//     if (e.target.parentElement.id == "toggleProfileButton"){
//         return;
//     }
//
//     if (!profileDropDown.classList.contains('hidden')){
//         profileDropDown.classList.add('hidden');
//     }
// })

// Handle mobile menu
// const mobileMenuToggleButton = document.getElementById("mobileMenuToggleButton");
// const mobileMenu = document.getElementById("mobileMenu");
// mobileMenuToggleButton.addEventListener('click', (e) => {
//     mobileMenu.classList.toggle('hidden');
// });


// Handle image of product
// document.getElementById("imageOfProduct").src="D:/ITI/e-commerce-app/src/main/webapp/img/admin/product.png";
// const productImageButton = document.getElementById("uploadImageButton");
// productImage.src="D:/ITI/e-commerce-app/src/main/webapp/img/admin/product.png"


const image_input = document.getElementById("productPhoto");
var uploaded_image ="";


image_input.addEventListener("change", function (){
    console.log(image_input.value);
    const reader = new FileReader();
    reader.addEventListener("load", ()=>{
        uploaded_image = reader.result;
        document.getElementById("imageOfProduct").src = `${uploaded_image}`;
    });
    reader.readAsDataURL(this.files[0]);
})

 //document.getElementById("failDismiss").onclick = dismissFailsDiv;

 //document.getElementById("successDismiss").onclick = dismissSuccessDiv;

 function dismissSuccessDiv(){
    document.getElementById("successDiv").classList.add("hidden");
    333333
  }

 function dismissFailsDiv(){
     document.getElementById("failDiv").classList.add("hidden")
 }


