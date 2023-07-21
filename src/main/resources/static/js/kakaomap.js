// 필기. 현 지도 경계 좌표 얻기, 이동범위 제한 두기 위한 메소드
// function getMapBounds () {
//     let mapBounds = map.getBounds();
//
//     console.log(mapBounds.toString());
// }

// 설명. 지도 그리기
let container = document.getElementById("map");
let options = {
    center: new kakao.maps.LatLng(33.350701, 126.470667),
    level: 9
};
let map = new kakao.maps.Map(container, options);
map.setMaxLevel(12);    // 필기. 지도 축소 최대치 설정

// 설명. 지도 이동 범위 제한
let pos1 = new kakao.maps.LatLng(33.087182684278126, 126.0769775264879);
let pos2 = new kakao.maps.LatLng(33.64512382818494, 127.05070758110132);
let bounds = new kakao.maps.LatLngBounds(pos1, pos2);
let constrainBounds = function () {
    let center = map.getCenter();

    let clipLat, clipLng, sw, ne;
    if (!bounds.contain(center)) {

        sw = bounds.getSouthWest();
        ne = bounds.getNorthEast();

        clipLat = Math.min(Math.max(sw.getLat(), center.getLat()), ne.getLat());
        clipLng = Math.min(Math.max(sw.getLng(), center.getLng()), ne.getLng());

        map.setCenter(new kakao.maps.LatLng(clipLat, clipLng));
    }
};
kakao.maps.event.addListener( map, 'drag', constrainBounds);
kakao.maps.event.addListener( map, 'zoom_changed', constrainBounds);

// 필기. 마커를 담을 배열입니다
let markers = [];

// 설명. 장소 검색 객체
const ps = new kakao.maps.services.Places();

// 설명. 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성
const infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 설명. 키워드로 장소를 검색합니다.
const searchForm = document.getElementById("searchKeyword");
searchForm?.addEventListener("click", function (e) {
    e.preventDefault();
    searchPlaces();
});

// 설명. 장소 검색 메소드
function searchPlaces() {

    const keyword = document.getElementById('keyword').value;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
    }

    // 설명. 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB);
}

// 설명. 장소 검색이 완료됐을 때 호출되는 콜백함수 입니다.
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

// 필기. 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {

    let listEl = document.getElementById('placesList'),
        menuEl = document.getElementById('menu_wrap'),
        fragment = document.createDocumentFragment(),
        bounds = new kakao.maps.LatLngBounds(),
        listStr = '';

    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();

    for ( let i=0; i<places.length; i++ ) {

        // 마커를 생성하고 지도에 표시합니다
        let placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
            marker = addMarker(placePosition, i),
            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을 때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        (function(marker, title) {
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                displayInfowindow(marker, title);
            });

            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });

            itemEl.onmouseover =  function () {
                displayInfowindow(marker, title);
            };

            itemEl.onmouseout =  function () {
                infowindow.close();
            };
        })(marker, places[i].place_name);

        fragment.appendChild(itemEl);
    }

    // 검색결과 항목들을 검색결과 목록 Element에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
}

// 설명. 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {

    let el = document.createElement('li'),
        itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
            '<div class="info">' +
            '   <h5>' + places.place_name + '</h5>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
            '   <span class="jibun gray">' +  places.address_name  + '</span>';
    } else {
        itemStr += '    <span>' +  places.address_name  + '</span>';
    }

    itemStr += '  <span class="tel">' + places.phone  + '</span>' +
        '</div>';

    el.innerHTML = itemStr;
    el.className = 'item';

    return el;
}

// 설명. 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
    let imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
        marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage
        });

    marker.setMap(map); // 설명. 지도 위에 마커를 표출합니다
    markers.push(marker);  // 설명. 배열에 생성된 마커를 추가합니다

    return marker;
}

// 설명. 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( let i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    let paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i;

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        let el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 설명. 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 설명. 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
    let content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

    infowindow.setContent(content);
    infowindow.open(map, marker);
}

// 설명. 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}