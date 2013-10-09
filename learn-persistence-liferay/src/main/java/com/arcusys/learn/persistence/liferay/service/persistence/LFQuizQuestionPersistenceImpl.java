package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException;
import com.arcusys.learn.persistence.liferay.model.LFQuizQuestion;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl;
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
 * The persistence implementation for the l f quiz question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestionPersistence
 * @see LFQuizQuestionUtil
 * @generated
 */
public class LFQuizQuestionPersistenceImpl extends BasePersistenceImpl<LFQuizQuestion>
    implements LFQuizQuestionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFQuizQuestionUtil} to access the l f quiz question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFQuizQuestionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZID = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByQuizID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID =
        new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuizID",
            new String[] { Integer.class.getName() },
            LFQuizQuestionModelImpl.QUIZID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_QUIZID = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuizID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZANDCATEGORY =
        new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByQuizAndCategory",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZANDCATEGORY =
        new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuizAndCategory",
            new String[] { Integer.class.getName(), Integer.class.getName() },
            LFQuizQuestionModelImpl.QUIZID_COLUMN_BITMASK |
            LFQuizQuestionModelImpl.CATEGORYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_QUIZANDCATEGORY = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByQuizAndCategory",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFQUIZQUESTION = "SELECT lfQuizQuestion FROM LFQuizQuestion lfQuizQuestion";
    private static final String _SQL_SELECT_LFQUIZQUESTION_WHERE = "SELECT lfQuizQuestion FROM LFQuizQuestion lfQuizQuestion WHERE ";
    private static final String _SQL_COUNT_LFQUIZQUESTION = "SELECT COUNT(lfQuizQuestion) FROM LFQuizQuestion lfQuizQuestion";
    private static final String _SQL_COUNT_LFQUIZQUESTION_WHERE = "SELECT COUNT(lfQuizQuestion) FROM LFQuizQuestion lfQuizQuestion WHERE ";
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_NULL = "lfQuizQuestion.quizId IS NULL";
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_NULL_2 = "lfQuizQuestion.quizId IS NULL ";
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_2 = "lfQuizQuestion.quizId = ?";
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_NULL = "lfQuizQuestion.quizId IS NULL";
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_NULL_2 = "lfQuizQuestion.quizId IS NULL  AND ";
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_2 = "lfQuizQuestion.quizId = ? AND ";
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_NULL = "lfQuizQuestion.categoryId IS NULL";
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_NULL_2 =
        "lfQuizQuestion.categoryId IS NULL ";
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_2 = "lfQuizQuestion.categoryId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfQuizQuestion.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFQuizQuestion exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFQuizQuestion exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFQuizQuestionPersistenceImpl.class);
    private static LFQuizQuestion _nullLFQuizQuestion = new LFQuizQuestionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFQuizQuestion> toCacheModel() {
                return _nullLFQuizQuestionCacheModel;
            }
        };

    private static CacheModel<LFQuizQuestion> _nullLFQuizQuestionCacheModel = new CacheModel<LFQuizQuestion>() {
            public LFQuizQuestion toEntityModel() {
                return _nullLFQuizQuestion;
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
     * Caches the l f quiz question in the entity cache if it is enabled.
     *
     * @param lfQuizQuestion the l f quiz question
     */
    public void cacheResult(LFQuizQuestion lfQuizQuestion) {
        EntityCacheUtil.putResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionImpl.class, lfQuizQuestion.getPrimaryKey(),
            lfQuizQuestion);

        lfQuizQuestion.resetOriginalValues();
    }

    /**
     * Caches the l f quiz questions in the entity cache if it is enabled.
     *
     * @param lfQuizQuestions the l f quiz questions
     */
    public void cacheResult(List<LFQuizQuestion> lfQuizQuestions) {
        for (LFQuizQuestion lfQuizQuestion : lfQuizQuestions) {
            if (EntityCacheUtil.getResult(
                        LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuizQuestionImpl.class, lfQuizQuestion.getPrimaryKey()) == null) {
                cacheResult(lfQuizQuestion);
            } else {
                lfQuizQuestion.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f quiz questions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFQuizQuestionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFQuizQuestionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f quiz question.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFQuizQuestion lfQuizQuestion) {
        EntityCacheUtil.removeResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionImpl.class, lfQuizQuestion.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFQuizQuestion> lfQuizQuestions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFQuizQuestion lfQuizQuestion : lfQuizQuestions) {
            EntityCacheUtil.removeResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizQuestionImpl.class, lfQuizQuestion.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f quiz question with the primary key. Does not add the l f quiz question to the database.
     *
     * @param id the primary key for the new l f quiz question
     * @return the new l f quiz question
     */
    public LFQuizQuestion create(long id) {
        LFQuizQuestion lfQuizQuestion = new LFQuizQuestionImpl();

        lfQuizQuestion.setNew(true);
        lfQuizQuestion.setPrimaryKey(id);

        return lfQuizQuestion;
    }

    /**
     * Removes the l f quiz question with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f quiz question
     * @return the l f quiz question that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion remove(long id)
        throws NoSuchLFQuizQuestionException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f quiz question with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f quiz question
     * @return the l f quiz question that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion remove(Serializable primaryKey)
        throws NoSuchLFQuizQuestionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFQuizQuestion lfQuizQuestion = (LFQuizQuestion) session.get(LFQuizQuestionImpl.class,
                    primaryKey);

            if (lfQuizQuestion == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFQuizQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfQuizQuestion);
        } catch (NoSuchLFQuizQuestionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFQuizQuestion removeImpl(LFQuizQuestion lfQuizQuestion)
        throws SystemException {
        lfQuizQuestion = toUnwrappedModel(lfQuizQuestion);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfQuizQuestion);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfQuizQuestion);

        return lfQuizQuestion;
    }

    @Override
    public LFQuizQuestion updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion,
        boolean merge) throws SystemException {
        lfQuizQuestion = toUnwrappedModel(lfQuizQuestion);

        boolean isNew = lfQuizQuestion.isNew();

        LFQuizQuestionModelImpl lfQuizQuestionModelImpl = (LFQuizQuestionModelImpl) lfQuizQuestion;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfQuizQuestion, merge);

            lfQuizQuestion.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFQuizQuestionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfQuizQuestionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfQuizQuestionModelImpl.getOriginalQuizId()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfQuizQuestionModelImpl.getQuizId()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID,
                    args);
            }

            if ((lfQuizQuestionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZANDCATEGORY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfQuizQuestionModelImpl.getOriginalQuizId(),
                        /* Integer.valueOf(   */
                        lfQuizQuestionModelImpl.getOriginalCategoryId()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZANDCATEGORY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZANDCATEGORY,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfQuizQuestionModelImpl.getQuizId(),
                        /* Integer.valueOf( */
                        lfQuizQuestionModelImpl.getCategoryId()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZANDCATEGORY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZANDCATEGORY,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionImpl.class, lfQuizQuestion.getPrimaryKey(),
            lfQuizQuestion);

        return lfQuizQuestion;
    }

    protected LFQuizQuestion toUnwrappedModel(LFQuizQuestion lfQuizQuestion) {
        if (lfQuizQuestion instanceof LFQuizQuestionImpl) {
            return lfQuizQuestion;
        }

        LFQuizQuestionImpl lfQuizQuestionImpl = new LFQuizQuestionImpl();

        lfQuizQuestionImpl.setNew(lfQuizQuestion.isNew());
        lfQuizQuestionImpl.setPrimaryKey(lfQuizQuestion.getPrimaryKey());

        lfQuizQuestionImpl.setId(lfQuizQuestion.getId());
        lfQuizQuestionImpl.setQuizId(lfQuizQuestion.getQuizId());
        lfQuizQuestionImpl.setCategoryId(lfQuizQuestion.getCategoryId());
        lfQuizQuestionImpl.setQuestionId(lfQuizQuestion.getQuestionId());
        lfQuizQuestionImpl.setQuestionType(lfQuizQuestion.getQuestionType());
        lfQuizQuestionImpl.setTitle(lfQuizQuestion.getTitle());
        lfQuizQuestionImpl.setUrl(lfQuizQuestion.getUrl());
        lfQuizQuestionImpl.setPlainText(lfQuizQuestion.getPlainText());
        lfQuizQuestionImpl.setArrangementIndex(lfQuizQuestion.getArrangementIndex());

        return lfQuizQuestionImpl;
    }

    /**
     * Returns the l f quiz question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz question
     * @return the l f quiz question
     * @throws com.liferay.portal.NoSuchModelException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f quiz question with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException} if it could not be found.
     *
     * @param id the primary key of the l f quiz question
     * @return the l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion findByPrimaryKey(long id)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = fetchByPrimaryKey(id);

        if (lfQuizQuestion == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFQuizQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfQuizQuestion;
    }

    /**
     * Returns the l f quiz question with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz question
     * @return the l f quiz question, or <code>null</code> if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f quiz question with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f quiz question
     * @return the l f quiz question, or <code>null</code> if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion fetchByPrimaryKey(long id) throws SystemException {
        LFQuizQuestion lfQuizQuestion = (LFQuizQuestion) EntityCacheUtil.getResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizQuestionImpl.class, id);

        if (lfQuizQuestion == _nullLFQuizQuestion) {
            return null;
        }

        if (lfQuizQuestion == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfQuizQuestion = (LFQuizQuestion) session.get(LFQuizQuestionImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfQuizQuestion != null) {
                    cacheResult(lfQuizQuestion);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuizQuestionImpl.class, id, _nullLFQuizQuestion);
                }

                closeSession(session);
            }
        }

        return lfQuizQuestion;
    }

    /**
     * Returns all the l f quiz questions where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @return the matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuizQuestion> findByQuizID(Integer quizId)
        throws SystemException {
        return findByQuizID(quizId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz questions where quizId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param quizId the quiz ID
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @return the range of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuizQuestion> findByQuizID(Integer quizId, int start, int end)
        throws SystemException {
        return findByQuizID(quizId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz questions where quizId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param quizId the quiz ID
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuizQuestion> findByQuizID(Integer quizId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID;
            finderArgs = new Object[] { quizId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZID;
            finderArgs = new Object[] { quizId, start, end, orderByComparator };
        }

        List<LFQuizQuestion> list = (List<LFQuizQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuizQuestion lfQuizQuestion : list) {
                if (!Validator.equals(quizId, lfQuizQuestion.getQuizId())) {
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

            query.append(_SQL_SELECT_LFQUIZQUESTION_WHERE);

            if (quizId == null) {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_2);
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

                if (quizId != null) {
                    qPos.add(quizId.intValue());
                }

                list = (List<LFQuizQuestion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f quiz question in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion findByQuizID_First(Integer quizId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = fetchByQuizID_First(quizId,
                orderByComparator);

        if (lfQuizQuestion != null) {
            return lfQuizQuestion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestionException(msg.toString());
    }

    /**
     * Returns the first l f quiz question in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion fetchByQuizID_First(Integer quizId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFQuizQuestion> list = findByQuizID(quizId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f quiz question in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion findByQuizID_Last(Integer quizId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = fetchByQuizID_Last(quizId,
                orderByComparator);

        if (lfQuizQuestion != null) {
            return lfQuizQuestion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestionException(msg.toString());
    }

    /**
     * Returns the last l f quiz question in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion fetchByQuizID_Last(Integer quizId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByQuizID(quizId);

        List<LFQuizQuestion> list = findByQuizID(quizId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f quiz questions before and after the current l f quiz question in the ordered set where quizId = &#63;.
     *
     * @param id the primary key of the current l f quiz question
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion[] findByQuizID_PrevAndNext(long id, Integer quizId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFQuizQuestion[] array = new LFQuizQuestionImpl[3];

            array[0] = getByQuizID_PrevAndNext(session, lfQuizQuestion, quizId,
                    orderByComparator, true);

            array[1] = lfQuizQuestion;

            array[2] = getByQuizID_PrevAndNext(session, lfQuizQuestion, quizId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFQuizQuestion getByQuizID_PrevAndNext(Session session,
        LFQuizQuestion lfQuizQuestion, Integer quizId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFQUIZQUESTION_WHERE);

        if (quizId == null) {
            query.append(_FINDER_COLUMN_QUIZID_QUIZID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_QUIZID_QUIZID_2);
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

        if (quizId != null) {
            qPos.add(quizId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfQuizQuestion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFQuizQuestion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f quiz questions where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @return the matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuizQuestion> findByQuizAndCategory(Integer quizId,
        Integer categoryId) throws SystemException {
        return findByQuizAndCategory(quizId, categoryId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz questions where quizId = &#63; and categoryId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @return the range of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuizQuestion> findByQuizAndCategory(Integer quizId,
        Integer categoryId, int start, int end) throws SystemException {
        return findByQuizAndCategory(quizId, categoryId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz questions where quizId = &#63; and categoryId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuizQuestion> findByQuizAndCategory(Integer quizId,
        Integer categoryId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZANDCATEGORY;
            finderArgs = new Object[] { quizId, categoryId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZANDCATEGORY;
            finderArgs = new Object[] {
                    quizId, categoryId,
                    
                    start, end, orderByComparator
                };
        }

        List<LFQuizQuestion> list = (List<LFQuizQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuizQuestion lfQuizQuestion : list) {
                if (!Validator.equals(quizId, lfQuizQuestion.getQuizId()) ||
                        !Validator.equals(categoryId,
                            lfQuizQuestion.getCategoryId())) {
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

            query.append(_SQL_SELECT_LFQUIZQUESTION_WHERE);

            if (quizId == null) {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_2);
            }

            if (categoryId == null) {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_2);
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

                if (quizId != null) {
                    qPos.add(quizId.intValue());
                }

                if (categoryId != null) {
                    qPos.add(categoryId.intValue());
                }

                list = (List<LFQuizQuestion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion findByQuizAndCategory_First(Integer quizId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = fetchByQuizAndCategory_First(quizId,
                categoryId, orderByComparator);

        if (lfQuizQuestion != null) {
            return lfQuizQuestion;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(", categoryId=");
        msg.append(categoryId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestionException(msg.toString());
    }

    /**
     * Returns the first l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion fetchByQuizAndCategory_First(Integer quizId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFQuizQuestion> list = findByQuizAndCategory(quizId, categoryId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion findByQuizAndCategory_Last(Integer quizId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = fetchByQuizAndCategory_Last(quizId,
                categoryId, orderByComparator);

        if (lfQuizQuestion != null) {
            return lfQuizQuestion;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(", categoryId=");
        msg.append(categoryId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestionException(msg.toString());
    }

    /**
     * Returns the last l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion fetchByQuizAndCategory_Last(Integer quizId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByQuizAndCategory(quizId, categoryId);

        List<LFQuizQuestion> list = findByQuizAndCategory(quizId, categoryId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f quiz questions before and after the current l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
     *
     * @param id the primary key of the current l f quiz question
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuizQuestion[] findByQuizAndCategory_PrevAndNext(long id,
        Integer quizId, Integer categoryId, OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFQuizQuestion[] array = new LFQuizQuestionImpl[3];

            array[0] = getByQuizAndCategory_PrevAndNext(session,
                    lfQuizQuestion, quizId, categoryId, orderByComparator, true);

            array[1] = lfQuizQuestion;

            array[2] = getByQuizAndCategory_PrevAndNext(session,
                    lfQuizQuestion, quizId, categoryId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFQuizQuestion getByQuizAndCategory_PrevAndNext(Session session,
        LFQuizQuestion lfQuizQuestion, Integer quizId, Integer categoryId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFQUIZQUESTION_WHERE);

        if (quizId == null) {
            query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_2);
        }

        if (categoryId == null) {
            query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_2);
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

        if (quizId != null) {
            qPos.add(quizId.intValue());
        }

        if (categoryId != null) {
            qPos.add(categoryId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfQuizQuestion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFQuizQuestion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f quiz questions.
     *
     * @return the l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuizQuestion> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz questions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @return the range of l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuizQuestion> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz questions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuizQuestion> findAll(int start, int end,
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

        List<LFQuizQuestion> list = (List<LFQuizQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFQUIZQUESTION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFQUIZQUESTION;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFQuizQuestion>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFQuizQuestion>) QueryUtil.list(q,
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
     * Removes all the l f quiz questions where quizId = &#63; from the database.
     *
     * @param quizId the quiz ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByQuizID(Integer quizId) throws SystemException {
        for (LFQuizQuestion lfQuizQuestion : findByQuizID(quizId)) {
            remove(lfQuizQuestion);
        }
    }

    /**
     * Removes all the l f quiz questions where quizId = &#63; and categoryId = &#63; from the database.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByQuizAndCategory(Integer quizId, Integer categoryId)
        throws SystemException {
        for (LFQuizQuestion lfQuizQuestion : findByQuizAndCategory(quizId,
                categoryId)) {
            remove(lfQuizQuestion);
        }
    }

    /**
     * Removes all the l f quiz questions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFQuizQuestion lfQuizQuestion : findAll()) {
            remove(lfQuizQuestion);
        }
    }

    /**
     * Returns the number of l f quiz questions where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @return the number of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public int countByQuizID(Integer quizId) throws SystemException {
        Object[] finderArgs = new Object[] { quizId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUIZID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFQUIZQUESTION_WHERE);

            if (quizId == null) {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (quizId != null) {
                    qPos.add(quizId.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUIZID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f quiz questions where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @return the number of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public int countByQuizAndCategory(Integer quizId, Integer categoryId)
        throws SystemException {
        Object[] finderArgs = new Object[] { quizId, categoryId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUIZANDCATEGORY,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFQUIZQUESTION_WHERE);

            if (quizId == null) {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_2);
            }

            if (categoryId == null) {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (quizId != null) {
                    qPos.add(quizId.intValue());
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

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUIZANDCATEGORY,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f quiz questions.
     *
     * @return the number of l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFQUIZQUESTION);

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
     * Initializes the l f quiz question persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFQuizQuestion")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFQuizQuestion>> listenersList = new ArrayList<ModelListener<LFQuizQuestion>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFQuizQuestion>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFQuizQuestionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
