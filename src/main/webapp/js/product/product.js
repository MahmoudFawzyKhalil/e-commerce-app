const addToCartButton = document.getElementById("addToCartButton");

addToCartButton.addEventListener('click', e => {
    e.preventDefault();
    const productId = addToCartButton.dataset.productid

    addToCartButton.classList.add('hidden')
    document.getElementById("addedToCartIcon").classList.remove('hidden')
    handleAddProductToCart(productId)
})


async function addProductToCart(id) {
    const result = await fetch(`/cart/add?id=${id}`)
    return result.status
}

function handleAddProductToCart(id) {
    addProductToCart(id).then(res => {
    })
}
