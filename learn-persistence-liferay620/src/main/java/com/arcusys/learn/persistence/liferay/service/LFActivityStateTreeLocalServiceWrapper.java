package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFActivityStateTreeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateTreeLocalService
 * @generated
 */
public class LFActivityStateTreeLocalServiceWrapper
    implements LFActivityStateTreeLocalService,
        ServiceWrapper<LFActivityStateTreeLocalService> {
    private LFActivityStateTreeLocalService _lfActivityStateTreeLocalService;

    public LFActivityStateTreeLocalServiceWrapper(
        LFActivityStateTreeLocalService lfActivityStateTreeLocalService) {
        _lfActivityStateTreeLocalService = lfActivityStateTreeLocalService;
    }

    /**
    * Adds the l f activity state tree to the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityStateTree the l f activity state tree
    * @return the l f activity state tree that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree addLFActivityStateTree(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.addLFActivityStateTree(lfActivityStateTree);
    }

    /**
    * Creates a new l f activity state tree with the primary key. Does not add the l f activity state tree to the database.
    *
    * @param id the primary key for the new l f activity state tree
    * @return the new l f activity state tree
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree createLFActivityStateTree(
        long id) {
        return _lfActivityStateTreeLocalService.createLFActivityStateTree(id);
    }

    /**
    * Deletes the l f activity state tree with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree that was removed
    * @throws PortalException if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree deleteLFActivityStateTree(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.deleteLFActivityStateTree(id);
    }

    /**
    * Deletes the l f activity state tree from the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityStateTree the l f activity state tree
    * @return the l f activity state tree that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree deleteLFActivityStateTree(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.deleteLFActivityStateTree(lfActivityStateTree);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfActivityStateTreeLocalService.dynamicQuery();
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
        return _lfActivityStateTreeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfActivityStateTreeLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfActivityStateTreeLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _lfActivityStateTreeLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfActivityStateTreeLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree fetchLFActivityStateTree(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.fetchLFActivityStateTree(id);
    }

    /**
    * Returns the l f activity state tree with the primary key.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree
    * @throws PortalException if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree getLFActivityStateTree(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.getLFActivityStateTree(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f activity state trees.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activity state trees
    * @param end the upper bound of the range of l f activity state trees (not inclusive)
    * @return the range of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateTree> getLFActivityStateTrees(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.getLFActivityStateTrees(start,
            end);
    }

    /**
    * Returns the number of l f activity state trees.
    *
    * @return the number of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFActivityStateTreesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.getLFActivityStateTreesCount();
    }

    /**
    * Updates the l f activity state tree in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivityStateTree the l f activity state tree
    * @return the l f activity state tree that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree updateLFActivityStateTree(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.updateLFActivityStateTree(lfActivityStateTree);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfActivityStateTreeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfActivityStateTreeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfActivityStateTreeLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree createLFActivityStateTree()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.createLFActivityStateTree();
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree findByAttemptID(
        java.lang.Integer attemptID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.findByAttemptID(attemptID);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityStateTreeLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFActivityStateTreeLocalService getWrappedLFActivityStateTreeLocalService() {
        return _lfActivityStateTreeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFActivityStateTreeLocalService(
        LFActivityStateTreeLocalService lfActivityStateTreeLocalService) {
        _lfActivityStateTreeLocalService = lfActivityStateTreeLocalService;
    }

    @Override
    public LFActivityStateTreeLocalService getWrappedService() {
        return _lfActivityStateTreeLocalService;
    }

    @Override
    public void setWrappedService(
        LFActivityStateTreeLocalService lfActivityStateTreeLocalService) {
        _lfActivityStateTreeLocalService = lfActivityStateTreeLocalService;
    }
}
