<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">	
	<head>
		<c:set var="focusOn" scope="request" value="skins"/> 
		<meta http-equiv="Content-type" content="text/html;charset:UTF-8">
		<meta charset="UTF-8">
		<title>Meow LoL</title>
		<script src="//code.jquery.com/jquery-1.10.2.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/skins.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="css/skins.css">
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
			<c:forEach var="datChampion" items="${listDatChampions}">
				<div class="skin" id="${datChampion.champion.libelle}">
					<div class="front">
						<a href="champions#${datChampion.champion.libelle}">
							<div>
								<img src="${datChampion.champion.imagePath}" alt="${datChampion.champion.libelle}" title="${datChampion.champion.nom}" class="imageChampion"/>
							</div>					
							
							<div class="name">
								${datChampion.champion.nom}
							</div>
							
							<div class="nickname">
								- ${datChampion.champion.sousNom}
							</div>
						</a>						
						
						<div>
							<img src="img/triangleDown.png" alt="triangle" class="triangle"/>
						</div>
						
						<button type="button" class="removeChamp">Supprimer ${datChampion.champion.nom}</button>
					</div>					
					
					<div class="skinsChampion">
						<c:forEach var="skin" items="${datChampion.listSkins}">
							<a href="champions#${datChampion.champion.libelle}">
								<div class="datSkin">
									<div class="skinName">
										${skin.nomSkin}
									</div>
									
									<img src="${skin.imagePath}" alt="${datChampion.champion.nom}+skin+${skin.numeroSkin}" title="${skin.nomSkin}"/>
									
									<div class="skinPrice">
										${skin.price} RP
									</div>
									<c:set var="numeroSkin" value="${skin.numeroSkin}" scope="page"></c:set>
								</div>
							</a>	
						</c:forEach>
							
							<div class="ajoutSkin">
								<button type="button" class="addSkin">Ajouter un skin</button>
								
								<form action="skins" method="POST" class="formAddSkin">
									<div>
										Nom du skin :  </br><input type="text" name="nomSkin" class="nomSkin" placeholder="Skin ${datChampion.champion.nom}" required>
									</div>
									
									<div>
										Chemin de l'image : </br><input type="text" name="imagePathSkin" class="imagePathSkin" required>
									</div>
									
									<div>
										Prix du skin :  </br><input type="text" name="priceSkin" class="priceSkin" placeholder="975" required> RP
									</div>
									
									<div>
										<input type="text" name="libelleChampion" class="libelleChampion" value="${datChampion.champion.libelle}">
									</div>
									
									<div>
										<input type="text" name="numeroSkin" class="numeroSkin" value="<c:out value="${numeroSkin}"></c:out>">
									</div>
									
									<div>
										<input type="submit" value="Ajouter" class="submit">
										<input type="reset" value="Effacer">
									</div>
								</form>
							</div>
							
							<div style="clear:both;"></div>
						</div>					
					<div style="clear:both;"></div>
				</div>	
			</c:forEach>	
		</div>
		
		<footer>
			<div>
				Meow LoL - Projet Dev Web - Charles Moreel
			</div>
		</footer>
	</body>	
</html>