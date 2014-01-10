package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFTincanLrsAttachment}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFTincanLrsAttachment
* @generated
*/
public class LFTincanLrsAttachmentWrapper implements LFTincanLrsAttachment,
    ModelWrapper<LFTincanLrsAttachment> {
    private LFTincanLrsAttachment _lfTincanLrsAttachment;

    public LFTincanLrsAttachmentWrapper(
        LFTincanLrsAttachment lfTincanLrsAttachment) {
        _lfTincanLrsAttachment = lfTincanLrsAttachment;
    }

    public Class<?> getModelClass() {
        return LFTincanLrsAttachment.class;
    }

    public String getModelClassName() {
        return LFTincanLrsAttachment.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("parentID", getParentID());
        attributes.put("usageType", getUsageType());
        attributes.put("display", getDisplay());
        attributes.put("description", getDescription());
        attributes.put("contentType", getContentType());
        attributes.put("length", getLength());
        attributes.put("sha2", getSha2());
        attributes.put("fileUrl", getFileUrl());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer parentID = (Integer) attributes.get("parentID");

        if (parentID != null) {
            setParentID(parentID);
        }

        String usageType = (String) attributes.get("usageType");

        if (usageType != null) {
            setUsageType(usageType);
        }

        String display = (String) attributes.get("display");

        if (display != null) {
            setDisplay(display);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String contentType = (String) attributes.get("contentType");

        if (contentType != null) {
            setContentType(contentType);
        }

        Integer length = (Integer) attributes.get("length");

        if (length != null) {
            setLength(length);
        }

        String sha2 = (String) attributes.get("sha2");

        if (sha2 != null) {
            setSha2(sha2);
        }

        String fileUrl = (String) attributes.get("fileUrl");

        if (fileUrl != null) {
            setFileUrl(fileUrl);
        }
    }

    /**
     * Returns the primary key of this l f tincan lrs attachment.
     *
     * @return the primary key of this l f tincan lrs attachment
     */
    public long getPrimaryKey() {
        return _lfTincanLrsAttachment.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f tincan lrs attachment.
     *
     * @param primaryKey the primary key of this l f tincan lrs attachment
     */
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsAttachment.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f tincan lrs attachment.
     *
     * @return the ID of this l f tincan lrs attachment
     */
    public long getId() {
        return _lfTincanLrsAttachment.getId();
    }

    /**
     * Sets the ID of this l f tincan lrs attachment.
     *
     * @param id the ID of this l f tincan lrs attachment
     */
    public void setId(long id) {
        _lfTincanLrsAttachment.setId(id);
    }

    /**
     * Returns the parent i d of this l f tincan lrs attachment.
     *
     * @return the parent i d of this l f tincan lrs attachment
     */
    public java.lang.Integer getParentID() {
        return _lfTincanLrsAttachment.getParentID();
    }

    /**
     * Sets the parent i d of this l f tincan lrs attachment.
     *
     * @param parentID the parent i d of this l f tincan lrs attachment
     */
    public void setParentID(java.lang.Integer parentID) {
        _lfTincanLrsAttachment.setParentID(parentID);
    }

    /**
     * Returns the usage type of this l f tincan lrs attachment.
     *
     * @return the usage type of this l f tincan lrs attachment
     */
    public java.lang.String getUsageType() {
        return _lfTincanLrsAttachment.getUsageType();
    }

    /**
     * Sets the usage type of this l f tincan lrs attachment.
     *
     * @param usageType the usage type of this l f tincan lrs attachment
     */
    public void setUsageType(java.lang.String usageType) {
        _lfTincanLrsAttachment.setUsageType(usageType);
    }

    /**
     * Returns the display of this l f tincan lrs attachment.
     *
     * @return the display of this l f tincan lrs attachment
     */
    public java.lang.String getDisplay() {
        return _lfTincanLrsAttachment.getDisplay();
    }

    /**
     * Sets the display of this l f tincan lrs attachment.
     *
     * @param display the display of this l f tincan lrs attachment
     */
    public void setDisplay(java.lang.String display) {
        _lfTincanLrsAttachment.setDisplay(display);
    }

    /**
     * Returns the description of this l f tincan lrs attachment.
     *
     * @return the description of this l f tincan lrs attachment
     */
    public java.lang.String getDescription() {
        return _lfTincanLrsAttachment.getDescription();
    }

    /**
     * Sets the description of this l f tincan lrs attachment.
     *
     * @param description the description of this l f tincan lrs attachment
     */
    public void setDescription(java.lang.String description) {
        _lfTincanLrsAttachment.setDescription(description);
    }

    /**
     * Returns the content type of this l f tincan lrs attachment.
     *
     * @return the content type of this l f tincan lrs attachment
     */
    public java.lang.String getContentType() {
        return _lfTincanLrsAttachment.getContentType();
    }

    /**
     * Sets the content type of this l f tincan lrs attachment.
     *
     * @param contentType the content type of this l f tincan lrs attachment
     */
    public void setContentType(java.lang.String contentType) {
        _lfTincanLrsAttachment.setContentType(contentType);
    }

    /**
     * Returns the length of this l f tincan lrs attachment.
     *
     * @return the length of this l f tincan lrs attachment
     */
    public java.lang.Integer getLength() {
        return _lfTincanLrsAttachment.getLength();
    }

    /**
     * Sets the length of this l f tincan lrs attachment.
     *
     * @param length the length of this l f tincan lrs attachment
     */
    public void setLength(java.lang.Integer length) {
        _lfTincanLrsAttachment.setLength(length);
    }

    /**
     * Returns the sha2 of this l f tincan lrs attachment.
     *
     * @return the sha2 of this l f tincan lrs attachment
     */
    public java.lang.String getSha2() {
        return _lfTincanLrsAttachment.getSha2();
    }

    /**
     * Sets the sha2 of this l f tincan lrs attachment.
     *
     * @param sha2 the sha2 of this l f tincan lrs attachment
     */
    public void setSha2(java.lang.String sha2) {
        _lfTincanLrsAttachment.setSha2(sha2);
    }

    /**
     * Returns the file url of this l f tincan lrs attachment.
     *
     * @return the file url of this l f tincan lrs attachment
     */
    public java.lang.String getFileUrl() {
        return _lfTincanLrsAttachment.getFileUrl();
    }

    /**
     * Sets the file url of this l f tincan lrs attachment.
     *
     * @param fileUrl the file url of this l f tincan lrs attachment
     */
    public void setFileUrl(java.lang.String fileUrl) {
        _lfTincanLrsAttachment.setFileUrl(fileUrl);
    }

    public boolean isNew() {
        return _lfTincanLrsAttachment.isNew();
    }

    public void setNew(boolean n) {
        _lfTincanLrsAttachment.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfTincanLrsAttachment.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsAttachment.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfTincanLrsAttachment.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsAttachment.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsAttachment.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsAttachment.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsAttachment.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsAttachmentWrapper((LFTincanLrsAttachment) _lfTincanLrsAttachment.clone());
    }

    public int compareTo(LFTincanLrsAttachment lfTincanLrsAttachment) {
        return _lfTincanLrsAttachment.compareTo(lfTincanLrsAttachment);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsAttachment.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFTincanLrsAttachment> toCacheModel() {
        return _lfTincanLrsAttachment.toCacheModel();
    }

    public LFTincanLrsAttachment toEscapedModel() {
        return new LFTincanLrsAttachmentWrapper(_lfTincanLrsAttachment.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsAttachment.toString();
    }

    public java.lang.String toXmlString() {
        return _lfTincanLrsAttachment.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsAttachment.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFTincanLrsAttachment getWrappedLFTincanLrsAttachment() {
        return _lfTincanLrsAttachment;
    }

    public LFTincanLrsAttachment getWrappedModel() {
        return _lfTincanLrsAttachment;
    }

    public void resetOriginalValues() {
        _lfTincanLrsAttachment.resetOriginalValues();
    }
}
