function checkUser() {
    var email = $("#user_email_pms").val();

    console.log(email);

    if(email.trim()==="") {
        alert("Please enter the field");
        return;
    }

    $.ajax({
        type: 'POST',
        url: '/reset?userEmail='+email,
        contentType: 'application/json',
        dataType: 'text',
        success: function (response) {
            if(response === "Success") {
                $("#userChecking").hide();
                $("#password-fields").show();
            } else {
                alert("User not found!");
                return;
            }
        },
        error: function (error) {
            console.error("Ошибка при отправке запроса:", error);
        },
    });
}

function changePassword() {
    var email = $("#user_email_pms").val();
    var old = $("#user_old").val();
    var newPassword = $("#user_new").val();

    if(old.trim()==="") {
        alert("Please enter the all fields");
        return;
    }
    if(newPassword.trim()==="") {
        alert("Please enter the all fields");
        return;
    }
    $.ajax({
        type: 'PUT',
        url: '/reset?user_old_password='+old+'&user_new_password='+newPassword+'&user_email='+email,
        contentType: 'application/json',
        dataType: 'text',
        success: function (response) {
            if(response === "Success") {
                window.location.href="/login";
            } else {
                alert("Something went wrong");
                return;
            }
        },
        error: function (error) {
            console.error("Ошибка при отправке запроса:", error);
        },
    });
}