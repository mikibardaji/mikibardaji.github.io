let refranes = [];
let indiceActual = 0;

window.onload = () => {
    fetch('refranes.json')
        .then(response => response.json())
        .then(data => {
            refranes = data;
            cargarRefran();
        })
        .catch(error => console.error('Error al cargar el archivo JSON:', error));
};

function cargarRefran() {
    if (refranes.length > 0) {
        const refran = refranes[indiceActual];
        document.getElementById('inicioRefran').textContent = refran.inicio;
        document.getElementById('finRefran').textContent = refran.fin;
        document.getElementById('finRefran').style.display = 'none';
    }
}

function mostrarSolucion() {
    document.getElementById('finRefran').style.display = 'block';
}

function siguienteRefran() {
    indiceActual = (indiceActual + 1) % refranes.length;
    cargarRefran();
    document.getElementById('finRefran').style.display = 'none';
}


function irAlRefran() {
    const inputNumero = document.getElementById('numeroRefran').value;
    const numero = parseInt(inputNumero, 10);

    if (!isNaN(numero) && numero > 0 && numero <= refranes.length) {
        indiceActual = numero - 1; // Els refranys comencen en 0 al array.
        cargarRefran();
    } else {
        alert('Por favor, introduce un número válido entre 1 y ' + refranes.length);
    }
}function cargarRefran() {
    if (refranes.length > 0) {
        const refran = refranes[indiceActual];
        document.getElementById('inicioRefran').textContent = refran.inicio;
        document.getElementById('finRefran').textContent = refran.fin;
        document.getElementById('finRefran').style.display = 'none';

        // Actualitzar el número del refrany actual.
        document.getElementById('numeroActual').textContent = `Refrán actual: ${indiceActual + 1}`;
    }
}


