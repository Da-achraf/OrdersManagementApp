let activeItem = localStorage.getItem("activeItem")

const url = window.location.href

if (!activeItem || url.endsWith('app/') || url.endsWith('app')) activeItem = "Home"

const navItems = document.querySelectorAll('.nav-item')

const setActiveItem = (activeItem, items) => {
    items.forEach(item => {
        if (item.innerHTML === activeItem) item.classList.add("active")
        else item.classList.remove("active")
    })
}



navItems.forEach(navItem => {
    if (navItem.innerHTML === activeItem){
        navItem.classList.add("active")
    }

    navItem.addEventListener('click', () => {
        localStorage.setItem("activeItem", navItem.innerHTML)
        setActiveItem(navItem, navItems)
    })

})


