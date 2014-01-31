package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsActivityProfileImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsActivityProfileModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsActivityProfilePersistence;

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
 * The persistence implementation for the l f tincan lrs activity profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsActivityProfilePersistence
 * @see LFTincanLrsActivityProfileUtil
 * @generated
 */
public class LFTincanLrsActivityProfilePersistenceImpl
    extends BasePersistenceImpl<LFTincanLrsActivityProfile>
    implements LFTincanLrsActivityProfilePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsActivityProfileUtil} to access the l f tincan lrs activity profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsActivityProfileImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
            new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID = new FinderPath(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByActivityIdAndProfileId",
            new String[] { String.class.getName(), String.class.getName() },
            LFTincanLrsActivityProfileModelImpl.ACTIVITYID_COLUMN_BITMASK |
            LFTincanLrsActivityProfileModelImpl.PROFILEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID = new FinderPath(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByActivityIdAndProfileId",
            new String[] { String.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_1 =
        "lfTincanLrsActivityProfile.activityId IS NULL AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_NULL =
        "lfTincanLrsActivityProfile.activityId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_2 =
        "lfTincanLrsActivityProfile.activityId = ? AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_NULL_2 =
        "lfTincanLrsActivityProfile.activityId IS NULL  AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_3 =
        "(lfTincanLrsActivityProfile.activityId IS NULL OR lfTincanLrsActivityProfile.activityId = '') AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_1 =
        "lfTincanLrsActivityProfile.profileId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_NULL =
        "lfTincanLrsActivityProfile.profileId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_2 =
        "lfTincanLrsActivityProfile.profileId = ?";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_NULL_2 =
        "lfTincanLrsActivityProfile.profileId IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_3 =
        "(lfTincanLrsActivityProfile.profileId IS NULL OR lfTincanLrsActivityProfile.profileId = '')";
    private static final String _SQL_SELECT_LFTINCANLRSACTIVITYPROFILE = "SELECT lfTincanLrsActivityProfile FROM LFTincanLrsActivityProfile lfTincanLrsActivityProfile";
    private static final String _SQL_SELECT_LFTINCANLRSACTIVITYPROFILE_WHERE = "SELECT lfTincanLrsActivityProfile FROM LFTincanLrsActivityProfile lfTincanLrsActivityProfile WHERE ";
    private static final String _SQL_COUNT_LFTINCANLRSACTIVITYPROFILE = "SELECT COUNT(lfTincanLrsActivityProfile) FROM LFTincanLrsActivityProfile lfTincanLrsActivityProfile";
    private static final String _SQL_COUNT_LFTINCANLRSACTIVITYPROFILE_WHERE = "SELECT COUNT(lfTincanLrsActivityProfile) FROM LFTincanLrsActivityProfile lfTincanLrsActivityProfile WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsActivityProfile.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsActivityProfile exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanLrsActivityProfile exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsActivityProfilePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFTincanLrsActivityProfile _nullLFTincanLrsActivityProfile = new LFTincanLrsActivityProfileImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsActivityProfile> toCacheModel() {
                return _nullLFTincanLrsActivityProfileCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsActivityProfile> _nullLFTincanLrsActivityProfileCacheModel =
        new CacheModel<LFTincanLrsActivityProfile>() {
            @Override
            public LFTincanLrsActivityProfile toEntityModel() {
                return _nullLFTincanLrsActivityProfile;
            }
        };

    public LFTincanLrsActivityProfilePersistenceImpl() {
        setModelClass(LFTincanLrsActivityProfile.class);
    }

    /**
     * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException} if it could not be found.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the matching l f tincan lrs activity profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a matching l f tincan lrs activity profile could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile findByActivityIdAndProfileId(
        String activityId, String profileId)
        throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile = fetchByActivityIdAndProfileId(activityId,
                profileId);

        if (lfTincanLrsActivityProfile == null) {
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

            throw new NoSuchLFTincanLrsActivityProfileException(msg.toString());
        }

        return lfTincanLrsActivityProfile;
    }

    /**
     * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the matching l f tincan lrs activity profile, or <code>null</code> if a matching l f tincan lrs activity profile could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile fetchByActivityIdAndProfileId(
        String activityId, String profileId) throws SystemException {
        return fetchByActivityIdAndProfileId(activityId, profileId, true);
    }

    /**
     * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan lrs activity profile, or <code>null</code> if a matching l f tincan lrs activity profile could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile fetchByActivityIdAndProfileId(
        String activityId, String profileId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { activityId, profileId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanLrsActivityProfile) {
            LFTincanLrsActivityProfile lfTincanLrsActivityProfile = (LFTincanLrsActivityProfile) result;

            if (!Validator.equals(activityId,
                        lfTincanLrsActivityProfile.getActivityId()) ||
                    !Validator.equals(profileId,
                        lfTincanLrsActivityProfile.getProfileId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFTINCANLRSACTIVITYPROFILE_WHERE);

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

                List<LFTincanLrsActivityProfile> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTincanLrsActivityProfilePersistenceImpl.fetchByActivityIdAndProfileId(String, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTincanLrsActivityProfile lfTincanLrsActivityProfile = list.get(0);

                    result = lfTincanLrsActivityProfile;

                    cacheResult(lfTincanLrsActivityProfile);

                    if ((lfTincanLrsActivityProfile.getActivityId() == null) ||
                            !lfTincanLrsActivityProfile.getActivityId()
                                                           .equals(activityId) ||
                            (lfTincanLrsActivityProfile.getProfileId() == null) ||
                            !lfTincanLrsActivityProfile.getProfileId()
                                                           .equals(profileId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                            finderArgs, lfTincanLrsActivityProfile);
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
            return (LFTincanLrsActivityProfile) result;
        }
    }

    /**
     * Removes the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; from the database.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the l f tincan lrs activity profile that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile removeByActivityIdAndProfileId(
        String activityId, String profileId)
        throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile = findByActivityIdAndProfileId(activityId,
                profileId);

        return remove(lfTincanLrsActivityProfile);
    }

    /**
     * Returns the number of l f tincan lrs activity profiles where activityId = &#63; and profileId = &#63;.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the number of matching l f tincan lrs activity profiles
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

            query.append(_SQL_COUNT_LFTINCANLRSACTIVITYPROFILE_WHERE);

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
     * Caches the l f tincan lrs activity profile in the entity cache if it is enabled.
     *
     * @param lfTincanLrsActivityProfile the l f tincan lrs activity profile
     */
    @Override
    public void cacheResult(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        EntityCacheUtil.putResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class,
            lfTincanLrsActivityProfile.getPrimaryKey(),
            lfTincanLrsActivityProfile);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
            new Object[] {
                lfTincanLrsActivityProfile.getActivityId(),
                lfTincanLrsActivityProfile.getProfileId()
            }, lfTincanLrsActivityProfile);

        lfTincanLrsActivityProfile.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs activity profiles in the entity cache if it is enabled.
     *
     * @param lfTincanLrsActivityProfiles the l f tincan lrs activity profiles
     */
    @Override
    public void cacheResult(
        List<LFTincanLrsActivityProfile> lfTincanLrsActivityProfiles) {
        for (LFTincanLrsActivityProfile lfTincanLrsActivityProfile : lfTincanLrsActivityProfiles) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsActivityProfileImpl.class,
                        lfTincanLrsActivityProfile.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsActivityProfile);
            } else {
                lfTincanLrsActivityProfile.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs activity profiles.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsActivityProfileImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsActivityProfileImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs activity profile.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        EntityCacheUtil.removeResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class,
            lfTincanLrsActivityProfile.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanLrsActivityProfile);
    }

    @Override
    public void clearCache(
        List<LFTincanLrsActivityProfile> lfTincanLrsActivityProfiles) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsActivityProfile lfTincanLrsActivityProfile : lfTincanLrsActivityProfiles) {
            EntityCacheUtil.removeResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsActivityProfileImpl.class,
                lfTincanLrsActivityProfile.getPrimaryKey());

            clearUniqueFindersCache(lfTincanLrsActivityProfile);
        }
    }

    protected void cacheUniqueFindersCache(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        if (lfTincanLrsActivityProfile.isNew()) {
            Object[] args = new Object[] {
                    lfTincanLrsActivityProfile.getActivityId(),
                    lfTincanLrsActivityProfile.getProfileId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                args, lfTincanLrsActivityProfile);
        } else {
            LFTincanLrsActivityProfileModelImpl lfTincanLrsActivityProfileModelImpl =
                (LFTincanLrsActivityProfileModelImpl) lfTincanLrsActivityProfile;

            if ((lfTincanLrsActivityProfileModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanLrsActivityProfile.getActivityId(),
                        lfTincanLrsActivityProfile.getProfileId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                    args, lfTincanLrsActivityProfile);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        LFTincanLrsActivityProfileModelImpl lfTincanLrsActivityProfileModelImpl = (LFTincanLrsActivityProfileModelImpl) lfTincanLrsActivityProfile;

        Object[] args = new Object[] {
                lfTincanLrsActivityProfile.getActivityId(),
                lfTincanLrsActivityProfile.getProfileId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
            args);

        if ((lfTincanLrsActivityProfileModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfTincanLrsActivityProfileModelImpl.getOriginalActivityId(),
                    lfTincanLrsActivityProfileModelImpl.getOriginalProfileId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                args);
        }
    }

    /**
     * Creates a new l f tincan lrs activity profile with the primary key. Does not add the l f tincan lrs activity profile to the database.
     *
     * @param id the primary key for the new l f tincan lrs activity profile
     * @return the new l f tincan lrs activity profile
     */
    @Override
    public LFTincanLrsActivityProfile create(long id) {
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile = new LFTincanLrsActivityProfileImpl();

        lfTincanLrsActivityProfile.setNew(true);
        lfTincanLrsActivityProfile.setPrimaryKey(id);

        return lfTincanLrsActivityProfile;
    }

    /**
     * Removes the l f tincan lrs activity profile with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile remove(long id)
        throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan lrs activity profile with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsActivityProfile lfTincanLrsActivityProfile = (LFTincanLrsActivityProfile) session.get(LFTincanLrsActivityProfileImpl.class,
                    primaryKey);

            if (lfTincanLrsActivityProfile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsActivityProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsActivityProfile);
        } catch (NoSuchLFTincanLrsActivityProfileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsActivityProfile removeImpl(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile)
        throws SystemException {
        lfTincanLrsActivityProfile = toUnwrappedModel(lfTincanLrsActivityProfile);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanLrsActivityProfile)) {
                lfTincanLrsActivityProfile = (LFTincanLrsActivityProfile) session.get(LFTincanLrsActivityProfileImpl.class,
                        lfTincanLrsActivityProfile.getPrimaryKeyObj());
            }

            if (lfTincanLrsActivityProfile != null) {
                session.delete(lfTincanLrsActivityProfile);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanLrsActivityProfile != null) {
            clearCache(lfTincanLrsActivityProfile);
        }

        return lfTincanLrsActivityProfile;
    }

    @Override
    public LFTincanLrsActivityProfile updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile lfTincanLrsActivityProfile)
        throws SystemException {
        lfTincanLrsActivityProfile = toUnwrappedModel(lfTincanLrsActivityProfile);

        boolean isNew = lfTincanLrsActivityProfile.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfTincanLrsActivityProfile.isNew()) {
                session.save(lfTincanLrsActivityProfile);

                lfTincanLrsActivityProfile.setNew(false);
            } else {
                session.merge(lfTincanLrsActivityProfile);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew ||
                !LFTincanLrsActivityProfileModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class,
            lfTincanLrsActivityProfile.getPrimaryKey(),
            lfTincanLrsActivityProfile);

        clearUniqueFindersCache(lfTincanLrsActivityProfile);
        cacheUniqueFindersCache(lfTincanLrsActivityProfile);

        return lfTincanLrsActivityProfile;
    }

    protected LFTincanLrsActivityProfile toUnwrappedModel(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        if (lfTincanLrsActivityProfile instanceof LFTincanLrsActivityProfileImpl) {
            return lfTincanLrsActivityProfile;
        }

        LFTincanLrsActivityProfileImpl lfTincanLrsActivityProfileImpl = new LFTincanLrsActivityProfileImpl();

        lfTincanLrsActivityProfileImpl.setNew(lfTincanLrsActivityProfile.isNew());
        lfTincanLrsActivityProfileImpl.setPrimaryKey(lfTincanLrsActivityProfile.getPrimaryKey());

        lfTincanLrsActivityProfileImpl.setId(lfTincanLrsActivityProfile.getId());
        lfTincanLrsActivityProfileImpl.setDocumentId(lfTincanLrsActivityProfile.getDocumentId());
        lfTincanLrsActivityProfileImpl.setActivityId(lfTincanLrsActivityProfile.getActivityId());
        lfTincanLrsActivityProfileImpl.setProfileId(lfTincanLrsActivityProfile.getProfileId());

        return lfTincanLrsActivityProfileImpl;
    }

    /**
     * Returns the l f tincan lrs activity profile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile = fetchByPrimaryKey(primaryKey);

        if (lfTincanLrsActivityProfile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanLrsActivityProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanLrsActivityProfile;
    }

    /**
     * Returns the l f tincan lrs activity profile with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan lrs activity profile with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile, or <code>null</code> if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile = (LFTincanLrsActivityProfile) EntityCacheUtil.getResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsActivityProfileImpl.class, primaryKey);

        if (lfTincanLrsActivityProfile == _nullLFTincanLrsActivityProfile) {
            return null;
        }

        if (lfTincanLrsActivityProfile == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanLrsActivityProfile = (LFTincanLrsActivityProfile) session.get(LFTincanLrsActivityProfileImpl.class,
                        primaryKey);

                if (lfTincanLrsActivityProfile != null) {
                    cacheResult(lfTincanLrsActivityProfile);
                } else {
                    EntityCacheUtil.putResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsActivityProfileImpl.class, primaryKey,
                        _nullLFTincanLrsActivityProfile);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanLrsActivityProfileImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanLrsActivityProfile;
    }

    /**
     * Returns the l f tincan lrs activity profile with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile, or <code>null</code> if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan lrs activity profiles.
     *
     * @return the l f tincan lrs activity profiles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsActivityProfile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs activity profiles.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsActivityProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs activity profiles
     * @param end the upper bound of the range of l f tincan lrs activity profiles (not inclusive)
     * @return the range of l f tincan lrs activity profiles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsActivityProfile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs activity profiles.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsActivityProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs activity profiles
     * @param end the upper bound of the range of l f tincan lrs activity profiles (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs activity profiles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsActivityProfile> findAll(int start, int end,
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

        List<LFTincanLrsActivityProfile> list = (List<LFTincanLrsActivityProfile>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSACTIVITYPROFILE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSACTIVITYPROFILE;

                if (pagination) {
                    sql = sql.concat(LFTincanLrsActivityProfileModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanLrsActivityProfile>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanLrsActivityProfile>(list);
                } else {
                    list = (List<LFTincanLrsActivityProfile>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs activity profiles from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanLrsActivityProfile lfTincanLrsActivityProfile : findAll()) {
            remove(lfTincanLrsActivityProfile);
        }
    }

    /**
     * Returns the number of l f tincan lrs activity profiles.
     *
     * @return the number of l f tincan lrs activity profiles
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSACTIVITYPROFILE);

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
     * Initializes the l f tincan lrs activity profile persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsActivityProfile>> listenersList = new ArrayList<ModelListener<LFTincanLrsActivityProfile>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsActivityProfile>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsActivityProfileImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
