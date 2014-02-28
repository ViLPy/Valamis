package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan manifest act service. This utility wraps {@link LFTincanManifestActPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanManifestActPersistence
 * @see LFTincanManifestActPersistenceImpl
 * @generated
 */
public class LFTincanManifestActUtil {
    private static LFTincanManifestActPersistence _persistence;

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
    public static void clearCache(LFTincanManifestAct lfTincanManifestAct) {
        getPersistence().clearCache(lfTincanManifestAct);
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
    public static List<LFTincanManifestAct> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanManifestAct> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanManifestAct> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFTincanManifestAct update(
        LFTincanManifestAct lfTincanManifestAct) throws SystemException {
        return getPersistence().update(lfTincanManifestAct);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFTincanManifestAct update(
        LFTincanManifestAct lfTincanManifestAct, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfTincanManifestAct, serviceContext);
    }

    /**
    * Returns all the l f tincan manifest acts where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the matching l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findByPackageID(
        java.lang.Long packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPackageID(packageID);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findByPackageID(
        java.lang.Long packageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPackageID(packageID, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findByPackageID(
        java.lang.Long packageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID(packageID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f tincan manifest act in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan manifest act
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct findByPackageID_First(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_First(packageID, orderByComparator);
    }

    /**
    * Returns the first l f tincan manifest act in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct fetchByPackageID_First(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageID_First(packageID, orderByComparator);
    }

    /**
    * Returns the last l f tincan manifest act in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan manifest act
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct findByPackageID_Last(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_Last(packageID, orderByComparator);
    }

    /**
    * Returns the last l f tincan manifest act in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct fetchByPackageID_Last(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageID_Last(packageID, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct[] findByPackageID_PrevAndNext(
        long id, java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_PrevAndNext(id, packageID, orderByComparator);
    }

    /**
    * Removes all the l f tincan manifest acts where packageID = &#63; from the database.
    *
    * @param packageID the package i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPackageID(java.lang.Long packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPackageID(packageID);
    }

    /**
    * Returns the number of l f tincan manifest acts where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the number of matching l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public static int countByPackageID(java.lang.Long packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPackageID(packageID);
    }

    /**
    * Returns the l f tincan manifest act where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException} if it could not be found.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan manifest act
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct findByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTincanID(tincanID);
    }

    /**
    * Returns the l f tincan manifest act where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct fetchByTincanID(
        java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTincanID(tincanID);
    }

    /**
    * Returns the l f tincan manifest act where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param tincanID the tincan i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct fetchByTincanID(
        java.lang.String tincanID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTincanID(tincanID, retrieveFromCache);
    }

    /**
    * Removes the l f tincan manifest act where tincanID = &#63; from the database.
    *
    * @param tincanID the tincan i d
    * @return the l f tincan manifest act that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct removeByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByTincanID(tincanID);
    }

    /**
    * Returns the number of l f tincan manifest acts where tincanID = &#63;.
    *
    * @param tincanID the tincan i d
    * @return the number of matching l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public static int countByTincanID(java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTincanID(tincanID);
    }

    /**
    * Caches the l f tincan manifest act in the entity cache if it is enabled.
    *
    * @param lfTincanManifestAct the l f tincan manifest act
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct lfTincanManifestAct) {
        getPersistence().cacheResult(lfTincanManifestAct);
    }

    /**
    * Caches the l f tincan manifest acts in the entity cache if it is enabled.
    *
    * @param lfTincanManifestActs the l f tincan manifest acts
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> lfTincanManifestActs) {
        getPersistence().cacheResult(lfTincanManifestActs);
    }

    /**
    * Creates a new l f tincan manifest act with the primary key. Does not add the l f tincan manifest act to the database.
    *
    * @param id the primary key for the new l f tincan manifest act
    * @return the new l f tincan manifest act
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f tincan manifest act with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan manifest act
    * @return the l f tincan manifest act that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a l f tincan manifest act with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct lfTincanManifestAct)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanManifestAct);
    }

    /**
    * Returns the l f tincan manifest act with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException} if it could not be found.
    *
    * @param id the primary key of the l f tincan manifest act
    * @return the l f tincan manifest act
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a l f tincan manifest act with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan manifest act with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan manifest act
    * @return the l f tincan manifest act, or <code>null</code> if a l f tincan manifest act with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f tincan manifest acts.
    *
    * @return the l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f tincan manifest acts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan manifest acts.
    *
    * @return the number of l f tincan manifest acts
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanManifestActPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanManifestActPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanManifestActPersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanManifestActUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFTincanManifestActPersistence persistence) {
    }
}
