package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFTincanManifestActivity}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFTincanManifestActivity
* @generated
*/
public class LFTincanManifestActivityWrapper implements LFTincanManifestActivity,
    ModelWrapper<LFTincanManifestActivity> {
    private LFTincanManifestActivity _lfTincanManifestActivity;

    public LFTincanManifestActivityWrapper(
        LFTincanManifestActivity lfTincanManifestActivity) {
        _lfTincanManifestActivity = lfTincanManifestActivity;
    }

    public Class<?> getModelClass() {
        return LFTincanManifestActivity.class;
    }

    public String getModelClassName() {
        return LFTincanManifestActivity.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("tincanID", getTincanID());
        attributes.put("packageID", getPackageID());
        attributes.put("activityType", getActivityType());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("launch", getLaunch());
        attributes.put("resource", getResource());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String tincanID = (String) attributes.get("tincanID");

        if (tincanID != null) {
            setTincanID(tincanID);
        }

        Long packageID = (Long) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String activityType = (String) attributes.get("activityType");

        if (activityType != null) {
            setActivityType(activityType);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String launch = (String) attributes.get("launch");

        if (launch != null) {
            setLaunch(launch);
        }

        String resource = (String) attributes.get("resource");

        if (resource != null) {
            setResource(resource);
        }
    }

    /**
     * Returns the primary key of this l f tincan manifest activity.
     *
     * @return the primary key of this l f tincan manifest activity
     */
    public long getPrimaryKey() {
        return _lfTincanManifestActivity.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f tincan manifest activity.
     *
     * @param primaryKey the primary key of this l f tincan manifest activity
     */
    public void setPrimaryKey(long primaryKey) {
        _lfTincanManifestActivity.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f tincan manifest activity.
     *
     * @return the ID of this l f tincan manifest activity
     */
    public long getId() {
        return _lfTincanManifestActivity.getId();
    }

    /**
     * Sets the ID of this l f tincan manifest activity.
     *
     * @param id the ID of this l f tincan manifest activity
     */
    public void setId(long id) {
        _lfTincanManifestActivity.setId(id);
    }

    /**
     * Returns the tincan i d of this l f tincan manifest activity.
     *
     * @return the tincan i d of this l f tincan manifest activity
     */
    public java.lang.String getTincanID() {
        return _lfTincanManifestActivity.getTincanID();
    }

    /**
     * Sets the tincan i d of this l f tincan manifest activity.
     *
     * @param tincanID the tincan i d of this l f tincan manifest activity
     */
    public void setTincanID(java.lang.String tincanID) {
        _lfTincanManifestActivity.setTincanID(tincanID);
    }

    /**
     * Returns the package i d of this l f tincan manifest activity.
     *
     * @return the package i d of this l f tincan manifest activity
     */
    public java.lang.Long getPackageID() {
        return _lfTincanManifestActivity.getPackageID();
    }

    /**
     * Sets the package i d of this l f tincan manifest activity.
     *
     * @param packageID the package i d of this l f tincan manifest activity
     */
    public void setPackageID(java.lang.Long packageID) {
        _lfTincanManifestActivity.setPackageID(packageID);
    }

    /**
     * Returns the activity type of this l f tincan manifest activity.
     *
     * @return the activity type of this l f tincan manifest activity
     */
    public java.lang.String getActivityType() {
        return _lfTincanManifestActivity.getActivityType();
    }

    /**
     * Sets the activity type of this l f tincan manifest activity.
     *
     * @param activityType the activity type of this l f tincan manifest activity
     */
    public void setActivityType(java.lang.String activityType) {
        _lfTincanManifestActivity.setActivityType(activityType);
    }

    /**
     * Returns the name of this l f tincan manifest activity.
     *
     * @return the name of this l f tincan manifest activity
     */
    public java.lang.String getName() {
        return _lfTincanManifestActivity.getName();
    }

    /**
     * Sets the name of this l f tincan manifest activity.
     *
     * @param name the name of this l f tincan manifest activity
     */
    public void setName(java.lang.String name) {
        _lfTincanManifestActivity.setName(name);
    }

    /**
     * Returns the description of this l f tincan manifest activity.
     *
     * @return the description of this l f tincan manifest activity
     */
    public java.lang.String getDescription() {
        return _lfTincanManifestActivity.getDescription();
    }

    /**
     * Sets the description of this l f tincan manifest activity.
     *
     * @param description the description of this l f tincan manifest activity
     */
    public void setDescription(java.lang.String description) {
        _lfTincanManifestActivity.setDescription(description);
    }

    /**
     * Returns the launch of this l f tincan manifest activity.
     *
     * @return the launch of this l f tincan manifest activity
     */
    public java.lang.String getLaunch() {
        return _lfTincanManifestActivity.getLaunch();
    }

    /**
     * Sets the launch of this l f tincan manifest activity.
     *
     * @param launch the launch of this l f tincan manifest activity
     */
    public void setLaunch(java.lang.String launch) {
        _lfTincanManifestActivity.setLaunch(launch);
    }

    /**
     * Returns the resource of this l f tincan manifest activity.
     *
     * @return the resource of this l f tincan manifest activity
     */
    public java.lang.String getResource() {
        return _lfTincanManifestActivity.getResource();
    }

    /**
     * Sets the resource of this l f tincan manifest activity.
     *
     * @param resource the resource of this l f tincan manifest activity
     */
    public void setResource(java.lang.String resource) {
        _lfTincanManifestActivity.setResource(resource);
    }

    public boolean isNew() {
        return _lfTincanManifestActivity.isNew();
    }

    public void setNew(boolean n) {
        _lfTincanManifestActivity.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfTincanManifestActivity.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfTincanManifestActivity.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfTincanManifestActivity.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanManifestActivity.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanManifestActivity.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanManifestActivity.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanManifestActivity.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanManifestActivityWrapper((LFTincanManifestActivity) _lfTincanManifestActivity.clone());
    }

    public int compareTo(LFTincanManifestActivity lfTincanManifestActivity) {
        return _lfTincanManifestActivity.compareTo(lfTincanManifestActivity);
    }

    @Override
    public int hashCode() {
        return _lfTincanManifestActivity.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFTincanManifestActivity> toCacheModel() {
        return _lfTincanManifestActivity.toCacheModel();
    }

    public LFTincanManifestActivity toEscapedModel() {
        return new LFTincanManifestActivityWrapper(_lfTincanManifestActivity.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanManifestActivity.toString();
    }

    public java.lang.String toXmlString() {
        return _lfTincanManifestActivity.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanManifestActivity.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFTincanManifestActivity getWrappedLFTincanManifestActivity() {
        return _lfTincanManifestActivity;
    }

    public LFTincanManifestActivity getWrappedModel() {
        return _lfTincanManifestActivity;
    }

    public void resetOriginalValues() {
        _lfTincanManifestActivity.resetOriginalValues();
    }
}
