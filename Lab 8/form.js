function submitmarks()
    {
        var phy=document.getElementById("physics").value
        var chem = document.getElementById("chem").value
        var mathbio = document.getElementById("mathbio").value
        var dob= document.getElementById("dob").value
        var split_dob = dob.split("-");
        var month = split_dob[1];
        var day = split_dob[2];
        var year = split_dob[0];
        var dob_asdate = new Date(year, month, day);
        var today = new Date();
        var mili_dif = Math.abs(today.getTime() - dob_asdate.getTime());
        var age = (mili_dif / (1000 * 3600 * 24 * 365.25));
        console.log(Math.floor(age));

        if(age>17 && age <23 && phy>50&& chem>50 && mathbio >50)
        {
            alert("Eligible")
        }
        else{
            alert("Not eligible")
        }
    }