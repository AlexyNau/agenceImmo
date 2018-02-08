
monApp.factory("conseillerService",['$http','$cookieStore','$rootScope','$timeout' ,function($http,$cookieStore,$rootScope,$timeout){
	
	var urlWS='http://localhost:8080/AppSystemeAgence/';
	
	function connexion(username,mdp,callbock){	
		var conseillerCookie='';	
		
		$http({
			method: 'GET',
			url:urlWS+'logConseiller/'+username +'/'+mdp

		}).then(function success(reponse){
			callbock(reponse.data);
			$cookieStore.put('conseillerCookie',reponse.data); // je stocke conseiller dans cookie
			conseillerCookie=$cookieStore.get('conseillerCookie'); // je recupere conseiller dans cookie
			console.log("Reponsedata: "+reponse.data);
			console.log(reponse.statut)
		},function erreur(reponse){
			
			console.log("---- Erreur du serveur pour co: "+reponse.status+" "+reponse.statusText)
		});	
		
	}

	
	return{
		connexionConseiller:connexion
	}
	
	
}]);



