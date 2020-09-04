document.getElementById("submit_button").addEventListener("click", function (e) {
    e.preventDefault();
    var name = document.getElementById("name").value;
    var address = document.getElementById("address").value;

    var proceed = true;

    if (!name_pattern.test(name)) {
        alert("Name should not be empty and should contain only uppercase and lowercase alhapbets");
        proceed = false;
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

        var gname;
        if (gname_obj != null) {
            gname = gname_obj.value;
            HTML += xtraHTML;
            HTML = insertProperty(HTML, "gname_holder", gname);
        }
        container.innerHTML = HTML;
    }
});
