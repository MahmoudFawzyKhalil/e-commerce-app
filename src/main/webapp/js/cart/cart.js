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
    console.log("name " + e.target.name)
    console.log("id " + e.target.dataset.quantityid)
    

})