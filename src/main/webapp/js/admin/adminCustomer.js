let req = null;
let url = null;
let pageNumber = document.getElementById("pageNumber");
let currentPageNumber = document.getElementById("currentPageNumber");
let nextButton = document.getElementById("nextButton");
let previousButton = document.getElementById("previousButton");

previousButton.classList.add('hidden')
console.log("page number " + pageNumber.value + " current pageNumber" + currentPageNumber.value)
if (pageNumber.value === currentPageNumber.value) {
    nextButton.classList.add('hidden')
}

nextButton.addEventListener("click", (e) => {
    currentPageNumber.value = parseInt(currentPageNumber.value) + 1
    navigate(currentPageNumber.value);
})

previousButton.addEventListener("click", (e) => {
    currentPageNumber.value = parseInt(currentPageNumber.value) - 1;
    navigate(currentPageNumber.value);
})

function navigate(PageNumber) {
    console.log("BOOM")
    createXMLHttpRequest();
    url = "/app/ListAjex?pg=" + PageNumber + "&timeStamp=" + new Date().getTime();
    console.log(url)
    req.open("GET", url, true);
    console.log("after open");
    req.onreadystatechange = handleStateChange;
    console.log("after onready");
    req.send();
}

let table = document.getElementById("tbody");
let row = "";

function handleStateChange() {
    if (req.readyState == 4 && req.status == 200) {
        let list = JSON.parse(req.responseText);
        console.log(list[0].name);
        list.forEach(user => {
          row +=  ` <tr>
                        <td class="py-2 pl-4 pr-3 text-sm text-gray-500 whitespace-nowrap sm:pl-6">1
                        </td>
                        <td class="px-2 py-2 text-sm font-medium text-gray-900">${user.name}</td>
                        <td class="px-2 py-2 text-sm text-gray-900 ">${user.email}</td>
                        <td class="px-2 py-2 text-sm text-gray-500 ">${user.phoneNumber}</td>
                        <td class="px-2 py-2 text-sm text-gray-500 ">${user.address}</td>
                        <td class="px-2 py-2 text-sm text-gray-500 ">${user.birthday}</td>

                        <td class="px-2 py-2 text-sm text-gray-500 ">${user.job}</td>
                        <td class="px-2 py-2 text-sm text-gray-500 ">${user.creditLimit}</td>
                        <td class="relative py-2 pl-3 pr-4 text-sm font-medium text-right whitespace-nowrap sm:pr-6">
                            <a href="/app/admin/customers/customer" class="text-indigo-600 hover:text-indigo-900">Orders</a>
                        </td>
                    </tr>
            `
        });
    table.innerHTML = row;
    row ="";
    }

}

function createXMLHttpRequest() {
    if (window.ActiveXObject)
        req = new ActiveXObject("Microsoft.XMLHTTP");
    else if (window.XMLHttpRequest)
        req = new XMLHttpRequest();
}

