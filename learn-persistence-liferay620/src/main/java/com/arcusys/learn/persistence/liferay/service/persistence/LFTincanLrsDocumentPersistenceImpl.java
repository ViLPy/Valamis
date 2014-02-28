package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsDocumentPersistence;

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
 * The persistence implementation for the l f tincan lrs document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsDocumentPersistence
 * @see LFTincanLrsDocumentUtil
 * @generated
 */
public class LFTincanLrsDocumentPersistenceImpl extends BasePersistenceImpl<LFTincanLrsDocument>
    implements LFTincanLrsDocumentPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsDocumentUtil} to access the l f tincan lrs document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsDocumentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_DOCUMENTID = new FinderPath(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByDocumentId", new String[] { String.class.getName() },
            LFTincanLrsDocumentModelImpl.DOCUMENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DOCUMENTID = new FinderPath(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentId",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_1 = "lfTincanLrsDocument.documentId IS NULL";
    private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_NULL = "lfTincanLrsDocument.documentId IS NULL";
    private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2 = "lfTincanLrsDocument.documentId = ?";
    private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_NULL_2 = "lfTincanLrsDocument.documentId IS NULL ";
    private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_3 = "(lfTincanLrsDocument.documentId IS NULL OR lfTincanLrsDocument.documentId = '')";
    private static final String _SQL_SELECT_LFTINCANLRSDOCUMENT = "SELECT lfTincanLrsDocument FROM LFTincanLrsDocument lfTincanLrsDocument";
    private static final String _SQL_SELECT_LFTINCANLRSDOCUMENT_WHERE = "SELECT lfTincanLrsDocument FROM LFTincanLrsDocument lfTincanLrsDocument WHERE ";
    private static final String _SQL_COUNT_LFTINCANLRSDOCUMENT = "SELECT COUNT(lfTincanLrsDocument) FROM LFTincanLrsDocument lfTincanLrsDocument";
    private static final String _SQL_COUNT_LFTINCANLRSDOCUMENT_WHERE = "SELECT COUNT(lfTincanLrsDocument) FROM LFTincanLrsDocument lfTincanLrsDocument WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsDocument.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsDocument exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanLrsDocument exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsDocumentPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id", "update"
            });
    private static LFTincanLrsDocument _nullLFTincanLrsDocument = new LFTincanLrsDocumentImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsDocument> toCacheModel() {
                return _nullLFTincanLrsDocumentCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsDocument> _nullLFTincanLrsDocumentCacheModel =
        new CacheModel<LFTincanLrsDocument>() {
            @Override
            public LFTincanLrsDocument toEntityModel() {
                return _nullLFTincanLrsDocument;
            }
        };

    public LFTincanLrsDocumentPersistenceImpl() {
        setModelClass(LFTincanLrsDocument.class);
    }

    /**
     * Returns the l f tincan lrs document where documentId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException} if it could not be found.
     *
     * @param documentId the document ID
     * @return the matching l f tincan lrs document
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a matching l f tincan lrs document could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument findByDocumentId(String documentId)
        throws NoSuchLFTincanLrsDocumentException, SystemException {
        LFTincanLrsDocument lfTincanLrsDocument = fetchByDocumentId(documentId);

        if (lfTincanLrsDocument == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("documentId=");
            msg.append(documentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanLrsDocumentException(msg.toString());
        }

        return lfTincanLrsDocument;
    }

    /**
     * Returns the l f tincan lrs document where documentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param documentId the document ID
     * @return the matching l f tincan lrs document, or <code>null</code> if a matching l f tincan lrs document could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument fetchByDocumentId(String documentId)
        throws SystemException {
        return fetchByDocumentId(documentId, true);
    }

    /**
     * Returns the l f tincan lrs document where documentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param documentId the document ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan lrs document, or <code>null</code> if a matching l f tincan lrs document could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument fetchByDocumentId(String documentId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { documentId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanLrsDocument) {
            LFTincanLrsDocument lfTincanLrsDocument = (LFTincanLrsDocument) result;

            if (!Validator.equals(documentId,
                        lfTincanLrsDocument.getDocumentId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTINCANLRSDOCUMENT_WHERE);

            boolean bindDocumentId = false;

            if (documentId == null) {
                query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_1);
            } else if (documentId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_3);
            } else {
                bindDocumentId = true;

                if (documentId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_3);
                } else {
                    query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindDocumentId) {
                    if (documentId != null) {
                        qPos.add(documentId);
                    }
                }

                List<LFTincanLrsDocument> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTincanLrsDocumentPersistenceImpl.fetchByDocumentId(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTincanLrsDocument lfTincanLrsDocument = list.get(0);

                    result = lfTincanLrsDocument;

                    cacheResult(lfTincanLrsDocument);

                    if ((lfTincanLrsDocument.getDocumentId() == null) ||
                            !lfTincanLrsDocument.getDocumentId()
                                                    .equals(documentId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                            finderArgs, lfTincanLrsDocument);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFTincanLrsDocument) result;
        }
    }

    /**
     * Removes the l f tincan lrs document where documentId = &#63; from the database.
     *
     * @param documentId the document ID
     * @return the l f tincan lrs document that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument removeByDocumentId(String documentId)
        throws NoSuchLFTincanLrsDocumentException, SystemException {
        LFTincanLrsDocument lfTincanLrsDocument = findByDocumentId(documentId);

        return remove(lfTincanLrsDocument);
    }

    /**
     * Returns the number of l f tincan lrs documents where documentId = &#63;.
     *
     * @param documentId the document ID
     * @return the number of matching l f tincan lrs documents
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByDocumentId(String documentId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_DOCUMENTID;

        Object[] finderArgs = new Object[] { documentId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANLRSDOCUMENT_WHERE);

            boolean bindDocumentId = false;

            if (documentId == null) {
                query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_1);
            } else if (documentId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_3);
            } else {
                bindDocumentId = true;

                if (documentId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_3);
                } else {
                    query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindDocumentId) {
                    if (documentId != null) {
                        qPos.add(documentId);
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
     * Caches the l f tincan lrs document in the entity cache if it is enabled.
     *
     * @param lfTincanLrsDocument the l f tincan lrs document
     */
    @Override
    public void cacheResult(LFTincanLrsDocument lfTincanLrsDocument) {
        EntityCacheUtil.putResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class, lfTincanLrsDocument.getPrimaryKey(),
            lfTincanLrsDocument);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
            new Object[] { lfTincanLrsDocument.getDocumentId() },
            lfTincanLrsDocument);

        lfTincanLrsDocument.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs documents in the entity cache if it is enabled.
     *
     * @param lfTincanLrsDocuments the l f tincan lrs documents
     */
    @Override
    public void cacheResult(List<LFTincanLrsDocument> lfTincanLrsDocuments) {
        for (LFTincanLrsDocument lfTincanLrsDocument : lfTincanLrsDocuments) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsDocumentImpl.class,
                        lfTincanLrsDocument.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsDocument);
            } else {
                lfTincanLrsDocument.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs documents.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsDocumentImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsDocumentImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs document.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanLrsDocument lfTincanLrsDocument) {
        EntityCacheUtil.removeResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class, lfTincanLrsDocument.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanLrsDocument);
    }

    @Override
    public void clearCache(List<LFTincanLrsDocument> lfTincanLrsDocuments) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsDocument lfTincanLrsDocument : lfTincanLrsDocuments) {
            EntityCacheUtil.removeResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsDocumentImpl.class,
                lfTincanLrsDocument.getPrimaryKey());

            clearUniqueFindersCache(lfTincanLrsDocument);
        }
    }

    protected void cacheUniqueFindersCache(
        LFTincanLrsDocument lfTincanLrsDocument) {
        if (lfTincanLrsDocument.isNew()) {
            Object[] args = new Object[] { lfTincanLrsDocument.getDocumentId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCUMENTID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID, args,
                lfTincanLrsDocument);
        } else {
            LFTincanLrsDocumentModelImpl lfTincanLrsDocumentModelImpl = (LFTincanLrsDocumentModelImpl) lfTincanLrsDocument;

            if ((lfTincanLrsDocumentModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_DOCUMENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lfTincanLrsDocument.getDocumentId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCUMENTID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                    args, lfTincanLrsDocument);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFTincanLrsDocument lfTincanLrsDocument) {
        LFTincanLrsDocumentModelImpl lfTincanLrsDocumentModelImpl = (LFTincanLrsDocumentModelImpl) lfTincanLrsDocument;

        Object[] args = new Object[] { lfTincanLrsDocument.getDocumentId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOCUMENTID, args);

        if ((lfTincanLrsDocumentModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_DOCUMENTID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfTincanLrsDocumentModelImpl.getOriginalDocumentId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOCUMENTID, args);
        }
    }

    /**
     * Creates a new l f tincan lrs document with the primary key. Does not add the l f tincan lrs document to the database.
     *
     * @param id the primary key for the new l f tincan lrs document
     * @return the new l f tincan lrs document
     */
    @Override
    public LFTincanLrsDocument create(long id) {
        LFTincanLrsDocument lfTincanLrsDocument = new LFTincanLrsDocumentImpl();

        lfTincanLrsDocument.setNew(true);
        lfTincanLrsDocument.setPrimaryKey(id);

        return lfTincanLrsDocument;
    }

    /**
     * Removes the l f tincan lrs document with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument remove(long id)
        throws NoSuchLFTincanLrsDocumentException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan lrs document with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsDocumentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsDocument lfTincanLrsDocument = (LFTincanLrsDocument) session.get(LFTincanLrsDocumentImpl.class,
                    primaryKey);

            if (lfTincanLrsDocument == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsDocument);
        } catch (NoSuchLFTincanLrsDocumentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsDocument removeImpl(
        LFTincanLrsDocument lfTincanLrsDocument) throws SystemException {
        lfTincanLrsDocument = toUnwrappedModel(lfTincanLrsDocument);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanLrsDocument)) {
                lfTincanLrsDocument = (LFTincanLrsDocument) session.get(LFTincanLrsDocumentImpl.class,
                        lfTincanLrsDocument.getPrimaryKeyObj());
            }

            if (lfTincanLrsDocument != null) {
                session.delete(lfTincanLrsDocument);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanLrsDocument != null) {
            clearCache(lfTincanLrsDocument);
        }

        return lfTincanLrsDocument;
    }

    @Override
    public LFTincanLrsDocument updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument lfTincanLrsDocument)
        throws SystemException {
        lfTincanLrsDocument = toUnwrappedModel(lfTincanLrsDocument);

        boolean isNew = lfTincanLrsDocument.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfTincanLrsDocument.isNew()) {
                session.save(lfTincanLrsDocument);

                lfTincanLrsDocument.setNew(false);
            } else {
                session.merge(lfTincanLrsDocument);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanLrsDocumentModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class, lfTincanLrsDocument.getPrimaryKey(),
            lfTincanLrsDocument);

        clearUniqueFindersCache(lfTincanLrsDocument);
        cacheUniqueFindersCache(lfTincanLrsDocument);

        return lfTincanLrsDocument;
    }

    protected LFTincanLrsDocument toUnwrappedModel(
        LFTincanLrsDocument lfTincanLrsDocument) {
        if (lfTincanLrsDocument instanceof LFTincanLrsDocumentImpl) {
            return lfTincanLrsDocument;
        }

        LFTincanLrsDocumentImpl lfTincanLrsDocumentImpl = new LFTincanLrsDocumentImpl();

        lfTincanLrsDocumentImpl.setNew(lfTincanLrsDocument.isNew());
        lfTincanLrsDocumentImpl.setPrimaryKey(lfTincanLrsDocument.getPrimaryKey());

        lfTincanLrsDocumentImpl.setId(lfTincanLrsDocument.getId());
        lfTincanLrsDocumentImpl.setDocumentId(lfTincanLrsDocument.getDocumentId());
        lfTincanLrsDocumentImpl.setUpdate(lfTincanLrsDocument.getUpdate());
        lfTincanLrsDocumentImpl.setContent(lfTincanLrsDocument.getContent());
        lfTincanLrsDocumentImpl.setContentType(lfTincanLrsDocument.getContentType());

        return lfTincanLrsDocumentImpl;
    }

    /**
     * Returns the l f tincan lrs document with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanLrsDocumentException, SystemException {
        LFTincanLrsDocument lfTincanLrsDocument = fetchByPrimaryKey(primaryKey);

        if (lfTincanLrsDocument == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanLrsDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanLrsDocument;
    }

    /**
     * Returns the l f tincan lrs document with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsDocumentException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan lrs document with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document, or <code>null</code> if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanLrsDocument lfTincanLrsDocument = (LFTincanLrsDocument) EntityCacheUtil.getResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsDocumentImpl.class, primaryKey);

        if (lfTincanLrsDocument == _nullLFTincanLrsDocument) {
            return null;
        }

        if (lfTincanLrsDocument == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanLrsDocument = (LFTincanLrsDocument) session.get(LFTincanLrsDocumentImpl.class,
                        primaryKey);

                if (lfTincanLrsDocument != null) {
                    cacheResult(lfTincanLrsDocument);
                } else {
                    EntityCacheUtil.putResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsDocumentImpl.class, primaryKey,
                        _nullLFTincanLrsDocument);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanLrsDocumentImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanLrsDocument;
    }

    /**
     * Returns the l f tincan lrs document with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document, or <code>null</code> if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan lrs documents.
     *
     * @return the l f tincan lrs documents
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsDocument> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs documents.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs documents
     * @param end the upper bound of the range of l f tincan lrs documents (not inclusive)
     * @return the range of l f tincan lrs documents
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsDocument> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs documents.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs documents
     * @param end the upper bound of the range of l f tincan lrs documents (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs documents
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsDocument> findAll(int start, int end,
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

        List<LFTincanLrsDocument> list = (List<LFTincanLrsDocument>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSDOCUMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSDOCUMENT;

                if (pagination) {
                    sql = sql.concat(LFTincanLrsDocumentModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanLrsDocument>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanLrsDocument>(list);
                } else {
                    list = (List<LFTincanLrsDocument>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs documents from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanLrsDocument lfTincanLrsDocument : findAll()) {
            remove(lfTincanLrsDocument);
        }
    }

    /**
     * Returns the number of l f tincan lrs documents.
     *
     * @return the number of l f tincan lrs documents
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSDOCUMENT);

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
     * Initializes the l f tincan lrs document persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsDocument>> listenersList = new ArrayList<ModelListener<LFTincanLrsDocument>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsDocument>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsDocumentImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
