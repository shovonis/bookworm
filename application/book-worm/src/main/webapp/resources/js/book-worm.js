/**
 * Created by rifatul.islam on 8/7/14.
 */

window.onload=function(){
    index = 0;
};

function onExchangeBookClick() {

    var newRowElement = '<tr>' +
        '                <td><input type="text" name = "exchangeBooks['+index+'].title"/> </td>'+
                        '<td><input type="text" name = "exchangeBooks['+index+'].author"/> </td>' +
        '                </tr>';

     $("#exchangeBookListTable  tbody").append(newRowElement);

    index++;

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

function sendAjax() {
    $.ajax({
        url: "/getUser/",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
            alert(data.id + " " + data.name);
        },
        error: function (data, status, er) {
            alert("error: " + data + " status: " + status + " er:" + er);
        }
    });
}
$(function () {
    $("#createFlatWindow").on('click', function () {
        userId = $("#urlValue").val();
        $.ajax({
            url: '/getUser',
            type: 'POST',

            data: {"userId": userId},


            success: function (user) {
                alert(user);
            },
            error: function (data, status, er) {
                alert("error: " + data + " status: " + status + " er:" + er);
            }
        });

        $.Dialog({
            overlay: true,
            shadow: true,
            flat: true,
            draggable: true,
            icon: '<img src="/resources/images/excel2013icon.png"/>',
            title: 'Flat window',
            content: '',
            padding: 10,
            onShow: function (_dialog) {
                var content = '<form class="user-input">' +
                    '<label>Login</label>' +
                    '<div class="input-control text"><input type="text" name="login"/><button class="btn-clear"/></div>' +
                    '<label>Password</label>' +
                    '<div class="input-control password"><input type="password" name="password"/><button class="btn-reveal"></button></div>' +
                    '<div class="input-control checkbox"><label><input type="checkbox" name="c1" /><span class="check"></span>Check me out</label></div>' +
                    '<div class="form-actions">' +
                    '<button class="button primary">Login to...</button>&nbsp;' +
                    '<button class="button" type="button" onclick="$.Dialog.close()">Cancel</button> ' +
                    '</div>' +
                    '</form>';

                $.Dialog.title("User Details");
                $.Dialog.content(content);
            }
        });
    });
});

function onClickOfPurchaseButton() {
    document.getElementById("typeField").value = 1;
}

function onClickOfExchangeButton() {
    document.getElementById("typeField").value = 0;
}

function onClickOfApproveButton() {
    document.getElementById("typeField").value = 2;
}

function onClickOfIgnoreButton() {
    document.getElementById("typeField").value = 3;
}