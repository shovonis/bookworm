/**
 * Created by rifatul.islam on 8/7/14.
 */


function onExchangeBookClick(id) {
    alert(id);
    var newRowElement = '<tr>' + '<td><input type="text" th:field="${exchangeBook.bookTitle}"/></td>' +
        '<td><input type="text" th:field="${exchangeBook.bookAuthor}"/></td>' + '</tr>';
    $("#exchangeBookListTable  tr:last").after(newRowElement);


}

function onclickOfNext(id) {
    $('#demo_stepper_methods').stepper('next');
    var stepValue = document.getElementById("stepper_value").value;
    stepValue = parseInt(stepValue);
    if (stepValue < 3) {
        stepValue = stepValue + 1;
    }
    document.getElementById("stepper_value").value = stepValue;
    processQualityDescription(stepValue);
}

function onclickOfPrior(id) {
    $('#demo_stepper_methods').stepper('prior');
    var stepValue = document.getElementById("stepper_value").value;
    stepValue = parseInt(stepValue);
    if (stepValue > 0) {
        stepValue = stepValue - 1;
    }
    document.getElementById("stepper_value").value = stepValue;
    processQualityDescription(stepValue);
}

function processQualityDescription(stepValue) {
    var qualityDiv = document.getElementById("quality_description").innerHTML;
    switch (stepValue) {
        case 0:
            qualityDiv = "Readable";
            break;
        case 1:
            qualityDiv = "Good";
            break;
        case 2:
            qualityDiv = "Very Good";
            break;
        case 3:
            qualityDiv = "New";
            break;
        default :
            qualityDiv = "Readable";
            break;
    }
    document.getElementById("quality_description").innerHTML = qualityDiv;
}

