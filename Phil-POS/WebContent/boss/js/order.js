
var result = {"heads":[{"createtime":"2016-04-30 21:02:12.0","hid":1,"item":"漢堡"},{"createtime":"2016-04-30 21:05:35.0","hid":2,"item":"飲料"},{"createtime":"2016-05-11 14:19:23.0","hid":9,"item":"點心"}],"meals":[{"active":1,"discount":1.0,"head":"漢堡","hid":1,"meal":"雞排漢堡","mid":8,"price":110},{"active":1,"discount":1.0,"head":"漢堡","hid":1,"meal":"牛肉漢堡","mid":6,"price":20},{"active":1,"discount":1.0,"head":"漢堡","hid":1,"meal":"豬肉漢堡","mid":7,"price":100},{"active":1,"discount":1.0,"head":"飲料","hid":2,"meal":"可口可樂","mid":9,"price":30},{"active":1,"discount":1.0,"head":"飲料","hid":2,"meal":"雪碧","mid":10,"price":30},{"active":1,"discount":1.0,"head":"點心","hid":9,"meal":"薯條","mid":11,"price":20},{"active":1,"discount":1.0,"head":"點心","hid":9,"meal":"雞塊","mid":12,"price":25}]};



var orderList = [];
var showHeadName = "",headName = "",mealName = "";
var itemIdNum = 0;  //計算點擊幾次餐點
var allprice = 0;	//總共的金額

//清空訂單
function cleanOrderList(){
	orderList.length = 0;
}



// Show Headname
for (i = 0; i < result.heads.length; i++) {
				showHeadName += '<div class="item col-md-3"><button id="'+result.heads[i].hid+'">'+result.heads[i].item+'</button></div>'
			}
$("#category").html(showHeadName);
// End of Show Head name




// Show Meal
function ShowMeal(){
	var showMealName = "";
	headName = $(this).attr("id");
	for(i = 0; i < result.meals.length;i++){
		if(headName == result.meals[i].hid){
				showMealName += '<div id="'+result.meals[i].mid+'"class="meal-item"><i class="glyphicon glyphicon-shopping-cart"></i><h3>'+result.meals[i].meal+'</h3><p>$'+result.meals[i].price+'</p></div>'	
			}
	}
	$('#order-main-wrap').html(showMealName);
};

function RemoverAllOrder(){
	cleanOrderList();
	itemIdNum = 0;  
	allprice = 0;
	allpriceNum.value = allprice;
	$("#js-order-view").empty();

}


//RemoveOrder
	function RemoveOrder(){
		var row = this.parentNode;
		var rowChild = this.parentNode.childNodes[11].value; 
		allprice = allprice - rowChild;
		allpriceNum.value = allprice ;
		orderList[0]= allprice;
		var menuItem = row.parentNode;
		var myid = parseInt(menuItem.id); //抓到個別餐點訂單的ID編號

		orderList[myid].order = false;
		menuItem.remove();
	}

// 數量加減
	function increase(){
		var row = this.parentNode;
		var menuItem = row.parentNode;
		var myid = parseInt(menuItem.id);
		var inputNode = row.childNodes[3];
		var price = parseInt(row.childNodes[11].name);
		var value = inputNode.value;
	  	value ++;
	  	orderList[myid].quantity = value;
	  	row.childNodes[3].value = value;
	  	row.childNodes[11].value = value * price;
	  	allprice = allprice + price ;
	  	orderList[0]= allprice;
	  	allpriceNum.value = allprice ;

	};

	function decrease(){
		var row = this.parentNode;
		var menuItem = row.parentNode;
		var myid = parseInt(menuItem.id);
		var inputNode = row.childNodes[3];
		var price = parseInt(row.childNodes[11].name);
		var value = inputNode.value;
	  	value --;
	  	orderList[myid].quantity = value;
	  	row.childNodes[3].value = value;
	  	row.childNodes[11].value = value * price;
	  	allprice = allprice - price ;
	  	orderList[0]= allprice;
	  	allpriceNum.value = allprice ;


	};
//get ID 
var jsTest = document.getElementById('js-test');
var allpriceNum = document.getElementById('allpriceNum');

$(document).ready(function(){
	


	 // 操作DOM
	$('.item button').on('click',ShowMeal);
	$('#order-main-wrap').on('click','.meal-item',ShowOrder);
	$('.order-view').on('click','.glyphicon-trash',RemoveOrder);//clean all item
	$('#js-clean-button').on('click',RemoverAllOrder);
	$('.order-view').on('click','.js-plus',increase);
	$('.order-view').on('click','.js-minus',decrease);
	
	jsTest.addEventListener('click',function(){
			$('#js-total').val(allprice);
			event.preventDefault();
			exportOrderList(itemIdNum);
	     	RemoverAllOrder();
			// var itemView = document.getElementById('js-order-view')
	
			// for (i = 1 ;i<4 ;i=i+2){
			// 	var allItems = itemView.childNodes[i];
			// 	var row = allItems.childNodes[1];
			// 	var rowChild = row.childNodes;
			// 	alert(rowChild[3]);
			// }

	},false);
			

		

//handlebars 
	var source = $("#test-template").html(); 
	var source2 = $("#export-template").html(); 
    var template = Handlebars.compile(source);
    var template2 = Handlebars.compile(source2);
   



	//輸出訂單
	function exportOrderList(Num){
		this.itemIdNum = Num;
		for(i = 1; i<=itemIdNum ;i++){
		
			var html = template2(orderList[i]);
			$("#export").append(html);
		}
	}




	//Show order
	function ShowOrder(){

		itemIdNum++;
		mealName = $(this).attr("id");
		for(i = 0 ;  i < result.meals.length;i++){
			if(mealName == result.meals[i].mid){
				MealData = {
					mid: result.meals[i].mid,
					meal: result.meals[i].meal,
					price: result.meals[i].price,
					id: itemIdNum
				}

				orderList[itemIdNum] = {
					order: true,
					mid: result.meals[i].mid,
					meal: result.meals[i].meal,
					price: result.meals[i].price,
					quantity: 1
				};

				allprice = allprice + MealData.price;
				allpriceNum.value = allprice ;
				var html = template(MealData);
				 $("#js-order-view").append(html);
			}
		}
	}//End of ShowOrder
});//End of Ready
   


// <!-- order -->
// 	<input name="order.discount" type="text" value="10">
// 	<input name="order.total" type="text" value="500"><br><br>

// <!-- order list -->
// 	<input name="orderList[0].mid" type="text" value="6">
// 	<input name="orderList[0].quantity" type="text" value="1"><br>
// 	<input name="customList[0].mid" type="text" value="6">
// 	<input name="customList[0].cid" type="text" value="1"><br>
	
// 	<input name="orderList[3].mid" type="text" value="9">
// 	<input name="orderList[3].quantity" type="text" value="2"><br>
	
// 	<input name="orderList[4].mid" type="text" value="10">
// 	<input name="orderList[4].quantity" type="text" value="1"><br>
// 	<input name="customList[4].mid" type="text" value="10">
// 	<input name="customList[4].cid" type="text" value="3"><br>
	



