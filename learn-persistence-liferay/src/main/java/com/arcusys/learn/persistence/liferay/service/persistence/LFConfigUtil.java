package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFConfig;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f config service. This utility wraps {@link LFConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFConfigPersistence
 * @see LFConfigPersistenceImpl
 * @generated
 */
public class LFConfigUtil {
    private static LFConfigPersistence _persistence;

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
    public static void clearCache(LFConfig lfConfig) {
        getPersistence().clearCache(lfConfig);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFConfig> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFConfig> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFConfig> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFConfig update(LFConfig lfConfig, boolean merge)
        throws SystemException {
        return getPersistence().update(lfConfig, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFConfig update(LFConfig lfConfig, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfConfig, merge, serviceContext);
    }

    /**
    * Caches the l f config in the entity cache if it is enabled.
    *
    * @param lfConfig the l f config
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFConfig lfConfig) {
        getPersistence().cacheResult(lfConfig);
    }

    /**
    * Caches the l f configs in the entity cache if it is enabled.
    *
    * @param lfConfigs the l f configs
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> lfConfigs) {
        getPersistence().cacheResult(lfConfigs);
    }

    /**
    * Creates a new l f config with the primary key. Does not add the l f config to the database.
    *
    * @param id the primary key for the new l f config
    * @return the new l f config
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConfig create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f config
    * @return the l f config that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a l f config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConfig remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFConfig updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFConfig lfConfig,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfConfig, merge);
    }

    /**
    * Returns the l f config with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFConfigException} if it could not be found.
    *
    * @param id the primary key of the l f config
    * @return the l f config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a l f config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConfig findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f config with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f config
    * @return the l f config, or <code>null</code> if a l f config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConfig fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f configs where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @return the matching l f configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findByDataKey(
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataKey(dataKey);
    }

    /**
    * Returns a range of all the l f configs where dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dataKey the data key
    * @param start the lower bound of the range of l f configs
    * @param end the upper bound of the range of l f configs (not inclusive)
    * @return the range of matching l f configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findByDataKey(
        java.lang.String dataKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataKey(dataKey, start, end);
    }

    /**
    * Returns an ordered range of all the l f configs where dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dataKey the data key
    * @param start the lower bound of the range of l f configs
    * @param end the upper bound of the range of l f configs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findByDataKey(
        java.lang.String dataKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDataKey(dataKey, start, end, orderByComparator);
    }

    /**
    * Returns the first l f config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a matching l f config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConfig findByDataKey_First(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataKey_First(dataKey, orderByComparator);
    }

    /**
    * Returns the first l f config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f config, or <code>null</code> if a matching l f config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConfig fetchByDataKey_First(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByDataKey_First(dataKey, orderByComparator);
    }

    /**
    * Returns the last l f config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a matching l f config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConfig findByDataKey_Last(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataKey_Last(dataKey, orderByComparator);
    }

    /**
    * Returns the last l f config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f config, or <code>null</code> if a matching l f config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConfig fetchByDataKey_Last(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByDataKey_Last(dataKey, orderByComparator);
    }

    /**
    * Returns the l f configs before and after the current l f config in the ordered set where dataKey = &#63;.
    *
    * @param id the primary key of the current l f config
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a l f config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConfig[] findByDataKey_PrevAndNext(
        long id, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDataKey_PrevAndNext(id, dataKey, orderByComparator);
    }

    /**
    * Returns all the l f configs.
    *
    * @return the l f configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f configs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f configs
    * @param end the upper bound of the range of l f configs (not inclusive)
    * @return the range of l f configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f configs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f configs
    * @param end the upper bound of the range of l f configs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f configs where dataKey = &#63; from the database.
    *
    * @param dataKey the data key
    * @throws SystemException if a system exception occurred
    */
    public static void removeByDataKey(java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByDataKey(dataKey);
    }

    /**
    * Removes all the l f configs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f configs where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @return the number of matching l f configs
    * @throws SystemException if a system exception occurred
    */
    public static int countByDataKey(java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByDataKey(dataKey);
    }

    /**
    * Returns the number of l f configs.
    *
    * @return the number of l f configs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFConfigPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFConfigPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFConfigPersistence.class.getName());

            ReferenceRegistry.registerReference(LFConfigUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFConfigPersistence persistence) {
    }
}
