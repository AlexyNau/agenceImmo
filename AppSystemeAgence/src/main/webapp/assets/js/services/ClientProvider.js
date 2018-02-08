
monApp.factory("clientService",['$http','$cookieStore','$rootScope','$timeout' ,function($http,$cookieStore,$rootScope,$timeout){
	
	var urlWS='http://localhost:8080/AppSystemeAgence/';
	
	function connexion(username,mdp,callback){	
		var clientCookie='';	
		/*mdp='c';
		username='c@c'*/
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
		
	}
	
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
		
	}

	
	return{
		connexionClient:connexion,
		addClient:ajouterClient
	}
	
	
}])



