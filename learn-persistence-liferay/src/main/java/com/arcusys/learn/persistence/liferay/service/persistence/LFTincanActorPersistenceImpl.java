package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException;
import com.arcusys.learn.persistence.liferay.model.LFTincanActor;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorModelImpl;
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
 * The persistence implementation for the l f tincan actor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActorPersistence
 * @see LFTincanActorUtil
 * @generated
 */
public class LFTincanActorPersistenceImpl extends BasePersistenceImpl<LFTincanActor>
    implements LFTincanActorPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanActorUtil} to access the l f tincan actor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanActorImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_TINCANID = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByTincanID", new String[] { String.class.getName() },
            LFTincanActorModelImpl.TINCANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TINCANID = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTincanID",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBEROF = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByMemberOf",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBEROF =
        new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByMemberOf", new String[] { String.class.getName() },
            LFTincanActorModelImpl.MEMBEROF_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MEMBEROF = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMemberOf",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AGENT = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByAgent",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENT = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByAgent",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                String.class.getName()
            },
            LFTincanActorModelImpl.OBJECTTYPE_COLUMN_BITMASK |
            LFTincanActorModelImpl.NAME_COLUMN_BITMASK |
            LFTincanActorModelImpl.MBOX_COLUMN_BITMASK |
            LFTincanActorModelImpl.MBOX_SHA1SUM_COLUMN_BITMASK |
            LFTincanActorModelImpl.OPENID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_AGENT = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAgent",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANACTOR = "SELECT lfTincanActor FROM LFTincanActor lfTincanActor";
    private static final String _SQL_SELECT_LFTINCANACTOR_WHERE = "SELECT lfTincanActor FROM LFTincanActor lfTincanActor WHERE ";
    private static final String _SQL_COUNT_LFTINCANACTOR = "SELECT COUNT(lfTincanActor) FROM LFTincanActor lfTincanActor";
    private static final String _SQL_COUNT_LFTINCANACTOR_WHERE = "SELECT COUNT(lfTincanActor) FROM LFTincanActor lfTincanActor WHERE ";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_1 = "lfTincanActor.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL = "lfTincanActor.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL_2 = "lfTincanActor.tincanID IS NULL ";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_2 = "lfTincanActor.tincanID = ?";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_3 = "(lfTincanActor.tincanID IS NULL OR lfTincanActor.tincanID = ?)";
    private static final String _FINDER_COLUMN_MEMBEROF_MEMBEROF_1 = "lfTincanActor.memberOf IS NULL";
    private static final String _FINDER_COLUMN_MEMBEROF_MEMBEROF_NULL = "lfTincanActor.memberOf IS NULL";
    private static final String _FINDER_COLUMN_MEMBEROF_MEMBEROF_NULL_2 = "lfTincanActor.memberOf IS NULL ";
    private static final String _FINDER_COLUMN_MEMBEROF_MEMBEROF_2 = "lfTincanActor.memberOf = ?";
    private static final String _FINDER_COLUMN_MEMBEROF_MEMBEROF_3 = "(lfTincanActor.memberOf IS NULL OR lfTincanActor.memberOf = ?)";
    private static final String _FINDER_COLUMN_AGENT_OBJECTTYPE_1 = "lfTincanActor.objectType IS NULL AND ";
    private static final String _FINDER_COLUMN_AGENT_OBJECTTYPE_NULL = "lfTincanActor.objectType IS NULL";
    private static final String _FINDER_COLUMN_AGENT_OBJECTTYPE_NULL_2 = "lfTincanActor.objectType IS NULL  AND ";
    private static final String _FINDER_COLUMN_AGENT_OBJECTTYPE_2 = "lfTincanActor.objectType = ? AND ";
    private static final String _FINDER_COLUMN_AGENT_OBJECTTYPE_3 = "(lfTincanActor.objectType IS NULL OR lfTincanActor.objectType = ?) AND ";
    private static final String _FINDER_COLUMN_AGENT_NAME_1 = "lfTincanActor.name IS NULL AND ";
    private static final String _FINDER_COLUMN_AGENT_NAME_NULL = "lfTincanActor.name IS NULL";
    private static final String _FINDER_COLUMN_AGENT_NAME_NULL_2 = "lfTincanActor.name IS NULL  AND ";
    private static final String _FINDER_COLUMN_AGENT_NAME_2 = "lfTincanActor.name = ? AND ";
    private static final String _FINDER_COLUMN_AGENT_NAME_3 = "(lfTincanActor.name IS NULL OR lfTincanActor.name = ?) AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_1 = "lfTincanActor.mbox IS NULL AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_NULL = "lfTincanActor.mbox IS NULL";
    private static final String _FINDER_COLUMN_AGENT_MBOX_NULL_2 = "lfTincanActor.mbox IS NULL  AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_2 = "lfTincanActor.mbox = ? AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_3 = "(lfTincanActor.mbox IS NULL OR lfTincanActor.mbox = ?) AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_SHA1SUM_1 = "lfTincanActor.mbox_sha1sum IS NULL AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_SHA1SUM_NULL = "lfTincanActor.mbox_sha1sum IS NULL";
    private static final String _FINDER_COLUMN_AGENT_MBOX_SHA1SUM_NULL_2 = "lfTincanActor.mbox_sha1sum IS NULL  AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_SHA1SUM_2 = "lfTincanActor.mbox_sha1sum = ? AND ";
    private static final String _FINDER_COLUMN_AGENT_MBOX_SHA1SUM_3 = "(lfTincanActor.mbox_sha1sum IS NULL OR lfTincanActor.mbox_sha1sum = ?) AND ";
    private static final String _FINDER_COLUMN_AGENT_OPENID_1 = "lfTincanActor.openid IS NULL";
    private static final String _FINDER_COLUMN_AGENT_OPENID_NULL = "lfTincanActor.openid IS NULL";
    private static final String _FINDER_COLUMN_AGENT_OPENID_NULL_2 = "lfTincanActor.openid IS NULL ";
    private static final String _FINDER_COLUMN_AGENT_OPENID_2 = "lfTincanActor.openid = ?";
    private static final String _FINDER_COLUMN_AGENT_OPENID_3 = "(lfTincanActor.openid IS NULL OR lfTincanActor.openid = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanActor.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanActor exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanActor exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanActorPersistenceImpl.class);
    private static LFTincanActor _nullLFTincanActor = new LFTincanActorImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanActor> toCacheModel() {
                return _nullLFTincanActorCacheModel;
            }
        };

    private static CacheModel<LFTincanActor> _nullLFTincanActorCacheModel = new CacheModel<LFTincanActor>() {
            public LFTincanActor toEntityModel() {
                return _nullLFTincanActor;
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
     * Caches the l f tincan actor in the entity cache if it is enabled.
     *
     * @param lfTincanActor the l f tincan actor
     */
    public void cacheResult(LFTincanActor lfTincanActor) {
        EntityCacheUtil.putResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorImpl.class, lfTincanActor.getPrimaryKey(),
            lfTincanActor);

        boolean noNullsInTINCANID = true;

        if (noNullsInTINCANID) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                new Object[] { lfTincanActor.getTincanID() }, lfTincanActor);
        }

        lfTincanActor.resetOriginalValues();
    }

    /**
     * Caches the l f tincan actors in the entity cache if it is enabled.
     *
     * @param lfTincanActors the l f tincan actors
     */
    public void cacheResult(List<LFTincanActor> lfTincanActors) {
        for (LFTincanActor lfTincanActor : lfTincanActors) {
            if (EntityCacheUtil.getResult(
                        LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanActorImpl.class, lfTincanActor.getPrimaryKey()) == null) {
                cacheResult(lfTincanActor);
            } else {
                lfTincanActor.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan actors.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanActorImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanActorImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan actor.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanActor lfTincanActor) {
        EntityCacheUtil.removeResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorImpl.class, lfTincanActor.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanActor);
    }

    @Override
    public void clearCache(List<LFTincanActor> lfTincanActors) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanActor lfTincanActor : lfTincanActors) {
            EntityCacheUtil.removeResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanActorImpl.class, lfTincanActor.getPrimaryKey());

            clearUniqueFindersCache(lfTincanActor);
        }
    }

    protected void clearUniqueFindersCache(LFTincanActor lfTincanActor) {
        boolean noNullsInTINCANID = true;

        if (noNullsInTINCANID) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID,
                new Object[] { lfTincanActor.getTincanID() });
        }
    }

    /**
     * Creates a new l f tincan actor with the primary key. Does not add the l f tincan actor to the database.
     *
     * @param id the primary key for the new l f tincan actor
     * @return the new l f tincan actor
     */
    public LFTincanActor create(long id) {
        LFTincanActor lfTincanActor = new LFTincanActorImpl();

        lfTincanActor.setNew(true);
        lfTincanActor.setPrimaryKey(id);

        return lfTincanActor;
    }

    /**
     * Removes the l f tincan actor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan actor
     * @return the l f tincan actor that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor remove(long id)
        throws NoSuchLFTincanActorException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f tincan actor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan actor
     * @return the l f tincan actor that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor remove(Serializable primaryKey)
        throws NoSuchLFTincanActorException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanActor lfTincanActor = (LFTincanActor) session.get(LFTincanActorImpl.class,
                    primaryKey);

            if (lfTincanActor == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanActorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanActor);
        } catch (NoSuchLFTincanActorException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanActor removeImpl(LFTincanActor lfTincanActor)
        throws SystemException {
        lfTincanActor = toUnwrappedModel(lfTincanActor);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfTincanActor);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfTincanActor);

        return lfTincanActor;
    }

    @Override
    public LFTincanActor updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor,
        boolean merge) throws SystemException {
        lfTincanActor = toUnwrappedModel(lfTincanActor);

        boolean isNew = lfTincanActor.isNew();

        LFTincanActorModelImpl lfTincanActorModelImpl = (LFTincanActorModelImpl) lfTincanActor;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfTincanActor, merge);

            lfTincanActor.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanActorModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanActorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBEROF.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanActorModelImpl.getOriginalMemberOf()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBEROF, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBEROF,
                    args);

                args = new Object[] { lfTincanActorModelImpl.getMemberOf() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBEROF, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBEROF,
                    args);
            }

            if ((lfTincanActorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanActorModelImpl.getOriginalObjectType(),
                        
                        lfTincanActorModelImpl.getOriginalName(),
                        
                        lfTincanActorModelImpl.getOriginalMbox(),
                        
                        lfTincanActorModelImpl.getOriginalMbox_sha1sum(),
                        
                        lfTincanActorModelImpl.getOriginalOpenid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AGENT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENT,
                    args);

                args = new Object[] {
                        lfTincanActorModelImpl.getObjectType(),
                        
                        lfTincanActorModelImpl.getName(),
                        
                        lfTincanActorModelImpl.getMbox(),
                        
                        lfTincanActorModelImpl.getMbox_sha1sum(),
                        
                        lfTincanActorModelImpl.getOpenid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AGENT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENT,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActorImpl.class, lfTincanActor.getPrimaryKey(),
            lfTincanActor);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                new Object[] { lfTincanActor.getTincanID() }, lfTincanActor);
        } else {
            if ((lfTincanActorModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TINCANID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanActorModelImpl.getOriginalTincanID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TINCANID, args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID, args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                    new Object[] { lfTincanActor.getTincanID() }, lfTincanActor);
            }
        }

        return lfTincanActor;
    }

    protected LFTincanActor toUnwrappedModel(LFTincanActor lfTincanActor) {
        if (lfTincanActor instanceof LFTincanActorImpl) {
            return lfTincanActor;
        }

        LFTincanActorImpl lfTincanActorImpl = new LFTincanActorImpl();

        lfTincanActorImpl.setNew(lfTincanActor.isNew());
        lfTincanActorImpl.setPrimaryKey(lfTincanActor.getPrimaryKey());

        lfTincanActorImpl.setId(lfTincanActor.getId());
        lfTincanActorImpl.setTincanID(lfTincanActor.getTincanID());
        lfTincanActorImpl.setObjectType(lfTincanActor.getObjectType());
        lfTincanActorImpl.setName(lfTincanActor.getName());
        lfTincanActorImpl.setMbox(lfTincanActor.getMbox());
        lfTincanActorImpl.setMbox_sha1sum(lfTincanActor.getMbox_sha1sum());
        lfTincanActorImpl.setOpenid(lfTincanActor.getOpenid());
        lfTincanActorImpl.setAccount(lfTincanActor.getAccount());
        lfTincanActorImpl.setMemberOf(lfTincanActor.getMemberOf());

        return lfTincanActorImpl;
    }

    /**
     * Returns the l f tincan actor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan actor
     * @return the l f tincan actor
     * @throws com.liferay.portal.NoSuchModelException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan actor with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException} if it could not be found.
     *
     * @param id the primary key of the l f tincan actor
     * @return the l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor findByPrimaryKey(long id)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByPrimaryKey(id);

        if (lfTincanActor == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFTincanActorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfTincanActor;
    }

    /**
     * Returns the l f tincan actor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan actor
     * @return the l f tincan actor, or <code>null</code> if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActor fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan actor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan actor
     * @return the l f tincan actor, or <code>null</code> if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor fetchByPrimaryKey(long id) throws SystemException {
        LFTincanActor lfTincanActor = (LFTincanActor) EntityCacheUtil.getResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanActorImpl.class, id);

        if (lfTincanActor == _nullLFTincanActor) {
            return null;
        }

        if (lfTincanActor == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfTincanActor = (LFTincanActor) session.get(LFTincanActorImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfTincanActor != null) {
                    cacheResult(lfTincanActor);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFTincanActorModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanActorImpl.class, id, _nullLFTincanActor);
                }

                closeSession(session);
            }
        }

        return lfTincanActor;
    }

    /**
     * Returns the l f tincan actor where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException} if it could not be found.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor findByTincanID(String tincanID)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByTincanID(tincanID);

        if (lfTincanActor == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("tincanID=");
            msg.append(tincanID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanActorException(msg.toString());
        }

        return lfTincanActor;
    }

    /**
     * Returns the l f tincan actor where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor fetchByTincanID(String tincanID)
        throws SystemException {
        return fetchByTincanID(tincanID, true);
    }

    /**
     * Returns the l f tincan actor where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param tincanID the tincan i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor fetchByTincanID(String tincanID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { tincanID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TINCANID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanActor) {
            LFTincanActor lfTincanActor = (LFTincanActor) result;

            if (!Validator.equals(tincanID, lfTincanActor.getTincanID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_LFTINCANACTOR_WHERE);

            if (tincanID == null) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_1);
            } else {
                if (tincanID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
                } else {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (tincanID != null) {
                    qPos.add(tincanID);
                }

                List<LFTincanActor> list = q.list();

                result = list;

                LFTincanActor lfTincanActor = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                        finderArgs, list);
                } else {
                    lfTincanActor = list.get(0);

                    cacheResult(lfTincanActor);

                    if ((lfTincanActor.getTincanID() == null) ||
                            !lfTincanActor.getTincanID().equals(tincanID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                            finderArgs, lfTincanActor);
                    }
                }

                return lfTincanActor;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFTincanActor) result;
            }
        }
    }

    /**
     * Returns all the l f tincan actors where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @return the matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanActor> findByMemberOf(String memberOf)
        throws SystemException {
        return findByMemberOf(memberOf, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan actors where memberOf = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param memberOf the member of
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @return the range of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanActor> findByMemberOf(String memberOf, int start,
        int end) throws SystemException {
        return findByMemberOf(memberOf, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan actors where memberOf = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param memberOf the member of
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanActor> findByMemberOf(String memberOf, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBEROF;
            finderArgs = new Object[] { memberOf };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBEROF;
            finderArgs = new Object[] { memberOf, start, end, orderByComparator };
        }

        List<LFTincanActor> list = (List<LFTincanActor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanActor lfTincanActor : list) {
                if (!Validator.equals(memberOf, lfTincanActor.getMemberOf())) {
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

            query.append(_SQL_SELECT_LFTINCANACTOR_WHERE);

            if (memberOf == null) {
                query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_1);
            } else {
                if (memberOf.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_3);
                } else {
                    query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_2);
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

                if (memberOf != null) {
                    qPos.add(memberOf);
                }

                list = (List<LFTincanActor>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f tincan actor in the ordered set where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor findByMemberOf_First(String memberOf,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByMemberOf_First(memberOf,
                orderByComparator);

        if (lfTincanActor != null) {
            return lfTincanActor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("memberOf=");
        msg.append(memberOf);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActorException(msg.toString());
    }

    /**
     * Returns the first l f tincan actor in the ordered set where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor fetchByMemberOf_First(String memberOf,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanActor> list = findByMemberOf(memberOf, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan actor in the ordered set where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor findByMemberOf_Last(String memberOf,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByMemberOf_Last(memberOf,
                orderByComparator);

        if (lfTincanActor != null) {
            return lfTincanActor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("memberOf=");
        msg.append(memberOf);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActorException(msg.toString());
    }

    /**
     * Returns the last l f tincan actor in the ordered set where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor fetchByMemberOf_Last(String memberOf,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByMemberOf(memberOf);

        List<LFTincanActor> list = findByMemberOf(memberOf, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan actors before and after the current l f tincan actor in the ordered set where memberOf = &#63;.
     *
     * @param id the primary key of the current l f tincan actor
     * @param memberOf the member of
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor[] findByMemberOf_PrevAndNext(long id, String memberOf,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanActor[] array = new LFTincanActorImpl[3];

            array[0] = getByMemberOf_PrevAndNext(session, lfTincanActor,
                    memberOf, orderByComparator, true);

            array[1] = lfTincanActor;

            array[2] = getByMemberOf_PrevAndNext(session, lfTincanActor,
                    memberOf, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanActor getByMemberOf_PrevAndNext(Session session,
        LFTincanActor lfTincanActor, String memberOf,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANACTOR_WHERE);

        if (memberOf == null) {
            query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_1);
        } else {
            if (memberOf.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_3);
            } else {
                query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_2);
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

        if (memberOf != null) {
            qPos.add(memberOf);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanActor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanActor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @return the matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanActor> findByAgent(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid)
        throws SystemException {
        return findByAgent(objectType, name, mbox, mbox_sha1sum, openid,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @return the range of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanActor> findByAgent(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid, int start, int end)
        throws SystemException {
        return findByAgent(objectType, name, mbox, mbox_sha1sum, openid, start,
            end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanActor> findByAgent(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENT;
            finderArgs = new Object[] {
                    objectType, name, mbox, mbox_sha1sum, openid
                };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AGENT;
            finderArgs = new Object[] {
                    objectType, name, mbox, mbox_sha1sum, openid,
                    
                    start, end, orderByComparator
                };
        }

        List<LFTincanActor> list = (List<LFTincanActor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanActor lfTincanActor : list) {
                if (!Validator.equals(objectType, lfTincanActor.getObjectType()) ||
                        !Validator.equals(name, lfTincanActor.getName()) ||
                        !Validator.equals(mbox, lfTincanActor.getMbox()) ||
                        !Validator.equals(mbox_sha1sum,
                            lfTincanActor.getMbox_sha1sum()) ||
                        !Validator.equals(openid, lfTincanActor.getOpenid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(7 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(6);
            }

            query.append(_SQL_SELECT_LFTINCANACTOR_WHERE);

            if (objectType == null) {
                query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_1);
            } else {
                if (objectType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_2);
                }
            }

            if (name == null) {
                query.append(_FINDER_COLUMN_AGENT_NAME_1);
            } else {
                if (name.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_NAME_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_NAME_2);
                }
            }

            if (mbox == null) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_1);
            } else {
                if (mbox.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_2);
                }
            }

            if (mbox_sha1sum == null) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_1);
            } else {
                if (mbox_sha1sum.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_2);
                }
            }

            if (openid == null) {
                query.append(_FINDER_COLUMN_AGENT_OPENID_1);
            } else {
                if (openid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_OPENID_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_OPENID_2);
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

                if (objectType != null) {
                    qPos.add(objectType);
                }

                if (name != null) {
                    qPos.add(name);
                }

                if (mbox != null) {
                    qPos.add(mbox);
                }

                if (mbox_sha1sum != null) {
                    qPos.add(mbox_sha1sum);
                }

                if (openid != null) {
                    qPos.add(openid);
                }

                list = (List<LFTincanActor>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor findByAgent_First(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByAgent_First(objectType, name,
                mbox, mbox_sha1sum, openid, orderByComparator);

        if (lfTincanActor != null) {
            return lfTincanActor;
        }

        StringBundler msg = new StringBundler(12);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("objectType=");
        msg.append(objectType);

        msg.append(", name=");
        msg.append(name);

        msg.append(", mbox=");
        msg.append(mbox);

        msg.append(", mbox_sha1sum=");
        msg.append(mbox_sha1sum);

        msg.append(", openid=");
        msg.append(openid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActorException(msg.toString());
    }

    /**
     * Returns the first l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor fetchByAgent_First(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanActor> list = findByAgent(objectType, name, mbox,
                mbox_sha1sum, openid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor findByAgent_Last(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = fetchByAgent_Last(objectType, name, mbox,
                mbox_sha1sum, openid, orderByComparator);

        if (lfTincanActor != null) {
            return lfTincanActor;
        }

        StringBundler msg = new StringBundler(12);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("objectType=");
        msg.append(objectType);

        msg.append(", name=");
        msg.append(name);

        msg.append(", mbox=");
        msg.append(mbox);

        msg.append(", mbox_sha1sum=");
        msg.append(mbox_sha1sum);

        msg.append(", openid=");
        msg.append(openid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActorException(msg.toString());
    }

    /**
     * Returns the last l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan actor, or <code>null</code> if a matching l f tincan actor could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor fetchByAgent_Last(String objectType, String name,
        String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAgent(objectType, name, mbox, mbox_sha1sum, openid);

        List<LFTincanActor> list = findByAgent(objectType, name, mbox,
                mbox_sha1sum, openid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan actors before and after the current l f tincan actor in the ordered set where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param id the primary key of the current l f tincan actor
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan actor
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException if a l f tincan actor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor[] findByAgent_PrevAndNext(long id, String objectType,
        String name, String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanActor[] array = new LFTincanActorImpl[3];

            array[0] = getByAgent_PrevAndNext(session, lfTincanActor,
                    objectType, name, mbox, mbox_sha1sum, openid,
                    orderByComparator, true);

            array[1] = lfTincanActor;

            array[2] = getByAgent_PrevAndNext(session, lfTincanActor,
                    objectType, name, mbox, mbox_sha1sum, openid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanActor getByAgent_PrevAndNext(Session session,
        LFTincanActor lfTincanActor, String objectType, String name,
        String mbox, String mbox_sha1sum, String openid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANACTOR_WHERE);

        if (objectType == null) {
            query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_1);
        } else {
            if (objectType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_3);
            } else {
                query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_2);
            }
        }

        if (name == null) {
            query.append(_FINDER_COLUMN_AGENT_NAME_1);
        } else {
            if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_NAME_3);
            } else {
                query.append(_FINDER_COLUMN_AGENT_NAME_2);
            }
        }

        if (mbox == null) {
            query.append(_FINDER_COLUMN_AGENT_MBOX_1);
        } else {
            if (mbox.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_3);
            } else {
                query.append(_FINDER_COLUMN_AGENT_MBOX_2);
            }
        }

        if (mbox_sha1sum == null) {
            query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_1);
        } else {
            if (mbox_sha1sum.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_3);
            } else {
                query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_2);
            }
        }

        if (openid == null) {
            query.append(_FINDER_COLUMN_AGENT_OPENID_1);
        } else {
            if (openid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AGENT_OPENID_3);
            } else {
                query.append(_FINDER_COLUMN_AGENT_OPENID_2);
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

        if (objectType != null) {
            qPos.add(objectType);
        }

        if (name != null) {
            qPos.add(name);
        }

        if (mbox != null) {
            qPos.add(mbox);
        }

        if (mbox_sha1sum != null) {
            qPos.add(mbox_sha1sum);
        }

        if (openid != null) {
            qPos.add(openid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanActor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanActor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f tincan actors.
     *
     * @return the l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanActor> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan actors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @return the range of l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanActor> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan actors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan actors
     * @param end the upper bound of the range of l f tincan actors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanActor> findAll(int start, int end,
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

        List<LFTincanActor> list = (List<LFTincanActor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANACTOR);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANACTOR;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFTincanActor>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFTincanActor>) QueryUtil.list(q,
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
     * Removes the l f tincan actor where tincanID = &#63; from the database.
     *
     * @param tincanID the tincan i d
     * @return the l f tincan actor that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFTincanActor removeByTincanID(String tincanID)
        throws NoSuchLFTincanActorException, SystemException {
        LFTincanActor lfTincanActor = findByTincanID(tincanID);

        return remove(lfTincanActor);
    }

    /**
     * Removes all the l f tincan actors where memberOf = &#63; from the database.
     *
     * @param memberOf the member of
     * @throws SystemException if a system exception occurred
     */
    public void removeByMemberOf(String memberOf) throws SystemException {
        for (LFTincanActor lfTincanActor : findByMemberOf(memberOf)) {
            remove(lfTincanActor);
        }
    }

    /**
     * Removes all the l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63; from the database.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @throws SystemException if a system exception occurred
     */
    public void removeByAgent(String objectType, String name, String mbox,
        String mbox_sha1sum, String openid) throws SystemException {
        for (LFTincanActor lfTincanActor : findByAgent(objectType, name, mbox,
                mbox_sha1sum, openid)) {
            remove(lfTincanActor);
        }
    }

    /**
     * Removes all the l f tincan actors from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFTincanActor lfTincanActor : findAll()) {
            remove(lfTincanActor);
        }
    }

    /**
     * Returns the number of l f tincan actors where tincanID = &#63;.
     *
     * @param tincanID the tincan i d
     * @return the number of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public int countByTincanID(String tincanID) throws SystemException {
        Object[] finderArgs = new Object[] { tincanID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TINCANID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANACTOR_WHERE);

            if (tincanID == null) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_1);
            } else {
                if (tincanID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
                } else {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (tincanID != null) {
                    qPos.add(tincanID);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TINCANID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan actors where memberOf = &#63;.
     *
     * @param memberOf the member of
     * @return the number of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public int countByMemberOf(String memberOf) throws SystemException {
        Object[] finderArgs = new Object[] { memberOf };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MEMBEROF,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANACTOR_WHERE);

            if (memberOf == null) {
                query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_1);
            } else {
                if (memberOf.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_3);
                } else {
                    query.append(_FINDER_COLUMN_MEMBEROF_MEMBEROF_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (memberOf != null) {
                    qPos.add(memberOf);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MEMBEROF,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan actors where objectType = &#63; and name = &#63; and mbox = &#63; and mbox_sha1sum = &#63; and openid = &#63;.
     *
     * @param objectType the object type
     * @param name the name
     * @param mbox the mbox
     * @param mbox_sha1sum the mbox_sha1sum
     * @param openid the openid
     * @return the number of matching l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public int countByAgent(String objectType, String name, String mbox,
        String mbox_sha1sum, String openid) throws SystemException {
        Object[] finderArgs = new Object[] {
                objectType, name, mbox, mbox_sha1sum, openid
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AGENT,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(6);

            query.append(_SQL_COUNT_LFTINCANACTOR_WHERE);

            if (objectType == null) {
                query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_1);
            } else {
                if (objectType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_OBJECTTYPE_2);
                }
            }

            if (name == null) {
                query.append(_FINDER_COLUMN_AGENT_NAME_1);
            } else {
                if (name.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_NAME_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_NAME_2);
                }
            }

            if (mbox == null) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_1);
            } else {
                if (mbox.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_2);
                }
            }

            if (mbox_sha1sum == null) {
                query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_1);
            } else {
                if (mbox_sha1sum.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_MBOX_SHA1SUM_2);
                }
            }

            if (openid == null) {
                query.append(_FINDER_COLUMN_AGENT_OPENID_1);
            } else {
                if (openid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_AGENT_OPENID_3);
                } else {
                    query.append(_FINDER_COLUMN_AGENT_OPENID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                if (name != null) {
                    qPos.add(name);
                }

                if (mbox != null) {
                    qPos.add(mbox);
                }

                if (mbox_sha1sum != null) {
                    qPos.add(mbox_sha1sum);
                }

                if (openid != null) {
                    qPos.add(openid);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AGENT,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan actors.
     *
     * @return the number of l f tincan actors
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANACTOR);

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
     * Initializes the l f tincan actor persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanActor")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanActor>> listenersList = new ArrayList<ModelListener<LFTincanActor>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanActor>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanActorImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
