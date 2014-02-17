<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">	
	<head>
		<c:set var="focusOn" scope="request" value="accueil"/> 
		<meta http-equiv="Content-type" content="text/html;charset:UTF-8">
		<meta charset="UTF-8">
		<title>Meow LoL</title>
		<script src="//code.jquery.com/jquery-1.10.2.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="css/accueil.css">
		<link rel="stylesheet" type="text/css" href="css/nav.css">		
	</head>
	
	<body>		
		<header>	
			<jsp:include page= "nav.jsp"/>
		</header>	
		
		<div id="font">
			<img src="img/font.jpg" alt="font"/>
		</div>
		
		<div id="content">
			<p>
				Bienvenue sur le site Meow Lol :</br></br>Visualisation des Champions de League of Legends et de leurs skins</br></br>N.B.:ouvrir la note (src/main/note/note.txt) pour trouver de leger renseignement concernant ce projet 
			</p>
		</div>
		
		<footer>
			<div>
				Meow LoL - Projet Dev Web - Charles Moreel
			</div>
		</footer>
	</body>
</html>