package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException;
import com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage;
import com.arcusys.learn.persistence.liferay.model.impl.LFPackageGradeStorageImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFPackageGradeStorageModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageGradeStoragePersistence;

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
 * The persistence implementation for the l f package grade storage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageGradeStoragePersistence
 * @see LFPackageGradeStorageUtil
 * @generated
 */
public class LFPackageGradeStoragePersistenceImpl extends BasePersistenceImpl<LFPackageGradeStorage>
    implements LFPackageGradeStoragePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFPackageGradeStorageUtil} to access the l f package grade storage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFPackageGradeStorageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageGradeStorageModelImpl.FINDER_CACHE_ENABLED,
            LFPackageGradeStorageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageGradeStorageModelImpl.FINDER_CACHE_ENABLED,
            LFPackageGradeStorageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageGradeStorageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_GRADE = new FinderPath(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageGradeStorageModelImpl.FINDER_CACHE_ENABLED,
            LFPackageGradeStorageImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByGrade",
            new String[] { Long.class.getName(), Long.class.getName() },
            LFPackageGradeStorageModelImpl.USERID_COLUMN_BITMASK |
            LFPackageGradeStorageModelImpl.PACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GRADE = new FinderPath(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageGradeStorageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGrade",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_GRADE_USERID_NULL = "lfPackageGradeStorage.userId IS NULL";
    private static final String _FINDER_COLUMN_GRADE_USERID_2 = "lfPackageGradeStorage.id.userId = ? AND ";
    private static final String _FINDER_COLUMN_GRADE_USERID_NULL_2 = "lfPackageGradeStorage.userId IS NULL  AND ";
    private static final String _FINDER_COLUMN_GRADE_PACKAGEID_NULL = "lfPackageGradeStorage.packageId IS NULL";
    private static final String _FINDER_COLUMN_GRADE_PACKAGEID_2 = "lfPackageGradeStorage.id.packageId = ?";
    private static final String _FINDER_COLUMN_GRADE_PACKAGEID_NULL_2 = "lfPackageGradeStorage.packageId IS NULL ";
    private static final String _SQL_SELECT_LFPACKAGEGRADESTORAGE = "SELECT lfPackageGradeStorage FROM LFPackageGradeStorage lfPackageGradeStorage";
    private static final String _SQL_SELECT_LFPACKAGEGRADESTORAGE_WHERE = "SELECT lfPackageGradeStorage FROM LFPackageGradeStorage lfPackageGradeStorage WHERE ";
    private static final String _SQL_COUNT_LFPACKAGEGRADESTORAGE = "SELECT COUNT(lfPackageGradeStorage) FROM LFPackageGradeStorage lfPackageGradeStorage";
    private static final String _SQL_COUNT_LFPACKAGEGRADESTORAGE_WHERE = "SELECT COUNT(lfPackageGradeStorage) FROM LFPackageGradeStorage lfPackageGradeStorage WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfPackageGradeStorage.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFPackageGradeStorage exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFPackageGradeStorage exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFPackageGradeStoragePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "comment", "date"
            });
    private static LFPackageGradeStorage _nullLFPackageGradeStorage = new LFPackageGradeStorageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFPackageGradeStorage> toCacheModel() {
                return _nullLFPackageGradeStorageCacheModel;
            }
        };

    private static CacheModel<LFPackageGradeStorage> _nullLFPackageGradeStorageCacheModel =
        new CacheModel<LFPackageGradeStorage>() {
            @Override
            public LFPackageGradeStorage toEntityModel() {
                return _nullLFPackageGradeStorage;
            }
        };

    public LFPackageGradeStoragePersistenceImpl() {
        setModelClass(LFPackageGradeStorage.class);
    }

    /**
     * Returns the l f package grade storage where userId = &#63; and packageId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException} if it could not be found.
     *
     * @param userId the user ID
     * @param packageId the package ID
     * @return the matching l f package grade storage
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException if a matching l f package grade storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageGradeStorage findByGrade(Long userId, Long packageId)
        throws NoSuchLFPackageGradeStorageException, SystemException {
        LFPackageGradeStorage lfPackageGradeStorage = fetchByGrade(userId,
                packageId);

        if (lfPackageGradeStorage == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("userId=");
            msg.append(userId);

            msg.append(", packageId=");
            msg.append(packageId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFPackageGradeStorageException(msg.toString());
        }

        return lfPackageGradeStorage;
    }

    /**
     * Returns the l f package grade storage where userId = &#63; and packageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param userId the user ID
     * @param packageId the package ID
     * @return the matching l f package grade storage, or <code>null</code> if a matching l f package grade storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageGradeStorage fetchByGrade(Long userId, Long packageId)
        throws SystemException {
        return fetchByGrade(userId, packageId, true);
    }

    /**
     * Returns the l f package grade storage where userId = &#63; and packageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param userId the user ID
     * @param packageId the package ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f package grade storage, or <code>null</code> if a matching l f package grade storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageGradeStorage fetchByGrade(Long userId, Long packageId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { userId, packageId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GRADE,
                    finderArgs, this);
        }

        if (result instanceof LFPackageGradeStorage) {
            LFPackageGradeStorage lfPackageGradeStorage = (LFPackageGradeStorage) result;

            if (!Validator.equals(userId, lfPackageGradeStorage.getUserId()) ||
                    !Validator.equals(packageId,
                        lfPackageGradeStorage.getPackageId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFPACKAGEGRADESTORAGE_WHERE);

            if (userId == null) {
                query.append(_FINDER_COLUMN_GRADE_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_GRADE_USERID_2);
            }

            if (packageId == null) {
                query.append(_FINDER_COLUMN_GRADE_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_GRADE_PACKAGEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userId != null) {
                    qPos.add(userId.longValue());
                }

                if (packageId != null) {
                    qPos.add(packageId.longValue());
                }

                List<LFPackageGradeStorage> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADE,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFPackageGradeStoragePersistenceImpl.fetchByGrade(Long, Long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFPackageGradeStorage lfPackageGradeStorage = list.get(0);

                    result = lfPackageGradeStorage;

                    cacheResult(lfPackageGradeStorage);

                    if ((lfPackageGradeStorage.getUserId() != userId) ||
                            (lfPackageGradeStorage.getPackageId() != packageId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADE,
                            finderArgs, lfPackageGradeStorage);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GRADE,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFPackageGradeStorage) result;
        }
    }

    /**
     * Removes the l f package grade storage where userId = &#63; and packageId = &#63; from the database.
     *
     * @param userId the user ID
     * @param packageId the package ID
     * @return the l f package grade storage that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageGradeStorage removeByGrade(Long userId, Long packageId)
        throws NoSuchLFPackageGradeStorageException, SystemException {
        LFPackageGradeStorage lfPackageGradeStorage = findByGrade(userId,
                packageId);

        return remove(lfPackageGradeStorage);
    }

    /**
     * Returns the number of l f package grade storages where userId = &#63; and packageId = &#63;.
     *
     * @param userId the user ID
     * @param packageId the package ID
     * @return the number of matching l f package grade storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGrade(Long userId, Long packageId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GRADE;

        Object[] finderArgs = new Object[] { userId, packageId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFPACKAGEGRADESTORAGE_WHERE);

            if (userId == null) {
                query.append(_FINDER_COLUMN_GRADE_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_GRADE_USERID_2);
            }

            if (packageId == null) {
                query.append(_FINDER_COLUMN_GRADE_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_GRADE_PACKAGEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userId != null) {
                    qPos.add(userId.longValue());
                }

                if (packageId != null) {
                    qPos.add(packageId.longValue());
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
     * Caches the l f package grade storage in the entity cache if it is enabled.
     *
     * @param lfPackageGradeStorage the l f package grade storage
     */
    @Override
    public void cacheResult(LFPackageGradeStorage lfPackageGradeStorage) {
        EntityCacheUtil.putResult(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageGradeStorageImpl.class,
            lfPackageGradeStorage.getPrimaryKey(), lfPackageGradeStorage);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADE,
            new Object[] {
                lfPackageGradeStorage.getUserId(),
                lfPackageGradeStorage.getPackageId()
            }, lfPackageGradeStorage);

        lfPackageGradeStorage.resetOriginalValues();
    }

    /**
     * Caches the l f package grade storages in the entity cache if it is enabled.
     *
     * @param lfPackageGradeStorages the l f package grade storages
     */
    @Override
    public void cacheResult(List<LFPackageGradeStorage> lfPackageGradeStorages) {
        for (LFPackageGradeStorage lfPackageGradeStorage : lfPackageGradeStorages) {
            if (EntityCacheUtil.getResult(
                        LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
                        LFPackageGradeStorageImpl.class,
                        lfPackageGradeStorage.getPrimaryKey()) == null) {
                cacheResult(lfPackageGradeStorage);
            } else {
                lfPackageGradeStorage.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f package grade storages.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFPackageGradeStorageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFPackageGradeStorageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f package grade storage.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFPackageGradeStorage lfPackageGradeStorage) {
        EntityCacheUtil.removeResult(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageGradeStorageImpl.class,
            lfPackageGradeStorage.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfPackageGradeStorage);
    }

    @Override
    public void clearCache(List<LFPackageGradeStorage> lfPackageGradeStorages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFPackageGradeStorage lfPackageGradeStorage : lfPackageGradeStorages) {
            EntityCacheUtil.removeResult(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
                LFPackageGradeStorageImpl.class,
                lfPackageGradeStorage.getPrimaryKey());

            clearUniqueFindersCache(lfPackageGradeStorage);
        }
    }

    protected void cacheUniqueFindersCache(
        LFPackageGradeStorage lfPackageGradeStorage) {
        if (lfPackageGradeStorage.isNew()) {
            Object[] args = new Object[] {
                    lfPackageGradeStorage.getUserId(),
                    lfPackageGradeStorage.getPackageId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GRADE, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADE, args,
                lfPackageGradeStorage);
        } else {
            LFPackageGradeStorageModelImpl lfPackageGradeStorageModelImpl = (LFPackageGradeStorageModelImpl) lfPackageGradeStorage;

            if ((lfPackageGradeStorageModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_GRADE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPackageGradeStorage.getUserId(),
                        lfPackageGradeStorage.getPackageId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GRADE, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADE, args,
                    lfPackageGradeStorage);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFPackageGradeStorage lfPackageGradeStorage) {
        LFPackageGradeStorageModelImpl lfPackageGradeStorageModelImpl = (LFPackageGradeStorageModelImpl) lfPackageGradeStorage;

        Object[] args = new Object[] {
                lfPackageGradeStorage.getUserId(),
                lfPackageGradeStorage.getPackageId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GRADE, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GRADE, args);

        if ((lfPackageGradeStorageModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_GRADE.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfPackageGradeStorageModelImpl.getOriginalUserId(),
                    lfPackageGradeStorageModelImpl.getOriginalPackageId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GRADE, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GRADE, args);
        }
    }

    /**
     * Creates a new l f package grade storage with the primary key. Does not add the l f package grade storage to the database.
     *
     * @param lfPackageGradeStoragePK the primary key for the new l f package grade storage
     * @return the new l f package grade storage
     */
    @Override
    public LFPackageGradeStorage create(
        LFPackageGradeStoragePK lfPackageGradeStoragePK) {
        LFPackageGradeStorage lfPackageGradeStorage = new LFPackageGradeStorageImpl();

        lfPackageGradeStorage.setNew(true);
        lfPackageGradeStorage.setPrimaryKey(lfPackageGradeStoragePK);

        return lfPackageGradeStorage;
    }

    /**
     * Removes the l f package grade storage with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfPackageGradeStoragePK the primary key of the l f package grade storage
     * @return the l f package grade storage that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException if a l f package grade storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageGradeStorage remove(
        LFPackageGradeStoragePK lfPackageGradeStoragePK)
        throws NoSuchLFPackageGradeStorageException, SystemException {
        return remove((Serializable) lfPackageGradeStoragePK);
    }

    /**
     * Removes the l f package grade storage with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f package grade storage
     * @return the l f package grade storage that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException if a l f package grade storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageGradeStorage remove(Serializable primaryKey)
        throws NoSuchLFPackageGradeStorageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFPackageGradeStorage lfPackageGradeStorage = (LFPackageGradeStorage) session.get(LFPackageGradeStorageImpl.class,
                    primaryKey);

            if (lfPackageGradeStorage == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFPackageGradeStorageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfPackageGradeStorage);
        } catch (NoSuchLFPackageGradeStorageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFPackageGradeStorage removeImpl(
        LFPackageGradeStorage lfPackageGradeStorage) throws SystemException {
        lfPackageGradeStorage = toUnwrappedModel(lfPackageGradeStorage);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfPackageGradeStorage)) {
                lfPackageGradeStorage = (LFPackageGradeStorage) session.get(LFPackageGradeStorageImpl.class,
                        lfPackageGradeStorage.getPrimaryKeyObj());
            }

            if (lfPackageGradeStorage != null) {
                session.delete(lfPackageGradeStorage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfPackageGradeStorage != null) {
            clearCache(lfPackageGradeStorage);
        }

        return lfPackageGradeStorage;
    }

    @Override
    public LFPackageGradeStorage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage lfPackageGradeStorage)
        throws SystemException {
        lfPackageGradeStorage = toUnwrappedModel(lfPackageGradeStorage);

        boolean isNew = lfPackageGradeStorage.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfPackageGradeStorage.isNew()) {
                session.save(lfPackageGradeStorage);

                lfPackageGradeStorage.setNew(false);
            } else {
                session.merge(lfPackageGradeStorage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFPackageGradeStorageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageGradeStorageImpl.class,
            lfPackageGradeStorage.getPrimaryKey(), lfPackageGradeStorage);

        clearUniqueFindersCache(lfPackageGradeStorage);
        cacheUniqueFindersCache(lfPackageGradeStorage);

        return lfPackageGradeStorage;
    }

    protected LFPackageGradeStorage toUnwrappedModel(
        LFPackageGradeStorage lfPackageGradeStorage) {
        if (lfPackageGradeStorage instanceof LFPackageGradeStorageImpl) {
            return lfPackageGradeStorage;
        }

        LFPackageGradeStorageImpl lfPackageGradeStorageImpl = new LFPackageGradeStorageImpl();

        lfPackageGradeStorageImpl.setNew(lfPackageGradeStorage.isNew());
        lfPackageGradeStorageImpl.setPrimaryKey(lfPackageGradeStorage.getPrimaryKey());

        lfPackageGradeStorageImpl.setUserId(lfPackageGradeStorage.getUserId());
        lfPackageGradeStorageImpl.setPackageId(lfPackageGradeStorage.getPackageId());
        lfPackageGradeStorageImpl.setGrade(lfPackageGradeStorage.getGrade());
        lfPackageGradeStorageImpl.setComment(lfPackageGradeStorage.getComment());
        lfPackageGradeStorageImpl.setDate(lfPackageGradeStorage.getDate());

        return lfPackageGradeStorageImpl;
    }

    /**
     * Returns the l f package grade storage with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f package grade storage
     * @return the l f package grade storage
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException if a l f package grade storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageGradeStorage findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFPackageGradeStorageException, SystemException {
        LFPackageGradeStorage lfPackageGradeStorage = fetchByPrimaryKey(primaryKey);

        if (lfPackageGradeStorage == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFPackageGradeStorageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfPackageGradeStorage;
    }

    /**
     * Returns the l f package grade storage with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException} if it could not be found.
     *
     * @param lfPackageGradeStoragePK the primary key of the l f package grade storage
     * @return the l f package grade storage
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException if a l f package grade storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageGradeStorage findByPrimaryKey(
        LFPackageGradeStoragePK lfPackageGradeStoragePK)
        throws NoSuchLFPackageGradeStorageException, SystemException {
        return findByPrimaryKey((Serializable) lfPackageGradeStoragePK);
    }

    /**
     * Returns the l f package grade storage with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f package grade storage
     * @return the l f package grade storage, or <code>null</code> if a l f package grade storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageGradeStorage fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFPackageGradeStorage lfPackageGradeStorage = (LFPackageGradeStorage) EntityCacheUtil.getResult(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
                LFPackageGradeStorageImpl.class, primaryKey);

        if (lfPackageGradeStorage == _nullLFPackageGradeStorage) {
            return null;
        }

        if (lfPackageGradeStorage == null) {
            Session session = null;

            try {
                session = openSession();

                lfPackageGradeStorage = (LFPackageGradeStorage) session.get(LFPackageGradeStorageImpl.class,
                        primaryKey);

                if (lfPackageGradeStorage != null) {
                    cacheResult(lfPackageGradeStorage);
                } else {
                    EntityCacheUtil.putResult(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
                        LFPackageGradeStorageImpl.class, primaryKey,
                        _nullLFPackageGradeStorage);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFPackageGradeStorageModelImpl.ENTITY_CACHE_ENABLED,
                    LFPackageGradeStorageImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfPackageGradeStorage;
    }

    /**
     * Returns the l f package grade storage with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param lfPackageGradeStoragePK the primary key of the l f package grade storage
     * @return the l f package grade storage, or <code>null</code> if a l f package grade storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageGradeStorage fetchByPrimaryKey(
        LFPackageGradeStoragePK lfPackageGradeStoragePK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) lfPackageGradeStoragePK);
    }

    /**
     * Returns all the l f package grade storages.
     *
     * @return the l f package grade storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageGradeStorage> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f package grade storages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageGradeStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f package grade storages
     * @param end the upper bound of the range of l f package grade storages (not inclusive)
     * @return the range of l f package grade storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageGradeStorage> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f package grade storages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageGradeStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f package grade storages
     * @param end the upper bound of the range of l f package grade storages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f package grade storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageGradeStorage> findAll(int start, int end,
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

        List<LFPackageGradeStorage> list = (List<LFPackageGradeStorage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFPACKAGEGRADESTORAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFPACKAGEGRADESTORAGE;

                if (pagination) {
                    sql = sql.concat(LFPackageGradeStorageModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFPackageGradeStorage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackageGradeStorage>(list);
                } else {
                    list = (List<LFPackageGradeStorage>) QueryUtil.list(q,
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
     * Removes all the l f package grade storages from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFPackageGradeStorage lfPackageGradeStorage : findAll()) {
            remove(lfPackageGradeStorage);
        }
    }

    /**
     * Returns the number of l f package grade storages.
     *
     * @return the number of l f package grade storages
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

                Query q = session.createQuery(_SQL_COUNT_LFPACKAGEGRADESTORAGE);

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
     * Initializes the l f package grade storage persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFPackageGradeStorage>> listenersList = new ArrayList<ModelListener<LFPackageGradeStorage>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFPackageGradeStorage>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFPackageGradeStorageImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
