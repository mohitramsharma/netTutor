
var PATH_INDEX = "/index.html";

var URL_LOGIN = "http://localhost:8080/login";
var URL_LOGOUT = "http://localhost:8080/logout";
var URL_REDIRECT = "http://localhost:8080/dashboard.html";

var USER_LOCAL_ALIAS = "loggedInUser";
var SELECTOR_USER_ID = "#username";
var SELECTOR_PASS = "#password";
var SELECTOR_LOGIN_BTN = "#loginBtn";
var SELECTOR_LOGOUT_BTN = "#logoutBtn";

$(document).ready(function(){


    validateUser();

    $(SELECTOR_LOGIN_BTN).click(function(){
            var username = $(SELECTOR_USER_ID).val();
            var password = $(SELECTOR_PASS).val();

            if( (username!=undefined || username!="") && (password != undefined || password!="") ){
                var payload = {"username":username,"password":password};

                // Ajax Hit for login
                $.ajax({
                    type: "POST",
                    url: URL_LOGIN,
                    data : JSON.stringify(payload),
                    dataType:"json",
                    contentType: "application/json",
                     headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    success: function (response, textStatus, jqXHR) {
                        if(response) {
                          localStorage.setItem(USER_LOCAL_ALIAS,JSON.stringify(response));
                          window.location = URL_REDIRECT;
                        } else{
                          console.log("error occurs");
                        }
                    },
                    error:function(response){
                        console.log(response);
                    },
                    complete: function(xhr){
                    }
                });
            }
    });

   $(SELECTOR_LOGOUT_BTN).click(function(){
                var user = localStorage.getItem(USER_LOCAL_ALIAS);

                if(user){
                    var payload = JSON.parse(user);
                    // Ajax Hit for logout
                    $.ajax({
                        type: "post",
                        url: URL_LOGOUT,
                        data : JSON.stringify(payload),
                        dataType:"json",
                        contentType: "application/json",
                         headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        success: function (response) {
                             console.log(response);
                             localStorage.removeItem(USER_LOCAL_ALIAS);
                              window.location.href = PATH_INDEX;
                        },
                        error:function(response){
                            console.log(response);
                        }
                    });
                }
        });


});




var validateUser = function(){
    // Redirect to login if user is znull
    var loggedInUser = localStorage.getItem(USER_LOCAL_ALIAS);

    if(loggedInUser == null && window.location.pathname != PATH_INDEX){
      window.location.href= PATH_INDEX;
    }
}