package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFCertificateToUserLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK;

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


public class LFCertificateToUserClp extends BaseModelImpl<LFCertificateToUser>
    implements LFCertificateToUser {
    private Integer _certificateID;
    private Integer _userID;
    private String _status;
    private Date _addedToUserDate;
    private BaseModel<?> _lfCertificateToUserRemoteModel;

    public LFCertificateToUserClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificateToUser.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificateToUser.class.getName();
    }

    @Override
    public LFCertificateToUserPK getPrimaryKey() {
        return new LFCertificateToUserPK(_certificateID, _userID);
    }

    @Override
    public void setPrimaryKey(LFCertificateToUserPK primaryKey) {
        setCertificateID(primaryKey.certificateID);
        setUserID(primaryKey.userID);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new LFCertificateToUserPK(_certificateID, _userID);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((LFCertificateToUserPK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("certificateID", getCertificateID());
        attributes.put("userID", getUserID());
        attributes.put("status", getStatus());
        attributes.put("addedToUserDate", getAddedToUserDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer certificateID = (Integer) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        Integer userID = (Integer) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Date addedToUserDate = (Date) attributes.get("addedToUserDate");

        if (addedToUserDate != null) {
            setAddedToUserDate(addedToUserDate);
        }
    }

    @Override
    public Integer getCertificateID() {
        return _certificateID;
    }

    @Override
    public void setCertificateID(Integer certificateID) {
        _certificateID = certificateID;

        if (_lfCertificateToUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateToUserRemoteModel.getClass();

                Method method = clazz.getMethod("setCertificateID",
                        Integer.class);

                method.invoke(_lfCertificateToUserRemoteModel, certificateID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getUserID() {
        return _userID;
    }

    @Override
    public void setUserID(Integer userID) {
        _userID = userID;

        if (_lfCertificateToUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateToUserRemoteModel.getClass();

                Method method = clazz.getMethod("setUserID", Integer.class);

                method.invoke(_lfCertificateToUserRemoteModel, userID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatus() {
        return _status;
    }

    @Override
    public void setStatus(String status) {
        _status = status;

        if (_lfCertificateToUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateToUserRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", String.class);

                method.invoke(_lfCertificateToUserRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getAddedToUserDate() {
        return _addedToUserDate;
    }

    @Override
    public void setAddedToUserDate(Date addedToUserDate) {
        _addedToUserDate = addedToUserDate;

        if (_lfCertificateToUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateToUserRemoteModel.getClass();

                Method method = clazz.getMethod("setAddedToUserDate", Date.class);

                method.invoke(_lfCertificateToUserRemoteModel, addedToUserDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFCertificateToUserRemoteModel() {
        return _lfCertificateToUserRemoteModel;
    }

    public void setLFCertificateToUserRemoteModel(
        BaseModel<?> lfCertificateToUserRemoteModel) {
        _lfCertificateToUserRemoteModel = lfCertificateToUserRemoteModel;
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

        Class<?> remoteModelClass = _lfCertificateToUserRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfCertificateToUserRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFCertificateToUserLocalServiceUtil.addLFCertificateToUser(this);
        } else {
            LFCertificateToUserLocalServiceUtil.updateLFCertificateToUser(this);
        }
    }

    @Override
    public LFCertificateToUser toEscapedModel() {
        return (LFCertificateToUser) ProxyUtil.newProxyInstance(LFCertificateToUser.class.getClassLoader(),
            new Class[] { LFCertificateToUser.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFCertificateToUserClp clone = new LFCertificateToUserClp();

        clone.setCertificateID(getCertificateID());
        clone.setUserID(getUserID());
        clone.setStatus(getStatus());
        clone.setAddedToUserDate(getAddedToUserDate());

        return clone;
    }

    @Override
    public int compareTo(LFCertificateToUser lfCertificateToUser) {
        LFCertificateToUserPK primaryKey = lfCertificateToUser.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateToUserClp)) {
            return false;
        }

        LFCertificateToUserClp lfCertificateToUser = (LFCertificateToUserClp) obj;

        LFCertificateToUserPK primaryKey = lfCertificateToUser.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{certificateID=");
        sb.append(getCertificateID());
        sb.append(", userID=");
        sb.append(getUserID());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", addedToUserDate=");
        sb.append(getAddedToUserDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFCertificateToUser");
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
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>addedToUserDate</column-name><column-value><![CDATA[");
        sb.append(getAddedToUserDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
