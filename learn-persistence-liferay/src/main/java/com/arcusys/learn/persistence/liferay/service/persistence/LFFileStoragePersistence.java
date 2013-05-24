package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFFileStorage;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f file storage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFFileStoragePersistenceImpl
 * @see LFFileStorageUtil
 * @generated
 */
public interface LFFileStoragePersistence extends BasePersistence<LFFileStorage> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFFileStorageUtil} to access the l f file storage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f file storage in the entity cache if it is enabled.
    *
    * @param lfFileStorage the l f file storage
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFFileStorage lfFileStorage);

    /**
    * Caches the l f file storages in the entity cache if it is enabled.
    *
    * @param lfFileStorages the l f file storages
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> lfFileStorages);

    /**
    * Creates a new l f file storage with the primary key. Does not add the l f file storage to the database.
    *
    * @param id the primary key for the new l f file storage
    * @return the new l f file storage
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage create(
        long id);

    /**
    * Removes the l f file storage with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f file storage
    * @return the l f file storage that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a l f file storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFFileStorage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFFileStorage lfFileStorage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f file storage with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException} if it could not be found.
    *
    * @param id the primary key of the l f file storage
    * @return the l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a l f file storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f file storage with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f file storage
    * @return the l f file storage, or <code>null</code> if a l f file storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f file storages where filename = &#63;.
    *
    * @param filename the filename
    * @return the matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
        java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f file storages where filename = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param filename the filename
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @return the range of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
        java.lang.String filename, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f file storages where filename = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param filename the filename
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
        java.lang.String filename, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f file storage in the ordered set where filename = &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage findByFilename_First(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f file storage in the ordered set where filename = &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f file storage, or <code>null</code> if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage fetchByFilename_First(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f file storage in the ordered set where filename = &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage findByFilename_Last(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f file storage in the ordered set where filename = &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f file storage, or <code>null</code> if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage fetchByFilename_Last(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f file storages before and after the current l f file storage in the ordered set where filename = &#63;.
    *
    * @param id the primary key of the current l f file storage
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a l f file storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage[] findByFilename_PrevAndNext(
        long id, java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f file storages where filename LIKE &#63;.
    *
    * @param filename the filename
    * @return the matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByDirectory(
        java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f file storages where filename LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param filename the filename
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @return the range of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByDirectory(
        java.lang.String filename, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f file storages where filename LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param filename the filename
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByDirectory(
        java.lang.String filename, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f file storage in the ordered set where filename LIKE &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage findByDirectory_First(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f file storage in the ordered set where filename LIKE &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f file storage, or <code>null</code> if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage fetchByDirectory_First(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f file storage in the ordered set where filename LIKE &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage findByDirectory_Last(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f file storage in the ordered set where filename LIKE &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f file storage, or <code>null</code> if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage fetchByDirectory_Last(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f file storages before and after the current l f file storage in the ordered set where filename LIKE &#63;.
    *
    * @param id the primary key of the current l f file storage
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a l f file storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage[] findByDirectory_PrevAndNext(
        long id, java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f file storages.
    *
    * @return the l f file storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f file storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @return the range of l f file storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f file storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f file storages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f file storages where filename = &#63; from the database.
    *
    * @param filename the filename
    * @throws SystemException if a system exception occurred
    */
    public void removeByFilename(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f file storages where filename LIKE &#63; from the database.
    *
    * @param filename the filename
    * @throws SystemException if a system exception occurred
    */
    public void removeByDirectory(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f file storages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f file storages where filename = &#63;.
    *
    * @param filename the filename
    * @return the number of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public int countByFilename(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f file storages where filename LIKE &#63;.
    *
    * @param filename the filename
    * @return the number of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public int countByDirectory(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f file storages.
    *
    * @return the number of l f file storages
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
