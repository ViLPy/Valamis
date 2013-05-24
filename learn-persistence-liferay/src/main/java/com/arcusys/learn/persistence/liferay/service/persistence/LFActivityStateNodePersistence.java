package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityStateNode;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f activity state node service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateNodePersistenceImpl
 * @see LFActivityStateNodeUtil
 * @generated
 */
public interface LFActivityStateNodePersistence extends BasePersistence<LFActivityStateNode> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFActivityStateNodeUtil} to access the l f activity state node persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f activity state node in the entity cache if it is enabled.
    *
    * @param lfActivityStateNode the l f activity state node
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateNode lfActivityStateNode);

    /**
    * Caches the l f activity state nodes in the entity cache if it is enabled.
    *
    * @param lfActivityStateNodes the l f activity state nodes
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> lfActivityStateNodes);

    /**
    * Creates a new l f activity state node with the primary key. Does not add the l f activity state node to the database.
    *
    * @param id the primary key for the new l f activity state node
    * @return the new l f activity state node
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode create(
        long id);

    /**
    * Removes the l f activity state node with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity state node
    * @return the l f activity state node that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a l f activity state node with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateNode lfActivityStateNode,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity state node with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException} if it could not be found.
    *
    * @param id the primary key of the l f activity state node
    * @return the l f activity state node
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a l f activity state node with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity state node with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f activity state node
    * @return the l f activity state node, or <code>null</code> if a l f activity state node with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity state nodes where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @return the matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeID(
        java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity state nodes where treeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param treeID the tree i d
    * @param start the lower bound of the range of l f activity state nodes
    * @param end the upper bound of the range of l f activity state nodes (not inclusive)
    * @return the range of matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeID(
        java.lang.Integer treeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity state nodes where treeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param treeID the tree i d
    * @param start the lower bound of the range of l f activity state nodes
    * @param end the upper bound of the range of l f activity state nodes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeID(
        java.lang.Integer treeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity state node in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state node
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode findByTreeID_First(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity state node in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state node, or <code>null</code> if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode fetchByTreeID_First(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity state node in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state node
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode findByTreeID_Last(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity state node in the ordered set where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state node, or <code>null</code> if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode fetchByTreeID_Last(
        java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode[] findByTreeID_PrevAndNext(
        long id, java.lang.Integer treeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity state nodes where treeID = &#63; and parentID = &#63;.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @return the matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeIDAndParentID(
        java.lang.Integer treeID, java.lang.Integer parentID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity state nodes where treeID = &#63; and parentID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @param start the lower bound of the range of l f activity state nodes
    * @param end the upper bound of the range of l f activity state nodes (not inclusive)
    * @return the range of matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeIDAndParentID(
        java.lang.Integer treeID, java.lang.Integer parentID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity state nodes where treeID = &#63; and parentID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findByTreeIDAndParentID(
        java.lang.Integer treeID, java.lang.Integer parentID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode findByTreeIDAndParentID_First(
        java.lang.Integer treeID, java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity state node in the ordered set where treeID = &#63; and parentID = &#63;.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity state node, or <code>null</code> if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode fetchByTreeIDAndParentID_First(
        java.lang.Integer treeID, java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode findByTreeIDAndParentID_Last(
        java.lang.Integer treeID, java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity state node in the ordered set where treeID = &#63; and parentID = &#63;.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity state node, or <code>null</code> if a matching l f activity state node could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode fetchByTreeIDAndParentID_Last(
        java.lang.Integer treeID, java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateNode[] findByTreeIDAndParentID_PrevAndNext(
        long id, java.lang.Integer treeID, java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity state nodes.
    *
    * @return the l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity state nodes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activity state nodes
    * @param end the upper bound of the range of l f activity state nodes (not inclusive)
    * @return the range of l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity state nodes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activity state nodes
    * @param end the upper bound of the range of l f activity state nodes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateNode> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activity state nodes where treeID = &#63; from the database.
    *
    * @param treeID the tree i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByTreeID(java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activity state nodes where treeID = &#63; and parentID = &#63; from the database.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByTreeIDAndParentID(java.lang.Integer treeID,
        java.lang.Integer parentID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activity state nodes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity state nodes where treeID = &#63;.
    *
    * @param treeID the tree i d
    * @return the number of matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public int countByTreeID(java.lang.Integer treeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity state nodes where treeID = &#63; and parentID = &#63;.
    *
    * @param treeID the tree i d
    * @param parentID the parent i d
    * @return the number of matching l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public int countByTreeIDAndParentID(java.lang.Integer treeID,
        java.lang.Integer parentID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity state nodes.
    *
    * @return the number of l f activity state nodes
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
