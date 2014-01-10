package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFTincanLrsDocument}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFTincanLrsDocument
* @generated
*/
public class LFTincanLrsDocumentWrapper implements LFTincanLrsDocument,
    ModelWrapper<LFTincanLrsDocument> {
    private LFTincanLrsDocument _lfTincanLrsDocument;

    public LFTincanLrsDocumentWrapper(LFTincanLrsDocument lfTincanLrsDocument) {
        _lfTincanLrsDocument = lfTincanLrsDocument;
    }

    public Class<?> getModelClass() {
        return LFTincanLrsDocument.class;
    }

    public String getModelClassName() {
        return LFTincanLrsDocument.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("documentId", getDocumentId());
        attributes.put("update", getUpdate());
        attributes.put("content", getContent());
        attributes.put("contentType", getContentType());

        return attributes;
    }

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

    /**
     * Returns the primary key of this l f tincan lrs document.
     *
     * @return the primary key of this l f tincan lrs document
     */
    public long getPrimaryKey() {
        return _lfTincanLrsDocument.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f tincan lrs document.
     *
     * @param primaryKey the primary key of this l f tincan lrs document
     */
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsDocument.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f tincan lrs document.
     *
     * @return the ID of this l f tincan lrs document
     */
    public long getId() {
        return _lfTincanLrsDocument.getId();
    }

    /**
     * Sets the ID of this l f tincan lrs document.
     *
     * @param id the ID of this l f tincan lrs document
     */
    public void setId(long id) {
        _lfTincanLrsDocument.setId(id);
    }

    /**
     * Returns the document ID of this l f tincan lrs document.
     *
     * @return the document ID of this l f tincan lrs document
     */
    public java.lang.String getDocumentId() {
        return _lfTincanLrsDocument.getDocumentId();
    }

    /**
     * Sets the document ID of this l f tincan lrs document.
     *
     * @param documentId the document ID of this l f tincan lrs document
     */
    public void setDocumentId(java.lang.String documentId) {
        _lfTincanLrsDocument.setDocumentId(documentId);
    }

    /**
     * Returns the update of this l f tincan lrs document.
     *
     * @return the update of this l f tincan lrs document
     */
    public java.util.Date getUpdate() {
        return _lfTincanLrsDocument.getUpdate();
    }

    /**
     * Sets the update of this l f tincan lrs document.
     *
     * @param update the update of this l f tincan lrs document
     */
    public void setUpdate(java.util.Date update) {
        _lfTincanLrsDocument.setUpdate(update);
    }

    /**
     * Returns the content of this l f tincan lrs document.
     *
     * @return the content of this l f tincan lrs document
     */
    public java.lang.String getContent() {
        return _lfTincanLrsDocument.getContent();
    }

    /**
     * Sets the content of this l f tincan lrs document.
     *
     * @param content the content of this l f tincan lrs document
     */
    public void setContent(java.lang.String content) {
        _lfTincanLrsDocument.setContent(content);
    }

    /**
     * Returns the content type of this l f tincan lrs document.
     *
     * @return the content type of this l f tincan lrs document
     */
    public java.lang.String getContentType() {
        return _lfTincanLrsDocument.getContentType();
    }

    /**
     * Sets the content type of this l f tincan lrs document.
     *
     * @param contentType the content type of this l f tincan lrs document
     */
    public void setContentType(java.lang.String contentType) {
        _lfTincanLrsDocument.setContentType(contentType);
    }

    public boolean isNew() {
        return _lfTincanLrsDocument.isNew();
    }

    public void setNew(boolean n) {
        _lfTincanLrsDocument.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfTincanLrsDocument.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsDocument.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfTincanLrsDocument.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsDocument.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsDocument.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsDocument.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsDocument.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsDocumentWrapper((LFTincanLrsDocument) _lfTincanLrsDocument.clone());
    }

    public int compareTo(LFTincanLrsDocument lfTincanLrsDocument) {
        return _lfTincanLrsDocument.compareTo(lfTincanLrsDocument);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsDocument.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFTincanLrsDocument> toCacheModel() {
        return _lfTincanLrsDocument.toCacheModel();
    }

    public LFTincanLrsDocument toEscapedModel() {
        return new LFTincanLrsDocumentWrapper(_lfTincanLrsDocument.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsDocument.toString();
    }

    public java.lang.String toXmlString() {
        return _lfTincanLrsDocument.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsDocument.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFTincanLrsDocument getWrappedLFTincanLrsDocument() {
        return _lfTincanLrsDocument;
    }

    public LFTincanLrsDocument getWrappedModel() {
        return _lfTincanLrsDocument;
    }

    public void resetOriginalValues() {
        _lfTincanLrsDocument.resetOriginalValues();
    }
}
