package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFCertificateUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateUser
 * @generated
 */
public class LFCertificateUserWrapper implements LFCertificateUser,
    ModelWrapper<LFCertificateUser> {
    private LFCertificateUser _lfCertificateUser;

    public LFCertificateUserWrapper(LFCertificateUser lfCertificateUser) {
        _lfCertificateUser = lfCertificateUser;
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificateUser.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificateUser.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("certificateID", getCertificateID());
        attributes.put("userID", getUserID());
        attributes.put("attachedDate", getAttachedDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long certificateID = (Long) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        Long userID = (Long) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }

        Date attachedDate = (Date) attributes.get("attachedDate");

        if (attachedDate != null) {
            setAttachedDate(attachedDate);
        }
    }

    /**
    * Returns the primary key of this l f certificate user.
    *
    * @return the primary key of this l f certificate user
    */
    @Override
    public com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK getPrimaryKey() {
        return _lfCertificateUser.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f certificate user.
    *
    * @param primaryKey the primary key of this l f certificate user
    */
    @Override
    public void setPrimaryKey(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK primaryKey) {
        _lfCertificateUser.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the certificate i d of this l f certificate user.
    *
    * @return the certificate i d of this l f certificate user
    */
    @Override
    public java.lang.Long getCertificateID() {
        return _lfCertificateUser.getCertificateID();
    }

    /**
    * Sets the certificate i d of this l f certificate user.
    *
    * @param certificateID the certificate i d of this l f certificate user
    */
    @Override
    public void setCertificateID(java.lang.Long certificateID) {
        _lfCertificateUser.setCertificateID(certificateID);
    }

    /**
    * Returns the user i d of this l f certificate user.
    *
    * @return the user i d of this l f certificate user
    */
    @Override
    public java.lang.Long getUserID() {
        return _lfCertificateUser.getUserID();
    }

    /**
    * Sets the user i d of this l f certificate user.
    *
    * @param userID the user i d of this l f certificate user
    */
    @Override
    public void setUserID(java.lang.Long userID) {
        _lfCertificateUser.setUserID(userID);
    }

    /**
    * Returns the attached date of this l f certificate user.
    *
    * @return the attached date of this l f certificate user
    */
    @Override
    public java.util.Date getAttachedDate() {
        return _lfCertificateUser.getAttachedDate();
    }

    /**
    * Sets the attached date of this l f certificate user.
    *
    * @param attachedDate the attached date of this l f certificate user
    */
    @Override
    public void setAttachedDate(java.util.Date attachedDate) {
        _lfCertificateUser.setAttachedDate(attachedDate);
    }

    @Override
    public boolean isNew() {
        return _lfCertificateUser.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfCertificateUser.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfCertificateUser.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfCertificateUser.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfCertificateUser.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfCertificateUser.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfCertificateUser.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfCertificateUser.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfCertificateUser.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfCertificateUser.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfCertificateUser.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFCertificateUserWrapper((LFCertificateUser) _lfCertificateUser.clone());
    }

    @Override
    public int compareTo(LFCertificateUser lfCertificateUser) {
        return _lfCertificateUser.compareTo(lfCertificateUser);
    }

    @Override
    public int hashCode() {
        return _lfCertificateUser.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFCertificateUser> toCacheModel() {
        return _lfCertificateUser.toCacheModel();
    }

    @Override
    public LFCertificateUser toEscapedModel() {
        return new LFCertificateUserWrapper(_lfCertificateUser.toEscapedModel());
    }

    @Override
    public LFCertificateUser toUnescapedModel() {
        return new LFCertificateUserWrapper(_lfCertificateUser.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfCertificateUser.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfCertificateUser.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateUser.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateUserWrapper)) {
            return false;
        }

        LFCertificateUserWrapper lfCertificateUserWrapper = (LFCertificateUserWrapper) obj;

        if (Validator.equals(_lfCertificateUser,
                    lfCertificateUserWrapper._lfCertificateUser)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFCertificateUser getWrappedLFCertificateUser() {
        return _lfCertificateUser;
    }

    @Override
    public LFCertificateUser getWrappedModel() {
        return _lfCertificateUser;
    }

    @Override
    public void resetOriginalValues() {
        _lfCertificateUser.resetOriginalValues();
    }
}
