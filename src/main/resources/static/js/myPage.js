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
for(let i=0;i<saveBtn.length;i++){
    saveBtn[i].addEventListener("mouseover",()=>{
        saveBtn[i].style.backgroundColor="orange"
        saveBtn[i].style.color="#fff"
    })
    saveBtn[i].addEventListener("mouseleave",()=>{
        saveBtn[i].style.backgroundColor="transparent"
        saveBtn[i].style.color="orange"
    })
}

