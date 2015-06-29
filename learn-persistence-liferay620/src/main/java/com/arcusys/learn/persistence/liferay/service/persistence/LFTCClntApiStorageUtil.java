package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f t c clnt api storage service. This utility wraps {@link LFTCClntApiStoragePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTCClntApiStoragePersistence
 * @see LFTCClntApiStoragePersistenceImpl
 * @generated
 */
public class LFTCClntApiStorageUtil {
    private static LFTCClntApiStoragePersistence _persistence;

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
    public static void clearCache(LFTCClntApiStorage lftcClntApiStorage) {
        getPersistence().clearCache(lftcClntApiStorage);
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
    public static List<LFTCClntApiStorage> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTCClntApiStorage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTCClntApiStorage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFTCClntApiStorage update(
        LFTCClntApiStorage lftcClntApiStorage) throws SystemException {
        return getPersistence().update(lftcClntApiStorage);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFTCClntApiStorage update(
        LFTCClntApiStorage lftcClntApiStorage, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lftcClntApiStorage, serviceContext);
    }

    /**
    * Returns the l f t c clnt api storage where token = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException} if it could not be found.
    *
    * @param token the token
    * @return the matching l f t c clnt api storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException if a matching l f t c clnt api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage findByToken(
        java.lang.String token)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByToken(token);
    }

    /**
    * Returns the l f t c clnt api storage where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param token the token
    * @return the matching l f t c clnt api storage, or <code>null</code> if a matching l f t c clnt api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage fetchByToken(
        java.lang.String token)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByToken(token);
    }

    /**
    * Returns the l f t c clnt api storage where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param token the token
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f t c clnt api storage, or <code>null</code> if a matching l f t c clnt api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage fetchByToken(
        java.lang.String token, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByToken(token, retrieveFromCache);
    }

    /**
    * Removes the l f t c clnt api storage where token = &#63; from the database.
    *
    * @param token the token
    * @return the l f t c clnt api storage that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage removeByToken(
        java.lang.String token)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByToken(token);
    }

    /**
    * Returns the number of l f t c clnt api storages where token = &#63;.
    *
    * @param token the token
    * @return the number of matching l f t c clnt api storages
    * @throws SystemException if a system exception occurred
    */
    public static int countByToken(java.lang.String token)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByToken(token);
    }

    /**
    * Returns the l f t c clnt api storage where code = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException} if it could not be found.
    *
    * @param code the code
    * @return the matching l f t c clnt api storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException if a matching l f t c clnt api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage findByCode(
        java.lang.String code)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCode(code);
    }

    /**
    * Returns the l f t c clnt api storage where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param code the code
    * @return the matching l f t c clnt api storage, or <code>null</code> if a matching l f t c clnt api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage fetchByCode(
        java.lang.String code)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCode(code);
    }

    /**
    * Returns the l f t c clnt api storage where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param code the code
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f t c clnt api storage, or <code>null</code> if a matching l f t c clnt api storage could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage fetchByCode(
        java.lang.String code, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCode(code, retrieveFromCache);
    }

    /**
    * Removes the l f t c clnt api storage where code = &#63; from the database.
    *
    * @param code the code
    * @return the l f t c clnt api storage that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage removeByCode(
        java.lang.String code)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByCode(code);
    }

    /**
    * Returns the number of l f t c clnt api storages where code = &#63;.
    *
    * @param code the code
    * @return the number of matching l f t c clnt api storages
    * @throws SystemException if a system exception occurred
    */
    public static int countByCode(java.lang.String code)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCode(code);
    }

    /**
    * Caches the l f t c clnt api storage in the entity cache if it is enabled.
    *
    * @param lftcClntApiStorage the l f t c clnt api storage
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage lftcClntApiStorage) {
        getPersistence().cacheResult(lftcClntApiStorage);
    }

    /**
    * Caches the l f t c clnt api storages in the entity cache if it is enabled.
    *
    * @param lftcClntApiStorages the l f t c clnt api storages
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage> lftcClntApiStorages) {
        getPersistence().cacheResult(lftcClntApiStorages);
    }

    /**
    * Creates a new l f t c clnt api storage with the primary key. Does not add the l f t c clnt api storage to the database.
    *
    * @param id the primary key for the new l f t c clnt api storage
    * @return the new l f t c clnt api storage
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f t c clnt api storage with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f t c clnt api storage
    * @return the l f t c clnt api storage that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException if a l f t c clnt api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage lftcClntApiStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lftcClntApiStorage);
    }

    /**
    * Returns the l f t c clnt api storage with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException} if it could not be found.
    *
    * @param id the primary key of the l f t c clnt api storage
    * @return the l f t c clnt api storage
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException if a l f t c clnt api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f t c clnt api storage with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f t c clnt api storage
    * @return the l f t c clnt api storage, or <code>null</code> if a l f t c clnt api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f t c clnt api storages.
    *
    * @return the l f t c clnt api storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f t c clnt api storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f t c clnt api storages
    * @param end the upper bound of the range of l f t c clnt api storages (not inclusive)
    * @return the range of l f t c clnt api storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f t c clnt api storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f t c clnt api storages
    * @param end the upper bound of the range of l f t c clnt api storages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f t c clnt api storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f t c clnt api storages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f t c clnt api storages.
    *
    * @return the number of l f t c clnt api storages
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTCClntApiStoragePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTCClntApiStoragePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTCClntApiStoragePersistence.class.getName());

            ReferenceRegistry.registerReference(LFTCClntApiStorageUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFTCClntApiStoragePersistence persistence) {
    }
}
