package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsState}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsState
 * @generated
 */
public class LFTincanLrsStateWrapper implements LFTincanLrsState,
    ModelWrapper<LFTincanLrsState> {
    private LFTincanLrsState _lfTincanLrsState;

    public LFTincanLrsStateWrapper(LFTincanLrsState lfTincanLrsState) {
        _lfTincanLrsState = lfTincanLrsState;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsState.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsState.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("stateId", getStateId());
        attributes.put("documentId", getDocumentId());
        attributes.put("activityId", getActivityId());
        attributes.put("registration", getRegistration());
        attributes.put("agentId", getAgentId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String stateId = (String) attributes.get("stateId");

        if (stateId != null) {
            setStateId(stateId);
        }

        String documentId = (String) attributes.get("documentId");

        if (documentId != null) {
            setDocumentId(documentId);
        }

        String activityId = (String) attributes.get("activityId");

        if (activityId != null) {
            setActivityId(activityId);
        }

        String registration = (String) attributes.get("registration");

        if (registration != null) {
            setRegistration(registration);
        }

        Integer agentId = (Integer) attributes.get("agentId");

        if (agentId != null) {
            setAgentId(agentId);
        }
    }

    /**
    * Returns the primary key of this l f tincan lrs state.
    *
    * @return the primary key of this l f tincan lrs state
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanLrsState.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan lrs state.
    *
    * @param primaryKey the primary key of this l f tincan lrs state
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsState.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan lrs state.
    *
    * @return the ID of this l f tincan lrs state
    */
    @Override
    public long getId() {
        return _lfTincanLrsState.getId();
    }

    /**
    * Sets the ID of this l f tincan lrs state.
    *
    * @param id the ID of this l f tincan lrs state
    */
    @Override
    public void setId(long id) {
        _lfTincanLrsState.setId(id);
    }

    /**
    * Returns the state ID of this l f tincan lrs state.
    *
    * @return the state ID of this l f tincan lrs state
    */
    @Override
    public java.lang.String getStateId() {
        return _lfTincanLrsState.getStateId();
    }

    /**
    * Sets the state ID of this l f tincan lrs state.
    *
    * @param stateId the state ID of this l f tincan lrs state
    */
    @Override
    public void setStateId(java.lang.String stateId) {
        _lfTincanLrsState.setStateId(stateId);
    }

    /**
    * Returns the document ID of this l f tincan lrs state.
    *
    * @return the document ID of this l f tincan lrs state
    */
    @Override
    public java.lang.String getDocumentId() {
        return _lfTincanLrsState.getDocumentId();
    }

    /**
    * Sets the document ID of this l f tincan lrs state.
    *
    * @param documentId the document ID of this l f tincan lrs state
    */
    @Override
    public void setDocumentId(java.lang.String documentId) {
        _lfTincanLrsState.setDocumentId(documentId);
    }

    /**
    * Returns the activity ID of this l f tincan lrs state.
    *
    * @return the activity ID of this l f tincan lrs state
    */
    @Override
    public java.lang.String getActivityId() {
        return _lfTincanLrsState.getActivityId();
    }

    /**
    * Sets the activity ID of this l f tincan lrs state.
    *
    * @param activityId the activity ID of this l f tincan lrs state
    */
    @Override
    public void setActivityId(java.lang.String activityId) {
        _lfTincanLrsState.setActivityId(activityId);
    }

    /**
    * Returns the registration of this l f tincan lrs state.
    *
    * @return the registration of this l f tincan lrs state
    */
    @Override
    public java.lang.String getRegistration() {
        return _lfTincanLrsState.getRegistration();
    }

    /**
    * Sets the registration of this l f tincan lrs state.
    *
    * @param registration the registration of this l f tincan lrs state
    */
    @Override
    public void setRegistration(java.lang.String registration) {
        _lfTincanLrsState.setRegistration(registration);
    }

    /**
    * Returns the agent ID of this l f tincan lrs state.
    *
    * @return the agent ID of this l f tincan lrs state
    */
    @Override
    public java.lang.Integer getAgentId() {
        return _lfTincanLrsState.getAgentId();
    }

    /**
    * Sets the agent ID of this l f tincan lrs state.
    *
    * @param agentId the agent ID of this l f tincan lrs state
    */
    @Override
    public void setAgentId(java.lang.Integer agentId) {
        _lfTincanLrsState.setAgentId(agentId);
    }

    @Override
    public boolean isNew() {
        return _lfTincanLrsState.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanLrsState.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanLrsState.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsState.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanLrsState.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsState.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsState.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsState.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanLrsState.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanLrsState.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsState.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsStateWrapper((LFTincanLrsState) _lfTincanLrsState.clone());
    }

    @Override
    public int compareTo(LFTincanLrsState lfTincanLrsState) {
        return _lfTincanLrsState.compareTo(lfTincanLrsState);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsState.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanLrsState> toCacheModel() {
        return _lfTincanLrsState.toCacheModel();
    }

    @Override
    public LFTincanLrsState toEscapedModel() {
        return new LFTincanLrsStateWrapper(_lfTincanLrsState.toEscapedModel());
    }

    @Override
    public LFTincanLrsState toUnescapedModel() {
        return new LFTincanLrsStateWrapper(_lfTincanLrsState.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsState.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanLrsState.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsState.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanLrsStateWrapper)) {
            return false;
        }

        LFTincanLrsStateWrapper lfTincanLrsStateWrapper = (LFTincanLrsStateWrapper) obj;

        if (Validator.equals(_lfTincanLrsState,
                    lfTincanLrsStateWrapper._lfTincanLrsState)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanLrsState getWrappedLFTincanLrsState() {
        return _lfTincanLrsState;
    }

    @Override
    public LFTincanLrsState getWrappedModel() {
        return _lfTincanLrsState;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanLrsState.resetOriginalValues();
    }
}
