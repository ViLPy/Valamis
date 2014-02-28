package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRollupContribution;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f rollup contribution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRollupContributionPersistenceImpl
 * @see LFRollupContributionUtil
 * @generated
 */
public interface LFRollupContributionPersistence extends BasePersistence<LFRollupContribution> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFRollupContributionUtil} to access the l f rollup contribution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the l f rollup contribution where sequencingID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException} if it could not be found.
    *
    * @param sequencingID the sequencing i d
    * @return the matching l f rollup contribution
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a matching l f rollup contribution could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f rollup contribution where sequencingID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param sequencingID the sequencing i d
    * @return the matching l f rollup contribution, or <code>null</code> if a matching l f rollup contribution could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution fetchBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f rollup contribution where sequencingID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param sequencingID the sequencing i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f rollup contribution, or <code>null</code> if a matching l f rollup contribution could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution fetchBySequencingID(
        java.lang.Integer sequencingID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f rollup contribution where sequencingID = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @return the l f rollup contribution that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution removeBySequencingID(
        java.lang.Integer sequencingID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f rollup contributions where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the number of matching l f rollup contributions
    * @throws SystemException if a system exception occurred
    */
    public int countBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f rollup contribution in the entity cache if it is enabled.
    *
    * @param lfRollupContribution the l f rollup contribution
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFRollupContribution lfRollupContribution);

    /**
    * Caches the l f rollup contributions in the entity cache if it is enabled.
    *
    * @param lfRollupContributions the l f rollup contributions
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupContribution> lfRollupContributions);

    /**
    * Creates a new l f rollup contribution with the primary key. Does not add the l f rollup contribution to the database.
    *
    * @param id the primary key for the new l f rollup contribution
    * @return the new l f rollup contribution
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution create(
        long id);

    /**
    * Removes the l f rollup contribution with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f rollup contribution
    * @return the l f rollup contribution that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a l f rollup contribution with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRollupContribution lfRollupContribution)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f rollup contribution with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException} if it could not be found.
    *
    * @param id the primary key of the l f rollup contribution
    * @return the l f rollup contribution
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a l f rollup contribution with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f rollup contribution with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f rollup contribution
    * @return the l f rollup contribution, or <code>null</code> if a l f rollup contribution with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f rollup contributions.
    *
    * @return the l f rollup contributions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupContribution> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f rollup contributions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupContributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f rollup contributions
    * @param end the upper bound of the range of l f rollup contributions (not inclusive)
    * @return the range of l f rollup contributions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupContribution> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f rollup contributions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupContributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f rollup contributions
    * @param end the upper bound of the range of l f rollup contributions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f rollup contributions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupContribution> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f rollup contributions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f rollup contributions.
    *
    * @return the number of l f rollup contributions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
