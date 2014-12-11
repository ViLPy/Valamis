package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException;
import com.arcusys.learn.persistence.liferay.model.LFTincanURI;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanURIPersistence;

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
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l f tincan u r i service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanURIPersistence
 * @see LFTincanURIUtil
 * @generated
 */
public class LFTincanURIPersistenceImpl extends BasePersistenceImpl<LFTincanURI>
    implements LFTincanURIPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanURIUtil} to access the l f tincan u r i persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanURIImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanURIModelImpl.FINDER_CACHE_ENABLED, LFTincanURIImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanURIModelImpl.FINDER_CACHE_ENABLED, LFTincanURIImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanURIModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_URI = new FinderPath(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanURIModelImpl.FINDER_CACHE_ENABLED, LFTincanURIImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByURI",
            new String[] { String.class.getName(), String.class.getName() },
            LFTincanURIModelImpl.OBJID_COLUMN_BITMASK |
            LFTincanURIModelImpl.OBJTYPE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_URI = new FinderPath(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanURIModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByURI",
            new String[] { String.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_URI_OBJID_1 = "lfTincanURI.objID IS NULL AND ";
    private static final String _FINDER_COLUMN_URI_OBJID_NULL = "lfTincanURI.objID IS NULL";
    private static final String _FINDER_COLUMN_URI_OBJID_2 = "lfTincanURI.objID = ? AND ";
    private static final String _FINDER_COLUMN_URI_OBJID_NULL_2 = "lfTincanURI.objID IS NULL  AND ";
    private static final String _FINDER_COLUMN_URI_OBJID_3 = "(lfTincanURI.objID IS NULL OR lfTincanURI.objID = '') AND ";
    private static final String _FINDER_COLUMN_URI_OBJTYPE_1 = "lfTincanURI.objType IS NULL";
    private static final String _FINDER_COLUMN_URI_OBJTYPE_NULL = "lfTincanURI.objType IS NULL";
    private static final String _FINDER_COLUMN_URI_OBJTYPE_2 = "lfTincanURI.objType = ?";
    private static final String _FINDER_COLUMN_URI_OBJTYPE_NULL_2 = "lfTincanURI.objType IS NULL ";
    private static final String _FINDER_COLUMN_URI_OBJTYPE_3 = "(lfTincanURI.objType IS NULL OR lfTincanURI.objType = '')";
    private static final String _SQL_SELECT_LFTINCANURI = "SELECT lfTincanURI FROM LFTincanURI lfTincanURI";
    private static final String _SQL_SELECT_LFTINCANURI_WHERE = "SELECT lfTincanURI FROM LFTincanURI lfTincanURI WHERE ";
    private static final String _SQL_COUNT_LFTINCANURI = "SELECT COUNT(lfTincanURI) FROM LFTincanURI lfTincanURI";
    private static final String _SQL_COUNT_LFTINCANURI_WHERE = "SELECT COUNT(lfTincanURI) FROM LFTincanURI lfTincanURI WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanURI.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanURI exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanURI exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanURIPersistenceImpl.class);
    private static LFTincanURI _nullLFTincanURI = new LFTincanURIImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanURI> toCacheModel() {
                return _nullLFTincanURICacheModel;
            }
        };

    private static CacheModel<LFTincanURI> _nullLFTincanURICacheModel = new CacheModel<LFTincanURI>() {
            @Override
            public LFTincanURI toEntityModel() {
                return _nullLFTincanURI;
            }
        };

    public LFTincanURIPersistenceImpl() {
        setModelClass(LFTincanURI.class);
    }

    /**
     * Returns the l f tincan u r i where objID = &#63; and objType = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException} if it could not be found.
     *
     * @param objID the obj i d
     * @param objType the obj type
     * @return the matching l f tincan u r i
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException if a matching l f tincan u r i could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanURI findByURI(String objID, String objType)
        throws NoSuchLFTincanURIException, SystemException {
        LFTincanURI lfTincanURI = fetchByURI(objID, objType);

        if (lfTincanURI == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("objID=");
            msg.append(objID);

            msg.append(", objType=");
            msg.append(objType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanURIException(msg.toString());
        }

        return lfTincanURI;
    }

    /**
     * Returns the l f tincan u r i where objID = &#63; and objType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param objID the obj i d
     * @param objType the obj type
     * @return the matching l f tincan u r i, or <code>null</code> if a matching l f tincan u r i could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanURI fetchByURI(String objID, String objType)
        throws SystemException {
        return fetchByURI(objID, objType, true);
    }

    /**
     * Returns the l f tincan u r i where objID = &#63; and objType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param objID the obj i d
     * @param objType the obj type
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan u r i, or <code>null</code> if a matching l f tincan u r i could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanURI fetchByURI(String objID, String objType,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { objID, objType };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_URI,
                    finderArgs, this);
        }

        if (result instanceof LFTincanURI) {
            LFTincanURI lfTincanURI = (LFTincanURI) result;

            if (!Validator.equals(objID, lfTincanURI.getObjID()) ||
                    !Validator.equals(objType, lfTincanURI.getObjType())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFTINCANURI_WHERE);

            boolean bindObjID = false;

            if (objID == null) {
                query.append(_FINDER_COLUMN_URI_OBJID_1);
            } else if (objID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_URI_OBJID_3);
            } else {
                bindObjID = true;

                if (objID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_URI_OBJID_3);
                } else {
                    query.append(_FINDER_COLUMN_URI_OBJID_2);
                }
            }

            boolean bindObjType = false;

            if (objType == null) {
                query.append(_FINDER_COLUMN_URI_OBJTYPE_1);
            } else if (objType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_URI_OBJTYPE_3);
            } else {
                bindObjType = true;

                if (objType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_URI_OBJTYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_URI_OBJTYPE_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindObjID) {
                    if (objID != null) {
                        qPos.add(objID);
                    }
                }

                if (bindObjType) {
                    if (objType != null) {
                        qPos.add(objType);
                    }
                }

                List<LFTincanURI> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTincanURIPersistenceImpl.fetchByURI(String, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTincanURI lfTincanURI = list.get(0);

                    result = lfTincanURI;

                    cacheResult(lfTincanURI);

                    if ((lfTincanURI.getObjID() == null) ||
                            !lfTincanURI.getObjID().equals(objID) ||
                            (lfTincanURI.getObjType() == null) ||
                            !lfTincanURI.getObjType().equals(objType)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI,
                            finderArgs, lfTincanURI);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URI,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFTincanURI) result;
        }
    }

    /**
     * Removes the l f tincan u r i where objID = &#63; and objType = &#63; from the database.
     *
     * @param objID the obj i d
     * @param objType the obj type
     * @return the l f tincan u r i that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanURI removeByURI(String objID, String objType)
        throws NoSuchLFTincanURIException, SystemException {
        LFTincanURI lfTincanURI = findByURI(objID, objType);

        return remove(lfTincanURI);
    }

    /**
     * Returns the number of l f tincan u r is where objID = &#63; and objType = &#63;.
     *
     * @param objID the obj i d
     * @param objType the obj type
     * @return the number of matching l f tincan u r is
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByURI(String objID, String objType)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_URI;

        Object[] finderArgs = new Object[] { objID, objType };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFTINCANURI_WHERE);

            boolean bindObjID = false;

            if (objID == null) {
                query.append(_FINDER_COLUMN_URI_OBJID_1);
            } else if (objID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_URI_OBJID_3);
            } else {
                bindObjID = true;

                if (objID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_URI_OBJID_3);
                } else {
                    query.append(_FINDER_COLUMN_URI_OBJID_2);
                }
            }

            boolean bindObjType = false;

            if (objType == null) {
                query.append(_FINDER_COLUMN_URI_OBJTYPE_1);
            } else if (objType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_URI_OBJTYPE_3);
            } else {
                bindObjType = true;

                if (objType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_URI_OBJTYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_URI_OBJTYPE_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindObjID) {
                    if (objID != null) {
                        qPos.add(objID);
                    }
                }

                if (bindObjType) {
                    if (objType != null) {
                        qPos.add(objType);
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
     * Caches the l f tincan u r i in the entity cache if it is enabled.
     *
     * @param lfTincanURI the l f tincan u r i
     */
    @Override
    public void cacheResult(LFTincanURI lfTincanURI) {
        EntityCacheUtil.putResult(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanURIImpl.class, lfTincanURI.getPrimaryKey(), lfTincanURI);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI,
            new Object[] { lfTincanURI.getObjID(), lfTincanURI.getObjType() },
            lfTincanURI);

        lfTincanURI.resetOriginalValues();
    }

    /**
     * Caches the l f tincan u r is in the entity cache if it is enabled.
     *
     * @param lfTincanURIs the l f tincan u r is
     */
    @Override
    public void cacheResult(List<LFTincanURI> lfTincanURIs) {
        for (LFTincanURI lfTincanURI : lfTincanURIs) {
            if (EntityCacheUtil.getResult(
                        LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanURIImpl.class, lfTincanURI.getPrimaryKey()) == null) {
                cacheResult(lfTincanURI);
            } else {
                lfTincanURI.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan u r is.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanURIImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanURIImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan u r i.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanURI lfTincanURI) {
        EntityCacheUtil.removeResult(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanURIImpl.class, lfTincanURI.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanURI);
    }

    @Override
    public void clearCache(List<LFTincanURI> lfTincanURIs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanURI lfTincanURI : lfTincanURIs) {
            EntityCacheUtil.removeResult(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanURIImpl.class, lfTincanURI.getPrimaryKey());

            clearUniqueFindersCache(lfTincanURI);
        }
    }

    protected void cacheUniqueFindersCache(LFTincanURI lfTincanURI) {
        if (lfTincanURI.isNew()) {
            Object[] args = new Object[] {
                    lfTincanURI.getObjID(), lfTincanURI.getObjType()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_URI, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI, args,
                lfTincanURI);
        } else {
            LFTincanURIModelImpl lfTincanURIModelImpl = (LFTincanURIModelImpl) lfTincanURI;

            if ((lfTincanURIModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_URI.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanURI.getObjID(), lfTincanURI.getObjType()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_URI, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI, args,
                    lfTincanURI);
            }
        }
    }

    protected void clearUniqueFindersCache(LFTincanURI lfTincanURI) {
        LFTincanURIModelImpl lfTincanURIModelImpl = (LFTincanURIModelImpl) lfTincanURI;

        Object[] args = new Object[] {
                lfTincanURI.getObjID(), lfTincanURI.getObjType()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URI, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URI, args);

        if ((lfTincanURIModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_URI.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfTincanURIModelImpl.getOriginalObjID(),
                    lfTincanURIModelImpl.getOriginalObjType()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URI, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URI, args);
        }
    }

    /**
     * Creates a new l f tincan u r i with the primary key. Does not add the l f tincan u r i to the database.
     *
     * @param uri the primary key for the new l f tincan u r i
     * @return the new l f tincan u r i
     */
    @Override
    public LFTincanURI create(String uri) {
        LFTincanURI lfTincanURI = new LFTincanURIImpl();

        lfTincanURI.setNew(true);
        lfTincanURI.setPrimaryKey(uri);

        return lfTincanURI;
    }

    /**
     * Removes the l f tincan u r i with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param uri the primary key of the l f tincan u r i
     * @return the l f tincan u r i that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException if a l f tincan u r i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanURI remove(String uri)
        throws NoSuchLFTincanURIException, SystemException {
        return remove((Serializable) uri);
    }

    /**
     * Removes the l f tincan u r i with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan u r i
     * @return the l f tincan u r i that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException if a l f tincan u r i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanURI remove(Serializable primaryKey)
        throws NoSuchLFTincanURIException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanURI lfTincanURI = (LFTincanURI) session.get(LFTincanURIImpl.class,
                    primaryKey);

            if (lfTincanURI == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanURIException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanURI);
        } catch (NoSuchLFTincanURIException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanURI removeImpl(LFTincanURI lfTincanURI)
        throws SystemException {
        lfTincanURI = toUnwrappedModel(lfTincanURI);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanURI)) {
                lfTincanURI = (LFTincanURI) session.get(LFTincanURIImpl.class,
                        lfTincanURI.getPrimaryKeyObj());
            }

            if (lfTincanURI != null) {
                session.delete(lfTincanURI);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanURI != null) {
            clearCache(lfTincanURI);
        }

        return lfTincanURI;
    }

    @Override
    public LFTincanURI updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanURI lfTincanURI)
        throws SystemException {
        lfTincanURI = toUnwrappedModel(lfTincanURI);

        boolean isNew = lfTincanURI.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfTincanURI.isNew()) {
                session.save(lfTincanURI);

                lfTincanURI.setNew(false);
            } else {
                session.merge(lfTincanURI);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanURIModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanURIImpl.class, lfTincanURI.getPrimaryKey(), lfTincanURI);

        clearUniqueFindersCache(lfTincanURI);
        cacheUniqueFindersCache(lfTincanURI);

        return lfTincanURI;
    }

    protected LFTincanURI toUnwrappedModel(LFTincanURI lfTincanURI) {
        if (lfTincanURI instanceof LFTincanURIImpl) {
            return lfTincanURI;
        }

        LFTincanURIImpl lfTincanURIImpl = new LFTincanURIImpl();

        lfTincanURIImpl.setNew(lfTincanURI.isNew());
        lfTincanURIImpl.setPrimaryKey(lfTincanURI.getPrimaryKey());

        lfTincanURIImpl.setUri(lfTincanURI.getUri());
        lfTincanURIImpl.setObjID(lfTincanURI.getObjID());
        lfTincanURIImpl.setObjType(lfTincanURI.getObjType());
        lfTincanURIImpl.setContent(lfTincanURI.getContent());

        return lfTincanURIImpl;
    }

    /**
     * Returns the l f tincan u r i with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan u r i
     * @return the l f tincan u r i
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException if a l f tincan u r i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanURI findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanURIException, SystemException {
        LFTincanURI lfTincanURI = fetchByPrimaryKey(primaryKey);

        if (lfTincanURI == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanURIException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanURI;
    }

    /**
     * Returns the l f tincan u r i with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException} if it could not be found.
     *
     * @param uri the primary key of the l f tincan u r i
     * @return the l f tincan u r i
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException if a l f tincan u r i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanURI findByPrimaryKey(String uri)
        throws NoSuchLFTincanURIException, SystemException {
        return findByPrimaryKey((Serializable) uri);
    }

    /**
     * Returns the l f tincan u r i with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan u r i
     * @return the l f tincan u r i, or <code>null</code> if a l f tincan u r i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanURI fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanURI lfTincanURI = (LFTincanURI) EntityCacheUtil.getResult(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanURIImpl.class, primaryKey);

        if (lfTincanURI == _nullLFTincanURI) {
            return null;
        }

        if (lfTincanURI == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanURI = (LFTincanURI) session.get(LFTincanURIImpl.class,
                        primaryKey);

                if (lfTincanURI != null) {
                    cacheResult(lfTincanURI);
                } else {
                    EntityCacheUtil.putResult(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanURIImpl.class, primaryKey, _nullLFTincanURI);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanURIModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanURIImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanURI;
    }

    /**
     * Returns the l f tincan u r i with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param uri the primary key of the l f tincan u r i
     * @return the l f tincan u r i, or <code>null</code> if a l f tincan u r i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanURI fetchByPrimaryKey(String uri) throws SystemException {
        return fetchByPrimaryKey((Serializable) uri);
    }

    /**
     * Returns all the l f tincan u r is.
     *
     * @return the l f tincan u r is
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanURI> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan u r is.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan u r is
     * @param end the upper bound of the range of l f tincan u r is (not inclusive)
     * @return the range of l f tincan u r is
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanURI> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan u r is.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan u r is
     * @param end the upper bound of the range of l f tincan u r is (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan u r is
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanURI> findAll(int start, int end,
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

        List<LFTincanURI> list = (List<LFTincanURI>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANURI);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANURI;

                if (pagination) {
                    sql = sql.concat(LFTincanURIModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanURI>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanURI>(list);
                } else {
                    list = (List<LFTincanURI>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the l f tincan u r is from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanURI lfTincanURI : findAll()) {
            remove(lfTincanURI);
        }
    }

    /**
     * Returns the number of l f tincan u r is.
     *
     * @return the number of l f tincan u r is
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANURI);

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

    /**
     * Initializes the l f tincan u r i persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanURI")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanURI>> listenersList = new ArrayList<ModelListener<LFTincanURI>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanURI>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanURIImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
