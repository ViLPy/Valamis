package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class LFTincanLrsDocumentClp extends BaseModelImpl<LFTincanLrsDocument>
    implements LFTincanLrsDocument {
    private long _id;
    private String _documentId;
    private Date _update;
    private String _content;
    private String _contentType;
    private BaseModel<?> _lfTincanLrsDocumentRemoteModel;

    public LFTincanLrsDocumentClp() {
    }

    public Class<?> getModelClass() {
        return LFTincanLrsDocument.class;
    }

    public String getModelClassName() {
        return LFTincanLrsDocument.class.getName();
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
        attributes.put("documentId", getDocumentId());
        attributes.put("update", getUpdate());
        attributes.put("content", getContent());
        attributes.put("contentType", getContentType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String documentId = (String) attributes.get("documentId");

        if (documentId != null) {
            setDocumentId(documentId);
        }

        Date update = (Date) attributes.get("update");

        if (update != null) {
            setUpdate(update);
        }

        String content = (String) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        String contentType = (String) attributes.get("contentType");

        if (contentType != null) {
            setContentType(contentType);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(String documentId) {
        _documentId = documentId;
    }

    public Date getUpdate() {
        return _update;
    }

    public void setUpdate(Date update) {
        _update = update;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }

    public String getContentType() {
        return _contentType;
    }

    public void setContentType(String contentType) {
        _contentType = contentType;
    }

    public BaseModel<?> getLFTincanLrsDocumentRemoteModel() {
        return _lfTincanLrsDocumentRemoteModel;
    }

    public void setLFTincanLrsDocumentRemoteModel(
        BaseModel<?> lfTincanLrsDocumentRemoteModel) {
        _lfTincanLrsDocumentRemoteModel = lfTincanLrsDocumentRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsDocumentLocalServiceUtil.addLFTincanLrsDocument(this);
        } else {
            LFTincanLrsDocumentLocalServiceUtil.updateLFTincanLrsDocument(this);
        }
    }

    @Override
    public LFTincanLrsDocument toEscapedModel() {
        return (LFTincanLrsDocument) Proxy.newProxyInstance(LFTincanLrsDocument.class.getClassLoader(),
            new Class[] { LFTincanLrsDocument.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsDocumentClp clone = new LFTincanLrsDocumentClp();

        clone.setId(getId());
        clone.setDocumentId(getDocumentId());
        clone.setUpdate(getUpdate());
        clone.setContent(getContent());
        clone.setContentType(getContentType());

        return clone;
    }

    public int compareTo(LFTincanLrsDocument lfTincanLrsDocument) {
        long primaryKey = lfTincanLrsDocument.getPrimaryKey();

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

        LFTincanLrsDocumentClp lfTincanLrsDocument = null;

        try {
            lfTincanLrsDocument = (LFTincanLrsDocumentClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfTincanLrsDocument.getPrimaryKey();

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
        sb.append(", documentId=");
        sb.append(getDocumentId());
        sb.append(", update=");
        sb.append(getUpdate());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", contentType=");
        sb.append(getContentType());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>documentId</column-name><column-value><![CDATA[");
        sb.append(getDocumentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>update</column-name><column-value><![CDATA[");
        sb.append(getUpdate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contentType</column-name><column-value><![CDATA[");
        sb.append(getContentType());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
