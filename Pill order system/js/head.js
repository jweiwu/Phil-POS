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

	$(".menu-icon").click(function() {
  		$(this).toggleClass("active");
  		$(".overlay-menu").toggleClass("open");
    });

});

