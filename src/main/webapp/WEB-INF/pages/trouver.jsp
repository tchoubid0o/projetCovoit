<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section class="wrapper3" id="wrapperInsc">
	<div class="width1000">
		
		<!-- Trouver un conducteur -->
	
		<div style="text-align: center;">
			<span class="titleAbout">Trouver un trajet</span>
		</div>

				<table class="lastCars" style="text-align: center;">
					<tbody>
						<c:forEach var="proposition" begin="0" end="${propositions_size}"
				step="1" items="${propositions}">
						<tr>
							<td><img src="img/car.png" alt="" /></td>
							<td>${proposition.villeDepart}</td>
							<td><img src="img/rightarrow.png" alt=""></td>
							<td>${proposition.villeArrivee}</td>
							<td>${proposition.prix}€</td>
							<td>Nombre de places: ${proposition.nbPlace}</td>
							<td>${proposition.dateEtHeureTrajet} à ${proposition.heure}h${proposition.minute}min</td>
							<td><form method="post" action="reserver"><input type="hidden" name="idAnnonceProposition" value="${proposition.idAnnonceProposition}" /><input type="submit" value="Réserver" class="submitContactForm" style="margin-bottom: 10px; height: auto; border: none;"></form></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			
		<c:if test="${propositions_size == 0 }">
			<div class="lastCars center">Aucun résultat</div>
		</c:if>

		<!-- Trouver un passager -->
		
		<div style="text-align: center;">
			<span class="titleAbout">Trouver un passager</span>
		</div>

				<table class="lastCars" style="text-align: center;">
					<tbody>
						<c:forEach var="propositionp" begin="0" end="${propositionsp_size}"
				step="1" items="${propositionsp}">
						<tr>
							<td><img src="img/passenger.png" alt="" /></td>
							<td>${propositionp.villeDepartRecherche}</td>
							<td><img src="img/rightarrow.png" alt=""></td>
							<td>${propositionp.villeArriveeRecherche}</td>
							<td>${propositionp.dateEtHeureRecherche} à ${propositionp.heure}h${propositionp.minute}min</td>
							<td><form method="post" action="reserver"><input type="hidden" name="idAnnonceProposition" value="${propositionp.idAnnonceRecherche}" /><input type="submit" value="Proposer" class="submitContactForm" style="margin-bottom: 10px; height: auto; border: none;"></form></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			
		<c:if test="${propositionsp_size == 0 }">
			<div class="lastCars center">Aucune annonce de passager.</div>
		</c:if>
		
	</div>
</section>


<jsp:include page="footer.jsp" />