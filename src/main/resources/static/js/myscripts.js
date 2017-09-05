$(document).ready(function pulse() {
    $("header").fadeOut(500);
    $("header").fadeIn(300);
});

function submitButton(e) {
    e.preventDefault();
    $.ajax({
        type: "POST",
        url: "/signup.html/form",
        contentType: "application/json",
        data: {firstName : "firstname",
                lastName : "lastname",
                email : "email"},
        success: function (result) {
            alert('ok');
        },
        error: function (result) {
            alert('error');
        }
    });
};
