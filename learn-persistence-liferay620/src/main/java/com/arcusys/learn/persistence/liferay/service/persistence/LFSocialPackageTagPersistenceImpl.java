package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException;
import com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag;
import com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackageTagPersistence;

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
 * The persistence implementation for the l f social package tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSocialPackageTagPersistence
 * @see LFSocialPackageTagUtil
 * @generated
 */
public class LFSocialPackageTagPersistenceImpl extends BasePersistenceImpl<LFSocialPackageTag>
    implements LFSocialPackageTagPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFSocialPackageTagUtil} to access the l f social package tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFSocialPackageTagImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageTagImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageTagImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageTagImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageTagImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
            new String[] { String.class.getName() },
            LFSocialPackageTagModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "lfSocialPackageTag.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_NULL = "lfSocialPackageTag.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "lfSocialPackageTag.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_NULL_2 = "lfSocialPackageTag.name IS NULL ";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(lfSocialPackageTag.name IS NULL OR lfSocialPackageTag.name = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCIALPACKAGEID =
        new FinderPath(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageTagImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySocialPackageID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID =
        new FinderPath(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageTagImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySocialPackageID",
            new String[] { Integer.class.getName() },
            LFSocialPackageTagModelImpl.SOCIALPACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SOCIALPACKAGEID = new FinderPath(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBySocialPackageID", new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_NULL =
        "lfSocialPackageTag.socialPackageID IS NULL";
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_2 =
        "lfSocialPackageTag.socialPackageID = ?";
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_NULL_2 =
        "lfSocialPackageTag.socialPackageID IS NULL ";
    private static final String _SQL_SELECT_LFSOCIALPACKAGETAG = "SELECT lfSocialPackageTag FROM LFSocialPackageTag lfSocialPackageTag";
    private static final String _SQL_SELECT_LFSOCIALPACKAGETAG_WHERE = "SELECT lfSocialPackageTag FROM LFSocialPackageTag lfSocialPackageTag WHERE ";
    private static final String _SQL_COUNT_LFSOCIALPACKAGETAG = "SELECT COUNT(lfSocialPackageTag) FROM LFSocialPackageTag lfSocialPackageTag";
    private static final String _SQL_COUNT_LFSOCIALPACKAGETAG_WHERE = "SELECT COUNT(lfSocialPackageTag) FROM LFSocialPackageTag lfSocialPackageTag WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfSocialPackageTag.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFSocialPackageTag exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFSocialPackageTag exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFSocialPackageTagPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFSocialPackageTag _nullLFSocialPackageTag = new LFSocialPackageTagImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFSocialPackageTag> toCacheModel() {
                return _nullLFSocialPackageTagCacheModel;
            }
        };

    private static CacheModel<LFSocialPackageTag> _nullLFSocialPackageTagCacheModel =
        new CacheModel<LFSocialPackageTag>() {
            @Override
            public LFSocialPackageTag toEntityModel() {
                return _nullLFSocialPackageTag;
            }
        };

    public LFSocialPackageTagPersistenceImpl() {
        setModelClass(LFSocialPackageTag.class);
    }

    /**
     * Returns all the l f social package tags where name = &#63;.
     *
     * @param name the name
     * @return the matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSocialPackageTag> findByName(String name)
        throws SystemException {
        return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f social package tags where name = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param name the name
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @return the range of matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSocialPackageTag> findByName(String name, int start, int end)
        throws SystemException {
        return findByName(name, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f social package tags where name = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param name the name
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSocialPackageTag> findByName(String name, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { name };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { name, start, end, orderByComparator };
        }

        List<LFSocialPackageTag> list = (List<LFSocialPackageTag>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFSocialPackageTag lfSocialPackageTag : list) {
                if (!Validator.equals(name, lfSocialPackageTag.getName())) {
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

            query.append(_SQL_SELECT_LFSOCIALPACKAGETAG_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                if (name.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_NAME_NAME_3);
                } else {
                    query.append(_FINDER_COLUMN_NAME_NAME_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFSocialPackageTagModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    if (name != null) {
                        qPos.add(name);
                    }
                }

                if (!pagination) {
                    list = (List<LFSocialPackageTag>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFSocialPackageTag>(list);
                } else {
                    list = (List<LFSocialPackageTag>) QueryUtil.list(q,
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
     * Returns the first l f social package tag in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f social package tag
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a matching l f social package tag could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag findByName_First(String name,
        OrderByComparator orderByComparator)
        throws NoSuchLFSocialPackageTagException, SystemException {
        LFSocialPackageTag lfSocialPackageTag = fetchByName_First(name,
                orderByComparator);

        if (lfSocialPackageTag != null) {
            return lfSocialPackageTag;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSocialPackageTagException(msg.toString());
    }

    /**
     * Returns the first l f social package tag in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f social package tag, or <code>null</code> if a matching l f social package tag could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag fetchByName_First(String name,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFSocialPackageTag> list = findByName(name, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f social package tag in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f social package tag
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a matching l f social package tag could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag findByName_Last(String name,
        OrderByComparator orderByComparator)
        throws NoSuchLFSocialPackageTagException, SystemException {
        LFSocialPackageTag lfSocialPackageTag = fetchByName_Last(name,
                orderByComparator);

        if (lfSocialPackageTag != null) {
            return lfSocialPackageTag;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSocialPackageTagException(msg.toString());
    }

    /**
     * Returns the last l f social package tag in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f social package tag, or <code>null</code> if a matching l f social package tag could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag fetchByName_Last(String name,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByName(name);

        if (count == 0) {
            return null;
        }

        List<LFSocialPackageTag> list = findByName(name, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f social package tags before and after the current l f social package tag in the ordered set where name = &#63;.
     *
     * @param id the primary key of the current l f social package tag
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f social package tag
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a l f social package tag with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag[] findByName_PrevAndNext(long id, String name,
        OrderByComparator orderByComparator)
        throws NoSuchLFSocialPackageTagException, SystemException {
        LFSocialPackageTag lfSocialPackageTag = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFSocialPackageTag[] array = new LFSocialPackageTagImpl[3];

            array[0] = getByName_PrevAndNext(session, lfSocialPackageTag, name,
                    orderByComparator, true);

            array[1] = lfSocialPackageTag;

            array[2] = getByName_PrevAndNext(session, lfSocialPackageTag, name,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFSocialPackageTag getByName_PrevAndNext(Session session,
        LFSocialPackageTag lfSocialPackageTag, String name,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFSOCIALPACKAGETAG_WHERE);

        boolean bindName = false;

        if (name == null) {
            query.append(_FINDER_COLUMN_NAME_NAME_1);
        } else if (name.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_NAME_NAME_3);
        } else {
            bindName = true;

            if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                query.append(_FINDER_COLUMN_NAME_NAME_2);
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
            query.append(LFSocialPackageTagModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindName) {
            if (name != null) {
                qPos.add(name);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfSocialPackageTag);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFSocialPackageTag> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f social package tags where name = &#63; from the database.
     *
     * @param name the name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByName(String name) throws SystemException {
        for (LFSocialPackageTag lfSocialPackageTag : findByName(name,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfSocialPackageTag);
        }
    }

    /**
     * Returns the number of l f social package tags where name = &#63;.
     *
     * @param name the name
     * @return the number of matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByName(String name) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

        Object[] finderArgs = new Object[] { name };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFSOCIALPACKAGETAG_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                if (name.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_NAME_NAME_3);
                } else {
                    query.append(_FINDER_COLUMN_NAME_NAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    if (name != null) {
                        qPos.add(name);
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
     * Returns all the l f social package tags where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @return the matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSocialPackageTag> findBySocialPackageID(
        Integer socialPackageID) throws SystemException {
        return findBySocialPackageID(socialPackageID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f social package tags where socialPackageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param socialPackageID the social package i d
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @return the range of matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSocialPackageTag> findBySocialPackageID(
        Integer socialPackageID, int start, int end) throws SystemException {
        return findBySocialPackageID(socialPackageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f social package tags where socialPackageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param socialPackageID the social package i d
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSocialPackageTag> findBySocialPackageID(
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

        List<LFSocialPackageTag> list = (List<LFSocialPackageTag>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFSocialPackageTag lfSocialPackageTag : list) {
                if (!Validator.equals(socialPackageID,
                            lfSocialPackageTag.getSocialPackageID())) {
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

            query.append(_SQL_SELECT_LFSOCIALPACKAGETAG_WHERE);

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
                query.append(LFSocialPackageTagModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFSocialPackageTag>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFSocialPackageTag>(list);
                } else {
                    list = (List<LFSocialPackageTag>) QueryUtil.list(q,
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
     * Returns the first l f social package tag in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f social package tag
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a matching l f social package tag could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag findBySocialPackageID_First(
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws NoSuchLFSocialPackageTagException, SystemException {
        LFSocialPackageTag lfSocialPackageTag = fetchBySocialPackageID_First(socialPackageID,
                orderByComparator);

        if (lfSocialPackageTag != null) {
            return lfSocialPackageTag;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("socialPackageID=");
        msg.append(socialPackageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSocialPackageTagException(msg.toString());
    }

    /**
     * Returns the first l f social package tag in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f social package tag, or <code>null</code> if a matching l f social package tag could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag fetchBySocialPackageID_First(
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFSocialPackageTag> list = findBySocialPackageID(socialPackageID,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f social package tag in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f social package tag
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a matching l f social package tag could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag findBySocialPackageID_Last(
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws NoSuchLFSocialPackageTagException, SystemException {
        LFSocialPackageTag lfSocialPackageTag = fetchBySocialPackageID_Last(socialPackageID,
                orderByComparator);

        if (lfSocialPackageTag != null) {
            return lfSocialPackageTag;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("socialPackageID=");
        msg.append(socialPackageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSocialPackageTagException(msg.toString());
    }

    /**
     * Returns the last l f social package tag in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f social package tag, or <code>null</code> if a matching l f social package tag could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag fetchBySocialPackageID_Last(
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countBySocialPackageID(socialPackageID);

        if (count == 0) {
            return null;
        }

        List<LFSocialPackageTag> list = findBySocialPackageID(socialPackageID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f social package tags before and after the current l f social package tag in the ordered set where socialPackageID = &#63;.
     *
     * @param id the primary key of the current l f social package tag
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f social package tag
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a l f social package tag with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag[] findBySocialPackageID_PrevAndNext(long id,
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws NoSuchLFSocialPackageTagException, SystemException {
        LFSocialPackageTag lfSocialPackageTag = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFSocialPackageTag[] array = new LFSocialPackageTagImpl[3];

            array[0] = getBySocialPackageID_PrevAndNext(session,
                    lfSocialPackageTag, socialPackageID, orderByComparator, true);

            array[1] = lfSocialPackageTag;

            array[2] = getBySocialPackageID_PrevAndNext(session,
                    lfSocialPackageTag, socialPackageID, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFSocialPackageTag getBySocialPackageID_PrevAndNext(
        Session session, LFSocialPackageTag lfSocialPackageTag,
        Integer socialPackageID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFSOCIALPACKAGETAG_WHERE);

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
            query.append(LFSocialPackageTagModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfSocialPackageTag);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFSocialPackageTag> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f social package tags where socialPackageID = &#63; from the database.
     *
     * @param socialPackageID the social package i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySocialPackageID(Integer socialPackageID)
        throws SystemException {
        for (LFSocialPackageTag lfSocialPackageTag : findBySocialPackageID(
                socialPackageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfSocialPackageTag);
        }
    }

    /**
     * Returns the number of l f social package tags where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @return the number of matching l f social package tags
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

            query.append(_SQL_COUNT_LFSOCIALPACKAGETAG_WHERE);

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
     * Caches the l f social package tag in the entity cache if it is enabled.
     *
     * @param lfSocialPackageTag the l f social package tag
     */
    @Override
    public void cacheResult(LFSocialPackageTag lfSocialPackageTag) {
        EntityCacheUtil.putResult(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagImpl.class, lfSocialPackageTag.getPrimaryKey(),
            lfSocialPackageTag);

        lfSocialPackageTag.resetOriginalValues();
    }

    /**
     * Caches the l f social package tags in the entity cache if it is enabled.
     *
     * @param lfSocialPackageTags the l f social package tags
     */
    @Override
    public void cacheResult(List<LFSocialPackageTag> lfSocialPackageTags) {
        for (LFSocialPackageTag lfSocialPackageTag : lfSocialPackageTags) {
            if (EntityCacheUtil.getResult(
                        LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
                        LFSocialPackageTagImpl.class,
                        lfSocialPackageTag.getPrimaryKey()) == null) {
                cacheResult(lfSocialPackageTag);
            } else {
                lfSocialPackageTag.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f social package tags.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFSocialPackageTagImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFSocialPackageTagImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f social package tag.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFSocialPackageTag lfSocialPackageTag) {
        EntityCacheUtil.removeResult(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagImpl.class, lfSocialPackageTag.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFSocialPackageTag> lfSocialPackageTags) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFSocialPackageTag lfSocialPackageTag : lfSocialPackageTags) {
            EntityCacheUtil.removeResult(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
                LFSocialPackageTagImpl.class, lfSocialPackageTag.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f social package tag with the primary key. Does not add the l f social package tag to the database.
     *
     * @param id the primary key for the new l f social package tag
     * @return the new l f social package tag
     */
    @Override
    public LFSocialPackageTag create(long id) {
        LFSocialPackageTag lfSocialPackageTag = new LFSocialPackageTagImpl();

        lfSocialPackageTag.setNew(true);
        lfSocialPackageTag.setPrimaryKey(id);

        return lfSocialPackageTag;
    }

    /**
     * Removes the l f social package tag with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f social package tag
     * @return the l f social package tag that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a l f social package tag with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag remove(long id)
        throws NoSuchLFSocialPackageTagException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f social package tag with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f social package tag
     * @return the l f social package tag that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a l f social package tag with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag remove(Serializable primaryKey)
        throws NoSuchLFSocialPackageTagException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFSocialPackageTag lfSocialPackageTag = (LFSocialPackageTag) session.get(LFSocialPackageTagImpl.class,
                    primaryKey);

            if (lfSocialPackageTag == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFSocialPackageTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfSocialPackageTag);
        } catch (NoSuchLFSocialPackageTagException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFSocialPackageTag removeImpl(
        LFSocialPackageTag lfSocialPackageTag) throws SystemException {
        lfSocialPackageTag = toUnwrappedModel(lfSocialPackageTag);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfSocialPackageTag)) {
                lfSocialPackageTag = (LFSocialPackageTag) session.get(LFSocialPackageTagImpl.class,
                        lfSocialPackageTag.getPrimaryKeyObj());
            }

            if (lfSocialPackageTag != null) {
                session.delete(lfSocialPackageTag);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfSocialPackageTag != null) {
            clearCache(lfSocialPackageTag);
        }

        return lfSocialPackageTag;
    }

    @Override
    public LFSocialPackageTag updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag lfSocialPackageTag)
        throws SystemException {
        lfSocialPackageTag = toUnwrappedModel(lfSocialPackageTag);

        boolean isNew = lfSocialPackageTag.isNew();

        LFSocialPackageTagModelImpl lfSocialPackageTagModelImpl = (LFSocialPackageTagModelImpl) lfSocialPackageTag;

        Session session = null;

        try {
            session = openSession();

            if (lfSocialPackageTag.isNew()) {
                session.save(lfSocialPackageTag);

                lfSocialPackageTag.setNew(false);
            } else {
                session.merge(lfSocialPackageTag);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFSocialPackageTagModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfSocialPackageTagModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfSocialPackageTagModelImpl.getOriginalName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);

                args = new Object[] { lfSocialPackageTagModelImpl.getName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);
            }

            if ((lfSocialPackageTagModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfSocialPackageTagModelImpl.getOriginalSocialPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCIALPACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID,
                    args);

                args = new Object[] {
                        lfSocialPackageTagModelImpl.getSocialPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCIALPACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagImpl.class, lfSocialPackageTag.getPrimaryKey(),
            lfSocialPackageTag);

        return lfSocialPackageTag;
    }

    protected LFSocialPackageTag toUnwrappedModel(
        LFSocialPackageTag lfSocialPackageTag) {
        if (lfSocialPackageTag instanceof LFSocialPackageTagImpl) {
            return lfSocialPackageTag;
        }

        LFSocialPackageTagImpl lfSocialPackageTagImpl = new LFSocialPackageTagImpl();

        lfSocialPackageTagImpl.setNew(lfSocialPackageTag.isNew());
        lfSocialPackageTagImpl.setPrimaryKey(lfSocialPackageTag.getPrimaryKey());

        lfSocialPackageTagImpl.setId(lfSocialPackageTag.getId());
        lfSocialPackageTagImpl.setSocialPackageID(lfSocialPackageTag.getSocialPackageID());
        lfSocialPackageTagImpl.setName(lfSocialPackageTag.getName());

        return lfSocialPackageTagImpl;
    }

    /**
     * Returns the l f social package tag with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f social package tag
     * @return the l f social package tag
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a l f social package tag with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFSocialPackageTagException, SystemException {
        LFSocialPackageTag lfSocialPackageTag = fetchByPrimaryKey(primaryKey);

        if (lfSocialPackageTag == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFSocialPackageTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfSocialPackageTag;
    }

    /**
     * Returns the l f social package tag with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException} if it could not be found.
     *
     * @param id the primary key of the l f social package tag
     * @return the l f social package tag
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a l f social package tag with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag findByPrimaryKey(long id)
        throws NoSuchLFSocialPackageTagException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f social package tag with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f social package tag
     * @return the l f social package tag, or <code>null</code> if a l f social package tag with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFSocialPackageTag lfSocialPackageTag = (LFSocialPackageTag) EntityCacheUtil.getResult(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
                LFSocialPackageTagImpl.class, primaryKey);

        if (lfSocialPackageTag == _nullLFSocialPackageTag) {
            return null;
        }

        if (lfSocialPackageTag == null) {
            Session session = null;

            try {
                session = openSession();

                lfSocialPackageTag = (LFSocialPackageTag) session.get(LFSocialPackageTagImpl.class,
                        primaryKey);

                if (lfSocialPackageTag != null) {
                    cacheResult(lfSocialPackageTag);
                } else {
                    EntityCacheUtil.putResult(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
                        LFSocialPackageTagImpl.class, primaryKey,
                        _nullLFSocialPackageTag);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
                    LFSocialPackageTagImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfSocialPackageTag;
    }

    /**
     * Returns the l f social package tag with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f social package tag
     * @return the l f social package tag, or <code>null</code> if a l f social package tag with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f social package tags.
     *
     * @return the l f social package tags
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSocialPackageTag> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f social package tags.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @return the range of l f social package tags
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSocialPackageTag> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f social package tags.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f social package tags
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSocialPackageTag> findAll(int start, int end,
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

        List<LFSocialPackageTag> list = (List<LFSocialPackageTag>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFSOCIALPACKAGETAG);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFSOCIALPACKAGETAG;

                if (pagination) {
                    sql = sql.concat(LFSocialPackageTagModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFSocialPackageTag>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFSocialPackageTag>(list);
                } else {
                    list = (List<LFSocialPackageTag>) QueryUtil.list(q,
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
     * Removes all the l f social package tags from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFSocialPackageTag lfSocialPackageTag : findAll()) {
            remove(lfSocialPackageTag);
        }
    }

    /**
     * Returns the number of l f social package tags.
     *
     * @return the number of l f social package tags
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

                Query q = session.createQuery(_SQL_COUNT_LFSOCIALPACKAGETAG);

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
     * Initializes the l f social package tag persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFSocialPackageTag>> listenersList = new ArrayList<ModelListener<LFSocialPackageTag>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFSocialPackageTag>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFSocialPackageTagImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
