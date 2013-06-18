package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityStateTree;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f activity state tree service. This utility wraps {@link LFActivityStateTreePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateTreePersistence
 * @see LFActivityStateTreePersistenceImpl
 * @generated
 */
public class LFActivityStateTreeUtil {
    private static LFActivityStateTreePersistence _persistence;

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
    public static void clearCache(LFActivityStateTree lfActivityStateTree) {
        getPersistence().clearCache(lfActivityStateTree);
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
    public static List<LFActivityStateTree> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFActivityStateTree> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFActivityStateTree> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFActivityStateTree update(
        LFActivityStateTree lfActivityStateTree, boolean merge)
        throws SystemException {
        return getPersistence().update(lfActivityStateTree, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFActivityStateTree update(
        LFActivityStateTree lfActivityStateTree, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(lfActivityStateTree, merge, serviceContext);
    }

    /**
    * Caches the l f activity state tree in the entity cache if it is enabled.
    *
    * @param lfActivityStateTree the l f activity state tree
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree) {
        getPersistence().cacheResult(lfActivityStateTree);
    }

    /**
    * Caches the l f activity state trees in the entity cache if it is enabled.
    *
    * @param lfActivityStateTrees the l f activity state trees
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateTree> lfActivityStateTrees) {
        getPersistence().cacheResult(lfActivityStateTrees);
    }

    /**
    * Creates a new l f activity state tree with the primary key. Does not add the l f activity state tree to the database.
    *
    * @param id the primary key for the new l f activity state tree
    * @return the new l f activity state tree
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f activity state tree with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfActivityStateTree, merge);
    }

    /**
    * Returns the l f activity state tree with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException} if it could not be found.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f activity state tree with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree, or <code>null</code> if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns the l f activity state tree where attemptID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException} if it could not be found.
    *
    * @param attemptID the attempt i d
    * @return the matching l f activity state tree
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a matching l f activity state tree could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree findByAttemptID(
        java.lang.Integer attemptID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAttemptID(attemptID);
    }

    /**
    * Returns the l f activity state tree where attemptID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param attemptID the attempt i d
    * @return the matching l f activity state tree, or <code>null</code> if a matching l f activity state tree could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree fetchByAttemptID(
        java.lang.Integer attemptID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAttemptID(attemptID);
    }

    /**
    * Returns the l f activity state tree where attemptID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param attemptID the attempt i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f activity state tree, or <code>null</code> if a matching l f activity state tree could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree fetchByAttemptID(
        java.lang.Integer attemptID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAttemptID(attemptID, retrieveFromCache);
    }

    /**
    * Returns all the l f activity state trees.
    *
    * @return the l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateTree> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f activity state trees.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activity state trees
    * @param end the upper bound of the range of l f activity state trees (not inclusive)
    * @return the range of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateTree> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f activity state trees.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activity state trees
    * @param end the upper bound of the range of l f activity state trees (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateTree> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes the l f activity state tree where attemptID = &#63; from the database.
    *
    * @param attemptID the attempt i d
    * @return the l f activity state tree that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateTree removeByAttemptID(
        java.lang.Integer attemptID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByAttemptID(attemptID);
    }

    /**
    * Removes all the l f activity state trees from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f activity state trees where attemptID = &#63;.
    *
    * @param attemptID the attempt i d
    * @return the number of matching l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public static int countByAttemptID(java.lang.Integer attemptID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAttemptID(attemptID);
    }

    /**
    * Returns the number of l f activity state trees.
    *
    * @return the number of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFActivityStateTreePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFActivityStateTreePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFActivityStateTreePersistence.class.getName());

            ReferenceRegistry.registerReference(LFActivityStateTreeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFActivityStateTreePersistence persistence) {
    }
}
