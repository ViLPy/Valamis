package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFAttemptLocalServiceUtil;

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


public class LFAttemptClp extends BaseModelImpl<LFAttempt> implements LFAttempt {
    private long _id;
    private Integer _userID;
    private Integer _packageID;
    private String _organizationID;
    private Boolean _isComplete;
    private BaseModel<?> _lfAttemptRemoteModel;

    public LFAttemptClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFAttempt.class;
    }

    @Override
    public String getModelClassName() {
        return LFAttempt.class.getName();
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
        attributes.put("userID", getUserID());
        attributes.put("packageID", getPackageID());
        attributes.put("organizationID", getOrganizationID());
        attributes.put("isComplete", getIsComplete());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer userID = (Integer) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String organizationID = (String) attributes.get("organizationID");

        if (organizationID != null) {
            setOrganizationID(organizationID);
        }

        Boolean isComplete = (Boolean) attributes.get("isComplete");

        if (isComplete != null) {
            setIsComplete(isComplete);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfAttemptRemoteModel != null) {
            try {
                Class<?> clazz = _lfAttemptRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfAttemptRemoteModel, id);
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

        if (_lfAttemptRemoteModel != null) {
            try {
                Class<?> clazz = _lfAttemptRemoteModel.getClass();

                Method method = clazz.getMethod("setUserID", Integer.class);

                method.invoke(_lfAttemptRemoteModel, userID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getPackageID() {
        return _packageID;
    }

    @Override
    public void setPackageID(Integer packageID) {
        _packageID = packageID;

        if (_lfAttemptRemoteModel != null) {
            try {
                Class<?> clazz = _lfAttemptRemoteModel.getClass();

                Method method = clazz.getMethod("setPackageID", Integer.class);

                method.invoke(_lfAttemptRemoteModel, packageID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOrganizationID() {
        return _organizationID;
    }

    @Override
    public void setOrganizationID(String organizationID) {
        _organizationID = organizationID;

        if (_lfAttemptRemoteModel != null) {
            try {
                Class<?> clazz = _lfAttemptRemoteModel.getClass();

                Method method = clazz.getMethod("setOrganizationID",
                        String.class);

                method.invoke(_lfAttemptRemoteModel, organizationID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getIsComplete() {
        return _isComplete;
    }

    @Override
    public void setIsComplete(Boolean isComplete) {
        _isComplete = isComplete;

        if (_lfAttemptRemoteModel != null) {
            try {
                Class<?> clazz = _lfAttemptRemoteModel.getClass();

                Method method = clazz.getMethod("setIsComplete", Boolean.class);

                method.invoke(_lfAttemptRemoteModel, isComplete);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFAttemptRemoteModel() {
        return _lfAttemptRemoteModel;
    }

    public void setLFAttemptRemoteModel(BaseModel<?> lfAttemptRemoteModel) {
        _lfAttemptRemoteModel = lfAttemptRemoteModel;
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

        Class<?> remoteModelClass = _lfAttemptRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfAttemptRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFAttemptLocalServiceUtil.addLFAttempt(this);
        } else {
            LFAttemptLocalServiceUtil.updateLFAttempt(this);
        }
    }

    @Override
    public LFAttempt toEscapedModel() {
        return (LFAttempt) ProxyUtil.newProxyInstance(LFAttempt.class.getClassLoader(),
            new Class[] { LFAttempt.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFAttemptClp clone = new LFAttemptClp();

        clone.setId(getId());
        clone.setUserID(getUserID());
        clone.setPackageID(getPackageID());
        clone.setOrganizationID(getOrganizationID());
        clone.setIsComplete(getIsComplete());

        return clone;
    }

    @Override
    public int compareTo(LFAttempt lfAttempt) {
        long primaryKey = lfAttempt.getPrimaryKey();

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

        if (!(obj instanceof LFAttemptClp)) {
            return false;
        }

        LFAttemptClp lfAttempt = (LFAttemptClp) obj;

        long primaryKey = lfAttempt.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", userID=");
        sb.append(getUserID());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", organizationID=");
        sb.append(getOrganizationID());
        sb.append(", isComplete=");
        sb.append(getIsComplete());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFAttempt");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userID</column-name><column-value><![CDATA[");
        sb.append(getUserID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>packageID</column-name><column-value><![CDATA[");
        sb.append(getPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>organizationID</column-name><column-value><![CDATA[");
        sb.append(getOrganizationID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isComplete</column-name><column-value><![CDATA[");
        sb.append(getIsComplete());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
