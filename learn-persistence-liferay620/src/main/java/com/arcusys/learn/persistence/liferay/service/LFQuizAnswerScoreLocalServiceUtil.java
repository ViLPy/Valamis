package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFQuizAnswerScore. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFQuizAnswerScoreLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizAnswerScoreLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFQuizAnswerScoreLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFQuizAnswerScoreLocalServiceImpl
 * @generated
 */
public class LFQuizAnswerScoreLocalServiceUtil {
    private static LFQuizAnswerScoreLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFQuizAnswerScoreLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f quiz answer score to the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizAnswerScore the l f quiz answer score
    * @return the l f quiz answer score that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore addLFQuizAnswerScore(
        com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore lfQuizAnswerScore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFQuizAnswerScore(lfQuizAnswerScore);
    }

    /**
    * Creates a new l f quiz answer score with the primary key. Does not add the l f quiz answer score to the database.
    *
    * @param answerId the primary key for the new l f quiz answer score
    * @return the new l f quiz answer score
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore createLFQuizAnswerScore(
        long answerId) {
        return getService().createLFQuizAnswerScore(answerId);
    }

    /**
    * Deletes the l f quiz answer score with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param answerId the primary key of the l f quiz answer score
    * @return the l f quiz answer score that was removed
    * @throws PortalException if a l f quiz answer score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore deleteLFQuizAnswerScore(
        long answerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFQuizAnswerScore(answerId);
    }

    /**
    * Deletes the l f quiz answer score from the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizAnswerScore the l f quiz answer score
    * @return the l f quiz answer score that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore deleteLFQuizAnswerScore(
        com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore lfQuizAnswerScore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFQuizAnswerScore(lfQuizAnswerScore);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore fetchLFQuizAnswerScore(
        long answerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFQuizAnswerScore(answerId);
    }

    /**
    * Returns the l f quiz answer score with the primary key.
    *
    * @param answerId the primary key of the l f quiz answer score
    * @return the l f quiz answer score
    * @throws PortalException if a l f quiz answer score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore getLFQuizAnswerScore(
        long answerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFQuizAnswerScore(answerId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f quiz answer scores.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz answer scores
    * @param end the upper bound of the range of l f quiz answer scores (not inclusive)
    * @return the range of l f quiz answer scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore> getLFQuizAnswerScores(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFQuizAnswerScores(start, end);
    }

    /**
    * Returns the number of l f quiz answer scores.
    *
    * @return the number of l f quiz answer scores
    * @throws SystemException if a system exception occurred
    */
    public static int getLFQuizAnswerScoresCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFQuizAnswerScoresCount();
    }

    /**
    * Updates the l f quiz answer score in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuizAnswerScore the l f quiz answer score
    * @return the l f quiz answer score that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore updateLFQuizAnswerScore(
        com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore lfQuizAnswerScore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFQuizAnswerScore(lfQuizAnswerScore);
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

    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore getScoresForAnswer(
        long answerId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getScoresForAnswer(answerId);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore createLFQuizQuestionScore()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFQuizQuestionScore();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFQuizAnswerScoreLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFQuizAnswerScoreLocalService.class.getName());

            if (invokableLocalService instanceof LFQuizAnswerScoreLocalService) {
                _service = (LFQuizAnswerScoreLocalService) invokableLocalService;
            } else {
                _service = new LFQuizAnswerScoreLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFQuizAnswerScoreLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFQuizAnswerScoreLocalService service) {
    }
}
