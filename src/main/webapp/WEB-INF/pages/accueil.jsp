<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

        <section class="wrapper1">
            <div class="width1000">
                <div class="searchcar">
                    <form method="post" class="searchForm" action="accueil#SearchResult">
                        <div class="country">
                            <span class="label_country" id="label_country_from">
                                <img src="img/flags/fr.png" alt="">&nbsp;<img class="arrowdownChoose" src="img/arrowdown.png" alt="">
                            </span>
                            <select name="paysFrom" onChange="getCountryFrom()" id="countryFrom">
                                <option value="fr">France</option>
                                <!-- <option value="de">Allemagne</option> -->
                            </select>
                        </div>
                        
                        	${villes}
                            <!-- 
                            <div class="town">
                            <span class="label_town" id="label_town_from">
                                Toutes les villes &nbsp;<img class="arrowdownChoose" src="img/arrowdown.png" alt="">
                            </span> 
                            </div>-->
                            <input type="text" style="float: left;width: 258px;margin-right: 5px;border: none;height: 39px;line-height: 50px;padding-left: 15px;" name="villeDepart" id="villeDepart" style="line-height: 40px; height: 30px;" placeholder="Ville de Départ" />
                        
                        <div class="country" style="margin-left: 10px;">
                            <span class="label_country" id="label_country_to">
                                <img src="img/flags/fr.png" alt="">&nbsp;<img class="arrowdownChoose" src="img/arrowdown.png" alt="">
                            </span>
                            <select name="paysTo" onChange="getCountryTo()" id="countryTo">
                                <option value="fr">France</option>
                                <!-- <option value="de">Allemagne</option>  -->
                            </select>
                        </div>
                        <input type="text" name="villeArrivee" style="float: left;width: 258px;margin-right: 5px;border: none;height: 39px;line-height: 50px;padding-left: 15px;" id="villeArrivee" style="line-height: 40px; height: 30px;" placeholder="Ville d'Arrivée" />
                        <input type="hidden" name="searchCarProp" value="1"/>
                        <input class="submitSearchCar" type="submit" value="Rechercher" />
                    </form>
                </div>

                <div id="aboutCovoit">
                    <div class="leftColumn">
                        <div class="columnInside">
                            <img src="img/rapide.png" alt="" />
                            <div class="columnheader">Rapide</div>
                            Après une simple inscription CovoiturageHEI vous permettra de trouver rapidement LE covoiturage désiré.<br/>
                        </div>
                    </div>
                    <div class="middleColumn">
                        <div class="columnInside">
                            <img src="img/trust.png" alt="" />
                            <div class="columnheader">Fiable</div>
                            Grâce à la réservation, conducteurs et passagers s'engagent à effectuer le trajet ensemble.<br/>
                        </div>
                    </div>
                    <div class="rightColumn">
                        <div class="columnInside">
                            <img src="img/usefull.png" alt="" />
                            <div class="columnheader">Pratique</div>
                            En quelques clics, réservez votre covoiturage, proposez vos annonces et prenez contact avec d'autres utilisateurs de CovoiturageHEI.
                        </div>
                    </div>
                    
                    <!-- POST FORM RECHERCHE ANNONCE -->
                    <c:if test="${listeAnnonces_size > 0 }">
                    <div id="SearchResult" style="margin-top: 10px;">
				<div class="titleAbout" style="text-align: center">Résultats de la recherche: 
						<span class="nbS">${listeAnnonces_size}</span> annonce(s)
				</div>
					</c:if> <c:if test="${listeAnnonces_size == 0}"> 
						<div class="titleAbout" style="text-align: center">Résultats de la recherche: aucun</div>
					</c:if>
				
				<div class="wrapProfil">
					<table class="lastCars" style="text-align: center;">
						<tbody>
							<c:forEach var="listeAnnonce" begin="0" end="${listeAnnonces_size}"
								step="1" items="${listeAnnonces}">
								<tr>
									<td><img src="img/car.png" alt="" /></td>
									<td>${listeAnnonce.villeDepart}</td>
									<td><img src="img/rightarrow.png" alt=""></td>
									<td>${listeAnnonce.villeArrivee}</td>
									<td>${listeAnnonce.prix}€</td>
									<td>Nombre de places: ${listeAnnonce.nbPlace}</td>
									<%--  String dateEtHeureTrajet --%>
									<td>${listeAnnonce.dateEtHeureTrajet.substring(8, 10)}/${listeAnnonce.dateEtHeureTrajet.substring(5, 7)}/${listeAnnonce.dateEtHeureTrajet.substring(0, 4)} à
										${listeAnnonce.heure}h${listeAnnonce.minute}min</td>
									<td><img class="seeMore" data-type="offers" data-id="${listeAnnonce.idAnnonceProposition}" data-login="${listeAnnonce.login}" src="img/downarrow2.png" alt="" /></td>
									<%if (request.getSession().getAttribute("login") != null) {%>
									<td>
										<form method="post" action="reserver" class="reservation_form">
											<input type="hidden" name="idAnnonceProposition" value="${listeAnnonce.idAnnonceProposition}" />
											<input type="hidden" name="reserverForm" value="1" />
											<input type="submit" value="Réserver" class="submitContactForm" style="margin-bottom: 10px; height: auto; border: none; width: 100px;" />
										</form>
										<div class="resultReserv" style="display: none;"></div>
									</td>
									<%} %>
								</tr>
								<tr style="display: none;">
									<td colspan="1"></td>
									<td colspan="2">Commentaire: ${listeAnnonce.commentaire}</td>
									<td colspan="6" class="tdEtapes">Etapes: ${listeAnnonce.villeDepart}&nbsp;&nbsp;<img src="img/rightarrow.png" alt="">&nbsp;&nbsp;<span class="etapesMore${listeAnnonce.idAnnonceProposition}"></span>${listeAnnonce.villeArrivee}</td>	
								</tr>
								<tr style="display: none;">
									<td colspan="1"></td>
									<td colspan="2" class="userAddMore${listeAnnonce.idAnnonceProposition}"></td>
									<!-- Login utilisateur: ${listeAnnonce.login} -->
									<td colspan="6"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
                    
                    <!-- FIN FORM RECHERCHE ANNONCE -->
                    
            </div>
            <div style="clear: both;"></div>
        </section>
        <section class="wrapper2">
            <div class="width1000">
                <div class="leftColumn500">
                    <div class="imgSpanAlign">
                        <img src="img/share.png" alt="" />
                        <span>1. Partager un trajet</span>
                    </div>
                    <img src="img/rightarrow.png" alt="" />&nbsp;&nbsp;Je m'inscris <span class="red" style="font-weight: bold;">gratuitement</span><br/>
                    <img src="img/rightarrow.png" alt="" />&nbsp;&nbsp;Je propose mes places libres<br/>
                    <img src="img/rightarrow.png" alt="" />&nbsp;&nbsp;Des passagers me contactent<br/>
                </div>
                <div class="rightColumn500">
                    <div class="imgSpanAlign">
                        <img src="img/find.png" alt="" />
                        <span>2. Trouver un trajet</span>
                    </div>
                    <img src="img/rightarrow.png" alt="" />&nbsp;&nbsp;Je m'inscris <span class="red" style="font-weight: bold;">gratuitement</span><br/>
                    <img src="img/rightarrow.png" alt="" />&nbsp;&nbsp;Je recherche un trajet<br/>
                    <img src="img/rightarrow.png" alt="" />&nbsp;&nbsp;Je contacte les conducteurs<br/>
                </div>
                <div style="clear: both;"></div>
            </div>
        </section>
        <section class="wrapper3">
            <div class="width1000" style="padding-top: 10px;">
                <span class="titleAbout">Pour faire vite:</span>
                <div>
                    CovoiturageHEI s'adresse aux étudiants de l'école d'ingénieurs HEI (Hautes études d'ingénieur).<br/><br/>

					C'est un projet d'étude de 4e année, réalisé par des étudiants de l'école et dans le domaine ITI 
					
					(Informatique et technologies de l'information), dans le but de fournir aux élèves un endroit leur permettant de trouver facilement et rapidement un covoiturage avec des personnes d'une même école.
                </div>
                <span class="titleAbout">Comment ça marche:</span>
                <div>
                    Nous proposons de mettre en contact conducteurs et passagers pour partager un véhicule le temps d'un voyage déterminé. <br/>
                    Le covoiturage peut s'effectuer entre son domicile et son lieu de travail (périphérie/centre ville par exemple) ou d'une ville à l'autre.<br/>
                    Il s'adresse à tous les automobilistes qui souhaitent rouler autrement.<br/>
                    Covoiturer, c'est utiliser une seule voiture pour faire un trajet à plusieurs.<br/><br/>

                    <div class="list" style="width: 945px; float: right;">
                        <img src="img/list.png" alt="" />&nbsp;Covoiturage = La solidarité et le lien social<br/>
							<div style="padding: 20px;">
								En proposant votre véhicule vous permettez à des personnes qui n'en possèdent pas de se rendre par exemple sur leur lieu de travail.<br/>
								Covoiturer c'est aussi rencontrer votre voisin ou celui qui travaille à deux pas de votre entreprise et que vous croisiez tous les matins dans votre voiture.
							</div>
                        <img src="img/list.png" alt="" />&nbsp;Covoiturage = respect de l'environnement<br/>
                        	<div style="padding: 20px;">
								Le vehicule personnel est l'un de principaux responsables des émissions de CO2 dans l'atmosphère.<br/>
								En covoiturant vous faites diminuer le nombre de véhicules sur les routes et vous participez ainsi à la protection de votre environnement.
							</div>
                    </div>
                    <div style="clear: both;"></div>
                </div>
            </div>
        </section>
        
<script src="js/accueilJs.js"></script>
<jsp:include page="footer.jsp" />