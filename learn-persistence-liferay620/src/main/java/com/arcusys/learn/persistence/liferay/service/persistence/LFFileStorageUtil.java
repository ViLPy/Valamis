package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFFileStorage;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f file storage service. This utility wraps {@link LFFileStoragePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFFileStoragePersistence
 * @see LFFileStoragePersistenceImpl
 * @generated
 */
public class LFFileStorageUtil {
    private static LFFileStoragePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(LFFileStorage lfFileStorage) {
        getPersistence().clearCache(lfFileStorage);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFFileStorage> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFFileStorage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFFileStorage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFFileStorage update(LFFileStorage lfFileStorage)
        throws SystemException {
        return getPersistence().update(lfFileStorage);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFFileStorage update(LFFileStorage lfFileStorage,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfFileStorage, serviceContext);
    }

    /**
    * Returns all the l f file storages where filename = &#63;.
    *
    * @param filename the filename
    * @return the matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
        java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFilename(filename);
    }

    /**
    * Returns a range of all the l f file storages where filename = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param filename the filename
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @return the range of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
        java.lang.String filename, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFilename(filename, start, end);
    }

    /**
    * Returns an ordered range of all the l f file storages where filename = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param filename the filename
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
        java.lang.String filename, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFilename(filename, start, end, orderByComparator);
    }

    /**
    * Returns the first l f file storage in the ordered set where filename = &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage findByFilename_First(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFilename_First(filename, orderByComparator);
    }

    /**
    * Returns the first l f file storage in the ordered set where filename = &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f file storage, or <code>null</code> if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage fetchByFilename_First(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByFilename_First(filename, orderByComparator);
    }

    /**
    * Returns the last l f file storage in the ordered set where filename = &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage findByFilename_Last(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFilename_Last(filename, orderByComparator);
    }

    /**
    * Returns the last l f file storage in the ordered set where filename = &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f file storage, or <code>null</code> if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage fetchByFilename_Last(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByFilename_Last(filename, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage[] findByFilename_PrevAndNext(
        long id, java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFilename_PrevAndNext(id, filename, orderByComparator);
    }

    /**
    * Removes all the l f file storages where filename = &#63; from the database.
    *
    * @param filename the filename
    * @throws SystemException if a system exception occurred
    */
    public static void removeByFilename(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByFilename(filename);
    }

    /**
    * Returns the number of l f file storages where filename = &#63;.
    *
    * @param filename the filename
    * @return the number of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static int countByFilename(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByFilename(filename);
    }

    /**
    * Returns all the l f file storages where filename LIKE &#63;.
    *
    * @param filename the filename
    * @return the matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByDirectory(
        java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDirectory(filename);
    }

    /**
    * Returns a range of all the l f file storages where filename LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param filename the filename
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @return the range of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByDirectory(
        java.lang.String filename, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDirectory(filename, start, end);
    }

    /**
    * Returns an ordered range of all the l f file storages where filename LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param filename the filename
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByDirectory(
        java.lang.String filename, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDirectory(filename, start, end, orderByComparator);
    }

    /**
    * Returns the first l f file storage in the ordered set where filename LIKE &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage findByDirectory_First(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDirectory_First(filename, orderByComparator);
    }

    /**
    * Returns the first l f file storage in the ordered set where filename LIKE &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f file storage, or <code>null</code> if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage fetchByDirectory_First(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDirectory_First(filename, orderByComparator);
    }

    /**
    * Returns the last l f file storage in the ordered set where filename LIKE &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage findByDirectory_Last(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDirectory_Last(filename, orderByComparator);
    }

    /**
    * Returns the last l f file storage in the ordered set where filename LIKE &#63;.
    *
    * @param filename the filename
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f file storage, or <code>null</code> if a matching l f file storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage fetchByDirectory_Last(
        java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDirectory_Last(filename, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage[] findByDirectory_PrevAndNext(
        long id, java.lang.String filename,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDirectory_PrevAndNext(id, filename, orderByComparator);
    }

    /**
    * Removes all the l f file storages where filename LIKE &#63; from the database.
    *
    * @param filename the filename
    * @throws SystemException if a system exception occurred
    */
    public static void removeByDirectory(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByDirectory(filename);
    }

    /**
    * Returns the number of l f file storages where filename LIKE &#63;.
    *
    * @param filename the filename
    * @return the number of matching l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static int countByDirectory(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByDirectory(filename);
    }

    /**
    * Caches the l f file storage in the entity cache if it is enabled.
    *
    * @param lfFileStorage the l f file storage
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFFileStorage lfFileStorage) {
        getPersistence().cacheResult(lfFileStorage);
    }

    /**
    * Caches the l f file storages in the entity cache if it is enabled.
    *
    * @param lfFileStorages the l f file storages
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> lfFileStorages) {
        getPersistence().cacheResult(lfFileStorages);
    }

    /**
    * Creates a new l f file storage with the primary key. Does not add the l f file storage to the database.
    *
    * @param id the primary key for the new l f file storage
    * @return the new l f file storage
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f file storage with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f file storage
    * @return the l f file storage that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a l f file storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFFileStorage lfFileStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfFileStorage);
    }

    /**
    * Returns the l f file storage with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException} if it could not be found.
    *
    * @param id the primary key of the l f file storage
    * @return the l f file storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException if a l f file storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f file storage with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f file storage
    * @return the l f file storage, or <code>null</code> if a l f file storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFFileStorage fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f file storages.
    *
    * @return the l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f file storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @return the range of l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f file storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f file storages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f file storages.
    *
    * @return the number of l f file storages
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFFileStoragePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFFileStoragePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFFileStoragePersistence.class.getName());

            ReferenceRegistry.registerReference(LFFileStorageUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFFileStoragePersistence persistence) {
    }
}
