package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFRequiredActivityLocalServiceUtil;

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


public class LFRequiredActivityClp extends BaseModelImpl<LFRequiredActivity>
    implements LFRequiredActivity {
    private long _id;
    private Integer _achievementId;
    private String _activityClassName;
    private Integer _numberActivitiesRequired;
    private BaseModel<?> _lfRequiredActivityRemoteModel;

    public LFRequiredActivityClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFRequiredActivity.class;
    }

    @Override
    public String getModelClassName() {
        return LFRequiredActivity.class.getName();
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
        attributes.put("achievementId", getAchievementId());
        attributes.put("activityClassName", getActivityClassName());
        attributes.put("numberActivitiesRequired", getNumberActivitiesRequired());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer achievementId = (Integer) attributes.get("achievementId");

        if (achievementId != null) {
            setAchievementId(achievementId);
        }

        String activityClassName = (String) attributes.get("activityClassName");

        if (activityClassName != null) {
            setActivityClassName(activityClassName);
        }

        Integer numberActivitiesRequired = (Integer) attributes.get(
                "numberActivitiesRequired");

        if (numberActivitiesRequired != null) {
            setNumberActivitiesRequired(numberActivitiesRequired);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfRequiredActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfRequiredActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfRequiredActivityRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getAchievementId() {
        return _achievementId;
    }

    @Override
    public void setAchievementId(Integer achievementId) {
        _achievementId = achievementId;

        if (_lfRequiredActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfRequiredActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setAchievementId",
                        Integer.class);

                method.invoke(_lfRequiredActivityRemoteModel, achievementId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getActivityClassName() {
        return _activityClassName;
    }

    @Override
    public void setActivityClassName(String activityClassName) {
        _activityClassName = activityClassName;

        if (_lfRequiredActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfRequiredActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setActivityClassName",
                        String.class);

                method.invoke(_lfRequiredActivityRemoteModel, activityClassName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getNumberActivitiesRequired() {
        return _numberActivitiesRequired;
    }

    @Override
    public void setNumberActivitiesRequired(Integer numberActivitiesRequired) {
        _numberActivitiesRequired = numberActivitiesRequired;

        if (_lfRequiredActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfRequiredActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setNumberActivitiesRequired",
                        Integer.class);

                method.invoke(_lfRequiredActivityRemoteModel,
                    numberActivitiesRequired);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFRequiredActivityRemoteModel() {
        return _lfRequiredActivityRemoteModel;
    }

    public void setLFRequiredActivityRemoteModel(
        BaseModel<?> lfRequiredActivityRemoteModel) {
        _lfRequiredActivityRemoteModel = lfRequiredActivityRemoteModel;
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

        Class<?> remoteModelClass = _lfRequiredActivityRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfRequiredActivityRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFRequiredActivityLocalServiceUtil.addLFRequiredActivity(this);
        } else {
            LFRequiredActivityLocalServiceUtil.updateLFRequiredActivity(this);
        }
    }

    @Override
    public LFRequiredActivity toEscapedModel() {
        return (LFRequiredActivity) ProxyUtil.newProxyInstance(LFRequiredActivity.class.getClassLoader(),
            new Class[] { LFRequiredActivity.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFRequiredActivityClp clone = new LFRequiredActivityClp();

        clone.setId(getId());
        clone.setAchievementId(getAchievementId());
        clone.setActivityClassName(getActivityClassName());
        clone.setNumberActivitiesRequired(getNumberActivitiesRequired());

        return clone;
    }

    @Override
    public int compareTo(LFRequiredActivity lfRequiredActivity) {
        long primaryKey = lfRequiredActivity.getPrimaryKey();

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

        if (!(obj instanceof LFRequiredActivityClp)) {
            return false;
        }

        LFRequiredActivityClp lfRequiredActivity = (LFRequiredActivityClp) obj;

        long primaryKey = lfRequiredActivity.getPrimaryKey();

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
        sb.append(", achievementId=");
        sb.append(getAchievementId());
        sb.append(", activityClassName=");
        sb.append(getActivityClassName());
        sb.append(", numberActivitiesRequired=");
        sb.append(getNumberActivitiesRequired());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFRequiredActivity");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>achievementId</column-name><column-value><![CDATA[");
        sb.append(getAchievementId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityClassName</column-name><column-value><![CDATA[");
        sb.append(getActivityClassName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>numberActivitiesRequired</column-name><column-value><![CDATA[");
        sb.append(getNumberActivitiesRequired());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
