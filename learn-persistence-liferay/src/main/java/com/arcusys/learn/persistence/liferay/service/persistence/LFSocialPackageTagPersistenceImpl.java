package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException;
import com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag;
import com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl;
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
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageTagImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
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
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCIALPACKAGEID =
        new FinderPath(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
            LFSocialPackageTagModelImpl.FINDER_CACHE_ENABLED,
            LFSocialPackageTagImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySocialPackageID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
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
    private static final String _SQL_SELECT_LFSOCIALPACKAGETAG = "SELECT lfSocialPackageTag FROM LFSocialPackageTag lfSocialPackageTag";
    private static final String _SQL_SELECT_LFSOCIALPACKAGETAG_WHERE = "SELECT lfSocialPackageTag FROM LFSocialPackageTag lfSocialPackageTag WHERE ";
    private static final String _SQL_COUNT_LFSOCIALPACKAGETAG = "SELECT COUNT(lfSocialPackageTag) FROM LFSocialPackageTag lfSocialPackageTag";
    private static final String _SQL_COUNT_LFSOCIALPACKAGETAG_WHERE = "SELECT COUNT(lfSocialPackageTag) FROM LFSocialPackageTag lfSocialPackageTag WHERE ";
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "lfSocialPackageTag.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_NULL = "lfSocialPackageTag.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_NULL_2 = "lfSocialPackageTag.name IS NULL ";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "lfSocialPackageTag.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(lfSocialPackageTag.name IS NULL OR lfSocialPackageTag.name = ?)";
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_NULL =
        "lfSocialPackageTag.socialPackageID IS NULL";
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_NULL_2 =
        "lfSocialPackageTag.socialPackageID IS NULL ";
    private static final String _FINDER_COLUMN_SOCIALPACKAGEID_SOCIALPACKAGEID_2 =
        "lfSocialPackageTag.socialPackageID = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfSocialPackageTag.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFSocialPackageTag exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFSocialPackageTag exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFSocialPackageTagPersistenceImpl.class);
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
            public LFSocialPackageTag toEntityModel() {
                return _nullLFSocialPackageTag;
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
     * Caches the l f social package tag in the entity cache if it is enabled.
     *
     * @param lfSocialPackageTag the l f social package tag
     */
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
    public LFSocialPackageTag remove(long id)
        throws NoSuchLFSocialPackageTagException, SystemException {
        return remove(Long.valueOf(id));
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

            BatchSessionUtil.delete(session, lfSocialPackageTag);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfSocialPackageTag);

        return lfSocialPackageTag;
    }

    @Override
    public LFSocialPackageTag updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag lfSocialPackageTag,
        boolean merge) throws SystemException {
        lfSocialPackageTag = toUnwrappedModel(lfSocialPackageTag);

        boolean isNew = lfSocialPackageTag.isNew();

        LFSocialPackageTagModelImpl lfSocialPackageTagModelImpl = (LFSocialPackageTagModelImpl) lfSocialPackageTag;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfSocialPackageTag, merge);

            lfSocialPackageTag.setNew(false);
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
                        /* Integer.valueOf(   */
                        lfSocialPackageTagModelImpl.getOriginalSocialPackageID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCIALPACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALPACKAGEID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfSocialPackageTagModelImpl.getSocialPackageID()
                    /* ) */
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
     * @throws com.liferay.portal.NoSuchModelException if a l f social package tag with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSocialPackageTag findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f social package tag with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException} if it could not be found.
     *
     * @param id the primary key of the l f social package tag
     * @return the l f social package tag
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a l f social package tag with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSocialPackageTag findByPrimaryKey(long id)
        throws NoSuchLFSocialPackageTagException, SystemException {
        LFSocialPackageTag lfSocialPackageTag = fetchByPrimaryKey(id);

        if (lfSocialPackageTag == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFSocialPackageTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfSocialPackageTag;
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
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f social package tag with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f social package tag
     * @return the l f social package tag, or <code>null</code> if a l f social package tag with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSocialPackageTag fetchByPrimaryKey(long id)
        throws SystemException {
        LFSocialPackageTag lfSocialPackageTag = (LFSocialPackageTag) EntityCacheUtil.getResult(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
                LFSocialPackageTagImpl.class, id);

        if (lfSocialPackageTag == _nullLFSocialPackageTag) {
            return null;
        }

        if (lfSocialPackageTag == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfSocialPackageTag = (LFSocialPackageTag) session.get(LFSocialPackageTagImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfSocialPackageTag != null) {
                    cacheResult(lfSocialPackageTag);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFSocialPackageTagModelImpl.ENTITY_CACHE_ENABLED,
                        LFSocialPackageTagImpl.class, id,
                        _nullLFSocialPackageTag);
                }

                closeSession(session);
            }
        }

        return lfSocialPackageTag;
    }

    /**
     * Returns all the l f social package tags where name = &#63;.
     *
     * @param name the name
     * @return the matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackageTag> findByName(String name)
        throws SystemException {
        return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f social package tags where name = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param name the name
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @return the range of matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackageTag> findByName(String name, int start, int end)
        throws SystemException {
        return findByName(name, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f social package tags where name = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param name the name
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackageTag> findByName(String name, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
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
                query = new StringBundler(2);
            }

            query.append(_SQL_SELECT_LFSOCIALPACKAGETAG_WHERE);

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else {
                if (name.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_NAME_NAME_3);
                } else {
                    query.append(_FINDER_COLUMN_NAME_NAME_2);
                }
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

                if (name != null) {
                    qPos.add(name);
                }

                list = (List<LFSocialPackageTag>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first l f social package tag in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f social package tag
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a matching l f social package tag could not be found
     * @throws SystemException if a system exception occurred
     */
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
    public LFSocialPackageTag fetchByName_Last(String name,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByName(name);

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

        if (name == null) {
            query.append(_FINDER_COLUMN_NAME_NAME_1);
        } else {
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
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (name != null) {
            qPos.add(name);
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
     * Returns all the l f social package tags where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @return the matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackageTag> findBySocialPackageID(
        Integer socialPackageID) throws SystemException {
        return findBySocialPackageID(socialPackageID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f social package tags where socialPackageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param socialPackageID the social package i d
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @return the range of matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackageTag> findBySocialPackageID(
        Integer socialPackageID, int start, int end) throws SystemException {
        return findBySocialPackageID(socialPackageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f social package tags where socialPackageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param socialPackageID the social package i d
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackageTag> findBySocialPackageID(
        Integer socialPackageID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
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
                query = new StringBundler(2);
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

                list = (List<LFSocialPackageTag>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first l f social package tag in the ordered set where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f social package tag
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a matching l f social package tag could not be found
     * @throws SystemException if a system exception occurred
     */
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
    public LFSocialPackageTag fetchBySocialPackageID_Last(
        Integer socialPackageID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countBySocialPackageID(socialPackageID);

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
     * Returns all the l f social package tags.
     *
     * @return the l f social package tags
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackageTag> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f social package tags.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @return the range of l f social package tags
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackageTag> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f social package tags.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f social package tags
     * @param end the upper bound of the range of l f social package tags (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f social package tags
     * @throws SystemException if a system exception occurred
     */
    public List<LFSocialPackageTag> findAll(int start, int end,
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
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFSocialPackageTag>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFSocialPackageTag>) QueryUtil.list(q,
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
     * Removes all the l f social package tags where name = &#63; from the database.
     *
     * @param name the name
     * @throws SystemException if a system exception occurred
     */
    public void removeByName(String name) throws SystemException {
        for (LFSocialPackageTag lfSocialPackageTag : findByName(name)) {
            remove(lfSocialPackageTag);
        }
    }

    /**
     * Removes all the l f social package tags where socialPackageID = &#63; from the database.
     *
     * @param socialPackageID the social package i d
     * @throws SystemException if a system exception occurred
     */
    public void removeBySocialPackageID(Integer socialPackageID)
        throws SystemException {
        for (LFSocialPackageTag lfSocialPackageTag : findBySocialPackageID(
                socialPackageID)) {
            remove(lfSocialPackageTag);
        }
    }

    /**
     * Removes all the l f social package tags from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFSocialPackageTag lfSocialPackageTag : findAll()) {
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
    public int countByName(String name) throws SystemException {
        Object[] finderArgs = new Object[] { name };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFSOCIALPACKAGETAG_WHERE);

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else {
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

                if (name != null) {
                    qPos.add(name);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f social package tags where socialPackageID = &#63;.
     *
     * @param socialPackageID the social package i d
     * @return the number of matching l f social package tags
     * @throws SystemException if a system exception occurred
     */
    public int countBySocialPackageID(Integer socialPackageID)
        throws SystemException {
        Object[] finderArgs = new Object[] { socialPackageID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SOCIALPACKAGEID,
                finderArgs, this);

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
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SOCIALPACKAGEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f social package tags.
     *
     * @return the number of l f social package tags
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFSOCIALPACKAGETAG);

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
                            listenerClassName));
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
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
