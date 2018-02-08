monApp.controller("addVenteCtrl", function($scope, venteService, $location) {
	// initialisation de la vente du formulaire à ajouter
	$scope.venteAjout = {
		proprietaire : {
			id : ''
		},
		classeStd : {
			type_bien : ''
		},
		adresse : {
			numero : '',
			rue : '',
			ville : '',
			pays : ''
		},
		datePublication:'',
		dateDisponibilite:'',
		remise:'',
		etat:'',
		prixAchat:'',
		superficie:''
	}
	
	//fonction pour soumettre la vente à ajouter
	$scope.ajouterVente = function() {
		//appel de la méthode du service
		venteService.addVente($scope.venteAjout, function(callback) {
			if (callback=='OK'){
				//redirection vers la page d'accueil du conseiller
				console.log("ajout vente ok");
			}
		})
	}
})