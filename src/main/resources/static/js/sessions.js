/* UI Management Selectors*/
var SELECTOR_STEP_ONE = "#step-one";
var SELECTOR_STEP_TWO = "#step-two";
var SELECTOR_STEP_THREE = "#step-three";

/*Data Management Selectors*/
var SELECTOR_SESSION_CREATE_BTN = "#createSessionBtn";
var SELECTOR_SESSION_NAME_INPUT = "#sessionName";
var SELECTOR_SESSION_DESTROY_BTN = ".sessionDestroyBtn";
var SELECTOR_SESSION_JOIN_BTN = "#joinSessionBtn";
var SELECTOR_SESSION_TEXT_INPUT = "#msgInput";
var SELECTOR_SESSION_CHAT_LABEL = "#chatBox";
var SELECTOR_SESSION_JOIN_INPUT = "#sessionId";
var SELECTOR_SESSION_TABLE = "#sessionTable";
var SELECTOR_SESSION_VIEW_BTN = "#viewSessionsBtn";
var COUNT = 0;
$(document).ready(function () {

    var loggedInUser = localStorage.getItem(USER_LOCAL_ALIAS);

    $(SELECTOR_SESSION_CREATE_BTN).click(function () {
        initSession(loggedInUser);
    });
    $(SELECTOR_SESSION_JOIN_BTN).click(function () {
        initSession(loggedInUser);
    });

    if (loggedInUser) {
        initStepOne(loggedInUser.role);
    }
});

