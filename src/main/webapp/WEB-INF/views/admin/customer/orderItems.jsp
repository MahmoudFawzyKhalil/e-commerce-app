<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="order" type="gov.iti.jets.domain.models.Order"--%>
<%--@elvariable id="customer" type="gov.iti.jets.domain.models.User"--%>
<%--@elvariable id="item" type="gov.iti.jets.domain.models.OrderLineItem"--%>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <script src="<c:url value="/js/components/cookie.js"/>"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/tailwind-out.css"/>">
    <title>${customer.fullName}'s Orders | Admin Dashboard</title>
</head>

<body class="flex flex-col h-screen">

<%@include file="/WEB-INF/views/navbars/adminNav.jspf" %>

<section id="profileSection">
    <div
            class="grid max-w-3xl grid-cols-1 gap-6 mx-auto mt-8 sm:px-6 lg:max-w-7xl lg:grid-flow-col-dense lg:grid-cols-2">
        <div class="space-y-6 lg:col-start-1 lg:col-span-2">
            <!-- Description list-->
            <section aria-labelledby="applicant-information-title">
                <div class="bg-white shadow sm:rounded-lg">
                    <div class="px-4 py-5 sm:px-6">
                        <h2 id="applicant-information-title" class="text-lg font-medium leading-6 text-gray-900">
                            Order Info</h2>
                    </div>
                    <div class="px-4 py-5 border-t border-gray-200 sm:px-6">
                        <dl class="grid grid-cols-1 gap-x-4 gap-y-8 sm:grid-cols-2">
                            <div class="sm:col-span-1">
                                <dt class="text-sm font-medium text-gray-500">ID</dt>
                                <dd class="mt-1 text-sm text-gray-900">${order.id}</dd>
                            </div>
                            <div class="sm:col-span-1">
                                <dt class="text-sm font-medium text-gray-500">Owner Name</dt>
                                <dd class="mt-1 text-sm text-gray-900">${customer.fullName}</dd>
                            </div>
                            <div class="sm:col-span-1">
                                <dt class="text-sm font-medium text-gray-500">Total cost</dt>
                                <dd class="mt-1 text-sm text-gray-900">EGP ${order.totalFormatted}.00</dd>
                            </div>

                            <div class="sm:col-span-1">
                                <dt class="text-sm font-medium text-gray-500">Time Stamp</dt>
                                <dd class="mt-1 text-sm text-gray-900">${order.timestamp}</dd>
                            </div>
                        </dl>
                    </div>
                </div>
            </section>

            <!-- Comments-->
            <section aria-labelledby="notes-title">
                <div class="bg-white shadow sm:rounded-lg sm:overflow-hidden">
                    <div class="divide-y divide-gray-200">
                        <div class="px-4 py-5 sm:px-6">
                            <h2 id="notes-title" class="text-lg font-medium text-gray-900">Order Item</h2>
                        </div>
                        <section id="orderTable" class="mt-5">
                            <div class="px-4 sm:px-6 lg:px-8">
                                <div class="sm:flex sm:items-center">

                                </div>
                                <div class="flex flex-col mt-8 mb-8">
                                    <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                                        <div class="inline-block min-w-full py-2 align-middle md:px-6 lg:px-8">
                                            <div class="overflow-hidden shadow ring-1 ring-black ring-opacity-5 md:rounded-lg">
                                                <table class="min-w-full divide-y divide-gray-300">
                                                    <thead class="bg-gray-50">
                                                    <tr>
                                                        <th scope="col"
                                                            class="whitespace-nowrap py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-6">
                                                            ID
                                                        </th>
                                                        <th scope="col"
                                                            class="whitespace-nowrap px-2 py-3.5 text-left text-sm font-semibold text-gray-900">
                                                            Product Name
                                                        </th>
                                                        <th scope="col"
                                                            class="whitespace-nowrap px-2 py-3.5 text-left text-sm font-semibold text-gray-900">
                                                            Unit Cost
                                                        </th>
                                                        <th scope="col"
                                                            class="whitespace-nowrap px-2 py-3.5 text-left text-sm font-semibold text-gray-900">
                                                            Quantity
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody class="bg-white divide-y divide-gray-200">
                                                    <c:forEach items="${itemList}" var="item">
                                                        <tr>
                                                            <td class="py-2 pl-4 pr-3 text-sm text-gray-500 whitespace-nowrap sm:pl-6">${item.id}</td>
                                                            <td class="px-2 py-2 text-sm text-gray-900 ">${item.product.name}</td>
                                                            <td class="px-2 py-2 text-sm text-gray-500 ">
                                                                EGP ${item.unitCostFormatted}.00
                                                            </td>
                                                            <td class="px-2 py-2 text-sm text-gray-500 ">${item.quantity}</td>
                                                        </tr>
                                                    </c:forEach>
                                                    <c:if test="${itemList ==null}">
                                                        <h4>NO Orders</h4>
                                                    </c:if>
                                                    <!-- More transactions... -->
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </section>
                    </div>
                    <div class="px-4 py-2 bg-gray-50 sm:px-6">

                    </div>
                </div>
            </section>
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

<script src="<c:url value="/js/components/navbar.js"/>"></script>
<script src="<c:url value="/js/admin/admin.js"/>"></script>
</body>

</html>
