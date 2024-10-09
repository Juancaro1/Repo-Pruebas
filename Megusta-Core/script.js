
document.querySelectorAll('.likes').forEach(button => {
    button.onclick = () => {
        const conteoLikes = button.previousElementSibling;
        let aumentoLikes = parseInt(conteoLikes.innerText); 
        conteoLikes.innerText = `${++aumentoLikes} like(s)`;
    };
});
