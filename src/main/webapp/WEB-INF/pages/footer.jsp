<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<section class="wrapper4">
            <div class="width1000">
                <div class="align">
                    <span class="titleAbout">Les dernières annonces<br/></span>
                    <span class="red">C'est en ce moment sur www.CovoiturageHEI.fr ...</span>
                </div>
                <div class="leftColumn500" style="padding-top: 20px;">

                    <span style="color: #292a2b;">Les dernières offres<br/></span>

                    <table class="lastCars">
					<tbody>
						<c:forEach var="last_offers" begin="0" end="${last_offers_size}"	step="1" items="${last_offers}">
						<tr>
							<td>${last_offers.villeDepart}</td>
							<td><img src="img/rightarrow.png" alt=""></td>
							<td>${last_offers.villeArrivee}</td>
							<td>${last_offers.prix}€</td>
							<td>le ${last_offers.dateEtHeureTrajet.substring(8, 10)}/${last_offers.dateEtHeureTrajet.substring(5, 7)}/${last_offers.dateEtHeureTrajet.substring(0, 4)}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
                </div>
                <div class="rightColumn500" style="padding-top: 20px;">

                    <span style="color: #292a2b;">Les dernières demandes<br/></span>
                    <table class="lastCars">
					<tbody>
						<c:forEach var="last_searchs" begin="0" end="${last_searchs_size}"	step="1" items="${last_searchs}">
						<tr>
							<td>${last_searchs.villeDepartRecherche}</td>
							<td><img src="img/rightarrow.png" alt=""></td>
							<td>${last_searchs.villeArriveeRecherche}</td>
							<td>le ${last_searchs.dateEtHeureRecherche.substring(8, 10)}/${last_searchs.dateEtHeureRecherche.substring(5, 7)}/${last_searchs.dateEtHeureRecherche.substring(0, 4)}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
                </div>
                <div style="clear: both;"></div>
            </div>
        </section>
        <section class="wrapper5">
            <div class="width1000">
                <div class="getInTouch">
                    RESTER EN CONTACT
                </div>
                <div class="align" style="color: #f6f6f6; font-size: 30px;">covoiturageHEI@gmail.com | integrale@hei.fr</div>
                <div class="align">
                    <a href=""><img src="img/social/white/facebook.png" alt="" /></a>
                    <a href=""><img src="img/social/white/twitter.png" alt="" /></a>
                    <a href=""><img src="img/social/white/google.png" alt="" /></a>
                    <a href=""><img src="img/social/white/instagram.png" alt="" /></a>
                </div>
            </div>
        </section>
        <section class="wrapper6">
            <div class="width1000">
                <div class="leftColumn" style="text-align: left;">
                    <div class="columnInside" style="width: 80%; margin: auto;">
                        <div class="columnheader2" style="text-align: left;">CONTACT</div>
                        <div class="gill">Contacter nous pour tous problèmes, 
                            demandes d’informations, nous y répondrons 
                            dans les plus bref délais.<br/>
                        </div>
                        <form method="post" action="ajaxcontact" id="contact_form">
                            <input class="input_contact" type="text" name="nom" id="nomcontact" placeholder="Votre nom..."/>
                            <input class="input_contact" type="email" name="email" id="emailcontact" placeholder="Votre email..."/>
                            <textarea class="textarea_contact" name="message" id="messagecontact" placeholder="Votre message..."></textarea>
                            <input type="submit" value="Contacter" class="submitContactForm"/>
                        </form>
                        <div id="contact_result" style="display: none"></div>
                    </div>
                </div>
                <div class="middleColumn" style="text-align: left;">
                    <div class="columnInside" style="width: 80%; margin: auto;">
                    	
                        <div class="columnheader2" style="text-align: left;">NEWSLETTER</div>
                        <div class="gill">Pour suivre l’évolution du site, le
                            développement de nouveaux modules,
                            inscrivez-vous à notre newsletter.<br/>
                        </div>
                        <form id="newsletter_form" action="ajaxnewsletter">
                            <input class="input_contact" type="text" name="email" id="newsletter_email"  placeholder="Votre email..."/>
                            <input type="submit" value="Newsletter" class="submitContactForm"/>
                        </form>
                        <div id="newsletter_result" style="display: none"></div>
                    </div>
                </div>
                <div class="rightColumn" style="text-align: left;">
                    <div class="columnInside size18" style="width: 80%; margin: auto;">
                        <div class="grey">Pour les conducteurs</div>
                        <div class="red">
                            <a href="proposer" class="red">Proposer un covoiturage</a><br/>
                            <div style="margin-top: -10px;">
                                <a href="inscription" class="red">S'inscrire maintenant</a><br/>
                            </div>
                            <div style="margin-top: -10px;">
                                <a href="" class="red">Tutoriel conducteur</a><br/>
                            </div>
                        </div>

                        <div class="grey">Pour les passagers</div>
                        <div class="red">
                            <a href="trouver" class="red">Covoiturage par ville</a><br/>
                            <div style="margin-top: -10px;">
                                <a href="" class="red">Tutoriel passager</a><br/>
                            </div>
                        </div>

                        <div class="grey">Légale</div>
                        <div class="red">
                            <a href="" class="red">Informations légales</a><br/>
                            <div style="margin-top: -10px;">
                                <a href="" class="red">Conditions générales</a><br/>
                            </div>
                            <div style="margin-top: -10px;">
                                <a href="" class="red">Confidentialité</a><br/>
                            </div>
                        </div>

                        <div class="grey">Aide</div>
                        <div class="red">
                            <a href="" class="red">Premiers pas</a><br/>
                            <div style="margin-top: -10px;">
                                <a href="" class="red">Questions fréquentes</a><br/>
                            </div>
                            <div style="margin-top: -10px;">
                                <a href="" class="red">Règles</a><br/>
                            </div>
                            <div style="margin-top: -10px;">
                                <a href="calculateur" class="red">Prix du covoiturage</a><br/>
                            </div>
                        </div>
                        
                        <c:if test="${estAdmin}">
	                        <div class="grey">Administration</div>
	                        <div class="red">
	                            <a href="administration" class="red">Lister les utilisateurs</a><br/>
	                        </div>
                        </c:if>
                    </div>
                </div>
                <div style="clear: both;"></div>
            </div>
        </section>
        <footer>
            <div class="width1000" style="padding-top: 22px;">
                <div style="float: left;">
                    <a href=""><img src="img/social/color/rss.png" alt="" /></a>
                    <a href=""><img src="img/social/color/twitter.png" alt="" /></a>
                    <a href=""><img src="img/social/color/facebook.png" alt="" /></a>
                    <a href=""><img src="img/social/color/google.png" alt="" /></a>
                </div>
                <div style="float: right; font-family: 'gillcondensed'; font-size: 18px; color: white;">
                    Covoiturage covoiturageHEI.fr · Copyright © 2014-2015 All rights reserved
                </div>
                <div style="clear: both;"></div>
            </div>
        </footer>
       
        <div id="back-top" style="border: 1px solid #121212;"><a href="#top"><img src="img/top.png" alt=""></a></div>
        <div id="global"></div>
		
		<script src="js/footerJs.js"></script>
    </body> 
</html>
