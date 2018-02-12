angular.module('questionsService', [])
.service("questionsService", function() {
	this.questions = {};
	this.correctAnswer = 0;
});
