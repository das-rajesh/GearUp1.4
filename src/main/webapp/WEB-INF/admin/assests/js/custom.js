var hamMenu = $('.hamburger-menu');
var sideMenu = $('.side-navigation');
var topMenu = $('.top-navigation');
var mainContent = $('.main-content');
hamMenu.click(function(e){
        // toggle side nav width to 275px and 75px
        sideMenu.toggleClass('toggle-side');
        topMenu.toggleClass('toggle-section');
        mainContent.toggleClass('toggle-section');
    }
);
// // toggle selling price section

// hide selling section
$('.sale-section').hide();
// checking for change in state
$('#onSale').change(function(e)
{
	//checking onSale button status
	if (this.checked) {
		$('.sale-section').show();
	} else {
		$('.sale-section').hide();
	}
});

// state change

$('.sale-section input').click(function(e)
{
	var value = $('.sale-section input:checked').val();

	if (value == 1) {
		var discount = $('#discount').val('0');
		$('#salePrice').val($('#price').val());
		$('#discount').change(function(e){
			var price = $('#price').val();
			var discount = $('#discount').val();

			var amount = price - discount;

			$('#salePrice').val(amount);
		});
	} else {
		var discount = $('#discount').val('0');
		$('#salePrice').val($('#price').val());
		$('#discount').change(function(e){
			var price = $('#price').val();
			var discount = $('#discount').val();

			var amount = price - discount/100 * price;

			$('#salePrice').val(amount);
		});
	}
});


$( window ).scroll(function() {
	var height = $(window).scrollTop();

    if(height  > 50) {
		$('.nav-left').removeClass('hide');
		$('.nav-logo').addClass('hide');
		$('.navigation').addClass('navbar-scroll');
    }else{
		$('.nav-left').addClass('hide');
		$('.nav-logo').removeClass('hide');
		$('.navigation').removeClass('navbar-scroll');
	}
	
});

// dropdown filter
$("#category").change(function(){
	var category_id = $("#category").val();
	$.get("/child/"+category_id, function(data, status){
		$(".child_category_item").remove();
		$.each(data, function(index, value){
			var row = "<option class='child_category_item' value='"+value.id+"'>"+value.name+"</option>";
			$("#child_category").append(row);
		});
	});
	
});

// 
$('.tr-img').click(function(){
	var addInput = "<div class='form-group'><label>Size</label><input type='text' name='size[]' placeholder='Size' class='form-control'></div><div class='form-group'><label>Quantity</label><input type='Number' name='quantity[]' class='form-control' placeholder='Quantity' ></div>";
	$('.addRow').append(addInput);
	console.log(i);	
})