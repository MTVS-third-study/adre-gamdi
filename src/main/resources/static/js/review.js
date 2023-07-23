
    const reviewAdd = document.getElementById("reviewNav")
    const reviewItem = document.getElementsByClassName("reviewBox")
    const reviewList = document.querySelectorAll("#reviewContentsBox")

    for (let i = 0; i < reviewList.length; i++) {

        reviewItem[i].addEventListener("click", () => {
            let reviewNo = reviewList[i].querySelector("#reviewNo").innerText
            let url = `/placeQuery/reviewInfo??placeNo=${placeNo}`;

            fetch(url)
                .then((response) => response.json())
                .then((data) => {
                    console.log(data);
                })
                .catch((error) => {
                    console.error(error);
                    alert("예기치 못한 오류 발생")
                })
        })
    }

