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
	}).when("/inscriptionClient", {
		templateUrl : "views/inscription_client.html",
		controller : "InscriptionClientCtrl"
	}).when("/inscriptionClient",{
		templateUrl:"views/inscription_client.html",
		controller:"InscriptionClientCtrl"
	}).when("/listeClient", {
		templateUrl : "views/listeClientsCN.html",
		controller : "findAllCtrlClient"
	}).when("/modifierClient", {
		templateUrl : "views/modifClientCN.html",
		controller : "updateCtrlClient"
	}).when("/mapConseiller",{
		templateUrl:"views/map_conseiller.html",
		controller:"mapCtrl"
	}).when("/coConseiller", {
		templateUrl : "views/login_conseiller.html",
		controller : "ConnexionConseillerCtrl"
	}).when("/ajouterVente", {
		templateUrl : "views/ajoutVente.html",
		controller : "addVenteCtrl"
	}).when("/listeLocation", {
		templateUrl : "views/rechercheLocation.html",
		controller : "findAllLocationCtrl"
	}).when("/modifierVente", {
		templateUrl : "views/modifierVenteCN.html",
		controller : "updateVenteCtrl"
	}).when("/afficherVentes", {
		templateUrl : "views/listeVentesCN.html",
		controller : "findAllVenteCtrl"
	}).otherwise({
		redirectTo : "/accueilU"
	})
});