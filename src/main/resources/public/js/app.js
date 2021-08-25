var Module = (() => {
    
    const showInfo = (infoStock) => {
        console.log(infoStock);
        document.getElementById("stockInfo").innerHTML = 'Historical data for ' + infoStock.name;
        _completeTable(infoStock);
    };

    const _completeTable = function (infoStock) {
        $(document).ready(function () {
            var fila= $("#infoStockId");
            
            for (let ad_date in infoStock.timeLine) {
                //console.log(ad_date);
                //console.log(infoStock.timeLine[ad_date]);
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

    const getChecked = () => {
        const btn = document.querySelector('#gb');
        // handle button click
        btn.onclick = function () {
          const rbs = document.querySelectorAll('input[name="btnradio"]');
          let selectedValue;

          for (const rb of rbs) {
            if (rb.checked) {
              selectedValue = rb.value;
              getInfoByStock(selectedValue);
              rb.checked = false;
              break;
            }
          }
        };
    }

    const getInfoByStock = (selectedValue) => {
        _cleanTable();
        stock = $("#stockName").val();
        apiclient.getInfoByStock(stock, selectedValue);
    };

	return {
		getInfoByStock: getInfoByStock,
        showInfo: showInfo,
        getChecked: getChecked
	}
})();