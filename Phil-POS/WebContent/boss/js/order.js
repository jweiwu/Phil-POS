
var result = {"heads":[{"createtime":"2016-04-30 21:02:12.0","hid":1,"item":"漢堡"},{"createtime":"2016-04-30 21:05:35.0","hid":2,"item":"飲料"},{"createtime":"2016-05-11 14:19:23.0","hid":9,"item":"點心"}],"meals":[{"active":1,"discount":1.0,"head":"漢堡","hid":1,"meal":"雞排漢堡","mid":8,"price":110},{"active":1,"discount":1.0,"head":"漢堡","hid":1,"meal":"牛肉漢堡","mid":6,"price":20},{"active":1,"discount":1.0,"head":"漢堡","hid":1,"meal":"豬肉漢堡","mid":7,"price":100},{"active":1,"discount":1.0,"head":"飲料","hid":2,"meal":"可口可樂","mid":9,"price":30},{"active":1,"discount":1.0,"head":"飲料","hid":2,"meal":"雪碧","mid":10,"price":30},{"active":1,"discount":1.0,"head":"點心","hid":9,"meal":"薯條","mid":11,"price":20},{"active":1,"discount":1.0,"head":"點心","hid":9,"meal":"雞塊","mid":12,"price":25}]};
var showHeadName = "",headName = "",mealName = "";


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


//RemoveOrder
	function RemoveOrder(){
		
		var a =this.parentNode;
		var b = a.parentNode;
		var c = b.parentNode;
		c.remove();
	}

// 數量加減



	function increase(){
		
		var inputNode = this.parentNode.childNodes[3];
		var price = this.parentNode.childNodes[11].name;
		var value = inputNode.value;
	  	value ++;
	  	this.parentNode.childNodes[3].value = value;

	  	this.parentNode.childNodes[11].value = value * price;

	};

	function decrease(){
		var inputNode = this.parentNode.childNodes[3];
		var value = inputNode.value;
	  	value --;
	  	this.parentNode.childNodes[3].value = value;
	};


// price change



















$(document).ready(function(){

	var source = $("#test-template").html(); 
    var template = Handlebars.compile(source);
    var test ={};

	//Show order
	function ShowOrder(){
		
		mealName = $(this).attr("id");
		for(i = 0 ; i < i < result.meals.length;i++){
			if(mealName == result.meals[i].mid){
				MealData = {
					meal: result.meals[i].meal,
					price: result.meals[i].price
				}
				var html = template(MealData);
				 $(".order-view").append(html);
			}
		}
	}//End of ShowOrder


    // 操作DOM
    $('.item button').on('click',ShowMeal);
	$('#order-main-wrap').on('click','.meal-item',ShowOrder);
	$('.order-view').on('click','.glyphicon-trash',RemoveOrder);
	$('#js-clean-button').on('click',function(){
		$('.menu-item').remove();
	});
	$('.order-view').on('click','.js-plus',increase);
	$('.order-view').on('click','.js-minus',decrease);



	//clean all item
});//End of Ready
   



	



