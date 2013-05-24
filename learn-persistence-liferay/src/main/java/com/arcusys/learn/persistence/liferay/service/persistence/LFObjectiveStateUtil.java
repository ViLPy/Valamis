package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveState;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f objective state service. This utility wraps {@link LFObjectiveStatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectiveStatePersistence
 * @see LFObjectiveStatePersistenceImpl
 * @generated
 */
public class LFObjectiveStateUtil {
    private static LFObjectiveStatePersistence _persistence;

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
    public static void clearCache(LFObjectiveState lfObjectiveState) {
        getPersistence().clearCache(lfObjectiveState);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFObjectiveState> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFObjectiveState> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFObjectiveState> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFObjectiveState update(LFObjectiveState lfObjectiveState,
        boolean merge) throws SystemException {
        return getPersistence().update(lfObjectiveState, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFObjectiveState update(LFObjectiveState lfObjectiveState,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfObjectiveState, merge, serviceContext);
    }

    /**
    * Caches the l f objective state in the entity cache if it is enabled.
    *
    * @param lfObjectiveState the l f objective state
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveState lfObjectiveState) {
        getPersistence().cacheResult(lfObjectiveState);
    }

    /**
    * Caches the l f objective states in the entity cache if it is enabled.
    *
    * @param lfObjectiveStates the l f objective states
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> lfObjectiveStates) {
        getPersistence().cacheResult(lfObjectiveStates);
    }

    /**
    * Creates a new l f objective state with the primary key. Does not add the l f objective state to the database.
    *
    * @param id the primary key for the new l f objective state
    * @return the new l f objective state
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f objective state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f objective state
    * @return the l f objective state that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a l f objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveState lfObjectiveState,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfObjectiveState, merge);
    }

    /**
    * Returns the l f objective state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException} if it could not be found.
    *
    * @param id the primary key of the l f objective state
    * @return the l f objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a l f objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f objective state with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f objective state
    * @return the l f objective state, or <code>null</code> if a l f objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns the l f objective state where mapKey = &#63; and activityStateID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException} if it could not be found.
    *
    * @param mapKey the map key
    * @param activityStateID the activity state i d
    * @return the matching l f objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState findByMapKeyAndActivityStateID(
        java.lang.String mapKey, java.lang.Integer activityStateID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByMapKeyAndActivityStateID(mapKey, activityStateID);
    }

    /**
    * Returns the l f objective state where mapKey = &#63; and activityStateID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param mapKey the map key
    * @param activityStateID the activity state i d
    * @return the matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState fetchByMapKeyAndActivityStateID(
        java.lang.String mapKey, java.lang.Integer activityStateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByMapKeyAndActivityStateID(mapKey, activityStateID);
    }

    /**
    * Returns the l f objective state where mapKey = &#63; and activityStateID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param mapKey the map key
    * @param activityStateID the activity state i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState fetchByMapKeyAndActivityStateID(
        java.lang.String mapKey, java.lang.Integer activityStateID,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByMapKeyAndActivityStateID(mapKey, activityStateID,
            retrieveFromCache);
    }

    /**
    * Returns all the l f objective states where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @return the matching l f objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findByActivityStateID(
        java.lang.Integer activityStateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActivityStateID(activityStateID);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findByActivityStateID(
        java.lang.Integer activityStateID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateID(activityStateID, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findByActivityStateID(
        java.lang.Integer activityStateID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateID(activityStateID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f objective state in the ordered set where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState findByActivityStateID_First(
        java.lang.Integer activityStateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateID_First(activityStateID,
            orderByComparator);
    }

    /**
    * Returns the first l f objective state in the ordered set where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState fetchByActivityStateID_First(
        java.lang.Integer activityStateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityStateID_First(activityStateID,
            orderByComparator);
    }

    /**
    * Returns the last l f objective state in the ordered set where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState findByActivityStateID_Last(
        java.lang.Integer activityStateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateID_Last(activityStateID,
            orderByComparator);
    }

    /**
    * Returns the last l f objective state in the ordered set where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState fetchByActivityStateID_Last(
        java.lang.Integer activityStateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityStateID_Last(activityStateID,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState[] findByActivityStateID_PrevAndNext(
        long id, java.lang.Integer activityStateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityStateID_PrevAndNext(id, activityStateID,
            orderByComparator);
    }

    /**
    * Returns all the l f objective states.
    *
    * @return the l f objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveState> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes the l f objective state where mapKey = &#63; and activityStateID = &#63; from the database.
    *
    * @param mapKey the map key
    * @param activityStateID the activity state i d
    * @return the l f objective state that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveState removeByMapKeyAndActivityStateID(
        java.lang.String mapKey, java.lang.Integer activityStateID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .removeByMapKeyAndActivityStateID(mapKey, activityStateID);
    }

    /**
    * Removes all the l f objective states where activityStateID = &#63; from the database.
    *
    * @param activityStateID the activity state i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByActivityStateID(
        java.lang.Integer activityStateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByActivityStateID(activityStateID);
    }

    /**
    * Removes all the l f objective states from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f objective states where mapKey = &#63; and activityStateID = &#63;.
    *
    * @param mapKey the map key
    * @param activityStateID the activity state i d
    * @return the number of matching l f objective states
    * @throws SystemException if a system exception occurred
    */
    public static int countByMapKeyAndActivityStateID(java.lang.String mapKey,
        java.lang.Integer activityStateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByMapKeyAndActivityStateID(mapKey, activityStateID);
    }

    /**
    * Returns the number of l f objective states where activityStateID = &#63;.
    *
    * @param activityStateID the activity state i d
    * @return the number of matching l f objective states
    * @throws SystemException if a system exception occurred
    */
    public static int countByActivityStateID(java.lang.Integer activityStateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByActivityStateID(activityStateID);
    }

    /**
    * Returns the number of l f objective states.
    *
    * @return the number of l f objective states
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFObjectiveStatePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFObjectiveStatePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFObjectiveStatePersistence.class.getName());

            ReferenceRegistry.registerReference(LFObjectiveStateUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFObjectiveStatePersistence persistence) {
    }
}
