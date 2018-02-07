
monApp

	.controller('ConnexionClientCtrl',function ($scope,clientService,$cookieStore, $rootScope, $location) {
				
			$rootScope.client=$cookieStore.get('clientCookie');
		
			$rootScope.login=function () {
			console.log("Tentative co ...")
			clientService.connexionClient($scope.username,$scope.mdp, function(callback) {
				console.log("callback ddd"+callback)
				if (callback) {
					console.log("Client recup provider:"+callback)	
					$rootScope.client=callback;
					$location.path("listeProprio");
				}
			})				
		}
		if($rootScope.client)
			console.log("Valeur nom client scope:"+$rootScope.client)
			
		$rootScope.logout=function () {
			console.log("Tentative deco ...")
			$cookieStore.remove('clientCookie');
			$rootScope.client='';
		}
    	
    	
	})
	
