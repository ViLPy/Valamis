package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException;
import com.arcusys.learn.persistence.liferay.model.LFQuestion;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuestionImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuestionModelImpl;
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
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupContributionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRuleConditionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPermissionsPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingTrackingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackageTagPersistence;
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
 * The persistence implementation for the l f question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuestionPersistence
 * @see LFQuestionUtil
 * @generated
 */
public class LFQuestionPersistenceImpl extends BasePersistenceImpl<LFQuestion>
    implements LFQuestionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFQuestionUtil} to access the l f question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFQuestionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDCATEGORYID =
        new FinderPath(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionModelImpl.FINDER_CACHE_ENABLED, LFQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCourseIdAndCategoryId",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDCATEGORYID =
        new FinderPath(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionModelImpl.FINDER_CACHE_ENABLED, LFQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCourseIdAndCategoryId",
            new String[] { Integer.class.getName(), Integer.class.getName() },
            LFQuestionModelImpl.COURSEID_COLUMN_BITMASK |
            LFQuestionModelImpl.CATEGORYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDCATEGORYID = new FinderPath(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCourseIdAndCategoryId",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEIDANDCATEGORYID =
        new FinderPath(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "countByCourseIdAndCategoryId",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionModelImpl.FINDER_CACHE_ENABLED, LFQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionModelImpl.FINDER_CACHE_ENABLED, LFQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFQUESTION = "SELECT lfQuestion FROM LFQuestion lfQuestion";
    private static final String _SQL_SELECT_LFQUESTION_WHERE = "SELECT lfQuestion FROM LFQuestion lfQuestion WHERE ";
    private static final String _SQL_COUNT_LFQUESTION = "SELECT COUNT(lfQuestion) FROM LFQuestion lfQuestion";
    private static final String _SQL_COUNT_LFQUESTION_WHERE = "SELECT COUNT(lfQuestion) FROM LFQuestion lfQuestion WHERE ";
    private static final String _FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_NULL =
        "lfQuestion.courseId IS NULL";
    private static final String _FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_NULL_2 =
        "lfQuestion.courseId IS NULL  AND ";
    private static final String _FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_2 = "lfQuestion.courseId = ? AND ";
    private static final String _FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_5 = "(" +
        _removeConjunction(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_2) +
        ")";
    private static final String _FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_NULL =
        "lfQuestion.categoryId IS NULL";
    private static final String _FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_NULL_2 =
        "lfQuestion.categoryId IS NULL ";
    private static final String _FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_2 =
        "lfQuestion.categoryId = ?";
    private static final String _FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_5 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_2) +
        ")";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfQuestion.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFQuestion exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFQuestion exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFQuestionPersistenceImpl.class);
    private static LFQuestion _nullLFQuestion = new LFQuestionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFQuestion> toCacheModel() {
                return _nullLFQuestionCacheModel;
            }
        };

    private static CacheModel<LFQuestion> _nullLFQuestionCacheModel = new CacheModel<LFQuestion>() {
            public LFQuestion toEntityModel() {
                return _nullLFQuestion;
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
    @BeanReference(type = LFUserPersistence.class)
    protected LFUserPersistence lfUserPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the l f question in the entity cache if it is enabled.
     *
     * @param lfQuestion the l f question
     */
    public void cacheResult(LFQuestion lfQuestion) {
        EntityCacheUtil.putResult(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionImpl.class, lfQuestion.getPrimaryKey(), lfQuestion);

        lfQuestion.resetOriginalValues();
    }

    /**
     * Caches the l f questions in the entity cache if it is enabled.
     *
     * @param lfQuestions the l f questions
     */
    public void cacheResult(List<LFQuestion> lfQuestions) {
        for (LFQuestion lfQuestion : lfQuestions) {
            if (EntityCacheUtil.getResult(
                        LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuestionImpl.class, lfQuestion.getPrimaryKey()) == null) {
                cacheResult(lfQuestion);
            } else {
                lfQuestion.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f questions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFQuestionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFQuestionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f question.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFQuestion lfQuestion) {
        EntityCacheUtil.removeResult(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionImpl.class, lfQuestion.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFQuestion> lfQuestions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFQuestion lfQuestion : lfQuestions) {
            EntityCacheUtil.removeResult(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
                LFQuestionImpl.class, lfQuestion.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f question with the primary key. Does not add the l f question to the database.
     *
     * @param id the primary key for the new l f question
     * @return the new l f question
     */
    public LFQuestion create(long id) {
        LFQuestion lfQuestion = new LFQuestionImpl();

        lfQuestion.setNew(true);
        lfQuestion.setPrimaryKey(id);

        return lfQuestion;
    }

    /**
     * Removes the l f question with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f question
     * @return the l f question that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a l f question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestion remove(long id)
        throws NoSuchLFQuestionException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f question with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f question
     * @return the l f question that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a l f question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuestion remove(Serializable primaryKey)
        throws NoSuchLFQuestionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFQuestion lfQuestion = (LFQuestion) session.get(LFQuestionImpl.class,
                    primaryKey);

            if (lfQuestion == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfQuestion);
        } catch (NoSuchLFQuestionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFQuestion removeImpl(LFQuestion lfQuestion)
        throws SystemException {
        lfQuestion = toUnwrappedModel(lfQuestion);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfQuestion);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfQuestion);

        return lfQuestion;
    }

    @Override
    public LFQuestion updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion,
        boolean merge) throws SystemException {
        lfQuestion = toUnwrappedModel(lfQuestion);

        boolean isNew = lfQuestion.isNew();

        LFQuestionModelImpl lfQuestionModelImpl = (LFQuestionModelImpl) lfQuestion;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfQuestion, merge);

            lfQuestion.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFQuestionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfQuestionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDCATEGORYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfQuestionModelImpl.getOriginalCourseId(),
                        /* Integer.valueOf(   */
                        lfQuestionModelImpl.getOriginalCategoryId()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDCATEGORYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDCATEGORYID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfQuestionModelImpl.getCourseId(),
                        /* Integer.valueOf( */
                        lfQuestionModelImpl.getCategoryId()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDCATEGORYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDCATEGORYID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionImpl.class, lfQuestion.getPrimaryKey(), lfQuestion);

        return lfQuestion;
    }

    protected LFQuestion toUnwrappedModel(LFQuestion lfQuestion) {
        if (lfQuestion instanceof LFQuestionImpl) {
            return lfQuestion;
        }

        LFQuestionImpl lfQuestionImpl = new LFQuestionImpl();

        lfQuestionImpl.setNew(lfQuestion.isNew());
        lfQuestionImpl.setPrimaryKey(lfQuestion.getPrimaryKey());

        lfQuestionImpl.setId(lfQuestion.getId());
        lfQuestionImpl.setCategoryId(lfQuestion.getCategoryId());
        lfQuestionImpl.setTitle(lfQuestion.getTitle());
        lfQuestionImpl.setDescription(lfQuestion.getDescription());
        lfQuestionImpl.setExplanationText(lfQuestion.getExplanationText());
        lfQuestionImpl.setForceCorrectCount(lfQuestion.isForceCorrectCount());
        lfQuestionImpl.setCaseSensitive(lfQuestion.isCaseSensitive());
        lfQuestionImpl.setQuestionType(lfQuestion.getQuestionType());
        lfQuestionImpl.setCourseId(lfQuestion.getCourseId());
        lfQuestionImpl.setArrangementIndex(lfQuestion.getArrangementIndex());

        return lfQuestionImpl;
    }

    /**
     * Returns the l f question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f question
     * @return the l f question
     * @throws com.liferay.portal.NoSuchModelException if a l f question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuestion findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f question with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException} if it could not be found.
     *
     * @param id the primary key of the l f question
     * @return the l f question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a l f question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestion findByPrimaryKey(long id)
        throws NoSuchLFQuestionException, SystemException {
        LFQuestion lfQuestion = fetchByPrimaryKey(id);

        if (lfQuestion == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfQuestion;
    }

    /**
     * Returns the l f question with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f question
     * @return the l f question, or <code>null</code> if a l f question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuestion fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f question with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f question
     * @return the l f question, or <code>null</code> if a l f question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestion fetchByPrimaryKey(long id) throws SystemException {
        LFQuestion lfQuestion = (LFQuestion) EntityCacheUtil.getResult(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
                LFQuestionImpl.class, id);

        if (lfQuestion == _nullLFQuestion) {
            return null;
        }

        if (lfQuestion == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfQuestion = (LFQuestion) session.get(LFQuestionImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfQuestion != null) {
                    cacheResult(lfQuestion);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFQuestionModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuestionImpl.class, id, _nullLFQuestion);
                }

                closeSession(session);
            }
        }

        return lfQuestion;
    }

    /**
     * Returns all the l f questions where courseId = &#63; and categoryId = &#63;.
     *
     * @param courseId the course ID
     * @param categoryId the category ID
     * @return the matching l f questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestion> findByCourseIdAndCategoryId(Integer courseId,
        Integer categoryId) throws SystemException {
        return findByCourseIdAndCategoryId(courseId, categoryId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f questions where courseId = &#63; and categoryId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseId the course ID
     * @param categoryId the category ID
     * @param start the lower bound of the range of l f questions
     * @param end the upper bound of the range of l f questions (not inclusive)
     * @return the range of matching l f questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestion> findByCourseIdAndCategoryId(Integer courseId,
        Integer categoryId, int start, int end) throws SystemException {
        return findByCourseIdAndCategoryId(courseId, categoryId, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the l f questions where courseId = &#63; and categoryId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseId the course ID
     * @param categoryId the category ID
     * @param start the lower bound of the range of l f questions
     * @param end the upper bound of the range of l f questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestion> findByCourseIdAndCategoryId(Integer courseId,
        Integer categoryId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDCATEGORYID;
            finderArgs = new Object[] { courseId, categoryId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDCATEGORYID;
            finderArgs = new Object[] {
                    courseId, categoryId,
                    
                    start, end, orderByComparator
                };
        }

        List<LFQuestion> list = (List<LFQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuestion lfQuestion : list) {
                if (!Validator.equals(courseId, lfQuestion.getCourseId()) ||
                        !Validator.equals(categoryId, lfQuestion.getCategoryId())) {
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

            query.append(_SQL_SELECT_LFQUESTION_WHERE);

            if (courseId == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_2);
            }

            if (categoryId == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_2);
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

                if (courseId != null) {
                    qPos.add(courseId.intValue());
                }

                if (categoryId != null) {
                    qPos.add(categoryId.intValue());
                }

                list = (List<LFQuestion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
     *
     * @param courseId the course ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a matching l f question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestion findByCourseIdAndCategoryId_First(Integer courseId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws NoSuchLFQuestionException, SystemException {
        LFQuestion lfQuestion = fetchByCourseIdAndCategoryId_First(courseId,
                categoryId, orderByComparator);

        if (lfQuestion != null) {
            return lfQuestion;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseId=");
        msg.append(courseId);

        msg.append(", categoryId=");
        msg.append(categoryId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuestionException(msg.toString());
    }

    /**
     * Returns the first l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
     *
     * @param courseId the course ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f question, or <code>null</code> if a matching l f question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestion fetchByCourseIdAndCategoryId_First(Integer courseId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFQuestion> list = findByCourseIdAndCategoryId(courseId,
                categoryId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
     *
     * @param courseId the course ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a matching l f question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestion findByCourseIdAndCategoryId_Last(Integer courseId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws NoSuchLFQuestionException, SystemException {
        LFQuestion lfQuestion = fetchByCourseIdAndCategoryId_Last(courseId,
                categoryId, orderByComparator);

        if (lfQuestion != null) {
            return lfQuestion;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseId=");
        msg.append(courseId);

        msg.append(", categoryId=");
        msg.append(categoryId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuestionException(msg.toString());
    }

    /**
     * Returns the last l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
     *
     * @param courseId the course ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f question, or <code>null</code> if a matching l f question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestion fetchByCourseIdAndCategoryId_Last(Integer courseId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCourseIdAndCategoryId(courseId, categoryId);

        List<LFQuestion> list = findByCourseIdAndCategoryId(courseId,
                categoryId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f questions before and after the current l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
     *
     * @param id the primary key of the current l f question
     * @param courseId the course ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a l f question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestion[] findByCourseIdAndCategoryId_PrevAndNext(long id,
        Integer courseId, Integer categoryId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuestionException, SystemException {
        LFQuestion lfQuestion = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFQuestion[] array = new LFQuestionImpl[3];

            array[0] = getByCourseIdAndCategoryId_PrevAndNext(session,
                    lfQuestion, courseId, categoryId, orderByComparator, true);

            array[1] = lfQuestion;

            array[2] = getByCourseIdAndCategoryId_PrevAndNext(session,
                    lfQuestion, courseId, categoryId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFQuestion getByCourseIdAndCategoryId_PrevAndNext(
        Session session, LFQuestion lfQuestion, Integer courseId,
        Integer categoryId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFQUESTION_WHERE);

        if (courseId == null) {
            query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_2);
        }

        if (categoryId == null) {
            query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_2);
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

        if (courseId != null) {
            qPos.add(courseId.intValue());
        }

        if (categoryId != null) {
            qPos.add(categoryId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfQuestion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFQuestion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f questions where courseId = any &#63; and categoryId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIds the course IDs
     * @param categoryIds the category IDs
     * @return the matching l f questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestion> findByCourseIdAndCategoryId(Integer[] courseIds,
        Integer[] categoryIds) throws SystemException {
        return findByCourseIdAndCategoryId(courseIds, categoryIds,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f questions where courseId = any &#63; and categoryId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIds the course IDs
     * @param categoryIds the category IDs
     * @param start the lower bound of the range of l f questions
     * @param end the upper bound of the range of l f questions (not inclusive)
     * @return the range of matching l f questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestion> findByCourseIdAndCategoryId(Integer[] courseIds,
        Integer[] categoryIds, int start, int end) throws SystemException {
        return findByCourseIdAndCategoryId(courseIds, categoryIds, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the l f questions where courseId = any &#63; and categoryId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIds the course IDs
     * @param categoryIds the category IDs
     * @param start the lower bound of the range of l f questions
     * @param end the upper bound of the range of l f questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestion> findByCourseIdAndCategoryId(Integer[] courseIds,
        Integer[] categoryIds, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDCATEGORYID;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderArgs = new Object[] {
                    StringUtil.merge(courseIds), StringUtil.merge(categoryIds)
                };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(courseIds), StringUtil.merge(categoryIds),
                    
                    start, end, orderByComparator
                };
        }

        List<LFQuestion> list = (List<LFQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuestion lfQuestion : list) {
                if (!ArrayUtil.contains(courseIds, lfQuestion.getCourseId()) ||
                        !ArrayUtil.contains(categoryIds,
                            lfQuestion.getCategoryId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFQUESTION_WHERE);

            boolean conjunctionable = false;

            if ((courseIds != null) && (courseIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIds.length; i++) {
                    if (courseIds[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_5);
                    }

                    if ((i + 1) < courseIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if ((categoryIds != null) && (categoryIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < categoryIds.length; i++) {
                    if (categoryIds[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_5);
                    }

                    if ((i + 1) < categoryIds.length) {
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

                if (courseIds != null) {
                    for (Integer courseId : courseIds) {
                        if (courseId != null) {
                            qPos.add(courseId);
                        }
                    }
                }

                if (categoryIds != null) {
                    for (Integer categoryId : categoryIds) {
                        if (categoryId != null) {
                            qPos.add(categoryId);
                        }
                    }
                }

                list = (List<LFQuestion>) QueryUtil.list(q, getDialect(),
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
     * Returns all the l f questions.
     *
     * @return the l f questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestion> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f questions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f questions
     * @param end the upper bound of the range of l f questions (not inclusive)
     * @return the range of l f questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestion> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f questions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f questions
     * @param end the upper bound of the range of l f questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestion> findAll(int start, int end,
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

        List<LFQuestion> list = (List<LFQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFQUESTION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFQUESTION;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFQuestion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFQuestion>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f questions where courseId = &#63; and categoryId = &#63; from the database.
     *
     * @param courseId the course ID
     * @param categoryId the category ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByCourseIdAndCategoryId(Integer courseId,
        Integer categoryId) throws SystemException {
        for (LFQuestion lfQuestion : findByCourseIdAndCategoryId(courseId,
                categoryId)) {
            remove(lfQuestion);
        }
    }

    /**
     * Removes all the l f questions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFQuestion lfQuestion : findAll()) {
            remove(lfQuestion);
        }
    }

    /**
     * Returns the number of l f questions where courseId = &#63; and categoryId = &#63;.
     *
     * @param courseId the course ID
     * @param categoryId the category ID
     * @return the number of matching l f questions
     * @throws SystemException if a system exception occurred
     */
    public int countByCourseIdAndCategoryId(Integer courseId, Integer categoryId)
        throws SystemException {
        Object[] finderArgs = new Object[] { courseId, categoryId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COURSEIDANDCATEGORYID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFQUESTION_WHERE);

            if (courseId == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_2);
            }

            if (categoryId == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseId != null) {
                    qPos.add(courseId.intValue());
                }

                if (categoryId != null) {
                    qPos.add(categoryId.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEIDANDCATEGORYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f questions where courseId = any &#63; and categoryId = any &#63;.
     *
     * @param courseIds the course IDs
     * @param categoryIds the category IDs
     * @return the number of matching l f questions
     * @throws SystemException if a system exception occurred
     */
    public int countByCourseIdAndCategoryId(Integer[] courseIds,
        Integer[] categoryIds) throws SystemException {
        Object[] finderArgs = new Object[] {
                StringUtil.merge(courseIds), StringUtil.merge(categoryIds)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEIDANDCATEGORYID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFQUESTION_WHERE);

            boolean conjunctionable = false;

            if ((courseIds != null) && (courseIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIds.length; i++) {
                    if (courseIds[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_COURSEID_5);
                    }

                    if ((i + 1) < courseIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if ((categoryIds != null) && (categoryIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < categoryIds.length; i++) {
                    if (categoryIds[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEIDANDCATEGORYID_CATEGORYID_5);
                    }

                    if ((i + 1) < categoryIds.length) {
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

                if (courseIds != null) {
                    for (Integer courseId : courseIds) {
                        if (courseId != null) {
                            qPos.add(courseId);
                        }
                    }
                }

                if (categoryIds != null) {
                    for (Integer categoryId : categoryIds) {
                        if (categoryId != null) {
                            qPos.add(categoryId);
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

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEIDANDCATEGORYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f questions.
     *
     * @return the number of l f questions
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFQUESTION);

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
     * Initializes the l f question persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFQuestion")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFQuestion>> listenersList = new ArrayList<ModelListener<LFQuestion>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFQuestion>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFQuestionImpl.class.getName());
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
