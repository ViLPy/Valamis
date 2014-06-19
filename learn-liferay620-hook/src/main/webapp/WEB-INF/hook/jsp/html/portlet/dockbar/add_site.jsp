
<%@ include file="/html/portlet/sites_admin/init.jsp" %>

<c:if test="<%= PortalPermissionUtil.contains(permissionChecker, ActionKeys.ADD_COMMUNITY) %>">

    <%
        List<LayoutSetPrototype> layoutSetPrototypes = LayoutSetPrototypeServiceUtil.search(company.getCompanyId(), Boolean.TRUE, null);

        String sitesListView = ParamUtil.get(request, "sitesListView", SiteConstants.LIST_VIEW_TREE);
    %>

    <portlet:renderURL var="viewSitesURL">
    </portlet:renderURL>

    <liferay-portlet:renderURL portletName="134" varImpl="addSiteURL" windowState="pop_up">
        <portlet:param name="struts_action" value="/sites_admin/edit_site" />
        <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
        <portlet:param name="redirect" value="<%= viewSitesURL %>" />
    </liferay-portlet:renderURL>

    <%
        boolean hasAddLayoutSetPrototypePermission = PortalPermissionUtil.contains(permissionChecker, ActionKeys.ADD_LAYOUT_SET_PROTOTYPE);
    %>

    <c:choose>
        <c:when test="<%= layoutSetPrototypes.isEmpty() && !hasAddLayoutSetPrototypePermission %>">
            <aui:nav-item href="<%= addSiteURL %>" iconCssClass="icon-plus" label="add" />
        </c:when>
        <c:otherwise>

            <%
                addSiteURL.setParameter("showPrototypes", "0");
            %>

            <!--a href="#" onClick="openAddSitePopup('<%= addSiteURL.toString() %>')">blank-site</a> <br /-->

            <%
                addSiteURL.setParameter("showPrototypes", "1");

                for (LayoutSetPrototype layoutSetPrototype : layoutSetPrototypes) {
                    addSiteURL.setParameter("layoutSetPrototypeId", String.valueOf(layoutSetPrototype.getLayoutSetPrototypeId()));
            %>
            <a href="#" onClick="openAddSitePopup('<%= addSiteURL.toString() %>')"><%= HtmlUtil.escape(layoutSetPrototype.getName(locale)) %></a> <br />
            <%
                }
            %>
        </c:otherwise>
    </c:choose>
</c:if>
<script>
    function openAddSitePopup(url) {
        Liferay.Util.openWindow({
            dialog:  {align:  Liferay.Util.Window.ALIGN_CENTER,  width:  1024},
            id: "addSitePopup",
            uri:  url
        });
    }
</script>