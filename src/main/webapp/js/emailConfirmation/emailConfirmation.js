const emailConfirmationForm = document.getElementById("emailConfirmationForm");
const emailConfirmationSpinner = document.getElementById("emailConfirmationSpinner");
const emailConfirmationButton = document.getElementById("emailConfirmationButton")

emailConfirmationForm.addEventListener("submit", (e) => {
    emailConfirmationButton.classList.add("hidden");
    emailConfirmationSpinner.classList.remove("hidden");
})