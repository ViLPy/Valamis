package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveState;
import com.arcusys.learn.persistence.liferay.model.LFObjectiveStateModel;

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

import java.math.BigDecimal;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the LFObjectiveState service. Represents a row in the &quot;Learn_LFObjectiveState&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.arcusys.learn.persistence.liferay.model.LFObjectiveStateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFObjectiveStateImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectiveStateImpl
 * @see com.arcusys.learn.persistence.liferay.model.LFObjectiveState
 * @see com.arcusys.learn.persistence.liferay.model.LFObjectiveStateModel
 * @generated
 */
public class LFObjectiveStateModelImpl extends BaseModelImpl<LFObjectiveState>
    implements LFObjectiveStateModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a l f objective state model instance should use the {@link com.arcusys.learn.persistence.liferay.model.LFObjectiveState} interface instead.
     */
    public static final String TABLE_NAME = "Learn_LFObjectiveState";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "satisfied", Types.BOOLEAN },
            { "normalizedMeasure", Types.NUMERIC },
            { "mapKey", Types.VARCHAR },
            { "activityStateID", Types.INTEGER },
            { "objectiveID", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table Learn_LFObjectiveState (id_ LONG not null primary key,satisfied BOOLEAN null,normalizedMeasure NUMERIC(20,2),mapKey VARCHAR(3000) null,activityStateID INTEGER null,objectiveID INTEGER null)";
    public static final String TABLE_SQL_DROP = "drop table Learn_LFObjectiveState";
    public static final String ORDER_BY_JPQL = " ORDER BY lfObjectiveState.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY Learn_LFObjectiveState.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFObjectiveState"),
            false);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFObjectiveState"),
            false);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arcusys.learn.persistence.liferay.model.LFObjectiveState"),
            true);
    public static long ACTIVITYSTATEID_COLUMN_BITMASK = 1L;
    public static long MAPKEY_COLUMN_BITMASK = 2L;
    public static long ID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arcusys.learn.persistence.liferay.model.LFObjectiveState"));
    private static ClassLoader _classLoader = LFObjectiveState.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            LFObjectiveState.class
        };
    private long _id;
    private Boolean _satisfied;
    private BigDecimal _normalizedMeasure;
    private String _mapKey;
    private String _originalMapKey;
    private Integer _activityStateID;
    private Integer _originalActivityStateID;
    private boolean _setOriginalActivityStateID;
    private Integer _objectiveID;
    private long _columnBitmask;
    private LFObjectiveState _escapedModel;

    public LFObjectiveStateModelImpl() {
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
        return LFObjectiveState.class;
    }

    @Override
    public String getModelClassName() {
        return LFObjectiveState.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("satisfied", getSatisfied());
        attributes.put("normalizedMeasure", getNormalizedMeasure());
        attributes.put("mapKey", getMapKey());
        attributes.put("activityStateID", getActivityStateID());
        attributes.put("objectiveID", getObjectiveID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Boolean satisfied = (Boolean) attributes.get("satisfied");

        if (satisfied != null) {
            setSatisfied(satisfied);
        }

        BigDecimal normalizedMeasure = (BigDecimal) attributes.get(
                "normalizedMeasure");

        if (normalizedMeasure != null) {
            setNormalizedMeasure(normalizedMeasure);
        }

        String mapKey = (String) attributes.get("mapKey");

        if (mapKey != null) {
            setMapKey(mapKey);
        }

        Integer activityStateID = (Integer) attributes.get("activityStateID");

        if (activityStateID != null) {
            setActivityStateID(activityStateID);
        }

        Integer objectiveID = (Integer) attributes.get("objectiveID");

        if (objectiveID != null) {
            setObjectiveID(objectiveID);
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
    public Boolean getSatisfied() {
        return _satisfied;
    }

    @Override
    public void setSatisfied(Boolean satisfied) {
        _satisfied = satisfied;
    }

    @Override
    public BigDecimal getNormalizedMeasure() {
        return _normalizedMeasure;
    }

    @Override
    public void setNormalizedMeasure(BigDecimal normalizedMeasure) {
        _normalizedMeasure = normalizedMeasure;
    }

    @Override
    public String getMapKey() {
        return _mapKey;
    }

    @Override
    public void setMapKey(String mapKey) {
        _columnBitmask |= MAPKEY_COLUMN_BITMASK;

        if (_originalMapKey == null) {
            _originalMapKey = _mapKey;
        }

        _mapKey = mapKey;
    }

    public String getOriginalMapKey() {
        return _originalMapKey;
    }

    @Override
    public Integer getActivityStateID() {
        return _activityStateID;
    }

    @Override
    public void setActivityStateID(Integer activityStateID) {
        _columnBitmask |= ACTIVITYSTATEID_COLUMN_BITMASK;

        if (!_setOriginalActivityStateID) {
            _setOriginalActivityStateID = true;

            _originalActivityStateID = _activityStateID;
        }

        _activityStateID = activityStateID;
    }

    public Integer getOriginalActivityStateID() {
        return _originalActivityStateID;
    }

    @Override
    public Integer getObjectiveID() {
        return _objectiveID;
    }

    @Override
    public void setObjectiveID(Integer objectiveID) {
        _objectiveID = objectiveID;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            LFObjectiveState.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public LFObjectiveState toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (LFObjectiveState) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        LFObjectiveStateImpl lfObjectiveStateImpl = new LFObjectiveStateImpl();

        lfObjectiveStateImpl.setId(getId());
        lfObjectiveStateImpl.setSatisfied(getSatisfied());
        lfObjectiveStateImpl.setNormalizedMeasure(getNormalizedMeasure());
        lfObjectiveStateImpl.setMapKey(getMapKey());
        lfObjectiveStateImpl.setActivityStateID(getActivityStateID());
        lfObjectiveStateImpl.setObjectiveID(getObjectiveID());

        lfObjectiveStateImpl.resetOriginalValues();

        return lfObjectiveStateImpl;
    }

    @Override
    public int compareTo(LFObjectiveState lfObjectiveState) {
        long primaryKey = lfObjectiveState.getPrimaryKey();

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

        if (!(obj instanceof LFObjectiveState)) {
            return false;
        }

        LFObjectiveState lfObjectiveState = (LFObjectiveState) obj;

        long primaryKey = lfObjectiveState.getPrimaryKey();

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
        LFObjectiveStateModelImpl lfObjectiveStateModelImpl = this;

        lfObjectiveStateModelImpl._originalMapKey = lfObjectiveStateModelImpl._mapKey;

        lfObjectiveStateModelImpl._originalActivityStateID = lfObjectiveStateModelImpl._activityStateID;

        lfObjectiveStateModelImpl._setOriginalActivityStateID = false;

        lfObjectiveStateModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<LFObjectiveState> toCacheModel() {
        LFObjectiveStateCacheModel lfObjectiveStateCacheModel = new LFObjectiveStateCacheModel();

        lfObjectiveStateCacheModel.id = getId();

        lfObjectiveStateCacheModel.satisfied = getSatisfied();

        lfObjectiveStateCacheModel.normalizedMeasure = getNormalizedMeasure();

        lfObjectiveStateCacheModel.mapKey = getMapKey();

        String mapKey = lfObjectiveStateCacheModel.mapKey;

        if ((mapKey != null) && (mapKey.length() == 0)) {
            lfObjectiveStateCacheModel.mapKey = null;
        }

        lfObjectiveStateCacheModel.activityStateID = getActivityStateID();

        lfObjectiveStateCacheModel.objectiveID = getObjectiveID();

        return lfObjectiveStateCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", satisfied=");
        sb.append(getSatisfied());
        sb.append(", normalizedMeasure=");
        sb.append(getNormalizedMeasure());
        sb.append(", mapKey=");
        sb.append(getMapKey());
        sb.append(", activityStateID=");
        sb.append(getActivityStateID());
        sb.append(", objectiveID=");
        sb.append(getObjectiveID());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFObjectiveState");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>satisfied</column-name><column-value><![CDATA[");
        sb.append(getSatisfied());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>normalizedMeasure</column-name><column-value><![CDATA[");
        sb.append(getNormalizedMeasure());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mapKey</column-name><column-value><![CDATA[");
        sb.append(getMapKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityStateID</column-name><column-value><![CDATA[");
        sb.append(getActivityStateID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectiveID</column-name><column-value><![CDATA[");
        sb.append(getObjectiveID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
