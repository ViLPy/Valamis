package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityState;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f activity state service. This utility wraps {@link LFActivityStatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStatePersistence
 * @see LFActivityStatePersistenceImpl
 * @generated
 */
public class LFActivityStateUtil {
    private static LFActivityStatePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(LFActivityState lfActivityState) {
        getPersistence().clearCache(lfActivityState);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFActivityState> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFActivityState> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFActivityState> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFActivityState update(LFActivityState lfActivityState)
        throws SystemException {
        return getPersistence().update(lfActivityState);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFActivityState update(LFActivityState lfActivityState,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfActivityState, serviceContext);
    }

    /**
    * Returns all the l f activity states where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @return the matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer activityStateNodeID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeIDActivityID(activityStateNodeID,
            activityID);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeIDActivityID(activityStateNodeID,
            activityID, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeIDActivityID(activityStateNodeID,
            activityID, start, end, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState findByActivityStateNodeIDActivityID_First(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeIDActivityID_First(activityStateNodeID,
            activityID, orderByComparator);
    }

    /**
    * Returns the first l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActivityStateNodeIDActivityID_First(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityStateNodeIDActivityID_First(activityStateNodeID,
            activityID, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState findByActivityStateNodeIDActivityID_Last(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeIDActivityID_Last(activityStateNodeID,
            activityID, orderByComparator);
    }

    /**
    * Returns the last l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActivityStateNodeIDActivityID_Last(
        java.lang.Integer activityStateNodeID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityStateNodeIDActivityID_Last(activityStateNodeID,
            activityID, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState[] findByActivityStateNodeIDActivityID_PrevAndNext(
        long id, java.lang.Integer activityStateNodeID,
        java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeIDActivityID_PrevAndNext(id,
            activityStateNodeID, activityID, orderByComparator);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer[] activityStateNodeIDs, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeIDActivityID(activityStateNodeIDs,
            activityID);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer[] activityStateNodeIDs, java.lang.String activityID,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeIDActivityID(activityStateNodeIDs,
            activityID, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDActivityID(
        java.lang.Integer[] activityStateNodeIDs, java.lang.String activityID,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeIDActivityID(activityStateNodeIDs,
            activityID, start, end, orderByComparator);
    }

    /**
    * Removes all the l f activity states where activityStateNodeID = &#63; and activityID = &#63; from the database.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByActivityStateNodeIDActivityID(
        java.lang.Integer activityStateNodeID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByActivityStateNodeIDActivityID(activityStateNodeID,
            activityID);
    }

    /**
    * Returns the number of l f activity states where activityStateNodeID = &#63; and activityID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param activityID the activity i d
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static int countByActivityStateNodeIDActivityID(
        java.lang.Integer activityStateNodeID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByActivityStateNodeIDActivityID(activityStateNodeID,
            activityID);
    }

    /**
    * Returns the number of l f activity states where activityStateNodeID = any &#63; and activityID = &#63;.
    *
    * @param activityStateNodeIDs the activity state node i ds
    * @param activityID the activity i d
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static int countByActivityStateNodeIDActivityID(
        java.lang.Integer[] activityStateNodeIDs, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByActivityStateNodeIDActivityID(activityStateNodeIDs,
            activityID);
    }

    /**
    * Returns all the l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @return the matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActIDActStateNodeActStateTree(activityID,
            activityStateNodeID, activityStateTreeID);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActIDActStateNodeActStateTree(activityID,
            activityStateNodeID, activityStateTreeID, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActIDActStateNodeActStateTree(activityID,
            activityStateNodeID, activityStateTreeID, start, end,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState findByActIDActStateNodeActStateTree_First(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActIDActStateNodeActStateTree_First(activityID,
            activityStateNodeID, activityStateTreeID, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActIDActStateNodeActStateTree_First(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActIDActStateNodeActStateTree_First(activityID,
            activityStateNodeID, activityStateTreeID, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState findByActIDActStateNodeActStateTree_Last(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActIDActStateNodeActStateTree_Last(activityID,
            activityStateNodeID, activityStateTreeID, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActIDActStateNodeActStateTree_Last(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActIDActStateNodeActStateTree_Last(activityID,
            activityStateNodeID, activityStateTreeID, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState[] findByActIDActStateNodeActStateTree_PrevAndNext(
        long id, java.lang.String activityID,
        java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActIDActStateNodeActStateTree_PrevAndNext(id,
            activityID, activityStateNodeID, activityStateTreeID,
            orderByComparator);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer[] activityStateNodeIDs,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActIDActStateNodeActStateTree(activityID,
            activityStateNodeIDs, activityStateTreeID);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer[] activityStateNodeIDs,
        java.lang.Integer activityStateTreeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActIDActStateNodeActStateTree(activityID,
            activityStateNodeIDs, activityStateTreeID, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer[] activityStateNodeIDs,
        java.lang.Integer activityStateTreeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActIDActStateNodeActStateTree(activityID,
            activityStateNodeIDs, activityStateTreeID, start, end,
            orderByComparator);
    }

    /**
    * Removes all the l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63; from the database.
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByActIDActStateNodeActStateTree(activityID,
            activityStateNodeID, activityStateTreeID);
    }

    /**
    * Returns the number of l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
    *
    * @param activityID the activity i d
    * @param activityStateNodeID the activity state node i d
    * @param activityStateTreeID the activity state tree i d
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static int countByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer activityStateNodeID,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByActIDActStateNodeActStateTree(activityID,
            activityStateNodeID, activityStateTreeID);
    }

    /**
    * Returns the number of l f activity states where activityID = &#63; and activityStateNodeID = any &#63; and activityStateTreeID = &#63;.
    *
    * @param activityID the activity i d
    * @param activityStateNodeIDs the activity state node i ds
    * @param activityStateTreeID the activity state tree i d
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static int countByActIDActStateNodeActStateTree(
        java.lang.String activityID, java.lang.Integer[] activityStateNodeIDs,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByActIDActStateNodeActStateTree(activityID,
            activityStateNodeIDs, activityStateTreeID);
    }

    /**
    * Returns all the l f activity states where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @return the matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer activityStateNodeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActivityStateNodeID(activityStateNodeID);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer activityStateNodeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeID(activityStateNodeID, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer activityStateNodeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeID(activityStateNodeID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f activity state in the ordered set where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState findByActivityStateNodeID_First(
        java.lang.Integer activityStateNodeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeID_First(activityStateNodeID,
            orderByComparator);
    }

    /**
    * Returns the first l f activity state in the ordered set where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActivityStateNodeID_First(
        java.lang.Integer activityStateNodeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityStateNodeID_First(activityStateNodeID,
            orderByComparator);
    }

    /**
    * Returns the last l f activity state in the ordered set where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState findByActivityStateNodeID_Last(
        java.lang.Integer activityStateNodeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeID_Last(activityStateNodeID,
            orderByComparator);
    }

    /**
    * Returns the last l f activity state in the ordered set where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByActivityStateNodeID_Last(
        java.lang.Integer activityStateNodeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityStateNodeID_Last(activityStateNodeID,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState[] findByActivityStateNodeID_PrevAndNext(
        long id, java.lang.Integer activityStateNodeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeID_PrevAndNext(id,
            activityStateNodeID, orderByComparator);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer[] activityStateNodeIDs)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActivityStateNodeID(activityStateNodeIDs);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer[] activityStateNodeIDs, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeID(activityStateNodeIDs, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer[] activityStateNodeIDs, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateNodeID(activityStateNodeIDs, start, end,
            orderByComparator);
    }

    /**
    * Removes all the l f activity states where activityStateNodeID = &#63; from the database.
    *
    * @param activityStateNodeID the activity state node i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByActivityStateNodeID(
        java.lang.Integer activityStateNodeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByActivityStateNodeID(activityStateNodeID);
    }

    /**
    * Returns the number of l f activity states where activityStateNodeID = &#63;.
    *
    * @param activityStateNodeID the activity state node i d
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static int countByActivityStateNodeID(
        java.lang.Integer activityStateNodeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByActivityStateNodeID(activityStateNodeID);
    }

    /**
    * Returns the number of l f activity states where activityStateNodeID = any &#63;.
    *
    * @param activityStateNodeIDs the activity state node i ds
    * @return the number of matching l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static int countByActivityStateNodeID(
        java.lang.Integer[] activityStateNodeIDs)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByActivityStateNodeID(activityStateNodeIDs);
    }

    /**
    * Caches the l f activity state in the entity cache if it is enabled.
    *
    * @param lfActivityState the l f activity state
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState) {
        getPersistence().cacheResult(lfActivityState);
    }

    /**
    * Caches the l f activity states in the entity cache if it is enabled.
    *
    * @param lfActivityStates the l f activity states
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> lfActivityStates) {
        getPersistence().cacheResult(lfActivityStates);
    }

    /**
    * Creates a new l f activity state with the primary key. Does not add the l f activity state to the database.
    *
    * @param id the primary key for the new l f activity state
    * @return the new l f activity state
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f activity state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity state
    * @return the l f activity state that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFActivityState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfActivityState);
    }

    /**
    * Returns the l f activity state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException} if it could not be found.
    *
    * @param id the primary key of the l f activity state
    * @return the l f activity state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f activity state with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f activity state
    * @return the l f activity state, or <code>null</code> if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f activity states.
    *
    * @return the l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f activity states from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f activity states.
    *
    * @return the number of l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFActivityStatePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFActivityStatePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFActivityStatePersistence.class.getName());

            ReferenceRegistry.registerReference(LFActivityStateUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFActivityStatePersistence persistence) {
    }
}
