package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsState;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateModelImpl;
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
 * The persistence implementation for the l f tincan lrs state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatePersistence
 * @see LFTincanLrsStateUtil
 * @generated
 */
public class LFTincanLrsStatePersistenceImpl extends BasePersistenceImpl<LFTincanLrsState>
    implements LFTincanLrsStatePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsStateUtil} to access the l f tincan lrs state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsStateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYID =
        new FinderPath(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByActivityId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID =
        new FinderPath(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActivityId",
            new String[] { String.class.getName() },
            LFTincanLrsStateModelImpl.ACTIVITYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYID = new FinderPath(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActivityId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYIDANDSTATEID =
        new FinderPath(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByActivityIdAndStateId",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYIDANDSTATEID =
        new FinderPath(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByActivityIdAndStateId",
            new String[] { String.class.getName(), String.class.getName() },
            LFTincanLrsStateModelImpl.ACTIVITYID_COLUMN_BITMASK |
            LFTincanLrsStateModelImpl.STATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYIDANDSTATEID = new FinderPath(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByActivityIdAndStateId",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSSTATE = "SELECT lfTincanLrsState FROM LFTincanLrsState lfTincanLrsState";
    private static final String _SQL_SELECT_LFTINCANLRSSTATE_WHERE = "SELECT lfTincanLrsState FROM LFTincanLrsState lfTincanLrsState WHERE ";
    private static final String _SQL_COUNT_LFTINCANLRSSTATE = "SELECT COUNT(lfTincanLrsState) FROM LFTincanLrsState lfTincanLrsState";
    private static final String _SQL_COUNT_LFTINCANLRSSTATE_WHERE = "SELECT COUNT(lfTincanLrsState) FROM LFTincanLrsState lfTincanLrsState WHERE ";
    private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_1 = "lfTincanLrsState.activityId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_NULL = "lfTincanLrsState.activityId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_NULL_2 = "lfTincanLrsState.activityId IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2 = "lfTincanLrsState.activityId = ?";
    private static final String _FINDER_COLUMN_ACTIVITYID_ACTIVITYID_3 = "(lfTincanLrsState.activityId IS NULL OR lfTincanLrsState.activityId = ?)";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_1 =
        "lfTincanLrsState.activityId IS NULL AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_NULL =
        "lfTincanLrsState.activityId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_NULL_2 =
        "lfTincanLrsState.activityId IS NULL  AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_2 =
        "lfTincanLrsState.activityId = ? AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_3 =
        "(lfTincanLrsState.activityId IS NULL OR lfTincanLrsState.activityId = ?) AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_1 = "lfTincanLrsState.stateId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_NULL =
        "lfTincanLrsState.stateId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_NULL_2 =
        "lfTincanLrsState.stateId IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_2 = "lfTincanLrsState.stateId = ?";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_3 = "(lfTincanLrsState.stateId IS NULL OR lfTincanLrsState.stateId = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsState.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsState exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanLrsState exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsStatePersistenceImpl.class);
    private static LFTincanLrsState _nullLFTincanLrsState = new LFTincanLrsStateImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsState> toCacheModel() {
                return _nullLFTincanLrsStateCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsState> _nullLFTincanLrsStateCacheModel = new CacheModel<LFTincanLrsState>() {
            public LFTincanLrsState toEntityModel() {
                return _nullLFTincanLrsState;
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
     * Caches the l f tincan lrs state in the entity cache if it is enabled.
     *
     * @param lfTincanLrsState the l f tincan lrs state
     */
    public void cacheResult(LFTincanLrsState lfTincanLrsState) {
        EntityCacheUtil.putResult(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateImpl.class, lfTincanLrsState.getPrimaryKey(),
            lfTincanLrsState);

        lfTincanLrsState.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs states in the entity cache if it is enabled.
     *
     * @param lfTincanLrsStates the l f tincan lrs states
     */
    public void cacheResult(List<LFTincanLrsState> lfTincanLrsStates) {
        for (LFTincanLrsState lfTincanLrsState : lfTincanLrsStates) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsStateImpl.class,
                        lfTincanLrsState.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsState);
            } else {
                lfTincanLrsState.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs states.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsStateImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsStateImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs state.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanLrsState lfTincanLrsState) {
        EntityCacheUtil.removeResult(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateImpl.class, lfTincanLrsState.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFTincanLrsState> lfTincanLrsStates) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsState lfTincanLrsState : lfTincanLrsStates) {
            EntityCacheUtil.removeResult(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsStateImpl.class, lfTincanLrsState.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f tincan lrs state with the primary key. Does not add the l f tincan lrs state to the database.
     *
     * @param id the primary key for the new l f tincan lrs state
     * @return the new l f tincan lrs state
     */
    public LFTincanLrsState create(long id) {
        LFTincanLrsState lfTincanLrsState = new LFTincanLrsStateImpl();

        lfTincanLrsState.setNew(true);
        lfTincanLrsState.setPrimaryKey(id);

        return lfTincanLrsState;
    }

    /**
     * Removes the l f tincan lrs state with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs state
     * @return the l f tincan lrs state that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a l f tincan lrs state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState remove(long id)
        throws NoSuchLFTincanLrsStateException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f tincan lrs state with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs state
     * @return the l f tincan lrs state that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a l f tincan lrs state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsState remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsStateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsState lfTincanLrsState = (LFTincanLrsState) session.get(LFTincanLrsStateImpl.class,
                    primaryKey);

            if (lfTincanLrsState == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsState);
        } catch (NoSuchLFTincanLrsStateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsState removeImpl(LFTincanLrsState lfTincanLrsState)
        throws SystemException {
        lfTincanLrsState = toUnwrappedModel(lfTincanLrsState);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfTincanLrsState);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfTincanLrsState);

        return lfTincanLrsState;
    }

    @Override
    public LFTincanLrsState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsState lfTincanLrsState,
        boolean merge) throws SystemException {
        lfTincanLrsState = toUnwrappedModel(lfTincanLrsState);

        boolean isNew = lfTincanLrsState.isNew();

        LFTincanLrsStateModelImpl lfTincanLrsStateModelImpl = (LFTincanLrsStateModelImpl) lfTincanLrsState;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfTincanLrsState, merge);

            lfTincanLrsState.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanLrsStateModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanLrsStateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanLrsStateModelImpl.getOriginalActivityId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
                    args);

                args = new Object[] { lfTincanLrsStateModelImpl.getActivityId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID,
                    args);
            }

            if ((lfTincanLrsStateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYIDANDSTATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanLrsStateModelImpl.getOriginalActivityId(),
                        
                        lfTincanLrsStateModelImpl.getOriginalStateId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDSTATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYIDANDSTATEID,
                    args);

                args = new Object[] {
                        lfTincanLrsStateModelImpl.getActivityId(),
                        
                        lfTincanLrsStateModelImpl.getStateId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDSTATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYIDANDSTATEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStateImpl.class, lfTincanLrsState.getPrimaryKey(),
            lfTincanLrsState);

        return lfTincanLrsState;
    }

    protected LFTincanLrsState toUnwrappedModel(
        LFTincanLrsState lfTincanLrsState) {
        if (lfTincanLrsState instanceof LFTincanLrsStateImpl) {
            return lfTincanLrsState;
        }

        LFTincanLrsStateImpl lfTincanLrsStateImpl = new LFTincanLrsStateImpl();

        lfTincanLrsStateImpl.setNew(lfTincanLrsState.isNew());
        lfTincanLrsStateImpl.setPrimaryKey(lfTincanLrsState.getPrimaryKey());

        lfTincanLrsStateImpl.setId(lfTincanLrsState.getId());
        lfTincanLrsStateImpl.setStateId(lfTincanLrsState.getStateId());
        lfTincanLrsStateImpl.setDocumentId(lfTincanLrsState.getDocumentId());
        lfTincanLrsStateImpl.setActivityId(lfTincanLrsState.getActivityId());
        lfTincanLrsStateImpl.setProfileId(lfTincanLrsState.getProfileId());
        lfTincanLrsStateImpl.setRegistration(lfTincanLrsState.getRegistration());
        lfTincanLrsStateImpl.setAgentId(lfTincanLrsState.getAgentId());

        return lfTincanLrsStateImpl;
    }

    /**
     * Returns the l f tincan lrs state with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs state
     * @return the l f tincan lrs state
     * @throws com.liferay.portal.NoSuchModelException if a l f tincan lrs state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsState findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs state
     * @return the l f tincan lrs state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a l f tincan lrs state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsStateException, SystemException {
        LFTincanLrsState lfTincanLrsState = fetchByPrimaryKey(id);

        if (lfTincanLrsState == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFTincanLrsStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfTincanLrsState;
    }

    /**
     * Returns the l f tincan lrs state with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs state
     * @return the l f tincan lrs state, or <code>null</code> if a l f tincan lrs state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsState fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs state with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs state
     * @return the l f tincan lrs state, or <code>null</code> if a l f tincan lrs state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState fetchByPrimaryKey(long id)
        throws SystemException {
        LFTincanLrsState lfTincanLrsState = (LFTincanLrsState) EntityCacheUtil.getResult(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsStateImpl.class, id);

        if (lfTincanLrsState == _nullLFTincanLrsState) {
            return null;
        }

        if (lfTincanLrsState == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfTincanLrsState = (LFTincanLrsState) session.get(LFTincanLrsStateImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfTincanLrsState != null) {
                    cacheResult(lfTincanLrsState);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFTincanLrsStateModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsStateImpl.class, id, _nullLFTincanLrsState);
                }

                closeSession(session);
            }
        }

        return lfTincanLrsState;
    }

    /**
     * Returns all the l f tincan lrs states where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @return the matching l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsState> findByActivityId(String activityId)
        throws SystemException {
        return findByActivityId(activityId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs states where activityId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityId the activity ID
     * @param start the lower bound of the range of l f tincan lrs states
     * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
     * @return the range of matching l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsState> findByActivityId(String activityId,
        int start, int end) throws SystemException {
        return findByActivityId(activityId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs states where activityId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityId the activity ID
     * @param start the lower bound of the range of l f tincan lrs states
     * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsState> findByActivityId(String activityId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYID;
            finderArgs = new Object[] { activityId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYID;
            finderArgs = new Object[] { activityId, start, end, orderByComparator };
        }

        List<LFTincanLrsState> list = (List<LFTincanLrsState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanLrsState lfTincanLrsState : list) {
                if (!Validator.equals(activityId,
                            lfTincanLrsState.getActivityId())) {
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

            query.append(_SQL_SELECT_LFTINCANLRSSTATE_WHERE);

            if (activityId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_1);
            } else {
                if (activityId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_2);
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

                if (activityId != null) {
                    qPos.add(activityId);
                }

                list = (List<LFTincanLrsState>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f tincan lrs state in the ordered set where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a matching l f tincan lrs state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState findByActivityId_First(String activityId,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStateException, SystemException {
        LFTincanLrsState lfTincanLrsState = fetchByActivityId_First(activityId,
                orderByComparator);

        if (lfTincanLrsState != null) {
            return lfTincanLrsState;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityId=");
        msg.append(activityId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsStateException(msg.toString());
    }

    /**
     * Returns the first l f tincan lrs state in the ordered set where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState fetchByActivityId_First(String activityId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanLrsState> list = findByActivityId(activityId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan lrs state in the ordered set where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a matching l f tincan lrs state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState findByActivityId_Last(String activityId,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStateException, SystemException {
        LFTincanLrsState lfTincanLrsState = fetchByActivityId_Last(activityId,
                orderByComparator);

        if (lfTincanLrsState != null) {
            return lfTincanLrsState;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityId=");
        msg.append(activityId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsStateException(msg.toString());
    }

    /**
     * Returns the last l f tincan lrs state in the ordered set where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState fetchByActivityId_Last(String activityId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByActivityId(activityId);

        List<LFTincanLrsState> list = findByActivityId(activityId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan lrs states before and after the current l f tincan lrs state in the ordered set where activityId = &#63;.
     *
     * @param id the primary key of the current l f tincan lrs state
     * @param activityId the activity ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan lrs state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a l f tincan lrs state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState[] findByActivityId_PrevAndNext(long id,
        String activityId, OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStateException, SystemException {
        LFTincanLrsState lfTincanLrsState = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanLrsState[] array = new LFTincanLrsStateImpl[3];

            array[0] = getByActivityId_PrevAndNext(session, lfTincanLrsState,
                    activityId, orderByComparator, true);

            array[1] = lfTincanLrsState;

            array[2] = getByActivityId_PrevAndNext(session, lfTincanLrsState,
                    activityId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanLrsState getByActivityId_PrevAndNext(Session session,
        LFTincanLrsState lfTincanLrsState, String activityId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANLRSSTATE_WHERE);

        if (activityId == null) {
            query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_1);
        } else {
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
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (activityId != null) {
            qPos.add(activityId);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanLrsState);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanLrsState> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f tincan lrs states where activityId = &#63; and stateId = &#63;.
     *
     * @param activityId the activity ID
     * @param stateId the state ID
     * @return the matching l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsState> findByActivityIdAndStateId(
        String activityId, String stateId) throws SystemException {
        return findByActivityIdAndStateId(activityId, stateId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs states where activityId = &#63; and stateId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityId the activity ID
     * @param stateId the state ID
     * @param start the lower bound of the range of l f tincan lrs states
     * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
     * @return the range of matching l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsState> findByActivityIdAndStateId(
        String activityId, String stateId, int start, int end)
        throws SystemException {
        return findByActivityIdAndStateId(activityId, stateId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs states where activityId = &#63; and stateId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityId the activity ID
     * @param stateId the state ID
     * @param start the lower bound of the range of l f tincan lrs states
     * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsState> findByActivityIdAndStateId(
        String activityId, String stateId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYIDANDSTATEID;
            finderArgs = new Object[] { activityId, stateId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYIDANDSTATEID;
            finderArgs = new Object[] {
                    activityId, stateId,
                    
                    start, end, orderByComparator
                };
        }

        List<LFTincanLrsState> list = (List<LFTincanLrsState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanLrsState lfTincanLrsState : list) {
                if (!Validator.equals(activityId,
                            lfTincanLrsState.getActivityId()) ||
                        !Validator.equals(stateId, lfTincanLrsState.getStateId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_LFTINCANLRSSTATE_WHERE);

            if (activityId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_1);
            } else {
                if (activityId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_2);
                }
            }

            if (stateId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_1);
            } else {
                if (stateId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_2);
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

                if (activityId != null) {
                    qPos.add(activityId);
                }

                if (stateId != null) {
                    qPos.add(stateId);
                }

                list = (List<LFTincanLrsState>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
     *
     * @param activityId the activity ID
     * @param stateId the state ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a matching l f tincan lrs state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState findByActivityIdAndStateId_First(
        String activityId, String stateId, OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStateException, SystemException {
        LFTincanLrsState lfTincanLrsState = fetchByActivityIdAndStateId_First(activityId,
                stateId, orderByComparator);

        if (lfTincanLrsState != null) {
            return lfTincanLrsState;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityId=");
        msg.append(activityId);

        msg.append(", stateId=");
        msg.append(stateId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsStateException(msg.toString());
    }

    /**
     * Returns the first l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
     *
     * @param activityId the activity ID
     * @param stateId the state ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState fetchByActivityIdAndStateId_First(
        String activityId, String stateId, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFTincanLrsState> list = findByActivityIdAndStateId(activityId,
                stateId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
     *
     * @param activityId the activity ID
     * @param stateId the state ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a matching l f tincan lrs state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState findByActivityIdAndStateId_Last(String activityId,
        String stateId, OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStateException, SystemException {
        LFTincanLrsState lfTincanLrsState = fetchByActivityIdAndStateId_Last(activityId,
                stateId, orderByComparator);

        if (lfTincanLrsState != null) {
            return lfTincanLrsState;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityId=");
        msg.append(activityId);

        msg.append(", stateId=");
        msg.append(stateId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsStateException(msg.toString());
    }

    /**
     * Returns the last l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
     *
     * @param activityId the activity ID
     * @param stateId the state ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs state, or <code>null</code> if a matching l f tincan lrs state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState fetchByActivityIdAndStateId_Last(
        String activityId, String stateId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByActivityIdAndStateId(activityId, stateId);

        List<LFTincanLrsState> list = findByActivityIdAndStateId(activityId,
                stateId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan lrs states before and after the current l f tincan lrs state in the ordered set where activityId = &#63; and stateId = &#63;.
     *
     * @param id the primary key of the current l f tincan lrs state
     * @param activityId the activity ID
     * @param stateId the state ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan lrs state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException if a l f tincan lrs state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsState[] findByActivityIdAndStateId_PrevAndNext(long id,
        String activityId, String stateId, OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStateException, SystemException {
        LFTincanLrsState lfTincanLrsState = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanLrsState[] array = new LFTincanLrsStateImpl[3];

            array[0] = getByActivityIdAndStateId_PrevAndNext(session,
                    lfTincanLrsState, activityId, stateId, orderByComparator,
                    true);

            array[1] = lfTincanLrsState;

            array[2] = getByActivityIdAndStateId_PrevAndNext(session,
                    lfTincanLrsState, activityId, stateId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanLrsState getByActivityIdAndStateId_PrevAndNext(
        Session session, LFTincanLrsState lfTincanLrsState, String activityId,
        String stateId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANLRSSTATE_WHERE);

        if (activityId == null) {
            query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_1);
        } else {
            if (activityId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_3);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_2);
            }
        }

        if (stateId == null) {
            query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_1);
        } else {
            if (stateId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_3);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_2);
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

        if (activityId != null) {
            qPos.add(activityId);
        }

        if (stateId != null) {
            qPos.add(stateId);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanLrsState);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanLrsState> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f tincan lrs states.
     *
     * @return the l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsState> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs states.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs states
     * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
     * @return the range of l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsState> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs states.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs states
     * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsState> findAll(int start, int end,
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

        List<LFTincanLrsState> list = (List<LFTincanLrsState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSSTATE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSSTATE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFTincanLrsState>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFTincanLrsState>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs states where activityId = &#63; from the database.
     *
     * @param activityId the activity ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByActivityId(String activityId) throws SystemException {
        for (LFTincanLrsState lfTincanLrsState : findByActivityId(activityId)) {
            remove(lfTincanLrsState);
        }
    }

    /**
     * Removes all the l f tincan lrs states where activityId = &#63; and stateId = &#63; from the database.
     *
     * @param activityId the activity ID
     * @param stateId the state ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByActivityIdAndStateId(String activityId, String stateId)
        throws SystemException {
        for (LFTincanLrsState lfTincanLrsState : findByActivityIdAndStateId(
                activityId, stateId)) {
            remove(lfTincanLrsState);
        }
    }

    /**
     * Removes all the l f tincan lrs states from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFTincanLrsState lfTincanLrsState : findAll()) {
            remove(lfTincanLrsState);
        }
    }

    /**
     * Returns the number of l f tincan lrs states where activityId = &#63;.
     *
     * @param activityId the activity ID
     * @return the number of matching l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public int countByActivityId(String activityId) throws SystemException {
        Object[] finderArgs = new Object[] { activityId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVITYID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANLRSSTATE_WHERE);

            if (activityId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYID_ACTIVITYID_1);
            } else {
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

                if (activityId != null) {
                    qPos.add(activityId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan lrs states where activityId = &#63; and stateId = &#63;.
     *
     * @param activityId the activity ID
     * @param stateId the state ID
     * @return the number of matching l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public int countByActivityIdAndStateId(String activityId, String stateId)
        throws SystemException {
        Object[] finderArgs = new Object[] { activityId, stateId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDSTATEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFTINCANLRSSTATE_WHERE);

            if (activityId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_1);
            } else {
                if (activityId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_ACTIVITYID_2);
                }
            }

            if (stateId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_1);
            } else {
                if (stateId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDSTATEID_STATEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (activityId != null) {
                    qPos.add(activityId);
                }

                if (stateId != null) {
                    qPos.add(stateId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDSTATEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan lrs states.
     *
     * @return the number of l f tincan lrs states
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSSTATE);

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
     * Initializes the l f tincan lrs state persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsState")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsState>> listenersList = new ArrayList<ModelListener<LFTincanLrsState>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsState>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsStateImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
