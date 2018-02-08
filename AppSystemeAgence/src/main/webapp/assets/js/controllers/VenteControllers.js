monApp.controller("findAllVenteCtrl", function($scope, venteService) {
	//appel de la méthode service
	venteService.getListe(function(callback) {
		$scope.listeVente = callback;
	})
})

.controller("addVenteCtrl", function($scope, venteService,
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
}).controller("updateVenteCtrl", function($scope, venteService, clientService, $location) {
	$scope.contratAjout={
	prix:'',
	date:'',
			
	vente:{
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
			etat : '',
			prixAchat : '',
			superficie : '',
			image:null,
			photo:null
		}
	}
	
	clientService.findListeClient(function(callback){
		$scope.listeClient=callback;
	})
	
	$scope.ajouterContrat = function() {
		venteService.updateVente($scope.contratAjout.vente, function(callback) {
		})
		venteService.addContrat($scope.contratAjout, function(callback) {
			if(callback){
				$location.path("listeProprio");
			}
		})
	}
})