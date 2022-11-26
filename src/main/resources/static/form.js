function disableStayQuestions() {
    document.getElementById("stayDuration").disabled = true;
    document.getElementById("monitoringYes").disabled = true;
    document.getElementById("monitoringNo").disabled = true;
    document.getElementById("monitoringDuration").disabled = true;
}

function enableStayQuestions() {
    document.getElementById("stayDuration").disabled = false;
    document.getElementById("monitoringYes").disabled = false;
    document.getElementById("monitoringNo").disabled = false;
    document.getElementById("monitoringDuration").disabled = false;
}

function enableMonitoringQuestion() {
    document.getElementById("monitoringDuration").disabled = false;
}

function disableMonitoringQuestion() {
    document.getElementById("monitoringDuration").disabled = true;
}