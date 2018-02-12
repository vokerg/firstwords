angular.module('QuestionApp')
.controller('MainController', ['$http', '$scope', '$timeout', '$location', 'questionsService', 
                                  function($http, $scope, $timeout, $location, questionsService) {
	var mainCtrl = this;
	
	this.putResult = function(selectedAnswer) {
		mainCtrl.loadNextQuestion(selectedAnswer == $scope.correctAnswer);
	};
	
	this.loadNextQuestion = function(correctPrevious) {
		$scope.correctAnswers = (correctPrevious) ? ($scope.correctAnswers + 1) : -1;
		console.log('wordCount=' + $scope.questions.length + ', correctAnswers=' + $scope.correctAnswers);
		$http.get('/questions/Home/' + $scope.questions.length + '/' + $scope.correctAnswers).success(function(data) {
			if ($scope.questions.length != data.questions.length) {
				questionsService.questions = data.questions;
				questionsService.correctAnswer = data.correctAnswer;

				switch (data.questions.length) {
					case 2: $location.path('/2answers'); break;
					case 3: $location.path('/3answers'); break;
					case 4: $location.path('/4answers'); break;
					case 5: $location.path('/5answers'); break;
					case 6: $location.path('/6answers'); break;
				};
			}
			$scope.questions = data.questions;
			$scope.correctAnswer = data.correctAnswer;
		});	
			
		$scope.isShowQuestion = false;
		$timeout(function(){
			responsiveVoice.speak($scope.questions[$scope.correctAnswer].name, "Russian Female");
			$scope.isShowQuestion = true;	
		}, 1000);
	};
	
	this.init = function() {
		$scope.putResult = mainCtrl.putResult;
		$scope.correctAnswers = -1;
		$scope.questions = questionsService.questions;
		$scope.correctAnswer = questionsService.correctAnswer;
		$scope.isShowQuestion = true;
		if ($scope.questions.length == 0) {
			mainCtrl.loadNextQuestion(true);	
		}
	}();
	
}]);