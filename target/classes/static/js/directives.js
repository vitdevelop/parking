parking.directive("alert", function () {
	return{
		restric: 'E',
		scope:{
			topic: '=topic',
			description: '=description',
			close: '&close'
		},
		templateUrl: "alert.html",
		replace: true
	};
});