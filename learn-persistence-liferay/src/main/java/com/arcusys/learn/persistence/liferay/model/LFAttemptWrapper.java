package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFAttempt}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFAttempt
* @generated
*/
public class LFAttemptWrapper implements LFAttempt, ModelWrapper<LFAttempt> {
    private LFAttempt _lfAttempt;

    public LFAttemptWrapper(LFAttempt lfAttempt) {
        _lfAttempt = lfAttempt;
    }

    public Class<?> getModelClass() {
        return LFAttempt.class;
    }

    public String getModelClassName() {
        return LFAttempt.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("userID", getUserID());
        attributes.put("packageID", getPackageID());
        attributes.put("organizationID", getOrganizationID());
        attributes.put("isComplete", getIsComplete());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer userID = (Integer) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String organizationID = (String) attributes.get("organizationID");

        if (organizationID != null) {
            setOrganizationID(organizationID);
        }

        Boolean isComplete = (Boolean) attributes.get("isComplete");

        if (isComplete != null) {
            setIsComplete(isComplete);
        }
    }

    /**
     * Returns the primary key of this l f attempt.
     *
     * @return the primary key of this l f attempt
     */
    public long getPrimaryKey() {
        return _lfAttempt.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f attempt.
     *
     * @param primaryKey the primary key of this l f attempt
     */
    public void setPrimaryKey(long primaryKey) {
        _lfAttempt.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f attempt.
     *
     * @return the ID of this l f attempt
     */
    public long getId() {
        return _lfAttempt.getId();
    }

    /**
     * Sets the ID of this l f attempt.
     *
     * @param id the ID of this l f attempt
     */
    public void setId(long id) {
        _lfAttempt.setId(id);
    }

    /**
     * Returns the user i d of this l f attempt.
     *
     * @return the user i d of this l f attempt
     */
    public java.lang.Integer getUserID() {
        return _lfAttempt.getUserID();
    }

    /**
     * Sets the user i d of this l f attempt.
     *
     * @param userID the user i d of this l f attempt
     */
    public void setUserID(java.lang.Integer userID) {
        _lfAttempt.setUserID(userID);
    }

    /**
     * Returns the package i d of this l f attempt.
     *
     * @return the package i d of this l f attempt
     */
    public java.lang.Integer getPackageID() {
        return _lfAttempt.getPackageID();
    }

    /**
     * Sets the package i d of this l f attempt.
     *
     * @param packageID the package i d of this l f attempt
     */
    public void setPackageID(java.lang.Integer packageID) {
        _lfAttempt.setPackageID(packageID);
    }

    /**
     * Returns the organization i d of this l f attempt.
     *
     * @return the organization i d of this l f attempt
     */
    public java.lang.String getOrganizationID() {
        return _lfAttempt.getOrganizationID();
    }

    /**
     * Sets the organization i d of this l f attempt.
     *
     * @param organizationID the organization i d of this l f attempt
     */
    public void setOrganizationID(java.lang.String organizationID) {
        _lfAttempt.setOrganizationID(organizationID);
    }

    /**
     * Returns the is complete of this l f attempt.
     *
     * @return the is complete of this l f attempt
     */
    public java.lang.Boolean getIsComplete() {
        return _lfAttempt.getIsComplete();
    }

    /**
     * Sets the is complete of this l f attempt.
     *
     * @param isComplete the is complete of this l f attempt
     */
    public void setIsComplete(java.lang.Boolean isComplete) {
        _lfAttempt.setIsComplete(isComplete);
    }

    public boolean isNew() {
        return _lfAttempt.isNew();
    }

    public void setNew(boolean n) {
        _lfAttempt.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfAttempt.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfAttempt.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfAttempt.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfAttempt.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfAttempt.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfAttempt.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfAttempt.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFAttemptWrapper((LFAttempt) _lfAttempt.clone());
    }

    public int compareTo(LFAttempt lfAttempt) {
        return _lfAttempt.compareTo(lfAttempt);
    }

    @Override
    public int hashCode() {
        return _lfAttempt.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFAttempt> toCacheModel() {
        return _lfAttempt.toCacheModel();
    }

    public LFAttempt toEscapedModel() {
        return new LFAttemptWrapper(_lfAttempt.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfAttempt.toString();
    }

    public java.lang.String toXmlString() {
        return _lfAttempt.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAttempt.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFAttempt getWrappedLFAttempt() {
        return _lfAttempt;
    }

    public LFAttempt getWrappedModel() {
        return _lfAttempt;
    }

    public void resetOriginalValues() {
        _lfAttempt.resetOriginalValues();
    }
}
