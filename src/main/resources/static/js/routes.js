	angular.module('QuestionApp')
	.config(['$routeProvider', function($routeProvider){
	$routeProvider
		.when('/2answers', {
			templateUrl: '/templates/pages/2answers.html',
			controller: 'MainController',
		})
		.when('/3answers', {
			templateUrl: '/templates/pages/3answers.html',
			controller: 'MainController',
		})
		.when('/4answers', {
			templateUrl: '/templates/pages/4answers.html',
			controller: 'MainController',
		})
		.when('/5answers', {
			templateUrl: '/templates/pages/5answers.html',
			controller: 'MainController',
		})
		.when('/6answers', {
			templateUrl: '/templates/pages/6answers.html',
			controller: 'MainController',
		})
		.when('/', {
			templateUrl: '/templates/pages/2answers.html',
			controller: 'MainController',
		})
		
	}]);