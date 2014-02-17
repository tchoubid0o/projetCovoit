$(document).ready( function ()
{	
	$("#champions").mouseenter(function(){
		$("#addChamp").slideDown(50);
	});
	
	$("#skins").mouseenter(function(){
		$("#addSkin").slideDown(50);
	});
	
	$("#champions").mouseleave(function(){
		$("#addChamp").slideUp(50);
	});
	
	$("#skins").mouseleave(function(){
		$("#addSkin").slideUp(50);
	});
});	