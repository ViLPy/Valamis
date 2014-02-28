package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

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

    @Override
    public Class<?> getModelClass() {
        return LFObjective.class;
    }

    @Override
    public String getModelClassName() {
        return LFObjective.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _lfId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setLfId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _lfId;
    }

    @Override
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

    @Override
    public long getLfId() {
        return _lfId;
    }

    @Override
    public void setLfId(long lfId) {
        _lfId = lfId;

        if (_lfObjectiveRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveRemoteModel.getClass();

                Method method = clazz.getMethod("setLfId", long.class);

                method.invoke(_lfObjectiveRemoteModel, lfId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getSequencingID() {
        return _sequencingID;
    }

    @Override
    public void setSequencingID(Integer sequencingID) {
        _sequencingID = sequencingID;

        if (_lfObjectiveRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveRemoteModel.getClass();

                Method method = clazz.getMethod("setSequencingID", Integer.class);

                method.invoke(_lfObjectiveRemoteModel, sequencingID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getSatisfiedByMeasure() {
        return _satisfiedByMeasure;
    }

    @Override
    public boolean isSatisfiedByMeasure() {
        return _satisfiedByMeasure;
    }

    @Override
    public void setSatisfiedByMeasure(boolean satisfiedByMeasure) {
        _satisfiedByMeasure = satisfiedByMeasure;

        if (_lfObjectiveRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveRemoteModel.getClass();

                Method method = clazz.getMethod("setSatisfiedByMeasure",
                        boolean.class);

                method.invoke(_lfObjectiveRemoteModel, satisfiedByMeasure);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIdentifier() {
        return _identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        _identifier = identifier;

        if (_lfObjectiveRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveRemoteModel.getClass();

                Method method = clazz.getMethod("setIdentifier", String.class);

                method.invoke(_lfObjectiveRemoteModel, identifier);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public BigDecimal getMinNormalizedMeasure() {
        return _minNormalizedMeasure;
    }

    @Override
    public void setMinNormalizedMeasure(BigDecimal minNormalizedMeasure) {
        _minNormalizedMeasure = minNormalizedMeasure;

        if (_lfObjectiveRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveRemoteModel.getClass();

                Method method = clazz.getMethod("setMinNormalizedMeasure",
                        BigDecimal.class);

                method.invoke(_lfObjectiveRemoteModel, minNormalizedMeasure);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getIsPrimary() {
        return _isPrimary;
    }

    @Override
    public void setIsPrimary(Boolean isPrimary) {
        _isPrimary = isPrimary;

        if (_lfObjectiveRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveRemoteModel.getClass();

                Method method = clazz.getMethod("setIsPrimary", Boolean.class);

                method.invoke(_lfObjectiveRemoteModel, isPrimary);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFObjectiveRemoteModel() {
        return _lfObjectiveRemoteModel;
    }

    public void setLFObjectiveRemoteModel(BaseModel<?> lfObjectiveRemoteModel) {
        _lfObjectiveRemoteModel = lfObjectiveRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _lfObjectiveRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_lfObjectiveRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFObjectiveLocalServiceUtil.addLFObjective(this);
        } else {
            LFObjectiveLocalServiceUtil.updateLFObjective(this);
        }
    }

    @Override
    public LFObjective toEscapedModel() {
        return (LFObjective) ProxyUtil.newProxyInstance(LFObjective.class.getClassLoader(),
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

    @Override
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFObjectiveClp)) {
            return false;
        }

        LFObjectiveClp lfObjective = (LFObjectiveClp) obj;

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

    @Override
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
