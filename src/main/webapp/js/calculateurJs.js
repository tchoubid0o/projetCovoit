var prixSelect = $("#prixForm option:selected");
var km = $("#km").val();
var prixCalc = 0;
$("#prixForm").change(function(){
	prixSelect = $("#prixForm option:selected").val();
	km = $("#km").val();
	if(km == null || km == ""){km = 0;}
	prixCalc = (parseFloat(prixSelect)*parseFloat(km))/100;

	$("#prixTotal").val(prixCalc+"€");
});

$("#km").keyup(function(){

	prixSelect = $("#prixForm option:selected").val();
	km = $(this).val();
	if(km == null || km == ""){km = 0;}

	prixCalc = (parseFloat(prixSelect)*parseFloat(km))/100;

	$("#prixTotal").val(prixCalc+"€");
});