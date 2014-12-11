package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFQuizAnswerScoreLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizAnswerScoreLocalService
 * @generated
 */
public class LFQuizAnswerScoreLocalServiceWrapper
    implements LFQuizAnswerScoreLocalService,
        ServiceWrapper<LFQuizAnswerScoreLocalService> {
    private LFQuizAnswerScoreLocalService _lfQuizAnswerScoreLocalService;

    public LFQuizAnswerScoreLocalServiceWrapper(
        LFQuizAnswerScoreLocalService lfQuizAnswerScoreLocalService) {
        _lfQuizAnswerScoreLocalService = lfQuizAnswerScoreLocalService;
    }

    /**
    * Adds the l f quiz answer score to the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizAnswerScore the l f quiz answer score
    * @return the l f quiz answer score that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore addLFQuizAnswerScore(
        com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore lfQuizAnswerScore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.addLFQuizAnswerScore(lfQuizAnswerScore);
    }

    /**
    * Creates a new l f quiz answer score with the primary key. Does not add the l f quiz answer score to the database.
    *
    * @param answerId the primary key for the new l f quiz answer score
    * @return the new l f quiz answer score
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore createLFQuizAnswerScore(
        long answerId) {
        return _lfQuizAnswerScoreLocalService.createLFQuizAnswerScore(answerId);
    }

    /**
    * Deletes the l f quiz answer score with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param answerId the primary key of the l f quiz answer score
    * @return the l f quiz answer score that was removed
    * @throws PortalException if a l f quiz answer score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore deleteLFQuizAnswerScore(
        long answerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.deleteLFQuizAnswerScore(answerId);
    }

    /**
    * Deletes the l f quiz answer score from the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizAnswerScore the l f quiz answer score
    * @return the l f quiz answer score that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore deleteLFQuizAnswerScore(
        com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore lfQuizAnswerScore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.deleteLFQuizAnswerScore(lfQuizAnswerScore);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfQuizAnswerScoreLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.dynamicQuery(dynamicQuery, start,
            end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore fetchLFQuizAnswerScore(
        long answerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.fetchLFQuizAnswerScore(answerId);
    }

    /**
    * Returns the l f quiz answer score with the primary key.
    *
    * @param answerId the primary key of the l f quiz answer score
    * @return the l f quiz answer score
    * @throws PortalException if a l f quiz answer score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore getLFQuizAnswerScore(
        long answerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.getLFQuizAnswerScore(answerId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore> getLFQuizAnswerScores(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.getLFQuizAnswerScores(start, end);
    }

    /**
    * Returns the number of l f quiz answer scores.
    *
    * @return the number of l f quiz answer scores
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFQuizAnswerScoresCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.getLFQuizAnswerScoresCount();
    }

    /**
    * Updates the l f quiz answer score in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuizAnswerScore the l f quiz answer score
    * @return the l f quiz answer score that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore updateLFQuizAnswerScore(
        com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore lfQuizAnswerScore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.updateLFQuizAnswerScore(lfQuizAnswerScore);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfQuizAnswerScoreLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfQuizAnswerScoreLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfQuizAnswerScoreLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore getScoresForAnswer(
        long answerId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.getScoresForAnswer(answerId);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore createLFQuizQuestionScore()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizAnswerScoreLocalService.createLFQuizQuestionScore();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFQuizAnswerScoreLocalService getWrappedLFQuizAnswerScoreLocalService() {
        return _lfQuizAnswerScoreLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFQuizAnswerScoreLocalService(
        LFQuizAnswerScoreLocalService lfQuizAnswerScoreLocalService) {
        _lfQuizAnswerScoreLocalService = lfQuizAnswerScoreLocalService;
    }

    @Override
    public LFQuizAnswerScoreLocalService getWrappedService() {
        return _lfQuizAnswerScoreLocalService;
    }

    @Override
    public void setWrappedService(
        LFQuizAnswerScoreLocalService lfQuizAnswerScoreLocalService) {
        _lfQuizAnswerScoreLocalService = lfQuizAnswerScoreLocalService;
    }
}
