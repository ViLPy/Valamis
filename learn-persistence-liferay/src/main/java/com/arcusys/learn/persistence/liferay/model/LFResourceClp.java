package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFResourceLocalServiceUtil;

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


public class LFResourceClp extends BaseModelImpl<LFResource>
    implements LFResource {
    private long _id;
    private Integer _packageID;
    private String _scormType;
    private String _resourceID;
    private String _href;
    private String _base;
    private BaseModel<?> _lfResourceRemoteModel;

    public LFResourceClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFResource.class;
    }

    @Override
    public String getModelClassName() {
        return LFResource.class.getName();
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
        attributes.put("packageID", getPackageID());
        attributes.put("scormType", getScormType());
        attributes.put("resourceID", getResourceID());
        attributes.put("href", getHref());
        attributes.put("base", getBase());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String scormType = (String) attributes.get("scormType");

        if (scormType != null) {
            setScormType(scormType);
        }

        String resourceID = (String) attributes.get("resourceID");

        if (resourceID != null) {
            setResourceID(resourceID);
        }

        String href = (String) attributes.get("href");

        if (href != null) {
            setHref(href);
        }

        String base = (String) attributes.get("base");

        if (base != null) {
            setBase(base);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfResourceRemoteModel != null) {
            try {
                Class<?> clazz = _lfResourceRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfResourceRemoteModel, id);
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

        if (_lfResourceRemoteModel != null) {
            try {
                Class<?> clazz = _lfResourceRemoteModel.getClass();

                Method method = clazz.getMethod("setPackageID", Integer.class);

                method.invoke(_lfResourceRemoteModel, packageID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getScormType() {
        return _scormType;
    }

    @Override
    public void setScormType(String scormType) {
        _scormType = scormType;

        if (_lfResourceRemoteModel != null) {
            try {
                Class<?> clazz = _lfResourceRemoteModel.getClass();

                Method method = clazz.getMethod("setScormType", String.class);

                method.invoke(_lfResourceRemoteModel, scormType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getResourceID() {
        return _resourceID;
    }

    @Override
    public void setResourceID(String resourceID) {
        _resourceID = resourceID;

        if (_lfResourceRemoteModel != null) {
            try {
                Class<?> clazz = _lfResourceRemoteModel.getClass();

                Method method = clazz.getMethod("setResourceID", String.class);

                method.invoke(_lfResourceRemoteModel, resourceID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getHref() {
        return _href;
    }

    @Override
    public void setHref(String href) {
        _href = href;

        if (_lfResourceRemoteModel != null) {
            try {
                Class<?> clazz = _lfResourceRemoteModel.getClass();

                Method method = clazz.getMethod("setHref", String.class);

                method.invoke(_lfResourceRemoteModel, href);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBase() {
        return _base;
    }

    @Override
    public void setBase(String base) {
        _base = base;

        if (_lfResourceRemoteModel != null) {
            try {
                Class<?> clazz = _lfResourceRemoteModel.getClass();

                Method method = clazz.getMethod("setBase", String.class);

                method.invoke(_lfResourceRemoteModel, base);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFResourceRemoteModel() {
        return _lfResourceRemoteModel;
    }

    public void setLFResourceRemoteModel(BaseModel<?> lfResourceRemoteModel) {
        _lfResourceRemoteModel = lfResourceRemoteModel;
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

        Class<?> remoteModelClass = _lfResourceRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfResourceRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFResourceLocalServiceUtil.addLFResource(this);
        } else {
            LFResourceLocalServiceUtil.updateLFResource(this);
        }
    }

    @Override
    public LFResource toEscapedModel() {
        return (LFResource) ProxyUtil.newProxyInstance(LFResource.class.getClassLoader(),
            new Class[] { LFResource.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFResourceClp clone = new LFResourceClp();

        clone.setId(getId());
        clone.setPackageID(getPackageID());
        clone.setScormType(getScormType());
        clone.setResourceID(getResourceID());
        clone.setHref(getHref());
        clone.setBase(getBase());

        return clone;
    }

    @Override
    public int compareTo(LFResource lfResource) {
        long primaryKey = lfResource.getPrimaryKey();

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

        if (!(obj instanceof LFResourceClp)) {
            return false;
        }

        LFResourceClp lfResource = (LFResourceClp) obj;

        long primaryKey = lfResource.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", scormType=");
        sb.append(getScormType());
        sb.append(", resourceID=");
        sb.append(getResourceID());
        sb.append(", href=");
        sb.append(getHref());
        sb.append(", base=");
        sb.append(getBase());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFResource");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>packageID</column-name><column-value><![CDATA[");
        sb.append(getPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>scormType</column-name><column-value><![CDATA[");
        sb.append(getScormType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resourceID</column-name><column-value><![CDATA[");
        sb.append(getResourceID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>href</column-name><column-value><![CDATA[");
        sb.append(getHref());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>base</column-name><column-value><![CDATA[");
        sb.append(getBase());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
