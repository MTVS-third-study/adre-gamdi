
<!-- 리뷰 작성 모달창 -->
const modal = document.querySelector('.modal');
const btnOpenPopup = document.querySelector('.reviewBtn');
const closeModalBtn = document.querySelector('.closeBtn')

btnOpenPopup.addEventListener('click', () => {
    modal.style.display = 'block';
    // document.body.style.overflow = "hidden"; // 스크롤바 제거
});

closeModalBtn.addEventListener("click", () => {
    modal.style.display = "none";
    // document.body.style.overflow = "auto"; // 스크롤바 보이기
});


<!-- 리뷰 작성시 이미지 프리뷰 기능 -->
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById('preview').src = e.target.result;
        };
        reader.readAsDataURL(input.files[0]);
    } else {
        document.getElementById('preview').src = "";
    }
}
