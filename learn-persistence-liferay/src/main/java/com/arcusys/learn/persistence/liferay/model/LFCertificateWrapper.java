package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFCertificate}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFCertificate
* @generated
*/
public class LFCertificateWrapper implements LFCertificate,
    ModelWrapper<LFCertificate> {
    private LFCertificate _lfCertificate;

    public LFCertificateWrapper(LFCertificate lfCertificate) {
        _lfCertificate = lfCertificate;
    }

    public Class<?> getModelClass() {
        return LFCertificate.class;
    }

    public String getModelClassName() {
        return LFCertificate.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());

        return attributes;
    }

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

    /**
     * Returns the primary key of this l f certificate.
     *
     * @return the primary key of this l f certificate
     */
    public long getPrimaryKey() {
        return _lfCertificate.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f certificate.
     *
     * @param primaryKey the primary key of this l f certificate
     */
    public void setPrimaryKey(long primaryKey) {
        _lfCertificate.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f certificate.
     *
     * @return the ID of this l f certificate
     */
    public long getId() {
        return _lfCertificate.getId();
    }

    /**
     * Sets the ID of this l f certificate.
     *
     * @param id the ID of this l f certificate
     */
    public void setId(long id) {
        _lfCertificate.setId(id);
    }

    /**
     * Returns the title of this l f certificate.
     *
     * @return the title of this l f certificate
     */
    public java.lang.String getTitle() {
        return _lfCertificate.getTitle();
    }

    /**
     * Sets the title of this l f certificate.
     *
     * @param title the title of this l f certificate
     */
    public void setTitle(java.lang.String title) {
        _lfCertificate.setTitle(title);
    }

    /**
     * Returns the description of this l f certificate.
     *
     * @return the description of this l f certificate
     */
    public java.lang.String getDescription() {
        return _lfCertificate.getDescription();
    }

    /**
     * Sets the description of this l f certificate.
     *
     * @param description the description of this l f certificate
     */
    public void setDescription(java.lang.String description) {
        _lfCertificate.setDescription(description);
    }

    public boolean isNew() {
        return _lfCertificate.isNew();
    }

    public void setNew(boolean n) {
        _lfCertificate.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfCertificate.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfCertificate.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfCertificate.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfCertificate.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfCertificate.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfCertificate.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfCertificate.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFCertificateWrapper((LFCertificate) _lfCertificate.clone());
    }

    public int compareTo(LFCertificate lfCertificate) {
        return _lfCertificate.compareTo(lfCertificate);
    }

    @Override
    public int hashCode() {
        return _lfCertificate.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFCertificate> toCacheModel() {
        return _lfCertificate.toCacheModel();
    }

    public LFCertificate toEscapedModel() {
        return new LFCertificateWrapper(_lfCertificate.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfCertificate.toString();
    }

    public java.lang.String toXmlString() {
        return _lfCertificate.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificate.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFCertificate getWrappedLFCertificate() {
        return _lfCertificate;
    }

    public LFCertificate getWrappedModel() {
        return _lfCertificate;
    }

    public void resetOriginalValues() {
        _lfCertificate.resetOriginalValues();
    }
}
