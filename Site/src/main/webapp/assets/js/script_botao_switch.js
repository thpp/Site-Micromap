/**
 * Rotaciona o ícone público / privado
 */

function rotacionarIconeDireita() {

	var div = document.getElementById('icone'), deg = 66;

	div.style.webkitTransform = 'rotate(' + deg + 'deg)';
	div.style.mozTransform = 'rotate(' + deg + 'deg)';
	div.style.msTransform = 'rotate(' + deg + 'deg)';
	div.style.oTransform = 'rotate(' + deg + 'deg)';
	div.style.transform = 'rotate(' + deg + 'deg)';

}

function rotacionarIconeEsquerda() {

	var div = document.getElementById('icone'), deg = 0;

	div.style.webkitTransform = 'rotate(' + deg + 'deg)';
	div.style.mozTransform = 'rotate(' + deg + 'deg)';
	div.style.msTransform = 'rotate(' + deg + 'deg)';
	div.style.oTransform = 'rotate(' + deg + 'deg)';
	div.style.transform = 'rotate(' + deg + 'deg)';

}