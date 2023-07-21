let beforLogin=document.getElementsByClassName("beforLogin")
let afterLogin=document.getElementsByClassName("afterLogin")

beforLogin[0].addEventListener("click",()=>{
    beforLogin[0].style.display = "none";
    afterLogin[0].style.display="block";
});