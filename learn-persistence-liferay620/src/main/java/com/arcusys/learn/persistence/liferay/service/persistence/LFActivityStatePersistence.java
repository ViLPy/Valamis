package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityState;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f activity state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStatePersistenceImpl
 * @see LFActivityStateUtil
 * @generated
 */
public interface LFActivityStatePersistence extends BasePersistence<LFActivityState> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFActivityStateUtil} to access the l f activity state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f activity states where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @return the matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer activityStateNodeID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity states where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @return the range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity states where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState findByActivityStateNodeIDActivityID_First(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActivityStateNodeIDActivityID_First(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState findByActivityStateNodeIDActivityID_Last(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActivityStateNodeIDActivityID_Last(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity states before and after the current l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * @param id the primary key of the current l f activity state
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState[] findByActivityStateNodeIDActivityID_PrevAndNext(
        long id, java.lang.Integer activityStateNodeID,
        java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity states where activityStateNodeID = any &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityStateNodeIDs the activity state node i ds
    * @param activityID the activity i d
    * @return the matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer[] activityStateNodeIDs, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity states where activityStateNodeID = any &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityStateNodeIDs the activity state node i ds
    * @param activityID the activity i d
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @return the range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer[] activityStateNodeIDs, java.lang.String activityID,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity states where activityStateNodeID = any &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityStateNodeIDs the activity state node i ds
    * @param activityID the activity i d
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer[] activityStateNodeIDs, java.lang.String activityID,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activity states where activityStateNodeID = &#63; and activityID = &#63; from the database.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByActivityStateNodeIDActivityID(
        java.lang.Integer activityStateNodeID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity states where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityStateNodeIDActivityID(
        java.lang.Integer activityStateNodeID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity states where activityStateNodeID = any &#63; and activityID = &#63;.
    *
    * @param activityStateNodeIDs the activity state node i ds
    * @param activityID the activity i d
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityStateNodeIDActivityID(
        java.lang.Integer[] activityStateNodeIDs, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @return the matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @return the range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity state in the ordered set where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState findByActIDActStateNodeActStateTree_First(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity state in the ordered set where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActIDActStateNodeActStateTree_First(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity state in the ordered set where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState findByActIDActStateNodeActStateTree_Last(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity state in the ordered set where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActIDActStateNodeActStateTree_Last(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity states before and after the current l f activity state in the ordered set where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
    *
    * @param id the primary key of the current l f activity state
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState[] findByActIDActStateNodeActStateTree_PrevAndNext(
        long id, java.lang.String activityID,
        java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity states where activityID = &#63; and activityStateNodeID = any &#63; and activityStateTreeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityID the activity i d
    * @param activityStateNodeIDs the activity state node i ds
    * @param activityStateTreeID the activity state tree i d
    * @return the matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer[] activityStateNodeIDs,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity states where activityID = &#63; and activityStateNodeID = any &#63; and activityStateTreeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityID the activity i d
    * @param activityStateNodeIDs the activity state node i ds
    * @param activityStateTreeID the activity state tree i d
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @return the range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer[] activityStateNodeIDs,
        java.lang.Integer activityStateTreeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity states where activityID = &#63; and activityStateNodeID = any &#63; and activityStateTreeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityID the activity i d
    * @param activityStateNodeIDs the activity state node i ds
    * @param activityStateTreeID the activity state tree i d
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer[] activityStateNodeIDs,
        java.lang.Integer activityStateTreeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63; from the database.
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public int countByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity states where activityID = &#63; and activityStateNodeID = any &#63; and activityStateTreeID = &#63;.
    *
    * @param activityID the activity i d
    * @param activityStateNodeIDs the activity state node i ds
    * @param activityStateTreeID the activity state tree i d
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public int countByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer[] activityStateNodeIDs,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity states where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @return the matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer activityStateNodeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity states where activityStateNodeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityStateNodeID the activity state node i d
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @return the range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer activityStateNodeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity states where activityStateNodeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityStateNodeID the activity state node i d
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer activityStateNodeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity state in the ordered set where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState findByActivityStateNodeID_First(
        java.lang.Integer activityStateNodeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity state in the ordered set where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActivityStateNodeID_First(
        java.lang.Integer activityStateNodeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity state in the ordered set where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState findByActivityStateNodeID_Last(
        java.lang.Integer activityStateNodeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity state in the ordered set where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActivityStateNodeID_Last(
        java.lang.Integer activityStateNodeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity states before and after the current l f activity state in the ordered set where activityStateNodeID = &#63;.
    *
    * @param id the primary key of the current l f activity state
    * @param activityStateNodeID the activity state node i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState[] findByActivityStateNodeID_PrevAndNext(
        long id, java.lang.Integer activityStateNodeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity states where activityStateNodeID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityStateNodeIDs the activity state node i ds
    * @return the matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer[] activityStateNodeIDs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity states where activityStateNodeID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityStateNodeIDs the activity state node i ds
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @return the range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer[] activityStateNodeIDs, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity states where activityStateNodeID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityStateNodeIDs the activity state node i ds
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer[] activityStateNodeIDs, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activity states where activityStateNodeID = &#63; from the database.
    *
    * @param activityStateNodeID the activity state node i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByActivityStateNodeID(
        java.lang.Integer activityStateNodeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity states where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityStateNodeID(java.lang.Integer activityStateNodeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity states where activityStateNodeID = any &#63;.
    *
    * @param activityStateNodeIDs the activity state node i ds
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityStateNodeID(
        java.lang.Integer[] activityStateNodeIDs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f activity state in the entity cache if it is enabled.
    *
    * @param lfActivityState the l f activity state
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState);

    /**
    * Caches the l f activity states in the entity cache if it is enabled.
    *
    * @param lfActivityStates the l f activity states
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> lfActivityStates);

    /**
    * Creates a new l f activity state with the primary key. Does not add the l f activity state to the database.
    *
    * @param id the primary key for the new l f activity state
    * @return the new l f activity state
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState create(
        long id);

    /**
    * Removes the l f activity state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity state
    * @return the l f activity state that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFActivityState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException} if it could not be found.
    *
    * @param id the primary key of the l f activity state
    * @return the l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity state with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f activity state
    * @return the l f activity state, or <code>null</code> if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity states.
    *
    * @return the l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @return the range of l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f activity states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activity states from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity states.
    *
    * @return the number of l f activity states
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
