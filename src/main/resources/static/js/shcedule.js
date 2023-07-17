//reviwpsge
let infoNav = document.getElementById("infoNav");
let reviewNav = document.getElementById("reviewNav");
let infoContents = document.getElementsByClassName("infoContents");
let reviewContainer = document.getElementsByClassName("reviewContainer");

infoNav.addEventListener("click", () => {
    infoContents[0].style.display = "block";
    reviewContainer[0].style.display = "none";
});
reviewNav.addEventListener("click", () => {
    infoContents[0].style.display = "none";
    reviewContainer[0].style.display = "block";
});

// 지도 사이드바 설정 js
let menuWrap = document.getElementById("menu_wrap");
let dayWrap = document.getElementById("day_wrap");
let homeBtn = document.getElementsByClassName("homeBtn");
let myScheduleBtn = document.getElementsByClassName("myScheduleBtn");
let imgBtn = document.getElementsByClassName("imgBtn");
let infoWrap = document.getElementById("info_wrap");
let BtnBox = document.getElementsByClassName("BtnBox");

homeBtn[0].addEventListener("click", () => {
    console.log(homeBtn[0])
    menuWrap.style.display = "block";
    dayWrap.style.display = "none";
    infoWrap.style.display="none";
});
myScheduleBtn[0].addEventListener("click", () => {
    console.log(myScheduleBtn[0])
    menuWrap.style.display = "none";
    dayWrap.style.display = "block";
    infoWrap.style.display="none";
});
imgBtn[0].addEventListener("click", () => {
    console.log(imgBtn[0])
    infoWrap.style.display = "block";
    menuWrap.style.display = "none";
    dayWrap.style.display = "none";
    BtnBox[0].style.display = "none";
});

// 상세 페이지 일정추가
let scheduleAdd = document.getElementsByClassName("scheduleAdd");

scheduleAdd[0].addEventListener("click", () => {
    dayWrap.style.display = "block";
    infoWrap.style.display = "none";
    BtnBox[0].style.display = "block";
});
