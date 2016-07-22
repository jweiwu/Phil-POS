
var orderLists;

function getOrderLists(oid) {
	var result;
		    $.ajax({
		        url: '192.168.1.158:8080/Phil-POS/orderLists',
		        type: 'get',
		        data: {
		        	oid : oid
		        },
		        dataType: 'json',
		         async: false,
		        success: function (data) {
		            result = data;
		        }
		    });
		return result;
	}

$(document).ready(function(){
	$(".test2").on('click',function(){
		var oid = this.value;
		orderLists = getOrderLists(oid);
		console.log(orderLists);

	});
});