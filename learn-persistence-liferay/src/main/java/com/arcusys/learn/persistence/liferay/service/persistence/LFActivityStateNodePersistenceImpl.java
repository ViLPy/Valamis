package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateNode;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateNodeImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateNodeModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateNodePersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the l f activity state node service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateNodePersistence
 * @see LFActivityStateNodeUtil
 * @generated
 */
public class LFActivityStateNodePersistenceImpl extends BasePersistenceImpl<LFActivityStateNode>
    implements LFActivityStateNodePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFActivityStateNodeUtil} to access the l f activity state node persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFActivityStateNodeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateNodeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateNodeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TREEID = new FinderPath(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateNodeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTreeID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID =
        new FinderPath(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateNodeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTreeID",
            new String[] { Integer.class.getName() },
            LFActivityStateNodeModelImpl.TREEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TREEID = new FinderPath(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTreeID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_TREEID_TREEID_NULL = "lfActivityStateNode.treeID IS NULL";
    private static final String _FINDER_COLUMN_TREEID_TREEID_2 = "lfActivityStateNode.treeID = ?";
    private static final String _FINDER_COLUMN_TREEID_TREEID_NULL_2 = "lfActivityStateNode.treeID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TREEIDANDPARENTID =
        new FinderPath(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateNodeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTreeIDAndParentID",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEIDANDPARENTID =
        new FinderPath(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateNodeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByTreeIDAndParentID",
            new String[] { Integer.class.getName(), Integer.class.getName() },
            LFActivityStateNodeModelImpl.TREEID_COLUMN_BITMASK |
            LFActivityStateNodeModelImpl.PARENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TREEIDANDPARENTID = new FinderPath(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByTreeIDAndParentID",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_TREEIDANDPARENTID_TREEID_NULL = "lfActivityStateNode.treeID IS NULL";
    private static final String _FINDER_COLUMN_TREEIDANDPARENTID_TREEID_2 = "lfActivityStateNode.treeID = ? AND ";
    private static final String _FINDER_COLUMN_TREEIDANDPARENTID_TREEID_NULL_2 = "lfActivityStateNode.treeID IS NULL  AND ";
    private static final String _FINDER_COLUMN_TREEIDANDPARENTID_PARENTID_NULL = "lfActivityStateNode.parentID IS NULL";
    private static final String _FINDER_COLUMN_TREEIDANDPARENTID_PARENTID_2 = "lfActivityStateNode.parentID = ?";
    private static final String _FINDER_COLUMN_TREEIDANDPARENTID_PARENTID_NULL_2 =
        "lfActivityStateNode.parentID IS NULL ";
    private static final String _SQL_SELECT_LFACTIVITYSTATENODE = "SELECT lfActivityStateNode FROM LFActivityStateNode lfActivityStateNode";
    private static final String _SQL_SELECT_LFACTIVITYSTATENODE_WHERE = "SELECT lfActivityStateNode FROM LFActivityStateNode lfActivityStateNode WHERE ";
    private static final String _SQL_COUNT_LFACTIVITYSTATENODE = "SELECT COUNT(lfActivityStateNode) FROM LFActivityStateNode lfActivityStateNode";
    private static final String _SQL_COUNT_LFACTIVITYSTATENODE_WHERE = "SELECT COUNT(lfActivityStateNode) FROM LFActivityStateNode lfActivityStateNode WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfActivityStateNode.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFActivityStateNode exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFActivityStateNode exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFActivityStateNodePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFActivityStateNode _nullLFActivityStateNode = new LFActivityStateNodeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFActivityStateNode> toCacheModel() {
                return _nullLFActivityStateNodeCacheModel;
            }
        };

    private static CacheModel<LFActivityStateNode> _nullLFActivityStateNodeCacheModel =
        new CacheModel<LFActivityStateNode>() {
            @Override
            public LFActivityStateNode toEntityModel() {
                return _nullLFActivityStateNode;
            }
        };

    public LFActivityStateNodePersistenceImpl() {
        setModelClass(LFActivityStateNode.class);
    }

    /**
     * Returns all the l f activity state nodes where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @return the matching l f activity state nodes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityStateNode> findByTreeID(Integer treeID)
        throws SystemException {
        return findByTreeID(treeID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<LFActivityStateNode> findByTreeID(Integer treeID, int start,
        int end) throws SystemException {
        return findByTreeID(treeID, start, end, null);
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
    @Override
    public List<LFActivityStateNode> findByTreeID(Integer treeID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID;
            finderArgs = new Object[] { treeID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TREEID;
            finderArgs = new Object[] { treeID, start, end, orderByComparator };
        }

        List<LFActivityStateNode> list = (List<LFActivityStateNode>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivityStateNode lfActivityStateNode : list) {
                if (!Validator.equals(treeID, lfActivityStateNode.getTreeID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_LFACTIVITYSTATENODE_WHERE);

            if (treeID == null) {
                query.append(_FINDER_COLUMN_TREEID_TREEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TREEID_TREEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFActivityStateNodeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (treeID != null) {
                    qPos.add(treeID.intValue());
                }

                if (!pagination) {
                    list = (List<LFActivityStateNode>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFActivityStateNode>(list);
                } else {
                    list = (List<LFActivityStateNode>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public LFActivityStateNode findByTreeID_First(Integer treeID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateNodeException, SystemException {
        LFActivityStateNode lfActivityStateNode = fetchByTreeID_First(treeID,
                orderByComparator);

        if (lfActivityStateNode != null) {
            return lfActivityStateNode;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("treeID=");
        msg.append(treeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityStateNodeException(msg.toString());
    }

    /**
     * Returns the first l f activity state node in the ordered set where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity state node, or <code>null</code> if a matching l f activity state node could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateNode fetchByTreeID_First(Integer treeID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFActivityStateNode> list = findByTreeID(treeID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public LFActivityStateNode findByTreeID_Last(Integer treeID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateNodeException, SystemException {
        LFActivityStateNode lfActivityStateNode = fetchByTreeID_Last(treeID,
                orderByComparator);

        if (lfActivityStateNode != null) {
            return lfActivityStateNode;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("treeID=");
        msg.append(treeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityStateNodeException(msg.toString());
    }

    /**
     * Returns the last l f activity state node in the ordered set where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity state node, or <code>null</code> if a matching l f activity state node could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateNode fetchByTreeID_Last(Integer treeID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByTreeID(treeID);

        if (count == 0) {
            return null;
        }

        List<LFActivityStateNode> list = findByTreeID(treeID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public LFActivityStateNode[] findByTreeID_PrevAndNext(long id,
        Integer treeID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateNodeException, SystemException {
        LFActivityStateNode lfActivityStateNode = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFActivityStateNode[] array = new LFActivityStateNodeImpl[3];

            array[0] = getByTreeID_PrevAndNext(session, lfActivityStateNode,
                    treeID, orderByComparator, true);

            array[1] = lfActivityStateNode;

            array[2] = getByTreeID_PrevAndNext(session, lfActivityStateNode,
                    treeID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivityStateNode getByTreeID_PrevAndNext(Session session,
        LFActivityStateNode lfActivityStateNode, Integer treeID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITYSTATENODE_WHERE);

        if (treeID == null) {
            query.append(_FINDER_COLUMN_TREEID_TREEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_TREEID_TREEID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(LFActivityStateNodeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (treeID != null) {
            qPos.add(treeID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivityStateNode);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivityStateNode> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f activity state nodes where treeID = &#63; from the database.
     *
     * @param treeID the tree i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByTreeID(Integer treeID) throws SystemException {
        for (LFActivityStateNode lfActivityStateNode : findByTreeID(treeID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfActivityStateNode);
        }
    }

    /**
     * Returns the number of l f activity state nodes where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @return the number of matching l f activity state nodes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTreeID(Integer treeID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TREEID;

        Object[] finderArgs = new Object[] { treeID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFACTIVITYSTATENODE_WHERE);

            if (treeID == null) {
                query.append(_FINDER_COLUMN_TREEID_TREEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TREEID_TREEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (treeID != null) {
                    qPos.add(treeID.intValue());
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the l f activity state nodes where treeID = &#63; and parentID = &#63;.
     *
     * @param treeID the tree i d
     * @param parentID the parent i d
     * @return the matching l f activity state nodes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityStateNode> findByTreeIDAndParentID(Integer treeID,
        Integer parentID) throws SystemException {
        return findByTreeIDAndParentID(treeID, parentID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<LFActivityStateNode> findByTreeIDAndParentID(Integer treeID,
        Integer parentID, int start, int end) throws SystemException {
        return findByTreeIDAndParentID(treeID, parentID, start, end, null);
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
    @Override
    public List<LFActivityStateNode> findByTreeIDAndParentID(Integer treeID,
        Integer parentID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEIDANDPARENTID;
            finderArgs = new Object[] { treeID, parentID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TREEIDANDPARENTID;
            finderArgs = new Object[] {
                    treeID, parentID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivityStateNode> list = (List<LFActivityStateNode>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivityStateNode lfActivityStateNode : list) {
                if (!Validator.equals(treeID, lfActivityStateNode.getTreeID()) ||
                        !Validator.equals(parentID,
                            lfActivityStateNode.getParentID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_LFACTIVITYSTATENODE_WHERE);

            if (treeID == null) {
                query.append(_FINDER_COLUMN_TREEIDANDPARENTID_TREEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TREEIDANDPARENTID_TREEID_2);
            }

            if (parentID == null) {
                query.append(_FINDER_COLUMN_TREEIDANDPARENTID_PARENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TREEIDANDPARENTID_PARENTID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFActivityStateNodeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (treeID != null) {
                    qPos.add(treeID.intValue());
                }

                if (parentID != null) {
                    qPos.add(parentID.intValue());
                }

                if (!pagination) {
                    list = (List<LFActivityStateNode>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFActivityStateNode>(list);
                } else {
                    list = (List<LFActivityStateNode>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public LFActivityStateNode findByTreeIDAndParentID_First(Integer treeID,
        Integer parentID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateNodeException, SystemException {
        LFActivityStateNode lfActivityStateNode = fetchByTreeIDAndParentID_First(treeID,
                parentID, orderByComparator);

        if (lfActivityStateNode != null) {
            return lfActivityStateNode;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("treeID=");
        msg.append(treeID);

        msg.append(", parentID=");
        msg.append(parentID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityStateNodeException(msg.toString());
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
    @Override
    public LFActivityStateNode fetchByTreeIDAndParentID_First(Integer treeID,
        Integer parentID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFActivityStateNode> list = findByTreeIDAndParentID(treeID,
                parentID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public LFActivityStateNode findByTreeIDAndParentID_Last(Integer treeID,
        Integer parentID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateNodeException, SystemException {
        LFActivityStateNode lfActivityStateNode = fetchByTreeIDAndParentID_Last(treeID,
                parentID, orderByComparator);

        if (lfActivityStateNode != null) {
            return lfActivityStateNode;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("treeID=");
        msg.append(treeID);

        msg.append(", parentID=");
        msg.append(parentID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityStateNodeException(msg.toString());
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
    @Override
    public LFActivityStateNode fetchByTreeIDAndParentID_Last(Integer treeID,
        Integer parentID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByTreeIDAndParentID(treeID, parentID);

        if (count == 0) {
            return null;
        }

        List<LFActivityStateNode> list = findByTreeIDAndParentID(treeID,
                parentID, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public LFActivityStateNode[] findByTreeIDAndParentID_PrevAndNext(long id,
        Integer treeID, Integer parentID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateNodeException, SystemException {
        LFActivityStateNode lfActivityStateNode = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFActivityStateNode[] array = new LFActivityStateNodeImpl[3];

            array[0] = getByTreeIDAndParentID_PrevAndNext(session,
                    lfActivityStateNode, treeID, parentID, orderByComparator,
                    true);

            array[1] = lfActivityStateNode;

            array[2] = getByTreeIDAndParentID_PrevAndNext(session,
                    lfActivityStateNode, treeID, parentID, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivityStateNode getByTreeIDAndParentID_PrevAndNext(
        Session session, LFActivityStateNode lfActivityStateNode,
        Integer treeID, Integer parentID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITYSTATENODE_WHERE);

        if (treeID == null) {
            query.append(_FINDER_COLUMN_TREEIDANDPARENTID_TREEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_TREEIDANDPARENTID_TREEID_2);
        }

        if (parentID == null) {
            query.append(_FINDER_COLUMN_TREEIDANDPARENTID_PARENTID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_TREEIDANDPARENTID_PARENTID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(LFActivityStateNodeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (treeID != null) {
            qPos.add(treeID.intValue());
        }

        if (parentID != null) {
            qPos.add(parentID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivityStateNode);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivityStateNode> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f activity state nodes where treeID = &#63; and parentID = &#63; from the database.
     *
     * @param treeID the tree i d
     * @param parentID the parent i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByTreeIDAndParentID(Integer treeID, Integer parentID)
        throws SystemException {
        for (LFActivityStateNode lfActivityStateNode : findByTreeIDAndParentID(
                treeID, parentID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfActivityStateNode);
        }
    }

    /**
     * Returns the number of l f activity state nodes where treeID = &#63; and parentID = &#63;.
     *
     * @param treeID the tree i d
     * @param parentID the parent i d
     * @return the number of matching l f activity state nodes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTreeIDAndParentID(Integer treeID, Integer parentID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TREEIDANDPARENTID;

        Object[] finderArgs = new Object[] { treeID, parentID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFACTIVITYSTATENODE_WHERE);

            if (treeID == null) {
                query.append(_FINDER_COLUMN_TREEIDANDPARENTID_TREEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TREEIDANDPARENTID_TREEID_2);
            }

            if (parentID == null) {
                query.append(_FINDER_COLUMN_TREEIDANDPARENTID_PARENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TREEIDANDPARENTID_PARENTID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (treeID != null) {
                    qPos.add(treeID.intValue());
                }

                if (parentID != null) {
                    qPos.add(parentID.intValue());
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the l f activity state node in the entity cache if it is enabled.
     *
     * @param lfActivityStateNode the l f activity state node
     */
    @Override
    public void cacheResult(LFActivityStateNode lfActivityStateNode) {
        EntityCacheUtil.putResult(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeImpl.class, lfActivityStateNode.getPrimaryKey(),
            lfActivityStateNode);

        lfActivityStateNode.resetOriginalValues();
    }

    /**
     * Caches the l f activity state nodes in the entity cache if it is enabled.
     *
     * @param lfActivityStateNodes the l f activity state nodes
     */
    @Override
    public void cacheResult(List<LFActivityStateNode> lfActivityStateNodes) {
        for (LFActivityStateNode lfActivityStateNode : lfActivityStateNodes) {
            if (EntityCacheUtil.getResult(
                        LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityStateNodeImpl.class,
                        lfActivityStateNode.getPrimaryKey()) == null) {
                cacheResult(lfActivityStateNode);
            } else {
                lfActivityStateNode.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f activity state nodes.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFActivityStateNodeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFActivityStateNodeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f activity state node.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFActivityStateNode lfActivityStateNode) {
        EntityCacheUtil.removeResult(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeImpl.class, lfActivityStateNode.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFActivityStateNode> lfActivityStateNodes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFActivityStateNode lfActivityStateNode : lfActivityStateNodes) {
            EntityCacheUtil.removeResult(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityStateNodeImpl.class,
                lfActivityStateNode.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f activity state node with the primary key. Does not add the l f activity state node to the database.
     *
     * @param id the primary key for the new l f activity state node
     * @return the new l f activity state node
     */
    @Override
    public LFActivityStateNode create(long id) {
        LFActivityStateNode lfActivityStateNode = new LFActivityStateNodeImpl();

        lfActivityStateNode.setNew(true);
        lfActivityStateNode.setPrimaryKey(id);

        return lfActivityStateNode;
    }

    /**
     * Removes the l f activity state node with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f activity state node
     * @return the l f activity state node that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a l f activity state node with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateNode remove(long id)
        throws NoSuchLFActivityStateNodeException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f activity state node with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f activity state node
     * @return the l f activity state node that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a l f activity state node with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateNode remove(Serializable primaryKey)
        throws NoSuchLFActivityStateNodeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFActivityStateNode lfActivityStateNode = (LFActivityStateNode) session.get(LFActivityStateNodeImpl.class,
                    primaryKey);

            if (lfActivityStateNode == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFActivityStateNodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfActivityStateNode);
        } catch (NoSuchLFActivityStateNodeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFActivityStateNode removeImpl(
        LFActivityStateNode lfActivityStateNode) throws SystemException {
        lfActivityStateNode = toUnwrappedModel(lfActivityStateNode);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfActivityStateNode)) {
                lfActivityStateNode = (LFActivityStateNode) session.get(LFActivityStateNodeImpl.class,
                        lfActivityStateNode.getPrimaryKeyObj());
            }

            if (lfActivityStateNode != null) {
                session.delete(lfActivityStateNode);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfActivityStateNode != null) {
            clearCache(lfActivityStateNode);
        }

        return lfActivityStateNode;
    }

    @Override
    public LFActivityStateNode updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateNode lfActivityStateNode)
        throws SystemException {
        lfActivityStateNode = toUnwrappedModel(lfActivityStateNode);

        boolean isNew = lfActivityStateNode.isNew();

        LFActivityStateNodeModelImpl lfActivityStateNodeModelImpl = (LFActivityStateNodeModelImpl) lfActivityStateNode;

        Session session = null;

        try {
            session = openSession();

            if (lfActivityStateNode.isNew()) {
                session.save(lfActivityStateNode);

                lfActivityStateNode.setNew(false);
            } else {
                session.merge(lfActivityStateNode);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFActivityStateNodeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfActivityStateNodeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfActivityStateNodeModelImpl.getOriginalTreeID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID,
                    args);

                args = new Object[] { lfActivityStateNodeModelImpl.getTreeID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID,
                    args);
            }

            if ((lfActivityStateNodeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEIDANDPARENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfActivityStateNodeModelImpl.getOriginalTreeID(),
                        lfActivityStateNodeModelImpl.getOriginalParentID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEIDANDPARENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEIDANDPARENTID,
                    args);

                args = new Object[] {
                        lfActivityStateNodeModelImpl.getTreeID(),
                        lfActivityStateNodeModelImpl.getParentID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEIDANDPARENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEIDANDPARENTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateNodeImpl.class, lfActivityStateNode.getPrimaryKey(),
            lfActivityStateNode);

        return lfActivityStateNode;
    }

    protected LFActivityStateNode toUnwrappedModel(
        LFActivityStateNode lfActivityStateNode) {
        if (lfActivityStateNode instanceof LFActivityStateNodeImpl) {
            return lfActivityStateNode;
        }

        LFActivityStateNodeImpl lfActivityStateNodeImpl = new LFActivityStateNodeImpl();

        lfActivityStateNodeImpl.setNew(lfActivityStateNode.isNew());
        lfActivityStateNodeImpl.setPrimaryKey(lfActivityStateNode.getPrimaryKey());

        lfActivityStateNodeImpl.setId(lfActivityStateNode.getId());
        lfActivityStateNodeImpl.setParentID(lfActivityStateNode.getParentID());
        lfActivityStateNodeImpl.setTreeID(lfActivityStateNode.getTreeID());
        lfActivityStateNodeImpl.setAvailableChildrenIDs(lfActivityStateNode.getAvailableChildrenIDs());

        return lfActivityStateNodeImpl;
    }

    /**
     * Returns the l f activity state node with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity state node
     * @return the l f activity state node
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a l f activity state node with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateNode findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFActivityStateNodeException, SystemException {
        LFActivityStateNode lfActivityStateNode = fetchByPrimaryKey(primaryKey);

        if (lfActivityStateNode == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFActivityStateNodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfActivityStateNode;
    }

    /**
     * Returns the l f activity state node with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException} if it could not be found.
     *
     * @param id the primary key of the l f activity state node
     * @return the l f activity state node
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException if a l f activity state node with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateNode findByPrimaryKey(long id)
        throws NoSuchLFActivityStateNodeException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f activity state node with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity state node
     * @return the l f activity state node, or <code>null</code> if a l f activity state node with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateNode fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFActivityStateNode lfActivityStateNode = (LFActivityStateNode) EntityCacheUtil.getResult(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityStateNodeImpl.class, primaryKey);

        if (lfActivityStateNode == _nullLFActivityStateNode) {
            return null;
        }

        if (lfActivityStateNode == null) {
            Session session = null;

            try {
                session = openSession();

                lfActivityStateNode = (LFActivityStateNode) session.get(LFActivityStateNodeImpl.class,
                        primaryKey);

                if (lfActivityStateNode != null) {
                    cacheResult(lfActivityStateNode);
                } else {
                    EntityCacheUtil.putResult(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityStateNodeImpl.class, primaryKey,
                        _nullLFActivityStateNode);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFActivityStateNodeModelImpl.ENTITY_CACHE_ENABLED,
                    LFActivityStateNodeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfActivityStateNode;
    }

    /**
     * Returns the l f activity state node with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f activity state node
     * @return the l f activity state node, or <code>null</code> if a l f activity state node with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateNode fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f activity state nodes.
     *
     * @return the l f activity state nodes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityStateNode> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<LFActivityStateNode> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<LFActivityStateNode> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<LFActivityStateNode> list = (List<LFActivityStateNode>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFACTIVITYSTATENODE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFACTIVITYSTATENODE;

                if (pagination) {
                    sql = sql.concat(LFActivityStateNodeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFActivityStateNode>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFActivityStateNode>(list);
                } else {
                    list = (List<LFActivityStateNode>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the l f activity state nodes from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFActivityStateNode lfActivityStateNode : findAll()) {
            remove(lfActivityStateNode);
        }
    }

    /**
     * Returns the number of l f activity state nodes.
     *
     * @return the number of l f activity state nodes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFACTIVITYSTATENODE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the l f activity state node persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFActivityStateNode")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFActivityStateNode>> listenersList = new ArrayList<ModelListener<LFActivityStateNode>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFActivityStateNode>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFActivityStateNodeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
