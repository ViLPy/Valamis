package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFQuestionLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFQuestionLocalService
 * @generated
 */
public class LFQuestionLocalServiceWrapper implements LFQuestionLocalService,
    ServiceWrapper<LFQuestionLocalService> {
    private LFQuestionLocalService _lfQuestionLocalService;

    public LFQuestionLocalServiceWrapper(
        LFQuestionLocalService lfQuestionLocalService) {
        _lfQuestionLocalService = lfQuestionLocalService;
    }

    /**
    * Adds the l f question to the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuestion the l f question
    * @return the l f question that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion addLFQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.addLFQuestion(lfQuestion);
    }

    /**
    * Creates a new l f question with the primary key. Does not add the l f question to the database.
    *
    * @param id the primary key for the new l f question
    * @return the new l f question
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion createLFQuestion(
        long id) {
        return _lfQuestionLocalService.createLFQuestion(id);
    }

    /**
    * Deletes the l f question with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f question
    * @return the l f question that was removed
    * @throws PortalException if a l f question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion deleteLFQuestion(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.deleteLFQuestion(id);
    }

    /**
    * Deletes the l f question from the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuestion the l f question
    * @return the l f question that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion deleteLFQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.deleteLFQuestion(lfQuestion);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfQuestionLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFQuestion fetchLFQuestion(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.fetchLFQuestion(id);
    }

    /**
    * Returns the l f question with the primary key.
    *
    * @param id the primary key of the l f question
    * @return the l f question
    * @throws PortalException if a l f question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion getLFQuestion(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.getLFQuestion(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f questions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @return the range of l f questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> getLFQuestions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.getLFQuestions(start, end);
    }

    /**
    * Returns the number of l f questions.
    *
    * @return the number of l f questions
    * @throws SystemException if a system exception occurred
    */
    public int getLFQuestionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.getLFQuestionsCount();
    }

    /**
    * Updates the l f question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuestion the l f question
    * @return the l f question that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion updateLFQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.updateLFQuestion(lfQuestion);
    }

    /**
    * Updates the l f question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuestion the l f question
    * @param merge whether to merge the l f question with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f question that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion updateLFQuestion(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.updateLFQuestion(lfQuestion, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfQuestionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfQuestionLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfQuestionLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFQuestion createLFQuestion()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.createLFQuestion();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer[] courseIds, java.lang.Integer[] categeryIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionLocalService.findByCourseIdAndCategoryId(courseIds,
            categeryIds);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuestionLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFQuestionLocalService getWrappedLFQuestionLocalService() {
        return _lfQuestionLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFQuestionLocalService(
        LFQuestionLocalService lfQuestionLocalService) {
        _lfQuestionLocalService = lfQuestionLocalService;
    }

    public LFQuestionLocalService getWrappedService() {
        return _lfQuestionLocalService;
    }

    public void setWrappedService(LFQuestionLocalService lfQuestionLocalService) {
        _lfQuestionLocalService = lfQuestionLocalService;
    }
}
