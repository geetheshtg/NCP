document.getElementById("submit_button").addEventListener("click", function (e) {
    e.preventDefault();
    var fname = document.getElementById("fname").value;
    var mname = document.getElementById("mname").value;
    var lname = document.getElementById("lname").value;

    var mail_pattern = /^\w([\.-]?\w+)*$/;
    var domain_pattern = /^\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var mname_pattern = /^[a-zA-z]*$/;
    var name_pattern = /^[a-zA-z]+$/;

    var mail1 = document.getElementById("mail1").value;
    var mail2 = document.getElementById("mail2").value;

    var address = document.getElementById("address").value;

    var proceed = true;

    if (!name_pattern.test(fname)) {
        alert("First Name should not be empty and should contain only uppercase and lowercase alhapbets");
        proceed = false;
    }

    if (!mname_pattern.test(mname)) {
        alert("Middle Name should contain only uppercase and lowercase alphabets");
        proceed = false;
    }

    if (!name_pattern.test(lname)) {
        alert("Last Name should not be empty and should contain only uppercase and lowercase alphabets");
        proceed = false;
    }

    if (address == "") {
        alert("Address should not be empty");
        proceed = false;
    }

    if (!mail_pattern.test(mail1)) {
        alert("Invalid Mail");
        proceed = false;
    }

    if (!domain_pattern.test(mail2)) {
        alert("Invalid Domain");
        proceed = false;
    }

    var age_range = document.getElementById("age-range").value;

    if (age_range === "default") {
        alert("Choose an age-range");
        proceed = false;
    }

    var gname_obj = document.getElementById("gname");

    if (gname_obj != null) {
        var gname = gname_obj.value;
        if (!name_pattern.test(gname)) {
            alert("Guardian Name cannot be empty and should contain only uppercase and lowercase alphabets.");
            proceed = false;
        }
    }

    var insertProperty = function (string, propName, propValue) {
        var propToReplace = "{{" + propName + "}}";
        string = string.replace(new RegExp(propToReplace, "g"), propValue);
        return string;
    };

    if (proceed) {
        var container = document.getElementById("contact");
        var HTML =
            "<div>Name : {{name_holder}}</div><div>Address: <p> {{address_holder}} </p></div><div>Mail ID: {{mail_holder}}</div><div>Age Range: {{age_holder}}</div><div>Gender: {{gender_holder}}</div>";
        var xtraHTML = "<div>Guardian Name: {{gname_holder}}</div>";
        var name = fname + " " + mname + " " + lname;
        HTML = insertProperty(HTML, "name_holder", name);
        var mail = mail1 + "@" + mail2;
        HTML = insertProperty(HTML, "mail_holder", mail);

        var gender = "";
        var checkboxes = document.getElementsByName("gender");
        for (box of checkboxes) {
            if (box.checked) {
                gender = box.value;
            }
        }

        HTML = insertProperty(HTML, "gender_holder", gender);
        HTML = insertProperty(HTML, "age_holder", age_range);
        HTML = insertProperty(HTML, "address_holder", address);

        var gname;
        if (gname_obj != null) {
            gname = gname_obj.value;
            HTML += xtraHTML;
            HTML = insertProperty(HTML, "gname_holder", gname);
        }
        container.innerHTML = HTML;
    }
});

document.getElementById("age-range").addEventListener("change", function (e) {
    var age_range = document.getElementById("age-range").value;
    if (age_range == "0-18") {
        document.getElementById("guardian-optional").innerHTML = '<input id="gname" placeholder="Guardian Name *" type="text" tabindex="5" required autofocus />';
    } else {
        document.getElementById("guardian-optional").innerHTML = null;
    }
});
