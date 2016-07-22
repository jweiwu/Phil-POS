
$(document).ready(function(){
	$(".test2").on('click',function(){
		var oid = this.value;
		
		$.ajax({
	        url: 'orderLists',
	        type: 'get',
	        data: {
	        	oid : oid
	        },
	        dataType: 'json',
	        success: function (data) {
	            var orderLists = data;
	            console.log(orderLists);
	            
	            // 將結果顯示於畫面
	        }
	    });
		
		// 其他工作

	});
});