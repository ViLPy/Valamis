package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException;
import com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateTincanStatementPersistence;

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
 * The persistence implementation for the l f certificate tincan statement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateTincanStatementPersistence
 * @see LFCertificateTincanStatementUtil
 * @generated
 */
public class LFCertificateTincanStatementPersistenceImpl
    extends BasePersistenceImpl<LFCertificateTincanStatement>
    implements LFCertificateTincanStatementPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFCertificateTincanStatementUtil} to access the l f certificate tincan statement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFCertificateTincanStatementImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
            new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCertificateID",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCertificateID",
            new String[] { Long.class.getName() },
            LFCertificateTincanStatementModelImpl.CERTIFICATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEID = new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCertificateID", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL = "lfCertificateTincanStatement.certificateID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2 = "lfCertificateTincanStatement.id.certificateID = ?";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2 =
        "lfCertificateTincanStatement.certificateID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VERB = new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVerb",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERB = new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVerb",
            new String[] { String.class.getName() },
            LFCertificateTincanStatementModelImpl.VERB_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_VERB = new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByVerb", new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_VERB_VERB_1 = "lfCertificateTincanStatement.id.verb IS NULL";
    private static final String _FINDER_COLUMN_VERB_VERB_NULL = "lfCertificateTincanStatement.verb IS NULL";
    private static final String _FINDER_COLUMN_VERB_VERB_2 = "lfCertificateTincanStatement.id.verb = ?";
    private static final String _FINDER_COLUMN_VERB_VERB_NULL_2 = "lfCertificateTincanStatement.verb IS NULL ";
    private static final String _FINDER_COLUMN_VERB_VERB_3 = "(lfCertificateTincanStatement.id.verb IS NULL OR lfCertificateTincanStatement.id.verb = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECT = new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByObject",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECT =
        new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByObject",
            new String[] { String.class.getName() },
            LFCertificateTincanStatementModelImpl.OBJECT_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_OBJECT = new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByObject", new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_OBJECT_OBJECT_1 = "lfCertificateTincanStatement.id.object IS NULL";
    private static final String _FINDER_COLUMN_OBJECT_OBJECT_NULL = "lfCertificateTincanStatement.object IS NULL";
    private static final String _FINDER_COLUMN_OBJECT_OBJECT_2 = "lfCertificateTincanStatement.id.object = ?";
    private static final String _FINDER_COLUMN_OBJECT_OBJECT_NULL_2 = "lfCertificateTincanStatement.object IS NULL ";
    private static final String _FINDER_COLUMN_OBJECT_OBJECT_3 = "(lfCertificateTincanStatement.id.object IS NULL OR lfCertificateTincanStatement.id.object = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VERBANDOBJECT =
        new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVerbAndObject",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERBANDOBJECT =
        new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVerbAndObject",
            new String[] { String.class.getName(), String.class.getName() },
            LFCertificateTincanStatementModelImpl.VERB_COLUMN_BITMASK |
            LFCertificateTincanStatementModelImpl.OBJECT_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_VERBANDOBJECT = new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByVerbAndObject",
            new String[] { String.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_VERBANDOBJECT_VERB_1 = "lfCertificateTincanStatement.id.verb IS NULL AND ";
    private static final String _FINDER_COLUMN_VERBANDOBJECT_VERB_NULL = "lfCertificateTincanStatement.verb IS NULL";
    private static final String _FINDER_COLUMN_VERBANDOBJECT_VERB_2 = "lfCertificateTincanStatement.id.verb = ? AND ";
    private static final String _FINDER_COLUMN_VERBANDOBJECT_VERB_NULL_2 = "lfCertificateTincanStatement.verb IS NULL  AND ";
    private static final String _FINDER_COLUMN_VERBANDOBJECT_VERB_3 = "(lfCertificateTincanStatement.id.verb IS NULL OR lfCertificateTincanStatement.id.verb = '') AND ";
    private static final String _FINDER_COLUMN_VERBANDOBJECT_OBJECT_1 = "lfCertificateTincanStatement.id.object IS NULL";
    private static final String _FINDER_COLUMN_VERBANDOBJECT_OBJECT_NULL = "lfCertificateTincanStatement.object IS NULL";
    private static final String _FINDER_COLUMN_VERBANDOBJECT_OBJECT_2 = "lfCertificateTincanStatement.id.object = ?";
    private static final String _FINDER_COLUMN_VERBANDOBJECT_OBJECT_NULL_2 = "lfCertificateTincanStatement.object IS NULL ";
    private static final String _FINDER_COLUMN_VERBANDOBJECT_OBJECT_3 = "(lfCertificateTincanStatement.id.object IS NULL OR lfCertificateTincanStatement.id.object = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT =
        new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByCertificateIDAndVerbAndObject",
            new String[] {
                Long.class.getName(), String.class.getName(),
                String.class.getName()
            },
            LFCertificateTincanStatementModelImpl.CERTIFICATEID_COLUMN_BITMASK |
            LFCertificateTincanStatementModelImpl.VERB_COLUMN_BITMASK |
            LFCertificateTincanStatementModelImpl.OBJECT_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEIDANDVERBANDOBJECT =
        new FinderPath(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCertificateIDAndVerbAndObject",
            new String[] {
                Long.class.getName(), String.class.getName(),
                String.class.getName()
            });
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_CERTIFICATEID_NULL =
        "lfCertificateTincanStatement.certificateID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_CERTIFICATEID_2 =
        "lfCertificateTincanStatement.id.certificateID = ? AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_CERTIFICATEID_NULL_2 =
        "lfCertificateTincanStatement.certificateID IS NULL  AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_1 =
        "lfCertificateTincanStatement.id.verb IS NULL AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_NULL =
        "lfCertificateTincanStatement.verb IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_2 =
        "lfCertificateTincanStatement.id.verb = ? AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_NULL_2 =
        "lfCertificateTincanStatement.verb IS NULL  AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_3 =
        "(lfCertificateTincanStatement.id.verb IS NULL OR lfCertificateTincanStatement.id.verb = '') AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_1 =
        "lfCertificateTincanStatement.id.object IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_NULL =
        "lfCertificateTincanStatement.object IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_2 =
        "lfCertificateTincanStatement.id.object = ?";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_NULL_2 =
        "lfCertificateTincanStatement.object IS NULL ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_3 =
        "(lfCertificateTincanStatement.id.object IS NULL OR lfCertificateTincanStatement.id.object = '')";
    private static final String _SQL_SELECT_LFCERTIFICATETINCANSTATEMENT = "SELECT lfCertificateTincanStatement FROM LFCertificateTincanStatement lfCertificateTincanStatement";
    private static final String _SQL_SELECT_LFCERTIFICATETINCANSTATEMENT_WHERE = "SELECT lfCertificateTincanStatement FROM LFCertificateTincanStatement lfCertificateTincanStatement WHERE ";
    private static final String _SQL_COUNT_LFCERTIFICATETINCANSTATEMENT = "SELECT COUNT(lfCertificateTincanStatement) FROM LFCertificateTincanStatement lfCertificateTincanStatement";
    private static final String _SQL_COUNT_LFCERTIFICATETINCANSTATEMENT_WHERE = "SELECT COUNT(lfCertificateTincanStatement) FROM LFCertificateTincanStatement lfCertificateTincanStatement WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfCertificateTincanStatement.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFCertificateTincanStatement exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFCertificateTincanStatement exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFCertificateTincanStatementPersistenceImpl.class);
    private static LFCertificateTincanStatement _nullLFCertificateTincanStatement =
        new LFCertificateTincanStatementImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFCertificateTincanStatement> toCacheModel() {
                return _nullLFCertificateTincanStatementCacheModel;
            }
        };

    private static CacheModel<LFCertificateTincanStatement> _nullLFCertificateTincanStatementCacheModel =
        new CacheModel<LFCertificateTincanStatement>() {
            @Override
            public LFCertificateTincanStatement toEntityModel() {
                return _nullLFCertificateTincanStatement;
            }
        };

    public LFCertificateTincanStatementPersistenceImpl() {
        setModelClass(LFCertificateTincanStatement.class);
    }

    /**
     * Returns all the l f certificate tincan statements where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByCertificateID(
        Long certificateID) throws SystemException {
        return findByCertificateID(certificateID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate tincan statements where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate tincan statements
     * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
     * @return the range of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByCertificateID(
        Long certificateID, int start, int end) throws SystemException {
        return findByCertificateID(certificateID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate tincan statements where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate tincan statements
     * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByCertificateID(
        Long certificateID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID;
            finderArgs = new Object[] { certificateID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEID;
            finderArgs = new Object[] {
                    certificateID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFCertificateTincanStatement> list = (List<LFCertificateTincanStatement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateTincanStatement lfCertificateTincanStatement : list) {
                if (!Validator.equals(certificateID,
                            lfCertificateTincanStatement.getCertificateID())) {
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
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_LFCERTIFICATETINCANSTATEMENT_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFCertificateTincanStatementModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
                }

                if (!pagination) {
                    list = (List<LFCertificateTincanStatement>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateTincanStatement>(list);
                } else {
                    list = (List<LFCertificateTincanStatement>) QueryUtil.list(q,
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
     * Returns the first l f certificate tincan statement in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement findByCertificateID_First(
        Long certificateID, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = fetchByCertificateID_First(certificateID,
                orderByComparator);

        if (lfCertificateTincanStatement != null) {
            return lfCertificateTincanStatement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateTincanStatementException(msg.toString());
    }

    /**
     * Returns the first l f certificate tincan statement in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByCertificateID_First(
        Long certificateID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFCertificateTincanStatement> list = findByCertificateID(certificateID,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate tincan statement in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement findByCertificateID_Last(
        Long certificateID, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = fetchByCertificateID_Last(certificateID,
                orderByComparator);

        if (lfCertificateTincanStatement != null) {
            return lfCertificateTincanStatement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateTincanStatementException(msg.toString());
    }

    /**
     * Returns the last l f certificate tincan statement in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByCertificateID_Last(
        Long certificateID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCertificateID(certificateID);

        if (count == 0) {
            return null;
        }

        List<LFCertificateTincanStatement> list = findByCertificateID(certificateID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate tincan statements before and after the current l f certificate tincan statement in the ordered set where certificateID = &#63;.
     *
     * @param lfCertificateTincanStatementPK the primary key of the current l f certificate tincan statement
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement[] findByCertificateID_PrevAndNext(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK,
        Long certificateID, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = findByPrimaryKey(lfCertificateTincanStatementPK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateTincanStatement[] array = new LFCertificateTincanStatementImpl[3];

            array[0] = getByCertificateID_PrevAndNext(session,
                    lfCertificateTincanStatement, certificateID,
                    orderByComparator, true);

            array[1] = lfCertificateTincanStatement;

            array[2] = getByCertificateID_PrevAndNext(session,
                    lfCertificateTincanStatement, certificateID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateTincanStatement getByCertificateID_PrevAndNext(
        Session session,
        LFCertificateTincanStatement lfCertificateTincanStatement,
        Long certificateID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATETINCANSTATEMENT_WHERE);

        if (certificateID == null) {
            query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
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
        } else {
            query.append(LFCertificateTincanStatementModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (certificateID != null) {
            qPos.add(certificateID.longValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateTincanStatement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateTincanStatement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate tincan statements where certificateID = &#63; from the database.
     *
     * @param certificateID the certificate i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCertificateID(Long certificateID)
        throws SystemException {
        for (LFCertificateTincanStatement lfCertificateTincanStatement : findByCertificateID(
                certificateID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateTincanStatement);
        }
    }

    /**
     * Returns the number of l f certificate tincan statements where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the number of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCertificateID(Long certificateID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATEID;

        Object[] finderArgs = new Object[] { certificateID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATETINCANSTATEMENT_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
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
     * Returns all the l f certificate tincan statements where verb = &#63;.
     *
     * @param verb the verb
     * @return the matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByVerb(String verb)
        throws SystemException {
        return findByVerb(verb, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate tincan statements where verb = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param verb the verb
     * @param start the lower bound of the range of l f certificate tincan statements
     * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
     * @return the range of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByVerb(String verb,
        int start, int end) throws SystemException {
        return findByVerb(verb, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate tincan statements where verb = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param verb the verb
     * @param start the lower bound of the range of l f certificate tincan statements
     * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByVerb(String verb,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERB;
            finderArgs = new Object[] { verb };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VERB;
            finderArgs = new Object[] { verb, start, end, orderByComparator };
        }

        List<LFCertificateTincanStatement> list = (List<LFCertificateTincanStatement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateTincanStatement lfCertificateTincanStatement : list) {
                if (!Validator.equals(verb,
                            lfCertificateTincanStatement.getVerb())) {
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
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_LFCERTIFICATETINCANSTATEMENT_WHERE);

            boolean bindVerb = false;

            if (verb == null) {
                query.append(_FINDER_COLUMN_VERB_VERB_1);
            } else if (verb.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VERB_VERB_3);
            } else {
                bindVerb = true;

                if (verb.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VERB_VERB_3);
                } else {
                    query.append(_FINDER_COLUMN_VERB_VERB_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFCertificateTincanStatementModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindVerb) {
                    if (verb != null) {
                        qPos.add(verb);
                    }
                }

                if (!pagination) {
                    list = (List<LFCertificateTincanStatement>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateTincanStatement>(list);
                } else {
                    list = (List<LFCertificateTincanStatement>) QueryUtil.list(q,
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
     * Returns the first l f certificate tincan statement in the ordered set where verb = &#63;.
     *
     * @param verb the verb
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement findByVerb_First(String verb,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = fetchByVerb_First(verb,
                orderByComparator);

        if (lfCertificateTincanStatement != null) {
            return lfCertificateTincanStatement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("verb=");
        msg.append(verb);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateTincanStatementException(msg.toString());
    }

    /**
     * Returns the first l f certificate tincan statement in the ordered set where verb = &#63;.
     *
     * @param verb the verb
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByVerb_First(String verb,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateTincanStatement> list = findByVerb(verb, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate tincan statement in the ordered set where verb = &#63;.
     *
     * @param verb the verb
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement findByVerb_Last(String verb,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = fetchByVerb_Last(verb,
                orderByComparator);

        if (lfCertificateTincanStatement != null) {
            return lfCertificateTincanStatement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("verb=");
        msg.append(verb);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateTincanStatementException(msg.toString());
    }

    /**
     * Returns the last l f certificate tincan statement in the ordered set where verb = &#63;.
     *
     * @param verb the verb
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByVerb_Last(String verb,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByVerb(verb);

        if (count == 0) {
            return null;
        }

        List<LFCertificateTincanStatement> list = findByVerb(verb, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate tincan statements before and after the current l f certificate tincan statement in the ordered set where verb = &#63;.
     *
     * @param lfCertificateTincanStatementPK the primary key of the current l f certificate tincan statement
     * @param verb the verb
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement[] findByVerb_PrevAndNext(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK,
        String verb, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = findByPrimaryKey(lfCertificateTincanStatementPK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateTincanStatement[] array = new LFCertificateTincanStatementImpl[3];

            array[0] = getByVerb_PrevAndNext(session,
                    lfCertificateTincanStatement, verb, orderByComparator, true);

            array[1] = lfCertificateTincanStatement;

            array[2] = getByVerb_PrevAndNext(session,
                    lfCertificateTincanStatement, verb, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateTincanStatement getByVerb_PrevAndNext(
        Session session,
        LFCertificateTincanStatement lfCertificateTincanStatement, String verb,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATETINCANSTATEMENT_WHERE);

        boolean bindVerb = false;

        if (verb == null) {
            query.append(_FINDER_COLUMN_VERB_VERB_1);
        } else if (verb.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_VERB_VERB_3);
        } else {
            bindVerb = true;

            if (verb.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VERB_VERB_3);
            } else {
                query.append(_FINDER_COLUMN_VERB_VERB_2);
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
        } else {
            query.append(LFCertificateTincanStatementModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindVerb) {
            if (verb != null) {
                qPos.add(verb);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateTincanStatement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateTincanStatement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate tincan statements where verb = &#63; from the database.
     *
     * @param verb the verb
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByVerb(String verb) throws SystemException {
        for (LFCertificateTincanStatement lfCertificateTincanStatement : findByVerb(
                verb, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateTincanStatement);
        }
    }

    /**
     * Returns the number of l f certificate tincan statements where verb = &#63;.
     *
     * @param verb the verb
     * @return the number of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByVerb(String verb) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_VERB;

        Object[] finderArgs = new Object[] { verb };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATETINCANSTATEMENT_WHERE);

            boolean bindVerb = false;

            if (verb == null) {
                query.append(_FINDER_COLUMN_VERB_VERB_1);
            } else if (verb.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VERB_VERB_3);
            } else {
                bindVerb = true;

                if (verb.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VERB_VERB_3);
                } else {
                    query.append(_FINDER_COLUMN_VERB_VERB_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindVerb) {
                    if (verb != null) {
                        qPos.add(verb);
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
     * Returns all the l f certificate tincan statements where object = &#63;.
     *
     * @param object the object
     * @return the matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByObject(String object)
        throws SystemException {
        return findByObject(object, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate tincan statements where object = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param object the object
     * @param start the lower bound of the range of l f certificate tincan statements
     * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
     * @return the range of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByObject(String object,
        int start, int end) throws SystemException {
        return findByObject(object, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate tincan statements where object = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param object the object
     * @param start the lower bound of the range of l f certificate tincan statements
     * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByObject(String object,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECT;
            finderArgs = new Object[] { object };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECT;
            finderArgs = new Object[] { object, start, end, orderByComparator };
        }

        List<LFCertificateTincanStatement> list = (List<LFCertificateTincanStatement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateTincanStatement lfCertificateTincanStatement : list) {
                if (!Validator.equals(object,
                            lfCertificateTincanStatement.getObject())) {
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
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_LFCERTIFICATETINCANSTATEMENT_WHERE);

            boolean bindObject = false;

            if (object == null) {
                query.append(_FINDER_COLUMN_OBJECT_OBJECT_1);
            } else if (object.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_OBJECT_OBJECT_3);
            } else {
                bindObject = true;

                if (object.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_OBJECT_OBJECT_3);
                } else {
                    query.append(_FINDER_COLUMN_OBJECT_OBJECT_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFCertificateTincanStatementModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindObject) {
                    if (object != null) {
                        qPos.add(object);
                    }
                }

                if (!pagination) {
                    list = (List<LFCertificateTincanStatement>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateTincanStatement>(list);
                } else {
                    list = (List<LFCertificateTincanStatement>) QueryUtil.list(q,
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
     * Returns the first l f certificate tincan statement in the ordered set where object = &#63;.
     *
     * @param object the object
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement findByObject_First(String object,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = fetchByObject_First(object,
                orderByComparator);

        if (lfCertificateTincanStatement != null) {
            return lfCertificateTincanStatement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("object=");
        msg.append(object);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateTincanStatementException(msg.toString());
    }

    /**
     * Returns the first l f certificate tincan statement in the ordered set where object = &#63;.
     *
     * @param object the object
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByObject_First(String object,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateTincanStatement> list = findByObject(object, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate tincan statement in the ordered set where object = &#63;.
     *
     * @param object the object
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement findByObject_Last(String object,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = fetchByObject_Last(object,
                orderByComparator);

        if (lfCertificateTincanStatement != null) {
            return lfCertificateTincanStatement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("object=");
        msg.append(object);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateTincanStatementException(msg.toString());
    }

    /**
     * Returns the last l f certificate tincan statement in the ordered set where object = &#63;.
     *
     * @param object the object
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByObject_Last(String object,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByObject(object);

        if (count == 0) {
            return null;
        }

        List<LFCertificateTincanStatement> list = findByObject(object,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate tincan statements before and after the current l f certificate tincan statement in the ordered set where object = &#63;.
     *
     * @param lfCertificateTincanStatementPK the primary key of the current l f certificate tincan statement
     * @param object the object
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement[] findByObject_PrevAndNext(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK,
        String object, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = findByPrimaryKey(lfCertificateTincanStatementPK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateTincanStatement[] array = new LFCertificateTincanStatementImpl[3];

            array[0] = getByObject_PrevAndNext(session,
                    lfCertificateTincanStatement, object, orderByComparator,
                    true);

            array[1] = lfCertificateTincanStatement;

            array[2] = getByObject_PrevAndNext(session,
                    lfCertificateTincanStatement, object, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateTincanStatement getByObject_PrevAndNext(
        Session session,
        LFCertificateTincanStatement lfCertificateTincanStatement,
        String object, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATETINCANSTATEMENT_WHERE);

        boolean bindObject = false;

        if (object == null) {
            query.append(_FINDER_COLUMN_OBJECT_OBJECT_1);
        } else if (object.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_OBJECT_OBJECT_3);
        } else {
            bindObject = true;

            if (object.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_OBJECT_OBJECT_3);
            } else {
                query.append(_FINDER_COLUMN_OBJECT_OBJECT_2);
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
        } else {
            query.append(LFCertificateTincanStatementModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindObject) {
            if (object != null) {
                qPos.add(object);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateTincanStatement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateTincanStatement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate tincan statements where object = &#63; from the database.
     *
     * @param object the object
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByObject(String object) throws SystemException {
        for (LFCertificateTincanStatement lfCertificateTincanStatement : findByObject(
                object, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateTincanStatement);
        }
    }

    /**
     * Returns the number of l f certificate tincan statements where object = &#63;.
     *
     * @param object the object
     * @return the number of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByObject(String object) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_OBJECT;

        Object[] finderArgs = new Object[] { object };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATETINCANSTATEMENT_WHERE);

            boolean bindObject = false;

            if (object == null) {
                query.append(_FINDER_COLUMN_OBJECT_OBJECT_1);
            } else if (object.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_OBJECT_OBJECT_3);
            } else {
                bindObject = true;

                if (object.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_OBJECT_OBJECT_3);
                } else {
                    query.append(_FINDER_COLUMN_OBJECT_OBJECT_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindObject) {
                    if (object != null) {
                        qPos.add(object);
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
     * Returns all the l f certificate tincan statements where verb = &#63; and object = &#63;.
     *
     * @param verb the verb
     * @param object the object
     * @return the matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByVerbAndObject(String verb,
        String object) throws SystemException {
        return findByVerbAndObject(verb, object, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate tincan statements where verb = &#63; and object = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param verb the verb
     * @param object the object
     * @param start the lower bound of the range of l f certificate tincan statements
     * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
     * @return the range of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByVerbAndObject(String verb,
        String object, int start, int end) throws SystemException {
        return findByVerbAndObject(verb, object, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate tincan statements where verb = &#63; and object = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param verb the verb
     * @param object the object
     * @param start the lower bound of the range of l f certificate tincan statements
     * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findByVerbAndObject(String verb,
        String object, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERBANDOBJECT;
            finderArgs = new Object[] { verb, object };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VERBANDOBJECT;
            finderArgs = new Object[] {
                    verb, object,
                    
                    start, end, orderByComparator
                };
        }

        List<LFCertificateTincanStatement> list = (List<LFCertificateTincanStatement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateTincanStatement lfCertificateTincanStatement : list) {
                if (!Validator.equals(verb,
                            lfCertificateTincanStatement.getVerb()) ||
                        !Validator.equals(object,
                            lfCertificateTincanStatement.getObject())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_LFCERTIFICATETINCANSTATEMENT_WHERE);

            boolean bindVerb = false;

            if (verb == null) {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_1);
            } else if (verb.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_3);
            } else {
                bindVerb = true;

                if (verb.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_3);
                } else {
                    query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_2);
                }
            }

            boolean bindObject = false;

            if (object == null) {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_1);
            } else if (object.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_3);
            } else {
                bindObject = true;

                if (object.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_3);
                } else {
                    query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFCertificateTincanStatementModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindVerb) {
                    if (verb != null) {
                        qPos.add(verb);
                    }
                }

                if (bindObject) {
                    if (object != null) {
                        qPos.add(object);
                    }
                }

                if (!pagination) {
                    list = (List<LFCertificateTincanStatement>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateTincanStatement>(list);
                } else {
                    list = (List<LFCertificateTincanStatement>) QueryUtil.list(q,
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
     * Returns the first l f certificate tincan statement in the ordered set where verb = &#63; and object = &#63;.
     *
     * @param verb the verb
     * @param object the object
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement findByVerbAndObject_First(String verb,
        String object, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = fetchByVerbAndObject_First(verb,
                object, orderByComparator);

        if (lfCertificateTincanStatement != null) {
            return lfCertificateTincanStatement;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("verb=");
        msg.append(verb);

        msg.append(", object=");
        msg.append(object);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateTincanStatementException(msg.toString());
    }

    /**
     * Returns the first l f certificate tincan statement in the ordered set where verb = &#63; and object = &#63;.
     *
     * @param verb the verb
     * @param object the object
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByVerbAndObject_First(
        String verb, String object, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFCertificateTincanStatement> list = findByVerbAndObject(verb,
                object, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate tincan statement in the ordered set where verb = &#63; and object = &#63;.
     *
     * @param verb the verb
     * @param object the object
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement findByVerbAndObject_Last(String verb,
        String object, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = fetchByVerbAndObject_Last(verb,
                object, orderByComparator);

        if (lfCertificateTincanStatement != null) {
            return lfCertificateTincanStatement;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("verb=");
        msg.append(verb);

        msg.append(", object=");
        msg.append(object);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateTincanStatementException(msg.toString());
    }

    /**
     * Returns the last l f certificate tincan statement in the ordered set where verb = &#63; and object = &#63;.
     *
     * @param verb the verb
     * @param object the object
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByVerbAndObject_Last(String verb,
        String object, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByVerbAndObject(verb, object);

        if (count == 0) {
            return null;
        }

        List<LFCertificateTincanStatement> list = findByVerbAndObject(verb,
                object, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate tincan statements before and after the current l f certificate tincan statement in the ordered set where verb = &#63; and object = &#63;.
     *
     * @param lfCertificateTincanStatementPK the primary key of the current l f certificate tincan statement
     * @param verb the verb
     * @param object the object
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement[] findByVerbAndObject_PrevAndNext(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK,
        String verb, String object, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = findByPrimaryKey(lfCertificateTincanStatementPK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateTincanStatement[] array = new LFCertificateTincanStatementImpl[3];

            array[0] = getByVerbAndObject_PrevAndNext(session,
                    lfCertificateTincanStatement, verb, object,
                    orderByComparator, true);

            array[1] = lfCertificateTincanStatement;

            array[2] = getByVerbAndObject_PrevAndNext(session,
                    lfCertificateTincanStatement, verb, object,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateTincanStatement getByVerbAndObject_PrevAndNext(
        Session session,
        LFCertificateTincanStatement lfCertificateTincanStatement, String verb,
        String object, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATETINCANSTATEMENT_WHERE);

        boolean bindVerb = false;

        if (verb == null) {
            query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_1);
        } else if (verb.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_3);
        } else {
            bindVerb = true;

            if (verb.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_3);
            } else {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_2);
            }
        }

        boolean bindObject = false;

        if (object == null) {
            query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_1);
        } else if (object.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_3);
        } else {
            bindObject = true;

            if (object.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_3);
            } else {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_2);
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
        } else {
            query.append(LFCertificateTincanStatementModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindVerb) {
            if (verb != null) {
                qPos.add(verb);
            }
        }

        if (bindObject) {
            if (object != null) {
                qPos.add(object);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateTincanStatement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateTincanStatement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate tincan statements where verb = &#63; and object = &#63; from the database.
     *
     * @param verb the verb
     * @param object the object
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByVerbAndObject(String verb, String object)
        throws SystemException {
        for (LFCertificateTincanStatement lfCertificateTincanStatement : findByVerbAndObject(
                verb, object, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateTincanStatement);
        }
    }

    /**
     * Returns the number of l f certificate tincan statements where verb = &#63; and object = &#63;.
     *
     * @param verb the verb
     * @param object the object
     * @return the number of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByVerbAndObject(String verb, String object)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_VERBANDOBJECT;

        Object[] finderArgs = new Object[] { verb, object };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFCERTIFICATETINCANSTATEMENT_WHERE);

            boolean bindVerb = false;

            if (verb == null) {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_1);
            } else if (verb.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_3);
            } else {
                bindVerb = true;

                if (verb.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_3);
                } else {
                    query.append(_FINDER_COLUMN_VERBANDOBJECT_VERB_2);
                }
            }

            boolean bindObject = false;

            if (object == null) {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_1);
            } else if (object.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_3);
            } else {
                bindObject = true;

                if (object.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_3);
                } else {
                    query.append(_FINDER_COLUMN_VERBANDOBJECT_OBJECT_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindVerb) {
                    if (verb != null) {
                        qPos.add(verb);
                    }
                }

                if (bindObject) {
                    if (object != null) {
                        qPos.add(object);
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
     * Returns the l f certificate tincan statement where certificateID = &#63; and verb = &#63; and object = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException} if it could not be found.
     *
     * @param certificateID the certificate i d
     * @param verb the verb
     * @param object the object
     * @return the matching l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement findByCertificateIDAndVerbAndObject(
        Long certificateID, String verb, String object)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = fetchByCertificateIDAndVerbAndObject(certificateID,
                verb, object);

        if (lfCertificateTincanStatement == null) {
            StringBundler msg = new StringBundler(8);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("certificateID=");
            msg.append(certificateID);

            msg.append(", verb=");
            msg.append(verb);

            msg.append(", object=");
            msg.append(object);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFCertificateTincanStatementException(msg.toString());
        }

        return lfCertificateTincanStatement;
    }

    /**
     * Returns the l f certificate tincan statement where certificateID = &#63; and verb = &#63; and object = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param certificateID the certificate i d
     * @param verb the verb
     * @param object the object
     * @return the matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByCertificateIDAndVerbAndObject(
        Long certificateID, String verb, String object)
        throws SystemException {
        return fetchByCertificateIDAndVerbAndObject(certificateID, verb,
            object, true);
    }

    /**
     * Returns the l f certificate tincan statement where certificateID = &#63; and verb = &#63; and object = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param certificateID the certificate i d
     * @param verb the verb
     * @param object the object
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f certificate tincan statement, or <code>null</code> if a matching l f certificate tincan statement could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByCertificateIDAndVerbAndObject(
        Long certificateID, String verb, String object,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { certificateID, verb, object };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT,
                    finderArgs, this);
        }

        if (result instanceof LFCertificateTincanStatement) {
            LFCertificateTincanStatement lfCertificateTincanStatement = (LFCertificateTincanStatement) result;

            if (!Validator.equals(certificateID,
                        lfCertificateTincanStatement.getCertificateID()) ||
                    !Validator.equals(verb,
                        lfCertificateTincanStatement.getVerb()) ||
                    !Validator.equals(object,
                        lfCertificateTincanStatement.getObject())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_SELECT_LFCERTIFICATETINCANSTATEMENT_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_CERTIFICATEID_2);
            }

            boolean bindVerb = false;

            if (verb == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_1);
            } else if (verb.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_3);
            } else {
                bindVerb = true;

                if (verb.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_3);
                } else {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_2);
                }
            }

            boolean bindObject = false;

            if (object == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_1);
            } else if (object.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_3);
            } else {
                bindObject = true;

                if (object.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_3);
                } else {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
                }

                if (bindVerb) {
                    if (verb != null) {
                        qPos.add(verb);
                    }
                }

                if (bindObject) {
                    if (object != null) {
                        qPos.add(object);
                    }
                }

                List<LFCertificateTincanStatement> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFCertificateTincanStatementPersistenceImpl.fetchByCertificateIDAndVerbAndObject(Long, String, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFCertificateTincanStatement lfCertificateTincanStatement = list.get(0);

                    result = lfCertificateTincanStatement;

                    cacheResult(lfCertificateTincanStatement);

                    if ((lfCertificateTincanStatement.getCertificateID() != certificateID) ||
                            (lfCertificateTincanStatement.getVerb() == null) ||
                            !lfCertificateTincanStatement.getVerb().equals(verb) ||
                            (lfCertificateTincanStatement.getObject() == null) ||
                            !lfCertificateTincanStatement.getObject()
                                                             .equals(object)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT,
                            finderArgs, lfCertificateTincanStatement);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFCertificateTincanStatement) result;
        }
    }

    /**
     * Removes the l f certificate tincan statement where certificateID = &#63; and verb = &#63; and object = &#63; from the database.
     *
     * @param certificateID the certificate i d
     * @param verb the verb
     * @param object the object
     * @return the l f certificate tincan statement that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement removeByCertificateIDAndVerbAndObject(
        Long certificateID, String verb, String object)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = findByCertificateIDAndVerbAndObject(certificateID,
                verb, object);

        return remove(lfCertificateTincanStatement);
    }

    /**
     * Returns the number of l f certificate tincan statements where certificateID = &#63; and verb = &#63; and object = &#63;.
     *
     * @param certificateID the certificate i d
     * @param verb the verb
     * @param object the object
     * @return the number of matching l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCertificateIDAndVerbAndObject(Long certificateID,
        String verb, String object) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATEIDANDVERBANDOBJECT;

        Object[] finderArgs = new Object[] { certificateID, verb, object };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_LFCERTIFICATETINCANSTATEMENT_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_CERTIFICATEID_2);
            }

            boolean bindVerb = false;

            if (verb == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_1);
            } else if (verb.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_3);
            } else {
                bindVerb = true;

                if (verb.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_3);
                } else {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_VERB_2);
                }
            }

            boolean bindObject = false;

            if (object == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_1);
            } else if (object.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_3);
            } else {
                bindObject = true;

                if (object.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_3);
                } else {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDVERBANDOBJECT_OBJECT_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
                }

                if (bindVerb) {
                    if (verb != null) {
                        qPos.add(verb);
                    }
                }

                if (bindObject) {
                    if (object != null) {
                        qPos.add(object);
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
     * Caches the l f certificate tincan statement in the entity cache if it is enabled.
     *
     * @param lfCertificateTincanStatement the l f certificate tincan statement
     */
    @Override
    public void cacheResult(
        LFCertificateTincanStatement lfCertificateTincanStatement) {
        EntityCacheUtil.putResult(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            lfCertificateTincanStatement.getPrimaryKey(),
            lfCertificateTincanStatement);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT,
            new Object[] {
                lfCertificateTincanStatement.getCertificateID(),
                lfCertificateTincanStatement.getVerb(),
                lfCertificateTincanStatement.getObject()
            }, lfCertificateTincanStatement);

        lfCertificateTincanStatement.resetOriginalValues();
    }

    /**
     * Caches the l f certificate tincan statements in the entity cache if it is enabled.
     *
     * @param lfCertificateTincanStatements the l f certificate tincan statements
     */
    @Override
    public void cacheResult(
        List<LFCertificateTincanStatement> lfCertificateTincanStatements) {
        for (LFCertificateTincanStatement lfCertificateTincanStatement : lfCertificateTincanStatements) {
            if (EntityCacheUtil.getResult(
                        LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateTincanStatementImpl.class,
                        lfCertificateTincanStatement.getPrimaryKey()) == null) {
                cacheResult(lfCertificateTincanStatement);
            } else {
                lfCertificateTincanStatement.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f certificate tincan statements.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFCertificateTincanStatementImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFCertificateTincanStatementImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f certificate tincan statement.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(
        LFCertificateTincanStatement lfCertificateTincanStatement) {
        EntityCacheUtil.removeResult(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            lfCertificateTincanStatement.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfCertificateTincanStatement);
    }

    @Override
    public void clearCache(
        List<LFCertificateTincanStatement> lfCertificateTincanStatements) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFCertificateTincanStatement lfCertificateTincanStatement : lfCertificateTincanStatements) {
            EntityCacheUtil.removeResult(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateTincanStatementImpl.class,
                lfCertificateTincanStatement.getPrimaryKey());

            clearUniqueFindersCache(lfCertificateTincanStatement);
        }
    }

    protected void cacheUniqueFindersCache(
        LFCertificateTincanStatement lfCertificateTincanStatement) {
        if (lfCertificateTincanStatement.isNew()) {
            Object[] args = new Object[] {
                    lfCertificateTincanStatement.getCertificateID(),
                    lfCertificateTincanStatement.getVerb(),
                    lfCertificateTincanStatement.getObject()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDVERBANDOBJECT,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT,
                args, lfCertificateTincanStatement);
        } else {
            LFCertificateTincanStatementModelImpl lfCertificateTincanStatementModelImpl =
                (LFCertificateTincanStatementModelImpl) lfCertificateTincanStatement;

            if ((lfCertificateTincanStatementModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateTincanStatement.getCertificateID(),
                        lfCertificateTincanStatement.getVerb(),
                        lfCertificateTincanStatement.getObject()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDVERBANDOBJECT,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT,
                    args, lfCertificateTincanStatement);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFCertificateTincanStatement lfCertificateTincanStatement) {
        LFCertificateTincanStatementModelImpl lfCertificateTincanStatementModelImpl =
            (LFCertificateTincanStatementModelImpl) lfCertificateTincanStatement;

        Object[] args = new Object[] {
                lfCertificateTincanStatement.getCertificateID(),
                lfCertificateTincanStatement.getVerb(),
                lfCertificateTincanStatement.getObject()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDVERBANDOBJECT,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT,
            args);

        if ((lfCertificateTincanStatementModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfCertificateTincanStatementModelImpl.getOriginalCertificateID(),
                    lfCertificateTincanStatementModelImpl.getOriginalVerb(),
                    lfCertificateTincanStatementModelImpl.getOriginalObject()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDVERBANDOBJECT,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDVERBANDOBJECT,
                args);
        }
    }

    /**
     * Creates a new l f certificate tincan statement with the primary key. Does not add the l f certificate tincan statement to the database.
     *
     * @param lfCertificateTincanStatementPK the primary key for the new l f certificate tincan statement
     * @return the new l f certificate tincan statement
     */
    @Override
    public LFCertificateTincanStatement create(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK) {
        LFCertificateTincanStatement lfCertificateTincanStatement = new LFCertificateTincanStatementImpl();

        lfCertificateTincanStatement.setNew(true);
        lfCertificateTincanStatement.setPrimaryKey(lfCertificateTincanStatementPK);

        return lfCertificateTincanStatement;
    }

    /**
     * Removes the l f certificate tincan statement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfCertificateTincanStatementPK the primary key of the l f certificate tincan statement
     * @return the l f certificate tincan statement that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement remove(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        return remove((Serializable) lfCertificateTincanStatementPK);
    }

    /**
     * Removes the l f certificate tincan statement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f certificate tincan statement
     * @return the l f certificate tincan statement that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement remove(Serializable primaryKey)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFCertificateTincanStatement lfCertificateTincanStatement = (LFCertificateTincanStatement) session.get(LFCertificateTincanStatementImpl.class,
                    primaryKey);

            if (lfCertificateTincanStatement == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFCertificateTincanStatementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfCertificateTincanStatement);
        } catch (NoSuchLFCertificateTincanStatementException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFCertificateTincanStatement removeImpl(
        LFCertificateTincanStatement lfCertificateTincanStatement)
        throws SystemException {
        lfCertificateTincanStatement = toUnwrappedModel(lfCertificateTincanStatement);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfCertificateTincanStatement)) {
                lfCertificateTincanStatement = (LFCertificateTincanStatement) session.get(LFCertificateTincanStatementImpl.class,
                        lfCertificateTincanStatement.getPrimaryKeyObj());
            }

            if (lfCertificateTincanStatement != null) {
                session.delete(lfCertificateTincanStatement);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfCertificateTincanStatement != null) {
            clearCache(lfCertificateTincanStatement);
        }

        return lfCertificateTincanStatement;
    }

    @Override
    public LFCertificateTincanStatement updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement lfCertificateTincanStatement)
        throws SystemException {
        lfCertificateTincanStatement = toUnwrappedModel(lfCertificateTincanStatement);

        boolean isNew = lfCertificateTincanStatement.isNew();

        LFCertificateTincanStatementModelImpl lfCertificateTincanStatementModelImpl =
            (LFCertificateTincanStatementModelImpl) lfCertificateTincanStatement;

        Session session = null;

        try {
            session = openSession();

            if (lfCertificateTincanStatement.isNew()) {
                session.save(lfCertificateTincanStatement);

                lfCertificateTincanStatement.setNew(false);
            } else {
                session.merge(lfCertificateTincanStatement);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew ||
                !LFCertificateTincanStatementModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfCertificateTincanStatementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateTincanStatementModelImpl.getOriginalCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);

                args = new Object[] {
                        lfCertificateTincanStatementModelImpl.getCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);
            }

            if ((lfCertificateTincanStatementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERB.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateTincanStatementModelImpl.getOriginalVerb()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VERB, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERB,
                    args);

                args = new Object[] {
                        lfCertificateTincanStatementModelImpl.getVerb()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VERB, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERB,
                    args);
            }

            if ((lfCertificateTincanStatementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateTincanStatementModelImpl.getOriginalObject()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECT,
                    args);

                args = new Object[] {
                        lfCertificateTincanStatementModelImpl.getObject()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECT,
                    args);
            }

            if ((lfCertificateTincanStatementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERBANDOBJECT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateTincanStatementModelImpl.getOriginalVerb(),
                        lfCertificateTincanStatementModelImpl.getOriginalObject()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VERBANDOBJECT,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERBANDOBJECT,
                    args);

                args = new Object[] {
                        lfCertificateTincanStatementModelImpl.getVerb(),
                        lfCertificateTincanStatementModelImpl.getObject()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VERBANDOBJECT,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERBANDOBJECT,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateTincanStatementImpl.class,
            lfCertificateTincanStatement.getPrimaryKey(),
            lfCertificateTincanStatement);

        clearUniqueFindersCache(lfCertificateTincanStatement);
        cacheUniqueFindersCache(lfCertificateTincanStatement);

        return lfCertificateTincanStatement;
    }

    protected LFCertificateTincanStatement toUnwrappedModel(
        LFCertificateTincanStatement lfCertificateTincanStatement) {
        if (lfCertificateTincanStatement instanceof LFCertificateTincanStatementImpl) {
            return lfCertificateTincanStatement;
        }

        LFCertificateTincanStatementImpl lfCertificateTincanStatementImpl = new LFCertificateTincanStatementImpl();

        lfCertificateTincanStatementImpl.setNew(lfCertificateTincanStatement.isNew());
        lfCertificateTincanStatementImpl.setPrimaryKey(lfCertificateTincanStatement.getPrimaryKey());

        lfCertificateTincanStatementImpl.setCertificateID(lfCertificateTincanStatement.getCertificateID());
        lfCertificateTincanStatementImpl.setVerb(lfCertificateTincanStatement.getVerb());
        lfCertificateTincanStatementImpl.setObject(lfCertificateTincanStatement.getObject());
        lfCertificateTincanStatementImpl.setPeriodType(lfCertificateTincanStatement.getPeriodType());
        lfCertificateTincanStatementImpl.setPeriod(lfCertificateTincanStatement.getPeriod());

        return lfCertificateTincanStatementImpl;
    }

    /**
     * Returns the l f certificate tincan statement with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate tincan statement
     * @return the l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement findByPrimaryKey(
        Serializable primaryKey)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = fetchByPrimaryKey(primaryKey);

        if (lfCertificateTincanStatement == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFCertificateTincanStatementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfCertificateTincanStatement;
    }

    /**
     * Returns the l f certificate tincan statement with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException} if it could not be found.
     *
     * @param lfCertificateTincanStatementPK the primary key of the l f certificate tincan statement
     * @return the l f certificate tincan statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException if a l f certificate tincan statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement findByPrimaryKey(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK)
        throws NoSuchLFCertificateTincanStatementException, SystemException {
        return findByPrimaryKey((Serializable) lfCertificateTincanStatementPK);
    }

    /**
     * Returns the l f certificate tincan statement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate tincan statement
     * @return the l f certificate tincan statement, or <code>null</code> if a l f certificate tincan statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByPrimaryKey(
        Serializable primaryKey) throws SystemException {
        LFCertificateTincanStatement lfCertificateTincanStatement = (LFCertificateTincanStatement) EntityCacheUtil.getResult(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateTincanStatementImpl.class, primaryKey);

        if (lfCertificateTincanStatement == _nullLFCertificateTincanStatement) {
            return null;
        }

        if (lfCertificateTincanStatement == null) {
            Session session = null;

            try {
                session = openSession();

                lfCertificateTincanStatement = (LFCertificateTincanStatement) session.get(LFCertificateTincanStatementImpl.class,
                        primaryKey);

                if (lfCertificateTincanStatement != null) {
                    cacheResult(lfCertificateTincanStatement);
                } else {
                    EntityCacheUtil.putResult(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateTincanStatementImpl.class, primaryKey,
                        _nullLFCertificateTincanStatement);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFCertificateTincanStatementModelImpl.ENTITY_CACHE_ENABLED,
                    LFCertificateTincanStatementImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfCertificateTincanStatement;
    }

    /**
     * Returns the l f certificate tincan statement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param lfCertificateTincanStatementPK the primary key of the l f certificate tincan statement
     * @return the l f certificate tincan statement, or <code>null</code> if a l f certificate tincan statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateTincanStatement fetchByPrimaryKey(
        LFCertificateTincanStatementPK lfCertificateTincanStatementPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) lfCertificateTincanStatementPK);
    }

    /**
     * Returns all the l f certificate tincan statements.
     *
     * @return the l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findAll()
        throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate tincan statements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate tincan statements
     * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
     * @return the range of l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate tincan statements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate tincan statements
     * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f certificate tincan statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateTincanStatement> findAll(int start, int end,
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

        List<LFCertificateTincanStatement> list = (List<LFCertificateTincanStatement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCERTIFICATETINCANSTATEMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCERTIFICATETINCANSTATEMENT;

                if (pagination) {
                    sql = sql.concat(LFCertificateTincanStatementModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFCertificateTincanStatement>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateTincanStatement>(list);
                } else {
                    list = (List<LFCertificateTincanStatement>) QueryUtil.list(q,
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
     * Removes all the l f certificate tincan statements from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFCertificateTincanStatement lfCertificateTincanStatement : findAll()) {
            remove(lfCertificateTincanStatement);
        }
    }

    /**
     * Returns the number of l f certificate tincan statements.
     *
     * @return the number of l f certificate tincan statements
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

                Query q = session.createQuery(_SQL_COUNT_LFCERTIFICATETINCANSTATEMENT);

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
     * Initializes the l f certificate tincan statement persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFCertificateTincanStatement>> listenersList = new ArrayList<ModelListener<LFCertificateTincanStatement>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFCertificateTincanStatement>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFCertificateTincanStatementImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
