package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException;
import com.arcusys.learn.persistence.liferay.model.LFBigDecimal;
import com.arcusys.learn.persistence.liferay.model.impl.LFBigDecimalImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFBigDecimalModelImpl;
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

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l f big decimal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFBigDecimalPersistence
 * @see LFBigDecimalUtil
 * @generated
 */
public class LFBigDecimalPersistenceImpl extends BasePersistenceImpl<LFBigDecimal>
    implements LFBigDecimalPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFBigDecimalUtil} to access the l f big decimal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFBigDecimalImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DECIMAL = new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, LFBigDecimalImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDecimal",
            new String[] {
                BigDecimal.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECIMAL =
        new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, LFBigDecimalImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDecimal",
            new String[] { BigDecimal.class.getName() },
            LFBigDecimalModelImpl.DECIMAL_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DECIMAL = new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDecimal",
            new String[] { BigDecimal.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, LFBigDecimalImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, LFBigDecimalImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFBIGDECIMAL = "SELECT lfBigDecimal FROM LFBigDecimal lfBigDecimal";
    private static final String _SQL_SELECT_LFBIGDECIMAL_WHERE = "SELECT lfBigDecimal FROM LFBigDecimal lfBigDecimal WHERE ";
    private static final String _SQL_COUNT_LFBIGDECIMAL = "SELECT COUNT(lfBigDecimal) FROM LFBigDecimal lfBigDecimal";
    private static final String _SQL_COUNT_LFBIGDECIMAL_WHERE = "SELECT COUNT(lfBigDecimal) FROM LFBigDecimal lfBigDecimal WHERE ";
    private static final String _FINDER_COLUMN_DECIMAL_DECIMAL_1 = "lfBigDecimal.decimal IS NULL";
    private static final String _FINDER_COLUMN_DECIMAL_DECIMAL_NULL = "lfBigDecimal.decimal IS NULL";
    private static final String _FINDER_COLUMN_DECIMAL_DECIMAL_NULL_2 = "lfBigDecimal.decimal IS NULL ";
    private static final String _FINDER_COLUMN_DECIMAL_DECIMAL_2 = "lfBigDecimal.decimal = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfBigDecimal.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFBigDecimal exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFBigDecimal exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFBigDecimalPersistenceImpl.class);
    private static LFBigDecimal _nullLFBigDecimal = new LFBigDecimalImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFBigDecimal> toCacheModel() {
                return _nullLFBigDecimalCacheModel;
            }
        };

    private static CacheModel<LFBigDecimal> _nullLFBigDecimalCacheModel = new CacheModel<LFBigDecimal>() {
            public LFBigDecimal toEntityModel() {
                return _nullLFBigDecimal;
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
     * Caches the l f big decimal in the entity cache if it is enabled.
     *
     * @param lfBigDecimal the l f big decimal
     */
    public void cacheResult(LFBigDecimal lfBigDecimal) {
        EntityCacheUtil.putResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalImpl.class, lfBigDecimal.getPrimaryKey(), lfBigDecimal);

        lfBigDecimal.resetOriginalValues();
    }

    /**
     * Caches the l f big decimals in the entity cache if it is enabled.
     *
     * @param lfBigDecimals the l f big decimals
     */
    public void cacheResult(List<LFBigDecimal> lfBigDecimals) {
        for (LFBigDecimal lfBigDecimal : lfBigDecimals) {
            if (EntityCacheUtil.getResult(
                        LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
                        LFBigDecimalImpl.class, lfBigDecimal.getPrimaryKey()) == null) {
                cacheResult(lfBigDecimal);
            } else {
                lfBigDecimal.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f big decimals.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFBigDecimalImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFBigDecimalImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f big decimal.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFBigDecimal lfBigDecimal) {
        EntityCacheUtil.removeResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalImpl.class, lfBigDecimal.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFBigDecimal> lfBigDecimals) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFBigDecimal lfBigDecimal : lfBigDecimals) {
            EntityCacheUtil.removeResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
                LFBigDecimalImpl.class, lfBigDecimal.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f big decimal with the primary key. Does not add the l f big decimal to the database.
     *
     * @param id the primary key for the new l f big decimal
     * @return the new l f big decimal
     */
    public LFBigDecimal create(long id) {
        LFBigDecimal lfBigDecimal = new LFBigDecimalImpl();

        lfBigDecimal.setNew(true);
        lfBigDecimal.setPrimaryKey(id);

        return lfBigDecimal;
    }

    /**
     * Removes the l f big decimal with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f big decimal
     * @return the l f big decimal that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFBigDecimal remove(long id)
        throws NoSuchLFBigDecimalException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f big decimal with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f big decimal
     * @return the l f big decimal that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal remove(Serializable primaryKey)
        throws NoSuchLFBigDecimalException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFBigDecimal lfBigDecimal = (LFBigDecimal) session.get(LFBigDecimalImpl.class,
                    primaryKey);

            if (lfBigDecimal == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFBigDecimalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfBigDecimal);
        } catch (NoSuchLFBigDecimalException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFBigDecimal removeImpl(LFBigDecimal lfBigDecimal)
        throws SystemException {
        lfBigDecimal = toUnwrappedModel(lfBigDecimal);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfBigDecimal);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfBigDecimal);

        return lfBigDecimal;
    }

    @Override
    public LFBigDecimal updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFBigDecimal lfBigDecimal,
        boolean merge) throws SystemException {
        lfBigDecimal = toUnwrappedModel(lfBigDecimal);

        boolean isNew = lfBigDecimal.isNew();

        LFBigDecimalModelImpl lfBigDecimalModelImpl = (LFBigDecimalModelImpl) lfBigDecimal;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfBigDecimal, merge);

            lfBigDecimal.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFBigDecimalModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfBigDecimalModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECIMAL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfBigDecimalModelImpl.getOriginalDecimal()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DECIMAL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECIMAL,
                    args);

                args = new Object[] { lfBigDecimalModelImpl.getDecimal() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DECIMAL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECIMAL,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalImpl.class, lfBigDecimal.getPrimaryKey(), lfBigDecimal);

        return lfBigDecimal;
    }

    protected LFBigDecimal toUnwrappedModel(LFBigDecimal lfBigDecimal) {
        if (lfBigDecimal instanceof LFBigDecimalImpl) {
            return lfBigDecimal;
        }

        LFBigDecimalImpl lfBigDecimalImpl = new LFBigDecimalImpl();

        lfBigDecimalImpl.setNew(lfBigDecimal.isNew());
        lfBigDecimalImpl.setPrimaryKey(lfBigDecimal.getPrimaryKey());

        lfBigDecimalImpl.setId(lfBigDecimal.getId());
        lfBigDecimalImpl.setDecimal(lfBigDecimal.getDecimal());
        lfBigDecimalImpl.setText(lfBigDecimal.getText());

        return lfBigDecimalImpl;
    }

    /**
     * Returns the l f big decimal with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f big decimal
     * @return the l f big decimal
     * @throws com.liferay.portal.NoSuchModelException if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f big decimal with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException} if it could not be found.
     *
     * @param id the primary key of the l f big decimal
     * @return the l f big decimal
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFBigDecimal findByPrimaryKey(long id)
        throws NoSuchLFBigDecimalException, SystemException {
        LFBigDecimal lfBigDecimal = fetchByPrimaryKey(id);

        if (lfBigDecimal == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFBigDecimalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfBigDecimal;
    }

    /**
     * Returns the l f big decimal with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f big decimal
     * @return the l f big decimal, or <code>null</code> if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f big decimal with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f big decimal
     * @return the l f big decimal, or <code>null</code> if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFBigDecimal fetchByPrimaryKey(long id) throws SystemException {
        LFBigDecimal lfBigDecimal = (LFBigDecimal) EntityCacheUtil.getResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
                LFBigDecimalImpl.class, id);

        if (lfBigDecimal == _nullLFBigDecimal) {
            return null;
        }

        if (lfBigDecimal == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfBigDecimal = (LFBigDecimal) session.get(LFBigDecimalImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfBigDecimal != null) {
                    cacheResult(lfBigDecimal);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
                        LFBigDecimalImpl.class, id, _nullLFBigDecimal);
                }

                closeSession(session);
            }
        }

        return lfBigDecimal;
    }

    /**
     * Returns all the l f big decimals where decimal = &#63;.
     *
     * @param decimal the decimal
     * @return the matching l f big decimals
     * @throws SystemException if a system exception occurred
     */
    public List<LFBigDecimal> findByDecimal(BigDecimal decimal)
        throws SystemException {
        return findByDecimal(decimal, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f big decimals where decimal = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param decimal the decimal
     * @param start the lower bound of the range of l f big decimals
     * @param end the upper bound of the range of l f big decimals (not inclusive)
     * @return the range of matching l f big decimals
     * @throws SystemException if a system exception occurred
     */
    public List<LFBigDecimal> findByDecimal(BigDecimal decimal, int start,
        int end) throws SystemException {
        return findByDecimal(decimal, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f big decimals where decimal = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param decimal the decimal
     * @param start the lower bound of the range of l f big decimals
     * @param end the upper bound of the range of l f big decimals (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f big decimals
     * @throws SystemException if a system exception occurred
     */
    public List<LFBigDecimal> findByDecimal(BigDecimal decimal, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECIMAL;
            finderArgs = new Object[] { decimal };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DECIMAL;
            finderArgs = new Object[] { decimal, start, end, orderByComparator };
        }

        List<LFBigDecimal> list = (List<LFBigDecimal>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFBigDecimal lfBigDecimal : list) {
                if (!Validator.equals(decimal, lfBigDecimal.getDecimal())) {
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

            query.append(_SQL_SELECT_LFBIGDECIMAL_WHERE);

            if (decimal == null) {
                query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_1);
            } else {
                if (decimal == null) {
                    query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_NULL_2);
                } else {
                    query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_2);
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

                if (decimal != null) {
                    qPos.add(decimal);
                }

                list = (List<LFBigDecimal>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f big decimal in the ordered set where decimal = &#63;.
     *
     * @param decimal the decimal
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f big decimal
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a matching l f big decimal could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFBigDecimal findByDecimal_First(BigDecimal decimal,
        OrderByComparator orderByComparator)
        throws NoSuchLFBigDecimalException, SystemException {
        LFBigDecimal lfBigDecimal = fetchByDecimal_First(decimal,
                orderByComparator);

        if (lfBigDecimal != null) {
            return lfBigDecimal;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("decimal=");
        msg.append(decimal);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFBigDecimalException(msg.toString());
    }

    /**
     * Returns the first l f big decimal in the ordered set where decimal = &#63;.
     *
     * @param decimal the decimal
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f big decimal, or <code>null</code> if a matching l f big decimal could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFBigDecimal fetchByDecimal_First(BigDecimal decimal,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFBigDecimal> list = findByDecimal(decimal, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f big decimal in the ordered set where decimal = &#63;.
     *
     * @param decimal the decimal
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f big decimal
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a matching l f big decimal could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFBigDecimal findByDecimal_Last(BigDecimal decimal,
        OrderByComparator orderByComparator)
        throws NoSuchLFBigDecimalException, SystemException {
        LFBigDecimal lfBigDecimal = fetchByDecimal_Last(decimal,
                orderByComparator);

        if (lfBigDecimal != null) {
            return lfBigDecimal;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("decimal=");
        msg.append(decimal);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFBigDecimalException(msg.toString());
    }

    /**
     * Returns the last l f big decimal in the ordered set where decimal = &#63;.
     *
     * @param decimal the decimal
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f big decimal, or <code>null</code> if a matching l f big decimal could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFBigDecimal fetchByDecimal_Last(BigDecimal decimal,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByDecimal(decimal);

        List<LFBigDecimal> list = findByDecimal(decimal, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f big decimals before and after the current l f big decimal in the ordered set where decimal = &#63;.
     *
     * @param id the primary key of the current l f big decimal
     * @param decimal the decimal
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f big decimal
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFBigDecimal[] findByDecimal_PrevAndNext(long id,
        BigDecimal decimal, OrderByComparator orderByComparator)
        throws NoSuchLFBigDecimalException, SystemException {
        LFBigDecimal lfBigDecimal = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFBigDecimal[] array = new LFBigDecimalImpl[3];

            array[0] = getByDecimal_PrevAndNext(session, lfBigDecimal, decimal,
                    orderByComparator, true);

            array[1] = lfBigDecimal;

            array[2] = getByDecimal_PrevAndNext(session, lfBigDecimal, decimal,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFBigDecimal getByDecimal_PrevAndNext(Session session,
        LFBigDecimal lfBigDecimal, BigDecimal decimal,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFBIGDECIMAL_WHERE);

        if (decimal == null) {
            query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_1);
        } else {
            if (decimal == null) {
                query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_2);
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

        if (decimal != null) {
            qPos.add(decimal);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfBigDecimal);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFBigDecimal> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f big decimals.
     *
     * @return the l f big decimals
     * @throws SystemException if a system exception occurred
     */
    public List<LFBigDecimal> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f big decimals.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f big decimals
     * @param end the upper bound of the range of l f big decimals (not inclusive)
     * @return the range of l f big decimals
     * @throws SystemException if a system exception occurred
     */
    public List<LFBigDecimal> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f big decimals.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f big decimals
     * @param end the upper bound of the range of l f big decimals (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f big decimals
     * @throws SystemException if a system exception occurred
     */
    public List<LFBigDecimal> findAll(int start, int end,
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

        List<LFBigDecimal> list = (List<LFBigDecimal>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFBIGDECIMAL);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFBIGDECIMAL;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFBigDecimal>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFBigDecimal>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f big decimals where decimal = &#63; from the database.
     *
     * @param decimal the decimal
     * @throws SystemException if a system exception occurred
     */
    public void removeByDecimal(BigDecimal decimal) throws SystemException {
        for (LFBigDecimal lfBigDecimal : findByDecimal(decimal)) {
            remove(lfBigDecimal);
        }
    }

    /**
     * Removes all the l f big decimals from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFBigDecimal lfBigDecimal : findAll()) {
            remove(lfBigDecimal);
        }
    }

    /**
     * Returns the number of l f big decimals where decimal = &#63;.
     *
     * @param decimal the decimal
     * @return the number of matching l f big decimals
     * @throws SystemException if a system exception occurred
     */
    public int countByDecimal(BigDecimal decimal) throws SystemException {
        Object[] finderArgs = new Object[] { decimal };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DECIMAL,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFBIGDECIMAL_WHERE);

            if (decimal == null) {
                query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_1);
            } else {
                if (decimal == null) {
                    query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_NULL_2);
                } else {
                    query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (decimal != null) {
                    qPos.add(decimal);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DECIMAL,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f big decimals.
     *
     * @return the number of l f big decimals
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFBIGDECIMAL);

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
     * Initializes the l f big decimal persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFBigDecimal")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFBigDecimal>> listenersList = new ArrayList<ModelListener<LFBigDecimal>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFBigDecimal>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFBigDecimalImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
