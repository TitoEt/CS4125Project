var btnLogin = document.getElementById('do-login');
var idLogin = document.getElementById('login');
var email = document.getElementById('email');
btnLogin.onclick = function () {
    idLogin.innerHTML = '<p>Welcome Back! </p><h1>' + email.value + '</h1>';
}