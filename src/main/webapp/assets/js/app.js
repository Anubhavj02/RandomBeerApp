var app = angular.module('beerApp', ['ngResource']);

app.factory('Beer', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/RandomBeerApp/beer/:beerId', {beerId: '@id'},
	{
		updateBeer: {method: 'PUT'},
		randomBeer: {method: 'GET', url: 'http://localhost:8080/RandomBeerApp/beerRandom'}
	}
    );
}]);

app.controller('BeerController', ['$scope', 'Beer', function($scope, Beer) {
    var ob = this;
    ob.beers=[];
    ob.beer = new Beer(); 
    // To fetch all the beers
    ob.fetchAllBeers = function(){
        ob.beers = Beer.query();
    };
    ob.fetchAllBeers();
    
    // To add a beer entity
    ob.addBeer = function(){
	if($scope.beerForm.$valid) {
	  ob.beer.$save(function(beer){
	     console.log(beer); 	
	     ob.reset();
	     $('#addBeerModal').modal('hide');
	     ob.fetchAllBeers();
	  },
	  function(err){
	     console.log(err.status);
	  }
          );
        }
    }; 
    // To fetch edit beer entity
    ob.editBeer = function(id){
        ob.beer = Beer.get({ beerId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };
    
    // To fetch update beer entity
    ob.updateBeerDetail = function(){
	if($scope.beerForm.$valid) {
    	   ob.beer.$updateBeer(function(beer){
		ob.updatedId = beer.id;
		$('#editBeerModal').modal('hide');
				ob.reset();
				
    		ob.fetchAllBeers();
           });
	}
    };	
    
    // To fetch delete beer entity
    ob.deleteBeer = function(id){
	    ob.beer = Beer.delete({ beerId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllBeers(); 
	    });
    };		
    
    // To reset the form and beer entity
    ob.reset = function(){
    	ob.beer = new Beer();
        $scope.beerForm.$setPristine();
    };	
    
}]);    

app.controller('RandomBeerController', ['$scope', 'Beer', function($scope, Beer) {
    var ob = this;
    ob.beer = new Beer(); 
    
    //  To fetch Random Beer Entity
    ob.fetchRandomBeer = function(){
        ob.beer = Beer.randomBeer();
    };
    
    ob.fetchRandomBeer();
}]);    
   
   
