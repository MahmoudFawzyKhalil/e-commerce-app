<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../../css/tailwind-out.css">
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
                            <img class="block w-auto h-8 lg:hidden" src="../../../../img/common/logo.png"
                                alt="Workflow logo">
                            <img class="hidden w-auto h-8 lg:block" src="../../../../img/common/logo.png"
                                alt="Workflow logo">
                        </div>
                        <div class="hidden sm:block sm:ml-6">
                            <div class="flex">
                                <a href="../admin.jsp"
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
                    <a href="../admin.jsp"
                        class="block px-3 py-2 text-base font-medium text-white transition duration-150 ease-in-out rounded-md hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">Dashboard</a>
                </div>
            </div>
        </nav>
    </section>

    <section id="searchBar" class="mt-5 md:self-center md:w-9/12">
        <div class="flex mx-5">
            <div class="relative flex-grow">

                <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
                    <!-- Heroicon name: solid/search -->
                    <svg class="w-5 h-5 text-gray-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
                        fill="currentColor" aria-hidden="true">
                        <path fill-rule="evenodd"
                            d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                              clip-rule="evenodd" ></path>
                    </svg>
                </div>


                <input id="search" name="search"
                    class="block w-full py-2 pl-10 pr-3 text-sm placeholder-gray-500 bg-white border border-gray-300 rounded-md focus:outline-none focus:text-gray-900 focus:placeholder-gray-400 focus:ring-1 focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                    placeholder="Search" type="search">
            </div>
        </div>
    </section>




    <section id="customerTable" class="mt-5">
        <div class="px-4 sm:px-6 lg:px-8">
            <div class="sm:flex sm:items-center">
                <div class="sm:flex-auto">
                    <h1 class="text-xl font-semibold text-gray-900">Customers</h1>
                </div>
            </div>
            <div class="flex flex-col mt-8">
                <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                    <div class="inline-block min-w-full py-2 align-middle md:px-6 lg:px-8">
                        <div class="overflow-hidden shadow ring-1 ring-black ring-opacity-5 md:rounded-lg">
                            <table class="min-w-full divide-y divide-gray-300">
                                <thead class="bg-gray-50">
                                    <tr>
                                        <th scope="col"
                                            class="whitespace-nowrap py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-6">
                                            ID</th>
                                        <th scope="col"
                                            class="whitespace-nowrap px-2 py-3.5 text-left text-sm font-semibold text-gray-900">
                                            Full Name</th>
                                        <th scope="col"
                                            class="whitespace-nowrap px-2 py-3.5 text-left text-sm font-semibold text-gray-900">
                                            Email</th>
                                        <th scope="col"
                                            class="whitespace-nowrap px-2 py-3.5 text-left text-sm font-semibold text-gray-900">
                                            Phone Number</th>
                                        <th scope="col"
                                            class="whitespace-nowrap px-2 py-3.5 text-left text-sm font-semibold text-gray-900">
                                            Address</th>
                                        <th scope="col"
                                            class="whitespace-nowrap px-2 py-3.5 text-left text-sm font-semibold text-gray-900">
                                            Birthday</th>
                                        <th scope="col"
                                            class="whitespace-nowrap px-2 py-3.5 text-left text-sm font-semibold text-gray-900">
                                            Job</th>
                                        <th scope="col"
                                            class="whitespace-nowrap px-2 py-3.5 text-left text-sm font-semibold text-gray-900">
                                            Credit Limit</th>
                                        <th scope="col" class="relative whitespace-nowrap py-3.5 pl-3 pr-4 sm:pr-6">
                                            <span class="sr-only">Edit</span>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="py-2 pl-4 pr-3 text-sm text-gray-500 whitespace-nowrap sm:pl-6">1
                                        </td>
                                        <td class="px-2 py-2 text-sm font-medium text-gray-900">Marwa Yousef</td>
                                        <td class="px-2 py-2 text-sm text-gray-900 ">marwa@gmail.com</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">01115984684</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">london second floor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">25/7/1997</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">Senor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">100,000</td>
                                        <td
                                            class="relative py-2 pl-3 pr-4 text-sm font-medium text-right whitespace-nowrap sm:pr-6">
                                            <a href="customer.jsp" class="text-indigo-600 hover:text-indigo-900">Orders<span
                                                    class="sr-only">, AAPS0L</span></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="py-2 pl-4 pr-3 text-sm text-gray-500 whitespace-nowrap sm:pl-6">1
                                        </td>
                                        <td class="px-2 py-2 text-sm font-medium text-gray-900">Marwa Yousef</td>
                                        <td class="px-2 py-2 text-sm text-gray-900 ">marwa@gmail.com</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">01115984684</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">london second floor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">25/7/1997</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">Senor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">100,000</td>
                                        <td
                                            class="relative py-2 pl-3 pr-4 text-sm font-medium text-right whitespace-nowrap sm:pr-6">
                                            <a href="customer.jsp" class="text-indigo-600 hover:text-indigo-900">Orders<span
                                                    class="sr-only">, AAPS0L</span></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="py-2 pl-4 pr-3 text-sm text-gray-500 whitespace-nowrap sm:pl-6">1
                                        </td>
                                        <td class="px-2 py-2 text-sm font-medium text-gray-900">Marwa Yousef</td>
                                        <td class="px-2 py-2 text-sm text-gray-900 ">marwa@gmail.com</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">01115984684</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">london second floor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">25/7/1997</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">Senor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">100,000</td>
                                        <td
                                            class="relative py-2 pl-3 pr-4 text-sm font-medium text-right whitespace-nowrap sm:pr-6">
                                            <a href="customer.jsp" class="text-indigo-600 hover:text-indigo-900">Orders<span
                                                    class="sr-only">, AAPS0L</span></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="py-2 pl-4 pr-3 text-sm text-gray-500 whitespace-nowrap sm:pl-6">1
                                        </td>
                                        <td class="px-2 py-2 text-sm font-medium text-gray-900">Marwa Yousef</td>
                                        <td class="px-2 py-2 text-sm text-gray-900 ">marwa@gmail.com</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">01115984684</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">london second floor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">25/7/1997</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">Senor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">100,000</td>
                                        <td
                                            class="relative py-2 pl-3 pr-4 text-sm font-medium text-right whitespace-nowrap sm:pr-6">
                                            <a href="customer.jsp" class="text-indigo-600 hover:text-indigo-900">Orders<span
                                                    class="sr-only">, AAPS0L</span></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="py-2 pl-4 pr-3 text-sm text-gray-500 whitespace-nowrap sm:pl-6">1
                                        </td>
                                        <td class="px-2 py-2 text-sm font-medium text-gray-900">Marwa Yousef</td>
                                        <td class="px-2 py-2 text-sm text-gray-900 ">marwa@gmail.com</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">01115984684</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">london second floor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">25/7/1997</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">Senor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">100,000</td>
                                        <td
                                            class="relative py-2 pl-3 pr-4 text-sm font-medium text-right whitespace-nowrap sm:pr-6">
                                            <a href="customer.jsp" class="text-indigo-600 hover:text-indigo-900">Orders<span
                                                    class="sr-only">, AAPS0L</span></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="py-2 pl-4 pr-3 text-sm text-gray-500 whitespace-nowrap sm:pl-6">1
                                        </td>
                                        <td class="px-2 py-2 text-sm font-medium text-gray-900">Marwa Yousef</td>
                                        <td class="px-2 py-2 text-sm text-gray-900 ">marwa@gmail.com</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">01115984684</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">london second floor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">25/7/1997</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">Senor</td>
                                        <td class="px-2 py-2 text-sm text-gray-500 ">100,000</td>
                                        <td
                                            class="relative py-2 pl-3 pr-4 text-sm font-medium text-right whitespace-nowrap sm:pr-6">
                                            <a href="customer.jsp" class="text-indigo-600 hover:text-indigo-900">Orders<span
                                                    class="sr-only">, AAPS0L</span></a>
                                        </td>
                                    </tr>
                                    <!-- More transactions... -->
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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

    <script src="../../../../js/admin/admin.js"></script>
</body>

</html>