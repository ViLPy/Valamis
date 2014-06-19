package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFCertificateActivityLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateActivityPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class LFCertificateActivityClp extends BaseModelImpl<LFCertificateActivity>
    implements LFCertificateActivity {
    private Long _certificateID;
    private String _activityName;
    private Integer _datacount;
    private String _periodType;
    private Integer _period;
    private BaseModel<?> _lfCertificateActivityRemoteModel;

    public LFCertificateActivityClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificateActivity.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificateActivity.class.getName();
    }

    @Override
    public LFCertificateActivityPK getPrimaryKey() {
        return new LFCertificateActivityPK(_certificateID, _activityName);
    }

    @Override
    public void setPrimaryKey(LFCertificateActivityPK primaryKey) {
        setCertificateID(primaryKey.certificateID);
        setActivityName(primaryKey.activityName);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new LFCertificateActivityPK(_certificateID, _activityName);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((LFCertificateActivityPK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("certificateID", getCertificateID());
        attributes.put("activityName", getActivityName());
        attributes.put("datacount", getDatacount());
        attributes.put("periodType", getPeriodType());
        attributes.put("period", getPeriod());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long certificateID = (Long) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        String activityName = (String) attributes.get("activityName");

        if (activityName != null) {
            setActivityName(activityName);
        }

        Integer datacount = (Integer) attributes.get("datacount");

        if (datacount != null) {
            setDatacount(datacount);
        }

        String periodType = (String) attributes.get("periodType");

        if (periodType != null) {
            setPeriodType(periodType);
        }

        Integer period = (Integer) attributes.get("period");

        if (period != null) {
            setPeriod(period);
        }
    }

    @Override
    public Long getCertificateID() {
        return _certificateID;
    }

    @Override
    public void setCertificateID(Long certificateID) {
        _certificateID = certificateID;

        if (_lfCertificateActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setCertificateID", Long.class);

                method.invoke(_lfCertificateActivityRemoteModel, certificateID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getActivityName() {
        return _activityName;
    }

    @Override
    public void setActivityName(String activityName) {
        _activityName = activityName;

        if (_lfCertificateActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setActivityName", String.class);

                method.invoke(_lfCertificateActivityRemoteModel, activityName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getDatacount() {
        return _datacount;
    }

    @Override
    public void setDatacount(Integer datacount) {
        _datacount = datacount;

        if (_lfCertificateActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setDatacount", Integer.class);

                method.invoke(_lfCertificateActivityRemoteModel, datacount);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPeriodType() {
        return _periodType;
    }

    @Override
    public void setPeriodType(String periodType) {
        _periodType = periodType;

        if (_lfCertificateActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setPeriodType", String.class);

                method.invoke(_lfCertificateActivityRemoteModel, periodType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getPeriod() {
        return _period;
    }

    @Override
    public void setPeriod(Integer period) {
        _period = period;

        if (_lfCertificateActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setPeriod", Integer.class);

                method.invoke(_lfCertificateActivityRemoteModel, period);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFCertificateActivityRemoteModel() {
        return _lfCertificateActivityRemoteModel;
    }

    public void setLFCertificateActivityRemoteModel(
        BaseModel<?> lfCertificateActivityRemoteModel) {
        _lfCertificateActivityRemoteModel = lfCertificateActivityRemoteModel;
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

        Class<?> remoteModelClass = _lfCertificateActivityRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfCertificateActivityRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFCertificateActivityLocalServiceUtil.addLFCertificateActivity(this);
        } else {
            LFCertificateActivityLocalServiceUtil.updateLFCertificateActivity(this);
        }
    }

    @Override
    public LFCertificateActivity toEscapedModel() {
        return (LFCertificateActivity) ProxyUtil.newProxyInstance(LFCertificateActivity.class.getClassLoader(),
            new Class[] { LFCertificateActivity.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFCertificateActivityClp clone = new LFCertificateActivityClp();

        clone.setCertificateID(getCertificateID());
        clone.setActivityName(getActivityName());
        clone.setDatacount(getDatacount());
        clone.setPeriodType(getPeriodType());
        clone.setPeriod(getPeriod());

        return clone;
    }

    @Override
    public int compareTo(LFCertificateActivity lfCertificateActivity) {
        LFCertificateActivityPK primaryKey = lfCertificateActivity.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateActivityClp)) {
            return false;
        }

        LFCertificateActivityClp lfCertificateActivity = (LFCertificateActivityClp) obj;

        LFCertificateActivityPK primaryKey = lfCertificateActivity.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{certificateID=");
        sb.append(getCertificateID());
        sb.append(", activityName=");
        sb.append(getActivityName());
        sb.append(", datacount=");
        sb.append(getDatacount());
        sb.append(", periodType=");
        sb.append(getPeriodType());
        sb.append(", period=");
        sb.append(getPeriod());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFCertificateActivity");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>certificateID</column-name><column-value><![CDATA[");
        sb.append(getCertificateID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityName</column-name><column-value><![CDATA[");
        sb.append(getActivityName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>datacount</column-name><column-value><![CDATA[");
        sb.append(getDatacount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>periodType</column-name><column-value><![CDATA[");
        sb.append(getPeriodType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>period</column-name><column-value><![CDATA[");
        sb.append(getPeriod());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
