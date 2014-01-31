package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFSocialPackageTagLocalServiceUtil;

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


public class LFSocialPackageTagClp extends BaseModelImpl<LFSocialPackageTag>
    implements LFSocialPackageTag {
    private long _id;
    private Integer _socialPackageID;
    private String _name;
    private BaseModel<?> _lfSocialPackageTagRemoteModel;

    public LFSocialPackageTagClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFSocialPackageTag.class;
    }

    @Override
    public String getModelClassName() {
        return LFSocialPackageTag.class.getName();
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
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer socialPackageID = (Integer) attributes.get("socialPackageID");

        if (socialPackageID != null) {
            setSocialPackageID(socialPackageID);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfSocialPackageTagRemoteModel != null) {
            try {
                Class<?> clazz = _lfSocialPackageTagRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfSocialPackageTagRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getSocialPackageID() {
        return _socialPackageID;
    }

    @Override
    public void setSocialPackageID(Integer socialPackageID) {
        _socialPackageID = socialPackageID;

        if (_lfSocialPackageTagRemoteModel != null) {
            try {
                Class<?> clazz = _lfSocialPackageTagRemoteModel.getClass();

                Method method = clazz.getMethod("setSocialPackageID",
                        Integer.class);

                method.invoke(_lfSocialPackageTagRemoteModel, socialPackageID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_lfSocialPackageTagRemoteModel != null) {
            try {
                Class<?> clazz = _lfSocialPackageTagRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_lfSocialPackageTagRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFSocialPackageTagRemoteModel() {
        return _lfSocialPackageTagRemoteModel;
    }

    public void setLFSocialPackageTagRemoteModel(
        BaseModel<?> lfSocialPackageTagRemoteModel) {
        _lfSocialPackageTagRemoteModel = lfSocialPackageTagRemoteModel;
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

        Class<?> remoteModelClass = _lfSocialPackageTagRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfSocialPackageTagRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSocialPackageTagLocalServiceUtil.addLFSocialPackageTag(this);
        } else {
            LFSocialPackageTagLocalServiceUtil.updateLFSocialPackageTag(this);
        }
    }

    @Override
    public LFSocialPackageTag toEscapedModel() {
        return (LFSocialPackageTag) ProxyUtil.newProxyInstance(LFSocialPackageTag.class.getClassLoader(),
            new Class[] { LFSocialPackageTag.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSocialPackageTagClp clone = new LFSocialPackageTagClp();

        clone.setId(getId());
        clone.setSocialPackageID(getSocialPackageID());
        clone.setName(getName());

        return clone;
    }

    @Override
    public int compareTo(LFSocialPackageTag lfSocialPackageTag) {
        long primaryKey = lfSocialPackageTag.getPrimaryKey();

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

        if (!(obj instanceof LFSocialPackageTagClp)) {
            return false;
        }

        LFSocialPackageTagClp lfSocialPackageTag = (LFSocialPackageTagClp) obj;

        long primaryKey = lfSocialPackageTag.getPrimaryKey();

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
        sb.append(", socialPackageID=");
        sb.append(getSocialPackageID());
        sb.append(", name=");
        sb.append(getName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>socialPackageID</column-name><column-value><![CDATA[");
        sb.append(getSocialPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
