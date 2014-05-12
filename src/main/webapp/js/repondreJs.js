var counter = 1;
var limit = 15;

function addInput(divName){
	if (counter == limit)  {
		alert("Vous avez atteint la limite des " + counter + " étapes possibles.");
	}
	else {

		$("#dynamicInput"+(counter+1)).show();
		counter++;

	}
}