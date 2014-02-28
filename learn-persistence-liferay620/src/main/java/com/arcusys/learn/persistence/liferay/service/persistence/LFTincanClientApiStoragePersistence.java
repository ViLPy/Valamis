package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan client api storage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanClientApiStoragePersistenceImpl
 * @see LFTincanClientApiStorageUtil
 * @generated
 */
public interface LFTincanClientApiStoragePersistence extends BasePersistence<LFTincanClientApiStorage> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanClientApiStorageUtil} to access the l f tincan client api storage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the l f tincan client api storage where token = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException} if it could not be found.
    *
    * @param token the token
    * @return the matching l f tincan client api storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException if a matching l f tincan client api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage findByToken(
        java.lang.String token)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan client api storage where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param token the token
    * @return the matching l f tincan client api storage, or <code>null</code> if a matching l f tincan client api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage fetchByToken(
        java.lang.String token)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan client api storage where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param token the token
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan client api storage, or <code>null</code> if a matching l f tincan client api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage fetchByToken(
        java.lang.String token, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f tincan client api storage where token = &#63; from the database.
    *
    * @param token the token
    * @return the l f tincan client api storage that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage removeByToken(
        java.lang.String token)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan client api storages where token = &#63;.
    *
    * @param token the token
    * @return the number of matching l f tincan client api storages
    * @throws SystemException if a system exception occurred
    */
    public int countByToken(java.lang.String token)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan client api storage where code = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException} if it could not be found.
    *
    * @param code the code
    * @return the matching l f tincan client api storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException if a matching l f tincan client api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage findByCode(
        java.lang.String code)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan client api storage where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param code the code
    * @return the matching l f tincan client api storage, or <code>null</code> if a matching l f tincan client api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage fetchByCode(
        java.lang.String code)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan client api storage where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param code the code
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan client api storage, or <code>null</code> if a matching l f tincan client api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage fetchByCode(
        java.lang.String code, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f tincan client api storage where code = &#63; from the database.
    *
    * @param code the code
    * @return the l f tincan client api storage that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage removeByCode(
        java.lang.String code)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan client api storages where code = &#63;.
    *
    * @param code the code
    * @return the number of matching l f tincan client api storages
    * @throws SystemException if a system exception occurred
    */
    public int countByCode(java.lang.String code)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f tincan client api storage in the entity cache if it is enabled.
    *
    * @param lfTincanClientApiStorage the l f tincan client api storage
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage lfTincanClientApiStorage);

    /**
    * Caches the l f tincan client api storages in the entity cache if it is enabled.
    *
    * @param lfTincanClientApiStorages the l f tincan client api storages
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage> lfTincanClientApiStorages);

    /**
    * Creates a new l f tincan client api storage with the primary key. Does not add the l f tincan client api storage to the database.
    *
    * @param id the primary key for the new l f tincan client api storage
    * @return the new l f tincan client api storage
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage create(
        long id);

    /**
    * Removes the l f tincan client api storage with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan client api storage
    * @return the l f tincan client api storage that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException if a l f tincan client api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage lfTincanClientApiStorage)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan client api storage with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException} if it could not be found.
    *
    * @param id the primary key of the l f tincan client api storage
    * @return the l f tincan client api storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException if a l f tincan client api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan client api storage with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan client api storage
    * @return the l f tincan client api storage, or <code>null</code> if a l f tincan client api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan client api storages.
    *
    * @return the l f tincan client api storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan client api storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanClientApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan client api storages
    * @param end the upper bound of the range of l f tincan client api storages (not inclusive)
    * @return the range of l f tincan client api storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan client api storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanClientApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan client api storages
    * @param end the upper bound of the range of l f tincan client api storages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan client api storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan client api storages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan client api storages.
    *
    * @return the number of l f tincan client api storages
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
