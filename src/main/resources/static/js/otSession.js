var publisher = {};
var subscriber = {};

$(SELECTOR_SESSION_DESTROY_BTN).click(function () {
        OT.off();
});


var generateChatSession = function (response) {
    console.log(response);

// Initialize an OpenTok Session object
    var apiKey = "46056512";
    var sessionId = response.sessionId;
    var session = OT.initSession(apiKey, sessionId);

    var token = response.token;
// Initialize a Publisher, and place it into the element with id="publisher"
    publisher = OT.initPublisher("publisher", {
        width: 500,
        height: 400,
        name: response.users[0].fullName + "(" + response.users[0].username + ")"
    });

    $(SELECTOR_SESSION_TEXT_INPUT).keypress(function() {
        if($(this))
            signal($(this));
    });


// Connect to the Session using the 'apiKey' of the application and a 'token' for permission
    session.connect(token, function (error) {
        // This function runs when session.connect() asynchronously completes
        signal();
        // Handle connection errors
        if (error) {
            console.error('Failed to connect', error);
        } else {
            // Publish the publisher we initialzed earlier (this will trigger 'streamCreated' on other
            // clients)
            session.publish(publisher, function (error) {
                if (error) {
                    console.error('Failed to publish', error);
                }
            });
        }
    });

    subscriber = OT.initPublisher('pubView1');
    var session2 = OT.initSession(apiKey, sessionId);
    session2.on('streamCreated', function(event) {
        session2.subscribe(event.stream, 'pubView', {
            insertMode: 'append'
        }, function(error) {
            if (error) {
                console.error('Failed to subscribe', error);
            }
        });
    });


    var signal= function (msgTxt) {
        session.signal({
            type: 'msg',
            data: msgTxt.val()
        }, function (error) {
            if (error) {
                console.log('Error sending signal:', error.name, error.message);
            } else {
                msgTxt.value = '';
            }
        });

    };


    session.on('signal:msg', function(event) {
        debugger;
        var msg = document.createElement('p');
        var msgHistory= $(SELECTOR_SESSION_CHAT_LABEL);
        msg.innerText = event.data;
        msg.className = event.from.connectionId === session.connection.connectionId ? 'mine' : 'theirs';
        msgHistory.text(event.data);
        msg.scrollIntoView();
    });



}

