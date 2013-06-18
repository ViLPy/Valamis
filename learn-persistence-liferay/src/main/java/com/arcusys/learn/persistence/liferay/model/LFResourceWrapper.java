package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFResource}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFResource
* @generated
*/
public class LFResourceWrapper implements LFResource, ModelWrapper<LFResource> {
    private LFResource _lfResource;

    public LFResourceWrapper(LFResource lfResource) {
        _lfResource = lfResource;
    }

    public Class<?> getModelClass() {
        return LFResource.class;
    }

    public String getModelClassName() {
        return LFResource.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("packageID", getPackageID());
        attributes.put("scormType", getScormType());
        attributes.put("resourceID", getResourceID());
        attributes.put("href", getHref());
        attributes.put("base", getBase());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String scormType = (String) attributes.get("scormType");

        if (scormType != null) {
            setScormType(scormType);
        }

        String resourceID = (String) attributes.get("resourceID");

        if (resourceID != null) {
            setResourceID(resourceID);
        }

        String href = (String) attributes.get("href");

        if (href != null) {
            setHref(href);
        }

        String base = (String) attributes.get("base");

        if (base != null) {
            setBase(base);
        }
    }

    /**
     * Returns the primary key of this l f resource.
     *
     * @return the primary key of this l f resource
     */
    public long getPrimaryKey() {
        return _lfResource.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f resource.
     *
     * @param primaryKey the primary key of this l f resource
     */
    public void setPrimaryKey(long primaryKey) {
        _lfResource.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f resource.
     *
     * @return the ID of this l f resource
     */
    public long getId() {
        return _lfResource.getId();
    }

    /**
     * Sets the ID of this l f resource.
     *
     * @param id the ID of this l f resource
     */
    public void setId(long id) {
        _lfResource.setId(id);
    }

    /**
     * Returns the package i d of this l f resource.
     *
     * @return the package i d of this l f resource
     */
    public java.lang.Integer getPackageID() {
        return _lfResource.getPackageID();
    }

    /**
     * Sets the package i d of this l f resource.
     *
     * @param packageID the package i d of this l f resource
     */
    public void setPackageID(java.lang.Integer packageID) {
        _lfResource.setPackageID(packageID);
    }

    /**
     * Returns the scorm type of this l f resource.
     *
     * @return the scorm type of this l f resource
     */
    public java.lang.String getScormType() {
        return _lfResource.getScormType();
    }

    /**
     * Sets the scorm type of this l f resource.
     *
     * @param scormType the scorm type of this l f resource
     */
    public void setScormType(java.lang.String scormType) {
        _lfResource.setScormType(scormType);
    }

    /**
     * Returns the resource i d of this l f resource.
     *
     * @return the resource i d of this l f resource
     */
    public java.lang.String getResourceID() {
        return _lfResource.getResourceID();
    }

    /**
     * Sets the resource i d of this l f resource.
     *
     * @param resourceID the resource i d of this l f resource
     */
    public void setResourceID(java.lang.String resourceID) {
        _lfResource.setResourceID(resourceID);
    }

    /**
     * Returns the href of this l f resource.
     *
     * @return the href of this l f resource
     */
    public java.lang.String getHref() {
        return _lfResource.getHref();
    }

    /**
     * Sets the href of this l f resource.
     *
     * @param href the href of this l f resource
     */
    public void setHref(java.lang.String href) {
        _lfResource.setHref(href);
    }

    /**
     * Returns the base of this l f resource.
     *
     * @return the base of this l f resource
     */
    public java.lang.String getBase() {
        return _lfResource.getBase();
    }

    /**
     * Sets the base of this l f resource.
     *
     * @param base the base of this l f resource
     */
    public void setBase(java.lang.String base) {
        _lfResource.setBase(base);
    }

    public boolean isNew() {
        return _lfResource.isNew();
    }

    public void setNew(boolean n) {
        _lfResource.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfResource.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfResource.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfResource.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfResource.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfResource.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfResource.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfResource.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFResourceWrapper((LFResource) _lfResource.clone());
    }

    public int compareTo(LFResource lfResource) {
        return _lfResource.compareTo(lfResource);
    }

    @Override
    public int hashCode() {
        return _lfResource.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFResource> toCacheModel() {
        return _lfResource.toCacheModel();
    }

    public LFResource toEscapedModel() {
        return new LFResourceWrapper(_lfResource.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfResource.toString();
    }

    public java.lang.String toXmlString() {
        return _lfResource.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfResource.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFResource getWrappedLFResource() {
        return _lfResource;
    }

    public LFResource getWrappedModel() {
        return _lfResource;
    }

    public void resetOriginalValues() {
        _lfResource.resetOriginalValues();
    }
}
