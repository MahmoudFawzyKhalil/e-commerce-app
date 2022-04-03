let imageInput = document.getElementById("productPhoto");
let uploaded_image = "";
let invalidElements = new Set();
let submitButton = document.getElementById("submitButton")
let cancelButton = document.getElementById("cancelButton")
let name = document.getElementById("name")
let description = document.getElementById("description")
let category = document.getElementById("category")
let image = document.getElementById("imageOfProduct")
let failDiv = document.getElementById("failDiv")
let successDiv = document.getElementById("successDiv")
let nameValidation = document.getElementById("nameValidation")
let quantity = document.getElementById("quantity")
let price = document.getElementById("price")
let descriptionValidation = document.getElementById("descriptionValidation")
let spinner = document.getElementById("spinner");
let changeflag = false

invalidElements.add(name).add(description)
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

function dismissSuccessDiv() {
    successDiv.classList.add("hidden");
}

function dismissFailsDiv() {
    failDiv.classList.add("hidden")
}

name.addEventListener("change", ev => {
    changeflag = true
    validation(changeflag)

})
description.addEventListener("change", ev => {
    changeflag = true
    validation(changeflag)

})
quantity.addEventListener("change", ev => {
    changeflag = true
    validation(changeflag)

})
price.addEventListener("change", ev => {
    changeflag = true
    validation(changeflag)

})
category.addEventListener("change", ev => {
    changeflag = true
    validation(changeflag)

})


// VALIDATION

name.addEventListener('blur', (e) => {
    if (((name.value.length) < 3) || ((name.value.length) > 200)) {
        nameValidation.classList.remove("hidden")
        if (!invalidElements.has(name)) {
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
    if (description.value.length === 0 || description.value.length > 1000) {
        descriptionValidation.classList.remove("hidden")
        if (!invalidElements.has(description)) {
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

//SPINNER

submitButton.addEventListener("click", (e) => {
    if (invalidElements.size !== 0) {
        return;
    }
    document.getElementById("productAddForm").submit();
    submitButton.classList.add('hidden');
    cancelButton.classList.add('hidden')
    spinner.classList.remove('hidden');
})

//VALIDATED

function validation(change) {

    console.log(invalidElements.size)
    if (invalidElements.size > 0) {
        console.log("in if")
        submitButton.classList.add("hidden")
    } else {
        console.log("in else")
        if (change) {
            console.log("in sec if")
            submitButton.classList.remove("hidden")
        } else {
            console.log("in sec else    ")
            submitButton.classList.add("hidden")
        }
    }

}