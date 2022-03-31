let req = null;
let url = null;
let pageNumber = document.getElementById("pageNumber");
let currentPageNumber = document.getElementById("currentPageNumber");
let nextButton = document.getElementById("nextButton");
let previousButton = document.getElementById("previousButton");

previousButton.classList.add('hidden')
console.log("page number "+pageNumber.value + " current pageNumber" + currentPageNumber.value)
if (pageNumber.value === currentPageNumber.value){
    nextButton.classList.add('hidden')
}

nextButton.addEventListener("click" ,(e)=>{
    navigate(parseInt(currentPageNumber.value) +1)
})

previousButton.addEventListener("click" ,(e)=>{
    navigate(parseInt(currentPageNumber.value) -1)
})

function navigate(PageNumber) {
    console.log("BOOM")
    createXMLHttpRequest();
    url ="/app/admin/customers?pg="+ PageNumber + "&timeStamp=" + new Date().getTime();
    console.log(url)
    req.open("GET", url, true);
    console.log("after open");
    req.onreadystatechange = handleStateChange;
    console.log("after onready");
    req.send();
}

function handleStateChange() {
    if (req.readyState == 4 && req.status == 200){
        // table= document.getElementById('table');
        // if(userList.size() !=0){/
            list = req.responseText;
            // for(i=0; i<list.length ; i++){
            //     tr= `<tr><td>`+list[i]+`</td></tr>`
            // }
          //  console.log(req);
            // table.innerHTML = list;
        }

    console.log("callback");
}

function createXMLHttpRequest() {
    if (window.ActiveXObject)
        req = new ActiveXObject("Microsoft.XMLHTTP");
    else if (window.XMLHttpRequest)
        req = new XMLHttpRequest();
}

