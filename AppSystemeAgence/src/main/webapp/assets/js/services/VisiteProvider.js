//creation de mon service qui va servir à la communication avec le WS
monApp.factory("visiteService",function($http){
	
	//variable de url
	var urlWS='http://localhost:8080/AppSystemeAgence/';
	//developpement de la fonction pour récupérer la liste
	function recupListeVisite(callback){
		
		// appel du web service via le service $http (il est basé sur ajax(le bus
		// qui transporte la requete et recup le resultat du
		// WS:XMLHttpRequests(XHR)))
		
		$http({
			 method: 'GET',//la methode http
			 
			  url: urlWS+'listeVisite' //url de la methode WS
			}).then(function success(reponse) {
			   console.log("****liste visite"+reponse.data)
				//stocker la reponse dans la callback afin de la transporter au controller
				  callback(reponse.data);
				  
			  }, function erreur(reponse) {
				
				  console.log("****erreur du serveur pour la liste: "+reponse.status+" "+reponse.statusText)
				  
			  });
	};
	
//developpement de la fonction pour ajouter le proprio
function ajoutVisite(visiteAjout,callback) {
	
	//appel du WS grace au service $Http
	$http({
		method:'POST',
		url:urlWS+'addVisite',
		data:angular.toJson(visiteAjout),// les données encapsulées dans le corps de la requete http
		headers:{ //configuration des headers
			'content-type':"application/json"
		}
	}).then(function success(reponse) {
		   
		//stocker la reponse dans la callback afin de la transporter au controller
		  callback(reponse.statusText);
		  
	  }, function erreur(reponse) {
		
		  console.log("****erreur du serveur pour l'ajout: "+reponse.status+" "+reponse.statusText)
		  
	  });
};


//developpement de la fonction pour modifier le proprio
function updateVisite(visiteUpdate,callback) {
	
	//appel du WS grace au service $Http
	$http({
		method:'PUT',
		url:urlWS+'modifierVisite',
		data:angular.toJson(visiteUpdate),// les données encapsulées dans le corps de la requete http
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


//developpement de la fonction pour supprimer la visite
function deleteVisite(id,callback) {
	
	//appel du WS grace au service $Http
	$http({
		method:'DELETE',
		url:urlWS+'deleteVisite/'+id,
		
	}).then(function success(reponse) {
		   
		//stocker la reponse dans la callback afin de la transporter au controller
		  callback(reponse.statusText);
		  
	  }, function erreur(reponse) {
		
		  console.log("****erreur du serveur pour la supression: "+reponse.status+" "+reponse.statusText)
		  
	  });
};

//developpement de la fonction pour rechercher une visite
function searchVisite(id,callback) {
	
	//appel du WS grace au service $Http
	$http({
		method:'GET',
		url:urlWS+'visite/'+id,
		
	}).then(function success(reponse) {
		   
		//stocker la reponse dans la callback afin de la transporter au controller
		  callback(reponse.data);
		  
	  }, function erreur(reponse) {
		
		  console.log("****erreur du serveur pour la recherche: "+reponse.status+" "+reponse.statusText)
		  
	  });
};
	
	//le retour de la fonction du service
return {
	
	findListeVisite:recupListeVisite,
	addVisite:ajoutVisite,
	modifVisite:updateVisite,
	supVisite:deleteVisite,
	rechercheVisite:searchVisite
	
}

});


