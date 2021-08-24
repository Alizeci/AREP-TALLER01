var Module = (() => {
    
    const showInfo = (infoStock) => {
        console.log(infoStock);
        document.getElementById("stockInfo").innerHTML = 'Historical data for ' + infoStock.name;
        _completeTable(infoStock);
    };

    const _completeTable = function (infoStock) {
        $(document).ready(function () {
            var fila= $("#infoStockId");
            console.log(infoStock.timeLine["2021-04-01"]);

            for (let ad_date in infoStock.timeLine) {
                console.log(ad_date);
                console.log(infoStock.timeLine[ad_date]);
                var markup = "<tr><td>" +
                ad_date +
                "</td><td>" +
                infoStock.timeLine[ad_date].open + 
                "</td><td>"+
                infoStock.timeLine[ad_date].high +
                "</td><td>"+
                infoStock.timeLine[ad_date].low + 
                "</td><td>"+
                infoStock.timeLine[ad_date].close + 
                "</td><td>"+
                infoStock.timeLine[ad_date].volume + 
                "</td></tr>";
                fila.append(markup);
            }
            //$('#table').dataTable();
        });
        
    };

    const _cleanTable = function () {
        $(document).ready(function () {
            $("table")
                .find("td")
                .each(function () {
                    $(this).parents("tr").remove();
                });
        });
    };

    const getInfoByStock = () => {
        _cleanTable();
        stock = $("#stockName").val();
        apiclient.getInfoByStock(stock);
    };

	return {
		getInfoByStock: getInfoByStock,
        showInfo: showInfo
	}
})();