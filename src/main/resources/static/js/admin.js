let userBtn = document.getElementById("userBtn");
let blackBtn = document.getElementById("blackBtn");
let reportBtn = document.getElementById("reportBtn");

let userList = document.getElementById("userList");
let blackList = document.getElementById("blackList");
let reportList = document.getElementById("reportList");

userBtn.addEventListener("click", () => {
    userList.style.display = "block";
    blackList.style.display = "none";
    reportList.style.display = "none";
});
blackBtn.addEventListener("click", () => {
    userList.style.display = "none";
    blackList.style.display = "block";
    reportList.style.display = "none";
});
reportBtn.addEventListener("click", () => {
    userList.style.display = "none";
    blackList.style.display = "none";
    reportList.style.display = "block";
});

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