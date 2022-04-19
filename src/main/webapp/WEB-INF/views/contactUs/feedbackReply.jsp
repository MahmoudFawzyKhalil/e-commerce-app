<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="user" type="gov.iti.jets.domain.models.User"--%>
<%--@elvariable id="feedbackMessage" type="gov.iti.jets.domain.models.FeedbackMessage"--%>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <script src="<c:url value="/js/components/cookie.js"/>"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/tailwind-out.css"/>">
    <title>Reply Customers Feedback | Admin Dashboard</title>
</head>

<body class="flex flex-col h-screen">

<%@include file="/WEB-INF/views/navbars/adminNav.jspf" %>

<section>

    <div class="m-10 space-y-6">

        <div class="px-4 py-5 shadow-md bg-gray-50 sm:rounded-lg sm:p-6">
            <div class="md:grid md:grid-cols-3 md:gap-6">
                <div class="md:col-span-1">
                    <h3 class="text-lg font-medium leading-6 text-gray-900">Reply</h3>
                    <p class="mt-1 text-sm text-gray-500">Reply to Customer message! 📝</p>
                </div>
                <div class="mt-5 md:mt-0 md:col-span-2">
                    <form id="feedback" action="<c:url value="/feedback/reply"/>" method="POST">
                        <div class="grid grid-cols-6 gap-6">
                            <%--          Email Address          --%>
                            <div class="col-span-6">
                                <label for="email" class="block text-sm font-medium text-gray-700">Customer Email
                                    address</label>
                                <input value="${email}" type="text" name="email"
                                       id="email"
                                       autocomplete="email"
                                       class="block w-full mt-1 bg-gray-200 cursor-not-allowed border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                       readonly>
                            </div>
                            <%--          Customer Message         --%>
                            <div class="col-span-6">
                                <label for="message" class="block text-sm font-medium text-gray-700">Feedback
                                    Message</label>
                                <input value="${message}" type="text" name="message"
                                       id="message"
                                       disabled
                                       class="block w-full mt-1 bg-gray-200 cursor-not-allowed border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                            </div>
                            <%--           Reply               --%>
                            <div class="col-span-6 row-span-3">
                                <label for="reply" class="block text-sm font-medium text-gray-700">Reply Message</label>
                                <textarea
                                        class="form-control block w-full px-3 py-1.5  text-base font-normal  text-gray-700 bg-white bg-clip-padding  border border-solid border-gray-300   rounded   transition  ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                        name="reply" id="reply"
                                        rows="3"
                                        required
                                        placeholder="Please enter your Message."></textarea>
                            </div>
                        </div>
                        <div class="flex justify-end mt-4">
                            <a href="<c:url value="/"/>"
                               class="px-4 py-2 text-sm font-medium text-gray-700 bg-white border border-gray-300 rounded-md shadow-sm hover:bg-gray-50 cursor-pointer">
                                Cancel
                            </a>

                            <button id="submitButton" type="submit"
                                    class="inline-flex justify-center px-4 py-2 ml-3 text-sm font-medium text-white bg-indigo-600 border border-transparent rounded-md shadow-sm hover:bg-indigo-700 ">
                                Send
                            </button>
                            <!-- SPINNER -->
                            <svg id="spinner" class="hidden w-24 inline-flex justify-center px-4 py-2 ml-3 "
                                 xmlns="http://www.w3.org/2000/svg"
                                 style="shape-rendering: auto;" viewBox="0 0 100 100"
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
                    </form>
                </div>
            </div>
        </div>


        <%--        <div class="flex justify-end">--%>
        <%--            <a href="<c:url value="/"/>"--%>
        <%--               class="px-4 py-2 text-sm font-medium text-gray-700 bg-white border border-gray-300 rounded-md shadow-sm hover:bg-gray-50 cursor-pointer">--%>
        <%--                Cancel--%>
        <%--            </a>--%>

        <%--            <button id="submitButton" type="submit"--%>
        <%--                    class="inline-flex justify-center px-4 py-2 ml-3 text-sm font-medium text-white bg-indigo-600 border border-transparent rounded-md shadow-sm hover:bg-indigo-700 ">--%>
        <%--                Send--%>
        <%--            </button>--%>
        <%--            <!-- SPINNER -->--%>
        <%--            <svg id="spinner" class="hidden w-24 inline-flex justify-center px-4 py-2 ml-3 "--%>
        <%--                 xmlns="http://www.w3.org/2000/svg"--%>
        <%--                 style="shape-rendering: auto;" viewBox="0 0 100 100"--%>
        <%--                 preserveAspectRatio="xMidYMid">--%>
        <%--                <g transform="rotate(0 50 50)">--%>
        <%--                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#191d3a">--%>
        <%--                        <animate attributeName="opacity" values="1;0" keyTimes="0;1" dur="0.6711409395973155s"--%>
        <%--                                 begin="-0.6101281269066504s" repeatCount="indefinite"></animate>--%>
        <%--                    </rect>--%>
        <%--                </g>--%>
        <%--                <g transform="rotate(32.72727272727273 50 50)">--%>
        <%--                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#93dbe9">--%>
        <%--                        <animate attributeName="opacity" values="1;0" keyTimes="0;1" dur="0.6711409395973155s"--%>
        <%--                                 begin="-0.5491153142159854s" repeatCount="indefinite"></animate>--%>
        <%--                    </rect>--%>
        <%--                </g>--%>
        <%--                <g transform="rotate(65.45454545454545 50 50)">--%>
        <%--                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#689cc5">--%>
        <%--                        <animate attributeName="opacity" values="1;0" keyTimes="0;1" dur="0.6711409395973155s"--%>
        <%--                                 begin="-0.4881025015253203s" repeatCount="indefinite"></animate>--%>
        <%--                    </rect>--%>
        <%--                </g>--%>
        <%--                <g transform="rotate(98.18181818181819 50 50)">--%>
        <%--                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#5e6fa3">--%>
        <%--                        <animate attributeName="opacity" values="1;0" keyTimes="0;1" dur="0.6711409395973155s"--%>
        <%--                                 begin="-0.42708968883465526s" repeatCount="indefinite"></animate>--%>
        <%--                    </rect>--%>
        <%--                </g>--%>
        <%--                <g transform="rotate(130.9090909090909 50 50)">--%>
        <%--                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#3b4368">--%>
        <%--                        <animate attributeName="opacity" values="1;0" keyTimes="0;1" dur="0.6711409395973155s"--%>
        <%--                                 begin="-0.3660768761439902s" repeatCount="indefinite"></animate>--%>
        <%--                    </rect>--%>
        <%--                </g>--%>
        <%--                <g transform="rotate(163.63636363636363 50 50)">--%>
        <%--                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#d9dbee">--%>
        <%--                        <animate attributeName="opacity" values="1;0" keyTimes="0;1" dur="0.6711409395973155s"--%>
        <%--                                 begin="-0.3050640634533252s" repeatCount="indefinite"></animate>--%>
        <%--                    </rect>--%>
        <%--                </g>--%>
        <%--                <g transform="rotate(196.36363636363637 50 50)">--%>
        <%--                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#b3b7e2">--%>
        <%--                        <animate attributeName="opacity" values="1;0" keyTimes="0;1" dur="0.6711409395973155s"--%>
        <%--                                 begin="-0.24405125076266015s" repeatCount="indefinite"></animate>--%>
        <%--                    </rect>--%>
        <%--                </g>--%>
        <%--                <g transform="rotate(229.0909090909091 50 50)">--%>
        <%--                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#191d3a">--%>
        <%--                        <animate attributeName="opacity" values="1;0" keyTimes="0;1" dur="0.6711409395973155s"--%>
        <%--                                 begin="-0.1830384380719951s" repeatCount="indefinite"></animate>--%>
        <%--                    </rect>--%>
        <%--                </g>--%>
        <%--                <g transform="rotate(261.8181818181818 50 50)">--%>
        <%--                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#93dbe9">--%>
        <%--                        <animate attributeName="opacity" values="1;0" keyTimes="0;1" dur="0.6711409395973155s"--%>
        <%--                                 begin="-0.12202562538133008s" repeatCount="indefinite"></animate>--%>
        <%--                    </rect>--%>
        <%--                </g>--%>
        <%--                <g transform="rotate(294.54545454545456 50 50)">--%>
        <%--                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#689cc5">--%>
        <%--                        <animate attributeName="opacity" values="1;0" keyTimes="0;1" dur="0.6711409395973155s"--%>
        <%--                                 begin="-0.06101281269066504s" repeatCount="indefinite"></animate>--%>
        <%--                    </rect>--%>
        <%--                </g>--%>
        <%--                <g transform="rotate(327.27272727272725 50 50)">--%>
        <%--                    <rect x="43" y="21" rx="5.44" ry="5.44" width="14" height="16" fill="#5e6fa3">--%>
        <%--                        <animate attributeName="opacity" values="1;0" keyTimes="0;1" dur="0.6711409395973155s"--%>
        <%--                                 begin="0s" repeatCount="indefinite"></animate>--%>
        <%--                    </rect>--%>
        <%--                </g>--%>
        <%--                <!-- [ldio] generated by https://loading.io/ -->--%>
        <%--            </svg>--%>

        <%--        </div>--%>

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


</body>

</html>