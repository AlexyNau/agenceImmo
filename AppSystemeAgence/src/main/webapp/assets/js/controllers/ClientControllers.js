
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
					$location.path("accueilClient");
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
	
		.controller("InscriptionClientCtrl", function($scope, $rootScope, clientService, $location) {

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
		
			if (callback) {
				$rootScope.confirmRegisterClient = "Inscription confirmer";
				// la redirection pour retourner à la page de connexion client
				$location.path("coClient");
			}
		});

	};
	})
	
monApp.controller("findAllCtrlClient",function($scope,clientService,$rootScope,$location,joinTableService) {

	
	
		// appel de la méthode du service pour recuperer la liste du web service
		clientService.findListeClient(function(callback) {

		// Stocker la liste récupéré dans la variable listeClients du scope
		$scope.listeClients = callback;

		
		
		// List des id des classestd
		$scope.listIdClass = [];
		// List des classesStd
		$scope.listClasseStd = [];
		
		var i =0;
		
		angular.forEach($scope.listeClients, function(client){
			// Récupération de la list des id des classeStd pour un id client
			joinTableService.getIdClasseStd(client.id, function(callback) {
				
				
				if(callback){
					$scope.listIdClass.push(callback);
				}
				console.log("liste des id classe :"+$scope.listIdClass);
	
				if($scope.listIdClass.length==$scope.listeClients.length){
					angular.forEach($scope.listIdClass, function(idClass){
						// Pour chaque id de la liste des id de classeStd :
						
						if(idClass!=0){
							joinTableService.getClasseStdById(idClass, function(callback) {
								console.log(callback);
							
								if(callback){
									$scope.listClasseStd.push(callback);
								}

								console.log("liste des id classeStd :"+$scope.listClasseStd);
							
							})
						}else{
							// +i sinon bug avec le ng-repeat pour des elements similaires
							$scope.listClasseStd.push("Aucune classe "+i);
							i++;
						}
					});
				}
				
				
			});
			
		});
		
		
		
		
		
		
		
		
		// Pour chaque client de la liste :
//		var i =0;
//		do {
//			$scope.clientUn = $scope.listeClients[i];
//			
//			// Récupération de la list des id des classeStd pour un id client
//			joinTableService.getIdClasseStd($scope.clientUn.id, function(callback) {
//				
//				console.log(callback);
//				if(callback){
//					$scope.listIdClass.push(callback);
//				}
//				console.log("liste des id classe :"+$scope.listIdClass);
//				
//				 if(i==6){
//
//				    	console.log("liste recu dans le if ********* :"+$scope.listIdClass);
//				    	
//						// List des classesStd
//						$scope.listClasseStd = [];
//
//						// Pour chaque id de la liste des id de classeStd :
//						var j =0;
//						do {
//							$scope.idclass = $scope.listIdClass[j];
//							
//							joinTableService.getClasseStdById($scope.idclass, function(callback) {
//								console.log(callback);
//								if(callback){
//									$scope.listClasseStd.push(callback);
//								}
//								
//								// Bug ici, la boucle fait trop de boucle
//								console.log("liste des id classeStd :"+$scope.listClasseStd);
//								
//							})
//						    j++;
//						}
//						while (j < $scope.listIdClass.length);
//
//				    }
//	
//				
//			});
//			
//		    i++;
//		    console.log("****** i ="+i);
//		    
//		   
//		}
//		while (i < $scope.listeClients.length);
	
		
		
		
		
		
	});
	
	
	

	// fonction pour modifier grace au lien du tableau
	// initialiser l'objet  client dans le rootScope
	$rootScope.clientUpdate={
			id:undefined,
			nom : '',
			telephone : '',
			mail : '',
			   adresse:    {
				      rue: '',
				      numero: '',
				      ville: '',
				      pays: ''
				   },
			classesStd :{
				code:'',
				type_bien:'',
				mode_offre:'',
				prix_max:'',
				sup_min:'',
			}
	}
	//la fonction appelée a partir de la liste
	$scope.modifierLien = function(client) {
		//stocker les données du client récupéré dans le rootScope
		$rootScope.clientUpdate=client;
		//rediriger vers la vue modif
		$location.path("modifierClient");
	}
	
	// fonction pour supprimer grace au lien du tableau
	$scope.supprimerLien = function(client) {
		clientService.supClient(client.id, function(callbackDelete) {
			if (callbackDelete == 'OK') {
				// appel de la méthode du service pour recuperer la liste du web
				// service
				clientService.findListeClient(function(callbackList) {

					// Stocker la liste récupéré dans la variable listeProprio du
					// scope
					$scope.listeClients = callbackList;
				});
			}
		})
	}

})
.controller("updateCtrlClient", function($scope, clientService, $location,$rootScope) {
	
	if($rootScope.clientUpdate.id==undefined){
		// initialiser le proprio du formulaire à ajouter
		$scope.clientUpdate = {
				id:'',
				nom : '',
				telephone : '',
				mail : '',
				   adresse:    {
					      rue: '',
					      numero: '',
					      ville: '',
					      pays: ''
					   },
					classesStd :{
						code:'',
						type_bien:'',
						mode_offre:'',
						prix_max:'',
						sup_min:'',
		}
	};	
	}else{
		$scope.clientModif=$rootScope.clientUpdate
	}

	// fonction pour soumettre le client a modif
	$scope.updateClient = function() {
		// appel de la méthode du service pour recuperer la liste du web service
		clientService.modifClient($scope.clientUpdate, function(callback) {
			if (callback == 'OK') {
				// la redirection pour recharger la new liste
				$location.path("listeClient");
			}
		});
	};
})

.controller("updateCtrlClientCL", function($scope, clientService, $location,$rootScope) {
	
	// On récupère le client connecté
	 $scope.clientModif = $rootScope.client;

	// fonction pour soumettre le client a modif
	$scope.updateClient = function() {
		// appel de la méthode du service pour recuperer la liste du web service
		clientService.modifClient($scope.clientModif, function(callback) {
			if (callback == 'OK') {
				// la redirection pour recharger la new liste
				$location.path("accueilClient");
			}
		});
	};
})



.controller("AccueilClientCtrl", function(){
	
})


.controller("mapCtrl", function($scope,$rootScope,locationService, clientService, $location) {

		$scope.rechercheZone='France';
		$scope.msg1="TEST";
		$scope.msg="";
		$rootScope.bien='';
		$scope.bien_map_bol=false;
		$scope.bien_map_bol2=false;
		console.log("init $rootScope.bien_map_bol="+$rootScope.bien_map_bol)
		$scope.x_coord='300px';
		$scope.y_coord='300px';
		// Liste de location
		locationService.findListeLocation(function(callback) {
			$scope.listeLocation = callback;
		    console.log("Adresse 0 ="+$scope.listeLocation[0].adresse.pays)
		    console.log("Adresse 0 ="+$scope.listeLocation[0].loyer)
		});
		
		var adresse=["24 rue crebillon nantes",
				"Parc des Chantiers, Boulevard Léon Bureau, 44200 Nantes",
				"1 Quai du Cordon Bleu, 44100 Nantes",
				"1 Allée du Dauphiné, 44400 Rezé",
				"Champ de Mars, 5 Avenue Anatole France, 75007 Paris",
				"5 Rue des Prouvaires, 75001 Paris",
				"Place Charles de Gaulle, 75008 Paris"
		];
		
		document.body.onmousemove = function(e) {
			  // suivi de la position de la souris dans la console
			  console.log("Position de la souris :  X=" + e.clientX + "   Y="+e.clientY);
				$scope.$apply(function() {
					  $scope.x_coord=e.clientX+'px';
					  $scope.y_coord=e.clientY+'px';
		 		});

			}


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

	     $scope.affiche_bien=function(bien,id){
		 alert("TEST="+bien.adresse.pays+" / "+id+" /");
		 $scope.msg="CLICK";
		 $rootScope.bienMap=bien;
		 $rootScope.idMap=id;

		 console.log($scope.msg);
		 redirection();
		
	}
	     
	     function redirection(){
         	 console.log("if="+$scope.msg);
	    	 console.log(" %%%%%%%%%%%%% REDIRECTION %%%%%%%");
	    	 $scope.$apply(function() {
	    		  $location.path('/afficheBien');
	    		});
	     }
	     
	     function affiche_survol(){
	    	 $scope.$apply(function() {
	    		 $scope.bien_map_bol2=true
	    		});
	    	 console.log("Affiche :"+$scope.bien_map_bol2)
	     }
		
	$scope.rechercher=function(){
			   
		 console.log("Initialize")	

		 $scope.map = new GMaps({
			    el: '#map',
			    lat: 47.5073346,
			    lng: -1.5276831,
			    zoom:7, 
			   
			  })
		 
		 /* marker.addListener('click', function() {
	          map.setZoom(8);
	          map.setCenter(marker.getPosition());
	        });*/
		
	console.log("Recherche="+$scope.rechercheZone);
	var positionRecup='';
	var latitude=[];
	var longitude=[];
	var positionRecup=[];
				
			geocoder1.geocode( { 'address': $scope.rechercheZone}, function(results, status) {
				console.log("i="+i)
		      if (status == 'OK') {
		    	  console.log("!!!!!!!Zone Correcte !!!!!!!!!")
		       //results[0].geometry.location.lat(), results[0].geometry.location.lng());
		        $scope.map.setCenter({lat: results[0].geometry.location.lat(), lng: results[0].geometry.location.lng()});
		        
		    	  $scope.map.setZoom(12);
		    	  if($scope.rechercheZone=='France')
		    		  $scope.map.setZoom(5);
		      }//fin geocoder 1
				var taille=$scope.listeLocation.length;
				console.log("************* TAILLE LISTE LOCATION "+ taille +"**********************")
				for(var i=0;i<taille;i++){
					console.log("i="+i)
					$scope.j=i
		        //geocoder2.geocode( { 'address': adresse[i]}, function(results1, status1) {
				geocoder2.geocode(
				{ 'address': $scope.listeLocation[i].adresse.numero+" "+$scope.listeLocation[i].adresse.rue+" "+$scope.listeLocation[i].adresse.ville }, function(results1, status1) {
				
		        	if (status1 == 'OK') {
		        		console.log("!!!!!!!Ville Find !!!!!!!!!")
	
		        		console.log("j geocoder 2="+$scope.j)
		        		positionRecup[i]=results1[0].geometry.location;
		        		 latitude[i] = results1[0].geometry.location.lat();
		                 longitude[i] = results1[0].geometry.location.lng();
		        		console.log("Position==="+positionRecup)
		        		console.log("latitude["+i+"]="+latitude[i]+" / longitude["+i+"]="+longitude[i])
		        		
		        		var bien=$scope.listeLocation[i-taille];
		        		var adresse=bien.adresse.numero+" "+bien.adresse.rue+" "+bien.adresse.ville;
		        		console.log("Adresse :"+adresse +"/ ")
		        		ajoutMarker(i-taille,latitude[i],longitude[i],adresse,bien);	
		        		i++
	
		        	}//fin if geocoder2		        	
		        	
		          }) //fin geocoder 2
		          
				}
				

		       
		       
		  })
		}//fin for
		
		
		
		function ajoutMarker(i,lat,lg,adresse,bien){
			console.log(bien)
			var lol=adresse
			console.log("i="+i+" //// Ajout Marker lat="+lat)
			 /* var marker = new google.maps.Marker({
	  			   lat: lat,
				   lng: lg,	
				   map: $scope.map,
				   title: 'Click to zoom'
			  });*/
			 $scope.map.addMarker({   			
  			   lat: lat,
			   lng: lg,	
			   id:i,
			   icon:'http://maps.google.com/mapfiles/marker_green.png',
			   //icon:bien.photo.base64,
			   url:bien.adresse.pays+"/"+bien.adresse.rue,
  			   title:adresse+" / "+i,
  			   click:function(e){
  				   
  				  
  				   $scope.affiche_bien(bien,i); 				   
  			   },
			 	mouseover:function(e){
			 		$scope.bien_map=bien

			 		$rootScope.bien_map_bol=true
			 		console.log("mouse OVER !!!!!!!!!!!!"+$scope.x_coord)
			 		
			 		$scope.$apply(function() {
			 			
				 		$scope.test=e
			 		});
			 		affiche_survol();
			   }
  			})/*.addlistener('click', function() {
  	          $scope.map.setZoom(8);
  	          $scope.map.setCenter(marker.getPosition());
  	        });*/
	
		} //fin scope recherche function	
		
		
		$scope.rechercher();
		
		
		
		
		
	});
	
