var test = {"orderLists":[{"meal":"牛肉漢堡","mid":6,"oid":30,"price":20,"quantity":1},{"meal":"豬肉漢堡","mid":7,"oid":30,"price":100,"quantity":1},{"meal":"雞排漢堡","mid":8,"oid":30,"price":110,"quantity":1}]};

$(document).ready(function(){
	 // $("button").click(function () {
        
  //    });
	$(".order-detail").on('click',function(){
		 $(".pop").fadeIn(300);
         // positionPopup();
		for(i=0 ;i<test.orderLists.length;i++){
			let meal = test.orderLists[i].meal;
			let price = test.orderLists[i].price;
			let quantity = test.orderLists[i].quantity

			$(".pop table").append("<tr class='delete'><td>"+meal+"</td><td>"+quantity+"</td><td>"+price+"</td></tr>");
		}

		
		
		// $.ajax({
	 //        url: 'http://192.168.1.158:8080/Phil-POS/orderLists',
	 //        type: 'get',
	 //        data: {
	 //        	oid : oid
	 //        },
	 //        dataType: 'json',
	 //        success: function (data) {
	 //            var orderLists = data;
	 //            console.log(orderLists);
	            
	 //            // 將結果顯示於畫面
	 //        }
	 //    });
		
		// 其他工作

	});
});


	

     $(".pop > span, .pop").click(function () {
         $(".pop").fadeOut(300);
         $('.delete').remove();
     });

