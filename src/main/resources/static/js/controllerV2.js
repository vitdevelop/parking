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
		$http.get('/api/v2.0.0/car?page='+page+'&size=10&sort=entrace,desc').success(function(response){
			$scope.cars = response._embedded.car;
			$scope.properties.totalPages = response.page.totalPages;
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
		$http.delete('/api/v2.0.0/car/'+car.id).success(function (response) {
			$scope.cars = _.reject($scope.cars, function (item) {
				return item.id === car.id;
			});
		});
	};

	$scope.saveCar = function (car) {
		if(car.id){
			$http.post('/api/v2.0.0/car/'+car.id,car).success(function(response){
				_.forEach($scope.cars, function(item,index){
					if(item.id === car.id){
						$scope.cars[index] == response;
					}
				});
			});
		}else{
			car.entrace = new Date();
			$http.put('/api/v2.0.0/car',car).success(function (response) {
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