<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section class="wrapper3" id="wrapperInsc">
	<div class="width1000">
		<div style="text-align: center;">
			${villes}
			<span class="titleAbout">Poster une recherche de Covoiturage</span>
			<form action="rechercher" method="post">
				<label for="villeDepart">Ville de départ :</label>
				<div>
					<input type="text" name="villeDepart" id="villeDepart" style="line-height: 40px; height: 30px;" placeholder="Ville de Départ" />
				</div>
				
				<label for="villeArrivee">Ville d'arrivée :</label><br />
				<div>
					<input type="text" name="villeArrivee" id="villeArrivee" style="line-height: 40px; height: 30px;" placeholder="ville d'Arrivée" />
				</div>
				<label for="date">Date :</label><br /> 
					<input type="text" class="datepicker" name="date" id="date" required/><br /> 
					
				<label>Heure de départ :</label><br />
				<div>
					<select id="heure" name="heure">
						<c:forEach var="j" begin="0" end="23">
							<option value="<c:out value="${j}"/>"><c:out value="${j}"/></option>
						</c:forEach>
					</select>
					<span> h</span>
					<select id="minute" name="minute">
						<c:forEach var="i" begin="0" end="59">
							<option value="<c:out value="${i}"/>"><c:out value="${i}"/></option>
						</c:forEach>
					</select>
					<span> min</span>
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