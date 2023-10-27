// calculoTotal.js

// Función para calcular el total en función del precio y el descuento
function calcularTotal() {
    var precio = parseFloat(document.getElementById("precio").value);
    var descuento = parseFloat(document.getElementById("descuento").value);
    var total = precio - (precio * (descuento / 100));
    document.getElementById("total").value = total.toFixed(2);
}

// Asignar la función al evento "input" de los campos de precio y descuento
document.getElementById("precio").addEventListener("input", calcularTotal);
document.getElementById("descuento").addEventListener("input", calcularTotal);
