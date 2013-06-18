package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFBigDecimalLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

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

    public Class<?> getModelClass() {
        return LFBigDecimal.class;
    }

    public String getModelClassName() {
        return LFBigDecimal.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public BigDecimal getDecimal() {
        return _decimal;
    }

    public void setDecimal(BigDecimal decimal) {
        _decimal = decimal;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        _text = text;
    }

    public BaseModel<?> getLFBigDecimalRemoteModel() {
        return _lfBigDecimalRemoteModel;
    }

    public void setLFBigDecimalRemoteModel(BaseModel<?> lfBigDecimalRemoteModel) {
        _lfBigDecimalRemoteModel = lfBigDecimalRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFBigDecimalLocalServiceUtil.addLFBigDecimal(this);
        } else {
            LFBigDecimalLocalServiceUtil.updateLFBigDecimal(this);
        }
    }

    @Override
    public LFBigDecimal toEscapedModel() {
        return (LFBigDecimal) Proxy.newProxyInstance(LFBigDecimal.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFBigDecimalClp lfBigDecimal = null;

        try {
            lfBigDecimal = (LFBigDecimalClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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
