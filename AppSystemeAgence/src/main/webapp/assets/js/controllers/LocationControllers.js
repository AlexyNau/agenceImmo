//creation des controllers de mon App

monApp.controller("findAllLocationCtrl", function($scope, locationService) {

	// appel de la méthode du service pour recuperer la liste du web service
	locationService.findListeLocation(function(callback) {

		// Stocker la liste récupéré dans la variable listeProprio du scope
		$scope.listeLocation = callback;
	});
	
})