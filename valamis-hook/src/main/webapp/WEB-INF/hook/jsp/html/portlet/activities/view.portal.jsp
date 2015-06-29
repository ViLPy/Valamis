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

<%@ include file="/html/portlet/activities/init.jsp" %>

<%
Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

List<SocialActivity> activities = null;

if (group.isOrganization()) {
	activities = SocialActivityLocalServiceUtil.getOrganizationActivities(group.getOrganizationId(), 0, max);
}
else if (group.isRegularSite()) {
	activities = SocialActivityLocalServiceUtil.getGroupActivities(group.getGroupId(), 0, max);
}
else if (group.isUser()) {
	activities = SocialActivityLocalServiceUtil.getUserActivities(group.getClassPK(), 0, max);
}

ArrayList<SocialActivity> result = new ArrayList<SocialActivity>();
if (group.isUser()){
    // if user activities - just keep them
    for(SocialActivity e:activities){
        result.add(e);
    }
}
else{
    // if not user - find certificate activities, add to list, sort by date and cut big list
    ArrayList<SocialActivity> valamisExtraActivities = new ArrayList<SocialActivity>();
    for(SocialActivity e:activities){
        valamisExtraActivities.add(e);
    }

    String certificateClassName = "com.arcusys.valamis.certificate.model.Certificate";
    for(SocialActivity e:SocialActivityLocalServiceUtil.getActivities(certificateClassName, 0, max)){
        valamisExtraActivities.add(e);
    }

    String statementClassName = "com.arcusys.valamis.lrs.tincan.Statement";

    for(SocialActivity e:SocialActivityLocalServiceUtil.getActivities(statementClassName, 0, max)){
        valamisExtraActivities.add(e);
    }

    Collections.sort(valamisExtraActivities);

    int counter = 0;
    int size = valamisExtraActivities.size();
    while( counter <  max && size > counter) {
        result.add(valamisExtraActivities.get(counter));
        counter++;
    }
}

ResourceURL rssURL = liferayPortletResponse.createResourceURL();

rssURL.setCacheability(ResourceURL.FULL);
rssURL.setParameter("struts_action", "/activities/rss");

String feedTitle = LanguageUtil.format(pageContext, "x's-activities", HtmlUtil.escape(group.getDescriptiveName(locale)));

rssURL.setParameter("feedTitle", feedTitle);

String taglibFeedTitle = LanguageUtil.format(pageContext, "subscribe-to-x's-activities", HtmlUtil.escape(group.getDescriptiveName(locale)));
%>

<liferay-ui:social-activities
	activities="<%= result %>"
	feedDisplayStyle="<%= rssDisplayStyle %>"
	feedEnabled="<%= enableRSS %>"
	feedLink="<%= rssURL.toString() %>"
	feedLinkMessage="<%= taglibFeedTitle %>"
	feedTitle="<%= taglibFeedTitle %>"
	feedType="<%= rssFeedType %>"
/>