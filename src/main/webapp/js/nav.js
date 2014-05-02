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
});	