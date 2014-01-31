package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalServiceUtil;

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


public class LFActivityStateTreeClp extends BaseModelImpl<LFActivityStateTree>
    implements LFActivityStateTree {
    private long _id;
    private String _currentActivityID;
    private String _suspendedActivityID;
    private Integer _attemptID;
    private BaseModel<?> _lfActivityStateTreeRemoteModel;

    public LFActivityStateTreeClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFActivityStateTree.class;
    }

    @Override
    public String getModelClassName() {
        return LFActivityStateTree.class.getName();
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
        attributes.put("currentActivityID", getCurrentActivityID());
        attributes.put("suspendedActivityID", getSuspendedActivityID());
        attributes.put("attemptID", getAttemptID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String currentActivityID = (String) attributes.get("currentActivityID");

        if (currentActivityID != null) {
            setCurrentActivityID(currentActivityID);
        }

        String suspendedActivityID = (String) attributes.get(
                "suspendedActivityID");

        if (suspendedActivityID != null) {
            setSuspendedActivityID(suspendedActivityID);
        }

        Integer attemptID = (Integer) attributes.get("attemptID");

        if (attemptID != null) {
            setAttemptID(attemptID);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfActivityStateTreeRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityStateTreeRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfActivityStateTreeRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCurrentActivityID() {
        return _currentActivityID;
    }

    @Override
    public void setCurrentActivityID(String currentActivityID) {
        _currentActivityID = currentActivityID;

        if (_lfActivityStateTreeRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityStateTreeRemoteModel.getClass();

                Method method = clazz.getMethod("setCurrentActivityID",
                        String.class);

                method.invoke(_lfActivityStateTreeRemoteModel, currentActivityID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSuspendedActivityID() {
        return _suspendedActivityID;
    }

    @Override
    public void setSuspendedActivityID(String suspendedActivityID) {
        _suspendedActivityID = suspendedActivityID;

        if (_lfActivityStateTreeRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityStateTreeRemoteModel.getClass();

                Method method = clazz.getMethod("setSuspendedActivityID",
                        String.class);

                method.invoke(_lfActivityStateTreeRemoteModel,
                    suspendedActivityID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getAttemptID() {
        return _attemptID;
    }

    @Override
    public void setAttemptID(Integer attemptID) {
        _attemptID = attemptID;

        if (_lfActivityStateTreeRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityStateTreeRemoteModel.getClass();

                Method method = clazz.getMethod("setAttemptID", Integer.class);

                method.invoke(_lfActivityStateTreeRemoteModel, attemptID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFActivityStateTreeRemoteModel() {
        return _lfActivityStateTreeRemoteModel;
    }

    public void setLFActivityStateTreeRemoteModel(
        BaseModel<?> lfActivityStateTreeRemoteModel) {
        _lfActivityStateTreeRemoteModel = lfActivityStateTreeRemoteModel;
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

        Class<?> remoteModelClass = _lfActivityStateTreeRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfActivityStateTreeRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFActivityStateTreeLocalServiceUtil.addLFActivityStateTree(this);
        } else {
            LFActivityStateTreeLocalServiceUtil.updateLFActivityStateTree(this);
        }
    }

    @Override
    public LFActivityStateTree toEscapedModel() {
        return (LFActivityStateTree) ProxyUtil.newProxyInstance(LFActivityStateTree.class.getClassLoader(),
            new Class[] { LFActivityStateTree.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFActivityStateTreeClp clone = new LFActivityStateTreeClp();

        clone.setId(getId());
        clone.setCurrentActivityID(getCurrentActivityID());
        clone.setSuspendedActivityID(getSuspendedActivityID());
        clone.setAttemptID(getAttemptID());

        return clone;
    }

    @Override
    public int compareTo(LFActivityStateTree lfActivityStateTree) {
        long primaryKey = lfActivityStateTree.getPrimaryKey();

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

        if (!(obj instanceof LFActivityStateTreeClp)) {
            return false;
        }

        LFActivityStateTreeClp lfActivityStateTree = (LFActivityStateTreeClp) obj;

        long primaryKey = lfActivityStateTree.getPrimaryKey();

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
        sb.append(", currentActivityID=");
        sb.append(getCurrentActivityID());
        sb.append(", suspendedActivityID=");
        sb.append(getSuspendedActivityID());
        sb.append(", attemptID=");
        sb.append(getAttemptID());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFActivityStateTree");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>currentActivityID</column-name><column-value><![CDATA[");
        sb.append(getCurrentActivityID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>suspendedActivityID</column-name><column-value><![CDATA[");
        sb.append(getSuspendedActivityID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptID</column-name><column-value><![CDATA[");
        sb.append(getAttemptID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
