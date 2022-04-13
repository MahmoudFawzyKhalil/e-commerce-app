let req = null;
let url = null;
let pageNumber = document.getElementById("pageNumber");
let currentPageNumber = document.getElementById("currentPageNumber");
let nextButton = document.getElementById("nextButton");
let previousButton = document.getElementById("previousButton");
let tableParent = document.getElementById("tableParent");
let msgDiv = "";
let table = document.getElementById("tbody");
let row = "";
let deletedId = 0

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
    console.log(pageNumber.value === "1");
    console.log(pageNumber.value == "0");
    console.log(pageNumber.value)
    if (num === "1") {
        previousButton.classList.add("hidden")
        previousButton.classList.add("disabled")
    } else {
        previousButton.classList.remove("hidden")
        previousButton.classList.remove("disabled")
    }
    if (num === pageNumber.value || pageNumber.value === "0") {
        nextButton.classList.add('hidden')
        nextButton.classList.add("disabled")
    } else {
        nextButton.classList.remove("hidden")
        nextButton.classList.remove("disabled")
    }

}

function navigate(PageNumber) {
    createXMLHttpRequest();
    url = "/productAjax?pg=" + PageNumber + "&timeStamp=" + new Date().getTime();
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
                    <td class="px-2 py-2 text-sm text-gray-500 whitespace-nowrap">EGP ${product.priceFormatting}</td>
                    <td class="px-2 py-2 text-sm text-gray-500 whitespace-nowrap">${product.category}</td>
                    <td class="relative py-2 pl-3 pr-4 text-sm cursor-pointer font-medium text-right whitespace-nowrap sm:pr-6">
                      <a href="/admin/products/edit?productId=${product.id}" class="text-indigo-600 hover:text-indigo-900">Edit<span class="sr-only">,
                          AAPS0L</span></a>
                    </td>
                    <td class="relative py-2 pl-3 pr-4 text-sm cursor-pointer font-medium text-right whitespace-nowrap sm:pr-6">
                      <a onclick="deleteProduct(${product.id})" class="text-indigo-600 hover:text-indigo-900">Delete<span class="sr-only">,
                          AAPS0L</span></a>
                    </td>
                  </tr>
            `
            // href="<c:url value="/admin/products/add" />"
        });
        if (list.length == 0) {
            console.log("null")
            msgDiv = `<h4 class="text-center">No Products</h4>`
            tableParent.innerHTML = msgDiv;
            msgDiv = "";
        }

        table.innerHTML = row;
        validation(currentPageNumber.value)
        row = "";
    }
}

function deleteProduct(id) {
    deletedId = id
    document.getElementById("divOfDelete").classList.remove("hidden")
}

function cancelDeletion() {
    document.getElementById("divOfDelete").classList.add("hidden")
}

function confirmDeletion() {
    window.location.href = "/admin/products/delete?productId=" + deletedId
}

function createXMLHttpRequest() {
    if (window.ActiveXObject)
        req = new ActiveXObject("Microsoft.XMLHTTP");
    else if (window.XMLHttpRequest)
        req = new XMLHttpRequest();
}
