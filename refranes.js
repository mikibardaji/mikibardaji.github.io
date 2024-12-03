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
