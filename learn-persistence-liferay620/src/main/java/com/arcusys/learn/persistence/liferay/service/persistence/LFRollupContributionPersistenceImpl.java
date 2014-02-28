package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException;
import com.arcusys.learn.persistence.liferay.model.LFRollupContribution;
import com.arcusys.learn.persistence.liferay.model.impl.LFRollupContributionImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFRollupContributionModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupContributionPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the l f rollup contribution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRollupContributionPersistence
 * @see LFRollupContributionUtil
 * @generated
 */
public class LFRollupContributionPersistenceImpl extends BasePersistenceImpl<LFRollupContribution>
    implements LFRollupContributionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFRollupContributionUtil} to access the l f rollup contribution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFRollupContributionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionModelImpl.FINDER_CACHE_ENABLED,
            LFRollupContributionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionModelImpl.FINDER_CACHE_ENABLED,
            LFRollupContributionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_SEQUENCINGID = new FinderPath(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionModelImpl.FINDER_CACHE_ENABLED,
            LFRollupContributionImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchBySequencingID", new String[] { Integer.class.getName() },
            LFRollupContributionModelImpl.SEQUENCINGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGID = new FinderPath(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySequencingID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL = "lfRollupContribution.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2 = "lfRollupContribution.sequencingID = ?";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2 = "lfRollupContribution.sequencingID IS NULL ";
    private static final String _SQL_SELECT_LFROLLUPCONTRIBUTION = "SELECT lfRollupContribution FROM LFRollupContribution lfRollupContribution";
    private static final String _SQL_SELECT_LFROLLUPCONTRIBUTION_WHERE = "SELECT lfRollupContribution FROM LFRollupContribution lfRollupContribution WHERE ";
    private static final String _SQL_COUNT_LFROLLUPCONTRIBUTION = "SELECT COUNT(lfRollupContribution) FROM LFRollupContribution lfRollupContribution";
    private static final String _SQL_COUNT_LFROLLUPCONTRIBUTION_WHERE = "SELECT COUNT(lfRollupContribution) FROM LFRollupContribution lfRollupContribution WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfRollupContribution.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFRollupContribution exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFRollupContribution exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFRollupContributionPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFRollupContribution _nullLFRollupContribution = new LFRollupContributionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFRollupContribution> toCacheModel() {
                return _nullLFRollupContributionCacheModel;
            }
        };

    private static CacheModel<LFRollupContribution> _nullLFRollupContributionCacheModel =
        new CacheModel<LFRollupContribution>() {
            @Override
            public LFRollupContribution toEntityModel() {
                return _nullLFRollupContribution;
            }
        };

    public LFRollupContributionPersistenceImpl() {
        setModelClass(LFRollupContribution.class);
    }

    /**
     * Returns the l f rollup contribution where sequencingID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException} if it could not be found.
     *
     * @param sequencingID the sequencing i d
     * @return the matching l f rollup contribution
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a matching l f rollup contribution could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution findBySequencingID(Integer sequencingID)
        throws NoSuchLFRollupContributionException, SystemException {
        LFRollupContribution lfRollupContribution = fetchBySequencingID(sequencingID);

        if (lfRollupContribution == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("sequencingID=");
            msg.append(sequencingID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFRollupContributionException(msg.toString());
        }

        return lfRollupContribution;
    }

    /**
     * Returns the l f rollup contribution where sequencingID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param sequencingID the sequencing i d
     * @return the matching l f rollup contribution, or <code>null</code> if a matching l f rollup contribution could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution fetchBySequencingID(Integer sequencingID)
        throws SystemException {
        return fetchBySequencingID(sequencingID, true);
    }

    /**
     * Returns the l f rollup contribution where sequencingID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param sequencingID the sequencing i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f rollup contribution, or <code>null</code> if a matching l f rollup contribution could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution fetchBySequencingID(Integer sequencingID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { sequencingID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                    finderArgs, this);
        }

        if (result instanceof LFRollupContribution) {
            LFRollupContribution lfRollupContribution = (LFRollupContribution) result;

            if (!Validator.equals(sequencingID,
                        lfRollupContribution.getSequencingID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFROLLUPCONTRIBUTION_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                List<LFRollupContribution> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFRollupContributionPersistenceImpl.fetchBySequencingID(Integer, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFRollupContribution lfRollupContribution = list.get(0);

                    result = lfRollupContribution;

                    cacheResult(lfRollupContribution);

                    if ((lfRollupContribution.getSequencingID() != sequencingID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                            finderArgs, lfRollupContribution);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFRollupContribution) result;
        }
    }

    /**
     * Removes the l f rollup contribution where sequencingID = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @return the l f rollup contribution that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution removeBySequencingID(Integer sequencingID)
        throws NoSuchLFRollupContributionException, SystemException {
        LFRollupContribution lfRollupContribution = findBySequencingID(sequencingID);

        return remove(lfRollupContribution);
    }

    /**
     * Returns the number of l f rollup contributions where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the number of matching l f rollup contributions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySequencingID(Integer sequencingID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SEQUENCINGID;

        Object[] finderArgs = new Object[] { sequencingID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFROLLUPCONTRIBUTION_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the l f rollup contribution in the entity cache if it is enabled.
     *
     * @param lfRollupContribution the l f rollup contribution
     */
    @Override
    public void cacheResult(LFRollupContribution lfRollupContribution) {
        EntityCacheUtil.putResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionImpl.class,
            lfRollupContribution.getPrimaryKey(), lfRollupContribution);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
            new Object[] { lfRollupContribution.getSequencingID() },
            lfRollupContribution);

        lfRollupContribution.resetOriginalValues();
    }

    /**
     * Caches the l f rollup contributions in the entity cache if it is enabled.
     *
     * @param lfRollupContributions the l f rollup contributions
     */
    @Override
    public void cacheResult(List<LFRollupContribution> lfRollupContributions) {
        for (LFRollupContribution lfRollupContribution : lfRollupContributions) {
            if (EntityCacheUtil.getResult(
                        LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
                        LFRollupContributionImpl.class,
                        lfRollupContribution.getPrimaryKey()) == null) {
                cacheResult(lfRollupContribution);
            } else {
                lfRollupContribution.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f rollup contributions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFRollupContributionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFRollupContributionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f rollup contribution.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFRollupContribution lfRollupContribution) {
        EntityCacheUtil.removeResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionImpl.class, lfRollupContribution.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfRollupContribution);
    }

    @Override
    public void clearCache(List<LFRollupContribution> lfRollupContributions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFRollupContribution lfRollupContribution : lfRollupContributions) {
            EntityCacheUtil.removeResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
                LFRollupContributionImpl.class,
                lfRollupContribution.getPrimaryKey());

            clearUniqueFindersCache(lfRollupContribution);
        }
    }

    protected void cacheUniqueFindersCache(
        LFRollupContribution lfRollupContribution) {
        if (lfRollupContribution.isNew()) {
            Object[] args = new Object[] { lfRollupContribution.getSequencingID() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEQUENCINGID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID, args,
                lfRollupContribution);
        } else {
            LFRollupContributionModelImpl lfRollupContributionModelImpl = (LFRollupContributionModelImpl) lfRollupContribution;

            if ((lfRollupContributionModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_SEQUENCINGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfRollupContribution.getSequencingID()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                    args, lfRollupContribution);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFRollupContribution lfRollupContribution) {
        LFRollupContributionModelImpl lfRollupContributionModelImpl = (LFRollupContributionModelImpl) lfRollupContribution;

        Object[] args = new Object[] { lfRollupContribution.getSequencingID() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEQUENCINGID, args);

        if ((lfRollupContributionModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_SEQUENCINGID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfRollupContributionModelImpl.getOriginalSequencingID()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEQUENCINGID, args);
        }
    }

    /**
     * Creates a new l f rollup contribution with the primary key. Does not add the l f rollup contribution to the database.
     *
     * @param id the primary key for the new l f rollup contribution
     * @return the new l f rollup contribution
     */
    @Override
    public LFRollupContribution create(long id) {
        LFRollupContribution lfRollupContribution = new LFRollupContributionImpl();

        lfRollupContribution.setNew(true);
        lfRollupContribution.setPrimaryKey(id);

        return lfRollupContribution;
    }

    /**
     * Removes the l f rollup contribution with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f rollup contribution
     * @return the l f rollup contribution that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution remove(long id)
        throws NoSuchLFRollupContributionException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f rollup contribution with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f rollup contribution
     * @return the l f rollup contribution that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution remove(Serializable primaryKey)
        throws NoSuchLFRollupContributionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFRollupContribution lfRollupContribution = (LFRollupContribution) session.get(LFRollupContributionImpl.class,
                    primaryKey);

            if (lfRollupContribution == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFRollupContributionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfRollupContribution);
        } catch (NoSuchLFRollupContributionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFRollupContribution removeImpl(
        LFRollupContribution lfRollupContribution) throws SystemException {
        lfRollupContribution = toUnwrappedModel(lfRollupContribution);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfRollupContribution)) {
                lfRollupContribution = (LFRollupContribution) session.get(LFRollupContributionImpl.class,
                        lfRollupContribution.getPrimaryKeyObj());
            }

            if (lfRollupContribution != null) {
                session.delete(lfRollupContribution);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfRollupContribution != null) {
            clearCache(lfRollupContribution);
        }

        return lfRollupContribution;
    }

    @Override
    public LFRollupContribution updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRollupContribution lfRollupContribution)
        throws SystemException {
        lfRollupContribution = toUnwrappedModel(lfRollupContribution);

        boolean isNew = lfRollupContribution.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfRollupContribution.isNew()) {
                session.save(lfRollupContribution);

                lfRollupContribution.setNew(false);
            } else {
                session.merge(lfRollupContribution);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFRollupContributionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionImpl.class,
            lfRollupContribution.getPrimaryKey(), lfRollupContribution);

        clearUniqueFindersCache(lfRollupContribution);
        cacheUniqueFindersCache(lfRollupContribution);

        return lfRollupContribution;
    }

    protected LFRollupContribution toUnwrappedModel(
        LFRollupContribution lfRollupContribution) {
        if (lfRollupContribution instanceof LFRollupContributionImpl) {
            return lfRollupContribution;
        }

        LFRollupContributionImpl lfRollupContributionImpl = new LFRollupContributionImpl();

        lfRollupContributionImpl.setNew(lfRollupContribution.isNew());
        lfRollupContributionImpl.setPrimaryKey(lfRollupContribution.getPrimaryKey());

        lfRollupContributionImpl.setId(lfRollupContribution.getId());
        lfRollupContributionImpl.setSequencingID(lfRollupContribution.getSequencingID());
        lfRollupContributionImpl.setContributeToSatisfied(lfRollupContribution.getContributeToSatisfied());
        lfRollupContributionImpl.setContributeToNotSatisfied(lfRollupContribution.getContributeToNotSatisfied());
        lfRollupContributionImpl.setContributeToCompleted(lfRollupContribution.getContributeToCompleted());
        lfRollupContributionImpl.setContributeToIncomplete(lfRollupContribution.getContributeToIncomplete());
        lfRollupContributionImpl.setObjectiveMeasureWeight(lfRollupContribution.getObjectiveMeasureWeight());
        lfRollupContributionImpl.setMeasureSatisfactionIfActive(lfRollupContribution.isMeasureSatisfactionIfActive());

        return lfRollupContributionImpl;
    }

    /**
     * Returns the l f rollup contribution with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f rollup contribution
     * @return the l f rollup contribution
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFRollupContributionException, SystemException {
        LFRollupContribution lfRollupContribution = fetchByPrimaryKey(primaryKey);

        if (lfRollupContribution == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFRollupContributionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfRollupContribution;
    }

    /**
     * Returns the l f rollup contribution with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException} if it could not be found.
     *
     * @param id the primary key of the l f rollup contribution
     * @return the l f rollup contribution
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution findByPrimaryKey(long id)
        throws NoSuchLFRollupContributionException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f rollup contribution with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f rollup contribution
     * @return the l f rollup contribution, or <code>null</code> if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFRollupContribution lfRollupContribution = (LFRollupContribution) EntityCacheUtil.getResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
                LFRollupContributionImpl.class, primaryKey);

        if (lfRollupContribution == _nullLFRollupContribution) {
            return null;
        }

        if (lfRollupContribution == null) {
            Session session = null;

            try {
                session = openSession();

                lfRollupContribution = (LFRollupContribution) session.get(LFRollupContributionImpl.class,
                        primaryKey);

                if (lfRollupContribution != null) {
                    cacheResult(lfRollupContribution);
                } else {
                    EntityCacheUtil.putResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
                        LFRollupContributionImpl.class, primaryKey,
                        _nullLFRollupContribution);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
                    LFRollupContributionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfRollupContribution;
    }

    /**
     * Returns the l f rollup contribution with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f rollup contribution
     * @return the l f rollup contribution, or <code>null</code> if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f rollup contributions.
     *
     * @return the l f rollup contributions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRollupContribution> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f rollup contributions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupContributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f rollup contributions
     * @param end the upper bound of the range of l f rollup contributions (not inclusive)
     * @return the range of l f rollup contributions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRollupContribution> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f rollup contributions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupContributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f rollup contributions
     * @param end the upper bound of the range of l f rollup contributions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f rollup contributions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRollupContribution> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<LFRollupContribution> list = (List<LFRollupContribution>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFROLLUPCONTRIBUTION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFROLLUPCONTRIBUTION;

                if (pagination) {
                    sql = sql.concat(LFRollupContributionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFRollupContribution>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFRollupContribution>(list);
                } else {
                    list = (List<LFRollupContribution>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the l f rollup contributions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFRollupContribution lfRollupContribution : findAll()) {
            remove(lfRollupContribution);
        }
    }

    /**
     * Returns the number of l f rollup contributions.
     *
     * @return the number of l f rollup contributions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFROLLUPCONTRIBUTION);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the l f rollup contribution persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFRollupContribution")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFRollupContribution>> listenersList = new ArrayList<ModelListener<LFRollupContribution>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFRollupContribution>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFRollupContributionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
