let imageInput = document.getElementById("productPhotoEdit");
let uploaded_image = "";
let invalidElements = new Set();
let changedElements = new Set();
let submitButtonEdit = document.getElementById("submitButtonEdit")
let cancelButtonEdit = document.getElementById("cancelButtonEdit")
let name = document.getElementById("nameEdit")
let description = document.getElementById("descriptionEdit")
let category = document.getElementById("categoryEdit")
let categoryValueFromInputField = document.getElementById("valueOfCategory")
let image = document.getElementById("imageOfProductEdit")
let failDiv = document.getElementById("failDivEdit")
let nameValidation = document.getElementById("nameValidationEdit")
let quantity = document.getElementById("quantityEdit")
let price = document.getElementById("priceEdit")
let descriptionValidation = document.getElementById("descriptionValidationEdit")
let spinner = document.getElementById("spinner");
const descriptionValue = description.value
const nameValue = name.value
const priceValue = price.value
const quantityValue = quantity.value
const categoryValue = categoryValueFromInputField.value


category.value = categoryValue


validation()

imageInput.addEventListener("change", function () {
    const reader = new FileReader();
    reader.addEventListener("load", () => {
        uploaded_image = reader.result;
        image.src = `${uploaded_image}`;
        changedElements.add(image)
        validation();
    });
    reader.readAsDataURL(this.files[0]);
})

function dismissFailsDivEdit() {
    failDiv.classList.add("hidden")
}

name.addEventListener("change",ev => {
    if(name.value !== nameValue){
        changedElements.add(name)
        validation()
    }else {
        changedElements.delete(name)
        validation()
    }
})
description.addEventListener("change",ev => {
    if(description.value !== descriptionValue){
        changedElements.add(description)
        validation()
    }
    else {
        changedElements.delete(description)
        validation()

    }
})
quantity.addEventListener("change",ev => {
    if(quantity.value !== quantityValue){
        changedElements.add(quantity)
        validation()

    }else {
        changedElements.delete(quantity)
        validation()

    }
})
price.addEventListener("change",ev => {
    if(price.value !== priceValue){
        changedElements.add(price)
        validation()

    }else {
        changedElements.delete(price)
        validation()

    }
})
category.addEventListener("change",ev => {
    if(category.value !== categoryValue){
        changedElements.add(category)
        validation()

    }else {
        changedElements.delete(category)
        validation()

    }
})

name.addEventListener('blur', (e) => {

    if (((name.value.length) < 3) || ((name.value.length) > 200)) {
        nameValidation.classList.remove("hidden")
        if(!invalidElements.has(name)){
            invalidElements.add(name)
        }
        validation()
    } else {
        invalidElements.delete(name);
        nameValidation.classList.add("hidden")
        validation()
    }
})
description.addEventListener("blur", (e) => {

    if (description.value.length < 3 || description.value.length > 1000) {
        descriptionValidation.classList.remove("hidden")
        if(!invalidElements.has(description)){
            invalidElements.add(description)
        }
        validation()
    } else {
        invalidElements.delete(description);
        descriptionValidation.classList.add("hidden")
        validation()
    }
})
quantity.addEventListener('blur', (e) => {
    if (quantity.value <= 0) {
        quantity.value = 1;
    }
});


price.addEventListener('blur', (e) => {
    if (price.value <= 0) {
        price.value = 1;
    }
});


submitButtonEdit.addEventListener("click", (e) => {
    if (invalidElements.size !== 0) {
        return;
    }
    document.getElementById("productEditForm").submit();
    submitButtonEdit.classList.add('hidden');
    cancelButtonEdit.classList.add('hidden')
    spinner.classList.remove('hidden');
})

//VALIDATED

function validation() {

    console.log(invalidElements.size)
    if(invalidElements.size > 0){
        console.log("in if")
        submitButtonEdit.classList.add("hidden")
    }
    else{
        console.log("chabge"+changedElements.size)
        if(changedElements.size>0){
            submitButtonEdit.classList.remove("hidden")
        }else {
            submitButtonEdit.classList.add("hidden")
        }
    }

}
