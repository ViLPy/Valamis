package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException;
import com.arcusys.learn.persistence.liferay.model.LFSettings;
import com.arcusys.learn.persistence.liferay.model.impl.LFSettingsImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFSettingsModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityDataMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateNodePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateTreePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAnswerPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptDataPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFBigDecimalPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateSitePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFChildrenSelectionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFConditionRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCoursePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFFileStoragePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFGlobalObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectivePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageCommentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageScopeRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageVotePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPlayerScopeRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuestionCategoryPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuestionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestionCategoryPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFResourcePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRolePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupContributionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRuleConditionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPermissionsPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingTrackingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSettingsPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackageTagPersistence;
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
 * The persistence implementation for the l f settings service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSettingsPersistence
 * @see LFSettingsUtil
 * @generated
 */
public class LFSettingsPersistenceImpl extends BasePersistenceImpl<LFSettings>
    implements LFSettingsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFSettingsUtil} to access the l f settings persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFSettingsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_KEY = new FinderPath(LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
            LFSettingsModelImpl.FINDER_CACHE_ENABLED, LFSettingsImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByKey",
            new String[] { String.class.getName() },
            LFSettingsModelImpl.KEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_KEY = new FinderPath(LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
            LFSettingsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
            LFSettingsModelImpl.FINDER_CACHE_ENABLED, LFSettingsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
            LFSettingsModelImpl.FINDER_CACHE_ENABLED, LFSettingsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
            LFSettingsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFSETTINGS = "SELECT lfSettings FROM LFSettings lfSettings";
    private static final String _SQL_SELECT_LFSETTINGS_WHERE = "SELECT lfSettings FROM LFSettings lfSettings WHERE ";
    private static final String _SQL_COUNT_LFSETTINGS = "SELECT COUNT(lfSettings) FROM LFSettings lfSettings";
    private static final String _SQL_COUNT_LFSETTINGS_WHERE = "SELECT COUNT(lfSettings) FROM LFSettings lfSettings WHERE ";
    private static final String _FINDER_COLUMN_KEY_KEY_1 = "lfSettings.key IS NULL";
    private static final String _FINDER_COLUMN_KEY_KEY_NULL = "lfSettings.key IS NULL";
    private static final String _FINDER_COLUMN_KEY_KEY_NULL_2 = "lfSettings.key IS NULL ";
    private static final String _FINDER_COLUMN_KEY_KEY_2 = "lfSettings.key = ?";
    private static final String _FINDER_COLUMN_KEY_KEY_3 = "(lfSettings.key IS NULL OR lfSettings.key = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfSettings.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFSettings exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFSettings exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFSettingsPersistenceImpl.class);
    private static LFSettings _nullLFSettings = new LFSettingsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFSettings> toCacheModel() {
                return _nullLFSettingsCacheModel;
            }
        };

    private static CacheModel<LFSettings> _nullLFSettingsCacheModel = new CacheModel<LFSettings>() {
            public LFSettings toEntityModel() {
                return _nullLFSettings;
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
    @BeanReference(type = LFCertificatePersistence.class)
    protected LFCertificatePersistence lfCertificatePersistence;
    @BeanReference(type = LFCertificateSitePersistence.class)
    protected LFCertificateSitePersistence lfCertificateSitePersistence;
    @BeanReference(type = LFCertificateUserPersistence.class)
    protected LFCertificateUserPersistence lfCertificateUserPersistence;
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
    @BeanReference(type = LFPackageCommentPersistence.class)
    protected LFPackageCommentPersistence lfPackageCommentPersistence;
    @BeanReference(type = LFPackageScopeRulePersistence.class)
    protected LFPackageScopeRulePersistence lfPackageScopeRulePersistence;
    @BeanReference(type = LFPackageVotePersistence.class)
    protected LFPackageVotePersistence lfPackageVotePersistence;
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
    @BeanReference(type = LFRolePersistence.class)
    protected LFRolePersistence lfRolePersistence;
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
    @BeanReference(type = LFSettingsPersistence.class)
    protected LFSettingsPersistence lfSettingsPersistence;
    @BeanReference(type = LFSocialPackagePersistence.class)
    protected LFSocialPackagePersistence lfSocialPackagePersistence;
    @BeanReference(type = LFSocialPackageTagPersistence.class)
    protected LFSocialPackageTagPersistence lfSocialPackageTagPersistence;
    @BeanReference(type = LFUserPersistence.class)
    protected LFUserPersistence lfUserPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the l f settings in the entity cache if it is enabled.
     *
     * @param lfSettings the l f settings
     */
    public void cacheResult(LFSettings lfSettings) {
        EntityCacheUtil.putResult(LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
            LFSettingsImpl.class, lfSettings.getPrimaryKey(), lfSettings);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
            new Object[] { lfSettings.getKey() }, lfSettings);

        lfSettings.resetOriginalValues();
    }

    /**
     * Caches the l f settingses in the entity cache if it is enabled.
     *
     * @param lfSettingses the l f settingses
     */
    public void cacheResult(List<LFSettings> lfSettingses) {
        for (LFSettings lfSettings : lfSettingses) {
            if (EntityCacheUtil.getResult(
                        LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
                        LFSettingsImpl.class, lfSettings.getPrimaryKey()) == null) {
                cacheResult(lfSettings);
            } else {
                lfSettings.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f settingses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFSettingsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFSettingsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f settings.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFSettings lfSettings) {
        EntityCacheUtil.removeResult(LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
            LFSettingsImpl.class, lfSettings.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfSettings);
    }

    @Override
    public void clearCache(List<LFSettings> lfSettingses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFSettings lfSettings : lfSettingses) {
            EntityCacheUtil.removeResult(LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
                LFSettingsImpl.class, lfSettings.getPrimaryKey());

            clearUniqueFindersCache(lfSettings);
        }
    }

    protected void clearUniqueFindersCache(LFSettings lfSettings) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY,
            new Object[] { lfSettings.getKey() });
    }

    /**
     * Creates a new l f settings with the primary key. Does not add the l f settings to the database.
     *
     * @param id the primary key for the new l f settings
     * @return the new l f settings
     */
    public LFSettings create(long id) {
        LFSettings lfSettings = new LFSettingsImpl();

        lfSettings.setNew(true);
        lfSettings.setPrimaryKey(id);

        return lfSettings;
    }

    /**
     * Removes the l f settings with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f settings
     * @return the l f settings that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException if a l f settings with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSettings remove(long id)
        throws NoSuchLFSettingsException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f settings with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f settings
     * @return the l f settings that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException if a l f settings with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSettings remove(Serializable primaryKey)
        throws NoSuchLFSettingsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFSettings lfSettings = (LFSettings) session.get(LFSettingsImpl.class,
                    primaryKey);

            if (lfSettings == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFSettingsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfSettings);
        } catch (NoSuchLFSettingsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFSettings removeImpl(LFSettings lfSettings)
        throws SystemException {
        lfSettings = toUnwrappedModel(lfSettings);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfSettings);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfSettings);

        return lfSettings;
    }

    @Override
    public LFSettings updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings,
        boolean merge) throws SystemException {
        lfSettings = toUnwrappedModel(lfSettings);

        boolean isNew = lfSettings.isNew();

        LFSettingsModelImpl lfSettingsModelImpl = (LFSettingsModelImpl) lfSettings;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfSettings, merge);

            lfSettings.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFSettingsModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
            LFSettingsImpl.class, lfSettings.getPrimaryKey(), lfSettings);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
                new Object[] { lfSettings.getKey() }, lfSettings);
        } else {
            if ((lfSettingsModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfSettingsModelImpl.getOriginalKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
                    new Object[] { lfSettings.getKey() }, lfSettings);
            }
        }

        return lfSettings;
    }

    protected LFSettings toUnwrappedModel(LFSettings lfSettings) {
        if (lfSettings instanceof LFSettingsImpl) {
            return lfSettings;
        }

        LFSettingsImpl lfSettingsImpl = new LFSettingsImpl();

        lfSettingsImpl.setNew(lfSettings.isNew());
        lfSettingsImpl.setPrimaryKey(lfSettings.getPrimaryKey());

        lfSettingsImpl.setId(lfSettings.getId());
        lfSettingsImpl.setKey(lfSettings.getKey());
        lfSettingsImpl.setValue(lfSettings.getValue());

        return lfSettingsImpl;
    }

    /**
     * Returns the l f settings with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f settings
     * @return the l f settings
     * @throws com.liferay.portal.NoSuchModelException if a l f settings with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSettings findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f settings with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException} if it could not be found.
     *
     * @param id the primary key of the l f settings
     * @return the l f settings
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException if a l f settings with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSettings findByPrimaryKey(long id)
        throws NoSuchLFSettingsException, SystemException {
        LFSettings lfSettings = fetchByPrimaryKey(id);

        if (lfSettings == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFSettingsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfSettings;
    }

    /**
     * Returns the l f settings with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f settings
     * @return the l f settings, or <code>null</code> if a l f settings with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSettings fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f settings with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f settings
     * @return the l f settings, or <code>null</code> if a l f settings with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSettings fetchByPrimaryKey(long id) throws SystemException {
        LFSettings lfSettings = (LFSettings) EntityCacheUtil.getResult(LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
                LFSettingsImpl.class, id);

        if (lfSettings == _nullLFSettings) {
            return null;
        }

        if (lfSettings == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfSettings = (LFSettings) session.get(LFSettingsImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfSettings != null) {
                    cacheResult(lfSettings);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFSettingsModelImpl.ENTITY_CACHE_ENABLED,
                        LFSettingsImpl.class, id, _nullLFSettings);
                }

                closeSession(session);
            }
        }

        return lfSettings;
    }

    /**
     * Returns the l f settings where key = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException} if it could not be found.
     *
     * @param key the key
     * @return the matching l f settings
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException if a matching l f settings could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSettings findByKey(String key)
        throws NoSuchLFSettingsException, SystemException {
        LFSettings lfSettings = fetchByKey(key);

        if (lfSettings == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("key=");
            msg.append(key);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFSettingsException(msg.toString());
        }

        return lfSettings;
    }

    /**
     * Returns the l f settings where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param key the key
     * @return the matching l f settings, or <code>null</code> if a matching l f settings could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSettings fetchByKey(String key) throws SystemException {
        return fetchByKey(key, true);
    }

    /**
     * Returns the l f settings where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param key the key
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f settings, or <code>null</code> if a matching l f settings could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSettings fetchByKey(String key, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { key };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KEY,
                    finderArgs, this);
        }

        if (result instanceof LFSettings) {
            LFSettings lfSettings = (LFSettings) result;

            if (!Validator.equals(key, lfSettings.getKey())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_LFSETTINGS_WHERE);

            if (key == null) {
                query.append(_FINDER_COLUMN_KEY_KEY_1);
            } else {
                if (key.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_KEY_KEY_3);
                } else {
                    query.append(_FINDER_COLUMN_KEY_KEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (key != null) {
                    qPos.add(key);
                }

                List<LFSettings> list = q.list();

                result = list;

                LFSettings lfSettings = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
                        finderArgs, list);
                } else {
                    lfSettings = list.get(0);

                    cacheResult(lfSettings);

                    if ((lfSettings.getKey() == null) ||
                            !lfSettings.getKey().equals(key)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
                            finderArgs, lfSettings);
                    }
                }

                return lfSettings;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFSettings) result;
            }
        }
    }

    /**
     * Returns all the l f settingses.
     *
     * @return the l f settingses
     * @throws SystemException if a system exception occurred
     */
    public List<LFSettings> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f settingses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f settingses
     * @param end the upper bound of the range of l f settingses (not inclusive)
     * @return the range of l f settingses
     * @throws SystemException if a system exception occurred
     */
    public List<LFSettings> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f settingses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f settingses
     * @param end the upper bound of the range of l f settingses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f settingses
     * @throws SystemException if a system exception occurred
     */
    public List<LFSettings> findAll(int start, int end,
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

        List<LFSettings> list = (List<LFSettings>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFSETTINGS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFSETTINGS;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFSettings>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFSettings>) QueryUtil.list(q, getDialect(),
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
     * Removes the l f settings where key = &#63; from the database.
     *
     * @param key the key
     * @return the l f settings that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFSettings removeByKey(String key)
        throws NoSuchLFSettingsException, SystemException {
        LFSettings lfSettings = findByKey(key);

        return remove(lfSettings);
    }

    /**
     * Removes all the l f settingses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFSettings lfSettings : findAll()) {
            remove(lfSettings);
        }
    }

    /**
     * Returns the number of l f settingses where key = &#63;.
     *
     * @param key the key
     * @return the number of matching l f settingses
     * @throws SystemException if a system exception occurred
     */
    public int countByKey(String key) throws SystemException {
        Object[] finderArgs = new Object[] { key };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_KEY,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFSETTINGS_WHERE);

            if (key == null) {
                query.append(_FINDER_COLUMN_KEY_KEY_1);
            } else {
                if (key.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_KEY_KEY_3);
                } else {
                    query.append(_FINDER_COLUMN_KEY_KEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (key != null) {
                    qPos.add(key);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f settingses.
     *
     * @return the number of l f settingses
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFSETTINGS);

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
     * Initializes the l f settings persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFSettings")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFSettings>> listenersList = new ArrayList<ModelListener<LFSettings>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFSettings>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFSettingsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
