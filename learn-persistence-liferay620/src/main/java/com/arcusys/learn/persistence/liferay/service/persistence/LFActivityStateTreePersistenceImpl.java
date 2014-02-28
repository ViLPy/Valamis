package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateTree;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateTreeImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateTreeModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateTreePersistence;

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
 * The persistence implementation for the l f activity state tree service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateTreePersistence
 * @see LFActivityStateTreeUtil
 * @generated
 */
public class LFActivityStateTreePersistenceImpl extends BasePersistenceImpl<LFActivityStateTree>
    implements LFActivityStateTreePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFActivityStateTreeUtil} to access the l f activity state tree persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFActivityStateTreeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateTreeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateTreeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_ATTEMPTID = new FinderPath(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeModelImpl.FINDER_CACHE_ENABLED,
            LFActivityStateTreeImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByAttemptID", new String[] { Integer.class.getName() },
            LFActivityStateTreeModelImpl.ATTEMPTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTEMPTID = new FinderPath(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttemptID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_ATTEMPTID_ATTEMPTID_NULL = "lfActivityStateTree.attemptID IS NULL";
    private static final String _FINDER_COLUMN_ATTEMPTID_ATTEMPTID_2 = "lfActivityStateTree.attemptID = ?";
    private static final String _FINDER_COLUMN_ATTEMPTID_ATTEMPTID_NULL_2 = "lfActivityStateTree.attemptID IS NULL ";
    private static final String _SQL_SELECT_LFACTIVITYSTATETREE = "SELECT lfActivityStateTree FROM LFActivityStateTree lfActivityStateTree";
    private static final String _SQL_SELECT_LFACTIVITYSTATETREE_WHERE = "SELECT lfActivityStateTree FROM LFActivityStateTree lfActivityStateTree WHERE ";
    private static final String _SQL_COUNT_LFACTIVITYSTATETREE = "SELECT COUNT(lfActivityStateTree) FROM LFActivityStateTree lfActivityStateTree";
    private static final String _SQL_COUNT_LFACTIVITYSTATETREE_WHERE = "SELECT COUNT(lfActivityStateTree) FROM LFActivityStateTree lfActivityStateTree WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfActivityStateTree.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFActivityStateTree exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFActivityStateTree exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFActivityStateTreePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFActivityStateTree _nullLFActivityStateTree = new LFActivityStateTreeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFActivityStateTree> toCacheModel() {
                return _nullLFActivityStateTreeCacheModel;
            }
        };

    private static CacheModel<LFActivityStateTree> _nullLFActivityStateTreeCacheModel =
        new CacheModel<LFActivityStateTree>() {
            @Override
            public LFActivityStateTree toEntityModel() {
                return _nullLFActivityStateTree;
            }
        };

    public LFActivityStateTreePersistenceImpl() {
        setModelClass(LFActivityStateTree.class);
    }

    /**
     * Returns the l f activity state tree where attemptID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException} if it could not be found.
     *
     * @param attemptID the attempt i d
     * @return the matching l f activity state tree
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a matching l f activity state tree could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree findByAttemptID(Integer attemptID)
        throws NoSuchLFActivityStateTreeException, SystemException {
        LFActivityStateTree lfActivityStateTree = fetchByAttemptID(attemptID);

        if (lfActivityStateTree == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("attemptID=");
            msg.append(attemptID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFActivityStateTreeException(msg.toString());
        }

        return lfActivityStateTree;
    }

    /**
     * Returns the l f activity state tree where attemptID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param attemptID the attempt i d
     * @return the matching l f activity state tree, or <code>null</code> if a matching l f activity state tree could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree fetchByAttemptID(Integer attemptID)
        throws SystemException {
        return fetchByAttemptID(attemptID, true);
    }

    /**
     * Returns the l f activity state tree where attemptID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param attemptID the attempt i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f activity state tree, or <code>null</code> if a matching l f activity state tree could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree fetchByAttemptID(Integer attemptID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { attemptID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                    finderArgs, this);
        }

        if (result instanceof LFActivityStateTree) {
            LFActivityStateTree lfActivityStateTree = (LFActivityStateTree) result;

            if (!Validator.equals(attemptID, lfActivityStateTree.getAttemptID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFACTIVITYSTATETREE_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_ATTEMPTID_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ATTEMPTID_ATTEMPTID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
                }

                List<LFActivityStateTree> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFActivityStateTreePersistenceImpl.fetchByAttemptID(Integer, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFActivityStateTree lfActivityStateTree = list.get(0);

                    result = lfActivityStateTree;

                    cacheResult(lfActivityStateTree);

                    if ((lfActivityStateTree.getAttemptID() != attemptID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                            finderArgs, lfActivityStateTree);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFActivityStateTree) result;
        }
    }

    /**
     * Removes the l f activity state tree where attemptID = &#63; from the database.
     *
     * @param attemptID the attempt i d
     * @return the l f activity state tree that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree removeByAttemptID(Integer attemptID)
        throws NoSuchLFActivityStateTreeException, SystemException {
        LFActivityStateTree lfActivityStateTree = findByAttemptID(attemptID);

        return remove(lfActivityStateTree);
    }

    /**
     * Returns the number of l f activity state trees where attemptID = &#63;.
     *
     * @param attemptID the attempt i d
     * @return the number of matching l f activity state trees
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAttemptID(Integer attemptID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ATTEMPTID;

        Object[] finderArgs = new Object[] { attemptID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFACTIVITYSTATETREE_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_ATTEMPTID_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ATTEMPTID_ATTEMPTID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
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
     * Caches the l f activity state tree in the entity cache if it is enabled.
     *
     * @param lfActivityStateTree the l f activity state tree
     */
    @Override
    public void cacheResult(LFActivityStateTree lfActivityStateTree) {
        EntityCacheUtil.putResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeImpl.class, lfActivityStateTree.getPrimaryKey(),
            lfActivityStateTree);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTEMPTID,
            new Object[] { lfActivityStateTree.getAttemptID() },
            lfActivityStateTree);

        lfActivityStateTree.resetOriginalValues();
    }

    /**
     * Caches the l f activity state trees in the entity cache if it is enabled.
     *
     * @param lfActivityStateTrees the l f activity state trees
     */
    @Override
    public void cacheResult(List<LFActivityStateTree> lfActivityStateTrees) {
        for (LFActivityStateTree lfActivityStateTree : lfActivityStateTrees) {
            if (EntityCacheUtil.getResult(
                        LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityStateTreeImpl.class,
                        lfActivityStateTree.getPrimaryKey()) == null) {
                cacheResult(lfActivityStateTree);
            } else {
                lfActivityStateTree.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f activity state trees.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFActivityStateTreeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFActivityStateTreeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f activity state tree.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFActivityStateTree lfActivityStateTree) {
        EntityCacheUtil.removeResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeImpl.class, lfActivityStateTree.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfActivityStateTree);
    }

    @Override
    public void clearCache(List<LFActivityStateTree> lfActivityStateTrees) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFActivityStateTree lfActivityStateTree : lfActivityStateTrees) {
            EntityCacheUtil.removeResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityStateTreeImpl.class,
                lfActivityStateTree.getPrimaryKey());

            clearUniqueFindersCache(lfActivityStateTree);
        }
    }

    protected void cacheUniqueFindersCache(
        LFActivityStateTree lfActivityStateTree) {
        if (lfActivityStateTree.isNew()) {
            Object[] args = new Object[] { lfActivityStateTree.getAttemptID() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ATTEMPTID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTEMPTID, args,
                lfActivityStateTree);
        } else {
            LFActivityStateTreeModelImpl lfActivityStateTreeModelImpl = (LFActivityStateTreeModelImpl) lfActivityStateTree;

            if ((lfActivityStateTreeModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ATTEMPTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lfActivityStateTree.getAttemptID() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ATTEMPTID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTEMPTID, args,
                    lfActivityStateTree);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFActivityStateTree lfActivityStateTree) {
        LFActivityStateTreeModelImpl lfActivityStateTreeModelImpl = (LFActivityStateTreeModelImpl) lfActivityStateTree;

        Object[] args = new Object[] { lfActivityStateTree.getAttemptID() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTEMPTID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTEMPTID, args);

        if ((lfActivityStateTreeModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_ATTEMPTID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfActivityStateTreeModelImpl.getOriginalAttemptID()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTEMPTID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTEMPTID, args);
        }
    }

    /**
     * Creates a new l f activity state tree with the primary key. Does not add the l f activity state tree to the database.
     *
     * @param id the primary key for the new l f activity state tree
     * @return the new l f activity state tree
     */
    @Override
    public LFActivityStateTree create(long id) {
        LFActivityStateTree lfActivityStateTree = new LFActivityStateTreeImpl();

        lfActivityStateTree.setNew(true);
        lfActivityStateTree.setPrimaryKey(id);

        return lfActivityStateTree;
    }

    /**
     * Removes the l f activity state tree with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f activity state tree
     * @return the l f activity state tree that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree remove(long id)
        throws NoSuchLFActivityStateTreeException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f activity state tree with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f activity state tree
     * @return the l f activity state tree that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree remove(Serializable primaryKey)
        throws NoSuchLFActivityStateTreeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFActivityStateTree lfActivityStateTree = (LFActivityStateTree) session.get(LFActivityStateTreeImpl.class,
                    primaryKey);

            if (lfActivityStateTree == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFActivityStateTreeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfActivityStateTree);
        } catch (NoSuchLFActivityStateTreeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFActivityStateTree removeImpl(
        LFActivityStateTree lfActivityStateTree) throws SystemException {
        lfActivityStateTree = toUnwrappedModel(lfActivityStateTree);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfActivityStateTree)) {
                lfActivityStateTree = (LFActivityStateTree) session.get(LFActivityStateTreeImpl.class,
                        lfActivityStateTree.getPrimaryKeyObj());
            }

            if (lfActivityStateTree != null) {
                session.delete(lfActivityStateTree);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfActivityStateTree != null) {
            clearCache(lfActivityStateTree);
        }

        return lfActivityStateTree;
    }

    @Override
    public LFActivityStateTree updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree)
        throws SystemException {
        lfActivityStateTree = toUnwrappedModel(lfActivityStateTree);

        boolean isNew = lfActivityStateTree.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfActivityStateTree.isNew()) {
                session.save(lfActivityStateTree);

                lfActivityStateTree.setNew(false);
            } else {
                session.merge(lfActivityStateTree);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFActivityStateTreeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityStateTreeImpl.class, lfActivityStateTree.getPrimaryKey(),
            lfActivityStateTree);

        clearUniqueFindersCache(lfActivityStateTree);
        cacheUniqueFindersCache(lfActivityStateTree);

        return lfActivityStateTree;
    }

    protected LFActivityStateTree toUnwrappedModel(
        LFActivityStateTree lfActivityStateTree) {
        if (lfActivityStateTree instanceof LFActivityStateTreeImpl) {
            return lfActivityStateTree;
        }

        LFActivityStateTreeImpl lfActivityStateTreeImpl = new LFActivityStateTreeImpl();

        lfActivityStateTreeImpl.setNew(lfActivityStateTree.isNew());
        lfActivityStateTreeImpl.setPrimaryKey(lfActivityStateTree.getPrimaryKey());

        lfActivityStateTreeImpl.setId(lfActivityStateTree.getId());
        lfActivityStateTreeImpl.setCurrentActivityID(lfActivityStateTree.getCurrentActivityID());
        lfActivityStateTreeImpl.setSuspendedActivityID(lfActivityStateTree.getSuspendedActivityID());
        lfActivityStateTreeImpl.setAttemptID(lfActivityStateTree.getAttemptID());

        return lfActivityStateTreeImpl;
    }

    /**
     * Returns the l f activity state tree with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity state tree
     * @return the l f activity state tree
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFActivityStateTreeException, SystemException {
        LFActivityStateTree lfActivityStateTree = fetchByPrimaryKey(primaryKey);

        if (lfActivityStateTree == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFActivityStateTreeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfActivityStateTree;
    }

    /**
     * Returns the l f activity state tree with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException} if it could not be found.
     *
     * @param id the primary key of the l f activity state tree
     * @return the l f activity state tree
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree findByPrimaryKey(long id)
        throws NoSuchLFActivityStateTreeException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f activity state tree with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity state tree
     * @return the l f activity state tree, or <code>null</code> if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFActivityStateTree lfActivityStateTree = (LFActivityStateTree) EntityCacheUtil.getResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityStateTreeImpl.class, primaryKey);

        if (lfActivityStateTree == _nullLFActivityStateTree) {
            return null;
        }

        if (lfActivityStateTree == null) {
            Session session = null;

            try {
                session = openSession();

                lfActivityStateTree = (LFActivityStateTree) session.get(LFActivityStateTreeImpl.class,
                        primaryKey);

                if (lfActivityStateTree != null) {
                    cacheResult(lfActivityStateTree);
                } else {
                    EntityCacheUtil.putResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityStateTreeImpl.class, primaryKey,
                        _nullLFActivityStateTree);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFActivityStateTreeModelImpl.ENTITY_CACHE_ENABLED,
                    LFActivityStateTreeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfActivityStateTree;
    }

    /**
     * Returns the l f activity state tree with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f activity state tree
     * @return the l f activity state tree, or <code>null</code> if a l f activity state tree with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityStateTree fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f activity state trees.
     *
     * @return the l f activity state trees
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityStateTree> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activity state trees.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f activity state trees
     * @param end the upper bound of the range of l f activity state trees (not inclusive)
     * @return the range of l f activity state trees
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityStateTree> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activity state trees.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f activity state trees
     * @param end the upper bound of the range of l f activity state trees (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f activity state trees
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityStateTree> findAll(int start, int end,
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

        List<LFActivityStateTree> list = (List<LFActivityStateTree>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFACTIVITYSTATETREE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFACTIVITYSTATETREE;

                if (pagination) {
                    sql = sql.concat(LFActivityStateTreeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFActivityStateTree>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFActivityStateTree>(list);
                } else {
                    list = (List<LFActivityStateTree>) QueryUtil.list(q,
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
     * Removes all the l f activity state trees from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFActivityStateTree lfActivityStateTree : findAll()) {
            remove(lfActivityStateTree);
        }
    }

    /**
     * Returns the number of l f activity state trees.
     *
     * @return the number of l f activity state trees
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

                Query q = session.createQuery(_SQL_COUNT_LFACTIVITYSTATETREE);

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
     * Initializes the l f activity state tree persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFActivityStateTree")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFActivityStateTree>> listenersList = new ArrayList<ModelListener<LFActivityStateTree>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFActivityStateTree>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFActivityStateTreeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
