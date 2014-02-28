package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException;
import com.arcusys.learn.persistence.liferay.model.LFTincanActProfile;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanActProfileImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanActProfileModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActProfilePersistence;

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
 * The persistence implementation for the l f tincan act profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActProfilePersistence
 * @see LFTincanActProfileUtil
 * @generated
 */
public class LFTincanActProfilePersistenceImpl extends BasePersistenceImpl<LFTincanActProfile>
    implements LFTincanActProfilePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanActProfileUtil} to access the l f tincan act profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanActProfileImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID = new FinderPath(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByActivityIdAndProfileId",
            new String[] { String.class.getName(), String.class.getName() },
            LFTincanActProfileModelImpl.ACTIVITYID_COLUMN_BITMASK |
            LFTincanActProfileModelImpl.PROFILEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID = new FinderPath(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByActivityIdAndProfileId",
            new String[] { String.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_1 =
        "lfTincanActProfile.activityId IS NULL AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_NULL =
        "lfTincanActProfile.activityId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_2 =
        "lfTincanActProfile.activityId = ? AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_NULL_2 =
        "lfTincanActProfile.activityId IS NULL  AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_3 =
        "(lfTincanActProfile.activityId IS NULL OR lfTincanActProfile.activityId = '') AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_1 =
        "lfTincanActProfile.profileId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_NULL =
        "lfTincanActProfile.profileId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_2 =
        "lfTincanActProfile.profileId = ?";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_NULL_2 =
        "lfTincanActProfile.profileId IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_3 =
        "(lfTincanActProfile.profileId IS NULL OR lfTincanActProfile.profileId = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYID =
        new FinderPath(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActivityId",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID =
        new FinderPath(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActivityId",
            new String[] { String.class.getName() },
            LFTincanActProfileModelImpl.ACTIVITYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYID = new FinderPath(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActivityId",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_1 = "lfTincanActProfile.activityId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_NULL = "lfTincanActProfile.activityId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2 = "lfTincanActProfile.activityId = ?";
    private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_NULL_2 = "lfTincanActProfile.activityId IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_3 = "(lfTincanActProfile.activityId IS NULL OR lfTincanActProfile.activityId = '')";
    private static final String _SQL_SELECT_LFTINCANACTPROFILE = "SELECT lfTincanActProfile FROM LFTincanActProfile lfTincanActProfile";
    private static final String _SQL_SELECT_LFTINCANACTPROFILE_WHERE = "SELECT lfTincanActProfile FROM LFTincanActProfile lfTincanActProfile WHERE ";
    private static final String _SQL_COUNT_LFTINCANACTPROFILE = "SELECT COUNT(lfTincanActProfile) FROM LFTincanActProfile lfTincanActProfile";
    private static final String _SQL_COUNT_LFTINCANACTPROFILE_WHERE = "SELECT COUNT(lfTincanActProfile) FROM LFTincanActProfile lfTincanActProfile WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanActProfile.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanActProfile exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanActProfile exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanActProfilePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFTincanActProfile _nullLFTincanActProfile = new LFTincanActProfileImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanActProfile> toCacheModel() {
                return _nullLFTincanActProfileCacheModel;
            }
        };

    private static CacheModel<LFTincanActProfile> _nullLFTincanActProfileCacheModel =
        new CacheModel<LFTincanActProfile>() {
            @Override
            public LFTincanActProfile toEntityModel() {
                return _nullLFTincanActProfile;
            }
        };

    public LFTincanActProfilePersistenceImpl() {
        setModelClass(LFTincanActProfile.class);
    }

    /**
     * Returns the l f tincan act profile where activityId = &#63; and profileId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException} if it could not be found.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the matching l f tincan act profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a matching l f tincan act profile could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile findByActivityIdAndProfileId(String activityId,
        String profileId)
        throws NoSuchLFTincanActProfileException, SystemException {
        LFTincanActProfile lfTincanActProfile = fetchByActivityIdAndProfileId(activityId,
                profileId);

        if (lfTincanActProfile == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("activityId=");
            msg.append(activityId);

            msg.append(", profileId=");
            msg.append(profileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanActProfileException(msg.toString());
        }

        return lfTincanActProfile;
    }

    /**
     * Returns the l f tincan act profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile fetchByActivityIdAndProfileId(String activityId,
        String profileId) throws SystemException {
        return fetchByActivityIdAndProfileId(activityId, profileId, true);
    }

    /**
     * Returns the l f tincan act profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile fetchByActivityIdAndProfileId(String activityId,
        String profileId, boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { activityId, profileId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanActProfile) {
            LFTincanActProfile lfTincanActProfile = (LFTincanActProfile) result;

            if (!Validator.equals(activityId, lfTincanActProfile.getActivityId()) ||
                    !Validator.equals(profileId,
                        lfTincanActProfile.getProfileId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFTINCANACTPROFILE_WHERE);

            boolean bindActivityId = false;

            if (activityId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_1);
            } else if (activityId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_3);
            } else {
                bindActivityId = true;

                if (activityId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_2);
                }
            }

            boolean bindProfileId = false;

            if (profileId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_1);
            } else if (profileId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_3);
            } else {
                bindProfileId = true;

                if (profileId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindActivityId) {
                    if (activityId != null) {
                        qPos.add(activityId);
                    }
                }

                if (bindProfileId) {
                    if (profileId != null) {
                        qPos.add(profileId);
                    }
                }

                List<LFTincanActProfile> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTincanActProfilePersistenceImpl.fetchByActivityIdAndProfileId(String, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTincanActProfile lfTincanActProfile = list.get(0);

                    result = lfTincanActProfile;

                    cacheResult(lfTincanActProfile);

                    if ((lfTincanActProfile.getActivityId() == null) ||
                            !lfTincanActProfile.getActivityId()
                                                   .equals(activityId) ||
                            (lfTincanActProfile.getProfileId() == null) ||
                            !lfTincanActProfile.getProfileId().equals(profileId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                            finderArgs, lfTincanActProfile);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFTincanActProfile) result;
        }
    }

    /**
     * Removes the l f tincan act profile where activityId = &#63; and profileId = &#63; from the database.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the l f tincan act profile that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile removeByActivityIdAndProfileId(
        String activityId, String profileId)
        throws NoSuchLFTincanActProfileException, SystemException {
        LFTincanActProfile lfTincanActProfile = findByActivityIdAndProfileId(activityId,
                profileId);

        return remove(lfTincanActProfile);
    }

    /**
     * Returns the number of l f tincan act profiles where activityId = &#63; and profileId = &#63;.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the number of matching l f tincan act profiles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByActivityIdAndProfileId(String activityId, String profileId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID;

        Object[] finderArgs = new Object[] { activityId, profileId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFTINCANACTPROFILE_WHERE);

            boolean bindActivityId = false;

            if (activityId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_1);
            } else if (activityId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_3);
            } else {
                bindActivityId = true;

                if (activityId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_2);
                }
            }

            boolean bindProfileId = false;

            if (profileId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_1);
            } else if (profileId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_3);
            } else {
                bindProfileId = true;

                if (profileId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindActivityId) {
                    if (activityId != null) {
                        qPos.add(activityId);
                    }
                }

                if (bindProfileId) {
                    if (profileId != null) {
                        qPos.add(profileId);
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
     * Returns all the l f tincan act profiles where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @return the matching l f tincan act profiles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActProfile> findByActivityId(String activityId)
        throws SystemException {
        return findByActivityId(activityId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan act profiles where activityId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param activityId the activity ID
     * @param start the lower bound of the range of l f tincan act profiles
     * @param end the upper bound of the range of l f tincan act profiles (not inclusive)
     * @return the range of matching l f tincan act profiles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActProfile> findByActivityId(String activityId,
        int start, int end) throws SystemException {
        return findByActivityId(activityId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan act profiles where activityId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param activityId the activity ID
     * @param start the lower bound of the range of l f tincan act profiles
     * @param end the upper bound of the range of l f tincan act profiles (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan act profiles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActProfile> findByActivityId(String activityId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID;
            finderArgs = new Object[] { activityId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYID;
            finderArgs = new Object[] { activityId, start, end, orderByComparator };
        }

        List<LFTincanActProfile> list = (List<LFTincanActProfile>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanActProfile lfTincanActProfile : list) {
                if (!Validator.equals(activityId,
                            lfTincanActProfile.getActivityId())) {
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

            query.append(_SQL_SELECT_LFTINCANACTPROFILE_WHERE);

            boolean bindActivityId = false;

            if (activityId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_1);
            } else if (activityId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_3);
            } else {
                bindActivityId = true;

                if (activityId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFTincanActProfileModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindActivityId) {
                    if (activityId != null) {
                        qPos.add(activityId);
                    }
                }

                if (!pagination) {
                    list = (List<LFTincanActProfile>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanActProfile>(list);
                } else {
                    list = (List<LFTincanActProfile>) QueryUtil.list(q,
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
     * Returns the first l f tincan act profile in the ordered set where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan act profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a matching l f tincan act profile could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile findByActivityId_First(String activityId,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActProfileException, SystemException {
        LFTincanActProfile lfTincanActProfile = fetchByActivityId_First(activityId,
                orderByComparator);

        if (lfTincanActProfile != null) {
            return lfTincanActProfile;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityId=");
        msg.append(activityId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActProfileException(msg.toString());
    }

    /**
     * Returns the first l f tincan act profile in the ordered set where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile fetchByActivityId_First(String activityId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanActProfile> list = findByActivityId(activityId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan act profile in the ordered set where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan act profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a matching l f tincan act profile could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile findByActivityId_Last(String activityId,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActProfileException, SystemException {
        LFTincanActProfile lfTincanActProfile = fetchByActivityId_Last(activityId,
                orderByComparator);

        if (lfTincanActProfile != null) {
            return lfTincanActProfile;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityId=");
        msg.append(activityId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActProfileException(msg.toString());
    }

    /**
     * Returns the last l f tincan act profile in the ordered set where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile fetchByActivityId_Last(String activityId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByActivityId(activityId);

        if (count == 0) {
            return null;
        }

        List<LFTincanActProfile> list = findByActivityId(activityId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan act profiles before and after the current l f tincan act profile in the ordered set where activityId = &#63;.
     *
     * @param id the primary key of the current l f tincan act profile
     * @param activityId the activity ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan act profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a l f tincan act profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile[] findByActivityId_PrevAndNext(long id,
        String activityId, OrderByComparator orderByComparator)
        throws NoSuchLFTincanActProfileException, SystemException {
        LFTincanActProfile lfTincanActProfile = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanActProfile[] array = new LFTincanActProfileImpl[3];

            array[0] = getByActivityId_PrevAndNext(session, lfTincanActProfile,
                    activityId, orderByComparator, true);

            array[1] = lfTincanActProfile;

            array[2] = getByActivityId_PrevAndNext(session, lfTincanActProfile,
                    activityId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanActProfile getByActivityId_PrevAndNext(Session session,
        LFTincanActProfile lfTincanActProfile, String activityId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANACTPROFILE_WHERE);

        boolean bindActivityId = false;

        if (activityId == null) {
            query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_1);
        } else if (activityId.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_3);
        } else {
            bindActivityId = true;

            if (activityId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_3);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2);
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
            query.append(LFTincanActProfileModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindActivityId) {
            if (activityId != null) {
                qPos.add(activityId);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanActProfile);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanActProfile> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f tincan act profiles where activityId = &#63; from the database.
     *
     * @param activityId the activity ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByActivityId(String activityId) throws SystemException {
        for (LFTincanActProfile lfTincanActProfile : findByActivityId(
                activityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfTincanActProfile);
        }
    }

    /**
     * Returns the number of l f tincan act profiles where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @return the number of matching l f tincan act profiles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByActivityId(String activityId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVITYID;

        Object[] finderArgs = new Object[] { activityId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANACTPROFILE_WHERE);

            boolean bindActivityId = false;

            if (activityId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_1);
            } else if (activityId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_3);
            } else {
                bindActivityId = true;

                if (activityId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindActivityId) {
                    if (activityId != null) {
                        qPos.add(activityId);
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
     * Caches the l f tincan act profile in the entity cache if it is enabled.
     *
     * @param lfTincanActProfile the l f tincan act profile
     */
    @Override
    public void cacheResult(LFTincanActProfile lfTincanActProfile) {
        EntityCacheUtil.putResult(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActProfileImpl.class, lfTincanActProfile.getPrimaryKey(),
            lfTincanActProfile);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
            new Object[] {
                lfTincanActProfile.getActivityId(),
                lfTincanActProfile.getProfileId()
            }, lfTincanActProfile);

        lfTincanActProfile.resetOriginalValues();
    }

    /**
     * Caches the l f tincan act profiles in the entity cache if it is enabled.
     *
     * @param lfTincanActProfiles the l f tincan act profiles
     */
    @Override
    public void cacheResult(List<LFTincanActProfile> lfTincanActProfiles) {
        for (LFTincanActProfile lfTincanActProfile : lfTincanActProfiles) {
            if (EntityCacheUtil.getResult(
                        LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanActProfileImpl.class,
                        lfTincanActProfile.getPrimaryKey()) == null) {
                cacheResult(lfTincanActProfile);
            } else {
                lfTincanActProfile.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan act profiles.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanActProfileImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanActProfileImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan act profile.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanActProfile lfTincanActProfile) {
        EntityCacheUtil.removeResult(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActProfileImpl.class, lfTincanActProfile.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanActProfile);
    }

    @Override
    public void clearCache(List<LFTincanActProfile> lfTincanActProfiles) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanActProfile lfTincanActProfile : lfTincanActProfiles) {
            EntityCacheUtil.removeResult(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanActProfileImpl.class, lfTincanActProfile.getPrimaryKey());

            clearUniqueFindersCache(lfTincanActProfile);
        }
    }

    protected void cacheUniqueFindersCache(
        LFTincanActProfile lfTincanActProfile) {
        if (lfTincanActProfile.isNew()) {
            Object[] args = new Object[] {
                    lfTincanActProfile.getActivityId(),
                    lfTincanActProfile.getProfileId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                args, lfTincanActProfile);
        } else {
            LFTincanActProfileModelImpl lfTincanActProfileModelImpl = (LFTincanActProfileModelImpl) lfTincanActProfile;

            if ((lfTincanActProfileModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanActProfile.getActivityId(),
                        lfTincanActProfile.getProfileId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                    args, lfTincanActProfile);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFTincanActProfile lfTincanActProfile) {
        LFTincanActProfileModelImpl lfTincanActProfileModelImpl = (LFTincanActProfileModelImpl) lfTincanActProfile;

        Object[] args = new Object[] {
                lfTincanActProfile.getActivityId(),
                lfTincanActProfile.getProfileId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
            args);

        if ((lfTincanActProfileModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfTincanActProfileModelImpl.getOriginalActivityId(),
                    lfTincanActProfileModelImpl.getOriginalProfileId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                args);
        }
    }

    /**
     * Creates a new l f tincan act profile with the primary key. Does not add the l f tincan act profile to the database.
     *
     * @param id the primary key for the new l f tincan act profile
     * @return the new l f tincan act profile
     */
    @Override
    public LFTincanActProfile create(long id) {
        LFTincanActProfile lfTincanActProfile = new LFTincanActProfileImpl();

        lfTincanActProfile.setNew(true);
        lfTincanActProfile.setPrimaryKey(id);

        return lfTincanActProfile;
    }

    /**
     * Removes the l f tincan act profile with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan act profile
     * @return the l f tincan act profile that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a l f tincan act profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile remove(long id)
        throws NoSuchLFTincanActProfileException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan act profile with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan act profile
     * @return the l f tincan act profile that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a l f tincan act profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile remove(Serializable primaryKey)
        throws NoSuchLFTincanActProfileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanActProfile lfTincanActProfile = (LFTincanActProfile) session.get(LFTincanActProfileImpl.class,
                    primaryKey);

            if (lfTincanActProfile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanActProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanActProfile);
        } catch (NoSuchLFTincanActProfileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanActProfile removeImpl(
        LFTincanActProfile lfTincanActProfile) throws SystemException {
        lfTincanActProfile = toUnwrappedModel(lfTincanActProfile);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanActProfile)) {
                lfTincanActProfile = (LFTincanActProfile) session.get(LFTincanActProfileImpl.class,
                        lfTincanActProfile.getPrimaryKeyObj());
            }

            if (lfTincanActProfile != null) {
                session.delete(lfTincanActProfile);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanActProfile != null) {
            clearCache(lfTincanActProfile);
        }

        return lfTincanActProfile;
    }

    @Override
    public LFTincanActProfile updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanActProfile lfTincanActProfile)
        throws SystemException {
        lfTincanActProfile = toUnwrappedModel(lfTincanActProfile);

        boolean isNew = lfTincanActProfile.isNew();

        LFTincanActProfileModelImpl lfTincanActProfileModelImpl = (LFTincanActProfileModelImpl) lfTincanActProfile;

        Session session = null;

        try {
            session = openSession();

            if (lfTincanActProfile.isNew()) {
                session.save(lfTincanActProfile);

                lfTincanActProfile.setNew(false);
            } else {
                session.merge(lfTincanActProfile);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanActProfileModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanActProfileModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanActProfileModelImpl.getOriginalActivityId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
                    args);

                args = new Object[] { lfTincanActProfileModelImpl.getActivityId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActProfileImpl.class, lfTincanActProfile.getPrimaryKey(),
            lfTincanActProfile);

        clearUniqueFindersCache(lfTincanActProfile);
        cacheUniqueFindersCache(lfTincanActProfile);

        return lfTincanActProfile;
    }

    protected LFTincanActProfile toUnwrappedModel(
        LFTincanActProfile lfTincanActProfile) {
        if (lfTincanActProfile instanceof LFTincanActProfileImpl) {
            return lfTincanActProfile;
        }

        LFTincanActProfileImpl lfTincanActProfileImpl = new LFTincanActProfileImpl();

        lfTincanActProfileImpl.setNew(lfTincanActProfile.isNew());
        lfTincanActProfileImpl.setPrimaryKey(lfTincanActProfile.getPrimaryKey());

        lfTincanActProfileImpl.setId(lfTincanActProfile.getId());
        lfTincanActProfileImpl.setDocumentId(lfTincanActProfile.getDocumentId());
        lfTincanActProfileImpl.setActivityId(lfTincanActProfile.getActivityId());
        lfTincanActProfileImpl.setProfileId(lfTincanActProfile.getProfileId());

        return lfTincanActProfileImpl;
    }

    /**
     * Returns the l f tincan act profile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan act profile
     * @return the l f tincan act profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a l f tincan act profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanActProfileException, SystemException {
        LFTincanActProfile lfTincanActProfile = fetchByPrimaryKey(primaryKey);

        if (lfTincanActProfile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanActProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanActProfile;
    }

    /**
     * Returns the l f tincan act profile with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException} if it could not be found.
     *
     * @param id the primary key of the l f tincan act profile
     * @return the l f tincan act profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a l f tincan act profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile findByPrimaryKey(long id)
        throws NoSuchLFTincanActProfileException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan act profile with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan act profile
     * @return the l f tincan act profile, or <code>null</code> if a l f tincan act profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanActProfile lfTincanActProfile = (LFTincanActProfile) EntityCacheUtil.getResult(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanActProfileImpl.class, primaryKey);

        if (lfTincanActProfile == _nullLFTincanActProfile) {
            return null;
        }

        if (lfTincanActProfile == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanActProfile = (LFTincanActProfile) session.get(LFTincanActProfileImpl.class,
                        primaryKey);

                if (lfTincanActProfile != null) {
                    cacheResult(lfTincanActProfile);
                } else {
                    EntityCacheUtil.putResult(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanActProfileImpl.class, primaryKey,
                        _nullLFTincanActProfile);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanActProfileModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanActProfileImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanActProfile;
    }

    /**
     * Returns the l f tincan act profile with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan act profile
     * @return the l f tincan act profile, or <code>null</code> if a l f tincan act profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActProfile fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan act profiles.
     *
     * @return the l f tincan act profiles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActProfile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan act profiles.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan act profiles
     * @param end the upper bound of the range of l f tincan act profiles (not inclusive)
     * @return the range of l f tincan act profiles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActProfile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan act profiles.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan act profiles
     * @param end the upper bound of the range of l f tincan act profiles (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan act profiles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActProfile> findAll(int start, int end,
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

        List<LFTincanActProfile> list = (List<LFTincanActProfile>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANACTPROFILE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANACTPROFILE;

                if (pagination) {
                    sql = sql.concat(LFTincanActProfileModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanActProfile>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanActProfile>(list);
                } else {
                    list = (List<LFTincanActProfile>) QueryUtil.list(q,
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
     * Removes all the l f tincan act profiles from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanActProfile lfTincanActProfile : findAll()) {
            remove(lfTincanActProfile);
        }
    }

    /**
     * Returns the number of l f tincan act profiles.
     *
     * @return the number of l f tincan act profiles
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANACTPROFILE);

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
     * Initializes the l f tincan act profile persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanActProfile")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanActProfile>> listenersList = new ArrayList<ModelListener<LFTincanActProfile>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanActProfile>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanActProfileImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
