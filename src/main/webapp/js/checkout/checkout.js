const ccRegex = /^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$/;
const cvcRegex = /^[0-9]{3,4}$/;
const expDateRegex = /^(0[1-9]|1[0-2])\/([0-9]{2})$/;

let setOfInvalidElements = new Set();

/* ELEMENT VALIDATION */

const ccNumber = document.getElementById("ccNumber");
const ccNumberValidation = document.getElementById("ccNumberValidation");
attachValidation(ccNumber, (e) => {
    validateWithRegex(ccRegex, ccNumber, ccNumberValidation);
});

const expDate = document.getElementById("expDate");
const expDateValidation = document.getElementById("expDateValidation");
attachValidation(expDate, (e) => {
    validateWithRegex(expDateRegex, expDate, expDateValidation);
});

const cvc = document.getElementById("cvc");
const cvcValidation = document.getElementById("cvcValidation");
attachValidation(cvc, (e) => {
    validateWithRegex(cvcRegex, cvc, cvcValidation);
});

/* INITIALIZE INVALID ELEMENTS SET */

setOfInvalidElements.add(ccNumber)
    .add(expDate)
    .add(cvc);

/* FORM VALIDATION */
const submitButton = document.getElementById("submitButton");
const spinner = document.getElementById("spinner");

submitButton.addEventListener("click", (e) => {
    if (setOfInvalidElements.size !== 0) {
        e.preventDefault();
        return;
    }
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
    elementValidation.classList.remove('invisible');
}

function addHiddenIfDoesntExist(elementValidation) {
    if (!elementValidation.classList.contains('invisible')) {
        elementValidation.classList.add('invisible');
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