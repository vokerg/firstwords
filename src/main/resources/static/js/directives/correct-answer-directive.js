angular.module('QuestionApp')
.directive('correctAnswer', [function() {
	return {
		restrict: 'E',
		templateUrl: "/templates/directives/correctAnswer.html",
		scope: {
			name: "@"
		},
		link: function(scope, element) {
			console.log("Hello from directive");
		}
	
	};
}]);