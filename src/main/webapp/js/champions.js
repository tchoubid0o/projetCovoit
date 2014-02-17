var supprimerChampion = function(libelleChampion) {
	$.post("champions", {
		libelle : libelleChampion
	}).done(function() {
		$("#"+libelleChampion).remove();
	});
};




$(document).ready( function ()
{
	$(".arrow").click(function(){
		if($(this).children("img").attr("src")=="img/arrowToLeft.png")
		{
			$(this).animate({
				right:"270",
				opacity:"0.0"
			},600,function(){
				$(this).children("img").attr("src","img/arrowToRight.png");
				$(this).children("img").attr("title","Vue sur le champion");
				$(this).animate({
					right:"612",
					opacity:"1.0"
				},600);
			});
			
			$(this).parent().children(".viewChamp").animate({
				opacity:"0.0"
			},600,function(){
				$(this).hide();
				$(this).parent().children(".caracChamp").show();
				$(this).parent().children(".caracChamp").animate({
					opacity:"1.0"
				},600);
			});
			
		}
		else if($(this).children("img").attr("src")=="img/arrowToRight.png")
		{
			$(this).animate({
				right:"270",
				opacity:"0.0"
			},600,function(){
				$(this).children("img").attr("src","img/arrowToLeft.png");
				$(this).children("img").attr("title","Caracteristiques");
				$(this).animate({
					right:"3",
					opacity:"1.0"
				},600);
			});
			
			$(this).parent().children(".caracChamp").animate({
				opacity:"0.0"
			},600,function(){
				$(this).hide();
				$(this).parent().children(".viewChamp").show();
				$(this).parent().children(".viewChamp").animate({
					opacity:"1.0"
				},600);
			});
		}
	});

	
	$(".removeChamp").click(function(){
		supprimerChampion($(this).parent().parent().parent().attr("id"));
	});
	
});