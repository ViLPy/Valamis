package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFAchievementUserLocalServiceUtil;

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


public class LFAchievementUserClp extends BaseModelImpl<LFAchievementUser>
    implements LFAchievementUser {
    private long _id;
    private Integer _userId;
    private Integer _achievementId;
    private BaseModel<?> _lfAchievementUserRemoteModel;

    public LFAchievementUserClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFAchievementUser.class;
    }

    @Override
    public String getModelClassName() {
        return LFAchievementUser.class.getName();
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
        attributes.put("userId", getUserId());
        attributes.put("achievementId", getAchievementId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer userId = (Integer) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Integer achievementId = (Integer) attributes.get("achievementId");

        if (achievementId != null) {
            setAchievementId(achievementId);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfAchievementUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfAchievementUserRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfAchievementUserRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(Integer userId) {
        _userId = userId;

        if (_lfAchievementUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfAchievementUserRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", Integer.class);

                method.invoke(_lfAchievementUserRemoteModel, userId);
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

        if (_lfAchievementUserRemoteModel != null) {
            try {
                Class<?> clazz = _lfAchievementUserRemoteModel.getClass();

                Method method = clazz.getMethod("setAchievementId",
                        Integer.class);

                method.invoke(_lfAchievementUserRemoteModel, achievementId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFAchievementUserRemoteModel() {
        return _lfAchievementUserRemoteModel;
    }

    public void setLFAchievementUserRemoteModel(
        BaseModel<?> lfAchievementUserRemoteModel) {
        _lfAchievementUserRemoteModel = lfAchievementUserRemoteModel;
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

        Class<?> remoteModelClass = _lfAchievementUserRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfAchievementUserRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFAchievementUserLocalServiceUtil.addLFAchievementUser(this);
        } else {
            LFAchievementUserLocalServiceUtil.updateLFAchievementUser(this);
        }
    }

    @Override
    public LFAchievementUser toEscapedModel() {
        return (LFAchievementUser) ProxyUtil.newProxyInstance(LFAchievementUser.class.getClassLoader(),
            new Class[] { LFAchievementUser.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFAchievementUserClp clone = new LFAchievementUserClp();

        clone.setId(getId());
        clone.setUserId(getUserId());
        clone.setAchievementId(getAchievementId());

        return clone;
    }

    @Override
    public int compareTo(LFAchievementUser lfAchievementUser) {
        long primaryKey = lfAchievementUser.getPrimaryKey();

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

        if (!(obj instanceof LFAchievementUserClp)) {
            return false;
        }

        LFAchievementUserClp lfAchievementUser = (LFAchievementUserClp) obj;

        long primaryKey = lfAchievementUser.getPrimaryKey();

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
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", achievementId=");
        sb.append(getAchievementId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFAchievementUser");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>achievementId</column-name><column-value><![CDATA[");
        sb.append(getAchievementId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
