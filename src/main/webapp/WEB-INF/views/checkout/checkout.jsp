<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="shoppingCart" type="gov.iti.jets.domain.models.ShoppingCart"--%>
<%--@elvariable id="lineItem" type="gov.iti.jets.domain.models.CartLineItem"--%>
<%--@elvariable id="user" type="gov.iti.jets.domain.models.User"--%>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <script src="<c:url value="/js/components/cookie.js"/>"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/tailwind-out.css"/>">
    <title>Checkout | ChocoTown</title>
</head>

<body class="flex flex-col h-screen">
<%@include file="/WEB-INF/views/navbars/customerNav.jspf" %>

<section id="alertSection" class="z-20">
    <c:if test="${shoppingCartOutdated != null}">
        <div class="rounded-md bg-red-50 p-4">
            <div class="flex">
                <div class="flex-shrink-0">
                    <!-- Heroicon name: solid/x-circle -->
                    <svg class="h-5 w-5 text-red-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
                         fill="currentColor">
                        <path fill-rule="evenodd"
                              d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z"
                              clip-rule="evenodd"></path>
                    </svg>
                </div>
                <div class="ml-3">
                    <h3 class="text-sm font-medium text-red-800">One or more items are no longer are available or
                        their quantities were reduced. 📦</h3>
                </div>
            </div>
        </div>
    </c:if>
</section>


<%-- CHECKOUT --%>
<section id="checkout">
    <div class="bg-white">
        <!-- Background color split screen for large screens -->
        <div class="hidden lg:block fixed top-0 left-0 w-1/2 h-full bg-white" aria-hidden="true"></div>
        <div class="hidden lg:block fixed top-0 right-0 w-1/2 h-full bg-indigo-900" aria-hidden="true"></div>

        <div class="relative grid grid-cols-1 gap-x-16 max-w-7xl mx-auto lg:px-8 lg:grid-cols-2 lg:pt-16">
            <h1 class="sr-only">Checkout</h1>

            <section aria-labelledby="summary-heading"
                     class="bg-indigo-900 text-indigo-300 py-12 md:px-10 lg:max-w-lg lg:w-full lg:mx-auto lg:px-0 lg:pt-0 lg:pb-24 lg:bg-transparent lg:row-start-1 lg:col-start-2">
                <div class="max-w-2xl mx-auto px-4 lg:max-w-none lg:px-0">
                    <h2 id="summary-heading" class="sr-only">Order summary</h2>

                    <dl>
                        <dt class="text-sm font-medium">Amount due</dt>
                        <dd class="mt-1 text-3xl font-extrabold text-white">EGP ${shoppingCart.totalFormatted}</dd>
                    </dl>

                    <ul role="list" class="text-sm font-medium divide-y divide-white divide-opacity-10">
                        <c:forEach items="${shoppingCart.cartLineItemsUnmodifiable}" var="item">
                            <li class="flex items-start py-6 space-x-4">
                                <img src="${item.product.imageName}"
                                     alt="${item.product.description}"
                                     class="flex-none w-20 h-20 rounded-md object-cover object-scale-down">
                                <div class="flex-auto space-y-1">
                                    <h3 class="text-white">${item.product.name}</h3>
                                    <p>x${item.quantity}</p>
                                </div>
                                <p class="flex-none text-base font-medium text-white">EGP ${item.totalCostFormatted}</p>
                            </li>
                        </c:forEach>

                        <!-- More products... -->
                    </ul>
                </div>
            </section>

            <section aria-labelledby="payment-and-shipping-heading"
                     class="py-16 lg:max-w-lg lg:w-full lg:mx-auto lg:pt-0 lg:pb-24 lg:row-start-1 lg:col-start-1">
                <h2 id="payment-and-shipping-heading" class="sr-only">Payment and shipping details</h2>

                <form id="checkoutForm" method="post">
                    <div class="max-w-2xl mx-auto px-4 lg:max-w-none lg:px-0">
                        <div class="mt-10">
                            <h3 class="text-lg font-medium text-gray-900">Payment details</h3>

                            <div class="mt-6 grid grid-cols-3 sm:grid-cols-4 gap-y-6 gap-x-4">
                                <div class="col-span-3 sm:col-span-4">
                                    <label for="ccNumber" class="block text-sm font-medium text-gray-700">Card
                                        number</label>
                                    <div class="mt-1">
                                        <input type="text" id="ccNumber" name="ccNumber" autocomplete="cc-number"
                                               class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                        <span class="invisible text-xs text-red-500"
                                              id="ccNumberValidation">Please enter a valid credit card number.</span>
                                    </div>
                                </div>

                                <div class="col-span-2 sm:col-span-3">
                                    <label for="expDate" class="block text-sm font-medium text-gray-700">Expiration
                                        date (MM/YY)</label>
                                    <div class="mt-1">
                                        <input type="text" name="expDate" id="expDate"
                                               autocomplete="cc-exp"
                                               class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                        <span class="invisible text-xs text-red-500"
                                              id="expDateValidation">Please enter a valid expiration date.</span>
                                    </div>
                                </div>

                                <div>
                                    <label for="cvc" class="block text-sm font-medium text-gray-700">CVC</label>
                                    <div class="mt-1">
                                        <input type="text" name="cvc" id="cvc" autocomplete="csc"
                                               class="block w-full border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                        <span class="invisible text-xs text-red-500"
                                              id="cvcValidation">Please enter a CVC.</span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="mt-10 flex justify-end pt-6 border-t border-gray-200">
                            <button id="submitButton" type="submit"
                                    class="bg-indigo-600 border border-transparent rounded-md shadow-sm py-2 px-4 text-sm font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-50 focus:ring-indigo-500">
                                Pay now
                            </button>

                            <svg id="spinner" class="hidden w-24 inline-flex justify-center px-4 py-2 ml-3 "
                                 xmlns="http://www.w3.org/2000/svg"
                                 xmlns:xlink="http://www.w3.org/1999/xlink" style="shape-rendering: auto;"
                                 viewBox="0 0 100 100"
                                 preserveAspectRatio="xMidYMid">
                                <g transform="rotate(0 50 50)">
                                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#191d3a">
                                        <animate attributeName="opacity" values="1;0" keyTimes="0;1"
                                                 dur="0.6711409395973155s"
                                                 begin="-0.6101281269066504s" repeatCount="indefinite"></animate>
                                    </rect>
                                </g>
                                <g transform="rotate(32.72727272727273 50 50)">
                                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#93dbe9">
                                        <animate attributeName="opacity" values="1;0" keyTimes="0;1"
                                                 dur="0.6711409395973155s"
                                                 begin="-0.5491153142159854s" repeatCount="indefinite"></animate>
                                    </rect>
                                </g>
                                <g transform="rotate(65.45454545454545 50 50)">
                                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#689cc5">
                                        <animate attributeName="opacity" values="1;0" keyTimes="0;1"
                                                 dur="0.6711409395973155s"
                                                 begin="-0.4881025015253203s" repeatCount="indefinite"></animate>
                                    </rect>
                                </g>
                                <g transform="rotate(98.18181818181819 50 50)">
                                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#5e6fa3">
                                        <animate attributeName="opacity" values="1;0" keyTimes="0;1"
                                                 dur="0.6711409395973155s"
                                                 begin="-0.42708968883465526s" repeatCount="indefinite"></animate>
                                    </rect>
                                </g>
                                <g transform="rotate(130.9090909090909 50 50)">
                                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#3b4368">
                                        <animate attributeName="opacity" values="1;0" keyTimes="0;1"
                                                 dur="0.6711409395973155s"
                                                 begin="-0.3660768761439902s" repeatCount="indefinite"></animate>
                                    </rect>
                                </g>
                                <g transform="rotate(163.63636363636363 50 50)">
                                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#d9dbee">
                                        <animate attributeName="opacity" values="1;0" keyTimes="0;1"
                                                 dur="0.6711409395973155s"
                                                 begin="-0.3050640634533252s" repeatCount="indefinite"></animate>
                                    </rect>
                                </g>
                                <g transform="rotate(196.36363636363637 50 50)">
                                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#b3b7e2">
                                        <animate attributeName="opacity" values="1;0" keyTimes="0;1"
                                                 dur="0.6711409395973155s"
                                                 begin="-0.24405125076266015s" repeatCount="indefinite"></animate>
                                    </rect>
                                </g>
                                <g transform="rotate(229.0909090909091 50 50)">
                                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#191d3a">
                                        <animate attributeName="opacity" values="1;0" keyTimes="0;1"
                                                 dur="0.6711409395973155s"
                                                 begin="-0.1830384380719951s" repeatCount="indefinite"></animate>
                                    </rect>
                                </g>
                                <g transform="rotate(261.8181818181818 50 50)">
                                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#93dbe9">
                                        <animate attributeName="opacity" values="1;0" keyTimes="0;1"
                                                 dur="0.6711409395973155s"
                                                 begin="-0.12202562538133008s" repeatCount="indefinite"></animate>
                                    </rect>
                                </g>
                                <g transform="rotate(294.54545454545456 50 50)">
                                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#689cc5">
                                        <animate attributeName="opacity" values="1;0" keyTimes="0;1"
                                                 dur="0.6711409395973155s"
                                                 begin="-0.06101281269066504s" repeatCount="indefinite"></animate>
                                    </rect>
                                </g>
                                <g transform="rotate(327.27272727272725 50 50)">
                                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#5e6fa3">
                                        <animate attributeName="opacity" values="1;0" keyTimes="0;1"
                                                 dur="0.6711409395973155s"
                                                 begin="0s" repeatCount="indefinite"></animate>
                                    </rect>
                                </g>
                                <!-- [ldio] generated by https://loading.io/ -->
                            </svg>

                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</section>


<!-- FOOTER -->

<section class="mt-auto z-50" id="footer">
    <footer class="bg-white">
        <div class="px-4 py-12 mx-auto max-w-7xl sm:px-6 md:flex md:items-center md:justify-between lg:px-8">
            <div class="flex justify-center space-x-6 md:order-2">
                <a href="#" class="text-gray-400 hover:text-gray-500">
                    <span class="sr-only">GitHub</span>
                    <svg class="w-6 h-6" fill="currentColor" viewBox="0 0 24 24" aria-hidden="true">
                        <path fill-rule="evenodd"
                              d="M12 2C6.477 2 2 6.484 2 12.017c0 4.425 2.865 8.18 6.839 9.504.5.092.682-.217.682-.483 0-.237-.008-.868-.013-1.703-2.782.605-3.369-1.343-3.369-1.343-.454-1.158-1.11-1.466-1.11-1.466-.908-.62.069-.608.069-.608 1.003.07 1.531 1.032 1.531 1.032.892 1.53 2.341 1.088 2.91.832.092-.647.35-1.088.636-1.338-2.22-.253-4.555-1.113-4.555-4.951 0-1.093.39-1.988 1.029-2.688-.103-.253-.446-1.272.098-2.65 0 0 .84-.27 2.75 1.026A9.564 9.564 0 0112 6.844c.85.004 1.705.115 2.504.337 1.909-1.296 2.747-1.027 2.747-1.027.546 1.379.202 2.398.1 2.651.64.7 1.028 1.595 1.028 2.688 0 3.848-2.339 4.695-4.566 4.943.359.309.678.92.678 1.855 0 1.338-.012 2.419-.012 2.747 0 .268.18.58.688.482A10.019 10.019 0 0022 12.017C22 6.484 17.522 2 12 2z"
                              clip-rule="evenodd"></path>
                    </svg>
                </a>
            </div>
            <div class="mt-8 md:mt-0 md:order-1">
                <p class="text-base text-center text-gray-400">&copy; 2022 ITI, JETS. All rights reserved.</p>
            </div>
        </div>
    </footer>
</section>
<script src="<c:url value="/js/components/navbar.js"/>"></script>
<script src="<c:url value="/js/checkout/checkout.js"/>"></script>
</body>

</html>