package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException;
import com.arcusys.learn.persistence.liferay.model.LFSocialPackage;
import com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageModelImpl;
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
import com.arcusys.learn.persistence.liferay.service.persistence.LFSettingPersistence;
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
 * The persistence implementation for the l f social package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSocialPackagePersistence
 * @see LFSocialPackageUtil
 * @generated
 */
public class LFSocialPackagePersistenceImpl extends BasePersistenceImpl<LFSocialPackage>
    implements LFSocialPackagePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFSocialPackageUtil} to access the l f social package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFSocialPackageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORID = new FinderPath(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByAuthorID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID =
        new FinderPath(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthorID",
            new String[] { Integer.class.getName() },
            LFSocialPackageModelImpl.AUTHORID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORID = new FinderPath(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthorID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFSOCIALPACKAGE = "SELECT lfSocialPackage FROM LFSocialPackage lfSocialPackage";
    private static final String _SQL_SELECT_LFSOCIALPACKAGE_WHERE = "SELECT lfSocialPackage FROM LFSocialPackage lfSocialPackage WHERE ";
    private static final String _SQL_COUNT_LFSOCIALPACKAGE = "SELECT COUNT(lfSocialPackage) FROM LFSocialPackage lfSocialPackage";
    private static final String _SQL_COUNT_LFSOCIALPACKAGE_WHERE = "SELECT COUNT(lfSocialPackage) FROM LFSocialPackage lfSocialPackage WHERE ";
    private static final String _FINDER_COLUMN_AUTHORID_AUTHORID_NULL = "lfSocialPackage.authorID IS NULL";
    private static final String _FINDER_COLUMN_AUTHORID_AUTHORID_NULL_2 = "lfSocialPackage.authorID IS NULL ";
    private static final String _FINDER_COLUMN_AUTHORID_AUTHORID_2 = "lfSocialPackage.authorID = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfSocialPackage.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFSocialPackage exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFSocialPackage exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFSocialPackagePersistenceImpl.class);
    private static LFSocialPackage _nullLFSocialPackage = new LFSocialPackageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFSocialPackage> toCacheModel() {
                return _nullLFSocialPackageCacheModel;
            }
        };

    private static CacheModel<LFSocialPackage> _nullLFSocialPackageCacheModel = new CacheModel<LFSocialPackage>() {
            public LFSocialPackage toEntityModel() {
                return _nullLFSocialPackage;
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
    @BeanReference(type = LFSettingPersistence.class)
    protected LFSettingPersistence lfSettingPersistence;
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
     * Caches the l f social package in the entity cache if it is enabled.
     *
     * @param lfSocialPackage the l f social package
     */
    public void cacheResult(LFSocialPackage lfSocialPackage) {
        EntityCacheUtil.putResult(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageImpl.class, lfSocialPackage.getPrimaryKey(),
            lfSocialPackage);

        lfSocialPackage.resetOriginalValues();
    }

    /**
     * Caches the l f social packages in the entity cache if it is enabled.
     *
     * @param lfSocialPackages the l f social packages
     */
    public void cacheResult(List<LFSocialPackage> lfSocialPackages) {
        for (LFSocialPackage lfSocialPackage : lfSocialPackages) {
            if (EntityCacheUtil.getResult(
                        LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
                        LFSocialPackageImpl.class,
                        lfSocialPackage.getPrimaryKey()) == null) {
                cacheResult(lfSocialPackage);
            } else {
                lfSocialPackage.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f social packages.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFSocialPackageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFSocialPackageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f social package.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFSocialPackage lfSocialPackage) {
        EntityCacheUtil.removeResult(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageImpl.class, lfSocialPackage.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFSocialPackage> lfSocialPackages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFSocialPackage lfSocialPackage : lfSocialPackages) {
            EntityCacheUtil.removeResult(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
                LFSocialPackageImpl.class, lfSocialPackage.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f social package with the primary key. Does not add the l f social package to the database.
     *
     * @param id the primary key for the new l f social package
     * @return the new l f social package
     */
    public LFSocialPackage create(long id) {
        LFSocialPackage lfSocialPackage = new LFSocialPackageImpl();

        lfSocialPackage.setNew(true);
        lfSocialPackage.setPrimaryKey(id);

        return lfSocialPackage;
    }

    /**
     * Removes the l f social package with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f social package
     * @return the l f social package that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a l f social package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSocialPackage remove(long id)
        throws NoSuchLFSocialPackageException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f social package with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f social package
     * @return the l f social package that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a l f social package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackage remove(Serializable primaryKey)
        throws NoSuchLFSocialPackageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFSocialPackage lfSocialPackage = (LFSocialPackage) session.get(LFSocialPackageImpl.class,
                    primaryKey);

            if (lfSocialPackage == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFSocialPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfSocialPackage);
        } catch (NoSuchLFSocialPackageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFSocialPackage removeImpl(LFSocialPackage lfSocialPackage)
        throws SystemException {
        lfSocialPackage = toUnwrappedModel(lfSocialPackage);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfSocialPackage);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfSocialPackage);

        return lfSocialPackage;
    }

    @Override
    public LFSocialPackage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage,
        boolean merge) throws SystemException {
        lfSocialPackage = toUnwrappedModel(lfSocialPackage);

        boolean isNew = lfSocialPackage.isNew();

        LFSocialPackageModelImpl lfSocialPackageModelImpl = (LFSocialPackageModelImpl) lfSocialPackage;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfSocialPackage, merge);

            lfSocialPackage.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFSocialPackageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfSocialPackageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfSocialPackageModelImpl.getOriginalAuthorID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfSocialPackageModelImpl.getAuthorID()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageImpl.class, lfSocialPackage.getPrimaryKey(),
            lfSocialPackage);

        return lfSocialPackage;
    }

    protected LFSocialPackage toUnwrappedModel(LFSocialPackage lfSocialPackage) {
        if (lfSocialPackage instanceof LFSocialPackageImpl) {
            return lfSocialPackage;
        }

        LFSocialPackageImpl lfSocialPackageImpl = new LFSocialPackageImpl();

        lfSocialPackageImpl.setNew(lfSocialPackage.isNew());
        lfSocialPackageImpl.setPrimaryKey(lfSocialPackage.getPrimaryKey());

        lfSocialPackageImpl.setId(lfSocialPackage.getId());
        lfSocialPackageImpl.setPackageID(lfSocialPackage.getPackageID());
        lfSocialPackageImpl.setAboutPackage(lfSocialPackage.getAboutPackage());
        lfSocialPackageImpl.setPublishDate(lfSocialPackage.getPublishDate());
        lfSocialPackageImpl.setAuthorID(lfSocialPackage.getAuthorID());

        return lfSocialPackageImpl;
    }

    /**
     * Returns the l f social package with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f social package
     * @return the l f social package
     * @throws com.liferay.portal.NoSuchModelException if a l f social package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackage findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f social package with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException} if it could not be found.
     *
     * @param id the primary key of the l f social package
     * @return the l f social package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a l f social package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSocialPackage findByPrimaryKey(long id)
        throws NoSuchLFSocialPackageException, SystemException {
        LFSocialPackage lfSocialPackage = fetchByPrimaryKey(id);

        if (lfSocialPackage == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFSocialPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfSocialPackage;
    }

    /**
     * Returns the l f social package with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f social package
     * @return the l f social package, or <code>null</code> if a l f social package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackage fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f social package with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f social package
     * @return the l f social package, or <code>null</code> if a l f social package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSocialPackage fetchByPrimaryKey(long id) throws SystemException {
        LFSocialPackage lfSocialPackage = (LFSocialPackage) EntityCacheUtil.getResult(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
                LFSocialPackageImpl.class, id);

        if (lfSocialPackage == _nullLFSocialPackage) {
            return null;
        }

        if (lfSocialPackage == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfSocialPackage = (LFSocialPackage) session.get(LFSocialPackageImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfSocialPackage != null) {
                    cacheResult(lfSocialPackage);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFSocialPackageModelImpl.ENTITY_CACHE_ENABLED,
                        LFSocialPackageImpl.class, id, _nullLFSocialPackage);
                }

                closeSession(session);
            }
        }

        return lfSocialPackage;
    }

    /**
     * Returns all the l f social packages where authorID = &#63;.
     *
     * @param authorID the author i d
     * @return the matching l f social packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackage> findByAuthorID(Integer authorID)
        throws SystemException {
        return findByAuthorID(authorID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f social packages where authorID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param authorID the author i d
     * @param start the lower bound of the range of l f social packages
     * @param end the upper bound of the range of l f social packages (not inclusive)
     * @return the range of matching l f social packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackage> findByAuthorID(Integer authorID, int start,
        int end) throws SystemException {
        return findByAuthorID(authorID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f social packages where authorID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param authorID the author i d
     * @param start the lower bound of the range of l f social packages
     * @param end the upper bound of the range of l f social packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f social packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackage> findByAuthorID(Integer authorID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID;
            finderArgs = new Object[] { authorID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORID;
            finderArgs = new Object[] { authorID, start, end, orderByComparator };
        }

        List<LFSocialPackage> list = (List<LFSocialPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFSocialPackage lfSocialPackage : list) {
                if (!Validator.equals(authorID, lfSocialPackage.getAuthorID())) {
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

            query.append(_SQL_SELECT_LFSOCIALPACKAGE_WHERE);

            if (authorID == null) {
                query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);
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

                if (authorID != null) {
                    qPos.add(authorID.intValue());
                }

                list = (List<LFSocialPackage>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f social package in the ordered set where authorID = &#63;.
     *
     * @param authorID the author i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f social package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a matching l f social package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSocialPackage findByAuthorID_First(Integer authorID,
        OrderByComparator orderByComparator)
        throws NoSuchLFSocialPackageException, SystemException {
        LFSocialPackage lfSocialPackage = fetchByAuthorID_First(authorID,
                orderByComparator);

        if (lfSocialPackage != null) {
            return lfSocialPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("authorID=");
        msg.append(authorID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSocialPackageException(msg.toString());
    }

    /**
     * Returns the first l f social package in the ordered set where authorID = &#63;.
     *
     * @param authorID the author i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f social package, or <code>null</code> if a matching l f social package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSocialPackage fetchByAuthorID_First(Integer authorID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFSocialPackage> list = findByAuthorID(authorID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f social package in the ordered set where authorID = &#63;.
     *
     * @param authorID the author i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f social package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a matching l f social package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSocialPackage findByAuthorID_Last(Integer authorID,
        OrderByComparator orderByComparator)
        throws NoSuchLFSocialPackageException, SystemException {
        LFSocialPackage lfSocialPackage = fetchByAuthorID_Last(authorID,
                orderByComparator);

        if (lfSocialPackage != null) {
            return lfSocialPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("authorID=");
        msg.append(authorID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSocialPackageException(msg.toString());
    }

    /**
     * Returns the last l f social package in the ordered set where authorID = &#63;.
     *
     * @param authorID the author i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f social package, or <code>null</code> if a matching l f social package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSocialPackage fetchByAuthorID_Last(Integer authorID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAuthorID(authorID);

        List<LFSocialPackage> list = findByAuthorID(authorID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f social packages before and after the current l f social package in the ordered set where authorID = &#63;.
     *
     * @param id the primary key of the current l f social package
     * @param authorID the author i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f social package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a l f social package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSocialPackage[] findByAuthorID_PrevAndNext(long id,
        Integer authorID, OrderByComparator orderByComparator)
        throws NoSuchLFSocialPackageException, SystemException {
        LFSocialPackage lfSocialPackage = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFSocialPackage[] array = new LFSocialPackageImpl[3];

            array[0] = getByAuthorID_PrevAndNext(session, lfSocialPackage,
                    authorID, orderByComparator, true);

            array[1] = lfSocialPackage;

            array[2] = getByAuthorID_PrevAndNext(session, lfSocialPackage,
                    authorID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFSocialPackage getByAuthorID_PrevAndNext(Session session,
        LFSocialPackage lfSocialPackage, Integer authorID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFSOCIALPACKAGE_WHERE);

        if (authorID == null) {
            query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);
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

        if (authorID != null) {
            qPos.add(authorID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfSocialPackage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFSocialPackage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f social packages.
     *
     * @return the l f social packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackage> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f social packages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f social packages
     * @param end the upper bound of the range of l f social packages (not inclusive)
     * @return the range of l f social packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackage> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f social packages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f social packages
     * @param end the upper bound of the range of l f social packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f social packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackage> findAll(int start, int end,
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

        List<LFSocialPackage> list = (List<LFSocialPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFSOCIALPACKAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFSOCIALPACKAGE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFSocialPackage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFSocialPackage>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the l f social packages where authorID = &#63; from the database.
     *
     * @param authorID the author i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByAuthorID(Integer authorID) throws SystemException {
        for (LFSocialPackage lfSocialPackage : findByAuthorID(authorID)) {
            remove(lfSocialPackage);
        }
    }

    /**
     * Removes all the l f social packages from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFSocialPackage lfSocialPackage : findAll()) {
            remove(lfSocialPackage);
        }
    }

    /**
     * Returns the number of l f social packages where authorID = &#63;.
     *
     * @param authorID the author i d
     * @return the number of matching l f social packages
     * @throws SystemException if a system exception occurred
     */
    public int countByAuthorID(Integer authorID) throws SystemException {
        Object[] finderArgs = new Object[] { authorID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AUTHORID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFSOCIALPACKAGE_WHERE);

            if (authorID == null) {
                query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (authorID != null) {
                    qPos.add(authorID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AUTHORID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f social packages.
     *
     * @return the number of l f social packages
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFSOCIALPACKAGE);

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
     * Initializes the l f social package persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFSocialPackage")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFSocialPackage>> listenersList = new ArrayList<ModelListener<LFSocialPackage>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFSocialPackage>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFSocialPackageImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
