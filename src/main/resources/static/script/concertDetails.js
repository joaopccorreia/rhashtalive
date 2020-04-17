window.onload = function () {

    var request = new XMLHttpRequest();

    request.open('GET', 'http://localhost:8080/concert', true);

    request.onload = function () {
        if(request.status === 200){
            var customerData = JSON.parse(request.responseText);
            addDescription(customerData);
            addDate(customerData);
            addDurationTime(customerData);

        }

    };

    function addDescription(customerData) {

        var descriptionElement = document.getElementsByClassName('card-description');

        var description = Object.keys(customerData).map(function (description) {
            return customerData[description];

        });

       descriptionElement.append(description);
    }

    function addDate(customerData) {

        var dateElement = document.getElementsByName("li").item(0);

        var dateTime = Object.keys(customerData).map(function (date) {
            return customerData[date];

        });

        dateElement.append(dateTime);

    }

    function addDurationTime(customerData) {

        var durationElement = document.getElementsByName("li").item(1);

        var date = Object.keys(customerData).map(function (durationTime) {
            return customerData[durationTime];

        });

        durationElement.append(date);
    }

    request.setRequestHeader('Content-type', 'application/json');
    request.send();


};