package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalServiceUtil;

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


public class LFTincanPackageClp extends BaseModelImpl<LFTincanPackage>
    implements LFTincanPackage {
    private long _id;
    private String _title;
    private String _summary;
    private Long _assetRefID;
    private Integer _courseID;
    private String _logo;
    private BaseModel<?> _lfTincanPackageRemoteModel;

    public LFTincanPackageClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanPackage.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanPackage.class.getName();
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
        attributes.put("title", getTitle());
        attributes.put("summary", getSummary());
        attributes.put("assetRefID", getAssetRefID());
        attributes.put("courseID", getCourseID());
        attributes.put("logo", getLogo());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String summary = (String) attributes.get("summary");

        if (summary != null) {
            setSummary(summary);
        }

        Long assetRefID = (Long) attributes.get("assetRefID");

        if (assetRefID != null) {
            setAssetRefID(assetRefID);
        }

        Integer courseID = (Integer) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }

        String logo = (String) attributes.get("logo");

        if (logo != null) {
            setLogo(logo);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanPackageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanPackageRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanPackageRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_lfTincanPackageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanPackageRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_lfTincanPackageRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSummary() {
        return _summary;
    }

    @Override
    public void setSummary(String summary) {
        _summary = summary;

        if (_lfTincanPackageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanPackageRemoteModel.getClass();

                Method method = clazz.getMethod("setSummary", String.class);

                method.invoke(_lfTincanPackageRemoteModel, summary);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getAssetRefID() {
        return _assetRefID;
    }

    @Override
    public void setAssetRefID(Long assetRefID) {
        _assetRefID = assetRefID;

        if (_lfTincanPackageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanPackageRemoteModel.getClass();

                Method method = clazz.getMethod("setAssetRefID", Long.class);

                method.invoke(_lfTincanPackageRemoteModel, assetRefID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getCourseID() {
        return _courseID;
    }

    @Override
    public void setCourseID(Integer courseID) {
        _courseID = courseID;

        if (_lfTincanPackageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanPackageRemoteModel.getClass();

                Method method = clazz.getMethod("setCourseID", Integer.class);

                method.invoke(_lfTincanPackageRemoteModel, courseID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLogo() {
        return _logo;
    }

    @Override
    public void setLogo(String logo) {
        _logo = logo;

        if (_lfTincanPackageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanPackageRemoteModel.getClass();

                Method method = clazz.getMethod("setLogo", String.class);

                method.invoke(_lfTincanPackageRemoteModel, logo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanPackageRemoteModel() {
        return _lfTincanPackageRemoteModel;
    }

    public void setLFTincanPackageRemoteModel(
        BaseModel<?> lfTincanPackageRemoteModel) {
        _lfTincanPackageRemoteModel = lfTincanPackageRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanPackageRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanPackageRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanPackageLocalServiceUtil.addLFTincanPackage(this);
        } else {
            LFTincanPackageLocalServiceUtil.updateLFTincanPackage(this);
        }
    }

    @Override
    public LFTincanPackage toEscapedModel() {
        return (LFTincanPackage) ProxyUtil.newProxyInstance(LFTincanPackage.class.getClassLoader(),
            new Class[] { LFTincanPackage.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanPackageClp clone = new LFTincanPackageClp();

        clone.setId(getId());
        clone.setTitle(getTitle());
        clone.setSummary(getSummary());
        clone.setAssetRefID(getAssetRefID());
        clone.setCourseID(getCourseID());
        clone.setLogo(getLogo());

        return clone;
    }

    @Override
    public int compareTo(LFTincanPackage lfTincanPackage) {
        long primaryKey = lfTincanPackage.getPrimaryKey();

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

        if (!(obj instanceof LFTincanPackageClp)) {
            return false;
        }

        LFTincanPackageClp lfTincanPackage = (LFTincanPackageClp) obj;

        long primaryKey = lfTincanPackage.getPrimaryKey();

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
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", summary=");
        sb.append(getSummary());
        sb.append(", assetRefID=");
        sb.append(getAssetRefID());
        sb.append(", courseID=");
        sb.append(getCourseID());
        sb.append(", logo=");
        sb.append(getLogo());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFTincanPackage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>summary</column-name><column-value><![CDATA[");
        sb.append(getSummary());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>assetRefID</column-name><column-value><![CDATA[");
        sb.append(getAssetRefID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courseID</column-name><column-value><![CDATA[");
        sb.append(getCourseID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>logo</column-name><column-value><![CDATA[");
        sb.append(getLogo());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
