//creation des controllers de mon App

monApp.controller("findAllLocationCtrl", function($scope, locationService,$location) {
	 $scope.loyer=1000;
	 $scope.sup_min=0;
	 $scope.sup_max=1000;
	 $scope.type_bien='';
	 $scope.garniture=true;
	$scope.filterRange = function(location) {
		console.log(location.classeStd.type_bien)
		console.log($scope.type_bien)
		var b=location.loyer < $scope.loyer && location.superficie>$scope.sup_min && location.superficie<$scope.sup_max;
		
		var b2=location.loyer < $scope.loyer && location.superficie>$scope.sup_min && location.superficie<$scope.sup_max && location.classeStd.type_bien==$scope.type_bien;
		if($scope.type_bien=='')
			return b;
		else
			return b2;
		
	};
	
	// appel de la méthode du service pour recuperer la liste du web service
	locationService.findListeLocation(function(callback) {

		// Stocker la liste récupéré dans la variable listeProprio du scope
		$scope.listeLocation = callback;
		  console.log("Provider Adresse 0 ="+$scope.listeLocation[0].adresse.pays)
		   console.log("Adresse 0 ="+$scope.listeLocation[0].loyer)
	});
	
	//la fonction appelée a partir de la liste
	$scope.favorisLien = function() {
		
		//rediriger vers la vue modif
$location.path("favoris");
	};
	
	
	
}).filter('lowerThan',function(){
	return function(input, max) {
		var tableauAffiche = [];
		input.forEach(function(l){
			if(l < max){tableauAffiche.push(l);}
		});
		return tableauAffiche;
	};

})