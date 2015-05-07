parking.controller("parkingCtrl", function($scope,$http,$filter){
	$scope.appTitle = $filter("uppercase")("Parking");
	$scope.cars = [];
	$scope.colors = ["White", "Black", "Blue", "Red", "Silver"];
	$scope.delete_button = false;

	$scope.properties={
		totalPages:null,
		last:null,
		size:10,
		first:null,
		page:0
	};


	$scope.loadCars = function(page){
		$http.get('/api/v1.0.0/cars/'+page+'/10').success(function(response){
			$scope.cars = response.content;
			$scope.properties.totalPages = response.totalPages;
			$scope.properties.last = response.last;
			$scope.properties.first = response.first;
			$scope.properties.page = page;
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
		$http.delete('/api/v1.0.0/cars/'+car.id).success(function (response) {
			$scope.cars = _.reject($scope.cars, function (item) {
				return item.id === car.id;
			});
		});
	};

	$scope.saveCar = function (car) {
		if(car.id){
			$http.put('/api/v1.0.0/cars/'+car.id,car).success(function(response){
				_.forEach($scope.cars, function(item,index){
					if(item.id === car.id){
						$scope.cars[index] == response;
					}
				});
			});
		}else{
			car.entrace = new Date();
			$http.put('/api/v1.0.0/cars',car).success(function (response) {
				$scope.cars.push(response);
			});
		}
	};

	$scope.editCar = function (car) {
		$scope.car = car;
	};

	$scope.nextPage = function () {
		if($scope.properties.page < $scope.properties.totalPages){
			$scope.properties.page++;
			$scope.loadCars($scope.properties.page);
		}
	};

	$scope.previousPage = function () {
		if($scope.properties.page > 0){
			$scope.properties.page--;
			$scope.loadCars($scope.properties.page);
		}
	};

	$scope.loadCars($scope.properties.page);
});