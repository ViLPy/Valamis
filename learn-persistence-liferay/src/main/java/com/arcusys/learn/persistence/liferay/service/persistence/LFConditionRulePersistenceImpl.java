package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException;
import com.arcusys.learn.persistence.liferay.model.LFConditionRule;
import com.arcusys.learn.persistence.liferay.model.impl.LFConditionRuleImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFConditionRuleModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFConditionRulePersistence;

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
 * The persistence implementation for the l f condition rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFConditionRulePersistence
 * @see LFConditionRuleUtil
 * @generated
 */
public class LFConditionRulePersistenceImpl extends BasePersistenceImpl<LFConditionRule>
    implements LFConditionRulePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFConditionRuleUtil} to access the l f condition rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFConditionRuleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleModelImpl.FINDER_CACHE_ENABLED,
            LFConditionRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleModelImpl.FINDER_CACHE_ENABLED,
            LFConditionRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGIDANDRULETYPE =
        new FinderPath(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleModelImpl.FINDER_CACHE_ENABLED,
            LFConditionRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBySequencingIDAndRuleType",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDRULETYPE =
        new FinderPath(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleModelImpl.FINDER_CACHE_ENABLED,
            LFConditionRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBySequencingIDAndRuleType",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFConditionRuleModelImpl.SEQUENCINGID_COLUMN_BITMASK |
            LFConditionRuleModelImpl.RULETYPE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGIDANDRULETYPE = new FinderPath(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBySequencingIDAndRuleType",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_SEQUENCINGID_NULL =
        "lfConditionRule.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_SEQUENCINGID_2 =
        "lfConditionRule.sequencingID = ? AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_SEQUENCINGID_NULL_2 =
        "lfConditionRule.sequencingID IS NULL  AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_1 =
        "lfConditionRule.ruleType IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_NULL =
        "lfConditionRule.ruleType IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_2 =
        "lfConditionRule.ruleType = ?";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_NULL_2 =
        "lfConditionRule.ruleType IS NULL ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_3 =
        "(lfConditionRule.ruleType IS NULL OR lfConditionRule.ruleType = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGID =
        new FinderPath(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleModelImpl.FINDER_CACHE_ENABLED,
            LFConditionRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBySequencingID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID =
        new FinderPath(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleModelImpl.FINDER_CACHE_ENABLED,
            LFConditionRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySequencingID",
            new String[] { Integer.class.getName() },
            LFConditionRuleModelImpl.SEQUENCINGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGID = new FinderPath(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySequencingID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL = "lfConditionRule.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2 = "lfConditionRule.sequencingID = ?";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2 = "lfConditionRule.sequencingID IS NULL ";
    private static final String _SQL_SELECT_LFCONDITIONRULE = "SELECT lfConditionRule FROM LFConditionRule lfConditionRule";
    private static final String _SQL_SELECT_LFCONDITIONRULE_WHERE = "SELECT lfConditionRule FROM LFConditionRule lfConditionRule WHERE ";
    private static final String _SQL_COUNT_LFCONDITIONRULE = "SELECT COUNT(lfConditionRule) FROM LFConditionRule lfConditionRule";
    private static final String _SQL_COUNT_LFCONDITIONRULE_WHERE = "SELECT COUNT(lfConditionRule) FROM LFConditionRule lfConditionRule WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfConditionRule.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFConditionRule exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFConditionRule exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFConditionRulePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFConditionRule _nullLFConditionRule = new LFConditionRuleImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFConditionRule> toCacheModel() {
                return _nullLFConditionRuleCacheModel;
            }
        };

    private static CacheModel<LFConditionRule> _nullLFConditionRuleCacheModel = new CacheModel<LFConditionRule>() {
            @Override
            public LFConditionRule toEntityModel() {
                return _nullLFConditionRule;
            }
        };

    public LFConditionRulePersistenceImpl() {
        setModelClass(LFConditionRule.class);
    }

    /**
     * Returns all the l f condition rules where sequencingID = &#63; and ruleType = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param ruleType the rule type
     * @return the matching l f condition rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConditionRule> findBySequencingIDAndRuleType(
        Integer sequencingID, String ruleType) throws SystemException {
        return findBySequencingIDAndRuleType(sequencingID, ruleType,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f condition rules where sequencingID = &#63; and ruleType = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFConditionRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param ruleType the rule type
     * @param start the lower bound of the range of l f condition rules
     * @param end the upper bound of the range of l f condition rules (not inclusive)
     * @return the range of matching l f condition rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConditionRule> findBySequencingIDAndRuleType(
        Integer sequencingID, String ruleType, int start, int end)
        throws SystemException {
        return findBySequencingIDAndRuleType(sequencingID, ruleType, start,
            end, null);
    }

    /**
     * Returns an ordered range of all the l f condition rules where sequencingID = &#63; and ruleType = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFConditionRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param ruleType the rule type
     * @param start the lower bound of the range of l f condition rules
     * @param end the upper bound of the range of l f condition rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f condition rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConditionRule> findBySequencingIDAndRuleType(
        Integer sequencingID, String ruleType, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDRULETYPE;
            finderArgs = new Object[] { sequencingID, ruleType };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGIDANDRULETYPE;
            finderArgs = new Object[] {
                    sequencingID, ruleType,
                    
                    start, end, orderByComparator
                };
        }

        List<LFConditionRule> list = (List<LFConditionRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFConditionRule lfConditionRule : list) {
                if (!Validator.equals(sequencingID,
                            lfConditionRule.getSequencingID()) ||
                        !Validator.equals(ruleType,
                            lfConditionRule.getRuleType())) {
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

            query.append(_SQL_SELECT_LFCONDITIONRULE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_SEQUENCINGID_2);
            }

            boolean bindRuleType = false;

            if (ruleType == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_1);
            } else if (ruleType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_3);
            } else {
                bindRuleType = true;

                if (ruleType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFConditionRuleModelImpl.ORDER_BY_JPQL);
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

                if (bindRuleType) {
                    if (ruleType != null) {
                        qPos.add(ruleType);
                    }
                }

                if (!pagination) {
                    list = (List<LFConditionRule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFConditionRule>(list);
                } else {
                    list = (List<LFConditionRule>) QueryUtil.list(q,
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
     * Returns the first l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param ruleType the rule type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f condition rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a matching l f condition rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule findBySequencingIDAndRuleType_First(
        Integer sequencingID, String ruleType,
        OrderByComparator orderByComparator)
        throws NoSuchLFConditionRuleException, SystemException {
        LFConditionRule lfConditionRule = fetchBySequencingIDAndRuleType_First(sequencingID,
                ruleType, orderByComparator);

        if (lfConditionRule != null) {
            return lfConditionRule;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(", ruleType=");
        msg.append(ruleType);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFConditionRuleException(msg.toString());
    }

    /**
     * Returns the first l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param ruleType the rule type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule fetchBySequencingIDAndRuleType_First(
        Integer sequencingID, String ruleType,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFConditionRule> list = findBySequencingIDAndRuleType(sequencingID,
                ruleType, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param ruleType the rule type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f condition rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a matching l f condition rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule findBySequencingIDAndRuleType_Last(
        Integer sequencingID, String ruleType,
        OrderByComparator orderByComparator)
        throws NoSuchLFConditionRuleException, SystemException {
        LFConditionRule lfConditionRule = fetchBySequencingIDAndRuleType_Last(sequencingID,
                ruleType, orderByComparator);

        if (lfConditionRule != null) {
            return lfConditionRule;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(", ruleType=");
        msg.append(ruleType);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFConditionRuleException(msg.toString());
    }

    /**
     * Returns the last l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param ruleType the rule type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule fetchBySequencingIDAndRuleType_Last(
        Integer sequencingID, String ruleType,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySequencingIDAndRuleType(sequencingID, ruleType);

        if (count == 0) {
            return null;
        }

        List<LFConditionRule> list = findBySequencingIDAndRuleType(sequencingID,
                ruleType, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f condition rules before and after the current l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
     *
     * @param id the primary key of the current l f condition rule
     * @param sequencingID the sequencing i d
     * @param ruleType the rule type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f condition rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule[] findBySequencingIDAndRuleType_PrevAndNext(
        long id, Integer sequencingID, String ruleType,
        OrderByComparator orderByComparator)
        throws NoSuchLFConditionRuleException, SystemException {
        LFConditionRule lfConditionRule = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFConditionRule[] array = new LFConditionRuleImpl[3];

            array[0] = getBySequencingIDAndRuleType_PrevAndNext(session,
                    lfConditionRule, sequencingID, ruleType, orderByComparator,
                    true);

            array[1] = lfConditionRule;

            array[2] = getBySequencingIDAndRuleType_PrevAndNext(session,
                    lfConditionRule, sequencingID, ruleType, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFConditionRule getBySequencingIDAndRuleType_PrevAndNext(
        Session session, LFConditionRule lfConditionRule, Integer sequencingID,
        String ruleType, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCONDITIONRULE_WHERE);

        if (sequencingID == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_SEQUENCINGID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_SEQUENCINGID_2);
        }

        boolean bindRuleType = false;

        if (ruleType == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_1);
        } else if (ruleType.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_3);
        } else {
            bindRuleType = true;

            if (ruleType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_3);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_2);
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
            query.append(LFConditionRuleModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (sequencingID != null) {
            qPos.add(sequencingID.intValue());
        }

        if (bindRuleType) {
            if (ruleType != null) {
                qPos.add(ruleType);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfConditionRule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFConditionRule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f condition rules where sequencingID = &#63; and ruleType = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @param ruleType the rule type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySequencingIDAndRuleType(Integer sequencingID,
        String ruleType) throws SystemException {
        for (LFConditionRule lfConditionRule : findBySequencingIDAndRuleType(
                sequencingID, ruleType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(lfConditionRule);
        }
    }

    /**
     * Returns the number of l f condition rules where sequencingID = &#63; and ruleType = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param ruleType the rule type
     * @return the number of matching l f condition rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySequencingIDAndRuleType(Integer sequencingID,
        String ruleType) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SEQUENCINGIDANDRULETYPE;

        Object[] finderArgs = new Object[] { sequencingID, ruleType };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFCONDITIONRULE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_SEQUENCINGID_2);
            }

            boolean bindRuleType = false;

            if (ruleType == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_1);
            } else if (ruleType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_3);
            } else {
                bindRuleType = true;

                if (ruleType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDANDRULETYPE_RULETYPE_2);
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

                if (bindRuleType) {
                    if (ruleType != null) {
                        qPos.add(ruleType);
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
     * Returns all the l f condition rules where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the matching l f condition rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConditionRule> findBySequencingID(Integer sequencingID)
        throws SystemException {
        return findBySequencingID(sequencingID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f condition rules where sequencingID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFConditionRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param start the lower bound of the range of l f condition rules
     * @param end the upper bound of the range of l f condition rules (not inclusive)
     * @return the range of matching l f condition rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConditionRule> findBySequencingID(Integer sequencingID,
        int start, int end) throws SystemException {
        return findBySequencingID(sequencingID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f condition rules where sequencingID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFConditionRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param start the lower bound of the range of l f condition rules
     * @param end the upper bound of the range of l f condition rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f condition rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConditionRule> findBySequencingID(Integer sequencingID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID;
            finderArgs = new Object[] { sequencingID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGID;
            finderArgs = new Object[] {
                    sequencingID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFConditionRule> list = (List<LFConditionRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFConditionRule lfConditionRule : list) {
                if (!Validator.equals(sequencingID,
                            lfConditionRule.getSequencingID())) {
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

            query.append(_SQL_SELECT_LFCONDITIONRULE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFConditionRuleModelImpl.ORDER_BY_JPQL);
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

                if (!pagination) {
                    list = (List<LFConditionRule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFConditionRule>(list);
                } else {
                    list = (List<LFConditionRule>) QueryUtil.list(q,
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
     * Returns the first l f condition rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f condition rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a matching l f condition rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule findBySequencingID_First(Integer sequencingID,
        OrderByComparator orderByComparator)
        throws NoSuchLFConditionRuleException, SystemException {
        LFConditionRule lfConditionRule = fetchBySequencingID_First(sequencingID,
                orderByComparator);

        if (lfConditionRule != null) {
            return lfConditionRule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFConditionRuleException(msg.toString());
    }

    /**
     * Returns the first l f condition rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule fetchBySequencingID_First(Integer sequencingID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFConditionRule> list = findBySequencingID(sequencingID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f condition rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f condition rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a matching l f condition rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule findBySequencingID_Last(Integer sequencingID,
        OrderByComparator orderByComparator)
        throws NoSuchLFConditionRuleException, SystemException {
        LFConditionRule lfConditionRule = fetchBySequencingID_Last(sequencingID,
                orderByComparator);

        if (lfConditionRule != null) {
            return lfConditionRule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFConditionRuleException(msg.toString());
    }

    /**
     * Returns the last l f condition rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule fetchBySequencingID_Last(Integer sequencingID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySequencingID(sequencingID);

        if (count == 0) {
            return null;
        }

        List<LFConditionRule> list = findBySequencingID(sequencingID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f condition rules before and after the current l f condition rule in the ordered set where sequencingID = &#63;.
     *
     * @param id the primary key of the current l f condition rule
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f condition rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule[] findBySequencingID_PrevAndNext(long id,
        Integer sequencingID, OrderByComparator orderByComparator)
        throws NoSuchLFConditionRuleException, SystemException {
        LFConditionRule lfConditionRule = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFConditionRule[] array = new LFConditionRuleImpl[3];

            array[0] = getBySequencingID_PrevAndNext(session, lfConditionRule,
                    sequencingID, orderByComparator, true);

            array[1] = lfConditionRule;

            array[2] = getBySequencingID_PrevAndNext(session, lfConditionRule,
                    sequencingID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFConditionRule getBySequencingID_PrevAndNext(Session session,
        LFConditionRule lfConditionRule, Integer sequencingID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCONDITIONRULE_WHERE);

        if (sequencingID == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
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
            query.append(LFConditionRuleModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (sequencingID != null) {
            qPos.add(sequencingID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfConditionRule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFConditionRule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f condition rules where sequencingID = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySequencingID(Integer sequencingID)
        throws SystemException {
        for (LFConditionRule lfConditionRule : findBySequencingID(
                sequencingID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfConditionRule);
        }
    }

    /**
     * Returns the number of l f condition rules where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the number of matching l f condition rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySequencingID(Integer sequencingID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SEQUENCINGID;

        Object[] finderArgs = new Object[] { sequencingID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCONDITIONRULE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
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
     * Caches the l f condition rule in the entity cache if it is enabled.
     *
     * @param lfConditionRule the l f condition rule
     */
    @Override
    public void cacheResult(LFConditionRule lfConditionRule) {
        EntityCacheUtil.putResult(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleImpl.class, lfConditionRule.getPrimaryKey(),
            lfConditionRule);

        lfConditionRule.resetOriginalValues();
    }

    /**
     * Caches the l f condition rules in the entity cache if it is enabled.
     *
     * @param lfConditionRules the l f condition rules
     */
    @Override
    public void cacheResult(List<LFConditionRule> lfConditionRules) {
        for (LFConditionRule lfConditionRule : lfConditionRules) {
            if (EntityCacheUtil.getResult(
                        LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
                        LFConditionRuleImpl.class,
                        lfConditionRule.getPrimaryKey()) == null) {
                cacheResult(lfConditionRule);
            } else {
                lfConditionRule.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f condition rules.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFConditionRuleImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFConditionRuleImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f condition rule.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFConditionRule lfConditionRule) {
        EntityCacheUtil.removeResult(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleImpl.class, lfConditionRule.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFConditionRule> lfConditionRules) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFConditionRule lfConditionRule : lfConditionRules) {
            EntityCacheUtil.removeResult(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
                LFConditionRuleImpl.class, lfConditionRule.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f condition rule with the primary key. Does not add the l f condition rule to the database.
     *
     * @param id the primary key for the new l f condition rule
     * @return the new l f condition rule
     */
    @Override
    public LFConditionRule create(long id) {
        LFConditionRule lfConditionRule = new LFConditionRuleImpl();

        lfConditionRule.setNew(true);
        lfConditionRule.setPrimaryKey(id);

        return lfConditionRule;
    }

    /**
     * Removes the l f condition rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f condition rule
     * @return the l f condition rule that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule remove(long id)
        throws NoSuchLFConditionRuleException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f condition rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f condition rule
     * @return the l f condition rule that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule remove(Serializable primaryKey)
        throws NoSuchLFConditionRuleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFConditionRule lfConditionRule = (LFConditionRule) session.get(LFConditionRuleImpl.class,
                    primaryKey);

            if (lfConditionRule == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFConditionRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfConditionRule);
        } catch (NoSuchLFConditionRuleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFConditionRule removeImpl(LFConditionRule lfConditionRule)
        throws SystemException {
        lfConditionRule = toUnwrappedModel(lfConditionRule);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfConditionRule)) {
                lfConditionRule = (LFConditionRule) session.get(LFConditionRuleImpl.class,
                        lfConditionRule.getPrimaryKeyObj());
            }

            if (lfConditionRule != null) {
                session.delete(lfConditionRule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfConditionRule != null) {
            clearCache(lfConditionRule);
        }

        return lfConditionRule;
    }

    @Override
    public LFConditionRule updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFConditionRule lfConditionRule)
        throws SystemException {
        lfConditionRule = toUnwrappedModel(lfConditionRule);

        boolean isNew = lfConditionRule.isNew();

        LFConditionRuleModelImpl lfConditionRuleModelImpl = (LFConditionRuleModelImpl) lfConditionRule;

        Session session = null;

        try {
            session = openSession();

            if (lfConditionRule.isNew()) {
                session.save(lfConditionRule);

                lfConditionRule.setNew(false);
            } else {
                session.merge(lfConditionRule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFConditionRuleModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfConditionRuleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDRULETYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfConditionRuleModelImpl.getOriginalSequencingID(),
                        lfConditionRuleModelImpl.getOriginalRuleType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDRULETYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDRULETYPE,
                    args);

                args = new Object[] {
                        lfConditionRuleModelImpl.getSequencingID(),
                        lfConditionRuleModelImpl.getRuleType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDRULETYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDRULETYPE,
                    args);
            }

            if ((lfConditionRuleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfConditionRuleModelImpl.getOriginalSequencingID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID,
                    args);

                args = new Object[] { lfConditionRuleModelImpl.getSequencingID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFConditionRuleImpl.class, lfConditionRule.getPrimaryKey(),
            lfConditionRule);

        return lfConditionRule;
    }

    protected LFConditionRule toUnwrappedModel(LFConditionRule lfConditionRule) {
        if (lfConditionRule instanceof LFConditionRuleImpl) {
            return lfConditionRule;
        }

        LFConditionRuleImpl lfConditionRuleImpl = new LFConditionRuleImpl();

        lfConditionRuleImpl.setNew(lfConditionRule.isNew());
        lfConditionRuleImpl.setPrimaryKey(lfConditionRule.getPrimaryKey());

        lfConditionRuleImpl.setId(lfConditionRule.getId());
        lfConditionRuleImpl.setSequencingID(lfConditionRule.getSequencingID());
        lfConditionRuleImpl.setCombination(lfConditionRule.getCombination());
        lfConditionRuleImpl.setRuleType(lfConditionRule.getRuleType());
        lfConditionRuleImpl.setAction(lfConditionRule.getAction());

        return lfConditionRuleImpl;
    }

    /**
     * Returns the l f condition rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f condition rule
     * @return the l f condition rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFConditionRuleException, SystemException {
        LFConditionRule lfConditionRule = fetchByPrimaryKey(primaryKey);

        if (lfConditionRule == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFConditionRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfConditionRule;
    }

    /**
     * Returns the l f condition rule with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException} if it could not be found.
     *
     * @param id the primary key of the l f condition rule
     * @return the l f condition rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule findByPrimaryKey(long id)
        throws NoSuchLFConditionRuleException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f condition rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f condition rule
     * @return the l f condition rule, or <code>null</code> if a l f condition rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFConditionRule lfConditionRule = (LFConditionRule) EntityCacheUtil.getResult(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
                LFConditionRuleImpl.class, primaryKey);

        if (lfConditionRule == _nullLFConditionRule) {
            return null;
        }

        if (lfConditionRule == null) {
            Session session = null;

            try {
                session = openSession();

                lfConditionRule = (LFConditionRule) session.get(LFConditionRuleImpl.class,
                        primaryKey);

                if (lfConditionRule != null) {
                    cacheResult(lfConditionRule);
                } else {
                    EntityCacheUtil.putResult(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
                        LFConditionRuleImpl.class, primaryKey,
                        _nullLFConditionRule);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFConditionRuleModelImpl.ENTITY_CACHE_ENABLED,
                    LFConditionRuleImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfConditionRule;
    }

    /**
     * Returns the l f condition rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f condition rule
     * @return the l f condition rule, or <code>null</code> if a l f condition rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConditionRule fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f condition rules.
     *
     * @return the l f condition rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConditionRule> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f condition rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFConditionRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f condition rules
     * @param end the upper bound of the range of l f condition rules (not inclusive)
     * @return the range of l f condition rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConditionRule> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f condition rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFConditionRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f condition rules
     * @param end the upper bound of the range of l f condition rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f condition rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConditionRule> findAll(int start, int end,
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

        List<LFConditionRule> list = (List<LFConditionRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCONDITIONRULE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCONDITIONRULE;

                if (pagination) {
                    sql = sql.concat(LFConditionRuleModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFConditionRule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFConditionRule>(list);
                } else {
                    list = (List<LFConditionRule>) QueryUtil.list(q,
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
     * Removes all the l f condition rules from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFConditionRule lfConditionRule : findAll()) {
            remove(lfConditionRule);
        }
    }

    /**
     * Returns the number of l f condition rules.
     *
     * @return the number of l f condition rules
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

                Query q = session.createQuery(_SQL_COUNT_LFCONDITIONRULE);

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
     * Initializes the l f condition rule persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFConditionRule")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFConditionRule>> listenersList = new ArrayList<ModelListener<LFConditionRule>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFConditionRule>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFConditionRuleImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
