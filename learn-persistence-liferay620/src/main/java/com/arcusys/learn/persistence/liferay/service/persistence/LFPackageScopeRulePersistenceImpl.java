package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException;
import com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule;
import com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageScopeRulePersistence;

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
 * The persistence implementation for the l f package scope rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageScopeRulePersistence
 * @see LFPackageScopeRuleUtil
 * @generated
 */
public class LFPackageScopeRulePersistenceImpl extends BasePersistenceImpl<LFPackageScopeRule>
    implements LFPackageScopeRulePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFPackageScopeRuleUtil} to access the l f package scope rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFPackageScopeRuleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPackageID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPackageID",
            new String[] { Integer.class.getName() },
            LFPackageScopeRuleModelImpl.PACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL = "lfPackageScopeRule.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "lfPackageScopeRule.packageID = ?";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2 = "lfPackageScopeRule.packageID IS NULL ";
    public static final FinderPath FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByScopeAndIsDefault",
            new String[] {
                String.class.getName(), String.class.getName(),
                Boolean.class.getName()
            },
            LFPackageScopeRuleModelImpl.SCOPE_COLUMN_BITMASK |
            LFPackageScopeRuleModelImpl.SCOPEID_COLUMN_BITMASK |
            LFPackageScopeRuleModelImpl.ISDEFAULT_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SCOPEANDISDEFAULT = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByScopeAndIsDefault",
            new String[] {
                String.class.getName(), String.class.getName(),
                Boolean.class.getName()
            });
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_1 = "lfPackageScopeRule.scope IS NULL AND ";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_NULL = "lfPackageScopeRule.scope IS NULL";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_2 = "lfPackageScopeRule.scope = ? AND ";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_NULL_2 = "lfPackageScopeRule.scope IS NULL  AND ";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_3 = "(lfPackageScopeRule.scope IS NULL OR lfPackageScopeRule.scope = '') AND ";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_1 = "lfPackageScopeRule.scopeID IS NULL AND ";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_NULL = "lfPackageScopeRule.scopeID IS NULL";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_2 = "lfPackageScopeRule.scopeID = ? AND ";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_NULL_2 = "lfPackageScopeRule.scopeID IS NULL  AND ";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_3 = "(lfPackageScopeRule.scopeID IS NULL OR lfPackageScopeRule.scopeID = '') AND ";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_ISDEFAULT_NULL = "lfPackageScopeRule.isDefault IS NULL";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_ISDEFAULT_2 = "lfPackageScopeRule.isDefault = ?";
    private static final String _FINDER_COLUMN_SCOPEANDISDEFAULT_ISDEFAULT_NULL_2 =
        "lfPackageScopeRule.isDefault IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCOPE = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByScope",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPE = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByScope",
            new String[] { String.class.getName(), String.class.getName() },
            LFPackageScopeRuleModelImpl.SCOPE_COLUMN_BITMASK |
            LFPackageScopeRuleModelImpl.SCOPEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SCOPE = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByScope",
            new String[] { String.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_SCOPE_SCOPE_1 = "lfPackageScopeRule.scope IS NULL AND ";
    private static final String _FINDER_COLUMN_SCOPE_SCOPE_NULL = "lfPackageScopeRule.scope IS NULL";
    private static final String _FINDER_COLUMN_SCOPE_SCOPE_2 = "lfPackageScopeRule.scope = ? AND ";
    private static final String _FINDER_COLUMN_SCOPE_SCOPE_NULL_2 = "lfPackageScopeRule.scope IS NULL  AND ";
    private static final String _FINDER_COLUMN_SCOPE_SCOPE_3 = "(lfPackageScopeRule.scope IS NULL OR lfPackageScopeRule.scope = '') AND ";
    private static final String _FINDER_COLUMN_SCOPE_SCOPEID_1 = "lfPackageScopeRule.scopeID IS NULL";
    private static final String _FINDER_COLUMN_SCOPE_SCOPEID_NULL = "lfPackageScopeRule.scopeID IS NULL";
    private static final String _FINDER_COLUMN_SCOPE_SCOPEID_2 = "lfPackageScopeRule.scopeID = ?";
    private static final String _FINDER_COLUMN_SCOPE_SCOPEID_NULL_2 = "lfPackageScopeRule.scopeID IS NULL ";
    private static final String _FINDER_COLUMN_SCOPE_SCOPEID_3 = "(lfPackageScopeRule.scopeID IS NULL OR lfPackageScopeRule.scopeID = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByPackageIDAndScope",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                String.class.getName()
            },
            LFPackageScopeRuleModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFPackageScopeRuleModelImpl.SCOPE_COLUMN_BITMASK |
            LFPackageScopeRuleModelImpl.SCOPEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEIDANDSCOPE = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByPackageIDAndScope",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                String.class.getName()
            });
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_PACKAGEID_NULL = "lfPackageScopeRule.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_PACKAGEID_2 = "lfPackageScopeRule.packageID = ? AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_PACKAGEID_NULL_2 =
        "lfPackageScopeRule.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_1 = "lfPackageScopeRule.scope IS NULL AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_NULL = "lfPackageScopeRule.scope IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_2 = "lfPackageScopeRule.scope = ? AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_NULL_2 = "lfPackageScopeRule.scope IS NULL  AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_3 = "(lfPackageScopeRule.scope IS NULL OR lfPackageScopeRule.scope = '') AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_1 = "lfPackageScopeRule.scopeID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_NULL = "lfPackageScopeRule.scopeID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_2 = "lfPackageScopeRule.scopeID = ?";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_NULL_2 = "lfPackageScopeRule.scopeID IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_3 = "(lfPackageScopeRule.scopeID IS NULL OR lfPackageScopeRule.scopeID = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLBYPACKAGEIDANDSCOPE =
        new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByAllByPackageIDAndScope",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLBYPACKAGEIDANDSCOPE =
        new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByAllByPackageIDAndScope",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                String.class.getName()
            },
            LFPackageScopeRuleModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFPackageScopeRuleModelImpl.SCOPE_COLUMN_BITMASK |
            LFPackageScopeRuleModelImpl.SCOPEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ALLBYPACKAGEIDANDSCOPE = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByAllByPackageIDAndScope",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                String.class.getName()
            });
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_PACKAGEID_NULL =
        "lfPackageScopeRule.packageID IS NULL";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_PACKAGEID_2 =
        "lfPackageScopeRule.packageID = ? AND ";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_PACKAGEID_NULL_2 =
        "lfPackageScopeRule.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_1 = "lfPackageScopeRule.scope IS NULL AND ";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_NULL =
        "lfPackageScopeRule.scope IS NULL";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_2 = "lfPackageScopeRule.scope = ? AND ";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_NULL_2 =
        "lfPackageScopeRule.scope IS NULL  AND ";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_3 = "(lfPackageScopeRule.scope IS NULL OR lfPackageScopeRule.scope = '') AND ";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_1 = "lfPackageScopeRule.scopeID IS NULL";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_NULL =
        "lfPackageScopeRule.scopeID IS NULL";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_2 = "lfPackageScopeRule.scopeID = ?";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_NULL_2 =
        "lfPackageScopeRule.scopeID IS NULL ";
    private static final String _FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_3 = "(lfPackageScopeRule.scopeID IS NULL OR lfPackageScopeRule.scopeID = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VISIBILITY =
        new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVisibility",
            new String[] {
                String.class.getName(), String.class.getName(),
                Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISIBILITY =
        new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVisibility",
            new String[] {
                String.class.getName(), String.class.getName(),
                Boolean.class.getName()
            },
            LFPackageScopeRuleModelImpl.SCOPE_COLUMN_BITMASK |
            LFPackageScopeRuleModelImpl.SCOPEID_COLUMN_BITMASK |
            LFPackageScopeRuleModelImpl.VISIBILITY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_VISIBILITY = new FinderPath(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVisibility",
            new String[] {
                String.class.getName(), String.class.getName(),
                Boolean.class.getName()
            });
    private static final String _FINDER_COLUMN_VISIBILITY_SCOPE_1 = "lfPackageScopeRule.scope IS NULL AND ";
    private static final String _FINDER_COLUMN_VISIBILITY_SCOPE_NULL = "lfPackageScopeRule.scope IS NULL";
    private static final String _FINDER_COLUMN_VISIBILITY_SCOPE_2 = "lfPackageScopeRule.scope = ? AND ";
    private static final String _FINDER_COLUMN_VISIBILITY_SCOPE_NULL_2 = "lfPackageScopeRule.scope IS NULL  AND ";
    private static final String _FINDER_COLUMN_VISIBILITY_SCOPE_3 = "(lfPackageScopeRule.scope IS NULL OR lfPackageScopeRule.scope = '') AND ";
    private static final String _FINDER_COLUMN_VISIBILITY_SCOPEID_1 = "lfPackageScopeRule.scopeID IS NULL AND ";
    private static final String _FINDER_COLUMN_VISIBILITY_SCOPEID_NULL = "lfPackageScopeRule.scopeID IS NULL";
    private static final String _FINDER_COLUMN_VISIBILITY_SCOPEID_2 = "lfPackageScopeRule.scopeID = ? AND ";
    private static final String _FINDER_COLUMN_VISIBILITY_SCOPEID_NULL_2 = "lfPackageScopeRule.scopeID IS NULL  AND ";
    private static final String _FINDER_COLUMN_VISIBILITY_SCOPEID_3 = "(lfPackageScopeRule.scopeID IS NULL OR lfPackageScopeRule.scopeID = '') AND ";
    private static final String _FINDER_COLUMN_VISIBILITY_VISIBILITY_NULL = "lfPackageScopeRule.visibility IS NULL";
    private static final String _FINDER_COLUMN_VISIBILITY_VISIBILITY_2 = "lfPackageScopeRule.visibility = ?";
    private static final String _FINDER_COLUMN_VISIBILITY_VISIBILITY_NULL_2 = "lfPackageScopeRule.visibility IS NULL ";
    private static final String _SQL_SELECT_LFPACKAGESCOPERULE = "SELECT lfPackageScopeRule FROM LFPackageScopeRule lfPackageScopeRule";
    private static final String _SQL_SELECT_LFPACKAGESCOPERULE_WHERE = "SELECT lfPackageScopeRule FROM LFPackageScopeRule lfPackageScopeRule WHERE ";
    private static final String _SQL_COUNT_LFPACKAGESCOPERULE = "SELECT COUNT(lfPackageScopeRule) FROM LFPackageScopeRule lfPackageScopeRule";
    private static final String _SQL_COUNT_LFPACKAGESCOPERULE_WHERE = "SELECT COUNT(lfPackageScopeRule) FROM LFPackageScopeRule lfPackageScopeRule WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfPackageScopeRule.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFPackageScopeRule exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFPackageScopeRule exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFPackageScopeRulePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFPackageScopeRule _nullLFPackageScopeRule = new LFPackageScopeRuleImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFPackageScopeRule> toCacheModel() {
                return _nullLFPackageScopeRuleCacheModel;
            }
        };

    private static CacheModel<LFPackageScopeRule> _nullLFPackageScopeRuleCacheModel =
        new CacheModel<LFPackageScopeRule>() {
            @Override
            public LFPackageScopeRule toEntityModel() {
                return _nullLFPackageScopeRule;
            }
        };

    public LFPackageScopeRulePersistenceImpl() {
        setModelClass(LFPackageScopeRule.class);
    }

    /**
     * Returns all the l f package scope rules where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByPackageID(Integer packageID)
        throws SystemException {
        return findByPackageID(packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f package scope rules where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f package scope rules
     * @param end the upper bound of the range of l f package scope rules (not inclusive)
     * @return the range of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByPackageID(Integer packageID,
        int start, int end) throws SystemException {
        return findByPackageID(packageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f package scope rules where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f package scope rules
     * @param end the upper bound of the range of l f package scope rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByPackageID(Integer packageID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID;
            finderArgs = new Object[] { packageID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID;
            finderArgs = new Object[] { packageID, start, end, orderByComparator };
        }

        List<LFPackageScopeRule> list = (List<LFPackageScopeRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFPackageScopeRule lfPackageScopeRule : list) {
                if (!Validator.equals(packageID,
                            lfPackageScopeRule.getPackageID())) {
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

            query.append(_SQL_SELECT_LFPACKAGESCOPERULE_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFPackageScopeRuleModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (!pagination) {
                    list = (List<LFPackageScopeRule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackageScopeRule>(list);
                } else {
                    list = (List<LFPackageScopeRule>) QueryUtil.list(q,
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
     * Returns the first l f package scope rule in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByPackageID_First(Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = fetchByPackageID_First(packageID,
                orderByComparator);

        if (lfPackageScopeRule != null) {
            return lfPackageScopeRule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageScopeRuleException(msg.toString());
    }

    /**
     * Returns the first l f package scope rule in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByPackageID_First(Integer packageID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFPackageScopeRule> list = findByPackageID(packageID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f package scope rule in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByPackageID_Last(Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = fetchByPackageID_Last(packageID,
                orderByComparator);

        if (lfPackageScopeRule != null) {
            return lfPackageScopeRule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageScopeRuleException(msg.toString());
    }

    /**
     * Returns the last l f package scope rule in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByPackageID_Last(Integer packageID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageID(packageID);

        if (count == 0) {
            return null;
        }

        List<LFPackageScopeRule> list = findByPackageID(packageID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f package scope rules before and after the current l f package scope rule in the ordered set where packageID = &#63;.
     *
     * @param id the primary key of the current l f package scope rule
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule[] findByPackageID_PrevAndNext(long id,
        Integer packageID, OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFPackageScopeRule[] array = new LFPackageScopeRuleImpl[3];

            array[0] = getByPackageID_PrevAndNext(session, lfPackageScopeRule,
                    packageID, orderByComparator, true);

            array[1] = lfPackageScopeRule;

            array[2] = getByPackageID_PrevAndNext(session, lfPackageScopeRule,
                    packageID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFPackageScopeRule getByPackageID_PrevAndNext(Session session,
        LFPackageScopeRule lfPackageScopeRule, Integer packageID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFPACKAGESCOPERULE_WHERE);

        if (packageID == null) {
            query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
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
            query.append(LFPackageScopeRuleModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (packageID != null) {
            qPos.add(packageID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfPackageScopeRule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFPackageScopeRule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f package scope rules where packageID = &#63; from the database.
     *
     * @param packageID the package i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPackageID(Integer packageID) throws SystemException {
        for (LFPackageScopeRule lfPackageScopeRule : findByPackageID(
                packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfPackageScopeRule);
        }
    }

    /**
     * Returns the number of l f package scope rules where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the number of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPackageID(Integer packageID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEID;

        Object[] finderArgs = new Object[] { packageID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFPACKAGESCOPERULE_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
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
     * Returns the l f package scope rule where scope = &#63; and scopeID = &#63; and isDefault = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException} if it could not be found.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param isDefault the is default
     * @return the matching l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByScopeAndIsDefault(String scope,
        String scopeID, Boolean isDefault)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = fetchByScopeAndIsDefault(scope,
                scopeID, isDefault);

        if (lfPackageScopeRule == null) {
            StringBundler msg = new StringBundler(8);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("scope=");
            msg.append(scope);

            msg.append(", scopeID=");
            msg.append(scopeID);

            msg.append(", isDefault=");
            msg.append(isDefault);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFPackageScopeRuleException(msg.toString());
        }

        return lfPackageScopeRule;
    }

    /**
     * Returns the l f package scope rule where scope = &#63; and scopeID = &#63; and isDefault = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param isDefault the is default
     * @return the matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByScopeAndIsDefault(String scope,
        String scopeID, Boolean isDefault) throws SystemException {
        return fetchByScopeAndIsDefault(scope, scopeID, isDefault, true);
    }

    /**
     * Returns the l f package scope rule where scope = &#63; and scopeID = &#63; and isDefault = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param isDefault the is default
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByScopeAndIsDefault(String scope,
        String scopeID, Boolean isDefault, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { scope, scopeID, isDefault };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT,
                    finderArgs, this);
        }

        if (result instanceof LFPackageScopeRule) {
            LFPackageScopeRule lfPackageScopeRule = (LFPackageScopeRule) result;

            if (!Validator.equals(scope, lfPackageScopeRule.getScope()) ||
                    !Validator.equals(scopeID, lfPackageScopeRule.getScopeID()) ||
                    !Validator.equals(isDefault,
                        lfPackageScopeRule.getIsDefault())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_SELECT_LFPACKAGESCOPERULE_WHERE);

            boolean bindScope = false;

            if (scope == null) {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_1);
            } else if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_3);
            } else {
                bindScope = true;

                if (scope.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_3);
                } else {
                    query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_2);
                }
            }

            boolean bindScopeID = false;

            if (scopeID == null) {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_1);
            } else if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_3);
            } else {
                bindScopeID = true;

                if (scopeID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_3);
                } else {
                    query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_2);
                }
            }

            if (isDefault == null) {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_ISDEFAULT_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_ISDEFAULT_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindScope) {
                    if (scope != null) {
                        qPos.add(scope);
                    }
                }

                if (bindScopeID) {
                    if (scopeID != null) {
                        qPos.add(scopeID);
                    }
                }

                if (isDefault != null) {
                    qPos.add(isDefault.booleanValue());
                }

                List<LFPackageScopeRule> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFPackageScopeRulePersistenceImpl.fetchByScopeAndIsDefault(String, String, Boolean, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFPackageScopeRule lfPackageScopeRule = list.get(0);

                    result = lfPackageScopeRule;

                    cacheResult(lfPackageScopeRule);

                    if ((lfPackageScopeRule.getScope() == null) ||
                            !lfPackageScopeRule.getScope().equals(scope) ||
                            (lfPackageScopeRule.getScopeID() == null) ||
                            !lfPackageScopeRule.getScopeID().equals(scopeID) ||
                            (lfPackageScopeRule.getIsDefault() != isDefault)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT,
                            finderArgs, lfPackageScopeRule);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFPackageScopeRule) result;
        }
    }

    /**
     * Removes the l f package scope rule where scope = &#63; and scopeID = &#63; and isDefault = &#63; from the database.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param isDefault the is default
     * @return the l f package scope rule that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule removeByScopeAndIsDefault(String scope,
        String scopeID, Boolean isDefault)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = findByScopeAndIsDefault(scope,
                scopeID, isDefault);

        return remove(lfPackageScopeRule);
    }

    /**
     * Returns the number of l f package scope rules where scope = &#63; and scopeID = &#63; and isDefault = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param isDefault the is default
     * @return the number of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByScopeAndIsDefault(String scope, String scopeID,
        Boolean isDefault) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SCOPEANDISDEFAULT;

        Object[] finderArgs = new Object[] { scope, scopeID, isDefault };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_LFPACKAGESCOPERULE_WHERE);

            boolean bindScope = false;

            if (scope == null) {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_1);
            } else if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_3);
            } else {
                bindScope = true;

                if (scope.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_3);
                } else {
                    query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPE_2);
                }
            }

            boolean bindScopeID = false;

            if (scopeID == null) {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_1);
            } else if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_3);
            } else {
                bindScopeID = true;

                if (scopeID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_3);
                } else {
                    query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_SCOPEID_2);
                }
            }

            if (isDefault == null) {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_ISDEFAULT_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SCOPEANDISDEFAULT_ISDEFAULT_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindScope) {
                    if (scope != null) {
                        qPos.add(scope);
                    }
                }

                if (bindScopeID) {
                    if (scopeID != null) {
                        qPos.add(scopeID);
                    }
                }

                if (isDefault != null) {
                    qPos.add(isDefault.booleanValue());
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
     * Returns all the l f package scope rules where scope = &#63; and scopeID = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @return the matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByScope(String scope, String scopeID)
        throws SystemException {
        return findByScope(scope, scopeID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f package scope rules where scope = &#63; and scopeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param start the lower bound of the range of l f package scope rules
     * @param end the upper bound of the range of l f package scope rules (not inclusive)
     * @return the range of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByScope(String scope, String scopeID,
        int start, int end) throws SystemException {
        return findByScope(scope, scopeID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f package scope rules where scope = &#63; and scopeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param start the lower bound of the range of l f package scope rules
     * @param end the upper bound of the range of l f package scope rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByScope(String scope, String scopeID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPE;
            finderArgs = new Object[] { scope, scopeID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCOPE;
            finderArgs = new Object[] {
                    scope, scopeID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFPackageScopeRule> list = (List<LFPackageScopeRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFPackageScopeRule lfPackageScopeRule : list) {
                if (!Validator.equals(scope, lfPackageScopeRule.getScope()) ||
                        !Validator.equals(scopeID,
                            lfPackageScopeRule.getScopeID())) {
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

            query.append(_SQL_SELECT_LFPACKAGESCOPERULE_WHERE);

            boolean bindScope = false;

            if (scope == null) {
                query.append(_FINDER_COLUMN_SCOPE_SCOPE_1);
            } else if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SCOPE_SCOPE_3);
            } else {
                bindScope = true;

                if (scope.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SCOPE_SCOPE_3);
                } else {
                    query.append(_FINDER_COLUMN_SCOPE_SCOPE_2);
                }
            }

            boolean bindScopeID = false;

            if (scopeID == null) {
                query.append(_FINDER_COLUMN_SCOPE_SCOPEID_1);
            } else if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SCOPE_SCOPEID_3);
            } else {
                bindScopeID = true;

                if (scopeID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SCOPE_SCOPEID_3);
                } else {
                    query.append(_FINDER_COLUMN_SCOPE_SCOPEID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFPackageScopeRuleModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindScope) {
                    if (scope != null) {
                        qPos.add(scope);
                    }
                }

                if (bindScopeID) {
                    if (scopeID != null) {
                        qPos.add(scopeID);
                    }
                }

                if (!pagination) {
                    list = (List<LFPackageScopeRule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackageScopeRule>(list);
                } else {
                    list = (List<LFPackageScopeRule>) QueryUtil.list(q,
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
     * Returns the first l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByScope_First(String scope, String scopeID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = fetchByScope_First(scope,
                scopeID, orderByComparator);

        if (lfPackageScopeRule != null) {
            return lfPackageScopeRule;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("scope=");
        msg.append(scope);

        msg.append(", scopeID=");
        msg.append(scopeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageScopeRuleException(msg.toString());
    }

    /**
     * Returns the first l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByScope_First(String scope, String scopeID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFPackageScopeRule> list = findByScope(scope, scopeID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByScope_Last(String scope, String scopeID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = fetchByScope_Last(scope,
                scopeID, orderByComparator);

        if (lfPackageScopeRule != null) {
            return lfPackageScopeRule;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("scope=");
        msg.append(scope);

        msg.append(", scopeID=");
        msg.append(scopeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageScopeRuleException(msg.toString());
    }

    /**
     * Returns the last l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByScope_Last(String scope, String scopeID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByScope(scope, scopeID);

        if (count == 0) {
            return null;
        }

        List<LFPackageScopeRule> list = findByScope(scope, scopeID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f package scope rules before and after the current l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63;.
     *
     * @param id the primary key of the current l f package scope rule
     * @param scope the scope
     * @param scopeID the scope i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule[] findByScope_PrevAndNext(long id, String scope,
        String scopeID, OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFPackageScopeRule[] array = new LFPackageScopeRuleImpl[3];

            array[0] = getByScope_PrevAndNext(session, lfPackageScopeRule,
                    scope, scopeID, orderByComparator, true);

            array[1] = lfPackageScopeRule;

            array[2] = getByScope_PrevAndNext(session, lfPackageScopeRule,
                    scope, scopeID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFPackageScopeRule getByScope_PrevAndNext(Session session,
        LFPackageScopeRule lfPackageScopeRule, String scope, String scopeID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFPACKAGESCOPERULE_WHERE);

        boolean bindScope = false;

        if (scope == null) {
            query.append(_FINDER_COLUMN_SCOPE_SCOPE_1);
        } else if (scope.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_SCOPE_SCOPE_3);
        } else {
            bindScope = true;

            if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SCOPE_SCOPE_3);
            } else {
                query.append(_FINDER_COLUMN_SCOPE_SCOPE_2);
            }
        }

        boolean bindScopeID = false;

        if (scopeID == null) {
            query.append(_FINDER_COLUMN_SCOPE_SCOPEID_1);
        } else if (scopeID.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_SCOPE_SCOPEID_3);
        } else {
            bindScopeID = true;

            if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SCOPE_SCOPEID_3);
            } else {
                query.append(_FINDER_COLUMN_SCOPE_SCOPEID_2);
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
            query.append(LFPackageScopeRuleModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindScope) {
            if (scope != null) {
                qPos.add(scope);
            }
        }

        if (bindScopeID) {
            if (scopeID != null) {
                qPos.add(scopeID);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfPackageScopeRule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFPackageScopeRule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f package scope rules where scope = &#63; and scopeID = &#63; from the database.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByScope(String scope, String scopeID)
        throws SystemException {
        for (LFPackageScopeRule lfPackageScopeRule : findByScope(scope,
                scopeID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfPackageScopeRule);
        }
    }

    /**
     * Returns the number of l f package scope rules where scope = &#63; and scopeID = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @return the number of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByScope(String scope, String scopeID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SCOPE;

        Object[] finderArgs = new Object[] { scope, scopeID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFPACKAGESCOPERULE_WHERE);

            boolean bindScope = false;

            if (scope == null) {
                query.append(_FINDER_COLUMN_SCOPE_SCOPE_1);
            } else if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SCOPE_SCOPE_3);
            } else {
                bindScope = true;

                if (scope.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SCOPE_SCOPE_3);
                } else {
                    query.append(_FINDER_COLUMN_SCOPE_SCOPE_2);
                }
            }

            boolean bindScopeID = false;

            if (scopeID == null) {
                query.append(_FINDER_COLUMN_SCOPE_SCOPEID_1);
            } else if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SCOPE_SCOPEID_3);
            } else {
                bindScopeID = true;

                if (scopeID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SCOPE_SCOPEID_3);
                } else {
                    query.append(_FINDER_COLUMN_SCOPE_SCOPEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindScope) {
                    if (scope != null) {
                        qPos.add(scope);
                    }
                }

                if (bindScopeID) {
                    if (scopeID != null) {
                        qPos.add(scopeID);
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
     * Returns the l f package scope rule where packageID = &#63; and scope = &#63; and scopeID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException} if it could not be found.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @return the matching l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByPackageIDAndScope(Integer packageID,
        String scope, String scopeID)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = fetchByPackageIDAndScope(packageID,
                scope, scopeID);

        if (lfPackageScopeRule == null) {
            StringBundler msg = new StringBundler(8);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("packageID=");
            msg.append(packageID);

            msg.append(", scope=");
            msg.append(scope);

            msg.append(", scopeID=");
            msg.append(scopeID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFPackageScopeRuleException(msg.toString());
        }

        return lfPackageScopeRule;
    }

    /**
     * Returns the l f package scope rule where packageID = &#63; and scope = &#63; and scopeID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @return the matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByPackageIDAndScope(Integer packageID,
        String scope, String scopeID) throws SystemException {
        return fetchByPackageIDAndScope(packageID, scope, scopeID, true);
    }

    /**
     * Returns the l f package scope rule where packageID = &#63; and scope = &#63; and scopeID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByPackageIDAndScope(Integer packageID,
        String scope, String scopeID, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { packageID, scope, scopeID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE,
                    finderArgs, this);
        }

        if (result instanceof LFPackageScopeRule) {
            LFPackageScopeRule lfPackageScopeRule = (LFPackageScopeRule) result;

            if (!Validator.equals(packageID, lfPackageScopeRule.getPackageID()) ||
                    !Validator.equals(scope, lfPackageScopeRule.getScope()) ||
                    !Validator.equals(scopeID, lfPackageScopeRule.getScopeID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_SELECT_LFPACKAGESCOPERULE_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_PACKAGEID_2);
            }

            boolean bindScope = false;

            if (scope == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_1);
            } else if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_3);
            } else {
                bindScope = true;

                if (scope.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_2);
                }
            }

            boolean bindScopeID = false;

            if (scopeID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_1);
            } else if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_3);
            } else {
                bindScopeID = true;

                if (scopeID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindScope) {
                    if (scope != null) {
                        qPos.add(scope);
                    }
                }

                if (bindScopeID) {
                    if (scopeID != null) {
                        qPos.add(scopeID);
                    }
                }

                List<LFPackageScopeRule> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFPackageScopeRulePersistenceImpl.fetchByPackageIDAndScope(Integer, String, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFPackageScopeRule lfPackageScopeRule = list.get(0);

                    result = lfPackageScopeRule;

                    cacheResult(lfPackageScopeRule);

                    if ((lfPackageScopeRule.getPackageID() != packageID) ||
                            (lfPackageScopeRule.getScope() == null) ||
                            !lfPackageScopeRule.getScope().equals(scope) ||
                            (lfPackageScopeRule.getScopeID() == null) ||
                            !lfPackageScopeRule.getScopeID().equals(scopeID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE,
                            finderArgs, lfPackageScopeRule);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFPackageScopeRule) result;
        }
    }

    /**
     * Removes the l f package scope rule where packageID = &#63; and scope = &#63; and scopeID = &#63; from the database.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @return the l f package scope rule that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule removeByPackageIDAndScope(Integer packageID,
        String scope, String scopeID)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = findByPackageIDAndScope(packageID,
                scope, scopeID);

        return remove(lfPackageScopeRule);
    }

    /**
     * Returns the number of l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63;.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @return the number of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPackageIDAndScope(Integer packageID, String scope,
        String scopeID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEIDANDSCOPE;

        Object[] finderArgs = new Object[] { packageID, scope, scopeID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_LFPACKAGESCOPERULE_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_PACKAGEID_2);
            }

            boolean bindScope = false;

            if (scope == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_1);
            } else if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_3);
            } else {
                bindScope = true;

                if (scope.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPE_2);
                }
            }

            boolean bindScopeID = false;

            if (scopeID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_1);
            } else if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_3);
            } else {
                bindScopeID = true;

                if (scopeID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDSCOPE_SCOPEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindScope) {
                    if (scope != null) {
                        qPos.add(scope);
                    }
                }

                if (bindScopeID) {
                    if (scopeID != null) {
                        qPos.add(scopeID);
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
     * Returns all the l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63;.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @return the matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByAllByPackageIDAndScope(
        Integer packageID, String scope, String scopeID)
        throws SystemException {
        return findByAllByPackageIDAndScope(packageID, scope, scopeID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @param start the lower bound of the range of l f package scope rules
     * @param end the upper bound of the range of l f package scope rules (not inclusive)
     * @return the range of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByAllByPackageIDAndScope(
        Integer packageID, String scope, String scopeID, int start, int end)
        throws SystemException {
        return findByAllByPackageIDAndScope(packageID, scope, scopeID, start,
            end, null);
    }

    /**
     * Returns an ordered range of all the l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @param start the lower bound of the range of l f package scope rules
     * @param end the upper bound of the range of l f package scope rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByAllByPackageIDAndScope(
        Integer packageID, String scope, String scopeID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLBYPACKAGEIDANDSCOPE;
            finderArgs = new Object[] { packageID, scope, scopeID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLBYPACKAGEIDANDSCOPE;
            finderArgs = new Object[] {
                    packageID, scope, scopeID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFPackageScopeRule> list = (List<LFPackageScopeRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFPackageScopeRule lfPackageScopeRule : list) {
                if (!Validator.equals(packageID,
                            lfPackageScopeRule.getPackageID()) ||
                        !Validator.equals(scope, lfPackageScopeRule.getScope()) ||
                        !Validator.equals(scopeID,
                            lfPackageScopeRule.getScopeID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_LFPACKAGESCOPERULE_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_PACKAGEID_2);
            }

            boolean bindScope = false;

            if (scope == null) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_1);
            } else if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_3);
            } else {
                bindScope = true;

                if (scope.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_3);
                } else {
                    query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_2);
                }
            }

            boolean bindScopeID = false;

            if (scopeID == null) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_1);
            } else if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_3);
            } else {
                bindScopeID = true;

                if (scopeID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_3);
                } else {
                    query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFPackageScopeRuleModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindScope) {
                    if (scope != null) {
                        qPos.add(scope);
                    }
                }

                if (bindScopeID) {
                    if (scopeID != null) {
                        qPos.add(scopeID);
                    }
                }

                if (!pagination) {
                    list = (List<LFPackageScopeRule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackageScopeRule>(list);
                } else {
                    list = (List<LFPackageScopeRule>) QueryUtil.list(q,
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
     * Returns the first l f package scope rule in the ordered set where packageID = &#63; and scope = &#63; and scopeID = &#63;.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByAllByPackageIDAndScope_First(
        Integer packageID, String scope, String scopeID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = fetchByAllByPackageIDAndScope_First(packageID,
                scope, scopeID, orderByComparator);

        if (lfPackageScopeRule != null) {
            return lfPackageScopeRule;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", scope=");
        msg.append(scope);

        msg.append(", scopeID=");
        msg.append(scopeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageScopeRuleException(msg.toString());
    }

    /**
     * Returns the first l f package scope rule in the ordered set where packageID = &#63; and scope = &#63; and scopeID = &#63;.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByAllByPackageIDAndScope_First(
        Integer packageID, String scope, String scopeID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFPackageScopeRule> list = findByAllByPackageIDAndScope(packageID,
                scope, scopeID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f package scope rule in the ordered set where packageID = &#63; and scope = &#63; and scopeID = &#63;.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByAllByPackageIDAndScope_Last(
        Integer packageID, String scope, String scopeID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = fetchByAllByPackageIDAndScope_Last(packageID,
                scope, scopeID, orderByComparator);

        if (lfPackageScopeRule != null) {
            return lfPackageScopeRule;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", scope=");
        msg.append(scope);

        msg.append(", scopeID=");
        msg.append(scopeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageScopeRuleException(msg.toString());
    }

    /**
     * Returns the last l f package scope rule in the ordered set where packageID = &#63; and scope = &#63; and scopeID = &#63;.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByAllByPackageIDAndScope_Last(
        Integer packageID, String scope, String scopeID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAllByPackageIDAndScope(packageID, scope, scopeID);

        if (count == 0) {
            return null;
        }

        List<LFPackageScopeRule> list = findByAllByPackageIDAndScope(packageID,
                scope, scopeID, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f package scope rules before and after the current l f package scope rule in the ordered set where packageID = &#63; and scope = &#63; and scopeID = &#63;.
     *
     * @param id the primary key of the current l f package scope rule
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule[] findByAllByPackageIDAndScope_PrevAndNext(
        long id, Integer packageID, String scope, String scopeID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFPackageScopeRule[] array = new LFPackageScopeRuleImpl[3];

            array[0] = getByAllByPackageIDAndScope_PrevAndNext(session,
                    lfPackageScopeRule, packageID, scope, scopeID,
                    orderByComparator, true);

            array[1] = lfPackageScopeRule;

            array[2] = getByAllByPackageIDAndScope_PrevAndNext(session,
                    lfPackageScopeRule, packageID, scope, scopeID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFPackageScopeRule getByAllByPackageIDAndScope_PrevAndNext(
        Session session, LFPackageScopeRule lfPackageScopeRule,
        Integer packageID, String scope, String scopeID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFPACKAGESCOPERULE_WHERE);

        if (packageID == null) {
            query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_PACKAGEID_2);
        }

        boolean bindScope = false;

        if (scope == null) {
            query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_1);
        } else if (scope.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_3);
        } else {
            bindScope = true;

            if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_3);
            } else {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_2);
            }
        }

        boolean bindScopeID = false;

        if (scopeID == null) {
            query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_1);
        } else if (scopeID.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_3);
        } else {
            bindScopeID = true;

            if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_3);
            } else {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_2);
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
            query.append(LFPackageScopeRuleModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (packageID != null) {
            qPos.add(packageID.intValue());
        }

        if (bindScope) {
            if (scope != null) {
                qPos.add(scope);
            }
        }

        if (bindScopeID) {
            if (scopeID != null) {
                qPos.add(scopeID);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfPackageScopeRule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFPackageScopeRule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63; from the database.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAllByPackageIDAndScope(Integer packageID, String scope,
        String scopeID) throws SystemException {
        for (LFPackageScopeRule lfPackageScopeRule : findByAllByPackageIDAndScope(
                packageID, scope, scopeID, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(lfPackageScopeRule);
        }
    }

    /**
     * Returns the number of l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63;.
     *
     * @param packageID the package i d
     * @param scope the scope
     * @param scopeID the scope i d
     * @return the number of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAllByPackageIDAndScope(Integer packageID, String scope,
        String scopeID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLBYPACKAGEIDANDSCOPE;

        Object[] finderArgs = new Object[] { packageID, scope, scopeID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_LFPACKAGESCOPERULE_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_PACKAGEID_2);
            }

            boolean bindScope = false;

            if (scope == null) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_1);
            } else if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_3);
            } else {
                bindScope = true;

                if (scope.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_3);
                } else {
                    query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPE_2);
                }
            }

            boolean bindScopeID = false;

            if (scopeID == null) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_1);
            } else if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_3);
            } else {
                bindScopeID = true;

                if (scopeID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_3);
                } else {
                    query.append(_FINDER_COLUMN_ALLBYPACKAGEIDANDSCOPE_SCOPEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindScope) {
                    if (scope != null) {
                        qPos.add(scope);
                    }
                }

                if (bindScopeID) {
                    if (scopeID != null) {
                        qPos.add(scopeID);
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
     * Returns all the l f package scope rules where scope = &#63; and scopeID = &#63; and visibility = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param visibility the visibility
     * @return the matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByVisibility(String scope,
        String scopeID, Boolean visibility) throws SystemException {
        return findByVisibility(scope, scopeID, visibility, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f package scope rules where scope = &#63; and scopeID = &#63; and visibility = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param visibility the visibility
     * @param start the lower bound of the range of l f package scope rules
     * @param end the upper bound of the range of l f package scope rules (not inclusive)
     * @return the range of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByVisibility(String scope,
        String scopeID, Boolean visibility, int start, int end)
        throws SystemException {
        return findByVisibility(scope, scopeID, visibility, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f package scope rules where scope = &#63; and scopeID = &#63; and visibility = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param visibility the visibility
     * @param start the lower bound of the range of l f package scope rules
     * @param end the upper bound of the range of l f package scope rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findByVisibility(String scope,
        String scopeID, Boolean visibility, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISIBILITY;
            finderArgs = new Object[] { scope, scopeID, visibility };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VISIBILITY;
            finderArgs = new Object[] {
                    scope, scopeID, visibility,
                    
                    start, end, orderByComparator
                };
        }

        List<LFPackageScopeRule> list = (List<LFPackageScopeRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFPackageScopeRule lfPackageScopeRule : list) {
                if (!Validator.equals(scope, lfPackageScopeRule.getScope()) ||
                        !Validator.equals(scopeID,
                            lfPackageScopeRule.getScopeID()) ||
                        !Validator.equals(visibility,
                            lfPackageScopeRule.getVisibility())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_LFPACKAGESCOPERULE_WHERE);

            boolean bindScope = false;

            if (scope == null) {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_1);
            } else if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_3);
            } else {
                bindScope = true;

                if (scope.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_3);
                } else {
                    query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_2);
                }
            }

            boolean bindScopeID = false;

            if (scopeID == null) {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_1);
            } else if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_3);
            } else {
                bindScopeID = true;

                if (scopeID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_3);
                } else {
                    query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_2);
                }
            }

            if (visibility == null) {
                query.append(_FINDER_COLUMN_VISIBILITY_VISIBILITY_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_VISIBILITY_VISIBILITY_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFPackageScopeRuleModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindScope) {
                    if (scope != null) {
                        qPos.add(scope);
                    }
                }

                if (bindScopeID) {
                    if (scopeID != null) {
                        qPos.add(scopeID);
                    }
                }

                if (visibility != null) {
                    qPos.add(visibility.booleanValue());
                }

                if (!pagination) {
                    list = (List<LFPackageScopeRule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackageScopeRule>(list);
                } else {
                    list = (List<LFPackageScopeRule>) QueryUtil.list(q,
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
     * Returns the first l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63; and visibility = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param visibility the visibility
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByVisibility_First(String scope,
        String scopeID, Boolean visibility, OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = fetchByVisibility_First(scope,
                scopeID, visibility, orderByComparator);

        if (lfPackageScopeRule != null) {
            return lfPackageScopeRule;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("scope=");
        msg.append(scope);

        msg.append(", scopeID=");
        msg.append(scopeID);

        msg.append(", visibility=");
        msg.append(visibility);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageScopeRuleException(msg.toString());
    }

    /**
     * Returns the first l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63; and visibility = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param visibility the visibility
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByVisibility_First(String scope,
        String scopeID, Boolean visibility, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFPackageScopeRule> list = findByVisibility(scope, scopeID,
                visibility, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63; and visibility = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param visibility the visibility
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByVisibility_Last(String scope,
        String scopeID, Boolean visibility, OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = fetchByVisibility_Last(scope,
                scopeID, visibility, orderByComparator);

        if (lfPackageScopeRule != null) {
            return lfPackageScopeRule;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("scope=");
        msg.append(scope);

        msg.append(", scopeID=");
        msg.append(scopeID);

        msg.append(", visibility=");
        msg.append(visibility);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageScopeRuleException(msg.toString());
    }

    /**
     * Returns the last l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63; and visibility = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param visibility the visibility
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByVisibility_Last(String scope,
        String scopeID, Boolean visibility, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByVisibility(scope, scopeID, visibility);

        if (count == 0) {
            return null;
        }

        List<LFPackageScopeRule> list = findByVisibility(scope, scopeID,
                visibility, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f package scope rules before and after the current l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63; and visibility = &#63;.
     *
     * @param id the primary key of the current l f package scope rule
     * @param scope the scope
     * @param scopeID the scope i d
     * @param visibility the visibility
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule[] findByVisibility_PrevAndNext(long id,
        String scope, String scopeID, Boolean visibility,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFPackageScopeRule[] array = new LFPackageScopeRuleImpl[3];

            array[0] = getByVisibility_PrevAndNext(session, lfPackageScopeRule,
                    scope, scopeID, visibility, orderByComparator, true);

            array[1] = lfPackageScopeRule;

            array[2] = getByVisibility_PrevAndNext(session, lfPackageScopeRule,
                    scope, scopeID, visibility, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFPackageScopeRule getByVisibility_PrevAndNext(Session session,
        LFPackageScopeRule lfPackageScopeRule, String scope, String scopeID,
        Boolean visibility, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFPACKAGESCOPERULE_WHERE);

        boolean bindScope = false;

        if (scope == null) {
            query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_1);
        } else if (scope.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_3);
        } else {
            bindScope = true;

            if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_3);
            } else {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_2);
            }
        }

        boolean bindScopeID = false;

        if (scopeID == null) {
            query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_1);
        } else if (scopeID.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_3);
        } else {
            bindScopeID = true;

            if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_3);
            } else {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_2);
            }
        }

        if (visibility == null) {
            query.append(_FINDER_COLUMN_VISIBILITY_VISIBILITY_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_VISIBILITY_VISIBILITY_2);
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
            query.append(LFPackageScopeRuleModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindScope) {
            if (scope != null) {
                qPos.add(scope);
            }
        }

        if (bindScopeID) {
            if (scopeID != null) {
                qPos.add(scopeID);
            }
        }

        if (visibility != null) {
            qPos.add(visibility.booleanValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfPackageScopeRule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFPackageScopeRule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f package scope rules where scope = &#63; and scopeID = &#63; and visibility = &#63; from the database.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param visibility the visibility
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByVisibility(String scope, String scopeID,
        Boolean visibility) throws SystemException {
        for (LFPackageScopeRule lfPackageScopeRule : findByVisibility(scope,
                scopeID, visibility, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfPackageScopeRule);
        }
    }

    /**
     * Returns the number of l f package scope rules where scope = &#63; and scopeID = &#63; and visibility = &#63;.
     *
     * @param scope the scope
     * @param scopeID the scope i d
     * @param visibility the visibility
     * @return the number of matching l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByVisibility(String scope, String scopeID,
        Boolean visibility) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_VISIBILITY;

        Object[] finderArgs = new Object[] { scope, scopeID, visibility };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_LFPACKAGESCOPERULE_WHERE);

            boolean bindScope = false;

            if (scope == null) {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_1);
            } else if (scope.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_3);
            } else {
                bindScope = true;

                if (scope.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_3);
                } else {
                    query.append(_FINDER_COLUMN_VISIBILITY_SCOPE_2);
                }
            }

            boolean bindScopeID = false;

            if (scopeID == null) {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_1);
            } else if (scopeID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_3);
            } else {
                bindScopeID = true;

                if (scopeID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_3);
                } else {
                    query.append(_FINDER_COLUMN_VISIBILITY_SCOPEID_2);
                }
            }

            if (visibility == null) {
                query.append(_FINDER_COLUMN_VISIBILITY_VISIBILITY_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_VISIBILITY_VISIBILITY_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindScope) {
                    if (scope != null) {
                        qPos.add(scope);
                    }
                }

                if (bindScopeID) {
                    if (scopeID != null) {
                        qPos.add(scopeID);
                    }
                }

                if (visibility != null) {
                    qPos.add(visibility.booleanValue());
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
     * Caches the l f package scope rule in the entity cache if it is enabled.
     *
     * @param lfPackageScopeRule the l f package scope rule
     */
    @Override
    public void cacheResult(LFPackageScopeRule lfPackageScopeRule) {
        EntityCacheUtil.putResult(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class, lfPackageScopeRule.getPrimaryKey(),
            lfPackageScopeRule);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT,
            new Object[] {
                lfPackageScopeRule.getScope(), lfPackageScopeRule.getScopeID(),
                lfPackageScopeRule.getIsDefault()
            }, lfPackageScopeRule);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE,
            new Object[] {
                lfPackageScopeRule.getPackageID(), lfPackageScopeRule.getScope(),
                lfPackageScopeRule.getScopeID()
            }, lfPackageScopeRule);

        lfPackageScopeRule.resetOriginalValues();
    }

    /**
     * Caches the l f package scope rules in the entity cache if it is enabled.
     *
     * @param lfPackageScopeRules the l f package scope rules
     */
    @Override
    public void cacheResult(List<LFPackageScopeRule> lfPackageScopeRules) {
        for (LFPackageScopeRule lfPackageScopeRule : lfPackageScopeRules) {
            if (EntityCacheUtil.getResult(
                        LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
                        LFPackageScopeRuleImpl.class,
                        lfPackageScopeRule.getPrimaryKey()) == null) {
                cacheResult(lfPackageScopeRule);
            } else {
                lfPackageScopeRule.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f package scope rules.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFPackageScopeRuleImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFPackageScopeRuleImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f package scope rule.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFPackageScopeRule lfPackageScopeRule) {
        EntityCacheUtil.removeResult(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class, lfPackageScopeRule.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfPackageScopeRule);
    }

    @Override
    public void clearCache(List<LFPackageScopeRule> lfPackageScopeRules) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFPackageScopeRule lfPackageScopeRule : lfPackageScopeRules) {
            EntityCacheUtil.removeResult(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
                LFPackageScopeRuleImpl.class, lfPackageScopeRule.getPrimaryKey());

            clearUniqueFindersCache(lfPackageScopeRule);
        }
    }

    protected void cacheUniqueFindersCache(
        LFPackageScopeRule lfPackageScopeRule) {
        if (lfPackageScopeRule.isNew()) {
            Object[] args = new Object[] {
                    lfPackageScopeRule.getScope(),
                    lfPackageScopeRule.getScopeID(),
                    lfPackageScopeRule.getIsDefault()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SCOPEANDISDEFAULT,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT,
                args, lfPackageScopeRule);

            args = new Object[] {
                    lfPackageScopeRule.getPackageID(),
                    lfPackageScopeRule.getScope(),
                    lfPackageScopeRule.getScopeID()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDSCOPE,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE,
                args, lfPackageScopeRule);
        } else {
            LFPackageScopeRuleModelImpl lfPackageScopeRuleModelImpl = (LFPackageScopeRuleModelImpl) lfPackageScopeRule;

            if ((lfPackageScopeRuleModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPackageScopeRule.getScope(),
                        lfPackageScopeRule.getScopeID(),
                        lfPackageScopeRule.getIsDefault()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SCOPEANDISDEFAULT,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT,
                    args, lfPackageScopeRule);
            }

            if ((lfPackageScopeRuleModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPackageScopeRule.getPackageID(),
                        lfPackageScopeRule.getScope(),
                        lfPackageScopeRule.getScopeID()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDSCOPE,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE,
                    args, lfPackageScopeRule);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFPackageScopeRule lfPackageScopeRule) {
        LFPackageScopeRuleModelImpl lfPackageScopeRuleModelImpl = (LFPackageScopeRuleModelImpl) lfPackageScopeRule;

        Object[] args = new Object[] {
                lfPackageScopeRule.getScope(), lfPackageScopeRule.getScopeID(),
                lfPackageScopeRule.getIsDefault()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCOPEANDISDEFAULT,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT,
            args);

        if ((lfPackageScopeRuleModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfPackageScopeRuleModelImpl.getOriginalScope(),
                    lfPackageScopeRuleModelImpl.getOriginalScopeID(),
                    lfPackageScopeRuleModelImpl.getOriginalIsDefault()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCOPEANDISDEFAULT,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SCOPEANDISDEFAULT,
                args);
        }

        args = new Object[] {
                lfPackageScopeRule.getPackageID(), lfPackageScopeRule.getScope(),
                lfPackageScopeRule.getScopeID()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDSCOPE,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE,
            args);

        if ((lfPackageScopeRuleModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfPackageScopeRuleModelImpl.getOriginalPackageID(),
                    lfPackageScopeRuleModelImpl.getOriginalScope(),
                    lfPackageScopeRuleModelImpl.getOriginalScopeID()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDSCOPE,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEIDANDSCOPE,
                args);
        }
    }

    /**
     * Creates a new l f package scope rule with the primary key. Does not add the l f package scope rule to the database.
     *
     * @param id the primary key for the new l f package scope rule
     * @return the new l f package scope rule
     */
    @Override
    public LFPackageScopeRule create(long id) {
        LFPackageScopeRule lfPackageScopeRule = new LFPackageScopeRuleImpl();

        lfPackageScopeRule.setNew(true);
        lfPackageScopeRule.setPrimaryKey(id);

        return lfPackageScopeRule;
    }

    /**
     * Removes the l f package scope rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f package scope rule
     * @return the l f package scope rule that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule remove(long id)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f package scope rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f package scope rule
     * @return the l f package scope rule that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule remove(Serializable primaryKey)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFPackageScopeRule lfPackageScopeRule = (LFPackageScopeRule) session.get(LFPackageScopeRuleImpl.class,
                    primaryKey);

            if (lfPackageScopeRule == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFPackageScopeRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfPackageScopeRule);
        } catch (NoSuchLFPackageScopeRuleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFPackageScopeRule removeImpl(
        LFPackageScopeRule lfPackageScopeRule) throws SystemException {
        lfPackageScopeRule = toUnwrappedModel(lfPackageScopeRule);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfPackageScopeRule)) {
                lfPackageScopeRule = (LFPackageScopeRule) session.get(LFPackageScopeRuleImpl.class,
                        lfPackageScopeRule.getPrimaryKeyObj());
            }

            if (lfPackageScopeRule != null) {
                session.delete(lfPackageScopeRule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfPackageScopeRule != null) {
            clearCache(lfPackageScopeRule);
        }

        return lfPackageScopeRule;
    }

    @Override
    public LFPackageScopeRule updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule lfPackageScopeRule)
        throws SystemException {
        lfPackageScopeRule = toUnwrappedModel(lfPackageScopeRule);

        boolean isNew = lfPackageScopeRule.isNew();

        LFPackageScopeRuleModelImpl lfPackageScopeRuleModelImpl = (LFPackageScopeRuleModelImpl) lfPackageScopeRule;

        Session session = null;

        try {
            session = openSession();

            if (lfPackageScopeRule.isNew()) {
                session.save(lfPackageScopeRule);

                lfPackageScopeRule.setNew(false);
            } else {
                session.merge(lfPackageScopeRule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFPackageScopeRuleModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfPackageScopeRuleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPackageScopeRuleModelImpl.getOriginalPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);

                args = new Object[] { lfPackageScopeRuleModelImpl.getPackageID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);
            }

            if ((lfPackageScopeRuleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPackageScopeRuleModelImpl.getOriginalScope(),
                        lfPackageScopeRuleModelImpl.getOriginalScopeID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCOPE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPE,
                    args);

                args = new Object[] {
                        lfPackageScopeRuleModelImpl.getScope(),
                        lfPackageScopeRuleModelImpl.getScopeID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCOPE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPE,
                    args);
            }

            if ((lfPackageScopeRuleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLBYPACKAGEIDANDSCOPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPackageScopeRuleModelImpl.getOriginalPackageID(),
                        lfPackageScopeRuleModelImpl.getOriginalScope(),
                        lfPackageScopeRuleModelImpl.getOriginalScopeID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLBYPACKAGEIDANDSCOPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLBYPACKAGEIDANDSCOPE,
                    args);

                args = new Object[] {
                        lfPackageScopeRuleModelImpl.getPackageID(),
                        lfPackageScopeRuleModelImpl.getScope(),
                        lfPackageScopeRuleModelImpl.getScopeID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLBYPACKAGEIDANDSCOPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLBYPACKAGEIDANDSCOPE,
                    args);
            }

            if ((lfPackageScopeRuleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISIBILITY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPackageScopeRuleModelImpl.getOriginalScope(),
                        lfPackageScopeRuleModelImpl.getOriginalScopeID(),
                        lfPackageScopeRuleModelImpl.getOriginalVisibility()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VISIBILITY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISIBILITY,
                    args);

                args = new Object[] {
                        lfPackageScopeRuleModelImpl.getScope(),
                        lfPackageScopeRuleModelImpl.getScopeID(),
                        lfPackageScopeRuleModelImpl.getVisibility()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VISIBILITY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISIBILITY,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageScopeRuleImpl.class, lfPackageScopeRule.getPrimaryKey(),
            lfPackageScopeRule);

        clearUniqueFindersCache(lfPackageScopeRule);
        cacheUniqueFindersCache(lfPackageScopeRule);

        return lfPackageScopeRule;
    }

    protected LFPackageScopeRule toUnwrappedModel(
        LFPackageScopeRule lfPackageScopeRule) {
        if (lfPackageScopeRule instanceof LFPackageScopeRuleImpl) {
            return lfPackageScopeRule;
        }

        LFPackageScopeRuleImpl lfPackageScopeRuleImpl = new LFPackageScopeRuleImpl();

        lfPackageScopeRuleImpl.setNew(lfPackageScopeRule.isNew());
        lfPackageScopeRuleImpl.setPrimaryKey(lfPackageScopeRule.getPrimaryKey());

        lfPackageScopeRuleImpl.setId(lfPackageScopeRule.getId());
        lfPackageScopeRuleImpl.setPackageID(lfPackageScopeRule.getPackageID());
        lfPackageScopeRuleImpl.setScope(lfPackageScopeRule.getScope());
        lfPackageScopeRuleImpl.setScopeID(lfPackageScopeRule.getScopeID());
        lfPackageScopeRuleImpl.setVisibility(lfPackageScopeRule.getVisibility());
        lfPackageScopeRuleImpl.setIsDefault(lfPackageScopeRule.getIsDefault());

        return lfPackageScopeRuleImpl;
    }

    /**
     * Returns the l f package scope rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f package scope rule
     * @return the l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        LFPackageScopeRule lfPackageScopeRule = fetchByPrimaryKey(primaryKey);

        if (lfPackageScopeRule == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFPackageScopeRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfPackageScopeRule;
    }

    /**
     * Returns the l f package scope rule with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException} if it could not be found.
     *
     * @param id the primary key of the l f package scope rule
     * @return the l f package scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule findByPrimaryKey(long id)
        throws NoSuchLFPackageScopeRuleException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f package scope rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f package scope rule
     * @return the l f package scope rule, or <code>null</code> if a l f package scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFPackageScopeRule lfPackageScopeRule = (LFPackageScopeRule) EntityCacheUtil.getResult(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
                LFPackageScopeRuleImpl.class, primaryKey);

        if (lfPackageScopeRule == _nullLFPackageScopeRule) {
            return null;
        }

        if (lfPackageScopeRule == null) {
            Session session = null;

            try {
                session = openSession();

                lfPackageScopeRule = (LFPackageScopeRule) session.get(LFPackageScopeRuleImpl.class,
                        primaryKey);

                if (lfPackageScopeRule != null) {
                    cacheResult(lfPackageScopeRule);
                } else {
                    EntityCacheUtil.putResult(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
                        LFPackageScopeRuleImpl.class, primaryKey,
                        _nullLFPackageScopeRule);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFPackageScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
                    LFPackageScopeRuleImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfPackageScopeRule;
    }

    /**
     * Returns the l f package scope rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f package scope rule
     * @return the l f package scope rule, or <code>null</code> if a l f package scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackageScopeRule fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f package scope rules.
     *
     * @return the l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f package scope rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f package scope rules
     * @param end the upper bound of the range of l f package scope rules (not inclusive)
     * @return the range of l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f package scope rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f package scope rules
     * @param end the upper bound of the range of l f package scope rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f package scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackageScopeRule> findAll(int start, int end,
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

        List<LFPackageScopeRule> list = (List<LFPackageScopeRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFPACKAGESCOPERULE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFPACKAGESCOPERULE;

                if (pagination) {
                    sql = sql.concat(LFPackageScopeRuleModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFPackageScopeRule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackageScopeRule>(list);
                } else {
                    list = (List<LFPackageScopeRule>) QueryUtil.list(q,
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
     * Removes all the l f package scope rules from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFPackageScopeRule lfPackageScopeRule : findAll()) {
            remove(lfPackageScopeRule);
        }
    }

    /**
     * Returns the number of l f package scope rules.
     *
     * @return the number of l f package scope rules
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

                Query q = session.createQuery(_SQL_COUNT_LFPACKAGESCOPERULE);

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
     * Initializes the l f package scope rule persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFPackageScopeRule>> listenersList = new ArrayList<ModelListener<LFPackageScopeRule>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFPackageScopeRule>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFPackageScopeRuleImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
