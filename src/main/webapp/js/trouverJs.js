$(".reservation_form").submit(function (event){
	event.preventDefault();
	$(this).css("display", "none");
	$(this).parent().children(".resultReserv").html("<div style='color: #ea3c3d;'>L'annonce a été réservée.</div>");
	$(this).parent().children(".resultReserv").slideDown();
	$.ajax({ url:"ajaxreserver", type:"POST", 
		data: $(this).serialize()
	});
});

$(".seeMore").click(function(event){

	var type= $(this).attr("data-type");
	var id = $(this).attr("data-id");
	var login = $(this).attr("data-login");					

	event.preventDefault();
	if(type == "offers"){
		$.ajax({ dataType: "json",url:"etapes", type:"POST", 
			data: "type="+type+"&seeMoreInfos=1&id="+id
		}).done(function(data){
			var etapesTemp = "";
			for (var i = 0; i < data.length; ++i) {
				etapesTemp += ""+data[i].nomVille+"&nbsp;&nbsp;<img src='img/rightarrow.png' alt=''>&nbsp;&nbsp;";
			}
			$(".etapesMore"+id).html(etapesTemp);
		});
	}

	$.ajax({ dataType: "json",url:"getuser", type:"POST", 
		data: "login="+login+"&seeMoreInfos=1"
	}).done(function(data){
		$(".userAddMore"+id).html(""+data.prenom+" "+data.nom[0]+".");
	});

	if($(this).parent().parent().next("tr").css('display') != 'none'){
		$(this).parent().parent().next("tr").hide();
		if(type == "offers"){
			$(this).parent().parent().next("tr").next("tr").hide();
		}
		$(this).attr("src", "img/downarrow2.png");
	}
	else{
		$(this).parent().parent().next("tr").show();
		if(type == "offers"){
			$(this).parent().parent().next("tr").next("tr").slideDown();
		}
		$(this).attr("src", "img/uparrow2.png");
	}
});