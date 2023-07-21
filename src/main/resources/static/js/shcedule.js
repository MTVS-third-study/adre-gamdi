//reviwpsge
let infoNav = document.getElementById("infoNav");
let reviewNav = document.getElementById("reviewNav");
let infoContents = document.getElementsByClassName("infoContents");
let reviewContainer = document.getElementsByClassName("reviewContainer");
let imgBox=document.getElementsByClassName("imgBox")
infoNav.addEventListener("click", () => {
    infoContents[0].style.display = "block";
    reviewContainer[0].style.display = "none";
    imgBox[0].style.display="block"

});
reviewNav.addEventListener("click", () => {
    infoContents[0].style.display = "none";
    reviewContainer[0].style.display = "block";
    imgBox[0].style.display="none"
});

// 지도 사이드바 설정 js
let menuWrap = document.getElementById("menu_wrap");
let dayWrap = document.getElementById("day_wrap");
let infoWrap = document.getElementById("info_wrap");
let homeBtn = document.getElementById("homeBtn");
let myScheduleBtn = document.getElementById("myScheduleBtn");
let imgBtn = document.getElementById("imgBtn");
let BtnBox = document.getElementsByClassName("BtnBox");
let option=document.getElementsByClassName("option")
homeBtn.addEventListener("click", () => {
    console.log(1)


    menuWrap.style.display="block"
    dayWrap.style.display="none"
    infoWrap.style.display="none"
    option[0].style.display="block";

});

myScheduleBtn.addEventListener("click", () => {

    console.log(2)

    dayWrap.style.display = "block";
    menuWrap.style.display = "none";
    infoWrap.style.display="none";
    option[0].style.display="block";


});
imgBtn.addEventListener("click", () => {
    console.log(3)


});

// 상세 페이지 일정추가
let scheduleAdd = document.getElementsByClassName("scheduleAdd");
let placeList=document.getElementsByClassName("placeList")
scheduleAdd[0].addEventListener("click", () => {
    dayWrap.style.display = "block";
    infoWrap.style.display = "none";
    BtnBox[0].style.display = "block";
    option[0].style.display="block";
});
for(let i=0 ;i<placeList.length ;i++){


    placeList[i].addEventListener("click",()=>{
        fetch('https://jsonplaceholder.typicode.com/posts/1')
            .then((response) => response.json())
            .then((json) => console.log(json));
        infoWrap.style.display = "block";
        menuWrap.style.display = "none";
        dayWrap.style.display = "none";
        BtnBox[0].style.display = "none";
        option[0].style.display="none";
    })


}
