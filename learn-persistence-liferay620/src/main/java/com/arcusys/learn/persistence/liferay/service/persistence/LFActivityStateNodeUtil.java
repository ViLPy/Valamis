package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityStateNode;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f activity state node service. This utility wraps {@link LFActivityStateNodePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateNodePersistence
 * @see LFActivityStateNodePersistenceImpl
 * @generated
 */
public class LFActivityStateNodeUtil {
    private static LFActivityStateNodePersistence _persistence;

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
    public static void clearCache(LFActivityStateNode lfActivityStateNode) {
        getPersistence().clearCache(lfActivityStateNode);
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
    public static List<LFActivityStateNode> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFActivityStateNode> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFActivityStateNode> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFActivityStateNode update(
        LFActivityStateNode lfActivityStateNode) throws SystemException {
        return getPersistence().update(lfActivityStateNode);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFActivityStateNode update(
        LFActivityStateNode lfActivityStateNode, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfActivityStateNode, serviceContext);
    }

    /**
    * Returns all the l f activity state nodes where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @return the matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeID(
        java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID(treeID);
    }

    /**
    * Returns a range of all the l f activity state nodes where treeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param treeID the tree i d
    * @param start the lower bound of the range of l f activity state nodes
    * @param end the upper bound of the range of l f activity state nodes (not inclusive)
    * @return the range of matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeID(
        java.lang.Integer treeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID(treeID, start, end);
    }

    /**
    * Returns an ordered range of all the l f activity state nodes where treeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param treeID the tree i d
    * @param start the lower bound of the range of l f activity state nodes
    * @param end the upper bound of the range of l f activity state nodes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeID(
        java.lang.Integer treeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTreeID(treeID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f activity state node in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state node
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode findByTreeID_First(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID_First(treeID, orderByComparator);
    }

    /**
    * Returns the first l f activity state node in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state node, or <code>null</code> if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode fetchByTreeID_First(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTreeID_First(treeID, orderByComparator);
    }

    /**
    * Returns the last l f activity state node in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state node
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode findByTreeID_Last(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeID_Last(treeID, orderByComparator);
    }

    /**
    * Returns the last l f activity state node in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state node, or <code>null</code> if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode fetchByTreeID_Last(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTreeID_Last(treeID, orderByComparator);
    }

    /**
    * Returns the l f activity state nodes before and after the current l f activity state node in the ordered set where treeID = &#63;.
    *
    * @param id the primary key of the current l f activity state node
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity state node
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a l f activity state node with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode[] findByTreeID_PrevAndNext(
        long id, java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTreeID_PrevAndNext(id, treeID, orderByComparator);
    }

    /**
    * Removes all the l f activity state nodes where treeID = &#63; from the database.
    *
    * @param treeID the tree i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByTreeID(java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByTreeID(treeID);
    }

    /**
    * Returns the number of l f activity state nodes where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @return the number of matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static int countByTreeID(java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTreeID(treeID);
    }

    /**
    * Returns all the l f activity state nodes where treeID = &#63; and parentID = &#63;.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @return the matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeIDAndParentID(
        java.lang.Integer treeID, java.lang.Integer parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTreeIDAndParentID(treeID, parentID);
    }

    /**
    * Returns a range of all the l f activity state nodes where treeID = &#63; and parentID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @param start the lower bound of the range of l f activity state nodes
    * @param end the upper bound of the range of l f activity state nodes (not inclusive)
    * @return the range of matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeIDAndParentID(
        java.lang.Integer treeID, java.lang.Integer parentID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTreeIDAndParentID(treeID, parentID, start, end);
    }

    /**
    * Returns an ordered range of all the l f activity state nodes where treeID = &#63; and parentID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @param start the lower bound of the range of l f activity state nodes
    * @param end the upper bound of the range of l f activity state nodes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeIDAndParentID(
        java.lang.Integer treeID, java.lang.Integer parentID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTreeIDAndParentID(treeID, parentID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f activity state node in the ordered set where treeID = &#63; and parentID = &#63;.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state node
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode findByTreeIDAndParentID_First(
        java.lang.Integer treeID, java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTreeIDAndParentID_First(treeID, parentID,
            orderByComparator);
    }

    /**
    * Returns the first l f activity state node in the ordered set where treeID = &#63; and parentID = &#63;.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state node, or <code>null</code> if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode fetchByTreeIDAndParentID_First(
        java.lang.Integer treeID, java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByTreeIDAndParentID_First(treeID, parentID,
            orderByComparator);
    }

    /**
    * Returns the last l f activity state node in the ordered set where treeID = &#63; and parentID = &#63;.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state node
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode findByTreeIDAndParentID_Last(
        java.lang.Integer treeID, java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTreeIDAndParentID_Last(treeID, parentID,
            orderByComparator);
    }

    /**
    * Returns the last l f activity state node in the ordered set where treeID = &#63; and parentID = &#63;.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state node, or <code>null</code> if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode fetchByTreeIDAndParentID_Last(
        java.lang.Integer treeID, java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByTreeIDAndParentID_Last(treeID, parentID,
            orderByComparator);
    }

    /**
    * Returns the l f activity state nodes before and after the current l f activity state node in the ordered set where treeID = &#63; and parentID = &#63;.
    *
    * @param id the primary key of the current l f activity state node
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity state node
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a l f activity state node with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode[] findByTreeIDAndParentID_PrevAndNext(
        long id, java.lang.Integer treeID, java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTreeIDAndParentID_PrevAndNext(id, treeID, parentID,
            orderByComparator);
    }

    /**
    * Removes all the l f activity state nodes where treeID = &#63; and parentID = &#63; from the database.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByTreeIDAndParentID(java.lang.Integer treeID,
        java.lang.Integer parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByTreeIDAndParentID(treeID, parentID);
    }

    /**
    * Returns the number of l f activity state nodes where treeID = &#63; and parentID = &#63;.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @return the number of matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static int countByTreeIDAndParentID(java.lang.Integer treeID,
        java.lang.Integer parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTreeIDAndParentID(treeID, parentID);
    }

    /**
    * Caches the l f activity state node in the entity cache if it is enabled.
    *
    * @param lfActivityStateNode the l f activity state node
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateNode lfActivityStateNode) {
        getPersistence().cacheResult(lfActivityStateNode);
    }

    /**
    * Caches the l f activity state nodes in the entity cache if it is enabled.
    *
    * @param lfActivityStateNodes the l f activity state nodes
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> lfActivityStateNodes) {
        getPersistence().cacheResult(lfActivityStateNodes);
    }

    /**
    * Creates a new l f activity state node with the primary key. Does not add the l f activity state node to the database.
    *
    * @param id the primary key for the new l f activity state node
    * @return the new l f activity state node
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f activity state node with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity state node
    * @return the l f activity state node that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a l f activity state node with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateNode lfActivityStateNode)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfActivityStateNode);
    }

    /**
    * Returns the l f activity state node with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException} if it could not be found.
    *
    * @param id the primary key of the l f activity state node
    * @return the l f activity state node
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a l f activity state node with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f activity state node with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f activity state node
    * @return the l f activity state node, or <code>null</code> if a l f activity state node with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityStateNode fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f activity state nodes.
    *
    * @return the l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f activity state nodes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activity state nodes
    * @param end the upper bound of the range of l f activity state nodes (not inclusive)
    * @return the range of l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f activity state nodes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activity state nodes
    * @param end the upper bound of the range of l f activity state nodes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f activity state nodes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f activity state nodes.
    *
    * @return the number of l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFActivityStateNodePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFActivityStateNodePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFActivityStateNodePersistence.class.getName());

            ReferenceRegistry.registerReference(LFActivityStateNodeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFActivityStateNodePersistence persistence) {
    }
}
