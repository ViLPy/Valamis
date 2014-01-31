package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalServiceUtil;

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


public class LFRollupContributionClp extends BaseModelImpl<LFRollupContribution>
    implements LFRollupContribution {
    private long _id;
    private Integer _sequencingID;
    private String _contributeToSatisfied;
    private String _contributeToNotSatisfied;
    private String _contributeToCompleted;
    private String _contributeToIncomplete;
    private BigDecimal _objectiveMeasureWeight;
    private boolean _measureSatisfactionIfActive;
    private BaseModel<?> _lfRollupContributionRemoteModel;

    public LFRollupContributionClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFRollupContribution.class;
    }

    @Override
    public String getModelClassName() {
        return LFRollupContribution.class.getName();
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
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("contributeToSatisfied", getContributeToSatisfied());
        attributes.put("contributeToNotSatisfied", getContributeToNotSatisfied());
        attributes.put("contributeToCompleted", getContributeToCompleted());
        attributes.put("contributeToIncomplete", getContributeToIncomplete());
        attributes.put("objectiveMeasureWeight", getObjectiveMeasureWeight());
        attributes.put("measureSatisfactionIfActive",
            getMeasureSatisfactionIfActive());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer sequencingID = (Integer) attributes.get("sequencingID");

        if (sequencingID != null) {
            setSequencingID(sequencingID);
        }

        String contributeToSatisfied = (String) attributes.get(
                "contributeToSatisfied");

        if (contributeToSatisfied != null) {
            setContributeToSatisfied(contributeToSatisfied);
        }

        String contributeToNotSatisfied = (String) attributes.get(
                "contributeToNotSatisfied");

        if (contributeToNotSatisfied != null) {
            setContributeToNotSatisfied(contributeToNotSatisfied);
        }

        String contributeToCompleted = (String) attributes.get(
                "contributeToCompleted");

        if (contributeToCompleted != null) {
            setContributeToCompleted(contributeToCompleted);
        }

        String contributeToIncomplete = (String) attributes.get(
                "contributeToIncomplete");

        if (contributeToIncomplete != null) {
            setContributeToIncomplete(contributeToIncomplete);
        }

        BigDecimal objectiveMeasureWeight = (BigDecimal) attributes.get(
                "objectiveMeasureWeight");

        if (objectiveMeasureWeight != null) {
            setObjectiveMeasureWeight(objectiveMeasureWeight);
        }

        Boolean measureSatisfactionIfActive = (Boolean) attributes.get(
                "measureSatisfactionIfActive");

        if (measureSatisfactionIfActive != null) {
            setMeasureSatisfactionIfActive(measureSatisfactionIfActive);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfRollupContributionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupContributionRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfRollupContributionRemoteModel, id);
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

        if (_lfRollupContributionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupContributionRemoteModel.getClass();

                Method method = clazz.getMethod("setSequencingID", Integer.class);

                method.invoke(_lfRollupContributionRemoteModel, sequencingID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContributeToSatisfied() {
        return _contributeToSatisfied;
    }

    @Override
    public void setContributeToSatisfied(String contributeToSatisfied) {
        _contributeToSatisfied = contributeToSatisfied;

        if (_lfRollupContributionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupContributionRemoteModel.getClass();

                Method method = clazz.getMethod("setContributeToSatisfied",
                        String.class);

                method.invoke(_lfRollupContributionRemoteModel,
                    contributeToSatisfied);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContributeToNotSatisfied() {
        return _contributeToNotSatisfied;
    }

    @Override
    public void setContributeToNotSatisfied(String contributeToNotSatisfied) {
        _contributeToNotSatisfied = contributeToNotSatisfied;

        if (_lfRollupContributionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupContributionRemoteModel.getClass();

                Method method = clazz.getMethod("setContributeToNotSatisfied",
                        String.class);

                method.invoke(_lfRollupContributionRemoteModel,
                    contributeToNotSatisfied);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContributeToCompleted() {
        return _contributeToCompleted;
    }

    @Override
    public void setContributeToCompleted(String contributeToCompleted) {
        _contributeToCompleted = contributeToCompleted;

        if (_lfRollupContributionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupContributionRemoteModel.getClass();

                Method method = clazz.getMethod("setContributeToCompleted",
                        String.class);

                method.invoke(_lfRollupContributionRemoteModel,
                    contributeToCompleted);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContributeToIncomplete() {
        return _contributeToIncomplete;
    }

    @Override
    public void setContributeToIncomplete(String contributeToIncomplete) {
        _contributeToIncomplete = contributeToIncomplete;

        if (_lfRollupContributionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupContributionRemoteModel.getClass();

                Method method = clazz.getMethod("setContributeToIncomplete",
                        String.class);

                method.invoke(_lfRollupContributionRemoteModel,
                    contributeToIncomplete);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public BigDecimal getObjectiveMeasureWeight() {
        return _objectiveMeasureWeight;
    }

    @Override
    public void setObjectiveMeasureWeight(BigDecimal objectiveMeasureWeight) {
        _objectiveMeasureWeight = objectiveMeasureWeight;

        if (_lfRollupContributionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupContributionRemoteModel.getClass();

                Method method = clazz.getMethod("setObjectiveMeasureWeight",
                        BigDecimal.class);

                method.invoke(_lfRollupContributionRemoteModel,
                    objectiveMeasureWeight);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getMeasureSatisfactionIfActive() {
        return _measureSatisfactionIfActive;
    }

    @Override
    public boolean isMeasureSatisfactionIfActive() {
        return _measureSatisfactionIfActive;
    }

    @Override
    public void setMeasureSatisfactionIfActive(
        boolean measureSatisfactionIfActive) {
        _measureSatisfactionIfActive = measureSatisfactionIfActive;

        if (_lfRollupContributionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRollupContributionRemoteModel.getClass();

                Method method = clazz.getMethod("setMeasureSatisfactionIfActive",
                        boolean.class);

                method.invoke(_lfRollupContributionRemoteModel,
                    measureSatisfactionIfActive);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFRollupContributionRemoteModel() {
        return _lfRollupContributionRemoteModel;
    }

    public void setLFRollupContributionRemoteModel(
        BaseModel<?> lfRollupContributionRemoteModel) {
        _lfRollupContributionRemoteModel = lfRollupContributionRemoteModel;
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

        Class<?> remoteModelClass = _lfRollupContributionRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfRollupContributionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFRollupContributionLocalServiceUtil.addLFRollupContribution(this);
        } else {
            LFRollupContributionLocalServiceUtil.updateLFRollupContribution(this);
        }
    }

    @Override
    public LFRollupContribution toEscapedModel() {
        return (LFRollupContribution) ProxyUtil.newProxyInstance(LFRollupContribution.class.getClassLoader(),
            new Class[] { LFRollupContribution.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFRollupContributionClp clone = new LFRollupContributionClp();

        clone.setId(getId());
        clone.setSequencingID(getSequencingID());
        clone.setContributeToSatisfied(getContributeToSatisfied());
        clone.setContributeToNotSatisfied(getContributeToNotSatisfied());
        clone.setContributeToCompleted(getContributeToCompleted());
        clone.setContributeToIncomplete(getContributeToIncomplete());
        clone.setObjectiveMeasureWeight(getObjectiveMeasureWeight());
        clone.setMeasureSatisfactionIfActive(getMeasureSatisfactionIfActive());

        return clone;
    }

    @Override
    public int compareTo(LFRollupContribution lfRollupContribution) {
        long primaryKey = lfRollupContribution.getPrimaryKey();

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

        if (!(obj instanceof LFRollupContributionClp)) {
            return false;
        }

        LFRollupContributionClp lfRollupContribution = (LFRollupContributionClp) obj;

        long primaryKey = lfRollupContribution.getPrimaryKey();

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
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", sequencingID=");
        sb.append(getSequencingID());
        sb.append(", contributeToSatisfied=");
        sb.append(getContributeToSatisfied());
        sb.append(", contributeToNotSatisfied=");
        sb.append(getContributeToNotSatisfied());
        sb.append(", contributeToCompleted=");
        sb.append(getContributeToCompleted());
        sb.append(", contributeToIncomplete=");
        sb.append(getContributeToIncomplete());
        sb.append(", objectiveMeasureWeight=");
        sb.append(getObjectiveMeasureWeight());
        sb.append(", measureSatisfactionIfActive=");
        sb.append(getMeasureSatisfactionIfActive());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFRollupContribution");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sequencingID</column-name><column-value><![CDATA[");
        sb.append(getSequencingID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contributeToSatisfied</column-name><column-value><![CDATA[");
        sb.append(getContributeToSatisfied());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contributeToNotSatisfied</column-name><column-value><![CDATA[");
        sb.append(getContributeToNotSatisfied());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contributeToCompleted</column-name><column-value><![CDATA[");
        sb.append(getContributeToCompleted());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contributeToIncomplete</column-name><column-value><![CDATA[");
        sb.append(getContributeToIncomplete());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectiveMeasureWeight</column-name><column-value><![CDATA[");
        sb.append(getObjectiveMeasureWeight());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>measureSatisfactionIfActive</column-name><column-value><![CDATA[");
        sb.append(getMeasureSatisfactionIfActive());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
