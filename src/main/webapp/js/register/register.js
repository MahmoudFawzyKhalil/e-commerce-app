const nameRegex = /^[a-z ,.'-]+$/i;
const streetRegex = /^[a-z ,.'0-9-]+$/i;
const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const phoneRegex = /^(01)[1250][0-9]{8}$/;
const passwordRegex = /.{8,50}/;

let setOfInvalidElements = new Set();
let buttonDisabled = true;

/* ELEMENT VALIDATION */


const firstName = document.getElementById("firstName");
const firstNameValidation = document.getElementById("firstNameValidation");
attachValidation(firstName, (e) => {
    validateWithRegex(nameRegex, firstName, firstNameValidation)
});

const lastName = document.getElementById("lastName");
const lastNameValidation = document.getElementById("lastNameValidation");
attachValidation(lastName, (e) => {
    validateWithRegex(nameRegex, lastName, lastNameValidation)
});

const emailAddress = document.getElementById("email");
const emailAddressValidation = document.getElementById("emailValidation");
attachValidation(emailAddress, (e) => {
    validateWithRegex(emailRegex, emailAddress, emailAddressValidation)
});

const phoneNumber = document.getElementById("phoneNumber");
const phoneNumberValidation = document.getElementById("phoneNumberValidation");
attachValidation(phoneNumber, (e) => {
    validateWithRegex(phoneRegex, phoneNumber, phoneNumberValidation)
});

const password = document.getElementById("password");
const passwordValidation = document.getElementById("passwordValidation");

const passwordConfirmation = document.getElementById("passwordConfirmation");
const passwordConfirmationValidation = document.getElementById("passwordConfirmationValidation");
attachValidation(password, (e) => {
    validateWithRegex(passwordRegex, password, passwordValidation);
    passwordValidation.textContent = "Password must be at least 8 characters long."

    if (password.value !== passwordConfirmation.value) {
        passwordValidation.textContent = "Passwords don't match."

        removeHidden(passwordConfirmationValidation);
        removeHidden(passwordValidation);
        setOfInvalidElements.add(password);
    } else if (password.value !== "") {
        addHiddenIfDoesntExist(passwordConfirmationValidation);
        addHiddenIfDoesntExist(passwordValidation);
        setOfInvalidElements.delete(password);
    }
});

attachValidation(passwordConfirmation, (e) => {
    if (password.value !== passwordConfirmation.value) {
        removeHidden(passwordConfirmationValidation);
        setOfInvalidElements.add(password);
    } else {
        addHiddenIfDoesntExist(passwordConfirmationValidation);
        addHiddenIfDoesntExist(passwordValidation);
        setOfInvalidElements.delete(password);
    }
});


const birthdate = document.getElementById("birthdate");
const birthdateValidation = document.getElementById("birthdateValidation");
attachValidation(birthdate, (e) => {
    if (birthdate.value === "") {
        removeHidden(birthdateValidation);
        setOfInvalidElements.add(birthdate);
    } else {
        addHiddenIfDoesntExist(birthdateValidation);
        setOfInvalidElements.delete(birthdate);
    }
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

/* INITIALIZE INVALID ELEMENTS SET */

setOfInvalidElements.add(firstName)
    .add(lastName)
    .add(emailAddress)
    .add(phoneNumber)
    .add(password)
    .add(birthdate)
    .add(job)
    .add(streetAddress)
    .add(city);

/* FORM VALIDATION */
const registrationForm = document.getElementById("registrationForm");

const submitButton = document.getElementById("submitButton");
const spinner = document.getElementById("spinner");
submitButton.addEventListener("click", (e) => {
    if (setOfInvalidElements.size !== 0) {
        return;
    }
    
    registrationForm.submit();
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
