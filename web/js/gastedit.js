/**
 * Kurzbeschreibung
 *
 *
 *
 * @author  Anakin Kirschler
 * @since   2019-04-26
 * @version 1.0
 */
$(document).ready(function () {
    loadGast();

    /**
     * listener for submitting the form
     */
    $("#gasteditForm").submit(saveGast);

    /**
     * listener for button [abbrechen], redirects to bookshelf
     */
    $("#cancel").click(function () {
        window.location.href = "./gaeste.html";
    });

});

/**
 *  loads the data of this book
 *
 */
function loadGast() {
    var gastUUID = $.urlParam('uuid');
    if (gastUUID !== null && gastUUID != -1) {
        $
            .ajax({
                url: "./resource/gast/search?uuid=" + gastUUID,
                dataType: "json",
                type: "GET"
            })
            .done(showBook)
            .fail(function (xhr, status, errorThrown) {
                if (xhr.status == 403) {
                    window.location.href = "./login.html";
                } else if (xhr.status == 404) {
                    $("#message").text("Kein Gast gefunden");
                } else {
                    window.location.href = "./gaeste.html";
                }
            })
    }
}

/**
 * shows the data of this book
 * @param  book  the book data to be shown
 */
function showBook(gast) {
    $("#message").empty();
    $("#gastUUID").val(gast.gastUUID);
    $("#vorname").val(gast.vorname);
    $("#nachname").val(gast.nachname);
    $("#address").val(gast.address);
    $("#hausnummer").val(gast.hausnummer);
    $("#plz").val(gast.plz);
    $("#wohnort").val(gast.wohnort);
    $("#land").val(gast.land);
    $("#telefon").val(gast.telefon);
    $("#mobil").val(gast.mobil);
    $("#geburtsdatum").val(gast.geburtsdatum);
    $("#mail").val(gast.mail);
    $("#check_in").val(gast.check_in);
    $("#check_out").val(gast.check_out);


    if (Cookies.get("userRole") != "admin") {
        $("#vorname, #nachname, #address, #hausnummer, #plz, #wohnort, #land, #telefon, #mobil, #geburtsdatum, #mail,#check_in,#check_out").prop("readonly", true);
        $("#save, #reset").prop("disabled", true);
    }
}

/**
 * sends the book data to the webservice
 * @param form the form being submitted
 */
function saveGast(form) {
    form.preventDefault();
    var gastUUID = $("#gastUUID").val();
    var url = "./resource/gast/";
    var type = "";
    if (gastUUID) {
        url += "update";
        type = "PUT";
    } else {
        url += "create";
        type = "POST";
    }
    $
        .ajax({
            url: url,
            dataType: "text",
            type: type,
            data: $("#gasteditForm").serialize(),
        })
        .done(function (jsonData) {
            window.location.href = "./gaeste.html";
        })
        .fail(function (xhr, status, errorThrown) {
            if (xhr.status == 404) {
                $("#message").text("Dieser Gast existiert nicht");
            } else {
                $("#message").text("Fehler beim Speichern des Gastes");
            }
        })
}

