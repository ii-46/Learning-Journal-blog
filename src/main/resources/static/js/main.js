(function btnState() {
  const btnEl = document.getElementsByClassName("btn");
  for (let i = 0; i < btnEl.length; i++) {
    btnEl[i].addEventListener("mouseenter", (e) => {
      e.target.classList.add("btn-hover");
    });
    btnEl[i].addEventListener("mouseleave", (e) => {
      e.target.classList.remove("btn-hover");
    });
    btnEl[i].addEventListener("click", (e) => {
      e.target.classList.remove("btn-hover");
    });
  }
})();
