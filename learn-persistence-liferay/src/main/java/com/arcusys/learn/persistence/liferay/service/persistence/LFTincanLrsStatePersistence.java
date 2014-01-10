package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsState;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan lrs state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatePersistenceImpl
 * @see LFTincanLrsStateUtil
 * @generated
 */
public interface LFTincanLrsStatePersistence extends BasePersistence<LFTincanLrsState> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanLrsStateUtil} to access the l f tincan lrs state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f tincan lrs state in the entity cache if it is enabled.
    *
    * @param lfTincanLrsState the l f tincan lrs state
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsState lfTincanLrsState);

    /**
    * Caches the l f tincan lrs states in the entity cache if it is enabled.
    *
    * @param lfTincanLrsStates the l f tincan lrs states
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> lfTincanLrsStates);

    /**
    * Creates a new l f tincan lrs state with the primary key. Does not add the l f tincan lrs state to the database.
    *
    * @param id the primary key for the new l f tincan lrs state
    * @return the new l f tincan lrs state
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState create(
        long id);

    /**
    * Removes the l f tincan lrs state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs state
    * @return the l f tincan lrs state that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a l f tincan lrs state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsState lfTincanLrsState,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs state
    * @return the l f tincan lrs state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a l f tincan lrs state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs state with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs state
    * @return the l f tincan lrs state, or <code>null</code> if a l f tincan lrs state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan lrs states where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @return the matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityId(
        java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan lrs states where activityId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param activityId the activity ID
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @return the range of matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityId(
        java.lang.String activityId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan lrs states where activityId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param activityId the activity ID
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityId(
        java.lang.String activityId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan lrs state in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState findByActivityId_First(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan lrs state in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState fetchByActivityId_First(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan lrs state in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState findByActivityId_Last(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan lrs state in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState fetchByActivityId_Last(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs states before and after the current l f tincan lrs state in the ordered set where activityId = &#63;.
    *
    * @param id the primary key of the current l f tincan lrs state
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan lrs state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a l f tincan lrs state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState[] findByActivityId_PrevAndNext(
        long id, java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan lrs states where activityId = &#63; and stateId = &#63;.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @return the matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityIdAndStateId(
        java.lang.String activityId, java.lang.String stateId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan lrs states where activityId = &#63; and stateId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @return the range of matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityIdAndStateId(
        java.lang.String activityId, java.lang.String stateId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan lrs states where activityId = &#63; and stateId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityIdAndStateId(
        java.lang.String activityId, java.lang.String stateId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState findByActivityIdAndStateId_First(
        java.lang.String activityId, java.lang.String stateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState fetchByActivityIdAndStateId_First(
        java.lang.String activityId, java.lang.String stateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState findByActivityIdAndStateId_Last(
        java.lang.String activityId, java.lang.String stateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState fetchByActivityIdAndStateId_Last(
        java.lang.String activityId, java.lang.String stateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs states before and after the current l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
    *
    * @param id the primary key of the current l f tincan lrs state
    * @param activityId the activity ID
    * @param stateId the state ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan lrs state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a l f tincan lrs state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState[] findByActivityIdAndStateId_PrevAndNext(
        long id, java.lang.String activityId, java.lang.String stateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan lrs states.
    *
    * @return the l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan lrs states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @return the range of l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan lrs states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan lrs states where activityId = &#63; from the database.
    *
    * @param activityId the activity ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByActivityId(java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan lrs states where activityId = &#63; and stateId = &#63; from the database.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByActivityIdAndStateId(java.lang.String activityId,
        java.lang.String stateId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan lrs states from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs states where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @return the number of matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityId(java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs states where activityId = &#63; and stateId = &#63;.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @return the number of matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityIdAndStateId(java.lang.String activityId,
        java.lang.String stateId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs states.
    *
    * @return the number of l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
