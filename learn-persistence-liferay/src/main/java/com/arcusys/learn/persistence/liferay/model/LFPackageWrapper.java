package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFPackage}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFPackage
* @generated
*/
public class LFPackageWrapper implements LFPackage, ModelWrapper<LFPackage> {
    private LFPackage _lfPackage;

    public LFPackageWrapper(LFPackage lfPackage) {
        _lfPackage = lfPackage;
    }

    public Class<?> getModelClass() {
        return LFPackage.class;
    }

    public String getModelClassName() {
        return LFPackage.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("defaultOrganizationID", getDefaultOrganizationID());
        attributes.put("title", getTitle());
        attributes.put("base", getBase());
        attributes.put("resourcesBase", getResourcesBase());
        attributes.put("summary", getSummary());
        attributes.put("assetRefID", getAssetRefID());
        attributes.put("courseID", getCourseID());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String defaultOrganizationID = (String) attributes.get(
                "defaultOrganizationID");

        if (defaultOrganizationID != null) {
            setDefaultOrganizationID(defaultOrganizationID);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String base = (String) attributes.get("base");

        if (base != null) {
            setBase(base);
        }

        String resourcesBase = (String) attributes.get("resourcesBase");

        if (resourcesBase != null) {
            setResourcesBase(resourcesBase);
        }

        String summary = (String) attributes.get("summary");

        if (summary != null) {
            setSummary(summary);
        }

        Long assetRefID = (Long) attributes.get("assetRefID");

        if (assetRefID != null) {
            setAssetRefID(assetRefID);
        }

        Integer courseID = (Integer) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }
    }

    /**
     * Returns the primary key of this l f package.
     *
     * @return the primary key of this l f package
     */
    public long getPrimaryKey() {
        return _lfPackage.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f package.
     *
     * @param primaryKey the primary key of this l f package
     */
    public void setPrimaryKey(long primaryKey) {
        _lfPackage.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f package.
     *
     * @return the ID of this l f package
     */
    public long getId() {
        return _lfPackage.getId();
    }

    /**
     * Sets the ID of this l f package.
     *
     * @param id the ID of this l f package
     */
    public void setId(long id) {
        _lfPackage.setId(id);
    }

    /**
     * Returns the default organization i d of this l f package.
     *
     * @return the default organization i d of this l f package
     */
    public java.lang.String getDefaultOrganizationID() {
        return _lfPackage.getDefaultOrganizationID();
    }

    /**
     * Sets the default organization i d of this l f package.
     *
     * @param defaultOrganizationID the default organization i d of this l f package
     */
    public void setDefaultOrganizationID(java.lang.String defaultOrganizationID) {
        _lfPackage.setDefaultOrganizationID(defaultOrganizationID);
    }

    /**
     * Returns the title of this l f package.
     *
     * @return the title of this l f package
     */
    public java.lang.String getTitle() {
        return _lfPackage.getTitle();
    }

    /**
     * Sets the title of this l f package.
     *
     * @param title the title of this l f package
     */
    public void setTitle(java.lang.String title) {
        _lfPackage.setTitle(title);
    }

    /**
     * Returns the base of this l f package.
     *
     * @return the base of this l f package
     */
    public java.lang.String getBase() {
        return _lfPackage.getBase();
    }

    /**
     * Sets the base of this l f package.
     *
     * @param base the base of this l f package
     */
    public void setBase(java.lang.String base) {
        _lfPackage.setBase(base);
    }

    /**
     * Returns the resources base of this l f package.
     *
     * @return the resources base of this l f package
     */
    public java.lang.String getResourcesBase() {
        return _lfPackage.getResourcesBase();
    }

    /**
     * Sets the resources base of this l f package.
     *
     * @param resourcesBase the resources base of this l f package
     */
    public void setResourcesBase(java.lang.String resourcesBase) {
        _lfPackage.setResourcesBase(resourcesBase);
    }

    /**
     * Returns the summary of this l f package.
     *
     * @return the summary of this l f package
     */
    public java.lang.String getSummary() {
        return _lfPackage.getSummary();
    }

    /**
     * Sets the summary of this l f package.
     *
     * @param summary the summary of this l f package
     */
    public void setSummary(java.lang.String summary) {
        _lfPackage.setSummary(summary);
    }

    /**
     * Returns the asset ref i d of this l f package.
     *
     * @return the asset ref i d of this l f package
     */
    public java.lang.Long getAssetRefID() {
        return _lfPackage.getAssetRefID();
    }

    /**
     * Sets the asset ref i d of this l f package.
     *
     * @param assetRefID the asset ref i d of this l f package
     */
    public void setAssetRefID(java.lang.Long assetRefID) {
        _lfPackage.setAssetRefID(assetRefID);
    }

    /**
     * Returns the course i d of this l f package.
     *
     * @return the course i d of this l f package
     */
    public java.lang.Integer getCourseID() {
        return _lfPackage.getCourseID();
    }

    /**
     * Sets the course i d of this l f package.
     *
     * @param courseID the course i d of this l f package
     */
    public void setCourseID(java.lang.Integer courseID) {
        _lfPackage.setCourseID(courseID);
    }

    public boolean isNew() {
        return _lfPackage.isNew();
    }

    public void setNew(boolean n) {
        _lfPackage.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfPackage.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfPackage.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfPackage.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfPackage.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfPackage.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfPackage.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfPackage.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFPackageWrapper((LFPackage) _lfPackage.clone());
    }

    public int compareTo(LFPackage lfPackage) {
        return _lfPackage.compareTo(lfPackage);
    }

    @Override
    public int hashCode() {
        return _lfPackage.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFPackage> toCacheModel() {
        return _lfPackage.toCacheModel();
    }

    public LFPackage toEscapedModel() {
        return new LFPackageWrapper(_lfPackage.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfPackage.toString();
    }

    public java.lang.String toXmlString() {
        return _lfPackage.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfPackage.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFPackage getWrappedLFPackage() {
        return _lfPackage;
    }

    public LFPackage getWrappedModel() {
        return _lfPackage;
    }

    public void resetOriginalValues() {
        _lfPackage.resetOriginalValues();
    }
}
