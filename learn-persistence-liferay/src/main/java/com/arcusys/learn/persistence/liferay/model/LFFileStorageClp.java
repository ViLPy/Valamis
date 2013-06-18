package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFFileStorageClp extends BaseModelImpl<LFFileStorage>
    implements LFFileStorage {
    private long _id;
    private String _filename;
    private String _content;
    private BaseModel<?> _lfFileStorageRemoteModel;

    public LFFileStorageClp() {
    }

    public Class<?> getModelClass() {
        return LFFileStorage.class;
    }

    public String getModelClassName() {
        return LFFileStorage.class.getName();
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
        attributes.put("filename", getFilename());
        attributes.put("content", getContent());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String filename = (String) attributes.get("filename");

        if (filename != null) {
            setFilename(filename);
        }

        String content = (String) attributes.get("content");

        if (content != null) {
            setContent(content);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getFilename() {
        return _filename;
    }

    public void setFilename(String filename) {
        _filename = filename;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }

    public BaseModel<?> getLFFileStorageRemoteModel() {
        return _lfFileStorageRemoteModel;
    }

    public void setLFFileStorageRemoteModel(
        BaseModel<?> lfFileStorageRemoteModel) {
        _lfFileStorageRemoteModel = lfFileStorageRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFFileStorageLocalServiceUtil.addLFFileStorage(this);
        } else {
            LFFileStorageLocalServiceUtil.updateLFFileStorage(this);
        }
    }

    @Override
    public LFFileStorage toEscapedModel() {
        return (LFFileStorage) Proxy.newProxyInstance(LFFileStorage.class.getClassLoader(),
            new Class[] { LFFileStorage.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFFileStorageClp clone = new LFFileStorageClp();

        clone.setId(getId());
        clone.setFilename(getFilename());
        clone.setContent(getContent());

        return clone;
    }

    public int compareTo(LFFileStorage lfFileStorage) {
        long primaryKey = lfFileStorage.getPrimaryKey();

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

        LFFileStorageClp lfFileStorage = null;

        try {
            lfFileStorage = (LFFileStorageClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfFileStorage.getPrimaryKey();

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
        sb.append(", filename=");
        sb.append(getFilename());
        sb.append(", content=");
        sb.append(getContent());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFFileStorage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>filename</column-name><column-value><![CDATA[");
        sb.append(getFilename());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
