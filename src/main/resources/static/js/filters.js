parking.filter('plate_whitespace',function(){
    return function (input) {
        var firstPart = input.substring(0,3);
        var secondPart = input.substring(3);
        return firstPart + " - " + secondPart;
    };
});
parking.filter('range',function(){
    return function (input,total) {
        total=parseInt(total);
        for(var i=0;i<total;i++)
            input.push(i);
        return input;
    };
});
