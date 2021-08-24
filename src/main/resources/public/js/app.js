var Module = (() => {
    
    const showInfo = (infoStock) => {
        document.getElementById("header").innerHTML = 'Current Stock data for ' + infoStock.name;
        _completeTable(infoStock);
    };

    const _completeTable = function (infoStock) {
        $(document).ready(function () {
            let fields =
                "<tr><td>" +
                infoStock.coord.lat +
                "</td><td>" +
                infoStock.coord.lon + 
                "</td></tr>";
            $("table").append(fields);
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