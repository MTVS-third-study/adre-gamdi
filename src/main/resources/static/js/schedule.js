/* 설명. reviwpage */
let infoNav = document.getElementById("infoNav");
let reviewNav = document.getElementById("reviewNav");
let infoContents = document.getElementsByClassName("infoContents");
let reviewContainer = document.getElementsByClassName("reviewContainer");
let imgBox = document.getElementsByClassName("imgBox");
function showReviewWindow() {
    infoContents[0].style.display = "none";
    reviewContainer[0].style.display = "block";
    imgBox[0].style.display = "none";
}
function closeReviewWindow() {
    infoContents[0].style.display = "block";
    reviewContainer[0].style.display = "none";
    imgBox[0].style.display = "block";
};
infoNav.addEventListener("click", () => {
    closeReviewWindow();
});

// 설명. 리뷰 조회 비동기
function addReviewClickEvent(placeNo) {
    reviewNav.addEventListener("click", () => {
        fetch(`/review/query/reviewInfo?placeNo=${placeNo}`)
            .then((response) => response.json())
            .then((json) => {
                console.log(json
                );
                console.log(placeNo);

                json = json.reviewInfo;
                let html = "";
                json.forEach((obj, idx) => {
                    if (!json.length) {
                        console.log("등록된 값이없습니다");
                    } else {
                        html += `
                        <div class="reviewBox">
                            <div class="reviewBox"><p>${obj.reviewNo}</p>

                            <div class="userinfoBox">
                                <div class="userName"><img src="" alt="" /><span >${obj.reviewWriter.reviewWriterName}</span></div>
                                <div class="star-ratings">
                                    <div class="starRatingsFill space-x-2 text-lg" style="width: ${obj.starPoint * 20}%">
                                        <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                                    </div>
                                   
                                    <div class="starRatingsBase space-x-2 text-lg">
                                        <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                                    </div>
                                </div>
                            </div>

                            <div class="reviewContents">
                                <p >
                                    ${obj.reviewContent}
                                </p>
                            </div>
                            <div class="reviewImg">
                                <img src="/images/reviewImages/${obj.savedReviewImageName}"/>
                            </div>
                           <div class="csBox">
                                <div class="like white">
                                    <img src="/images/whiteLie.png" alt="" /><span>1</span>
                                </div>
                                <div class="like black">
                                    <img src="/images/blackLike.png" alt="" /><span>2</span>
                                </div>
                                <div class="report">
                                    <img src="/images/siren.png" alt="" /><span>신고</span>
                                </div>
                            </div>
                        </div>
`;
                    }
                    document.querySelector(".reviewContentsBox").innerHTML = html;
                });
            })
            .catch((error) => {
                console.error(error);
                alert("예기치 못한 오류가 발생했습니다.");
                showSearchListWindow();
            });
        showReviewWindow();
    });
}

// 설명. 리뷰 등록 비동기
function addReviewRegistEvent(placeNo) {
    let reviewForm = document.getElementById("reviewForm")
    const modal = document.querySelector('.modal');
    let modalBody=document.querySelector(".modal_body");
    modal.addEventListener("click",()=>{
        modal.style.display="none"
        modalBody.style.display="none"
    })
    reviewForm.addEventListener('submit', (e) => {
        e.preventDefault();

        const reviewFormData = new FormData(reviewForm);
        reviewFormData.append("placeNo", placeNo)
        console.log(reviewFormData);
        fetch("/review/regist"
            , {
                method: 'POST',
                headers: {},
                body: reviewFormData
            }
        )
            .then((resp) => {
                if (resp.status === 200) {
                    alert("리뷰가 성공적으로 등록되었습니다!");
                    modal.style.display = "none";
                    modalBody.style.display="none";
                }
            })
            .catch((error) => {
                console.error(error);
                alert("예기치 못한 오류가 발생했습니다22.");
                showSearchListWindow();
            });
        showReviewWindow();
    });
}

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
}
// 필기. 상세 창 보이기
function showDetailWindow() {
    menuWrap.style.display = "none";
    dayWrap.style.display = "none";
    infoWrap.style.display = "block";
    option[0].style.display = "none";
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
    infoContents[0].style.display = "block";
    reviewContainer[0].style.display = "none";
    imgBox[0].style.display = "block";
});
// 필기. 새 일정 짜기 버튼 이벤트
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
                        addMarker(obj);

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
                    addMarker(obj);

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

function addMarker(obj) {

    // 마커가 표시될 위치입니다
    var markerPosition = new kakao.maps.LatLng(obj.latitude, obj.longitude);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);

    var iwContent = '<div style="padding-top:5px; padding-left:5px; padding-right:10px; padding-bottom:20px;"> ' +
            obj.placeName +
            '<br>' +
            '<a href="https://map.kakao.com/link/map/' + obj.placeName + ',' + obj.latitude + ',' + obj.longitude + '" style="color:blue" target="_blank">큰지도보기</a> ' +
            '<a href="https://map.kakao.com/link/to/' + obj.placeName + ',' + obj.latitude + ',' + obj.longitude + '" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        iwPosition = new kakao.maps.LatLng(obj.latitude, obj.longitude); //인포윈도우 표시 위치입니다

    // 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
        position: iwPosition,
        content: iwContent
    });

    // 마커에 마우스오버 이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'mouseover', function () {
        // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
        infowindow.open(map, marker);
    });

    // 마커에 마우스아웃 이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'mouseout', function () {
        // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
        infowindow.close();
    });
}

function resetMarker() {
    window.location.replace("http://localhost:9090/schedule");
}


/*설명. 상세페이지*/
let scheduleAdd = document.getElementsByClassName("scheduleAdd");
let detailPlaceInfo = "";

function addPlaceListClickEvent() {
    let placeItem = document.getElementsByClassName("placeItem");
    let placeList = document.querySelectorAll("#placeList>li");
    let backBtn = document.getElementsByClassName("backBtn")
    backBtn[0].addEventListener("click", () => {
        showSearchListWindow();
    })

    for (let i = 0; i < placeList.length; i++) {
        placeItem[i].addEventListener("click", () => {  // 검색된 리스트
            let placeNo = placeList[i].querySelector("#placeNo").innerText;

            fetch(`/placeQuery/placeInfo?placeNo=${placeNo}`)
                .then((response) => response.json())
                .then((data) => {
                    console.log(data);
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
            addReviewClickEvent(placeNo);
            addReviewRegistEvent(placeNo);

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
let hideBtn = document.getElementById("hideBtn")

userImgBox[0].addEventListener("click", () => {
    hideUserInfoBox[0].style.display = "block";
    hideBtn.style.display = "block";
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
    hideBtn.style.display = "none";
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

            let html = `  
            <div><h1>나의 일정</h1> 
                <img src="/images/close.png" alt="" class="closeBtn1" id="closeBtn">
            </div>`;
            data.myScheduleList.forEach((obj, idx) => {

                html += `
           
             <div class="plan">
            <div class="plan_title">여행 이름 <span><input type="text" placeholder=${obj.scheduleName} disabled></span></div>
            <div class="plan_date">여행 일자 <span>${obj.startDate}~${obj.endDate}</span></div>
            <p id="scheduleNo" style="display: none">${obj.scheduleNo}</p>
<!--            <div class="plan_cnt">선택장소 <span>12</span></div>-->
            <div class="schedule_modal_btnBox">
                <button class="modal_btn scheduleModify">일정 수정</button>
                <button class="modal_btn deleteSchedule">삭제</button>
            </div>         
            </div>
                    `;

            });
            document.getElementById("schedule_modal_body").innerHTML = html;
            let closeBtn=document.getElementById("closeBtn")
            closeBtn.addEventListener("click",()=>{
                closeMyScheduleModal();
            })
            modifyMySchedule();
            deleteMySchedule();
        })
        .catch((error) => {
            console.log(error);
        });
})
// 필기. 일정 수정 버튼 클릭 이벤트
function modifyMySchedule() {
    const modifyScheduleBtn = document.getElementsByClassName("scheduleModify");
    for (let i=0; i<modifyScheduleBtn.length; i++) {
        modifyScheduleBtn[i].addEventListener("click", () => {
            let scheduleNo = modifyScheduleBtn[i].closest(".plan").querySelector("#scheduleNo").innerText;

            fetch(`schedule/query/loadMySchedule?scheduleNo=${scheduleNo}`)
                .then(resp => resp.json())
                .then(data => {
                    console.log(data);
                    newTravelSchedule.scheduleName=data.scheduleName;
                    newTravelSchedule.startDate=data.startDate;
                    newTravelSchedule.endDate=data.endDate;
                    newTravelSchedule.dayAndNight=data.dayAndNight;
                    let detailScheduleList = data.detailScheduleList;
                    let dayArray = [];
                    let dayList = [];
                    scheduleId.value = newTravelSchedule.scheduleName;
                    setScheduleName();
                    for (let i=1; i<=newTravelSchedule.dayAndNight; i++) {
                        dayArray = []
                        for (let j=0; j<detailScheduleList[i].length; j++){
                                dayList[j] = new Object();
                                dayList[j].placeNo = detailScheduleList[i][j].detailScheduleDTO.placeNo,
                                dayList[j].placeName = detailScheduleList[i][j].responsePlaceDTO.placeName,
                                dayList[j].categoryName = detailScheduleList[i][j].responsePlaceDTO.categoryName,
                                dayList[j].cityName = detailScheduleList[i][j].responsePlaceDTO.cityName,
                                dayList[j].dongName = detailScheduleList[i][j].responsePlaceDTO.dongName,
                                dayList[j].imagePath = detailScheduleList[i][j].responsePlaceDTO.imagePath,
                                dayList[j].averageStarPoint = detailScheduleList[i][j].responsePlaceDTO.averageStarPoint,
                                dayList[j].introduction = detailScheduleList[i][j].responsePlaceDTO.introduction,
                                dayList[j].latitude = detailScheduleList[i][j].responsePlaceDTO.latitude,
                                dayList[j].longitude = detailScheduleList[i][j].responsePlaceDTO.longitude,
                                dayList[j].phoneNumber = detailScheduleList[i][j].responsePlaceDTO.phoneNumber,
                                dayList[j].placeAddress = detailScheduleList[i][j].responsePlaceDTO.placeAddress,
                                dayList[j].roadPlaceAddress = detailScheduleList[i][j].responsePlaceDTO.roadPlaceAddress,
                                dayList[j].postCode = detailScheduleList[i][j].responsePlaceDTO.postCode,
                                dayList[j].reviewCount = detailScheduleList[i][j].responsePlaceDTO.reviewCount,
                                dayList[j].tagList = detailScheduleList[i][j].responsePlaceDTO.tagList,
                                dayList[j].thumbnailPath =detailScheduleList[i][j].responsePlaceDTO.thumbnailPath
                            dayArray.push(dayList[j]);
                            console.log(dayList[j]);
                            console.log(dayArray);
                        }
                        travelDays[i] = (dayArray);
                    }
                    newTravelSchedule.travelDays=travelDays;
                    $('input[name="datefilter"]').val(
                        newTravelSchedule.startDate +
                        '-' +
                        newTravelSchedule.endDate
                    )
                    let html = ` <option value="allday">전체 일정</option>`;
                    for (let i=1; i<=newTravelSchedule.dayAndNight; i++) {

                        if (i === 1) {
                            html += `   
                                <option value="${i}" selected="selected">${i}일 차</option>
                            `;
                        } else {
                            html += `   
                                <option value="${i}">${i}일 차</option>
                            `;
                        }
                        daySelect.innerHTML = html;
                    }

                    closeMyScheduleModal();
                    showSelectedDaySchedule();
                    showScheduleWindow();
                })
        });
    }
}
function closeMyScheduleModal(){
    myScheduleModal.style.display = "none";
    myScheduleModalBody[0].style.display = "none";
}
myScheduleModal.addEventListener("click", () => {
    closeMyScheduleModal();
});
// 필기. 내 일정 삭제 클릭 이벤트
function deleteMySchedule() {
    let myScheduleItems = document.getElementsByClassName("deleteSchedule");
    for (let i = 0; i < myScheduleItems.length; i++) {
        myScheduleItems[i].addEventListener("click", () => {
            const confirm = window.confirm("정말 삭제하시겠습니까?");
            if (!confirm){
                return;
            }
            let scheduleNo = myScheduleItems[i].closest(".plan").querySelector("#scheduleNo").innerText;

            fetch(`/schedule/deleteSchedule?scheduleNo=${scheduleNo}`)
                .then(resp => resp.json())
                .then(data => {
                    alert(data.message);
                    closeMyScheduleModal();
                })
                .catch((error) => {
                    console.error(error);
                    alert("예기치 못한 오류가 발생하였습니다.");
                })
        })
    }
};

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
                    newTravelSchedule.startDate = startDate;
                    newTravelSchedule.endDate = endDate;
                    newTravelSchedule.dayAndNight = dayAndNight;

                    let html = ` <option value="allday">전체 일정</option>`;
                    for (let i = 1; i <= dayAndNight; i++) {

                        if (i === 1) {
                            html += `   
                                <option value="${i}" selected="selected">${i}일 차</option>
                            `;
                        } else {
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
    newTravelSchedule.travelDays = travelDays;

    showScheduleWindow();
    saveScheduleInLocalStorage();
    showSelectedDaySchedule();
});

// 필기. 세부 일정 리스트 조회
function showSelectedDaySchedule() {
    dayNumber = daySelect.options[daySelect.selectedIndex].value;
    let html = ``;
    if (dayNumber === "allday") {   // 필기. 전체 일정 선택 시
        for (let i = 1; i < daySelect.options.length; i++) {
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
    console.log(newTravelSchedule);
    console.log("travelDays",travelDays);

    fetch("/schedule/insertSchedule", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
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
    window.localStorage.setItem("newTravelSchedule", JSON.stringify(newTravelSchedule));
}

function selectDaySchedule(day) {   // 필기. 전체 일정에서 일차 별 일정으로 이동 메소드
    daySelect.value = day;
    showSelectedDaySchedule();
}

/* 설명. 초기화 */

// 일정 정보들 초기화
function clearSchedule() {
    newTravelSchedule = {};
    travelDays = {};
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
let scheduleId = document.getElementById("scheduleName");
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