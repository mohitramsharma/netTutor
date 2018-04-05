var SELECTOR_ROLE_SELECT = "#roleSelect";
var SELECTOR_ROLE_UL_LI = ".roleOpt";
var SELECTOR_ROLE_OPT_LBL = "#roleOptLbl";
var SELECTOR_USER_SAVE_BTN = "#saveUserBtn";
var SELECTOR_SECTION_TUTOR ="#section-tutor";
var SELECTOR_SECTION_TUTOR_LINK = "#tutorSection";
var URL_ROLELIST = "http://localhost:8080/role";

 // Initialize collapse button
  $(".button-collapse").sideNav();
  // Initialize collapsible (uncomment the line below if you use the dropdown variation)
  //$('.collapsible').collapsible();

$(document).ready(function(){

    $(SELECTOR_SECTION_TUTOR).hide();


    $('.modal').modal();
    $('select').material_select();

    // Loads Role Data
    $.ajax({
        type: "get",
        url: URL_ROLELIST,
        dataType:"json",
        contentType: "application/json",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (response) {
            console.log(response);
            debugger;
            if( SELECTOR_ROLE_UL_LI.charAt( 0 ) === '.' )
                SELECTOR_ROLE_UL_LI = SELECTOR_ROLE_UL_LI.slice( 1 );

            for(var i=0;i<response.length;i++){

                    var li = $("<option></option>")
                        .attr("value",response[i].id)
                        .text(response[i].name);

                    $(SELECTOR_ROLE_SELECT).append(li);
                    $(SELECTOR_ROLE_SELECT).material_select()
            }
        },
        error:function(response){
            console.log(response);
        }
    });

    // Load User Data


    // Initialize DataTable
    function Employee ( name, position, salary, office ) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this._office = office;

        this.office = function () {
            return this._office;
        }
    };

    var dataSet = [
        ["Tiger Nixon", "System Architect", "Edinburgh", "5421", "2011/04/25", "$320,800"],
        ["Garrett Winters", "Accountant", "Tokyo", "8422", "2011/07/25", "$170,750"],
        ["Ashton Cox", "Junior Technical Author", "San Francisco", "1562", "2009/01/12", "$86,000"],
        ["Cedric Kelly", "Senior Javascript Developer", "Edinburgh", "6224", "2012/03/29", "$433,060"],
        ["Airi Satou", "Accountant", "Tokyo", "5407", "2008/11/28", "$162,700"],
        ["Brielle Williamson", "Integration Specialist", "New York", "4804", "2012/12/02", "$372,000"],
        ["Herrod Chandler", "Sales Assistant", "San Francisco", "9608", "2012/08/06", "$137,500"],
        ["Rhona Davidson", "Integration Specialist", "Tokyo", "6200", "2010/10/14", "$327,900"],
        ["Colleen Hurst", "Javascript Developer", "San Francisco", "2360", "2009/09/15", "$205,500"],
        ["Sonya Frost", "Software Engineer", "Edinburgh", "1667", "2008/12/13", "$103,600"],
        ["Jena Gaines", "Office Manager", "London", "3814", "2008/12/19", "$90,560"],
        ["Quinn Flynn", "Support Lead", "Edinburgh", "9497", "2013/03/03", "$342,000"],
        ["Charde Marshall", "Regional Director", "San Francisco", "6741", "2008/10/16", "$470,600"],
        ["Haley Kennedy", "Senior Marketing Designer", "London", "3597", "2012/12/18", "$313,500"],
        ["Tatyana Fitzpatrick", "Regional Director", "London", "1965", "2010/03/17", "$385,750"],
        ["Michael Silva", "Marketing Designer", "London", "1581", "2012/11/27", "$198,500"],
        ["Paul Byrd", "Chief Financial Officer (CFO)", "New York", "3059", "2010/06/09", "$725,000"],
        ["Gloria Little", "Systems Administrator", "New York", "1721", "2009/04/10", "$237,500"],
        ["Bradley Greer", "Software Engineer", "London", "2558", "2012/10/13", "$132,000"],
        ["Dai Rios", "Personnel Lead", "Edinburgh", "2290", "2012/09/26", "$217,500"],
        ["Jenette Caldwell", "Development Lead", "New York", "1937", "2011/09/03", "$345,000"],
        ["Yuri Berry", "Chief Marketing Officer (CMO)", "New York", "6154", "2009/06/25", "$675,000"],
        ["Caesar Vance", "Pre-Sales Support", "New York", "8330", "2011/12/12", "$106,450"],
        ["Doris Wilder", "Sales Assistant", "Sidney", "3023", "2010/09/20", "$85,600"],
        ["Angelica Ramos", "Chief Executive Officer (CEO)", "London", "5797", "2009/10/09", "$1,200,000"],
        ["Gavin Joyce", "Developer", "Edinburgh", "8822", "2010/12/22", "$92,575"],
        ["Jennifer Chang", "Regional Director", "Singapore", "9239", "2010/11/14", "$357,650"],
        ["Brenden Wagner", "Software Engineer", "San Francisco", "1314", "2011/06/07", "$206,850"],
        ["Fiona Green", "Chief Operating Officer (COO)", "San Francisco", "2947", "2010/03/11", "$850,000"],
        ["Shou Itou", "Regional Marketing", "Tokyo", "8899", "2011/08/14", "$163,000"],
        ["Michelle House", "Integration Specialist", "Sidney", "2769", "2011/06/02", "$95,400"],
        ["Suki Burks", "Developer", "London", "6832", "2009/10/22", "$114,500"],
        ["Prescott Bartlett", "Technical Author", "London", "3606", "2011/05/07", "$145,000"],
        ["Gavin Cortez", "Team Leader", "San Francisco", "2860", "2008/10/26", "$235,500"],
        ["Martena Mccray", "Post-Sales support", "Edinburgh", "8240", "2011/03/09", "$324,050"],
        ["Unity Butler", "Marketing Designer", "San Francisco", "5384", "2009/12/09", "$85,675"]
    ];

    var columnDefs = [{
        title: "Name"
    }, {
        title: "Position"
    }, {
        title: "Office"
    }, {
        title: "Extn."
    }, {
        title: "Start date"
    }, {
        title: "Salary"
    }];

    var myTable;

    myTable = $('#example').DataTable({
        "sPaginationType": "full_numbers",
        data: dataSet,
        columns: columnDefs,
        dom: 'Bfrtip',        // Needs button container
        select: 'single',
        responsive: true,
        altEditor: true,     // Enable altEditor
        buttons: [{
            text: 'Add',
            name: 'add'        // do not change name
        },
            {
                extend: 'selected', // Bind to Selected row
                text: 'Edit',
                name: 'edit'        // do not change name
            },
            {
                extend: 'selected', // Bind to Selected row
                text: 'Delete',
                name: 'delete'      // do not change name
            }]
    });

    // Loads Tutor Section
    $(SELECTOR_SECTION_TUTOR_LINK).click(function () {
       $(SELECTOR_SECTION_TUTOR).show();
    });

     // Adds a new Teacher
     $(SELECTOR_USER_SAVE_BTN).click(function () {

         var fName = $("#first_name").val();
         var lName = $("#last_name").val();
         var email = $("#email").val();
         var password = $("#password").val();
         var roleSelected = $(SELECTOR_ROLE_SELECT).val();

         var user = {};

         user.firstName = fName;
         user.lastName = lName;
         user.email = email;
         user.password = password;
         user.role ={};
         user.role.id= parseInt(roleSelected);
         if(user){
             var payload = {"user":user};
             var url = "http://localhost:8080/user/add";
             // Ajax Hit for logout
             $.ajax({
                 type: "post",
                 url: url,
                 data : JSON.stringify(user),
                 dataType:"json",
                 contentType: "application/json",
                 headers: {
                     'Accept': 'application/json',
                     'Content-Type': 'application/json'
                 },
                 success: function (response) {
                     console.log(response);

                 },
                 error:function(response){
                     console.log(response);
                 }
             });
         }
});

 // Adds a new Student
     $(SELECTOR_ROLE_UL_LI).on( "click", function() {
         debugger;
        var roleOpt =$(this).text();
        if(roleOpt){
            switch(roleOpt){
                case "Student":
                    // Prepare UI for Student creation

                    break;

                case "Teacher":
                    // Prepare UI for Student creation
                    break;

                case "Manager":
                    // Prepare UI for Student creation
                    break;

                case "Admin":
                    // Prepare UI for Student creation
                    break;
                default:
                    console.log("Invalid Selection");
                    break;
            }
            debugger;
            $(SELECTOR_ROLE_OPT_LBL).text($(this).html());

            $(SELECTOR_ROLE_OPT_LBL).text(roleOpt);
        }

     });

     // Adds a new Student
     $("#addStudentBtn").click(function(){
                         debugger;
                         var user = localStorage.getItem("loggedInUser");

                         if(user){
                             var payload = {"user":user};
                             var url = "http://localhost:8080/student/add";
                             // Ajax Hit for logout
                             $.ajax({
                                 type: "post",
                                 url: url,
                                 data : JSON.stringify(payload),
                                 dataType:"json",
                                 contentType: "application/json",
                                  headers: {
                                     'Accept': 'application/json',
                                     'Content-Type': 'application/json'
                                 },
                                 success: function (response) {
                                      console.log(response);
                                      localStorage.removeItem("loggedInUser");
                                       window.location.href = "/index.html";
                                 },
                                 error:function(response){
                                     console.log(response);
                                 }
                             });
                         }
      });

});
