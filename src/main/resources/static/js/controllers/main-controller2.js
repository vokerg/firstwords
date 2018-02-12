/**
 * 
 */
angular.module('questionsApp')
.controller('MainController', ['$http', '$scope', '$timeout', '$location', 'questionsService', 
                                  function($http, $scope, $timeout, $location, questionsService) {

	this.currentCorrect = true;
	var mainCtrl = this;
	
	this.putResult = function(selectedAnswer) {
		if (selectedAnswer == questionsService.correctAnswer) {
			this.loadNextQuestion(true);
		} else {
			this.loadNextQuestion(false);
		}
	};
	
	this.getCurrentQuestionList = function() {
		return questionsService.questions;
	};
			
	this.getCorrectAnswer = function() {
		return questionsService.correctAnswer;
	};
	
	this.loadNextQuestion = function(correctPrevious) {
		if (correctPrevious == false)  {
			questionsService.correctAnswers = -1;
			this.currentCorrect = false;
		}
		else {
			questionsService.correctAnswers++;
			this.currentCorrect = true;
		}
		console.log('wordCount=' + questionsService.wordCount + ', correctAnswers=' + questionsService.correctAnswers);
		$http.get('/questions/Home/' + questionsService.wordCount + '/' + questionsService.correctAnswers).success(function(data) {
			if (questionsService.wordCount != data.questions.length) {
				questionsService.correctAnswers = -1;
			}
			questionsService.wordCount = data.questions.length;					
			questionsService.setQuestions(data.questions);
			questionsService.setCorrectAnswer(data.correctAnswer);
			console.log('wordCount=' + questionsService.wordCount + ', correctAnswers=' + questionsService.correctAnswers);

			console.log('completed');
			switch (data.questions.length) {
				case 2: $location.path('/2answers'); break;
				case 3: $location.path('/3answers'); break;
				case 4: $location.path('/4answers'); break;
				case 5: $location.path('/5answers'); break;
				case 6: $location.path('/6answers'); break;
			};					         
		});	
			
		$scope.isShowQuestion = false;
		$timeout(function(){
			responsiveVoice.speak(questionsService.questions[questionsService.correctAnswer].name, "Russian Female");
			$scope.isShowQuestion = true;	
		}, 1000);
	};
	
	this.init = function() {
		console.log("started, " + questionsService.questions.length);
		if ((questionsService.questions.length == null) || (questionsService.questions.length == 0)) {
			mainCtrl.loadNextQuestion(true);	
		} else {
			$scope.isShowQuestion = true;
		}
	}();
	
}]);