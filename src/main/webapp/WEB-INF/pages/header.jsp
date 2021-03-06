<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Covoiturage HEI</title>
<meta charset="UTF-8">
<!-- Auteur de la page -->
<meta name="author" content="Tchoubid0o" />
<!-- Description de la page -->
<meta name="description" content="Covoiturage HEI" />
<!-- Mots-clés de la page -->
<meta name="keywords" content="Covoiturage, HEI" />

<link rel="stylesheet" media="screen" type="text/css" title="Design"
	href="css/design.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<!-- Datepicker -->
<link rel="stylesheet" type="text/css"
	href="js/datepicker/jquery-ui.css">
<link rel="stylesheet" type="text/css"
	href="js/datepicker/demos.css">
<script src="js/nav.js"></script>
<!-- <script src="js/datepicker/jquery.ui.core.js"></script>
<script src="js/datepicker/jquery.ui.widget.js"></script>
<script src="js/datepicker/jquery.ui.datepicker.js"></script>--> 
<script src="js/datepicker/jquery.ui.datepicker-fr.js"></script>
<script>
	$(function() {
		$(".datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>
</head>

<body>
	<div id="logintop">

		<div
			style="background-color: #353b44; height: 50px; text-align: center; line-height: 50px; color: white; font-size: 1.1em; font-family: calibri;">
			Connexion</div>
		<div class="loginh" style="text-align: left; padding: 25px;">
			<div
				style="color: #8c9197; font-size: 18px; line-height: 15px; margin-bottom: 5px;">Connectez-vous
				rapidement pour accéder à toutes les fonctionnalitées du site!</div>
			<form action="connexion" method="post">
				<div>
					<input class="iconForm" type="text" name="login" id="login"
						style="border-bottom: 1px solid #dfdede; background-position: 5px -10px !important;"
						placeholder="Identifiant" />
				</div>
				<div>
					<input class="iconForm" type="password" name="password"
						id="password" style="background-position: 5px -60px !important;"
						placeholder="Mot de passe" />
				</div>
				<input type="hidden" name="connexion" value="1" />
				<div style="margin: auto;">
					<input class="submit" type="submit" value="Login !"
						style="margin-top: 15px; border: none; width: 100%; cursor: pointer; color: #fff; border-radius: 4px; padding-top: 10px; background-color: #ea3c3d; text-transform: none; text-decoration: none; font-weight: 600; -moz-transition: background-color 0.35s linear; -webkit-transition: background-color 0.35s linear; transition: background-color 0.35s linear;"
						id="submit2" />
				</div>
				<div
					style="color: #ea3c3d; font-size: 18px; line-height: 15px; margin-top: 15px; text-align: center;">
					<i class="helpIcon"></i> Mot de passe oublié?
				</div>
			</form>
		</div>

	</div>
	<header>
		<div id="nav">
			<div id="leftNav"><a href="accueil" style="color: white;font-size: 30px;">CovoiturageHEI</a></div>
			<div id="rightNav">
				<ul>
					<li><a href="accueil" class="active">Accueil</a></li>
					<%
						if (request.getSession().getAttribute("login") == null) {
					%>
					<li><a href="">A propos</a></li>
					<%
						}
					%>
					<li><a href="trouver">Trouver un trajet</a></li>
					<%
						if (request.getSession().getAttribute("login") != null) {
					%>
					<li><a href="proposer">Publier un trajet</a></li>
					<li><a href="rechercher">Publier une recherche</a></li>
					<%
						}
					%>
					<%
						if (request.getSession().getAttribute("login") == null) {
					%>
					<li><a href="inscription">Inscription</a></li>
					<li class="borderli"><span id="loginname" class="white"
						style="cursor: pointer;"><img src="img/user.png" alt="" />&nbsp;Connexion</span></li>
					<%
						} else {
					%>
					<li><a href="profil">Profil</a></li>
					<li class="borderli"><a href="deconnexion" class="white"><img
							src="img/user.png" alt="" />&nbsp;Deconnexion</a></li>
					<%
						}
					%>
				</ul>
			</div>
			<div style="clear: both;"></div>
		</div>

		<div class="width1000">
			<div id="slideTitle">Trouver vite votre covoiturage</div>
			<div id="slideDesc">La plus grande communauté de covoiturage
				réservé uniquement aux étudiants d’HEI</div>
			<div class="sepa"></div>

			<div class="slideDown">
				<a href=""><img src="img/down.png" alt="" /></a>
			</div>
		</div>
	</header>