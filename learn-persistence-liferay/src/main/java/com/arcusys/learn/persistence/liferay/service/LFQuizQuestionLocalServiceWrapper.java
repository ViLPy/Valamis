package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFQuizQuestionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestionLocalService
 * @generated
 */
public class LFQuizQuestionLocalServiceWrapper
    implements LFQuizQuestionLocalService,
        ServiceWrapper<LFQuizQuestionLocalService> {
    private LFQuizQuestionLocalService _lfQuizQuestionLocalService;

    public LFQuizQuestionLocalServiceWrapper(
        LFQuizQuestionLocalService lfQuizQuestionLocalService) {
        _lfQuizQuestionLocalService = lfQuizQuestionLocalService;
    }

    /**
    * Adds the l f quiz question to the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizQuestion the l f quiz question
    * @return the l f quiz question that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion addLFQuizQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.addLFQuizQuestion(lfQuizQuestion);
    }

    /**
    * Creates a new l f quiz question with the primary key. Does not add the l f quiz question to the database.
    *
    * @param id the primary key for the new l f quiz question
    * @return the new l f quiz question
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion createLFQuizQuestion(
        long id) {
        return _lfQuizQuestionLocalService.createLFQuizQuestion(id);
    }

    /**
    * Deletes the l f quiz question with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz question
    * @return the l f quiz question that was removed
    * @throws PortalException if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion deleteLFQuizQuestion(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.deleteLFQuizQuestion(id);
    }

    /**
    * Deletes the l f quiz question from the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizQuestion the l f quiz question
    * @return the l f quiz question that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion deleteLFQuizQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.deleteLFQuizQuestion(lfQuizQuestion);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfQuizQuestionLocalService.dynamicQuery();
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
        return _lfQuizQuestionLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfQuizQuestionLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfQuizQuestionLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchLFQuizQuestion(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.fetchLFQuizQuestion(id);
    }

    /**
    * Returns the l f quiz question with the primary key.
    *
    * @param id the primary key of the l f quiz question
    * @return the l f quiz question
    * @throws PortalException if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion getLFQuizQuestion(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.getLFQuizQuestion(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> getLFQuizQuestions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.getLFQuizQuestions(start, end);
    }

    /**
    * Returns the number of l f quiz questions.
    *
    * @return the number of l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFQuizQuestionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.getLFQuizQuestionsCount();
    }

    /**
    * Updates the l f quiz question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuizQuestion the l f quiz question
    * @return the l f quiz question that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion updateLFQuizQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.updateLFQuizQuestion(lfQuizQuestion);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfQuizQuestionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfQuizQuestionLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfQuizQuestionLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion createLFQuizQuestion()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.createLFQuizQuestion();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizID(
        java.lang.Integer quizID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.findByQuizID(quizID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizAndCategory(
        java.lang.Integer quizID, java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestionLocalService.findByQuizAndCategory(quizID,
            categoryId);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuizQuestionLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFQuizQuestionLocalService getWrappedLFQuizQuestionLocalService() {
        return _lfQuizQuestionLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFQuizQuestionLocalService(
        LFQuizQuestionLocalService lfQuizQuestionLocalService) {
        _lfQuizQuestionLocalService = lfQuizQuestionLocalService;
    }

    @Override
    public LFQuizQuestionLocalService getWrappedService() {
        return _lfQuizQuestionLocalService;
    }

    @Override
    public void setWrappedService(
        LFQuizQuestionLocalService lfQuizQuestionLocalService) {
        _lfQuizQuestionLocalService = lfQuizQuestionLocalService;
    }
}
