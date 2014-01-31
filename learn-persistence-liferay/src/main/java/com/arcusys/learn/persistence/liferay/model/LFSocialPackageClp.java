package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFSocialPackageLocalServiceUtil;

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


public class LFSocialPackageClp extends BaseModelImpl<LFSocialPackage>
    implements LFSocialPackage {
    private long _id;
    private Integer _packageID;
    private String _aboutPackage;
    private Date _publishDate;
    private Integer _authorID;
    private BaseModel<?> _lfSocialPackageRemoteModel;

    public LFSocialPackageClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFSocialPackage.class;
    }

    @Override
    public String getModelClassName() {
        return LFSocialPackage.class.getName();
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
        attributes.put("aboutPackage", getAboutPackage());
        attributes.put("publishDate", getPublishDate());
        attributes.put("authorID", getAuthorID());

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

        String aboutPackage = (String) attributes.get("aboutPackage");

        if (aboutPackage != null) {
            setAboutPackage(aboutPackage);
        }

        Date publishDate = (Date) attributes.get("publishDate");

        if (publishDate != null) {
            setPublishDate(publishDate);
        }

        Integer authorID = (Integer) attributes.get("authorID");

        if (authorID != null) {
            setAuthorID(authorID);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfSocialPackageRemoteModel != null) {
            try {
                Class<?> clazz = _lfSocialPackageRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfSocialPackageRemoteModel, id);
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

        if (_lfSocialPackageRemoteModel != null) {
            try {
                Class<?> clazz = _lfSocialPackageRemoteModel.getClass();

                Method method = clazz.getMethod("setPackageID", Integer.class);

                method.invoke(_lfSocialPackageRemoteModel, packageID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAboutPackage() {
        return _aboutPackage;
    }

    @Override
    public void setAboutPackage(String aboutPackage) {
        _aboutPackage = aboutPackage;

        if (_lfSocialPackageRemoteModel != null) {
            try {
                Class<?> clazz = _lfSocialPackageRemoteModel.getClass();

                Method method = clazz.getMethod("setAboutPackage", String.class);

                method.invoke(_lfSocialPackageRemoteModel, aboutPackage);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getPublishDate() {
        return _publishDate;
    }

    @Override
    public void setPublishDate(Date publishDate) {
        _publishDate = publishDate;

        if (_lfSocialPackageRemoteModel != null) {
            try {
                Class<?> clazz = _lfSocialPackageRemoteModel.getClass();

                Method method = clazz.getMethod("setPublishDate", Date.class);

                method.invoke(_lfSocialPackageRemoteModel, publishDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getAuthorID() {
        return _authorID;
    }

    @Override
    public void setAuthorID(Integer authorID) {
        _authorID = authorID;

        if (_lfSocialPackageRemoteModel != null) {
            try {
                Class<?> clazz = _lfSocialPackageRemoteModel.getClass();

                Method method = clazz.getMethod("setAuthorID", Integer.class);

                method.invoke(_lfSocialPackageRemoteModel, authorID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFSocialPackageRemoteModel() {
        return _lfSocialPackageRemoteModel;
    }

    public void setLFSocialPackageRemoteModel(
        BaseModel<?> lfSocialPackageRemoteModel) {
        _lfSocialPackageRemoteModel = lfSocialPackageRemoteModel;
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

        Class<?> remoteModelClass = _lfSocialPackageRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfSocialPackageRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSocialPackageLocalServiceUtil.addLFSocialPackage(this);
        } else {
            LFSocialPackageLocalServiceUtil.updateLFSocialPackage(this);
        }
    }

    @Override
    public LFSocialPackage toEscapedModel() {
        return (LFSocialPackage) ProxyUtil.newProxyInstance(LFSocialPackage.class.getClassLoader(),
            new Class[] { LFSocialPackage.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSocialPackageClp clone = new LFSocialPackageClp();

        clone.setId(getId());
        clone.setPackageID(getPackageID());
        clone.setAboutPackage(getAboutPackage());
        clone.setPublishDate(getPublishDate());
        clone.setAuthorID(getAuthorID());

        return clone;
    }

    @Override
    public int compareTo(LFSocialPackage lfSocialPackage) {
        long primaryKey = lfSocialPackage.getPrimaryKey();

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

        if (!(obj instanceof LFSocialPackageClp)) {
            return false;
        }

        LFSocialPackageClp lfSocialPackage = (LFSocialPackageClp) obj;

        long primaryKey = lfSocialPackage.getPrimaryKey();

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
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", aboutPackage=");
        sb.append(getAboutPackage());
        sb.append(", publishDate=");
        sb.append(getPublishDate());
        sb.append(", authorID=");
        sb.append(getAuthorID());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFSocialPackage");
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
            "<column><column-name>aboutPackage</column-name><column-value><![CDATA[");
        sb.append(getAboutPackage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>publishDate</column-name><column-value><![CDATA[");
        sb.append(getPublishDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorID</column-name><column-value><![CDATA[");
        sb.append(getAuthorID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
