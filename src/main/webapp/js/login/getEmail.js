const emailSendButton = document.getElementById("emailSendButton");
const emailSendSpinner = document.getElementById("emailSendSpinner");
const getEmailForm = document.getElementById("getEmailForm")


getEmailForm.addEventListener('submit', e => {
    console.log("submit form.........");
    emailSendButton.classList.add('hidden');
    emailSendSpinner.classList.remove('hidden');
})