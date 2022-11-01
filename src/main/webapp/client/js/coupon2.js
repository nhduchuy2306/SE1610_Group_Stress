

function changeFunc() {
	var selectCoupon = document.getElementById("selectCoupon");
	var selectedValue = selectCoupon.options[selectCoupon.selectedIndex].value;
	console.log(selectedValue*10);
	var defaultTotalPrice=document.getElementById("default-totalPrice");
	var resetTotal=defaultTotalPrice.value - defaultTotalPrice.value * (selectedValue/100);
	document.getElementById("totalPrice").value=resetTotal;

	document.getElementById("totalPrice-span").innerHTML=resetTotal + 'VND' ;
	console.log(resetTotal);
}
