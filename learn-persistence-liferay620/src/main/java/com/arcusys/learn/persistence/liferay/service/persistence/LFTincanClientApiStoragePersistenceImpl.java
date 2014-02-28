package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException;
import com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanClientApiStorageImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanClientApiStorageModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanClientApiStoragePersistence;

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
 * The persistence implementation for the l f tincan client api storage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanClientApiStoragePersistence
 * @see LFTincanClientApiStorageUtil
 * @generated
 */
public class LFTincanClientApiStoragePersistenceImpl extends BasePersistenceImpl<LFTincanClientApiStorage>
    implements LFTincanClientApiStoragePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanClientApiStorageUtil} to access the l f tincan client api storage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanClientApiStorageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanClientApiStorageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanClientApiStorageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanClientApiStorageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanClientApiStorageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanClientApiStorageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_TOKEN = new FinderPath(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanClientApiStorageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanClientApiStorageImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByToken", new String[] { String.class.getName() },
            LFTincanClientApiStorageModelImpl.TOKEN_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TOKEN = new FinderPath(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanClientApiStorageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByToken",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_1 = "lfTincanClientApiStorage.token IS NULL";
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_NULL = "lfTincanClientApiStorage.token IS NULL";
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_2 = "lfTincanClientApiStorage.token = ?";
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_NULL_2 = "lfTincanClientApiStorage.token IS NULL ";
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_3 = "(lfTincanClientApiStorage.token IS NULL OR lfTincanClientApiStorage.token = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanClientApiStorageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanClientApiStorageImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByCode", new String[] { String.class.getName() },
            LFTincanClientApiStorageModelImpl.CODE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanClientApiStorageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_CODE_CODE_1 = "lfTincanClientApiStorage.code IS NULL";
    private static final String _FINDER_COLUMN_CODE_CODE_NULL = "lfTincanClientApiStorage.code IS NULL";
    private static final String _FINDER_COLUMN_CODE_CODE_2 = "lfTincanClientApiStorage.code = ?";
    private static final String _FINDER_COLUMN_CODE_CODE_NULL_2 = "lfTincanClientApiStorage.code IS NULL ";
    private static final String _FINDER_COLUMN_CODE_CODE_3 = "(lfTincanClientApiStorage.code IS NULL OR lfTincanClientApiStorage.code = '')";
    private static final String _SQL_SELECT_LFTINCANCLIENTAPISTORAGE = "SELECT lfTincanClientApiStorage FROM LFTincanClientApiStorage lfTincanClientApiStorage";
    private static final String _SQL_SELECT_LFTINCANCLIENTAPISTORAGE_WHERE = "SELECT lfTincanClientApiStorage FROM LFTincanClientApiStorage lfTincanClientApiStorage WHERE ";
    private static final String _SQL_COUNT_LFTINCANCLIENTAPISTORAGE = "SELECT COUNT(lfTincanClientApiStorage) FROM LFTincanClientApiStorage lfTincanClientApiStorage";
    private static final String _SQL_COUNT_LFTINCANCLIENTAPISTORAGE_WHERE = "SELECT COUNT(lfTincanClientApiStorage) FROM LFTincanClientApiStorage lfTincanClientApiStorage WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanClientApiStorage.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanClientApiStorage exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanClientApiStorage exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanClientApiStoragePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id", "code"
            });
    private static LFTincanClientApiStorage _nullLFTincanClientApiStorage = new LFTincanClientApiStorageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanClientApiStorage> toCacheModel() {
                return _nullLFTincanClientApiStorageCacheModel;
            }
        };

    private static CacheModel<LFTincanClientApiStorage> _nullLFTincanClientApiStorageCacheModel =
        new CacheModel<LFTincanClientApiStorage>() {
            @Override
            public LFTincanClientApiStorage toEntityModel() {
                return _nullLFTincanClientApiStorage;
            }
        };

    public LFTincanClientApiStoragePersistenceImpl() {
        setModelClass(LFTincanClientApiStorage.class);
    }

    /**
     * Returns the l f tincan client api storage where token = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException} if it could not be found.
     *
     * @param token the token
     * @return the matching l f tincan client api storage
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException if a matching l f tincan client api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage findByToken(String token)
        throws NoSuchLFTincanClientApiStorageException, SystemException {
        LFTincanClientApiStorage lfTincanClientApiStorage = fetchByToken(token);

        if (lfTincanClientApiStorage == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("token=");
            msg.append(token);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanClientApiStorageException(msg.toString());
        }

        return lfTincanClientApiStorage;
    }

    /**
     * Returns the l f tincan client api storage where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param token the token
     * @return the matching l f tincan client api storage, or <code>null</code> if a matching l f tincan client api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage fetchByToken(String token)
        throws SystemException {
        return fetchByToken(token, true);
    }

    /**
     * Returns the l f tincan client api storage where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param token the token
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan client api storage, or <code>null</code> if a matching l f tincan client api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage fetchByToken(String token,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { token };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TOKEN,
                    finderArgs, this);
        }

        if (result instanceof LFTincanClientApiStorage) {
            LFTincanClientApiStorage lfTincanClientApiStorage = (LFTincanClientApiStorage) result;

            if (!Validator.equals(token, lfTincanClientApiStorage.getToken())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTINCANCLIENTAPISTORAGE_WHERE);

            boolean bindToken = false;

            if (token == null) {
                query.append(_FINDER_COLUMN_TOKEN_TOKEN_1);
            } else if (token.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
            } else {
                bindToken = true;

                if (token.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
                } else {
                    query.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindToken) {
                    if (token != null) {
                        qPos.add(token);
                    }
                }

                List<LFTincanClientApiStorage> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTincanClientApiStoragePersistenceImpl.fetchByToken(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTincanClientApiStorage lfTincanClientApiStorage = list.get(0);

                    result = lfTincanClientApiStorage;

                    cacheResult(lfTincanClientApiStorage);

                    if ((lfTincanClientApiStorage.getToken() == null) ||
                            !lfTincanClientApiStorage.getToken().equals(token)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
                            finderArgs, lfTincanClientApiStorage);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFTincanClientApiStorage) result;
        }
    }

    /**
     * Removes the l f tincan client api storage where token = &#63; from the database.
     *
     * @param token the token
     * @return the l f tincan client api storage that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage removeByToken(String token)
        throws NoSuchLFTincanClientApiStorageException, SystemException {
        LFTincanClientApiStorage lfTincanClientApiStorage = findByToken(token);

        return remove(lfTincanClientApiStorage);
    }

    /**
     * Returns the number of l f tincan client api storages where token = &#63;.
     *
     * @param token the token
     * @return the number of matching l f tincan client api storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByToken(String token) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TOKEN;

        Object[] finderArgs = new Object[] { token };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANCLIENTAPISTORAGE_WHERE);

            boolean bindToken = false;

            if (token == null) {
                query.append(_FINDER_COLUMN_TOKEN_TOKEN_1);
            } else if (token.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
            } else {
                bindToken = true;

                if (token.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
                } else {
                    query.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindToken) {
                    if (token != null) {
                        qPos.add(token);
                    }
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
     * Returns the l f tincan client api storage where code = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException} if it could not be found.
     *
     * @param code the code
     * @return the matching l f tincan client api storage
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException if a matching l f tincan client api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage findByCode(String code)
        throws NoSuchLFTincanClientApiStorageException, SystemException {
        LFTincanClientApiStorage lfTincanClientApiStorage = fetchByCode(code);

        if (lfTincanClientApiStorage == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("code=");
            msg.append(code);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanClientApiStorageException(msg.toString());
        }

        return lfTincanClientApiStorage;
    }

    /**
     * Returns the l f tincan client api storage where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param code the code
     * @return the matching l f tincan client api storage, or <code>null</code> if a matching l f tincan client api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage fetchByCode(String code)
        throws SystemException {
        return fetchByCode(code, true);
    }

    /**
     * Returns the l f tincan client api storage where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param code the code
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan client api storage, or <code>null</code> if a matching l f tincan client api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage fetchByCode(String code,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { code };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
                    finderArgs, this);
        }

        if (result instanceof LFTincanClientApiStorage) {
            LFTincanClientApiStorage lfTincanClientApiStorage = (LFTincanClientApiStorage) result;

            if (!Validator.equals(code, lfTincanClientApiStorage.getCode())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTINCANCLIENTAPISTORAGE_WHERE);

            boolean bindCode = false;

            if (code == null) {
                query.append(_FINDER_COLUMN_CODE_CODE_1);
            } else if (code.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CODE_CODE_3);
            } else {
                bindCode = true;

                if (code.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CODE_CODE_3);
                } else {
                    query.append(_FINDER_COLUMN_CODE_CODE_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCode) {
                    if (code != null) {
                        qPos.add(code);
                    }
                }

                List<LFTincanClientApiStorage> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTincanClientApiStoragePersistenceImpl.fetchByCode(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTincanClientApiStorage lfTincanClientApiStorage = list.get(0);

                    result = lfTincanClientApiStorage;

                    cacheResult(lfTincanClientApiStorage);

                    if ((lfTincanClientApiStorage.getCode() == null) ||
                            !lfTincanClientApiStorage.getCode().equals(code)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
                            finderArgs, lfTincanClientApiStorage);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFTincanClientApiStorage) result;
        }
    }

    /**
     * Removes the l f tincan client api storage where code = &#63; from the database.
     *
     * @param code the code
     * @return the l f tincan client api storage that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage removeByCode(String code)
        throws NoSuchLFTincanClientApiStorageException, SystemException {
        LFTincanClientApiStorage lfTincanClientApiStorage = findByCode(code);

        return remove(lfTincanClientApiStorage);
    }

    /**
     * Returns the number of l f tincan client api storages where code = &#63;.
     *
     * @param code the code
     * @return the number of matching l f tincan client api storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCode(String code) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

        Object[] finderArgs = new Object[] { code };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANCLIENTAPISTORAGE_WHERE);

            boolean bindCode = false;

            if (code == null) {
                query.append(_FINDER_COLUMN_CODE_CODE_1);
            } else if (code.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CODE_CODE_3);
            } else {
                bindCode = true;

                if (code.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CODE_CODE_3);
                } else {
                    query.append(_FINDER_COLUMN_CODE_CODE_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCode) {
                    if (code != null) {
                        qPos.add(code);
                    }
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
     * Caches the l f tincan client api storage in the entity cache if it is enabled.
     *
     * @param lfTincanClientApiStorage the l f tincan client api storage
     */
    @Override
    public void cacheResult(LFTincanClientApiStorage lfTincanClientApiStorage) {
        EntityCacheUtil.putResult(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanClientApiStorageImpl.class,
            lfTincanClientApiStorage.getPrimaryKey(), lfTincanClientApiStorage);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
            new Object[] { lfTincanClientApiStorage.getToken() },
            lfTincanClientApiStorage);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
            new Object[] { lfTincanClientApiStorage.getCode() },
            lfTincanClientApiStorage);

        lfTincanClientApiStorage.resetOriginalValues();
    }

    /**
     * Caches the l f tincan client api storages in the entity cache if it is enabled.
     *
     * @param lfTincanClientApiStorages the l f tincan client api storages
     */
    @Override
    public void cacheResult(
        List<LFTincanClientApiStorage> lfTincanClientApiStorages) {
        for (LFTincanClientApiStorage lfTincanClientApiStorage : lfTincanClientApiStorages) {
            if (EntityCacheUtil.getResult(
                        LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanClientApiStorageImpl.class,
                        lfTincanClientApiStorage.getPrimaryKey()) == null) {
                cacheResult(lfTincanClientApiStorage);
            } else {
                lfTincanClientApiStorage.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan client api storages.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanClientApiStorageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanClientApiStorageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan client api storage.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanClientApiStorage lfTincanClientApiStorage) {
        EntityCacheUtil.removeResult(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanClientApiStorageImpl.class,
            lfTincanClientApiStorage.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanClientApiStorage);
    }

    @Override
    public void clearCache(
        List<LFTincanClientApiStorage> lfTincanClientApiStorages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanClientApiStorage lfTincanClientApiStorage : lfTincanClientApiStorages) {
            EntityCacheUtil.removeResult(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanClientApiStorageImpl.class,
                lfTincanClientApiStorage.getPrimaryKey());

            clearUniqueFindersCache(lfTincanClientApiStorage);
        }
    }

    protected void cacheUniqueFindersCache(
        LFTincanClientApiStorage lfTincanClientApiStorage) {
        if (lfTincanClientApiStorage.isNew()) {
            Object[] args = new Object[] { lfTincanClientApiStorage.getToken() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args,
                lfTincanClientApiStorage);

            args = new Object[] { lfTincanClientApiStorage.getCode() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
                lfTincanClientApiStorage);
        } else {
            LFTincanClientApiStorageModelImpl lfTincanClientApiStorageModelImpl = (LFTincanClientApiStorageModelImpl) lfTincanClientApiStorage;

            if ((lfTincanClientApiStorageModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lfTincanClientApiStorage.getToken() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args,
                    lfTincanClientApiStorage);
            }

            if ((lfTincanClientApiStorageModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lfTincanClientApiStorage.getCode() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
                    lfTincanClientApiStorage);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFTincanClientApiStorage lfTincanClientApiStorage) {
        LFTincanClientApiStorageModelImpl lfTincanClientApiStorageModelImpl = (LFTincanClientApiStorageModelImpl) lfTincanClientApiStorage;

        Object[] args = new Object[] { lfTincanClientApiStorage.getToken() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);

        if ((lfTincanClientApiStorageModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfTincanClientApiStorageModelImpl.getOriginalToken()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);
        }

        args = new Object[] { lfTincanClientApiStorage.getCode() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

        if ((lfTincanClientApiStorageModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfTincanClientApiStorageModelImpl.getOriginalCode()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
        }
    }

    /**
     * Creates a new l f tincan client api storage with the primary key. Does not add the l f tincan client api storage to the database.
     *
     * @param id the primary key for the new l f tincan client api storage
     * @return the new l f tincan client api storage
     */
    @Override
    public LFTincanClientApiStorage create(long id) {
        LFTincanClientApiStorage lfTincanClientApiStorage = new LFTincanClientApiStorageImpl();

        lfTincanClientApiStorage.setNew(true);
        lfTincanClientApiStorage.setPrimaryKey(id);

        return lfTincanClientApiStorage;
    }

    /**
     * Removes the l f tincan client api storage with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan client api storage
     * @return the l f tincan client api storage that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException if a l f tincan client api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage remove(long id)
        throws NoSuchLFTincanClientApiStorageException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan client api storage with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan client api storage
     * @return the l f tincan client api storage that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException if a l f tincan client api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage remove(Serializable primaryKey)
        throws NoSuchLFTincanClientApiStorageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanClientApiStorage lfTincanClientApiStorage = (LFTincanClientApiStorage) session.get(LFTincanClientApiStorageImpl.class,
                    primaryKey);

            if (lfTincanClientApiStorage == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanClientApiStorageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanClientApiStorage);
        } catch (NoSuchLFTincanClientApiStorageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanClientApiStorage removeImpl(
        LFTincanClientApiStorage lfTincanClientApiStorage)
        throws SystemException {
        lfTincanClientApiStorage = toUnwrappedModel(lfTincanClientApiStorage);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanClientApiStorage)) {
                lfTincanClientApiStorage = (LFTincanClientApiStorage) session.get(LFTincanClientApiStorageImpl.class,
                        lfTincanClientApiStorage.getPrimaryKeyObj());
            }

            if (lfTincanClientApiStorage != null) {
                session.delete(lfTincanClientApiStorage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanClientApiStorage != null) {
            clearCache(lfTincanClientApiStorage);
        }

        return lfTincanClientApiStorage;
    }

    @Override
    public LFTincanClientApiStorage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage lfTincanClientApiStorage)
        throws SystemException {
        lfTincanClientApiStorage = toUnwrappedModel(lfTincanClientApiStorage);

        boolean isNew = lfTincanClientApiStorage.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfTincanClientApiStorage.isNew()) {
                session.save(lfTincanClientApiStorage);

                lfTincanClientApiStorage.setNew(false);
            } else {
                session.merge(lfTincanClientApiStorage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanClientApiStorageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanClientApiStorageImpl.class,
            lfTincanClientApiStorage.getPrimaryKey(), lfTincanClientApiStorage);

        clearUniqueFindersCache(lfTincanClientApiStorage);
        cacheUniqueFindersCache(lfTincanClientApiStorage);

        return lfTincanClientApiStorage;
    }

    protected LFTincanClientApiStorage toUnwrappedModel(
        LFTincanClientApiStorage lfTincanClientApiStorage) {
        if (lfTincanClientApiStorage instanceof LFTincanClientApiStorageImpl) {
            return lfTincanClientApiStorage;
        }

        LFTincanClientApiStorageImpl lfTincanClientApiStorageImpl = new LFTincanClientApiStorageImpl();

        lfTincanClientApiStorageImpl.setNew(lfTincanClientApiStorage.isNew());
        lfTincanClientApiStorageImpl.setPrimaryKey(lfTincanClientApiStorage.getPrimaryKey());

        lfTincanClientApiStorageImpl.setId(lfTincanClientApiStorage.getId());
        lfTincanClientApiStorageImpl.setName(lfTincanClientApiStorage.getName());
        lfTincanClientApiStorageImpl.setDescription(lfTincanClientApiStorage.getDescription());
        lfTincanClientApiStorageImpl.setSecret(lfTincanClientApiStorage.getSecret());
        lfTincanClientApiStorageImpl.setUrl(lfTincanClientApiStorage.getUrl());
        lfTincanClientApiStorageImpl.setRedirectUrl(lfTincanClientApiStorage.getRedirectUrl());
        lfTincanClientApiStorageImpl.setScope(lfTincanClientApiStorage.getScope());
        lfTincanClientApiStorageImpl.setIconUrl(lfTincanClientApiStorage.getIconUrl());
        lfTincanClientApiStorageImpl.setToken(lfTincanClientApiStorage.getToken());
        lfTincanClientApiStorageImpl.setCode(lfTincanClientApiStorage.getCode());
        lfTincanClientApiStorageImpl.setIssuedAt(lfTincanClientApiStorage.getIssuedAt());
        lfTincanClientApiStorageImpl.setExpiredIn(lfTincanClientApiStorage.getExpiredIn());

        return lfTincanClientApiStorageImpl;
    }

    /**
     * Returns the l f tincan client api storage with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan client api storage
     * @return the l f tincan client api storage
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException if a l f tincan client api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanClientApiStorageException, SystemException {
        LFTincanClientApiStorage lfTincanClientApiStorage = fetchByPrimaryKey(primaryKey);

        if (lfTincanClientApiStorage == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanClientApiStorageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanClientApiStorage;
    }

    /**
     * Returns the l f tincan client api storage with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException} if it could not be found.
     *
     * @param id the primary key of the l f tincan client api storage
     * @return the l f tincan client api storage
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException if a l f tincan client api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage findByPrimaryKey(long id)
        throws NoSuchLFTincanClientApiStorageException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan client api storage with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan client api storage
     * @return the l f tincan client api storage, or <code>null</code> if a l f tincan client api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanClientApiStorage lfTincanClientApiStorage = (LFTincanClientApiStorage) EntityCacheUtil.getResult(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanClientApiStorageImpl.class, primaryKey);

        if (lfTincanClientApiStorage == _nullLFTincanClientApiStorage) {
            return null;
        }

        if (lfTincanClientApiStorage == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanClientApiStorage = (LFTincanClientApiStorage) session.get(LFTincanClientApiStorageImpl.class,
                        primaryKey);

                if (lfTincanClientApiStorage != null) {
                    cacheResult(lfTincanClientApiStorage);
                } else {
                    EntityCacheUtil.putResult(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanClientApiStorageImpl.class, primaryKey,
                        _nullLFTincanClientApiStorage);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanClientApiStorageModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanClientApiStorageImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanClientApiStorage;
    }

    /**
     * Returns the l f tincan client api storage with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan client api storage
     * @return the l f tincan client api storage, or <code>null</code> if a l f tincan client api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanClientApiStorage fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan client api storages.
     *
     * @return the l f tincan client api storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanClientApiStorage> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan client api storages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanClientApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan client api storages
     * @param end the upper bound of the range of l f tincan client api storages (not inclusive)
     * @return the range of l f tincan client api storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanClientApiStorage> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan client api storages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanClientApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan client api storages
     * @param end the upper bound of the range of l f tincan client api storages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan client api storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanClientApiStorage> findAll(int start, int end,
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

        List<LFTincanClientApiStorage> list = (List<LFTincanClientApiStorage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANCLIENTAPISTORAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANCLIENTAPISTORAGE;

                if (pagination) {
                    sql = sql.concat(LFTincanClientApiStorageModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanClientApiStorage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanClientApiStorage>(list);
                } else {
                    list = (List<LFTincanClientApiStorage>) QueryUtil.list(q,
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
     * Removes all the l f tincan client api storages from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanClientApiStorage lfTincanClientApiStorage : findAll()) {
            remove(lfTincanClientApiStorage);
        }
    }

    /**
     * Returns the number of l f tincan client api storages.
     *
     * @return the number of l f tincan client api storages
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANCLIENTAPISTORAGE);

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
     * Initializes the l f tincan client api storage persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanClientApiStorage>> listenersList = new ArrayList<ModelListener<LFTincanClientApiStorage>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanClientApiStorage>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanClientApiStorageImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
