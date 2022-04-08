const cartProductList = document.getElementById("cartProductsList")
const orderTotal = document.getElementById("orderTotal")

cartProductList.addEventListener('click', e => {

    const buttonId = e.target.dataset.productid;
    const svgId = e.target.parentElement.dataset.productid;

    const targetId = buttonId ? buttonId : svgId;

    if (!targetId) {
        return
    }

    handleRemoveProductFromCart(targetId)
})

async function removeProductFromCart(productId) {
    const result = await fetch(`/app/cart/remove?id=${productId}`);
    return result.json()
}

function handleRemoveProductFromCart(productId) {

    const productElement = document.getElementById(`${productId}`)

    productElement.classList.add('hidden');

    removeProductFromCart(productId).then(json => orderTotal.innerText = `EGP ${json}`)

}


cartProductList.addEventListener('focusout', e => {

    const targetName = e.target.name
    if (targetName === "quantity") {
        const targetProductId = e.target.dataset.quantityid
        const targetProductQuantity = e.target.value
        handleUpdateProductQuantity(targetProductId, targetProductQuantity)
    }
})

async function updateProductQuantity(productId, productQuantity) {
    const result = await fetch(`/app/cart/update?id=${productId}&quantity=${productQuantity}`)
    return result.json()
}

function handleUpdateProductQuantity(productId, productQuantity) {
    updateProductQuantity(productId, productQuantity).then(json => orderTotal.innerText = `EGP ${json}`)
}


//SPINNER

const checkoutSpinner = document.getElementById("checkoutSpinner");
const checkoutButton = document.getElementById("checkoutButton");

checkoutButton.addEventListener('click', (e) => {
    checkoutButton.classList.add('hidden');
    checkoutSpinner.classList.remove('hidden');
})


