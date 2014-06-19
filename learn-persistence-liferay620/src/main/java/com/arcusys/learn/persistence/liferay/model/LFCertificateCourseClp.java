package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFCertificateCourseLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateCoursePK;

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


public class LFCertificateCourseClp extends BaseModelImpl<LFCertificateCourse>
    implements LFCertificateCourse {
    private Long _certificateID;
    private Long _courseID;
    private Integer _arrangementIndex;
    private String _periodType;
    private Integer _period;
    private BaseModel<?> _lfCertificateCourseRemoteModel;

    public LFCertificateCourseClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificateCourse.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificateCourse.class.getName();
    }

    @Override
    public LFCertificateCoursePK getPrimaryKey() {
        return new LFCertificateCoursePK(_certificateID, _courseID);
    }

    @Override
    public void setPrimaryKey(LFCertificateCoursePK primaryKey) {
        setCertificateID(primaryKey.certificateID);
        setCourseID(primaryKey.courseID);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new LFCertificateCoursePK(_certificateID, _courseID);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((LFCertificateCoursePK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("certificateID", getCertificateID());
        attributes.put("courseID", getCourseID());
        attributes.put("arrangementIndex", getArrangementIndex());
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

        Long courseID = (Long) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
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

        if (_lfCertificateCourseRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateCourseRemoteModel.getClass();

                Method method = clazz.getMethod("setCertificateID", Long.class);

                method.invoke(_lfCertificateCourseRemoteModel, certificateID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getCourseID() {
        return _courseID;
    }

    @Override
    public void setCourseID(Long courseID) {
        _courseID = courseID;

        if (_lfCertificateCourseRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateCourseRemoteModel.getClass();

                Method method = clazz.getMethod("setCourseID", Long.class);

                method.invoke(_lfCertificateCourseRemoteModel, courseID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getArrangementIndex() {
        return _arrangementIndex;
    }

    @Override
    public void setArrangementIndex(Integer arrangementIndex) {
        _arrangementIndex = arrangementIndex;

        if (_lfCertificateCourseRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateCourseRemoteModel.getClass();

                Method method = clazz.getMethod("setArrangementIndex",
                        Integer.class);

                method.invoke(_lfCertificateCourseRemoteModel, arrangementIndex);
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

        if (_lfCertificateCourseRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateCourseRemoteModel.getClass();

                Method method = clazz.getMethod("setPeriodType", String.class);

                method.invoke(_lfCertificateCourseRemoteModel, periodType);
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

        if (_lfCertificateCourseRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateCourseRemoteModel.getClass();

                Method method = clazz.getMethod("setPeriod", Integer.class);

                method.invoke(_lfCertificateCourseRemoteModel, period);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFCertificateCourseRemoteModel() {
        return _lfCertificateCourseRemoteModel;
    }

    public void setLFCertificateCourseRemoteModel(
        BaseModel<?> lfCertificateCourseRemoteModel) {
        _lfCertificateCourseRemoteModel = lfCertificateCourseRemoteModel;
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

        Class<?> remoteModelClass = _lfCertificateCourseRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfCertificateCourseRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFCertificateCourseLocalServiceUtil.addLFCertificateCourse(this);
        } else {
            LFCertificateCourseLocalServiceUtil.updateLFCertificateCourse(this);
        }
    }

    @Override
    public LFCertificateCourse toEscapedModel() {
        return (LFCertificateCourse) ProxyUtil.newProxyInstance(LFCertificateCourse.class.getClassLoader(),
            new Class[] { LFCertificateCourse.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFCertificateCourseClp clone = new LFCertificateCourseClp();

        clone.setCertificateID(getCertificateID());
        clone.setCourseID(getCourseID());
        clone.setArrangementIndex(getArrangementIndex());
        clone.setPeriodType(getPeriodType());
        clone.setPeriod(getPeriod());

        return clone;
    }

    @Override
    public int compareTo(LFCertificateCourse lfCertificateCourse) {
        LFCertificateCoursePK primaryKey = lfCertificateCourse.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateCourseClp)) {
            return false;
        }

        LFCertificateCourseClp lfCertificateCourse = (LFCertificateCourseClp) obj;

        LFCertificateCoursePK primaryKey = lfCertificateCourse.getPrimaryKey();

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
        sb.append(", courseID=");
        sb.append(getCourseID());
        sb.append(", arrangementIndex=");
        sb.append(getArrangementIndex());
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
            "com.arcusys.learn.persistence.liferay.model.LFCertificateCourse");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>certificateID</column-name><column-value><![CDATA[");
        sb.append(getCertificateID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courseID</column-name><column-value><![CDATA[");
        sb.append(getCourseID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>arrangementIndex</column-name><column-value><![CDATA[");
        sb.append(getArrangementIndex());
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
