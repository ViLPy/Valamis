package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFCertificateLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFCertificateClp extends BaseModelImpl<LFCertificate>
    implements LFCertificate {
    private long _id;
    private String _title;
    private String _description;
    private BaseModel<?> _lfCertificateRemoteModel;

    public LFCertificateClp() {
    }

    public Class<?> getModelClass() {
        return LFCertificate.class;
    }

    public String getModelClassName() {
        return LFCertificate.class.getName();
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
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public BaseModel<?> getLFCertificateRemoteModel() {
        return _lfCertificateRemoteModel;
    }

    public void setLFCertificateRemoteModel(
        BaseModel<?> lfCertificateRemoteModel) {
        _lfCertificateRemoteModel = lfCertificateRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFCertificateLocalServiceUtil.addLFCertificate(this);
        } else {
            LFCertificateLocalServiceUtil.updateLFCertificate(this);
        }
    }

    @Override
    public LFCertificate toEscapedModel() {
        return (LFCertificate) Proxy.newProxyInstance(LFCertificate.class.getClassLoader(),
            new Class[] { LFCertificate.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFCertificateClp clone = new LFCertificateClp();

        clone.setId(getId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(LFCertificate lfCertificate) {
        long primaryKey = lfCertificate.getPrimaryKey();

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

        LFCertificateClp lfCertificate = null;

        try {
            lfCertificate = (LFCertificateClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfCertificate.getPrimaryKey();

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
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFCertificate");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
