package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsAgentProfile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsAgentProfile
 * @generated
 */
public class LFTincanLrsAgentProfileWrapper implements LFTincanLrsAgentProfile,
    ModelWrapper<LFTincanLrsAgentProfile> {
    private LFTincanLrsAgentProfile _lfTincanLrsAgentProfile;

    public LFTincanLrsAgentProfileWrapper(
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile) {
        _lfTincanLrsAgentProfile = lfTincanLrsAgentProfile;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsAgentProfile.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsAgentProfile.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("documentId", getDocumentId());
        attributes.put("agentId", getAgentId());
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
    @Override
    public long getPrimaryKey() {
        return _lfTincanLrsAgentProfile.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan lrs agent profile.
    *
    * @param primaryKey the primary key of this l f tincan lrs agent profile
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsAgentProfile.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan lrs agent profile.
    *
    * @return the ID of this l f tincan lrs agent profile
    */
    @Override
    public long getId() {
        return _lfTincanLrsAgentProfile.getId();
    }

    /**
    * Sets the ID of this l f tincan lrs agent profile.
    *
    * @param id the ID of this l f tincan lrs agent profile
    */
    @Override
    public void setId(long id) {
        _lfTincanLrsAgentProfile.setId(id);
    }

    /**
    * Returns the document ID of this l f tincan lrs agent profile.
    *
    * @return the document ID of this l f tincan lrs agent profile
    */
    @Override
    public java.lang.Integer getDocumentId() {
        return _lfTincanLrsAgentProfile.getDocumentId();
    }

    /**
    * Sets the document ID of this l f tincan lrs agent profile.
    *
    * @param documentId the document ID of this l f tincan lrs agent profile
    */
    @Override
    public void setDocumentId(java.lang.Integer documentId) {
        _lfTincanLrsAgentProfile.setDocumentId(documentId);
    }

    /**
    * Returns the agent ID of this l f tincan lrs agent profile.
    *
    * @return the agent ID of this l f tincan lrs agent profile
    */
    @Override
    public java.lang.Integer getAgentId() {
        return _lfTincanLrsAgentProfile.getAgentId();
    }

    /**
    * Sets the agent ID of this l f tincan lrs agent profile.
    *
    * @param agentId the agent ID of this l f tincan lrs agent profile
    */
    @Override
    public void setAgentId(java.lang.Integer agentId) {
        _lfTincanLrsAgentProfile.setAgentId(agentId);
    }

    /**
    * Returns the profile ID of this l f tincan lrs agent profile.
    *
    * @return the profile ID of this l f tincan lrs agent profile
    */
    @Override
    public java.lang.String getProfileId() {
        return _lfTincanLrsAgentProfile.getProfileId();
    }

    /**
    * Sets the profile ID of this l f tincan lrs agent profile.
    *
    * @param profileId the profile ID of this l f tincan lrs agent profile
    */
    @Override
    public void setProfileId(java.lang.String profileId) {
        _lfTincanLrsAgentProfile.setProfileId(profileId);
    }

    @Override
    public boolean isNew() {
        return _lfTincanLrsAgentProfile.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanLrsAgentProfile.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanLrsAgentProfile.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsAgentProfile.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanLrsAgentProfile.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsAgentProfile.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsAgentProfile.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsAgentProfile.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanLrsAgentProfile.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanLrsAgentProfile.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsAgentProfile.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsAgentProfileWrapper((LFTincanLrsAgentProfile) _lfTincanLrsAgentProfile.clone());
    }

    @Override
    public int compareTo(LFTincanLrsAgentProfile lfTincanLrsAgentProfile) {
        return _lfTincanLrsAgentProfile.compareTo(lfTincanLrsAgentProfile);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsAgentProfile.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanLrsAgentProfile> toCacheModel() {
        return _lfTincanLrsAgentProfile.toCacheModel();
    }

    @Override
    public LFTincanLrsAgentProfile toEscapedModel() {
        return new LFTincanLrsAgentProfileWrapper(_lfTincanLrsAgentProfile.toEscapedModel());
    }

    @Override
    public LFTincanLrsAgentProfile toUnescapedModel() {
        return new LFTincanLrsAgentProfileWrapper(_lfTincanLrsAgentProfile.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsAgentProfile.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanLrsAgentProfile.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsAgentProfile.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanLrsAgentProfileWrapper)) {
            return false;
        }

        LFTincanLrsAgentProfileWrapper lfTincanLrsAgentProfileWrapper = (LFTincanLrsAgentProfileWrapper) obj;

        if (Validator.equals(_lfTincanLrsAgentProfile,
                    lfTincanLrsAgentProfileWrapper._lfTincanLrsAgentProfile)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanLrsAgentProfile getWrappedLFTincanLrsAgentProfile() {
        return _lfTincanLrsAgentProfile;
    }

    @Override
    public LFTincanLrsAgentProfile getWrappedModel() {
        return _lfTincanLrsAgentProfile;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanLrsAgentProfile.resetOriginalValues();
    }
}
