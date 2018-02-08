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
	
return {
		
		addLocation : ajoutLocation
	}
})
