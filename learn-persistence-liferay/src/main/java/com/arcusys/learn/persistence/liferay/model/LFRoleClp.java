package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFRoleLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

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

    public Class<?> getModelClass() {
        return LFRole.class;
    }

    public String getModelClassName() {
        return LFRole.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getLiferayRoleID() {
        return _liferayRoleID;
    }

    public void setLiferayRoleID(Integer liferayRoleID) {
        _liferayRoleID = liferayRoleID;
    }

    public String getPermission() {
        return _permission;
    }

    public void setPermission(String permission) {
        _permission = permission;
    }

    public Boolean getIsDefault() {
        return _isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        _isDefault = isDefault;
    }

    public BaseModel<?> getLFRoleRemoteModel() {
        return _lfRoleRemoteModel;
    }

    public void setLFRoleRemoteModel(BaseModel<?> lfRoleRemoteModel) {
        _lfRoleRemoteModel = lfRoleRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFRoleLocalServiceUtil.addLFRole(this);
        } else {
            LFRoleLocalServiceUtil.updateLFRole(this);
        }
    }

    @Override
    public LFRole toEscapedModel() {
        return (LFRole) Proxy.newProxyInstance(LFRole.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFRoleClp lfRole = null;

        try {
            lfRole = (LFRoleClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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
