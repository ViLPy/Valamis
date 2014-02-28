package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFQuestion. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFQuestionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuestionLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFQuestionLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFQuestionLocalServiceImpl
 * @generated
 */
public class LFQuestionLocalServiceUtil {
    private static LFQuestionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFQuestionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f question to the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuestion the l f question
    * @return the l f question that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion addLFQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFQuestion(lfQuestion);
    }

    /**
    * Creates a new l f question with the primary key. Does not add the l f question to the database.
    *
    * @param id the primary key for the new l f question
    * @return the new l f question
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion createLFQuestion(
        long id) {
        return getService().createLFQuestion(id);
    }

    /**
    * Deletes the l f question with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f question
    * @return the l f question that was removed
    * @throws PortalException if a l f question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion deleteLFQuestion(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFQuestion(id);
    }

    /**
    * Deletes the l f question from the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuestion the l f question
    * @return the l f question that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion deleteLFQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFQuestion(lfQuestion);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.arcusys.learn.persistence.liferay.model.LFQuestion fetchLFQuestion(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFQuestion(id);
    }

    /**
    * Returns the l f question with the primary key.
    *
    * @param id the primary key of the l f question
    * @return the l f question
    * @throws PortalException if a l f question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion getLFQuestion(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFQuestion(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f questions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @return the range of l f questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> getLFQuestions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFQuestions(start, end);
    }

    /**
    * Returns the number of l f questions.
    *
    * @return the number of l f questions
    * @throws SystemException if a system exception occurred
    */
    public static int getLFQuestionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFQuestionsCount();
    }

    /**
    * Updates the l f question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuestion the l f question
    * @return the l f question that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion updateLFQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFQuestion(lfQuestion);
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

    public static com.arcusys.learn.persistence.liferay.model.LFQuestion createLFQuestion()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFQuestion();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer[] courseIds, java.lang.Integer[] categeryIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCourseIdAndCategoryId(courseIds, categeryIds);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFQuestionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFQuestionLocalService.class.getName());

            if (invokableLocalService instanceof LFQuestionLocalService) {
                _service = (LFQuestionLocalService) invokableLocalService;
            } else {
                _service = new LFQuestionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFQuestionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFQuestionLocalService service) {
    }
}
