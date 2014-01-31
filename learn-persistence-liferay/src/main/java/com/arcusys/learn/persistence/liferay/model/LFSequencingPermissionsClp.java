package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalServiceUtil;

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


public class LFSequencingPermissionsClp extends BaseModelImpl<LFSequencingPermissions>
    implements LFSequencingPermissions {
    private long _id;
    private Integer _sequencingID;
    private boolean _choiceForChildren;
    private boolean _choiceForNonDescendants;
    private boolean _flowForChildren;
    private boolean _forwardOnlyForChildren;
    private BaseModel<?> _lfSequencingPermissionsRemoteModel;

    public LFSequencingPermissionsClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFSequencingPermissions.class;
    }

    @Override
    public String getModelClassName() {
        return LFSequencingPermissions.class.getName();
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
        attributes.put("choiceForChildren", getChoiceForChildren());
        attributes.put("choiceForNonDescendants", getChoiceForNonDescendants());
        attributes.put("flowForChildren", getFlowForChildren());
        attributes.put("forwardOnlyForChildren", getForwardOnlyForChildren());

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

        Boolean choiceForChildren = (Boolean) attributes.get(
                "choiceForChildren");

        if (choiceForChildren != null) {
            setChoiceForChildren(choiceForChildren);
        }

        Boolean choiceForNonDescendants = (Boolean) attributes.get(
                "choiceForNonDescendants");

        if (choiceForNonDescendants != null) {
            setChoiceForNonDescendants(choiceForNonDescendants);
        }

        Boolean flowForChildren = (Boolean) attributes.get("flowForChildren");

        if (flowForChildren != null) {
            setFlowForChildren(flowForChildren);
        }

        Boolean forwardOnlyForChildren = (Boolean) attributes.get(
                "forwardOnlyForChildren");

        if (forwardOnlyForChildren != null) {
            setForwardOnlyForChildren(forwardOnlyForChildren);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfSequencingPermissionsRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingPermissionsRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfSequencingPermissionsRemoteModel, id);
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

        if (_lfSequencingPermissionsRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingPermissionsRemoteModel.getClass();

                Method method = clazz.getMethod("setSequencingID", Integer.class);

                method.invoke(_lfSequencingPermissionsRemoteModel, sequencingID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getChoiceForChildren() {
        return _choiceForChildren;
    }

    @Override
    public boolean isChoiceForChildren() {
        return _choiceForChildren;
    }

    @Override
    public void setChoiceForChildren(boolean choiceForChildren) {
        _choiceForChildren = choiceForChildren;

        if (_lfSequencingPermissionsRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingPermissionsRemoteModel.getClass();

                Method method = clazz.getMethod("setChoiceForChildren",
                        boolean.class);

                method.invoke(_lfSequencingPermissionsRemoteModel,
                    choiceForChildren);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getChoiceForNonDescendants() {
        return _choiceForNonDescendants;
    }

    @Override
    public boolean isChoiceForNonDescendants() {
        return _choiceForNonDescendants;
    }

    @Override
    public void setChoiceForNonDescendants(boolean choiceForNonDescendants) {
        _choiceForNonDescendants = choiceForNonDescendants;

        if (_lfSequencingPermissionsRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingPermissionsRemoteModel.getClass();

                Method method = clazz.getMethod("setChoiceForNonDescendants",
                        boolean.class);

                method.invoke(_lfSequencingPermissionsRemoteModel,
                    choiceForNonDescendants);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getFlowForChildren() {
        return _flowForChildren;
    }

    @Override
    public boolean isFlowForChildren() {
        return _flowForChildren;
    }

    @Override
    public void setFlowForChildren(boolean flowForChildren) {
        _flowForChildren = flowForChildren;

        if (_lfSequencingPermissionsRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingPermissionsRemoteModel.getClass();

                Method method = clazz.getMethod("setFlowForChildren",
                        boolean.class);

                method.invoke(_lfSequencingPermissionsRemoteModel,
                    flowForChildren);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getForwardOnlyForChildren() {
        return _forwardOnlyForChildren;
    }

    @Override
    public boolean isForwardOnlyForChildren() {
        return _forwardOnlyForChildren;
    }

    @Override
    public void setForwardOnlyForChildren(boolean forwardOnlyForChildren) {
        _forwardOnlyForChildren = forwardOnlyForChildren;

        if (_lfSequencingPermissionsRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingPermissionsRemoteModel.getClass();

                Method method = clazz.getMethod("setForwardOnlyForChildren",
                        boolean.class);

                method.invoke(_lfSequencingPermissionsRemoteModel,
                    forwardOnlyForChildren);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFSequencingPermissionsRemoteModel() {
        return _lfSequencingPermissionsRemoteModel;
    }

    public void setLFSequencingPermissionsRemoteModel(
        BaseModel<?> lfSequencingPermissionsRemoteModel) {
        _lfSequencingPermissionsRemoteModel = lfSequencingPermissionsRemoteModel;
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

        Class<?> remoteModelClass = _lfSequencingPermissionsRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfSequencingPermissionsRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSequencingPermissionsLocalServiceUtil.addLFSequencingPermissions(this);
        } else {
            LFSequencingPermissionsLocalServiceUtil.updateLFSequencingPermissions(this);
        }
    }

    @Override
    public LFSequencingPermissions toEscapedModel() {
        return (LFSequencingPermissions) ProxyUtil.newProxyInstance(LFSequencingPermissions.class.getClassLoader(),
            new Class[] { LFSequencingPermissions.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSequencingPermissionsClp clone = new LFSequencingPermissionsClp();

        clone.setId(getId());
        clone.setSequencingID(getSequencingID());
        clone.setChoiceForChildren(getChoiceForChildren());
        clone.setChoiceForNonDescendants(getChoiceForNonDescendants());
        clone.setFlowForChildren(getFlowForChildren());
        clone.setForwardOnlyForChildren(getForwardOnlyForChildren());

        return clone;
    }

    @Override
    public int compareTo(LFSequencingPermissions lfSequencingPermissions) {
        long primaryKey = lfSequencingPermissions.getPrimaryKey();

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

        if (!(obj instanceof LFSequencingPermissionsClp)) {
            return false;
        }

        LFSequencingPermissionsClp lfSequencingPermissions = (LFSequencingPermissionsClp) obj;

        long primaryKey = lfSequencingPermissions.getPrimaryKey();

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
        sb.append(", sequencingID=");
        sb.append(getSequencingID());
        sb.append(", choiceForChildren=");
        sb.append(getChoiceForChildren());
        sb.append(", choiceForNonDescendants=");
        sb.append(getChoiceForNonDescendants());
        sb.append(", flowForChildren=");
        sb.append(getFlowForChildren());
        sb.append(", forwardOnlyForChildren=");
        sb.append(getForwardOnlyForChildren());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions");
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
            "<column><column-name>choiceForChildren</column-name><column-value><![CDATA[");
        sb.append(getChoiceForChildren());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>choiceForNonDescendants</column-name><column-value><![CDATA[");
        sb.append(getChoiceForNonDescendants());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>flowForChildren</column-name><column-value><![CDATA[");
        sb.append(getFlowForChildren());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>forwardOnlyForChildren</column-name><column-value><![CDATA[");
        sb.append(getForwardOnlyForChildren());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
