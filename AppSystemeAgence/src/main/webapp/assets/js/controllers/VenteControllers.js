monApp.controller("addVenteCtrl", function($scope, venteService,
		proprioService, $location) {
	// initialisation de la vente du formulaire à ajouter
	$scope.venteAjout = {
		adresse : {
			numero : '',
			rue : '',
			ville : '',
			pays : ''
	
		},
		datePublication : '',
		dateDisponibilite : '',
		remise : '',
		etat : '',
		prixAchat : '',
		superficie : '',
		image:null,
		photo:null
	}
	
	
	$scope.affiche=function(){
		$scope.venteAjout.photo=$scope.venteAjout.image.base64;
	}
	// récupérer la liste des propriétaires
	proprioService.findListeProprio(function(callback) {
		$scope.listeProprietaires = callback;
	})

	// fonction pour soumettre la vente à ajouter
	$scope.ajouterVente = function() {
		// appel de la méthode du service
		venteService.addVente($scope.venteAjout, function(callback) {
			if (callback) {
				// redirection vers la page d'accueil du conseiller
				$location.path("listeProprio");
			}
		})
	}
}).controller("updateVenteCtrl", function($scope, venteService, $location) {
	$scope.modifierVente = function() {
		venteService.updateVente(venteModif, function(callback) {
			if (callback) {
				// redirection vers la page d'accueil du conseiller
				$location.path("listeProprio");
			}
		})
	}
})