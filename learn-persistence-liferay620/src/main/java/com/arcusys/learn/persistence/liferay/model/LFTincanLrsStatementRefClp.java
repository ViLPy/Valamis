package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalServiceUtil;

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


public class LFTincanLrsStatementRefClp extends BaseModelImpl<LFTincanLrsStatementRef>
    implements LFTincanLrsStatementRef {
    private long _id;
    private String _uuid;
    private BaseModel<?> _lfTincanLrsStatementRefRemoteModel;

    public LFTincanLrsStatementRefClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsStatementRef.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsStatementRef.class.getName();
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
        attributes.put("uuid", getUuid());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanLrsStatementRefRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRefRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanLrsStatementRefRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_lfTincanLrsStatementRefRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStatementRefRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_lfTincanLrsStatementRefRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanLrsStatementRefRemoteModel() {
        return _lfTincanLrsStatementRefRemoteModel;
    }

    public void setLFTincanLrsStatementRefRemoteModel(
        BaseModel<?> lfTincanLrsStatementRefRemoteModel) {
        _lfTincanLrsStatementRefRemoteModel = lfTincanLrsStatementRefRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanLrsStatementRefRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanLrsStatementRefRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsStatementRefLocalServiceUtil.addLFTincanLrsStatementRef(this);
        } else {
            LFTincanLrsStatementRefLocalServiceUtil.updateLFTincanLrsStatementRef(this);
        }
    }

    @Override
    public LFTincanLrsStatementRef toEscapedModel() {
        return (LFTincanLrsStatementRef) ProxyUtil.newProxyInstance(LFTincanLrsStatementRef.class.getClassLoader(),
            new Class[] { LFTincanLrsStatementRef.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsStatementRefClp clone = new LFTincanLrsStatementRefClp();

        clone.setId(getId());
        clone.setUuid(getUuid());

        return clone;
    }

    @Override
    public int compareTo(LFTincanLrsStatementRef lfTincanLrsStatementRef) {
        long primaryKey = lfTincanLrsStatementRef.getPrimaryKey();

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

        if (!(obj instanceof LFTincanLrsStatementRefClp)) {
            return false;
        }

        LFTincanLrsStatementRefClp lfTincanLrsStatementRef = (LFTincanLrsStatementRefClp) obj;

        long primaryKey = lfTincanLrsStatementRef.getPrimaryKey();

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
        StringBundler sb = new StringBundler(5);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", uuid=");
        sb.append(getUuid());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
