//creation des controllers de mon App

monApp.controller("findAllLocationCtrl", function($scope, locationService,$location) {

	// appel de la méthode du service pour recuperer la liste du web service
	locationService.findListeLocation(function(callback) {

		// Stocker la liste récupéré dans la variable listeProprio du scope
		$scope.listeLocation = callback;
	});
	
	//la fonction appelée a partir de la liste
	$scope.favorisLien = function() {
		
		//rediriger vers la vue modif
$location.path("favoris");
	};
	
	
	
}).filter('lowerThan',function(){
	return function(input, max) {
		var tableauAffiche = [];
		input.forEach(function(l){
			if(l < max){tableauAffiche.push(l);}
		});
		return tableauAffiche;
	};

})