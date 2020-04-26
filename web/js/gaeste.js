/**
 * Kurzbeschreibung
 *
 * @author  Anakin Kirschler
 * @since   2019-04-26
 * @version 1.0
 */
$(document).ready(function () {
    loadGaeste();

    /**
     * listener for buttons within shelfForm
     */
    $("#gastForm").on("click", "button", function () {
        if (confirm("Wollen Sie den Gast wirklich löschen?")) {
            deleteGast(this.value);
        }
    });

});

/**
 * loads the books from the webservice
 *
 */
function loadGaeste() {
    $
        .ajax({
            url: "./resource/gast/list",
            dataType: "json",
            type: "GET"
        })
        .done(showGaeste)
        .fail(function (xhr, status, errorThrown) {
            if (xhr.status == 403) {
                window.location.href("./login.html");
            } else if (xhr.status == 404) {
                $("#message").text("Keinen Gast vorhanden");
            }else {
                $("#message").text("Fehler beim Lesen der Gäste");
            }
        })
}

/**
 * shows all books as a table
 *
 * @param bookData all books as an array
 */
function showGaeste(gastData) {
    $("#message").val("");
    $("#gaeste > tbody").html("");
    var tableData = "";
    $.each(gastData, function (uuid, gast) {
        tableData += "<tr>";
        tableData += "<td>" + gast.vorname + "</td>";
        tableData += "<td>" + gast.nachname + "</td>";
        tableData += "<td>" + gast.adresse + "</td>";
        tableData += "<td>" + gast.hausnummer + "</td>";
        tableData += "<td>" + gast.plz + "</td>";
        tableData += "<td>" + gast.wohnort + "</td>";
        tableData += "<td>" + gast.land + "</td>";
        tableData += "<td>" + gast.telefon + "</td>";
        tableData += "<td>" + gast.mobil + "</td>";
        tableData += "<td>" + gast.geburtsdatum + "</td>";
        tableData += "<td>" + gast.mail + "</td>";
        tableData += "<td>" + gast.check_in + "</td>";
        tableData += "<td>" + gast.check_out + "</td>";
        if (Cookies.get("userRole") == "admin") {
            tableData += "<td><a href='./gastedit.html?uuid=" + uuid + "'>Bearbeiten</a></td>";
            tableData += "<td><button type='button' id='delete_" + uuid + "' value='" + uuid + "'>Löschen</button></td>";
        } else {
            tableData += "<td><a href='./gastedit.html?uuid=" + uuid + "'>Ansehen</a></td>";
        }
        tableData += "</tr>";
    });
    $("#gaeste > tbody").html(tableData);
}

/**
 * send delete request for a book
 * @param bookUUID
 */
function deleteGast(gastUUID) {
    $
        .ajax({
            url: "./resource/gast/delete?uuid=" + gastUUID,
            dataType: "text",
            type: "DELETE",
        })
        .done(function (data) {
            loadGaeste();
            $("#message").text("Gast gelöscht");

        })
        .fail(function (xhr, status, errorThrown) {
            $("#message").text("Fehler beim Löschen des Gastes");
        })
}