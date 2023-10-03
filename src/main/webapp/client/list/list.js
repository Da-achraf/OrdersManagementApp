const viewCommands = document.querySelector('.command-count')

viewCommands.addEventListener('click', () => {
    localStorage.setItem("activeItem", "Commands")
})