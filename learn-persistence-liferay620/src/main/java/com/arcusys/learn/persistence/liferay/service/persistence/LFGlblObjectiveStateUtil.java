package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f glbl objective state service. This utility wraps {@link LFGlblObjectiveStatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFGlblObjectiveStatePersistence
 * @see LFGlblObjectiveStatePersistenceImpl
 * @generated
 */
public class LFGlblObjectiveStateUtil {
    private static LFGlblObjectiveStatePersistence _persistence;

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
    public static void clearCache(LFGlblObjectiveState lfGlblObjectiveState) {
        getPersistence().clearCache(lfGlblObjectiveState);
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
    public static List<LFGlblObjectiveState> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFGlblObjectiveState> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFGlblObjectiveState> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFGlblObjectiveState update(
        LFGlblObjectiveState lfGlblObjectiveState) throws SystemException {
        return getPersistence().update(lfGlblObjectiveState);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFGlblObjectiveState update(
        LFGlblObjectiveState lfGlblObjectiveState, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfGlblObjectiveState, serviceContext);
    }

    /**
    * Returns all the l f glbl objective states where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @return the matching l f glbl objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState> findByTreeID(
        java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID(treeID);
    }

    /**
    * Returns a range of all the l f glbl objective states where treeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param treeID the tree i d
    * @param start the lower bound of the range of l f glbl objective states
    * @param end the upper bound of the range of l f glbl objective states (not inclusive)
    * @return the range of matching l f glbl objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState> findByTreeID(
        java.lang.Integer treeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID(treeID, start, end);
    }

    /**
    * Returns an ordered range of all the l f glbl objective states where treeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param treeID the tree i d
    * @param start the lower bound of the range of l f glbl objective states
    * @param end the upper bound of the range of l f glbl objective states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f glbl objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState> findByTreeID(
        java.lang.Integer treeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTreeID(treeID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f glbl objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f glbl objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a matching l f glbl objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState findByTreeID_First(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID_First(treeID, orderByComparator);
    }

    /**
    * Returns the first l f glbl objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f glbl objective state, or <code>null</code> if a matching l f glbl objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState fetchByTreeID_First(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTreeID_First(treeID, orderByComparator);
    }

    /**
    * Returns the last l f glbl objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f glbl objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a matching l f glbl objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState findByTreeID_Last(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID_Last(treeID, orderByComparator);
    }

    /**
    * Returns the last l f glbl objective state in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f glbl objective state, or <code>null</code> if a matching l f glbl objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState fetchByTreeID_Last(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTreeID_Last(treeID, orderByComparator);
    }

    /**
    * Returns the l f glbl objective states before and after the current l f glbl objective state in the ordered set where treeID = &#63;.
    *
    * @param id the primary key of the current l f glbl objective state
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f glbl objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a l f glbl objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState[] findByTreeID_PrevAndNext(
        long id, java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTreeID_PrevAndNext(id, treeID, orderByComparator);
    }

    /**
    * Removes all the l f glbl objective states where treeID = &#63; from the database.
    *
    * @param treeID the tree i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByTreeID(java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByTreeID(treeID);
    }

    /**
    * Returns the number of l f glbl objective states where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @return the number of matching l f glbl objective states
    * @throws SystemException if a system exception occurred
    */
    public static int countByTreeID(java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTreeID(treeID);
    }

    /**
    * Returns the l f glbl objective state where treeID = &#63; and mapKey = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException} if it could not be found.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the matching l f glbl objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a matching l f glbl objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState findByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeIDAndMapKey(treeID, mapKey);
    }

    /**
    * Returns the l f glbl objective state where treeID = &#63; and mapKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the matching l f glbl objective state, or <code>null</code> if a matching l f glbl objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState fetchByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTreeIDAndMapKey(treeID, mapKey);
    }

    /**
    * Returns the l f glbl objective state where treeID = &#63; and mapKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f glbl objective state, or <code>null</code> if a matching l f glbl objective state could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState fetchByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByTreeIDAndMapKey(treeID, mapKey, retrieveFromCache);
    }

    /**
    * Removes the l f glbl objective state where treeID = &#63; and mapKey = &#63; from the database.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the l f glbl objective state that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState removeByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByTreeIDAndMapKey(treeID, mapKey);
    }

    /**
    * Returns the number of l f glbl objective states where treeID = &#63; and mapKey = &#63;.
    *
    * @param treeID the tree i d
    * @param mapKey the map key
    * @return the number of matching l f glbl objective states
    * @throws SystemException if a system exception occurred
    */
    public static int countByTreeIDAndMapKey(java.lang.Integer treeID,
        java.lang.String mapKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTreeIDAndMapKey(treeID, mapKey);
    }

    /**
    * Caches the l f glbl objective state in the entity cache if it is enabled.
    *
    * @param lfGlblObjectiveState the l f glbl objective state
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState lfGlblObjectiveState) {
        getPersistence().cacheResult(lfGlblObjectiveState);
    }

    /**
    * Caches the l f glbl objective states in the entity cache if it is enabled.
    *
    * @param lfGlblObjectiveStates the l f glbl objective states
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState> lfGlblObjectiveStates) {
        getPersistence().cacheResult(lfGlblObjectiveStates);
    }

    /**
    * Creates a new l f glbl objective state with the primary key. Does not add the l f glbl objective state to the database.
    *
    * @param id the primary key for the new l f glbl objective state
    * @return the new l f glbl objective state
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f glbl objective state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f glbl objective state
    * @return the l f glbl objective state that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a l f glbl objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState lfGlblObjectiveState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfGlblObjectiveState);
    }

    /**
    * Returns the l f glbl objective state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException} if it could not be found.
    *
    * @param id the primary key of the l f glbl objective state
    * @return the l f glbl objective state
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a l f glbl objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f glbl objective state with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f glbl objective state
    * @return the l f glbl objective state, or <code>null</code> if a l f glbl objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f glbl objective states.
    *
    * @return the l f glbl objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f glbl objective states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f glbl objective states
    * @param end the upper bound of the range of l f glbl objective states (not inclusive)
    * @return the range of l f glbl objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f glbl objective states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f glbl objective states
    * @param end the upper bound of the range of l f glbl objective states (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f glbl objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f glbl objective states from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f glbl objective states.
    *
    * @return the number of l f glbl objective states
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFGlblObjectiveStatePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFGlblObjectiveStatePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFGlblObjectiveStatePersistence.class.getName());

            ReferenceRegistry.registerReference(LFGlblObjectiveStateUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFGlblObjectiveStatePersistence persistence) {
    }
}
