parking.controller("parkingCtrl", function($scope,$http,$filter){
	$scope.appTitle = $filter("uppercase")("Parking");
	$scope.cars = [];
	$scope.colors = ["White", "Black", "Blue", "Red", "Silver"];
	$scope.delete_button = false;

	$scope.loadCars = function(){
		$http.get('/cars').success(function(response){
			$scope.cars = response;
		});
	};

	$scope.park = function(car) {
		car.entrace = new Date();
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
	};

	$scope.deleteCar = function(car){
		$http.delete('/cars/'+car.id).success(function (response) {
			$scope.cars = _.reject($scope.cars, function (item) {
				return item.id === car.id;
			});
		});
	};

	$scope.loadCars();
});