// 설명. reviwpage
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

// 설명. 지도 사이드바 설정 js
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

    infoWrap.style.display = "block";
    menuWrap.style.display = "none";
    dayWrap.style.display = "none";
    BtnBox[0].style.display = "none";
    option[0].style.display="none";

});

// 설명. 상세페이지
let scheduleAdd = document.getElementsByClassName("scheduleAdd");
let placeItem=document.getElementsByClassName("placeItem")
let placeList=document.querySelectorAll("#placeList>li")
scheduleAdd[0].addEventListener("click", () => {
    dayWrap.style.display = "block";
    infoWrap.style.display = "none";
    BtnBox[0].style.display = "block";
    option[0].style.display="block";
});

for(let i=0 ;i<placeList.length ;i++){

    placeItem[i].addEventListener("click",()=>{
        let placeNo = placeList[i].querySelector("#placeNo").innerText;

        fetch(`/placeQuery/placeInfo?placeNo=${placeNo}`)
            .then( response => response.json())
            .then((data) => {
                console.log(data);
            })
            .catch((error) => {
                console.error(error);
                alert("예기치 못한 오류가 발생했습니다.");
            })
        infoWrap.style.display = "block";
        menuWrap.style.display = "none";
        dayWrap.style.display = "none";
        option[0].style.display="none";
    })

}

// 설명. Btnmouseover
homeBtn.addEventListener("mouseover",()=>{
    homeBtn.classList.add('add')
})
homeBtn.addEventListener("mouseleave",()=>{
    homeBtn.classList.remove('add')
})

myScheduleBtn.addEventListener("mouseover",()=>{
    myScheduleBtn.classList.add('add')
})
myScheduleBtn.addEventListener("mouseleave",()=>{
    myScheduleBtn.classList.remove('add')
})

imgBtn.addEventListener("mouseover",()=>{
    imgBtn.classList.add('add')
})
imgBtn.addEventListener("mouseleave",()=>{
    imgBtn.classList.remove('add')
})
// 설명. userInfoBox

let userImgBox=document.getElementsByClassName("userImgBox")
let hideUserInfoBox=document.getElementsByClassName("hideUserInfoBox")
let hideUserInfoBoxItem=document.querySelectorAll(".hideUserInfoBox>li")

userImgBox[0].addEventListener("click",()=>{
    hideUserInfoBox[0].style.display="block";
})

for(let i=0 ;i<hideUserInfoBoxItem.length;i++){
    hideUserInfoBoxItem[i].addEventListener("mouseover",()=>{
        hideUserInfoBoxItem[i].style.backgroundColor="#70757a"
    })
    hideUserInfoBoxItem[i].addEventListener("mouseleave",()=>{
        hideUserInfoBoxItem[i].style.backgroundColor="transparent"
    })
    hideUserInfoBoxItem[i].addEventListener("click",()=>{
        hideUserInfoBox[0].style.display="none";
    })
}