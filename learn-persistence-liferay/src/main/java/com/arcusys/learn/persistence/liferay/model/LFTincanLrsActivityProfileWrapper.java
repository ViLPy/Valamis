package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFTincanLrsActivityProfile}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFTincanLrsActivityProfile
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

    public Class<?> getModelClass() {
        return LFTincanLrsActivityProfile.class;
    }

    public String getModelClassName() {
        return LFTincanLrsActivityProfile.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("documentId", getDocumentId());
        attributes.put("activityId", getActivityId());
        attributes.put("profileId", getProfileId());

        return attributes;
    }

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
    public long getPrimaryKey() {
        return _lfTincanLrsActivityProfile.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f tincan lrs activity profile.
     *
     * @param primaryKey the primary key of this l f tincan lrs activity profile
     */
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsActivityProfile.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f tincan lrs activity profile.
     *
     * @return the ID of this l f tincan lrs activity profile
     */
    public long getId() {
        return _lfTincanLrsActivityProfile.getId();
    }

    /**
     * Sets the ID of this l f tincan lrs activity profile.
     *
     * @param id the ID of this l f tincan lrs activity profile
     */
    public void setId(long id) {
        _lfTincanLrsActivityProfile.setId(id);
    }

    /**
     * Returns the document ID of this l f tincan lrs activity profile.
     *
     * @return the document ID of this l f tincan lrs activity profile
     */
    public java.lang.Integer getDocumentId() {
        return _lfTincanLrsActivityProfile.getDocumentId();
    }

    /**
     * Sets the document ID of this l f tincan lrs activity profile.
     *
     * @param documentId the document ID of this l f tincan lrs activity profile
     */
    public void setDocumentId(java.lang.Integer documentId) {
        _lfTincanLrsActivityProfile.setDocumentId(documentId);
    }

    /**
     * Returns the activity ID of this l f tincan lrs activity profile.
     *
     * @return the activity ID of this l f tincan lrs activity profile
     */
    public java.lang.String getActivityId() {
        return _lfTincanLrsActivityProfile.getActivityId();
    }

    /**
     * Sets the activity ID of this l f tincan lrs activity profile.
     *
     * @param activityId the activity ID of this l f tincan lrs activity profile
     */
    public void setActivityId(java.lang.String activityId) {
        _lfTincanLrsActivityProfile.setActivityId(activityId);
    }

    /**
     * Returns the profile ID of this l f tincan lrs activity profile.
     *
     * @return the profile ID of this l f tincan lrs activity profile
     */
    public java.lang.String getProfileId() {
        return _lfTincanLrsActivityProfile.getProfileId();
    }

    /**
     * Sets the profile ID of this l f tincan lrs activity profile.
     *
     * @param profileId the profile ID of this l f tincan lrs activity profile
     */
    public void setProfileId(java.lang.String profileId) {
        _lfTincanLrsActivityProfile.setProfileId(profileId);
    }

    public boolean isNew() {
        return _lfTincanLrsActivityProfile.isNew();
    }

    public void setNew(boolean n) {
        _lfTincanLrsActivityProfile.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfTincanLrsActivityProfile.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsActivityProfile.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfTincanLrsActivityProfile.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsActivityProfile.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsActivityProfile.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsActivityProfile.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsActivityProfile.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsActivityProfileWrapper((LFTincanLrsActivityProfile) _lfTincanLrsActivityProfile.clone());
    }

    public int compareTo(LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        return _lfTincanLrsActivityProfile.compareTo(lfTincanLrsActivityProfile);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsActivityProfile.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFTincanLrsActivityProfile> toCacheModel() {
        return _lfTincanLrsActivityProfile.toCacheModel();
    }

    public LFTincanLrsActivityProfile toEscapedModel() {
        return new LFTincanLrsActivityProfileWrapper(_lfTincanLrsActivityProfile.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsActivityProfile.toString();
    }

    public java.lang.String toXmlString() {
        return _lfTincanLrsActivityProfile.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsActivityProfile.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFTincanLrsActivityProfile getWrappedLFTincanLrsActivityProfile() {
        return _lfTincanLrsActivityProfile;
    }

    public LFTincanLrsActivityProfile getWrappedModel() {
        return _lfTincanLrsActivityProfile;
    }

    public void resetOriginalValues() {
        _lfTincanLrsActivityProfile.resetOriginalValues();
    }
}
