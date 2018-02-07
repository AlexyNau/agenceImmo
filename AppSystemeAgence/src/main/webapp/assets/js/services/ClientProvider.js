
monApp.factory("clientService",['$http','$cookieStore','$rootScope','$timeout' ,function($http,$cookieStore,$rootScope,$timeout){
	

	
	function connexion(username,mdp){	
		
		var clientCookie={
				nom:''
		}
	
		
		$http({
			method: 'GET',
			url:urlWS+'/logClient/'+username +'/'+mdp ,
			data:angular.toJson(clientAjout) //données encapsulées dans le corps de la requete

		}).then(function success(reponse){
			$cookieStore.put('clientCookie',reponse.data); // je stocke client dans cookie
			clientCookie=$cookieStore.get('clientCookie'); // je recupere client dans cookie
		},function erreur(reponse){
			
			console.log("---- Erreur du serveur pour ajout: "+reponse.status+" "+reponse.statusText)
		});
		
		
		return clientCookie;
		
	}
	
	return{
		connexionClient:connexion
	}
	
	
}])



