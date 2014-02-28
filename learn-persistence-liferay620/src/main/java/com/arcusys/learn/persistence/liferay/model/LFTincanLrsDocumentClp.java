package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

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

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsDocument.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsDocument.class.getName();
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanLrsDocumentRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsDocumentRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanLrsDocumentRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDocumentId() {
        return _documentId;
    }

    @Override
    public void setDocumentId(String documentId) {
        _documentId = documentId;

        if (_lfTincanLrsDocumentRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsDocumentRemoteModel.getClass();

                Method method = clazz.getMethod("setDocumentId", String.class);

                method.invoke(_lfTincanLrsDocumentRemoteModel, documentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getUpdate() {
        return _update;
    }

    @Override
    public void setUpdate(Date update) {
        _update = update;

        if (_lfTincanLrsDocumentRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsDocumentRemoteModel.getClass();

                Method method = clazz.getMethod("setUpdate", Date.class);

                method.invoke(_lfTincanLrsDocumentRemoteModel, update);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContent() {
        return _content;
    }

    @Override
    public void setContent(String content) {
        _content = content;

        if (_lfTincanLrsDocumentRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsDocumentRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", String.class);

                method.invoke(_lfTincanLrsDocumentRemoteModel, content);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContentType() {
        return _contentType;
    }

    @Override
    public void setContentType(String contentType) {
        _contentType = contentType;

        if (_lfTincanLrsDocumentRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsDocumentRemoteModel.getClass();

                Method method = clazz.getMethod("setContentType", String.class);

                method.invoke(_lfTincanLrsDocumentRemoteModel, contentType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanLrsDocumentRemoteModel() {
        return _lfTincanLrsDocumentRemoteModel;
    }

    public void setLFTincanLrsDocumentRemoteModel(
        BaseModel<?> lfTincanLrsDocumentRemoteModel) {
        _lfTincanLrsDocumentRemoteModel = lfTincanLrsDocumentRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanLrsDocumentRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanLrsDocumentRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsDocumentLocalServiceUtil.addLFTincanLrsDocument(this);
        } else {
            LFTincanLrsDocumentLocalServiceUtil.updateLFTincanLrsDocument(this);
        }
    }

    @Override
    public LFTincanLrsDocument toEscapedModel() {
        return (LFTincanLrsDocument) ProxyUtil.newProxyInstance(LFTincanLrsDocument.class.getClassLoader(),
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

    @Override
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanLrsDocumentClp)) {
            return false;
        }

        LFTincanLrsDocumentClp lfTincanLrsDocument = (LFTincanLrsDocumentClp) obj;

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

    @Override
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
