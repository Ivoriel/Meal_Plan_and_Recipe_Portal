document.querySelectorAll(".deletion-confirmation").forEach((deleteButton) => {
    deleteButton.addEventListener("click", function () {
        let r = confirm(deleteButton.dataset.message);
        if (r === true) {
            window.location.replace(deleteButton.dataset.href);
        }
    })
})