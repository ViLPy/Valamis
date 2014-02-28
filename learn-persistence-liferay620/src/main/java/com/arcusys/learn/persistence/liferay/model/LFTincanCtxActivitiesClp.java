package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanCtxActivitiesLocalServiceUtil;

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


public class LFTincanCtxActivitiesClp extends BaseModelImpl<LFTincanCtxActivities>
    implements LFTincanCtxActivities {
    private long _id;
    private String _parent;
    private String _grouping;
    private String _category;
    private String _other;
    private BaseModel<?> _lfTincanCtxActivitiesRemoteModel;

    public LFTincanCtxActivitiesClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanCtxActivities.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanCtxActivities.class.getName();
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
        attributes.put("parent", getParent());
        attributes.put("grouping", getGrouping());
        attributes.put("category", getCategory());
        attributes.put("other", getOther());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String parent = (String) attributes.get("parent");

        if (parent != null) {
            setParent(parent);
        }

        String grouping = (String) attributes.get("grouping");

        if (grouping != null) {
            setGrouping(grouping);
        }

        String category = (String) attributes.get("category");

        if (category != null) {
            setCategory(category);
        }

        String other = (String) attributes.get("other");

        if (other != null) {
            setOther(other);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanCtxActivitiesRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanCtxActivitiesRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanCtxActivitiesRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getParent() {
        return _parent;
    }

    @Override
    public void setParent(String parent) {
        _parent = parent;

        if (_lfTincanCtxActivitiesRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanCtxActivitiesRemoteModel.getClass();

                Method method = clazz.getMethod("setParent", String.class);

                method.invoke(_lfTincanCtxActivitiesRemoteModel, parent);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getGrouping() {
        return _grouping;
    }

    @Override
    public void setGrouping(String grouping) {
        _grouping = grouping;

        if (_lfTincanCtxActivitiesRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanCtxActivitiesRemoteModel.getClass();

                Method method = clazz.getMethod("setGrouping", String.class);

                method.invoke(_lfTincanCtxActivitiesRemoteModel, grouping);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCategory() {
        return _category;
    }

    @Override
    public void setCategory(String category) {
        _category = category;

        if (_lfTincanCtxActivitiesRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanCtxActivitiesRemoteModel.getClass();

                Method method = clazz.getMethod("setCategory", String.class);

                method.invoke(_lfTincanCtxActivitiesRemoteModel, category);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOther() {
        return _other;
    }

    @Override
    public void setOther(String other) {
        _other = other;

        if (_lfTincanCtxActivitiesRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanCtxActivitiesRemoteModel.getClass();

                Method method = clazz.getMethod("setOther", String.class);

                method.invoke(_lfTincanCtxActivitiesRemoteModel, other);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanCtxActivitiesRemoteModel() {
        return _lfTincanCtxActivitiesRemoteModel;
    }

    public void setLFTincanCtxActivitiesRemoteModel(
        BaseModel<?> lfTincanCtxActivitiesRemoteModel) {
        _lfTincanCtxActivitiesRemoteModel = lfTincanCtxActivitiesRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanCtxActivitiesRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanCtxActivitiesRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanCtxActivitiesLocalServiceUtil.addLFTincanCtxActivities(this);
        } else {
            LFTincanCtxActivitiesLocalServiceUtil.updateLFTincanCtxActivities(this);
        }
    }

    @Override
    public LFTincanCtxActivities toEscapedModel() {
        return (LFTincanCtxActivities) ProxyUtil.newProxyInstance(LFTincanCtxActivities.class.getClassLoader(),
            new Class[] { LFTincanCtxActivities.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanCtxActivitiesClp clone = new LFTincanCtxActivitiesClp();

        clone.setId(getId());
        clone.setParent(getParent());
        clone.setGrouping(getGrouping());
        clone.setCategory(getCategory());
        clone.setOther(getOther());

        return clone;
    }

    @Override
    public int compareTo(LFTincanCtxActivities lfTincanCtxActivities) {
        long primaryKey = lfTincanCtxActivities.getPrimaryKey();

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

        if (!(obj instanceof LFTincanCtxActivitiesClp)) {
            return false;
        }

        LFTincanCtxActivitiesClp lfTincanCtxActivities = (LFTincanCtxActivitiesClp) obj;

        long primaryKey = lfTincanCtxActivities.getPrimaryKey();

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
        sb.append(", parent=");
        sb.append(getParent());
        sb.append(", grouping=");
        sb.append(getGrouping());
        sb.append(", category=");
        sb.append(getCategory());
        sb.append(", other=");
        sb.append(getOther());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parent</column-name><column-value><![CDATA[");
        sb.append(getParent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>grouping</column-name><column-value><![CDATA[");
        sb.append(getGrouping());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>category</column-name><column-value><![CDATA[");
        sb.append(getCategory());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>other</column-name><column-value><![CDATA[");
        sb.append(getOther());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
