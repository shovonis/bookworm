/**
 * Created by rifatul.islam on 8/7/14.
 */

//TODO: Bug here . step value cant be negative or more than maximum step.

function onclickOfNext(id) {
    $('#demo_stepper_methods').stepper('next');
    var stepValue = document.getElementById("stepper_value").value;
    stepValue = parseInt(stepValue) + 1;
    document.getElementById("stepper_value").value = stepValue;

}

function onclickOfPrior(id) {
    $('#demo_stepper_methods').stepper('prior');
    var stepValue = document.getElementById("stepper_value").value;
    stepValue = parseInt(stepValue) - 1;
    document.getElementById("stepper_value").value = stepValue;

}