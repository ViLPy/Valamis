package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFTincanActivity}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFTincanActivity
* @generated
*/
public class LFTincanActivityWrapper implements LFTincanActivity,
    ModelWrapper<LFTincanActivity> {
    private LFTincanActivity _lfTincanActivity;

    public LFTincanActivityWrapper(LFTincanActivity lfTincanActivity) {
        _lfTincanActivity = lfTincanActivity;
    }

    public Class<?> getModelClass() {
        return LFTincanActivity.class;
    }

    public String getModelClassName() {
        return LFTincanActivity.class.getName();
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
     * Returns the primary key of this l f tincan activity.
     *
     * @return the primary key of this l f tincan activity
     */
    public long getPrimaryKey() {
        return _lfTincanActivity.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f tincan activity.
     *
     * @param primaryKey the primary key of this l f tincan activity
     */
    public void setPrimaryKey(long primaryKey) {
        _lfTincanActivity.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f tincan activity.
     *
     * @return the ID of this l f tincan activity
     */
    public long getId() {
        return _lfTincanActivity.getId();
    }

    /**
     * Sets the ID of this l f tincan activity.
     *
     * @param id the ID of this l f tincan activity
     */
    public void setId(long id) {
        _lfTincanActivity.setId(id);
    }

    /**
     * Returns the tincan i d of this l f tincan activity.
     *
     * @return the tincan i d of this l f tincan activity
     */
    public java.lang.String getTincanID() {
        return _lfTincanActivity.getTincanID();
    }

    /**
     * Sets the tincan i d of this l f tincan activity.
     *
     * @param tincanID the tincan i d of this l f tincan activity
     */
    public void setTincanID(java.lang.String tincanID) {
        _lfTincanActivity.setTincanID(tincanID);
    }

    /**
     * Returns the package i d of this l f tincan activity.
     *
     * @return the package i d of this l f tincan activity
     */
    public java.lang.Long getPackageID() {
        return _lfTincanActivity.getPackageID();
    }

    /**
     * Sets the package i d of this l f tincan activity.
     *
     * @param packageID the package i d of this l f tincan activity
     */
    public void setPackageID(java.lang.Long packageID) {
        _lfTincanActivity.setPackageID(packageID);
    }

    /**
     * Returns the activity type of this l f tincan activity.
     *
     * @return the activity type of this l f tincan activity
     */
    public java.lang.String getActivityType() {
        return _lfTincanActivity.getActivityType();
    }

    /**
     * Sets the activity type of this l f tincan activity.
     *
     * @param activityType the activity type of this l f tincan activity
     */
    public void setActivityType(java.lang.String activityType) {
        _lfTincanActivity.setActivityType(activityType);
    }

    /**
     * Returns the name of this l f tincan activity.
     *
     * @return the name of this l f tincan activity
     */
    public java.lang.String getName() {
        return _lfTincanActivity.getName();
    }

    /**
     * Sets the name of this l f tincan activity.
     *
     * @param name the name of this l f tincan activity
     */
    public void setName(java.lang.String name) {
        _lfTincanActivity.setName(name);
    }

    /**
     * Returns the description of this l f tincan activity.
     *
     * @return the description of this l f tincan activity
     */
    public java.lang.String getDescription() {
        return _lfTincanActivity.getDescription();
    }

    /**
     * Sets the description of this l f tincan activity.
     *
     * @param description the description of this l f tincan activity
     */
    public void setDescription(java.lang.String description) {
        _lfTincanActivity.setDescription(description);
    }

    /**
     * Returns the launch of this l f tincan activity.
     *
     * @return the launch of this l f tincan activity
     */
    public java.lang.String getLaunch() {
        return _lfTincanActivity.getLaunch();
    }

    /**
     * Sets the launch of this l f tincan activity.
     *
     * @param launch the launch of this l f tincan activity
     */
    public void setLaunch(java.lang.String launch) {
        _lfTincanActivity.setLaunch(launch);
    }

    /**
     * Returns the resource of this l f tincan activity.
     *
     * @return the resource of this l f tincan activity
     */
    public java.lang.String getResource() {
        return _lfTincanActivity.getResource();
    }

    /**
     * Sets the resource of this l f tincan activity.
     *
     * @param resource the resource of this l f tincan activity
     */
    public void setResource(java.lang.String resource) {
        _lfTincanActivity.setResource(resource);
    }

    public boolean isNew() {
        return _lfTincanActivity.isNew();
    }

    public void setNew(boolean n) {
        _lfTincanActivity.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfTincanActivity.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfTincanActivity.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfTincanActivity.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanActivity.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanActivity.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanActivity.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanActivity.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanActivityWrapper((LFTincanActivity) _lfTincanActivity.clone());
    }

    public int compareTo(LFTincanActivity lfTincanActivity) {
        return _lfTincanActivity.compareTo(lfTincanActivity);
    }

    @Override
    public int hashCode() {
        return _lfTincanActivity.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFTincanActivity> toCacheModel() {
        return _lfTincanActivity.toCacheModel();
    }

    public LFTincanActivity toEscapedModel() {
        return new LFTincanActivityWrapper(_lfTincanActivity.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanActivity.toString();
    }

    public java.lang.String toXmlString() {
        return _lfTincanActivity.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanActivity.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFTincanActivity getWrappedLFTincanActivity() {
        return _lfTincanActivity;
    }

    public LFTincanActivity getWrappedModel() {
        return _lfTincanActivity;
    }

    public void resetOriginalValues() {
        _lfTincanActivity.resetOriginalValues();
    }
}
