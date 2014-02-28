package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalServiceUtil;

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


public class LFCertificateUserClp extends BaseModelImpl<LFCertificateUser>
    implements LFCertificateUser {
    private long _id;
    private Integer _certificateID;
    private Integer _userID;
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
        attributes.put("certificateID", getCertificateID());
        attributes.put("userID", getUserID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer certificateID = (Integer) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        Integer userID = (Integer) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfCertificateUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateUserRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfCertificateUserRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getCertificateID() {
        return _certificateID;
    }

    @Override
    public void setCertificateID(Integer certificateID) {
        _certificateID = certificateID;

        if (_lfCertificateUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateUserRemoteModel.getClass();

                Method method = clazz.getMethod("setCertificateID",
                        Integer.class);

                method.invoke(_lfCertificateUserRemoteModel, certificateID);
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

        if (_lfCertificateUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfCertificateUserRemoteModel.getClass();

                Method method = clazz.getMethod("setUserID", Integer.class);

                method.invoke(_lfCertificateUserRemoteModel, userID);
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

        clone.setId(getId());
        clone.setCertificateID(getCertificateID());
        clone.setUserID(getUserID());

        return clone;
    }

    @Override
    public int compareTo(LFCertificateUser lfCertificateUser) {
        long primaryKey = lfCertificateUser.getPrimaryKey();

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

        if (!(obj instanceof LFCertificateUserClp)) {
            return false;
        }

        LFCertificateUserClp lfCertificateUser = (LFCertificateUserClp) obj;

        long primaryKey = lfCertificateUser.getPrimaryKey();

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
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", certificateID=");
        sb.append(getCertificateID());
        sb.append(", userID=");
        sb.append(getUserID());
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
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>certificateID</column-name><column-value><![CDATA[");
        sb.append(getCertificateID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userID</column-name><column-value><![CDATA[");
        sb.append(getUserID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
