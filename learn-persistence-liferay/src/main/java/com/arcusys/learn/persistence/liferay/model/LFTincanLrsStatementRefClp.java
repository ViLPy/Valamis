package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFTincanLrsStatementRefClp extends BaseModelImpl<LFTincanLrsStatementRef>
    implements LFTincanLrsStatementRef {
    private long _id;
    private String _uuid;
    private BaseModel<?> _lfTincanLrsStatementRefRemoteModel;

    public LFTincanLrsStatementRefClp() {
    }

    public Class<?> getModelClass() {
        return LFTincanLrsStatementRef.class;
    }

    public String getModelClassName() {
        return LFTincanLrsStatementRef.class.getName();
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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public BaseModel<?> getLFTincanLrsStatementRefRemoteModel() {
        return _lfTincanLrsStatementRefRemoteModel;
    }

    public void setLFTincanLrsStatementRefRemoteModel(
        BaseModel<?> lfTincanLrsStatementRefRemoteModel) {
        _lfTincanLrsStatementRefRemoteModel = lfTincanLrsStatementRefRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsStatementRefLocalServiceUtil.addLFTincanLrsStatementRef(this);
        } else {
            LFTincanLrsStatementRefLocalServiceUtil.updateLFTincanLrsStatementRef(this);
        }
    }

    @Override
    public LFTincanLrsStatementRef toEscapedModel() {
        return (LFTincanLrsStatementRef) Proxy.newProxyInstance(LFTincanLrsStatementRef.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFTincanLrsStatementRefClp lfTincanLrsStatementRef = null;

        try {
            lfTincanLrsStatementRef = (LFTincanLrsStatementRefClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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
