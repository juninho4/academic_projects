function validateForm() {
	var f_name = document.forms["my_form"]["fName"].value;
	var l_name = document.forms["my_form"]["lName"].value;
	var email = document.forms["my_form"]["email"].value;
	var phone = document.forms["my_form"]["phone"].value;
	
	if(f_name == "") {
		alert("First Name must be filled out");
		return false;
	}
	if(l_name == "") {
		alert("Last Name must be filled out");
		return false;
	}
	if(email == "") {
		alert("Email must be filled out");
		return false;
	}
	if(isNaN(phone) || phone == "") {
		alert("Invalid Phone Number");
		return false;
	}
}

// Hamburger menu function
function hamburger() {
	var menu = document.getElementById("menu-links");
	// var nav = document.getElementByClassName("mobile-nav")[0];
	if(menu.style.display === "block") {
		menu.style.display = "none";
		// nav.style.height = "auto";
	} else {
		menu.style.display = "block";
		// nav.style.height = "auto";
	}
}