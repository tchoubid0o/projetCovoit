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
                            This is Photoshop's version  of Lorem <br/>
                            Ipsum. Proin gravida nibh vel velit <br/>
                            auctor aliquet. Aenean sollicitudin, lorem <br/>
                            quis bibendum auctor, nisi elit id elit.<br/>
                        </div>
                    </div>
                    <div class="middleColumn">
                        <div class="columnInside">
                            <img src="img/trust.png" alt="" />
                            <div class="columnheader">Fiable</div>
                            Proin gravida nibh vel velit <br/>
                            auctor aliquet. Aenean sollicitudin, lorem <br/>
                            ipsum dolor sit<br/>
                        </div>
                    </div>
                    <div class="rightColumn">
                        <div class="columnInside">
                            <img src="img/usefull.png" alt="" />
                            <div class="columnheader">Pratique</div>
                            This is Photoshop's version  of Lorem <br/>
                            Ipsum. Proin gravida nibh vel velit <br/>
                            auctor aliquet. Aenean sollicitudin, lorem <br/>
                            quis bibendum auctor, nisi elit id elit.<br/>
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
									<td>${listeAnnonce.dateEtHeureTrajet} à
										${listeAnnonce.heure}h${listeAnnonce.minute}min</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
                    
                    <!-- FIN FORM RECHERCHE ANNONCE -->
                    
                </div>
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
                    This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh <br/>
                    vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum <br/>
                    auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. <br/>
                    Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. <br/>
                </div>
                <div class="rightColumn500">
                    <div class="imgSpanAlign">
                        <img src="img/find.png" alt="" />
                        <span>2. Trouver un trajet</span>
                    </div>
                    Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt <br/>
                    auctor a ornare odio. Sed non  mauris vitae erat consequat <br/>
                    auctor eu in elit. Class aptent taciti sociosqu ad litora <br/>
                    torquent per conubia nostra, per inceptos himenaeos.<br/>
                </div>
                <div style="clear: both;"></div>
            </div>
        </section>
        <section class="wrapper3">
            <div class="width1000" style="padding-top: 10px;">
                <span class="titleAbout">Pour faire vite:</span>
                <div>
                    This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor
                    nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan 
                    ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent 
                    taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris in erat justo. Nullam ac urna eu felis dapibus <br/><br/>

                    condimentum sit amet a augue. Sed non neque elit. Sed ut imperdiet nisi. Proin condimentum fermentum nunc. Etiam pharetra, 
                    erat sed fermentum feugiat, velit mauris egestas quam, ut aliquam massa nisl quis neque. Suspendisse in orci enim.
                </div>
                <span class="titleAbout">Comment ça marche:</span>
                <div>
                    This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor
                    nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan<br/><br/>

                    <span class="list" style="width: 945px; float: right;">
                        <img src="img/list.png" alt="" />&nbsp;Ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris vitae erat consequat auctor eu in elit. 
                        Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.<br/>
                        <img src="img/list.png" alt="" />&nbsp;Mauris in erat justo. Nullam ac urna eu felis dapibus condimentum sit amet a augue. Sed non neque elit. Sed ut imperdiet nisi.<br/>
                        <img src="img/list.png" alt="" />&nbsp;Proin condimentum fermentum nunc. Etiam pharetra, erat sed fermentum feugiat, velit mauris egestas quam, ut aliquam.<br/>
                    </span>
                    <div style="clear: both;"></div>
                </div>
            </div>
        </section>
        
<jsp:include page="footer.jsp" />