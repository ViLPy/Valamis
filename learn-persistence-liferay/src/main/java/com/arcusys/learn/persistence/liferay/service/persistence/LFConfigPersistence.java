package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFConfig;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFConfigPersistenceImpl
 * @see LFConfigUtil
 * @generated
 */
public interface LFConfigPersistence extends BasePersistence<LFConfig> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFConfigUtil} to access the l f config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f config in the entity cache if it is enabled.
    *
    * @param lfConfig the l f config
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFConfig lfConfig);

    /**
    * Caches the l f configs in the entity cache if it is enabled.
    *
    * @param lfConfigs the l f configs
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> lfConfigs);

    /**
    * Creates a new l f config with the primary key. Does not add the l f config to the database.
    *
    * @param id the primary key for the new l f config
    * @return the new l f config
    */
    public com.arcusys.learn.persistence.liferay.model.LFConfig create(long id);

    /**
    * Removes the l f config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f config
    * @return the l f config that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a l f config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConfig remove(long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFConfig updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFConfig lfConfig,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f config with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFConfigException} if it could not be found.
    *
    * @param id the primary key of the l f config
    * @return the l f config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a l f config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConfig findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f config with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f config
    * @return the l f config, or <code>null</code> if a l f config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConfig fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f configs where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @return the matching l f configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findByDataKey(
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findByDataKey(
        java.lang.String dataKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findByDataKey(
        java.lang.String dataKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a matching l f config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConfig findByDataKey_First(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f config, or <code>null</code> if a matching l f config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConfig fetchByDataKey_First(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a matching l f config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConfig findByDataKey_Last(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f config, or <code>null</code> if a matching l f config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConfig fetchByDataKey_Last(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFConfig[] findByDataKey_PrevAndNext(
        long id, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f configs.
    *
    * @return the l f configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConfig> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f configs where dataKey = &#63; from the database.
    *
    * @param dataKey the data key
    * @throws SystemException if a system exception occurred
    */
    public void removeByDataKey(java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f configs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f configs where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @return the number of matching l f configs
    * @throws SystemException if a system exception occurred
    */
    public int countByDataKey(java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f configs.
    *
    * @return the number of l f configs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
