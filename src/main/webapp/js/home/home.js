/* PRODUCT PAGINATION */
const productsContainer = document.getElementById("productsContainer");
const loadMoreButton = document.getElementById("loadMoreButton");
const loadMoreSpinner = document.getElementById("loadMoreSpinner");
let currentPage = 1;

async function getProductPage() {
    const response = await fetch(`/app/products?page=${currentPage}`);
    return await response.json();
}

getProductPage().then(json => {
    appendProductPage(json);
});

loadMoreButton.addEventListener('click', e => {
    currentPage++;
    toggleLoadMoreSpinner();
    getProductPage().then(json => {
        console.log(json);
        if (json.length === 0) {
            loadMoreButton.classList.add('hidden');
            loadMoreSpinner.classList.add('hidden');
            return;
        }
        appendProductPage(json);
        toggleLoadMoreSpinner();
    });
});

function toggleLoadMoreSpinner() {
    loadMoreButton.classList.toggle('hidden');
    loadMoreSpinner.classList.toggle('hidden');
}

function appendProductPage(json) {
    let productsMarkup = "";

    json.forEach(product => {
        productsMarkup +=
            `
        <div class="p-2 rounded-lg shadow-md cursor-pointer hover:shadow-xl">
            <a href="/app/product?id=${product.id}">
                <div class="relative">
                    <div class="relative w-full overflow-hidden rounded-lg h-72">
                        <img src="/images/${product.imageName}"
                             alt="${product.name}" class="object-scale-down object-center w-full h-full">
                    </div>
                    <div class="relative mt-4">
                        <h3 class="text-sm font-medium text-gray-900">${product.name}</h3>
                        <p class="mt-1 text-sm text-gray-500 truncate">${product.description}</p>
                    </div>
                    <div
                            class="absolute inset-x-0 top-0 flex items-end justify-end p-4 overflow-hidden rounded-lg h-72">
                        <div aria-hidden="true"
                             class="absolute inset-x-0 bottom-0 opacity-50 h-36 bg-gradient-to-t from-black">
                        </div>
                        <p class="relative text-lg font-semibold text-white">EGP ${product.priceFormatted}</p>
                    </div>
                </div>
                <div class="mt-6">
                    <a data-productId="${product.id}"
                       class="relative flex items-center justify-center px-8 py-2 text-sm font-medium text-gray-900 bg-gray-100 border border-transparent rounded-md hover:bg-gray-200">Add
                        to cart</a>
                </div>
            </a>
        </div>
        `
    });

    productsContainer.innerHTML += productsMarkup;
}

/* SEARCH */

const productsTitle = document.getElementById("productsTitle");
const searchInput = document.getElementById("searchInput");
const categorySelect = document.getElementById("categorySelect");
const searchButton = document.getElementById("searchButton");
const categoryPreviews = document.getElementById("categoryPreviews");
const viewTheCollectionButton = document.getElementById("viewTheCollectionButton");

async function searchForProducts() {
    console.log("HELLO")
    const response = await fetch(`/app/products/search?query=${searchInput.value}&category=${categorySelect.value}`);
    return await response.json();
}

searchButton.addEventListener('click', e => {
    handleSearch();
});

viewTheCollectionButton.addEventListener('click', e => {
    e.preventDefault();
    categorySelect.value = 'Chocolate';
    handleSearch();
});

searchInput.addEventListener('keydown', e => {
    if (e.key === 'Enter') {
        handleSearch();
    }
})

function handleSearch() {
    hideLoadMoreAndCategoryPreviews();
    searchForProducts().then(json => {
        console.log(json);
        if (json.length === 0) {
            productsTitle.textContent = "No results 😢"
            productsContainer.innerHTML = "";
            return;
        }

        productsTitle.textContent = "Search results 🔍"
        replaceProductsMarkupWithSearch(json)
    });
}

function hideLoadMoreAndCategoryPreviews() {
    if (!categoryPreviews.classList.contains('hidden')) {
        categoryPreviews.classList.add('hidden');
        loadMoreButton.classList.add('hidden');
    }
}

function replaceProductsMarkupWithSearch(json) {
    let productsMarkup = "";

    json.forEach(product => {
        productsMarkup +=
            `
        <div class="p-2 rounded-lg shadow-md cursor-pointer hover:shadow-xl">
            <a href="/app/product?id=${product.id}">
                <div class="relative">
                    <div class="relative w-full overflow-hidden rounded-lg h-72">
                        <img src="/images/${product.imageName}"
                             alt="${product.name}" class="object-scale-down object-center w-full h-full">
                    </div>
                    <div class="relative mt-4">
                        <h3 class="text-sm font-medium text-gray-900">${product.name}</h3>
                        <p class="mt-1 text-sm text-gray-500 truncate">${product.description}</p>
                    </div>
                    <div
                            class="absolute inset-x-0 top-0 flex items-end justify-end p-4 overflow-hidden rounded-lg h-72">
                        <div aria-hidden="true"
                             class="absolute inset-x-0 bottom-0 opacity-50 h-36 bg-gradient-to-t from-black">
                        </div>
                        <p class="relative text-lg font-semibold text-white">EGP ${product.priceFormatted}</p>
                    </div>
                </div>
                <div class="mt-6">
                    <a data-productId="${product.id}"
                       class="relative flex items-center justify-center px-8 py-2 text-sm font-medium text-gray-900 bg-gray-100 border border-transparent rounded-md hover:bg-gray-200">Add
                        to cart</a>
                </div>
            </a>
        </div>
        `
    });

    productsContainer.innerHTML = productsMarkup;
}

/* ADD TO CART */
const totalPrice = document.getElementById("orderTotal");


productsContainer.addEventListener('click', e => {

    const targetId = e.target.dataset.productid

    if (!targetId) {
        return
    }

    console.log(targetId);

    e.target.parentElement.innerHTML = `
                <div class="mt-6">
                    <a
                       class="relative flex items-center justify-center px-8 py-2 text-sm font-medium text-gray-900 bg-gray-100 border border-transparent rounded-md cursor-default">
                       <svg xmlns="http://www.w3.org/2000/svg" class="inline-block w-6 h-6" fill="none"
                                     viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                            <path stroke-linecap="round" stroke-linejoin="round"
                                  d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z">  
                            </path>
                       </svg>
                    </a>
                </div>
`
    e.stopPropagation()
    handleAddProductToCart(targetId);
})

async function addProductToCart(id) {
    const result = await fetch(`/app/cart/add?id=${id}`)
    return result.status
}

function handleAddProductToCart(id) {

    addProductToCart(id).then(res => console.log(res))
}


