let iniciar = document.querySelector("#iniciar");

iniciar.onclick = () => {
    console.log("Click en iniciar");
    iniciar.innerText = "Cerrar sesion";
};

let agregar = document.querySelector("#agregarInf");

agregar.onclick = () => {
    console.log("Click en agregar");
    agregarInf.style.display = "none";
}

let meGusta1 = document.querySelector("#meGusta1");

meGusta1.onclick = () => {
    console.log("Click en me gusta");
    alert("Gato Atigrado was liked")
}

let meGustaGato = document.querySelector("#meGusta1");

meGustaGato.addEventListener("click", function(event){
    event.preventDefault();
    let conteoLikesText = meGustaGato.textContent;
    let conteoLikes = parseInt(conteoLikesText);
    conteoLikes++;
    meGustaGato.textContent = `${conteoLikes} me gusta`;
});

let meGusta2 = document.querySelector("#meGusta2");

meGusta2.onclick = () => {
    console.log("Click en me gusta");
    alert("Golden Retriever was liked")
}

let meGustaPerro = document.querySelector("#meGusta2");

meGustaPerro.addEventListener("click", function(event){
    event.preventDefault();
    let conteoLikesPerroText = meGustaPerro.textContent;
    let conteoLikesPerro = parseInt(conteoLikesPerroText);
    conteoLikesPerro++;
    meGustaPerro.textContent = `${conteoLikesPerro} me gusta`;
});