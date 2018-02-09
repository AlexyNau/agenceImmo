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

	$scope.lat=0;
	$scope.lng=0;
	
	$scope.voirCadastre = function() {
		geocoder = new google.maps.Geocoder();
		
		geocoder.geocode(
				{ 'address': $scope.venteAjout.adresse.numero
					+" "+$scope.venteAjout.adresse.rue
					+" "+$scope.venteAjout.adresse.ville }, 
					function(results, status) {
						if (status=='OK') {
							$scope.lat=results[0].geometry.location.lat();
							console.log("Latitude : "+$scope.lat)

							$scope.lng=results[0].geometry.location.lng();
							console.log("Longitude : "+$scope.lng)
						}
					})
				}
		
	
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
			console.log($scope.contratAjout);
			if(callback){
				$location.path("listeProprio");
			}
		})
	}
})