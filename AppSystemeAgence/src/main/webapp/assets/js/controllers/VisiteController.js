//creation des controllers de mon App

monApp.controller("findAllVisiteCtrl", function($scope, visiteService,$rootScope,$location) {

	// appel de la méthode du service pour recuperer la liste du web service
	visiteService.findListeVisite(function(callback) {

		// Stocker la liste récupéré dans la variable listeVisite du scope
		$scope.listeVisite = callback;
	});
	
	// fonction pour modifier grace au lien du tableau
	// initialiser l'objet  visite dans le rootScope
	$rootScope.visiteUpdate={
			id:undefined,
			date : '',
			client : '',
			location :'',
			vente :''
	}
	//la fonction appelée a partir de la liste
	$scope.modifierVLien = function(visite) {
		//stocker les données du visite récupéré dans le rootScope
		$rootScope.visiteUpdate=visite;
		//rediriger vers la vue modif
$location.path("modifierVisite");
	}
	
	// fonction pour supprimer grace au lien du tableau
	$scope.supprimerVLien = function(visite) {
		visiteService.supVisite(visite.id, function(callbackDelete) {
			if (callbackDelete == 'OK') {
				// appel de la méthode du service pour recuperer la liste du web
				// service
				visiteService.findListeVisite(function(callbackList) {

					// Stocker la liste récupéré dans la variable listeProprio du
					// scope
					$scope.listeVisite = callbackList;
				});
			}
		})
	}
	
})// ***** Controller ajout d'une visite *****
.controller("visiteAddCtrl",function($scope,visiteService,$location){
	
	$scope.visiteAjout = {
		date : '',
		client : '',
		location :'',
		vente :''
	}

	// fonction pour soumettre la visite a ajouter
	$scope.ajouterVisite = function() {
		// appel de la méthode du service pour recuperer la liste du web service
		visiteService.addVisite($scope.visiteAjout, function(callback) {
		
			if (callback == 'OK') {
				// la redirection pour recharger la new liste
				$location.path("listeVisite");
			}
		});
	}
	
}).controller("visiteDeleteCtrl", function($scope, visiteService, $location) {

	// initialiser le visite du formulaire à sup
	$scope.id = '';

	// fonction pour soumettre la visite a sup
	$scope.deleteVisite = function() {
		// appel de la méthode du service pour recuperer la liste du web service
		visiteService.supVisite($scope.id, function(callback) {
			// Stocker la liste récupéré dans la variable listeVisite du scope
			if (callback == 'OK') {
				// la redirection pour recharger la new liste
				$location.path("listeVisite");
			}
		});

	};

}).controller("visiteUpdateCtrl", function($scope, visiteService, $location,$rootScope) {
	
	if($rootScope.visiteUpdate.id==undefined){
		// initialiser le formulaire à ajouter
		$scope.proprioUpdate = {
			id : '',
			date : '',
			client : '',
			location :'',
			vente :''
		
	};
		
	}else{
		
		$scope.visiteModif=$rootScope.visiteUpdate
		
	}



	// fonction pour soumettre la modif
	$scope.updateVisite = function() {
		// appel de la méthode du service pour recuperer la liste du web service
		visiteService.modifVisite($scope.visiteUpdate, function(callback) {
			// Stocker la liste récupéré dans la variable listeVisite du scope
			if (callback == 'OK') {
				// la redirection pour recharger la new liste
				$location.path("listeVisite");
			}
		});

	};

}).controller(
		"findVisiteByIdCtrl",
		function($scope,visiteService,$rootScope,$location) {

			// initialiser le formulaire
			$scope.id = '';
			$scope.indice = false;

			
			$scope.searchVisite = function() {
				// appel de la méthode du service pour recuperer la liste du web
				// service
				visiteService.rechercheVisite($scope.id, function(callback) {
					// Stocker la liste récupéré dans la variable listeVisite du
					// scope
					if (callback != undefined && callback != ''
							&& typeof callback == "object") {
						// la redirection pour recharger la new liste
						$scope.visiteRecherche = callback;
						$scope.indice = true;
					} else {
						$scope.indice = false;
						$scope.msg = "La visite n'existe pas ou l'id est faux";
					}
				});

			};
			// fonction pour modifier grace au lien du tableau
			// initialiser l'objet  visite dans le rootScope
			$rootScope.proprioUpdate={
					id:undefined,
					date : '',
					client : '',
					location :'',
					vente :''
			}
			//la fonction appelée a partir de la liste
			$scope.modifierVLien = function(visite) {
				//stocker les données récupéré dans le rootScope
				$rootScope.visiteUpdate=visite;
				//rediriger vers la vue modif
		$location.path("modifierVisite");
			}
			
			// fonction pour supprimer grace au lien du tableau
			$scope.supprimerVLien = function(visite) {
				visiteService.supVisite(visite.id, function(callbackDelete) {
					if (callbackDelete == 'OK') {
						// appel de la méthode du service pour recuperer la liste du web
						// service
						$location.path("listeVisite");

					}
				})
			}
		})