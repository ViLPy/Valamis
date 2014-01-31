package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsActivityProfile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsActivityProfile
 * @generated
 */
public class LFTincanLrsActivityProfileWrapper
    implements LFTincanLrsActivityProfile,
        ModelWrapper<LFTincanLrsActivityProfile> {
    private LFTincanLrsActivityProfile _lfTincanLrsActivityProfile;

    public LFTincanLrsActivityProfileWrapper(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        _lfTincanLrsActivityProfile = lfTincanLrsActivityProfile;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsActivityProfile.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsActivityProfile.class.getName();
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
    * Returns the primary key of this l f tincan lrs activity profile.
    *
    * @return the primary key of this l f tincan lrs activity profile
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanLrsActivityProfile.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan lrs activity profile.
    *
    * @param primaryKey the primary key of this l f tincan lrs activity profile
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsActivityProfile.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan lrs activity profile.
    *
    * @return the ID of this l f tincan lrs activity profile
    */
    @Override
    public long getId() {
        return _lfTincanLrsActivityProfile.getId();
    }

    /**
    * Sets the ID of this l f tincan lrs activity profile.
    *
    * @param id the ID of this l f tincan lrs activity profile
    */
    @Override
    public void setId(long id) {
        _lfTincanLrsActivityProfile.setId(id);
    }

    /**
    * Returns the document ID of this l f tincan lrs activity profile.
    *
    * @return the document ID of this l f tincan lrs activity profile
    */
    @Override
    public java.lang.Integer getDocumentId() {
        return _lfTincanLrsActivityProfile.getDocumentId();
    }

    /**
    * Sets the document ID of this l f tincan lrs activity profile.
    *
    * @param documentId the document ID of this l f tincan lrs activity profile
    */
    @Override
    public void setDocumentId(java.lang.Integer documentId) {
        _lfTincanLrsActivityProfile.setDocumentId(documentId);
    }

    /**
    * Returns the activity ID of this l f tincan lrs activity profile.
    *
    * @return the activity ID of this l f tincan lrs activity profile
    */
    @Override
    public java.lang.String getActivityId() {
        return _lfTincanLrsActivityProfile.getActivityId();
    }

    /**
    * Sets the activity ID of this l f tincan lrs activity profile.
    *
    * @param activityId the activity ID of this l f tincan lrs activity profile
    */
    @Override
    public void setActivityId(java.lang.String activityId) {
        _lfTincanLrsActivityProfile.setActivityId(activityId);
    }

    /**
    * Returns the profile ID of this l f tincan lrs activity profile.
    *
    * @return the profile ID of this l f tincan lrs activity profile
    */
    @Override
    public java.lang.String getProfileId() {
        return _lfTincanLrsActivityProfile.getProfileId();
    }

    /**
    * Sets the profile ID of this l f tincan lrs activity profile.
    *
    * @param profileId the profile ID of this l f tincan lrs activity profile
    */
    @Override
    public void setProfileId(java.lang.String profileId) {
        _lfTincanLrsActivityProfile.setProfileId(profileId);
    }

    @Override
    public boolean isNew() {
        return _lfTincanLrsActivityProfile.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanLrsActivityProfile.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanLrsActivityProfile.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsActivityProfile.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanLrsActivityProfile.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsActivityProfile.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsActivityProfile.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsActivityProfile.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanLrsActivityProfile.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanLrsActivityProfile.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsActivityProfile.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsActivityProfileWrapper((LFTincanLrsActivityProfile) _lfTincanLrsActivityProfile.clone());
    }

    @Override
    public int compareTo(LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        return _lfTincanLrsActivityProfile.compareTo(lfTincanLrsActivityProfile);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsActivityProfile.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanLrsActivityProfile> toCacheModel() {
        return _lfTincanLrsActivityProfile.toCacheModel();
    }

    @Override
    public LFTincanLrsActivityProfile toEscapedModel() {
        return new LFTincanLrsActivityProfileWrapper(_lfTincanLrsActivityProfile.toEscapedModel());
    }

    @Override
    public LFTincanLrsActivityProfile toUnescapedModel() {
        return new LFTincanLrsActivityProfileWrapper(_lfTincanLrsActivityProfile.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsActivityProfile.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanLrsActivityProfile.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsActivityProfile.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanLrsActivityProfileWrapper)) {
            return false;
        }

        LFTincanLrsActivityProfileWrapper lfTincanLrsActivityProfileWrapper = (LFTincanLrsActivityProfileWrapper) obj;

        if (Validator.equals(_lfTincanLrsActivityProfile,
                    lfTincanLrsActivityProfileWrapper._lfTincanLrsActivityProfile)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanLrsActivityProfile getWrappedLFTincanLrsActivityProfile() {
        return _lfTincanLrsActivityProfile;
    }

    @Override
    public LFTincanLrsActivityProfile getWrappedModel() {
        return _lfTincanLrsActivityProfile;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanLrsActivityProfile.resetOriginalValues();
    }
}
