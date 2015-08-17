<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<liferay-util:buffer var="html">
    <liferay-util:include page="/html/portlet/dockbar/view.portal.jsp"/>
</liferay-util:buffer>

<%@ include file="/html/portlet/dockbar/init.jsp" %>

<c:if test="<%= themeDisplay.isShowSiteAdministrationIcon() %>">
    <style>
        .showBanner {
            display: block;
        }
        .hideBanner {
            display: none;
        }
        .adminBanner {
            background-color: #2974A6;
            position: absolute;
            opacity: 0.9;
            z-index: 1000;
            width: 100%;
            height: 50px;
            text-align: center;
            color: white;
            font-weight: bold;
            box-sizing: border-box;
            padding-top: 15px;
        }
        .closeButton {
            background-image: url(/learn-portlet/images/popup-close-white.png);
            background-position: left center;
            width: 50px;
            height: 50px;
            position: absolute;
            right: 0;
            top: 0;
            cursor: pointer;
        }
    </style>
    <div class="adminBanner hideBanner" id="<portlet:namespace />Banner">
        This is Valamis CE version - No support - No warranty - <a style="color: white; text-decoration: underline;" target="_blank" href="http://www.liferay.com/marketplace/-/mp/application/35268197">Update to EE version</a>
        <div class="closeButton" onclick="<portlet:namespace />DoClose()"></div>
    </div>
    <script>
        (function() {
            var breakBannerCookie = document.cookie.match('(^|;) ?' + 'breakBanner' + '=([^;]*)(;|$)');
            if (!breakBannerCookie) {
                var banner = document.getElementById('<portlet:namespace />Banner');
                banner.className = 'adminBanner showBanner';
            }
        })();
        var <portlet:namespace />DoClose = function() {
            var banner = document.getElementById('<portlet:namespace />Banner');
            banner.className = 'adminBanner hideBanner';
            var cookieDate = new Date();
            cookieDate.setMinutes(cookieDate.getMinutes() + 15);
            document.cookie = "breakBanner = true; expires=" + cookieDate.toGMTString();
        };
    </script>
</c:if>

<%= html %>