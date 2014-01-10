package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateTree;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateTreeImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateTreeModelImpl;
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
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActorPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsActivityProfilePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsAgentProfilePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsAttachmentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsContextActivitiesPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsContextPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsDocumentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsEndpointPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsResultPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatementPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatementRefPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsSubStatementPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanManifestActivityPersistence;
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
 * The persistence implementation for the l f activity state tree service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateTreePersistence
 * @see LFActivityStateTreeUtil
 * @generated
 */
public class LFActivityStateTreePersistenceImpl extends BasePersistenceImpl<LFActivityStateTree>
    implements LFActivityStateTreePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFActivityStateTreeUtil} to access the l f activity state tree persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFActivityStateTreeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_ATTEMPTID = new FinderPath(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateTreeImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByAttemptID", new String[] { Integer.class.getName() },
            LFActivityStateTreeModelImpl.ATTEMPTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTEMPTID = new FinderPath(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttemptID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateTreeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateTreeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFACTIVITYSTATETREE = "SELECT lfActivityStateTree FROM LFActivityStateTree lfActivityStateTree";
    private static final String _SQL_SELECT_LFACTIVITYSTATETREE_WHERE = "SELECT lfActivityStateTree FROM LFActivityStateTree lfActivityStateTree WHERE ";
    private static final String _SQL_COUNT_LFACTIVITYSTATETREE = "SELECT COUNT(lfActivityStateTree) FROM LFActivityStateTree lfActivityStateTree";
    private static final String _SQL_COUNT_LFACTIVITYSTATETREE_WHERE = "SELECT COUNT(lfActivityStateTree) FROM LFActivityStateTree lfActivityStateTree WHERE ";
    private static final String _FINDER_COLUMN_ATTEMPTID_ATTEMPTID_NULL = "lfActivityStateTree.attemptID IS NULL";
    private static final String _FINDER_COLUMN_ATTEMPTID_ATTEMPTID_NULL_2 = "lfActivityStateTree.attemptID IS NULL ";
    private static final String _FINDER_COLUMN_ATTEMPTID_ATTEMPTID_2 = "lfActivityStateTree.attemptID = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfActivityStateTree.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFActivityStateTree exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFActivityStateTree exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFActivityStateTreePersistenceImpl.class);
    private static LFActivityStateTree _nullLFActivityStateTree = new LFActivityStateTreeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFActivityStateTree> toCacheModel() {
                return _nullLFActivityStateTreeCacheModel;
            }
        };

    private static CacheModel<LFActivityStateTree> _nullLFActivityStateTreeCacheModel =
        new CacheModel<LFActivityStateTree>() {
            public LFActivityStateTree toEntityModel() {
                return _nullLFActivityStateTree;
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
    @BeanReference(type = LFTincanActorPersistence.class)
    protected LFTincanActorPersistence lfTincanActorPersistence;
    @BeanReference(type = LFTincanLrsActivityProfilePersistence.class)
    protected LFTincanLrsActivityProfilePersistence lfTincanLrsActivityProfilePersistence;
    @BeanReference(type = LFTincanLrsAgentProfilePersistence.class)
    protected LFTincanLrsAgentProfilePersistence lfTincanLrsAgentProfilePersistence;
    @BeanReference(type = LFTincanLrsAttachmentPersistence.class)
    protected LFTincanLrsAttachmentPersistence lfTincanLrsAttachmentPersistence;
    @BeanReference(type = LFTincanLrsContextPersistence.class)
    protected LFTincanLrsContextPersistence lfTincanLrsContextPersistence;
    @BeanReference(type = LFTincanLrsContextActivitiesPersistence.class)
    protected LFTincanLrsContextActivitiesPersistence lfTincanLrsContextActivitiesPersistence;
    @BeanReference(type = LFTincanLrsDocumentPersistence.class)
    protected LFTincanLrsDocumentPersistence lfTincanLrsDocumentPersistence;
    @BeanReference(type = LFTincanLrsEndpointPersistence.class)
    protected LFTincanLrsEndpointPersistence lfTincanLrsEndpointPersistence;
    @BeanReference(type = LFTincanLrsResultPersistence.class)
    protected LFTincanLrsResultPersistence lfTincanLrsResultPersistence;
    @BeanReference(type = LFTincanLrsStatePersistence.class)
    protected LFTincanLrsStatePersistence lfTincanLrsStatePersistence;
    @BeanReference(type = LFTincanLrsStatementPersistence.class)
    protected LFTincanLrsStatementPersistence lfTincanLrsStatementPersistence;
    @BeanReference(type = LFTincanLrsStatementRefPersistence.class)
    protected LFTincanLrsStatementRefPersistence lfTincanLrsStatementRefPersistence;
    @BeanReference(type = LFTincanLrsSubStatementPersistence.class)
    protected LFTincanLrsSubStatementPersistence lfTincanLrsSubStatementPersistence;
    @BeanReference(type = LFTincanManifestActivityPersistence.class)
    protected LFTincanManifestActivityPersistence lfTincanManifestActivityPersistence;
    @BeanReference(type = LFTincanPackagePersistence.class)
    protected LFTincanPackagePersistence lfTincanPackagePersistence;
    @BeanReference(type = LFUserPersistence.class)
    protected LFUserPersistence lfUserPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the l f activity state tree in the entity cache if it is enabled.
     *
     * @param lfActivityStateTree the l f activity state tree
     */
    public void cacheResult(LFActivityStateTree lfActivityStateTree) {
        EntityCacheUtil.putResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeImpl.class, lfActivityStateTree.getPrimaryKey(),
            lfActivityStateTree);

        boolean noNullsInATTEMPTID = true;

        if (lfActivityStateTree.getAttemptID() == null) {
            noNullsInATTEMPTID = false;
        }

        if (noNullsInATTEMPTID) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                new Object[] { Integer.valueOf(
                        lfActivityStateTree.getAttemptID()) },
                lfActivityStateTree);
        }

        lfActivityStateTree.resetOriginalValues();
    }

    /**
     * Caches the l f activity state trees in the entity cache if it is enabled.
     *
     * @param lfActivityStateTrees the l f activity state trees
     */
    public void cacheResult(List<LFActivityStateTree> lfActivityStateTrees) {
        for (LFActivityStateTree lfActivityStateTree : lfActivityStateTrees) {
            if (EntityCacheUtil.getResult(
                        LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityStateTreeImpl.class,
                        lfActivityStateTree.getPrimaryKey()) == null) {
                cacheResult(lfActivityStateTree);
            } else {
                lfActivityStateTree.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f activity state trees.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFActivityStateTreeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFActivityStateTreeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f activity state tree.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFActivityStateTree lfActivityStateTree) {
        EntityCacheUtil.removeResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeImpl.class, lfActivityStateTree.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfActivityStateTree);
    }

    @Override
    public void clearCache(List<LFActivityStateTree> lfActivityStateTrees) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFActivityStateTree lfActivityStateTree : lfActivityStateTrees) {
            EntityCacheUtil.removeResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityStateTreeImpl.class,
                lfActivityStateTree.getPrimaryKey());

            clearUniqueFindersCache(lfActivityStateTree);
        }
    }

    protected void clearUniqueFindersCache(
        LFActivityStateTree lfActivityStateTree) {
        boolean noNullsInATTEMPTID = true;

        if (lfActivityStateTree.getAttemptID() == null) {
            noNullsInATTEMPTID = false;
        }

        if (noNullsInATTEMPTID) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                new Object[] { Integer.valueOf(
                        lfActivityStateTree.getAttemptID()) });
        }
    }

    /**
     * Creates a new l f activity state tree with the primary key. Does not add the l f activity state tree to the database.
     *
     * @param id the primary key for the new l f activity state tree
     * @return the new l f activity state tree
     */
    public LFActivityStateTree create(long id) {
        LFActivityStateTree lfActivityStateTree = new LFActivityStateTreeImpl();

        lfActivityStateTree.setNew(true);
        lfActivityStateTree.setPrimaryKey(id);

        return lfActivityStateTree;
    }

    /**
     * Removes the l f activity state tree with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f activity state tree
     * @return the l f activity state tree that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityStateTree remove(long id)
        throws NoSuchLFActivityStateTreeException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f activity state tree with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f activity state tree
     * @return the l f activity state tree that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree remove(Serializable primaryKey)
        throws NoSuchLFActivityStateTreeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFActivityStateTree lfActivityStateTree = (LFActivityStateTree) session.get(LFActivityStateTreeImpl.class,
                    primaryKey);

            if (lfActivityStateTree == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFActivityStateTreeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfActivityStateTree);
        } catch (NoSuchLFActivityStateTreeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFActivityStateTree removeImpl(
        LFActivityStateTree lfActivityStateTree) throws SystemException {
        lfActivityStateTree = toUnwrappedModel(lfActivityStateTree);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfActivityStateTree);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfActivityStateTree);

        return lfActivityStateTree;
    }

    @Override
    public LFActivityStateTree updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree,
        boolean merge) throws SystemException {
        lfActivityStateTree = toUnwrappedModel(lfActivityStateTree);

        boolean isNew = lfActivityStateTree.isNew();

        LFActivityStateTreeModelImpl lfActivityStateTreeModelImpl = (LFActivityStateTreeModelImpl) lfActivityStateTree;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfActivityStateTree, merge);

            lfActivityStateTree.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFActivityStateTreeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeImpl.class, lfActivityStateTree.getPrimaryKey(),
            lfActivityStateTree);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                new Object[] { /*Integer.valueOf( */
                lfActivityStateTree.getAttemptID()/*) */
                }, lfActivityStateTree);
        } else {
            if ((lfActivityStateTreeModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ATTEMPTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /*        Integer.valueOf( */
                        lfActivityStateTreeModelImpl.getOriginalAttemptID()
                    /*        ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTEMPTID,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                    new Object[] { /*        Integer.valueOf( */
                    lfActivityStateTree.getAttemptID()/*        ) */
                    }, lfActivityStateTree);
            }
        }

        return lfActivityStateTree;
    }

    protected LFActivityStateTree toUnwrappedModel(
        LFActivityStateTree lfActivityStateTree) {
        if (lfActivityStateTree instanceof LFActivityStateTreeImpl) {
            return lfActivityStateTree;
        }

        LFActivityStateTreeImpl lfActivityStateTreeImpl = new LFActivityStateTreeImpl();

        lfActivityStateTreeImpl.setNew(lfActivityStateTree.isNew());
        lfActivityStateTreeImpl.setPrimaryKey(lfActivityStateTree.getPrimaryKey());

        lfActivityStateTreeImpl.setId(lfActivityStateTree.getId());
        lfActivityStateTreeImpl.setCurrentActivityID(lfActivityStateTree.getCurrentActivityID());
        lfActivityStateTreeImpl.setSuspendedActivityID(lfActivityStateTree.getSuspendedActivityID());
        lfActivityStateTreeImpl.setAttemptID(lfActivityStateTree.getAttemptID());

        return lfActivityStateTreeImpl;
    }

    /**
     * Returns the l f activity state tree with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity state tree
     * @return the l f activity state tree
     * @throws com.liferay.portal.NoSuchModelException if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f activity state tree with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException} if it could not be found.
     *
     * @param id the primary key of the l f activity state tree
     * @return the l f activity state tree
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityStateTree findByPrimaryKey(long id)
        throws NoSuchLFActivityStateTreeException, SystemException {
        LFActivityStateTree lfActivityStateTree = fetchByPrimaryKey(id);

        if (lfActivityStateTree == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFActivityStateTreeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfActivityStateTree;
    }

    /**
     * Returns the l f activity state tree with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity state tree
     * @return the l f activity state tree, or <code>null</code> if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f activity state tree with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f activity state tree
     * @return the l f activity state tree, or <code>null</code> if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityStateTree fetchByPrimaryKey(long id)
        throws SystemException {
        LFActivityStateTree lfActivityStateTree = (LFActivityStateTree) EntityCacheUtil.getResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityStateTreeImpl.class, id);

        if (lfActivityStateTree == _nullLFActivityStateTree) {
            return null;
        }

        if (lfActivityStateTree == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfActivityStateTree = (LFActivityStateTree) session.get(LFActivityStateTreeImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfActivityStateTree != null) {
                    cacheResult(lfActivityStateTree);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityStateTreeImpl.class, id,
                        _nullLFActivityStateTree);
                }

                closeSession(session);
            }
        }

        return lfActivityStateTree;
    }

    /**
     * Returns the l f activity state tree where attemptID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException} if it could not be found.
     *
     * @param attemptID the attempt i d
     * @return the matching l f activity state tree
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a matching l f activity state tree could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityStateTree findByAttemptID(Integer attemptID)
        throws NoSuchLFActivityStateTreeException, SystemException {
        LFActivityStateTree lfActivityStateTree = fetchByAttemptID(attemptID);

        if (lfActivityStateTree == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("attemptID=");
            msg.append(attemptID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFActivityStateTreeException(msg.toString());
        }

        return lfActivityStateTree;
    }

    /**
     * Returns the l f activity state tree where attemptID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param attemptID the attempt i d
     * @return the matching l f activity state tree, or <code>null</code> if a matching l f activity state tree could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityStateTree fetchByAttemptID(Integer attemptID)
        throws SystemException {
        return fetchByAttemptID(attemptID, true);
    }

    /**
     * Returns the l f activity state tree where attemptID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param attemptID the attempt i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f activity state tree, or <code>null</code> if a matching l f activity state tree could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityStateTree fetchByAttemptID(Integer attemptID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { attemptID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                    finderArgs, this);
        }

        if (result instanceof LFActivityStateTree) {
            LFActivityStateTree lfActivityStateTree = (LFActivityStateTree) result;

            if (!Validator.equals(attemptID, lfActivityStateTree.getAttemptID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_LFACTIVITYSTATETREE_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_ATTEMPTID_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ATTEMPTID_ATTEMPTID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
                }

                List<LFActivityStateTree> list = q.list();

                result = list;

                LFActivityStateTree lfActivityStateTree = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                        finderArgs, list);
                } else {
                    lfActivityStateTree = list.get(0);

                    cacheResult(lfActivityStateTree);

                    if ((lfActivityStateTree.getAttemptID() != attemptID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                            finderArgs, lfActivityStateTree);
                    }
                }

                return lfActivityStateTree;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFActivityStateTree) result;
            }
        }
    }

    /**
     * Returns all the l f activity state trees.
     *
     * @return the l f activity state trees
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityStateTree> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activity state trees.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f activity state trees
     * @param end the upper bound of the range of l f activity state trees (not inclusive)
     * @return the range of l f activity state trees
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityStateTree> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activity state trees.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f activity state trees
     * @param end the upper bound of the range of l f activity state trees (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f activity state trees
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityStateTree> findAll(int start, int end,
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

        List<LFActivityStateTree> list = (List<LFActivityStateTree>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFACTIVITYSTATETREE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFACTIVITYSTATETREE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFActivityStateTree>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFActivityStateTree>) QueryUtil.list(q,
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
     * Removes the l f activity state tree where attemptID = &#63; from the database.
     *
     * @param attemptID the attempt i d
     * @return the l f activity state tree that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFActivityStateTree removeByAttemptID(Integer attemptID)
        throws NoSuchLFActivityStateTreeException, SystemException {
        LFActivityStateTree lfActivityStateTree = findByAttemptID(attemptID);

        return remove(lfActivityStateTree);
    }

    /**
     * Removes all the l f activity state trees from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFActivityStateTree lfActivityStateTree : findAll()) {
            remove(lfActivityStateTree);
        }
    }

    /**
     * Returns the number of l f activity state trees where attemptID = &#63;.
     *
     * @param attemptID the attempt i d
     * @return the number of matching l f activity state trees
     * @throws SystemException if a system exception occurred
     */
    public int countByAttemptID(Integer attemptID) throws SystemException {
        Object[] finderArgs = new Object[] { attemptID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ATTEMPTID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFACTIVITYSTATETREE_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_ATTEMPTID_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ATTEMPTID_ATTEMPTID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ATTEMPTID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f activity state trees.
     *
     * @return the number of l f activity state trees
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFACTIVITYSTATETREE);

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
     * Initializes the l f activity state tree persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFActivityStateTree")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFActivityStateTree>> listenersList = new ArrayList<ModelListener<LFActivityStateTree>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFActivityStateTree>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFActivityStateTreeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
