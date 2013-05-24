package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f global objective state service. This utility wraps {@link LFGlobalObjectiveStatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFGlobalObjectiveStatePersistence
 * @see LFGlobalObjectiveStatePersistenceImpl
 * @generated
 */
public class LFGlobalObjectiveStateUtil {
    private static LFGlobalObjectiveStatePersistence _persistence;

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
    public static void clearCache(LFGlobalObjectiveState lfGlobalObjectiveState) {
        getPersistence().clearCache(lfGlobalObjectiveState);
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
    public static List<LFGlobalObjectiveState> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFGlobalObjectiveState> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFGlobalObjectiveState> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFGlobalObjectiveState update(
        LFGlobalObjectiveState lfGlobalObjectiveState, boolean merge)
        throws SystemException {
        return getPersistence().update(lfGlobalObjectiveState, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFGlobalObjectiveState update(
        LFGlobalObjectiveState lfGlobalObjectiveState, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(lfGlobalObjectiveState, merge, serviceContext);
    }

    /**
    * Caches the l f global objective state in the entity cache if it is enabled.
    *
    * @param lfGlobalObjectiveState the l f global objective state
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState) {
        getPersistence().cacheResult(lfGlobalObjectiveState);
    }

    /**
    * Caches the l f global objective states in the entity cache if it is enabled.
    *
    * @param lfGlobalObjectiveStates the l f global objective states
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> lfGlobalObjectiveStates) {
        getPersistence().cacheResult(lfGlobalObjectiveStates);
    }

    /**
    * Creates a new l f global objective state with the primary key. Does not add the l f global objective state to the database.
    *
    * @param id the primary key for the new l f global objective state
    * @return the new l f global objective state
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f global objective state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f global objective state
    * @return the l f global objective state that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a l f global objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfGlobalObjectiveState, merge);
    }

    /**
    * Returns the l f global objective state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException} if it could not be found.
    *
    * @param id the primary key of the l f global objective state
    * @return the l f global objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a l f global objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f global objective state with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f global objective state
    * @return the l f global objective state, or <code>null</code> if a l f global objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f global objective states where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @return the matching l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findByTreeID(
        java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID(treeID);
    }

    /**
    * Returns a range of all the l f global objective states where treeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param treeID the tree i d
    * @param start the lower bound of the range of l f global objective states
    * @param end the upper bound of the range of l f global objective states (not inclusive)
    * @return the range of matching l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findByTreeID(
        java.lang.Integer treeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID(treeID, start, end);
    }

    /**
    * Returns an ordered range of all the l f global objective states where treeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param treeID the tree i d
    * @param start the lower bound of the range of l f global objective states
    * @param end the upper bound of the range of l f global objective states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findByTreeID(
        java.lang.Integer treeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTreeID(treeID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f global objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f global objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState findByTreeID_First(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID_First(treeID, orderByComparator);
    }

    /**
    * Returns the first l f global objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchByTreeID_First(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTreeID_First(treeID, orderByComparator);
    }

    /**
    * Returns the last l f global objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f global objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState findByTreeID_Last(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID_Last(treeID, orderByComparator);
    }

    /**
    * Returns the last l f global objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchByTreeID_Last(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTreeID_Last(treeID, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState[] findByTreeID_PrevAndNext(
        long id, java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTreeID_PrevAndNext(id, treeID, orderByComparator);
    }

    /**
    * Returns the l f global objective state where treeID = &#63; and mapKey = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException} if it could not be found.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the matching l f global objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState findByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeIDAndMapKey(treeID, mapKey);
    }

    /**
    * Returns the l f global objective state where treeID = &#63; and mapKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTreeIDAndMapKey(treeID, mapKey);
    }

    /**
    * Returns the l f global objective state where treeID = &#63; and mapKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByTreeIDAndMapKey(treeID, mapKey, retrieveFromCache);
    }

    /**
    * Returns all the l f global objective states.
    *
    * @return the l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f global objective states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f global objective states
    * @param end the upper bound of the range of l f global objective states (not inclusive)
    * @return the range of l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f global objective states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f global objective states
    * @param end the upper bound of the range of l f global objective states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f global objective states where treeID = &#63; from the database.
    *
    * @param treeID the tree i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByTreeID(java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByTreeID(treeID);
    }

    /**
    * Removes the l f global objective state where treeID = &#63; and mapKey = &#63; from the database.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the l f global objective state that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState removeByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByTreeIDAndMapKey(treeID, mapKey);
    }

    /**
    * Removes all the l f global objective states from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f global objective states where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @return the number of matching l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public static int countByTreeID(java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTreeID(treeID);
    }

    /**
    * Returns the number of l f global objective states where treeID = &#63; and mapKey = &#63;.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the number of matching l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public static int countByTreeIDAndMapKey(java.lang.Integer treeID,
        java.lang.String mapKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTreeIDAndMapKey(treeID, mapKey);
    }

    /**
    * Returns the number of l f global objective states.
    *
    * @return the number of l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFGlobalObjectiveStatePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFGlobalObjectiveStatePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFGlobalObjectiveStatePersistence.class.getName());

            ReferenceRegistry.registerReference(LFGlobalObjectiveStateUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFGlobalObjectiveStatePersistence persistence) {
    }
}
