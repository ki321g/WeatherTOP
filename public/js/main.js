// The following code is used to toggle menu

const burgerIcon = document.querySelector('#burger');
const navbarMenu = document.querySelector('#nav-links');
const deleteStation = document.querySelector('#delete-station');
const deleteReading = document.querySelector('#delete-reading');
burgerIcon.addEventListener('click', () => {
	navbarMenu.classList.toggle('is-active');
});


// Validates addReading Form
function validateReadingForm() {
	var valid = true;
	var checkCode = document.forms["addReading"]["code"].value;
	var checkTemperature = document.forms["addReading"]["temperature"].value;
	var checkWindSpeed = document.forms["addReading"]["windSpeed"].value;
	var checkWindDirection = document.forms["addReading"]["windDirection"].value;
	var checkPressure = document.forms["addReading"]["pressure"].value;

	if (checkCode == "") {
		document.forms["addReading"]["code"].classList.add('is-danger');
		document.getElementById("selectCode").classList.add('is-danger');
		document.getElementById("errTemperature").style.display = "block";
		document.getElementById("errCode").innerHTML = "Select a Code";
		valid = false;
	} else {
		document.forms["addReading"]["code"].classList.add('is-success');
		document.forms["addReading"]["code"].classList.remove('is-danger');
		document.getElementById("selectCode").classList.add('is-success');
		document.getElementById("selectCode").classList.remove('is-danger');
		document.getElementById("errCode").style.display = "none";
	}

	if (checkTemperature == "") {
		document.forms["addReading"]["temperature"].classList.add('is-danger');
		document.getElementById("errTemperature").style.display = "block";
		document.getElementById("errTemperature").innerHTML = "Enter the Temperature";
		valid = false;
	} else {
		document.forms["addReading"]["temperature"].classList.add('is-success');
		document.forms["addReading"]["temperature"].classList.remove('is-danger');
		document.getElementById("errTemperature").style.display = "none";
	}

	if (checkWindSpeed == "") {
		document.forms["addReading"]["windSpeed"].classList.add('is-danger');
		document.getElementById("errWindSpeed").style.display = "block";
		document.getElementById("errWindSpeed").innerHTML = "Enter the Wind Speed";
		valid = false;
	} else {
		document.forms["addReading"]["windSpeed"].classList.add('is-success');
		document.forms["addReading"]["windSpeed"].classList.remove('is-danger');
		document.getElementById("errWindSpeed").style.display = "none";
	}

	if (checkWindDirection == "") {
		document.forms["addReading"]["windDirection"].classList.add('is-danger');
		document.getElementById("errWindDirection").style.display = "block";
		document.getElementById("errWindDirection").innerHTML = "Enter the Wind Speed";
		valid = false;
	} else {
		document.forms["addReading"]["windDirection"].classList.add('is-success');
		document.forms["addReading"]["windDirection"].classList.remove('is-danger');
		document.getElementById("errWindDirection").style.display = "none";
	}

	if (checkPressure == "") {
		document.forms["addReading"]["pressure"].classList.add('is-danger');
		document.getElementById("errPressure").style.display = "block";
		document.getElementById("errPressure").innerHTML = "Enter the Pressure";
		valid = false;
	} else {
		document.forms["addReading"]["pressure"].classList.add('is-success');
		document.forms["addReading"]["pressure"].classList.remove('is-danger');
		document.getElementById("errPressure").style.display = "none";
	}

	return valid;
}

// Validates addStationForm
function validateStationForm() {
	var valid = true;
	var checkName = document.forms["addStation"]["name"].value;
	var checkLatitude = document.forms["addStation"]["latitude"].value;
	var checkLongitude = document.forms["addStation"]["longitude"].value;

	if (checkName == "") {
		document.forms["addStation"]["name"].classList.add('is-danger');
		document.getElementById("errName").style.display = 'block';
		document.getElementById("errName").innerHTML = "Enter the Station Name";
		valid = false;
	} else {
		document.forms["addStation"]["name"].classList.add('is-success');
		document.forms["addStation"]["name"].classList.remove('is-danger');
		document.getElementById("errName").style.display = "none";
	}

	if (checkLatitude == "") {
		document.forms["addStation"]["latitude"].classList.add('is-danger');
		document.getElementById("errLatitude").style.display = "block";
		document.getElementById("errLatitude").innerHTML = "Enter the Latitude";
		valid = false;
	} else {
		document.forms["addStation"]["latitude"].classList.add('is-success');
		document.forms["addStation"]["latitude"].classList.remove('is-danger');
		document.getElementById("errLatitude").style.display = "none";
	}

	if (checkLongitude == "") {
		document.forms["addStation"]["longitude"].classList.add('is-danger');
		document.getElementById("errLongitude").style.display = "block";
		document.getElementById("errLongitude").innerHTML = "Enter the Longitude";
		valid = false;
	} else {
		document.forms["addStation"]["longitude"].classList.add('is-success');
		document.forms["addStation"]["longitude"].classList.remove('is-danger');
		document.getElementById("errLongitude").style.display = "none";
	}

	return valid;
}


/*
deleteStation.addEventListener('click', () => {
	// Functions to open and close a modal
	function openModal($el) {
		$el.classList.add('is-active');
	}

	function closeModal($el) {
		$el.classList.remove('is-active');
	}

	function closeAllModals() {
		(document.querySelectorAll('.modal') || []).forEach(($modal) => {
			closeModal($modal);
		});
	}

	// Add a click event on buttons to open a specific modal
	(document.querySelectorAll('.js-modal-trigger') || []).forEach(($trigger) => {
		const modal = $trigger.dataset.target;
		const $target = document.getElementById(modal);

		$trigger.addEventListener('click', () => {
			openModal($target);
		});
	});
	// Add a click event on various child elements to close the parent modal
	(
		document.querySelectorAll(
			'.modal-background, .modal-close, .modal-card-head .delete, .modal-card-foot .delete-station'
		) || []
	).forEach(($close) => {
		const $target = $close.closest('.modal');

		$close.addEventListener('click', () => {
			closeModal($target);
		});
	});

	// Add a keyboard event to close all modals
	document.addEventListener('keydown', (event) => {
		const e = event || window.event;

		if (e.keyCode === 27) {
			// Escape key
			closeAllModals();
		}
	});
});
deleteReading.addEventListener('click', () => {
	const modalDisplay = document.querySelector('#modal-delete-reading')
	modalDisplay.classList.toggle('is-active');
});
*/



