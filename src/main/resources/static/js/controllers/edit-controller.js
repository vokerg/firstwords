/**
 * 
 */

angular.module('editController', [])
.controller('EditController', ['$http', function($http) {
	var editCtrl = this;
	this.questions = model.questions;
	this.showEditId = -1;
	
	this.refreshQuestions = function() {
		editCtrl.masters = [];
		$http.get('/master').success(function(data) {
			editCtrl.questions = data;
			model.questions = data;
			editCtrl.showEditId = -1;
		});
	};
	
}]);