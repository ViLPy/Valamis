<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
/**
* Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>

<%@ include file="/html/portlet/dockbar/init.jsp" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>

<c:choose>
    <c:when test="<%= themeDisplay.isSignedIn() %>">
        <c:if test="<%= layout != null %>">

            <%
                Group group = layout.getGroup();

                boolean hasLayoutAddPermission = false;

                if (layout.getParentLayoutId() == LayoutConstants.DEFAULT_PARENT_LAYOUT_ID) {
                    hasLayoutAddPermission = GroupPermissionUtil.contains(permissionChecker, group.getGroupId(), ActionKeys.ADD_LAYOUT);
                }
                else {
                    hasLayoutAddPermission = LayoutPermissionUtil.contains(permissionChecker, layout, ActionKeys.ADD_LAYOUT);
                }

                boolean hasLayoutCustomizePermission = LayoutPermissionUtil.contains(permissionChecker, layout, ActionKeys.CUSTOMIZE);
                boolean hasLayoutUpdatePermission = LayoutPermissionUtil.contains(permissionChecker, layout, ActionKeys.UPDATE);
            %>

            <c:if test="<%= !group.isControlPanel() && (hasLayoutAddPermission || hasLayoutUpdatePermission || (layoutTypePortlet.isCustomizable() && layoutTypePortlet.isCustomizedView() && hasLayoutCustomizePermission)) %>">
                <div class="add-content-menu" id="<portlet:namespace />addPanelContainer">
                    <aui:button cssClass="close pull-right" name="closePanelAdd" value="&times;" />

                    <%
                        List<String> tabs1Names = new ArrayList<String>();

                        boolean stateMaximized = ParamUtil.getBoolean(request, "stateMaximized");

                        boolean hasAddContentAndApplicationsPermission = !stateMaximized && layout.isTypePortlet() && !layout.isLayoutPrototypeLinkActive() && (hasLayoutUpdatePermission || (layoutTypePortlet.isCustomizable() && layoutTypePortlet.isCustomizedView() && hasLayoutCustomizePermission));

                        if (hasAddContentAndApplicationsPermission) {
                            tabs1Names.add("content,applications");
                        }

                        if (hasLayoutAddPermission) {
                            tabs1Names.add("page");
                        }

                        String selectedTab = GetterUtil.getString(SessionClicks.get(request, "liferay_addpanel_tab", "content"));

                        if (stateMaximized) {
                            selectedTab = "page";
                        }
                        tabs1Names.add("Site");



                    %>
                    <liferay-portlet:renderURL portletName="47" var="openPortletURL" plid="<%=themeDisplay.getPlid()%>"  varImpl="openPortletURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
                        <liferay-portlet:param name="name" value="meera"/>
                    </liferay-portlet:renderURL>

                    <h1><liferay-ui:message key="add" /></h1>
                    <liferay-ui:tabs
                            names="<%= StringUtil.merge(tabs1Names) %>"
                            refresh="<%= false %>"
                            type="pills"
                            value="<%= selectedTab %>"
                            >
                        <c:if test="<%= hasAddContentAndApplicationsPermission %>">
                            <liferay-ui:section>
                                <liferay-util:include page="/html/portlet/dockbar/add_content.jsp" />
                            </liferay-ui:section>

                            <liferay-ui:section>
                                <liferay-util:include page="/html/portlet/dockbar/add_application.jsp" />
                            </liferay-ui:section>
                        </c:if>

                        <c:if test="<%= hasLayoutAddPermission %>">
                            <liferay-ui:section>
                                <liferay-util:include page="/html/portlet/layouts_admin/add_layout.jsp" />
                            </liferay-ui:section>
                        </c:if>
                        <liferay-ui:section>
                            <liferay-util:include page="/html/portlet/dockbar/add_site.jsp" />
                        </liferay-ui:section>
                    </liferay-ui:tabs>
                </div>
            </c:if>
        </c:if>
    </c:when>
    <c:otherwise>
        <liferay-ui:message key="please-sign-in-to-continue" />
    </c:otherwise>
</c:choose>

<aui:script use="liferay-dockbar">
    A.one('#<portlet:namespace />closePanelAdd').on('click', Liferay.Dockbar.toggleAddPanel, Liferay.Dockbar);
</aui:script>