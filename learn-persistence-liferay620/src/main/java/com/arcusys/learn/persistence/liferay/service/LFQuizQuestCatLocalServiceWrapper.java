package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFQuizQuestCatLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestCatLocalService
 * @generated
 */
public class LFQuizQuestCatLocalServiceWrapper
    implements LFQuizQuestCatLocalService,
        ServiceWrapper<LFQuizQuestCatLocalService> {
    private LFQuizQuestCatLocalService _lfQuizQuestCatLocalService;

    public LFQuizQuestCatLocalServiceWrapper(
        LFQuizQuestCatLocalService lfQuizQuestCatLocalService) {
        _lfQuizQuestCatLocalService = lfQuizQuestCatLocalService;
    }

    /**
    * Adds the l f quiz quest cat to the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizQuestCat the l f quiz quest cat
    * @return the l f quiz quest cat that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat addLFQuizQuestCat(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat lfQuizQuestCat)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.addLFQuizQuestCat(lfQuizQuestCat);
    }

    /**
    * Creates a new l f quiz quest cat with the primary key. Does not add the l f quiz quest cat to the database.
    *
    * @param id the primary key for the new l f quiz quest cat
    * @return the new l f quiz quest cat
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat createLFQuizQuestCat(
        long id) {
        return _lfQuizQuestCatLocalService.createLFQuizQuestCat(id);
    }

    /**
    * Deletes the l f quiz quest cat with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz quest cat
    * @return the l f quiz quest cat that was removed
    * @throws PortalException if a l f quiz quest cat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat deleteLFQuizQuestCat(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.deleteLFQuizQuestCat(id);
    }

    /**
    * Deletes the l f quiz quest cat from the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizQuestCat the l f quiz quest cat
    * @return the l f quiz quest cat that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat deleteLFQuizQuestCat(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat lfQuizQuestCat)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.deleteLFQuizQuestCat(lfQuizQuestCat);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfQuizQuestCatLocalService.dynamicQuery();
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
        return _lfQuizQuestCatLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfQuizQuestCatLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfQuizQuestCatLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfQuizQuestCatLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfQuizQuestCatLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat fetchLFQuizQuestCat(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.fetchLFQuizQuestCat(id);
    }

    /**
    * Returns the l f quiz quest cat with the primary key.
    *
    * @param id the primary key of the l f quiz quest cat
    * @return the l f quiz quest cat
    * @throws PortalException if a l f quiz quest cat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat getLFQuizQuestCat(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.getLFQuizQuestCat(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f quiz quest cats.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz quest cats
    * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
    * @return the range of l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> getLFQuizQuestCats(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.getLFQuizQuestCats(start, end);
    }

    /**
    * Returns the number of l f quiz quest cats.
    *
    * @return the number of l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFQuizQuestCatsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.getLFQuizQuestCatsCount();
    }

    /**
    * Updates the l f quiz quest cat in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuizQuestCat the l f quiz quest cat
    * @return the l f quiz quest cat that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat updateLFQuizQuestCat(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat lfQuizQuestCat)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.updateLFQuizQuestCat(lfQuizQuestCat);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfQuizQuestCatLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfQuizQuestCatLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfQuizQuestCatLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat createLFQuizQuestionCategory()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.createLFQuizQuestionCategory();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> findByQuizIdAndParentId(
        java.lang.Integer quizId, java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.findByQuizIdAndParentId(quizId,
            parentId);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> findByQuizId(
        java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizQuestCatLocalService.findByQuizId(quizId);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuizQuestCatLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFQuizQuestCatLocalService getWrappedLFQuizQuestCatLocalService() {
        return _lfQuizQuestCatLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFQuizQuestCatLocalService(
        LFQuizQuestCatLocalService lfQuizQuestCatLocalService) {
        _lfQuizQuestCatLocalService = lfQuizQuestCatLocalService;
    }

    @Override
    public LFQuizQuestCatLocalService getWrappedService() {
        return _lfQuizQuestCatLocalService;
    }

    @Override
    public void setWrappedService(
        LFQuizQuestCatLocalService lfQuizQuestCatLocalService) {
        _lfQuizQuestCatLocalService = lfQuizQuestCatLocalService;
    }
}
