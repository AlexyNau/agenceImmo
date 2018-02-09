monApp.factory("joinTableService",['$http','$rootScope' ,function($http,$rootScope,$scope){
	
	var urlWS='http://localhost:8080/AppSystemeAgence/';
	
	function getIdClasseOfClientInteresse(idClient,callback){	

		$http({
			method: 'GET',
			url:urlWS+'listeClasseStd/'+idClient,

		}).then(function success(reponse){
			callback(reponse.data);
			
			console.log("Reponsedata: "+reponse.data);
			console.log(reponse.statut);
		},function erreur(reponse){
			
			console.log("---- Erreur du serveur pour co: "+reponse.status+" "+reponse.statusText);
		});		
	};
	
	
	function getClasseById(idClasse,callback){	

		$http({
			method: 'GET',
			url:urlWS+'classe/'+idClasse,

		}).then(function success(reponse){
			callback(reponse.data);
			
			console.log("Reponsedata: "+reponse.data);
			console.log(reponse.statut);
		},function erreur(reponse){
			
			console.log("---- Erreur du serveur pour co: "+reponse.status+" "+reponse.statusText);
		});		
	};

	
	return{
		getIdClasseStd:getIdClasseOfClientInteresse,
		getClasseStdById:getClasseById
	};
	
	
}]);
