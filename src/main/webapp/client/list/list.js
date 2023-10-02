const viewCommands = document.querySelector('.view')

viewCommands.addEventListener('click', () => {
    localStorage.setItem("activeItem", "Commands")
})