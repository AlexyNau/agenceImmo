// La configuration de la table de routage

monApp.config(function($routeProvider) {

	$routeProvider.when("/accueilU", {
		templateUrl : "views/accueilU.html",
		controller : "accueilUCtrl"
	}).when("/listeProprio", {
		templateUrl : "views/listeProprio.html",
		controller : "findAllCtrlProprio"
	}).when("/ajouterProprio", {
		templateUrl : "views/ajoutProprio.html",
		controller : "addCtrlProprio"
	}).when("/supprimerProprio", {
		templateUrl : "views/supprimeProprio.html",
		controller : "deleteCtrlProprio"
	}).when("/modifierProprio", {
		templateUrl : "views/modifProprio.html",
		controller : "updateCtrlProprio"
	}).when("/rechercherProprio", {
		templateUrl : "views/rechercheProprio.html",
		controller : "findByIdCtrlProprio"
	}).when("/coClient", {
		templateUrl : "views/login_client.html",
		controller : "ConnexionClientCtrl"
	}).when("/coConseiller", {
		templateUrl : "views/login_conseiller.html",
		controller : "ConnexionConseillerCtrl"
	}).when("/ajouterVente", {
		templateUrl : "views/ajoutVente",
		controller : "addVenteCtrl"
	}).otherwise({
		redirectTo : "/accueilU"
	})
});