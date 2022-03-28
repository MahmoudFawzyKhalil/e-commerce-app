
// Handle profile menu
const profileDropDown = document.getElementById("profileDropDown");
const toggleProfileButton = document.getElementById("toggleProfileButton");
toggleProfileButton.addEventListener('click', (e) => {
        profileDropDown.classList.toggle('hidden')
});

document.body.addEventListener('click', (e) => {
    if (e.target.parentElement.id == "toggleProfileButton"){
        return;
    }

    if (!profileDropDown.classList.contains('hidden')){
        profileDropDown.classList.add('hidden');
    }
})

// Handle mobile menu
const mobileMenuToggleButton = document.getElementById("mobileMenuToggleButton");
const mobileMenu = document.getElementById("mobileMenu");
mobileMenuToggleButton.addEventListener('click', (e) => {
    mobileMenu.classList.toggle('hidden');
});


// Handle image of product
document.getElementById("imageOfProduct").src="D:/ITI/e-commerce-app/src/main/webapp/img/admin/product.png";
const productImageButton = document.getElementById("uploadImageButton");
// productImage.src="D:/ITI/e-commerce-app/src/main/webapp/img/admin/product.png"




