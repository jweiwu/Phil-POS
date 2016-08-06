

var month = []

$(document).ready( function () {



    var template = Handlebars.templates.nav;
    $('#nav-template').html(template);
    
    var year = 2016;
    var month = 8;
    var day = 1;

    $('.daypick').on('click',function(){
//    	$('#account-detail td').remove();
		var m = $("#date").val().split("-",3);;
		
	 
		for(let i = 0; i<m.length;i++){
			m[i] = parseInt(m[i]);
		}

		year = m[0];
		month =m[1];
		day = m[2];
		
		getAccData(year, month, day);
	
	});
    

    
});

function getAccData() {
	
	if (arguments.length == 2) {
	    $.ajax({
	        url: 'boss/monthlyAcc',
	        type: 'get',
	        data: {
	        	year : arguments[0],
	        	month : arguments[1]
	        },
	        dataType: 'json',
	        success: function (totalData) {
	        	buildAccTable(totalData);
	        }
	    });

		
	} else if (arguments.length == 3) {
	    $.ajax({
	        url: 'boss/dailyAcc',
	        type: 'get',
	        data: {
	        	year : arguments[0],
	        	month : arguments[1],
	        	day : arguments[2]
	        },
	        dataType: 'json',
	        success: function (totalData) {
	        	buildAccTable(totalData);
	        }
	    });

	}
}

function buildAccTable(totalData) {
	$('#total-detail td').remove();
	var detail_length = totalData.detail.length;
	var total = 0;
	for(let i = 0 ; i < detail_length ;i++){
		$('#total-detail').append("<tr><td>"+totalData.detail[i].meal+"</td><td>"+totalData.detail[i].number+"</td><td>"+totalData.detail[i].amount+"</td></tr>");
		total += totalData.detail[i].amount;
	}

	$('#account-detail').html("<td>"+total+"</td><td>"+totalData.overall.discount+"</td><td>"+totalData.overall.total+"</td>");
    $('#table_id').DataTable();

}
