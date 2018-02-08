
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

		// Stocker la liste récupéré dans la variable listeProprio du scope
		$scope.listeClients = callback;

	});
	
	// Récupération de la list des id des classeStd pour un id client
	joinTableService.getIdClasseStd('2', function(callback) {
		$scope.listIdClasse = callback;
		console.log("liste des id classe :"+$scope.listIdClasse);
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

.controller("mapCtrl", function($scope,$rootScope, clientService, $location) {

		$scope.rechercheZone='france';
		$scope.msg1="TEST";
		$scope.msg="";
		$rootScope.bien='';
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

	function affiche_bien(bien){
		 alert("TEST="+bien.nom+" / "+bien.prenom);
		 $scope.msg="CLICK";
		// $rootScope.bien=bien;
		 console.log("AFFICHAGE BIEN === "+$scope.bien.prenom);
		
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
		    	  if($scope.rechercheZone=='france')
		    		  $scope.map.setZoom(5);
		      }//fin geocoder 1
				
				for(var i=0;i<6;i++){
					console.log("i="+i)
					$scope.j=i
		        geocoder2.geocode( { 'address': adresse[i]}, function(results1, status1) {
		        	if (status1 == 'OK') {
		        		console.log("!!!!!!!Ville Find !!!!!!!!!")
	
		        		console.log("j geocoder 2="+$scope.j)
		        		positionRecup[i]=results1[0].geometry.location;
		        		 latitude[i] = results1[0].geometry.location.lat();
		                 longitude[i] = results1[0].geometry.location.lng();
		        		console.log("Position==="+positionRecup)
		        		console.log("latitude["+i+"]="+latitude[i]+" / longitude["+i+"]="+longitude[i])
		        		console.log("Adresse :"+adresse[i] +"/ ")
		        		var bien={nom:i,prenom:adresse}
		        		ajoutMarker(i,latitude[i],longitude[i],adresse[i-6],bien);	
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
			   url:bien.nom+"/"+bien.prenom,
  			   title:adresse+" / "+i,
  			   click:function(e){
  				   
  				  
  				   affiche_bien(bien);
  				   
  			   }
  			})/*.addlistener('click', function() {
  	          $scope.map.setZoom(8);
  	          $scope.map.setCenter(marker.getPosition());
  	        });*/
	
		} //fin scope recherche function	
		
		
		$scope.rechercher();
		
		
		
		
		
	});
	
