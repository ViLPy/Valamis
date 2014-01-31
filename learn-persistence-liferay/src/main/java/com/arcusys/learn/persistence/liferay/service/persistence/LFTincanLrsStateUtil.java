package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsState;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan lrs state service. This utility wraps {@link LFTincanLrsStatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatePersistence
 * @see LFTincanLrsStatePersistenceImpl
 * @generated
 */
public class LFTincanLrsStateUtil {
    private static LFTincanLrsStatePersistence _persistence;

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
    public static void clearCache(LFTincanLrsState lfTincanLrsState) {
        getPersistence().clearCache(lfTincanLrsState);
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
    public static List<LFTincanLrsState> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanLrsState> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanLrsState> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFTincanLrsState update(LFTincanLrsState lfTincanLrsState)
        throws SystemException {
        return getPersistence().update(lfTincanLrsState);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFTincanLrsState update(LFTincanLrsState lfTincanLrsState,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfTincanLrsState, serviceContext);
    }

    /**
    * Returns all the l f tincan lrs states where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @return the matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityId(
        java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActivityId(activityId);
    }

    /**
    * Returns a range of all the l f tincan lrs states where activityId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityId the activity ID
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @return the range of matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityId(
        java.lang.String activityId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActivityId(activityId, start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs states where activityId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityId the activity ID
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityId(
        java.lang.String activityId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityId(activityId, start, end, orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs state in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState findByActivityId_First(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityId_First(activityId, orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs state in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState fetchByActivityId_First(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityId_First(activityId, orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs state in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState findByActivityId_Last(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityId_Last(activityId, orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs state in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState fetchByActivityId_Last(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityId_Last(activityId, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState[] findByActivityId_PrevAndNext(
        long id, java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityId_PrevAndNext(id, activityId,
            orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs states where activityId = &#63; from the database.
    *
    * @param activityId the activity ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByActivityId(java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByActivityId(activityId);
    }

    /**
    * Returns the number of l f tincan lrs states where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @return the number of matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public static int countByActivityId(java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByActivityId(activityId);
    }

    /**
    * Returns all the l f tincan lrs states where activityId = &#63; and stateId = &#63;.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @return the matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityIdAndStateId(
        java.lang.String activityId, java.lang.String stateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActivityIdAndStateId(activityId, stateId);
    }

    /**
    * Returns a range of all the l f tincan lrs states where activityId = &#63; and stateId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @return the range of matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityIdAndStateId(
        java.lang.String activityId, java.lang.String stateId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityIdAndStateId(activityId, stateId, start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs states where activityId = &#63; and stateId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityIdAndStateId(
        java.lang.String activityId, java.lang.String stateId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityIdAndStateId(activityId, stateId, start, end,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState findByActivityIdAndStateId_First(
        java.lang.String activityId, java.lang.String stateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityIdAndStateId_First(activityId, stateId,
            orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState fetchByActivityIdAndStateId_First(
        java.lang.String activityId, java.lang.String stateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityIdAndStateId_First(activityId, stateId,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState findByActivityIdAndStateId_Last(
        java.lang.String activityId, java.lang.String stateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityIdAndStateId_Last(activityId, stateId,
            orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState fetchByActivityIdAndStateId_Last(
        java.lang.String activityId, java.lang.String stateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityIdAndStateId_Last(activityId, stateId,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState[] findByActivityIdAndStateId_PrevAndNext(
        long id, java.lang.String activityId, java.lang.String stateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityIdAndStateId_PrevAndNext(id, activityId,
            stateId, orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs states where activityId = &#63; and stateId = &#63; from the database.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByActivityIdAndStateId(
        java.lang.String activityId, java.lang.String stateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByActivityIdAndStateId(activityId, stateId);
    }

    /**
    * Returns the number of l f tincan lrs states where activityId = &#63; and stateId = &#63;.
    *
    * @param activityId the activity ID
    * @param stateId the state ID
    * @return the number of matching l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public static int countByActivityIdAndStateId(java.lang.String activityId,
        java.lang.String stateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByActivityIdAndStateId(activityId, stateId);
    }

    /**
    * Caches the l f tincan lrs state in the entity cache if it is enabled.
    *
    * @param lfTincanLrsState the l f tincan lrs state
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsState lfTincanLrsState) {
        getPersistence().cacheResult(lfTincanLrsState);
    }

    /**
    * Caches the l f tincan lrs states in the entity cache if it is enabled.
    *
    * @param lfTincanLrsStates the l f tincan lrs states
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> lfTincanLrsStates) {
        getPersistence().cacheResult(lfTincanLrsStates);
    }

    /**
    * Creates a new l f tincan lrs state with the primary key. Does not add the l f tincan lrs state to the database.
    *
    * @param id the primary key for the new l f tincan lrs state
    * @return the new l f tincan lrs state
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f tincan lrs state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs state
    * @return the l f tincan lrs state that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a l f tincan lrs state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsState lfTincanLrsState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanLrsState);
    }

    /**
    * Returns the l f tincan lrs state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs state
    * @return the l f tincan lrs state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a l f tincan lrs state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan lrs state with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs state
    * @return the l f tincan lrs state, or <code>null</code> if a l f tincan lrs state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsState fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f tincan lrs states.
    *
    * @return the l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f tincan lrs states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @return the range of l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs states from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan lrs states.
    *
    * @return the number of l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanLrsStatePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanLrsStatePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanLrsStatePersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanLrsStateUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFTincanLrsStatePersistence persistence) {
    }
}
