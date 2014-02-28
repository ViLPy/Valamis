package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException;
import com.arcusys.learn.persistence.liferay.model.LFPackageVote;
import com.arcusys.learn.persistence.liferay.model.impl.LFPackageVoteImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFPackageVoteModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageVotePersistence;

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
 * The persistence implementation for the l f package vote service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageVotePersistence
 * @see LFPackageVoteUtil
 * @generated
 */
public class LFPackageVotePersistenceImpl extends BasePersistenceImpl<LFPackageVote>
    implements LFPackageVotePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFPackageVoteUtil} to access the l f package vote persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFPackageVoteImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageVoteModelImpl.FINDER_CACHE_ENABLED,
            LFPackageVoteImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageVoteModelImpl.FINDER_CACHE_ENABLED,
            LFPackageVoteImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageVoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCIALPACKAGEID =
        new FinderPath(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageVoteModelImpl.FINDER_CACHE_ENABLED,
            LFPackageVoteImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBySocialPackageID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID =
        new FinderPath(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageVoteModelImpl.FINDER_CACHE_ENABLED,
            LFPackageVoteImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBySocialPackageID", new String[] { Integer.class.getName() },
            LFPackageVoteModelImpl.SOCIALPACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SOCIALPACKAGEID = new FinderPath(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageVoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBySocialPackageID", new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_NULL =
        "lfPackageVote.socialPackageID IS NULL";
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_2 =
        "lfPackageVote.socialPackageID = ?";
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_NULL_2 =
        "lfPackageVote.socialPackageID IS NULL ";
    private static final String _SQL_SELECT_LFPACKAGEVOTE = "SELECT lfPackageVote FROM LFPackageVote lfPackageVote";
    private static final String _SQL_SELECT_LFPACKAGEVOTE_WHERE = "SELECT lfPackageVote FROM LFPackageVote lfPackageVote WHERE ";
    private static final String _SQL_COUNT_LFPACKAGEVOTE = "SELECT COUNT(lfPackageVote) FROM LFPackageVote lfPackageVote";
    private static final String _SQL_COUNT_LFPACKAGEVOTE_WHERE = "SELECT COUNT(lfPackageVote) FROM LFPackageVote lfPackageVote WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfPackageVote.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFPackageVote exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFPackageVote exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFPackageVotePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFPackageVote _nullLFPackageVote = new LFPackageVoteImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFPackageVote> toCacheModel() {
                return _nullLFPackageVoteCacheModel;
            }
        };

    private static CacheModel<LFPackageVote> _nullLFPackageVoteCacheModel = new CacheModel<LFPackageVote>() {
            @Override
            public LFPackageVote toEntityModel() {
                return _nullLFPackageVote;
            }
        };

    public LFPackageVotePersistenceImpl() {
        setModelClass(LFPackageVote.class);
    }

    /**
     * Returns all the l f package votes where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @return the matching l f package votes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageVote> findBySocialPackageID(Integer socialPackageID)
        throws SystemException {
        return findBySocialPackageID(socialPackageID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f package votes where socialPackageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageVoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param socialPackageID the social package i d
     * @param start the lower bound of the range of l f package votes
     * @param end the upper bound of the range of l f package votes (not inclusive)
     * @return the range of matching l f package votes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageVote> findBySocialPackageID(Integer socialPackageID,
        int start, int end) throws SystemException {
        return findBySocialPackageID(socialPackageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f package votes where socialPackageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageVoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param socialPackageID the social package i d
     * @param start the lower bound of the range of l f package votes
     * @param end the upper bound of the range of l f package votes (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f package votes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageVote> findBySocialPackageID(Integer socialPackageID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
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

        List<LFPackageVote> list = (List<LFPackageVote>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFPackageVote lfPackageVote : list) {
                if (!Validator.equals(socialPackageID,
                            lfPackageVote.getSocialPackageID())) {
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

            query.append(_SQL_SELECT_LFPACKAGEVOTE_WHERE);

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
                query.append(LFPackageVoteModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFPackageVote>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackageVote>(list);
                } else {
                    list = (List<LFPackageVote>) QueryUtil.list(q,
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
     * Returns the first l f package vote in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package vote
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a matching l f package vote could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageVote findBySocialPackageID_First(Integer socialPackageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageVoteException, SystemException {
        LFPackageVote lfPackageVote = fetchBySocialPackageID_First(socialPackageID,
                orderByComparator);

        if (lfPackageVote != null) {
            return lfPackageVote;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("socialPackageID=");
        msg.append(socialPackageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageVoteException(msg.toString());
    }

    /**
     * Returns the first l f package vote in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package vote, or <code>null</code> if a matching l f package vote could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageVote fetchBySocialPackageID_First(Integer socialPackageID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFPackageVote> list = findBySocialPackageID(socialPackageID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f package vote in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package vote
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a matching l f package vote could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageVote findBySocialPackageID_Last(Integer socialPackageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageVoteException, SystemException {
        LFPackageVote lfPackageVote = fetchBySocialPackageID_Last(socialPackageID,
                orderByComparator);

        if (lfPackageVote != null) {
            return lfPackageVote;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("socialPackageID=");
        msg.append(socialPackageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageVoteException(msg.toString());
    }

    /**
     * Returns the last l f package vote in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package vote, or <code>null</code> if a matching l f package vote could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageVote fetchBySocialPackageID_Last(Integer socialPackageID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySocialPackageID(socialPackageID);

        if (count == 0) {
            return null;
        }

        List<LFPackageVote> list = findBySocialPackageID(socialPackageID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f package votes before and after the current l f package vote in the ordered set where socialPackageID = &#63;.
     *
     * @param id the primary key of the current l f package vote
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f package vote
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a l f package vote with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageVote[] findBySocialPackageID_PrevAndNext(long id,
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws NoSuchLFPackageVoteException, SystemException {
        LFPackageVote lfPackageVote = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFPackageVote[] array = new LFPackageVoteImpl[3];

            array[0] = getBySocialPackageID_PrevAndNext(session, lfPackageVote,
                    socialPackageID, orderByComparator, true);

            array[1] = lfPackageVote;

            array[2] = getBySocialPackageID_PrevAndNext(session, lfPackageVote,
                    socialPackageID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFPackageVote getBySocialPackageID_PrevAndNext(Session session,
        LFPackageVote lfPackageVote, Integer socialPackageID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFPACKAGEVOTE_WHERE);

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
            query.append(LFPackageVoteModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfPackageVote);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFPackageVote> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f package votes where socialPackageID = &#63; from the database.
     *
     * @param socialPackageID the social package i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySocialPackageID(Integer socialPackageID)
        throws SystemException {
        for (LFPackageVote lfPackageVote : findBySocialPackageID(
                socialPackageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfPackageVote);
        }
    }

    /**
     * Returns the number of l f package votes where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @return the number of matching l f package votes
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

            query.append(_SQL_COUNT_LFPACKAGEVOTE_WHERE);

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
     * Caches the l f package vote in the entity cache if it is enabled.
     *
     * @param lfPackageVote the l f package vote
     */
    @Override
    public void cacheResult(LFPackageVote lfPackageVote) {
        EntityCacheUtil.putResult(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageVoteImpl.class, lfPackageVote.getPrimaryKey(),
            lfPackageVote);

        lfPackageVote.resetOriginalValues();
    }

    /**
     * Caches the l f package votes in the entity cache if it is enabled.
     *
     * @param lfPackageVotes the l f package votes
     */
    @Override
    public void cacheResult(List<LFPackageVote> lfPackageVotes) {
        for (LFPackageVote lfPackageVote : lfPackageVotes) {
            if (EntityCacheUtil.getResult(
                        LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
                        LFPackageVoteImpl.class, lfPackageVote.getPrimaryKey()) == null) {
                cacheResult(lfPackageVote);
            } else {
                lfPackageVote.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f package votes.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFPackageVoteImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFPackageVoteImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f package vote.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFPackageVote lfPackageVote) {
        EntityCacheUtil.removeResult(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageVoteImpl.class, lfPackageVote.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFPackageVote> lfPackageVotes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFPackageVote lfPackageVote : lfPackageVotes) {
            EntityCacheUtil.removeResult(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
                LFPackageVoteImpl.class, lfPackageVote.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f package vote with the primary key. Does not add the l f package vote to the database.
     *
     * @param id the primary key for the new l f package vote
     * @return the new l f package vote
     */
    @Override
    public LFPackageVote create(long id) {
        LFPackageVote lfPackageVote = new LFPackageVoteImpl();

        lfPackageVote.setNew(true);
        lfPackageVote.setPrimaryKey(id);

        return lfPackageVote;
    }

    /**
     * Removes the l f package vote with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f package vote
     * @return the l f package vote that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a l f package vote with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageVote remove(long id)
        throws NoSuchLFPackageVoteException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f package vote with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f package vote
     * @return the l f package vote that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a l f package vote with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageVote remove(Serializable primaryKey)
        throws NoSuchLFPackageVoteException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFPackageVote lfPackageVote = (LFPackageVote) session.get(LFPackageVoteImpl.class,
                    primaryKey);

            if (lfPackageVote == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFPackageVoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfPackageVote);
        } catch (NoSuchLFPackageVoteException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFPackageVote removeImpl(LFPackageVote lfPackageVote)
        throws SystemException {
        lfPackageVote = toUnwrappedModel(lfPackageVote);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfPackageVote)) {
                lfPackageVote = (LFPackageVote) session.get(LFPackageVoteImpl.class,
                        lfPackageVote.getPrimaryKeyObj());
            }

            if (lfPackageVote != null) {
                session.delete(lfPackageVote);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfPackageVote != null) {
            clearCache(lfPackageVote);
        }

        return lfPackageVote;
    }

    @Override
    public LFPackageVote updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPackageVote lfPackageVote)
        throws SystemException {
        lfPackageVote = toUnwrappedModel(lfPackageVote);

        boolean isNew = lfPackageVote.isNew();

        LFPackageVoteModelImpl lfPackageVoteModelImpl = (LFPackageVoteModelImpl) lfPackageVote;

        Session session = null;

        try {
            session = openSession();

            if (lfPackageVote.isNew()) {
                session.save(lfPackageVote);

                lfPackageVote.setNew(false);
            } else {
                session.merge(lfPackageVote);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFPackageVoteModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfPackageVoteModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPackageVoteModelImpl.getOriginalSocialPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCIALPACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID,
                    args);

                args = new Object[] { lfPackageVoteModelImpl.getSocialPackageID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCIALPACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageVoteImpl.class, lfPackageVote.getPrimaryKey(),
            lfPackageVote);

        return lfPackageVote;
    }

    protected LFPackageVote toUnwrappedModel(LFPackageVote lfPackageVote) {
        if (lfPackageVote instanceof LFPackageVoteImpl) {
            return lfPackageVote;
        }

        LFPackageVoteImpl lfPackageVoteImpl = new LFPackageVoteImpl();

        lfPackageVoteImpl.setNew(lfPackageVote.isNew());
        lfPackageVoteImpl.setPrimaryKey(lfPackageVote.getPrimaryKey());

        lfPackageVoteImpl.setId(lfPackageVote.getId());
        lfPackageVoteImpl.setUserID(lfPackageVote.getUserID());
        lfPackageVoteImpl.setSocialPackageID(lfPackageVote.getSocialPackageID());
        lfPackageVoteImpl.setVoteValue(lfPackageVote.getVoteValue());

        return lfPackageVoteImpl;
    }

    /**
     * Returns the l f package vote with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f package vote
     * @return the l f package vote
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a l f package vote with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageVote findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFPackageVoteException, SystemException {
        LFPackageVote lfPackageVote = fetchByPrimaryKey(primaryKey);

        if (lfPackageVote == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFPackageVoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfPackageVote;
    }

    /**
     * Returns the l f package vote with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException} if it could not be found.
     *
     * @param id the primary key of the l f package vote
     * @return the l f package vote
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException if a l f package vote with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageVote findByPrimaryKey(long id)
        throws NoSuchLFPackageVoteException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f package vote with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f package vote
     * @return the l f package vote, or <code>null</code> if a l f package vote with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageVote fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFPackageVote lfPackageVote = (LFPackageVote) EntityCacheUtil.getResult(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
                LFPackageVoteImpl.class, primaryKey);

        if (lfPackageVote == _nullLFPackageVote) {
            return null;
        }

        if (lfPackageVote == null) {
            Session session = null;

            try {
                session = openSession();

                lfPackageVote = (LFPackageVote) session.get(LFPackageVoteImpl.class,
                        primaryKey);

                if (lfPackageVote != null) {
                    cacheResult(lfPackageVote);
                } else {
                    EntityCacheUtil.putResult(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
                        LFPackageVoteImpl.class, primaryKey, _nullLFPackageVote);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFPackageVoteModelImpl.ENTITY_CACHE_ENABLED,
                    LFPackageVoteImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfPackageVote;
    }

    /**
     * Returns the l f package vote with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f package vote
     * @return the l f package vote, or <code>null</code> if a l f package vote with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageVote fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f package votes.
     *
     * @return the l f package votes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageVote> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f package votes.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageVoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f package votes
     * @param end the upper bound of the range of l f package votes (not inclusive)
     * @return the range of l f package votes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageVote> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f package votes.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageVoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f package votes
     * @param end the upper bound of the range of l f package votes (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f package votes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageVote> findAll(int start, int end,
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

        List<LFPackageVote> list = (List<LFPackageVote>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFPACKAGEVOTE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFPACKAGEVOTE;

                if (pagination) {
                    sql = sql.concat(LFPackageVoteModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFPackageVote>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackageVote>(list);
                } else {
                    list = (List<LFPackageVote>) QueryUtil.list(q,
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
     * Removes all the l f package votes from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFPackageVote lfPackageVote : findAll()) {
            remove(lfPackageVote);
        }
    }

    /**
     * Returns the number of l f package votes.
     *
     * @return the number of l f package votes
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

                Query q = session.createQuery(_SQL_COUNT_LFPACKAGEVOTE);

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
     * Initializes the l f package vote persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFPackageVote")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFPackageVote>> listenersList = new ArrayList<ModelListener<LFPackageVote>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFPackageVote>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFPackageVoteImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
