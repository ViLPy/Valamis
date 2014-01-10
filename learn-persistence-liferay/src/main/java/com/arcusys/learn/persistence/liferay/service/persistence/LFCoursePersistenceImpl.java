package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFCourseException;
import com.arcusys.learn.persistence.liferay.model.LFCourse;
import com.arcusys.learn.persistence.liferay.model.impl.LFCourseImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFCourseModelImpl;
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
 * The persistence implementation for the l f course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCoursePersistence
 * @see LFCourseUtil
 * @generated
 */
public class LFCoursePersistenceImpl extends BasePersistenceImpl<LFCourse>
    implements LFCoursePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFCourseUtil} to access the l f course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFCourseImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_COURSEIDANDUSERID = new FinderPath(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCourseModelImpl.FINDER_CACHE_ENABLED, LFCourseImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByCourseIdAndUserId",
            new String[] { Integer.class.getName(), Integer.class.getName() },
            LFCourseModelImpl.COURSEID_COLUMN_BITMASK |
            LFCourseModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDUSERID = new FinderPath(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCourseIdAndUserId",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_GRADE = new FinderPath(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCourseModelImpl.FINDER_CACHE_ENABLED, LFCourseImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByGrade",
            new String[] { String.class.getName() },
            LFCourseModelImpl.GRADE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GRADE = new FinderPath(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGrade",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCourseModelImpl.FINDER_CACHE_ENABLED, LFCourseImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCourseModelImpl.FINDER_CACHE_ENABLED, LFCourseImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFCOURSE = "SELECT lfCourse FROM LFCourse lfCourse";
    private static final String _SQL_SELECT_LFCOURSE_WHERE = "SELECT lfCourse FROM LFCourse lfCourse WHERE ";
    private static final String _SQL_COUNT_LFCOURSE = "SELECT COUNT(lfCourse) FROM LFCourse lfCourse";
    private static final String _SQL_COUNT_LFCOURSE_WHERE = "SELECT COUNT(lfCourse) FROM LFCourse lfCourse WHERE ";
    private static final String _FINDER_COLUMN_COURSEIDANDUSERID_COURSEID_NULL = "lfCourse.courseID IS NULL";
    private static final String _FINDER_COLUMN_COURSEIDANDUSERID_COURSEID_NULL_2 =
        "lfCourse.courseID IS NULL  AND ";
    private static final String _FINDER_COLUMN_COURSEIDANDUSERID_COURSEID_2 = "lfCourse.courseID = ? AND ";
    private static final String _FINDER_COLUMN_COURSEIDANDUSERID_USERID_NULL = "lfCourse.userID IS NULL";
    private static final String _FINDER_COLUMN_COURSEIDANDUSERID_USERID_NULL_2 = "lfCourse.userID IS NULL ";
    private static final String _FINDER_COLUMN_COURSEIDANDUSERID_USERID_2 = "lfCourse.userID = ?";
    private static final String _FINDER_COLUMN_GRADE_GRADE_1 = "lfCourse.grade IS NULL";
    private static final String _FINDER_COLUMN_GRADE_GRADE_NULL = "lfCourse.grade IS NULL";
    private static final String _FINDER_COLUMN_GRADE_GRADE_NULL_2 = "lfCourse.grade IS NULL ";
    private static final String _FINDER_COLUMN_GRADE_GRADE_2 = "lfCourse.grade = ?";
    private static final String _FINDER_COLUMN_GRADE_GRADE_3 = "(lfCourse.grade IS NULL OR lfCourse.grade = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfCourse.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFCourse exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFCourse exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFCoursePersistenceImpl.class);
    private static LFCourse _nullLFCourse = new LFCourseImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFCourse> toCacheModel() {
                return _nullLFCourseCacheModel;
            }
        };

    private static CacheModel<LFCourse> _nullLFCourseCacheModel = new CacheModel<LFCourse>() {
            public LFCourse toEntityModel() {
                return _nullLFCourse;
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
     * Caches the l f course in the entity cache if it is enabled.
     *
     * @param lfCourse the l f course
     */
    public void cacheResult(LFCourse lfCourse) {
        EntityCacheUtil.putResult(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCourseImpl.class, lfCourse.getPrimaryKey(), lfCourse);

        boolean noNullsInCOURSEIDANDUSERID = true;

        if (lfCourse.getCourseID() == null) {
            noNullsInCOURSEIDANDUSERID = false;
        }

        if (lfCourse.getUserID() == null) {
            noNullsInCOURSEIDANDUSERID = false;
        }

        if (noNullsInCOURSEIDANDUSERID) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDANDUSERID,
                new Object[] {
                    Integer.valueOf(lfCourse.getCourseID()),
                    Integer.valueOf(lfCourse.getUserID())
                }, lfCourse);
        }

        boolean noNullsInGRADE = true;

        if (noNullsInGRADE) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADE,
                new Object[] { lfCourse.getGrade() }, lfCourse);
        }

        lfCourse.resetOriginalValues();
    }

    /**
     * Caches the l f courses in the entity cache if it is enabled.
     *
     * @param lfCourses the l f courses
     */
    public void cacheResult(List<LFCourse> lfCourses) {
        for (LFCourse lfCourse : lfCourses) {
            if (EntityCacheUtil.getResult(
                        LFCourseModelImpl.ENTITY_CACHE_ENABLED,
                        LFCourseImpl.class, lfCourse.getPrimaryKey()) == null) {
                cacheResult(lfCourse);
            } else {
                lfCourse.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f courses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFCourseImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFCourseImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f course.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFCourse lfCourse) {
        EntityCacheUtil.removeResult(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCourseImpl.class, lfCourse.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfCourse);
    }

    @Override
    public void clearCache(List<LFCourse> lfCourses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFCourse lfCourse : lfCourses) {
            EntityCacheUtil.removeResult(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
                LFCourseImpl.class, lfCourse.getPrimaryKey());

            clearUniqueFindersCache(lfCourse);
        }
    }

    protected void clearUniqueFindersCache(LFCourse lfCourse) {
        boolean noNullsInCOURSEIDANDUSERID = true;

        if (lfCourse.getCourseID() == null) {
            noNullsInCOURSEIDANDUSERID = false;
        }

        if (lfCourse.getUserID() == null) {
            noNullsInCOURSEIDANDUSERID = false;
        }

        if (noNullsInCOURSEIDANDUSERID) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEIDANDUSERID,
                new Object[] {
                    Integer.valueOf(lfCourse.getCourseID()),
                    Integer.valueOf(lfCourse.getUserID())
                });
        }

        boolean noNullsInGRADE = true;

        if (noNullsInGRADE) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GRADE,
                new Object[] { lfCourse.getGrade() });
        }
    }

    /**
     * Creates a new l f course with the primary key. Does not add the l f course to the database.
     *
     * @param id the primary key for the new l f course
     * @return the new l f course
     */
    public LFCourse create(long id) {
        LFCourse lfCourse = new LFCourseImpl();

        lfCourse.setNew(true);
        lfCourse.setPrimaryKey(id);

        return lfCourse;
    }

    /**
     * Removes the l f course with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f course
     * @return the l f course that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a l f course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCourse remove(long id)
        throws NoSuchLFCourseException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f course with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f course
     * @return the l f course that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a l f course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCourse remove(Serializable primaryKey)
        throws NoSuchLFCourseException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFCourse lfCourse = (LFCourse) session.get(LFCourseImpl.class,
                    primaryKey);

            if (lfCourse == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfCourse);
        } catch (NoSuchLFCourseException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFCourse removeImpl(LFCourse lfCourse) throws SystemException {
        lfCourse = toUnwrappedModel(lfCourse);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfCourse);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfCourse);

        return lfCourse;
    }

    @Override
    public LFCourse updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse,
        boolean merge) throws SystemException {
        lfCourse = toUnwrappedModel(lfCourse);

        boolean isNew = lfCourse.isNew();

        LFCourseModelImpl lfCourseModelImpl = (LFCourseModelImpl) lfCourse;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfCourse, merge);

            lfCourse.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFCourseModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCourseImpl.class, lfCourse.getPrimaryKey(), lfCourse);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDANDUSERID,
                new Object[] { /*Integer.valueOf( */
                lfCourse.getCourseID()/*) */
                , /*Integer.valueOf( */
                lfCourse.getUserID()/*) */
                }, lfCourse);

            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADE,
                new Object[] { lfCourse.getGrade() }, lfCourse);
        } else {
            if ((lfCourseModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_COURSEIDANDUSERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /*        Integer.valueOf( */
                        lfCourseModelImpl.getOriginalCourseID(),
                        /*        Integer.valueOf( */
                        lfCourseModelImpl.getOriginalUserID()
                    /*        ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDUSERID,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEIDANDUSERID,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDANDUSERID,
                    new Object[] { /*        Integer.valueOf( */
                    lfCourse.getCourseID()/*        ) */
                    , /*        Integer.valueOf( */
                    lfCourse.getUserID()/*        ) */
                    }, lfCourse);
            }

            if ((lfCourseModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_GRADE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCourseModelImpl.getOriginalGrade()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GRADE, args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GRADE, args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADE,
                    new Object[] { lfCourse.getGrade() }, lfCourse);
            }
        }

        return lfCourse;
    }

    protected LFCourse toUnwrappedModel(LFCourse lfCourse) {
        if (lfCourse instanceof LFCourseImpl) {
            return lfCourse;
        }

        LFCourseImpl lfCourseImpl = new LFCourseImpl();

        lfCourseImpl.setNew(lfCourse.isNew());
        lfCourseImpl.setPrimaryKey(lfCourse.getPrimaryKey());

        lfCourseImpl.setId(lfCourse.getId());
        lfCourseImpl.setCourseID(lfCourse.getCourseID());
        lfCourseImpl.setUserID(lfCourse.getUserID());
        lfCourseImpl.setGrade(lfCourse.getGrade());
        lfCourseImpl.setComment(lfCourse.getComment());
        lfCourseImpl.setDate(lfCourse.getDate());

        return lfCourseImpl;
    }

    /**
     * Returns the l f course with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f course
     * @return the l f course
     * @throws com.liferay.portal.NoSuchModelException if a l f course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCourse findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f course with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCourseException} if it could not be found.
     *
     * @param id the primary key of the l f course
     * @return the l f course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a l f course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCourse findByPrimaryKey(long id)
        throws NoSuchLFCourseException, SystemException {
        LFCourse lfCourse = fetchByPrimaryKey(id);

        if (lfCourse == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfCourse;
    }

    /**
     * Returns the l f course with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f course
     * @return the l f course, or <code>null</code> if a l f course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCourse fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f course with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f course
     * @return the l f course, or <code>null</code> if a l f course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCourse fetchByPrimaryKey(long id) throws SystemException {
        LFCourse lfCourse = (LFCourse) EntityCacheUtil.getResult(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
                LFCourseImpl.class, id);

        if (lfCourse == _nullLFCourse) {
            return null;
        }

        if (lfCourse == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfCourse = (LFCourse) session.get(LFCourseImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfCourse != null) {
                    cacheResult(lfCourse);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFCourseModelImpl.ENTITY_CACHE_ENABLED,
                        LFCourseImpl.class, id, _nullLFCourse);
                }

                closeSession(session);
            }
        }

        return lfCourse;
    }

    /**
     * Returns the l f course where courseID = &#63; and userID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCourseException} if it could not be found.
     *
     * @param courseID the course i d
     * @param userID the user i d
     * @return the matching l f course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a matching l f course could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCourse findByCourseIdAndUserId(Integer courseID, Integer userID)
        throws NoSuchLFCourseException, SystemException {
        LFCourse lfCourse = fetchByCourseIdAndUserId(courseID, userID);

        if (lfCourse == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("courseID=");
            msg.append(courseID);

            msg.append(", userID=");
            msg.append(userID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFCourseException(msg.toString());
        }

        return lfCourse;
    }

    /**
     * Returns the l f course where courseID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param courseID the course i d
     * @param userID the user i d
     * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCourse fetchByCourseIdAndUserId(Integer courseID, Integer userID)
        throws SystemException {
        return fetchByCourseIdAndUserId(courseID, userID, true);
    }

    /**
     * Returns the l f course where courseID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param courseID the course i d
     * @param userID the user i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCourse fetchByCourseIdAndUserId(Integer courseID, Integer userID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { courseID, userID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COURSEIDANDUSERID,
                    finderArgs, this);
        }

        if (result instanceof LFCourse) {
            LFCourse lfCourse = (LFCourse) result;

            if (!Validator.equals(courseID, lfCourse.getCourseID()) ||
                    !Validator.equals(userID, lfCourse.getUserID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFCOURSE_WHERE);

            if (courseID == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDUSERID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDUSERID_COURSEID_2);
            }

            if (userID == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDUSERID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDUSERID_USERID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseID != null) {
                    qPos.add(courseID.intValue());
                }

                if (userID != null) {
                    qPos.add(userID.intValue());
                }

                List<LFCourse> list = q.list();

                result = list;

                LFCourse lfCourse = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDANDUSERID,
                        finderArgs, list);
                } else {
                    lfCourse = list.get(0);

                    cacheResult(lfCourse);

                    if ((lfCourse.getCourseID() != courseID) ||
                            (lfCourse.getUserID() != userID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDANDUSERID,
                            finderArgs, lfCourse);
                    }
                }

                return lfCourse;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEIDANDUSERID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFCourse) result;
            }
        }
    }

    /**
     * Returns the l f course where grade = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCourseException} if it could not be found.
     *
     * @param grade the grade
     * @return the matching l f course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a matching l f course could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCourse findByGrade(String grade)
        throws NoSuchLFCourseException, SystemException {
        LFCourse lfCourse = fetchByGrade(grade);

        if (lfCourse == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("grade=");
            msg.append(grade);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFCourseException(msg.toString());
        }

        return lfCourse;
    }

    /**
     * Returns the l f course where grade = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param grade the grade
     * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCourse fetchByGrade(String grade) throws SystemException {
        return fetchByGrade(grade, true);
    }

    /**
     * Returns the l f course where grade = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param grade the grade
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCourse fetchByGrade(String grade, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { grade };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GRADE,
                    finderArgs, this);
        }

        if (result instanceof LFCourse) {
            LFCourse lfCourse = (LFCourse) result;

            if (!Validator.equals(grade, lfCourse.getGrade())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_LFCOURSE_WHERE);

            if (grade == null) {
                query.append(_FINDER_COLUMN_GRADE_GRADE_1);
            } else {
                if (grade.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_GRADE_GRADE_3);
                } else {
                    query.append(_FINDER_COLUMN_GRADE_GRADE_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (grade != null) {
                    qPos.add(grade);
                }

                List<LFCourse> list = q.list();

                result = list;

                LFCourse lfCourse = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADE,
                        finderArgs, list);
                } else {
                    lfCourse = list.get(0);

                    cacheResult(lfCourse);

                    if ((lfCourse.getGrade() == null) ||
                            !lfCourse.getGrade().equals(grade)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADE,
                            finderArgs, lfCourse);
                    }
                }

                return lfCourse;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GRADE,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFCourse) result;
            }
        }
    }

    /**
     * Returns all the l f courses.
     *
     * @return the l f courses
     * @throws SystemException if a system exception occurred
     */
    public List<LFCourse> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f courses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f courses
     * @param end the upper bound of the range of l f courses (not inclusive)
     * @return the range of l f courses
     * @throws SystemException if a system exception occurred
     */
    public List<LFCourse> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f courses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f courses
     * @param end the upper bound of the range of l f courses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f courses
     * @throws SystemException if a system exception occurred
     */
    public List<LFCourse> findAll(int start, int end,
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

        List<LFCourse> list = (List<LFCourse>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCOURSE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCOURSE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFCourse>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFCourse>) QueryUtil.list(q, getDialect(),
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
     * Removes the l f course where courseID = &#63; and userID = &#63; from the database.
     *
     * @param courseID the course i d
     * @param userID the user i d
     * @return the l f course that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFCourse removeByCourseIdAndUserId(Integer courseID, Integer userID)
        throws NoSuchLFCourseException, SystemException {
        LFCourse lfCourse = findByCourseIdAndUserId(courseID, userID);

        return remove(lfCourse);
    }

    /**
     * Removes the l f course where grade = &#63; from the database.
     *
     * @param grade the grade
     * @return the l f course that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFCourse removeByGrade(String grade)
        throws NoSuchLFCourseException, SystemException {
        LFCourse lfCourse = findByGrade(grade);

        return remove(lfCourse);
    }

    /**
     * Removes all the l f courses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFCourse lfCourse : findAll()) {
            remove(lfCourse);
        }
    }

    /**
     * Returns the number of l f courses where courseID = &#63; and userID = &#63;.
     *
     * @param courseID the course i d
     * @param userID the user i d
     * @return the number of matching l f courses
     * @throws SystemException if a system exception occurred
     */
    public int countByCourseIdAndUserId(Integer courseID, Integer userID)
        throws SystemException {
        Object[] finderArgs = new Object[] { courseID, userID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COURSEIDANDUSERID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFCOURSE_WHERE);

            if (courseID == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDUSERID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDUSERID_COURSEID_2);
            }

            if (userID == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDUSERID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDUSERID_USERID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseID != null) {
                    qPos.add(courseID.intValue());
                }

                if (userID != null) {
                    qPos.add(userID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEIDANDUSERID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f courses where grade = &#63;.
     *
     * @param grade the grade
     * @return the number of matching l f courses
     * @throws SystemException if a system exception occurred
     */
    public int countByGrade(String grade) throws SystemException {
        Object[] finderArgs = new Object[] { grade };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GRADE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCOURSE_WHERE);

            if (grade == null) {
                query.append(_FINDER_COLUMN_GRADE_GRADE_1);
            } else {
                if (grade.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_GRADE_GRADE_3);
                } else {
                    query.append(_FINDER_COLUMN_GRADE_GRADE_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (grade != null) {
                    qPos.add(grade);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GRADE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f courses.
     *
     * @return the number of l f courses
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFCOURSE);

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
     * Initializes the l f course persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFCourse")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFCourse>> listenersList = new ArrayList<ModelListener<LFCourse>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFCourse>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFCourseImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
