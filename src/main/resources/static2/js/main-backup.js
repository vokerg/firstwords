(function(){
	var app=angular.module('questionsApp', ['ngRoute']);
	/*
	app.filter("trustUrl", ['$sce', function ($sce) {
        return function (recordingUrl) {
            return $sce.trustAsResourceUrl(recordingUrl);
        };
    }]);
	*/
	app.service("questionsService", function() {
		this.questions = {};
		this.setQuestions = function (questionList) {
			this.questions = questionList;
		}
		this.correctAnswer;
		this.setCorrectAnswer = function(answer) {
			this.correctAnswer = answer;
		}
		this.wordCount = 2;
		this.correctAnswers = -1;
	});
	
	
	app.config(['$routeProvider', function($routeProvider){
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
	}]);
	

	var model={
			   questions:[
			                {  
			                   "id":1,
			                   "name":"Вертолет",
			                   imgSrc:"http://www.ap7.ru/wp-content/uploads/2015/07/Novyiy-rossiyskiy-chudo-vertolet.jpg",
			                   "audioSrc":"samolet.m4a",
			                   "categories":[  
			                      {  
			                         "id":1,
			                         "catName":"Avia",
			                         "questions":[  

			                         ]
			                      }
			                   ]
			                },
			                {  
			                   "id":2,
			                   "name":"Самолет",
			                   imgSrc:"http://in-news.ru/images/stories/news-rasskazova/samolet-shassi.jpg",
			                   "audioSrc":"samolet.m4a",
			                   "categories":[  
			                      {  
			                         "id":1,
			                         "catName":"Avia",
			                         "questions":[  

			                         ]
			                      }
			                   ]
			                }
			             ],
			             "correctAnswer":"0"
			          };
/**/

	app.controller('EditController', ['$http', function($http) {
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
	
	app.controller('QuestionController', ['$http', function($http) {
		this.question = {};
		this.addQuestion = function(question) {
			model.questions.push(question);
			this.question = {};
		}
	}]);
	
	
	app.controller('MainController', ['$http', '$scope', '$timeout', '$location', 'questionsService', 
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
})();