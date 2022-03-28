const loginForm = document.getElementById("loginForm");
const email = document.getElementById("emailAddress");
const password = document.getElementById("password");


loginForm.addEventListener('submit', (e) => {
    if (email.value === "" || password.value === "") {
        e.preventDefault();
        console.log("prevented")
    }
})


