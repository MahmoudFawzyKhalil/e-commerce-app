<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="helper" type="gov.iti.jets.presentation.viewhelpers.ProductAddNewViewHelper"--%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/tailwind-out.css"/>">
    <title>Admin Dashboard</title>
</head>

<body class="flex flex-col h-screen">

    <section class="sticky top-0 z-50" id="adminNav">
        <nav class="bg-gray-800">
            <div class="px-2 mx-auto max-w-7xl sm:px-6 lg:px-8">
                <div class="relative flex items-center justify-between h-16">
                    <div class="absolute inset-y-0 left-0 flex items-center sm:hidden">
                        <!-- Mobile menu button-->
                        <button id="mobileMenuToggleButton"
                            class="inline-flex items-center justify-center p-2 text-gray-400 transition duration-150 ease-in-out rounded-md hover:text-white hover:bg-gray-700 focus:outline-none focus:bg-gray-700 focus:text-white"
                            aria-label="Main menu" aria-expanded="false">
                            <!-- Icon when menu is closed. -->
                            <!-- Menu open: "hidden", Menu closed: "block" -->
                            <svg class="block w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                    d="M4 6h16M4 12h16M4 18h16"></path>
                            </svg>
                            <!-- Icon when menu is open. -->
                            <!-- Menu open: "block", Menu closed: "hidden" -->
                            <svg class="hidden w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                    d="M6 18L18 6M6 6l12 12"></path>
                            </svg>
                        </button>
                    </div>
                    <div class="flex items-center justify-center flex-1 sm:items-stretch sm:justify-start">
                        <div class="flex-shrink-0">
                            <img class="block w-auto h-8 lg:hidden" src="<c:url value="/img/common/logo.png" />"
                            alt="Workflow logo">
                            <img class="hidden w-auto h-8 lg:block" src="<c:url value="/img/common/logo.png" />"
                            alt="Workflow logo">
                        </div>
                        <div class="hidden sm:block sm:ml-6">
                            <div class="flex">
                                <a href="/app/admin"
                                    class="px-3 py-2 ml-4 text-sm font-medium leading-5 text-gray-300 transition duration-150 ease-in-out rounded-md hover:text-white hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">Dashboard</a>
                            </div>
                        </div>
                    </div>
                    <div
                        class="absolute inset-y-0 right-0 flex items-center pr-2 sm:static sm:inset-auto sm:ml-6 sm:pr-0">

                        <!-- PROFILE DROPDOWN -->
                        <div class="relative ml-3">
                            <div>
                                <button id="toggleProfileButton"
                                    class="flex transition duration-150 ease-in-out border-2 border-transparent rounded-full focus:outline-none"
                                    aria-label="User menu" aria-haspopup="true">
                                    <!-- <img class="w-8 h-8 rounded-full" src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80" alt=""> -->
                                    <span
                                        class="block px-3 py-2 text-base font-medium text-white transition duration-150 ease-in-out rounded-md hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">John
                                        Doe</span>
                                </button>
                            </div>

                            <div id="profileDropDown"
                                class="absolute right-0 z-40 hidden w-48 mt-2 origin-top-right rounded-md shadow-lg">
                                <div class="py-1 bg-white rounded-md shadow-xs" role="menu" aria-orientation="vertical"
                                    aria-labelledby="user-menu">
                                    <a href="#"
                                        class="block px-4 py-2 text-sm leading-5 text-gray-700 transition duration-150 ease-in-out hover:bg-gray-100 focus:outline-none focus:bg-gray-100"
                                        role="menuitem">Sign out</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--
                Mobile menu, toggle classes based on menu state.

                Menu open: "block", Menu closed: "hidden"
              -->
            <div id="mobileMenu" class="hidden sm:hidden">
                <div class="px-2 pt-2 pb-3">
                    <a href="/app/admin"
                        class="block px-3 py-2 text-base font-medium text-white transition duration-150 ease-in-out rounded-md hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">Dashboard</a>
                </div>
            </div>
        </nav>
    </section>

    <section id="product">
        <!--
  This example requires Tailwind CSS v2.0+ 
  
  This example requires some changes to your config:
  
  ```
  // tailwind.config.js
  module.exports = {
    // ...
    plugins: [
      // ...
      require('@tailwindcss/forms'),
    ],
  }
  ```
-->
        <div class="space-y-6">
            <div class="px-4 py-5 bg-white shadow sm:rounded-lg sm:p-6">
                <div class="md:grid md:grid-cols-3 md:gap-6">
                    <div class="md:col-span-1">
                        <h3 class="text-lg font-medium leading-6 text-gray-900">Product Information</h3>
                    </div>
                    <div class="mt-5 md:mt-0 md:col-span-2">
                        <form action="/app/admin/products/add" enctype="multipart/form-data" method="POST" >
                            <div class="grid grid-cols-6 gap-6">

                                <div class="col-span-6 bg-white sm:col-span-4">
                                    <label class="text-sm font-medium text-gray-700"> Photo </label>
                                    <div class="max-w-xs px-4 mx-auto sm:py-3 sm:px-3 lg:max-w-7xl ">
                                        <div
                                            class="max-w-xs overflow-hidden bg-gray-200 rounded-md min-h-80 aspect-w-1 aspect-h-1 group-hover:opacity-75 lg:h-80 lg:aspect-none">
                                            <img src="<c:url value="/img/admin/defaultProduct.jpeg"/>" alt="customer"
                                                class="object-cover object-center w-full h-full lg:w-full lg:h-full">
                                        </div>
                                        <div class="grid grid-cols-1 gap-x-6 sm:grid-cols-2 lg:grid-cols-2 xl:gap-x-8">


                                            <div class="flex justify-between mt-4">
                                                <div>
<%--                                                    <button type="button"--%>
<%--                                                        class="px-3 py-2 text-sm font-medium leading-4 text-gray-700 bg-white border border-gray-300 rounded-md shadow-sm hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Add--%>
<%--                                                        Photo</button>--%>

                                                    <input type="file" name="productPhoto" id="productPhoto">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-span-6 sm:col-span-4">
                                    <label for="name" class="text-sm font-medium text-gray-700">
                                        Name</label>
                                    <input type="text" name="name" id="name" autocomplete="given-name" required
                                        class="block w-full mt-1 border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                </div>


                                <div class="col-span-6 sm:col-span-4">
                                    <label for="description"
                                        class="block text-sm font-medium text-gray-700">Description</label>
                                    <div class="mt-1">
                                        <textarea id="description" name="description" rows="3"
                                            class="block w-full border border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"></textarea>
                                    </div>
                                </div>



                                <div class="col-span-6 sm:col-span-4">
                                    <label for="quantity" class="block text-sm font-medium text-gray-700">Quantity</label>
<%--                                    <input type="number" min="0" name="quantity" id="quantity" required--%>
                                    <input type="text" name="quantity" id="quantity"
                                        class="block w-full mt-1 border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                </div>

                                <div class="col-span-6 sm:col-span-4">
                                    <label for="price" class="block text-sm font-medium text-gray-700">Price</label>
<%--                                    <input  name="price" id="price" type="number" min="0" required--%>
                                    <input type="text" name="price" id="price"
                                        class="block w-full mt-1 border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                </div>

                                <div class="col-span-6 sm:col-span-4">
                                    <label for="category"
                                        class="block text-sm font-medium text-gray-700">Category</label>
                                    <select id="category" name="category"
                                        class="block w-full px-3 py-2 mt-1 bg-white border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                        <option selected>Category</option>
                                        <option>CHOCOLATE</option>
                                        <option>DRINKS</option>
                                    </select>
                                </div>

                            </div>
                            <div class="flex justify-end p-1">
                                <button type="button"
                                        class="px-4 py-2 text-sm font-medium text-gray-700 bg-white border border-gray-300 rounded-md shadow-sm hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Cancel</button>
                                <button type="submit"
                                        class="inline-flex justify-center px-4 py-2 ml-3 text-sm font-medium text-white bg-indigo-600 border border-transparent rounded-md shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Add</button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>

        </div>

    </section>

    <section id="feedback" class="mt-3">
        <c:if test = "${helper.successfullyAddedProduct}">


            <div class="rounded-md bg-green-50 p-4">
                <div class="flex">
                    <div class="flex-shrink-0">
                        <!-- Heroicon name: solid/check-circle -->
                        <svg class="h-5 w-5 text-green-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                            <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd"></path>
                        </svg>
                    </div>
                    <div class="ml-3">
                        <p class="text-sm font-medium text-green-800">Successfully Added</p>
                    </div>
                    <div class="ml-auto pl-3">
                        <div class="-mx-1.5 -my-1.5">
                            <button type="button" class="inline-flex bg-green-50 rounded-md p-1.5 text-green-500 hover:bg-green-100 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-green-50 focus:ring-green-600">
                                <span class="sr-only">Dismiss</span>
                                <!-- Heroicon name: solid/x -->
                                <svg class="h-5 w-5" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                    <path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path>
                                </svg>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test = "${helper.failedToAddProduct}">
            <div class="rounded-md bg-red-50 p-4 mt-3">
                <div class="flex">
                    <div class="flex-shrink-0">
                        <!-- Heroicon name: solid/x-circle -->
                        <svg class="h-5 w-5 text-red-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                            <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z" clip-rule="evenodd"></path>
                        </svg>
                    </div>
                    <div class="ml-3">
                        <h3 class="text-sm font-medium text-red-800">Adding Failed</h3>
                    </div>
                    <div class="ml-auto pl-3">
                        <div class="-mx-1.5 -my-1.5">
                            <button type="button" class="inline-flex bg-red-50 rounded-md p-1.5 text-red-500 hover:bg-red-100 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-red-50 focus:ring-red-600">
                                <span class="sr-only">Dismiss</span>
                                <!-- Heroicon name: solid/x -->
                                <svg class="h-5 w-5" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                    <path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path>
                                </svg>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </section>



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

</body>

</html>