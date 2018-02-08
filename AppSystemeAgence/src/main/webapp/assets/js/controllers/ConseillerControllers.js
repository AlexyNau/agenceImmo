
monApp.controller('ConnexionConseillerCtrl',function ($scope,conseillerService,$cookieStore, $rootScope, $location) {
		var conseiller={
				mail:''
			};
		
			
			
			$rootScope.conseiller=$cookieStore.get('conseillerCookie');
		
			$scope.login=function () {
			console.log("Tentative co ...")
			conseiller=conseillerService.connexionConseiller($scope.username,$scope.mdp,function(callback){
				if(callback){
					$rootScope.conseiller=callback;
					$location.path("listeProprio");
					console.log("Fonction login:"+$rootScope.conseiller.nom)
				}
			})				
			
			
			
		};
		
		console.log("Valeur nom conseiller:"+conseiller.nom)
		if($rootScope.conseiller)
			console.log("Valeur nom conseiller scope:"+$rootScope.conseiller.nom)
    	
			// Pour la déconnexion (accesible partout avec rootScrope)
		$rootScope.logoutConseiller=function () {
			console.log("Tentative deco ...")
			$cookieStore.remove('conseillerCookie');
			$rootScope.conseiller='';
		}
    	
	});
	
