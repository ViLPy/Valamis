package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFCertificate}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificate
 * @generated
 */
public class LFCertificateWrapper implements LFCertificate,
    ModelWrapper<LFCertificate> {
    private LFCertificate _lfCertificate;

    public LFCertificateWrapper(LFCertificate lfCertificate) {
        _lfCertificate = lfCertificate;
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificate.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificate.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("logo", getLogo());
        attributes.put("isPermanent", getIsPermanent());
        attributes.put("publishBadge", getPublishBadge());
        attributes.put("shortDescription", getShortDescription());
        attributes.put("companyID", getCompanyID());

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

        String logo = (String) attributes.get("logo");

        if (logo != null) {
            setLogo(logo);
        }

        Boolean isPermanent = (Boolean) attributes.get("isPermanent");

        if (isPermanent != null) {
            setIsPermanent(isPermanent);
        }

        Boolean publishBadge = (Boolean) attributes.get("publishBadge");

        if (publishBadge != null) {
            setPublishBadge(publishBadge);
        }

        String shortDescription = (String) attributes.get("shortDescription");

        if (shortDescription != null) {
            setShortDescription(shortDescription);
        }

        Integer companyID = (Integer) attributes.get("companyID");

        if (companyID != null) {
            setCompanyID(companyID);
        }
    }

    /**
    * Returns the primary key of this l f certificate.
    *
    * @return the primary key of this l f certificate
    */
    @Override
    public long getPrimaryKey() {
        return _lfCertificate.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f certificate.
    *
    * @param primaryKey the primary key of this l f certificate
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfCertificate.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f certificate.
    *
    * @return the ID of this l f certificate
    */
    @Override
    public long getId() {
        return _lfCertificate.getId();
    }

    /**
    * Sets the ID of this l f certificate.
    *
    * @param id the ID of this l f certificate
    */
    @Override
    public void setId(long id) {
        _lfCertificate.setId(id);
    }

    /**
    * Returns the title of this l f certificate.
    *
    * @return the title of this l f certificate
    */
    @Override
    public java.lang.String getTitle() {
        return _lfCertificate.getTitle();
    }

    /**
    * Sets the title of this l f certificate.
    *
    * @param title the title of this l f certificate
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lfCertificate.setTitle(title);
    }

    /**
    * Returns the description of this l f certificate.
    *
    * @return the description of this l f certificate
    */
    @Override
    public java.lang.String getDescription() {
        return _lfCertificate.getDescription();
    }

    /**
    * Sets the description of this l f certificate.
    *
    * @param description the description of this l f certificate
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfCertificate.setDescription(description);
    }

    /**
    * Returns the logo of this l f certificate.
    *
    * @return the logo of this l f certificate
    */
    @Override
    public java.lang.String getLogo() {
        return _lfCertificate.getLogo();
    }

    /**
    * Sets the logo of this l f certificate.
    *
    * @param logo the logo of this l f certificate
    */
    @Override
    public void setLogo(java.lang.String logo) {
        _lfCertificate.setLogo(logo);
    }

    /**
    * Returns the is permanent of this l f certificate.
    *
    * @return the is permanent of this l f certificate
    */
    @Override
    public java.lang.Boolean getIsPermanent() {
        return _lfCertificate.getIsPermanent();
    }

    /**
    * Sets the is permanent of this l f certificate.
    *
    * @param isPermanent the is permanent of this l f certificate
    */
    @Override
    public void setIsPermanent(java.lang.Boolean isPermanent) {
        _lfCertificate.setIsPermanent(isPermanent);
    }

    /**
    * Returns the publish badge of this l f certificate.
    *
    * @return the publish badge of this l f certificate
    */
    @Override
    public java.lang.Boolean getPublishBadge() {
        return _lfCertificate.getPublishBadge();
    }

    /**
    * Sets the publish badge of this l f certificate.
    *
    * @param publishBadge the publish badge of this l f certificate
    */
    @Override
    public void setPublishBadge(java.lang.Boolean publishBadge) {
        _lfCertificate.setPublishBadge(publishBadge);
    }

    /**
    * Returns the short description of this l f certificate.
    *
    * @return the short description of this l f certificate
    */
    @Override
    public java.lang.String getShortDescription() {
        return _lfCertificate.getShortDescription();
    }

    /**
    * Sets the short description of this l f certificate.
    *
    * @param shortDescription the short description of this l f certificate
    */
    @Override
    public void setShortDescription(java.lang.String shortDescription) {
        _lfCertificate.setShortDescription(shortDescription);
    }

    /**
    * Returns the company i d of this l f certificate.
    *
    * @return the company i d of this l f certificate
    */
    @Override
    public java.lang.Integer getCompanyID() {
        return _lfCertificate.getCompanyID();
    }

    /**
    * Sets the company i d of this l f certificate.
    *
    * @param companyID the company i d of this l f certificate
    */
    @Override
    public void setCompanyID(java.lang.Integer companyID) {
        _lfCertificate.setCompanyID(companyID);
    }

    @Override
    public boolean isNew() {
        return _lfCertificate.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfCertificate.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfCertificate.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfCertificate.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfCertificate.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfCertificate.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfCertificate.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfCertificate.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfCertificate.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfCertificate.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfCertificate.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFCertificateWrapper((LFCertificate) _lfCertificate.clone());
    }

    @Override
    public int compareTo(LFCertificate lfCertificate) {
        return _lfCertificate.compareTo(lfCertificate);
    }

    @Override
    public int hashCode() {
        return _lfCertificate.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFCertificate> toCacheModel() {
        return _lfCertificate.toCacheModel();
    }

    @Override
    public LFCertificate toEscapedModel() {
        return new LFCertificateWrapper(_lfCertificate.toEscapedModel());
    }

    @Override
    public LFCertificate toUnescapedModel() {
        return new LFCertificateWrapper(_lfCertificate.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfCertificate.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfCertificate.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificate.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateWrapper)) {
            return false;
        }

        LFCertificateWrapper lfCertificateWrapper = (LFCertificateWrapper) obj;

        if (Validator.equals(_lfCertificate, lfCertificateWrapper._lfCertificate)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFCertificate getWrappedLFCertificate() {
        return _lfCertificate;
    }

    @Override
    public LFCertificate getWrappedModel() {
        return _lfCertificate;
    }

    @Override
    public void resetOriginalValues() {
        _lfCertificate.resetOriginalValues();
    }
}
