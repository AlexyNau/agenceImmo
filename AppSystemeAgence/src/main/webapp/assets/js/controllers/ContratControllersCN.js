monApp.controller("findAllContratCtrl", function($scope, contratService) {
	contratService.listVente(function(callback) {
		$scope.listeContratVente=callback;
	})
	contratService.listLocation(function(callback) {
		$scope.listeContratLocation=callback;
	})
})