package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFQuestionCategoryLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFQuestionCategoryLocalService
 * @generated
 */
public class LFQuestionCategoryLocalServiceWrapper
    implements LFQuestionCategoryLocalService,
        ServiceWrapper<LFQuestionCategoryLocalService> {
    private LFQuestionCategoryLocalService _lfQuestionCategoryLocalService;

    public LFQuestionCategoryLocalServiceWrapper(
        LFQuestionCategoryLocalService lfQuestionCategoryLocalService) {
        _lfQuestionCategoryLocalService = lfQuestionCategoryLocalService;
    }

    /**
    * Adds the l f question category to the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuestionCategory the l f question category
    * @return the l f question category that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory addLFQuestionCategory(
        com.arcusys.learn.persistence.liferay.model.LFQuestionCategory lfQuestionCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.addLFQuestionCategory(lfQuestionCategory);
    }

    /**
    * Creates a new l f question category with the primary key. Does not add the l f question category to the database.
    *
    * @param id the primary key for the new l f question category
    * @return the new l f question category
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory createLFQuestionCategory(
        long id) {
        return _lfQuestionCategoryLocalService.createLFQuestionCategory(id);
    }

    /**
    * Deletes the l f question category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f question category
    * @return the l f question category that was removed
    * @throws PortalException if a l f question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory deleteLFQuestionCategory(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.deleteLFQuestionCategory(id);
    }

    /**
    * Deletes the l f question category from the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuestionCategory the l f question category
    * @return the l f question category that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory deleteLFQuestionCategory(
        com.arcusys.learn.persistence.liferay.model.LFQuestionCategory lfQuestionCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.deleteLFQuestionCategory(lfQuestionCategory);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfQuestionCategoryLocalService.dynamicQuery();
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
        return _lfQuestionCategoryLocalService.dynamicQuery(dynamicQuery);
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
        return _lfQuestionCategoryLocalService.dynamicQuery(dynamicQuery,
            start, end);
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
        return _lfQuestionCategoryLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _lfQuestionCategoryLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory fetchLFQuestionCategory(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.fetchLFQuestionCategory(id);
    }

    /**
    * Returns the l f question category with the primary key.
    *
    * @param id the primary key of the l f question category
    * @return the l f question category
    * @throws PortalException if a l f question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory getLFQuestionCategory(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.getLFQuestionCategory(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f question categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f question categories
    * @param end the upper bound of the range of l f question categories (not inclusive)
    * @return the range of l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> getLFQuestionCategories(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.getLFQuestionCategories(start,
            end);
    }

    /**
    * Returns the number of l f question categories.
    *
    * @return the number of l f question categories
    * @throws SystemException if a system exception occurred
    */
    public int getLFQuestionCategoriesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.getLFQuestionCategoriesCount();
    }

    /**
    * Updates the l f question category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuestionCategory the l f question category
    * @return the l f question category that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory updateLFQuestionCategory(
        com.arcusys.learn.persistence.liferay.model.LFQuestionCategory lfQuestionCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.updateLFQuestionCategory(lfQuestionCategory);
    }

    /**
    * Updates the l f question category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuestionCategory the l f question category
    * @param merge whether to merge the l f question category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f question category that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory updateLFQuestionCategory(
        com.arcusys.learn.persistence.liferay.model.LFQuestionCategory lfQuestionCategory,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.updateLFQuestionCategory(lfQuestionCategory,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfQuestionCategoryLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfQuestionCategoryLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfQuestionCategoryLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory createLFQuestionCategory()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.createLFQuestionCategory();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer[] courseIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.findByCourseId(courseIds);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer[] courseIds, java.lang.Integer[] parentIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuestionCategoryLocalService.findByCourseIdAndParentId(courseIds,
            parentIds);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuestionCategoryLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFQuestionCategoryLocalService getWrappedLFQuestionCategoryLocalService() {
        return _lfQuestionCategoryLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFQuestionCategoryLocalService(
        LFQuestionCategoryLocalService lfQuestionCategoryLocalService) {
        _lfQuestionCategoryLocalService = lfQuestionCategoryLocalService;
    }

    public LFQuestionCategoryLocalService getWrappedService() {
        return _lfQuestionCategoryLocalService;
    }

    public void setWrappedService(
        LFQuestionCategoryLocalService lfQuestionCategoryLocalService) {
        _lfQuestionCategoryLocalService = lfQuestionCategoryLocalService;
    }
}
