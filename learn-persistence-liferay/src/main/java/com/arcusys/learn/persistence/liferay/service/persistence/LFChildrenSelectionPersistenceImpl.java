package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException;
import com.arcusys.learn.persistence.liferay.model.LFChildrenSelection;
import com.arcusys.learn.persistence.liferay.model.impl.LFChildrenSelectionImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFChildrenSelectionModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFChildrenSelectionPersistence;

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
 * The persistence implementation for the l f children selection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFChildrenSelectionPersistence
 * @see LFChildrenSelectionUtil
 * @generated
 */
public class LFChildrenSelectionPersistenceImpl extends BasePersistenceImpl<LFChildrenSelection>
    implements LFChildrenSelectionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFChildrenSelectionUtil} to access the l f children selection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFChildrenSelectionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
            LFChildrenSelectionModelImpl.FINDER_CACHE_ENABLED,
            LFChildrenSelectionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
            LFChildrenSelectionModelImpl.FINDER_CACHE_ENABLED,
            LFChildrenSelectionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
            LFChildrenSelectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_SEQUENCINGID = new FinderPath(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
            LFChildrenSelectionModelImpl.FINDER_CACHE_ENABLED,
            LFChildrenSelectionImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchBySequencingID", new String[] { Integer.class.getName() },
            LFChildrenSelectionModelImpl.SEQUENCINGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGID = new FinderPath(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
            LFChildrenSelectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySequencingID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL = "lfChildrenSelection.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2 = "lfChildrenSelection.sequencingID = ?";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2 = "lfChildrenSelection.sequencingID IS NULL ";
    private static final String _SQL_SELECT_LFCHILDRENSELECTION = "SELECT lfChildrenSelection FROM LFChildrenSelection lfChildrenSelection";
    private static final String _SQL_SELECT_LFCHILDRENSELECTION_WHERE = "SELECT lfChildrenSelection FROM LFChildrenSelection lfChildrenSelection WHERE ";
    private static final String _SQL_COUNT_LFCHILDRENSELECTION = "SELECT COUNT(lfChildrenSelection) FROM LFChildrenSelection lfChildrenSelection";
    private static final String _SQL_COUNT_LFCHILDRENSELECTION_WHERE = "SELECT COUNT(lfChildrenSelection) FROM LFChildrenSelection lfChildrenSelection WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfChildrenSelection.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFChildrenSelection exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFChildrenSelection exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFChildrenSelectionPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFChildrenSelection _nullLFChildrenSelection = new LFChildrenSelectionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFChildrenSelection> toCacheModel() {
                return _nullLFChildrenSelectionCacheModel;
            }
        };

    private static CacheModel<LFChildrenSelection> _nullLFChildrenSelectionCacheModel =
        new CacheModel<LFChildrenSelection>() {
            @Override
            public LFChildrenSelection toEntityModel() {
                return _nullLFChildrenSelection;
            }
        };

    public LFChildrenSelectionPersistenceImpl() {
        setModelClass(LFChildrenSelection.class);
    }

    /**
     * Returns the l f children selection where sequencingID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException} if it could not be found.
     *
     * @param sequencingID the sequencing i d
     * @return the matching l f children selection
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException if a matching l f children selection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFChildrenSelection findBySequencingID(Integer sequencingID)
        throws NoSuchLFChildrenSelectionException, SystemException {
        LFChildrenSelection lfChildrenSelection = fetchBySequencingID(sequencingID);

        if (lfChildrenSelection == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("sequencingID=");
            msg.append(sequencingID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFChildrenSelectionException(msg.toString());
        }

        return lfChildrenSelection;
    }

    /**
     * Returns the l f children selection where sequencingID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param sequencingID the sequencing i d
     * @return the matching l f children selection, or <code>null</code> if a matching l f children selection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFChildrenSelection fetchBySequencingID(Integer sequencingID)
        throws SystemException {
        return fetchBySequencingID(sequencingID, true);
    }

    /**
     * Returns the l f children selection where sequencingID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param sequencingID the sequencing i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f children selection, or <code>null</code> if a matching l f children selection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFChildrenSelection fetchBySequencingID(Integer sequencingID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { sequencingID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                    finderArgs, this);
        }

        if (result instanceof LFChildrenSelection) {
            LFChildrenSelection lfChildrenSelection = (LFChildrenSelection) result;

            if (!Validator.equals(sequencingID,
                        lfChildrenSelection.getSequencingID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFCHILDRENSELECTION_WHERE);

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

                List<LFChildrenSelection> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFChildrenSelectionPersistenceImpl.fetchBySequencingID(Integer, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFChildrenSelection lfChildrenSelection = list.get(0);

                    result = lfChildrenSelection;

                    cacheResult(lfChildrenSelection);

                    if ((lfChildrenSelection.getSequencingID() != sequencingID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                            finderArgs, lfChildrenSelection);
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
            return (LFChildrenSelection) result;
        }
    }

    /**
     * Removes the l f children selection where sequencingID = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @return the l f children selection that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFChildrenSelection removeBySequencingID(Integer sequencingID)
        throws NoSuchLFChildrenSelectionException, SystemException {
        LFChildrenSelection lfChildrenSelection = findBySequencingID(sequencingID);

        return remove(lfChildrenSelection);
    }

    /**
     * Returns the number of l f children selections where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the number of matching l f children selections
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

            query.append(_SQL_COUNT_LFCHILDRENSELECTION_WHERE);

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
     * Caches the l f children selection in the entity cache if it is enabled.
     *
     * @param lfChildrenSelection the l f children selection
     */
    @Override
    public void cacheResult(LFChildrenSelection lfChildrenSelection) {
        EntityCacheUtil.putResult(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
            LFChildrenSelectionImpl.class, lfChildrenSelection.getPrimaryKey(),
            lfChildrenSelection);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
            new Object[] { lfChildrenSelection.getSequencingID() },
            lfChildrenSelection);

        lfChildrenSelection.resetOriginalValues();
    }

    /**
     * Caches the l f children selections in the entity cache if it is enabled.
     *
     * @param lfChildrenSelections the l f children selections
     */
    @Override
    public void cacheResult(List<LFChildrenSelection> lfChildrenSelections) {
        for (LFChildrenSelection lfChildrenSelection : lfChildrenSelections) {
            if (EntityCacheUtil.getResult(
                        LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
                        LFChildrenSelectionImpl.class,
                        lfChildrenSelection.getPrimaryKey()) == null) {
                cacheResult(lfChildrenSelection);
            } else {
                lfChildrenSelection.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f children selections.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFChildrenSelectionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFChildrenSelectionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f children selection.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFChildrenSelection lfChildrenSelection) {
        EntityCacheUtil.removeResult(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
            LFChildrenSelectionImpl.class, lfChildrenSelection.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfChildrenSelection);
    }

    @Override
    public void clearCache(List<LFChildrenSelection> lfChildrenSelections) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFChildrenSelection lfChildrenSelection : lfChildrenSelections) {
            EntityCacheUtil.removeResult(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
                LFChildrenSelectionImpl.class,
                lfChildrenSelection.getPrimaryKey());

            clearUniqueFindersCache(lfChildrenSelection);
        }
    }

    protected void cacheUniqueFindersCache(
        LFChildrenSelection lfChildrenSelection) {
        if (lfChildrenSelection.isNew()) {
            Object[] args = new Object[] { lfChildrenSelection.getSequencingID() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEQUENCINGID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID, args,
                lfChildrenSelection);
        } else {
            LFChildrenSelectionModelImpl lfChildrenSelectionModelImpl = (LFChildrenSelectionModelImpl) lfChildrenSelection;

            if ((lfChildrenSelectionModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_SEQUENCINGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfChildrenSelection.getSequencingID()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                    args, lfChildrenSelection);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFChildrenSelection lfChildrenSelection) {
        LFChildrenSelectionModelImpl lfChildrenSelectionModelImpl = (LFChildrenSelectionModelImpl) lfChildrenSelection;

        Object[] args = new Object[] { lfChildrenSelection.getSequencingID() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEQUENCINGID, args);

        if ((lfChildrenSelectionModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_SEQUENCINGID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfChildrenSelectionModelImpl.getOriginalSequencingID()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEQUENCINGID, args);
        }
    }

    /**
     * Creates a new l f children selection with the primary key. Does not add the l f children selection to the database.
     *
     * @param id the primary key for the new l f children selection
     * @return the new l f children selection
     */
    @Override
    public LFChildrenSelection create(long id) {
        LFChildrenSelection lfChildrenSelection = new LFChildrenSelectionImpl();

        lfChildrenSelection.setNew(true);
        lfChildrenSelection.setPrimaryKey(id);

        return lfChildrenSelection;
    }

    /**
     * Removes the l f children selection with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f children selection
     * @return the l f children selection that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException if a l f children selection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFChildrenSelection remove(long id)
        throws NoSuchLFChildrenSelectionException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f children selection with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f children selection
     * @return the l f children selection that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException if a l f children selection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFChildrenSelection remove(Serializable primaryKey)
        throws NoSuchLFChildrenSelectionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFChildrenSelection lfChildrenSelection = (LFChildrenSelection) session.get(LFChildrenSelectionImpl.class,
                    primaryKey);

            if (lfChildrenSelection == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFChildrenSelectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfChildrenSelection);
        } catch (NoSuchLFChildrenSelectionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFChildrenSelection removeImpl(
        LFChildrenSelection lfChildrenSelection) throws SystemException {
        lfChildrenSelection = toUnwrappedModel(lfChildrenSelection);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfChildrenSelection)) {
                lfChildrenSelection = (LFChildrenSelection) session.get(LFChildrenSelectionImpl.class,
                        lfChildrenSelection.getPrimaryKeyObj());
            }

            if (lfChildrenSelection != null) {
                session.delete(lfChildrenSelection);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfChildrenSelection != null) {
            clearCache(lfChildrenSelection);
        }

        return lfChildrenSelection;
    }

    @Override
    public LFChildrenSelection updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFChildrenSelection lfChildrenSelection)
        throws SystemException {
        lfChildrenSelection = toUnwrappedModel(lfChildrenSelection);

        boolean isNew = lfChildrenSelection.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfChildrenSelection.isNew()) {
                session.save(lfChildrenSelection);

                lfChildrenSelection.setNew(false);
            } else {
                session.merge(lfChildrenSelection);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFChildrenSelectionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
            LFChildrenSelectionImpl.class, lfChildrenSelection.getPrimaryKey(),
            lfChildrenSelection);

        clearUniqueFindersCache(lfChildrenSelection);
        cacheUniqueFindersCache(lfChildrenSelection);

        return lfChildrenSelection;
    }

    protected LFChildrenSelection toUnwrappedModel(
        LFChildrenSelection lfChildrenSelection) {
        if (lfChildrenSelection instanceof LFChildrenSelectionImpl) {
            return lfChildrenSelection;
        }

        LFChildrenSelectionImpl lfChildrenSelectionImpl = new LFChildrenSelectionImpl();

        lfChildrenSelectionImpl.setNew(lfChildrenSelection.isNew());
        lfChildrenSelectionImpl.setPrimaryKey(lfChildrenSelection.getPrimaryKey());

        lfChildrenSelectionImpl.setId(lfChildrenSelection.getId());
        lfChildrenSelectionImpl.setSequencingID(lfChildrenSelection.getSequencingID());
        lfChildrenSelectionImpl.setTakeCount(lfChildrenSelection.getTakeCount());
        lfChildrenSelectionImpl.setTakeTimingOnEachAttempt(lfChildrenSelection.getTakeTimingOnEachAttempt());
        lfChildrenSelectionImpl.setReorderOnEachAttempt(lfChildrenSelection.getReorderOnEachAttempt());

        return lfChildrenSelectionImpl;
    }

    /**
     * Returns the l f children selection with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f children selection
     * @return the l f children selection
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException if a l f children selection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFChildrenSelection findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFChildrenSelectionException, SystemException {
        LFChildrenSelection lfChildrenSelection = fetchByPrimaryKey(primaryKey);

        if (lfChildrenSelection == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFChildrenSelectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfChildrenSelection;
    }

    /**
     * Returns the l f children selection with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException} if it could not be found.
     *
     * @param id the primary key of the l f children selection
     * @return the l f children selection
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException if a l f children selection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFChildrenSelection findByPrimaryKey(long id)
        throws NoSuchLFChildrenSelectionException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f children selection with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f children selection
     * @return the l f children selection, or <code>null</code> if a l f children selection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFChildrenSelection fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFChildrenSelection lfChildrenSelection = (LFChildrenSelection) EntityCacheUtil.getResult(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
                LFChildrenSelectionImpl.class, primaryKey);

        if (lfChildrenSelection == _nullLFChildrenSelection) {
            return null;
        }

        if (lfChildrenSelection == null) {
            Session session = null;

            try {
                session = openSession();

                lfChildrenSelection = (LFChildrenSelection) session.get(LFChildrenSelectionImpl.class,
                        primaryKey);

                if (lfChildrenSelection != null) {
                    cacheResult(lfChildrenSelection);
                } else {
                    EntityCacheUtil.putResult(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
                        LFChildrenSelectionImpl.class, primaryKey,
                        _nullLFChildrenSelection);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFChildrenSelectionModelImpl.ENTITY_CACHE_ENABLED,
                    LFChildrenSelectionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfChildrenSelection;
    }

    /**
     * Returns the l f children selection with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f children selection
     * @return the l f children selection, or <code>null</code> if a l f children selection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFChildrenSelection fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f children selections.
     *
     * @return the l f children selections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFChildrenSelection> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f children selections.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFChildrenSelectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f children selections
     * @param end the upper bound of the range of l f children selections (not inclusive)
     * @return the range of l f children selections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFChildrenSelection> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f children selections.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFChildrenSelectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f children selections
     * @param end the upper bound of the range of l f children selections (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f children selections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFChildrenSelection> findAll(int start, int end,
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

        List<LFChildrenSelection> list = (List<LFChildrenSelection>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCHILDRENSELECTION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCHILDRENSELECTION;

                if (pagination) {
                    sql = sql.concat(LFChildrenSelectionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFChildrenSelection>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFChildrenSelection>(list);
                } else {
                    list = (List<LFChildrenSelection>) QueryUtil.list(q,
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
     * Removes all the l f children selections from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFChildrenSelection lfChildrenSelection : findAll()) {
            remove(lfChildrenSelection);
        }
    }

    /**
     * Returns the number of l f children selections.
     *
     * @return the number of l f children selections
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

                Query q = session.createQuery(_SQL_COUNT_LFCHILDRENSELECTION);

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
     * Initializes the l f children selection persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFChildrenSelection")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFChildrenSelection>> listenersList = new ArrayList<ModelListener<LFChildrenSelection>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFChildrenSelection>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFChildrenSelectionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
