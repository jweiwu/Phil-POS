
var result = {"heads":[{"createtime":"2016-04-30 21:02:12.0","hid":1,"item":"漢堡"},{"createtime":"2016-04-30 21:05:35.0","hid":2,"item":"飲料"},{"createtime":"2016-05-11 14:19:23.0","hid":9,"item":"點心"}],"meals":[{"active":1,"discount":1.0,"head":"漢堡","hid":1,"meal":"雞排漢堡","mid":8,"price":110},{"active":1,"discount":1.0,"head":"漢堡","hid":1,"meal":"牛肉漢堡","mid":6,"price":20},{"active":1,"discount":1.0,"head":"漢堡","hid":1,"meal":"豬肉漢堡","mid":7,"price":100},{"active":1,"discount":1.0,"head":"飲料","hid":2,"meal":"可口可樂","mid":9,"price":30},{"active":1,"discount":1.0,"head":"飲料","hid":2,"meal":"雪碧","mid":10,"price":30},{"active":1,"discount":1.0,"head":"點心","hid":9,"meal":"薯條","mid":11,"price":20},{"active":1,"discount":1.0,"head":"點心","hid":9,"meal":"雞塊","mid":12,"price":25}]};



var str = "";

var headname = "";

for (i = 0; i < result.heads.length; i++) {
				str += '<div class="item col-md-3"><button id="'+result.heads[i].hid+'">'+result.heads[i].item+'</button></div>'
				
			}
$("#category").html(str);




$('.item button').on('click',function(){

var test = "";

	headname = $(this).attr("id");
	for(i = 0; i < result.meals.length;i++){
		if(headname == result.meals[i].hid){
				test += '<div class="meal-item"><i class="glyphicon glyphicon-shopping-cart"></i><h3>'+result.meals[i].meal+'</h3><p>$'+result.meals[i].price+'</p></div>'	
			}


	}

	$('#order-main-wrap').html(test);

});



var num = document.getElementById('num');

var template = Handlebars.templates.nav;
$('#nav-template').html(template);