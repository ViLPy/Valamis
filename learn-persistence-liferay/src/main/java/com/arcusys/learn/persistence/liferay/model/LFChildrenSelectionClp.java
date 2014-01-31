package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalServiceUtil;

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


public class LFChildrenSelectionClp extends BaseModelImpl<LFChildrenSelection>
    implements LFChildrenSelection {
    private long _id;
    private Integer _sequencingID;
    private Integer _takeCount;
    private String _takeTimingOnEachAttempt;
    private String _reorderOnEachAttempt;
    private BaseModel<?> _lfChildrenSelectionRemoteModel;

    public LFChildrenSelectionClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFChildrenSelection.class;
    }

    @Override
    public String getModelClassName() {
        return LFChildrenSelection.class.getName();
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
        attributes.put("sequencingID", getSequencingID());
        attributes.put("takeCount", getTakeCount());
        attributes.put("takeTimingOnEachAttempt", getTakeTimingOnEachAttempt());
        attributes.put("reorderOnEachAttempt", getReorderOnEachAttempt());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer sequencingID = (Integer) attributes.get("sequencingID");

        if (sequencingID != null) {
            setSequencingID(sequencingID);
        }

        Integer takeCount = (Integer) attributes.get("takeCount");

        if (takeCount != null) {
            setTakeCount(takeCount);
        }

        String takeTimingOnEachAttempt = (String) attributes.get(
                "takeTimingOnEachAttempt");

        if (takeTimingOnEachAttempt != null) {
            setTakeTimingOnEachAttempt(takeTimingOnEachAttempt);
        }

        String reorderOnEachAttempt = (String) attributes.get(
                "reorderOnEachAttempt");

        if (reorderOnEachAttempt != null) {
            setReorderOnEachAttempt(reorderOnEachAttempt);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfChildrenSelectionRemoteModel != null) {
            try {
                Class<?> clazz = _lfChildrenSelectionRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfChildrenSelectionRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getSequencingID() {
        return _sequencingID;
    }

    @Override
    public void setSequencingID(Integer sequencingID) {
        _sequencingID = sequencingID;

        if (_lfChildrenSelectionRemoteModel != null) {
            try {
                Class<?> clazz = _lfChildrenSelectionRemoteModel.getClass();

                Method method = clazz.getMethod("setSequencingID", Integer.class);

                method.invoke(_lfChildrenSelectionRemoteModel, sequencingID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getTakeCount() {
        return _takeCount;
    }

    @Override
    public void setTakeCount(Integer takeCount) {
        _takeCount = takeCount;

        if (_lfChildrenSelectionRemoteModel != null) {
            try {
                Class<?> clazz = _lfChildrenSelectionRemoteModel.getClass();

                Method method = clazz.getMethod("setTakeCount", Integer.class);

                method.invoke(_lfChildrenSelectionRemoteModel, takeCount);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTakeTimingOnEachAttempt() {
        return _takeTimingOnEachAttempt;
    }

    @Override
    public void setTakeTimingOnEachAttempt(String takeTimingOnEachAttempt) {
        _takeTimingOnEachAttempt = takeTimingOnEachAttempt;

        if (_lfChildrenSelectionRemoteModel != null) {
            try {
                Class<?> clazz = _lfChildrenSelectionRemoteModel.getClass();

                Method method = clazz.getMethod("setTakeTimingOnEachAttempt",
                        String.class);

                method.invoke(_lfChildrenSelectionRemoteModel,
                    takeTimingOnEachAttempt);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getReorderOnEachAttempt() {
        return _reorderOnEachAttempt;
    }

    @Override
    public void setReorderOnEachAttempt(String reorderOnEachAttempt) {
        _reorderOnEachAttempt = reorderOnEachAttempt;

        if (_lfChildrenSelectionRemoteModel != null) {
            try {
                Class<?> clazz = _lfChildrenSelectionRemoteModel.getClass();

                Method method = clazz.getMethod("setReorderOnEachAttempt",
                        String.class);

                method.invoke(_lfChildrenSelectionRemoteModel,
                    reorderOnEachAttempt);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFChildrenSelectionRemoteModel() {
        return _lfChildrenSelectionRemoteModel;
    }

    public void setLFChildrenSelectionRemoteModel(
        BaseModel<?> lfChildrenSelectionRemoteModel) {
        _lfChildrenSelectionRemoteModel = lfChildrenSelectionRemoteModel;
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

        Class<?> remoteModelClass = _lfChildrenSelectionRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfChildrenSelectionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFChildrenSelectionLocalServiceUtil.addLFChildrenSelection(this);
        } else {
            LFChildrenSelectionLocalServiceUtil.updateLFChildrenSelection(this);
        }
    }

    @Override
    public LFChildrenSelection toEscapedModel() {
        return (LFChildrenSelection) ProxyUtil.newProxyInstance(LFChildrenSelection.class.getClassLoader(),
            new Class[] { LFChildrenSelection.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFChildrenSelectionClp clone = new LFChildrenSelectionClp();

        clone.setId(getId());
        clone.setSequencingID(getSequencingID());
        clone.setTakeCount(getTakeCount());
        clone.setTakeTimingOnEachAttempt(getTakeTimingOnEachAttempt());
        clone.setReorderOnEachAttempt(getReorderOnEachAttempt());

        return clone;
    }

    @Override
    public int compareTo(LFChildrenSelection lfChildrenSelection) {
        long primaryKey = lfChildrenSelection.getPrimaryKey();

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

        if (!(obj instanceof LFChildrenSelectionClp)) {
            return false;
        }

        LFChildrenSelectionClp lfChildrenSelection = (LFChildrenSelectionClp) obj;

        long primaryKey = lfChildrenSelection.getPrimaryKey();

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
        sb.append(", sequencingID=");
        sb.append(getSequencingID());
        sb.append(", takeCount=");
        sb.append(getTakeCount());
        sb.append(", takeTimingOnEachAttempt=");
        sb.append(getTakeTimingOnEachAttempt());
        sb.append(", reorderOnEachAttempt=");
        sb.append(getReorderOnEachAttempt());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFChildrenSelection");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sequencingID</column-name><column-value><![CDATA[");
        sb.append(getSequencingID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>takeCount</column-name><column-value><![CDATA[");
        sb.append(getTakeCount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>takeTimingOnEachAttempt</column-name><column-value><![CDATA[");
        sb.append(getTakeTimingOnEachAttempt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>reorderOnEachAttempt</column-name><column-value><![CDATA[");
        sb.append(getReorderOnEachAttempt());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
