package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

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

        attributes.put("id", getId());
        attributes.put("certificateID", getCertificateID());
        attributes.put("userID", getUserID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer certificateID = (Integer) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        Integer userID = (Integer) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }
    }

    /**
    * Returns the primary key of this l f certificate user.
    *
    * @return the primary key of this l f certificate user
    */
    @Override
    public long getPrimaryKey() {
        return _lfCertificateUser.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f certificate user.
    *
    * @param primaryKey the primary key of this l f certificate user
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfCertificateUser.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f certificate user.
    *
    * @return the ID of this l f certificate user
    */
    @Override
    public long getId() {
        return _lfCertificateUser.getId();
    }

    /**
    * Sets the ID of this l f certificate user.
    *
    * @param id the ID of this l f certificate user
    */
    @Override
    public void setId(long id) {
        _lfCertificateUser.setId(id);
    }

    /**
    * Returns the certificate i d of this l f certificate user.
    *
    * @return the certificate i d of this l f certificate user
    */
    @Override
    public java.lang.Integer getCertificateID() {
        return _lfCertificateUser.getCertificateID();
    }

    /**
    * Sets the certificate i d of this l f certificate user.
    *
    * @param certificateID the certificate i d of this l f certificate user
    */
    @Override
    public void setCertificateID(java.lang.Integer certificateID) {
        _lfCertificateUser.setCertificateID(certificateID);
    }

    /**
    * Returns the user i d of this l f certificate user.
    *
    * @return the user i d of this l f certificate user
    */
    @Override
    public java.lang.Integer getUserID() {
        return _lfCertificateUser.getUserID();
    }

    /**
    * Sets the user i d of this l f certificate user.
    *
    * @param userID the user i d of this l f certificate user
    */
    @Override
    public void setUserID(java.lang.Integer userID) {
        _lfCertificateUser.setUserID(userID);
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
