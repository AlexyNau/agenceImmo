monApp.factory("contratService", function($http) {
	// variable de url
	var urlWS = 'http://localhost:8080/AppSystemeAgence/';
	
	function recupListeVentes(callback) {
		$http({
			method : 'GET', // méthode Http
			url : urlWS + 'listeContratVente' // url de la méthode du webservice
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
	
	function recupListeLocation(callback) {
		$http({
			method : 'GET', // méthode Http
			url : urlWS + 'listeContratLocation' // url de la méthode du webservice
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
		
		listVente : recupListeVentes,
		listLocation : recupListeLocation
	}
})
