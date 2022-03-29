// IMAGE
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

 function dismissSuccessDiv(){
    document.getElementById("successDiv").classList.add("hidden");
  }

 function dismissFailsDiv(){
     document.getElementById("failDiv").classList.add("hidden")
 }


 // VALIDATION

document.getElementById("name").addEventListener("blur",(e)=>{
    document.getElementById("name").l
})

