package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFAttemptData}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFAttemptData
* @generated
*/
public class LFAttemptDataWrapper implements LFAttemptData,
    ModelWrapper<LFAttemptData> {
    private LFAttemptData _lfAttemptData;

    public LFAttemptDataWrapper(LFAttemptData lfAttemptData) {
        _lfAttemptData = lfAttemptData;
    }

    public Class<?> getModelClass() {
        return LFAttemptData.class;
    }

    public String getModelClassName() {
        return LFAttemptData.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("dataKey", getDataKey());
        attributes.put("dataValue", getDataValue());
        attributes.put("attemptID", getAttemptID());
        attributes.put("activityID", getActivityID());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String dataKey = (String) attributes.get("dataKey");

        if (dataKey != null) {
            setDataKey(dataKey);
        }

        String dataValue = (String) attributes.get("dataValue");

        if (dataValue != null) {
            setDataValue(dataValue);
        }

        Integer attemptID = (Integer) attributes.get("attemptID");

        if (attemptID != null) {
            setAttemptID(attemptID);
        }

        String activityID = (String) attributes.get("activityID");

        if (activityID != null) {
            setActivityID(activityID);
        }
    }

    /**
     * Returns the primary key of this l f attempt data.
     *
     * @return the primary key of this l f attempt data
     */
    public long getPrimaryKey() {
        return _lfAttemptData.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f attempt data.
     *
     * @param primaryKey the primary key of this l f attempt data
     */
    public void setPrimaryKey(long primaryKey) {
        _lfAttemptData.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f attempt data.
     *
     * @return the ID of this l f attempt data
     */
    public long getId() {
        return _lfAttemptData.getId();
    }

    /**
     * Sets the ID of this l f attempt data.
     *
     * @param id the ID of this l f attempt data
     */
    public void setId(long id) {
        _lfAttemptData.setId(id);
    }

    /**
     * Returns the data key of this l f attempt data.
     *
     * @return the data key of this l f attempt data
     */
    public java.lang.String getDataKey() {
        return _lfAttemptData.getDataKey();
    }

    /**
     * Sets the data key of this l f attempt data.
     *
     * @param dataKey the data key of this l f attempt data
     */
    public void setDataKey(java.lang.String dataKey) {
        _lfAttemptData.setDataKey(dataKey);
    }

    /**
     * Returns the data value of this l f attempt data.
     *
     * @return the data value of this l f attempt data
     */
    public java.lang.String getDataValue() {
        return _lfAttemptData.getDataValue();
    }

    /**
     * Sets the data value of this l f attempt data.
     *
     * @param dataValue the data value of this l f attempt data
     */
    public void setDataValue(java.lang.String dataValue) {
        _lfAttemptData.setDataValue(dataValue);
    }

    /**
     * Returns the attempt i d of this l f attempt data.
     *
     * @return the attempt i d of this l f attempt data
     */
    public java.lang.Integer getAttemptID() {
        return _lfAttemptData.getAttemptID();
    }

    /**
     * Sets the attempt i d of this l f attempt data.
     *
     * @param attemptID the attempt i d of this l f attempt data
     */
    public void setAttemptID(java.lang.Integer attemptID) {
        _lfAttemptData.setAttemptID(attemptID);
    }

    /**
     * Returns the activity i d of this l f attempt data.
     *
     * @return the activity i d of this l f attempt data
     */
    public java.lang.String getActivityID() {
        return _lfAttemptData.getActivityID();
    }

    /**
     * Sets the activity i d of this l f attempt data.
     *
     * @param activityID the activity i d of this l f attempt data
     */
    public void setActivityID(java.lang.String activityID) {
        _lfAttemptData.setActivityID(activityID);
    }

    public boolean isNew() {
        return _lfAttemptData.isNew();
    }

    public void setNew(boolean n) {
        _lfAttemptData.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfAttemptData.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfAttemptData.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfAttemptData.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfAttemptData.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfAttemptData.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfAttemptData.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfAttemptData.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFAttemptDataWrapper((LFAttemptData) _lfAttemptData.clone());
    }

    public int compareTo(LFAttemptData lfAttemptData) {
        return _lfAttemptData.compareTo(lfAttemptData);
    }

    @Override
    public int hashCode() {
        return _lfAttemptData.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFAttemptData> toCacheModel() {
        return _lfAttemptData.toCacheModel();
    }

    public LFAttemptData toEscapedModel() {
        return new LFAttemptDataWrapper(_lfAttemptData.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfAttemptData.toString();
    }

    public java.lang.String toXmlString() {
        return _lfAttemptData.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAttemptData.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFAttemptData getWrappedLFAttemptData() {
        return _lfAttemptData;
    }

    public LFAttemptData getWrappedModel() {
        return _lfAttemptData;
    }

    public void resetOriginalValues() {
        _lfAttemptData.resetOriginalValues();
    }
}
