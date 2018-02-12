(function(){	
	angular.module('questionsApp', ['ngRoute', 'questionsService', 'mainController', 'editController'])
	.config(['$routeProvider', function($routeProvider){
	$routeProvider
		.when('/2answers', {
			templateUrl: '/templates/pages/2answers/index.html',
			controller: 'MainController',
			controllerAs: 'mainCtrl'
		})
		.when('/3answers', {
			templateUrl: '/templates/pages/3answers/index.html',
			controller: 'MainController',
			controllerAs: 'mainCtrl'
		})
		.when('/4answers', {
			templateUrl: '/templates/pages/4answers/index.html',
			controller: 'MainController',
			controllerAs: 'mainCtrl'
		})
		.when('/5answers', {
			templateUrl: '/templates/pages/5answers/index.html',
			controller: 'MainController',
			controllerAs: 'mainCtrl'
		})
		.when('/6answers', {
			templateUrl: '/templates/pages/6answers/index.html',
			controller: 'MainController',
			controllerAs: 'mainCtrl'
		})
		.when('/', {
			templateUrl: '/templates/pages/2answers/index.html',
			controller: 'MainController',
			controllerAs: 'mainCtrl'
		})
	}])
		
})();