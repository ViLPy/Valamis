/**
 * Created by iliya.tryapitsin on 17.02.14.
 */



function refreshList() {
    var tmpl = "<tr><td>{0}</td><td>{1}</td><td>{2}</td></tr>";
    $("#clients").empty();
    $.each(clients, function (index, item) {
        $("#clients").append(tmpl
            .replace('{0}', item.clientId)
            .replace('{1}', item.clientSecret)
            .replace('{2}', item.clientName));
            /*.replace('{2}', item.expiredIn)
            .replace('{3}', item.issuedAt));*/
    });
}

$("#addingClientBtn").on("click", function () {
    $("#addClientModal").removeClass("fade");
});

$(".closable").on("click", function () {
    $("#addClientModal").addClass("fade");
});

$("#addClientBtn").on("click", function () {
    var data = $("#newClientFrm").serialize()
    $.post("/learn-portlet/oauth/registration", data)
        .success(function (result) {
            $("#addClientModal").addClass("fade");
            $('#newClientFrm')[0].reset();

            clients.push(result);
            refreshList();
        })
        .error(function () {
            alert("Request error");
        });
});

refreshList();