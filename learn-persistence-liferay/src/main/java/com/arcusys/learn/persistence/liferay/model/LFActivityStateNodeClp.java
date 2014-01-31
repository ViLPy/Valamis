package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalServiceUtil;

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


public class LFActivityStateNodeClp extends BaseModelImpl<LFActivityStateNode>
    implements LFActivityStateNode {
    private long _id;
    private Integer _parentID;
    private Integer _treeID;
    private String _availableChildrenIDs;
    private BaseModel<?> _lfActivityStateNodeRemoteModel;

    public LFActivityStateNodeClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFActivityStateNode.class;
    }

    @Override
    public String getModelClassName() {
        return LFActivityStateNode.class.getName();
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
        attributes.put("parentID", getParentID());
        attributes.put("treeID", getTreeID());
        attributes.put("availableChildrenIDs", getAvailableChildrenIDs());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer parentID = (Integer) attributes.get("parentID");

        if (parentID != null) {
            setParentID(parentID);
        }

        Integer treeID = (Integer) attributes.get("treeID");

        if (treeID != null) {
            setTreeID(treeID);
        }

        String availableChildrenIDs = (String) attributes.get(
                "availableChildrenIDs");

        if (availableChildrenIDs != null) {
            setAvailableChildrenIDs(availableChildrenIDs);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfActivityStateNodeRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityStateNodeRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfActivityStateNodeRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getParentID() {
        return _parentID;
    }

    @Override
    public void setParentID(Integer parentID) {
        _parentID = parentID;

        if (_lfActivityStateNodeRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityStateNodeRemoteModel.getClass();

                Method method = clazz.getMethod("setParentID", Integer.class);

                method.invoke(_lfActivityStateNodeRemoteModel, parentID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getTreeID() {
        return _treeID;
    }

    @Override
    public void setTreeID(Integer treeID) {
        _treeID = treeID;

        if (_lfActivityStateNodeRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityStateNodeRemoteModel.getClass();

                Method method = clazz.getMethod("setTreeID", Integer.class);

                method.invoke(_lfActivityStateNodeRemoteModel, treeID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAvailableChildrenIDs() {
        return _availableChildrenIDs;
    }

    @Override
    public void setAvailableChildrenIDs(String availableChildrenIDs) {
        _availableChildrenIDs = availableChildrenIDs;

        if (_lfActivityStateNodeRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityStateNodeRemoteModel.getClass();

                Method method = clazz.getMethod("setAvailableChildrenIDs",
                        String.class);

                method.invoke(_lfActivityStateNodeRemoteModel,
                    availableChildrenIDs);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFActivityStateNodeRemoteModel() {
        return _lfActivityStateNodeRemoteModel;
    }

    public void setLFActivityStateNodeRemoteModel(
        BaseModel<?> lfActivityStateNodeRemoteModel) {
        _lfActivityStateNodeRemoteModel = lfActivityStateNodeRemoteModel;
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

        Class<?> remoteModelClass = _lfActivityStateNodeRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfActivityStateNodeRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFActivityStateNodeLocalServiceUtil.addLFActivityStateNode(this);
        } else {
            LFActivityStateNodeLocalServiceUtil.updateLFActivityStateNode(this);
        }
    }

    @Override
    public LFActivityStateNode toEscapedModel() {
        return (LFActivityStateNode) ProxyUtil.newProxyInstance(LFActivityStateNode.class.getClassLoader(),
            new Class[] { LFActivityStateNode.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFActivityStateNodeClp clone = new LFActivityStateNodeClp();

        clone.setId(getId());
        clone.setParentID(getParentID());
        clone.setTreeID(getTreeID());
        clone.setAvailableChildrenIDs(getAvailableChildrenIDs());

        return clone;
    }

    @Override
    public int compareTo(LFActivityStateNode lfActivityStateNode) {
        long primaryKey = lfActivityStateNode.getPrimaryKey();

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

        if (!(obj instanceof LFActivityStateNodeClp)) {
            return false;
        }

        LFActivityStateNodeClp lfActivityStateNode = (LFActivityStateNodeClp) obj;

        long primaryKey = lfActivityStateNode.getPrimaryKey();

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
        sb.append(", parentID=");
        sb.append(getParentID());
        sb.append(", treeID=");
        sb.append(getTreeID());
        sb.append(", availableChildrenIDs=");
        sb.append(getAvailableChildrenIDs());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFActivityStateNode");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentID</column-name><column-value><![CDATA[");
        sb.append(getParentID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>treeID</column-name><column-value><![CDATA[");
        sb.append(getTreeID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>availableChildrenIDs</column-name><column-value><![CDATA[");
        sb.append(getAvailableChildrenIDs());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
