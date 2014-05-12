$(".mescovoits").click(function(){

	var type= $(this).attr("data-type");

	if(type == "covoitAttente"){

		$(this).css("color", "#EA3C3D");
		$(this).prev().css("color", "black");
		$(this).next().css("color", "black");
		$("#tabCovoitAccepte").hide();
		$("#tabCovoitAttente").show();
		$("#tabCovoitRefuse").hide();
	}
	else if(type == "covoitRefuse"){

		$(this).css("color", "#EA3C3D");
		$(this).prev().css("color", "black");
		$(this).prev().prev().css("color", "black");
		$("#tabCovoitAccepte").hide();
		$("#tabCovoitAttente").hide();
		$("#tabCovoitRefuse").show();
	}
	else{

		$(this).css("color", "#EA3C3D");
		$(this).next().css("color", "black");
		$(this).next().next().css("color", "black");
		$("#tabCovoitAccepte").show();
		$("#tabCovoitAttente").hide();
		$("#tabCovoitRefuse").hide();
	}
});

$(".seeMoreAnnonce").click(function(event){

	var type= $(this).attr("data-type");
	var id = $(this).attr("data-id");
	var login = $(this).attr("data-login");

	if($(this).parent().parent().next("tr").css('display') != 'none'){
		$(this).parent().parent().next("tr").hide();
		$(this).parent().parent().next("tr").next("tr").hide();
		$(this).attr("src", "img/downarrow2.png");
	}
	else{
		$(this).parent().parent().next("tr").show();
		$(this).parent().parent().next("tr").next("tr").show();
		$(this).attr("src", "img/uparrow2.png");
	}


	event.preventDefault();
	$.ajax({ dataType: "json",url:"etapes", type:"POST", 
		data: "type="+type+"&seeMoreInfos=1&id="+id
	}).done(function(data){
		var etapesTemp = "";
		for (var i = 0; i < data.length; ++i) {
			etapesTemp += ""+data[i].nomVille+"&nbsp;&nbsp;<img src='img/rightarrow.png' alt=''>&nbsp;&nbsp;";
		}
		$(".etapesMore"+id).html(etapesTemp);
	});

	$.ajax({ dataType: "json",url:"getuser", type:"POST", 
		data: "login="+login+"&seeMoreInfos=1"
	}).done(function(data){
		$(".userAddMore"+id).html("- "+data.prenom+" "+data.nom[0]+". -");
	});
});


$(".seeMore").click(function(event){

	var type= $(this).attr("data-type");
	var id = $(this).attr("data-id");
	var login = $(this).attr("data-login");

	if($(this).parent().parent().next("tr").css('display') != 'none'){
		$(this).parent().parent().next("tr").hide();
		$(this).parent().parent().next("tr").next("tr").hide();
		$(this).parent().parent().next("tr").next("tr").next("tr").hide();
		$(this).parent().parent().nextAll(".souhaiteEtreOuAccepteDansCovoit"+id).hide();
		$(this).attr("src", "img/downarrow2.png");
	}
	else{
		$(this).parent().parent().next("tr").show();
		$(this).parent().parent().next("tr").next("tr").show();
		$(this).parent().parent().next("tr").next("tr").next("tr").show();
		$(this).parent().parent().nextAll(".souhaiteEtreOuAccepteDansCovoit"+id).show();
		$(this).attr("src", "img/uparrow2.png");
	}


	event.preventDefault();
	$.ajax({ dataType: "json",url:"etapes", type:"POST", 
		data: "type="+type+"&seeMoreInfos=1&id="+id
	}).done(function(data){
		var etapesTemp = "";
		for (var i = 0; i < data.length; ++i) {
			etapesTemp += ""+data[i].nomVille+"&nbsp;&nbsp;<img src='img/rightarrow.png' alt=''>&nbsp;&nbsp;";
		}
		$(".etapesMore"+id).html(etapesTemp);
	});

	$.ajax({ dataType: "json",url:"getuser", type:"POST", 
		data: "login="+login+"&seeMoreInfos=1"
	}).done(function(data){
		$(".userAddMore"+id).html("- "+data.prenom+" "+data.nom[0]+". -");
	});
});


$(".personneDansCovoit").click(function(event){

	var typeDemande= $(this).attr("data-typeDemande");
	var idAP = $(this).attr("data-idAP");
	var loginDesirEtreDansCovoit = $(this).attr("data-loginDesirEtreDansCovoit");	
	var nbPlaceSuffisant = false;
	var elt = $(this);

	event.preventDefault();

	$.post("ajaxreserver",{ 
		typeDemande : typeDemande,
		loginDesirEtreDansCovoit : loginDesirEtreDansCovoit,
		idAP : idAP
	}, 'json').done(function(data){

		if(data){
			nbPlaceSuffisant = true;
		}

		if(typeDemande == "accepterDansCovoit" && nbPlaceSuffisant){

			$(elt).parent().next("td").remove();
			$(elt).parent().remove();     
		}     
		else if(typeDemande == "refusePourCovoit"){

			$(elt).parent().parent().remove();
		}
	});
});


$(".editAds").click(function() {
	//Si l'on est pas connecté
	if ($(this).attr("data-type") == "proposition") {
		$(".divModifRech").slideUp("slow");
		$("#inputEtape").html("");
		$.ajax({url : "etapes",
			type : "POST",
			data : {id : $(this).attr("data-idP")}
		}).done(function(response) {
			var currentEtape = response.length;
			for (var i = 0; i < response.length; i++) {
				$("#inputEtape").append('<div id="dynamicInputPropM'+(i+1)+'" class="columnheader2">Etape <span class="idCurrentEtape">'	+ (i + 1)+ '</span><br><input type="text" class="input_contact villeInput" name="etapesPropM" id="villeEtape'+ (i+1) +'" value="'+response[i].nomVille+'">');
			}
			for(var a = response.length; a <15; a++){
				$("#inputEtape").append('<div id="dynamicInputPropM'+(a+1)+'" class="columnheader2" style="display: none;">Etape <span class="idCurrentEtape">'	+ (a + 1)+ '</span><br><input type="text" class="input_contact villeInput" name="etapesPropM" id="villeEtape'+ (a+1) +'" >');
			}

			$("#addEtapeProp").click(function() {
				$("#inputEtape").children("#dynamicInputPropM"+(currentEtape+1)).show();
				currentEtape++;
			});
		});

		//On met les valeurs de l'image � modifier dans les div
		$("#idProp").attr("value", $(this).attr("data-idP"));
		$("#villeDepartPropM").attr("value",$(this).attr("data-villeD"));
		$("#villeArriveePropM").attr("value",$(this).attr("data-villeA"));
		$("#datePropM").attr("value",$(this).attr("data-date"));

		$("#heurePropM option[value='"+ $(this).attr("data-heure") + "']").attr("selected", "selected");
		$("#minutePropM option[value='"+ $(this).attr("data-min") + "']").attr("selected", "selected");

		$("#commentPropM").text($(this).attr("data-commentaire"));
		$("#prixPropM").attr("value",$(this).attr("data-prix"));
		$("#nbPlacePropM").attr("value",$(this).attr("data-nbPlace"));

		$(".divModif").slideDown("slow");
		$('html, body').animate({
			scrollTop : $(".wrapper6").offset().top
		}, 2000);
	}
	if ($(this).attr("data-type") == "recherche") {
		$(".divModif").slideUp("slow");
		//On met les valeurs de l'image � modifier dans les div
		$("#idRech").attr("value", $(this).attr("data-idR"));
		$("#villeDepartRechM").attr("value",$(this).attr("data-villeD"));
		$("#villeArriveeRechM").attr("value",$(this).attr("data-villeA"));
		$("#dateRechM").attr("value",$(this).attr("data-date"));

		$("#heureRechM option[value='"+ $(this).attr("data-heure") + "']").attr("selected", "selected");
		$("#minuteRechM option[value='"+ $(this).attr("data-min") + "']").attr("selected", "selected");

		$("#commentRechM").text($(this).attr("data-commentaire"));

		$(".divModifRech").slideDown("slow");
		$('html, body').animate({
			scrollTop : $(".wrapper6 divModifRech").offset().top
		}, 2000);
	}

});

$(".deleteAds").click(function(){
	$(this).parent().parent().hide();

	if($(this).attr("data-type") == "proposition"){
		$(this).parent().parent().next().hide();
		$(this).parent().parent().next().next().hide();
	}
	var nbS = parseInt($(this).parent().parent().parent().parent().parent().parent().children(".titleAbout").children(".nbS").text());
	var nbSafter = nbS - 1;
	$(this).parent().parent().parent().parent().parent().parent().children(".titleAbout").children(".nbS").html(nbSafter);
	$(this).parent().parent().parent().parent().parent().children("#messageAjax").html('<span class="red">L\'annonce a correctement été supprimée.</span>');
	$.ajax({url : "profil",
		type : "POST",
		data : {deleteAds : 1, type : $(this).attr("data-type"), id : $(this).attr("data-idP")}
	});
});


$(".closeWindow").click(function(){
	$(this).parent().slideUp();
});
$("#editMySettings").submit(function(event){
	event.preventDefault();
	if($("#passwordEditForm").val() != "" && $("#passwordEditForm_verif").val() != "" && $("#email").val() != "" && $("#telephone").val() != ""){
		if($("#passwordEditForm").val() == $("#passwordEditForm_verif").val()){
			$.ajax({url : "profil",
				type : "POST",
				data : $("#editMySettings").serialize()
			}).done(function(){
				$("#erreurEdit").html("<span class='red'>Votre compte a bien été modifié.</span>");
				$("#erreurEdit").slideDown();
			});
		}
		else{
			$("#passwordEditForm").val("");
			$("#passwordEditForm_verif").val("");
			$("#erreurEdit").html("<span class='red'>Les passwords ne correspondent pas!</span>");
			$("#erreurEdit").slideDown();
		}
	}
	else{
		$("#erreurEdit").html("<span class='red'>Veuillez remplir tous les champs!</span>");
		$("#erreurEdit").slideDown();
	}
});


$("#downSettings").click(function(){
	if($("#wrap_settings").css('display') != 'none'){
		$("#wrap_settings").slideUp();
		$(this).attr("src", "img/downarrow2.png");
	}
	else{
		$("#wrap_settings").slideDown();
		$(this).attr("src", "img/uparrow2.png");
	}
});

$(".downTitleSettings").click(function(){
	if($("#wrap_settings").css('display') != 'none'){
		$("#wrap_settings").slideUp();
		$(this).next().attr("src", "img/downarrow2.png");
	}
	else{
		$("#wrap_settings").slideDown();
		$(this).next().attr("src", "img/uparrow2.png");
	}
});