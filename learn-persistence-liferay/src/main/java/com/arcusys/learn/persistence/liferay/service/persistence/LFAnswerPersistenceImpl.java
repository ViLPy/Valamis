package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException;
import com.arcusys.learn.persistence.liferay.model.LFAnswer;
import com.arcusys.learn.persistence.liferay.model.impl.LFAnswerImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFAnswerModelImpl;
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
 * The persistence implementation for the l f answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAnswerPersistence
 * @see LFAnswerUtil
 * @generated
 */
public class LFAnswerPersistenceImpl extends BasePersistenceImpl<LFAnswer>
    implements LFAnswerPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFAnswerUtil} to access the l f answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFAnswerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID =
        new FinderPath(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
            LFAnswerModelImpl.FINDER_CACHE_ENABLED, LFAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuestionId",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID =
        new FinderPath(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
            LFAnswerModelImpl.FINDER_CACHE_ENABLED, LFAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuestionId",
            new String[] { Integer.class.getName() },
            LFAnswerModelImpl.QUESTIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONID = new FinderPath(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
            LFAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestionId",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
            LFAnswerModelImpl.FINDER_CACHE_ENABLED, LFAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
            LFAnswerModelImpl.FINDER_CACHE_ENABLED, LFAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
            LFAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFANSWER = "SELECT lfAnswer FROM LFAnswer lfAnswer";
    private static final String _SQL_SELECT_LFANSWER_WHERE = "SELECT lfAnswer FROM LFAnswer lfAnswer WHERE ";
    private static final String _SQL_COUNT_LFANSWER = "SELECT COUNT(lfAnswer) FROM LFAnswer lfAnswer";
    private static final String _SQL_COUNT_LFANSWER_WHERE = "SELECT COUNT(lfAnswer) FROM LFAnswer lfAnswer WHERE ";
    private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_NULL = "lfAnswer.questionId IS NULL";
    private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_NULL_2 = "lfAnswer.questionId IS NULL ";
    private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 = "lfAnswer.questionId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfAnswer.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFAnswer exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFAnswer exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFAnswerPersistenceImpl.class);
    private static LFAnswer _nullLFAnswer = new LFAnswerImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFAnswer> toCacheModel() {
                return _nullLFAnswerCacheModel;
            }
        };

    private static CacheModel<LFAnswer> _nullLFAnswerCacheModel = new CacheModel<LFAnswer>() {
            public LFAnswer toEntityModel() {
                return _nullLFAnswer;
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
     * Caches the l f answer in the entity cache if it is enabled.
     *
     * @param lfAnswer the l f answer
     */
    public void cacheResult(LFAnswer lfAnswer) {
        EntityCacheUtil.putResult(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
            LFAnswerImpl.class, lfAnswer.getPrimaryKey(), lfAnswer);

        lfAnswer.resetOriginalValues();
    }

    /**
     * Caches the l f answers in the entity cache if it is enabled.
     *
     * @param lfAnswers the l f answers
     */
    public void cacheResult(List<LFAnswer> lfAnswers) {
        for (LFAnswer lfAnswer : lfAnswers) {
            if (EntityCacheUtil.getResult(
                        LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
                        LFAnswerImpl.class, lfAnswer.getPrimaryKey()) == null) {
                cacheResult(lfAnswer);
            } else {
                lfAnswer.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f answers.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFAnswerImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFAnswerImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f answer.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFAnswer lfAnswer) {
        EntityCacheUtil.removeResult(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
            LFAnswerImpl.class, lfAnswer.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFAnswer> lfAnswers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFAnswer lfAnswer : lfAnswers) {
            EntityCacheUtil.removeResult(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
                LFAnswerImpl.class, lfAnswer.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f answer with the primary key. Does not add the l f answer to the database.
     *
     * @param id the primary key for the new l f answer
     * @return the new l f answer
     */
    public LFAnswer create(long id) {
        LFAnswer lfAnswer = new LFAnswerImpl();

        lfAnswer.setNew(true);
        lfAnswer.setPrimaryKey(id);

        return lfAnswer;
    }

    /**
     * Removes the l f answer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f answer
     * @return the l f answer that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException if a l f answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAnswer remove(long id)
        throws NoSuchLFAnswerException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f answer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f answer
     * @return the l f answer that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException if a l f answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAnswer remove(Serializable primaryKey)
        throws NoSuchLFAnswerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFAnswer lfAnswer = (LFAnswer) session.get(LFAnswerImpl.class,
                    primaryKey);

            if (lfAnswer == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfAnswer);
        } catch (NoSuchLFAnswerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFAnswer removeImpl(LFAnswer lfAnswer) throws SystemException {
        lfAnswer = toUnwrappedModel(lfAnswer);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfAnswer);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfAnswer);

        return lfAnswer;
    }

    @Override
    public LFAnswer updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAnswer lfAnswer,
        boolean merge) throws SystemException {
        lfAnswer = toUnwrappedModel(lfAnswer);

        boolean isNew = lfAnswer.isNew();

        LFAnswerModelImpl lfAnswerModelImpl = (LFAnswerModelImpl) lfAnswer;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfAnswer, merge);

            lfAnswer.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFAnswerModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfAnswerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfAnswerModelImpl.getOriginalQuestionId()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfAnswerModelImpl.getQuestionId()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
            LFAnswerImpl.class, lfAnswer.getPrimaryKey(), lfAnswer);

        return lfAnswer;
    }

    protected LFAnswer toUnwrappedModel(LFAnswer lfAnswer) {
        if (lfAnswer instanceof LFAnswerImpl) {
            return lfAnswer;
        }

        LFAnswerImpl lfAnswerImpl = new LFAnswerImpl();

        lfAnswerImpl.setNew(lfAnswer.isNew());
        lfAnswerImpl.setPrimaryKey(lfAnswer.getPrimaryKey());

        lfAnswerImpl.setId(lfAnswer.getId());
        lfAnswerImpl.setDescription(lfAnswer.getDescription());
        lfAnswerImpl.setCorrect(lfAnswer.isCorrect());
        lfAnswerImpl.setQuestionId(lfAnswer.getQuestionId());
        lfAnswerImpl.setRangeFrom(lfAnswer.getRangeFrom());
        lfAnswerImpl.setRangeTo(lfAnswer.getRangeTo());
        lfAnswerImpl.setMatchingText(lfAnswer.getMatchingText());
        lfAnswerImpl.setAnswerPosition(lfAnswer.getAnswerPosition());
        lfAnswerImpl.setAnswerType(lfAnswer.getAnswerType());

        return lfAnswerImpl;
    }

    /**
     * Returns the l f answer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f answer
     * @return the l f answer
     * @throws com.liferay.portal.NoSuchModelException if a l f answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAnswer findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f answer with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException} if it could not be found.
     *
     * @param id the primary key of the l f answer
     * @return the l f answer
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException if a l f answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAnswer findByPrimaryKey(long id)
        throws NoSuchLFAnswerException, SystemException {
        LFAnswer lfAnswer = fetchByPrimaryKey(id);

        if (lfAnswer == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfAnswer;
    }

    /**
     * Returns the l f answer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f answer
     * @return the l f answer, or <code>null</code> if a l f answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAnswer fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f answer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f answer
     * @return the l f answer, or <code>null</code> if a l f answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAnswer fetchByPrimaryKey(long id) throws SystemException {
        LFAnswer lfAnswer = (LFAnswer) EntityCacheUtil.getResult(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
                LFAnswerImpl.class, id);

        if (lfAnswer == _nullLFAnswer) {
            return null;
        }

        if (lfAnswer == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfAnswer = (LFAnswer) session.get(LFAnswerImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfAnswer != null) {
                    cacheResult(lfAnswer);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFAnswerModelImpl.ENTITY_CACHE_ENABLED,
                        LFAnswerImpl.class, id, _nullLFAnswer);
                }

                closeSession(session);
            }
        }

        return lfAnswer;
    }

    /**
     * Returns all the l f answers where questionId = &#63;.
     *
     * @param questionId the question ID
     * @return the matching l f answers
     * @throws SystemException if a system exception occurred
     */
    public List<LFAnswer> findByQuestionId(Integer questionId)
        throws SystemException {
        return findByQuestionId(questionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f answers where questionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param questionId the question ID
     * @param start the lower bound of the range of l f answers
     * @param end the upper bound of the range of l f answers (not inclusive)
     * @return the range of matching l f answers
     * @throws SystemException if a system exception occurred
     */
    public List<LFAnswer> findByQuestionId(Integer questionId, int start,
        int end) throws SystemException {
        return findByQuestionId(questionId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f answers where questionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param questionId the question ID
     * @param start the lower bound of the range of l f answers
     * @param end the upper bound of the range of l f answers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f answers
     * @throws SystemException if a system exception occurred
     */
    public List<LFAnswer> findByQuestionId(Integer questionId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID;
            finderArgs = new Object[] { questionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID;
            finderArgs = new Object[] { questionId, start, end, orderByComparator };
        }

        List<LFAnswer> list = (List<LFAnswer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAnswer lfAnswer : list) {
                if (!Validator.equals(questionId, lfAnswer.getQuestionId())) {
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

            query.append(_SQL_SELECT_LFANSWER_WHERE);

            if (questionId == null) {
                query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);
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

                if (questionId != null) {
                    qPos.add(questionId.intValue());
                }

                list = (List<LFAnswer>) QueryUtil.list(q, getDialect(), start,
                        end);
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
     * Returns the first l f answer in the ordered set where questionId = &#63;.
     *
     * @param questionId the question ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f answer
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException if a matching l f answer could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAnswer findByQuestionId_First(Integer questionId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAnswerException, SystemException {
        LFAnswer lfAnswer = fetchByQuestionId_First(questionId,
                orderByComparator);

        if (lfAnswer != null) {
            return lfAnswer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("questionId=");
        msg.append(questionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAnswerException(msg.toString());
    }

    /**
     * Returns the first l f answer in the ordered set where questionId = &#63;.
     *
     * @param questionId the question ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f answer, or <code>null</code> if a matching l f answer could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAnswer fetchByQuestionId_First(Integer questionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFAnswer> list = findByQuestionId(questionId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f answer in the ordered set where questionId = &#63;.
     *
     * @param questionId the question ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f answer
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException if a matching l f answer could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAnswer findByQuestionId_Last(Integer questionId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAnswerException, SystemException {
        LFAnswer lfAnswer = fetchByQuestionId_Last(questionId, orderByComparator);

        if (lfAnswer != null) {
            return lfAnswer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("questionId=");
        msg.append(questionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAnswerException(msg.toString());
    }

    /**
     * Returns the last l f answer in the ordered set where questionId = &#63;.
     *
     * @param questionId the question ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f answer, or <code>null</code> if a matching l f answer could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAnswer fetchByQuestionId_Last(Integer questionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByQuestionId(questionId);

        List<LFAnswer> list = findByQuestionId(questionId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f answers before and after the current l f answer in the ordered set where questionId = &#63;.
     *
     * @param id the primary key of the current l f answer
     * @param questionId the question ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f answer
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException if a l f answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAnswer[] findByQuestionId_PrevAndNext(long id, Integer questionId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAnswerException, SystemException {
        LFAnswer lfAnswer = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAnswer[] array = new LFAnswerImpl[3];

            array[0] = getByQuestionId_PrevAndNext(session, lfAnswer,
                    questionId, orderByComparator, true);

            array[1] = lfAnswer;

            array[2] = getByQuestionId_PrevAndNext(session, lfAnswer,
                    questionId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAnswer getByQuestionId_PrevAndNext(Session session,
        LFAnswer lfAnswer, Integer questionId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFANSWER_WHERE);

        if (questionId == null) {
            query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);
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

        if (questionId != null) {
            qPos.add(questionId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfAnswer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAnswer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f answers.
     *
     * @return the l f answers
     * @throws SystemException if a system exception occurred
     */
    public List<LFAnswer> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f answers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f answers
     * @param end the upper bound of the range of l f answers (not inclusive)
     * @return the range of l f answers
     * @throws SystemException if a system exception occurred
     */
    public List<LFAnswer> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f answers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f answers
     * @param end the upper bound of the range of l f answers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f answers
     * @throws SystemException if a system exception occurred
     */
    public List<LFAnswer> findAll(int start, int end,
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

        List<LFAnswer> list = (List<LFAnswer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFANSWER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFANSWER;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFAnswer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFAnswer>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f answers where questionId = &#63; from the database.
     *
     * @param questionId the question ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByQuestionId(Integer questionId)
        throws SystemException {
        for (LFAnswer lfAnswer : findByQuestionId(questionId)) {
            remove(lfAnswer);
        }
    }

    /**
     * Removes all the l f answers from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFAnswer lfAnswer : findAll()) {
            remove(lfAnswer);
        }
    }

    /**
     * Returns the number of l f answers where questionId = &#63;.
     *
     * @param questionId the question ID
     * @return the number of matching l f answers
     * @throws SystemException if a system exception occurred
     */
    public int countByQuestionId(Integer questionId) throws SystemException {
        Object[] finderArgs = new Object[] { questionId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUESTIONID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFANSWER_WHERE);

            if (questionId == null) {
                query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (questionId != null) {
                    qPos.add(questionId.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUESTIONID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f answers.
     *
     * @return the number of l f answers
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFANSWER);

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
     * Initializes the l f answer persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFAnswer")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFAnswer>> listenersList = new ArrayList<ModelListener<LFAnswer>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFAnswer>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFAnswerImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
