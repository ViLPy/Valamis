package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFTincanLrsAgentProfile}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFTincanLrsAgentProfile
* @generated
*/
public class LFTincanLrsAgentProfileWrapper implements LFTincanLrsAgentProfile,
    ModelWrapper<LFTincanLrsAgentProfile> {
    private LFTincanLrsAgentProfile _lfTincanLrsAgentProfile;

    public LFTincanLrsAgentProfileWrapper(
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile) {
        _lfTincanLrsAgentProfile = lfTincanLrsAgentProfile;
    }

    public Class<?> getModelClass() {
        return LFTincanLrsAgentProfile.class;
    }

    public String getModelClassName() {
        return LFTincanLrsAgentProfile.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("documentId", getDocumentId());
        attributes.put("agentId", getAgentId());
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

        Integer agentId = (Integer) attributes.get("agentId");

        if (agentId != null) {
            setAgentId(agentId);
        }

        String profileId = (String) attributes.get("profileId");

        if (profileId != null) {
            setProfileId(profileId);
        }
    }

    /**
     * Returns the primary key of this l f tincan lrs agent profile.
     *
     * @return the primary key of this l f tincan lrs agent profile
     */
    public long getPrimaryKey() {
        return _lfTincanLrsAgentProfile.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f tincan lrs agent profile.
     *
     * @param primaryKey the primary key of this l f tincan lrs agent profile
     */
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsAgentProfile.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f tincan lrs agent profile.
     *
     * @return the ID of this l f tincan lrs agent profile
     */
    public long getId() {
        return _lfTincanLrsAgentProfile.getId();
    }

    /**
     * Sets the ID of this l f tincan lrs agent profile.
     *
     * @param id the ID of this l f tincan lrs agent profile
     */
    public void setId(long id) {
        _lfTincanLrsAgentProfile.setId(id);
    }

    /**
     * Returns the document ID of this l f tincan lrs agent profile.
     *
     * @return the document ID of this l f tincan lrs agent profile
     */
    public java.lang.Integer getDocumentId() {
        return _lfTincanLrsAgentProfile.getDocumentId();
    }

    /**
     * Sets the document ID of this l f tincan lrs agent profile.
     *
     * @param documentId the document ID of this l f tincan lrs agent profile
     */
    public void setDocumentId(java.lang.Integer documentId) {
        _lfTincanLrsAgentProfile.setDocumentId(documentId);
    }

    /**
     * Returns the agent ID of this l f tincan lrs agent profile.
     *
     * @return the agent ID of this l f tincan lrs agent profile
     */
    public java.lang.Integer getAgentId() {
        return _lfTincanLrsAgentProfile.getAgentId();
    }

    /**
     * Sets the agent ID of this l f tincan lrs agent profile.
     *
     * @param agentId the agent ID of this l f tincan lrs agent profile
     */
    public void setAgentId(java.lang.Integer agentId) {
        _lfTincanLrsAgentProfile.setAgentId(agentId);
    }

    /**
     * Returns the profile ID of this l f tincan lrs agent profile.
     *
     * @return the profile ID of this l f tincan lrs agent profile
     */
    public java.lang.String getProfileId() {
        return _lfTincanLrsAgentProfile.getProfileId();
    }

    /**
     * Sets the profile ID of this l f tincan lrs agent profile.
     *
     * @param profileId the profile ID of this l f tincan lrs agent profile
     */
    public void setProfileId(java.lang.String profileId) {
        _lfTincanLrsAgentProfile.setProfileId(profileId);
    }

    public boolean isNew() {
        return _lfTincanLrsAgentProfile.isNew();
    }

    public void setNew(boolean n) {
        _lfTincanLrsAgentProfile.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfTincanLrsAgentProfile.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsAgentProfile.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfTincanLrsAgentProfile.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsAgentProfile.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsAgentProfile.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsAgentProfile.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsAgentProfile.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsAgentProfileWrapper((LFTincanLrsAgentProfile) _lfTincanLrsAgentProfile.clone());
    }

    public int compareTo(LFTincanLrsAgentProfile lfTincanLrsAgentProfile) {
        return _lfTincanLrsAgentProfile.compareTo(lfTincanLrsAgentProfile);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsAgentProfile.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFTincanLrsAgentProfile> toCacheModel() {
        return _lfTincanLrsAgentProfile.toCacheModel();
    }

    public LFTincanLrsAgentProfile toEscapedModel() {
        return new LFTincanLrsAgentProfileWrapper(_lfTincanLrsAgentProfile.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsAgentProfile.toString();
    }

    public java.lang.String toXmlString() {
        return _lfTincanLrsAgentProfile.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsAgentProfile.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFTincanLrsAgentProfile getWrappedLFTincanLrsAgentProfile() {
        return _lfTincanLrsAgentProfile;
    }

    public LFTincanLrsAgentProfile getWrappedModel() {
        return _lfTincanLrsAgentProfile;
    }

    public void resetOriginalValues() {
        _lfTincanLrsAgentProfile.resetOriginalValues();
    }
}
