//création de mon service qui va servir à la communication
monApp.factory("venteService", function($http) {
	// variable de url
	var urlWS = 'http://localhost:8080/AppSystemeAgence/';

	// développement de la fonction pour ajouter une vente
	function ajoutVente(venteAjout, callback) {
		
		venteAjout.photo = venteAjout.image.base64;
		venteAjout.image='';
		// appel du WS grâce au service $http
		$http({
			method : 'POST',
			url : urlWS + 'vente',
			data : angular.toJson(venteAjout),
			header : {
				'content-type' : 'application/json'
			}
		}).then(
				function success(reponse) {
					// stockage de la réponse dans le callback
					callback(reponse.data);
				},
				function erreur(reponse) {
					console.log("****erreur du serveur pour l'ajout de vente: "
							+ reponse.status + " " + reponse.statusText)
				});
	}
	;
	
	function modifVente(venteModif, callback) {
		$http({
			method : 'PUT',
			url : urlWS + 'vente',
			data : angular.toJson(venteAjout),
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
	}

	return {
		
		addVente : ajoutVente,
		updateVente : modifVente
	}

});