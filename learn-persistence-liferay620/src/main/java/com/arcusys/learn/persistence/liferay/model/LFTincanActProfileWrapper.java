package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanActProfile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActProfile
 * @generated
 */
public class LFTincanActProfileWrapper implements LFTincanActProfile,
    ModelWrapper<LFTincanActProfile> {
    private LFTincanActProfile _lfTincanActProfile;

    public LFTincanActProfileWrapper(LFTincanActProfile lfTincanActProfile) {
        _lfTincanActProfile = lfTincanActProfile;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanActProfile.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanActProfile.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("documentId", getDocumentId());
        attributes.put("activityId", getActivityId());
        attributes.put("profileId", getProfileId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer documentId = (Integer) attributes.get("documentId");

        if (documentId != null) {
            setDocumentId(documentId);
        }

        String activityId = (String) attributes.get("activityId");

        if (activityId != null) {
            setActivityId(activityId);
        }

        String profileId = (String) attributes.get("profileId");

        if (profileId != null) {
            setProfileId(profileId);
        }
    }

    /**
    * Returns the primary key of this l f tincan act profile.
    *
    * @return the primary key of this l f tincan act profile
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanActProfile.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan act profile.
    *
    * @param primaryKey the primary key of this l f tincan act profile
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanActProfile.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan act profile.
    *
    * @return the ID of this l f tincan act profile
    */
    @Override
    public long getId() {
        return _lfTincanActProfile.getId();
    }

    /**
    * Sets the ID of this l f tincan act profile.
    *
    * @param id the ID of this l f tincan act profile
    */
    @Override
    public void setId(long id) {
        _lfTincanActProfile.setId(id);
    }

    /**
    * Returns the document ID of this l f tincan act profile.
    *
    * @return the document ID of this l f tincan act profile
    */
    @Override
    public java.lang.Integer getDocumentId() {
        return _lfTincanActProfile.getDocumentId();
    }

    /**
    * Sets the document ID of this l f tincan act profile.
    *
    * @param documentId the document ID of this l f tincan act profile
    */
    @Override
    public void setDocumentId(java.lang.Integer documentId) {
        _lfTincanActProfile.setDocumentId(documentId);
    }

    /**
    * Returns the activity ID of this l f tincan act profile.
    *
    * @return the activity ID of this l f tincan act profile
    */
    @Override
    public java.lang.String getActivityId() {
        return _lfTincanActProfile.getActivityId();
    }

    /**
    * Sets the activity ID of this l f tincan act profile.
    *
    * @param activityId the activity ID of this l f tincan act profile
    */
    @Override
    public void setActivityId(java.lang.String activityId) {
        _lfTincanActProfile.setActivityId(activityId);
    }

    /**
    * Returns the profile ID of this l f tincan act profile.
    *
    * @return the profile ID of this l f tincan act profile
    */
    @Override
    public java.lang.String getProfileId() {
        return _lfTincanActProfile.getProfileId();
    }

    /**
    * Sets the profile ID of this l f tincan act profile.
    *
    * @param profileId the profile ID of this l f tincan act profile
    */
    @Override
    public void setProfileId(java.lang.String profileId) {
        _lfTincanActProfile.setProfileId(profileId);
    }

    @Override
    public boolean isNew() {
        return _lfTincanActProfile.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanActProfile.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanActProfile.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanActProfile.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanActProfile.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanActProfile.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanActProfile.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanActProfile.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanActProfile.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanActProfile.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanActProfile.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanActProfileWrapper((LFTincanActProfile) _lfTincanActProfile.clone());
    }

    @Override
    public int compareTo(LFTincanActProfile lfTincanActProfile) {
        return _lfTincanActProfile.compareTo(lfTincanActProfile);
    }

    @Override
    public int hashCode() {
        return _lfTincanActProfile.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanActProfile> toCacheModel() {
        return _lfTincanActProfile.toCacheModel();
    }

    @Override
    public LFTincanActProfile toEscapedModel() {
        return new LFTincanActProfileWrapper(_lfTincanActProfile.toEscapedModel());
    }

    @Override
    public LFTincanActProfile toUnescapedModel() {
        return new LFTincanActProfileWrapper(_lfTincanActProfile.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanActProfile.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanActProfile.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanActProfile.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanActProfileWrapper)) {
            return false;
        }

        LFTincanActProfileWrapper lfTincanActProfileWrapper = (LFTincanActProfileWrapper) obj;

        if (Validator.equals(_lfTincanActProfile,
                    lfTincanActProfileWrapper._lfTincanActProfile)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanActProfile getWrappedLFTincanActProfile() {
        return _lfTincanActProfile;
    }

    @Override
    public LFTincanActProfile getWrappedModel() {
        return _lfTincanActProfile;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanActProfile.resetOriginalValues();
    }
}
