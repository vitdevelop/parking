parking.controller("parkingCtrl", function($scope,$http){
	$scope.appTitle = "Parking";
	$scope.cars = [];
	$scope.colors = ["White", "Black", "Blue", "Red", "Silver"];

	$scope.loadCars = function(){
		$http.get('/cars').success(function(response){
			$scope.cars = response;
		});
	};

	$scope.park = function(car) {
		car.entrace = new Date();
		car.price = 10;
		$http.put('/cars',car).success(function (response) {
			$scope.cars.push(car);
		});
	};

	$scope.newCar = function () {
		$scope.car = {
			id:null,
			plate:null,
			color:null,
			entrace:null,
			price:null
		};
	}

	$scope.loadCars();
});