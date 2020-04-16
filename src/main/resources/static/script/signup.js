$(document).ready(function() {

    var userName = $("#userName");
    var firstName = $("#firstName");
    var lastName = $("#lastName");
    var vatNumber = $("#vatNumber");
    var email = $("#email");
    var password = $("#password");
    var confirmPassword = $("#confirmPassword");
    var phone = $("#phone");

    var letters = /^[A-Za-z]+$/;
    var numbers = /^[0-9]+$/;
    var mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var alphaNum = /^[0-9a-zA-Z]+$/;

    function validate() {
        if (userName.match(letters)) {
            return true;
        } else {
            alert('Enter a valid username');
            return false;
        }
        if (firstName.match(letters)) {
            return true;
        } else {
            alert('Enter a valid first name');
            return false;
        }
        if (lastName.match(letters)) {
            return true;
        } else {
            alert('Enter a valid last name');
            return false;
        }
        if (vatNumber.match(numbers)) {
            return true;
        } else {
            alert('Use numeric characters only!');
            return false;
        }
        if (email.match(mailFormat)) {
            return true;
        } else {
            alert('Introduce a valid email!');
            return false;
        }
        if (password.match(alphaNum)) {
            return true;
        } else {
            alert('Use alphanumeric characters only!');
            return false;
        }
        if (confirmPassword.match(alphaNum)) {
            return true;
        } else {
            alert('Use alphanumeric characters only!');
            return false;
        }
        if (password === confirmPassword) {
            return true;
        } else {
            alert('Passwords don\'t match');
            return false;
        }
        if (phone.match(numbers)) {
            return true;
        } else {
            alert('Must use numeric characters only!');
            return false;
        }
    }

    function sendData () {

        var data = new FormData();
        data.append('firstName', document.getElementById('firstName').value);
        data.append('lastName', document.getElementById('lastName').value);
        data.append('vatNumber', document.getElementById('vatNumber').value);
        data.append('email', document.getElementById('email').value);
        data.append('password', document.getElementById('password').value);
        data.append('phone', document.getElementById('phone').value);

        var req = new XMLHttpRequest();
        req.open('POST', 'https://localhost:8080/rHastalive/api/customer', true);
        req.onreadystatechange = function () {
            if (req.readyState === 4 && req.status === 200) {
                var resp = JSON.parse(req.responseText);
                if (resp.status) {
                    window.location = "login.html"
                } else {
                    alert(resp.message);
                }
            } else {
                alert("Server Error!");
            }
        };
        req.send(data);
        return false;
    };



});