
var data = {
      menu_name: "hambuger",     
      price: "$10"
      };

var source =    $("#order-template").html(); 
var template = Handlebars.compile(source);




$('button').click(order);
function order(){
 var html = template(data);
 $(".list").append(html);
};



var num = document.getElementById('num');

$('div .glyphicon-trash').click(function(){
	// num = this.num;
	num_value = num.value;
	alert(num_value);
});



var template = Handlebars.templates.nav;
$('#nav-template').html(template);