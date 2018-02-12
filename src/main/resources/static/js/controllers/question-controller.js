/**
 * 
 */

angular.module('questionsApp')
	.controller('QuestionController', ['$http', function($http) {
		this.question = {};
		this.addQuestion = function(question) {
			model.questions.push(question);
			this.question = {};
		}
}]); 