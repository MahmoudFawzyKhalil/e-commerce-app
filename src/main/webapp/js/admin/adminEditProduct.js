let imageInput = document.getElementById("productPhotoEdit");
let uploaded_image = "";
let invalidElements = new Set();
let submitButtonEdit = document.getElementById("submitButtonEdit")
let cancelButtonEdit = document.getElementById("cancelButtonEdit")
let name = document.getElementById("nameEdit")
let description = document.getElementById("descriptionEdit")
let category = document.getElementById("categoryEdit")
let categoryValue = document.getElementById("valueOfCategory")
let image = document.getElementById("imageOfProductEdit")
let failDiv = document.getElementById("failDivEdit")
let nameValidation = document.getElementById("nameValidationEdit")
let quantity = document.getElementById("quantityEdit")
let price = document.getElementById("priceEdit")
let descriptionValidation = document.getElementById("descriptionValidationEdit")
let spinner = document.getElementById("spinner");
const descriptionValue = description.value.length
const nameValue = name.value.length
let changeflag = false

category.value = categoryValue.value


validation(false)

imageInput.addEventListener("change", function () {
    const reader = new FileReader();
    reader.addEventListener("load", () => {
        uploaded_image = reader.result;
        image.src = `${uploaded_image}`;
        changeflag = true;
        validation(changeflag);
    });
    reader.readAsDataURL(this.files[0]);
})

function dismissFailsDivEdit() {
    failDiv.classList.add("hidden")
}

name.addEventListener("change",ev => {
    changeflag = true
    validation(changeflag)
})
description.addEventListener("change",ev => {
    changeflag = true
    validation(changeflag)
})
quantity.addEventListener("change",ev => {
    console.log("quantityEvent")
    changeflag = true
    validation(changeflag)
})
price.addEventListener("change",ev => {
    console.log("priceEvent")
    changeflag = true
    validation(changeflag)
})
category.addEventListener("change",ev => {
    console.log("CategoryEvent")
    changeflag = true
    validation(changeflag)
})

name.addEventListener('blur', (e) => {

    if (((name.value.length) < 3) || ((name.value.length) > 200)) {
        nameValidation.classList.remove("hidden")
        if(!invalidElements.has(name)){
            invalidElements.add(name)
        }
        validation(false)
    } else {
        invalidElements.delete(name);
        nameValidation.classList.add("hidden")
        validation(changeflag)
    }
})
description.addEventListener("blur", (e) => {

    if (description.value.length < 3 || description.value.length > 1000) {
        descriptionValidation.classList.remove("hidden")
        if(!invalidElements.has(description)){
            invalidElements.add(description)
        }
        validation(false)
    } else {
        invalidElements.delete(description);
        descriptionValidation.classList.add("hidden")
        validation(changeflag)
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

function validation(change) {

    console.log(invalidElements.size)
    if(invalidElements.size > 0){
        console.log("in if")
        submitButtonEdit.classList.add("hidden")
    }
    else{
        console.log("in else")
        if(change){
            console.log("in sec if")
            submitButtonEdit.classList.remove("hidden")
        }else {
            console.log("in sec else    ")
            submitButtonEdit.classList.add("hidden")
        }
    }

}
