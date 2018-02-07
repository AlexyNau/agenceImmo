//creation des controllers de mon App

monApp.controller("findAllCtrlProprio", function($scope, proprioService,$rootScope,$location) {

	// appel de la méthode du service pour recuperer la liste du web service
	proprioService.findListeProprio(function(callback) {

		// Stocker la liste récupéré dans la variable listeProprio du scope
		$scope.listeProprio = callback;
	});

	// fonction pour modifier grace au lien du tableau
	// initialiser l'objet  proprio dans le rootScope
	$rootScope.proprioUpdate={
			id:undefined,
			nom : '',
			numTelPrive : '',
			numTelTravail : '',
			   adresse:    {
				      rue: '',
				      numero: '',
				      ville: '',
				      pays: ''
				   }
	}
	//la fonction appelée a partir de la liste
	$scope.modifierLien = function(proprio) {
		//stocker les données du proprio récupéré dans le rootScope
		$rootScope.proprioUpdate=proprio;
		//rediriger vers la vue modif
$location.path("modifierProprio");
	}
	
	// fonction pour supprimer grace au lien du tableau
	$scope.supprimerLien = function(proprio) {
		proprioService.supProprio(proprio.id, function(callbackDelete) {
			if (callbackDelete == 'OK') {
				// appel de la méthode du service pour recuperer la liste du web
				// service
				proprioService.findListeProprio(function(callbackList) {

					// Stocker la liste récupéré dans la variable listeProprio du
					// scope
					$scope.listeProprio = callbackList;
				});
			}
		})
	}

}).controller(
		"findByIdCtrlProprio",
		function($scope, proprioService,$rootScope,$location) {

			// initialiser le proprio du formulaire
			$scope.id = '';
			$scope.indice = false;

			
			$scope.searchProprio = function() {
				// appel de la méthode du service pour recuperer la liste du web
				// service
				proprioService.rechercheProprio($scope.id, function(callback) {
					// Stocker la liste récupéré dans la variable listeProprio du
					// scope
					if (callback != undefined && callback != ''
							&& typeof callback == "object") {
						// la redirection pour recharger la new liste
						$scope.proprioRecherche = callback;
						$scope.indice = true;
					} else {
						$scope.indice = false;
						$scope.msg = "Le proprietaire n'existe pas ou l'id est faux";
					}
				});

			};
			
			// fonction pour modifier grace au lien du tableau
			// initialiser l'objet  propriétaire dans le rootScope
			$rootScope.proprioUpdate={
					id:undefined,
					nom : '',
					numTelPrive : '',
					numTelTravail : '',
					   adresse:    {
						      rue: '',
						      numero: '',
						      ville: '',
						      pays: ''
						   }
			}
			//la fonction appelée a partir de la liste
			$scope.modifierLien = function(proprio) {
				//stocker les données du propriétaire récupéré dans le rootScope
				$rootScope.proprioUpdate=proprio;
				//rediriger vers la vue modif
		$location.path("modifierProprio");
			}
			
			// fonction pour supprimer grace au lien du tableau
			$scope.supprimerLien = function(proprio) {
				proprioService.supProprio(proprio.id, function(callbackDelete) {
					if (callbackDelete == 'OK') {
						// appel de la méthode du service pour recuperer la liste du web
						// service
						$location.path("listeProprio");

					}
				})
			}
			
			

		}).controller("addCtrlProprio", function($scope, proprioService, $location) {

	// initialiser le propriétaire du formulaire à ajouter
	$scope.proprioAjout = {
			nom : '',
			numTelPrive : '',
			numTelTravail : '',
			   adresse:    {
				      rue: '',
				      numero: '',
				      ville: '',
				      pays: ''
				   }
	}
	// fonction pour soumettre le proprio a ajouter
	$scope.ajouterProprio = function() {
		// appel de la méthode du service pour recuperer la liste du web service
		proprioService.addProprio($scope.proprioAjout, function(callback) {
		
			if (callback == 'OK') {
				// la redirection pour recharger la new liste
				$location.path("listeProprio");
			}
		});

	};

}).controller("updateCtrlProprio", function($scope, proprioService, $location,$rootScope) {
	
	if($rootScope.proprioUpdate.id==undefined){
		// initialiser le proprio du formulaire à ajouter
		$scope.proprioUpdate = {
			id : '',
			nom : '',
			numTelPrive : '',
			numTelTravail : '',
			   adresse:    {
				      rue: '',
				      numero: '',
				      ville: '',
				      pays: ''
				   }
	};
		
	}else{
		
		$scope.proprioModif=$rootScope.proprioUpdate
		
	}



	// fonction pour soumettre le proprio a modif
	$scope.updateProprio = function() {
		// appel de la méthode du service pour recuperer la liste du web service
		proprioService.modifProprio($scope.proprioUpdate, function(callback) {
			// Stocker la liste récupéré dans la variable listeProprio du scope
			if (callback == 'OK') {
				// la redirection pour recharger la new liste
				$location.path("listeProprio");
			}
		});

	};

}).controller("deleteCtrlProprio", function($scope, proprioService, $location) {

	// initialiser le proprio du formulaire à sup
	$scope.id = '';

	// fonction pour soumettre le proprio a sup
	$scope.deleteProprio = function() {
		// appel de la méthode du service pour recuperer la liste du web service
		proprioService.supProprio($scope.id, function(callback) {
			// Stocker la liste récupéré dans la variable listeProprio du scope
			if (callback == 'OK') {
				// la redirection pour recharger la new liste
				$location.path("listeProprio");
			}
		});

	};

});
