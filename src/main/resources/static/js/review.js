function reviewList() {

    let url = '/review/query/reviewList';
    let options = {
        method: 'GET',
        headers: {'content-Type': 'application/json'}
    };
    fetch(url, options)
        .then((response) => response.json())
        .then((data) => console.log(data))
}