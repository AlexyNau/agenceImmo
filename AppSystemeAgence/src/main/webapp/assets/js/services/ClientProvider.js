
monApp.factory("clientService",['$http','$cookieStore','$rootScope','$timeout' ,function($http,$cookieStore,$rootScope,$timeout){
	
	var urlWS='http://localhost:8080/AppSystemeAgence/';
	
	function connexion(username,mdp,callback){	
		var clientCookie='';	
		mdp='c';
		username='c@c'
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

	
	return{
		connexionClient:connexion
	}
	
	
}])



