<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section class="wrapper3" id="wrapperInsc">
	<div class="width1000">
		<div style="text-align: center;">
			<span class="titleAbout">Nouveau trajet</span>
			<form action="proposer" method="post">
				<label for="villeDepart">Ville de départ :</label>
				<div>
					<input type="text" name="villeDepart" id="villeDepart" style="line-height: 40px; height: 30px;" placeholder="Ville de Départ" />
				</div>
				
				<label for="villeArrivee">Ville d'arrivée :</label><br />
				<div>
					<input type="text" name="villeArrivee" id="villeArrivee" style="line-height: 40px; height: 30px;" placeholder="ville d'Arrivée" />
				</div>
				<label for="etapes">Etapes éventuelles :</label><br />
				<div>
					<div id="dynamicInput">
          				Etape 1<br><input type="text" name="etapes">
     				</div>
     				<input type="button" value="Ajouter une autre étape" style="font-family: Verdana,Arial,sans-serif;font-size: 12px;" onClick="addInput('dynamicInput');">
					<script>
					var counter = 1;
					var limit = 15;
					function addInput(divName){
					     if (counter == limit)  {
					          alert("Vous avez atteint la limite des " + counter + " étapes possibles.");
					     }
					     else {
					          var newdiv = document.createElement('div');
					          newdiv.innerHTML = "Etape " + (counter + 1) + " <br><input type='text' name='etapes'>";
					          document.getElementById(divName).appendChild(newdiv);
					          counter++;
					     }
					}
					</script>
				</div>
				<label for="date">Date :</label><br /> 
					<input type="text" class="datepicker" name="date" id="date" required/><br /> 
					
				<label>Heure de départ :</label><br />
				<div>
					<select id="heure" name="heure">
							<option value="00">00</option>
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
						<c:forEach var="j" begin="10" end="23">
							<option value="<c:out value="${j}"/>"><c:out value="${j}"/></option>
						</c:forEach>
					</select>
					<span> h</span>
					<select id="minute" name="minute">
							<option value="00">00</option>
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
						<c:forEach var="i" begin="10" end="59">
							<option value="<c:out value="${i}"/>"><c:out value="${i}"/></option>
						</c:forEach>
					</select>
					<span> min</span>
				</div>
				<label for="prix">Prix par passager :</label><br />
				<div>
					<input type="text" name="prix" id="prix" style="line-height: 40px; height: 30px;" placeholder="prix" />
				</div>
				<label for="nbPlace">Nombre de places :</label><br />
				<div>
					<input type="text" name="nbPlace" id="nbPlace" style="line-height: 40px; height: 30px;" placeholder="Nb places" />
				</div>
				<textarea placeholder="Commentaire" name="comment"></textarea>
				<div style="margin: auto;">
					<input class="submit"
						style="background-color: #ea3c3d; border: 1px solid white; color: white; padding-left: 15px; padding-right: 15px; height: 35px; line-height: 40px;"
						type="submit" value="Poster" id="submit" />
				</div>
				
			</form>
		</div>
	</div>
</section>

<section class="wrapper3">
	<div class="width1000">
		<div style="text-align: center;">
			<div style="${empty erreurs ? 'color: green;' : 'color: red;'}">${resultat}</div>
		</div>
	</div>
</section>

<jsp:include page="footer.jsp" />