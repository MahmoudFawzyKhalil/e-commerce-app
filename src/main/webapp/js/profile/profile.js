const nameRegex = /^[a-z ,.'-]+$/i;
const streetRegex = /^[a-z ,.'0-9-]+$/i;
const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const phoneRegex = /^(01)[1250][0-9]{8}$/;
const passwordRegex = /.{8,50}/;

let setOfInvalidElements = new Set();
let buttonDisabled = true;

/* ELEMENT VALIDATION */

const phoneNumber = document.getElementById("phoneNumber");
const phoneNumberValidation = document.getElementById("phoneNumberValidation");
attachValidation(phoneNumber, (e) => {
    validateWithRegex(phoneRegex, phoneNumber, phoneNumberValidation)
});

const job = document.getElementById("job");
const jobValidation = document.getElementById("jobValidation");
attachValidation(job, (e) => {
    validateWithRegex(nameRegex, job, jobValidation);
});

const creditLimit = document.getElementById("creditLimit");
const creditLimitValidation = document.getElementById("creditLimitValidation");
attachValidation(creditLimit, (e) => {
    if (+creditLimit.value < 100) {
        creditLimit.value = 100;
    }
});

const streetAddress = document.getElementById("streetAddress");
const streetAddressValidation = document.getElementById("streetAddressValidation");
attachValidation(streetAddress, (e) => {
    validateWithRegex(streetRegex, streetAddress, streetAddressValidation);
});


const city = document.getElementById("city");
const cityValidation = document.getElementById("cityValidation");
attachValidation(city, (e) => {
    validateWithRegex(nameRegex, city, cityValidation);
});

/* FORM VALIDATION */
const updateProfileForm = document.getElementById("updateProfileForm");

const submitButton = document.getElementById("submitButton");

const spinner = document.getElementById("spinner");
submitButton.addEventListener("click", (e) => {
    if (setOfInvalidElements.size !== 0) {
        return;
    }

    updateProfileForm.submit();
    submitButton.classList.add('hidden');
    spinner.classList.remove('hidden');
})


/* VALIDATION FUNCTIONS */

function attachValidation(elementToValidate, validationCallback) {
    elementToValidate.addEventListener('blur', (e) => {
        validationCallback(e);
    })
}

function removeHidden(elementValidation) {
    elementValidation.classList.remove('hidden');
}

function addHiddenIfDoesntExist(elementValidation) {
    if (!elementValidation.classList.contains('hidden')) {
        elementValidation.classList.add('hidden');
    }
}

function validateWithRegex(regex, element, elementValidation) {
    if (regex.test(element.value)) {
        addHiddenIfDoesntExist(elementValidation);
        setOfInvalidElements.delete(element);
    } else {
        removeHidden(elementValidation);
        setOfInvalidElements.add(element);
    }
}
