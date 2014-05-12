<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section class="wrapper3" id="wrapperInsc" style="padding: 20px;">
	<div class="width1000">
		<div style="text-align: center;">
			<span class="downTitle titleAbout">Calculatrice de prix du trajet</span>
			<div>
				La calculatrice de prix du trajet aide les conducteurs à définir le prix du trajet le plus correct possible pour les passagers.<br/>
				Ce prix est une recommandation. Le prix définitif doit être convenu directement entre le conducteur et le passager avant chaque départ.<br/> 
				En principe, tout est objet de négociation. <br/>
				En règle générale, le prix est basé sur une consommation minimale de 10l/100km. <br/><br/>

				Vous obtenez d'autres informations sur le prix du trajet dans nos questions fréquentes.<br/><br/>

				Si vous souhaitez indiquer un prix fixe à vos passagers, vous pouvez calculer ici, en relation avec le trajet, la participation au prix.<br/>
				En général, le prix revient entre 5-7 Euro par 100 km en fonction du prix de l'essence, du véhicule et de la consommation.<br/><br/>
				
				Veuillez remplir les cases correspondantes:<br/>
			</div>
		</div>
	</div>
</section>
<section class="wrapper6" id="wrapperInsc" style="padding: 30px;">
	<div class="width1000">
		<div style="text-align: center;">
			<table style="margin: auto;">
				<tr>
					<td class="columnheader2" style="padding-bottom: 10px;">Prix par 100km</td>
					<td style="padding: 0 10px 0 10px;">
						<select class="input_contact" style="width: 150px;" name="prix" id="prixForm">
							<option value="5.00" selected>5.00</option>
							<option value="5.50">5.50</option>
							<option value="6.00">6.00</option>
							<option value="6.50">6.50</option>
							<option value="7.00">7.00</option>
							<option value="7.50">7.50</option>
							<option value="8.00">8.00</option>
						</select>
					</td>
					<td class="columnheader2" style="padding-bottom: 15px;">EUR</td>
				</tr>
				<tr>
					<td class="columnheader2" style="padding-bottom: 15px;">Distance</td>
					<td style="padding: 0 10px 0 10px;">
						<input type="text" class="input_contact" style="width: 150px;" name="km" id="km">
					</td>
					<td class="columnheader2" style="padding-bottom: 15px;">km</td>
				</tr>
				<tr>
					<td colspan="3" class="columnheader2" style="padding-bottom: 15px;">Prix recommandé par passager</td>
				</tr>
				<tr>
					<td colspan="3" style="padding: 0 90px 0 90px;"><input type="text" id="prixTotal" class="submitContactForm" style="text-align: center; cursor: auto;" value="0.00€" readonly></td>
				</tr>
			</table>
			<script>
				var prixSelect = $("#prixForm option:selected");
				var km = $("#km").val();
				var prixCalc = 0;
				$("#prixForm").change(function(){
					prixSelect = $("#prixForm option:selected").val();
					km = $("#km").val();
					if(km == null || km == ""){km = 0;}
					prixCalc = (parseFloat(prixSelect)*parseFloat(km))/100;
					
					$("#prixTotal").val(prixCalc+"€");
				});
				
				$("#km").keyup(function(){
					
					prixSelect = $("#prixForm option:selected").val();
					km = $(this).val();
					if(km == null || km == ""){km = 0;}
					
					prixCalc = (parseFloat(prixSelect)*parseFloat(km))/100;
					
					$("#prixTotal").val(prixCalc+"€");
				});
			</script>
			
		</div>
	</div>
</section>

<jsp:include page="footer.jsp" />
