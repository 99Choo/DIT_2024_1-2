let draggingMenu = null;
let dragOverBox = null;
let totalAmount = 0;

function updateTotal() {
    totalAmount = 0;
    const cartItems = document.querySelectorAll('#boxCart .menu');
    cartItems.forEach(item => {
        const subtotal = parseFloat(item.dataset.subtotal);
        if (!isNaN(subtotal)) {
            totalAmount += subtotal;
        }
    });
    document.getElementById('totalDisplay').innerText = `총액: ${totalAmount.toFixed(0)}원`;
}

function onDragStartMenu(event) {
    draggingMenu = this;
    this.classList.add("draggingMenu");
}

function onDragEndMenu(event) {
    draggingMenu = null;
    this.classList.remove("draggingMenu");
    if (dragOverBox) {
        dragOverBox.classList.remove("overBox");
    }
}

function onDragOverBox(event) {
    event.preventDefault();
    dragOverBox = this;
    this.classList.add("overBox");
}

function onDragLeaveBox(event) {
    dragOverBox = null;
    this.classList.remove("overBox");
}

function onDropBox(event) {
    event.preventDefault();
    this.appendChild(draggingMenu);

    if (this.id === 'boxCart') {
        // 카트로 이동한 메뉴 UI 생성 및 데이터 설정
        if (!draggingMenu.querySelector('.quantity-wrapper')) {
            const quantityWrapper = document.createElement('div');
            quantityWrapper.className = 'quantity-wrapper';

            const decrementButton = document.createElement('button');
            decrementButton.className = 'decrement-button';
            decrementButton.innerText = '-';

            const incrementButton = document.createElement('button');
            incrementButton.className = 'increment-button';
            incrementButton.innerText = '+';

            const quantityDisplay = document.createElement('span');
            quantityDisplay.className = 'quantity';
            quantityDisplay.innerText = '1';

            quantityWrapper.appendChild(decrementButton);
            quantityWrapper.appendChild(quantityDisplay);
            quantityWrapper.appendChild(incrementButton);

            draggingMenu.appendChild(quantityWrapper);

            const subtotalDisplay = document.createElement('div');
            subtotalDisplay.className = 'subtotal';
            draggingMenu.dataset.price = parseFloat(draggingMenu.dataset.price); // 단가 설정
            draggingMenu.dataset.quantity = 1; // 초기 수량 설정
            draggingMenu.dataset.subtotal = draggingMenu.dataset.price; // 초기 소계 설정
            subtotalDisplay.innerText = `${draggingMenu.dataset.price}원`;
            draggingMenu.appendChild(subtotalDisplay);
        } else {
            // 기존 UI 복구 (이미 추가된 메뉴)
            draggingMenu.dataset.quantity = 1;
            draggingMenu.dataset.subtotal = draggingMenu.dataset.price;
            draggingMenu.querySelector('.quantity').innerText = '1';
            draggingMenu.querySelector('.subtotal').innerText = `${draggingMenu.dataset.price}원`;
        }

        updateTotal(); // 총액 업데이트
    } else if (this.id === 'boxMenu') {
        // 메뉴 영역으로 돌아갔을 때 데이터 초기화
        draggingMenu.dataset.quantity = 0;
        draggingMenu.dataset.subtotal = 0;
        draggingMenu.querySelector('.quantity-wrapper')?.remove(); // UI 요소 제거
        draggingMenu.querySelector('.subtotal')?.remove();
        updateTotal(); // 총액 업데이트
    }
}

// 이벤트 위임: 증감 버튼 클릭 처리
document.addEventListener('click', function(event) {
    if (event.target.classList.contains('decrement-button')) {
        const menuItem = event.target.closest('.menu');
        let quantity = parseInt(menuItem.dataset.quantity);
        if (quantity > 1) {
            quantity -= 1;
            menuItem.dataset.quantity = quantity;
            menuItem.querySelector('.quantity').innerText = quantity;
            menuItem.dataset.subtotal = (quantity * parseFloat(menuItem.dataset.price)).toFixed(0);
            menuItem.querySelector('.subtotal').innerText = `${menuItem.dataset.subtotal}원`;
            updateTotal();
        }
    } else if (event.target.classList.contains('increment-button')) {
        const menuItem = event.target.closest('.menu');
        let quantity = parseInt(menuItem.dataset.quantity);
        quantity += 1;
        menuItem.dataset.quantity = quantity;
        menuItem.querySelector('.quantity').innerText = quantity;
        menuItem.dataset.subtotal = (quantity * parseFloat(menuItem.dataset.price)).toFixed(0);
        menuItem.querySelector('.subtotal').innerText = `${menuItem.dataset.subtotal}원`;
        updateTotal();
    }
});

// 결제 및 영수증 처리
document.addEventListener('click', function(event) {
    if (event.target.id === 'paymentButton') {
        const cartItems = document.querySelectorAll('#boxCart .menu');
        if (cartItems.length === 0) {
            alert('장바구니가 비어 있습니다!');
            return;
        }

        let receipt = '영수증:\n';
        cartItems.forEach(item => {
            const name = item.getAttribute('menuname');
            const quantity = item.dataset.quantity;
            const subtotal = item.dataset.subtotal;
            receipt += `${name} - ${quantity}개: ${subtotal}원\n`;
        });

        receipt += `\n총액: ${totalAmount.toFixed(0)}원\n감사합니다!`;
        alert(receipt);

        // 화면 초기화
        cartItems.forEach(item => {
            document.getElementById('boxMenu').appendChild(item);
            item.dataset.quantity = 0;
            item.dataset.subtotal = 0;
            item.querySelector('.quantity-wrapper')?.remove();
            item.querySelector('.subtotal')?.remove();
        });
        updateTotal();
    }
});

// 관리자 기능: 메뉴 추가 및 삭제
document.addEventListener('click', function(event) {
    if (event.target.id === 'addMenuButton') {
        const menuName = prompt('추가할 메뉴 이름을 입력하세요:');
        const menuPrice = parseFloat(prompt('메뉴의 가격을 입력하세요:'));
        if (!menuName || isNaN(menuPrice)) {
            alert('유효한 메뉴 이름과 가격을 입력하세요.');
            return;
        }

        const newMenu = document.createElement('div');
        newMenu.className = 'menu';
        newMenu.setAttribute('draggable', 'true');
        newMenu.setAttribute('menuname', menuName);
        newMenu.dataset.price = menuPrice;

        const menuContent = document.createElement('div');
        menuContent.innerText = `${menuName} - ${menuPrice}원`;
        newMenu.appendChild(menuContent);

        newMenu.addEventListener("dragstart", onDragStartMenu);
        newMenu.addEventListener("dragend", onDragEndMenu);

        document.getElementById('boxMenu').appendChild(newMenu);
    }

});

// 관리자 창 열기 및 비밀번호 확인
document.addEventListener('click', function(event) {
    if (event.target.id === 'adminButton') {
        const password = prompt('관리자 비밀번호를 입력하세요:');
        if (password === '202430952') { // 비밀번호 검증
            const adminWindow = window.open('', 'AdminWindow', 'width=400,height=600');
            adminWindow.document.write(`
                <h1>관리자 기능</h1>
                <button id="addMenuButton">메뉴 추가</button>
                <button id="deleteMenuButton">메뉴 삭제</button>
                <button id="viewSalesHistoryButton">판매 내역 보기</button>
                <button id="clearSalesHistoryButton">판매 내역 초기화</button>
                <div id="adminLog"></div>
            `);

            // 관리자 기능 이벤트 리스너 추가
            adminWindow.document.getElementById('addMenuButton').addEventListener('click', () => {
                const menuName = prompt('추가할 메뉴 이름을 입력하세요:');
                const menuImage = prompt('메뉴 이미지 경로를 입력하세요:');
                const menuPrice = parseFloat(prompt('메뉴의 가격을 입력하세요:'));

                if (!menuName || isNaN(menuPrice)) {
                    alert('유효한 메뉴 이름과 이미지 경로 가격을 입력하세요.');
                    return;
                }

                const newMenu = document.createElement('div');
                newMenu.className = 'menu';
                newMenu.setAttribute('draggable', 'true');
                newMenu.setAttribute('menuname', menuName);
                newMenu.dataset.price = menuPrice;

                const menuContent = document.createElement('div');
                menuContent.innerText = `${menuName} - ${menuPrice}원`;
                newMenu.appendChild(menuContent);

                newMenu.addEventListener("dragstart", onDragStartMenu);
                newMenu.addEventListener("dragend", onDragEndMenu);

                document.getElementById('boxMenu').appendChild(newMenu);
                adminWindow.document.getElementById('adminLog').innerText = `메뉴 "${menuName}" 추가 완료.`;
            });

            adminWindow.document.getElementById('deleteMenuButton').addEventListener('click', () => {
                const menuName = prompt('삭제할 메뉴 이름을 입력하세요:');
                const menuList = document.querySelectorAll('.menu');
                let deleted = false;

                menuList.forEach(menu => {
                    if (menu.getAttribute('menuname') === menuName) {
                        menu.remove();
                        deleted = true;
                    }
                });

                if (deleted) {
                    adminWindow.document.getElementById('adminLog').innerText = `메뉴 "${menuName}" 삭제 완료.`;
                } else {
                    adminWindow.document.getElementById('adminLog').innerText = `메뉴 "${menuName}"를 찾을 수 없습니다.`;
                }
            });

            adminWindow.document.getElementById('viewSalesHistoryButton').addEventListener('click', () => {
                let history = '판매 내역:\n';
                let totalSales = 0;
                salesHistory.forEach(sale => {
                    history += `${sale.name} - ${sale.quantity}개: ${sale.subtotal}원\n`;
                    totalSales += parseFloat(sale.subtotal);
                });
                history += `\n총 판매 금액: ${totalSales.toFixed(0)}원`;
                adminWindow.alert(history);
            });

            adminWindow.document.getElementById('clearSalesHistoryButton').addEventListener('click', () => {
                salesHistory = [];
                adminWindow.alert('판매 내역이 초기화되었습니다.');
                adminWindow.document.getElementById('adminLog').innerText = '판매 내역 초기화 완료.';
            });
        } else {
            alert('비밀번호가 일치하지 않습니다.');
        }
    }
});


$(document).ready(function() {
    const menuArray = document.getElementsByClassName("menu");
    for (let menu of menuArray) {
        menu.addEventListener("dragstart", onDragStartMenu);
        menu.addEventListener("dragend", onDragEndMenu);
        const priceDisplay = document.createElement('div');
        priceDisplay.className = 'price-display';
        priceDisplay.innerText = `${menu.dataset.price}원`;
        menu.appendChild(priceDisplay);


    }

    const boxArray = document.getElementsByClassName("box");
    for (let box of boxArray) {
        box.addEventListener("dragover", onDragOverBox);
        box.addEventListener("dragleave", onDragLeaveBox);
        box.addEventListener("drop", onDropBox);
    }

    const totalDisplay = document.createElement('div');
    totalDisplay.id = 'totalDisplay';
    totalDisplay.innerText = '총액: 0원';
    document.body.appendChild(totalDisplay);

    // 결제 버튼 추가
    const paymentButton = document.createElement('button');
    paymentButton.id = 'paymentButton';
    paymentButton.innerText = '결제';
    document.body.appendChild(paymentButton);

    // 관리자 버튼 추가
    const adminButton = document.createElement('button');
    adminButton.id = 'adminButton';
    adminButton.innerText = '관리자';
    adminButton.style.position = 'absolute';
    adminButton.style.top = '10px';
    adminButton.style.right = '10px';
    document.body.appendChild(adminButton);
});
