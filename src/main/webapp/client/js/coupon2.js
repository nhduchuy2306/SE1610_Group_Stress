

function changeFunc() {
	var selectCoupon = document.getElementById("selectCoupon");
	var defaultTotalPrice=document.getElementById("default-totalPrice");
	var accountBalance=document.getElementById('accountBalance');
	var selectedValue = selectCoupon.options[selectCoupon.selectedIndex].value;
	
	if (selectedValue==0) {
		document.getElementById("totalPrice").value=defaultTotalPrice.value;
		document.getElementById("totalPrice-span").innerHTML=defaultTotalPrice.value + 'VND' ;
	}
	else{
		var resetTotal=defaultTotalPrice.value - defaultTotalPrice.value * (selectedValue/100);
		document.getElementById("totalPrice").value=resetTotal;
		document.getElementById("totalPrice-span").innerHTML=resetTotal + 'VND' ;
		// console.log(resetTotal);
	}

	var totalPrice=document.getElementById("totalPrice");
	console.log("accountBalance:" + accountBalance.value);
	console.log("totalPrice: "+totalPrice.value);
	console.log("Compare:" + accountBalance.value>totalPrice.value);

	if (accountBalance.value>resetTotal) {
		document.getElementById('payingAccount').style.display='block';
		console.log("totalPrice: "+totalPrice.value);
	}else{
		 document.getElementById('payingAccount').style.display='none';
		 console.log("not");
	}
}
