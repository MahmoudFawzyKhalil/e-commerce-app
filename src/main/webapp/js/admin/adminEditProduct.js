const image_input = document.getElementById("productPhotoEdit");
var uploaded_image ="";

let invalidElements = new Set();
invalidElements.add(document.getElementById("nameEdit"))
    .add(document.getElementById("descriptionEdit"))


document.getElementById("categoryEdit").value = document.getElementById("valueOfCategory").value

image_input.addEventListener("change", function (){
    console.log(image_input.value);
    const reader = new FileReader();
    reader.addEventListener("load", ()=>{
        uploaded_image = reader.result;
        document.getElementById("imageOfProductEdit").src = `${uploaded_image}`;
    });
    reader.readAsDataURL(this.files[0]);
})

function dismissSuccessDivEdit(){
    document.getElementById("successDivEdit").classList.add("hidden");
}

function dismissFailsDivEdit(){
    document.getElementById("failDivEdit").classList.add("hidden")
}

const name = document.getElementById('nameEdit');
name.addEventListener('blur',(e)=>{
    console.log((name.value.length))
    if(((name.value.length) < 3) ||((name.value.length)>200)){
        console.log("leeeeh")
        document.getElementById("nameValidationEdit").classList.remove("hidden")
        document.getElementById("submitButtonEdit").classList.add("disabled")
    }else{
        invalidElements.delete(name);
        document.getElementById("nameValidationEdit").classList.add("hidden")
        document.getElementById("submitButtonEdit").classList.remove("disabled")

    }
})
const description = document.getElementById("descriptionEdit")
description.addEventListener("blur",(e)=>{
    if(description.value.length<3 ||description.value.length>1000){
        document.getElementById("descriptionValidationEdit").classList.remove("hidden")
        document.getElementById("submitButtonEdit").classList.add("disabled")

    }else{
        invalidElements.delete(description);
        document.getElementById("descriptionValidationEdit").classList.add("hidden")
        document.getElementById("submitButtonEditEdit").classList.remove("disabled")

    }
})
//
const quantity = document.getElementById("quantityEdit")
quantity.addEventListener('blur', (e) => {
    if (quantity.value <= 0) {
        quantity.value = 1;
    }
});
//
const price = document.getElementById("priceEdit")
price.addEventListener('blur', (e) => {
    if (price.value <= 0) {
        price.value = 1;
    }
});
//
const submitButton = document.getElementById("submitButton");
const spinner = document.getElementById("spinner");
const cancelButton = document.getElementById("cancelButton")
submitButton.addEventListener("click", (e) => {
    console.log(invalidElements.size)
    if (invalidElements.size !== 0) {
        return;
    }
    document.getElementById("productEditForm").submit();
    submitButton.classList.add('hidden');
    cancelButton.classList.add('hidden')
    spinner.classList.remove('hidden');
})