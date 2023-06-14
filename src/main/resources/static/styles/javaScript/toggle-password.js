function togglePasswordVisibility() {
    var passwordInput = document.getElementById("psw");
    var toggleIcon = document.querySelector(".toggle-password");

    if (passwordInput.type === "password") {
        passwordInput.type = "text";
        toggleIcon.innerHTML = "&#128064;"; // Show password icon
    } else {
        passwordInput.type = "password";
        toggleIcon.innerHTML = "&#128065;"; // Hide password icon
    }
}