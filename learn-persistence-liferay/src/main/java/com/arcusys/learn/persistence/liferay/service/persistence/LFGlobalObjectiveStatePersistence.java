package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f global objective state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFGlobalObjectiveStatePersistenceImpl
 * @see LFGlobalObjectiveStateUtil
 * @generated
 */
public interface LFGlobalObjectiveStatePersistence extends BasePersistence<LFGlobalObjectiveState> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFGlobalObjectiveStateUtil} to access the l f global objective state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f global objective states where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @return the matching l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findByTreeID(
        java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f global objective states where treeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlobalObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param treeID the tree i d
    * @param start the lower bound of the range of l f global objective states
    * @param end the upper bound of the range of l f global objective states (not inclusive)
    * @return the range of matching l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findByTreeID(
        java.lang.Integer treeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f global objective states where treeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlobalObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param treeID the tree i d
    * @param start the lower bound of the range of l f global objective states
    * @param end the upper bound of the range of l f global objective states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findByTreeID(
        java.lang.Integer treeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f global objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f global objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState findByTreeID_First(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f global objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchByTreeID_First(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f global objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f global objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState findByTreeID_Last(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f global objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchByTreeID_Last(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f global objective states before and after the current l f global objective state in the ordered set where treeID = &#63;.
    *
    * @param id the primary key of the current l f global objective state
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f global objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a l f global objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState[] findByTreeID_PrevAndNext(
        long id, java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f global objective states where treeID = &#63; from the database.
    *
    * @param treeID the tree i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByTreeID(java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f global objective states where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @return the number of matching l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public int countByTreeID(java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f global objective state where treeID = &#63; and mapKey = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException} if it could not be found.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the matching l f global objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState findByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f global objective state where treeID = &#63; and mapKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f global objective state where treeID = &#63; and mapKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f global objective state where treeID = &#63; and mapKey = &#63; from the database.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the l f global objective state that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState removeByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f global objective states where treeID = &#63; and mapKey = &#63;.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the number of matching l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public int countByTreeIDAndMapKey(java.lang.Integer treeID,
        java.lang.String mapKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f global objective state in the entity cache if it is enabled.
    *
    * @param lfGlobalObjectiveState the l f global objective state
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState);

    /**
    * Caches the l f global objective states in the entity cache if it is enabled.
    *
    * @param lfGlobalObjectiveStates the l f global objective states
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> lfGlobalObjectiveStates);

    /**
    * Creates a new l f global objective state with the primary key. Does not add the l f global objective state to the database.
    *
    * @param id the primary key for the new l f global objective state
    * @return the new l f global objective state
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState create(
        long id);

    /**
    * Removes the l f global objective state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f global objective state
    * @return the l f global objective state that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a l f global objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f global objective state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException} if it could not be found.
    *
    * @param id the primary key of the l f global objective state
    * @return the l f global objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a l f global objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f global objective state with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f global objective state
    * @return the l f global objective state, or <code>null</code> if a l f global objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f global objective states.
    *
    * @return the l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f global objective states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlobalObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f global objective states
    * @param end the upper bound of the range of l f global objective states (not inclusive)
    * @return the range of l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f global objective states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlobalObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f global objective states
    * @param end the upper bound of the range of l f global objective states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f global objective states from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f global objective states.
    *
    * @return the number of l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
