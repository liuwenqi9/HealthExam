var img = document.getElementById("floatdiv");

var x = 0,
	y = 0;

var xSpeed = 2,
	ySpeed = 1;

var w = document.body.clientWidth - 200,
	h = document.body.clientHeight - 100;

function floatdiv() {
	if(x > w || x < 0) xSpeed = -xSpeed;
	if(y > h || y < 0) ySpeed = -ySpeed;

	x += xSpeed;
	y += ySpeed;

	img.style.top = y + "px";
	img.style.left = x + "px";
	setTimeout("floatdiv()", 10);
}
floatdiv();