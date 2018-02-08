
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
			
		$rootScope.logout=function () {
			console.log("Tentative deco ...")
			$cookieStore.remove('clientCookie');
			$rootScope.client='';
		}
    	
    	
	})
	
		.controller("InscriptionClientCtrl", function($scope, clientService, $location) {

	// initialiser le propriétaire du formulaire à ajouter
	$scope.clientAjout = {
			nom : '',
			mail : '',
			mdp : '',
			telephone : '',
			   adresse:    {
				      rue: '',
				      numero: '',
				      ville: '',
				      pays: ''
				   }
	}
	// fonction pour soumettre le proprio a ajouter
	$scope.ajouterClient = function() {
		// appel de la méthode du service pour recuperer la liste du web service
		clientService.addClient($scope.clientAjout, function(callback) {
		
			if (callback == 'OK') {
				// la redirection pour recharger la new liste
				$location.path("listeProprio");
			}
		});

	};
	})

.controller("mapCtrl", function($scope, clientService, $location) {

		$scope.rechercheZone='';
		
		var adresse=["24 rue crebillon nantes",
				"Parc des Chantiers, Boulevard Léon Bureau, 44200 Nantes",
				"1 Quai du Cordon Bleu, 44100 Nantes",
				"1 Allée du Dauphiné, 44400 Rezé",
				"Champ de Mars, 5 Avenue Anatole France, 75007 Paris",
				"5 Rue des Prouvaires, 75001 Paris",
				"Place Charles de Gaulle, 75008 Paris"
		];

	
	
		geocoder1 = new google.maps.Geocoder();
		geocoder2 = new google.maps.Geocoder();
		
		/*$scope.map=new google.maps.Map(document.getElementById('map'), {
	          center: {lat: -34.397, lng: 150.644},
	          zoom: 8
	          
	          
	        });*/
		
	        
			   $scope.map = new GMaps({
			    el: '#map',
			    lat: 47.5073346,
			    lng: -1.5276831,
			    zoom:7, 
			   
			  });

			   $scope.map.addMarker({
				      lat: 44.870000,
				      lng: -0.590000,
				      title: 'Notre entreprise',
				      infoWindow: {
				        content: 'Piscines de qualité '
				      }
				  });
			   $scope.map.addMarker({
				      lat: 43.870000,
				      lng: -0.790000,
				      title: 'hsfhe',
				      infoWindow: {
				        content: 'Piscines de qgjgfjgj '
				      }
				  });

		
	$scope.rechercher=function(){
		
	 
		 console.log("Initialize")
		 
		 $scope.map = new GMaps({
			    el: '#map',
			    lat: 47.5073346,
			    lng: -1.5276831,
			    zoom:7, 
			   
			  });
		 
		   $scope.map.addMarker({
			      lat: 54.870000,
			      lng: -0.990000,
			      title: 'Notre entreprise 222',
			      infoWindow: {
			        content: 'Piscines de qualité '
			      }
			  });
		   $scope.map.addMarker({
			      lat: 53.870000,
			      lng: -0.990000,
			      title: 'hsfhe 3333',
			      infoWindow: {
			        content: 'Piscines de qgjgfjgj '
			      }
			  });

		
		
	console.log("Recherche="+$scope.rechercheZone);
	var positionRecup='';
		for(var i=0;i<2;i++){
			console.log("Adresse :"+adresse[i])
		geocoder1.geocode( { 'address': $scope.rechercheZone}, function(results, status) {
			
		      if (status == 'OK') {
		    	  
		       // $scope.map.setCenter(results[0].geometry.location);
		        $scope.map.setZoom(12);
		        geocoder2.geocode( { 'address': adresse[i]}, function(results1, status1) {
		        	if (status1 == 'OK') {
		        		positionRecup=results1[0].geometry.location;
		        		console.log("Position"+positionRecup)
		        		console.log("Position[0]="+positionRecup+" / Position[1]="+positionRecup[1])
		        		console.log("Adresse :"+adresse[i] +"/ ")
		        		/* $scope.map.addMarker({
		        			
		        			   lat: 53.870000,
		   			           lng: -0.990000,	
		        			//	map:$scope.map,
		        				title:"Trop fort"
		        			}
			        					        				
		        		);*/

		        		
	
		        	}//fin if geocoder2
		        	
		        })
		       /* var myLatLng = {lat: positionRecup[0], lng: positionRecup[1]};
		        var marker = new google.maps.Marker({
        			position: myLatLng,
        			map: map,
        			title:"Trop fort"
        		});*/
		      }//fin if geocoder1
		       
		  })
		}//fin for	

	  }//fin scope function
		
	});	

	
