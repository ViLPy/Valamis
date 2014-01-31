package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSequencing;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f sequencing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingPersistenceImpl
 * @see LFSequencingUtil
 * @generated
 */
public interface LFSequencingPersistence extends BasePersistence<LFSequencing> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFSequencingUtil} to access the l f sequencing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the l f sequencing where packageID = &#63; and activityID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException} if it could not be found.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the matching l f sequencing
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException if a matching l f sequencing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSequencing findByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f sequencing where packageID = &#63; and activityID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the matching l f sequencing, or <code>null</code> if a matching l f sequencing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSequencing fetchByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f sequencing where packageID = &#63; and activityID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f sequencing, or <code>null</code> if a matching l f sequencing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSequencing fetchByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f sequencing where packageID = &#63; and activityID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the l f sequencing that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSequencing removeByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f sequencings where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the number of matching l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityIDAndPackageID(java.lang.Integer packageID,
        java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f sequencing in the entity cache if it is enabled.
    *
    * @param lfSequencing the l f sequencing
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing);

    /**
    * Caches the l f sequencings in the entity cache if it is enabled.
    *
    * @param lfSequencings the l f sequencings
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencing> lfSequencings);

    /**
    * Creates a new l f sequencing with the primary key. Does not add the l f sequencing to the database.
    *
    * @param id the primary key for the new l f sequencing
    * @return the new l f sequencing
    */
    public com.arcusys.learn.persistence.liferay.model.LFSequencing create(
        long id);

    /**
    * Removes the l f sequencing with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f sequencing
    * @return the l f sequencing that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException if a l f sequencing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSequencing remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFSequencing updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f sequencing with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException} if it could not be found.
    *
    * @param id the primary key of the l f sequencing
    * @return the l f sequencing
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException if a l f sequencing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSequencing findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f sequencing with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f sequencing
    * @return the l f sequencing, or <code>null</code> if a l f sequencing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSequencing fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f sequencings.
    *
    * @return the l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencing> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f sequencings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSequencingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f sequencings
    * @param end the upper bound of the range of l f sequencings (not inclusive)
    * @return the range of l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencing> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f sequencings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSequencingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f sequencings
    * @param end the upper bound of the range of l f sequencings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencing> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f sequencings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f sequencings.
    *
    * @return the number of l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
