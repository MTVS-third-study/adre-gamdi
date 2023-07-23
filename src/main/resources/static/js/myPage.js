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

let saveBtn=document.getElementsByClassName("saveBtn")
saveBtn[0].addEventListener("mouseover",()=>{
    saveBtn[0].style.backgroundColor="#696cff"
    saveBtn[0].style.color="#fff"
})
saveBtn[0].addEventListener("mouseleave",()=>{
    saveBtn[0].style.backgroundColor="transparent"
    saveBtn[0].style.color="#696cff"
})