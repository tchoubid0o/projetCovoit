<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section class="wrapper3" id="wrapperInsc">
	<div class="width1000">
		<div style="text-align: center;">
			<span class="titleAbout">Trouver un trajet</span>
		</div>

			

				<table class="lastCars" style="text-align: center;">
					<tbody>
						<c:forEach var="proposition" begin="0" end="${propositions_size}"
				step="1" items="${propositions}">
						<tr>
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
			<h2 class="h2_right_content colorGray">Aucun résultat</h2>
		</c:if>

	</div>
</section>

<jsp:include page="footer.jsp" />