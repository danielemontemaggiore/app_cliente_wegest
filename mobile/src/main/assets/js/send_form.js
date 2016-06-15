$(document).ready(function() {
  $("#invia_richiesta").click(function(){
    var bar_code = $("#bar_code").val();
    var id_punto = $("#id_punto").val();
    $.ajax({
      type: "GET",
      url: "http://www.i-salon.eu/accesso_barcode.asp",
      data: "bar_code=" + bar_code + "&id_punto=" + id_punto,
      dataType: "text",
      success: function(msg)
      {
		  var elem = document.getElementById("scritta");
			elem.parentNode.removeChild(elem);
			var json = msg;
			var jsonData = JSON.parse(json);
			
			var risposta = jsonData.Risposta;

			var messaggio_errore = "Errore";

			$("#risultato").append(risposta);

			if (risposta.localeCompare(messaggio_errore)==-1) {
                $("#risultato").append('Il codice a barre da lei inserito è errato.<br>Per visualizzare il suo saldo punti, torni alla schermata precedente e inserisca nuovamente il codice a barre.');
            }
			else
			{
                var cognome = jsonData.Cognome;
                var nome = jsonData.Nome;
                var punti_disponibili = jsonData.Punti;
                $("#risultato").append('<div id="descrizione-punti"> Benvenuta <b>'+ cognome + " " + nome +"</b><br>Lei ha totalizzato <b>"+ punti_disponibili +"</b> punti.<br> Di seguito trova la lista dei premi disponibili : <br><br><br></div>");
                $("#risultato").append('<table class="table"><thead><tr><th class="name">Premio</th><th class="points">Punti</th></tr></thead><tbody>');
                for (var i = 0; i < jsonData.Premi.length; i++) {
                    var tipo_premio = jsonData.Premi[i];
                    if(i%2==0){
                    $("#risultato").append('<tr class="table_content"><td class="name">' + tipo_premio.Premio + '</td><td class="points"> '+ tipo_premio.Punti +"</td></tr>");
                    }
                    else{
                        $("#risultato").append('<tr class="table_content2"><td class="name">' + tipo_premio.Premio + '</td><td class="points"> '+ tipo_premio.Punti +"</td></tr>");
                    }
                }
                $("#risultato").append('</tbody></table>');
			}
      },
      error: function()
      {
		  alert("Errore");
		
			
      }
    });
  });
});