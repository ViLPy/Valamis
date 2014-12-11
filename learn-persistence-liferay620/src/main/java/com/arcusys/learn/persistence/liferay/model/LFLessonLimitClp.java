package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK;

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


public class LFLessonLimitClp extends BaseModelImpl<LFLessonLimit>
    implements LFLessonLimit {
    private Long _itemID;
    private String _itemType;
    private Integer _passingLimit;
    private Integer _rerunInterval;
    private String _rerunIntervalType;
    private BaseModel<?> _lfLessonLimitRemoteModel;

    public LFLessonLimitClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFLessonLimit.class;
    }

    @Override
    public String getModelClassName() {
        return LFLessonLimit.class.getName();
    }

    @Override
    public LFLessonLimitPK getPrimaryKey() {
        return new LFLessonLimitPK(_itemID, _itemType);
    }

    @Override
    public void setPrimaryKey(LFLessonLimitPK primaryKey) {
        setItemID(primaryKey.itemID);
        setItemType(primaryKey.itemType);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new LFLessonLimitPK(_itemID, _itemType);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((LFLessonLimitPK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("itemID", getItemID());
        attributes.put("itemType", getItemType());
        attributes.put("passingLimit", getPassingLimit());
        attributes.put("rerunInterval", getRerunInterval());
        attributes.put("rerunIntervalType", getRerunIntervalType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long itemID = (Long) attributes.get("itemID");

        if (itemID != null) {
            setItemID(itemID);
        }

        String itemType = (String) attributes.get("itemType");

        if (itemType != null) {
            setItemType(itemType);
        }

        Integer passingLimit = (Integer) attributes.get("passingLimit");

        if (passingLimit != null) {
            setPassingLimit(passingLimit);
        }

        Integer rerunInterval = (Integer) attributes.get("rerunInterval");

        if (rerunInterval != null) {
            setRerunInterval(rerunInterval);
        }

        String rerunIntervalType = (String) attributes.get("rerunIntervalType");

        if (rerunIntervalType != null) {
            setRerunIntervalType(rerunIntervalType);
        }
    }

    @Override
    public Long getItemID() {
        return _itemID;
    }

    @Override
    public void setItemID(Long itemID) {
        _itemID = itemID;

        if (_lfLessonLimitRemoteModel != null) {
            try {
                Class<?> clazz = _lfLessonLimitRemoteModel.getClass();

                Method method = clazz.getMethod("setItemID", Long.class);

                method.invoke(_lfLessonLimitRemoteModel, itemID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getItemType() {
        return _itemType;
    }

    @Override
    public void setItemType(String itemType) {
        _itemType = itemType;

        if (_lfLessonLimitRemoteModel != null) {
            try {
                Class<?> clazz = _lfLessonLimitRemoteModel.getClass();

                Method method = clazz.getMethod("setItemType", String.class);

                method.invoke(_lfLessonLimitRemoteModel, itemType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getPassingLimit() {
        return _passingLimit;
    }

    @Override
    public void setPassingLimit(Integer passingLimit) {
        _passingLimit = passingLimit;

        if (_lfLessonLimitRemoteModel != null) {
            try {
                Class<?> clazz = _lfLessonLimitRemoteModel.getClass();

                Method method = clazz.getMethod("setPassingLimit", Integer.class);

                method.invoke(_lfLessonLimitRemoteModel, passingLimit);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getRerunInterval() {
        return _rerunInterval;
    }

    @Override
    public void setRerunInterval(Integer rerunInterval) {
        _rerunInterval = rerunInterval;

        if (_lfLessonLimitRemoteModel != null) {
            try {
                Class<?> clazz = _lfLessonLimitRemoteModel.getClass();

                Method method = clazz.getMethod("setRerunInterval",
                        Integer.class);

                method.invoke(_lfLessonLimitRemoteModel, rerunInterval);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRerunIntervalType() {
        return _rerunIntervalType;
    }

    @Override
    public void setRerunIntervalType(String rerunIntervalType) {
        _rerunIntervalType = rerunIntervalType;

        if (_lfLessonLimitRemoteModel != null) {
            try {
                Class<?> clazz = _lfLessonLimitRemoteModel.getClass();

                Method method = clazz.getMethod("setRerunIntervalType",
                        String.class);

                method.invoke(_lfLessonLimitRemoteModel, rerunIntervalType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFLessonLimitRemoteModel() {
        return _lfLessonLimitRemoteModel;
    }

    public void setLFLessonLimitRemoteModel(
        BaseModel<?> lfLessonLimitRemoteModel) {
        _lfLessonLimitRemoteModel = lfLessonLimitRemoteModel;
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

        Class<?> remoteModelClass = _lfLessonLimitRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfLessonLimitRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFLessonLimitLocalServiceUtil.addLFLessonLimit(this);
        } else {
            LFLessonLimitLocalServiceUtil.updateLFLessonLimit(this);
        }
    }

    @Override
    public LFLessonLimit toEscapedModel() {
        return (LFLessonLimit) ProxyUtil.newProxyInstance(LFLessonLimit.class.getClassLoader(),
            new Class[] { LFLessonLimit.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFLessonLimitClp clone = new LFLessonLimitClp();

        clone.setItemID(getItemID());
        clone.setItemType(getItemType());
        clone.setPassingLimit(getPassingLimit());
        clone.setRerunInterval(getRerunInterval());
        clone.setRerunIntervalType(getRerunIntervalType());

        return clone;
    }

    @Override
    public int compareTo(LFLessonLimit lfLessonLimit) {
        LFLessonLimitPK primaryKey = lfLessonLimit.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFLessonLimitClp)) {
            return false;
        }

        LFLessonLimitClp lfLessonLimit = (LFLessonLimitClp) obj;

        LFLessonLimitPK primaryKey = lfLessonLimit.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{itemID=");
        sb.append(getItemID());
        sb.append(", itemType=");
        sb.append(getItemType());
        sb.append(", passingLimit=");
        sb.append(getPassingLimit());
        sb.append(", rerunInterval=");
        sb.append(getRerunInterval());
        sb.append(", rerunIntervalType=");
        sb.append(getRerunIntervalType());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFLessonLimit");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>itemID</column-name><column-value><![CDATA[");
        sb.append(getItemID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>itemType</column-name><column-value><![CDATA[");
        sb.append(getItemType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>passingLimit</column-name><column-value><![CDATA[");
        sb.append(getPassingLimit());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rerunInterval</column-name><column-value><![CDATA[");
        sb.append(getRerunInterval());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rerunIntervalType</column-name><column-value><![CDATA[");
        sb.append(getRerunIntervalType());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
