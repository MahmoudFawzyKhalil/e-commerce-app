document.getElementById('togglemebutton').onclick = function() {
    document.getElementById("resultnav").classList.toggle("hidden");
  }
  
  //document.getElementById('togglemebutton').onclick = function () {
  //  document.getElementById("toggleme").classList.toggle("hidden");
  //}
  
  
  const toggleprofile = document.getElementById("toggleprofile");
  const resultprofile = document.getElementById("resultprofile");
  [...document.querySelectorAll('body')].forEach(el => {
    el.addEventListener('click', event => {
      if (event.target.parentElement.id !== "toggleprofile") {
        console.clear();
        console.log(event.target.parentElement.id)
        resultprofile.classList.add("hidden")
      }else{
      resultprofile.classList.toggle("hidden")}
    })
  })