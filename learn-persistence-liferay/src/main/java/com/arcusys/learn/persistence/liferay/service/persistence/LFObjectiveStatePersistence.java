package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveState;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f objective state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectiveStatePersistenceImpl
 * @see LFObjectiveStateUtil
 * @generated
 */
public interface LFObjectiveStatePersistence extends BasePersistence<LFObjectiveState> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFObjectiveStateUtil} to access the l f objective state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f objective state in the entity cache if it is enabled.
    *
    * @param lfObjectiveState the l f objective state
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveState lfObjectiveState);

    /**
    * Caches the l f objective states in the entity cache if it is enabled.
    *
    * @param lfObjectiveStates the l f objective states
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> lfObjectiveStates);

    /**
    * Creates a new l f objective state with the primary key. Does not add the l f objective state to the database.
    *
    * @param id the primary key for the new l f objective state
    * @return the new l f objective state
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState create(
        long id);

    /**
    * Removes the l f objective state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f objective state
    * @return the l f objective state that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a l f objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveState lfObjectiveState,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f objective state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException} if it could not be found.
    *
    * @param id the primary key of the l f objective state
    * @return the l f objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a l f objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f objective state with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f objective state
    * @return the l f objective state, or <code>null</code> if a l f objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f objective state where mapKey = &#63; and activityStateID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException} if it could not be found.
    *
    * @param mapKey the map key
    * @param activityStateID the activity state i d
    * @return the matching l f objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState findByMapKeyAndActivityStateID(
        java.lang.String mapKey, java.lang.Integer activityStateID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f objective state where mapKey = &#63; and activityStateID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param mapKey the map key
    * @param activityStateID the activity state i d
    * @return the matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState fetchByMapKeyAndActivityStateID(
        java.lang.String mapKey, java.lang.Integer activityStateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f objective state where mapKey = &#63; and activityStateID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param mapKey the map key
    * @param activityStateID the activity state i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState fetchByMapKeyAndActivityStateID(
        java.lang.String mapKey, java.lang.Integer activityStateID,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f objective states where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @return the matching l f objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findByActivityStateID(
        java.lang.Integer activityStateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f objective states where activityStateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param activityStateID the activity state i d
    * @param start the lower bound of the range of l f objective states
    * @param end the upper bound of the range of l f objective states (not inclusive)
    * @return the range of matching l f objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findByActivityStateID(
        java.lang.Integer activityStateID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f objective states where activityStateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param activityStateID the activity state i d
    * @param start the lower bound of the range of l f objective states
    * @param end the upper bound of the range of l f objective states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findByActivityStateID(
        java.lang.Integer activityStateID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f objective state in the ordered set where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState findByActivityStateID_First(
        java.lang.Integer activityStateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f objective state in the ordered set where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState fetchByActivityStateID_First(
        java.lang.Integer activityStateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f objective state in the ordered set where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState findByActivityStateID_Last(
        java.lang.Integer activityStateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f objective state in the ordered set where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState fetchByActivityStateID_Last(
        java.lang.Integer activityStateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f objective states before and after the current l f objective state in the ordered set where activityStateID = &#63;.
    *
    * @param id the primary key of the current l f objective state
    * @param activityStateID the activity state i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a l f objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState[] findByActivityStateID_PrevAndNext(
        long id, java.lang.Integer activityStateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f objective states.
    *
    * @return the l f objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f objective states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f objective states
    * @param end the upper bound of the range of l f objective states (not inclusive)
    * @return the range of l f objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f objective states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f objective states
    * @param end the upper bound of the range of l f objective states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f objective state where mapKey = &#63; and activityStateID = &#63; from the database.
    *
    * @param mapKey the map key
    * @param activityStateID the activity state i d
    * @return the l f objective state that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveState removeByMapKeyAndActivityStateID(
        java.lang.String mapKey, java.lang.Integer activityStateID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f objective states where activityStateID = &#63; from the database.
    *
    * @param activityStateID the activity state i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByActivityStateID(java.lang.Integer activityStateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f objective states from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f objective states where mapKey = &#63; and activityStateID = &#63;.
    *
    * @param mapKey the map key
    * @param activityStateID the activity state i d
    * @return the number of matching l f objective states
    * @throws SystemException if a system exception occurred
    */
    public int countByMapKeyAndActivityStateID(java.lang.String mapKey,
        java.lang.Integer activityStateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f objective states where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @return the number of matching l f objective states
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityStateID(java.lang.Integer activityStateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f objective states.
    *
    * @return the number of l f objective states
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
