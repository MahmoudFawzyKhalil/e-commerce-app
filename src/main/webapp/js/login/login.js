const loginForm = document.getElementById("loginForm");
const email = document.getElementById("emailAddress");
const password = document.getElementById("password");

let submitButton = document.getElementById("loginSubmitButton");
let spinner = document.getElementById("loginSpinner");

submitButton.addEventListener('click', (e) => {
    console.log("in submit event listener")
    loginForm.submit();
    submitButton.classList.add('hidden');
    spinner.classList.remove('hidden');
})


