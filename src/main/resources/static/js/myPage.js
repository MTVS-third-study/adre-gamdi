let modifyBtn = document.getElementById("modifyBtn");
let deleteBtn = document.getElementById("deleteBtn");



let menuListItem=document.querySelectorAll("#menuList>div");
for(let i=0;i<menuListItem.length;i++){
    console.log(menuListItem[i]);
    menuListItem[i].addEventListener("mouseover",()=>{
        menuListItem[i].classList.add("on")
    })
    menuListItem[i].addEventListener("mouseleave",()=>{
        menuListItem[i].classList.remove("on")
    }  )
}



