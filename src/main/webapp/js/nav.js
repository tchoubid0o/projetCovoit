$(document).ready( function ()
{	
	$(".down").click(function(){
		if($(this).next(".wrapProfil").css('display') != 'none'){
			$(this).next(".wrapProfil").slideUp();
			$(this).attr("src", "img/downarrow.png");
		}
		else{
			$(this).next(".wrapProfil").slideDown();
			$(this).attr("src", "img/uparrow.png");
		}
	});
	
	$(".downTitle").click(function(){
		if($(this).next().next(".wrapProfil").css('display') != 'none'){
			$(this).next().next(".wrapProfil").slideUp();
			console.log($(this).next());
			$(this).next().attr("src", "img/downarrow.png");
		}
		else{
			$(this).next().next(".wrapProfil").slideDown();
			$(this).next().attr("src", "img/uparrow.png");
		}
	});
});	