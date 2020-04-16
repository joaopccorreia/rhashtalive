window.onload = function () {

    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('lastName').value;
    var vatNumber = document.getElementById('vatNumber').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;
    var phone = document.getElementById('phone').value;

    function validate() {
        if (firstName === "") {
        alert('Please enter your first name.');
        return false;
        }
        var letters = /^[A-Za-z]+$/;
        if (firstName.match(letters)) {
            return true;
        } else {
            alert('Must use alphabet characters only!');
            return false;
        }
        if (lastName === "") {
            alert('Please enter your last name.');
            return false;
        }
        if (lastName.match(letters)) {
            return true;
        } else {
            alert('Must use alphabet characters only!');
            return false;
        }
        if (vatNumber === "") {
            alert('Please enter your VAT number.');
            return false;
        }
        var numbers = /^[0-9]+$/;
        if (vatNumber.match(numbers)) {
            return true;
        } else {
            alert('Must use numeric characters only!');
            return false;
        }
        if (email === "") {
            alert('Please enter your email.');
            return false;
        }
        var mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        if (email.match(mailFormat)) {
            return true;
        } else {
            alert('Must introduce a valid email!');
            return false;
        }
        if (password === "") {
            alert('Please enter your password.');
            return false;
        }
        var alphaNum = /^[0-9a-zA-Z]+$/;
        if (password.match(alphaNum)) {
            return true;
        } else {
            alert('Must use alphanumeric characters only!');
            return false;
        }
        if (confirmPassword === "") {
            alert('Please confirm your password.');
            return false;
        }
        if (confirmPassword.match(alphaNum)) {
            return true;
        } else {
            alert('Must use alphanumeric characters only!');
            return false;
        }
        if (password === confirmPassword) {
            return true;
        } else {
            alert('Passwords don\'t match');
            return false;
        }
        if (phone === "") {
            alert('Please enter your phone number.');
            return false;
        }
        if (phone.match(numbers)) {
            return true;
        } else {
            alert('Must use numeric characters only!');
            return false;
        }
    }

    var btnUser = document.getElementById('user_button');
    btnUser.addEventListener("click", validate, false);

    var btnArtist = document.getElementById('artist_button');
    btnArtist.addEventListener("click", validate, false);

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
};