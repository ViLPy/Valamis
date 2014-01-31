package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan lrs context activities service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsContextActivitiesPersistenceImpl
 * @see LFTincanLrsContextActivitiesUtil
 * @generated
 */
public interface LFTincanLrsContextActivitiesPersistence extends BasePersistence<LFTincanLrsContextActivities> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanLrsContextActivitiesUtil} to access the l f tincan lrs context activities persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f tincan lrs context activities in the entity cache if it is enabled.
    *
    * @param lfTincanLrsContextActivities the l f tincan lrs context activities
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities lfTincanLrsContextActivities);

    /**
    * Caches the l f tincan lrs context activitieses in the entity cache if it is enabled.
    *
    * @param lfTincanLrsContextActivitieses the l f tincan lrs context activitieses
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities> lfTincanLrsContextActivitieses);

    /**
    * Creates a new l f tincan lrs context activities with the primary key. Does not add the l f tincan lrs context activities to the database.
    *
    * @param id the primary key for the new l f tincan lrs context activities
    * @return the new l f tincan lrs context activities
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities create(
        long id);

    /**
    * Removes the l f tincan lrs context activities with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs context activities
    * @return the l f tincan lrs context activities that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException if a l f tincan lrs context activities with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities lfTincanLrsContextActivities)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs context activities with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs context activities
    * @return the l f tincan lrs context activities
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException if a l f tincan lrs context activities with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs context activities with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs context activities
    * @return the l f tincan lrs context activities, or <code>null</code> if a l f tincan lrs context activities with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan lrs context activitieses.
    *
    * @return the l f tincan lrs context activitieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan lrs context activitieses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextActivitiesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs context activitieses
    * @param end the upper bound of the range of l f tincan lrs context activitieses (not inclusive)
    * @return the range of l f tincan lrs context activitieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan lrs context activitieses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextActivitiesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs context activitieses
    * @param end the upper bound of the range of l f tincan lrs context activitieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs context activitieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan lrs context activitieses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs context activitieses.
    *
    * @return the number of l f tincan lrs context activitieses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
