package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;


public class LFObjectiveClp extends BaseModelImpl<LFObjective>
    implements LFObjective {
    private long _lfId;
    private Integer _sequencingID;
    private boolean _satisfiedByMeasure;
    private String _identifier;
    private BigDecimal _minNormalizedMeasure;
    private Boolean _isPrimary;
    private BaseModel<?> _lfObjectiveRemoteModel;

    public LFObjectiveClp() {
    }

    public Class<?> getModelClass() {
        return LFObjective.class;
    }

    public String getModelClassName() {
        return LFObjective.class.getName();
    }

    public long getPrimaryKey() {
        return _lfId;
    }

    public void setPrimaryKey(long primaryKey) {
        setLfId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_lfId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("lfId", getLfId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("satisfiedByMeasure", getSatisfiedByMeasure());
        attributes.put("identifier", getIdentifier());
        attributes.put("minNormalizedMeasure", getMinNormalizedMeasure());
        attributes.put("isPrimary", getIsPrimary());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long lfId = (Long) attributes.get("lfId");

        if (lfId != null) {
            setLfId(lfId);
        }

        Integer sequencingID = (Integer) attributes.get("sequencingID");

        if (sequencingID != null) {
            setSequencingID(sequencingID);
        }

        Boolean satisfiedByMeasure = (Boolean) attributes.get(
                "satisfiedByMeasure");

        if (satisfiedByMeasure != null) {
            setSatisfiedByMeasure(satisfiedByMeasure);
        }

        String identifier = (String) attributes.get("identifier");

        if (identifier != null) {
            setIdentifier(identifier);
        }

        BigDecimal minNormalizedMeasure = (BigDecimal) attributes.get(
                "minNormalizedMeasure");

        if (minNormalizedMeasure != null) {
            setMinNormalizedMeasure(minNormalizedMeasure);
        }

        Boolean isPrimary = (Boolean) attributes.get("isPrimary");

        if (isPrimary != null) {
            setIsPrimary(isPrimary);
        }
    }

    public long getLfId() {
        return _lfId;
    }

    public void setLfId(long lfId) {
        _lfId = lfId;
    }

    public Integer getSequencingID() {
        return _sequencingID;
    }

    public void setSequencingID(Integer sequencingID) {
        _sequencingID = sequencingID;
    }

    public boolean getSatisfiedByMeasure() {
        return _satisfiedByMeasure;
    }

    public boolean isSatisfiedByMeasure() {
        return _satisfiedByMeasure;
    }

    public void setSatisfiedByMeasure(boolean satisfiedByMeasure) {
        _satisfiedByMeasure = satisfiedByMeasure;
    }

    public String getIdentifier() {
        return _identifier;
    }

    public void setIdentifier(String identifier) {
        _identifier = identifier;
    }

    public BigDecimal getMinNormalizedMeasure() {
        return _minNormalizedMeasure;
    }

    public void setMinNormalizedMeasure(BigDecimal minNormalizedMeasure) {
        _minNormalizedMeasure = minNormalizedMeasure;
    }

    public Boolean getIsPrimary() {
        return _isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        _isPrimary = isPrimary;
    }

    public BaseModel<?> getLFObjectiveRemoteModel() {
        return _lfObjectiveRemoteModel;
    }

    public void setLFObjectiveRemoteModel(BaseModel<?> lfObjectiveRemoteModel) {
        _lfObjectiveRemoteModel = lfObjectiveRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFObjectiveLocalServiceUtil.addLFObjective(this);
        } else {
            LFObjectiveLocalServiceUtil.updateLFObjective(this);
        }
    }

    @Override
    public LFObjective toEscapedModel() {
        return (LFObjective) Proxy.newProxyInstance(LFObjective.class.getClassLoader(),
            new Class[] { LFObjective.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFObjectiveClp clone = new LFObjectiveClp();

        clone.setLfId(getLfId());
        clone.setSequencingID(getSequencingID());
        clone.setSatisfiedByMeasure(getSatisfiedByMeasure());
        clone.setIdentifier(getIdentifier());
        clone.setMinNormalizedMeasure(getMinNormalizedMeasure());
        clone.setIsPrimary(getIsPrimary());

        return clone;
    }

    public int compareTo(LFObjective lfObjective) {
        long primaryKey = lfObjective.getPrimaryKey();

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
        if (obj == null) {
            return false;
        }

        LFObjectiveClp lfObjective = null;

        try {
            lfObjective = (LFObjectiveClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfObjective.getPrimaryKey();

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
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{lfId=");
        sb.append(getLfId());
        sb.append(", sequencingID=");
        sb.append(getSequencingID());
        sb.append(", satisfiedByMeasure=");
        sb.append(getSatisfiedByMeasure());
        sb.append(", identifier=");
        sb.append(getIdentifier());
        sb.append(", minNormalizedMeasure=");
        sb.append(getMinNormalizedMeasure());
        sb.append(", isPrimary=");
        sb.append(getIsPrimary());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFObjective");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>lfId</column-name><column-value><![CDATA[");
        sb.append(getLfId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sequencingID</column-name><column-value><![CDATA[");
        sb.append(getSequencingID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>satisfiedByMeasure</column-name><column-value><![CDATA[");
        sb.append(getSatisfiedByMeasure());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>identifier</column-name><column-value><![CDATA[");
        sb.append(getIdentifier());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>minNormalizedMeasure</column-name><column-value><![CDATA[");
        sb.append(getMinNormalizedMeasure());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isPrimary</column-name><column-value><![CDATA[");
        sb.append(getIsPrimary());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
