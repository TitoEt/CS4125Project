function disableStayQuestions() {
    document.getElementById("stayDuration").disabled = true;
    document.getElementById("stayDuration").value = 0;
    document.getElementById("wardBed").disabled = true;
    document.getElementById("privateRoom").disabled = true;
    document.getElementById("monitoringYes").disabled = true;
    document.getElementById("monitoringNo").disabled = true;
    disableMonitoringQuestion();
}

function enableStayQuestions() {
    document.getElementById("stayDuration").disabled = false;
    document.getElementById("wardBed").disabled = false;
    document.getElementById("privateRoom").disabled = false;
    document.getElementById("monitoringYes").disabled = false;
    document.getElementById("monitoringNo").disabled = false;
    document.getElementById("monitoringDuration").disabled = false;
}

function enableMonitoringQuestion() {
    document.getElementById("monitoringDuration").disabled = false;
}

function disableMonitoringQuestion() {
    document.getElementById("monitoringDuration").disabled = true;
    document.getElementById("monitoringDuration").value = 0;
}

function toggleStayQuestions() {
    if(document.getElementById("hospitalStay").checked) {
        enableStayQuestions();
    }
    else {
        disableStayQuestions();
    }
}

$(document).ready(function () {
    console.log("Document ready");
    disableStayQuestions();
});