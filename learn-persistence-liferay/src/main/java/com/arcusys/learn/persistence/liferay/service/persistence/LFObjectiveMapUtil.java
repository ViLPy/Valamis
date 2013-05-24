package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveMap;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f objective map service. This utility wraps {@link LFObjectiveMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectiveMapPersistence
 * @see LFObjectiveMapPersistenceImpl
 * @generated
 */
public class LFObjectiveMapUtil {
    private static LFObjectiveMapPersistence _persistence;

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
    public static void clearCache(LFObjectiveMap lfObjectiveMap) {
        getPersistence().clearCache(lfObjectiveMap);
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
    public static List<LFObjectiveMap> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFObjectiveMap> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFObjectiveMap> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFObjectiveMap update(LFObjectiveMap lfObjectiveMap,
        boolean merge) throws SystemException {
        return getPersistence().update(lfObjectiveMap, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFObjectiveMap update(LFObjectiveMap lfObjectiveMap,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfObjectiveMap, merge, serviceContext);
    }

    /**
    * Caches the l f objective map in the entity cache if it is enabled.
    *
    * @param lfObjectiveMap the l f objective map
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveMap lfObjectiveMap) {
        getPersistence().cacheResult(lfObjectiveMap);
    }

    /**
    * Caches the l f objective maps in the entity cache if it is enabled.
    *
    * @param lfObjectiveMaps the l f objective maps
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> lfObjectiveMaps) {
        getPersistence().cacheResult(lfObjectiveMaps);
    }

    /**
    * Creates a new l f objective map with the primary key. Does not add the l f objective map to the database.
    *
    * @param id the primary key for the new l f objective map
    * @return the new l f objective map
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f objective map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f objective map
    * @return the l f objective map that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a l f objective map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveMap lfObjectiveMap,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfObjectiveMap, merge);
    }

    /**
    * Returns the l f objective map with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException} if it could not be found.
    *
    * @param id the primary key of the l f objective map
    * @return the l f objective map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a l f objective map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f objective map with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f objective map
    * @return the l f objective map, or <code>null</code> if a l f objective map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f objective maps where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @return the matching l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findByObjectiveID(
        java.lang.Integer objectiveID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByObjectiveID(objectiveID);
    }

    /**
    * Returns a range of all the l f objective maps where objectiveID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param objectiveID the objective i d
    * @param start the lower bound of the range of l f objective maps
    * @param end the upper bound of the range of l f objective maps (not inclusive)
    * @return the range of matching l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findByObjectiveID(
        java.lang.Integer objectiveID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByObjectiveID(objectiveID, start, end);
    }

    /**
    * Returns an ordered range of all the l f objective maps where objectiveID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param objectiveID the objective i d
    * @param start the lower bound of the range of l f objective maps
    * @param end the upper bound of the range of l f objective maps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findByObjectiveID(
        java.lang.Integer objectiveID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByObjectiveID(objectiveID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f objective map in the ordered set where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a matching l f objective map could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap findByObjectiveID_First(
        java.lang.Integer objectiveID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByObjectiveID_First(objectiveID, orderByComparator);
    }

    /**
    * Returns the first l f objective map in the ordered set where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective map, or <code>null</code> if a matching l f objective map could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap fetchByObjectiveID_First(
        java.lang.Integer objectiveID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByObjectiveID_First(objectiveID, orderByComparator);
    }

    /**
    * Returns the last l f objective map in the ordered set where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a matching l f objective map could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap findByObjectiveID_Last(
        java.lang.Integer objectiveID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByObjectiveID_Last(objectiveID, orderByComparator);
    }

    /**
    * Returns the last l f objective map in the ordered set where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective map, or <code>null</code> if a matching l f objective map could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap fetchByObjectiveID_Last(
        java.lang.Integer objectiveID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByObjectiveID_Last(objectiveID, orderByComparator);
    }

    /**
    * Returns the l f objective maps before and after the current l f objective map in the ordered set where objectiveID = &#63;.
    *
    * @param id the primary key of the current l f objective map
    * @param objectiveID the objective i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f objective map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a l f objective map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap[] findByObjectiveID_PrevAndNext(
        long id, java.lang.Integer objectiveID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByObjectiveID_PrevAndNext(id, objectiveID,
            orderByComparator);
    }

    /**
    * Returns all the l f objective maps.
    *
    * @return the l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f objective maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f objective maps
    * @param end the upper bound of the range of l f objective maps (not inclusive)
    * @return the range of l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f objective maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f objective maps
    * @param end the upper bound of the range of l f objective maps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f objective maps where objectiveID = &#63; from the database.
    *
    * @param objectiveID the objective i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByObjectiveID(java.lang.Integer objectiveID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByObjectiveID(objectiveID);
    }

    /**
    * Removes all the l f objective maps from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f objective maps where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @return the number of matching l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public static int countByObjectiveID(java.lang.Integer objectiveID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByObjectiveID(objectiveID);
    }

    /**
    * Returns the number of l f objective maps.
    *
    * @return the number of l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFObjectiveMapPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFObjectiveMapPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFObjectiveMapPersistence.class.getName());

            ReferenceRegistry.registerReference(LFObjectiveMapUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFObjectiveMapPersistence persistence) {
    }
}
