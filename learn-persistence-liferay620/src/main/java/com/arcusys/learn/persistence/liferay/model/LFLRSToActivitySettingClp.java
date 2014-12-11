package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFLRSToActivitySettingLocalServiceUtil;

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


public class LFLRSToActivitySettingClp extends BaseModelImpl<LFLRSToActivitySetting>
    implements LFLRSToActivitySetting {
    private long _id;
    private Integer _courseID;
    private String _title;
    private String _activityFilter;
    private String _verbFilter;
    private BaseModel<?> _lflrsToActivitySettingRemoteModel;

    public LFLRSToActivitySettingClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFLRSToActivitySetting.class;
    }

    @Override
    public String getModelClassName() {
        return LFLRSToActivitySetting.class.getName();
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
        attributes.put("courseID", getCourseID());
        attributes.put("title", getTitle());
        attributes.put("activityFilter", getActivityFilter());
        attributes.put("verbFilter", getVerbFilter());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer courseID = (Integer) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String activityFilter = (String) attributes.get("activityFilter");

        if (activityFilter != null) {
            setActivityFilter(activityFilter);
        }

        String verbFilter = (String) attributes.get("verbFilter");

        if (verbFilter != null) {
            setVerbFilter(verbFilter);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lflrsToActivitySettingRemoteModel != null) {
            try {
                Class<?> clazz = _lflrsToActivitySettingRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lflrsToActivitySettingRemoteModel, id);
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

        if (_lflrsToActivitySettingRemoteModel != null) {
            try {
                Class<?> clazz = _lflrsToActivitySettingRemoteModel.getClass();

                Method method = clazz.getMethod("setCourseID", Integer.class);

                method.invoke(_lflrsToActivitySettingRemoteModel, courseID);
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

        if (_lflrsToActivitySettingRemoteModel != null) {
            try {
                Class<?> clazz = _lflrsToActivitySettingRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_lflrsToActivitySettingRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getActivityFilter() {
        return _activityFilter;
    }

    @Override
    public void setActivityFilter(String activityFilter) {
        _activityFilter = activityFilter;

        if (_lflrsToActivitySettingRemoteModel != null) {
            try {
                Class<?> clazz = _lflrsToActivitySettingRemoteModel.getClass();

                Method method = clazz.getMethod("setActivityFilter",
                        String.class);

                method.invoke(_lflrsToActivitySettingRemoteModel, activityFilter);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getVerbFilter() {
        return _verbFilter;
    }

    @Override
    public void setVerbFilter(String verbFilter) {
        _verbFilter = verbFilter;

        if (_lflrsToActivitySettingRemoteModel != null) {
            try {
                Class<?> clazz = _lflrsToActivitySettingRemoteModel.getClass();

                Method method = clazz.getMethod("setVerbFilter", String.class);

                method.invoke(_lflrsToActivitySettingRemoteModel, verbFilter);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFLRSToActivitySettingRemoteModel() {
        return _lflrsToActivitySettingRemoteModel;
    }

    public void setLFLRSToActivitySettingRemoteModel(
        BaseModel<?> lflrsToActivitySettingRemoteModel) {
        _lflrsToActivitySettingRemoteModel = lflrsToActivitySettingRemoteModel;
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

        Class<?> remoteModelClass = _lflrsToActivitySettingRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lflrsToActivitySettingRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFLRSToActivitySettingLocalServiceUtil.addLFLRSToActivitySetting(this);
        } else {
            LFLRSToActivitySettingLocalServiceUtil.updateLFLRSToActivitySetting(this);
        }
    }

    @Override
    public LFLRSToActivitySetting toEscapedModel() {
        return (LFLRSToActivitySetting) ProxyUtil.newProxyInstance(LFLRSToActivitySetting.class.getClassLoader(),
            new Class[] { LFLRSToActivitySetting.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFLRSToActivitySettingClp clone = new LFLRSToActivitySettingClp();

        clone.setId(getId());
        clone.setCourseID(getCourseID());
        clone.setTitle(getTitle());
        clone.setActivityFilter(getActivityFilter());
        clone.setVerbFilter(getVerbFilter());

        return clone;
    }

    @Override
    public int compareTo(LFLRSToActivitySetting lflrsToActivitySetting) {
        long primaryKey = lflrsToActivitySetting.getPrimaryKey();

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

        if (!(obj instanceof LFLRSToActivitySettingClp)) {
            return false;
        }

        LFLRSToActivitySettingClp lflrsToActivitySetting = (LFLRSToActivitySettingClp) obj;

        long primaryKey = lflrsToActivitySetting.getPrimaryKey();

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
        sb.append(", courseID=");
        sb.append(getCourseID());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", activityFilter=");
        sb.append(getActivityFilter());
        sb.append(", verbFilter=");
        sb.append(getVerbFilter());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courseID</column-name><column-value><![CDATA[");
        sb.append(getCourseID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityFilter</column-name><column-value><![CDATA[");
        sb.append(getActivityFilter());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>verbFilter</column-name><column-value><![CDATA[");
        sb.append(getVerbFilter());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
