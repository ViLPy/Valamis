package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFCertificateSite}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateSite
 * @generated
 */
public class LFCertificateSiteWrapper implements LFCertificateSite,
    ModelWrapper<LFCertificateSite> {
    private LFCertificateSite _lfCertificateSite;

    public LFCertificateSiteWrapper(LFCertificateSite lfCertificateSite) {
        _lfCertificateSite = lfCertificateSite;
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificateSite.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificateSite.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("certificateID", getCertificateID());
        attributes.put("siteID", getSiteID());
        attributes.put("arrangementIndex", getArrangementIndex());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer certificateID = (Integer) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        Integer siteID = (Integer) attributes.get("siteID");

        if (siteID != null) {
            setSiteID(siteID);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
        }
    }

    /**
    * Returns the primary key of this l f certificate site.
    *
    * @return the primary key of this l f certificate site
    */
    @Override
    public long getPrimaryKey() {
        return _lfCertificateSite.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f certificate site.
    *
    * @param primaryKey the primary key of this l f certificate site
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfCertificateSite.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f certificate site.
    *
    * @return the ID of this l f certificate site
    */
    @Override
    public long getId() {
        return _lfCertificateSite.getId();
    }

    /**
    * Sets the ID of this l f certificate site.
    *
    * @param id the ID of this l f certificate site
    */
    @Override
    public void setId(long id) {
        _lfCertificateSite.setId(id);
    }

    /**
    * Returns the certificate i d of this l f certificate site.
    *
    * @return the certificate i d of this l f certificate site
    */
    @Override
    public java.lang.Integer getCertificateID() {
        return _lfCertificateSite.getCertificateID();
    }

    /**
    * Sets the certificate i d of this l f certificate site.
    *
    * @param certificateID the certificate i d of this l f certificate site
    */
    @Override
    public void setCertificateID(java.lang.Integer certificateID) {
        _lfCertificateSite.setCertificateID(certificateID);
    }

    /**
    * Returns the site i d of this l f certificate site.
    *
    * @return the site i d of this l f certificate site
    */
    @Override
    public java.lang.Integer getSiteID() {
        return _lfCertificateSite.getSiteID();
    }

    /**
    * Sets the site i d of this l f certificate site.
    *
    * @param siteID the site i d of this l f certificate site
    */
    @Override
    public void setSiteID(java.lang.Integer siteID) {
        _lfCertificateSite.setSiteID(siteID);
    }

    /**
    * Returns the arrangement index of this l f certificate site.
    *
    * @return the arrangement index of this l f certificate site
    */
    @Override
    public java.lang.Integer getArrangementIndex() {
        return _lfCertificateSite.getArrangementIndex();
    }

    /**
    * Sets the arrangement index of this l f certificate site.
    *
    * @param arrangementIndex the arrangement index of this l f certificate site
    */
    @Override
    public void setArrangementIndex(java.lang.Integer arrangementIndex) {
        _lfCertificateSite.setArrangementIndex(arrangementIndex);
    }

    @Override
    public boolean isNew() {
        return _lfCertificateSite.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfCertificateSite.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfCertificateSite.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfCertificateSite.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfCertificateSite.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfCertificateSite.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfCertificateSite.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfCertificateSite.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfCertificateSite.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfCertificateSite.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfCertificateSite.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFCertificateSiteWrapper((LFCertificateSite) _lfCertificateSite.clone());
    }

    @Override
    public int compareTo(LFCertificateSite lfCertificateSite) {
        return _lfCertificateSite.compareTo(lfCertificateSite);
    }

    @Override
    public int hashCode() {
        return _lfCertificateSite.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFCertificateSite> toCacheModel() {
        return _lfCertificateSite.toCacheModel();
    }

    @Override
    public LFCertificateSite toEscapedModel() {
        return new LFCertificateSiteWrapper(_lfCertificateSite.toEscapedModel());
    }

    @Override
    public LFCertificateSite toUnescapedModel() {
        return new LFCertificateSiteWrapper(_lfCertificateSite.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfCertificateSite.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfCertificateSite.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateSite.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateSiteWrapper)) {
            return false;
        }

        LFCertificateSiteWrapper lfCertificateSiteWrapper = (LFCertificateSiteWrapper) obj;

        if (Validator.equals(_lfCertificateSite,
                    lfCertificateSiteWrapper._lfCertificateSite)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFCertificateSite getWrappedLFCertificateSite() {
        return _lfCertificateSite;
    }

    @Override
    public LFCertificateSite getWrappedModel() {
        return _lfCertificateSite;
    }

    @Override
    public void resetOriginalValues() {
        _lfCertificateSite.resetOriginalValues();
    }
}
