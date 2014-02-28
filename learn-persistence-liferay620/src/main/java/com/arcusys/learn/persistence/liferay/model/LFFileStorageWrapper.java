package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFFileStorage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFFileStorage
 * @generated
 */
public class LFFileStorageWrapper implements LFFileStorage,
    ModelWrapper<LFFileStorage> {
    private LFFileStorage _lfFileStorage;

    public LFFileStorageWrapper(LFFileStorage lfFileStorage) {
        _lfFileStorage = lfFileStorage;
    }

    @Override
    public Class<?> getModelClass() {
        return LFFileStorage.class;
    }

    @Override
    public String getModelClassName() {
        return LFFileStorage.class.getName();
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

    /**
    * Returns the primary key of this l f file storage.
    *
    * @return the primary key of this l f file storage
    */
    @Override
    public long getPrimaryKey() {
        return _lfFileStorage.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f file storage.
    *
    * @param primaryKey the primary key of this l f file storage
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfFileStorage.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f file storage.
    *
    * @return the ID of this l f file storage
    */
    @Override
    public long getId() {
        return _lfFileStorage.getId();
    }

    /**
    * Sets the ID of this l f file storage.
    *
    * @param id the ID of this l f file storage
    */
    @Override
    public void setId(long id) {
        _lfFileStorage.setId(id);
    }

    /**
    * Returns the filename of this l f file storage.
    *
    * @return the filename of this l f file storage
    */
    @Override
    public java.lang.String getFilename() {
        return _lfFileStorage.getFilename();
    }

    /**
    * Sets the filename of this l f file storage.
    *
    * @param filename the filename of this l f file storage
    */
    @Override
    public void setFilename(java.lang.String filename) {
        _lfFileStorage.setFilename(filename);
    }

    /**
    * Returns the content of this l f file storage.
    *
    * @return the content of this l f file storage
    */
    @Override
    public java.lang.String getContent() {
        return _lfFileStorage.getContent();
    }

    /**
    * Sets the content of this l f file storage.
    *
    * @param content the content of this l f file storage
    */
    @Override
    public void setContent(java.lang.String content) {
        _lfFileStorage.setContent(content);
    }

    @Override
    public boolean isNew() {
        return _lfFileStorage.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfFileStorage.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfFileStorage.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfFileStorage.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfFileStorage.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfFileStorage.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfFileStorage.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfFileStorage.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfFileStorage.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfFileStorage.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfFileStorage.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFFileStorageWrapper((LFFileStorage) _lfFileStorage.clone());
    }

    @Override
    public int compareTo(LFFileStorage lfFileStorage) {
        return _lfFileStorage.compareTo(lfFileStorage);
    }

    @Override
    public int hashCode() {
        return _lfFileStorage.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFFileStorage> toCacheModel() {
        return _lfFileStorage.toCacheModel();
    }

    @Override
    public LFFileStorage toEscapedModel() {
        return new LFFileStorageWrapper(_lfFileStorage.toEscapedModel());
    }

    @Override
    public LFFileStorage toUnescapedModel() {
        return new LFFileStorageWrapper(_lfFileStorage.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfFileStorage.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfFileStorage.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfFileStorage.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFFileStorageWrapper)) {
            return false;
        }

        LFFileStorageWrapper lfFileStorageWrapper = (LFFileStorageWrapper) obj;

        if (Validator.equals(_lfFileStorage, lfFileStorageWrapper._lfFileStorage)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFFileStorage getWrappedLFFileStorage() {
        return _lfFileStorage;
    }

    @Override
    public LFFileStorage getWrappedModel() {
        return _lfFileStorage;
    }

    @Override
    public void resetOriginalValues() {
        _lfFileStorage.resetOriginalValues();
    }
}
