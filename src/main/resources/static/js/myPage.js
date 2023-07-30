let modifyBtn = document.getElementById("modifyBtn");
let deleteBtn = document.getElementById("deleteBtn");
let contentsWrap=document.getElementsByClassName("contentsWrap")
let placeReqWrap=document.getElementsByClassName("placeReqWrap")
let menuListItem=document.querySelectorAll("#menuList>div");
for(let i=0;i<menuListItem.length;i++){
    console.log(menuListItem[i]);
    menuListItem[i].addEventListener("mouseover",()=>{
        menuListItem[i].classList.add("on")
    })
    menuListItem[i].addEventListener("mouseleave",()=>{
        menuListItem[i].classList.remove("on")
    }  )
    menuListItem[0].addEventListener("click",()=>{
        contentsWrap[0].style.display="block";
        placeReqWrap[0].style.display="none";
    })
    menuListItem[1].addEventListener("click",()=>{
        contentsWrap[0].style.display="none";
        placeReqWrap[0].style.display="block";
    })
}



