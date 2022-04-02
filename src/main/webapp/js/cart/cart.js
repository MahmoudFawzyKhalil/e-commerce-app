const cartProductList = document.getElementById("cartProductsList")
const orderTotal = document.getElementById("orderTotal")

cartProductList.addEventListener('click', e => {

    const buttonId = e.target.dataset.productid;
    const svgId = e.target.parentElement.dataset.productid;

    const targetId = buttonId ? buttonId : svgId;

    if (!targetId) {
        return
    }

    // console.log(targetId, " remove")

    handleRemoveProductFromCart(targetId)
})

async function removeProductFromCart(productId) {
    const result = await fetch(`/app/cart/remove?id=${productId}`);
    return result.json()
}

function handleRemoveProductFromCart(productId) {

    const productElement = document.getElementById(`${productId}`)

    // console.log("inside handle remove")
    // console.log(productElement)

    productElement.classList.add('hidden');

    removeProductFromCart(productId).then(json => orderTotal.innerText = `EGP ${json}`)

}


cartProductList.addEventListener('focusout', e => {

    console.log("unblurred")

    const targetName = e.target.name
    if (targetName === "quantity") {
        console.log("targetName inside if " + targetName)
        const targetProductId = e.target.dataset.quantityid
        console.log("productId" + targetProductId)
        console.log(e.target.value)
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