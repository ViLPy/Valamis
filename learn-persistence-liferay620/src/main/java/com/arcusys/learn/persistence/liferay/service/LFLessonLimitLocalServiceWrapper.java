package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFLessonLimitLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFLessonLimitLocalService
 * @generated
 */
public class LFLessonLimitLocalServiceWrapper
    implements LFLessonLimitLocalService,
        ServiceWrapper<LFLessonLimitLocalService> {
    private LFLessonLimitLocalService _lfLessonLimitLocalService;

    public LFLessonLimitLocalServiceWrapper(
        LFLessonLimitLocalService lfLessonLimitLocalService) {
        _lfLessonLimitLocalService = lfLessonLimitLocalService;
    }

    /**
    * Adds the l f lesson limit to the database. Also notifies the appropriate model listeners.
    *
    * @param lfLessonLimit the l f lesson limit
    * @return the l f lesson limit that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit addLFLessonLimit(
        com.arcusys.learn.persistence.liferay.model.LFLessonLimit lfLessonLimit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfLessonLimitLocalService.addLFLessonLimit(lfLessonLimit);
    }

    /**
    * Creates a new l f lesson limit with the primary key. Does not add the l f lesson limit to the database.
    *
    * @param lfLessonLimitPK the primary key for the new l f lesson limit
    * @return the new l f lesson limit
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit createLFLessonLimit(
        com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK lfLessonLimitPK) {
        return _lfLessonLimitLocalService.createLFLessonLimit(lfLessonLimitPK);
    }

    /**
    * Deletes the l f lesson limit with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfLessonLimitPK the primary key of the l f lesson limit
    * @return the l f lesson limit that was removed
    * @throws PortalException if a l f lesson limit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit deleteLFLessonLimit(
        com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK lfLessonLimitPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfLessonLimitLocalService.deleteLFLessonLimit(lfLessonLimitPK);
    }

    /**
    * Deletes the l f lesson limit from the database. Also notifies the appropriate model listeners.
    *
    * @param lfLessonLimit the l f lesson limit
    * @return the l f lesson limit that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit deleteLFLessonLimit(
        com.arcusys.learn.persistence.liferay.model.LFLessonLimit lfLessonLimit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfLessonLimitLocalService.deleteLFLessonLimit(lfLessonLimit);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfLessonLimitLocalService.dynamicQuery();
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
        return _lfLessonLimitLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfLessonLimitLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfLessonLimitLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfLessonLimitLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfLessonLimitLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit fetchLFLessonLimit(
        com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK lfLessonLimitPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfLessonLimitLocalService.fetchLFLessonLimit(lfLessonLimitPK);
    }

    /**
    * Returns the l f lesson limit with the primary key.
    *
    * @param lfLessonLimitPK the primary key of the l f lesson limit
    * @return the l f lesson limit
    * @throws PortalException if a l f lesson limit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit getLFLessonLimit(
        com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK lfLessonLimitPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfLessonLimitLocalService.getLFLessonLimit(lfLessonLimitPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfLessonLimitLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f lesson limits.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f lesson limits
    * @param end the upper bound of the range of l f lesson limits (not inclusive)
    * @return the range of l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> getLFLessonLimits(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfLessonLimitLocalService.getLFLessonLimits(start, end);
    }

    /**
    * Returns the number of l f lesson limits.
    *
    * @return the number of l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFLessonLimitsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfLessonLimitLocalService.getLFLessonLimitsCount();
    }

    /**
    * Updates the l f lesson limit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfLessonLimit the l f lesson limit
    * @return the l f lesson limit that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit updateLFLessonLimit(
        com.arcusys.learn.persistence.liferay.model.LFLessonLimit lfLessonLimit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfLessonLimitLocalService.updateLFLessonLimit(lfLessonLimit);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfLessonLimitLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfLessonLimitLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfLessonLimitLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit findByID(
        java.lang.Long itemID, java.lang.String itemType)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfLessonLimitLocalService.findByID(itemID, itemType);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFLessonLimitLocalService getWrappedLFLessonLimitLocalService() {
        return _lfLessonLimitLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFLessonLimitLocalService(
        LFLessonLimitLocalService lfLessonLimitLocalService) {
        _lfLessonLimitLocalService = lfLessonLimitLocalService;
    }

    @Override
    public LFLessonLimitLocalService getWrappedService() {
        return _lfLessonLimitLocalService;
    }

    @Override
    public void setWrappedService(
        LFLessonLimitLocalService lfLessonLimitLocalService) {
        _lfLessonLimitLocalService = lfLessonLimitLocalService;
    }
}
