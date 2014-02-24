$(document).ready(function()
{
	$('.accordion-header').toggleClass('inactive-header');
	$('.accordion-header').click(function () {
		$(this).find(".plus").toggleClass("minus");
		if($(this).is('.inactive-header')) {
				$(this).next().slideToggle().toggleClass('open-content');		
		}
		else {
			$(this).next().slideToggle().toggleClass('open-content');
		}
	});
	
	return false;
});