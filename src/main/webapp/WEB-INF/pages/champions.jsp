<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">	
	<head>
		<c:set var="focusOn" scope="request" value="champions"/> 
		<meta http-equiv="Content-type" content="text/html;charset:UTF-8">
		<meta charset="UTF-8">
		<title>Meow LoL</title>
		<script src="//code.jquery.com/jquery-1.10.2.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/champions.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="css/champions.css">
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
				<section class="champion" id="${datChampion.champion.libelle}">
					<a href="skins?id=${datChampion.champion.libelle}#${datChampion.champion.libelle}">
						<div class="imgChamp">
							<img src="${datChampion.listSkins[0].imagePath}" alt="${datChampion.champion.libelle}" title="${datChampion.champion.nom}"/>
						</div>
					</a>
					
					<div class="backgroundChamp">
						<div class="viewChamp">
							<div class ="abilities">
								<h2>Competences</h2>
								
								<c:forEach var="ability" items="${datChampion.listAbilities}">
									<img src="${ability.imagePath}" alt="${datChampion.champion.libelle}+${ability.lettreAbility}" title="${ability.lettreAbility} : ${ability.nomAbility}" />
								</c:forEach>
							</div>
							
							<div class="stats">
								<h2>Statistiques</h2>
								<table>
									<tr>
										<td class="libelle"> Attaque : </td>
										<td><meter min="0" max="10" value="${datChampion.champion.offense}" title="attaque">attaque</meter></td>
									</tr>
									<tr>
										<td class="libelle"> Defense : </td>
										<td><meter min="0" max="10" value="${datChampion.champion.defense}" title="defense">defense</meter></td>
									</tr>
									<tr>
										<td class="libelle"> Magie :  </td>
										<td><meter min="0" max="10" value="${datChampion.champion.magie}" title="magie">magie</meter></td>
									</tr>
									<tr>
										<td class="libelle"> Difficulte : </td>
										<td><meter min="0" max="10" value="${datChampion.champion.difficulte}" title="difficulte">difficulte</meter></td>
									</tr>
								</table>
							</div>
							
							<div class="siteOfficiel">
								<a href="http://gameinfo.euw.leagueoflegends.com/en/game-info/champions/${datChampion.champion.libelle}" title="Lien site officiel">Lien site officiel : ${datChampion.champion.nom}</a>
							</div>
							
							<button type="button" class="removeChamp">Supprimer ${datChampion.champion.nom}</button>
						</div>
						
						<div class="caracChamp">
							<div class="contentCarac">
								<table>
									<tr>
										<td class="libelle">Vie : </td> 
										<td>${datChampion.champion.vie} (+${datChampion.champion.vieLevel}/lvl)</td>
										<td class="libelle">Mana : </td> 
										<td>${datChampion.champion.mana} (+${datChampion.champion.manaLevel}/lvl)</td>
									</tr>
									
									<tr>
										<td class="libelle">Attaque physique : </td> 
										<td>${datChampion.champion.attaque} (+${datChampion.champion.attaqueLevel}/lvl)</td>
										<td class="libelle">Vitesse d'attaque : </td>
										<td>${datChampion.champion.vitesseAttaque} (+${datChampion.champion.vitesseAttaqueLevel}%/lvl)</td>
									</tr>
									
									<tr>
										<td class="libelle">Regen. de vie : </td>
										<td>${datChampion.champion.regenVie} (+${datChampion.champion.regenVieLevel}/lvl)</td>
										<td class="libelle">Regen. de mana : </td>
										<td>${datChampion.champion.regenMana} (+${datChampion.champion.regenManaLevel}/lvl)</td>
									</tr>
									
									<tr>
										<td class="libelle">Armure : </td>
										<td>${datChampion.champion.armure} (+${datChampion.champion.armureLevel}/lvl)</td>
										<td class="libelle">Resistance magique : </td>
										<td>${datChampion.champion.magicRes} (+${datChampion.champion.magicResLevel}/lvl)</td>
									</tr>
									
									<tr>
										<td class="libelle">Vitesse de <br/>deplacement : </td>
										<td>${datChampion.champion.vitesse}</td>
									</tr>
								</table>
								
								<div class="siteOfficiel">
									<a href="http://gameinfo.euw.leagueoflegends.com/en/game-info/champions/${datChampion.champion.libelle}" title="Lien site officiel">Lien site officiel : ${datChampion.champion.nom}</a>
								</div>			
							</div>	
								
							<button type="button" class="removeChamp">Supprimer ${datChampion.champion.nom}</button>				
						</div>
						
						<aside class="arrow">
							<img src="img/arrowToLeft.png" alt="arrow" title="Caracteristiques" />
						</aside>
					</div>
				</section>
			</c:forEach>			
			
			<a href="addChampion"id="addChammp">
				<button type="button">Ajouter un champion</button>	
			</a>	
		</div>
		
		<footer>
			<div>
				Meow LoL - Projet Dev Web - Charles Moreel
			</div>
		</footer>
	</body>
</html>

