monApp



		.controller("accueilUCtrl", function($scope,$rootScope,locationService,venteService,$location){
			
			// Liste de Vente
			venteService.getListe(function(callback) {
				$scope.listeVente = callback;
			})
			
			// Liste de location
			locationService.findListeLocation(function(callback) {
				$scope.listeLocation = callback;
			    console.log("Adresse 0 ="+$scope.listeLocation[0].adresse.pays)
			    console.log("Adresse 0 ="+$scope.listeLocation[0].loyer)
			});
			
			$scope.affiche_bien=function(bien){
				$rootScope.bien2=bien;
				$location.path("afficheBien");
			}
	
		
		})
		
		
		.controller("AfficheBienCtrl", function($scope,$rootScope,locationService,venteService,$location){
			geocoder1 = new google.maps.Geocoder();
			if(!$scope.immoBien)
				$scope.immoBien=$rootScope.bien2;
			if($rootScope.idMap)
				recupBienMap();
			
			function recupBienMap(){
				console.log("RECUP BIEN MAP")
				console.log("Bien ["+$rootScope.idMap+"]="+$rootScope.bienMap.adresse.pays)
				//alert("rootScope bien map="+$rootScope.bienMap.loyer)
				console.log("Bien ville="+$rootScope.bienMap.adresse.ville)
				console.log("Bien loyer="+$rootScope.bienMap.loyer)
				var bienMap=
				$scope.immoBien=$rootScope.bienMap;
				console.log("Bien immo ville="+$scope.immoBien.adresse.ville)
				console.log("Bien immo loyer="+$scope.immoBien.loyer)
				$rootScope.idMap=''
				//location.path("")
			}
			//console.log("Bien root loyer="+$rootScope.bien2.loyer)
			console.log("Bien scope loyer="+$scope.immoBien.loyer)
			
			
			/*$scope.map=new google.maps.Map(document.getElementById('map_bien'), {
	          center: {lat: -34.397, lng: 150.644},
	          zoom: 8
	                    
	        }); */ 
			 $scope.map = new GMaps({
			    el: '#map_bien',
			    lat: 47.5073346,
			    lng: -1.5276831,
			    zoom:7, 
			   
			  })
			

			var recherche=$scope.immoBien.adresse.numero+" "+$scope.immoBien.adresse.rue+" "+$scope.immoBien.adresse.ville+" "+$scope.immoBien.adresse.pays
			geocoder1.geocode( { 'address': recherche}, function(results, status) {
	
		      if (status == 'OK') {
	
		        $scope.map.setCenter({lat: results[0].geometry.location.lat(), lng: results[0].geometry.location.lng()});
		        $scope.map.setZoom(13)
		        $scope.map.addMarker({
		  			   lat:  results[0].geometry.location.lat(),
					   lng:  results[0].geometry.location.lng(),	
					   title: 'Click to zoom'
				  });
				
		      }
			})
			
			
	
		
		});