var apiclient = (function () {
    
    var getInfoByStock = function (stock){
        axios.get('https://sparkwebapp-taller01.herokuapp.com/' + stock)
            .then(response=> Module.showInfo(response.data))
            .catch(error=> console.log(error));
    };

	return {
        getInfoByStock: getInfoByStock
    }
})();