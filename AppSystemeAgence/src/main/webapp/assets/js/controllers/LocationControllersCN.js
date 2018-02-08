monApp.controller("addLocationCtrl", function($scope, locationServiceCN,
		proprioService, $location) {
	// initialisation de la vente du formulaire à ajouter
	$scope.locationAjout = {
		adresse : {
			numero : '',
			rue : '',
			ville : '',
			pays : ''
	
		},
		datePublication : '',
		dateDisponibilite : '',
		remise : '',
		superficie : '',
		image:null,
		photo:null
	}
	
	
	$scope.affiche=function(){
		$scope.locationAjout.photo=$scope.locationAjout.image.base64;
	}
	// récupérer la liste des propriétaires
	proprioService.findListeProprio(function(callback) {
		$scope.listeProprietaires = callback;
	})

	// fonction pour soumettre la vente à ajouter
	$scope.ajouterLocation = function() {
		// appel de la méthode du service
		locationServiceCN.addLocation($scope.locationAjout, function(callback) {
			if (callback) {
				// redirection vers la page d'accueil du conseiller
				$location.path("listeProprio");
			}
		})
	}
}).controller("updateLocationCNCtrl", function($scope, locationServiceCN, $location) {
	$scope.locationModif = {
			id:'',
			adresse : {
				numero : '',
				rue : '',
				ville : '',
				pays : ''
		
			},
			datePublication : '',
			dateDisponibilite : '',
			remise : '',
			superficie : '',
			image:null,
			photo:null
	}
	
	$scope.modifierLocation = function() {
		locationServiceCN.updateLocation($scope.locationModif, function(callback) {
			if (callback) {
				// redirection vers la page d'accueil du conseiller
				$location.path("listeProprio");
			}
		})
	}
})