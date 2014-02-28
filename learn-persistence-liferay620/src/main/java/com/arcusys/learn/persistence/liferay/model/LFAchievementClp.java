package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFAchievementLocalServiceUtil;

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


public class LFAchievementClp extends BaseModelImpl<LFAchievement>
    implements LFAchievement {
    private long _id;
    private String _title;
    private String _description;
    private String _logo;
    private Date _creationDate;
    private BaseModel<?> _lfAchievementRemoteModel;

    public LFAchievementClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFAchievement.class;
    }

    @Override
    public String getModelClassName() {
        return LFAchievement.class.getName();
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
        attributes.put("description", getDescription());
        attributes.put("logo", getLogo());
        attributes.put("creationDate", getCreationDate());

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

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String logo = (String) attributes.get("logo");

        if (logo != null) {
            setLogo(logo);
        }

        Date creationDate = (Date) attributes.get("creationDate");

        if (creationDate != null) {
            setCreationDate(creationDate);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfAchievementRemoteModel != null) {
            try {
                Class<?> clazz = _lfAchievementRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfAchievementRemoteModel, id);
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

        if (_lfAchievementRemoteModel != null) {
            try {
                Class<?> clazz = _lfAchievementRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_lfAchievementRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_lfAchievementRemoteModel != null) {
            try {
                Class<?> clazz = _lfAchievementRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_lfAchievementRemoteModel, description);
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

        if (_lfAchievementRemoteModel != null) {
            try {
                Class<?> clazz = _lfAchievementRemoteModel.getClass();

                Method method = clazz.getMethod("setLogo", String.class);

                method.invoke(_lfAchievementRemoteModel, logo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreationDate() {
        return _creationDate;
    }

    @Override
    public void setCreationDate(Date creationDate) {
        _creationDate = creationDate;

        if (_lfAchievementRemoteModel != null) {
            try {
                Class<?> clazz = _lfAchievementRemoteModel.getClass();

                Method method = clazz.getMethod("setCreationDate", Date.class);

                method.invoke(_lfAchievementRemoteModel, creationDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFAchievementRemoteModel() {
        return _lfAchievementRemoteModel;
    }

    public void setLFAchievementRemoteModel(
        BaseModel<?> lfAchievementRemoteModel) {
        _lfAchievementRemoteModel = lfAchievementRemoteModel;
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

        Class<?> remoteModelClass = _lfAchievementRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfAchievementRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFAchievementLocalServiceUtil.addLFAchievement(this);
        } else {
            LFAchievementLocalServiceUtil.updateLFAchievement(this);
        }
    }

    @Override
    public LFAchievement toEscapedModel() {
        return (LFAchievement) ProxyUtil.newProxyInstance(LFAchievement.class.getClassLoader(),
            new Class[] { LFAchievement.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFAchievementClp clone = new LFAchievementClp();

        clone.setId(getId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setLogo(getLogo());
        clone.setCreationDate(getCreationDate());

        return clone;
    }

    @Override
    public int compareTo(LFAchievement lfAchievement) {
        long primaryKey = lfAchievement.getPrimaryKey();

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

        if (!(obj instanceof LFAchievementClp)) {
            return false;
        }

        LFAchievementClp lfAchievement = (LFAchievementClp) obj;

        long primaryKey = lfAchievement.getPrimaryKey();

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
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", logo=");
        sb.append(getLogo());
        sb.append(", creationDate=");
        sb.append(getCreationDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFAchievement");
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
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>logo</column-name><column-value><![CDATA[");
        sb.append(getLogo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>creationDate</column-name><column-value><![CDATA[");
        sb.append(getCreationDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
