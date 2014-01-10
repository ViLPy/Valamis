package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAgentProfileImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAgentProfileModelImpl;
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
 * The persistence implementation for the l f tincan lrs agent profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsAgentProfilePersistence
 * @see LFTincanLrsAgentProfileUtil
 * @generated
 */
public class LFTincanLrsAgentProfilePersistenceImpl extends BasePersistenceImpl<LFTincanLrsAgentProfile>
    implements LFTincanLrsAgentProfilePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsAgentProfileUtil} to access the l f tincan lrs agent profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsAgentProfileImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROFILEID =
        new FinderPath(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAgentProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsAgentProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProfileId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROFILEID =
        new FinderPath(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAgentProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsAgentProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProfileId",
            new String[] { String.class.getName() },
            LFTincanLrsAgentProfileModelImpl.PROFILEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PROFILEID = new FinderPath(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAgentProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProfileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_AGENTIDANDPROFILEID = new FinderPath(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAgentProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsAgentProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByAgentIdAndProfileId",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFTincanLrsAgentProfileModelImpl.AGENTID_COLUMN_BITMASK |
            LFTincanLrsAgentProfileModelImpl.PROFILEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_AGENTIDANDPROFILEID = new FinderPath(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAgentProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByAgentIdAndProfileId",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAgentProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsAgentProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAgentProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsAgentProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAgentProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSAGENTPROFILE = "SELECT lfTincanLrsAgentProfile FROM LFTincanLrsAgentProfile lfTincanLrsAgentProfile";
    private static final String _SQL_SELECT_LFTINCANLRSAGENTPROFILE_WHERE = "SELECT lfTincanLrsAgentProfile FROM LFTincanLrsAgentProfile lfTincanLrsAgentProfile WHERE ";
    private static final String _SQL_COUNT_LFTINCANLRSAGENTPROFILE = "SELECT COUNT(lfTincanLrsAgentProfile) FROM LFTincanLrsAgentProfile lfTincanLrsAgentProfile";
    private static final String _SQL_COUNT_LFTINCANLRSAGENTPROFILE_WHERE = "SELECT COUNT(lfTincanLrsAgentProfile) FROM LFTincanLrsAgentProfile lfTincanLrsAgentProfile WHERE ";
    private static final String _FINDER_COLUMN_PROFILEID_PROFILEID_1 = "lfTincanLrsAgentProfile.profileId IS NULL";
    private static final String _FINDER_COLUMN_PROFILEID_PROFILEID_NULL = "lfTincanLrsAgentProfile.profileId IS NULL";
    private static final String _FINDER_COLUMN_PROFILEID_PROFILEID_NULL_2 = "lfTincanLrsAgentProfile.profileId IS NULL ";
    private static final String _FINDER_COLUMN_PROFILEID_PROFILEID_2 = "lfTincanLrsAgentProfile.profileId = ?";
    private static final String _FINDER_COLUMN_PROFILEID_PROFILEID_3 = "(lfTincanLrsAgentProfile.profileId IS NULL OR lfTincanLrsAgentProfile.profileId = ?)";
    private static final String _FINDER_COLUMN_AGENTIDANDPROFILEID_AGENTID_NULL = "lfTincanLrsAgentProfile.agentId IS NULL";
    private static final String _FINDER_COLUMN_AGENTIDANDPROFILEID_AGENTID_NULL_2 =
        "lfTincanLrsAgentProfile.agentId IS NULL  AND ";
    private static final String _FINDER_COLUMN_AGENTIDANDPROFILEID_AGENTID_2 = "lfTincanLrsAgentProfile.agentId = ? AND ";
    private static final String _FINDER_COLUMN_AGENTIDANDPROFILEID_PROFILEID_1 = "lfTincanLrsAgentProfile.profileId IS NULL";
    private static final String _FINDER_COLUMN_AGENTIDANDPROFILEID_PROFILEID_NULL =
        "lfTincanLrsAgentProfile.profileId IS NULL";
    private static final String _FINDER_COLUMN_AGENTIDANDPROFILEID_PROFILEID_NULL_2 =
        "lfTincanLrsAgentProfile.profileId IS NULL ";
    private static final String _FINDER_COLUMN_AGENTIDANDPROFILEID_PROFILEID_2 = "lfTincanLrsAgentProfile.profileId = ?";
    private static final String _FINDER_COLUMN_AGENTIDANDPROFILEID_PROFILEID_3 = "(lfTincanLrsAgentProfile.profileId IS NULL OR lfTincanLrsAgentProfile.profileId = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsAgentProfile.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsAgentProfile exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanLrsAgentProfile exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsAgentProfilePersistenceImpl.class);
    private static LFTincanLrsAgentProfile _nullLFTincanLrsAgentProfile = new LFTincanLrsAgentProfileImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsAgentProfile> toCacheModel() {
                return _nullLFTincanLrsAgentProfileCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsAgentProfile> _nullLFTincanLrsAgentProfileCacheModel =
        new CacheModel<LFTincanLrsAgentProfile>() {
            public LFTincanLrsAgentProfile toEntityModel() {
                return _nullLFTincanLrsAgentProfile;
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
     * Caches the l f tincan lrs agent profile in the entity cache if it is enabled.
     *
     * @param lfTincanLrsAgentProfile the l f tincan lrs agent profile
     */
    public void cacheResult(LFTincanLrsAgentProfile lfTincanLrsAgentProfile) {
        EntityCacheUtil.putResult(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAgentProfileImpl.class,
            lfTincanLrsAgentProfile.getPrimaryKey(), lfTincanLrsAgentProfile);

        boolean noNullsInAGENTIDANDPROFILEID = true;

        if (lfTincanLrsAgentProfile.getAgentId() == null) {
            noNullsInAGENTIDANDPROFILEID = false;
        }

        if (noNullsInAGENTIDANDPROFILEID) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AGENTIDANDPROFILEID,
                new Object[] {
                    Integer.valueOf(lfTincanLrsAgentProfile.getAgentId()),
                    
                lfTincanLrsAgentProfile.getProfileId()
                }, lfTincanLrsAgentProfile);
        }

        lfTincanLrsAgentProfile.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs agent profiles in the entity cache if it is enabled.
     *
     * @param lfTincanLrsAgentProfiles the l f tincan lrs agent profiles
     */
    public void cacheResult(
        List<LFTincanLrsAgentProfile> lfTincanLrsAgentProfiles) {
        for (LFTincanLrsAgentProfile lfTincanLrsAgentProfile : lfTincanLrsAgentProfiles) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsAgentProfileImpl.class,
                        lfTincanLrsAgentProfile.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsAgentProfile);
            } else {
                lfTincanLrsAgentProfile.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs agent profiles.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsAgentProfileImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsAgentProfileImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs agent profile.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanLrsAgentProfile lfTincanLrsAgentProfile) {
        EntityCacheUtil.removeResult(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAgentProfileImpl.class,
            lfTincanLrsAgentProfile.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanLrsAgentProfile);
    }

    @Override
    public void clearCache(
        List<LFTincanLrsAgentProfile> lfTincanLrsAgentProfiles) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsAgentProfile lfTincanLrsAgentProfile : lfTincanLrsAgentProfiles) {
            EntityCacheUtil.removeResult(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsAgentProfileImpl.class,
                lfTincanLrsAgentProfile.getPrimaryKey());

            clearUniqueFindersCache(lfTincanLrsAgentProfile);
        }
    }

    protected void clearUniqueFindersCache(
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile) {
        boolean noNullsInAGENTIDANDPROFILEID = true;

        if (lfTincanLrsAgentProfile.getAgentId() == null) {
            noNullsInAGENTIDANDPROFILEID = false;
        }

        if (noNullsInAGENTIDANDPROFILEID) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_AGENTIDANDPROFILEID,
                new Object[] {
                    Integer.valueOf(lfTincanLrsAgentProfile.getAgentId()),
                    
                lfTincanLrsAgentProfile.getProfileId()
                });
        }
    }

    /**
     * Creates a new l f tincan lrs agent profile with the primary key. Does not add the l f tincan lrs agent profile to the database.
     *
     * @param id the primary key for the new l f tincan lrs agent profile
     * @return the new l f tincan lrs agent profile
     */
    public LFTincanLrsAgentProfile create(long id) {
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile = new LFTincanLrsAgentProfileImpl();

        lfTincanLrsAgentProfile.setNew(true);
        lfTincanLrsAgentProfile.setPrimaryKey(id);

        return lfTincanLrsAgentProfile;
    }

    /**
     * Removes the l f tincan lrs agent profile with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs agent profile
     * @return the l f tincan lrs agent profile that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a l f tincan lrs agent profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile remove(long id)
        throws NoSuchLFTincanLrsAgentProfileException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f tincan lrs agent profile with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs agent profile
     * @return the l f tincan lrs agent profile that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a l f tincan lrs agent profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsAgentProfile remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsAgentProfileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsAgentProfile lfTincanLrsAgentProfile = (LFTincanLrsAgentProfile) session.get(LFTincanLrsAgentProfileImpl.class,
                    primaryKey);

            if (lfTincanLrsAgentProfile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsAgentProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsAgentProfile);
        } catch (NoSuchLFTincanLrsAgentProfileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsAgentProfile removeImpl(
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile)
        throws SystemException {
        lfTincanLrsAgentProfile = toUnwrappedModel(lfTincanLrsAgentProfile);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfTincanLrsAgentProfile);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfTincanLrsAgentProfile);

        return lfTincanLrsAgentProfile;
    }

    @Override
    public LFTincanLrsAgentProfile updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile lfTincanLrsAgentProfile,
        boolean merge) throws SystemException {
        lfTincanLrsAgentProfile = toUnwrappedModel(lfTincanLrsAgentProfile);

        boolean isNew = lfTincanLrsAgentProfile.isNew();

        LFTincanLrsAgentProfileModelImpl lfTincanLrsAgentProfileModelImpl = (LFTincanLrsAgentProfileModelImpl) lfTincanLrsAgentProfile;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfTincanLrsAgentProfile, merge);

            lfTincanLrsAgentProfile.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanLrsAgentProfileModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanLrsAgentProfileModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROFILEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanLrsAgentProfileModelImpl.getOriginalProfileId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROFILEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROFILEID,
                    args);

                args = new Object[] {
                        lfTincanLrsAgentProfileModelImpl.getProfileId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROFILEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROFILEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAgentProfileImpl.class,
            lfTincanLrsAgentProfile.getPrimaryKey(), lfTincanLrsAgentProfile);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AGENTIDANDPROFILEID,
                new Object[] {
                    /*Integer.valueOf( */
                lfTincanLrsAgentProfile.getAgentId(),
                    
                lfTincanLrsAgentProfile.getProfileId()
                }, lfTincanLrsAgentProfile);
        } else {
            if ((lfTincanLrsAgentProfileModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_AGENTIDANDPROFILEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /*        Integer.valueOf( */
                        lfTincanLrsAgentProfileModelImpl.getOriginalAgentId(),
                        
                        lfTincanLrsAgentProfileModelImpl.getOriginalProfileId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AGENTIDANDPROFILEID,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_AGENTIDANDPROFILEID,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AGENTIDANDPROFILEID,
                    new Object[] {
                        /*        Integer.valueOf( */
                    lfTincanLrsAgentProfile.getAgentId(),
                        
                    lfTincanLrsAgentProfile.getProfileId()
                    }, lfTincanLrsAgentProfile);
            }
        }

        return lfTincanLrsAgentProfile;
    }

    protected LFTincanLrsAgentProfile toUnwrappedModel(
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile) {
        if (lfTincanLrsAgentProfile instanceof LFTincanLrsAgentProfileImpl) {
            return lfTincanLrsAgentProfile;
        }

        LFTincanLrsAgentProfileImpl lfTincanLrsAgentProfileImpl = new LFTincanLrsAgentProfileImpl();

        lfTincanLrsAgentProfileImpl.setNew(lfTincanLrsAgentProfile.isNew());
        lfTincanLrsAgentProfileImpl.setPrimaryKey(lfTincanLrsAgentProfile.getPrimaryKey());

        lfTincanLrsAgentProfileImpl.setId(lfTincanLrsAgentProfile.getId());
        lfTincanLrsAgentProfileImpl.setDocumentId(lfTincanLrsAgentProfile.getDocumentId());
        lfTincanLrsAgentProfileImpl.setAgentId(lfTincanLrsAgentProfile.getAgentId());
        lfTincanLrsAgentProfileImpl.setProfileId(lfTincanLrsAgentProfile.getProfileId());

        return lfTincanLrsAgentProfileImpl;
    }

    /**
     * Returns the l f tincan lrs agent profile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs agent profile
     * @return the l f tincan lrs agent profile
     * @throws com.liferay.portal.NoSuchModelException if a l f tincan lrs agent profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsAgentProfile findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs agent profile with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs agent profile
     * @return the l f tincan lrs agent profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a l f tincan lrs agent profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsAgentProfileException, SystemException {
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile = fetchByPrimaryKey(id);

        if (lfTincanLrsAgentProfile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFTincanLrsAgentProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfTincanLrsAgentProfile;
    }

    /**
     * Returns the l f tincan lrs agent profile with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs agent profile
     * @return the l f tincan lrs agent profile, or <code>null</code> if a l f tincan lrs agent profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsAgentProfile fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs agent profile with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs agent profile
     * @return the l f tincan lrs agent profile, or <code>null</code> if a l f tincan lrs agent profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile fetchByPrimaryKey(long id)
        throws SystemException {
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile = (LFTincanLrsAgentProfile) EntityCacheUtil.getResult(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsAgentProfileImpl.class, id);

        if (lfTincanLrsAgentProfile == _nullLFTincanLrsAgentProfile) {
            return null;
        }

        if (lfTincanLrsAgentProfile == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfTincanLrsAgentProfile = (LFTincanLrsAgentProfile) session.get(LFTincanLrsAgentProfileImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfTincanLrsAgentProfile != null) {
                    cacheResult(lfTincanLrsAgentProfile);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFTincanLrsAgentProfileModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsAgentProfileImpl.class, id,
                        _nullLFTincanLrsAgentProfile);
                }

                closeSession(session);
            }
        }

        return lfTincanLrsAgentProfile;
    }

    /**
     * Returns all the l f tincan lrs agent profiles where profileId = &#63;.
     *
     * @param profileId the profile ID
     * @return the matching l f tincan lrs agent profiles
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAgentProfile> findByProfileId(String profileId)
        throws SystemException {
        return findByProfileId(profileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan lrs agent profiles where profileId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param profileId the profile ID
     * @param start the lower bound of the range of l f tincan lrs agent profiles
     * @param end the upper bound of the range of l f tincan lrs agent profiles (not inclusive)
     * @return the range of matching l f tincan lrs agent profiles
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAgentProfile> findByProfileId(String profileId,
        int start, int end) throws SystemException {
        return findByProfileId(profileId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs agent profiles where profileId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param profileId the profile ID
     * @param start the lower bound of the range of l f tincan lrs agent profiles
     * @param end the upper bound of the range of l f tincan lrs agent profiles (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan lrs agent profiles
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAgentProfile> findByProfileId(String profileId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROFILEID;
            finderArgs = new Object[] { profileId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROFILEID;
            finderArgs = new Object[] { profileId, start, end, orderByComparator };
        }

        List<LFTincanLrsAgentProfile> list = (List<LFTincanLrsAgentProfile>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanLrsAgentProfile lfTincanLrsAgentProfile : list) {
                if (!Validator.equals(profileId,
                            lfTincanLrsAgentProfile.getProfileId())) {
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

            query.append(_SQL_SELECT_LFTINCANLRSAGENTPROFILE_WHERE);

            if (profileId == null) {
                query.append(_FINDER_COLUMN_PROFILEID_PROFILEID_1);
            } else {
                if (profileId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PROFILEID_PROFILEID_3);
                } else {
                    query.append(_FINDER_COLUMN_PROFILEID_PROFILEID_2);
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

                if (profileId != null) {
                    qPos.add(profileId);
                }

                list = (List<LFTincanLrsAgentProfile>) QueryUtil.list(q,
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
     * Returns the first l f tincan lrs agent profile in the ordered set where profileId = &#63;.
     *
     * @param profileId the profile ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs agent profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a matching l f tincan lrs agent profile could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile findByProfileId_First(String profileId,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsAgentProfileException, SystemException {
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile = fetchByProfileId_First(profileId,
                orderByComparator);

        if (lfTincanLrsAgentProfile != null) {
            return lfTincanLrsAgentProfile;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("profileId=");
        msg.append(profileId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsAgentProfileException(msg.toString());
    }

    /**
     * Returns the first l f tincan lrs agent profile in the ordered set where profileId = &#63;.
     *
     * @param profileId the profile ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs agent profile, or <code>null</code> if a matching l f tincan lrs agent profile could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile fetchByProfileId_First(String profileId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanLrsAgentProfile> list = findByProfileId(profileId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan lrs agent profile in the ordered set where profileId = &#63;.
     *
     * @param profileId the profile ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs agent profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a matching l f tincan lrs agent profile could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile findByProfileId_Last(String profileId,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsAgentProfileException, SystemException {
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile = fetchByProfileId_Last(profileId,
                orderByComparator);

        if (lfTincanLrsAgentProfile != null) {
            return lfTincanLrsAgentProfile;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("profileId=");
        msg.append(profileId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsAgentProfileException(msg.toString());
    }

    /**
     * Returns the last l f tincan lrs agent profile in the ordered set where profileId = &#63;.
     *
     * @param profileId the profile ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs agent profile, or <code>null</code> if a matching l f tincan lrs agent profile could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile fetchByProfileId_Last(String profileId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByProfileId(profileId);

        List<LFTincanLrsAgentProfile> list = findByProfileId(profileId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan lrs agent profiles before and after the current l f tincan lrs agent profile in the ordered set where profileId = &#63;.
     *
     * @param id the primary key of the current l f tincan lrs agent profile
     * @param profileId the profile ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan lrs agent profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a l f tincan lrs agent profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile[] findByProfileId_PrevAndNext(long id,
        String profileId, OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsAgentProfileException, SystemException {
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanLrsAgentProfile[] array = new LFTincanLrsAgentProfileImpl[3];

            array[0] = getByProfileId_PrevAndNext(session,
                    lfTincanLrsAgentProfile, profileId, orderByComparator, true);

            array[1] = lfTincanLrsAgentProfile;

            array[2] = getByProfileId_PrevAndNext(session,
                    lfTincanLrsAgentProfile, profileId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanLrsAgentProfile getByProfileId_PrevAndNext(
        Session session, LFTincanLrsAgentProfile lfTincanLrsAgentProfile,
        String profileId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANLRSAGENTPROFILE_WHERE);

        if (profileId == null) {
            query.append(_FINDER_COLUMN_PROFILEID_PROFILEID_1);
        } else {
            if (profileId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PROFILEID_PROFILEID_3);
            } else {
                query.append(_FINDER_COLUMN_PROFILEID_PROFILEID_2);
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

        if (profileId != null) {
            qPos.add(profileId);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanLrsAgentProfile);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanLrsAgentProfile> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns the l f tincan lrs agent profile where agentId = &#63; and profileId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException} if it could not be found.
     *
     * @param agentId the agent ID
     * @param profileId the profile ID
     * @return the matching l f tincan lrs agent profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a matching l f tincan lrs agent profile could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile findByAgentIdAndProfileId(Integer agentId,
        String profileId)
        throws NoSuchLFTincanLrsAgentProfileException, SystemException {
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile = fetchByAgentIdAndProfileId(agentId,
                profileId);

        if (lfTincanLrsAgentProfile == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("agentId=");
            msg.append(agentId);

            msg.append(", profileId=");
            msg.append(profileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanLrsAgentProfileException(msg.toString());
        }

        return lfTincanLrsAgentProfile;
    }

    /**
     * Returns the l f tincan lrs agent profile where agentId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param agentId the agent ID
     * @param profileId the profile ID
     * @return the matching l f tincan lrs agent profile, or <code>null</code> if a matching l f tincan lrs agent profile could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile fetchByAgentIdAndProfileId(Integer agentId,
        String profileId) throws SystemException {
        return fetchByAgentIdAndProfileId(agentId, profileId, true);
    }

    /**
     * Returns the l f tincan lrs agent profile where agentId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param agentId the agent ID
     * @param profileId the profile ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan lrs agent profile, or <code>null</code> if a matching l f tincan lrs agent profile could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile fetchByAgentIdAndProfileId(Integer agentId,
        String profileId, boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { agentId, profileId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_AGENTIDANDPROFILEID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanLrsAgentProfile) {
            LFTincanLrsAgentProfile lfTincanLrsAgentProfile = (LFTincanLrsAgentProfile) result;

            if (!Validator.equals(agentId, lfTincanLrsAgentProfile.getAgentId()) ||
                    !Validator.equals(profileId,
                        lfTincanLrsAgentProfile.getProfileId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTINCANLRSAGENTPROFILE_WHERE);

            if (agentId == null) {
                query.append(_FINDER_COLUMN_AGENTIDANDPROFILEID_AGENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_AGENTIDANDPROFILEID_AGENTID_2);
            }

            if (profileId == null) {
                query.append(_FINDER_COLUMN_AGENTIDANDPROFILEID_PROFILEID_1);
            } else {
                if (profileId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENTIDANDPROFILEID_PROFILEID_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENTIDANDPROFILEID_PROFILEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (agentId != null) {
                    qPos.add(agentId.intValue());
                }

                if (profileId != null) {
                    qPos.add(profileId);
                }

                List<LFTincanLrsAgentProfile> list = q.list();

                result = list;

                LFTincanLrsAgentProfile lfTincanLrsAgentProfile = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AGENTIDANDPROFILEID,
                        finderArgs, list);
                } else {
                    lfTincanLrsAgentProfile = list.get(0);

                    cacheResult(lfTincanLrsAgentProfile);

                    if ((lfTincanLrsAgentProfile.getAgentId() != agentId) ||
                            (lfTincanLrsAgentProfile.getProfileId() == null) ||
                            !lfTincanLrsAgentProfile.getProfileId()
                                                        .equals(profileId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AGENTIDANDPROFILEID,
                            finderArgs, lfTincanLrsAgentProfile);
                    }
                }

                return lfTincanLrsAgentProfile;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_AGENTIDANDPROFILEID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFTincanLrsAgentProfile) result;
            }
        }
    }

    /**
     * Returns all the l f tincan lrs agent profiles.
     *
     * @return the l f tincan lrs agent profiles
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAgentProfile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs agent profiles.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs agent profiles
     * @param end the upper bound of the range of l f tincan lrs agent profiles (not inclusive)
     * @return the range of l f tincan lrs agent profiles
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAgentProfile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs agent profiles.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs agent profiles
     * @param end the upper bound of the range of l f tincan lrs agent profiles (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs agent profiles
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAgentProfile> findAll(int start, int end,
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

        List<LFTincanLrsAgentProfile> list = (List<LFTincanLrsAgentProfile>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSAGENTPROFILE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSAGENTPROFILE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFTincanLrsAgentProfile>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFTincanLrsAgentProfile>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs agent profiles where profileId = &#63; from the database.
     *
     * @param profileId the profile ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByProfileId(String profileId) throws SystemException {
        for (LFTincanLrsAgentProfile lfTincanLrsAgentProfile : findByProfileId(
                profileId)) {
            remove(lfTincanLrsAgentProfile);
        }
    }

    /**
     * Removes the l f tincan lrs agent profile where agentId = &#63; and profileId = &#63; from the database.
     *
     * @param agentId the agent ID
     * @param profileId the profile ID
     * @return the l f tincan lrs agent profile that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAgentProfile removeByAgentIdAndProfileId(
        Integer agentId, String profileId)
        throws NoSuchLFTincanLrsAgentProfileException, SystemException {
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile = findByAgentIdAndProfileId(agentId,
                profileId);

        return remove(lfTincanLrsAgentProfile);
    }

    /**
     * Removes all the l f tincan lrs agent profiles from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFTincanLrsAgentProfile lfTincanLrsAgentProfile : findAll()) {
            remove(lfTincanLrsAgentProfile);
        }
    }

    /**
     * Returns the number of l f tincan lrs agent profiles where profileId = &#63;.
     *
     * @param profileId the profile ID
     * @return the number of matching l f tincan lrs agent profiles
     * @throws SystemException if a system exception occurred
     */
    public int countByProfileId(String profileId) throws SystemException {
        Object[] finderArgs = new Object[] { profileId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROFILEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANLRSAGENTPROFILE_WHERE);

            if (profileId == null) {
                query.append(_FINDER_COLUMN_PROFILEID_PROFILEID_1);
            } else {
                if (profileId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PROFILEID_PROFILEID_3);
                } else {
                    query.append(_FINDER_COLUMN_PROFILEID_PROFILEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (profileId != null) {
                    qPos.add(profileId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROFILEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan lrs agent profiles where agentId = &#63; and profileId = &#63;.
     *
     * @param agentId the agent ID
     * @param profileId the profile ID
     * @return the number of matching l f tincan lrs agent profiles
     * @throws SystemException if a system exception occurred
     */
    public int countByAgentIdAndProfileId(Integer agentId, String profileId)
        throws SystemException {
        Object[] finderArgs = new Object[] { agentId, profileId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AGENTIDANDPROFILEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFTINCANLRSAGENTPROFILE_WHERE);

            if (agentId == null) {
                query.append(_FINDER_COLUMN_AGENTIDANDPROFILEID_AGENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_AGENTIDANDPROFILEID_AGENTID_2);
            }

            if (profileId == null) {
                query.append(_FINDER_COLUMN_AGENTIDANDPROFILEID_PROFILEID_1);
            } else {
                if (profileId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENTIDANDPROFILEID_PROFILEID_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENTIDANDPROFILEID_PROFILEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (agentId != null) {
                    qPos.add(agentId.intValue());
                }

                if (profileId != null) {
                    qPos.add(profileId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AGENTIDANDPROFILEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan lrs agent profiles.
     *
     * @return the number of l f tincan lrs agent profiles
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSAGENTPROFILE);

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
     * Initializes the l f tincan lrs agent profile persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsAgentProfile>> listenersList = new ArrayList<ModelListener<LFTincanLrsAgentProfile>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsAgentProfile>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsAgentProfileImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
