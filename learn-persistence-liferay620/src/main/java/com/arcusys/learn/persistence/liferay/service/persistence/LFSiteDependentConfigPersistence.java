package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f site dependent config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSiteDependentConfigPersistenceImpl
 * @see LFSiteDependentConfigUtil
 * @generated
 */
public interface LFSiteDependentConfigPersistence extends BasePersistence<LFSiteDependentConfig> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFSiteDependentConfigUtil} to access the l f site dependent config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f site dependent configs where siteID = &#63;.
    *
    * @param siteID the site i d
    * @return the matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findBySiteID(
        java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findBySiteID(
        java.lang.Integer siteID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findBySiteID(
        java.lang.Integer siteID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f site dependent config in the ordered set where siteID = &#63;.
    *
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findBySiteID_First(
        java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f site dependent config in the ordered set where siteID = &#63;.
    *
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchBySiteID_First(
        java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f site dependent config in the ordered set where siteID = &#63;.
    *
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findBySiteID_Last(
        java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f site dependent config in the ordered set where siteID = &#63;.
    *
    * @param siteID the site i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchBySiteID_Last(
        java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig[] findBySiteID_PrevAndNext(
        long id, java.lang.Integer siteID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f site dependent configs where siteID = &#63; from the database.
    *
    * @param siteID the site i d
    * @throws SystemException if a system exception occurred
    */
    public void removeBySiteID(java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f site dependent configs where siteID = &#63;.
    *
    * @param siteID the site i d
    * @return the number of matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public int countBySiteID(java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f site dependent config where siteID = &#63; and dataKey = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException} if it could not be found.
    *
    * @param siteID the site i d
    * @param dataKey the data key
    * @return the matching l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findBySiteIDAndDataKey(
        java.lang.Integer siteID, java.lang.String dataKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f site dependent config where siteID = &#63; and dataKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param siteID the site i d
    * @param dataKey the data key
    * @return the matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchBySiteIDAndDataKey(
        java.lang.Integer siteID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f site dependent config where siteID = &#63; and dataKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param siteID the site i d
    * @param dataKey the data key
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchBySiteIDAndDataKey(
        java.lang.Integer siteID, java.lang.String dataKey,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f site dependent config where siteID = &#63; and dataKey = &#63; from the database.
    *
    * @param siteID the site i d
    * @param dataKey the data key
    * @return the l f site dependent config that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig removeBySiteIDAndDataKey(
        java.lang.Integer siteID, java.lang.String dataKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f site dependent configs where siteID = &#63; and dataKey = &#63;.
    *
    * @param siteID the site i d
    * @param dataKey the data key
    * @return the number of matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public int countBySiteIDAndDataKey(java.lang.Integer siteID,
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f site dependent configs where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @return the matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findByDataKey(
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findByDataKey(
        java.lang.String dataKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findByDataKey(
        java.lang.String dataKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f site dependent config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findByDataKey_First(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f site dependent config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchByDataKey_First(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f site dependent config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findByDataKey_Last(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f site dependent config in the ordered set where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchByDataKey_Last(
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig[] findByDataKey_PrevAndNext(
        long id, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f site dependent configs where dataKey = &#63; from the database.
    *
    * @param dataKey the data key
    * @throws SystemException if a system exception occurred
    */
    public void removeByDataKey(java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f site dependent configs where dataKey = &#63;.
    *
    * @param dataKey the data key
    * @return the number of matching l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public int countByDataKey(java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f site dependent config in the entity cache if it is enabled.
    *
    * @param lfSiteDependentConfig the l f site dependent config
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig lfSiteDependentConfig);

    /**
    * Caches the l f site dependent configs in the entity cache if it is enabled.
    *
    * @param lfSiteDependentConfigs the l f site dependent configs
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> lfSiteDependentConfigs);

    /**
    * Creates a new l f site dependent config with the primary key. Does not add the l f site dependent config to the database.
    *
    * @param id the primary key for the new l f site dependent config
    * @return the new l f site dependent config
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig create(
        long id);

    /**
    * Removes the l f site dependent config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f site dependent config
    * @return the l f site dependent config that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig lfSiteDependentConfig)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f site dependent config with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException} if it could not be found.
    *
    * @param id the primary key of the l f site dependent config
    * @return the l f site dependent config
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f site dependent config with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f site dependent config
    * @return the l f site dependent config, or <code>null</code> if a l f site dependent config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f site dependent configs.
    *
    * @return the l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f site dependent configs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f site dependent configs.
    *
    * @return the number of l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
