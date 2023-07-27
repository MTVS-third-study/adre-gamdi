// 설명. reviwpage
let infoNav = document.getElementById("infoNav");
let reviewNav = document.getElementById("reviewNav");
let infoContents = document.getElementsByClassName("infoContents");
let reviewContainer = document.getElementsByClassName("reviewContainer");
let imgBox = document.getElementsByClassName("imgBox");
let infoPlace=document.getElementsByClassName("infoPlace")
infoNav.addEventListener("click", () => {
    infoContents[0].style.display = "block";
    reviewContainer[0].style.display = "none";
    imgBox[0].style.display = "block";
});
reviewNav.addEventListener("click", () => {
    fetch(`reviewController주소?placieNo=${placeNo}`)
        .then((response) => response.json())
        .then((json) => {
            console.log(json);
            console.log(placeNo);
        })
        .catch((error) => {
            console.error(error);
            alert("예기치 못한 오류가 발생했습니다.");
            infoWrap.style.display = "none";
            menuWrap.style.display = "block";
            dayWrap.style.display = "none";
            option[0].style.display = "block";
        });
    infoContents[0].style.display = "none";
    reviewContainer[0].style.display = "block";
    imgBox[0].style.display = "none";
    infoPlace[0].style.display = "none";
});

// 설명. 지도 사이드바 설정 js
let menuWrap = document.getElementById("menu_wrap");    // 검색 list
let dayWrap = document.getElementById("day_wrap");      // 일정 box
let infoWrap = document.getElementById("info_wrap");    // 상세 box
let homeBtn = document.getElementById("homeBtn");       // 홈 버튼
let myScheduleBtn = document.getElementById("myScheduleBtn");   // 내 일정 버튼
let imgBtn = document.getElementById("imgBtn");         // new 버튼
let BtnBox = document.getElementsByClassName("BtnBox");     // 모든 버튼 박스
let option = document.getElementsByClassName("option");     // 검색 box
homeBtn.addEventListener("click", () => {
    console.log(1);

    menuWrap.style.display = "block";
    dayWrap.style.display = "none";
    infoWrap.style.display = "none";
    option[0].style.display = "block";
});

imgBtn.addEventListener("click", () => {
    console.log(3);

    infoWrap.style.display = "none";
    menuWrap.style.display = "none";
    dayWrap.style.display = "block";
    BtnBox[0].style.display = "block";
    option[0].style.display = "block";

});

// 설명. 검색 비동기
let searchBox = document.getElementById("searchBox");
let searchKeyword = document.getElementById("searchKeyword1");
let keyword = document.querySelector(".keyword");
let keywordValue = "";
keyword.addEventListener("keyup", (e) => {  // 설명. 엔터키 검색 이벤트
    if (e.keyCode === 13) {
        keywordValue = JSON.stringify(keyword.value);

        fetch(`/placeQuery/searchPlace?searchKeyword=${keywordValue}`)
            .then((response) => response.json())
            .then((json) => {
                json = json.respPlaceList;
                let html = "";
                json.forEach((obj, idx) => {
                    if (!json.length) {
                        console.log("등록된 값이없습니다");
                    } else {
                        console.log(obj);
                        html += `
                        <li class="placeItem">
                    <div class="placeContents">
                    <div class="placeInfo">
                        <p id="placeNo" style="display: none">${obj.placeNo}</p>
                        <h4>${obj.placeName}</h4>
                        <p>${obj.categoryName}</p>
                        <span  class="placeAddr">${obj.placeAddress}</span><br>
                        <span>${obj.phoneNumber}</span>
                    </div>
                    <img src="${obj.imagePath}" alt="">
                    </div>
                <hr>
                </li>`;
                    }
                });
                document.getElementById("placeList").innerHTML = html;
                menuWrap.style.display = "block";
                dayWrap.style.display = "none";
                addPlaceListClickEvent();
            })
            .catch((error) => {
                console.log(error);
            });
    }
});
searchKeyword.addEventListener("click", () => { // 설명. 검색 버튼 클릭 이벤트

    keywordValue = JSON.stringify(keyword.value);

    fetch(`/placeQuery/searchPlace?searchKeyword=${keywordValue}`)
        .then((response) => response.json())
        .then((json) => {
            json = json.respPlaceList;
            let html = "";
            json.forEach((obj, idx) => {
                if (!json.length) {
                    console.log("등록된 값이없습니다");
                } else {

                    html += `
                        <li class="placeItem">
                    <div class="placeContents">
                    <div class="placeInfo">
                        <p id="placeNo" style="display: none">${obj.placeNo}</p>
                        <h4>${obj.placeName}</h4>
                        <p>${obj.categoryName}</p>
                        <span  class="placeAddr">${obj.placeAddress}</span><br>
                        <span>${obj.phoneNumber}</span>
                    </div>
                    <img src="${obj.imagePath}" alt="">
                    </div>
                <hr>
                </li>`;
                }
            });
            document.getElementById("placeList").innerHTML = html;
            menuWrap.style.display = "block";
            dayWrap.style.display = "none";
            addPlaceListClickEvent();
        })
        .catch((error) => {
            console.log(error);
        });
});

// 설명. 상세페이지
function addPlaceListClickEvent() {
    let scheduleAdd = document.getElementsByClassName("scheduleAdd");
    let placeItem = document.getElementsByClassName("placeItem");
    let placeList = document.querySelectorAll("#placeList>li");
    let backBtn=document.getElementsByClassName("backBtn")
    scheduleAdd[0].addEventListener("click", () => {
        dayWrap.style.display = "block";
        infoWrap.style.display = "none";
        BtnBox[0].style.display = "block";
        option[0].style.display = "block";
    });
    backBtn[0].addEventListener("click",()=>{
        menuWrap.style.display="block"
        dayWrap.style.display = "none";
        infoWrap.style.display = "none";
        BtnBox[0].style.display = "block";
        option[0].style.display = "block";
        reviewContainer.style.display="none";

    })
    for (let i = 0; i < placeList.length; i++) {
        placeItem[i].addEventListener("click", () => {
            let placeNo = placeList[i].querySelector("#placeNo").innerText;

            fetch(`/placeQuery/placeInfo?placeNo=${placeNo}`)
                .then((response) => response.json())
                .then((data) => {
                    console.log(data);
                    let detailPlaceInfo = data.detailPlaceInfo;

                    let placeName = document.getElementById("placeName");
                    // let categoryName=document.getElementById("categoryName")
                    let imgPath = document.getElementById("imgPath");
                    let phoneNumber = document.getElementById("phoneNumber");
                    let placeAddress = document.getElementById("placeAddress");
                    let introduction = document.getElementById("introduction");

                    placeName.innerText = detailPlaceInfo.placeName;
                    let placeLIst = document.querySelectorAll("#placeList>li");
                    placeLIst.length;
                    // categoryName.innerText=detailPlaceInfo.categoryName;
                    phoneNumber.innerText = detailPlaceInfo.phoneNumber;
                    placeAddress.innerText = detailPlaceInfo.placeAddress;
                    introduction.innerText = detailPlaceInfo.introduction;
                    const imgsrc = `<img src="${detailPlaceInfo.imagePath}">`;
                    imgPath.innerHTML = imgsrc;
                })
                .catch((error) => {
                    console.error(error);
                    alert("예기치 못한 오류가 발생했습니다.");
                    infoWrap.style.display = "none";
                    menuWrap.style.display = "block";
                    dayWrap.style.display = "none";
                    option[0].style.display = "block";
                    reviewContainer.style.display="none";
                });

            infoWrap.style.display = "block";
            menuWrap.style.display = "none";
            dayWrap.style.display = "none";
            option[0].style.display = "none";
            reviewContainer.style.display="none";
        });
    }
}


// 설명. Btnmouseover
homeBtn.addEventListener("mouseover", () => {
    homeBtn.classList.add("add");
});
homeBtn.addEventListener("mouseleave", () => {
    homeBtn.classList.remove("add");
});

myScheduleBtn.addEventListener("mouseover", () => {
    myScheduleBtn.classList.add("add");
});
myScheduleBtn.addEventListener("mouseleave", () => {
    myScheduleBtn.classList.remove("add");
});

imgBtn.addEventListener("mouseover", () => {
    imgBtn.classList.add("add");
});
imgBtn.addEventListener("mouseleave", () => {
    imgBtn.classList.remove("add");
});


// 설명. userInfoBox
let userImgBox = document.getElementsByClassName("userImgBox");
let hideUserInfoBox = document.getElementsByClassName("hideUserInfoBox");
let hideUserInfoBoxItem = document.querySelectorAll(".hideUserInfoBox>li");

userImgBox[0].addEventListener("click", () => {
    hideUserInfoBox[0].style.display = "block";
});

for (let i = 0; i < hideUserInfoBoxItem.length; i++) {
    hideUserInfoBoxItem[i].addEventListener("mouseover", () => {
        hideUserInfoBoxItem[i].style.backgroundColor = "#70757a";
    });
    hideUserInfoBoxItem[i].addEventListener("mouseleave", () => {
        hideUserInfoBoxItem[i].style.backgroundColor = "transparent";
    });
    hideUserInfoBoxItem[i].addEventListener("click", () => {
        hideUserInfoBox[0].style.display = "none";
    });
}

//내 일정 모달창 설정
let myScheduleModal = document.getElementById("myScheduleModal");
let myScheduleModalBody = document.getElementsByClassName(
    "schedule_modal_body"
);
let scheduleModify = document.getElementsByClassName("scheduleModify");
//내 일정 모달창
myScheduleBtn.addEventListener("click", () => {
    console.log(2);
    infoWrap.style.display = "none";
    menuWrap.style.display = "none";
    dayWrap.style.display = "block";
    BtnBox[0].style.display = "block";
    option[0].style.display = "block";

    fetch(`/schedule/query/mySchedule`)
        .then((response) => response.json())
        .then((data) => {
            console.log(data);

            if (data.message) { // 에러 메세지가 존재한다면
                alert(data.message);
                return;
            }

            myScheduleModal.style.display = "block";
            myScheduleModalBody[0].style.display = "block";

            let html = `  <div><h1>나의 일정</h1></div>`;
            data.myScheduleList.forEach((obj, idx) => {

                    console.log(data.myScheduleList);
                    html += `
           
             <div class="plan">
            <div class="plan_title">여행 이름 <span><input type="text" placeholder=${obj.scheduleName}></span></div>
            <div class="plan_date">여행 일자 <span>${obj.startDay}~${obj.endDay}</span></div>
<!--            <div class="plan_cnt">선택장소 <span>12</span></div>-->
            <div class="schedule_modal_btnBox">
                <button class="modal_btn scheduleModify">일정 수정</button>
                <button class="modal_btn">삭제</button>
            </div>         
                    `;

            });
            document.getElementById("schedule_modal_body").innerHTML = html;
        })
        .catch((error) => {
            console.log(error);
        });
})
    myScheduleModal.addEventListener("click", () => {
        myScheduleModal.style.display = "none";
        myScheduleModalBody[0].style.display = "none";
    });
    // scheduleModify[0].addEventListener("click", () => {
    //     if ((dayWrap.style.display = "none")) {
    //         dayWrap.style.display = "block";
    //         infoWrap.style.display = "none";
    //         menuWrap.style.display = "none";
    //     }
    //
    //     myScheduleModal.style.display = "none";
    //     myScheduleModalBody[0].style.display = "none";
    // });

// 설명. caleder
// function setCalendar() {
    let startDate = "";
    let endDate = "";
    let dayAndNight = "";
    $(function () {
        $('input[name="datefilter"]').daterangepicker({
            autoUpdateInput: false,
            locale: {
                cancelLabel: "Clear",
            },
        });

        $('input[name="datefilter"]').on(
            "apply.daterangepicker",
            function (ev, picker) {
                $(this).val(
                    picker.startDate.format("MM/DD/YYYY") +
                    " - " +
                    picker.endDate.format("MM/DD/YYYY")
                );

                let startDate =
                    picker.startDate._d.getUTCFullYear() +
                    "-" +
                    (picker.startDate._d.getMonth() +
                        1) +
                    "-" +
                    picker.startDate._d.getDate() +
                    "";
                endDate =
                    picker.endDate._d.getUTCFullYear() +
                    "-" +
                    (picker.endDate._d.getMonth() +
                        1) +
                    "-" +
                    picker.endDate._d.getDate() +
                    "";
                fetch(`/schedule/getDayAndNight?startDay=${startDate}&endDay=${endDate}`)
                    .then((response) => response.json())
                    .then((data) => {
                        if (data.message) {
                            alert(data.message);
                            return;
                        }
                        dayAndNight = data.dayAndNight;
                    });
            }
        );

        $('input[name="datefilter"]').on(
            "cancel.daterangepicker",
            function (ev, picker) {
                $(this).val("");
            }
        );
    });
// }

// 설명. 일정 세우기
