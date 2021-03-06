package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanPackage;
import com.arcusys.learn.persistence.liferay.model.LFTincanPackageModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the LFTincanPackage service. Represents a row in the &quot;Learn_LFTincanPackage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.arcusys.learn.persistence.liferay.model.LFTincanPackageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFTincanPackageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanPackageImpl
 * @see com.arcusys.learn.persistence.liferay.model.LFTincanPackage
 * @see com.arcusys.learn.persistence.liferay.model.LFTincanPackageModel
 * @generated
 */
public class LFTincanPackageModelImpl extends BaseModelImpl<LFTincanPackage>
    implements LFTincanPackageModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a l f tincan package model instance should use the {@link com.arcusys.learn.persistence.liferay.model.LFTincanPackage} interface instead.
     */
    public static final String TABLE_NAME = "Learn_LFTincanPackage";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "title", Types.VARCHAR },
            { "summary", Types.VARCHAR },
            { "assetRefID", Types.BIGINT },
            { "courseID", Types.INTEGER },
            { "logo", Types.CLOB },
            { "beginDate", Types.TIMESTAMP },
            { "endDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table Learn_LFTincanPackage (id_ LONG not null primary key,title VARCHAR(2000) null,summary VARCHAR(2000) null,assetRefID LONG null,courseID INTEGER null,logo TEXT null,beginDate DATE null,endDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table Learn_LFTincanPackage";
    public static final String ORDER_BY_JPQL = " ORDER BY lfTincanPackage.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY Learn_LFTincanPackage.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFTincanPackage"),
            false);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFTincanPackage"),
            false);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arcusys.learn.persistence.liferay.model.LFTincanPackage"),
            true);
    public static long ASSETREFID_COLUMN_BITMASK = 1L;
    public static long COURSEID_COLUMN_BITMASK = 2L;
    public static long TITLE_COLUMN_BITMASK = 4L;
    public static long ID_COLUMN_BITMASK = 8L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arcusys.learn.persistence.liferay.model.LFTincanPackage"));
    private static ClassLoader _classLoader = LFTincanPackage.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            LFTincanPackage.class
        };
    private long _id;
    private String _title;
    private String _originalTitle;
    private String _summary;
    private Long _assetRefID;
    private Long _originalAssetRefID;
    private boolean _setOriginalAssetRefID;
    private Integer _courseID;
    private Integer _originalCourseID;
    private boolean _setOriginalCourseID;
    private String _logo;
    private Date _beginDate;
    private Date _endDate;
    private long _columnBitmask;
    private LFTincanPackage _escapedModel;

    public LFTincanPackageModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanPackage.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanPackage.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("summary", getSummary());
        attributes.put("assetRefID", getAssetRefID());
        attributes.put("courseID", getCourseID());
        attributes.put("logo", getLogo());
        attributes.put("beginDate", getBeginDate());
        attributes.put("endDate", getEndDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String summary = (String) attributes.get("summary");

        if (summary != null) {
            setSummary(summary);
        }

        Long assetRefID = (Long) attributes.get("assetRefID");

        if (assetRefID != null) {
            setAssetRefID(assetRefID);
        }

        Integer courseID = (Integer) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }

        String logo = (String) attributes.get("logo");

        if (logo != null) {
            setLogo(logo);
        }

        Date beginDate = (Date) attributes.get("beginDate");

        if (beginDate != null) {
            setBeginDate(beginDate);
        }

        Date endDate = (Date) attributes.get("endDate");

        if (endDate != null) {
            setEndDate(endDate);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _columnBitmask |= TITLE_COLUMN_BITMASK;

        if (_originalTitle == null) {
            _originalTitle = _title;
        }

        _title = title;
    }

    public String getOriginalTitle() {
        return _originalTitle;
    }

    @Override
    public String getSummary() {
        return _summary;
    }

    @Override
    public void setSummary(String summary) {
        _summary = summary;
    }

    @Override
    public Long getAssetRefID() {
        return _assetRefID;
    }

    @Override
    public void setAssetRefID(Long assetRefID) {
        _columnBitmask |= ASSETREFID_COLUMN_BITMASK;

        if (!_setOriginalAssetRefID) {
            _setOriginalAssetRefID = true;

            _originalAssetRefID = _assetRefID;
        }

        _assetRefID = assetRefID;
    }

    public Long getOriginalAssetRefID() {
        return _originalAssetRefID;
    }

    @Override
    public Integer getCourseID() {
        return _courseID;
    }

    @Override
    public void setCourseID(Integer courseID) {
        _columnBitmask |= COURSEID_COLUMN_BITMASK;

        if (!_setOriginalCourseID) {
            _setOriginalCourseID = true;

            _originalCourseID = _courseID;
        }

        _courseID = courseID;
    }

    public Integer getOriginalCourseID() {
        return _originalCourseID;
    }

    @Override
    public String getLogo() {
        return _logo;
    }

    @Override
    public void setLogo(String logo) {
        _logo = logo;
    }

    @Override
    public Date getBeginDate() {
        return _beginDate;
    }

    @Override
    public void setBeginDate(Date beginDate) {
        _beginDate = beginDate;
    }

    @Override
    public Date getEndDate() {
        return _endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        _endDate = endDate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            LFTincanPackage.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public LFTincanPackage toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (LFTincanPackage) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        LFTincanPackageImpl lfTincanPackageImpl = new LFTincanPackageImpl();

        lfTincanPackageImpl.setId(getId());
        lfTincanPackageImpl.setTitle(getTitle());
        lfTincanPackageImpl.setSummary(getSummary());
        lfTincanPackageImpl.setAssetRefID(getAssetRefID());
        lfTincanPackageImpl.setCourseID(getCourseID());
        lfTincanPackageImpl.setLogo(getLogo());
        lfTincanPackageImpl.setBeginDate(getBeginDate());
        lfTincanPackageImpl.setEndDate(getEndDate());

        lfTincanPackageImpl.resetOriginalValues();

        return lfTincanPackageImpl;
    }

    @Override
    public int compareTo(LFTincanPackage lfTincanPackage) {
        long primaryKey = lfTincanPackage.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanPackage)) {
            return false;
        }

        LFTincanPackage lfTincanPackage = (LFTincanPackage) obj;

        long primaryKey = lfTincanPackage.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        LFTincanPackageModelImpl lfTincanPackageModelImpl = this;

        lfTincanPackageModelImpl._originalTitle = lfTincanPackageModelImpl._title;

        lfTincanPackageModelImpl._originalAssetRefID = lfTincanPackageModelImpl._assetRefID;

        lfTincanPackageModelImpl._setOriginalAssetRefID = false;

        lfTincanPackageModelImpl._originalCourseID = lfTincanPackageModelImpl._courseID;

        lfTincanPackageModelImpl._setOriginalCourseID = false;

        lfTincanPackageModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<LFTincanPackage> toCacheModel() {
        LFTincanPackageCacheModel lfTincanPackageCacheModel = new LFTincanPackageCacheModel();

        lfTincanPackageCacheModel.id = getId();

        lfTincanPackageCacheModel.title = getTitle();

        String title = lfTincanPackageCacheModel.title;

        if ((title != null) && (title.length() == 0)) {
            lfTincanPackageCacheModel.title = null;
        }

        lfTincanPackageCacheModel.summary = getSummary();

        String summary = lfTincanPackageCacheModel.summary;

        if ((summary != null) && (summary.length() == 0)) {
            lfTincanPackageCacheModel.summary = null;
        }

        lfTincanPackageCacheModel.assetRefID = getAssetRefID();

        lfTincanPackageCacheModel.courseID = getCourseID();

        lfTincanPackageCacheModel.logo = getLogo();

        String logo = lfTincanPackageCacheModel.logo;

        if ((logo != null) && (logo.length() == 0)) {
            lfTincanPackageCacheModel.logo = null;
        }

        Date beginDate = getBeginDate();

        if (beginDate != null) {
            lfTincanPackageCacheModel.beginDate = beginDate.getTime();
        } else {
            lfTincanPackageCacheModel.beginDate = Long.MIN_VALUE;
        }

        Date endDate = getEndDate();

        if (endDate != null) {
            lfTincanPackageCacheModel.endDate = endDate.getTime();
        } else {
            lfTincanPackageCacheModel.endDate = Long.MIN_VALUE;
        }

        return lfTincanPackageCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", summary=");
        sb.append(getSummary());
        sb.append(", assetRefID=");
        sb.append(getAssetRefID());
        sb.append(", courseID=");
        sb.append(getCourseID());
        sb.append(", logo=");
        sb.append(getLogo());
        sb.append(", beginDate=");
        sb.append(getBeginDate());
        sb.append(", endDate=");
        sb.append(getEndDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFTincanPackage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>summary</column-name><column-value><![CDATA[");
        sb.append(getSummary());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>assetRefID</column-name><column-value><![CDATA[");
        sb.append(getAssetRefID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courseID</column-name><column-value><![CDATA[");
        sb.append(getCourseID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>logo</column-name><column-value><![CDATA[");
        sb.append(getLogo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>beginDate</column-name><column-value><![CDATA[");
        sb.append(getBeginDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>endDate</column-name><column-value><![CDATA[");
        sb.append(getEndDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
