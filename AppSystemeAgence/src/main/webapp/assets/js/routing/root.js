// La configuration de la table de routage

monApp.config(function($routeProvider) {
	
	$routeProvider
	.when("/listeProprio",{templateUrl:"views/listeProprio.html",controller:"findAllCtrlProprio"})
	.when("/ajouterProprio",{templateUrl:"views/ajoutProprio.html",controller:"addCtrlProprio"})
	.when("/supprimerProprio",{templateUrl:"views/supprimeProprio.html",controller:"deleteCtrlProprio"})
	.when("/modifierProprio",{templateUrl:"views/modifProprio.html",controller:"updateCtrlProprio"})
	.when("/rechercherProprio",{templateUrl:"views/rechercheProprio.html",controller:"findByIdCtrlProprio"})
	.when("/coClient",{templateUrl:"views/login_client.html",controller:"ConnexionClientCtrl"})
	.otherwise({
		redirectTo:"/listeProprio"
	})
});