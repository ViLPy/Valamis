package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFCertificateSite}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFCertificateSite
* @generated
*/
public class LFCertificateSiteWrapper implements LFCertificateSite,
    ModelWrapper<LFCertificateSite> {
    private LFCertificateSite _lfCertificateSite;

    public LFCertificateSiteWrapper(LFCertificateSite lfCertificateSite) {
        _lfCertificateSite = lfCertificateSite;
    }

    public Class<?> getModelClass() {
        return LFCertificateSite.class;
    }

    public String getModelClassName() {
        return LFCertificateSite.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("certificateID", getCertificateID());
        attributes.put("siteID", getSiteID());
        attributes.put("arrangementIndex", getArrangementIndex());

        return attributes;
    }

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
    public long getPrimaryKey() {
        return _lfCertificateSite.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f certificate site.
     *
     * @param primaryKey the primary key of this l f certificate site
     */
    public void setPrimaryKey(long primaryKey) {
        _lfCertificateSite.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f certificate site.
     *
     * @return the ID of this l f certificate site
     */
    public long getId() {
        return _lfCertificateSite.getId();
    }

    /**
     * Sets the ID of this l f certificate site.
     *
     * @param id the ID of this l f certificate site
     */
    public void setId(long id) {
        _lfCertificateSite.setId(id);
    }

    /**
     * Returns the certificate i d of this l f certificate site.
     *
     * @return the certificate i d of this l f certificate site
     */
    public java.lang.Integer getCertificateID() {
        return _lfCertificateSite.getCertificateID();
    }

    /**
     * Sets the certificate i d of this l f certificate site.
     *
     * @param certificateID the certificate i d of this l f certificate site
     */
    public void setCertificateID(java.lang.Integer certificateID) {
        _lfCertificateSite.setCertificateID(certificateID);
    }

    /**
     * Returns the site i d of this l f certificate site.
     *
     * @return the site i d of this l f certificate site
     */
    public java.lang.Integer getSiteID() {
        return _lfCertificateSite.getSiteID();
    }

    /**
     * Sets the site i d of this l f certificate site.
     *
     * @param siteID the site i d of this l f certificate site
     */
    public void setSiteID(java.lang.Integer siteID) {
        _lfCertificateSite.setSiteID(siteID);
    }

    /**
     * Returns the arrangement index of this l f certificate site.
     *
     * @return the arrangement index of this l f certificate site
     */
    public java.lang.Integer getArrangementIndex() {
        return _lfCertificateSite.getArrangementIndex();
    }

    /**
     * Sets the arrangement index of this l f certificate site.
     *
     * @param arrangementIndex the arrangement index of this l f certificate site
     */
    public void setArrangementIndex(java.lang.Integer arrangementIndex) {
        _lfCertificateSite.setArrangementIndex(arrangementIndex);
    }

    public boolean isNew() {
        return _lfCertificateSite.isNew();
    }

    public void setNew(boolean n) {
        _lfCertificateSite.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfCertificateSite.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfCertificateSite.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfCertificateSite.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfCertificateSite.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfCertificateSite.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfCertificateSite.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfCertificateSite.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFCertificateSiteWrapper((LFCertificateSite) _lfCertificateSite.clone());
    }

    public int compareTo(LFCertificateSite lfCertificateSite) {
        return _lfCertificateSite.compareTo(lfCertificateSite);
    }

    @Override
    public int hashCode() {
        return _lfCertificateSite.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFCertificateSite> toCacheModel() {
        return _lfCertificateSite.toCacheModel();
    }

    public LFCertificateSite toEscapedModel() {
        return new LFCertificateSiteWrapper(_lfCertificateSite.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfCertificateSite.toString();
    }

    public java.lang.String toXmlString() {
        return _lfCertificateSite.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateSite.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFCertificateSite getWrappedLFCertificateSite() {
        return _lfCertificateSite;
    }

    public LFCertificateSite getWrappedModel() {
        return _lfCertificateSite;
    }

    public void resetOriginalValues() {
        _lfCertificateSite.resetOriginalValues();
    }
}
