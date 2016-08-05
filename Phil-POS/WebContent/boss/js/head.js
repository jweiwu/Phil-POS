
var totalData = {"overall":{"discount":0,"total":6375},"detail":[{"amount":320,"meal":"牛肉漢堡","mid":6,"number":16},{"amount":800,"meal":"豬肉漢堡","mid":7,"number":8},{"amount":2310,"meal":"雞排漢堡","mid":8,"number":21},{"amount":90,"meal":"可口可樂","mid":9,"number":3},{"amount":120,"meal":"雪碧","mid":10,"number":4},{"amount":40,"meal":"薯條","mid":11,"number":2},{"amount":25,"meal":"雞塊","mid":12,"number":1}]}

$(document).ready( function () {
    $('#table_id').DataTable();
//刪除類別
    $('td').on('click','span',function(){
    	var x = this.parentElement;
    	var y = x.parentElement;
    	$(y).fadeOut('slow',function(){
    	$(this).remove();
	    });
	});


    var template = Handlebars.templates.nav;
    $('#nav-template').html(template);


});

var detail_length = totalData.detail.length;
var total = 0;
for(let i = 0 ; i < detail_length ;i++){
$('#total-detail').append("<tr><td>"+totalData.detail[i].meal+"</td><td>"+totalData.detail[i].number+"</td><td>"+totalData.detail[i].amount+"</td></tr>");
total += totalData.detail[i].amount;
}

$('#account-detail').html("<td>"+total+"</td><td>"+totalData.overall.discount+"</td><td>"+totalData.overall.total+"</td>");



