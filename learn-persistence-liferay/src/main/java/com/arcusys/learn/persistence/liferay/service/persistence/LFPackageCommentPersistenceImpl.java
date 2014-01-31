package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException;
import com.arcusys.learn.persistence.liferay.model.LFPackageComment;
import com.arcusys.learn.persistence.liferay.model.impl.LFPackageCommentImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFPackageCommentModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageCommentPersistence;

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
 * The persistence implementation for the l f package comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageCommentPersistence
 * @see LFPackageCommentUtil
 * @generated
 */
public class LFPackageCommentPersistenceImpl extends BasePersistenceImpl<LFPackageComment>
    implements LFPackageCommentPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFPackageCommentUtil} to access the l f package comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFPackageCommentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageCommentModelImpl.FINDER_CACHE_ENABLED,
            LFPackageCommentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageCommentModelImpl.FINDER_CACHE_ENABLED,
            LFPackageCommentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageCommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCIALPACKAGEID =
        new FinderPath(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageCommentModelImpl.FINDER_CACHE_ENABLED,
            LFPackageCommentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBySocialPackageID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID =
        new FinderPath(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageCommentModelImpl.FINDER_CACHE_ENABLED,
            LFPackageCommentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySocialPackageID",
            new String[] { Integer.class.getName() },
            LFPackageCommentModelImpl.SOCIALPACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SOCIALPACKAGEID = new FinderPath(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageCommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBySocialPackageID", new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_NULL =
        "lfPackageComment.socialPackageID IS NULL";
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_2 =
        "lfPackageComment.socialPackageID = ?";
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_NULL_2 =
        "lfPackageComment.socialPackageID IS NULL ";
    private static final String _SQL_SELECT_LFPACKAGECOMMENT = "SELECT lfPackageComment FROM LFPackageComment lfPackageComment";
    private static final String _SQL_SELECT_LFPACKAGECOMMENT_WHERE = "SELECT lfPackageComment FROM LFPackageComment lfPackageComment WHERE ";
    private static final String _SQL_COUNT_LFPACKAGECOMMENT = "SELECT COUNT(lfPackageComment) FROM LFPackageComment lfPackageComment";
    private static final String _SQL_COUNT_LFPACKAGECOMMENT_WHERE = "SELECT COUNT(lfPackageComment) FROM LFPackageComment lfPackageComment WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfPackageComment.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFPackageComment exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFPackageComment exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFPackageCommentPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id", "comment"
            });
    private static LFPackageComment _nullLFPackageComment = new LFPackageCommentImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFPackageComment> toCacheModel() {
                return _nullLFPackageCommentCacheModel;
            }
        };

    private static CacheModel<LFPackageComment> _nullLFPackageCommentCacheModel = new CacheModel<LFPackageComment>() {
            @Override
            public LFPackageComment toEntityModel() {
                return _nullLFPackageComment;
            }
        };

    public LFPackageCommentPersistenceImpl() {
        setModelClass(LFPackageComment.class);
    }

    /**
     * Returns all the l f package comments where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @return the matching l f package comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageComment> findBySocialPackageID(Integer socialPackageID)
        throws SystemException {
        return findBySocialPackageID(socialPackageID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f package comments where socialPackageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param socialPackageID the social package i d
     * @param start the lower bound of the range of l f package comments
     * @param end the upper bound of the range of l f package comments (not inclusive)
     * @return the range of matching l f package comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageComment> findBySocialPackageID(
        Integer socialPackageID, int start, int end) throws SystemException {
        return findBySocialPackageID(socialPackageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f package comments where socialPackageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param socialPackageID the social package i d
     * @param start the lower bound of the range of l f package comments
     * @param end the upper bound of the range of l f package comments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f package comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageComment> findBySocialPackageID(
        Integer socialPackageID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID;
            finderArgs = new Object[] { socialPackageID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCIALPACKAGEID;
            finderArgs = new Object[] {
                    socialPackageID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFPackageComment> list = (List<LFPackageComment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFPackageComment lfPackageComment : list) {
                if (!Validator.equals(socialPackageID,
                            lfPackageComment.getSocialPackageID())) {
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

            query.append(_SQL_SELECT_LFPACKAGECOMMENT_WHERE);

            if (socialPackageID == null) {
                query.append(_FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFPackageCommentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (socialPackageID != null) {
                    qPos.add(socialPackageID.intValue());
                }

                if (!pagination) {
                    list = (List<LFPackageComment>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackageComment>(list);
                } else {
                    list = (List<LFPackageComment>) QueryUtil.list(q,
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
     * Returns the first l f package comment in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package comment
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a matching l f package comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageComment findBySocialPackageID_First(
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws NoSuchLFPackageCommentException, SystemException {
        LFPackageComment lfPackageComment = fetchBySocialPackageID_First(socialPackageID,
                orderByComparator);

        if (lfPackageComment != null) {
            return lfPackageComment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("socialPackageID=");
        msg.append(socialPackageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageCommentException(msg.toString());
    }

    /**
     * Returns the first l f package comment in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package comment, or <code>null</code> if a matching l f package comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageComment fetchBySocialPackageID_First(
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFPackageComment> list = findBySocialPackageID(socialPackageID, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f package comment in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package comment
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a matching l f package comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageComment findBySocialPackageID_Last(
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws NoSuchLFPackageCommentException, SystemException {
        LFPackageComment lfPackageComment = fetchBySocialPackageID_Last(socialPackageID,
                orderByComparator);

        if (lfPackageComment != null) {
            return lfPackageComment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("socialPackageID=");
        msg.append(socialPackageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageCommentException(msg.toString());
    }

    /**
     * Returns the last l f package comment in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package comment, or <code>null</code> if a matching l f package comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageComment fetchBySocialPackageID_Last(
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countBySocialPackageID(socialPackageID);

        if (count == 0) {
            return null;
        }

        List<LFPackageComment> list = findBySocialPackageID(socialPackageID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f package comments before and after the current l f package comment in the ordered set where socialPackageID = &#63;.
     *
     * @param id the primary key of the current l f package comment
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f package comment
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a l f package comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageComment[] findBySocialPackageID_PrevAndNext(long id,
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws NoSuchLFPackageCommentException, SystemException {
        LFPackageComment lfPackageComment = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFPackageComment[] array = new LFPackageCommentImpl[3];

            array[0] = getBySocialPackageID_PrevAndNext(session,
                    lfPackageComment, socialPackageID, orderByComparator, true);

            array[1] = lfPackageComment;

            array[2] = getBySocialPackageID_PrevAndNext(session,
                    lfPackageComment, socialPackageID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFPackageComment getBySocialPackageID_PrevAndNext(
        Session session, LFPackageComment lfPackageComment,
        Integer socialPackageID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFPACKAGECOMMENT_WHERE);

        if (socialPackageID == null) {
            query.append(_FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_2);
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
            query.append(LFPackageCommentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (socialPackageID != null) {
            qPos.add(socialPackageID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfPackageComment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFPackageComment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f package comments where socialPackageID = &#63; from the database.
     *
     * @param socialPackageID the social package i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySocialPackageID(Integer socialPackageID)
        throws SystemException {
        for (LFPackageComment lfPackageComment : findBySocialPackageID(
                socialPackageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfPackageComment);
        }
    }

    /**
     * Returns the number of l f package comments where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @return the number of matching l f package comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySocialPackageID(Integer socialPackageID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SOCIALPACKAGEID;

        Object[] finderArgs = new Object[] { socialPackageID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFPACKAGECOMMENT_WHERE);

            if (socialPackageID == null) {
                query.append(_FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (socialPackageID != null) {
                    qPos.add(socialPackageID.intValue());
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
     * Caches the l f package comment in the entity cache if it is enabled.
     *
     * @param lfPackageComment the l f package comment
     */
    @Override
    public void cacheResult(LFPackageComment lfPackageComment) {
        EntityCacheUtil.putResult(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageCommentImpl.class, lfPackageComment.getPrimaryKey(),
            lfPackageComment);

        lfPackageComment.resetOriginalValues();
    }

    /**
     * Caches the l f package comments in the entity cache if it is enabled.
     *
     * @param lfPackageComments the l f package comments
     */
    @Override
    public void cacheResult(List<LFPackageComment> lfPackageComments) {
        for (LFPackageComment lfPackageComment : lfPackageComments) {
            if (EntityCacheUtil.getResult(
                        LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
                        LFPackageCommentImpl.class,
                        lfPackageComment.getPrimaryKey()) == null) {
                cacheResult(lfPackageComment);
            } else {
                lfPackageComment.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f package comments.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFPackageCommentImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFPackageCommentImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f package comment.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFPackageComment lfPackageComment) {
        EntityCacheUtil.removeResult(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageCommentImpl.class, lfPackageComment.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFPackageComment> lfPackageComments) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFPackageComment lfPackageComment : lfPackageComments) {
            EntityCacheUtil.removeResult(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
                LFPackageCommentImpl.class, lfPackageComment.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f package comment with the primary key. Does not add the l f package comment to the database.
     *
     * @param id the primary key for the new l f package comment
     * @return the new l f package comment
     */
    @Override
    public LFPackageComment create(long id) {
        LFPackageComment lfPackageComment = new LFPackageCommentImpl();

        lfPackageComment.setNew(true);
        lfPackageComment.setPrimaryKey(id);

        return lfPackageComment;
    }

    /**
     * Removes the l f package comment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f package comment
     * @return the l f package comment that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a l f package comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageComment remove(long id)
        throws NoSuchLFPackageCommentException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f package comment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f package comment
     * @return the l f package comment that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a l f package comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageComment remove(Serializable primaryKey)
        throws NoSuchLFPackageCommentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFPackageComment lfPackageComment = (LFPackageComment) session.get(LFPackageCommentImpl.class,
                    primaryKey);

            if (lfPackageComment == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFPackageCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfPackageComment);
        } catch (NoSuchLFPackageCommentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFPackageComment removeImpl(LFPackageComment lfPackageComment)
        throws SystemException {
        lfPackageComment = toUnwrappedModel(lfPackageComment);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfPackageComment)) {
                lfPackageComment = (LFPackageComment) session.get(LFPackageCommentImpl.class,
                        lfPackageComment.getPrimaryKeyObj());
            }

            if (lfPackageComment != null) {
                session.delete(lfPackageComment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfPackageComment != null) {
            clearCache(lfPackageComment);
        }

        return lfPackageComment;
    }

    @Override
    public LFPackageComment updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPackageComment lfPackageComment)
        throws SystemException {
        lfPackageComment = toUnwrappedModel(lfPackageComment);

        boolean isNew = lfPackageComment.isNew();

        LFPackageCommentModelImpl lfPackageCommentModelImpl = (LFPackageCommentModelImpl) lfPackageComment;

        Session session = null;

        try {
            session = openSession();

            if (lfPackageComment.isNew()) {
                session.save(lfPackageComment);

                lfPackageComment.setNew(false);
            } else {
                session.merge(lfPackageComment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFPackageCommentModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfPackageCommentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPackageCommentModelImpl.getOriginalSocialPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCIALPACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID,
                    args);

                args = new Object[] {
                        lfPackageCommentModelImpl.getSocialPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCIALPACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageCommentImpl.class, lfPackageComment.getPrimaryKey(),
            lfPackageComment);

        return lfPackageComment;
    }

    protected LFPackageComment toUnwrappedModel(
        LFPackageComment lfPackageComment) {
        if (lfPackageComment instanceof LFPackageCommentImpl) {
            return lfPackageComment;
        }

        LFPackageCommentImpl lfPackageCommentImpl = new LFPackageCommentImpl();

        lfPackageCommentImpl.setNew(lfPackageComment.isNew());
        lfPackageCommentImpl.setPrimaryKey(lfPackageComment.getPrimaryKey());

        lfPackageCommentImpl.setId(lfPackageComment.getId());
        lfPackageCommentImpl.setSocialPackageID(lfPackageComment.getSocialPackageID());
        lfPackageCommentImpl.setAuthorID(lfPackageComment.getAuthorID());
        lfPackageCommentImpl.setComment(lfPackageComment.getComment());
        lfPackageCommentImpl.setPublishDate(lfPackageComment.getPublishDate());

        return lfPackageCommentImpl;
    }

    /**
     * Returns the l f package comment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f package comment
     * @return the l f package comment
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a l f package comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageComment findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFPackageCommentException, SystemException {
        LFPackageComment lfPackageComment = fetchByPrimaryKey(primaryKey);

        if (lfPackageComment == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFPackageCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfPackageComment;
    }

    /**
     * Returns the l f package comment with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException} if it could not be found.
     *
     * @param id the primary key of the l f package comment
     * @return the l f package comment
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a l f package comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageComment findByPrimaryKey(long id)
        throws NoSuchLFPackageCommentException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f package comment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f package comment
     * @return the l f package comment, or <code>null</code> if a l f package comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageComment fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFPackageComment lfPackageComment = (LFPackageComment) EntityCacheUtil.getResult(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
                LFPackageCommentImpl.class, primaryKey);

        if (lfPackageComment == _nullLFPackageComment) {
            return null;
        }

        if (lfPackageComment == null) {
            Session session = null;

            try {
                session = openSession();

                lfPackageComment = (LFPackageComment) session.get(LFPackageCommentImpl.class,
                        primaryKey);

                if (lfPackageComment != null) {
                    cacheResult(lfPackageComment);
                } else {
                    EntityCacheUtil.putResult(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
                        LFPackageCommentImpl.class, primaryKey,
                        _nullLFPackageComment);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFPackageCommentModelImpl.ENTITY_CACHE_ENABLED,
                    LFPackageCommentImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfPackageComment;
    }

    /**
     * Returns the l f package comment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f package comment
     * @return the l f package comment, or <code>null</code> if a l f package comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageComment fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f package comments.
     *
     * @return the l f package comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageComment> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f package comments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f package comments
     * @param end the upper bound of the range of l f package comments (not inclusive)
     * @return the range of l f package comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageComment> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f package comments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f package comments
     * @param end the upper bound of the range of l f package comments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f package comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageComment> findAll(int start, int end,
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

        List<LFPackageComment> list = (List<LFPackageComment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFPACKAGECOMMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFPACKAGECOMMENT;

                if (pagination) {
                    sql = sql.concat(LFPackageCommentModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFPackageComment>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackageComment>(list);
                } else {
                    list = (List<LFPackageComment>) QueryUtil.list(q,
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
     * Removes all the l f package comments from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFPackageComment lfPackageComment : findAll()) {
            remove(lfPackageComment);
        }
    }

    /**
     * Returns the number of l f package comments.
     *
     * @return the number of l f package comments
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

                Query q = session.createQuery(_SQL_COUNT_LFPACKAGECOMMENT);

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
     * Initializes the l f package comment persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFPackageComment")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFPackageComment>> listenersList = new ArrayList<ModelListener<LFPackageComment>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFPackageComment>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFPackageCommentImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
