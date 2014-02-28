package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFQuizQuestion. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFQuizQuestionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestionLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFQuizQuestionLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFQuizQuestionLocalServiceImpl
 * @generated
 */
public class LFQuizQuestionLocalServiceUtil {
    private static LFQuizQuestionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFQuizQuestionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f quiz question to the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizQuestion the l f quiz question
    * @return the l f quiz question that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion addLFQuizQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFQuizQuestion(lfQuizQuestion);
    }

    /**
    * Creates a new l f quiz question with the primary key. Does not add the l f quiz question to the database.
    *
    * @param id the primary key for the new l f quiz question
    * @return the new l f quiz question
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion createLFQuizQuestion(
        long id) {
        return getService().createLFQuizQuestion(id);
    }

    /**
    * Deletes the l f quiz question with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz question
    * @return the l f quiz question that was removed
    * @throws PortalException if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion deleteLFQuizQuestion(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFQuizQuestion(id);
    }

    /**
    * Deletes the l f quiz question from the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizQuestion the l f quiz question
    * @return the l f quiz question that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion deleteLFQuizQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFQuizQuestion(lfQuizQuestion);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchLFQuizQuestion(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFQuizQuestion(id);
    }

    /**
    * Returns the l f quiz question with the primary key.
    *
    * @param id the primary key of the l f quiz question
    * @return the l f quiz question
    * @throws PortalException if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion getLFQuizQuestion(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFQuizQuestion(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f quiz questions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz questions
    * @param end the upper bound of the range of l f quiz questions (not inclusive)
    * @return the range of l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> getLFQuizQuestions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFQuizQuestions(start, end);
    }

    /**
    * Returns the number of l f quiz questions.
    *
    * @return the number of l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static int getLFQuizQuestionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFQuizQuestionsCount();
    }

    /**
    * Updates the l f quiz question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuizQuestion the l f quiz question
    * @return the l f quiz question that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion updateLFQuizQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFQuizQuestion(lfQuizQuestion);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion createLFQuizQuestion()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFQuizQuestion();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizID(
        java.lang.Integer quizID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByQuizID(quizID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizAndCategory(
        java.lang.Integer quizID, java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByQuizAndCategory(quizID, categoryId);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFQuizQuestionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFQuizQuestionLocalService.class.getName());

            if (invokableLocalService instanceof LFQuizQuestionLocalService) {
                _service = (LFQuizQuestionLocalService) invokableLocalService;
            } else {
                _service = new LFQuizQuestionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFQuizQuestionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFQuizQuestionLocalService service) {
    }
}
