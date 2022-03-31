// IMAGE
const image_input = document.getElementById("productPhoto");
var uploaded_image ="";

let invalidElements = new Set();
invalidElements.add(document.getElementById("name"))
    .add(document.getElementById("description"))

image_input.addEventListener("change", function (){
    console.log(image_input.value);
    const reader = new FileReader();
    reader.addEventListener("load", ()=>{
        uploaded_image = reader.result;
        document.getElementById("imageOfProduct").src = `${uploaded_image}`;
    });
    reader.readAsDataURL(this.files[0]);
})

 function dismissSuccessDiv(){
    document.getElementById("successDiv").classList.add("hidden");
  }

 function dismissFailsDiv(){
     document.getElementById("failDiv").classList.add("hidden")
 }


 // VALIDATION


const name = document.getElementById('name');
name.addEventListener('blur',(e)=>{
    console.log((name.value.length))
    if(((name.value.length) < 3) ||((name.value.length)>200)){
        document.getElementById("nameValidation").classList.remove("hidden")
    }else{
        invalidElements.delete(name);
        document.getElementById("nameValidation").classList.add("hidden")
    }
})
const description = document.getElementById("description")
description.addEventListener("blur",(e)=>{
    if(description.value.length===0 ||description.value.length>1000){
        document.getElementById("descriptionValidation").classList.remove("hidden")
    }else{
        invalidElements.delete(description);
        document.getElementById("descriptionValidation").classList.add("hidden")
    }
})

 const quantity = document.getElementById("quantity")
 quantity.addEventListener('blur', (e) => {
     if (quantity.value <= 0) {
         quantity.value = 1;
     }
 });

 const price = document.getElementById("price")
 price.addEventListener('blur', (e) => {
     if (price.value <= 0) {
         price.value = 1;
     }
 });

 //SPINNER
const submitButton = document.getElementById("submitButton");
const spinner = document.getElementById("spinner");
const cancelButton = document.getElementById("cancelButton")
submitButton.addEventListener("click", (e) => {
    console.log(invalidElements.size)
    if (invalidElements.size !== 0) {
        return;
    }
    document.getElementById("productAddForm").submit();
    submitButton.classList.add('hidden');
    cancelButton.classList.add('hidden')
    spinner.classList.remove('hidden');
})