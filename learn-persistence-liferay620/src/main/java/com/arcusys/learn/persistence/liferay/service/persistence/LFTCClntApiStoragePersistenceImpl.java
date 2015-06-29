package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException;
import com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage;
import com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTCClntApiStoragePersistence;

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
 * The persistence implementation for the l f t c clnt api storage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTCClntApiStoragePersistence
 * @see LFTCClntApiStorageUtil
 * @generated
 */
public class LFTCClntApiStoragePersistenceImpl extends BasePersistenceImpl<LFTCClntApiStorage>
    implements LFTCClntApiStoragePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTCClntApiStorageUtil} to access the l f t c clnt api storage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTCClntApiStorageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTCClntApiStorageModelImpl.FINDER_CACHE_ENABLED,
            LFTCClntApiStorageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTCClntApiStorageModelImpl.FINDER_CACHE_ENABLED,
            LFTCClntApiStorageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTCClntApiStorageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_TOKEN = new FinderPath(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTCClntApiStorageModelImpl.FINDER_CACHE_ENABLED,
            LFTCClntApiStorageImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByToken", new String[] { String.class.getName() },
            LFTCClntApiStorageModelImpl.TOKEN_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TOKEN = new FinderPath(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTCClntApiStorageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByToken",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_1 = "lftcClntApiStorage.token IS NULL";
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_NULL = "lftcClntApiStorage.token IS NULL";
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_2 = "lftcClntApiStorage.token = ?";
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_NULL_2 = "lftcClntApiStorage.token IS NULL ";
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_3 = "(lftcClntApiStorage.token IS NULL OR lftcClntApiStorage.token = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTCClntApiStorageModelImpl.FINDER_CACHE_ENABLED,
            LFTCClntApiStorageImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByCode", new String[] { String.class.getName() },
            LFTCClntApiStorageModelImpl.CODE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTCClntApiStorageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_CODE_CODE_1 = "lftcClntApiStorage.code IS NULL";
    private static final String _FINDER_COLUMN_CODE_CODE_NULL = "lftcClntApiStorage.code IS NULL";
    private static final String _FINDER_COLUMN_CODE_CODE_2 = "lftcClntApiStorage.code = ?";
    private static final String _FINDER_COLUMN_CODE_CODE_NULL_2 = "lftcClntApiStorage.code IS NULL ";
    private static final String _FINDER_COLUMN_CODE_CODE_3 = "(lftcClntApiStorage.code IS NULL OR lftcClntApiStorage.code = '')";
    private static final String _SQL_SELECT_LFTCCLNTAPISTORAGE = "SELECT lftcClntApiStorage FROM LFTCClntApiStorage lftcClntApiStorage";
    private static final String _SQL_SELECT_LFTCCLNTAPISTORAGE_WHERE = "SELECT lftcClntApiStorage FROM LFTCClntApiStorage lftcClntApiStorage WHERE ";
    private static final String _SQL_COUNT_LFTCCLNTAPISTORAGE = "SELECT COUNT(lftcClntApiStorage) FROM LFTCClntApiStorage lftcClntApiStorage";
    private static final String _SQL_COUNT_LFTCCLNTAPISTORAGE_WHERE = "SELECT COUNT(lftcClntApiStorage) FROM LFTCClntApiStorage lftcClntApiStorage WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lftcClntApiStorage.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTCClntApiStorage exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTCClntApiStorage exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTCClntApiStoragePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id", "code"
            });
    private static LFTCClntApiStorage _nullLFTCClntApiStorage = new LFTCClntApiStorageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTCClntApiStorage> toCacheModel() {
                return _nullLFTCClntApiStorageCacheModel;
            }
        };

    private static CacheModel<LFTCClntApiStorage> _nullLFTCClntApiStorageCacheModel =
        new CacheModel<LFTCClntApiStorage>() {
            @Override
            public LFTCClntApiStorage toEntityModel() {
                return _nullLFTCClntApiStorage;
            }
        };

    public LFTCClntApiStoragePersistenceImpl() {
        setModelClass(LFTCClntApiStorage.class);
    }

    /**
     * Returns the l f t c clnt api storage where token = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException} if it could not be found.
     *
     * @param token the token
     * @return the matching l f t c clnt api storage
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException if a matching l f t c clnt api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage findByToken(String token)
        throws NoSuchLFTCClntApiStorageException, SystemException {
        LFTCClntApiStorage lftcClntApiStorage = fetchByToken(token);

        if (lftcClntApiStorage == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("token=");
            msg.append(token);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTCClntApiStorageException(msg.toString());
        }

        return lftcClntApiStorage;
    }

    /**
     * Returns the l f t c clnt api storage where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param token the token
     * @return the matching l f t c clnt api storage, or <code>null</code> if a matching l f t c clnt api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage fetchByToken(String token)
        throws SystemException {
        return fetchByToken(token, true);
    }

    /**
     * Returns the l f t c clnt api storage where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param token the token
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f t c clnt api storage, or <code>null</code> if a matching l f t c clnt api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage fetchByToken(String token,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { token };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TOKEN,
                    finderArgs, this);
        }

        if (result instanceof LFTCClntApiStorage) {
            LFTCClntApiStorage lftcClntApiStorage = (LFTCClntApiStorage) result;

            if (!Validator.equals(token, lftcClntApiStorage.getToken())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTCCLNTAPISTORAGE_WHERE);

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

                List<LFTCClntApiStorage> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTCClntApiStoragePersistenceImpl.fetchByToken(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTCClntApiStorage lftcClntApiStorage = list.get(0);

                    result = lftcClntApiStorage;

                    cacheResult(lftcClntApiStorage);

                    if ((lftcClntApiStorage.getToken() == null) ||
                            !lftcClntApiStorage.getToken().equals(token)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
                            finderArgs, lftcClntApiStorage);
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
            return (LFTCClntApiStorage) result;
        }
    }

    /**
     * Removes the l f t c clnt api storage where token = &#63; from the database.
     *
     * @param token the token
     * @return the l f t c clnt api storage that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage removeByToken(String token)
        throws NoSuchLFTCClntApiStorageException, SystemException {
        LFTCClntApiStorage lftcClntApiStorage = findByToken(token);

        return remove(lftcClntApiStorage);
    }

    /**
     * Returns the number of l f t c clnt api storages where token = &#63;.
     *
     * @param token the token
     * @return the number of matching l f t c clnt api storages
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

            query.append(_SQL_COUNT_LFTCCLNTAPISTORAGE_WHERE);

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
     * Returns the l f t c clnt api storage where code = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException} if it could not be found.
     *
     * @param code the code
     * @return the matching l f t c clnt api storage
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException if a matching l f t c clnt api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage findByCode(String code)
        throws NoSuchLFTCClntApiStorageException, SystemException {
        LFTCClntApiStorage lftcClntApiStorage = fetchByCode(code);

        if (lftcClntApiStorage == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("code=");
            msg.append(code);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTCClntApiStorageException(msg.toString());
        }

        return lftcClntApiStorage;
    }

    /**
     * Returns the l f t c clnt api storage where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param code the code
     * @return the matching l f t c clnt api storage, or <code>null</code> if a matching l f t c clnt api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage fetchByCode(String code)
        throws SystemException {
        return fetchByCode(code, true);
    }

    /**
     * Returns the l f t c clnt api storage where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param code the code
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f t c clnt api storage, or <code>null</code> if a matching l f t c clnt api storage could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage fetchByCode(String code, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { code };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
                    finderArgs, this);
        }

        if (result instanceof LFTCClntApiStorage) {
            LFTCClntApiStorage lftcClntApiStorage = (LFTCClntApiStorage) result;

            if (!Validator.equals(code, lftcClntApiStorage.getCode())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTCCLNTAPISTORAGE_WHERE);

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

                List<LFTCClntApiStorage> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTCClntApiStoragePersistenceImpl.fetchByCode(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTCClntApiStorage lftcClntApiStorage = list.get(0);

                    result = lftcClntApiStorage;

                    cacheResult(lftcClntApiStorage);

                    if ((lftcClntApiStorage.getCode() == null) ||
                            !lftcClntApiStorage.getCode().equals(code)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
                            finderArgs, lftcClntApiStorage);
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
            return (LFTCClntApiStorage) result;
        }
    }

    /**
     * Removes the l f t c clnt api storage where code = &#63; from the database.
     *
     * @param code the code
     * @return the l f t c clnt api storage that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage removeByCode(String code)
        throws NoSuchLFTCClntApiStorageException, SystemException {
        LFTCClntApiStorage lftcClntApiStorage = findByCode(code);

        return remove(lftcClntApiStorage);
    }

    /**
     * Returns the number of l f t c clnt api storages where code = &#63;.
     *
     * @param code the code
     * @return the number of matching l f t c clnt api storages
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

            query.append(_SQL_COUNT_LFTCCLNTAPISTORAGE_WHERE);

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
     * Caches the l f t c clnt api storage in the entity cache if it is enabled.
     *
     * @param lftcClntApiStorage the l f t c clnt api storage
     */
    @Override
    public void cacheResult(LFTCClntApiStorage lftcClntApiStorage) {
        EntityCacheUtil.putResult(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTCClntApiStorageImpl.class, lftcClntApiStorage.getPrimaryKey(),
            lftcClntApiStorage);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
            new Object[] { lftcClntApiStorage.getToken() }, lftcClntApiStorage);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
            new Object[] { lftcClntApiStorage.getCode() }, lftcClntApiStorage);

        lftcClntApiStorage.resetOriginalValues();
    }

    /**
     * Caches the l f t c clnt api storages in the entity cache if it is enabled.
     *
     * @param lftcClntApiStorages the l f t c clnt api storages
     */
    @Override
    public void cacheResult(List<LFTCClntApiStorage> lftcClntApiStorages) {
        for (LFTCClntApiStorage lftcClntApiStorage : lftcClntApiStorages) {
            if (EntityCacheUtil.getResult(
                        LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
                        LFTCClntApiStorageImpl.class,
                        lftcClntApiStorage.getPrimaryKey()) == null) {
                cacheResult(lftcClntApiStorage);
            } else {
                lftcClntApiStorage.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f t c clnt api storages.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTCClntApiStorageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTCClntApiStorageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f t c clnt api storage.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTCClntApiStorage lftcClntApiStorage) {
        EntityCacheUtil.removeResult(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTCClntApiStorageImpl.class, lftcClntApiStorage.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lftcClntApiStorage);
    }

    @Override
    public void clearCache(List<LFTCClntApiStorage> lftcClntApiStorages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTCClntApiStorage lftcClntApiStorage : lftcClntApiStorages) {
            EntityCacheUtil.removeResult(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
                LFTCClntApiStorageImpl.class, lftcClntApiStorage.getPrimaryKey());

            clearUniqueFindersCache(lftcClntApiStorage);
        }
    }

    protected void cacheUniqueFindersCache(
        LFTCClntApiStorage lftcClntApiStorage) {
        if (lftcClntApiStorage.isNew()) {
            Object[] args = new Object[] { lftcClntApiStorage.getToken() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args,
                lftcClntApiStorage);

            args = new Object[] { lftcClntApiStorage.getCode() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
                lftcClntApiStorage);
        } else {
            LFTCClntApiStorageModelImpl lftcClntApiStorageModelImpl = (LFTCClntApiStorageModelImpl) lftcClntApiStorage;

            if ((lftcClntApiStorageModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lftcClntApiStorage.getToken() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args,
                    lftcClntApiStorage);
            }

            if ((lftcClntApiStorageModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lftcClntApiStorage.getCode() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
                    lftcClntApiStorage);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFTCClntApiStorage lftcClntApiStorage) {
        LFTCClntApiStorageModelImpl lftcClntApiStorageModelImpl = (LFTCClntApiStorageModelImpl) lftcClntApiStorage;

        Object[] args = new Object[] { lftcClntApiStorage.getToken() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);

        if ((lftcClntApiStorageModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
            args = new Object[] { lftcClntApiStorageModelImpl.getOriginalToken() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);
        }

        args = new Object[] { lftcClntApiStorage.getCode() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

        if ((lftcClntApiStorageModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
            args = new Object[] { lftcClntApiStorageModelImpl.getOriginalCode() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
        }
    }

    /**
     * Creates a new l f t c clnt api storage with the primary key. Does not add the l f t c clnt api storage to the database.
     *
     * @param id the primary key for the new l f t c clnt api storage
     * @return the new l f t c clnt api storage
     */
    @Override
    public LFTCClntApiStorage create(long id) {
        LFTCClntApiStorage lftcClntApiStorage = new LFTCClntApiStorageImpl();

        lftcClntApiStorage.setNew(true);
        lftcClntApiStorage.setPrimaryKey(id);

        return lftcClntApiStorage;
    }

    /**
     * Removes the l f t c clnt api storage with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f t c clnt api storage
     * @return the l f t c clnt api storage that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException if a l f t c clnt api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage remove(long id)
        throws NoSuchLFTCClntApiStorageException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f t c clnt api storage with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f t c clnt api storage
     * @return the l f t c clnt api storage that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException if a l f t c clnt api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage remove(Serializable primaryKey)
        throws NoSuchLFTCClntApiStorageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTCClntApiStorage lftcClntApiStorage = (LFTCClntApiStorage) session.get(LFTCClntApiStorageImpl.class,
                    primaryKey);

            if (lftcClntApiStorage == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTCClntApiStorageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lftcClntApiStorage);
        } catch (NoSuchLFTCClntApiStorageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTCClntApiStorage removeImpl(
        LFTCClntApiStorage lftcClntApiStorage) throws SystemException {
        lftcClntApiStorage = toUnwrappedModel(lftcClntApiStorage);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lftcClntApiStorage)) {
                lftcClntApiStorage = (LFTCClntApiStorage) session.get(LFTCClntApiStorageImpl.class,
                        lftcClntApiStorage.getPrimaryKeyObj());
            }

            if (lftcClntApiStorage != null) {
                session.delete(lftcClntApiStorage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lftcClntApiStorage != null) {
            clearCache(lftcClntApiStorage);
        }

        return lftcClntApiStorage;
    }

    @Override
    public LFTCClntApiStorage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage lftcClntApiStorage)
        throws SystemException {
        lftcClntApiStorage = toUnwrappedModel(lftcClntApiStorage);

        boolean isNew = lftcClntApiStorage.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lftcClntApiStorage.isNew()) {
                session.save(lftcClntApiStorage);

                lftcClntApiStorage.setNew(false);
            } else {
                session.merge(lftcClntApiStorage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTCClntApiStorageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
            LFTCClntApiStorageImpl.class, lftcClntApiStorage.getPrimaryKey(),
            lftcClntApiStorage);

        clearUniqueFindersCache(lftcClntApiStorage);
        cacheUniqueFindersCache(lftcClntApiStorage);

        return lftcClntApiStorage;
    }

    protected LFTCClntApiStorage toUnwrappedModel(
        LFTCClntApiStorage lftcClntApiStorage) {
        if (lftcClntApiStorage instanceof LFTCClntApiStorageImpl) {
            return lftcClntApiStorage;
        }

        LFTCClntApiStorageImpl lftcClntApiStorageImpl = new LFTCClntApiStorageImpl();

        lftcClntApiStorageImpl.setNew(lftcClntApiStorage.isNew());
        lftcClntApiStorageImpl.setPrimaryKey(lftcClntApiStorage.getPrimaryKey());

        lftcClntApiStorageImpl.setId(lftcClntApiStorage.getId());
        lftcClntApiStorageImpl.setName(lftcClntApiStorage.getName());
        lftcClntApiStorageImpl.setDescription(lftcClntApiStorage.getDescription());
        lftcClntApiStorageImpl.setSecret(lftcClntApiStorage.getSecret());
        lftcClntApiStorageImpl.setUrl(lftcClntApiStorage.getUrl());
        lftcClntApiStorageImpl.setRedirectUrl(lftcClntApiStorage.getRedirectUrl());
        lftcClntApiStorageImpl.setScope(lftcClntApiStorage.getScope());
        lftcClntApiStorageImpl.setIconUrl(lftcClntApiStorage.getIconUrl());
        lftcClntApiStorageImpl.setToken(lftcClntApiStorage.getToken());
        lftcClntApiStorageImpl.setCode(lftcClntApiStorage.getCode());
        lftcClntApiStorageImpl.setIssuedAt(lftcClntApiStorage.getIssuedAt());
        lftcClntApiStorageImpl.setExpiredIn(lftcClntApiStorage.getExpiredIn());

        return lftcClntApiStorageImpl;
    }

    /**
     * Returns the l f t c clnt api storage with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f t c clnt api storage
     * @return the l f t c clnt api storage
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException if a l f t c clnt api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTCClntApiStorageException, SystemException {
        LFTCClntApiStorage lftcClntApiStorage = fetchByPrimaryKey(primaryKey);

        if (lftcClntApiStorage == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTCClntApiStorageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lftcClntApiStorage;
    }

    /**
     * Returns the l f t c clnt api storage with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException} if it could not be found.
     *
     * @param id the primary key of the l f t c clnt api storage
     * @return the l f t c clnt api storage
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException if a l f t c clnt api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage findByPrimaryKey(long id)
        throws NoSuchLFTCClntApiStorageException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f t c clnt api storage with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f t c clnt api storage
     * @return the l f t c clnt api storage, or <code>null</code> if a l f t c clnt api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTCClntApiStorage lftcClntApiStorage = (LFTCClntApiStorage) EntityCacheUtil.getResult(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
                LFTCClntApiStorageImpl.class, primaryKey);

        if (lftcClntApiStorage == _nullLFTCClntApiStorage) {
            return null;
        }

        if (lftcClntApiStorage == null) {
            Session session = null;

            try {
                session = openSession();

                lftcClntApiStorage = (LFTCClntApiStorage) session.get(LFTCClntApiStorageImpl.class,
                        primaryKey);

                if (lftcClntApiStorage != null) {
                    cacheResult(lftcClntApiStorage);
                } else {
                    EntityCacheUtil.putResult(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
                        LFTCClntApiStorageImpl.class, primaryKey,
                        _nullLFTCClntApiStorage);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTCClntApiStorageModelImpl.ENTITY_CACHE_ENABLED,
                    LFTCClntApiStorageImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lftcClntApiStorage;
    }

    /**
     * Returns the l f t c clnt api storage with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f t c clnt api storage
     * @return the l f t c clnt api storage, or <code>null</code> if a l f t c clnt api storage with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTCClntApiStorage fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f t c clnt api storages.
     *
     * @return the l f t c clnt api storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTCClntApiStorage> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f t c clnt api storages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f t c clnt api storages
     * @param end the upper bound of the range of l f t c clnt api storages (not inclusive)
     * @return the range of l f t c clnt api storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTCClntApiStorage> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f t c clnt api storages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f t c clnt api storages
     * @param end the upper bound of the range of l f t c clnt api storages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f t c clnt api storages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTCClntApiStorage> findAll(int start, int end,
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

        List<LFTCClntApiStorage> list = (List<LFTCClntApiStorage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTCCLNTAPISTORAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTCCLNTAPISTORAGE;

                if (pagination) {
                    sql = sql.concat(LFTCClntApiStorageModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTCClntApiStorage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTCClntApiStorage>(list);
                } else {
                    list = (List<LFTCClntApiStorage>) QueryUtil.list(q,
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
     * Removes all the l f t c clnt api storages from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTCClntApiStorage lftcClntApiStorage : findAll()) {
            remove(lftcClntApiStorage);
        }
    }

    /**
     * Returns the number of l f t c clnt api storages.
     *
     * @return the number of l f t c clnt api storages
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

                Query q = session.createQuery(_SQL_COUNT_LFTCCLNTAPISTORAGE);

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
     * Initializes the l f t c clnt api storage persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTCClntApiStorage>> listenersList = new ArrayList<ModelListener<LFTCClntApiStorage>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTCClntApiStorage>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTCClntApiStorageImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
