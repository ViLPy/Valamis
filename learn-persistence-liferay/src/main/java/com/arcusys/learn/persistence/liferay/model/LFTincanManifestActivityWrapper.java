package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanManifestActivity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanManifestActivity
 * @generated
 */
public class LFTincanManifestActivityWrapper implements LFTincanManifestActivity,
    ModelWrapper<LFTincanManifestActivity> {
    private LFTincanManifestActivity _lfTincanManifestActivity;

    public LFTincanManifestActivityWrapper(
        LFTincanManifestActivity lfTincanManifestActivity) {
        _lfTincanManifestActivity = lfTincanManifestActivity;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanManifestActivity.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanManifestActivity.class.getName();
    }

    @Override
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

    @Override
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
    @Override
    public long getPrimaryKey() {
        return _lfTincanManifestActivity.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan manifest activity.
    *
    * @param primaryKey the primary key of this l f tincan manifest activity
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanManifestActivity.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan manifest activity.
    *
    * @return the ID of this l f tincan manifest activity
    */
    @Override
    public long getId() {
        return _lfTincanManifestActivity.getId();
    }

    /**
    * Sets the ID of this l f tincan manifest activity.
    *
    * @param id the ID of this l f tincan manifest activity
    */
    @Override
    public void setId(long id) {
        _lfTincanManifestActivity.setId(id);
    }

    /**
    * Returns the tincan i d of this l f tincan manifest activity.
    *
    * @return the tincan i d of this l f tincan manifest activity
    */
    @Override
    public java.lang.String getTincanID() {
        return _lfTincanManifestActivity.getTincanID();
    }

    /**
    * Sets the tincan i d of this l f tincan manifest activity.
    *
    * @param tincanID the tincan i d of this l f tincan manifest activity
    */
    @Override
    public void setTincanID(java.lang.String tincanID) {
        _lfTincanManifestActivity.setTincanID(tincanID);
    }

    /**
    * Returns the package i d of this l f tincan manifest activity.
    *
    * @return the package i d of this l f tincan manifest activity
    */
    @Override
    public java.lang.Long getPackageID() {
        return _lfTincanManifestActivity.getPackageID();
    }

    /**
    * Sets the package i d of this l f tincan manifest activity.
    *
    * @param packageID the package i d of this l f tincan manifest activity
    */
    @Override
    public void setPackageID(java.lang.Long packageID) {
        _lfTincanManifestActivity.setPackageID(packageID);
    }

    /**
    * Returns the activity type of this l f tincan manifest activity.
    *
    * @return the activity type of this l f tincan manifest activity
    */
    @Override
    public java.lang.String getActivityType() {
        return _lfTincanManifestActivity.getActivityType();
    }

    /**
    * Sets the activity type of this l f tincan manifest activity.
    *
    * @param activityType the activity type of this l f tincan manifest activity
    */
    @Override
    public void setActivityType(java.lang.String activityType) {
        _lfTincanManifestActivity.setActivityType(activityType);
    }

    /**
    * Returns the name of this l f tincan manifest activity.
    *
    * @return the name of this l f tincan manifest activity
    */
    @Override
    public java.lang.String getName() {
        return _lfTincanManifestActivity.getName();
    }

    /**
    * Sets the name of this l f tincan manifest activity.
    *
    * @param name the name of this l f tincan manifest activity
    */
    @Override
    public void setName(java.lang.String name) {
        _lfTincanManifestActivity.setName(name);
    }

    /**
    * Returns the description of this l f tincan manifest activity.
    *
    * @return the description of this l f tincan manifest activity
    */
    @Override
    public java.lang.String getDescription() {
        return _lfTincanManifestActivity.getDescription();
    }

    /**
    * Sets the description of this l f tincan manifest activity.
    *
    * @param description the description of this l f tincan manifest activity
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfTincanManifestActivity.setDescription(description);
    }

    /**
    * Returns the launch of this l f tincan manifest activity.
    *
    * @return the launch of this l f tincan manifest activity
    */
    @Override
    public java.lang.String getLaunch() {
        return _lfTincanManifestActivity.getLaunch();
    }

    /**
    * Sets the launch of this l f tincan manifest activity.
    *
    * @param launch the launch of this l f tincan manifest activity
    */
    @Override
    public void setLaunch(java.lang.String launch) {
        _lfTincanManifestActivity.setLaunch(launch);
    }

    /**
    * Returns the resource of this l f tincan manifest activity.
    *
    * @return the resource of this l f tincan manifest activity
    */
    @Override
    public java.lang.String getResource() {
        return _lfTincanManifestActivity.getResource();
    }

    /**
    * Sets the resource of this l f tincan manifest activity.
    *
    * @param resource the resource of this l f tincan manifest activity
    */
    @Override
    public void setResource(java.lang.String resource) {
        _lfTincanManifestActivity.setResource(resource);
    }

    @Override
    public boolean isNew() {
        return _lfTincanManifestActivity.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanManifestActivity.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanManifestActivity.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanManifestActivity.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanManifestActivity.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanManifestActivity.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanManifestActivity.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanManifestActivity.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanManifestActivity.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanManifestActivity.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanManifestActivity.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanManifestActivityWrapper((LFTincanManifestActivity) _lfTincanManifestActivity.clone());
    }

    @Override
    public int compareTo(LFTincanManifestActivity lfTincanManifestActivity) {
        return _lfTincanManifestActivity.compareTo(lfTincanManifestActivity);
    }

    @Override
    public int hashCode() {
        return _lfTincanManifestActivity.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanManifestActivity> toCacheModel() {
        return _lfTincanManifestActivity.toCacheModel();
    }

    @Override
    public LFTincanManifestActivity toEscapedModel() {
        return new LFTincanManifestActivityWrapper(_lfTincanManifestActivity.toEscapedModel());
    }

    @Override
    public LFTincanManifestActivity toUnescapedModel() {
        return new LFTincanManifestActivityWrapper(_lfTincanManifestActivity.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanManifestActivity.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanManifestActivity.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanManifestActivity.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanManifestActivityWrapper)) {
            return false;
        }

        LFTincanManifestActivityWrapper lfTincanManifestActivityWrapper = (LFTincanManifestActivityWrapper) obj;

        if (Validator.equals(_lfTincanManifestActivity,
                    lfTincanManifestActivityWrapper._lfTincanManifestActivity)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanManifestActivity getWrappedLFTincanManifestActivity() {
        return _lfTincanManifestActivity;
    }

    @Override
    public LFTincanManifestActivity getWrappedModel() {
        return _lfTincanManifestActivity;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanManifestActivity.resetOriginalValues();
    }
}
