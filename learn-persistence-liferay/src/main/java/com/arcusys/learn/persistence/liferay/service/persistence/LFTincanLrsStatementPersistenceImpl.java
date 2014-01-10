package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl;
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
 * The persistence implementation for the l f tincan lrs statement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatementPersistence
 * @see LFTincanLrsStatementUtil
 * @generated
 */
public class LFTincanLrsStatementPersistenceImpl extends BasePersistenceImpl<LFTincanLrsStatement>
    implements LFTincanLrsStatementPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsStatementUtil} to access the l f tincan lrs statement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsStatementImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJTYPEANDOBJID =
        new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByObjTypeAndObjID",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJTYPEANDOBJID =
        new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByObjTypeAndObjID",
            new String[] { String.class.getName(), Integer.class.getName() },
            LFTincanLrsStatementModelImpl.OBJTYPE_COLUMN_BITMASK |
            LFTincanLrsStatementModelImpl.OBJID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_OBJTYPEANDOBJID = new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByObjTypeAndObjID",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTORID = new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActorID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTORID =
        new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActorID",
            new String[] { Integer.class.getName() },
            LFTincanLrsStatementModelImpl.ACTORID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTORID = new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActorID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VERBID = new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVerbID",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERBID =
        new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVerbID",
            new String[] { String.class.getName() },
            LFTincanLrsStatementModelImpl.VERBID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_VERBID = new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVerbID",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_TINCANID = new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByTincanID", new String[] { String.class.getName() },
            LFTincanLrsStatementModelImpl.TINCANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TINCANID = new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTincanID",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSSTATEMENT = "SELECT lfTincanLrsStatement FROM LFTincanLrsStatement lfTincanLrsStatement";
    private static final String _SQL_SELECT_LFTINCANLRSSTATEMENT_WHERE = "SELECT lfTincanLrsStatement FROM LFTincanLrsStatement lfTincanLrsStatement WHERE ";
    private static final String _SQL_COUNT_LFTINCANLRSSTATEMENT = "SELECT COUNT(lfTincanLrsStatement) FROM LFTincanLrsStatement lfTincanLrsStatement";
    private static final String _SQL_COUNT_LFTINCANLRSSTATEMENT_WHERE = "SELECT COUNT(lfTincanLrsStatement) FROM LFTincanLrsStatement lfTincanLrsStatement WHERE ";
    private static final String _FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_1 = "lfTincanLrsStatement.objType IS NULL AND ";
    private static final String _FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_NULL = "lfTincanLrsStatement.objType IS NULL";
    private static final String _FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_NULL_2 = "lfTincanLrsStatement.objType IS NULL  AND ";
    private static final String _FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_2 = "lfTincanLrsStatement.objType = ? AND ";
    private static final String _FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_3 = "(lfTincanLrsStatement.objType IS NULL OR lfTincanLrsStatement.objType = ?) AND ";
    private static final String _FINDER_COLUMN_OBJTYPEANDOBJID_OBJID_NULL = "lfTincanLrsStatement.objID IS NULL";
    private static final String _FINDER_COLUMN_OBJTYPEANDOBJID_OBJID_NULL_2 = "lfTincanLrsStatement.objID IS NULL ";
    private static final String _FINDER_COLUMN_OBJTYPEANDOBJID_OBJID_2 = "lfTincanLrsStatement.objID = ?";
    private static final String _FINDER_COLUMN_ACTORID_ACTORID_NULL = "lfTincanLrsStatement.actorID IS NULL";
    private static final String _FINDER_COLUMN_ACTORID_ACTORID_NULL_2 = "lfTincanLrsStatement.actorID IS NULL ";
    private static final String _FINDER_COLUMN_ACTORID_ACTORID_2 = "lfTincanLrsStatement.actorID = ?";
    private static final String _FINDER_COLUMN_VERBID_VERBID_1 = "lfTincanLrsStatement.verbID IS NULL";
    private static final String _FINDER_COLUMN_VERBID_VERBID_NULL = "lfTincanLrsStatement.verbID IS NULL";
    private static final String _FINDER_COLUMN_VERBID_VERBID_NULL_2 = "lfTincanLrsStatement.verbID IS NULL ";
    private static final String _FINDER_COLUMN_VERBID_VERBID_2 = "lfTincanLrsStatement.verbID = ?";
    private static final String _FINDER_COLUMN_VERBID_VERBID_3 = "(lfTincanLrsStatement.verbID IS NULL OR lfTincanLrsStatement.verbID = ?)";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_1 = "lfTincanLrsStatement.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL = "lfTincanLrsStatement.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL_2 = "lfTincanLrsStatement.tincanID IS NULL ";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_2 = "lfTincanLrsStatement.tincanID = ?";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_3 = "(lfTincanLrsStatement.tincanID IS NULL OR lfTincanLrsStatement.tincanID = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsStatement.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsStatement exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanLrsStatement exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsStatementPersistenceImpl.class);
    private static LFTincanLrsStatement _nullLFTincanLrsStatement = new LFTincanLrsStatementImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsStatement> toCacheModel() {
                return _nullLFTincanLrsStatementCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsStatement> _nullLFTincanLrsStatementCacheModel =
        new CacheModel<LFTincanLrsStatement>() {
            public LFTincanLrsStatement toEntityModel() {
                return _nullLFTincanLrsStatement;
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
     * Caches the l f tincan lrs statement in the entity cache if it is enabled.
     *
     * @param lfTincanLrsStatement the l f tincan lrs statement
     */
    public void cacheResult(LFTincanLrsStatement lfTincanLrsStatement) {
        EntityCacheUtil.putResult(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class,
            lfTincanLrsStatement.getPrimaryKey(), lfTincanLrsStatement);

        boolean noNullsInTINCANID = true;

        if (noNullsInTINCANID) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                new Object[] { lfTincanLrsStatement.getTincanID() },
                lfTincanLrsStatement);
        }

        lfTincanLrsStatement.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs statements in the entity cache if it is enabled.
     *
     * @param lfTincanLrsStatements the l f tincan lrs statements
     */
    public void cacheResult(List<LFTincanLrsStatement> lfTincanLrsStatements) {
        for (LFTincanLrsStatement lfTincanLrsStatement : lfTincanLrsStatements) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsStatementImpl.class,
                        lfTincanLrsStatement.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsStatement);
            } else {
                lfTincanLrsStatement.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs statements.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsStatementImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsStatementImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs statement.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanLrsStatement lfTincanLrsStatement) {
        EntityCacheUtil.removeResult(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class, lfTincanLrsStatement.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanLrsStatement);
    }

    @Override
    public void clearCache(List<LFTincanLrsStatement> lfTincanLrsStatements) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsStatement lfTincanLrsStatement : lfTincanLrsStatements) {
            EntityCacheUtil.removeResult(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsStatementImpl.class,
                lfTincanLrsStatement.getPrimaryKey());

            clearUniqueFindersCache(lfTincanLrsStatement);
        }
    }

    protected void clearUniqueFindersCache(
        LFTincanLrsStatement lfTincanLrsStatement) {
        boolean noNullsInTINCANID = true;

        if (noNullsInTINCANID) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID,
                new Object[] { lfTincanLrsStatement.getTincanID() });
        }
    }

    /**
     * Creates a new l f tincan lrs statement with the primary key. Does not add the l f tincan lrs statement to the database.
     *
     * @param id the primary key for the new l f tincan lrs statement
     * @return the new l f tincan lrs statement
     */
    public LFTincanLrsStatement create(long id) {
        LFTincanLrsStatement lfTincanLrsStatement = new LFTincanLrsStatementImpl();

        lfTincanLrsStatement.setNew(true);
        lfTincanLrsStatement.setPrimaryKey(id);

        return lfTincanLrsStatement;
    }

    /**
     * Removes the l f tincan lrs statement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs statement
     * @return the l f tincan lrs statement that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement remove(long id)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f tincan lrs statement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs statement
     * @return the l f tincan lrs statement that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsStatement remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsStatement lfTincanLrsStatement = (LFTincanLrsStatement) session.get(LFTincanLrsStatementImpl.class,
                    primaryKey);

            if (lfTincanLrsStatement == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsStatementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsStatement);
        } catch (NoSuchLFTincanLrsStatementException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsStatement removeImpl(
        LFTincanLrsStatement lfTincanLrsStatement) throws SystemException {
        lfTincanLrsStatement = toUnwrappedModel(lfTincanLrsStatement);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfTincanLrsStatement);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfTincanLrsStatement);

        return lfTincanLrsStatement;
    }

    @Override
    public LFTincanLrsStatement updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement lfTincanLrsStatement,
        boolean merge) throws SystemException {
        lfTincanLrsStatement = toUnwrappedModel(lfTincanLrsStatement);

        boolean isNew = lfTincanLrsStatement.isNew();

        LFTincanLrsStatementModelImpl lfTincanLrsStatementModelImpl = (LFTincanLrsStatementModelImpl) lfTincanLrsStatement;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfTincanLrsStatement, merge);

            lfTincanLrsStatement.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanLrsStatementModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanLrsStatementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJTYPEANDOBJID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanLrsStatementModelImpl.getOriginalObjType(),
                        /* Integer.valueOf(   */
                        lfTincanLrsStatementModelImpl.getOriginalObjID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJTYPEANDOBJID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJTYPEANDOBJID,
                    args);

                args = new Object[] {
                        lfTincanLrsStatementModelImpl.getObjType(),
                        /* Integer.valueOf( */
                        lfTincanLrsStatementModelImpl.getObjID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJTYPEANDOBJID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJTYPEANDOBJID,
                    args);
            }

            if ((lfTincanLrsStatementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTORID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfTincanLrsStatementModelImpl.getOriginalActorID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTORID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTORID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfTincanLrsStatementModelImpl.getActorID()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTORID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTORID,
                    args);
            }

            if ((lfTincanLrsStatementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERBID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanLrsStatementModelImpl.getOriginalVerbID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VERBID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERBID,
                    args);

                args = new Object[] { lfTincanLrsStatementModelImpl.getVerbID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VERBID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERBID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementImpl.class,
            lfTincanLrsStatement.getPrimaryKey(), lfTincanLrsStatement);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                new Object[] { lfTincanLrsStatement.getTincanID() },
                lfTincanLrsStatement);
        } else {
            if ((lfTincanLrsStatementModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TINCANID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanLrsStatementModelImpl.getOriginalTincanID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TINCANID, args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID, args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                    new Object[] { lfTincanLrsStatement.getTincanID() },
                    lfTincanLrsStatement);
            }
        }

        return lfTincanLrsStatement;
    }

    protected LFTincanLrsStatement toUnwrappedModel(
        LFTincanLrsStatement lfTincanLrsStatement) {
        if (lfTincanLrsStatement instanceof LFTincanLrsStatementImpl) {
            return lfTincanLrsStatement;
        }

        LFTincanLrsStatementImpl lfTincanLrsStatementImpl = new LFTincanLrsStatementImpl();

        lfTincanLrsStatementImpl.setNew(lfTincanLrsStatement.isNew());
        lfTincanLrsStatementImpl.setPrimaryKey(lfTincanLrsStatement.getPrimaryKey());

        lfTincanLrsStatementImpl.setId(lfTincanLrsStatement.getId());
        lfTincanLrsStatementImpl.setTincanID(lfTincanLrsStatement.getTincanID());
        lfTincanLrsStatementImpl.setActorID(lfTincanLrsStatement.getActorID());
        lfTincanLrsStatementImpl.setVerbID(lfTincanLrsStatement.getVerbID());
        lfTincanLrsStatementImpl.setVerbDisplay(lfTincanLrsStatement.getVerbDisplay());
        lfTincanLrsStatementImpl.setObjType(lfTincanLrsStatement.getObjType());
        lfTincanLrsStatementImpl.setObjID(lfTincanLrsStatement.getObjID());
        lfTincanLrsStatementImpl.setResultID(lfTincanLrsStatement.getResultID());
        lfTincanLrsStatementImpl.setContextID(lfTincanLrsStatement.getContextID());
        lfTincanLrsStatementImpl.setTimestamp(lfTincanLrsStatement.getTimestamp());
        lfTincanLrsStatementImpl.setStored(lfTincanLrsStatement.getStored());
        lfTincanLrsStatementImpl.setAuthorityID(lfTincanLrsStatement.getAuthorityID());
        lfTincanLrsStatementImpl.setVersion(lfTincanLrsStatement.getVersion());

        return lfTincanLrsStatementImpl;
    }

    /**
     * Returns the l f tincan lrs statement with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs statement
     * @return the l f tincan lrs statement
     * @throws com.liferay.portal.NoSuchModelException if a l f tincan lrs statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsStatement findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs statement with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs statement
     * @return the l f tincan lrs statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = fetchByPrimaryKey(id);

        if (lfTincanLrsStatement == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFTincanLrsStatementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfTincanLrsStatement;
    }

    /**
     * Returns the l f tincan lrs statement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs statement
     * @return the l f tincan lrs statement, or <code>null</code> if a l f tincan lrs statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsStatement fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs statement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs statement
     * @return the l f tincan lrs statement, or <code>null</code> if a l f tincan lrs statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement fetchByPrimaryKey(long id)
        throws SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = (LFTincanLrsStatement) EntityCacheUtil.getResult(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsStatementImpl.class, id);

        if (lfTincanLrsStatement == _nullLFTincanLrsStatement) {
            return null;
        }

        if (lfTincanLrsStatement == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfTincanLrsStatement = (LFTincanLrsStatement) session.get(LFTincanLrsStatementImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfTincanLrsStatement != null) {
                    cacheResult(lfTincanLrsStatement);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFTincanLrsStatementModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsStatementImpl.class, id,
                        _nullLFTincanLrsStatement);
                }

                closeSession(session);
            }
        }

        return lfTincanLrsStatement;
    }

    /**
     * Returns all the l f tincan lrs statements where objType = &#63; and objID = &#63;.
     *
     * @param objType the obj type
     * @param objID the obj i d
     * @return the matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findByObjTypeAndObjID(String objType,
        Integer objID) throws SystemException {
        return findByObjTypeAndObjID(objType, objID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs statements where objType = &#63; and objID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param objType the obj type
     * @param objID the obj i d
     * @param start the lower bound of the range of l f tincan lrs statements
     * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
     * @return the range of matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findByObjTypeAndObjID(String objType,
        Integer objID, int start, int end) throws SystemException {
        return findByObjTypeAndObjID(objType, objID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs statements where objType = &#63; and objID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param objType the obj type
     * @param objID the obj i d
     * @param start the lower bound of the range of l f tincan lrs statements
     * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findByObjTypeAndObjID(String objType,
        Integer objID, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJTYPEANDOBJID;
            finderArgs = new Object[] { objType, objID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJTYPEANDOBJID;
            finderArgs = new Object[] {
                    objType, objID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFTincanLrsStatement> list = (List<LFTincanLrsStatement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanLrsStatement lfTincanLrsStatement : list) {
                if (!Validator.equals(objType, lfTincanLrsStatement.getObjType()) ||
                        !Validator.equals(objID, lfTincanLrsStatement.getObjID())) {
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

            query.append(_SQL_SELECT_LFTINCANLRSSTATEMENT_WHERE);

            if (objType == null) {
                query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_1);
            } else {
                if (objType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_2);
                }
            }

            if (objID == null) {
                query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJID_2);
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

                if (objType != null) {
                    qPos.add(objType);
                }

                if (objID != null) {
                    qPos.add(objID.intValue());
                }

                list = (List<LFTincanLrsStatement>) QueryUtil.list(q,
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
     * Returns the first l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
     *
     * @param objType the obj type
     * @param objID the obj i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement findByObjTypeAndObjID_First(String objType,
        Integer objID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = fetchByObjTypeAndObjID_First(objType,
                objID, orderByComparator);

        if (lfTincanLrsStatement != null) {
            return lfTincanLrsStatement;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("objType=");
        msg.append(objType);

        msg.append(", objID=");
        msg.append(objID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsStatementException(msg.toString());
    }

    /**
     * Returns the first l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
     *
     * @param objType the obj type
     * @param objID the obj i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement fetchByObjTypeAndObjID_First(String objType,
        Integer objID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFTincanLrsStatement> list = findByObjTypeAndObjID(objType, objID,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
     *
     * @param objType the obj type
     * @param objID the obj i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement findByObjTypeAndObjID_Last(String objType,
        Integer objID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = fetchByObjTypeAndObjID_Last(objType,
                objID, orderByComparator);

        if (lfTincanLrsStatement != null) {
            return lfTincanLrsStatement;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("objType=");
        msg.append(objType);

        msg.append(", objID=");
        msg.append(objID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsStatementException(msg.toString());
    }

    /**
     * Returns the last l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
     *
     * @param objType the obj type
     * @param objID the obj i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement fetchByObjTypeAndObjID_Last(String objType,
        Integer objID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByObjTypeAndObjID(objType, objID);

        List<LFTincanLrsStatement> list = findByObjTypeAndObjID(objType, objID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan lrs statements before and after the current l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
     *
     * @param id the primary key of the current l f tincan lrs statement
     * @param objType the obj type
     * @param objID the obj i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan lrs statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement[] findByObjTypeAndObjID_PrevAndNext(long id,
        String objType, Integer objID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanLrsStatement[] array = new LFTincanLrsStatementImpl[3];

            array[0] = getByObjTypeAndObjID_PrevAndNext(session,
                    lfTincanLrsStatement, objType, objID, orderByComparator,
                    true);

            array[1] = lfTincanLrsStatement;

            array[2] = getByObjTypeAndObjID_PrevAndNext(session,
                    lfTincanLrsStatement, objType, objID, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanLrsStatement getByObjTypeAndObjID_PrevAndNext(
        Session session, LFTincanLrsStatement lfTincanLrsStatement,
        String objType, Integer objID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANLRSSTATEMENT_WHERE);

        if (objType == null) {
            query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_1);
        } else {
            if (objType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_3);
            } else {
                query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_2);
            }
        }

        if (objID == null) {
            query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJID_2);
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

        if (objType != null) {
            qPos.add(objType);
        }

        if (objID != null) {
            qPos.add(objID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanLrsStatement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanLrsStatement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f tincan lrs statements where actorID = &#63;.
     *
     * @param actorID the actor i d
     * @return the matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findByActorID(Integer actorID)
        throws SystemException {
        return findByActorID(actorID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs statements where actorID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param actorID the actor i d
     * @param start the lower bound of the range of l f tincan lrs statements
     * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
     * @return the range of matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findByActorID(Integer actorID, int start,
        int end) throws SystemException {
        return findByActorID(actorID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs statements where actorID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param actorID the actor i d
     * @param start the lower bound of the range of l f tincan lrs statements
     * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findByActorID(Integer actorID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTORID;
            finderArgs = new Object[] { actorID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTORID;
            finderArgs = new Object[] { actorID, start, end, orderByComparator };
        }

        List<LFTincanLrsStatement> list = (List<LFTincanLrsStatement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanLrsStatement lfTincanLrsStatement : list) {
                if (!Validator.equals(actorID, lfTincanLrsStatement.getActorID())) {
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

            query.append(_SQL_SELECT_LFTINCANLRSSTATEMENT_WHERE);

            if (actorID == null) {
                query.append(_FINDER_COLUMN_ACTORID_ACTORID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTORID_ACTORID_2);
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

                if (actorID != null) {
                    qPos.add(actorID.intValue());
                }

                list = (List<LFTincanLrsStatement>) QueryUtil.list(q,
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
     * Returns the first l f tincan lrs statement in the ordered set where actorID = &#63;.
     *
     * @param actorID the actor i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement findByActorID_First(Integer actorID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = fetchByActorID_First(actorID,
                orderByComparator);

        if (lfTincanLrsStatement != null) {
            return lfTincanLrsStatement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("actorID=");
        msg.append(actorID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsStatementException(msg.toString());
    }

    /**
     * Returns the first l f tincan lrs statement in the ordered set where actorID = &#63;.
     *
     * @param actorID the actor i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement fetchByActorID_First(Integer actorID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanLrsStatement> list = findByActorID(actorID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan lrs statement in the ordered set where actorID = &#63;.
     *
     * @param actorID the actor i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement findByActorID_Last(Integer actorID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = fetchByActorID_Last(actorID,
                orderByComparator);

        if (lfTincanLrsStatement != null) {
            return lfTincanLrsStatement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("actorID=");
        msg.append(actorID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsStatementException(msg.toString());
    }

    /**
     * Returns the last l f tincan lrs statement in the ordered set where actorID = &#63;.
     *
     * @param actorID the actor i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement fetchByActorID_Last(Integer actorID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByActorID(actorID);

        List<LFTincanLrsStatement> list = findByActorID(actorID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan lrs statements before and after the current l f tincan lrs statement in the ordered set where actorID = &#63;.
     *
     * @param id the primary key of the current l f tincan lrs statement
     * @param actorID the actor i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan lrs statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement[] findByActorID_PrevAndNext(long id,
        Integer actorID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanLrsStatement[] array = new LFTincanLrsStatementImpl[3];

            array[0] = getByActorID_PrevAndNext(session, lfTincanLrsStatement,
                    actorID, orderByComparator, true);

            array[1] = lfTincanLrsStatement;

            array[2] = getByActorID_PrevAndNext(session, lfTincanLrsStatement,
                    actorID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanLrsStatement getByActorID_PrevAndNext(Session session,
        LFTincanLrsStatement lfTincanLrsStatement, Integer actorID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANLRSSTATEMENT_WHERE);

        if (actorID == null) {
            query.append(_FINDER_COLUMN_ACTORID_ACTORID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ACTORID_ACTORID_2);
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

        if (actorID != null) {
            qPos.add(actorID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanLrsStatement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanLrsStatement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f tincan lrs statements where verbID = &#63;.
     *
     * @param verbID the verb i d
     * @return the matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findByVerbID(String verbID)
        throws SystemException {
        return findByVerbID(verbID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs statements where verbID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param verbID the verb i d
     * @param start the lower bound of the range of l f tincan lrs statements
     * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
     * @return the range of matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findByVerbID(String verbID, int start,
        int end) throws SystemException {
        return findByVerbID(verbID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs statements where verbID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param verbID the verb i d
     * @param start the lower bound of the range of l f tincan lrs statements
     * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findByVerbID(String verbID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERBID;
            finderArgs = new Object[] { verbID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VERBID;
            finderArgs = new Object[] { verbID, start, end, orderByComparator };
        }

        List<LFTincanLrsStatement> list = (List<LFTincanLrsStatement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanLrsStatement lfTincanLrsStatement : list) {
                if (!Validator.equals(verbID, lfTincanLrsStatement.getVerbID())) {
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

            query.append(_SQL_SELECT_LFTINCANLRSSTATEMENT_WHERE);

            if (verbID == null) {
                query.append(_FINDER_COLUMN_VERBID_VERBID_1);
            } else {
                if (verbID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VERBID_VERBID_3);
                } else {
                    query.append(_FINDER_COLUMN_VERBID_VERBID_2);
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

                if (verbID != null) {
                    qPos.add(verbID);
                }

                list = (List<LFTincanLrsStatement>) QueryUtil.list(q,
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
     * Returns the first l f tincan lrs statement in the ordered set where verbID = &#63;.
     *
     * @param verbID the verb i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement findByVerbID_First(String verbID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = fetchByVerbID_First(verbID,
                orderByComparator);

        if (lfTincanLrsStatement != null) {
            return lfTincanLrsStatement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("verbID=");
        msg.append(verbID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsStatementException(msg.toString());
    }

    /**
     * Returns the first l f tincan lrs statement in the ordered set where verbID = &#63;.
     *
     * @param verbID the verb i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement fetchByVerbID_First(String verbID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanLrsStatement> list = findByVerbID(verbID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan lrs statement in the ordered set where verbID = &#63;.
     *
     * @param verbID the verb i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement findByVerbID_Last(String verbID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = fetchByVerbID_Last(verbID,
                orderByComparator);

        if (lfTincanLrsStatement != null) {
            return lfTincanLrsStatement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("verbID=");
        msg.append(verbID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsStatementException(msg.toString());
    }

    /**
     * Returns the last l f tincan lrs statement in the ordered set where verbID = &#63;.
     *
     * @param verbID the verb i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement fetchByVerbID_Last(String verbID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByVerbID(verbID);

        List<LFTincanLrsStatement> list = findByVerbID(verbID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan lrs statements before and after the current l f tincan lrs statement in the ordered set where verbID = &#63;.
     *
     * @param id the primary key of the current l f tincan lrs statement
     * @param verbID the verb i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan lrs statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement[] findByVerbID_PrevAndNext(long id,
        String verbID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanLrsStatement[] array = new LFTincanLrsStatementImpl[3];

            array[0] = getByVerbID_PrevAndNext(session, lfTincanLrsStatement,
                    verbID, orderByComparator, true);

            array[1] = lfTincanLrsStatement;

            array[2] = getByVerbID_PrevAndNext(session, lfTincanLrsStatement,
                    verbID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanLrsStatement getByVerbID_PrevAndNext(Session session,
        LFTincanLrsStatement lfTincanLrsStatement, String verbID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANLRSSTATEMENT_WHERE);

        if (verbID == null) {
            query.append(_FINDER_COLUMN_VERBID_VERBID_1);
        } else {
            if (verbID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VERBID_VERBID_3);
            } else {
                query.append(_FINDER_COLUMN_VERBID_VERBID_2);
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

        if (verbID != null) {
            qPos.add(verbID);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanLrsStatement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanLrsStatement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns the l f tincan lrs statement where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException} if it could not be found.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan lrs statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement findByTincanID(String tincanID)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = fetchByTincanID(tincanID);

        if (lfTincanLrsStatement == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("tincanID=");
            msg.append(tincanID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanLrsStatementException(msg.toString());
        }

        return lfTincanLrsStatement;
    }

    /**
     * Returns the l f tincan lrs statement where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement fetchByTincanID(String tincanID)
        throws SystemException {
        return fetchByTincanID(tincanID, true);
    }

    /**
     * Returns the l f tincan lrs statement where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param tincanID the tincan i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement fetchByTincanID(String tincanID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { tincanID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TINCANID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanLrsStatement) {
            LFTincanLrsStatement lfTincanLrsStatement = (LFTincanLrsStatement) result;

            if (!Validator.equals(tincanID, lfTincanLrsStatement.getTincanID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_LFTINCANLRSSTATEMENT_WHERE);

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

                List<LFTincanLrsStatement> list = q.list();

                result = list;

                LFTincanLrsStatement lfTincanLrsStatement = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                        finderArgs, list);
                } else {
                    lfTincanLrsStatement = list.get(0);

                    cacheResult(lfTincanLrsStatement);

                    if ((lfTincanLrsStatement.getTincanID() == null) ||
                            !lfTincanLrsStatement.getTincanID().equals(tincanID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                            finderArgs, lfTincanLrsStatement);
                    }
                }

                return lfTincanLrsStatement;
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
                return (LFTincanLrsStatement) result;
            }
        }
    }

    /**
     * Returns all the l f tincan lrs statements.
     *
     * @return the l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs statements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs statements
     * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
     * @return the range of l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs statements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs statements
     * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsStatement> findAll(int start, int end,
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

        List<LFTincanLrsStatement> list = (List<LFTincanLrsStatement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSSTATEMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSSTATEMENT;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFTincanLrsStatement>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFTincanLrsStatement>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs statements where objType = &#63; and objID = &#63; from the database.
     *
     * @param objType the obj type
     * @param objID the obj i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByObjTypeAndObjID(String objType, Integer objID)
        throws SystemException {
        for (LFTincanLrsStatement lfTincanLrsStatement : findByObjTypeAndObjID(
                objType, objID)) {
            remove(lfTincanLrsStatement);
        }
    }

    /**
     * Removes all the l f tincan lrs statements where actorID = &#63; from the database.
     *
     * @param actorID the actor i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByActorID(Integer actorID) throws SystemException {
        for (LFTincanLrsStatement lfTincanLrsStatement : findByActorID(actorID)) {
            remove(lfTincanLrsStatement);
        }
    }

    /**
     * Removes all the l f tincan lrs statements where verbID = &#63; from the database.
     *
     * @param verbID the verb i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByVerbID(String verbID) throws SystemException {
        for (LFTincanLrsStatement lfTincanLrsStatement : findByVerbID(verbID)) {
            remove(lfTincanLrsStatement);
        }
    }

    /**
     * Removes the l f tincan lrs statement where tincanID = &#63; from the database.
     *
     * @param tincanID the tincan i d
     * @return the l f tincan lrs statement that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsStatement removeByTincanID(String tincanID)
        throws NoSuchLFTincanLrsStatementException, SystemException {
        LFTincanLrsStatement lfTincanLrsStatement = findByTincanID(tincanID);

        return remove(lfTincanLrsStatement);
    }

    /**
     * Removes all the l f tincan lrs statements from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFTincanLrsStatement lfTincanLrsStatement : findAll()) {
            remove(lfTincanLrsStatement);
        }
    }

    /**
     * Returns the number of l f tincan lrs statements where objType = &#63; and objID = &#63;.
     *
     * @param objType the obj type
     * @param objID the obj i d
     * @return the number of matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public int countByObjTypeAndObjID(String objType, Integer objID)
        throws SystemException {
        Object[] finderArgs = new Object[] { objType, objID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OBJTYPEANDOBJID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFTINCANLRSSTATEMENT_WHERE);

            if (objType == null) {
                query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_1);
            } else {
                if (objType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJTYPE_2);
                }
            }

            if (objID == null) {
                query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_OBJTYPEANDOBJID_OBJID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (objType != null) {
                    qPos.add(objType);
                }

                if (objID != null) {
                    qPos.add(objID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OBJTYPEANDOBJID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan lrs statements where actorID = &#63;.
     *
     * @param actorID the actor i d
     * @return the number of matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public int countByActorID(Integer actorID) throws SystemException {
        Object[] finderArgs = new Object[] { actorID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTORID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANLRSSTATEMENT_WHERE);

            if (actorID == null) {
                query.append(_FINDER_COLUMN_ACTORID_ACTORID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTORID_ACTORID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (actorID != null) {
                    qPos.add(actorID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTORID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan lrs statements where verbID = &#63;.
     *
     * @param verbID the verb i d
     * @return the number of matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public int countByVerbID(String verbID) throws SystemException {
        Object[] finderArgs = new Object[] { verbID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VERBID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANLRSSTATEMENT_WHERE);

            if (verbID == null) {
                query.append(_FINDER_COLUMN_VERBID_VERBID_1);
            } else {
                if (verbID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VERBID_VERBID_3);
                } else {
                    query.append(_FINDER_COLUMN_VERBID_VERBID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (verbID != null) {
                    qPos.add(verbID);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VERBID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan lrs statements where tincanID = &#63;.
     *
     * @param tincanID the tincan i d
     * @return the number of matching l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public int countByTincanID(String tincanID) throws SystemException {
        Object[] finderArgs = new Object[] { tincanID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TINCANID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANLRSSTATEMENT_WHERE);

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
     * Returns the number of l f tincan lrs statements.
     *
     * @return the number of l f tincan lrs statements
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSSTATEMENT);

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
     * Initializes the l f tincan lrs statement persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsStatement>> listenersList = new ArrayList<ModelListener<LFTincanLrsStatement>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsStatement>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsStatementImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
