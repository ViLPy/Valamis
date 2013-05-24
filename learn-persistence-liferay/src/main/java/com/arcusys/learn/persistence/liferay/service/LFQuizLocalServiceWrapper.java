package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFQuizLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFQuizLocalService
 * @generated
 */
public class LFQuizLocalServiceWrapper implements LFQuizLocalService,
    ServiceWrapper<LFQuizLocalService> {
    private LFQuizLocalService _lfQuizLocalService;

    public LFQuizLocalServiceWrapper(LFQuizLocalService lfQuizLocalService) {
        _lfQuizLocalService = lfQuizLocalService;
    }

    /**
    * Adds the l f quiz to the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuiz the l f quiz
    * @return the l f quiz that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz addLFQuiz(
        com.arcusys.learn.persistence.liferay.model.LFQuiz lfQuiz)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.addLFQuiz(lfQuiz);
    }

    /**
    * Creates a new l f quiz with the primary key. Does not add the l f quiz to the database.
    *
    * @param id the primary key for the new l f quiz
    * @return the new l f quiz
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz createLFQuiz(
        long id) {
        return _lfQuizLocalService.createLFQuiz(id);
    }

    /**
    * Deletes the l f quiz with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz
    * @return the l f quiz that was removed
    * @throws PortalException if a l f quiz with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz deleteLFQuiz(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.deleteLFQuiz(id);
    }

    /**
    * Deletes the l f quiz from the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuiz the l f quiz
    * @return the l f quiz that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz deleteLFQuiz(
        com.arcusys.learn.persistence.liferay.model.LFQuiz lfQuiz)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.deleteLFQuiz(lfQuiz);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfQuizLocalService.dynamicQuery();
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
        return _lfQuizLocalService.dynamicQuery(dynamicQuery);
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
        return _lfQuizLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _lfQuizLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _lfQuizLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFQuiz fetchLFQuiz(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.fetchLFQuiz(id);
    }

    /**
    * Returns the l f quiz with the primary key.
    *
    * @param id the primary key of the l f quiz
    * @return the l f quiz
    * @throws PortalException if a l f quiz with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz getLFQuiz(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.getLFQuiz(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f quizs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @return the range of l f quizs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> getLFQuizs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.getLFQuizs(start, end);
    }

    /**
    * Returns the number of l f quizs.
    *
    * @return the number of l f quizs
    * @throws SystemException if a system exception occurred
    */
    public int getLFQuizsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.getLFQuizsCount();
    }

    /**
    * Updates the l f quiz in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuiz the l f quiz
    * @return the l f quiz that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz updateLFQuiz(
        com.arcusys.learn.persistence.liferay.model.LFQuiz lfQuiz)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.updateLFQuiz(lfQuiz);
    }

    /**
    * Updates the l f quiz in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuiz the l f quiz
    * @param merge whether to merge the l f quiz with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f quiz that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz updateLFQuiz(
        com.arcusys.learn.persistence.liferay.model.LFQuiz lfQuiz, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.updateLFQuiz(lfQuiz, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfQuizLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfQuizLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfQuizLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFQuiz createLFQuiz()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.createLFQuiz();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer[] courseIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizLocalService.findByCourseId(courseIds);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuizLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFQuizLocalService getWrappedLFQuizLocalService() {
        return _lfQuizLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFQuizLocalService(
        LFQuizLocalService lfQuizLocalService) {
        _lfQuizLocalService = lfQuizLocalService;
    }

    public LFQuizLocalService getWrappedService() {
        return _lfQuizLocalService;
    }

    public void setWrappedService(LFQuizLocalService lfQuizLocalService) {
        _lfQuizLocalService = lfQuizLocalService;
    }
}
