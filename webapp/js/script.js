(".input_text").focus(function() {
	$(this).prev('.fa').addClass('glowIcon')
})
(".input_text").focusout(function() {
	$(this).prev('.fa').removeClass('glowIcon')
})

function opencreateadmin() {
	window.location.href = "../createadmin.html"
}
function opensesionvis() {
	window.location.href = "../sesionvis.html"
}
function opensesionadmin() {
	window.location.href = "../sesionadmin.html"
}
function opencrudvis() {
	window.location.href = "../crudvis.html"
}
function opencreateop() {
	window.location.href = "../createop.html"
}
function openreadps() {
	window.location.href = "../readps.html"
}
function opendeleteadmin() {
	window.location.href = "../deleteadmin.html"
}
function opendeletepsy() {
	window.location.href = "../deletepsy.html"
}
function opendeleteServGen() {
	window.location.href = "../deleteservGen.html"
}
function openupdatepsy(){
	window.location.href="../updatepsy.html"
}
function openupdate(){
	window.location.href="../updatevis.html"
}
function openupdateSer(){
	window.location.href="../updatesergen.html"
}
function openupdatePsi(){
	window.location.href="../updatepsi.html"
}
function openupdatePsi(){
	window.location.href="../updateservgene.html"
}

/create/
function mostrarCuadros() {
    var rolSeleccionado = document.getElementById("rol").value;
    var cuadros = document.querySelectorAll(".cuadro"); 

    
    for (var i = 0; i < cuadros.length; i++) {
        cuadros[i].style.display = "none";
    }

    
    if (rolSeleccionado !== "ninguno") {
        document.getElementById(rolSeleccionado).style.display = "block";
    }
}
/readps/
function mostrarCuadros() {
	var rolSeleccionado = document.getElementById("rol").value;
	var cuadros = document.querySelectorAll(".cuadro");

	for (var i = 0; i < cuadros.length; i++) {
		cuadros[i].style.display = "none";
	}

	if (rolSeleccionado === "visitante") {
		document.getElementById("visitante").style.display = "block";
	}

	if (rolSeleccionado === "serviciosgenerales") {
		document.getElementById("serviciosgenerales").style.display = "block";
	}
	if (rolSeleccionado === "psicologo") {
		document.getElementById("psicologo").style.display = "block";
	}
}


document.getElementById("nextButton").addEventListener("click", function() {
    var cuadro = document.getElementById("serviciosgenerales");
    cuadro.style.display = "block";
});