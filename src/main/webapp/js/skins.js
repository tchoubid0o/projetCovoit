var supprimerChampion = function(libelleChampion) {
	$.post("champions", {
		libelle : libelleChampion
	}).done(function() {
		$("#"+libelleChampion).remove();
	});
};


function GetURLParameter(param){
	var pageURL = window.location.search.substring(1);
	var parameterName = pageURL.split('=');
	
	if(parameterName[0] == param){
		return parameterName[1];
	}
};



$(document).ready( function ()
{
	$(".triangle").click(function(){
		if($(this).attr("src")=="img/triangleDown.png")
		{
			$(this).attr("src","img/triangleUp.png");
			$(this).parents().children(".skinsChampion").slideDown();			
		}
		else if($(this).attr("src")=="img/triangleUp.png")
		{
			$(this).attr("src","img/triangleDown.png");
			$(this).parents().children(".skinsChampion").slideUp();
		}		
	});	
	
	
	
	$(".addSkin").click(function(){
		if($(this).parent().children("button").text()=="Ajouter un skin"){
			$(this).parent().children("button").text("Annuler");
		}
		else{
			$(this).parent().children("button").text("Ajouter un skin");
		}
		$(this).parent().children("form").toggle();
	});
	
	
	
	var idChamp = null;
	idChamp = GetURLParameter('id');

	if(idChamp != null)
	{
		$("#"+idChamp).children(".skinsChampion").slideDown();
		$("#"+idChamp).children(".front").children("div").children(".triangle").attr("src","img/triangleUp.png");
	}
	
	
	$(".formAddSkin").submit(function(event) {
		$.post("skins", {libelleChampion : $(this).children("div").children(".libelleChampion").val(),nomSkin : $(this).children("div").children(".nomSkin").val(), imagePathSkin : $(this).children("div").children(".imagePathSkin").text(), priceSkin : $(this).children("div").children(".priceSkin").val(), numeroSkin : $(this).children("div").children(".numeroSkin").val()});
	});
	
	
	
	$(".removeChamp").click(function(){
		supprimerChampion($(this).parent().parent().attr("id"));
	});
});