package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f package grade storage service. This utility wraps {@link LFPackageGradeStoragePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageGradeStoragePersistence
 * @see LFPackageGradeStoragePersistenceImpl
 * @generated
 */
public class LFPackageGradeStorageUtil {
    private static LFPackageGradeStoragePersistence _persistence;

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
    public static void clearCache(LFPackageGradeStorage lfPackageGradeStorage) {
        getPersistence().clearCache(lfPackageGradeStorage);
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
    public static List<LFPackageGradeStorage> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFPackageGradeStorage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFPackageGradeStorage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFPackageGradeStorage update(
        LFPackageGradeStorage lfPackageGradeStorage) throws SystemException {
        return getPersistence().update(lfPackageGradeStorage);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFPackageGradeStorage update(
        LFPackageGradeStorage lfPackageGradeStorage,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfPackageGradeStorage, serviceContext);
    }

    /**
    * Returns the l f package grade storage where userId = &#63; and packageId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException} if it could not be found.
    *
    * @param userId the user ID
    * @param packageId the package ID
    * @return the matching l f package grade storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException if a matching l f package grade storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage findByGrade(
        java.lang.Long userId, java.lang.Long packageId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGrade(userId, packageId);
    }

    /**
    * Returns the l f package grade storage where userId = &#63; and packageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param userId the user ID
    * @param packageId the package ID
    * @return the matching l f package grade storage, or <code>null</code> if a matching l f package grade storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage fetchByGrade(
        java.lang.Long userId, java.lang.Long packageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGrade(userId, packageId);
    }

    /**
    * Returns the l f package grade storage where userId = &#63; and packageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param userId the user ID
    * @param packageId the package ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f package grade storage, or <code>null</code> if a matching l f package grade storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage fetchByGrade(
        java.lang.Long userId, java.lang.Long packageId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGrade(userId, packageId, retrieveFromCache);
    }

    /**
    * Removes the l f package grade storage where userId = &#63; and packageId = &#63; from the database.
    *
    * @param userId the user ID
    * @param packageId the package ID
    * @return the l f package grade storage that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage removeByGrade(
        java.lang.Long userId, java.lang.Long packageId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByGrade(userId, packageId);
    }

    /**
    * Returns the number of l f package grade storages where userId = &#63; and packageId = &#63;.
    *
    * @param userId the user ID
    * @param packageId the package ID
    * @return the number of matching l f package grade storages
    * @throws SystemException if a system exception occurred
    */
    public static int countByGrade(java.lang.Long userId,
        java.lang.Long packageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGrade(userId, packageId);
    }

    /**
    * Caches the l f package grade storage in the entity cache if it is enabled.
    *
    * @param lfPackageGradeStorage the l f package grade storage
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage lfPackageGradeStorage) {
        getPersistence().cacheResult(lfPackageGradeStorage);
    }

    /**
    * Caches the l f package grade storages in the entity cache if it is enabled.
    *
    * @param lfPackageGradeStorages the l f package grade storages
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage> lfPackageGradeStorages) {
        getPersistence().cacheResult(lfPackageGradeStorages);
    }

    /**
    * Creates a new l f package grade storage with the primary key. Does not add the l f package grade storage to the database.
    *
    * @param lfPackageGradeStoragePK the primary key for the new l f package grade storage
    * @return the new l f package grade storage
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage create(
        LFPackageGradeStoragePK lfPackageGradeStoragePK) {
        return getPersistence().create(lfPackageGradeStoragePK);
    }

    /**
    * Removes the l f package grade storage with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfPackageGradeStoragePK the primary key of the l f package grade storage
    * @return the l f package grade storage that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException if a l f package grade storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage remove(
        LFPackageGradeStoragePK lfPackageGradeStoragePK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(lfPackageGradeStoragePK);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage lfPackageGradeStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfPackageGradeStorage);
    }

    /**
    * Returns the l f package grade storage with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException} if it could not be found.
    *
    * @param lfPackageGradeStoragePK the primary key of the l f package grade storage
    * @return the l f package grade storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException if a l f package grade storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage findByPrimaryKey(
        LFPackageGradeStoragePK lfPackageGradeStoragePK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(lfPackageGradeStoragePK);
    }

    /**
    * Returns the l f package grade storage with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfPackageGradeStoragePK the primary key of the l f package grade storage
    * @return the l f package grade storage, or <code>null</code> if a l f package grade storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage fetchByPrimaryKey(
        LFPackageGradeStoragePK lfPackageGradeStoragePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(lfPackageGradeStoragePK);
    }

    /**
    * Returns all the l f package grade storages.
    *
    * @return the l f package grade storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f package grade storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageGradeStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f package grade storages
    * @param end the upper bound of the range of l f package grade storages (not inclusive)
    * @return the range of l f package grade storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f package grade storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageGradeStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f package grade storages
    * @param end the upper bound of the range of l f package grade storages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f package grade storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f package grade storages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f package grade storages.
    *
    * @return the number of l f package grade storages
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFPackageGradeStoragePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFPackageGradeStoragePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFPackageGradeStoragePersistence.class.getName());

            ReferenceRegistry.registerReference(LFPackageGradeStorageUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFPackageGradeStoragePersistence persistence) {
    }
}
