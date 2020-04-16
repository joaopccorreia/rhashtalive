window.onload = function () {

    var req = new XMLHttpRequest();
    req.open('GET', 'https://localhost:8080/rHastalive/api/customer', true);

    req.onreadystatechange = function () {
        var data = JSON.parse(req.responseText);
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;

        if (req.readyState === 4 && req.status === 200) {
            data.forEach(element => {
                if (email === Object.keys(element) && password === Object.keys(element)) {
                    alert("Login successfully");
                    window.location = "homepage.html";
                    return false;
                } else {
                    alert("Wrong email or password");
                }
            });
        } else {
            alert("Server Error");
        }
        req.setRequestHeader('Content-type', 'application/json');
        req.send();
    }
};
