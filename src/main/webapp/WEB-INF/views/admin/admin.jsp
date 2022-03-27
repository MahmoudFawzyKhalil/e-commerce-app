<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="<c:url value="/css/tailwind-out.css"/>">
  <title>Admin Dashboard</title>
</head>

<body class="flex flex-col h-screen">


  <!--  Admin NAVBAR -->
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
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"></path>
              </svg>
              <!-- Icon when menu is open. -->
              <!-- Menu open: "block", Menu closed: "hidden" -->
              <svg class="hidden w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path>
              </svg>
            </button>
          </div>
          <div class="flex items-center justify-center flex-1 sm:items-stretch sm:justify-start">
            <div class="flex-shrink-0">
              <img class="block w-auto h-8 lg:hidden" src="<c:url value="/img/common/logo.png"/>" alt="Workflow logo">
              <img class="hidden w-auto h-8 lg:block" src="<c:url value="/img/common/logo.png"/>" alt="Workflow logo">
            </div>
            <div class="hidden sm:block sm:ml-6">
              <div class="flex">
                <a href="<c:url value="/WEB-INF/views/admin/admin.jsp"/>"
                  class="px-3 py-2 ml-4 text-sm font-medium leading-5 text-gray-300 transition duration-150 ease-in-out rounded-md hover:text-white hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">Dashboard</a>
              </div>
            </div>
          </div>
          <div class="absolute inset-y-0 right-0 flex items-center pr-2 sm:static sm:inset-auto sm:ml-6 sm:pr-0">

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
          <a href="<c:url value="/WEB-INF/views/admin/admin.jsp"/>"
            class="block px-3 py-2 text-base font-medium text-white transition duration-150 ease-in-out rounded-md hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">Dashboard</a>
        </div>
      </div>
    </nav>
  </section>

  <!--   Cards Section  -->
  <section id="Cards" class="flex justify-center">
    <div class="max-w-2xl mx-auto py-16 px-4 sm:py-24 sm:px-6 lg:max-w-7xl lg:px-8">
      <h2 class="text-2xl font-extrabold tracking-tight text-gray-900 mb-10">Managing The Website</h2>
      <div class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-1 lg:grid-cols-3 xl:gap-x-8">
        <div class="group relative">
          <div class="w-full min-h-80 bg-gray-200 aspect-w-1 aspect-h-1 rounded-md overflow-hidden group-hover:opacity-75 lg:h-80 lg:aspect-none">
            <img src="<c:url value="/img/admin/customer.png"/>" alt="Front of men&#039;s Basic Tee in black." class="w-full h-full object-center object-cover lg:w-full lg:h-full">
          </div>
          <div class="mt-4 flex justify-center">
            <div>
              <h3 class="text-xl text-gray-700 hover:text-black">
                <a href="customer/listOfCustomer.jsp">
                  <span aria-hidden="true" class="absolute inset-0"></span>
                  Customers
                </a>
              </h3>
            </div>
          </div>
        </div>
        <div class="group relative ">
          <div class="w-full min-h-80  bg-gray-200 aspect-w-1 aspect-h-1 rounded-md overflow-hidden group-hover:opacity-75 lg:h-80 lg:aspect-none">
            <img src="<c:url value="/img/admin/product.png"/>" alt="Front of men&#039;s Basic Tee in black." class="w-full h-full object-center object-cover lg:w-full lg:h-full">
          </div>
          <div class="mt-4 flex justify-center">
            <div >
              <h3 class=" text-gray-700  text-xl hover:text-black ">
                <a href="product/listOfProduct.jsp" >
                  <span aria-hidden="true" class="absolute inset-0 "></span>
                  Manage Products
                </a>
              </h3>
            </div>
          </div>
        </div>
        <div class="group relative items-center">
          <div class="w-full min-h-80 bg-gray-200 aspect-w-1 aspect-h-1 rounded-md overflow-hidden group-hover:opacity-75 lg:h-80 lg:aspect-none">
            <img src="<c:url value="/img/admin/AddProduct.png"/>" alt="Front of men&#039;s Basic Tee in black." class="w-full h-full object-center object-cover lg:w-full lg:h-full">
          </div>
          <div class="mt-4 flex justify-center">
            <div>
              <h3 class="text-xl  text-gray-700 hover:text-black">
                <a href="product/addProduct.jsp">
                  <span aria-hidden="true" class="absolute inset-0"></span>
                  Add Product
                </a>
              </h3>
            </div>
          </div>
        </div>
  
        <!-- More products... -->
      </div>
    </div>
 
  </section>

<!-- Footer -->
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