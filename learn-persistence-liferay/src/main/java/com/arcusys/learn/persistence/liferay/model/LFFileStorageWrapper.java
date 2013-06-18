package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFFileStorage}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFFileStorage
* @generated
*/
public class LFFileStorageWrapper implements LFFileStorage,
    ModelWrapper<LFFileStorage> {
    private LFFileStorage _lfFileStorage;

    public LFFileStorageWrapper(LFFileStorage lfFileStorage) {
        _lfFileStorage = lfFileStorage;
    }

    public Class<?> getModelClass() {
        return LFFileStorage.class;
    }

    public String getModelClassName() {
        return LFFileStorage.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("filename", getFilename());
        attributes.put("content", getContent());

        return attributes;
    }

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
    public long getPrimaryKey() {
        return _lfFileStorage.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f file storage.
     *
     * @param primaryKey the primary key of this l f file storage
     */
    public void setPrimaryKey(long primaryKey) {
        _lfFileStorage.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f file storage.
     *
     * @return the ID of this l f file storage
     */
    public long getId() {
        return _lfFileStorage.getId();
    }

    /**
     * Sets the ID of this l f file storage.
     *
     * @param id the ID of this l f file storage
     */
    public void setId(long id) {
        _lfFileStorage.setId(id);
    }

    /**
     * Returns the filename of this l f file storage.
     *
     * @return the filename of this l f file storage
     */
    public java.lang.String getFilename() {
        return _lfFileStorage.getFilename();
    }

    /**
     * Sets the filename of this l f file storage.
     *
     * @param filename the filename of this l f file storage
     */
    public void setFilename(java.lang.String filename) {
        _lfFileStorage.setFilename(filename);
    }

    /**
     * Returns the content of this l f file storage.
     *
     * @return the content of this l f file storage
     */
    public java.lang.String getContent() {
        return _lfFileStorage.getContent();
    }

    /**
     * Sets the content of this l f file storage.
     *
     * @param content the content of this l f file storage
     */
    public void setContent(java.lang.String content) {
        _lfFileStorage.setContent(content);
    }

    public boolean isNew() {
        return _lfFileStorage.isNew();
    }

    public void setNew(boolean n) {
        _lfFileStorage.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfFileStorage.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfFileStorage.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfFileStorage.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfFileStorage.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfFileStorage.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfFileStorage.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfFileStorage.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFFileStorageWrapper((LFFileStorage) _lfFileStorage.clone());
    }

    public int compareTo(LFFileStorage lfFileStorage) {
        return _lfFileStorage.compareTo(lfFileStorage);
    }

    @Override
    public int hashCode() {
        return _lfFileStorage.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFFileStorage> toCacheModel() {
        return _lfFileStorage.toCacheModel();
    }

    public LFFileStorage toEscapedModel() {
        return new LFFileStorageWrapper(_lfFileStorage.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfFileStorage.toString();
    }

    public java.lang.String toXmlString() {
        return _lfFileStorage.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfFileStorage.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFFileStorage getWrappedLFFileStorage() {
        return _lfFileStorage;
    }

    public LFFileStorage getWrappedModel() {
        return _lfFileStorage;
    }

    public void resetOriginalValues() {
        _lfFileStorage.resetOriginalValues();
    }
}
