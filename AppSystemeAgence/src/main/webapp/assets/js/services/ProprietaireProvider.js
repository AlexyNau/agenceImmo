//creation de mon service qui va servir à la communication avec le WS
monApp.factory("proprioService",function($http){
	
	//variable de url
	var urlWS='http://localhost:8080/AppSystemeAgence/';
	//developpement de la fonction pour récupérer la liste
	function recupListeProprio(callback){
		
		// appel du web service via le service $http (il est basé sur ajax(le bus
		// qui transporte la requete et recup le resultat du
		// WS:XMLHttpRequests(XHR)))
		
		$http({
			 method: 'GET',//la methode http
			 
			  url: urlWS+'listeProprietaire' //url de la methode WS
			}).then(function success(reponse) {
			   
				//stocker la reponse dans la callback afin de la transporter au controller
				  callback(reponse.data);
				  
			  }, function erreur(reponse) {
				
				  console.log("****erreur du serveur pour la liste: "+reponse.status+" "+reponse.statusText)
				  
			  });
	};
	
//developpement de la fonction pour ajouter le proprio
function ajoutProprio(proprioAjout,callback) {
	
	//appel du WS grace au service $Http
	$http({
		method:'POST',
		url:urlWS+'addProprietaire',
		data:angular.toJson(proprioAjout),// les données encapsulées dans le corps de la requete http
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
function updateProprio(proprioUpdate,callback) {
	
	//appel du WS grace au service $Http
	$http({
		method:'PUT',
		url:urlWS+'modifierProprietaire',
		data:angular.toJson(proprioUpdate),// les données encapsulées dans le corps de la requete http
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
function deleteProprio(id,callback) {
	
	//appel du WS grace au service $Http
	$http({
		method:'DELETE',
		url:urlWS+'deleteProprietaire/'+id,
		
	}).then(function success(reponse) {
		   
		//stocker la reponse dans la callback afin de la transporter au controller
		  callback(reponse.statusText);
		  
	  }, function erreur(reponse) {
		
		  console.log("****erreur du serveur pour la supression: "+reponse.status+" "+reponse.statusText)
		  
	  });
};

//developpement de la fonction pour rechercher un proprietaire
function searchProprio(id,callback) {
	
	//appel du WS grace au service $Http
	$http({
		method:'GET',
		url:urlWS+'proprietaire/'+id,
		
	}).then(function success(reponse) {
		   
		//stocker la reponse dans la callback afin de la transporter au controller
		  callback(reponse.data);
		  
	  }, function erreur(reponse) {
		
		  console.log("****erreur du serveur pour la recherche: "+reponse.status+" "+reponse.statusText)
		  
	  });
};
	
	//le retour de la fonction du service
return {
	
	findListeProprio:recupListeProprio,
	addProprio:ajoutProprio,
	modifProprio:updateProprio,
	supProprio:deleteProprio,
	rechercheProprio:searchProprio
	
}

});


