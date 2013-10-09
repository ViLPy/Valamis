package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSettings;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f settings service. This utility wraps {@link LFSettingsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSettingsPersistence
 * @see LFSettingsPersistenceImpl
 * @generated
 */
public class LFSettingsUtil {
    private static LFSettingsPersistence _persistence;

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
    public static void clearCache(LFSettings lfSettings) {
        getPersistence().clearCache(lfSettings);
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
    public static List<LFSettings> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFSettings> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFSettings> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFSettings update(LFSettings lfSettings, boolean merge)
        throws SystemException {
        return getPersistence().update(lfSettings, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFSettings update(LFSettings lfSettings, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfSettings, merge, serviceContext);
    }

    /**
    * Caches the l f settings in the entity cache if it is enabled.
    *
    * @param lfSettings the l f settings
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings) {
        getPersistence().cacheResult(lfSettings);
    }

    /**
    * Caches the l f settingses in the entity cache if it is enabled.
    *
    * @param lfSettingses the l f settingses
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSettings> lfSettingses) {
        getPersistence().cacheResult(lfSettingses);
    }

    /**
    * Creates a new l f settings with the primary key. Does not add the l f settings to the database.
    *
    * @param id the primary key for the new l f settings
    * @return the new l f settings
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f settings with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f settings
    * @return the l f settings that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException if a l f settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSettings updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfSettings, merge);
    }

    /**
    * Returns the l f settings with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException} if it could not be found.
    *
    * @param id the primary key of the l f settings
    * @return the l f settings
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException if a l f settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f settings with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f settings
    * @return the l f settings, or <code>null</code> if a l f settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns the l f settings where key = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException} if it could not be found.
    *
    * @param key the key
    * @return the matching l f settings
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException if a matching l f settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings findByKey(
        java.lang.String key)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByKey(key);
    }

    /**
    * Returns the l f settings where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param key the key
    * @return the matching l f settings, or <code>null</code> if a matching l f settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings fetchByKey(
        java.lang.String key)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKey(key);
    }

    /**
    * Returns the l f settings where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param key the key
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f settings, or <code>null</code> if a matching l f settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings fetchByKey(
        java.lang.String key, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKey(key, retrieveFromCache);
    }

    /**
    * Returns all the l f settingses.
    *
    * @return the l f settingses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSettings> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f settingses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f settingses
    * @param end the upper bound of the range of l f settingses (not inclusive)
    * @return the range of l f settingses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSettings> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f settingses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f settingses
    * @param end the upper bound of the range of l f settingses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f settingses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSettings> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes the l f settings where key = &#63; from the database.
    *
    * @param key the key
    * @return the l f settings that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings removeByKey(
        java.lang.String key)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByKey(key);
    }

    /**
    * Removes all the l f settingses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f settingses where key = &#63;.
    *
    * @param key the key
    * @return the number of matching l f settingses
    * @throws SystemException if a system exception occurred
    */
    public static int countByKey(java.lang.String key)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByKey(key);
    }

    /**
    * Returns the number of l f settingses.
    *
    * @return the number of l f settingses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFSettingsPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFSettingsPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFSettingsPersistence.class.getName());

            ReferenceRegistry.registerReference(LFSettingsUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFSettingsPersistence persistence) {
    }
}
