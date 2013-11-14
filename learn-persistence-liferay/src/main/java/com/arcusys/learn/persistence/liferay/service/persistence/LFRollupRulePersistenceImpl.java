package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException;
import com.arcusys.learn.persistence.liferay.model.LFRollupRule;
import com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleModelImpl;
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
import com.arcusys.learn.persistence.liferay.service.persistence.LFConfigPersistence;
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
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackageTagPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsEndpointPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanPackagePersistence;
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
 * The persistence implementation for the l f rollup rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRollupRulePersistence
 * @see LFRollupRuleUtil
 * @generated
 */
public class LFRollupRulePersistenceImpl extends BasePersistenceImpl<LFRollupRule>
    implements LFRollupRulePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFRollupRuleUtil} to access the l f rollup rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFRollupRuleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGID =
        new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, LFRollupRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySequencingID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID =
        new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, LFRollupRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySequencingID",
            new String[] { Integer.class.getName() },
            LFRollupRuleModelImpl.SEQUENCINGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGID = new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySequencingID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, LFRollupRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, LFRollupRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFROLLUPRULE = "SELECT lfRollupRule FROM LFRollupRule lfRollupRule";
    private static final String _SQL_SELECT_LFROLLUPRULE_WHERE = "SELECT lfRollupRule FROM LFRollupRule lfRollupRule WHERE ";
    private static final String _SQL_COUNT_LFROLLUPRULE = "SELECT COUNT(lfRollupRule) FROM LFRollupRule lfRollupRule";
    private static final String _SQL_COUNT_LFROLLUPRULE_WHERE = "SELECT COUNT(lfRollupRule) FROM LFRollupRule lfRollupRule WHERE ";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL = "lfRollupRule.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2 = "lfRollupRule.sequencingID IS NULL ";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2 = "lfRollupRule.sequencingID = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfRollupRule.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFRollupRule exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFRollupRule exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFRollupRulePersistenceImpl.class);
    private static LFRollupRule _nullLFRollupRule = new LFRollupRuleImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFRollupRule> toCacheModel() {
                return _nullLFRollupRuleCacheModel;
            }
        };

    private static CacheModel<LFRollupRule> _nullLFRollupRuleCacheModel = new CacheModel<LFRollupRule>() {
            public LFRollupRule toEntityModel() {
                return _nullLFRollupRule;
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
    @BeanReference(type = LFConfigPersistence.class)
    protected LFConfigPersistence lfConfigPersistence;
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
    @BeanReference(type = LFSocialPackagePersistence.class)
    protected LFSocialPackagePersistence lfSocialPackagePersistence;
    @BeanReference(type = LFSocialPackageTagPersistence.class)
    protected LFSocialPackageTagPersistence lfSocialPackageTagPersistence;
    @BeanReference(type = LFTincanActivityPersistence.class)
    protected LFTincanActivityPersistence lfTincanActivityPersistence;
    @BeanReference(type = LFTincanLrsEndpointPersistence.class)
    protected LFTincanLrsEndpointPersistence lfTincanLrsEndpointPersistence;
    @BeanReference(type = LFTincanPackagePersistence.class)
    protected LFTincanPackagePersistence lfTincanPackagePersistence;
    @BeanReference(type = LFUserPersistence.class)
    protected LFUserPersistence lfUserPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the l f rollup rule in the entity cache if it is enabled.
     *
     * @param lfRollupRule the l f rollup rule
     */
    public void cacheResult(LFRollupRule lfRollupRule) {
        EntityCacheUtil.putResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleImpl.class, lfRollupRule.getPrimaryKey(), lfRollupRule);

        lfRollupRule.resetOriginalValues();
    }

    /**
     * Caches the l f rollup rules in the entity cache if it is enabled.
     *
     * @param lfRollupRules the l f rollup rules
     */
    public void cacheResult(List<LFRollupRule> lfRollupRules) {
        for (LFRollupRule lfRollupRule : lfRollupRules) {
            if (EntityCacheUtil.getResult(
                        LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
                        LFRollupRuleImpl.class, lfRollupRule.getPrimaryKey()) == null) {
                cacheResult(lfRollupRule);
            } else {
                lfRollupRule.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f rollup rules.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFRollupRuleImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFRollupRuleImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f rollup rule.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFRollupRule lfRollupRule) {
        EntityCacheUtil.removeResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleImpl.class, lfRollupRule.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFRollupRule> lfRollupRules) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFRollupRule lfRollupRule : lfRollupRules) {
            EntityCacheUtil.removeResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
                LFRollupRuleImpl.class, lfRollupRule.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f rollup rule with the primary key. Does not add the l f rollup rule to the database.
     *
     * @param id the primary key for the new l f rollup rule
     * @return the new l f rollup rule
     */
    public LFRollupRule create(long id) {
        LFRollupRule lfRollupRule = new LFRollupRuleImpl();

        lfRollupRule.setNew(true);
        lfRollupRule.setPrimaryKey(id);

        return lfRollupRule;
    }

    /**
     * Removes the l f rollup rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f rollup rule
     * @return the l f rollup rule that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupRule remove(long id)
        throws NoSuchLFRollupRuleException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f rollup rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f rollup rule
     * @return the l f rollup rule that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule remove(Serializable primaryKey)
        throws NoSuchLFRollupRuleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFRollupRule lfRollupRule = (LFRollupRule) session.get(LFRollupRuleImpl.class,
                    primaryKey);

            if (lfRollupRule == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFRollupRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfRollupRule);
        } catch (NoSuchLFRollupRuleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFRollupRule removeImpl(LFRollupRule lfRollupRule)
        throws SystemException {
        lfRollupRule = toUnwrappedModel(lfRollupRule);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfRollupRule);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfRollupRule);

        return lfRollupRule;
    }

    @Override
    public LFRollupRule updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule,
        boolean merge) throws SystemException {
        lfRollupRule = toUnwrappedModel(lfRollupRule);

        boolean isNew = lfRollupRule.isNew();

        LFRollupRuleModelImpl lfRollupRuleModelImpl = (LFRollupRuleModelImpl) lfRollupRule;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfRollupRule, merge);

            lfRollupRule.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFRollupRuleModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfRollupRuleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfRollupRuleModelImpl.getOriginalSequencingID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfRollupRuleModelImpl.getSequencingID()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleImpl.class, lfRollupRule.getPrimaryKey(), lfRollupRule);

        return lfRollupRule;
    }

    protected LFRollupRule toUnwrappedModel(LFRollupRule lfRollupRule) {
        if (lfRollupRule instanceof LFRollupRuleImpl) {
            return lfRollupRule;
        }

        LFRollupRuleImpl lfRollupRuleImpl = new LFRollupRuleImpl();

        lfRollupRuleImpl.setNew(lfRollupRule.isNew());
        lfRollupRuleImpl.setPrimaryKey(lfRollupRule.getPrimaryKey());

        lfRollupRuleImpl.setId(lfRollupRule.getId());
        lfRollupRuleImpl.setSequencingID(lfRollupRule.getSequencingID());
        lfRollupRuleImpl.setCombination(lfRollupRule.getCombination());
        lfRollupRuleImpl.setChildActivitySet(lfRollupRule.getChildActivitySet());
        lfRollupRuleImpl.setMinimumCount(lfRollupRule.getMinimumCount());
        lfRollupRuleImpl.setMinimumPercent(lfRollupRule.getMinimumPercent());
        lfRollupRuleImpl.setAction(lfRollupRule.getAction());

        return lfRollupRuleImpl;
    }

    /**
     * Returns the l f rollup rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f rollup rule
     * @return the l f rollup rule
     * @throws com.liferay.portal.NoSuchModelException if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f rollup rule with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException} if it could not be found.
     *
     * @param id the primary key of the l f rollup rule
     * @return the l f rollup rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupRule findByPrimaryKey(long id)
        throws NoSuchLFRollupRuleException, SystemException {
        LFRollupRule lfRollupRule = fetchByPrimaryKey(id);

        if (lfRollupRule == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFRollupRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfRollupRule;
    }

    /**
     * Returns the l f rollup rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f rollup rule
     * @return the l f rollup rule, or <code>null</code> if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f rollup rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f rollup rule
     * @return the l f rollup rule, or <code>null</code> if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupRule fetchByPrimaryKey(long id) throws SystemException {
        LFRollupRule lfRollupRule = (LFRollupRule) EntityCacheUtil.getResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
                LFRollupRuleImpl.class, id);

        if (lfRollupRule == _nullLFRollupRule) {
            return null;
        }

        if (lfRollupRule == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfRollupRule = (LFRollupRule) session.get(LFRollupRuleImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfRollupRule != null) {
                    cacheResult(lfRollupRule);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
                        LFRollupRuleImpl.class, id, _nullLFRollupRule);
                }

                closeSession(session);
            }
        }

        return lfRollupRule;
    }

    /**
     * Returns all the l f rollup rules where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the matching l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    public List<LFRollupRule> findBySequencingID(Integer sequencingID)
        throws SystemException {
        return findBySequencingID(sequencingID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f rollup rules where sequencingID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param start the lower bound of the range of l f rollup rules
     * @param end the upper bound of the range of l f rollup rules (not inclusive)
     * @return the range of matching l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    public List<LFRollupRule> findBySequencingID(Integer sequencingID,
        int start, int end) throws SystemException {
        return findBySequencingID(sequencingID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f rollup rules where sequencingID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param start the lower bound of the range of l f rollup rules
     * @param end the upper bound of the range of l f rollup rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    public List<LFRollupRule> findBySequencingID(Integer sequencingID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID;
            finderArgs = new Object[] { sequencingID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGID;
            finderArgs = new Object[] {
                    sequencingID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFRollupRule> list = (List<LFRollupRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFRollupRule lfRollupRule : list) {
                if (!Validator.equals(sequencingID,
                            lfRollupRule.getSequencingID())) {
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

            query.append(_SQL_SELECT_LFROLLUPRULE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
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

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                list = (List<LFRollupRule>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Returns the first l f rollup rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f rollup rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a matching l f rollup rule could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupRule findBySequencingID_First(Integer sequencingID,
        OrderByComparator orderByComparator)
        throws NoSuchLFRollupRuleException, SystemException {
        LFRollupRule lfRollupRule = fetchBySequencingID_First(sequencingID,
                orderByComparator);

        if (lfRollupRule != null) {
            return lfRollupRule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRollupRuleException(msg.toString());
    }

    /**
     * Returns the first l f rollup rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f rollup rule, or <code>null</code> if a matching l f rollup rule could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupRule fetchBySequencingID_First(Integer sequencingID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFRollupRule> list = findBySequencingID(sequencingID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f rollup rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f rollup rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a matching l f rollup rule could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupRule findBySequencingID_Last(Integer sequencingID,
        OrderByComparator orderByComparator)
        throws NoSuchLFRollupRuleException, SystemException {
        LFRollupRule lfRollupRule = fetchBySequencingID_Last(sequencingID,
                orderByComparator);

        if (lfRollupRule != null) {
            return lfRollupRule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRollupRuleException(msg.toString());
    }

    /**
     * Returns the last l f rollup rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f rollup rule, or <code>null</code> if a matching l f rollup rule could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupRule fetchBySequencingID_Last(Integer sequencingID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySequencingID(sequencingID);

        List<LFRollupRule> list = findBySequencingID(sequencingID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f rollup rules before and after the current l f rollup rule in the ordered set where sequencingID = &#63;.
     *
     * @param id the primary key of the current l f rollup rule
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f rollup rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupRule[] findBySequencingID_PrevAndNext(long id,
        Integer sequencingID, OrderByComparator orderByComparator)
        throws NoSuchLFRollupRuleException, SystemException {
        LFRollupRule lfRollupRule = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFRollupRule[] array = new LFRollupRuleImpl[3];

            array[0] = getBySequencingID_PrevAndNext(session, lfRollupRule,
                    sequencingID, orderByComparator, true);

            array[1] = lfRollupRule;

            array[2] = getBySequencingID_PrevAndNext(session, lfRollupRule,
                    sequencingID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFRollupRule getBySequencingID_PrevAndNext(Session session,
        LFRollupRule lfRollupRule, Integer sequencingID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFROLLUPRULE_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(lfRollupRule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFRollupRule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f rollup rules.
     *
     * @return the l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    public List<LFRollupRule> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f rollup rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f rollup rules
     * @param end the upper bound of the range of l f rollup rules (not inclusive)
     * @return the range of l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    public List<LFRollupRule> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f rollup rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f rollup rules
     * @param end the upper bound of the range of l f rollup rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    public List<LFRollupRule> findAll(int start, int end,
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

        List<LFRollupRule> list = (List<LFRollupRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFROLLUPRULE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFROLLUPRULE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFRollupRule>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFRollupRule>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f rollup rules where sequencingID = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @throws SystemException if a system exception occurred
     */
    public void removeBySequencingID(Integer sequencingID)
        throws SystemException {
        for (LFRollupRule lfRollupRule : findBySequencingID(sequencingID)) {
            remove(lfRollupRule);
        }
    }

    /**
     * Removes all the l f rollup rules from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFRollupRule lfRollupRule : findAll()) {
            remove(lfRollupRule);
        }
    }

    /**
     * Returns the number of l f rollup rules where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the number of matching l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    public int countBySequencingID(Integer sequencingID)
        throws SystemException {
        Object[] finderArgs = new Object[] { sequencingID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFROLLUPRULE_WHERE);

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
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f rollup rules.
     *
     * @return the number of l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFROLLUPRULE);

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
     * Initializes the l f rollup rule persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFRollupRule")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFRollupRule>> listenersList = new ArrayList<ModelListener<LFRollupRule>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFRollupRule>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFRollupRuleImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
