package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSettings;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f settings service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSettingsPersistenceImpl
 * @see LFSettingsUtil
 * @generated
 */
public interface LFSettingsPersistence extends BasePersistence<LFSettings> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFSettingsUtil} to access the l f settings persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f settings in the entity cache if it is enabled.
    *
    * @param lfSettings the l f settings
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings);

    /**
    * Caches the l f settingses in the entity cache if it is enabled.
    *
    * @param lfSettingses the l f settingses
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSettings> lfSettingses);

    /**
    * Creates a new l f settings with the primary key. Does not add the l f settings to the database.
    *
    * @param id the primary key for the new l f settings
    * @return the new l f settings
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings create(
        long id);

    /**
    * Removes the l f settings with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f settings
    * @return the l f settings that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException if a l f settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFSettings updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f settings with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException} if it could not be found.
    *
    * @param id the primary key of the l f settings
    * @return the l f settings
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException if a l f settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f settings with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f settings
    * @return the l f settings, or <code>null</code> if a l f settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f settings where key = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException} if it could not be found.
    *
    * @param key the key
    * @return the matching l f settings
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException if a matching l f settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings findByKey(
        java.lang.String key)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f settings where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param key the key
    * @return the matching l f settings, or <code>null</code> if a matching l f settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings fetchByKey(
        java.lang.String key)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f settings where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param key the key
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f settings, or <code>null</code> if a matching l f settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings fetchByKey(
        java.lang.String key, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f settingses.
    *
    * @return the l f settingses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSettings> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSettings> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSettings> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f settings where key = &#63; from the database.
    *
    * @param key the key
    * @return the l f settings that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings removeByKey(
        java.lang.String key)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f settingses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f settingses where key = &#63;.
    *
    * @param key the key
    * @return the number of matching l f settingses
    * @throws SystemException if a system exception occurred
    */
    public int countByKey(java.lang.String key)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f settingses.
    *
    * @return the number of l f settingses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
