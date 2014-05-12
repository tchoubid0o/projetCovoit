$(document).ready(function() {
	function getCountryFrom() {
		var myselect = $("#countryFrom").val();
		$("#label_country_from").html('<img src="img/flags/' + myselect + '.png" alt="">&nbsp;<img class="arrowdownChoose" src="img/arrowdown.png" alt="">');
	}
	function getCountryTo() {
		var myselect = $("#countryTo").val();
		$("#label_country_to").html('<img src="img/flags/' + myselect + '.png" alt="">&nbsp;<img class="arrowdownChoose" src="img/arrowdown.png" alt="">');
	}
	function getTownFrom() {
		var myselect = $("#townFrom").find('option:selected').text();
		$("#label_town_from").html(myselect + '&nbsp;<img class="arrowdownChoose" src="img/arrowdown.png" alt="">');
	}
	function getTownTo() {
		var myselect = $("#townTo").find('option:selected').text();
		$("#label_town_to").html(myselect + '&nbsp;<img class="arrowdownChoose" src="img/arrowdown.png" alt="">');
	}
	$("#loginname").click(function() {
		if ($("#logintop").is(":hidden")) { /* Si le menu d'inscription est cachï¿½ alors lorsque l'on clique... */

			$("#logintop").slideDown("slow");  /* Permet de descendre le menu inscription */
			$('#global').css({'position': 'fixed', 'left': '0px', 'top': '0px', 'background-color': 'white', 'height': '100%', 'width': '100%', 'z-index': '100', 'opacity': '0.7'});
		}
		else {
			$("#logintop").slideUp("slow");
			$('#global').css({'position': 'fixed', 'left': '0px', 'top': '0px', 'background-color': '', 'height': '', 'width': '100%', 'z-index': '100', 'opacity': ''});
		}
	});

	$("#global").click(function() {	/* Si l'on clique hors des menus alors, on remonte tous et on enlï¿½ve l'opacitï¿½ du fond */

		$("#logintop").slideUp("slow");

		$('#global').css({'position': 'fixed', 'left': '0px', 'top': '0px', 'background-color': '', 'height': '', 'width': '100%', 'z-index': '100', 'opacity': ''});
	});

	$(window).scroll(function() {
		posScroll = $(document).scrollTop();

		280 <= posScroll ? $("#back-top").fadeIn() : $("#back-top").fadeOut();
	});

	$("#back-top").click(function(b) {
		b.preventDefault();
		$("html, body").animate({scrollTop: 0}, "slow");
		return false;
	});

	$("#newsletter_form").submit(function(event){
		event.preventDefault();
		if($("#newsletter_email").val() != ""){
			$.ajax({ url:"ajaxnewsletter", type:"POST", 
				data: $("#newsletter_form").serialize()
			}).done(function (response){		  		
				$("#newsletter_result").html("<div style='color: #ea3c3d; margin-top: 15px;'>"+response+"</div>");
				$("#newsletter_form").slideToggle();
				$("#newsletter_result").slideToggle();	
			})
			.fail(function (response){		
				$("#newsletter_result").html("<div style='color: #ea3c3d; margin-top: 15px;'>"+response+"</div>");
				$("#newsletter_result").slideToggle();
			});
		}else{
			$("#newsletter_result").html("<div style='color: #ea3c3d; margin-top: 15px;'>Vous devez renseigner une adresse email.</div>");
			$("#newsletter_result").show("slow");

		}
	}); 	

	$("#contact_form").submit(function(event){
		event.preventDefault(); 
		if($("#nomcontact").val() != "" && $("#emailcontact").val() != "" && $("#messagecontact").val() != ""){
			$.ajax({ url:"ajaxcontact", type:"POST", 
				data: $("#contact_form").serialize()
			}).done(function (response){		  		
				$("#contact_result").html("<div style='color: #ea3c3d; margin-top: 15px;'>"+response+"</div>");
				$("#contact_form").slideToggle();
				$("#contact_result").slideToggle();	
			})
			.fail(function (response){		
				$("#contact_result").html("<div style='color: #ea3c3d; margin-top: 15px;'>"+response+"</div>");
			});
		}else{
			$("#contact_result").html("<div style='color: #ea3c3d; margin-top: 15px;'>Vous devez renseigner tous les champs.</div>");
			$("#contact_result").show("slow");
		}
	}); 	
});