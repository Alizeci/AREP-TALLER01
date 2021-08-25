var apiclient = (function () {
    
    var getInfoByStock = function (stock, timePeriod){
        
        /*Heroku Endpoint*/
        /*axios.get('https://sparkwebapp-taller01.herokuapp.com/data?stock=' + stock+"&period="+timePeriod)
        .then(response=> Module.showInfo(response.data))
        .catch(error=> console.log(error));*/
        
        /*Localhost Endpoint*/
        axios.get('http://localhost:4567/data?stock=' + stock+"&period="+timePeriod)
            .then(response=> Module.showInfo(response.data))
            .catch(error=> console.log(error));
    };

	return {
        getInfoByStock: getInfoByStock
    }
})();