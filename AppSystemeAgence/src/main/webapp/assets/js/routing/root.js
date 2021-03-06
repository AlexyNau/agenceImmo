// La configuration de la table de routage

monApp.config(function($routeProvider) {

	$routeProvider.when("/accueilU", {
		templateUrl : "views/accueilU.html",
		controller : "accueilUCtrl"
	}).when("/contactImmo", {
		templateUrl : "views/contactU.html",
		controller : "contactCtrl"
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
	}).when("/biensProprio", {
		templateUrl : "views/listeBienProprio.html",
		controller : "findBienProprioCtrl"
	}).when("/coClient", {
		templateUrl : "views/login_client.html",
		controller : "ConnexionClientCtrl"
	}).when("/accueilClient", {
		templateUrl : "views/accueilCL.html",
		controller : "AccueilClientCtrl"
	}).when("/contactImmoCL", {
		templateUrl : "views/contactCL.html",
		controller : "contactCtrl"
	}).when("/modifCL", {
		templateUrl : "views/modifClientCL.html",
		controller : "updateCtrlClientCL"
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
		templateUrl : "views/ajoutContratVenteCN.html",
		controller : "updateVenteCtrl"
	}).when("/afficherVentes", {
		templateUrl : "views/listeVentesCN.html",
		controller : "findAllVenteCtrl"
	}).when("/ajouterLocation", {
		templateUrl : "views/ajoutLocationCN.html",
		controller : "addLocationCtrl"
	}).when("/modifierLocation", {
		templateUrl : "views/ajoutContratLocCN.html",
		controller : "updateLocationCNCtrl"
	}).when("/listeVisite", {
		templateUrl : "views/gestionVisiteCN.html",
		controller : "findAllVisiteCtrl"
	}).when("/ajouterVisite", {
		templateUrl : "views/ajoutVisiteCN.html",
		controller : "visiteAddCtrl"
	}).when("/modifierVisite", {
		templateUrl : "views/modifVisiteCN.html",
		controller : "visiteUpdateCtrl"
	}).when("/supprimerVisite", {
		templateUrl : "views/supprimeVisiteCN.html",
		controller : "visiteDeleteCtrl"
	}).when("/afficherLocationCN", {
		templateUrl : "views/listeLocationCN.html",
		controller : "findAllLocationCtrl"
	}).when("/afficheBien", {
		templateUrl : "views/afficheBien.html",
		controller : "AfficheBienCtrl"			
	}).when("/afficheListeContrat", {
		templateUrl : "views/listeContratCN.html",
		controller : "findAllContratCtrl"
	}).when("/afficheListeAcquereurs", {
		templateUrl : "views/listeAcquereursCN.html",
		controller : "findAllContratCtrl"
	}).otherwise({
		redirectTo : "/accueilU"
	})
});