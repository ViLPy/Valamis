package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan manifest act service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanManifestActPersistenceImpl
 * @see LFTincanManifestActUtil
 * @generated
 */
public interface LFTincanManifestActPersistence extends BasePersistence<LFTincanManifestAct> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanManifestActUtil} to access the l f tincan manifest act persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f tincan manifest acts where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the matching l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findByPackageID(
        java.lang.Long packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan manifest acts where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f tincan manifest acts
    * @param end the upper bound of the range of l f tincan manifest acts (not inclusive)
    * @return the range of matching l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findByPackageID(
        java.lang.Long packageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan manifest acts where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f tincan manifest acts
    * @param end the upper bound of the range of l f tincan manifest acts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findByPackageID(
        java.lang.Long packageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan manifest act in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan manifest act
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct findByPackageID_First(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan manifest act in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct fetchByPackageID_First(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan manifest act in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan manifest act
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct findByPackageID_Last(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan manifest act in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct fetchByPackageID_Last(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan manifest acts before and after the current l f tincan manifest act in the ordered set where packageID = &#63;.
    *
    * @param id the primary key of the current l f tincan manifest act
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan manifest act
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a l f tincan manifest act with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct[] findByPackageID_PrevAndNext(
        long id, java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan manifest acts where packageID = &#63; from the database.
    *
    * @param packageID the package i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByPackageID(java.lang.Long packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan manifest acts where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the number of matching l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageID(java.lang.Long packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan manifest act where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException} if it could not be found.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan manifest act
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct findByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan manifest act where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct fetchByTincanID(
        java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan manifest act where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param tincanID the tincan i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct fetchByTincanID(
        java.lang.String tincanID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f tincan manifest act where tincanID = &#63; from the database.
    *
    * @param tincanID the tincan i d
    * @return the l f tincan manifest act that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct removeByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan manifest acts where tincanID = &#63;.
    *
    * @param tincanID the tincan i d
    * @return the number of matching l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public int countByTincanID(java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f tincan manifest act in the entity cache if it is enabled.
    *
    * @param lfTincanManifestAct the l f tincan manifest act
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct lfTincanManifestAct);

    /**
    * Caches the l f tincan manifest acts in the entity cache if it is enabled.
    *
    * @param lfTincanManifestActs the l f tincan manifest acts
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> lfTincanManifestActs);

    /**
    * Creates a new l f tincan manifest act with the primary key. Does not add the l f tincan manifest act to the database.
    *
    * @param id the primary key for the new l f tincan manifest act
    * @return the new l f tincan manifest act
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct create(
        long id);

    /**
    * Removes the l f tincan manifest act with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan manifest act
    * @return the l f tincan manifest act that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a l f tincan manifest act with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct lfTincanManifestAct)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan manifest act with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException} if it could not be found.
    *
    * @param id the primary key of the l f tincan manifest act
    * @return the l f tincan manifest act
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a l f tincan manifest act with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan manifest act with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan manifest act
    * @return the l f tincan manifest act, or <code>null</code> if a l f tincan manifest act with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan manifest acts.
    *
    * @return the l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan manifest acts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan manifest acts
    * @param end the upper bound of the range of l f tincan manifest acts (not inclusive)
    * @return the range of l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan manifest acts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan manifest acts
    * @param end the upper bound of the range of l f tincan manifest acts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan manifest acts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan manifest acts.
    *
    * @return the number of l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
