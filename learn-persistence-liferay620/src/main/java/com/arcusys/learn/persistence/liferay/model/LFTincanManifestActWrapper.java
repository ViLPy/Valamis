package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanManifestAct}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanManifestAct
 * @generated
 */
public class LFTincanManifestActWrapper implements LFTincanManifestAct,
    ModelWrapper<LFTincanManifestAct> {
    private LFTincanManifestAct _lfTincanManifestAct;

    public LFTincanManifestActWrapper(LFTincanManifestAct lfTincanManifestAct) {
        _lfTincanManifestAct = lfTincanManifestAct;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanManifestAct.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanManifestAct.class.getName();
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
        attributes.put("resourceID", getResourceID());

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

        String resourceID = (String) attributes.get("resourceID");

        if (resourceID != null) {
            setResourceID(resourceID);
        }
    }

    /**
    * Returns the primary key of this l f tincan manifest act.
    *
    * @return the primary key of this l f tincan manifest act
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanManifestAct.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan manifest act.
    *
    * @param primaryKey the primary key of this l f tincan manifest act
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanManifestAct.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan manifest act.
    *
    * @return the ID of this l f tincan manifest act
    */
    @Override
    public long getId() {
        return _lfTincanManifestAct.getId();
    }

    /**
    * Sets the ID of this l f tincan manifest act.
    *
    * @param id the ID of this l f tincan manifest act
    */
    @Override
    public void setId(long id) {
        _lfTincanManifestAct.setId(id);
    }

    /**
    * Returns the tincan i d of this l f tincan manifest act.
    *
    * @return the tincan i d of this l f tincan manifest act
    */
    @Override
    public java.lang.String getTincanID() {
        return _lfTincanManifestAct.getTincanID();
    }

    /**
    * Sets the tincan i d of this l f tincan manifest act.
    *
    * @param tincanID the tincan i d of this l f tincan manifest act
    */
    @Override
    public void setTincanID(java.lang.String tincanID) {
        _lfTincanManifestAct.setTincanID(tincanID);
    }

    /**
    * Returns the package i d of this l f tincan manifest act.
    *
    * @return the package i d of this l f tincan manifest act
    */
    @Override
    public java.lang.Long getPackageID() {
        return _lfTincanManifestAct.getPackageID();
    }

    /**
    * Sets the package i d of this l f tincan manifest act.
    *
    * @param packageID the package i d of this l f tincan manifest act
    */
    @Override
    public void setPackageID(java.lang.Long packageID) {
        _lfTincanManifestAct.setPackageID(packageID);
    }

    /**
    * Returns the activity type of this l f tincan manifest act.
    *
    * @return the activity type of this l f tincan manifest act
    */
    @Override
    public java.lang.String getActivityType() {
        return _lfTincanManifestAct.getActivityType();
    }

    /**
    * Sets the activity type of this l f tincan manifest act.
    *
    * @param activityType the activity type of this l f tincan manifest act
    */
    @Override
    public void setActivityType(java.lang.String activityType) {
        _lfTincanManifestAct.setActivityType(activityType);
    }

    /**
    * Returns the name of this l f tincan manifest act.
    *
    * @return the name of this l f tincan manifest act
    */
    @Override
    public java.lang.String getName() {
        return _lfTincanManifestAct.getName();
    }

    /**
    * Sets the name of this l f tincan manifest act.
    *
    * @param name the name of this l f tincan manifest act
    */
    @Override
    public void setName(java.lang.String name) {
        _lfTincanManifestAct.setName(name);
    }

    /**
    * Returns the description of this l f tincan manifest act.
    *
    * @return the description of this l f tincan manifest act
    */
    @Override
    public java.lang.String getDescription() {
        return _lfTincanManifestAct.getDescription();
    }

    /**
    * Sets the description of this l f tincan manifest act.
    *
    * @param description the description of this l f tincan manifest act
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfTincanManifestAct.setDescription(description);
    }

    /**
    * Returns the launch of this l f tincan manifest act.
    *
    * @return the launch of this l f tincan manifest act
    */
    @Override
    public java.lang.String getLaunch() {
        return _lfTincanManifestAct.getLaunch();
    }

    /**
    * Sets the launch of this l f tincan manifest act.
    *
    * @param launch the launch of this l f tincan manifest act
    */
    @Override
    public void setLaunch(java.lang.String launch) {
        _lfTincanManifestAct.setLaunch(launch);
    }

    /**
    * Returns the resource i d of this l f tincan manifest act.
    *
    * @return the resource i d of this l f tincan manifest act
    */
    @Override
    public java.lang.String getResourceID() {
        return _lfTincanManifestAct.getResourceID();
    }

    /**
    * Sets the resource i d of this l f tincan manifest act.
    *
    * @param resourceID the resource i d of this l f tincan manifest act
    */
    @Override
    public void setResourceID(java.lang.String resourceID) {
        _lfTincanManifestAct.setResourceID(resourceID);
    }

    @Override
    public boolean isNew() {
        return _lfTincanManifestAct.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanManifestAct.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanManifestAct.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanManifestAct.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanManifestAct.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanManifestAct.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanManifestAct.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanManifestAct.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanManifestAct.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanManifestAct.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanManifestAct.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanManifestActWrapper((LFTincanManifestAct) _lfTincanManifestAct.clone());
    }

    @Override
    public int compareTo(LFTincanManifestAct lfTincanManifestAct) {
        return _lfTincanManifestAct.compareTo(lfTincanManifestAct);
    }

    @Override
    public int hashCode() {
        return _lfTincanManifestAct.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanManifestAct> toCacheModel() {
        return _lfTincanManifestAct.toCacheModel();
    }

    @Override
    public LFTincanManifestAct toEscapedModel() {
        return new LFTincanManifestActWrapper(_lfTincanManifestAct.toEscapedModel());
    }

    @Override
    public LFTincanManifestAct toUnescapedModel() {
        return new LFTincanManifestActWrapper(_lfTincanManifestAct.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanManifestAct.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanManifestAct.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanManifestAct.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanManifestActWrapper)) {
            return false;
        }

        LFTincanManifestActWrapper lfTincanManifestActWrapper = (LFTincanManifestActWrapper) obj;

        if (Validator.equals(_lfTincanManifestAct,
                    lfTincanManifestActWrapper._lfTincanManifestAct)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanManifestAct getWrappedLFTincanManifestAct() {
        return _lfTincanManifestAct;
    }

    @Override
    public LFTincanManifestAct getWrappedModel() {
        return _lfTincanManifestAct;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanManifestAct.resetOriginalValues();
    }
}
