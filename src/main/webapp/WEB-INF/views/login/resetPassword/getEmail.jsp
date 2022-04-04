<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/tailwind-out.css"/>">
    <title>ChocoTown</title>
</head>

<body class="flex flex-col h-screen">
<section class="sticky top-0 z-50" id="customerNav">
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
                    <a href="<c:url value="/"/>">
                        <img class="block w-auto h-8 lg:hidden" src="<c:url value="/img/common/logo.png"/>"
                             alt="Workflow logo">
                    </a>
                    <a href="<c:url value="/"/>">
                        <img class="hidden w-auto h-8 lg:block" src="<c:url value="/img/common/logo.png"/>"
                             alt="Workflow logo">
                    </a>
                    <div class="hidden sm:block sm:ml-6">
                        <div class="flex">
                            <a href="<c:url value="/register"/>"
                               class="px-3 py-2 ml-4 text-sm font-medium leading-5 text-gray-300 transition duration-150 ease-in-out rounded-md hover:text-white hover:bg-gray-700 ">Register</a>
                        </div>
                    </div>
                    <div class="hidden sm:block sm:ml-6">
                        <div class="flex">
                            <a href="<c:url value="/login"/>"
                               class="px-3 py-2 ml-4 text-sm font-medium leading-5 text-gray-300 transition duration-150 ease-in-out rounded-md hover:text-white hover:bg-gray-700 ">Sign
                                in</a>
                        </div>
                    </div>
                    <div class="hidden sm:block sm:ml-6">
                        <div class="flex">
                            <a href="<c:url value="/cart"/>"
                               class="px-3 py-2 ml-4 text-sm font-medium leading-5 text-gray-300 transition duration-150 ease-in-out rounded-md hover:text-white hover:bg-gray-700 ">
                                <svg xmlns="http://www.w3.org/2000/svg" class="inline-block w-6 h-6" fill="none"
                                     viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round"
                                          d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"></path>
                                </svg>
                                <span>Cart</span>
                            </a>
                        </div>
                    </div>
                </div>
                <div
                        class="absolute inset-y-0 right-0 flex items-center pr-2 sm:static sm:inset-auto sm:ml-6 sm:pr-0">

                    <!-- PROFILE DROPDOWN  - HIDDEN WHEN NOT LOGGED IN!!!!-->
                    <div class="relative hidden ml-3">
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
                <a href="<c:url value="/register"/>"
                   class="block px-3 py-2 text-base font-medium text-white transition duration-150 ease-in-out rounded-md hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">
                    Register
                </a>
            </div>
            <div class="px-2 pt-2 pb-3">
                <a href="<c:url value="/login"/>"
                   class="block px-3 py-2 text-base font-medium text-white transition duration-150 ease-in-out rounded-md hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">
                    Sign in
                </a>
            </div>
            <div class="px-2 pt-2 pb-3">
                <a href="<c:url value="/cart"/>"
                   class="block px-3 py-2 text-base font-medium text-white transition duration-150 ease-in-out rounded-md hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">
                    Cart
                </a>
            </div>
        </div>
    </nav>
</section>


<!-- LOGIN FORM -->

<section id="loginSection">
    <div class="flex items-center justify-center min-h-full px-4 py-12 sm:px-6 lg:px-8">
        <div class="w-full max-w-md space-y-8">
            <div>
                <img class="w-32 mx-auto" src="<c:url value="/img/common/logo.png"/>" alt="Workflow">
                <h2 class="mt-6 text-3xl font-extrabold text-center text-gray-900">Enter your email</h2>
            </div>

            <form id="emailConfirmationForm" class="mt-8 space-y-6" action="#" method="POST">
                <input type="hidden" name="remember" value="true">
                <div class="-space-y-px rounded-md shadow-sm">
                    <div>
                        <label for="confirmationId" class="sr-only">Email address</label>
                        <input id="confirmationId" name="email" type="email" required
                               class="relative block w-full px-3 py-2 text-gray-900 placeholder-gray-500 border border-gray-300 rounded-none appearance-none rounded-t-md focus:outline-none focus:ring-gray-500 focus:border-gray-500 focus:z-10 sm:text-sm"
                               placeholder="Email address">
                    </div>
                </div>

                <div>
                    <button type="submit" id="emailConfirmationButton"
                            class="relative flex justify-center w-full px-4 py-2 text-sm font-medium text-white bg-indigo-600 border border-transparent rounded-md group hover:bg-indigo-700">
                        Send email
                    </button>

                    <%--       Spinner             --%>
                    <div class="relative flex justify-center px-4 py-2">
                        <svg id="emailConfirmationSpinner"
                             class="hidden w-8 "
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
        </div>
    </div>
</section>


<section id="alertSection">
    <c:if test="${!empty param.failed}">
        <div class="rounded-md bg-red-50 p-4">
            <div class="flex">
                <div class="flex-shrink-0">
                    <!-- Heroicon name: solid/x-circle -->
                    <svg class="h-5 w-5 text-red-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
                         fill="currentColor" aria-hidden="true">
                        <path fill-rule="evenodd"
                              d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z"
                              clip-rule="evenodd"></path>
                    </svg>
                </div>
                <div class="ml-3">
                    <h3 class="text-sm font-medium text-red-800">Invalid email or password.</h3>
                </div>
            </div>
        </div>
    </c:if>
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
</body>
<script src="<c:url value="/js/components/navbar.js"/>"></script>
<%--<script src="<c:url value="/js/login/login.js"/>"></script>--%>

</html>