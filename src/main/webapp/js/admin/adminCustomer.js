let req = null;
let url = null;
let pageNumber = document.getElementById("pageNumber");
let currentPageNumber = document.getElementById("currentPageNumber");
let nextButton = document.getElementById("nextButton");
let previousButton = document.getElementById("previousButton");

let table = document.getElementById("tbody");
let row = "";

document.onload = navigate(1)

previousButton.addEventListener("click", (e) => {
    currentPageNumber.value = parseInt(currentPageNumber.value) - 1;
    navigate(currentPageNumber.value);
})

nextButton.addEventListener("click", (e) => {
    currentPageNumber.value = parseInt(currentPageNumber.value) + 1
    navigate(currentPageNumber.value);
})

function validation(num) {
    if (num === "1") {
        previousButton.classList.add("hidden")
        previousButton.classList.add("disabled")
    } else {
        previousButton.classList.remove("hidden")
        previousButton.classList.remove("disabled")
    }
    if (num === pageNumber.value || pageNumber.value === "1") {
        nextButton.classList.add('hidden')
        nextButton.classList.add("disabled")
    } else {
        nextButton.classList.remove("hidden")
        nextButton.classList.remove("disabled")
    }

}

function navigate(PageNumber) {
    createXMLHttpRequest();
    url = "/app/ListAjax?pg=" + PageNumber + "&timeStamp=" + new Date().getTime();
    console.log(url)
    req.open("GET", url, true);
    req.onreadystatechange = handleStateChange;
    req.send();
}

function handleStateChange() {
    console.log("feehh ehh")
    if (req.readyState === 4 && req.status === 200) {
        let list = JSON.parse(req.responseText);
        list.forEach(user => {
            console.log("hey")
            let address = JSON.parse(user.address)
            row += ` <tr>
                        <td class="py-2 pl-4 pr-3 text-sm text-gray-500 whitespace-nowrap sm:pl-6">${user.id}
                        </td>
                        <td class="px-2 py-2 text-sm font-medium text-gray-900">${user.name}</td>
                        <td class="px-2 py-2 text-sm text-gray-900 ">${user.email}</td>
                        <td class="px-2 py-2 text-sm text-gray-500 ">${user.phoneNumber}</td>
                        <td class="px-2 py-2 text-sm text-gray-500 ">${address.street}, ${address.city}</td>
                        <td class="px-2 py-2 text-sm text-gray-500 ">${user.birthday}</td>
                        <td class="px-2 py-2 text-sm text-gray-500 ">${user.job}</td>
                        <td class="px-2 py-2 text-sm text-gray-500 ">EGP ${user.creditLimitFormatting}.00</td>
                        <td class="relative py-2 pl-3 pr-4 text-sm font-medium text-right whitespace-nowrap sm:pr-6">
                            <a href='/app/admin/customers/customer?id=${user.id}' class="text-indigo-600 hover:text-indigo-900">View</a>
                        </td>
                    </tr>
            `
        });
        table.innerHTML = row;
        validation(currentPageNumber.value)
        row = "";
    }
}

function createXMLHttpRequest() {
    if (window.ActiveXObject)
        req = new ActiveXObject("Microsoft.XMLHTTP");
    else if (window.XMLHttpRequest)
        req = new XMLHttpRequest();
}
