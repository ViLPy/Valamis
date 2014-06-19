package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class LFCertificateUserClp extends BaseModelImpl<LFCertificateUser>
    implements LFCertificateUser {
    private Long _certificateID;
    private Long _userID;
    private Date _attachedDate;
    private BaseModel<?> _lfCertificateUserRemoteModel;

    public LFCertificateUserClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificateUser.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificateUser.class.getName();
    }

    @Override
    public LFCertificateUserPK getPrimaryKey() {
        return new LFCertificateUserPK(_certificateID, _userID);
    }

    @Override
    public void setPrimaryKey(LFCertificateUserPK primaryKey) {
        setCertificateID(primaryKey.certificateID);
        setUserID(primaryKey.userID);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new LFCertificateUserPK(_certificateID, _userID);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((LFCertificateUserPK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("certificateID", getCertificateID());
        attributes.put("userID", getUserID());
        attributes.put("attachedDate", getAttachedDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long certificateID = (Long) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        Long userID = (Long) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }

        Date attachedDate = (Date) attributes.get("attachedDate");

        if (attachedDate != null) {
            setAttachedDate(attachedDate);
        }
    }

    @Override
    public Long getCertificateID() {
        return _certificateID;
    }

    @Override
    public void setCertificateID(Long certificateID) {
        _certificateID = certificateID;

        if (_lfCertificateUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateUserRemoteModel.getClass();

                Method method = clazz.getMethod("setCertificateID", Long.class);

                method.invoke(_lfCertificateUserRemoteModel, certificateID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getUserID() {
        return _userID;
    }

    @Override
    public void setUserID(Long userID) {
        _userID = userID;

        if (_lfCertificateUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateUserRemoteModel.getClass();

                Method method = clazz.getMethod("setUserID", Long.class);

                method.invoke(_lfCertificateUserRemoteModel, userID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getAttachedDate() {
        return _attachedDate;
    }

    @Override
    public void setAttachedDate(Date attachedDate) {
        _attachedDate = attachedDate;

        if (_lfCertificateUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateUserRemoteModel.getClass();

                Method method = clazz.getMethod("setAttachedDate", Date.class);

                method.invoke(_lfCertificateUserRemoteModel, attachedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFCertificateUserRemoteModel() {
        return _lfCertificateUserRemoteModel;
    }

    public void setLFCertificateUserRemoteModel(
        BaseModel<?> lfCertificateUserRemoteModel) {
        _lfCertificateUserRemoteModel = lfCertificateUserRemoteModel;
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

        Class<?> remoteModelClass = _lfCertificateUserRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfCertificateUserRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFCertificateUserLocalServiceUtil.addLFCertificateUser(this);
        } else {
            LFCertificateUserLocalServiceUtil.updateLFCertificateUser(this);
        }
    }

    @Override
    public LFCertificateUser toEscapedModel() {
        return (LFCertificateUser) ProxyUtil.newProxyInstance(LFCertificateUser.class.getClassLoader(),
            new Class[] { LFCertificateUser.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFCertificateUserClp clone = new LFCertificateUserClp();

        clone.setCertificateID(getCertificateID());
        clone.setUserID(getUserID());
        clone.setAttachedDate(getAttachedDate());

        return clone;
    }

    @Override
    public int compareTo(LFCertificateUser lfCertificateUser) {
        LFCertificateUserPK primaryKey = lfCertificateUser.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateUserClp)) {
            return false;
        }

        LFCertificateUserClp lfCertificateUser = (LFCertificateUserClp) obj;

        LFCertificateUserPK primaryKey = lfCertificateUser.getPrimaryKey();

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
        StringBundler sb = new StringBundler(7);

        sb.append("{certificateID=");
        sb.append(getCertificateID());
        sb.append(", userID=");
        sb.append(getUserID());
        sb.append(", attachedDate=");
        sb.append(getAttachedDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFCertificateUser");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>certificateID</column-name><column-value><![CDATA[");
        sb.append(getCertificateID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userID</column-name><column-value><![CDATA[");
        sb.append(getUserID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attachedDate</column-name><column-value><![CDATA[");
        sb.append(getAttachedDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
