package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPackageVote;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f package vote service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageVotePersistenceImpl
 * @see LFPackageVoteUtil
 * @generated
 */
public interface LFPackageVotePersistence extends BasePersistence<LFPackageVote> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFPackageVoteUtil} to access the l f package vote persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f package vote in the entity cache if it is enabled.
    *
    * @param lfPackageVote the l f package vote
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFPackageVote lfPackageVote);

    /**
    * Caches the l f package votes in the entity cache if it is enabled.
    *
    * @param lfPackageVotes the l f package votes
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> lfPackageVotes);

    /**
    * Creates a new l f package vote with the primary key. Does not add the l f package vote to the database.
    *
    * @param id the primary key for the new l f package vote
    * @return the new l f package vote
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageVote create(
        long id);

    /**
    * Removes the l f package vote with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f package vote
    * @return the l f package vote that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a l f package vote with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageVote remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFPackageVote updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPackageVote lfPackageVote,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package vote with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException} if it could not be found.
    *
    * @param id the primary key of the l f package vote
    * @return the l f package vote
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a l f package vote with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageVote findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package vote with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f package vote
    * @return the l f package vote, or <code>null</code> if a l f package vote with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageVote fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f package votes where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @return the matching l f package votes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findBySocialPackageID(
        java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f package votes where socialPackageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param socialPackageID the social package i d
    * @param start the lower bound of the range of l f package votes
    * @param end the upper bound of the range of l f package votes (not inclusive)
    * @return the range of matching l f package votes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findBySocialPackageID(
        java.lang.Integer socialPackageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f package votes where socialPackageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param socialPackageID the social package i d
    * @param start the lower bound of the range of l f package votes
    * @param end the upper bound of the range of l f package votes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f package votes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findBySocialPackageID(
        java.lang.Integer socialPackageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f package vote in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package vote
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a matching l f package vote could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageVote findBySocialPackageID_First(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f package vote in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package vote, or <code>null</code> if a matching l f package vote could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageVote fetchBySocialPackageID_First(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f package vote in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package vote
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a matching l f package vote could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageVote findBySocialPackageID_Last(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f package vote in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package vote, or <code>null</code> if a matching l f package vote could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageVote fetchBySocialPackageID_Last(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package votes before and after the current l f package vote in the ordered set where socialPackageID = &#63;.
    *
    * @param id the primary key of the current l f package vote
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f package vote
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a l f package vote with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageVote[] findBySocialPackageID_PrevAndNext(
        long id, java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f package votes.
    *
    * @return the l f package votes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f package votes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f package votes
    * @param end the upper bound of the range of l f package votes (not inclusive)
    * @return the range of l f package votes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f package votes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f package votes
    * @param end the upper bound of the range of l f package votes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f package votes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f package votes where socialPackageID = &#63; from the database.
    *
    * @param socialPackageID the social package i d
    * @throws SystemException if a system exception occurred
    */
    public void removeBySocialPackageID(java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f package votes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f package votes where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @return the number of matching l f package votes
    * @throws SystemException if a system exception occurred
    */
    public int countBySocialPackageID(java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f package votes.
    *
    * @return the number of l f package votes
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
