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
		<link rel="stylesheet" type="text/css" href="css/addChamp.css">
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
			<form  method="post" action="addChampion">
				<div class="division" id="infoNomChamp">							
					<div>
						Nom du champion : <input type="text" name="name" placeholder="Nom Champion" required>					
					</div>
					
					<div>
						Sous nom du champion : <input type="text" name="nickname" placeholder="Sous Nom Champion" required>
					</div>	
					
					<div>
						Chemin de l'icone du champion : <input type="text" name="iconePathChamp" required>
					</div>			
					
					<div>
						Chemin de l'image du champion : <input type="text" name="imagePathChamp" required>
					</div>
					
					<div>
						Prix en RP du champion : <input type="text" name="price" placeholder="975" required> RP
					</div>
				</div>
				
				<div class="division" id="odmdChamp">
					<div>
						Offense : <SELECT name="offense">
							<OPTION VALUE="0">0</OPTION>
							<OPTION VALUE="1">1</OPTION>
							<OPTION VALUE="2">2</OPTION>
							<OPTION VALUE="3">3</OPTION>
							<OPTION VALUE="4">4</OPTION>
							<OPTION VALUE="5">5</OPTION>
							<OPTION VALUE="6">6</OPTION>
							<OPTION VALUE="7">7</OPTION>
							<OPTION VALUE="8">8</OPTION>
							<OPTION VALUE="9">9</OPTION>
							<OPTION VALUE="10">10</OPTION>
						</SELECT>
					</div>
					
					<div>
						Defense : <SELECT name="defense">
							<OPTION VALUE="0">0</OPTION>
							<OPTION VALUE="1">1</OPTION>
							<OPTION VALUE="2">2</OPTION>
							<OPTION VALUE="3">3</OPTION>
							<OPTION VALUE="4">4</OPTION>
							<OPTION VALUE="5">5</OPTION>
							<OPTION VALUE="6">6</OPTION>
							<OPTION VALUE="7">7</OPTION>
							<OPTION VALUE="8">8</OPTION>
							<OPTION VALUE="9">9</OPTION>
							<OPTION VALUE="10">10</OPTION>
						</SELECT>
					</div>
					
					<div>
						Magie : <SELECT name="magie">
							<OPTION VALUE="0">0</OPTION>
							<OPTION VALUE="1">1</OPTION>
							<OPTION VALUE="2">2</OPTION>
							<OPTION VALUE="3">3</OPTION>
							<OPTION VALUE="4">4</OPTION>
							<OPTION VALUE="5">5</OPTION>
							<OPTION VALUE="6">6</OPTION>
							<OPTION VALUE="7">7</OPTION>
							<OPTION VALUE="8">8</OPTION>
							<OPTION VALUE="9">9</OPTION>
							<OPTION VALUE="10">10</OPTION>
						</SELECT>
					</div>
					
					<div>
						Difficulte : <SELECT name="difficulte">
							<OPTION VALUE="0">0</OPTION>
							<OPTION VALUE="1">1</OPTION>
							<OPTION VALUE="2">2</OPTION>
							<OPTION VALUE="3">3</OPTION>
							<OPTION VALUE="4">4</OPTION>
							<OPTION VALUE="5">5</OPTION>
							<OPTION VALUE="6">6</OPTION>
							<OPTION VALUE="7">7</OPTION>
							<OPTION VALUE="8">8</OPTION>
							<OPTION VALUE="9">9</OPTION>
							<OPTION VALUE="10">10</OPTION>
						</SELECT>
					</div>
				</div>
				
				<div class="division">
					<table>
						<tr>
							<td>
								Vie : <input type="text" name="vie" placeholder="0" required>
							</td>	
							<td>
								Vie par level : <input type="text" name="vieLevel" placeholder="0.0" required>
							</td>
						</tr>
						<tr>
							<td>
								Mana : <input type="text" name="mana" placeholder="0" required>
							</td>
							<td>
								Mana par level : <input type="text" name="manaLevel" placeholder="0.0" required>
							</td>
						</tr>
						<tr>
							<td>
								Attaque : <input type="text" name="attaque" placeholder="0.0" required>
							</td>
							<td>
								Attaque par level : <input type="text" name="attaqueLevel" placeholder="0.0" required>
							</td>
						</tr>
						<tr>
							<td>
								Vitesse d'attaque : <input type="text" name="vitesseAttaque" placeholder="0.0" required>
							</td>
							<td>
								Vitesse d'attaque par level : <input type="text" name="vitesseAttaqueLevel" placeholder="0.0" required>
							</td>
						</tr>
						<tr>					
							<td>
								Regen vie : <input type="text" name="regenVie" placeholder="0.0" required>
							</td>
							<td>
								Regen vie par level : <input type="text" name="regenVieLevel" placeholder="0.0" required>
							</td>
						</tr>
						<tr>
							<td>
								Regen mana : <input type="text" name="regenMana" placeholder="0.0" required>
							</td>
							<td>
								Regen mana par level : <input type="text" name="regenManaLevel" placeholder="0.0" required>
							</td>
						</tr>
						<tr>
							<td>
								Armure : <input type="text" name="armure" placeholder="0.0" required>
							</td>
							<td>
								Armure par level : <input type="text" name="armureLevel" placeholder="0.0" required>
							</td>
						</tr>
						<tr>
							<td>
								Resistance magique : <input type="text" name="magicRes" placeholder="0.0" required>
							</td>
							<td>
								Resistance magique par level : <input type="text" name="magicResLevel" placeholder="0.0" required>
							</td>
						</tr>
						<tr>
							<td>
								Vitesse de deplacement : <input type="text" name="vitesse" placeholder="0" required>
							</td>
						</tr>
					</table>
				</div>
				
				<div class="division">
					<table>
						<tr>
							<td>
								Passive : <input type="text" name="passive" placeholder="Passive" required>
							</td>
							
							<td>
								Chemin de l'image 'Passive' : <input type="text" name="imagePathP" required>
							</td>
						</tr>
						
						<tr>
							<td>
								Q : <input type="text" name="q" placeholder="Q" required>
							</td>
							
							<td>
								Chemin de l'image 'Q' : <input type="text" name="imagePathQ" required>
							</td>
						</tr>
						
						<tr>
							<td>
								W : <input type="text" name="w" placeholder="W" required>
							</td>
							
							<td>
								Chemin de l'image 'W' : <input type="text" name="imagePathW" required>
							</td>
						</tr>
						
						<tr>
							<td>
								E : <input type="text" name="e" placeholder="E" required>
							</td>
							
							<td>
								Chemin de l'image 'E' : <input type="text" name="imagePathE" required>
							</td>
						</tr>
						
						<tr>
							<td>
								R : <input type="text" name="r" placeholder="R" required>
							</td>
							
							<td>
								Chemin de l'image 'R' : <input type="text" name="imagePathR" required>
							</td>
						</tr>
					</table>
				</div>
				
				<div id="submit">
					<input type="submit" value="Enregistrer">
					<input type="reset" value="Effacer">
				</div>
			</form>
		</div>
		
		<footer>
			<div>
				Meow LoL - Projet Dev Web - Charles Moreel
			</div>
		</footer>
	</body>	
</html>