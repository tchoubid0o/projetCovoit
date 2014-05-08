<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section class="wrapper3" id="wrapperInsc">
	<div class="width1000">
		<div style="text-align: center; padding-top: 15px;">
			<c:if test='${user != null }'>
				<span class="titleAbout">Profil de ${user.prenom} ${user.nom}</span>
				
				<div id="informationsUser">
					<span>Nom: ${user.nom}</span><br/>
					<span>Prénom: ${user.prenom}</span><br/>
					<span>Email: ${user.email}</span><br/>
					<span>Téléphone: ${user.telephone}</span><br/>
					<span>Date d'inscription: ${user_date.substring(8, 10)}/${user_date.substring(5, 7)}/${user_date.substring(0, 4)}</span><br/>					
				</div>
			</c:if>
		</div>
	</div>
</section>


<jsp:include page="footer.jsp" />