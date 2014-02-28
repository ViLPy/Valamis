package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFBigDecimalLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;


public class LFBigDecimalClp extends BaseModelImpl<LFBigDecimal>
    implements LFBigDecimal {
    private long _id;
    private BigDecimal _decimal;
    private String _text;
    private BaseModel<?> _lfBigDecimalRemoteModel;

    public LFBigDecimalClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFBigDecimal.class;
    }

    @Override
    public String getModelClassName() {
        return LFBigDecimal.class.getName();
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
        attributes.put("decimal", getDecimal());
        attributes.put("text", getText());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        BigDecimal decimal = (BigDecimal) attributes.get("decimal");

        if (decimal != null) {
            setDecimal(decimal);
        }

        String text = (String) attributes.get("text");

        if (text != null) {
            setText(text);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfBigDecimalRemoteModel != null) {
            try {
                Class<?> clazz = _lfBigDecimalRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfBigDecimalRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public BigDecimal getDecimal() {
        return _decimal;
    }

    @Override
    public void setDecimal(BigDecimal decimal) {
        _decimal = decimal;

        if (_lfBigDecimalRemoteModel != null) {
            try {
                Class<?> clazz = _lfBigDecimalRemoteModel.getClass();

                Method method = clazz.getMethod("setDecimal", BigDecimal.class);

                method.invoke(_lfBigDecimalRemoteModel, decimal);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getText() {
        return _text;
    }

    @Override
    public void setText(String text) {
        _text = text;

        if (_lfBigDecimalRemoteModel != null) {
            try {
                Class<?> clazz = _lfBigDecimalRemoteModel.getClass();

                Method method = clazz.getMethod("setText", String.class);

                method.invoke(_lfBigDecimalRemoteModel, text);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFBigDecimalRemoteModel() {
        return _lfBigDecimalRemoteModel;
    }

    public void setLFBigDecimalRemoteModel(BaseModel<?> lfBigDecimalRemoteModel) {
        _lfBigDecimalRemoteModel = lfBigDecimalRemoteModel;
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

        Class<?> remoteModelClass = _lfBigDecimalRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfBigDecimalRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFBigDecimalLocalServiceUtil.addLFBigDecimal(this);
        } else {
            LFBigDecimalLocalServiceUtil.updateLFBigDecimal(this);
        }
    }

    @Override
    public LFBigDecimal toEscapedModel() {
        return (LFBigDecimal) ProxyUtil.newProxyInstance(LFBigDecimal.class.getClassLoader(),
            new Class[] { LFBigDecimal.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFBigDecimalClp clone = new LFBigDecimalClp();

        clone.setId(getId());
        clone.setDecimal(getDecimal());
        clone.setText(getText());

        return clone;
    }

    @Override
    public int compareTo(LFBigDecimal lfBigDecimal) {
        long primaryKey = lfBigDecimal.getPrimaryKey();

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

        if (!(obj instanceof LFBigDecimalClp)) {
            return false;
        }

        LFBigDecimalClp lfBigDecimal = (LFBigDecimalClp) obj;

        long primaryKey = lfBigDecimal.getPrimaryKey();

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
        sb.append(", decimal=");
        sb.append(getDecimal());
        sb.append(", text=");
        sb.append(getText());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFBigDecimal");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>decimal</column-name><column-value><![CDATA[");
        sb.append(getDecimal());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>text</column-name><column-value><![CDATA[");
        sb.append(getText());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
