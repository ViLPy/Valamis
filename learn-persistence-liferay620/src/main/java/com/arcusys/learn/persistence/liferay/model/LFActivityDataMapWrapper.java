package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFActivityDataMap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityDataMap
 * @generated
 */
public class LFActivityDataMapWrapper implements LFActivityDataMap,
    ModelWrapper<LFActivityDataMap> {
    private LFActivityDataMap _lfActivityDataMap;

    public LFActivityDataMapWrapper(LFActivityDataMap lfActivityDataMap) {
        _lfActivityDataMap = lfActivityDataMap;
    }

    @Override
    public Class<?> getModelClass() {
        return LFActivityDataMap.class;
    }

    @Override
    public String getModelClassName() {
        return LFActivityDataMap.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("packageID", getPackageID());
        attributes.put("activityID", getActivityID());
        attributes.put("targetId", getTargetId());
        attributes.put("readSharedData", getReadSharedData());
        attributes.put("writeSharedData", getWriteSharedData());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String activityID = (String) attributes.get("activityID");

        if (activityID != null) {
            setActivityID(activityID);
        }

        String targetId = (String) attributes.get("targetId");

        if (targetId != null) {
            setTargetId(targetId);
        }

        Boolean readSharedData = (Boolean) attributes.get("readSharedData");

        if (readSharedData != null) {
            setReadSharedData(readSharedData);
        }

        Boolean writeSharedData = (Boolean) attributes.get("writeSharedData");

        if (writeSharedData != null) {
            setWriteSharedData(writeSharedData);
        }
    }

    /**
    * Returns the primary key of this l f activity data map.
    *
    * @return the primary key of this l f activity data map
    */
    @Override
    public long getPrimaryKey() {
        return _lfActivityDataMap.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f activity data map.
    *
    * @param primaryKey the primary key of this l f activity data map
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfActivityDataMap.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f activity data map.
    *
    * @return the ID of this l f activity data map
    */
    @Override
    public long getId() {
        return _lfActivityDataMap.getId();
    }

    /**
    * Sets the ID of this l f activity data map.
    *
    * @param id the ID of this l f activity data map
    */
    @Override
    public void setId(long id) {
        _lfActivityDataMap.setId(id);
    }

    /**
    * Returns the package i d of this l f activity data map.
    *
    * @return the package i d of this l f activity data map
    */
    @Override
    public java.lang.Integer getPackageID() {
        return _lfActivityDataMap.getPackageID();
    }

    /**
    * Sets the package i d of this l f activity data map.
    *
    * @param packageID the package i d of this l f activity data map
    */
    @Override
    public void setPackageID(java.lang.Integer packageID) {
        _lfActivityDataMap.setPackageID(packageID);
    }

    /**
    * Returns the activity i d of this l f activity data map.
    *
    * @return the activity i d of this l f activity data map
    */
    @Override
    public java.lang.String getActivityID() {
        return _lfActivityDataMap.getActivityID();
    }

    /**
    * Sets the activity i d of this l f activity data map.
    *
    * @param activityID the activity i d of this l f activity data map
    */
    @Override
    public void setActivityID(java.lang.String activityID) {
        _lfActivityDataMap.setActivityID(activityID);
    }

    /**
    * Returns the target ID of this l f activity data map.
    *
    * @return the target ID of this l f activity data map
    */
    @Override
    public java.lang.String getTargetId() {
        return _lfActivityDataMap.getTargetId();
    }

    /**
    * Sets the target ID of this l f activity data map.
    *
    * @param targetId the target ID of this l f activity data map
    */
    @Override
    public void setTargetId(java.lang.String targetId) {
        _lfActivityDataMap.setTargetId(targetId);
    }

    /**
    * Returns the read shared data of this l f activity data map.
    *
    * @return the read shared data of this l f activity data map
    */
    @Override
    public boolean getReadSharedData() {
        return _lfActivityDataMap.getReadSharedData();
    }

    /**
    * Returns <code>true</code> if this l f activity data map is read shared data.
    *
    * @return <code>true</code> if this l f activity data map is read shared data; <code>false</code> otherwise
    */
    @Override
    public boolean isReadSharedData() {
        return _lfActivityDataMap.isReadSharedData();
    }

    /**
    * Sets whether this l f activity data map is read shared data.
    *
    * @param readSharedData the read shared data of this l f activity data map
    */
    @Override
    public void setReadSharedData(boolean readSharedData) {
        _lfActivityDataMap.setReadSharedData(readSharedData);
    }

    /**
    * Returns the write shared data of this l f activity data map.
    *
    * @return the write shared data of this l f activity data map
    */
    @Override
    public boolean getWriteSharedData() {
        return _lfActivityDataMap.getWriteSharedData();
    }

    /**
    * Returns <code>true</code> if this l f activity data map is write shared data.
    *
    * @return <code>true</code> if this l f activity data map is write shared data; <code>false</code> otherwise
    */
    @Override
    public boolean isWriteSharedData() {
        return _lfActivityDataMap.isWriteSharedData();
    }

    /**
    * Sets whether this l f activity data map is write shared data.
    *
    * @param writeSharedData the write shared data of this l f activity data map
    */
    @Override
    public void setWriteSharedData(boolean writeSharedData) {
        _lfActivityDataMap.setWriteSharedData(writeSharedData);
    }

    @Override
    public boolean isNew() {
        return _lfActivityDataMap.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfActivityDataMap.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfActivityDataMap.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfActivityDataMap.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfActivityDataMap.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfActivityDataMap.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfActivityDataMap.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfActivityDataMap.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfActivityDataMap.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfActivityDataMap.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfActivityDataMap.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFActivityDataMapWrapper((LFActivityDataMap) _lfActivityDataMap.clone());
    }

    @Override
    public int compareTo(LFActivityDataMap lfActivityDataMap) {
        return _lfActivityDataMap.compareTo(lfActivityDataMap);
    }

    @Override
    public int hashCode() {
        return _lfActivityDataMap.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFActivityDataMap> toCacheModel() {
        return _lfActivityDataMap.toCacheModel();
    }

    @Override
    public LFActivityDataMap toEscapedModel() {
        return new LFActivityDataMapWrapper(_lfActivityDataMap.toEscapedModel());
    }

    @Override
    public LFActivityDataMap toUnescapedModel() {
        return new LFActivityDataMapWrapper(_lfActivityDataMap.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfActivityDataMap.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfActivityDataMap.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityDataMap.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFActivityDataMapWrapper)) {
            return false;
        }

        LFActivityDataMapWrapper lfActivityDataMapWrapper = (LFActivityDataMapWrapper) obj;

        if (Validator.equals(_lfActivityDataMap,
                    lfActivityDataMapWrapper._lfActivityDataMap)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFActivityDataMap getWrappedLFActivityDataMap() {
        return _lfActivityDataMap;
    }

    @Override
    public LFActivityDataMap getWrappedModel() {
        return _lfActivityDataMap;
    }

    @Override
    public void resetOriginalValues() {
        _lfActivityDataMap.resetOriginalValues();
    }
}
