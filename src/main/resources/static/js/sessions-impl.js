var initStepOne = function () {
    // Hide other steps
    $(SELECTOR_STEP_TWO).hide();
    $(SELECTOR_STEP_THREE).hide();
    $(SELECTOR_STEP_ONE).show();

};


var initSession = function (loggedInUser) {

    if (loggedInUser) {

        var sessionId = $(SELECTOR_SESSION_JOIN_INPUT).val();
        var sessionName = $(SELECTOR_SESSION_NAME_INPUT).val();
        var url = "";
        var payload = "";
        if (sessionId) {
            url = "http://localhost:8080/session/" + sessionId + "/user/" + JSON.parse(loggedInUser).id;
            payload = {"id": $(SELECTOR_SESSION_JOIN_INPUT).val()};
        }
        if (sessionName) {
            url = "http://localhost:8080/session/user/" + JSON.parse(loggedInUser).id + "/add";
            payload = {"name": $(SELECTOR_SESSION_NAME_INPUT).val()};
        }

        $.ajax({
            type: "post",
            url: url,
            data: JSON.stringify(payload),
            dataType: "json",
            contentType: "application/json",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function (response) {
                generateChatSession(response);

            },
            error: function (response) {
                console.log(response);
            }
        });
    }
};

