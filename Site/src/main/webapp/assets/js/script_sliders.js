/**
 * Faz a animação dos sliders
 */

$(function() {
	$('.sliderprincipal').bxSlider({
		mode : 'fade',
		captions : true,
		auto : true,
		autoControls : true
	});
	$('.slidercidades').bxSlider({
		minSlides : 1,
		maxSlides : 3,
		slideWidth : 400,
		auto : true,
		autoControls : false,
		nextSelector : '#',
		prevSelector : '#'
	});

});