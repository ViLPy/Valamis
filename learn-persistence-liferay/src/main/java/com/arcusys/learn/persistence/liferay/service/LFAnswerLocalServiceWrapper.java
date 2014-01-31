package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFAnswerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFAnswerLocalService
 * @generated
 */
public class LFAnswerLocalServiceWrapper implements LFAnswerLocalService,
    ServiceWrapper<LFAnswerLocalService> {
    private LFAnswerLocalService _lfAnswerLocalService;

    public LFAnswerLocalServiceWrapper(
        LFAnswerLocalService lfAnswerLocalService) {
        _lfAnswerLocalService = lfAnswerLocalService;
    }

    /**
    * Adds the l f answer to the database. Also notifies the appropriate model listeners.
    *
    * @param lfAnswer the l f answer
    * @return the l f answer that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAnswer addLFAnswer(
        com.arcusys.learn.persistence.liferay.model.LFAnswer lfAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAnswerLocalService.addLFAnswer(lfAnswer);
    }

    /**
    * Creates a new l f answer with the primary key. Does not add the l f answer to the database.
    *
    * @param id the primary key for the new l f answer
    * @return the new l f answer
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAnswer createLFAnswer(
        long id) {
        return _lfAnswerLocalService.createLFAnswer(id);
    }

    /**
    * Deletes the l f answer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f answer
    * @return the l f answer that was removed
    * @throws PortalException if a l f answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAnswer deleteLFAnswer(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAnswerLocalService.deleteLFAnswer(id);
    }

    /**
    * Deletes the l f answer from the database. Also notifies the appropriate model listeners.
    *
    * @param lfAnswer the l f answer
    * @return the l f answer that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAnswer deleteLFAnswer(
        com.arcusys.learn.persistence.liferay.model.LFAnswer lfAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAnswerLocalService.deleteLFAnswer(lfAnswer);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfAnswerLocalService.dynamicQuery();
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
        return _lfAnswerLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfAnswerLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfAnswerLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _lfAnswerLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfAnswerLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAnswer fetchLFAnswer(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAnswerLocalService.fetchLFAnswer(id);
    }

    /**
    * Returns the l f answer with the primary key.
    *
    * @param id the primary key of the l f answer
    * @return the l f answer
    * @throws PortalException if a l f answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAnswer getLFAnswer(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAnswerLocalService.getLFAnswer(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAnswerLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f answers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f answers
    * @param end the upper bound of the range of l f answers (not inclusive)
    * @return the range of l f answers
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAnswer> getLFAnswers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAnswerLocalService.getLFAnswers(start, end);
    }

    /**
    * Returns the number of l f answers.
    *
    * @return the number of l f answers
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFAnswersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAnswerLocalService.getLFAnswersCount();
    }

    /**
    * Updates the l f answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfAnswer the l f answer
    * @return the l f answer that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAnswer updateLFAnswer(
        com.arcusys.learn.persistence.liferay.model.LFAnswer lfAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAnswerLocalService.updateLFAnswer(lfAnswer);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfAnswerLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfAnswerLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfAnswerLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAnswer createLFAnswer()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAnswerLocalService.createLFAnswer();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAnswer> findByQuestionId(
        java.lang.Integer questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAnswerLocalService.findByQuestionId(questionId);
    }

    @Override
    public void removeByQuestionId(java.lang.Integer questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAnswerLocalService.removeByQuestionId(questionId);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAnswerLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFAnswerLocalService getWrappedLFAnswerLocalService() {
        return _lfAnswerLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFAnswerLocalService(
        LFAnswerLocalService lfAnswerLocalService) {
        _lfAnswerLocalService = lfAnswerLocalService;
    }

    @Override
    public LFAnswerLocalService getWrappedService() {
        return _lfAnswerLocalService;
    }

    @Override
    public void setWrappedService(LFAnswerLocalService lfAnswerLocalService) {
        _lfAnswerLocalService = lfAnswerLocalService;
    }
}
