package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException;
import com.arcusys.learn.persistence.liferay.model.LFTincanActor;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActorPersistence;

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
 * The persistence implementation for the l f tincan actor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActorPersistence
 * @see LFTincanActorUtil
 * @generated
 */
public class LFTincanActorPersistenceImpl extends BasePersistenceImpl<LFTincanActor>
    implements LFTincanActorPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanActorUtil} to access the l f tincan actor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanActorImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_TINCANID = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByTincanID", new String[] { String.class.getName() },
            LFTincanActorModelImpl.TINCANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TINCANID = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTincanID",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_1 = "lfTincanActor.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL = "lfTincanActor.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_2 = "lfTincanActor.tincanID = ?";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL_2 = "lfTincanActor.tincanID IS NULL ";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_3 = "(lfTincanActor.tincanID IS NULL OR lfTincanActor.tincanID = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBEROF = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByMemberOf",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBEROF =
        new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByMemberOf", new String[] { String.class.getName() },
            LFTincanActorModelImpl.MEMBEROF_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MEMBEROF = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMemberOf",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_MEMBEROF_MEMBEROF_1 = "lfTincanActor.memberOf IS NULL";
    private static final String _FINDER_COLUMN_MEMBEROF_MEMBEROF_NULL = "lfTincanActor.memberOf IS NULL";
    private static final String _FINDER_COLUMN_MEMBEROF_MEMBEROF_2 = "lfTincanActor.memberOf = ?";
    private static final String _FINDER_COLUMN_MEMBEROF_MEMBEROF_NULL_2 = "lfTincanActor.memberOf IS NULL ";
    private static final String _FINDER_COLUMN_MEMBEROF_MEMBEROF_3 = "(lfTincanActor.memberOf IS NULL OR lfTincanActor.memberOf = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AGENT = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByAgent",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENT = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByAgent",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                String.class.getName()
            },
            LFTincanActorModelImpl.OBJECTTYPE_COLUMN_BITMASK |
            LFTincanActorModelImpl.NAME_COLUMN_BITMASK |
            LFTincanActorModelImpl.MBOX_COLUMN_BITMASK |
            LFTincanActorModelImpl.MBOX_SHA1SUM_COLUMN_BITMASK |
            LFTincanActorModelImpl.OPENID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_AGENT = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAgent",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                String.class.getName()
            });
    private static final String _FINDER_COLUMN_AGENT_OBJECTTYPE_1 = "lfTincanActor.objectType IS NULL AND ";
    private static final String _FINDER_COLUMN_AGENT_OBJECTTYPE_NULL = "lfTincanActor.objectType IS NULL";
    private static final String _FINDER_COLUMN_AGENT_OBJECTTYPE_2 = "lfTincanActor.objectType = ? AND ";
    private static final String _FINDER_COLUMN_AGENT_OBJECTTYPE_NULL_2 = "lfTincanActor.objectType IS NULL  AND ";
    private static final String _FINDER_COLUMN_AGENT_OBJECTTYPE_3 = "(lfTincanActor.objectType IS NULL OR lfTincanActor.objectType = '') AND ";
    private static final String _FINDER_COLUMN_AGENT_NAME_1 = "lfTincanActor.name IS NULL AND ";
    private static final String _FINDER_COLUMN_AGENT_NAME_NULL = "lfTincanActor.name IS NULL";
    private static final String _FINDER_COLUMN_AGENT_NAME_2 = "lfTincanActor.name = ? AND ";
    private static final String _FINDER_COLUMN_AGENT_NAME_NULL_2 = "lfTincanActor.name IS NULL  AND ";
    private static final String _FINDER_COLUMN_AGENT_NAME_3 = "(lfTincanActor.name IS NULL OR lfTincanActor.name = '') AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_1 = "lfTincanActor.mbox IS NULL AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_NULL = "lfTincanActor.mbox IS NULL";
    private static final String _FINDER_COLUMN_AGENT_MBOX_2 = "lfTincanActor.mbox = ? AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_NULL_2 = "lfTincanActor.mbox IS NULL  AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_3 = "(lfTincanActor.mbox IS NULL OR lfTincanActor.mbox = '') AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_SHA1SUM_1 = "lfTincanActor.mbox_sha1sum IS NULL AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_SHA1SUM_NULL = "lfTincanActor.mbox_sha1sum IS NULL";
    private static final String _FINDER_COLUMN_AGENT_MBOX_SHA1SUM_2 = "lfTincanActor.mbox_sha1sum = ? AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_SHA1SUM_NULL_2 = "lfTincanActor.mbox_sha1sum IS NULL  AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_SHA1SUM_3 = "(lfTincanActor.mbox_sha1sum IS NULL OR lfTincanActor.mbox_sha1sum = '') AND ";
    private static final String _FINDER_COLUMN_AGENT_OPENID_1 = "lfTincanActor.openid IS NULL";
    private static final String _FINDER_COLUMN_AGENT_OPENID_NULL = "lfTincanActor.openid IS NULL";
    private static final String _FINDER_COLUMN_AGENT_OPENID_2 = "lfTincanActor.openid = ?";
    private static final String _FINDER_COLUMN_AGENT_OPENID_NULL_2 = "lfTincanActor.openid IS NULL ";
    private static final String _FINDER_COLUMN_AGENT_OPENID_3 = "(lfTincanActor.openid IS NULL OR lfTincanActor.openid = '')";
    private static final String _SQL_SELECT_LFTINCANACTOR = "SELECT lfTincanActor FROM LFTincanActor lfTincanActor";
    private static final String _SQL_SELECT_LFTINCANACTOR_WHERE = "SELECT lfTincanActor FROM LFTincanActor lfTincanActor WHERE ";
    private static final String _SQL_COUNT_LFTINCANACTOR = "SELECT COUNT(lfTincanActor) FROM LFTincanActor lfTincanActor";
    private static final String _SQL_COUNT_LFTINCANACTOR_WHERE = "SELECT COUNT(lfTincanActor) FROM LFTincanActor lfTincanActor WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanActor.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanActor exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanActor exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanActorPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFTincanActor _nullLFTincanActor = new LFTincanActorImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanActor> toCacheModel() {
                return _nullLFTincanActorCacheModel;
            }
        };

    private static CacheModel<LFTincanActor> _nullLFTincanActorCacheModel = new CacheModel<LFTincanActor>() {
            @Override
            public LFTincanActor toEntityModel() {
                return _nullLFTincanActor;
            }
        };

    public LFTincanActorPersistenceImpl() {
        setModelClass(LFTincanActor.class);
    }

    /**
     * Returns the l f tincan actor where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException} if it could not be found.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor findByTincanID(String tincanID)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByTincanID(tincanID);

        if (lfTincanActor == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("tincanID=");
            msg.append(tincanID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanActorException(msg.toString());
        }

        return lfTincanActor;
    }

    /**
     * Returns the l f tincan actor where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor fetchByTincanID(String tincanID)
        throws SystemException {
        return fetchByTincanID(tincanID, true);
    }

    /**
     * Returns the l f tincan actor where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param tincanID the tincan i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor fetchByTincanID(String tincanID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { tincanID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TINCANID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanActor) {
            LFTincanActor lfTincanActor = (LFTincanActor) result;

            if (!Validator.equals(tincanID, lfTincanActor.getTincanID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTINCANACTOR_WHERE);

            boolean bindTincanID = false;

            if (tincanID == null) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_1);
            } else if (tincanID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
            } else {
                bindTincanID = true;

                if (tincanID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
                } else {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTincanID) {
                    if (tincanID != null) {
                        qPos.add(tincanID);
                    }
                }

                List<LFTincanActor> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTincanActorPersistenceImpl.fetchByTincanID(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTincanActor lfTincanActor = list.get(0);

                    result = lfTincanActor;

                    cacheResult(lfTincanActor);

                    if ((lfTincanActor.getTincanID() == null) ||
                            !lfTincanActor.getTincanID().equals(tincanID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                            finderArgs, lfTincanActor);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFTincanActor) result;
        }
    }

    /**
     * Removes the l f tincan actor where tincanID = &#63; from the database.
     *
     * @param tincanID the tincan i d
     * @return the l f tincan actor that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor removeByTincanID(String tincanID)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = findByTincanID(tincanID);

        return remove(lfTincanActor);
    }

    /**
     * Returns the number of l f tincan actors where tincanID = &#63;.
     *
     * @param tincanID the tincan i d
     * @return the number of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTincanID(String tincanID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TINCANID;

        Object[] finderArgs = new Object[] { tincanID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANACTOR_WHERE);

            boolean bindTincanID = false;

            if (tincanID == null) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_1);
            } else if (tincanID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
            } else {
                bindTincanID = true;

                if (tincanID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
                } else {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTincanID) {
                    if (tincanID != null) {
                        qPos.add(tincanID);
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
     * Returns all the l f tincan actors where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @return the matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActor> findByMemberOf(String memberOf)
        throws SystemException {
        return findByMemberOf(memberOf, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan actors where memberOf = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param memberOf the member of
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @return the range of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActor> findByMemberOf(String memberOf, int start,
        int end) throws SystemException {
        return findByMemberOf(memberOf, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan actors where memberOf = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param memberOf the member of
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActor> findByMemberOf(String memberOf, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBEROF;
            finderArgs = new Object[] { memberOf };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBEROF;
            finderArgs = new Object[] { memberOf, start, end, orderByComparator };
        }

        List<LFTincanActor> list = (List<LFTincanActor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanActor lfTincanActor : list) {
                if (!Validator.equals(memberOf, lfTincanActor.getMemberOf())) {
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

            query.append(_SQL_SELECT_LFTINCANACTOR_WHERE);

            boolean bindMemberOf = false;

            if (memberOf == null) {
                query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_1);
            } else if (memberOf.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_3);
            } else {
                bindMemberOf = true;

                if (memberOf.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_3);
                } else {
                    query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFTincanActorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindMemberOf) {
                    if (memberOf != null) {
                        qPos.add(memberOf);
                    }
                }

                if (!pagination) {
                    list = (List<LFTincanActor>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanActor>(list);
                } else {
                    list = (List<LFTincanActor>) QueryUtil.list(q,
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
     * Returns the first l f tincan actor in the ordered set where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor findByMemberOf_First(String memberOf,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByMemberOf_First(memberOf,
                orderByComparator);

        if (lfTincanActor != null) {
            return lfTincanActor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("memberOf=");
        msg.append(memberOf);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActorException(msg.toString());
    }

    /**
     * Returns the first l f tincan actor in the ordered set where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor fetchByMemberOf_First(String memberOf,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanActor> list = findByMemberOf(memberOf, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan actor in the ordered set where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor findByMemberOf_Last(String memberOf,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByMemberOf_Last(memberOf,
                orderByComparator);

        if (lfTincanActor != null) {
            return lfTincanActor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("memberOf=");
        msg.append(memberOf);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActorException(msg.toString());
    }

    /**
     * Returns the last l f tincan actor in the ordered set where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor fetchByMemberOf_Last(String memberOf,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByMemberOf(memberOf);

        if (count == 0) {
            return null;
        }

        List<LFTincanActor> list = findByMemberOf(memberOf, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan actors before and after the current l f tincan actor in the ordered set where memberOf = &#63;.
     *
     * @param id the primary key of the current l f tincan actor
     * @param memberOf the member of
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor[] findByMemberOf_PrevAndNext(long id, String memberOf,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanActor[] array = new LFTincanActorImpl[3];

            array[0] = getByMemberOf_PrevAndNext(session, lfTincanActor,
                    memberOf, orderByComparator, true);

            array[1] = lfTincanActor;

            array[2] = getByMemberOf_PrevAndNext(session, lfTincanActor,
                    memberOf, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanActor getByMemberOf_PrevAndNext(Session session,
        LFTincanActor lfTincanActor, String memberOf,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANACTOR_WHERE);

        boolean bindMemberOf = false;

        if (memberOf == null) {
            query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_1);
        } else if (memberOf.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_3);
        } else {
            bindMemberOf = true;

            if (memberOf.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_3);
            } else {
                query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_2);
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
            query.append(LFTincanActorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindMemberOf) {
            if (memberOf != null) {
                qPos.add(memberOf);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanActor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanActor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f tincan actors where memberOf = &#63; from the database.
     *
     * @param memberOf the member of
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByMemberOf(String memberOf) throws SystemException {
        for (LFTincanActor lfTincanActor : findByMemberOf(memberOf,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfTincanActor);
        }
    }

    /**
     * Returns the number of l f tincan actors where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @return the number of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByMemberOf(String memberOf) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBEROF;

        Object[] finderArgs = new Object[] { memberOf };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANACTOR_WHERE);

            boolean bindMemberOf = false;

            if (memberOf == null) {
                query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_1);
            } else if (memberOf.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_3);
            } else {
                bindMemberOf = true;

                if (memberOf.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_3);
                } else {
                    query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindMemberOf) {
                    if (memberOf != null) {
                        qPos.add(memberOf);
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
     * Returns all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @return the matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActor> findByAgent(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid)
        throws SystemException {
        return findByAgent(objectType, name, mbox, mbox_sha1sum, openid,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @return the range of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActor> findByAgent(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid, int start, int end)
        throws SystemException {
        return findByAgent(objectType, name, mbox, mbox_sha1sum, openid, start,
            end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActor> findByAgent(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENT;
            finderArgs = new Object[] {
                    objectType, name, mbox, mbox_sha1sum, openid
                };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AGENT;
            finderArgs = new Object[] {
                    objectType, name, mbox, mbox_sha1sum, openid,
                    
                    start, end, orderByComparator
                };
        }

        List<LFTincanActor> list = (List<LFTincanActor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanActor lfTincanActor : list) {
                if (!Validator.equals(objectType, lfTincanActor.getObjectType()) ||
                        !Validator.equals(name, lfTincanActor.getName()) ||
                        !Validator.equals(mbox, lfTincanActor.getMbox()) ||
                        !Validator.equals(mbox_sha1sum,
                            lfTincanActor.getMbox_sha1sum()) ||
                        !Validator.equals(openid, lfTincanActor.getOpenid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(7 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(7);
            }

            query.append(_SQL_SELECT_LFTINCANACTOR_WHERE);

            boolean bindObjectType = false;

            if (objectType == null) {
                query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_1);
            } else if (objectType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_3);
            } else {
                bindObjectType = true;

                if (objectType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_2);
                }
            }

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_AGENT_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_NAME_3);
            } else {
                bindName = true;

                if (name.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_NAME_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_NAME_2);
                }
            }

            boolean bindMbox = false;

            if (mbox == null) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_1);
            } else if (mbox.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_3);
            } else {
                bindMbox = true;

                if (mbox.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_2);
                }
            }

            boolean bindMbox_sha1sum = false;

            if (mbox_sha1sum == null) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_1);
            } else if (mbox_sha1sum.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_3);
            } else {
                bindMbox_sha1sum = true;

                if (mbox_sha1sum.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_2);
                }
            }

            boolean bindOpenid = false;

            if (openid == null) {
                query.append(_FINDER_COLUMN_AGENT_OPENID_1);
            } else if (openid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_OPENID_3);
            } else {
                bindOpenid = true;

                if (openid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_OPENID_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_OPENID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFTincanActorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindObjectType) {
                    if (objectType != null) {
                        qPos.add(objectType);
                    }
                }

                if (bindName) {
                    if (name != null) {
                        qPos.add(name);
                    }
                }

                if (bindMbox) {
                    if (mbox != null) {
                        qPos.add(mbox);
                    }
                }

                if (bindMbox_sha1sum) {
                    if (mbox_sha1sum != null) {
                        qPos.add(mbox_sha1sum);
                    }
                }

                if (bindOpenid) {
                    if (openid != null) {
                        qPos.add(openid);
                    }
                }

                if (!pagination) {
                    list = (List<LFTincanActor>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanActor>(list);
                } else {
                    list = (List<LFTincanActor>) QueryUtil.list(q,
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
     * Returns the first l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor findByAgent_First(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByAgent_First(objectType, name,
                mbox, mbox_sha1sum, openid, orderByComparator);

        if (lfTincanActor != null) {
            return lfTincanActor;
        }

        StringBundler msg = new StringBundler(12);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("objectType=");
        msg.append(objectType);

        msg.append(", name=");
        msg.append(name);

        msg.append(", mbox=");
        msg.append(mbox);

        msg.append(", mbox_sha1sum=");
        msg.append(mbox_sha1sum);

        msg.append(", openid=");
        msg.append(openid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActorException(msg.toString());
    }

    /**
     * Returns the first l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor fetchByAgent_First(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanActor> list = findByAgent(objectType, name, mbox,
                mbox_sha1sum, openid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor findByAgent_Last(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByAgent_Last(objectType, name, mbox,
                mbox_sha1sum, openid, orderByComparator);

        if (lfTincanActor != null) {
            return lfTincanActor;
        }

        StringBundler msg = new StringBundler(12);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("objectType=");
        msg.append(objectType);

        msg.append(", name=");
        msg.append(name);

        msg.append(", mbox=");
        msg.append(mbox);

        msg.append(", mbox_sha1sum=");
        msg.append(mbox_sha1sum);

        msg.append(", openid=");
        msg.append(openid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActorException(msg.toString());
    }

    /**
     * Returns the last l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor fetchByAgent_Last(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAgent(objectType, name, mbox, mbox_sha1sum, openid);

        if (count == 0) {
            return null;
        }

        List<LFTincanActor> list = findByAgent(objectType, name, mbox,
                mbox_sha1sum, openid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan actors before and after the current l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param id the primary key of the current l f tincan actor
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor[] findByAgent_PrevAndNext(long id, String objectType,
        String name, String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanActor[] array = new LFTincanActorImpl[3];

            array[0] = getByAgent_PrevAndNext(session, lfTincanActor,
                    objectType, name, mbox, mbox_sha1sum, openid,
                    orderByComparator, true);

            array[1] = lfTincanActor;

            array[2] = getByAgent_PrevAndNext(session, lfTincanActor,
                    objectType, name, mbox, mbox_sha1sum, openid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanActor getByAgent_PrevAndNext(Session session,
        LFTincanActor lfTincanActor, String objectType, String name,
        String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANACTOR_WHERE);

        boolean bindObjectType = false;

        if (objectType == null) {
            query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_1);
        } else if (objectType.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_3);
        } else {
            bindObjectType = true;

            if (objectType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_3);
            } else {
                query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_2);
            }
        }

        boolean bindName = false;

        if (name == null) {
            query.append(_FINDER_COLUMN_AGENT_NAME_1);
        } else if (name.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_AGENT_NAME_3);
        } else {
            bindName = true;

            if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_NAME_3);
            } else {
                query.append(_FINDER_COLUMN_AGENT_NAME_2);
            }
        }

        boolean bindMbox = false;

        if (mbox == null) {
            query.append(_FINDER_COLUMN_AGENT_MBOX_1);
        } else if (mbox.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_AGENT_MBOX_3);
        } else {
            bindMbox = true;

            if (mbox.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_3);
            } else {
                query.append(_FINDER_COLUMN_AGENT_MBOX_2);
            }
        }

        boolean bindMbox_sha1sum = false;

        if (mbox_sha1sum == null) {
            query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_1);
        } else if (mbox_sha1sum.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_3);
        } else {
            bindMbox_sha1sum = true;

            if (mbox_sha1sum.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_3);
            } else {
                query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_2);
            }
        }

        boolean bindOpenid = false;

        if (openid == null) {
            query.append(_FINDER_COLUMN_AGENT_OPENID_1);
        } else if (openid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_AGENT_OPENID_3);
        } else {
            bindOpenid = true;

            if (openid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_OPENID_3);
            } else {
                query.append(_FINDER_COLUMN_AGENT_OPENID_2);
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
            query.append(LFTincanActorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindObjectType) {
            if (objectType != null) {
                qPos.add(objectType);
            }
        }

        if (bindName) {
            if (name != null) {
                qPos.add(name);
            }
        }

        if (bindMbox) {
            if (mbox != null) {
                qPos.add(mbox);
            }
        }

        if (bindMbox_sha1sum) {
            if (mbox_sha1sum != null) {
                qPos.add(mbox_sha1sum);
            }
        }

        if (bindOpenid) {
            if (openid != null) {
                qPos.add(openid);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanActor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanActor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; from the database.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAgent(String objectType, String name, String mbox,
        String mbox_sha1sum, String openid) throws SystemException {
        for (LFTincanActor lfTincanActor : findByAgent(objectType, name, mbox,
                mbox_sha1sum, openid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfTincanActor);
        }
    }

    /**
     * Returns the number of l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @return the number of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAgent(String objectType, String name, String mbox,
        String mbox_sha1sum, String openid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_AGENT;

        Object[] finderArgs = new Object[] {
                objectType, name, mbox, mbox_sha1sum, openid
            };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(6);

            query.append(_SQL_COUNT_LFTINCANACTOR_WHERE);

            boolean bindObjectType = false;

            if (objectType == null) {
                query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_1);
            } else if (objectType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_3);
            } else {
                bindObjectType = true;

                if (objectType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_2);
                }
            }

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_AGENT_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_NAME_3);
            } else {
                bindName = true;

                if (name.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_NAME_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_NAME_2);
                }
            }

            boolean bindMbox = false;

            if (mbox == null) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_1);
            } else if (mbox.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_3);
            } else {
                bindMbox = true;

                if (mbox.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_2);
                }
            }

            boolean bindMbox_sha1sum = false;

            if (mbox_sha1sum == null) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_1);
            } else if (mbox_sha1sum.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_3);
            } else {
                bindMbox_sha1sum = true;

                if (mbox_sha1sum.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_2);
                }
            }

            boolean bindOpenid = false;

            if (openid == null) {
                query.append(_FINDER_COLUMN_AGENT_OPENID_1);
            } else if (openid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_OPENID_3);
            } else {
                bindOpenid = true;

                if (openid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_OPENID_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_OPENID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindObjectType) {
                    if (objectType != null) {
                        qPos.add(objectType);
                    }
                }

                if (bindName) {
                    if (name != null) {
                        qPos.add(name);
                    }
                }

                if (bindMbox) {
                    if (mbox != null) {
                        qPos.add(mbox);
                    }
                }

                if (bindMbox_sha1sum) {
                    if (mbox_sha1sum != null) {
                        qPos.add(mbox_sha1sum);
                    }
                }

                if (bindOpenid) {
                    if (openid != null) {
                        qPos.add(openid);
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
     * Caches the l f tincan actor in the entity cache if it is enabled.
     *
     * @param lfTincanActor the l f tincan actor
     */
    @Override
    public void cacheResult(LFTincanActor lfTincanActor) {
        EntityCacheUtil.putResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorImpl.class, lfTincanActor.getPrimaryKey(),
            lfTincanActor);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
            new Object[] { lfTincanActor.getTincanID() }, lfTincanActor);

        lfTincanActor.resetOriginalValues();
    }

    /**
     * Caches the l f tincan actors in the entity cache if it is enabled.
     *
     * @param lfTincanActors the l f tincan actors
     */
    @Override
    public void cacheResult(List<LFTincanActor> lfTincanActors) {
        for (LFTincanActor lfTincanActor : lfTincanActors) {
            if (EntityCacheUtil.getResult(
                        LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanActorImpl.class, lfTincanActor.getPrimaryKey()) == null) {
                cacheResult(lfTincanActor);
            } else {
                lfTincanActor.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan actors.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanActorImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanActorImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan actor.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanActor lfTincanActor) {
        EntityCacheUtil.removeResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorImpl.class, lfTincanActor.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanActor);
    }

    @Override
    public void clearCache(List<LFTincanActor> lfTincanActors) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanActor lfTincanActor : lfTincanActors) {
            EntityCacheUtil.removeResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanActorImpl.class, lfTincanActor.getPrimaryKey());

            clearUniqueFindersCache(lfTincanActor);
        }
    }

    protected void cacheUniqueFindersCache(LFTincanActor lfTincanActor) {
        if (lfTincanActor.isNew()) {
            Object[] args = new Object[] { lfTincanActor.getTincanID() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TINCANID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID, args,
                lfTincanActor);
        } else {
            LFTincanActorModelImpl lfTincanActorModelImpl = (LFTincanActorModelImpl) lfTincanActor;

            if ((lfTincanActorModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TINCANID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lfTincanActor.getTincanID() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TINCANID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID, args,
                    lfTincanActor);
            }
        }
    }

    protected void clearUniqueFindersCache(LFTincanActor lfTincanActor) {
        LFTincanActorModelImpl lfTincanActorModelImpl = (LFTincanActorModelImpl) lfTincanActor;

        Object[] args = new Object[] { lfTincanActor.getTincanID() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TINCANID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID, args);

        if ((lfTincanActorModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TINCANID.getColumnBitmask()) != 0) {
            args = new Object[] { lfTincanActorModelImpl.getOriginalTincanID() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TINCANID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID, args);
        }
    }

    /**
     * Creates a new l f tincan actor with the primary key. Does not add the l f tincan actor to the database.
     *
     * @param id the primary key for the new l f tincan actor
     * @return the new l f tincan actor
     */
    @Override
    public LFTincanActor create(long id) {
        LFTincanActor lfTincanActor = new LFTincanActorImpl();

        lfTincanActor.setNew(true);
        lfTincanActor.setPrimaryKey(id);

        return lfTincanActor;
    }

    /**
     * Removes the l f tincan actor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan actor
     * @return the l f tincan actor that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor remove(long id)
        throws NoSuchLFTincanActorException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan actor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan actor
     * @return the l f tincan actor that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor remove(Serializable primaryKey)
        throws NoSuchLFTincanActorException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanActor lfTincanActor = (LFTincanActor) session.get(LFTincanActorImpl.class,
                    primaryKey);

            if (lfTincanActor == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanActorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanActor);
        } catch (NoSuchLFTincanActorException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanActor removeImpl(LFTincanActor lfTincanActor)
        throws SystemException {
        lfTincanActor = toUnwrappedModel(lfTincanActor);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanActor)) {
                lfTincanActor = (LFTincanActor) session.get(LFTincanActorImpl.class,
                        lfTincanActor.getPrimaryKeyObj());
            }

            if (lfTincanActor != null) {
                session.delete(lfTincanActor);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanActor != null) {
            clearCache(lfTincanActor);
        }

        return lfTincanActor;
    }

    @Override
    public LFTincanActor updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor)
        throws SystemException {
        lfTincanActor = toUnwrappedModel(lfTincanActor);

        boolean isNew = lfTincanActor.isNew();

        LFTincanActorModelImpl lfTincanActorModelImpl = (LFTincanActorModelImpl) lfTincanActor;

        Session session = null;

        try {
            session = openSession();

            if (lfTincanActor.isNew()) {
                session.save(lfTincanActor);

                lfTincanActor.setNew(false);
            } else {
                session.merge(lfTincanActor);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanActorModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanActorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBEROF.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanActorModelImpl.getOriginalMemberOf()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBEROF, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBEROF,
                    args);

                args = new Object[] { lfTincanActorModelImpl.getMemberOf() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBEROF, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBEROF,
                    args);
            }

            if ((lfTincanActorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanActorModelImpl.getOriginalObjectType(),
                        lfTincanActorModelImpl.getOriginalName(),
                        lfTincanActorModelImpl.getOriginalMbox(),
                        lfTincanActorModelImpl.getOriginalMbox_sha1sum(),
                        lfTincanActorModelImpl.getOriginalOpenid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AGENT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENT,
                    args);

                args = new Object[] {
                        lfTincanActorModelImpl.getObjectType(),
                        lfTincanActorModelImpl.getName(),
                        lfTincanActorModelImpl.getMbox(),
                        lfTincanActorModelImpl.getMbox_sha1sum(),
                        lfTincanActorModelImpl.getOpenid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AGENT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENT,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorImpl.class, lfTincanActor.getPrimaryKey(),
            lfTincanActor);

        clearUniqueFindersCache(lfTincanActor);
        cacheUniqueFindersCache(lfTincanActor);

        return lfTincanActor;
    }

    protected LFTincanActor toUnwrappedModel(LFTincanActor lfTincanActor) {
        if (lfTincanActor instanceof LFTincanActorImpl) {
            return lfTincanActor;
        }

        LFTincanActorImpl lfTincanActorImpl = new LFTincanActorImpl();

        lfTincanActorImpl.setNew(lfTincanActor.isNew());
        lfTincanActorImpl.setPrimaryKey(lfTincanActor.getPrimaryKey());

        lfTincanActorImpl.setId(lfTincanActor.getId());
        lfTincanActorImpl.setTincanID(lfTincanActor.getTincanID());
        lfTincanActorImpl.setObjectType(lfTincanActor.getObjectType());
        lfTincanActorImpl.setName(lfTincanActor.getName());
        lfTincanActorImpl.setMbox(lfTincanActor.getMbox());
        lfTincanActorImpl.setMbox_sha1sum(lfTincanActor.getMbox_sha1sum());
        lfTincanActorImpl.setOpenid(lfTincanActor.getOpenid());
        lfTincanActorImpl.setAccount(lfTincanActor.getAccount());
        lfTincanActorImpl.setMemberOf(lfTincanActor.getMemberOf());

        return lfTincanActorImpl;
    }

    /**
     * Returns the l f tincan actor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan actor
     * @return the l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByPrimaryKey(primaryKey);

        if (lfTincanActor == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanActorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanActor;
    }

    /**
     * Returns the l f tincan actor with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException} if it could not be found.
     *
     * @param id the primary key of the l f tincan actor
     * @return the l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor findByPrimaryKey(long id)
        throws NoSuchLFTincanActorException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan actor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan actor
     * @return the l f tincan actor, or <code>null</code> if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanActor lfTincanActor = (LFTincanActor) EntityCacheUtil.getResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanActorImpl.class, primaryKey);

        if (lfTincanActor == _nullLFTincanActor) {
            return null;
        }

        if (lfTincanActor == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanActor = (LFTincanActor) session.get(LFTincanActorImpl.class,
                        primaryKey);

                if (lfTincanActor != null) {
                    cacheResult(lfTincanActor);
                } else {
                    EntityCacheUtil.putResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanActorImpl.class, primaryKey, _nullLFTincanActor);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanActorImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanActor;
    }

    /**
     * Returns the l f tincan actor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan actor
     * @return the l f tincan actor, or <code>null</code> if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan actors.
     *
     * @return the l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActor> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan actors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @return the range of l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActor> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan actors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActor> findAll(int start, int end,
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

        List<LFTincanActor> list = (List<LFTincanActor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANACTOR);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANACTOR;

                if (pagination) {
                    sql = sql.concat(LFTincanActorModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanActor>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanActor>(list);
                } else {
                    list = (List<LFTincanActor>) QueryUtil.list(q,
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
     * Removes all the l f tincan actors from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanActor lfTincanActor : findAll()) {
            remove(lfTincanActor);
        }
    }

    /**
     * Returns the number of l f tincan actors.
     *
     * @return the number of l f tincan actors
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANACTOR);

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
     * Initializes the l f tincan actor persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanActor")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanActor>> listenersList = new ArrayList<ModelListener<LFTincanActor>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanActor>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanActorImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
