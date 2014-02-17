<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav>
	<div id="menu">
		<div>
			<a href="http://i.imgur.com/Q3cUg29.jpg">
				<img src="img/logo.png" alt="logo" title="Meow LoL"/>
			</a>
		</div>
		
		<a href="accueil">
			<div <c:if test="${focusOn == 'accueil'}"> class="focus"</c:if>>
				Accueil
			</div>
		</a>
		
		<div id="champions">
			<a href="champions">
				<div <c:if test="${focusOn == 'champions'}"> class="focus"</c:if>>
					Champions
				</div>
			</a>	
			
			<a href="addChampion">
				<div id="addChamp">
					Ajouter Champion			
				</div>
			</a>	
		</div>
		
		<div id="skins">
			<a href="skins">
				<div <c:if test="${focusOn == 'skins'}"> class="focus"</c:if>>
					Skins
				</div>	
			</a>
		</div>
	</div>
</nav>