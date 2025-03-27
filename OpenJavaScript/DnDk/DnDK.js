let cart = {};

function drag(event) {
    event.dataTransfer.setData("text", event.target.id);
}

function allowDrop(event) {
    event.preventDefault();
}

function drop(event, targetAreaId) {
    event.preventDefault();
    const itemId = event.dataTransfer.getData("text");
    const item = document.getElementById(itemId);
    const targetArea = document.getElementById(targetAreaId);

    if (targetAreaId === "cart-area") {
        addToCart(item);
    } else {
        removeFromCart(itemId);
    }
}

function addToCart(item) {
    const name = item.getAttribute("data-name");
    const price = parseInt(item.getAttribute("data-price"));

    if (!cart[name]) {
        cart[name] = { price: price, quantity: 1 };
    } else {
        cart[name].quantity++;
    }
    updateCartDisplay();
}

function removeFromCart(itemId) {
    const name = document.getElementById(itemId).getAttribute("data-name");
    delete cart[name];
    updateCartDisplay();
}

function changeQuantity(name, delta) {
    if (cart[name]) {
        cart[name].quantity += delta;
        if (cart[name].quantity <= 0) delete cart[name];
        updateCartDisplay();
    }
}

function updateCartDisplay() {
    const cartItems = document.getElementById("cart-items");
    const totalElement = document.getElementById("total");
    cartItems.innerHTML = "";
    let total = 0;

    for (let name in cart) {
        const item = cart[name];
        total += item.price * item.quantity;
        cartItems.innerHTML += `
            <div class="cart-item">
                <p>${name} - ${item.price}원 x ${item.quantity} = ${item.price * item.quantity}원</p>
                <div class="quantity-controls">
                    <button onclick="changeQuantity('${name}', -1)">-</button>
                    <span>${item.quantity}</span>
                    <button onclick="changeQuantity('${name}', 1)">+</button>
                </div>
            </div>
        `;
    }
    totalElement.textContent = `총액: ${total}원`;
}
