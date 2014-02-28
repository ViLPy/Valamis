package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException;
import com.arcusys.learn.persistence.liferay.model.LFObjective;
import com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectivePersistence;

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

/**
 * The persistence implementation for the l f objective service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectivePersistence
 * @see LFObjectiveUtil
 * @generated
 */
public class LFObjectivePersistenceImpl extends BasePersistenceImpl<LFObjective>
    implements LFObjectivePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFObjectiveUtil} to access the l f objective persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFObjectiveImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBySequencingIDAndIsPrimary",
            new String[] {
                Integer.class.getName(), Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBySequencingIDAndIsPrimary",
            new String[] { Integer.class.getName(), Boolean.class.getName() },
            LFObjectiveModelImpl.SEQUENCINGID_COLUMN_BITMASK |
            LFObjectiveModelImpl.ISPRIMARY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARY =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBySequencingIDAndIsPrimary",
            new String[] { Integer.class.getName(), Boolean.class.getName() });
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_NULL =
        "lfObjective.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_2 =
        "lfObjective.sequencingID = ? AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_NULL_2 =
        "lfObjective.sequencingID IS NULL  AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_NULL =
        "lfObjective.isPrimary IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_2 =
        "lfObjective.isPrimary = ?";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_NULL_2 =
        "lfObjective.isPrimary IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGIDISPRIMARYIDENTIFIER =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBySequencingIDIsPrimaryIdentifier",
            new String[] {
                Integer.class.getName(), Boolean.class.getName(),
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDISPRIMARYIDENTIFIER =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBySequencingIDIsPrimaryIdentifier",
            new String[] {
                Integer.class.getName(), Boolean.class.getName(),
                String.class.getName()
            },
            LFObjectiveModelImpl.SEQUENCINGID_COLUMN_BITMASK |
            LFObjectiveModelImpl.ISPRIMARY_COLUMN_BITMASK |
            LFObjectiveModelImpl.IDENTIFIER_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGIDISPRIMARYIDENTIFIER =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBySequencingIDIsPrimaryIdentifier",
            new String[] {
                Integer.class.getName(), Boolean.class.getName(),
                String.class.getName()
            });
    private static final String _FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_SEQUENCINGID_NULL =
        "lfObjective.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_SEQUENCINGID_2 =
        "lfObjective.sequencingID = ? AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_SEQUENCINGID_NULL_2 =
        "lfObjective.sequencingID IS NULL  AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_ISPRIMARY_NULL =
        "lfObjective.isPrimary IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_ISPRIMARY_2 =
        "lfObjective.isPrimary = ? AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_ISPRIMARY_NULL_2 =
        "lfObjective.isPrimary IS NULL  AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_1 =
        "lfObjective.identifier IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_NULL =
        "lfObjective.identifier IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_2 =
        "lfObjective.identifier = ?";
    private static final String _FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_NULL_2 =
        "lfObjective.identifier IS NULL ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_3 =
        "(lfObjective.identifier IS NULL OR lfObjective.identifier = '')";
    private static final String _SQL_SELECT_LFOBJECTIVE = "SELECT lfObjective FROM LFObjective lfObjective";
    private static final String _SQL_SELECT_LFOBJECTIVE_WHERE = "SELECT lfObjective FROM LFObjective lfObjective WHERE ";
    private static final String _SQL_COUNT_LFOBJECTIVE = "SELECT COUNT(lfObjective) FROM LFObjective lfObjective";
    private static final String _SQL_COUNT_LFOBJECTIVE_WHERE = "SELECT COUNT(lfObjective) FROM LFObjective lfObjective WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfObjective.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFObjective exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFObjective exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFObjectivePersistenceImpl.class);
    private static LFObjective _nullLFObjective = new LFObjectiveImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFObjective> toCacheModel() {
                return _nullLFObjectiveCacheModel;
            }
        };

    private static CacheModel<LFObjective> _nullLFObjectiveCacheModel = new CacheModel<LFObjective>() {
            @Override
            public LFObjective toEntityModel() {
                return _nullLFObjective;
            }
        };

    public LFObjectivePersistenceImpl() {
        setModelClass(LFObjective.class);
    }

    /**
     * Returns all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @return the matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjective> findBySequencingIDAndIsPrimary(
        Integer sequencingID, Boolean isPrimary) throws SystemException {
        return findBySequencingIDAndIsPrimary(sequencingID, isPrimary,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @return the range of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjective> findBySequencingIDAndIsPrimary(
        Integer sequencingID, Boolean isPrimary, int start, int end)
        throws SystemException {
        return findBySequencingIDAndIsPrimary(sequencingID, isPrimary, start,
            end, null);
    }

    /**
     * Returns an ordered range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjective> findBySequencingIDAndIsPrimary(
        Integer sequencingID, Boolean isPrimary, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY;
            finderArgs = new Object[] { sequencingID, isPrimary };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY;
            finderArgs = new Object[] {
                    sequencingID, isPrimary,
                    
                    start, end, orderByComparator
                };
        }

        List<LFObjective> list = (List<LFObjective>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFObjective lfObjective : list) {
                if (!Validator.equals(sequencingID,
                            lfObjective.getSequencingID()) ||
                        !Validator.equals(isPrimary, lfObjective.getIsPrimary())) {
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

            query.append(_SQL_SELECT_LFOBJECTIVE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_2);
            }

            if (isPrimary == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFObjectiveModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                if (isPrimary != null) {
                    qPos.add(isPrimary.booleanValue());
                }

                if (!pagination) {
                    list = (List<LFObjective>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFObjective>(list);
                } else {
                    list = (List<LFObjective>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective findBySequencingIDAndIsPrimary_First(
        Integer sequencingID, Boolean isPrimary,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = fetchBySequencingIDAndIsPrimary_First(sequencingID,
                isPrimary, orderByComparator);

        if (lfObjective != null) {
            return lfObjective;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(", isPrimary=");
        msg.append(isPrimary);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveException(msg.toString());
    }

    /**
     * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective, or <code>null</code> if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective fetchBySequencingIDAndIsPrimary_First(
        Integer sequencingID, Boolean isPrimary,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFObjective> list = findBySequencingIDAndIsPrimary(sequencingID,
                isPrimary, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective findBySequencingIDAndIsPrimary_Last(
        Integer sequencingID, Boolean isPrimary,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = fetchBySequencingIDAndIsPrimary_Last(sequencingID,
                isPrimary, orderByComparator);

        if (lfObjective != null) {
            return lfObjective;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(", isPrimary=");
        msg.append(isPrimary);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveException(msg.toString());
    }

    /**
     * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective, or <code>null</code> if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective fetchBySequencingIDAndIsPrimary_Last(
        Integer sequencingID, Boolean isPrimary,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySequencingIDAndIsPrimary(sequencingID, isPrimary);

        if (count == 0) {
            return null;
        }

        List<LFObjective> list = findBySequencingIDAndIsPrimary(sequencingID,
                isPrimary, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f objectives before and after the current l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param lfId the primary key of the current l f objective
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective[] findBySequencingIDAndIsPrimary_PrevAndNext(long lfId,
        Integer sequencingID, Boolean isPrimary,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = findByPrimaryKey(lfId);

        Session session = null;

        try {
            session = openSession();

            LFObjective[] array = new LFObjectiveImpl[3];

            array[0] = getBySequencingIDAndIsPrimary_PrevAndNext(session,
                    lfObjective, sequencingID, isPrimary, orderByComparator,
                    true);

            array[1] = lfObjective;

            array[2] = getBySequencingIDAndIsPrimary_PrevAndNext(session,
                    lfObjective, sequencingID, isPrimary, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFObjective getBySequencingIDAndIsPrimary_PrevAndNext(
        Session session, LFObjective lfObjective, Integer sequencingID,
        Boolean isPrimary, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFOBJECTIVE_WHERE);

        if (sequencingID == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_2);
        }

        if (isPrimary == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_2);
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
            query.append(LFObjectiveModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (sequencingID != null) {
            qPos.add(sequencingID.intValue());
        }

        if (isPrimary != null) {
            qPos.add(isPrimary.booleanValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfObjective);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFObjective> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f objectives where sequencingID = &#63; and isPrimary = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySequencingIDAndIsPrimary(Integer sequencingID,
        Boolean isPrimary) throws SystemException {
        for (LFObjective lfObjective : findBySequencingIDAndIsPrimary(
                sequencingID, isPrimary, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(lfObjective);
        }
    }

    /**
     * Returns the number of l f objectives where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @return the number of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySequencingIDAndIsPrimary(Integer sequencingID,
        Boolean isPrimary) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARY;

        Object[] finderArgs = new Object[] { sequencingID, isPrimary };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFOBJECTIVE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_2);
            }

            if (isPrimary == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                if (isPrimary != null) {
                    qPos.add(isPrimary.booleanValue());
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
     * Returns all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @return the matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjective> findBySequencingIDIsPrimaryIdentifier(
        Integer sequencingID, Boolean isPrimary, String identifier)
        throws SystemException {
        return findBySequencingIDIsPrimaryIdentifier(sequencingID, isPrimary,
            identifier, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @return the range of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjective> findBySequencingIDIsPrimaryIdentifier(
        Integer sequencingID, Boolean isPrimary, String identifier, int start,
        int end) throws SystemException {
        return findBySequencingIDIsPrimaryIdentifier(sequencingID, isPrimary,
            identifier, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjective> findBySequencingIDIsPrimaryIdentifier(
        Integer sequencingID, Boolean isPrimary, String identifier, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDISPRIMARYIDENTIFIER;
            finderArgs = new Object[] { sequencingID, isPrimary, identifier };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGIDISPRIMARYIDENTIFIER;
            finderArgs = new Object[] {
                    sequencingID, isPrimary, identifier,
                    
                    start, end, orderByComparator
                };
        }

        List<LFObjective> list = (List<LFObjective>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFObjective lfObjective : list) {
                if (!Validator.equals(sequencingID,
                            lfObjective.getSequencingID()) ||
                        !Validator.equals(isPrimary, lfObjective.getIsPrimary()) ||
                        !Validator.equals(identifier,
                            lfObjective.getIdentifier())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_LFOBJECTIVE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_SEQUENCINGID_2);
            }

            if (isPrimary == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_ISPRIMARY_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_ISPRIMARY_2);
            }

            boolean bindIdentifier = false;

            if (identifier == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_1);
            } else if (identifier.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_3);
            } else {
                bindIdentifier = true;

                if (identifier.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_3);
                } else {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFObjectiveModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                if (isPrimary != null) {
                    qPos.add(isPrimary.booleanValue());
                }

                if (bindIdentifier) {
                    if (identifier != null) {
                        qPos.add(identifier);
                    }
                }

                if (!pagination) {
                    list = (List<LFObjective>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFObjective>(list);
                } else {
                    list = (List<LFObjective>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective findBySequencingIDIsPrimaryIdentifier_First(
        Integer sequencingID, Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = fetchBySequencingIDIsPrimaryIdentifier_First(sequencingID,
                isPrimary, identifier, orderByComparator);

        if (lfObjective != null) {
            return lfObjective;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(", isPrimary=");
        msg.append(isPrimary);

        msg.append(", identifier=");
        msg.append(identifier);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveException(msg.toString());
    }

    /**
     * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective, or <code>null</code> if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective fetchBySequencingIDIsPrimaryIdentifier_First(
        Integer sequencingID, Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFObjective> list = findBySequencingIDIsPrimaryIdentifier(sequencingID,
                isPrimary, identifier, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective findBySequencingIDIsPrimaryIdentifier_Last(
        Integer sequencingID, Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = fetchBySequencingIDIsPrimaryIdentifier_Last(sequencingID,
                isPrimary, identifier, orderByComparator);

        if (lfObjective != null) {
            return lfObjective;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(", isPrimary=");
        msg.append(isPrimary);

        msg.append(", identifier=");
        msg.append(identifier);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveException(msg.toString());
    }

    /**
     * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective, or <code>null</code> if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective fetchBySequencingIDIsPrimaryIdentifier_Last(
        Integer sequencingID, Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySequencingIDIsPrimaryIdentifier(sequencingID,
                isPrimary, identifier);

        if (count == 0) {
            return null;
        }

        List<LFObjective> list = findBySequencingIDIsPrimaryIdentifier(sequencingID,
                isPrimary, identifier, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f objectives before and after the current l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param lfId the primary key of the current l f objective
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective[] findBySequencingIDIsPrimaryIdentifier_PrevAndNext(
        long lfId, Integer sequencingID, Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = findByPrimaryKey(lfId);

        Session session = null;

        try {
            session = openSession();

            LFObjective[] array = new LFObjectiveImpl[3];

            array[0] = getBySequencingIDIsPrimaryIdentifier_PrevAndNext(session,
                    lfObjective, sequencingID, isPrimary, identifier,
                    orderByComparator, true);

            array[1] = lfObjective;

            array[2] = getBySequencingIDIsPrimaryIdentifier_PrevAndNext(session,
                    lfObjective, sequencingID, isPrimary, identifier,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFObjective getBySequencingIDIsPrimaryIdentifier_PrevAndNext(
        Session session, LFObjective lfObjective, Integer sequencingID,
        Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFOBJECTIVE_WHERE);

        if (sequencingID == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_SEQUENCINGID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_SEQUENCINGID_2);
        }

        if (isPrimary == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_ISPRIMARY_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_ISPRIMARY_2);
        }

        boolean bindIdentifier = false;

        if (identifier == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_1);
        } else if (identifier.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_3);
        } else {
            bindIdentifier = true;

            if (identifier.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_3);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_2);
            }
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
            query.append(LFObjectiveModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (sequencingID != null) {
            qPos.add(sequencingID.intValue());
        }

        if (isPrimary != null) {
            qPos.add(isPrimary.booleanValue());
        }

        if (bindIdentifier) {
            if (identifier != null) {
                qPos.add(identifier);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfObjective);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFObjective> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySequencingIDIsPrimaryIdentifier(Integer sequencingID,
        Boolean isPrimary, String identifier) throws SystemException {
        for (LFObjective lfObjective : findBySequencingIDIsPrimaryIdentifier(
                sequencingID, isPrimary, identifier, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(lfObjective);
        }
    }

    /**
     * Returns the number of l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @return the number of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySequencingIDIsPrimaryIdentifier(Integer sequencingID,
        Boolean isPrimary, String identifier) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SEQUENCINGIDISPRIMARYIDENTIFIER;

        Object[] finderArgs = new Object[] { sequencingID, isPrimary, identifier };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_LFOBJECTIVE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_SEQUENCINGID_2);
            }

            if (isPrimary == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_ISPRIMARY_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_ISPRIMARY_2);
            }

            boolean bindIdentifier = false;

            if (identifier == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_1);
            } else if (identifier.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_3);
            } else {
                bindIdentifier = true;

                if (identifier.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_3);
                } else {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDISPRIMARYIDENTIFIER_IDENTIFIER_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                if (isPrimary != null) {
                    qPos.add(isPrimary.booleanValue());
                }

                if (bindIdentifier) {
                    if (identifier != null) {
                        qPos.add(identifier);
                    }
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
     * Caches the l f objective in the entity cache if it is enabled.
     *
     * @param lfObjective the l f objective
     */
    @Override
    public void cacheResult(LFObjective lfObjective) {
        EntityCacheUtil.putResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveImpl.class, lfObjective.getPrimaryKey(), lfObjective);

        lfObjective.resetOriginalValues();
    }

    /**
     * Caches the l f objectives in the entity cache if it is enabled.
     *
     * @param lfObjectives the l f objectives
     */
    @Override
    public void cacheResult(List<LFObjective> lfObjectives) {
        for (LFObjective lfObjective : lfObjectives) {
            if (EntityCacheUtil.getResult(
                        LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
                        LFObjectiveImpl.class, lfObjective.getPrimaryKey()) == null) {
                cacheResult(lfObjective);
            } else {
                lfObjective.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f objectives.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFObjectiveImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFObjectiveImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f objective.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFObjective lfObjective) {
        EntityCacheUtil.removeResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveImpl.class, lfObjective.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFObjective> lfObjectives) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFObjective lfObjective : lfObjectives) {
            EntityCacheUtil.removeResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
                LFObjectiveImpl.class, lfObjective.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f objective with the primary key. Does not add the l f objective to the database.
     *
     * @param lfId the primary key for the new l f objective
     * @return the new l f objective
     */
    @Override
    public LFObjective create(long lfId) {
        LFObjective lfObjective = new LFObjectiveImpl();

        lfObjective.setNew(true);
        lfObjective.setPrimaryKey(lfId);

        return lfObjective;
    }

    /**
     * Removes the l f objective with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfId the primary key of the l f objective
     * @return the l f objective that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective remove(long lfId)
        throws NoSuchLFObjectiveException, SystemException {
        return remove((Serializable) lfId);
    }

    /**
     * Removes the l f objective with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f objective
     * @return the l f objective that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective remove(Serializable primaryKey)
        throws NoSuchLFObjectiveException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFObjective lfObjective = (LFObjective) session.get(LFObjectiveImpl.class,
                    primaryKey);

            if (lfObjective == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFObjectiveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfObjective);
        } catch (NoSuchLFObjectiveException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFObjective removeImpl(LFObjective lfObjective)
        throws SystemException {
        lfObjective = toUnwrappedModel(lfObjective);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfObjective)) {
                lfObjective = (LFObjective) session.get(LFObjectiveImpl.class,
                        lfObjective.getPrimaryKeyObj());
            }

            if (lfObjective != null) {
                session.delete(lfObjective);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfObjective != null) {
            clearCache(lfObjective);
        }

        return lfObjective;
    }

    @Override
    public LFObjective updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFObjective lfObjective)
        throws SystemException {
        lfObjective = toUnwrappedModel(lfObjective);

        boolean isNew = lfObjective.isNew();

        LFObjectiveModelImpl lfObjectiveModelImpl = (LFObjectiveModelImpl) lfObjective;

        Session session = null;

        try {
            session = openSession();

            if (lfObjective.isNew()) {
                session.save(lfObjective);

                lfObjective.setNew(false);
            } else {
                session.merge(lfObjective);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFObjectiveModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfObjectiveModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfObjectiveModelImpl.getOriginalSequencingID(),
                        lfObjectiveModelImpl.getOriginalIsPrimary()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY,
                    args);

                args = new Object[] {
                        lfObjectiveModelImpl.getSequencingID(),
                        lfObjectiveModelImpl.getIsPrimary()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY,
                    args);
            }

            if ((lfObjectiveModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDISPRIMARYIDENTIFIER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfObjectiveModelImpl.getOriginalSequencingID(),
                        lfObjectiveModelImpl.getOriginalIsPrimary(),
                        lfObjectiveModelImpl.getOriginalIdentifier()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDISPRIMARYIDENTIFIER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDISPRIMARYIDENTIFIER,
                    args);

                args = new Object[] {
                        lfObjectiveModelImpl.getSequencingID(),
                        lfObjectiveModelImpl.getIsPrimary(),
                        lfObjectiveModelImpl.getIdentifier()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDISPRIMARYIDENTIFIER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDISPRIMARYIDENTIFIER,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveImpl.class, lfObjective.getPrimaryKey(), lfObjective);

        return lfObjective;
    }

    protected LFObjective toUnwrappedModel(LFObjective lfObjective) {
        if (lfObjective instanceof LFObjectiveImpl) {
            return lfObjective;
        }

        LFObjectiveImpl lfObjectiveImpl = new LFObjectiveImpl();

        lfObjectiveImpl.setNew(lfObjective.isNew());
        lfObjectiveImpl.setPrimaryKey(lfObjective.getPrimaryKey());

        lfObjectiveImpl.setLfId(lfObjective.getLfId());
        lfObjectiveImpl.setSequencingID(lfObjective.getSequencingID());
        lfObjectiveImpl.setSatisfiedByMeasure(lfObjective.isSatisfiedByMeasure());
        lfObjectiveImpl.setIdentifier(lfObjective.getIdentifier());
        lfObjectiveImpl.setMinNormalizedMeasure(lfObjective.getMinNormalizedMeasure());
        lfObjectiveImpl.setIsPrimary(lfObjective.getIsPrimary());

        return lfObjectiveImpl;
    }

    /**
     * Returns the l f objective with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f objective
     * @return the l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = fetchByPrimaryKey(primaryKey);

        if (lfObjective == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFObjectiveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfObjective;
    }

    /**
     * Returns the l f objective with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException} if it could not be found.
     *
     * @param lfId the primary key of the l f objective
     * @return the l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective findByPrimaryKey(long lfId)
        throws NoSuchLFObjectiveException, SystemException {
        return findByPrimaryKey((Serializable) lfId);
    }

    /**
     * Returns the l f objective with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f objective
     * @return the l f objective, or <code>null</code> if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFObjective lfObjective = (LFObjective) EntityCacheUtil.getResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
                LFObjectiveImpl.class, primaryKey);

        if (lfObjective == _nullLFObjective) {
            return null;
        }

        if (lfObjective == null) {
            Session session = null;

            try {
                session = openSession();

                lfObjective = (LFObjective) session.get(LFObjectiveImpl.class,
                        primaryKey);

                if (lfObjective != null) {
                    cacheResult(lfObjective);
                } else {
                    EntityCacheUtil.putResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
                        LFObjectiveImpl.class, primaryKey, _nullLFObjective);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
                    LFObjectiveImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfObjective;
    }

    /**
     * Returns the l f objective with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param lfId the primary key of the l f objective
     * @return the l f objective, or <code>null</code> if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective fetchByPrimaryKey(long lfId) throws SystemException {
        return fetchByPrimaryKey((Serializable) lfId);
    }

    /**
     * Returns all the l f objectives.
     *
     * @return the l f objectives
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjective> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f objectives.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @return the range of l f objectives
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjective> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f objectives.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f objectives
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjective> findAll(int start, int end,
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

        List<LFObjective> list = (List<LFObjective>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFOBJECTIVE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFOBJECTIVE;

                if (pagination) {
                    sql = sql.concat(LFObjectiveModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFObjective>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFObjective>(list);
                } else {
                    list = (List<LFObjective>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the l f objectives from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFObjective lfObjective : findAll()) {
            remove(lfObjective);
        }
    }

    /**
     * Returns the number of l f objectives.
     *
     * @return the number of l f objectives
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

                Query q = session.createQuery(_SQL_COUNT_LFOBJECTIVE);

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

    /**
     * Initializes the l f objective persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFObjective")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFObjective>> listenersList = new ArrayList<ModelListener<LFObjective>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFObjective>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFObjectiveImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
