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

<%@ include file="/html/portlet/portal_settings/init.jsp" %>

<h3><liferay-ui:message key="email-notifications" /></h3>

<%
    String valamisStudentEnrolledSubject = "VALAMIS_EMAIL_STUDENT_ENROLLED_SUBJECT";
    String valamisStudentEnrolledBody = "VALAMIS_EMAIL_STUDENT_ENROLLED_BODY";

    String valamisCompleteModuleSubject = "VALAMIS_EMAIL_COMPLETE_MODULE_SUBJECT";
    String valamisCompleteModuleBody = "VALAMIS_EMAIL_COMPLETE_MODULE_BODY";

    String valamisCertificateDeadlineSubject = "VALAMIS_EMAIL_CERTIFICATE_DEADLINE_SUBJECT";
    String valamisCertificateDeadlineBody = "VALAMIS_EMAIL_CERTIFICATE_DEADLINE_BODY";

    String valamisCertificateExpireSubject = "VALAMIS_EMAIL_CERTIFICATE_EXPIRE_SUBJECT";
    String valamisCertificateExpireBody = "VALAMIS_EMAIL_CERTIFICATE_EXPIRE_BODY";

    String adminEmailFromName = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
    String adminEmailFromAddress = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

    boolean adminEmailUserAddedEnable = PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED);
    String adminEmailUserAddedSubject = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_SUBJECT);
    String adminEmailUserAddedBody = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_BODY);
    String adminEmailUserAddedNoPasswordBody = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_NO_PASSWORD_BODY);

    String adminEmailPasswordSentSubject = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_SUBJECT);
    String adminEmailPasswordSentBody = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_BODY);

    String adminEmailPasswordResetSubject = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_SUBJECT);
    String adminEmailPasswordResetBody = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_BODY);

    String adminEmailVerificationSubject = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_VERIFICATION_SUBJECT);
    String adminEmailVerificationBody = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_VERIFICATION_BODY);

    String valamisEmailStudentEnrolledSubject = PrefsPropsUtil.getContent(company.getCompanyId(), valamisStudentEnrolledSubject);
    String valamisEmailStudentEnrolledBody = PrefsPropsUtil.getContent(company.getCompanyId(), valamisStudentEnrolledBody);

    String valamisEmailCompleteModuleSubject = PrefsPropsUtil.getContent(company.getCompanyId(), valamisCompleteModuleSubject);
    String valamisEmailCompleteModuleBody = PrefsPropsUtil.getContent(company.getCompanyId(), valamisCompleteModuleBody);

    String valamisEmailCertificateDeadlineSubject = PrefsPropsUtil.getContent(company.getCompanyId(), valamisCertificateDeadlineSubject);
    String valamisEmailCertificateDeadlineBody = PrefsPropsUtil.getContent(company.getCompanyId(), valamisCertificateDeadlineBody);

    String valamisEmailCertificateExpireSubject = PrefsPropsUtil.getContent(company.getCompanyId(), valamisCertificateExpireSubject);
    String valamisEmailCertificateExpireBody = PrefsPropsUtil.getContent(company.getCompanyId(), valamisCertificateExpireBody);
%>

<liferay-ui:error-marker key="errorSection" value="email_notifications" />

<liferay-ui:tabs
        names="sender,account-created-notification,email-verification-notification,password-changed-notification,password-reset-notification,
	valamis-student-enrolled, valamis-complete-module, valamis-certificate-deadline, valamis-certificate-expire"
        refresh="<%= false %>">
<liferay-ui:section>
    <aui:fieldset>
        <liferay-ui:error key="emailFromName" message="please-enter-a-valid-name" />

        <aui:input cssClass="lfr-input-text-container" label="name" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_FROM_NAME + "--" %>' type="text" value="<%= adminEmailFromName %>" />

        <liferay-ui:error key="emailFromAddress" message="please-enter-a-valid-email-address" />

        <aui:input cssClass="lfr-input-text-container" label="address" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_FROM_ADDRESS + "--" %>' type="text" value="<%= adminEmailFromAddress %>" />
    </aui:fieldset>
</liferay-ui:section>
<liferay-ui:section>
    <aui:fieldset>
        <aui:input label="enabled" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED + "--" %>' type="checkbox" value="<%= adminEmailUserAddedEnable %>" />

        <liferay-ui:error key="emailUserAddedSubject" message="please-enter-a-valid-subject" />

        <aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_USER_ADDED_SUBJECT + "--" %>' type="text" value="<%= adminEmailUserAddedSubject %>" />

        <liferay-ui:error key="emailUserAddedBody" message="please-enter-a-valid-body" />

        <aui:field-wrapper helpMessage="account-created-notification-body-with-password-help" label="body-with-password">
            <liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailUserAddedBodyEditor" %>' name="emailUserAddedBody" toolbarSet="email" width="470" />

            <aui:input name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_USER_ADDED_BODY + "--" %>' type="hidden" value="<%= adminEmailUserAddedBody %>" />
        </aui:field-wrapper>

        <liferay-ui:error key="emailUserAddedNoPasswordBody" message="please-enter-a-valid-body" />

        <aui:field-wrapper helpMessage="account-created-notification-body-without-password-help" label="body-without-password">
            <liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailUserAddedNoPasswordBodyEditor" %>' name="emailUserAddedNoPasswordBody" toolbarSet="email" width="470" />

            <aui:input name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_USER_ADDED_NO_PASSWORD_BODY + "--" %>' type="hidden" value="<%= adminEmailUserAddedNoPasswordBody %>" />
        </aui:field-wrapper>

        <div class="terms email-user-add definition-of-terms">
            <%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
        </div>
    </aui:fieldset>
</liferay-ui:section>
<liferay-ui:section>
    <aui:fieldset>
        <liferay-ui:error key="emailVerificationSubject" message="please-enter-a-valid-subject" />

        <aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_VERIFICATION_SUBJECT + "--" %>' type="text" value="<%= adminEmailVerificationSubject %>" />

        <liferay-ui:error key="emailVerificationBody" message="please-enter-a-valid-body" />

        <aui:field-wrapper label="body">
            <liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailVerificationBodyEditor" %>' name="emailVerificationBody" toolbarSet="email" width="470" />

            <aui:input name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_VERIFICATION_BODY + "--" %>' type="hidden" value="<%= adminEmailPasswordResetBody %>" />
        </aui:field-wrapper>

        <div class="terms email-verification definition-of-terms">
            <%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
        </div>
    </aui:fieldset>
</liferay-ui:section>
<liferay-ui:section>
    <aui:fieldset>
        <liferay-ui:error key="emailPasswordSentSubject" message="please-enter-a-valid-subject" />

        <aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_SUBJECT + "--" %>' type="text" value="<%= adminEmailPasswordSentSubject %>" />

        <liferay-ui:error key="emailPasswordSentBody" message="please-enter-a-valid-body" />

        <aui:field-wrapper label="body">
            <liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailPasswordSentBodyEditor" %>' name="emailPasswordSentBody" toolbarSet="email" width="470" />

            <aui:input name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_BODY + "--" %>' type="hidden" value="<%= adminEmailPasswordSentBody %>" />
        </aui:field-wrapper>

        <div class="terms email-password-sent definition-of-terms">
            <%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
        </div>
    </aui:fieldset>
</liferay-ui:section>
<liferay-ui:section>
    <aui:fieldset>
        <liferay-ui:error key="emailPasswordResetSubject" message="please-enter-a-valid-subject" />

        <aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_SUBJECT + "--" %>' type="text" value="<%= adminEmailPasswordResetSubject %>" />

        <liferay-ui:error key="emailPasswordResetBody" message="please-enter-a-valid-body" />

        <aui:field-wrapper label="body">
            <liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailPasswordResetBodyEditor" %>' name="emailPasswordResetBody" toolbarSet="email" width="470" />

            <aui:input name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_BODY + "--" %>' type="hidden" value="<%= adminEmailPasswordResetBody %>" />
        </aui:field-wrapper>

        <div class="terms email-password-sent definition-of-terms">
            <%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
        </div>
    </aui:fieldset>
</liferay-ui:section>

<liferay-ui:section>
    <aui:fieldset>
        <liferay-ui:error key="valamisStudentEnrolledSubject" message="please-enter-a-valid-subject" />

        <aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + valamisStudentEnrolledSubject + "--" %>' type="text" value="<%= valamisEmailStudentEnrolledSubject %>" />

        <liferay-ui:error key="valamisStudentEnrolledBody" message="please-enter-a-valid-body" />

        <aui:field-wrapper label="body">
            <liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initValamisEmailStudentEnrolledBodyEditor" %>' name="valamisStudentEnrolledBody" toolbarSet="email" width="470" />

            <aui:input name='<%= "settings--" + valamisStudentEnrolledBody + "--" %>' type="hidden" value="<%= valamisEmailStudentEnrolledBody %>" />
        </aui:field-wrapper>

        <div class="terms email-password-sent definition-of-terms">
            <h4>Definition of Terms</h4>

            <dl>
                <dt> [$DATE$] </dt>
                <dd> Email date </dd>
                <dt> [$REPEAT$] </dt>
                <dd> Repeatable data (for each course) </dd>
                <dt> [$COURSE_NAME$] </dt>
                <dd> Name of course </dd>
                <dt> [$ENROLLED_STUDENTS$] </dt>
                <dd> List of enrolled students </dd>
            </dl>
        </div>
    </aui:fieldset>
</liferay-ui:section>

   <liferay-ui:section>
       <aui:fieldset>
           <liferay-ui:error key="valamisCompleteModuleSubject" message="please-enter-a-valid-subject" />

           <aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + valamisCompleteModuleSubject + "--" %>' type="text" value="<%= valamisEmailCompleteModuleSubject %>" />

           <liferay-ui:error key="valamisCompleteModuleBody" message="please-enter-a-valid-body" />

           <aui:field-wrapper label="body">
               <liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initValamisEmailCompleteModuleBodyEditor" %>' name="valamisCompleteModuleBody" toolbarSet="email" width="470" />

               <aui:input name='<%= "settings--" + valamisCompleteModuleBody + "--" %>' type="hidden" value="<%= valamisEmailCompleteModuleBody %>" />
           </aui:field-wrapper>

           <div class="terms email-password-sent definition-of-terms">
               <h4>Definition of Terms</h4>

               <dl>
                   <dt> [$DATE$] </dt>
                   <dd> Email date </dd>
                   <dt> [$REPEAT$] </dt>
                   <dd> Repeatable data (for each student) </dd>
                   <dt> [$STUDENT_NAME$] </dt>
                   <dd> Student name </dd>
                   <dt> [$FINISHED_PACKAGES$] </dt>
                   <dd> List of finished packages </dd>
               </dl>
           </div>
       </aui:fieldset>
   </liferay-ui:section>

   <liferay-ui:section>
       <aui:fieldset>
           <liferay-ui:error key="valamisCertificateDeadlineSubject" message="please-enter-a-valid-subject" />

           <aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + valamisCertificateDeadlineSubject + "--" %>' type="text" value="<%= valamisEmailCertificateDeadlineSubject %>" />

           <liferay-ui:error key="valamisCertificateDeadlineBody" message="please-enter-a-valid-body" />

           <aui:field-wrapper label="body">
               <liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initValamisEmailCertificateDeadlineBodyEditor" %>' name="valamisCertificateDeadlineBody" toolbarSet="email" width="470" />

               <aui:input name='<%= "settings--" + valamisCertificateDeadlineBody + "--" %>' type="hidden" value="<%= valamisEmailCertificateDeadlineBody %>" />
           </aui:field-wrapper>

           <div class="terms email-password-sent definition-of-terms">
               <h4>Definition of Terms</h4>

               <dl>
                   <dt> [$DATE$] </dt>
                   <dd> Email date </dd>
                   <dt> [$REPEAT$] </dt>
                   <dd> Repeatable data (for each certificate) </dd>

                   <dt> [$REPEAT_COURSE$] </dt>
                   <dd> Repeatable data (for each course) </dd>

                   <dt> [$REPEAT_STATEMENT$] </dt>
                   <dd> Repeatable data (for each statement) </dd>

                   <dt> [$REPEAT_ACTIVITY$] </dt>
                   <dd> Repeatable data (for each activity) </dd>

                   <dt> [$CERTIFICATE_NAME$] </dt>
                   <dd> Certificate name </dd>
                   <dt> [$TITLE$] </dt>
                   <dd> Goal name </dd>

                   <dt> [$DAYS$] </dt>
                   <dd> Days </dd>
                   <dt> [$DATE$] </dt>
                   <dd> Date </dd>
               </dl>
           </div>
       </aui:fieldset>
   </liferay-ui:section>

   <liferay-ui:section>
       <aui:fieldset>
           <liferay-ui:error key="valamisCertificateExpireSubject" message="please-enter-a-valid-subject" />

           <aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + valamisCertificateExpireSubject + "--" %>' type="text" value="<%= valamisEmailCertificateExpireSubject %>" />

           <liferay-ui:error key="valamisCertificateExpireBody" message="please-enter-a-valid-body" />

           <aui:field-wrapper label="body">
               <liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initValamisEmailCertificateExpireBodyEditor" %>' name="valamisCertificateExpireBody" toolbarSet="email" width="470" />

               <aui:input name='<%= "settings--" + valamisCertificateExpireBody + "--" %>' type="hidden" value="<%= valamisEmailCertificateExpireBody %>" />
           </aui:field-wrapper>

           <div class="terms email-password-sent definition-of-terms">
               <h4>Definition of Terms</h4>

               <dl>
                   <dt> [$DATE$] </dt>
                   <dd> Email date </dd>
                   <dt> [$REPEAT$] </dt>
                   <dd> Repeatable data (for each certificate) </dd>
                   <dt> [$CERTIFICATE_NAME$] </dt>
                   <dd> Certificate name </dd>
                   <dt> [$DAYS$] </dt>
                   <dd> Days </dd>
                   <dt> [$DATE$] </dt>
                   <dd> Date </dd>
               </dl>
           </div>
       </aui:fieldset>
   </liferay-ui:section>
</liferay-ui:tabs>

<aui:script>
    function <portlet:namespace />initEmailUserAddedBodyEditor() {
    return "<%= UnicodeFormatter.toString(adminEmailUserAddedBody) %>";
    }

    function <portlet:namespace />initEmailUserAddedNoPasswordBodyEditor() {
    return "<%= UnicodeFormatter.toString(adminEmailUserAddedNoPasswordBody) %>";
    }

    function <portlet:namespace />initEmailPasswordSentBodyEditor() {
    return "<%= UnicodeFormatter.toString(adminEmailPasswordSentBody) %>";
    }

    function <portlet:namespace />initEmailPasswordResetBodyEditor() {
    return "<%= UnicodeFormatter.toString(adminEmailPasswordResetBody) %>";
    }

    function <portlet:namespace />initEmailVerificationBodyEditor() {
    return "<%= UnicodeFormatter.toString(adminEmailVerificationBody) %>";
    }

    function <portlet:namespace />initValamisEmailStudentEnrolledBodyEditor() {
    return "<%= UnicodeFormatter.toString(valamisEmailStudentEnrolledBody) %>";
    }

    function <portlet:namespace />initValamisEmailCompleteModuleBodyEditor() {
        return "<%= UnicodeFormatter.toString(valamisEmailCompleteModuleBody) %>";
    }

    function <portlet:namespace />initValamisEmailCertificateDeadlineBodyEditor() {
        return "<%= UnicodeFormatter.toString(valamisEmailCertificateDeadlineBody) %>";
    }

    function <portlet:namespace />initValamisEmailCertificateExpireBodyEditor() {
        return "<%= UnicodeFormatter.toString(valamisEmailCertificateExpireBody) %>";
    }


    function <portlet:namespace />saveEmails() {
    try {
    document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.ADMIN_EMAIL_USER_ADDED_BODY %>--'].value = window['<portlet:namespace />emailUserAddedBody'].getHTML();
    }
    catch (e) {
    }

    try {
    document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.ADMIN_EMAIL_USER_ADDED_NO_PASSWORD_BODY %>--'].value = window['<portlet:namespace />emailUserAddedNoPasswordBody'].getHTML();
    }
    catch (e) {
    }

    try {
    document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_BODY %>--'].value = window['<portlet:namespace />emailPasswordSentBody'].getHTML();
    }
    catch (e) {
    }

    try {
    document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_BODY %>--'].value = window['<portlet:namespace />emailPasswordResetBody'].getHTML();
    }
    catch (e) {
    }

    try {
    document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.ADMIN_EMAIL_VERIFICATION_BODY %>--'].value = window['<portlet:namespace />emailVerificationBody'].getHTML();
    }
    catch (e) {
    }

    try {
    document.<portlet:namespace />fm['<portlet:namespace />settings--<%= valamisStudentEnrolledBody %>--'].value = window['<portlet:namespace />valamisStudentEnrolledBody'].getHTML();
    }
    catch (e) {
    }

    try {
        document.<portlet:namespace />fm['<portlet:namespace />settings--<%= valamisCompleteModuleBody %>--'].value = window['<portlet:namespace />valamisCompleteModuleBody'].getHTML();
    }
    catch (e) {
    }

    try {
        document.<portlet:namespace />fm['<portlet:namespace />settings--<%= valamisCertificateDeadlineBody %>--'].value = window['<portlet:namespace />valamisCertificateDeadlineBody'].getHTML();
    }
    catch (e) {
    }

    try {
        document.<portlet:namespace />fm['<portlet:namespace />settings--<%= valamisCertificateExpireBody %>--'].value = window['<portlet:namespace />valamisCertificateExpireBody'].getHTML();
    }
    catch (e) {
    }
    }
</aui:script>

<%!
    public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.portal_settings.email_notifications.jsp";
%>