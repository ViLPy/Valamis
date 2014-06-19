package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFCertificateToUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateToUser
 * @generated
 */
public class LFCertificateToUserWrapper implements LFCertificateToUser,
    ModelWrapper<LFCertificateToUser> {
    private LFCertificateToUser _lfCertificateToUser;

    public LFCertificateToUserWrapper(LFCertificateToUser lfCertificateToUser) {
        _lfCertificateToUser = lfCertificateToUser;
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificateToUser.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificateToUser.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("certificateID", getCertificateID());
        attributes.put("userID", getUserID());
        attributes.put("status", getStatus());
        attributes.put("addedToUserDate", getAddedToUserDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer certificateID = (Integer) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        Integer userID = (Integer) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Date addedToUserDate = (Date) attributes.get("addedToUserDate");

        if (addedToUserDate != null) {
            setAddedToUserDate(addedToUserDate);
        }
    }

    /**
    * Returns the primary key of this l f certificate to user.
    *
    * @return the primary key of this l f certificate to user
    */
    @Override
    public com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK getPrimaryKey() {
        return _lfCertificateToUser.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f certificate to user.
    *
    * @param primaryKey the primary key of this l f certificate to user
    */
    @Override
    public void setPrimaryKey(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK primaryKey) {
        _lfCertificateToUser.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the certificate i d of this l f certificate to user.
    *
    * @return the certificate i d of this l f certificate to user
    */
    @Override
    public java.lang.Integer getCertificateID() {
        return _lfCertificateToUser.getCertificateID();
    }

    /**
    * Sets the certificate i d of this l f certificate to user.
    *
    * @param certificateID the certificate i d of this l f certificate to user
    */
    @Override
    public void setCertificateID(java.lang.Integer certificateID) {
        _lfCertificateToUser.setCertificateID(certificateID);
    }

    /**
    * Returns the user i d of this l f certificate to user.
    *
    * @return the user i d of this l f certificate to user
    */
    @Override
    public java.lang.Integer getUserID() {
        return _lfCertificateToUser.getUserID();
    }

    /**
    * Sets the user i d of this l f certificate to user.
    *
    * @param userID the user i d of this l f certificate to user
    */
    @Override
    public void setUserID(java.lang.Integer userID) {
        _lfCertificateToUser.setUserID(userID);
    }

    /**
    * Returns the status of this l f certificate to user.
    *
    * @return the status of this l f certificate to user
    */
    @Override
    public java.lang.String getStatus() {
        return _lfCertificateToUser.getStatus();
    }

    /**
    * Sets the status of this l f certificate to user.
    *
    * @param status the status of this l f certificate to user
    */
    @Override
    public void setStatus(java.lang.String status) {
        _lfCertificateToUser.setStatus(status);
    }

    /**
    * Returns the added to user date of this l f certificate to user.
    *
    * @return the added to user date of this l f certificate to user
    */
    @Override
    public java.util.Date getAddedToUserDate() {
        return _lfCertificateToUser.getAddedToUserDate();
    }

    /**
    * Sets the added to user date of this l f certificate to user.
    *
    * @param addedToUserDate the added to user date of this l f certificate to user
    */
    @Override
    public void setAddedToUserDate(java.util.Date addedToUserDate) {
        _lfCertificateToUser.setAddedToUserDate(addedToUserDate);
    }

    @Override
    public boolean isNew() {
        return _lfCertificateToUser.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfCertificateToUser.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfCertificateToUser.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfCertificateToUser.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfCertificateToUser.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfCertificateToUser.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfCertificateToUser.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfCertificateToUser.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfCertificateToUser.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfCertificateToUser.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfCertificateToUser.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFCertificateToUserWrapper((LFCertificateToUser) _lfCertificateToUser.clone());
    }

    @Override
    public int compareTo(LFCertificateToUser lfCertificateToUser) {
        return _lfCertificateToUser.compareTo(lfCertificateToUser);
    }

    @Override
    public int hashCode() {
        return _lfCertificateToUser.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFCertificateToUser> toCacheModel() {
        return _lfCertificateToUser.toCacheModel();
    }

    @Override
    public LFCertificateToUser toEscapedModel() {
        return new LFCertificateToUserWrapper(_lfCertificateToUser.toEscapedModel());
    }

    @Override
    public LFCertificateToUser toUnescapedModel() {
        return new LFCertificateToUserWrapper(_lfCertificateToUser.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfCertificateToUser.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfCertificateToUser.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateToUser.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateToUserWrapper)) {
            return false;
        }

        LFCertificateToUserWrapper lfCertificateToUserWrapper = (LFCertificateToUserWrapper) obj;

        if (Validator.equals(_lfCertificateToUser,
                    lfCertificateToUserWrapper._lfCertificateToUser)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFCertificateToUser getWrappedLFCertificateToUser() {
        return _lfCertificateToUser;
    }

    @Override
    public LFCertificateToUser getWrappedModel() {
        return _lfCertificateToUser;
    }

    @Override
    public void resetOriginalValues() {
        _lfCertificateToUser.resetOriginalValues();
    }
}
