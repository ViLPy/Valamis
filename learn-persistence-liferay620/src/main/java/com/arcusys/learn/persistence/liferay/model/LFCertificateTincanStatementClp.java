package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFCertificateTincanStatementLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateTincanStatementPK;

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


public class LFCertificateTincanStatementClp extends BaseModelImpl<LFCertificateTincanStatement>
    implements LFCertificateTincanStatement {
    private Long _certificateID;
    private String _verb;
    private String _object;
    private String _periodType;
    private Integer _period;
    private BaseModel<?> _lfCertificateTincanStatementRemoteModel;

    public LFCertificateTincanStatementClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificateTincanStatement.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificateTincanStatement.class.getName();
    }

    @Override
    public LFCertificateTincanStatementPK getPrimaryKey() {
        return new LFCertificateTincanStatementPK(_certificateID, _verb, _object);
    }

    @Override
    public void setPrimaryKey(LFCertificateTincanStatementPK primaryKey) {
        setCertificateID(primaryKey.certificateID);
        setVerb(primaryKey.verb);
        setObject(primaryKey.object);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new LFCertificateTincanStatementPK(_certificateID, _verb, _object);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((LFCertificateTincanStatementPK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("certificateID", getCertificateID());
        attributes.put("verb", getVerb());
        attributes.put("object", getObject());
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

        String verb = (String) attributes.get("verb");

        if (verb != null) {
            setVerb(verb);
        }

        String object = (String) attributes.get("object");

        if (object != null) {
            setObject(object);
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

        if (_lfCertificateTincanStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateTincanStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setCertificateID", Long.class);

                method.invoke(_lfCertificateTincanStatementRemoteModel,
                    certificateID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getVerb() {
        return _verb;
    }

    @Override
    public void setVerb(String verb) {
        _verb = verb;

        if (_lfCertificateTincanStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateTincanStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setVerb", String.class);

                method.invoke(_lfCertificateTincanStatementRemoteModel, verb);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getObject() {
        return _object;
    }

    @Override
    public void setObject(String object) {
        _object = object;

        if (_lfCertificateTincanStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateTincanStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setObject", String.class);

                method.invoke(_lfCertificateTincanStatementRemoteModel, object);
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

        if (_lfCertificateTincanStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateTincanStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setPeriodType", String.class);

                method.invoke(_lfCertificateTincanStatementRemoteModel,
                    periodType);
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

        if (_lfCertificateTincanStatementRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateTincanStatementRemoteModel.getClass();

                Method method = clazz.getMethod("setPeriod", Integer.class);

                method.invoke(_lfCertificateTincanStatementRemoteModel, period);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFCertificateTincanStatementRemoteModel() {
        return _lfCertificateTincanStatementRemoteModel;
    }

    public void setLFCertificateTincanStatementRemoteModel(
        BaseModel<?> lfCertificateTincanStatementRemoteModel) {
        _lfCertificateTincanStatementRemoteModel = lfCertificateTincanStatementRemoteModel;
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

        Class<?> remoteModelClass = _lfCertificateTincanStatementRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfCertificateTincanStatementRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFCertificateTincanStatementLocalServiceUtil.addLFCertificateTincanStatement(this);
        } else {
            LFCertificateTincanStatementLocalServiceUtil.updateLFCertificateTincanStatement(this);
        }
    }

    @Override
    public LFCertificateTincanStatement toEscapedModel() {
        return (LFCertificateTincanStatement) ProxyUtil.newProxyInstance(LFCertificateTincanStatement.class.getClassLoader(),
            new Class[] { LFCertificateTincanStatement.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFCertificateTincanStatementClp clone = new LFCertificateTincanStatementClp();

        clone.setCertificateID(getCertificateID());
        clone.setVerb(getVerb());
        clone.setObject(getObject());
        clone.setPeriodType(getPeriodType());
        clone.setPeriod(getPeriod());

        return clone;
    }

    @Override
    public int compareTo(
        LFCertificateTincanStatement lfCertificateTincanStatement) {
        LFCertificateTincanStatementPK primaryKey = lfCertificateTincanStatement.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateTincanStatementClp)) {
            return false;
        }

        LFCertificateTincanStatementClp lfCertificateTincanStatement = (LFCertificateTincanStatementClp) obj;

        LFCertificateTincanStatementPK primaryKey = lfCertificateTincanStatement.getPrimaryKey();

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
        sb.append(", verb=");
        sb.append(getVerb());
        sb.append(", object=");
        sb.append(getObject());
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
            "com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>certificateID</column-name><column-value><![CDATA[");
        sb.append(getCertificateID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>verb</column-name><column-value><![CDATA[");
        sb.append(getVerb());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>object</column-name><column-value><![CDATA[");
        sb.append(getObject());
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
