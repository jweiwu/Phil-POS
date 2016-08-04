//var test = {"orderLists":[{"meal":"牛肉漢堡","mid":6,"oid":30,"price":20,"quantity":1},{"meal":"豬肉漢堡","mid":7,"oid":30,"price":100,"quantity":1},{"meal":"雞排漢堡","mid":8,"oid":30,"price":110,"quantity":1}]};

$(document).ready(function(){
	$(".order-detail").on('click',function(){
		var oid = this.value;
		$(".pop").fadeIn(300);
		
		$.ajax({
	         url: 'orderLists',
	         type: 'get',
	         data: {
	         	oid : oid
	         },
	         dataType: 'json',
	         success: function (test) {
	        	// Show and analyze the obtained JSON
	        	 
	             for(i=0 ;i<test.orderLists.length;i++){
	     			let meal = test.orderLists[i].meal;
	     			let price = test.orderLists[i].price;
	     			let quantity = test.orderLists[i].quantity

	     			$(".pop table").append("<tr class='delete'><td>"+meal+"</td><td>"+quantity+"</td><td>"+price+"</td></tr>");
	     		 }
	             
	         }
	    });
		
		// other works

	});
});	

 $(".pop > span, .pop").click(function () {
     $(".pop").fadeOut(300);
     $('.delete').remove();
 });

