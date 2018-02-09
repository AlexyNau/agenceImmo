monApp.factory("locationServiceCN", function($http) {
	// variable de url
	var urlWS = 'http://localhost:8080/AppSystemeAgence/';
	
	//développement de la fonction pour ajouter une location
	function ajoutLocation(locationAjout, callback){
		locationAjout.photo = locationAjout.image.base64;
		locationAjout.image='';
		// appel du WS grâce au service $http
		$http({
			method : 'POST',
			url : urlWS + 'location',
			data : angular.toJson(locationAjout),
			header : {
				'content-type' : 'application/json'
			}
		}).then(
				function success(reponse) {
					// stockage de la réponse dans le callback
					callback(reponse.data);
				},
				function erreur(reponse) {
					console.log("****erreur du serveur pour l'ajout de location: "
							+ reponse.status + " " + reponse.statusText)
				});
	}
	;
	
	function modifLocation(locationModif, callback) {
		$http({
			method : 'PUT',
			url : urlWS + 'location',
			data : angular.toJson(locationModif),
			header : {
				'content-type' : 'application/json'
			}
		}).then(
				function success(reponse) {
					// stockage de la réponse dans le callback
					callback(reponse.data);
				},
				function erreur(reponse) {
					console.log("****erreur du serveur pour la modif de vente: "
							+ reponse.status + " " + reponse.statusText)
				});
	};
	
	function ajoutContrat(contratAjout, callback) {
		// appel du WS grâce au service $http
		$http({
			method : 'POST',
			url : urlWS + 'addContratLocation',
			data : angular.toJson(contratAjout),
			header : {
				'content-type' : 'application/json'
			}
		}).then(
				function success(reponse) {
					// stockage de la réponse dans le callback
					callback(reponse.data);
				},
				function erreur(reponse) {
					console.log("****erreur du serveur pour l'ajout de contrat: "
							+ reponse.status + " " + reponse.statusText)
				});
	};
	
	function recupListe(callback){
		$http({
			method : 'GET', // méthode Http
			url : urlWS + 'listeLocations' // url de la méthode du webservice
		}).then(function success(reponse) {
			// stocker la réponse dans le callback afin de la
			// transporter au controller
			callback(reponse.data);

		},
		function failure(reponse) {
			console.log("------- Erreur du serveur (liste) "
					+ reponse.status + " " + reponse.statusText);
		});
	};
	
return {
		
		addLocation : ajoutLocation,
		updateLocation : modifLocation,
		getListeLocations : recupListe,
		addContrat : ajoutContrat
	}
})
