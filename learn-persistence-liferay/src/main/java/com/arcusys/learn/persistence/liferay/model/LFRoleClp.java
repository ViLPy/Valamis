package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFRoleLocalServiceUtil;

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


public class LFRoleClp extends BaseModelImpl<LFRole> implements LFRole {
    private long _id;
    private Integer _liferayRoleID;
    private String _permission;
    private Boolean _isDefault;
    private BaseModel<?> _lfRoleRemoteModel;

    public LFRoleClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFRole.class;
    }

    @Override
    public String getModelClassName() {
        return LFRole.class.getName();
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
        attributes.put("liferayRoleID", getLiferayRoleID());
        attributes.put("permission", getPermission());
        attributes.put("isDefault", getIsDefault());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer liferayRoleID = (Integer) attributes.get("liferayRoleID");

        if (liferayRoleID != null) {
            setLiferayRoleID(liferayRoleID);
        }

        String permission = (String) attributes.get("permission");

        if (permission != null) {
            setPermission(permission);
        }

        Boolean isDefault = (Boolean) attributes.get("isDefault");

        if (isDefault != null) {
            setIsDefault(isDefault);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfRoleRemoteModel != null) {
            try {
                Class<?> clazz = _lfRoleRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfRoleRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getLiferayRoleID() {
        return _liferayRoleID;
    }

    @Override
    public void setLiferayRoleID(Integer liferayRoleID) {
        _liferayRoleID = liferayRoleID;

        if (_lfRoleRemoteModel != null) {
            try {
                Class<?> clazz = _lfRoleRemoteModel.getClass();

                Method method = clazz.getMethod("setLiferayRoleID",
                        Integer.class);

                method.invoke(_lfRoleRemoteModel, liferayRoleID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPermission() {
        return _permission;
    }

    @Override
    public void setPermission(String permission) {
        _permission = permission;

        if (_lfRoleRemoteModel != null) {
            try {
                Class<?> clazz = _lfRoleRemoteModel.getClass();

                Method method = clazz.getMethod("setPermission", String.class);

                method.invoke(_lfRoleRemoteModel, permission);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getIsDefault() {
        return _isDefault;
    }

    @Override
    public void setIsDefault(Boolean isDefault) {
        _isDefault = isDefault;

        if (_lfRoleRemoteModel != null) {
            try {
                Class<?> clazz = _lfRoleRemoteModel.getClass();

                Method method = clazz.getMethod("setIsDefault", Boolean.class);

                method.invoke(_lfRoleRemoteModel, isDefault);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFRoleRemoteModel() {
        return _lfRoleRemoteModel;
    }

    public void setLFRoleRemoteModel(BaseModel<?> lfRoleRemoteModel) {
        _lfRoleRemoteModel = lfRoleRemoteModel;
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

        Class<?> remoteModelClass = _lfRoleRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfRoleRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFRoleLocalServiceUtil.addLFRole(this);
        } else {
            LFRoleLocalServiceUtil.updateLFRole(this);
        }
    }

    @Override
    public LFRole toEscapedModel() {
        return (LFRole) ProxyUtil.newProxyInstance(LFRole.class.getClassLoader(),
            new Class[] { LFRole.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFRoleClp clone = new LFRoleClp();

        clone.setId(getId());
        clone.setLiferayRoleID(getLiferayRoleID());
        clone.setPermission(getPermission());
        clone.setIsDefault(getIsDefault());

        return clone;
    }

    @Override
    public int compareTo(LFRole lfRole) {
        long primaryKey = lfRole.getPrimaryKey();

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

        if (!(obj instanceof LFRoleClp)) {
            return false;
        }

        LFRoleClp lfRole = (LFRoleClp) obj;

        long primaryKey = lfRole.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", liferayRoleID=");
        sb.append(getLiferayRoleID());
        sb.append(", permission=");
        sb.append(getPermission());
        sb.append(", isDefault=");
        sb.append(getIsDefault());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFRole");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>liferayRoleID</column-name><column-value><![CDATA[");
        sb.append(getLiferayRoleID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>permission</column-name><column-value><![CDATA[");
        sb.append(getPermission());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isDefault</column-name><column-value><![CDATA[");
        sb.append(getIsDefault());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
