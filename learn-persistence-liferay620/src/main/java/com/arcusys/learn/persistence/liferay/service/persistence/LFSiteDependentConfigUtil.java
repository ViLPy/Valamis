package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f site dependent config service. This utility wraps {@link LFSiteDependentConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSiteDependentConfigPersistence
 * @see LFSiteDependentConfigPersistenceImpl
 * @generated
 */
public class LFSiteDependentConfigUtil {
    private static LFSiteDependentConfigPersistence _persistence;

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
    public static void clearCache(LFSiteDependentConfig lfSiteDependentConfig) {
        getPersistence().clearCache(lfSiteDependentConfig);
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
    public static List<LFSiteDependentConfig> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFSiteDependentConfig> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFSiteDependentConfig> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFSiteDependentConfig update(
        LFSiteDependentConfig lfSiteDependentConfig) throws SystemException {
        return getPersistence().update(lfSiteDependentConfig);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFSiteDependentConfig update(
        LFSiteDependentConfig lfSiteDependentConfig,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfSiteDependentConfig, serviceContext);
    }

    /**
    * Returns all the l f site dependent configs where siteID = &#63;.
    *
    * @param siteID the site i d
    * @return the matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findBySiteID(
        java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySiteID(siteID);
    }

    /**
    * Returns a range of all the l f site dependent configs where siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param siteID the site i d
    * @param start the lower bound of the range of l f site dependent configs
    * @param end the upper bound of the range of l f site dependent configs (not inclusive)
    * @return the range of matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findBySiteID(
        java.lang.Integer siteID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySiteID(siteID, start, end);
    }

    /**
    * Returns an ordered range of all the l f site dependent configs where siteID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param siteID the site i d
    * @param start the lower bound of the range of l f site dependent configs
    * @param end the upper bound of the range of l f site dependent configs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findBySiteID(
        java.lang.Integer siteID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySiteID(siteID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f site dependent config in the ordered set where siteID = &#63;.
    *
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findBySiteID_First(
        java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySiteID_First(siteID, orderByComparator);
    }

    /**
    * Returns the first l f site dependent config in the ordered set where siteID = &#63;.
    *
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchBySiteID_First(
        java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBySiteID_First(siteID, orderByComparator);
    }

    /**
    * Returns the last l f site dependent config in the ordered set where siteID = &#63;.
    *
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findBySiteID_Last(
        java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySiteID_Last(siteID, orderByComparator);
    }

    /**
    * Returns the last l f site dependent config in the ordered set where siteID = &#63;.
    *
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchBySiteID_Last(
        java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBySiteID_Last(siteID, orderByComparator);
    }

    /**
    * Returns the l f site dependent configs before and after the current l f site dependent config in the ordered set where siteID = &#63;.
    *
    * @param id the primary key of the current l f site dependent config
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig[] findBySiteID_PrevAndNext(
        long id, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySiteID_PrevAndNext(id, siteID, orderByComparator);
    }

    /**
    * Removes all the l f site dependent configs where siteID = &#63; from the database.
    *
    * @param siteID the site i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySiteID(java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySiteID(siteID);
    }

    /**
    * Returns the number of l f site dependent configs where siteID = &#63;.
    *
    * @param siteID the site i d
    * @return the number of matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static int countBySiteID(java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySiteID(siteID);
    }

    /**
    * Returns the l f site dependent config where siteID = &#63; and dataKey = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException} if it could not be found.
    *
    * @param siteID the site i d
    * @param dataKey the data key
    * @return the matching l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findBySiteIDAndDataKey(
        java.lang.Integer siteID, java.lang.String dataKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySiteIDAndDataKey(siteID, dataKey);
    }

    /**
    * Returns the l f site dependent config where siteID = &#63; and dataKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param siteID the site i d
    * @param dataKey the data key
    * @return the matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchBySiteIDAndDataKey(
        java.lang.Integer siteID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBySiteIDAndDataKey(siteID, dataKey);
    }

    /**
    * Returns the l f site dependent config where siteID = &#63; and dataKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param siteID the site i d
    * @param dataKey the data key
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchBySiteIDAndDataKey(
        java.lang.Integer siteID, java.lang.String dataKey,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySiteIDAndDataKey(siteID, dataKey, retrieveFromCache);
    }

    /**
    * Removes the l f site dependent config where siteID = &#63; and dataKey = &#63; from the database.
    *
    * @param siteID the site i d
    * @param dataKey the data key
    * @return the l f site dependent config that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig removeBySiteIDAndDataKey(
        java.lang.Integer siteID, java.lang.String dataKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeBySiteIDAndDataKey(siteID, dataKey);
    }

    /**
    * Returns the number of l f site dependent configs where siteID = &#63; and dataKey = &#63;.
    *
    * @param siteID the site i d
    * @param dataKey the data key
    * @return the number of matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static int countBySiteIDAndDataKey(java.lang.Integer siteID,
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySiteIDAndDataKey(siteID, dataKey);
    }

    /**
    * Returns all the l f site dependent configs where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @return the matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findByDataKey(
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataKey(dataKey);
    }

    /**
    * Returns a range of all the l f site dependent configs where dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataKey the data key
    * @param start the lower bound of the range of l f site dependent configs
    * @param end the upper bound of the range of l f site dependent configs (not inclusive)
    * @return the range of matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findByDataKey(
        java.lang.String dataKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataKey(dataKey, start, end);
    }

    /**
    * Returns an ordered range of all the l f site dependent configs where dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataKey the data key
    * @param start the lower bound of the range of l f site dependent configs
    * @param end the upper bound of the range of l f site dependent configs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findByDataKey(
        java.lang.String dataKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDataKey(dataKey, start, end, orderByComparator);
    }

    /**
    * Returns the first l f site dependent config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findByDataKey_First(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataKey_First(dataKey, orderByComparator);
    }

    /**
    * Returns the first l f site dependent config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchByDataKey_First(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByDataKey_First(dataKey, orderByComparator);
    }

    /**
    * Returns the last l f site dependent config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findByDataKey_Last(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataKey_Last(dataKey, orderByComparator);
    }

    /**
    * Returns the last l f site dependent config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchByDataKey_Last(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByDataKey_Last(dataKey, orderByComparator);
    }

    /**
    * Returns the l f site dependent configs before and after the current l f site dependent config in the ordered set where dataKey = &#63;.
    *
    * @param id the primary key of the current l f site dependent config
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig[] findByDataKey_PrevAndNext(
        long id, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDataKey_PrevAndNext(id, dataKey, orderByComparator);
    }

    /**
    * Removes all the l f site dependent configs where dataKey = &#63; from the database.
    *
    * @param dataKey the data key
    * @throws SystemException if a system exception occurred
    */
    public static void removeByDataKey(java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByDataKey(dataKey);
    }

    /**
    * Returns the number of l f site dependent configs where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @return the number of matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static int countByDataKey(java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByDataKey(dataKey);
    }

    /**
    * Caches the l f site dependent config in the entity cache if it is enabled.
    *
    * @param lfSiteDependentConfig the l f site dependent config
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig lfSiteDependentConfig) {
        getPersistence().cacheResult(lfSiteDependentConfig);
    }

    /**
    * Caches the l f site dependent configs in the entity cache if it is enabled.
    *
    * @param lfSiteDependentConfigs the l f site dependent configs
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> lfSiteDependentConfigs) {
        getPersistence().cacheResult(lfSiteDependentConfigs);
    }

    /**
    * Creates a new l f site dependent config with the primary key. Does not add the l f site dependent config to the database.
    *
    * @param id the primary key for the new l f site dependent config
    * @return the new l f site dependent config
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f site dependent config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f site dependent config
    * @return the l f site dependent config that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig lfSiteDependentConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfSiteDependentConfig);
    }

    /**
    * Returns the l f site dependent config with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException} if it could not be found.
    *
    * @param id the primary key of the l f site dependent config
    * @return the l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f site dependent config with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f site dependent config
    * @return the l f site dependent config, or <code>null</code> if a l f site dependent config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f site dependent configs.
    *
    * @return the l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f site dependent configs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f site dependent configs
    * @param end the upper bound of the range of l f site dependent configs (not inclusive)
    * @return the range of l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f site dependent configs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f site dependent configs
    * @param end the upper bound of the range of l f site dependent configs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f site dependent configs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f site dependent configs.
    *
    * @return the number of l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFSiteDependentConfigPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFSiteDependentConfigPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFSiteDependentConfigPersistence.class.getName());

            ReferenceRegistry.registerReference(LFSiteDependentConfigUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFSiteDependentConfigPersistence persistence) {
    }
}
