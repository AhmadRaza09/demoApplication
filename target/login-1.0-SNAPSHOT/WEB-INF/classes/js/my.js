
$(document).ready( function () {
    // alert("Raza");
    $('#table_id').DataTable();
} );

function userUpdate(e)
{
    // alert(e);
    // alert("Ahmad");
    var s = $(e).attr("id");
    // alert(s);
    var a = "/getUser/" + s;
    // alert(a);
    $.ajax(
        {
            type: "GET",
            url: "/getUser/" + s,
            success: function (data)
            {
                console.log(data.firstName);
                console.log(data.lastName);
                console.log(data.mobile);
                console.log(data.designation);
                console.log(data.gender);
                console.log(data.account.email);
                $('.someCssClass input[type=hidden]').val(data.id)
                $('.fname').val(data.firstName);
                $('.lname').val(data.lastName);
                $('.des').val(data.designation);
                $('.email').val(data.account.email);
                $('.mob').val(data.mobile);
                $('.pass').val(data.account.password);
                $('.male input[value=' + data.gender + ']').attr('checked', 'checked');
                $('.status input[value=' + data.status + ']').attr('checked', 'checked');
                $('.role input[value=' + data.account.role.id + ']').attr('checked', 'checked');
                // alert(data.id);
            }

        }
    )


}

