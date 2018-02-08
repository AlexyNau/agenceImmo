
monApp.factory("clientService",['$http','$cookieStore','$rootScope','$timeout' ,function($http,$cookieStore,$rootScope,$timeout){
	
	var urlWS='http://localhost:8080/AppSystemeAgence/';
	
	function connexion(username,mdp,callback){	
		var clientCookie='';	
		
		console.log(urlWS+'logClient/'+username +'/'+mdp)
		$http({
			method: 'GET',
			url:urlWS+'logClient/'+username +'/'+mdp

		}).then(function success(reponse){
			callback(reponse.data)
			$cookieStore.put('clientCookie',reponse.data); // je stocke client dans cookie
			 clientCookie=$cookieStore.get('clientCookie'); // je recupere client dans cookie
			 console.log("Reponsedata: "+reponse.data);
			 console.log(reponse.statut)
		},function erreur(reponse){
			
			console.log("---- Erreur du serveur pour co: "+reponse.status+" "+reponse.statusText)
		});	
		
	};
	
	function ajouterClient(ajoutClient,callback){	
	
		$http({
			method: 'POST',
			url:urlWS+'addClient',
			data:angular.toJson(ajoutClient),// les données encapsulées dans le corps de la requete http
			headers:{ //configuration des headers
				'content-type':"application/json"
			}
		}).then(function success(reponse){
			callback(reponse.data)
		},function erreur(reponse){
			
			console.log("---- Erreur du serveur pour ajout client: "+reponse.status+" "+reponse.statusText)
		});	
		
	};
	
	// Fonction pour récupérer la liste des client
	function recupListeClient(callback){
		
		$http({
			 method: 'GET',//la methode http
			 
			  url: urlWS+'listeClient' //url de la methode WS
			}).then(function success(reponse) {
			   
				//stocker la reponse dans la callback afin de la transporter au controller
				  callback(reponse.data);
				  
			  }, function erreur(reponse) {
				
				  console.log("****erreur du serveur pour la liste clients: "+reponse.status+" "+reponse.statusText)
				  
			  });
	};
	
	// Fonction pour modifier le client
	function updateClient(clientUpdate,callback) {
		
		//appel du WS grace au service $Http
		$http({
			method:'PUT',
			url:urlWS+'modifierClient',
			data:angular.toJson(clientUpdate),// les données encapsulées dans le corps de la requete http
			headers:{ //configuration des headers
				'content-type':"application/json"
			}
		}).then(function success(reponse) {
			   
			//stocker la reponse dans la callback afin de la transporter au controller
			  callback(reponse.statusText);
			  
		  }, function erreur(reponse) {
			
			  console.log("****erreur du serveur pour la modification: "+reponse.status+" "+reponse.statusText)
			  
		  });
	};


	//developpement de la fonction pour supprimer le propriétaire
	function deleteClient(id,callback) {
		
		//appel du WS grace au service $Http
		$http({
			method:'DELETE',
			url:urlWS+'deleteClient/'+id,
			
		}).then(function success(reponse) {
			   
			//stocker la reponse dans la callback afin de la transporter au controller
			  callback(reponse.statusText);
			  
		  }, function erreur(reponse) {
			
			  console.log("****erreur du serveur pour la supression: "+reponse.status+" "+reponse.statusText)
			  
		  });
	};

	
	return{
		connexionClient:connexion,
		addClient:ajouterClient,
		findListeClient:recupListeClient,
		modifClient:updateClient,
		supClient:deleteClient
		
	}
	
	
}])



