var apiclient = (function () {
    
    var getInfoByStock = function (stock){
        
        /*axios.get('https://sparkwebapp-taller01.herokuapp.com/datainfo' + stock)
        .then(response=> Module.showInfo(response.data))
        .catch(error=> console.log(error));*/

        axios.get('http://localhost:4567/data?stock=' + stock)
            .then(response=> Module.showInfo(response.data))
            .catch(error=> console.log(error));
    };

	return {
        getInfoByStock: getInfoByStock
    }
})();