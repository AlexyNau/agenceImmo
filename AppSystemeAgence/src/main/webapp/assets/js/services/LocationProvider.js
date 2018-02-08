//creation de mon service qui va servir à la communication avec le WS
monApp.factory("locationService",function($http){
	
	//variable de url
	var urlWS='http://localhost:8080/AppSystemeAgence/';
	
	//developpement de la fonction pour récupérer la liste Location
	function recupListeLocation(callback){
		
		// appel du web service via le service $http (il est basé sur ajax(le bus
		// qui transporte la requete et recup le resultat du
		// WS:XMLHttpRequests(XHR)))
		
		$http({
			 method: 'GET',//la methode http
			 
			  url: urlWS+'listeLocations' //url de la methode WS
			}).then(function success(reponse) {
			   
				//stocker la reponse dans la callback afin de la transporter au controller
				  callback(reponse.data);
				  
			  }, function erreur(reponse) {
				
				  console.log("****erreur du serveur pour la liste: "+reponse.status+" "+reponse.statusText)
				  
			  });
	};
		
		//le retour de la fonction du service
		return {
			findListeLocation:recupListeLocation
		}
		
	});