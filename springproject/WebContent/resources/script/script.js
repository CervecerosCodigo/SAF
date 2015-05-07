
function enableEditCustomer(){
	//alert(document.getElementById("firstname").ge);
	document.getElementById("firstname").readOnly = false;
	document.getElementById("lastname").readOnly = false;
	document.getElementById("address1").readOnly = false;
	document.getElementById("address2").readOnly = false;
	document.getElementById("postNumber").readOnly = false;
	document.getElementById("postAddress").readOnly = false;
	document.getElementById("phone").readOnly = false;
	document.getElementById("email").readOnly = false;
	document.getElementById("password").readOnly = false;
	document.getElementById("update_customer").hidden = false;
	document.getElementById("edit_link").hidden = true;
	document.getElementById("cancel_edit_link").hidden = false;
}

function disableEditCustomer(){
	//alert(document.getElementById("firstname").ge);
	document.getElementById("firstname").readOnly = true;
	document.getElementById("lastname").readOnly = true;
	document.getElementById("address1").readOnly = true;
	document.getElementById("address2").readOnly = true;
	document.getElementById("postNumber").readOnly = true;
	document.getElementById("postAddress").readOnly = true;
	document.getElementById("phone").readOnly = true;
	document.getElementById("email").readOnly = true;
	document.getElementById("password").readOnly = true;
	document.getElementById("update_customer").hidden = true;
	document.getElementById("edit_link").hidden = false;
	document.getElementById("cancel_edit_link").hidden = true;
	
}
