/* 설명. reviwpage */
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

/* 설명. 지도 사이드바 설정 js */
let menuWrap = document.getElementById("menu_wrap");    // 검색 list
let dayWrap = document.getElementById("day_wrap");      // 일정 box
let infoWrap = document.getElementById("info_wrap");    // 상세 box
let homeBtn = document.getElementById("homeBtn");       // 홈 버튼
let myScheduleBtn = document.getElementById("myScheduleBtn");   // 내 일정 불러오기 버튼
let imgBtn = document.getElementById("imgBtn");         // new 버튼
let BtnBox = document.getElementsByClassName("BtnBox");     // 모든 버튼 박스
let option = document.getElementsByClassName("option");     // 검색 창
let loadBtn=document.getElementById("loadBtn")          // 일정 버튼

// 필기. 검색 창 보이기
function showSearchListWindow(){
    menuWrap.style.display = "block";
    dayWrap.style.display = "none";
    infoWrap.style.display = "none";
    BtnBox[0].style.display = "block";
    option[0].style.display = "block";
    // reviewContainer.style.display="none";
}
// 필기. 상세 창 보이기
function showDetailWindow() {
    menuWrap.style.display = "none";
    dayWrap.style.display = "none";
    infoWrap.style.display = "block";
    option[0].style.display = "none";
    // reviewContainer.style.display="none";
}
// 필기. 일정 창 보이기
function showScheduleWindow() {
    menuWrap.style.display = "none";
    dayWrap.style.display = "block";
    infoWrap.style.display = "none";
    BtnBox[0].style.display = "block";
    option[0].style.display = "block";
}
// 필기. 검색 사이드 바 버튼 이벤트
homeBtn.addEventListener("click", () => {
    showSearchListWindow();
});
// 필기. 새 일정 짜기 버튼 이벤트
let scheduleId = document.getElementById("scheduleName");
imgBtn.addEventListener("click", () => {
    const confirm = window.confirm("새 일정을 추가하시겠습니까?");
    if (!confirm) {
        return;
    }
    if (newTravelSchedule) {
        saveScheduleInLocalStorage();
    }

    clearSchedule();
    clearDatepicker();
    showSelectedDaySchedule();
    clearScheduleName();

    showScheduleWindow();
});
// 필기. 일정 버튼 이벤트
loadBtn.addEventListener("click",()=>{
    showScheduleWindow();
})

/*설명. 검색 비동기*/
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
                if (json.length === 0) {
                    html = `
                        <li class="placeItem">
                            <div class="placeContents">
                                <h4>검색 결과가 없습니다</h4>
                            </div>
                        </li>
                    `;
                } else {
                    json.forEach((obj, idx) => {
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
                        </li>
                        `;
                    });
                }
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
// 설명. 검색 버튼 클릭 이벤트
searchKeyword.addEventListener("click", () => {

    keywordValue = JSON.stringify(keyword.value);

    fetch(`/placeQuery/searchPlace?searchKeyword=${keywordValue}`)
        .then((response) => response.json())
        .then((json) => {
            json = json.respPlaceList;
            let html = "";
            if (json.length === 0) {
                html = `
                    <li class="placeItem">
                        <div class="placeContents">
                            <h4>검색 결과가 없습니다</h4>
                        </div>
                    </li>
                `;
            } else {
                json.forEach((obj, idx) => {
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
                        </li>
                    `;
                });
            }
            document.getElementById("placeList").innerHTML = html;
            menuWrap.style.display = "block";
            dayWrap.style.display = "none";
            addPlaceListClickEvent();
        })
        .catch((error) => {
            console.log(error);
        });
});


/*설명. 상세페이지*/
let scheduleAdd = document.getElementsByClassName("scheduleAdd");
let detailPlaceInfo = "";
function addPlaceListClickEvent() {
    let placeItem = document.getElementsByClassName("placeItem");
    let placeList = document.querySelectorAll("#placeList>li");
    let backBtn=document.getElementsByClassName("backBtn")
    backBtn[0].addEventListener("click",()=>{
        showSearchListWindow();
        // reviewContainer.style.display="none";
    })

    for (let i = 0; i < placeList.length; i++) {
        placeItem[i].addEventListener("click", () => {  // 검색된 리스트
            let placeNo = placeList[i].querySelector("#placeNo").innerText;

            fetch(`/placeQuery/placeInfo?placeNo=${placeNo}`)
                .then((response) => response.json())
                .then((data) => {
                    detailPlaceInfo = data.detailPlaceInfo;

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
                    showSearchListWindow();
                });

            showDetailWindow();
        });
    }
}

/*설명. 마우스 이벤트 정리*/
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
loadBtn.addEventListener("mouseover", () => {
    loadBtn.classList.add("add");
});
loadBtn.addEventListener("mouseleave", () => {
    loadBtn.classList.remove("add");
});


/*설명. user 프로필*/
let userImgBox = document.getElementsByClassName("userImgBox");
let hideUserInfoBox = document.getElementsByClassName("hideUserInfoBox");
let hideUserInfoBoxItem = document.querySelectorAll(".hideUserInfoBox>li");
let hideBtn=document.getElementById("hideBtn")
userImgBox[0].addEventListener("click", () => {
    hideUserInfoBox[0].style.display = "block";
    hideBtn.style.display="block";
});

for (let i = 0; i < hideUserInfoBoxItem.length; i++) {
    hideUserInfoBoxItem[i].addEventListener("mouseover", () => {
        hideUserInfoBoxItem[i].style.backgroundColor = "orange";
    });
    hideUserInfoBoxItem[i].addEventListener("mouseleave", () => {
        hideUserInfoBoxItem[i].style.backgroundColor = "transparent";
    });
}
// 프로필 제거 이벤트
hideBtn.addEventListener("click", () => {
    hideUserInfoBox[0].style.display = "none";
    hideBtn.style.display="none";
});

/*설명. 내 일정 모달창 설정*/
let myScheduleModal = document.getElementById("myScheduleModal");
let myScheduleModalBody = document.getElementsByClassName(
    "schedule_modal_body"
);
let scheduleModify = document.getElementsByClassName("scheduleModify");
// 내 일정 모달창
myScheduleBtn.addEventListener("click", () => {
    showScheduleWindow();

    fetch(`/schedule/query/mySchedule`)
        .then((response) => response.json())
        .then((data) => {
            if (data.message) { // 에러 메세지가 존재한다면
                alert(data.message);
                return;
            }

            myScheduleModal.style.display = "block";
            myScheduleModalBody[0].style.display = "block";

            let html = `  <div><h1>나의 일정</h1> <img src="/images/close.png" alt="" class="closeBtn1" id="closeBtn"></div>`;
            data.myScheduleList.forEach((obj, idx) => {

                    html += `
           
             <div class="plan">
            <div class="plan_title">여행 이름 <span><input type="text" placeholder=${obj.scheduleName}></span></div>
            <div class="plan_date">여행 일자 <span>${obj.startDate}~${obj.endDate}</span></div>
<!--            <div class="plan_cnt">선택장소 <span>12</span></div>-->
            <div class="schedule_modal_btnBox">
                <button class="modal_btn scheduleModify" id="modifyScheduleBtn">일정 수정</button>
                <button class="modal_btn">삭제</button>
            </div>         
            </div>
                    `;

            });
            document.getElementById("schedule_modal_body").innerHTML = html;
            let closeBtn=document.getElementById("closeBtn")
            closeBtn.addEventListener("click",()=>{
                myScheduleModal.style.display = "none";
                myScheduleModalBody[0].style.display = "none";
            })
        })
        .catch((error) => {
            console.log(error);
        });

})
// 필기. 일정 수정 버튼 클릭 이벤트
// const modifyScheduleBtn = document.getElementById("modifyScheduleBtn");
// modifyScheduleBtn.addEventListener("click", () => {
//     console.log(1000);
// });
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

/*설명. caleder*/
let newTravelSchedule = {
    scheduleName: "",
    startDate: "",
    endDate: "",
    dayAndNight: "",
    travelDays: ""
};
let daySelect = document.getElementById("daySelect");  // 캘린더 input
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
            let endDate =
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
                    let dayAndNight = data.dayAndNight;
                    newTravelSchedule.startDate=startDate;
                    newTravelSchedule.endDate=endDate;
                    newTravelSchedule.dayAndNight = dayAndNight;

                    let html = ` <option value="allday">전체 일정</option>`;
                    for (let i=1; i<=dayAndNight; i++) {

                        if (i === 1) {
                            html += `   
                                <option value="${i}" selected="selected">${i}일 차</option>
                            `;
                        } else{
                            html += `   
                                <option value="${i}">${i}일 차</option>
                            `;
                        }
                        daySelect.innerHTML = html;
                    }
                    saveScheduleInLocalStorage();
                    showSelectedDaySchedule();
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

/*설명. 일정 추가*/
let dayNumber = 1;  // 첫 째날
let travelDays = {};    // 몇박며칠
function setScheduleName() {    // 필기. 일정 이름 변경 이벤트
    let changedScheduleName = document.getElementsByClassName("newPlaceName");
    newTravelSchedule.scheduleName = changedScheduleName[0].value;
    saveScheduleInLocalStorage();
}
scheduleAdd[0].addEventListener("click", () => {    // 필기. 상세 페이지에서 일정추가 버튼 클릭 이벤트
    if (!travelDays[dayNumber]) {
        travelDays[dayNumber] = [];
    }
    let datefilterValue = $('input[name="datefilter"]').val();
    if (datefilterValue === '') {
        alert('일정을 생성해주세요!');
        return;
    }
    if (dayNumber === "allday") {
        alert('일정 일 차를 지정해주세요!');
        return;
    }

    travelDays[dayNumber].push(detailPlaceInfo);
    newTravelSchedule.travelDays=travelDays;

    showScheduleWindow();
    saveScheduleInLocalStorage();
    showSelectedDaySchedule();
});
// 필기. 세부 일정 리스트 조회
function showSelectedDaySchedule() {
    dayNumber = daySelect.options[daySelect.selectedIndex].value;
    let html = ``;
    if (dayNumber === "allday") {   // 필기. 전체 일정 선택 시
        for (let i = 1; i < daySelect.options.length; i++){
            html += `
                <li class="dayScheduleList" onclick="selectDaySchedule(${i})">
                    <div class="daySchedule">
                        <h3>${i}일 차 일정</h3>
                    </div>
                </li>
            `;
        }
    }
    if (travelDays[dayNumber]) {    // 필기. 일 차가 있다면
        for (let i = 0; i < travelDays[dayNumber].length; i++) {
            html += `
                <li id="dayPlaceList">
                    <div>
                        <div class="placeNum">
                         <img src="/images/daylistnum.png" alt=""/><span class="listnum">${i + 1}</span>
                        </div>
                        <div class="dayListNumInfo">
                           
                             <span>${travelDays[dayNumber][i].placeName}</span>
                             <p>${travelDays[dayNumber][i].categoryName}</p>
                             
                        </div>
                        <div class="dayPicture">
                            <img src="${travelDays[dayNumber][i].imagePath}">
                        </div>                   
                    </div>                     
                </li>
            `;
        }
    }
    document.getElementById("dayPlacesList").innerHTML = html;
}
// 필기. 일정 저장
let saveScheduleBtn = document.getElementById("saveScheduleBtn");
saveScheduleBtn.addEventListener("click", () => {
    saveSchedule();
})
function saveSchedule() {

    fetch("/schedule/insertSchedule", {
        method: "POST",
        headers: { "Content-Type":"application/json"},
        body: JSON.stringify(newTravelSchedule),
    })
    .then(resp => {
        if (resp.status === 200) {
            alert("성공적으로 저장되었습니다.");
            clearSchedule();
            showSelectedDaySchedule();
            clearScheduleName();
            clearDatepicker();
        }
    })
    .catch(error => {
        alert(error);
    })
}
function saveScheduleInLocalStorage() {
    window.localStorage.setItem("newTravelSchedule", JSON.stringify(newTravelSchedule) );
}
function selectDaySchedule(day) {   // 필기. 전체 일정에서 일차 별 일정으로 이동 메소드
    daySelect.value = day;
    showSelectedDaySchedule();
};

/* 설명. 초기화 */
// 일정 정보들 초기화
function clearSchedule() {
    newTravelSchedule={};
    travelDays=[];
}
// 필기. 선택된 날짜 일정 초기화
let initScheduleBtn = document.getElementById("initScheduleBtn");
initScheduleBtn.addEventListener("click", () => {
    let selectedDay = daySelect.options[daySelect.selectedIndex].value;
    if (selectedDay === "allday") {

        const confirmed = window.confirm("전체 일정이 초기화됩니다.\n정말 초기화하시겠습니까?");
        if (!confirmed) {
            return;
        }
        travelDays = {};
        showSelectedDaySchedule();
        return;
    }

    const confirmed = window.confirm(`${selectedDay}일 차 일정이 초기화됩니다.\n정말 초기화하시겠습니까?`);
    if (!confirmed) {
        return;
    }
    travelDays[selectedDay] = [];
    showSelectedDaySchedule();
});
// 필기. 여행 이름 초기화 함수
function clearScheduleName() {
    scheduleId.value = "";
    setScheduleName();
}
// 필기. calendar 초기화 함수
function clearDatepicker() {
    $('input[name="datefilter"]').data('daterangepicker').setStartDate(moment());
    $('input[name="datefilter"]').data('daterangepicker').setEndDate(moment());
    $('input[name="datefilter"]').val('');

    while (daySelect.firstChild) {
        daySelect.removeChild(daySelect.firstChild);
    }

    let allDayOption = document.createElement("option");
    allDayOption.value = "allday";
    allDayOption.textContent = "전체 일정";
    daySelect.appendChild(allDayOption);
}
// 필기. 로컬스토리지 초기화 함수
function clearLocalStorage() {
    window.localStorage.removeItem("newTravelSchedule")
}
