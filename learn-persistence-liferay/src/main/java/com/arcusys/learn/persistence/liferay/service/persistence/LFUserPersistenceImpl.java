package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFUserException;
import com.arcusys.learn.persistence.liferay.model.LFUser;
import com.arcusys.learn.persistence.liferay.model.impl.LFUserImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFUserModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityDataMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateNodePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateTreePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAnswerPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptDataPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFBigDecimalPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFChildrenSelectionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFConditionRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCoursePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFFileStoragePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFGlobalObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectivePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageScopeRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPlayerScopeRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuestionCategoryPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuestionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestionCategoryPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFResourcePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupContributionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRuleConditionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPermissionsPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingTrackingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFUserPersistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l f user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFUserPersistence
 * @see LFUserUtil
 * @generated
 */
public class LFUserPersistenceImpl extends BasePersistenceImpl<LFUser>
    implements LFUserPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFUserUtil} to access the l f user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFUserImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, LFUserImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
            new String[] { Integer.class.getName() },
            LFUserModelImpl.ID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCOLLECTION =
        new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, LFUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdCollection",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCOLLECTION =
        new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, LFUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByUserIdCollection", new String[] { Integer.class.getName() },
            LFUserModelImpl.ID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERIDCOLLECTION = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByUserIdCollection", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDCOLLECTION =
        new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByUserIdCollection",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, LFUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, LFUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFUSER = "SELECT lfUser FROM LFUser lfUser";
    private static final String _SQL_SELECT_LFUSER_WHERE = "SELECT lfUser FROM LFUser lfUser WHERE ";
    private static final String _SQL_COUNT_LFUSER = "SELECT COUNT(lfUser) FROM LFUser lfUser";
    private static final String _SQL_COUNT_LFUSER_WHERE = "SELECT COUNT(lfUser) FROM LFUser lfUser WHERE ";
    private static final String _FINDER_COLUMN_USERID_ID_NULL = "lfUser.id IS NULL";
    private static final String _FINDER_COLUMN_USERID_ID_NULL_2 = "lfUser.id IS NULL ";
    private static final String _FINDER_COLUMN_USERID_ID_2 = "lfUser.id = ?";
    private static final String _FINDER_COLUMN_USERIDCOLLECTION_ID_NULL = "lfUser.id IS NULL";
    private static final String _FINDER_COLUMN_USERIDCOLLECTION_ID_NULL_2 = "lfUser.id IS NULL ";
    private static final String _FINDER_COLUMN_USERIDCOLLECTION_ID_2 = "lfUser.id = ?";
    private static final String _FINDER_COLUMN_USERIDCOLLECTION_ID_5_NULL = "(" +
        _removeConjunction(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL_2) + ")";
    private static final String _FINDER_COLUMN_USERIDCOLLECTION_ID_5 = "(" +
        _removeConjunction(_FINDER_COLUMN_USERIDCOLLECTION_ID_2) + ")";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfUser.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFUser exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFUser exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFUserPersistenceImpl.class);
    private static LFUser _nullLFUser = new LFUserImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFUser> toCacheModel() {
                return _nullLFUserCacheModel;
            }
        };

    private static CacheModel<LFUser> _nullLFUserCacheModel = new CacheModel<LFUser>() {
            public LFUser toEntityModel() {
                return _nullLFUser;
            }
        };

    @BeanReference(type = LFActivityPersistence.class)
    protected LFActivityPersistence lfActivityPersistence;
    @BeanReference(type = LFActivityDataMapPersistence.class)
    protected LFActivityDataMapPersistence lfActivityDataMapPersistence;
    @BeanReference(type = LFActivityStatePersistence.class)
    protected LFActivityStatePersistence lfActivityStatePersistence;
    @BeanReference(type = LFActivityStateNodePersistence.class)
    protected LFActivityStateNodePersistence lfActivityStateNodePersistence;
    @BeanReference(type = LFActivityStateTreePersistence.class)
    protected LFActivityStateTreePersistence lfActivityStateTreePersistence;
    @BeanReference(type = LFAnswerPersistence.class)
    protected LFAnswerPersistence lfAnswerPersistence;
    @BeanReference(type = LFAttemptPersistence.class)
    protected LFAttemptPersistence lfAttemptPersistence;
    @BeanReference(type = LFAttemptDataPersistence.class)
    protected LFAttemptDataPersistence lfAttemptDataPersistence;
    @BeanReference(type = LFBigDecimalPersistence.class)
    protected LFBigDecimalPersistence lfBigDecimalPersistence;
    @BeanReference(type = LFChildrenSelectionPersistence.class)
    protected LFChildrenSelectionPersistence lfChildrenSelectionPersistence;
    @BeanReference(type = LFConditionRulePersistence.class)
    protected LFConditionRulePersistence lfConditionRulePersistence;
    @BeanReference(type = LFCoursePersistence.class)
    protected LFCoursePersistence lfCoursePersistence;
    @BeanReference(type = LFFileStoragePersistence.class)
    protected LFFileStoragePersistence lfFileStoragePersistence;
    @BeanReference(type = LFGlobalObjectiveStatePersistence.class)
    protected LFGlobalObjectiveStatePersistence lfGlobalObjectiveStatePersistence;
    @BeanReference(type = LFObjectivePersistence.class)
    protected LFObjectivePersistence lfObjectivePersistence;
    @BeanReference(type = LFObjectiveMapPersistence.class)
    protected LFObjectiveMapPersistence lfObjectiveMapPersistence;
    @BeanReference(type = LFObjectiveStatePersistence.class)
    protected LFObjectiveStatePersistence lfObjectiveStatePersistence;
    @BeanReference(type = LFPackagePersistence.class)
    protected LFPackagePersistence lfPackagePersistence;
    @BeanReference(type = LFPackageScopeRulePersistence.class)
    protected LFPackageScopeRulePersistence lfPackageScopeRulePersistence;
    @BeanReference(type = LFPlayerScopeRulePersistence.class)
    protected LFPlayerScopeRulePersistence lfPlayerScopeRulePersistence;
    @BeanReference(type = LFQuestionPersistence.class)
    protected LFQuestionPersistence lfQuestionPersistence;
    @BeanReference(type = LFQuestionCategoryPersistence.class)
    protected LFQuestionCategoryPersistence lfQuestionCategoryPersistence;
    @BeanReference(type = LFQuizPersistence.class)
    protected LFQuizPersistence lfQuizPersistence;
    @BeanReference(type = LFQuizQuestionPersistence.class)
    protected LFQuizQuestionPersistence lfQuizQuestionPersistence;
    @BeanReference(type = LFQuizQuestionCategoryPersistence.class)
    protected LFQuizQuestionCategoryPersistence lfQuizQuestionCategoryPersistence;
    @BeanReference(type = LFResourcePersistence.class)
    protected LFResourcePersistence lfResourcePersistence;
    @BeanReference(type = LFRollupContributionPersistence.class)
    protected LFRollupContributionPersistence lfRollupContributionPersistence;
    @BeanReference(type = LFRollupRulePersistence.class)
    protected LFRollupRulePersistence lfRollupRulePersistence;
    @BeanReference(type = LFRuleConditionPersistence.class)
    protected LFRuleConditionPersistence lfRuleConditionPersistence;
    @BeanReference(type = LFSequencingPersistence.class)
    protected LFSequencingPersistence lfSequencingPersistence;
    @BeanReference(type = LFSequencingPermissionsPersistence.class)
    protected LFSequencingPermissionsPersistence lfSequencingPermissionsPersistence;
    @BeanReference(type = LFSequencingTrackingPersistence.class)
    protected LFSequencingTrackingPersistence lfSequencingTrackingPersistence;
    @BeanReference(type = LFUserPersistence.class)
    protected LFUserPersistence lfUserPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the l f user in the entity cache if it is enabled.
     *
     * @param lfUser the l f user
     */
    public void cacheResult(LFUser lfUser) {
        EntityCacheUtil.putResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserImpl.class, lfUser.getPrimaryKey(), lfUser);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
            new Object[] { Integer.valueOf(lfUser.getId()) }, lfUser);

        lfUser.resetOriginalValues();
    }

    /**
     * Caches the l f users in the entity cache if it is enabled.
     *
     * @param lfUsers the l f users
     */
    public void cacheResult(List<LFUser> lfUsers) {
        for (LFUser lfUser : lfUsers) {
            if (EntityCacheUtil.getResult(
                        LFUserModelImpl.ENTITY_CACHE_ENABLED, LFUserImpl.class,
                        lfUser.getPrimaryKey()) == null) {
                cacheResult(lfUser);
            } else {
                lfUser.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFUserImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFUserImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f user.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFUser lfUser) {
        EntityCacheUtil.removeResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserImpl.class, lfUser.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfUser);
    }

    @Override
    public void clearCache(List<LFUser> lfUsers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFUser lfUser : lfUsers) {
            EntityCacheUtil.removeResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
                LFUserImpl.class, lfUser.getPrimaryKey());

            clearUniqueFindersCache(lfUser);
        }
    }

    protected void clearUniqueFindersCache(LFUser lfUser) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
            new Object[] { Integer.valueOf(lfUser.getId()) });
    }

    /**
     * Creates a new l f user with the primary key. Does not add the l f user to the database.
     *
     * @param lfid the primary key for the new l f user
     * @return the new l f user
     */
    public LFUser create(long lfid) {
        LFUser lfUser = new LFUserImpl();

        lfUser.setNew(true);
        lfUser.setPrimaryKey(lfid);

        return lfUser;
    }

    /**
     * Removes the l f user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfid the primary key of the l f user
     * @return the l f user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFUser remove(long lfid)
        throws NoSuchLFUserException, SystemException {
        return remove(Long.valueOf(lfid));
    }

    /**
     * Removes the l f user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f user
     * @return the l f user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser remove(Serializable primaryKey)
        throws NoSuchLFUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFUser lfUser = (LFUser) session.get(LFUserImpl.class, primaryKey);

            if (lfUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfUser);
        } catch (NoSuchLFUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFUser removeImpl(LFUser lfUser) throws SystemException {
        lfUser = toUnwrappedModel(lfUser);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfUser);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfUser);

        return lfUser;
    }

    @Override
    public LFUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFUser lfUser, boolean merge)
        throws SystemException {
        lfUser = toUnwrappedModel(lfUser);

        boolean isNew = lfUser.isNew();

        LFUserModelImpl lfUserModelImpl = (LFUserModelImpl) lfUser;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfUser, merge);

            lfUser.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFUserModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCOLLECTION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { /* Integer.valueOf(   */
                        lfUserModelImpl.getOriginalId()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCOLLECTION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCOLLECTION,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfUserModelImpl.getId()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCOLLECTION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCOLLECTION,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserImpl.class, lfUser.getPrimaryKey(), lfUser);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
                new Object[] { /*Integer.valueOf( */
                lfUser.getId()/*) */
                }, lfUser);
        } else {
            if ((lfUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { /*        Integer.valueOf( */
                        lfUserModelImpl.getOriginalId()/*        ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
                    new Object[] { /*        Integer.valueOf( */
                    lfUser.getId()/*        ) */
                    }, lfUser);
            }
        }

        return lfUser;
    }

    protected LFUser toUnwrappedModel(LFUser lfUser) {
        if (lfUser instanceof LFUserImpl) {
            return lfUser;
        }

        LFUserImpl lfUserImpl = new LFUserImpl();

        lfUserImpl.setNew(lfUser.isNew());
        lfUserImpl.setPrimaryKey(lfUser.getPrimaryKey());

        lfUserImpl.setLfid(lfUser.getLfid());
        lfUserImpl.setId(lfUser.getId());
        lfUserImpl.setName(lfUser.getName());
        lfUserImpl.setPreferredAudioLevel(lfUser.getPreferredAudioLevel());
        lfUserImpl.setPreferredLanguage(lfUser.getPreferredLanguage());
        lfUserImpl.setPreferredDeliverySpeed(lfUser.getPreferredDeliverySpeed());
        lfUserImpl.setPreferredAudioCaptioning(lfUser.getPreferredAudioCaptioning());

        return lfUserImpl;
    }

    /**
     * Returns the l f user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f user
     * @return the l f user
     * @throws com.liferay.portal.NoSuchModelException if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFUserException} if it could not be found.
     *
     * @param lfid the primary key of the l f user
     * @return the l f user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFUser findByPrimaryKey(long lfid)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = fetchByPrimaryKey(lfid);

        if (lfUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + lfid);
            }

            throw new NoSuchLFUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                lfid);
        }

        return lfUser;
    }

    /**
     * Returns the l f user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f user
     * @return the l f user, or <code>null</code> if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param lfid the primary key of the l f user
     * @return the l f user, or <code>null</code> if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFUser fetchByPrimaryKey(long lfid) throws SystemException {
        LFUser lfUser = (LFUser) EntityCacheUtil.getResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
                LFUserImpl.class, lfid);

        if (lfUser == _nullLFUser) {
            return null;
        }

        if (lfUser == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfUser = (LFUser) session.get(LFUserImpl.class,
                        Long.valueOf(lfid));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfUser != null) {
                    cacheResult(lfUser);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
                        LFUserImpl.class, lfid, _nullLFUser);
                }

                closeSession(session);
            }
        }

        return lfUser;
    }

    /**
     * Returns the l f user where id = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFUserException} if it could not be found.
     *
     * @param id the ID
     * @return the matching l f user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFUser findByUserId(Integer id)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = fetchByUserId(id);

        if (lfUser == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("id=");
            msg.append(id);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFUserException(msg.toString());
        }

        return lfUser;
    }

    /**
     * Returns the l f user where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param id the ID
     * @return the matching l f user, or <code>null</code> if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFUser fetchByUserId(Integer id) throws SystemException {
        return fetchByUserId(id, true);
    }

    /**
     * Returns the l f user where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param id the ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f user, or <code>null</code> if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFUser fetchByUserId(Integer id, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { id };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
                    finderArgs, this);
        }

        if (result instanceof LFUser) {
            LFUser lfUser = (LFUser) result;

            if (!Validator.equals(id, lfUser.getId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_LFUSER_WHERE);

            if (id == null) {
                query.append(_FINDER_COLUMN_USERID_ID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERID_ID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (id != null) {
                    qPos.add(id.intValue());
                }

                List<LFUser> list = q.list();

                result = list;

                LFUser lfUser = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
                        finderArgs, list);
                } else {
                    lfUser = list.get(0);

                    cacheResult(lfUser);

                    if ((lfUser.getId() != id)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
                            finderArgs, lfUser);
                    }
                }

                return lfUser;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFUser) result;
            }
        }
    }

    /**
     * Returns all the l f users where id = &#63;.
     *
     * @param id the ID
     * @return the matching l f users
     * @throws SystemException if a system exception occurred
     */
    public List<LFUser> findByUserIdCollection(Integer id)
        throws SystemException {
        return findByUserIdCollection(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f users where id = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the ID
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @return the range of matching l f users
     * @throws SystemException if a system exception occurred
     */
    public List<LFUser> findByUserIdCollection(Integer id, int start, int end)
        throws SystemException {
        return findByUserIdCollection(id, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f users where id = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the ID
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f users
     * @throws SystemException if a system exception occurred
     */
    public List<LFUser> findByUserIdCollection(Integer id, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCOLLECTION;
            finderArgs = new Object[] { id };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCOLLECTION;
            finderArgs = new Object[] { id, start, end, orderByComparator };
        }

        List<LFUser> list = (List<LFUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFUser lfUser : list) {
                if (!Validator.equals(id, lfUser.getId())) {
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
                query = new StringBundler(2);
            }

            query.append(_SQL_SELECT_LFUSER_WHERE);

            if (id == null) {
                query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (id != null) {
                    qPos.add(id.intValue());
                }

                list = (List<LFUser>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first l f user in the ordered set where id = &#63;.
     *
     * @param id the ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFUser findByUserIdCollection_First(Integer id,
        OrderByComparator orderByComparator)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = fetchByUserIdCollection_First(id, orderByComparator);

        if (lfUser != null) {
            return lfUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("id=");
        msg.append(id);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFUserException(msg.toString());
    }

    /**
     * Returns the first l f user in the ordered set where id = &#63;.
     *
     * @param id the ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f user, or <code>null</code> if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFUser fetchByUserIdCollection_First(Integer id,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFUser> list = findByUserIdCollection(id, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f user in the ordered set where id = &#63;.
     *
     * @param id the ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFUser findByUserIdCollection_Last(Integer id,
        OrderByComparator orderByComparator)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = fetchByUserIdCollection_Last(id, orderByComparator);

        if (lfUser != null) {
            return lfUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("id=");
        msg.append(id);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFUserException(msg.toString());
    }

    /**
     * Returns the last l f user in the ordered set where id = &#63;.
     *
     * @param id the ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f user, or <code>null</code> if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFUser fetchByUserIdCollection_Last(Integer id,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserIdCollection(id);

        List<LFUser> list = findByUserIdCollection(id, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f users before and after the current l f user in the ordered set where id = &#63;.
     *
     * @param lfid the primary key of the current l f user
     * @param id the ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFUser[] findByUserIdCollection_PrevAndNext(long lfid, Integer id,
        OrderByComparator orderByComparator)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = findByPrimaryKey(lfid);

        Session session = null;

        try {
            session = openSession();

            LFUser[] array = new LFUserImpl[3];

            array[0] = getByUserIdCollection_PrevAndNext(session, lfUser, id,
                    orderByComparator, true);

            array[1] = lfUser;

            array[2] = getByUserIdCollection_PrevAndNext(session, lfUser, id,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFUser getByUserIdCollection_PrevAndNext(Session session,
        LFUser lfUser, Integer id, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFUSER_WHERE);

        if (id == null) {
            query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_2);
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
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (id != null) {
            qPos.add(id.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f users where id = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param ids the IDs
     * @return the matching l f users
     * @throws SystemException if a system exception occurred
     */
    public List<LFUser> findByUserIdCollection(Integer[] ids)
        throws SystemException {
        return findByUserIdCollection(ids, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f users where id = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param ids the IDs
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @return the range of matching l f users
     * @throws SystemException if a system exception occurred
     */
    public List<LFUser> findByUserIdCollection(Integer[] ids, int start, int end)
        throws SystemException {
        return findByUserIdCollection(ids, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f users where id = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param ids the IDs
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f users
     * @throws SystemException if a system exception occurred
     */
    public List<LFUser> findByUserIdCollection(Integer[] ids, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCOLLECTION;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderArgs = new Object[] { StringUtil.merge(ids) };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(ids),
                    
                    start, end, orderByComparator
                };
        }

        List<LFUser> list = (List<LFUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFUser lfUser : list) {
                if (!ArrayUtil.contains(ids, lfUser.getId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFUSER_WHERE);

            boolean conjunctionable = false;

            if ((ids != null) && (ids.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] == null) {
                        query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_5);
                    }

                    if ((i + 1) < ids.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (ids != null) {
                    for (Integer id : ids) {
                        if (id != null) {
                            qPos.add(id);
                        }
                    }
                }

                list = (List<LFUser>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns all the l f users.
     *
     * @return the l f users
     * @throws SystemException if a system exception occurred
     */
    public List<LFUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @return the range of l f users
     * @throws SystemException if a system exception occurred
     */
    public List<LFUser> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f users
     * @throws SystemException if a system exception occurred
     */
    public List<LFUser> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<LFUser> list = (List<LFUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFUSER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFUSER;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFUser>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFUser>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes the l f user where id = &#63; from the database.
     *
     * @param id the ID
     * @return the l f user that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFUser removeByUserId(Integer id)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = findByUserId(id);

        return remove(lfUser);
    }

    /**
     * Removes all the l f users where id = &#63; from the database.
     *
     * @param id the ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByUserIdCollection(Integer id) throws SystemException {
        for (LFUser lfUser : findByUserIdCollection(id)) {
            remove(lfUser);
        }
    }

    /**
     * Removes all the l f users from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFUser lfUser : findAll()) {
            remove(lfUser);
        }
    }

    /**
     * Returns the number of l f users where id = &#63;.
     *
     * @param id the ID
     * @return the number of matching l f users
     * @throws SystemException if a system exception occurred
     */
    public int countByUserId(Integer id) throws SystemException {
        Object[] finderArgs = new Object[] { id };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFUSER_WHERE);

            if (id == null) {
                query.append(_FINDER_COLUMN_USERID_ID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERID_ID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (id != null) {
                    qPos.add(id.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f users where id = &#63;.
     *
     * @param id the ID
     * @return the number of matching l f users
     * @throws SystemException if a system exception occurred
     */
    public int countByUserIdCollection(Integer id) throws SystemException {
        Object[] finderArgs = new Object[] { id };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERIDCOLLECTION,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFUSER_WHERE);

            if (id == null) {
                query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (id != null) {
                    qPos.add(id.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDCOLLECTION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f users where id = any &#63;.
     *
     * @param ids the IDs
     * @return the number of matching l f users
     * @throws SystemException if a system exception occurred
     */
    public int countByUserIdCollection(Integer[] ids) throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(ids) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDCOLLECTION,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFUSER_WHERE);

            boolean conjunctionable = false;

            if ((ids != null) && (ids.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] == null) {
                        query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_5);
                    }

                    if ((i + 1) < ids.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (ids != null) {
                    for (Integer id : ids) {
                        if (id != null) {
                            qPos.add(id);
                        }
                    }
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDCOLLECTION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f users.
     *
     * @return the number of l f users
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFUSER);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the l f user persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFUser")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFUser>> listenersList = new ArrayList<ModelListener<LFUser>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFUser>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFUserImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    private static String _removeConjunction(String sql) {
        int pos = sql.indexOf(" AND ");

        if (pos != -1) {
            sql = sql.substring(0, pos);
        }

        return sql;
    }
}
