package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFCertificateUser}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFCertificateUser
* @generated
*/
public class LFCertificateUserWrapper implements LFCertificateUser,
    ModelWrapper<LFCertificateUser> {
    private LFCertificateUser _lfCertificateUser;

    public LFCertificateUserWrapper(LFCertificateUser lfCertificateUser) {
        _lfCertificateUser = lfCertificateUser;
    }

    public Class<?> getModelClass() {
        return LFCertificateUser.class;
    }

    public String getModelClassName() {
        return LFCertificateUser.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("certificateID", getCertificateID());
        attributes.put("userID", getUserID());

        return attributes;
    }

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
    public long getPrimaryKey() {
        return _lfCertificateUser.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f certificate user.
     *
     * @param primaryKey the primary key of this l f certificate user
     */
    public void setPrimaryKey(long primaryKey) {
        _lfCertificateUser.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f certificate user.
     *
     * @return the ID of this l f certificate user
     */
    public long getId() {
        return _lfCertificateUser.getId();
    }

    /**
     * Sets the ID of this l f certificate user.
     *
     * @param id the ID of this l f certificate user
     */
    public void setId(long id) {
        _lfCertificateUser.setId(id);
    }

    /**
     * Returns the certificate i d of this l f certificate user.
     *
     * @return the certificate i d of this l f certificate user
     */
    public java.lang.Integer getCertificateID() {
        return _lfCertificateUser.getCertificateID();
    }

    /**
     * Sets the certificate i d of this l f certificate user.
     *
     * @param certificateID the certificate i d of this l f certificate user
     */
    public void setCertificateID(java.lang.Integer certificateID) {
        _lfCertificateUser.setCertificateID(certificateID);
    }

    /**
     * Returns the user i d of this l f certificate user.
     *
     * @return the user i d of this l f certificate user
     */
    public java.lang.Integer getUserID() {
        return _lfCertificateUser.getUserID();
    }

    /**
     * Sets the user i d of this l f certificate user.
     *
     * @param userID the user i d of this l f certificate user
     */
    public void setUserID(java.lang.Integer userID) {
        _lfCertificateUser.setUserID(userID);
    }

    public boolean isNew() {
        return _lfCertificateUser.isNew();
    }

    public void setNew(boolean n) {
        _lfCertificateUser.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfCertificateUser.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfCertificateUser.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfCertificateUser.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfCertificateUser.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfCertificateUser.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfCertificateUser.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfCertificateUser.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFCertificateUserWrapper((LFCertificateUser) _lfCertificateUser.clone());
    }

    public int compareTo(LFCertificateUser lfCertificateUser) {
        return _lfCertificateUser.compareTo(lfCertificateUser);
    }

    @Override
    public int hashCode() {
        return _lfCertificateUser.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFCertificateUser> toCacheModel() {
        return _lfCertificateUser.toCacheModel();
    }

    public LFCertificateUser toEscapedModel() {
        return new LFCertificateUserWrapper(_lfCertificateUser.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfCertificateUser.toString();
    }

    public java.lang.String toXmlString() {
        return _lfCertificateUser.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateUser.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFCertificateUser getWrappedLFCertificateUser() {
        return _lfCertificateUser;
    }

    public LFCertificateUser getWrappedModel() {
        return _lfCertificateUser;
    }

    public void resetOriginalValues() {
        _lfCertificateUser.resetOriginalValues();
    }
}
