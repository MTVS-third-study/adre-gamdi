// let beforLogin=document.getElementsByClassName("beforLogin")
// let afterLogin=document.getElementsByClassName("afterLogin")
//
// beforLogin[0].addEventListener("click",()=>{
//     beforLogin[0].style.display = "none";
//     afterLogin[0].style.display="block";
// });
const modal = document.getElementById("modal");
const openModalBtn = document.getElementById("open-modal");
const closeModalBtn = document.getElementById("close-modal");
// 모달창 열기
openModalBtn.addEventListener("click", () => {
    modal.style.display = "block";
    document.body.style.overflow = "hidden"; // 스크롤바 제거
});
// 모달창 닫기
closeModalBtn.addEventListener("click", () => {
    modal.style.display = "none";
    document.body.style.overflow = "auto"; // 스크롤바 보이기
});