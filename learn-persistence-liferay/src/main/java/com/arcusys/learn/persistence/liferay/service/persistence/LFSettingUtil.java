package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSetting;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f setting service. This utility wraps {@link LFSettingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSettingPersistence
 * @see LFSettingPersistenceImpl
 * @generated
 */
public class LFSettingUtil {
    private static LFSettingPersistence _persistence;

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
    public static void clearCache(LFSetting lfSetting) {
        getPersistence().clearCache(lfSetting);
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
    public static List<LFSetting> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFSetting> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFSetting> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFSetting update(LFSetting lfSetting, boolean merge)
        throws SystemException {
        return getPersistence().update(lfSetting, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFSetting update(LFSetting lfSetting, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfSetting, merge, serviceContext);
    }

    /**
    * Caches the l f setting in the entity cache if it is enabled.
    *
    * @param lfSetting the l f setting
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSetting lfSetting) {
        getPersistence().cacheResult(lfSetting);
    }

    /**
    * Caches the l f settings in the entity cache if it is enabled.
    *
    * @param lfSettings the l f settings
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSetting> lfSettings) {
        getPersistence().cacheResult(lfSettings);
    }

    /**
    * Creates a new l f setting with the primary key. Does not add the l f setting to the database.
    *
    * @param id the primary key for the new l f setting
    * @return the new l f setting
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSetting create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f setting with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f setting
    * @return the l f setting that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingException if a l f setting with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSetting remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSetting updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSetting lfSetting,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfSetting, merge);
    }

    /**
    * Returns the l f setting with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSettingException} if it could not be found.
    *
    * @param id the primary key of the l f setting
    * @return the l f setting
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingException if a l f setting with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSetting findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f setting with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f setting
    * @return the l f setting, or <code>null</code> if a l f setting with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSetting fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns the l f setting where key = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSettingException} if it could not be found.
    *
    * @param key the key
    * @return the matching l f setting
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingException if a matching l f setting could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSetting findByKey(
        java.lang.String key)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByKey(key);
    }

    /**
    * Returns the l f setting where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param key the key
    * @return the matching l f setting, or <code>null</code> if a matching l f setting could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSetting fetchByKey(
        java.lang.String key)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKey(key);
    }

    /**
    * Returns the l f setting where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param key the key
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f setting, or <code>null</code> if a matching l f setting could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSetting fetchByKey(
        java.lang.String key, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKey(key, retrieveFromCache);
    }

    /**
    * Returns all the l f settings.
    *
    * @return the l f settings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSetting> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f settings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f settings
    * @param end the upper bound of the range of l f settings (not inclusive)
    * @return the range of l f settings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSetting> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f settings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f settings
    * @param end the upper bound of the range of l f settings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f settings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSetting> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes the l f setting where key = &#63; from the database.
    *
    * @param key the key
    * @return the l f setting that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSetting removeByKey(
        java.lang.String key)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByKey(key);
    }

    /**
    * Removes all the l f settings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f settings where key = &#63;.
    *
    * @param key the key
    * @return the number of matching l f settings
    * @throws SystemException if a system exception occurred
    */
    public static int countByKey(java.lang.String key)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByKey(key);
    }

    /**
    * Returns the number of l f settings.
    *
    * @return the number of l f settings
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFSettingPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFSettingPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFSettingPersistence.class.getName());

            ReferenceRegistry.registerReference(LFSettingUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFSettingPersistence persistence) {
    }
}
