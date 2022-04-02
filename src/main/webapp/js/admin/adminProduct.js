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
    console.log(num)
    if (num === "1") {
        previousButton.classList.add("hidden")
        previousButton.classList.add("disabled")
    } else {
        previousButton.classList.remove("hidden")
        previousButton.classList.remove("disabled")
    }
    if (num === pageNumber.value) {
        nextButton.classList.add('hidden')
        nextButton.classList.add("disabled")
    } else {
        nextButton.classList.remove("hidden")
        nextButton.classList.remove("disabled")
    }

}

function navigate(PageNumber) {
    createXMLHttpRequest();
    url = "/app/productAjax?pg=" + PageNumber + "&timeStamp=" + new Date().getTime();
    console.log(url)
    req.open("GET", url, true);
    req.onreadystatechange = handleStateChange;
    req.send();
}

function handleStateChange() {
    if (req.readyState === 4 && req.status === 200) {
        let list = JSON.parse(req.responseText);
        list.forEach(product => {
            row += ` <tr>
                    <td class="py-2 pl-4 pr-3 text-sm text-gray-500 whitespace-nowrap sm:pl-6">${product.id}</td>
                    <td class="px-2 py-2 text-sm font-medium text-gray-900">${product.name}</td>
                    <td class="px-2 py-2 text-sm text-gray-900 ">${product.description}</td>
                    <td class="px-2 py-2 text-sm text-gray-500 whitespace-nowrap">${product.quantity}</td>
                    <td class="px-2 py-2 text-sm text-gray-500 whitespace-nowrap">${product.priceFormatting}</td>
                    <td class="px-2 py-2 text-sm text-gray-500 whitespace-nowrap">${product.category}</td>
                    <td class="relative py-2 pl-3 pr-4 text-sm font-medium text-right whitespace-nowrap sm:pr-6">
                      <a href="/app/admin/products/edit?productId=${product.id}" class="text-indigo-600 hover:text-indigo-900">Edit<span class="sr-only">,
                          AAPS0L</span></a>
                    </td>
                    <td class="relative py-2 pl-3 pr-4 text-sm font-medium text-right whitespace-nowrap sm:pr-6">
                      <a href="/app/admin/products/delete?productId=${product.id}" class="text-indigo-600 hover:text-indigo-900">Delete<span class="sr-only">,
                          AAPS0L</span></a>
                    </td>
                  </tr>
            `
            // href="<c:url value="/admin/products/add" />"
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
