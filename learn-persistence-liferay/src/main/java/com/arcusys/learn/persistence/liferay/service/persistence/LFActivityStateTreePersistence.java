package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityStateTree;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f activity state tree service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateTreePersistenceImpl
 * @see LFActivityStateTreeUtil
 * @generated
 */
public interface LFActivityStateTreePersistence extends BasePersistence<LFActivityStateTree> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFActivityStateTreeUtil} to access the l f activity state tree persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f activity state tree in the entity cache if it is enabled.
    *
    * @param lfActivityStateTree the l f activity state tree
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree);

    /**
    * Caches the l f activity state trees in the entity cache if it is enabled.
    *
    * @param lfActivityStateTrees the l f activity state trees
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateTree> lfActivityStateTrees);

    /**
    * Creates a new l f activity state tree with the primary key. Does not add the l f activity state tree to the database.
    *
    * @param id the primary key for the new l f activity state tree
    * @return the new l f activity state tree
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree create(
        long id);

    /**
    * Removes the l f activity state tree with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity state tree with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException} if it could not be found.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity state tree with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree, or <code>null</code> if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity state tree where attemptID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException} if it could not be found.
    *
    * @param attemptID the attempt i d
    * @return the matching l f activity state tree
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a matching l f activity state tree could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree findByAttemptID(
        java.lang.Integer attemptID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity state tree where attemptID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param attemptID the attempt i d
    * @return the matching l f activity state tree, or <code>null</code> if a matching l f activity state tree could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree fetchByAttemptID(
        java.lang.Integer attemptID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity state tree where attemptID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param attemptID the attempt i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f activity state tree, or <code>null</code> if a matching l f activity state tree could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree fetchByAttemptID(
        java.lang.Integer attemptID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity state trees.
    *
    * @return the l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateTree> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity state trees.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activity state trees
    * @param end the upper bound of the range of l f activity state trees (not inclusive)
    * @return the range of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateTree> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity state trees.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activity state trees
    * @param end the upper bound of the range of l f activity state trees (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateTree> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f activity state tree where attemptID = &#63; from the database.
    *
    * @param attemptID the attempt i d
    * @return the l f activity state tree that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree removeByAttemptID(
        java.lang.Integer attemptID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activity state trees from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity state trees where attemptID = &#63;.
    *
    * @param attemptID the attempt i d
    * @return the number of matching l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public int countByAttemptID(java.lang.Integer attemptID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity state trees.
    *
    * @return the number of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
