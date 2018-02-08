
monApp

	.controller('ConnexionClientCtrl',function ($scope,clientService,$cookieStore, $rootScope, $location) {
		var client={
				nom:''
			}
		
			
			
			$rootScope.client=$cookieStore.get('clientCookie');
		
			$rootScope.login=function () {
			console.log("Tentative co ...")
			clientService.connexionClient($scope.username,$scope.mdp,function(callback){
				if(callback){
					$rootScope.client=callback;
					$location.path("listeProprio");
					console.log("Fonction login:"+$rootScope.client.nom)
				}
			})				
			
			
			
		}
		
		console.log("Valeur nom client:"+client.nom)
		if($rootScope.client)
			console.log("Valeur nom client scope:"+$rootScope.client.nom)
    	
    	
	})
	
