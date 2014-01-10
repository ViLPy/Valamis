package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException;
import com.arcusys.learn.persistence.liferay.model.LFActivityState;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl;
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
 * The persistence implementation for the l f activity state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStatePersistence
 * @see LFActivityStateUtil
 * @generated
 */
public class LFActivityStatePersistenceImpl extends BasePersistenceImpl<LFActivityState>
    implements LFActivityStatePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFActivityStateUtil} to access the l f activity state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFActivityStateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYSTATENODEIDANDACTIVITYID =
        new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByActivityStateNodeIDAndActivityID",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATENODEIDANDACTIVITYID =
        new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByActivityStateNodeIDAndActivityID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFActivityStateModelImpl.ACTIVITYSTATENODEID_COLUMN_BITMASK |
            LFActivityStateModelImpl.ACTIVITYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYSTATENODEIDANDACTIVITYID =
        new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByActivityStateNodeIDAndActivityID",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVITYSTATENODEIDANDACTIVITYID =
        new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "countByActivityStateNodeIDAndActivityID",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID =
        new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID =
        new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                Integer.class.getName()
            },
            LFActivityStateModelImpl.ACTIVITYID_COLUMN_BITMASK |
            LFActivityStateModelImpl.ACTIVITYSTATENODEID_COLUMN_BITMASK |
            LFActivityStateModelImpl.ACTIVITYSTATETREEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID =
        new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByActivityIDAndActivityStateNodeIDAndActivityStateTreeID",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                Integer.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID =
        new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "countByActivityIDAndActivityStateNodeIDAndActivityStateTreeID",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                Integer.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYSTATENODEID =
        new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByActivityStateNodeID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATENODEID =
        new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByActivityStateNodeID",
            new String[] { Integer.class.getName() },
            LFActivityStateModelImpl.ACTIVITYSTATENODEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYSTATENODEID = new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByActivityStateNodeID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVITYSTATENODEID =
        new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "countByActivityStateNodeID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFACTIVITYSTATE = "SELECT lfActivityState FROM LFActivityState lfActivityState";
    private static final String _SQL_SELECT_LFACTIVITYSTATE_WHERE = "SELECT lfActivityState FROM LFActivityState lfActivityState WHERE ";
    private static final String _SQL_COUNT_LFACTIVITYSTATE = "SELECT COUNT(lfActivityState) FROM LFActivityState lfActivityState";
    private static final String _SQL_COUNT_LFACTIVITYSTATE_WHERE = "SELECT COUNT(lfActivityState) FROM LFActivityState lfActivityState WHERE ";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_NULL =
        "lfActivityState.activityStateNodeID IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_NULL_2 =
        "lfActivityState.activityStateNodeID IS NULL  AND ";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_2 =
        "lfActivityState.activityStateNodeID = ? AND ";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_5 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_2) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_1 =
        "lfActivityState.activityID IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_NULL =
        "lfActivityState.activityID IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_NULL_2 =
        "lfActivityState.activityID IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_2 =
        "lfActivityState.activityID = ?";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_3 =
        "(lfActivityState.activityID IS NULL OR lfActivityState.activityID = ?)";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_4 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_1) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_5 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_2) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_6 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_3) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_1 =
        "lfActivityState.activityID IS NULL AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_NULL =
        "lfActivityState.activityID IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_NULL_2 =
        "lfActivityState.activityID IS NULL  AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_2 =
        "lfActivityState.activityID = ? AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_3 =
        "(lfActivityState.activityID IS NULL OR lfActivityState.activityID = ?) AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_4 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_1) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_5 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_2) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_6 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_3) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_NULL =
        "lfActivityState.activityStateNodeID IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_NULL_2 =
        "lfActivityState.activityStateNodeID IS NULL  AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_2 =
        "lfActivityState.activityStateNodeID = ? AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_5 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_2) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_NULL =
        "lfActivityState.activityStateTreeID IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_NULL_2 =
        "lfActivityState.activityStateTreeID IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_2 =
        "lfActivityState.activityStateTreeID = ?";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_5 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_2) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_NULL =
        "lfActivityState.activityStateNodeID IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_NULL_2 =
        "lfActivityState.activityStateNodeID IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_2 =
        "lfActivityState.activityStateNodeID = ?";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_5 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_2) +
        ")";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfActivityState.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFActivityState exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFActivityState exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFActivityStatePersistenceImpl.class);
    private static LFActivityState _nullLFActivityState = new LFActivityStateImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFActivityState> toCacheModel() {
                return _nullLFActivityStateCacheModel;
            }
        };

    private static CacheModel<LFActivityState> _nullLFActivityStateCacheModel = new CacheModel<LFActivityState>() {
            public LFActivityState toEntityModel() {
                return _nullLFActivityState;
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
     * Caches the l f activity state in the entity cache if it is enabled.
     *
     * @param lfActivityState the l f activity state
     */
    public void cacheResult(LFActivityState lfActivityState) {
        EntityCacheUtil.putResult(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateImpl.class, lfActivityState.getPrimaryKey(),
            lfActivityState);

        lfActivityState.resetOriginalValues();
    }

    /**
     * Caches the l f activity states in the entity cache if it is enabled.
     *
     * @param lfActivityStates the l f activity states
     */
    public void cacheResult(List<LFActivityState> lfActivityStates) {
        for (LFActivityState lfActivityState : lfActivityStates) {
            if (EntityCacheUtil.getResult(
                        LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityStateImpl.class,
                        lfActivityState.getPrimaryKey()) == null) {
                cacheResult(lfActivityState);
            } else {
                lfActivityState.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f activity states.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFActivityStateImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFActivityStateImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f activity state.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFActivityState lfActivityState) {
        EntityCacheUtil.removeResult(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateImpl.class, lfActivityState.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFActivityState> lfActivityStates) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFActivityState lfActivityState : lfActivityStates) {
            EntityCacheUtil.removeResult(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityStateImpl.class, lfActivityState.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f activity state with the primary key. Does not add the l f activity state to the database.
     *
     * @param id the primary key for the new l f activity state
     * @return the new l f activity state
     */
    public LFActivityState create(long id) {
        LFActivityState lfActivityState = new LFActivityStateImpl();

        lfActivityState.setNew(true);
        lfActivityState.setPrimaryKey(id);

        return lfActivityState;
    }

    /**
     * Removes the l f activity state with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f activity state
     * @return the l f activity state that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState remove(long id)
        throws NoSuchLFActivityStateException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f activity state with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f activity state
     * @return the l f activity state that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityState remove(Serializable primaryKey)
        throws NoSuchLFActivityStateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFActivityState lfActivityState = (LFActivityState) session.get(LFActivityStateImpl.class,
                    primaryKey);

            if (lfActivityState == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFActivityStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfActivityState);
        } catch (NoSuchLFActivityStateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFActivityState removeImpl(LFActivityState lfActivityState)
        throws SystemException {
        lfActivityState = toUnwrappedModel(lfActivityState);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfActivityState);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfActivityState);

        return lfActivityState;
    }

    @Override
    public LFActivityState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState,
        boolean merge) throws SystemException {
        lfActivityState = toUnwrappedModel(lfActivityState);

        boolean isNew = lfActivityState.isNew();

        LFActivityStateModelImpl lfActivityStateModelImpl = (LFActivityStateModelImpl) lfActivityState;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfActivityState, merge);

            lfActivityState.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFActivityStateModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfActivityStateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATENODEIDANDACTIVITYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfActivityStateModelImpl.getOriginalActivityStateNodeID(),
                        
                        lfActivityStateModelImpl.getOriginalActivityID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATENODEIDANDACTIVITYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATENODEIDANDACTIVITYID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfActivityStateModelImpl.getActivityStateNodeID(),
                        
                        lfActivityStateModelImpl.getActivityID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATENODEIDANDACTIVITYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATENODEIDANDACTIVITYID,
                    args);
            }

            if ((lfActivityStateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfActivityStateModelImpl.getOriginalActivityID(),
                        /* Integer.valueOf(   */
                        lfActivityStateModelImpl.getOriginalActivityStateNodeID(),
                        /* Integer.valueOf(   */
                        lfActivityStateModelImpl.getOriginalActivityStateTreeID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID,
                    args);

                args = new Object[] {
                        lfActivityStateModelImpl.getActivityID(),
                        /* Integer.valueOf( */
                        lfActivityStateModelImpl.getActivityStateNodeID(),
                        /* Integer.valueOf( */
                        lfActivityStateModelImpl.getActivityStateTreeID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID,
                    args);
            }

            if ((lfActivityStateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATENODEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfActivityStateModelImpl.getOriginalActivityStateNodeID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATENODEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATENODEID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfActivityStateModelImpl.getActivityStateNodeID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATENODEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATENODEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateImpl.class, lfActivityState.getPrimaryKey(),
            lfActivityState);

        return lfActivityState;
    }

    protected LFActivityState toUnwrappedModel(LFActivityState lfActivityState) {
        if (lfActivityState instanceof LFActivityStateImpl) {
            return lfActivityState;
        }

        LFActivityStateImpl lfActivityStateImpl = new LFActivityStateImpl();

        lfActivityStateImpl.setNew(lfActivityState.isNew());
        lfActivityStateImpl.setPrimaryKey(lfActivityState.getPrimaryKey());

        lfActivityStateImpl.setId(lfActivityState.getId());
        lfActivityStateImpl.setPackageID(lfActivityState.getPackageID());
        lfActivityStateImpl.setActivityID(lfActivityState.getActivityID());
        lfActivityStateImpl.setActive(lfActivityState.getActive());
        lfActivityStateImpl.setSuspended(lfActivityState.getSuspended());
        lfActivityStateImpl.setAttemptCompleted(lfActivityState.getAttemptCompleted());
        lfActivityStateImpl.setAttemptCompletionAmount(lfActivityState.getAttemptCompletionAmount());
        lfActivityStateImpl.setAttemptAbsoluteDuration(lfActivityState.getAttemptAbsoluteDuration());
        lfActivityStateImpl.setAttemptExperiencedDuration(lfActivityState.getAttemptExperiencedDuration());
        lfActivityStateImpl.setActivityAbsoluteDuration(lfActivityState.getActivityAbsoluteDuration());
        lfActivityStateImpl.setActivityExperiencedDuration(lfActivityState.getActivityExperiencedDuration());
        lfActivityStateImpl.setAttemptCount(lfActivityState.getAttemptCount());
        lfActivityStateImpl.setActivityStateNodeID(lfActivityState.getActivityStateNodeID());
        lfActivityStateImpl.setActivityStateTreeID(lfActivityState.getActivityStateTreeID());

        return lfActivityStateImpl;
    }

    /**
     * Returns the l f activity state with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity state
     * @return the l f activity state
     * @throws com.liferay.portal.NoSuchModelException if a l f activity state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityState findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f activity state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException} if it could not be found.
     *
     * @param id the primary key of the l f activity state
     * @return the l f activity state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState findByPrimaryKey(long id)
        throws NoSuchLFActivityStateException, SystemException {
        LFActivityState lfActivityState = fetchByPrimaryKey(id);

        if (lfActivityState == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFActivityStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfActivityState;
    }

    /**
     * Returns the l f activity state with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity state
     * @return the l f activity state, or <code>null</code> if a l f activity state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityState fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f activity state with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f activity state
     * @return the l f activity state, or <code>null</code> if a l f activity state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState fetchByPrimaryKey(long id) throws SystemException {
        LFActivityState lfActivityState = (LFActivityState) EntityCacheUtil.getResult(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityStateImpl.class, id);

        if (lfActivityState == _nullLFActivityState) {
            return null;
        }

        if (lfActivityState == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfActivityState = (LFActivityState) session.get(LFActivityStateImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfActivityState != null) {
                    cacheResult(lfActivityState);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFActivityStateModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityStateImpl.class, id, _nullLFActivityState);
                }

                closeSession(session);
            }
        }

        return lfActivityState;
    }

    /**
     * Returns all the l f activity states where activityStateNodeID = &#63; and activityID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @param activityID the activity i d
     * @return the matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeIDAndActivityID(
        Integer activityStateNodeID, String activityID)
        throws SystemException {
        return findByActivityStateNodeIDAndActivityID(activityStateNodeID,
            activityID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activity states where activityStateNodeID = &#63; and activityID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateNodeID the activity state node i d
     * @param activityID the activity i d
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @return the range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeIDAndActivityID(
        Integer activityStateNodeID, String activityID, int start, int end)
        throws SystemException {
        return findByActivityStateNodeIDAndActivityID(activityStateNodeID,
            activityID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activity states where activityStateNodeID = &#63; and activityID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateNodeID the activity state node i d
     * @param activityID the activity i d
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeIDAndActivityID(
        Integer activityStateNodeID, String activityID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATENODEIDANDACTIVITYID;
            finderArgs = new Object[] { activityStateNodeID, activityID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYSTATENODEIDANDACTIVITYID;
            finderArgs = new Object[] {
                    activityStateNodeID, activityID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivityState> list = (List<LFActivityState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivityState lfActivityState : list) {
                if (!Validator.equals(activityStateNodeID,
                            lfActivityState.getActivityStateNodeID()) ||
                        !Validator.equals(activityID,
                            lfActivityState.getActivityID())) {
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

            query.append(_SQL_SELECT_LFACTIVITYSTATE_WHERE);

            if (activityStateNodeID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_2);
            }

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_1);
            } else {
                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_2);
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

                if (activityStateNodeID != null) {
                    qPos.add(activityStateNodeID.intValue());
                }

                if (activityID != null) {
                    qPos.add(activityID);
                }

                list = (List<LFActivityState>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState findByActivityStateNodeIDAndActivityID_First(
        Integer activityStateNodeID, String activityID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateException, SystemException {
        LFActivityState lfActivityState = fetchByActivityStateNodeIDAndActivityID_First(activityStateNodeID,
                activityID, orderByComparator);

        if (lfActivityState != null) {
            return lfActivityState;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityStateNodeID=");
        msg.append(activityStateNodeID);

        msg.append(", activityID=");
        msg.append(activityID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityStateException(msg.toString());
    }

    /**
     * Returns the first l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState fetchByActivityStateNodeIDAndActivityID_First(
        Integer activityStateNodeID, String activityID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFActivityState> list = findByActivityStateNodeIDAndActivityID(activityStateNodeID,
                activityID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState findByActivityStateNodeIDAndActivityID_Last(
        Integer activityStateNodeID, String activityID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateException, SystemException {
        LFActivityState lfActivityState = fetchByActivityStateNodeIDAndActivityID_Last(activityStateNodeID,
                activityID, orderByComparator);

        if (lfActivityState != null) {
            return lfActivityState;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityStateNodeID=");
        msg.append(activityStateNodeID);

        msg.append(", activityID=");
        msg.append(activityID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityStateException(msg.toString());
    }

    /**
     * Returns the last l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState fetchByActivityStateNodeIDAndActivityID_Last(
        Integer activityStateNodeID, String activityID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByActivityStateNodeIDAndActivityID(activityStateNodeID,
                activityID);

        List<LFActivityState> list = findByActivityStateNodeIDAndActivityID(activityStateNodeID,
                activityID, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f activity states before and after the current l f activity state in the ordered set where activityStateNodeID = &#63; and activityID = &#63;.
     *
     * @param id the primary key of the current l f activity state
     * @param activityStateNodeID the activity state node i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f activity state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState[] findByActivityStateNodeIDAndActivityID_PrevAndNext(
        long id, Integer activityStateNodeID, String activityID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateException, SystemException {
        LFActivityState lfActivityState = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFActivityState[] array = new LFActivityStateImpl[3];

            array[0] = getByActivityStateNodeIDAndActivityID_PrevAndNext(session,
                    lfActivityState, activityStateNodeID, activityID,
                    orderByComparator, true);

            array[1] = lfActivityState;

            array[2] = getByActivityStateNodeIDAndActivityID_PrevAndNext(session,
                    lfActivityState, activityStateNodeID, activityID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivityState getByActivityStateNodeIDAndActivityID_PrevAndNext(
        Session session, LFActivityState lfActivityState,
        Integer activityStateNodeID, String activityID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITYSTATE_WHERE);

        if (activityStateNodeID == null) {
            query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_2);
        }

        if (activityID == null) {
            query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_1);
        } else {
            if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_3);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_2);
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

        if (activityStateNodeID != null) {
            qPos.add(activityStateNodeID.intValue());
        }

        if (activityID != null) {
            qPos.add(activityID);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivityState);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivityState> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f activity states where activityStateNodeID = any &#63; and activityID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateNodeIDs the activity state node i ds
     * @param activityID the activity i d
     * @return the matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeIDAndActivityID(
        Integer[] activityStateNodeIDs, String activityID)
        throws SystemException {
        return findByActivityStateNodeIDAndActivityID(activityStateNodeIDs,
            activityID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activity states where activityStateNodeID = any &#63; and activityID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateNodeIDs the activity state node i ds
     * @param activityID the activity i d
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @return the range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeIDAndActivityID(
        Integer[] activityStateNodeIDs, String activityID, int start, int end)
        throws SystemException {
        return findByActivityStateNodeIDAndActivityID(activityStateNodeIDs,
            activityID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activity states where activityStateNodeID = any &#63; and activityID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateNodeIDs the activity state node i ds
     * @param activityID the activity i d
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeIDAndActivityID(
        Integer[] activityStateNodeIDs, String activityID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYSTATENODEIDANDACTIVITYID;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderArgs = new Object[] {
                    StringUtil.merge(activityStateNodeIDs), activityID
                };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(activityStateNodeIDs), activityID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivityState> list = (List<LFActivityState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivityState lfActivityState : list) {
                if (!ArrayUtil.contains(activityStateNodeIDs,
                            lfActivityState.getActivityStateNodeID()) ||
                        !Validator.equals(activityID,
                            lfActivityState.getActivityID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFACTIVITYSTATE_WHERE);

            boolean conjunctionable = false;

            if ((activityStateNodeIDs != null) &&
                    (activityStateNodeIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < activityStateNodeIDs.length; i++) {
                    if (activityStateNodeIDs[i] == null) {
                        query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_5);
                    }

                    if ((i + 1) < activityStateNodeIDs.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_4);
            } else {
                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_6);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_5);
                }
            }

            conjunctionable = true;

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

                if (activityStateNodeIDs != null) {
                    for (Integer activityStateNodeID : activityStateNodeIDs) {
                        if (activityStateNodeID != null) {
                            qPos.add(activityStateNodeID);
                        }
                    }
                }

                if (activityID != null) {
                    qPos.add(activityID);
                }

                list = (List<LFActivityState>) QueryUtil.list(q, getDialect(),
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
     * Returns all the l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
     *
     * @param activityID the activity i d
     * @param activityStateNodeID the activity state node i d
     * @param activityStateTreeID the activity state tree i d
     * @return the matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
        String activityID, Integer activityStateNodeID,
        Integer activityStateTreeID) throws SystemException {
        return findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID,
            activityStateNodeID, activityStateTreeID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityID the activity i d
     * @param activityStateNodeID the activity state node i d
     * @param activityStateTreeID the activity state tree i d
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @return the range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
        String activityID, Integer activityStateNodeID,
        Integer activityStateTreeID, int start, int end)
        throws SystemException {
        return findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID,
            activityStateNodeID, activityStateTreeID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityID the activity i d
     * @param activityStateNodeID the activity state node i d
     * @param activityStateTreeID the activity state tree i d
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
        String activityID, Integer activityStateNodeID,
        Integer activityStateTreeID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID;
            finderArgs = new Object[] {
                    activityID, activityStateNodeID, activityStateTreeID
                };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID;
            finderArgs = new Object[] {
                    activityID, activityStateNodeID, activityStateTreeID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivityState> list = (List<LFActivityState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivityState lfActivityState : list) {
                if (!Validator.equals(activityID,
                            lfActivityState.getActivityID()) ||
                        !Validator.equals(activityStateNodeID,
                            lfActivityState.getActivityStateNodeID()) ||
                        !Validator.equals(activityStateTreeID,
                            lfActivityState.getActivityStateTreeID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_LFACTIVITYSTATE_WHERE);

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_1);
            } else {
                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_2);
                }
            }

            if (activityStateNodeID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_2);
            }

            if (activityStateTreeID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_2);
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

                if (activityID != null) {
                    qPos.add(activityID);
                }

                if (activityStateNodeID != null) {
                    qPos.add(activityStateNodeID.intValue());
                }

                if (activityStateTreeID != null) {
                    qPos.add(activityStateTreeID.intValue());
                }

                list = (List<LFActivityState>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f activity state in the ordered set where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
     *
     * @param activityID the activity i d
     * @param activityStateNodeID the activity state node i d
     * @param activityStateTreeID the activity state tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID_First(
        String activityID, Integer activityStateNodeID,
        Integer activityStateTreeID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateException, SystemException {
        LFActivityState lfActivityState = fetchByActivityIDAndActivityStateNodeIDAndActivityStateTreeID_First(activityID,
                activityStateNodeID, activityStateTreeID, orderByComparator);

        if (lfActivityState != null) {
            return lfActivityState;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityID=");
        msg.append(activityID);

        msg.append(", activityStateNodeID=");
        msg.append(activityStateNodeID);

        msg.append(", activityStateTreeID=");
        msg.append(activityStateTreeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityStateException(msg.toString());
    }

    /**
     * Returns the first l f activity state in the ordered set where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
     *
     * @param activityID the activity i d
     * @param activityStateNodeID the activity state node i d
     * @param activityStateTreeID the activity state tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState fetchByActivityIDAndActivityStateNodeIDAndActivityStateTreeID_First(
        String activityID, Integer activityStateNodeID,
        Integer activityStateTreeID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFActivityState> list = findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID,
                activityStateNodeID, activityStateTreeID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f activity state in the ordered set where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
     *
     * @param activityID the activity i d
     * @param activityStateNodeID the activity state node i d
     * @param activityStateTreeID the activity state tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID_Last(
        String activityID, Integer activityStateNodeID,
        Integer activityStateTreeID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateException, SystemException {
        LFActivityState lfActivityState = fetchByActivityIDAndActivityStateNodeIDAndActivityStateTreeID_Last(activityID,
                activityStateNodeID, activityStateTreeID, orderByComparator);

        if (lfActivityState != null) {
            return lfActivityState;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityID=");
        msg.append(activityID);

        msg.append(", activityStateNodeID=");
        msg.append(activityStateNodeID);

        msg.append(", activityStateTreeID=");
        msg.append(activityStateTreeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityStateException(msg.toString());
    }

    /**
     * Returns the last l f activity state in the ordered set where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
     *
     * @param activityID the activity i d
     * @param activityStateNodeID the activity state node i d
     * @param activityStateTreeID the activity state tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState fetchByActivityIDAndActivityStateNodeIDAndActivityStateTreeID_Last(
        String activityID, Integer activityStateNodeID,
        Integer activityStateTreeID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID,
                activityStateNodeID, activityStateTreeID);

        List<LFActivityState> list = findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID,
                activityStateNodeID, activityStateTreeID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f activity states before and after the current l f activity state in the ordered set where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
     *
     * @param id the primary key of the current l f activity state
     * @param activityID the activity i d
     * @param activityStateNodeID the activity state node i d
     * @param activityStateTreeID the activity state tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f activity state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState[] findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID_PrevAndNext(
        long id, String activityID, Integer activityStateNodeID,
        Integer activityStateTreeID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateException, SystemException {
        LFActivityState lfActivityState = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFActivityState[] array = new LFActivityStateImpl[3];

            array[0] = getByActivityIDAndActivityStateNodeIDAndActivityStateTreeID_PrevAndNext(session,
                    lfActivityState, activityID, activityStateNodeID,
                    activityStateTreeID, orderByComparator, true);

            array[1] = lfActivityState;

            array[2] = getByActivityIDAndActivityStateNodeIDAndActivityStateTreeID_PrevAndNext(session,
                    lfActivityState, activityID, activityStateNodeID,
                    activityStateTreeID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivityState getByActivityIDAndActivityStateNodeIDAndActivityStateTreeID_PrevAndNext(
        Session session, LFActivityState lfActivityState, String activityID,
        Integer activityStateNodeID, Integer activityStateTreeID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITYSTATE_WHERE);

        if (activityID == null) {
            query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_1);
        } else {
            if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_3);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_2);
            }
        }

        if (activityStateNodeID == null) {
            query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_2);
        }

        if (activityStateTreeID == null) {
            query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_2);
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

        if (activityID != null) {
            qPos.add(activityID);
        }

        if (activityStateNodeID != null) {
            qPos.add(activityStateNodeID.intValue());
        }

        if (activityStateTreeID != null) {
            qPos.add(activityStateTreeID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivityState);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivityState> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f activity states where activityID = &#63; and activityStateNodeID = any &#63; and activityStateTreeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityID the activity i d
     * @param activityStateNodeIDs the activity state node i ds
     * @param activityStateTreeID the activity state tree i d
     * @return the matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
        String activityID, Integer[] activityStateNodeIDs,
        Integer activityStateTreeID) throws SystemException {
        return findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID,
            activityStateNodeIDs, activityStateTreeID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activity states where activityID = &#63; and activityStateNodeID = any &#63; and activityStateTreeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityID the activity i d
     * @param activityStateNodeIDs the activity state node i ds
     * @param activityStateTreeID the activity state tree i d
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @return the range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
        String activityID, Integer[] activityStateNodeIDs,
        Integer activityStateTreeID, int start, int end)
        throws SystemException {
        return findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID,
            activityStateNodeIDs, activityStateTreeID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activity states where activityID = &#63; and activityStateNodeID = any &#63; and activityStateTreeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityID the activity i d
     * @param activityStateNodeIDs the activity state node i ds
     * @param activityStateTreeID the activity state tree i d
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
        String activityID, Integer[] activityStateNodeIDs,
        Integer activityStateTreeID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderArgs = new Object[] {
                    activityID, StringUtil.merge(activityStateNodeIDs),
                    activityStateTreeID
                };
        } else {
            finderArgs = new Object[] {
                    activityID, StringUtil.merge(activityStateNodeIDs),
                    activityStateTreeID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivityState> list = (List<LFActivityState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivityState lfActivityState : list) {
                if (!Validator.equals(activityID,
                            lfActivityState.getActivityID()) ||
                        !ArrayUtil.contains(activityStateNodeIDs,
                            lfActivityState.getActivityStateNodeID()) ||
                        !Validator.equals(activityStateTreeID,
                            lfActivityState.getActivityStateTreeID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFACTIVITYSTATE_WHERE);

            boolean conjunctionable = false;

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_4);
            } else {
                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_6);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_5);
                }
            }

            conjunctionable = true;

            if ((activityStateNodeIDs != null) &&
                    (activityStateNodeIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < activityStateNodeIDs.length; i++) {
                    if (activityStateNodeIDs[i] == null) {
                        query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_5);
                    }

                    if ((i + 1) < activityStateNodeIDs.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            if (activityStateTreeID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_5_NULL);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_5);
            }

            conjunctionable = true;

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

                if (activityID != null) {
                    qPos.add(activityID);
                }

                if (activityStateNodeIDs != null) {
                    for (Integer activityStateNodeID : activityStateNodeIDs) {
                        if (activityStateNodeID != null) {
                            qPos.add(activityStateNodeID);
                        }
                    }
                }

                if (activityStateTreeID != null) {
                    qPos.add(activityStateTreeID.intValue());
                }

                list = (List<LFActivityState>) QueryUtil.list(q, getDialect(),
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
     * Returns all the l f activity states where activityStateNodeID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @return the matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeID(
        Integer activityStateNodeID) throws SystemException {
        return findByActivityStateNodeID(activityStateNodeID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activity states where activityStateNodeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateNodeID the activity state node i d
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @return the range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeID(
        Integer activityStateNodeID, int start, int end)
        throws SystemException {
        return findByActivityStateNodeID(activityStateNodeID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activity states where activityStateNodeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateNodeID the activity state node i d
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeID(
        Integer activityStateNodeID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATENODEID;
            finderArgs = new Object[] { activityStateNodeID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYSTATENODEID;
            finderArgs = new Object[] {
                    activityStateNodeID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivityState> list = (List<LFActivityState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivityState lfActivityState : list) {
                if (!Validator.equals(activityStateNodeID,
                            lfActivityState.getActivityStateNodeID())) {
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

            query.append(_SQL_SELECT_LFACTIVITYSTATE_WHERE);

            if (activityStateNodeID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_2);
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

                if (activityStateNodeID != null) {
                    qPos.add(activityStateNodeID.intValue());
                }

                list = (List<LFActivityState>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f activity state in the ordered set where activityStateNodeID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState findByActivityStateNodeID_First(
        Integer activityStateNodeID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateException, SystemException {
        LFActivityState lfActivityState = fetchByActivityStateNodeID_First(activityStateNodeID,
                orderByComparator);

        if (lfActivityState != null) {
            return lfActivityState;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityStateNodeID=");
        msg.append(activityStateNodeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityStateException(msg.toString());
    }

    /**
     * Returns the first l f activity state in the ordered set where activityStateNodeID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState fetchByActivityStateNodeID_First(
        Integer activityStateNodeID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFActivityState> list = findByActivityStateNodeID(activityStateNodeID,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f activity state in the ordered set where activityStateNodeID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState findByActivityStateNodeID_Last(
        Integer activityStateNodeID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateException, SystemException {
        LFActivityState lfActivityState = fetchByActivityStateNodeID_Last(activityStateNodeID,
                orderByComparator);

        if (lfActivityState != null) {
            return lfActivityState;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityStateNodeID=");
        msg.append(activityStateNodeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityStateException(msg.toString());
    }

    /**
     * Returns the last l f activity state in the ordered set where activityStateNodeID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity state, or <code>null</code> if a matching l f activity state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState fetchByActivityStateNodeID_Last(
        Integer activityStateNodeID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByActivityStateNodeID(activityStateNodeID);

        List<LFActivityState> list = findByActivityStateNodeID(activityStateNodeID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f activity states before and after the current l f activity state in the ordered set where activityStateNodeID = &#63;.
     *
     * @param id the primary key of the current l f activity state
     * @param activityStateNodeID the activity state node i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f activity state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException if a l f activity state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivityState[] findByActivityStateNodeID_PrevAndNext(long id,
        Integer activityStateNodeID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityStateException, SystemException {
        LFActivityState lfActivityState = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFActivityState[] array = new LFActivityStateImpl[3];

            array[0] = getByActivityStateNodeID_PrevAndNext(session,
                    lfActivityState, activityStateNodeID, orderByComparator,
                    true);

            array[1] = lfActivityState;

            array[2] = getByActivityStateNodeID_PrevAndNext(session,
                    lfActivityState, activityStateNodeID, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivityState getByActivityStateNodeID_PrevAndNext(
        Session session, LFActivityState lfActivityState,
        Integer activityStateNodeID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITYSTATE_WHERE);

        if (activityStateNodeID == null) {
            query.append(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_2);
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

        if (activityStateNodeID != null) {
            qPos.add(activityStateNodeID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivityState);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivityState> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f activity states where activityStateNodeID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateNodeIDs the activity state node i ds
     * @return the matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeID(
        Integer[] activityStateNodeIDs) throws SystemException {
        return findByActivityStateNodeID(activityStateNodeIDs,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activity states where activityStateNodeID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateNodeIDs the activity state node i ds
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @return the range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeID(
        Integer[] activityStateNodeIDs, int start, int end)
        throws SystemException {
        return findByActivityStateNodeID(activityStateNodeIDs, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activity states where activityStateNodeID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateNodeIDs the activity state node i ds
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findByActivityStateNodeID(
        Integer[] activityStateNodeIDs, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYSTATENODEID;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderArgs = new Object[] { StringUtil.merge(activityStateNodeIDs) };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(activityStateNodeIDs),
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivityState> list = (List<LFActivityState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivityState lfActivityState : list) {
                if (!ArrayUtil.contains(activityStateNodeIDs,
                            lfActivityState.getActivityStateNodeID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFACTIVITYSTATE_WHERE);

            boolean conjunctionable = false;

            if ((activityStateNodeIDs != null) &&
                    (activityStateNodeIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < activityStateNodeIDs.length; i++) {
                    if (activityStateNodeIDs[i] == null) {
                        query.append(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_5);
                    }

                    if ((i + 1) < activityStateNodeIDs.length) {
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

                if (activityStateNodeIDs != null) {
                    for (Integer activityStateNodeID : activityStateNodeIDs) {
                        if (activityStateNodeID != null) {
                            qPos.add(activityStateNodeID);
                        }
                    }
                }

                list = (List<LFActivityState>) QueryUtil.list(q, getDialect(),
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
     * Returns all the l f activity states.
     *
     * @return the l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activity states.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @return the range of l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activity states.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f activity states
     * @param end the upper bound of the range of l f activity states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f activity states
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivityState> findAll(int start, int end,
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

        List<LFActivityState> list = (List<LFActivityState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFACTIVITYSTATE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFACTIVITYSTATE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFActivityState>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFActivityState>) QueryUtil.list(q,
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
     * Removes all the l f activity states where activityStateNodeID = &#63; and activityID = &#63; from the database.
     *
     * @param activityStateNodeID the activity state node i d
     * @param activityID the activity i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByActivityStateNodeIDAndActivityID(
        Integer activityStateNodeID, String activityID)
        throws SystemException {
        for (LFActivityState lfActivityState : findByActivityStateNodeIDAndActivityID(
                activityStateNodeID, activityID)) {
            remove(lfActivityState);
        }
    }

    /**
     * Removes all the l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63; from the database.
     *
     * @param activityID the activity i d
     * @param activityStateNodeID the activity state node i d
     * @param activityStateTreeID the activity state tree i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
        String activityID, Integer activityStateNodeID,
        Integer activityStateTreeID) throws SystemException {
        for (LFActivityState lfActivityState : findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
                activityID, activityStateNodeID, activityStateTreeID)) {
            remove(lfActivityState);
        }
    }

    /**
     * Removes all the l f activity states where activityStateNodeID = &#63; from the database.
     *
     * @param activityStateNodeID the activity state node i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByActivityStateNodeID(Integer activityStateNodeID)
        throws SystemException {
        for (LFActivityState lfActivityState : findByActivityStateNodeID(
                activityStateNodeID)) {
            remove(lfActivityState);
        }
    }

    /**
     * Removes all the l f activity states from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFActivityState lfActivityState : findAll()) {
            remove(lfActivityState);
        }
    }

    /**
     * Returns the number of l f activity states where activityStateNodeID = &#63; and activityID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @param activityID the activity i d
     * @return the number of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public int countByActivityStateNodeIDAndActivityID(
        Integer activityStateNodeID, String activityID)
        throws SystemException {
        Object[] finderArgs = new Object[] { activityStateNodeID, activityID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATENODEIDANDACTIVITYID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFACTIVITYSTATE_WHERE);

            if (activityStateNodeID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_2);
            }

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_1);
            } else {
                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (activityStateNodeID != null) {
                    qPos.add(activityStateNodeID.intValue());
                }

                if (activityID != null) {
                    qPos.add(activityID);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATENODEIDANDACTIVITYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f activity states where activityStateNodeID = any &#63; and activityID = &#63;.
     *
     * @param activityStateNodeIDs the activity state node i ds
     * @param activityID the activity i d
     * @return the number of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public int countByActivityStateNodeIDAndActivityID(
        Integer[] activityStateNodeIDs, String activityID)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                StringUtil.merge(activityStateNodeIDs), activityID
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVITYSTATENODEIDANDACTIVITYID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFACTIVITYSTATE_WHERE);

            boolean conjunctionable = false;

            if ((activityStateNodeIDs != null) &&
                    (activityStateNodeIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < activityStateNodeIDs.length; i++) {
                    if (activityStateNodeIDs[i] == null) {
                        query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYSTATENODEID_5);
                    }

                    if ((i + 1) < activityStateNodeIDs.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_4);
            } else {
                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_6);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYSTATENODEIDANDACTIVITYID_ACTIVITYID_5);
                }
            }

            conjunctionable = true;

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (activityStateNodeIDs != null) {
                    for (Integer activityStateNodeID : activityStateNodeIDs) {
                        if (activityStateNodeID != null) {
                            qPos.add(activityStateNodeID);
                        }
                    }
                }

                if (activityID != null) {
                    qPos.add(activityID);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVITYSTATENODEIDANDACTIVITYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f activity states where activityID = &#63; and activityStateNodeID = &#63; and activityStateTreeID = &#63;.
     *
     * @param activityID the activity i d
     * @param activityStateNodeID the activity state node i d
     * @param activityStateTreeID the activity state tree i d
     * @return the number of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public int countByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
        String activityID, Integer activityStateNodeID,
        Integer activityStateTreeID) throws SystemException {
        Object[] finderArgs = new Object[] {
                activityID, activityStateNodeID, activityStateTreeID
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_LFACTIVITYSTATE_WHERE);

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_1);
            } else {
                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_2);
                }
            }

            if (activityStateNodeID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_2);
            }

            if (activityStateTreeID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (activityID != null) {
                    qPos.add(activityID);
                }

                if (activityStateNodeID != null) {
                    qPos.add(activityStateNodeID.intValue());
                }

                if (activityStateTreeID != null) {
                    qPos.add(activityStateTreeID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f activity states where activityID = &#63; and activityStateNodeID = any &#63; and activityStateTreeID = &#63;.
     *
     * @param activityID the activity i d
     * @param activityStateNodeIDs the activity state node i ds
     * @param activityStateTreeID the activity state tree i d
     * @return the number of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public int countByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
        String activityID, Integer[] activityStateNodeIDs,
        Integer activityStateTreeID) throws SystemException {
        Object[] finderArgs = new Object[] {
                activityID, StringUtil.merge(activityStateNodeIDs),
                activityStateTreeID
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFACTIVITYSTATE_WHERE);

            boolean conjunctionable = false;

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_4);
            } else {
                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_6);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYID_5);
                }
            }

            conjunctionable = true;

            if ((activityStateNodeIDs != null) &&
                    (activityStateNodeIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < activityStateNodeIDs.length; i++) {
                    if (activityStateNodeIDs[i] == null) {
                        query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATENODEID_5);
                    }

                    if ((i + 1) < activityStateNodeIDs.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            if (activityStateTreeID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_5_NULL);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID_ACTIVITYSTATETREEID_5);
            }

            conjunctionable = true;

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (activityID != null) {
                    qPos.add(activityID);
                }

                if (activityStateNodeIDs != null) {
                    for (Integer activityStateNodeID : activityStateNodeIDs) {
                        if (activityStateNodeID != null) {
                            qPos.add(activityStateNodeID);
                        }
                    }
                }

                if (activityStateTreeID != null) {
                    qPos.add(activityStateTreeID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVITYIDANDACTIVITYSTATENODEIDANDACTIVITYSTATETREEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f activity states where activityStateNodeID = &#63;.
     *
     * @param activityStateNodeID the activity state node i d
     * @return the number of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public int countByActivityStateNodeID(Integer activityStateNodeID)
        throws SystemException {
        Object[] finderArgs = new Object[] { activityStateNodeID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATENODEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFACTIVITYSTATE_WHERE);

            if (activityStateNodeID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (activityStateNodeID != null) {
                    qPos.add(activityStateNodeID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATENODEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f activity states where activityStateNodeID = any &#63;.
     *
     * @param activityStateNodeIDs the activity state node i ds
     * @return the number of matching l f activity states
     * @throws SystemException if a system exception occurred
     */
    public int countByActivityStateNodeID(Integer[] activityStateNodeIDs)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                StringUtil.merge(activityStateNodeIDs)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVITYSTATENODEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFACTIVITYSTATE_WHERE);

            boolean conjunctionable = false;

            if ((activityStateNodeIDs != null) &&
                    (activityStateNodeIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < activityStateNodeIDs.length; i++) {
                    if (activityStateNodeIDs[i] == null) {
                        query.append(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_ACTIVITYSTATENODEID_ACTIVITYSTATENODEID_5);
                    }

                    if ((i + 1) < activityStateNodeIDs.length) {
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

                if (activityStateNodeIDs != null) {
                    for (Integer activityStateNodeID : activityStateNodeIDs) {
                        if (activityStateNodeID != null) {
                            qPos.add(activityStateNodeID);
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

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVITYSTATENODEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f activity states.
     *
     * @return the number of l f activity states
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFACTIVITYSTATE);

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
     * Initializes the l f activity state persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFActivityState")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFActivityState>> listenersList = new ArrayList<ModelListener<LFActivityState>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFActivityState>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFActivityStateImpl.class.getName());
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
