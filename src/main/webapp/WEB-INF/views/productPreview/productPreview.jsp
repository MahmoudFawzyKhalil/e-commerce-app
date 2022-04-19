<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="user" type="gov.iti.jets.domain.models.User"--%>
<%--@elvariable id="product" type="gov.iti.jets.domain.models.Product"--%>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <script src="<c:url value="/js/components/cookie.js"/>"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/tailwind-out.css"/>">
    <title>${product.name} | ChocoTown</title>
</head>

<body class="flex flex-col h-screen">
<%@include file="/WEB-INF/views/navbars/customerNav.jspf" %>

<!-- Product preview -->
<section id="productPreview" class="m-10 rounded-lg shadow-md">

    <div class="bg-white">
        <div
                class="max-w-2xl px-4 py-16 mx-auto sm:py-24 sm:px-6 lg:max-w-7xl lg:px-8 lg:grid lg:grid-cols-2 lg:gap-x-8">
            <!-- Product details -->
            <div class="lg:max-w-lg lg:self-end">

                <div class="mt-4">
                    <h1 class="text-3xl font-extrabold tracking-tight text-gray-900 sm:text-4xl">${product.name}
                    </h1>
                </div>

                <section aria-labelledby="information-heading" class="mt-4">
                    <div class="flex items-center">
                        <p class="text-lg text-gray-900 sm:text-xl">EGP ${product.priceFormatted}</p>
                    </div>

                    <div class="mt-4 space-y-6">
                        <p class="text-base text-gray-500">${product.description}</p>
                    </div>
                </section>
            </div>

            <!-- Product image -->
            <div class="mt-10 lg:mt-0 lg:col-start-2 lg:row-span-2 lg:self-center ">
                <div class="overflow-hidden rounded-lg aspect-w-1 aspect-h-1">
                    <img src="${product.imageName}"
                         alt="Model wearing light green backpack with black canvas straps and front zipper pouch."
                         class="object-scale-down object-center w-full h-full">
                </div>
            </div>

            <!-- Product form -->
            <div class="mt-10 lg:max-w-lg lg:col-start-1 lg:row-start-2 lg:self-start">
                <section aria-labelledby="options-heading">
                    <h2 id="options-heading" class="sr-only">Product options</h2>

                    <form>

                        <div class="mt-10">
                            <button data-productId="${product.id}" id="addToCartButton" type="submit"
                                    class="flex items-center justify-center w-full px-8 py-3 text-base font-medium text-white bg-indigo-600 border border-transparent rounded-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-50 focus:ring-indigo-500">
                                Add
                                to cart
                            </button>
                        </div>

                        <div id="addedToCartIcon" class="hidden mt-6">
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


                    </form>
                </section>
            </div>
        </div>
    </div>


</section>


<!-- FOOTER -->

<section class="mt-auto" id="footer">
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
<script src="<c:url value="/js/product/product.js"/>"></script>
</body>
</html>