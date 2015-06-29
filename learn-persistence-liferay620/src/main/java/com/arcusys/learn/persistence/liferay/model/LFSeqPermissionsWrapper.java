package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFSeqPermissions}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSeqPermissions
 * @generated
 */
public class LFSeqPermissionsWrapper implements LFSeqPermissions,
    ModelWrapper<LFSeqPermissions> {
    private LFSeqPermissions _lfSeqPermissions;

    public LFSeqPermissionsWrapper(LFSeqPermissions lfSeqPermissions) {
        _lfSeqPermissions = lfSeqPermissions;
    }

    @Override
    public Class<?> getModelClass() {
        return LFSeqPermissions.class;
    }

    @Override
    public String getModelClassName() {
        return LFSeqPermissions.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("choiceForChildren", getChoiceForChildren());
        attributes.put("choiceForNonDescendants", getChoiceForNonDescendants());
        attributes.put("flowForChildren", getFlowForChildren());
        attributes.put("forwardOnlyForChildren", getForwardOnlyForChildren());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer sequencingID = (Integer) attributes.get("sequencingID");

        if (sequencingID != null) {
            setSequencingID(sequencingID);
        }

        Boolean choiceForChildren = (Boolean) attributes.get(
                "choiceForChildren");

        if (choiceForChildren != null) {
            setChoiceForChildren(choiceForChildren);
        }

        Boolean choiceForNonDescendants = (Boolean) attributes.get(
                "choiceForNonDescendants");

        if (choiceForNonDescendants != null) {
            setChoiceForNonDescendants(choiceForNonDescendants);
        }

        Boolean flowForChildren = (Boolean) attributes.get("flowForChildren");

        if (flowForChildren != null) {
            setFlowForChildren(flowForChildren);
        }

        Boolean forwardOnlyForChildren = (Boolean) attributes.get(
                "forwardOnlyForChildren");

        if (forwardOnlyForChildren != null) {
            setForwardOnlyForChildren(forwardOnlyForChildren);
        }
    }

    /**
    * Returns the primary key of this l f seq permissions.
    *
    * @return the primary key of this l f seq permissions
    */
    @Override
    public long getPrimaryKey() {
        return _lfSeqPermissions.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f seq permissions.
    *
    * @param primaryKey the primary key of this l f seq permissions
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfSeqPermissions.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f seq permissions.
    *
    * @return the ID of this l f seq permissions
    */
    @Override
    public long getId() {
        return _lfSeqPermissions.getId();
    }

    /**
    * Sets the ID of this l f seq permissions.
    *
    * @param id the ID of this l f seq permissions
    */
    @Override
    public void setId(long id) {
        _lfSeqPermissions.setId(id);
    }

    /**
    * Returns the sequencing i d of this l f seq permissions.
    *
    * @return the sequencing i d of this l f seq permissions
    */
    @Override
    public java.lang.Integer getSequencingID() {
        return _lfSeqPermissions.getSequencingID();
    }

    /**
    * Sets the sequencing i d of this l f seq permissions.
    *
    * @param sequencingID the sequencing i d of this l f seq permissions
    */
    @Override
    public void setSequencingID(java.lang.Integer sequencingID) {
        _lfSeqPermissions.setSequencingID(sequencingID);
    }

    /**
    * Returns the choice for children of this l f seq permissions.
    *
    * @return the choice for children of this l f seq permissions
    */
    @Override
    public boolean getChoiceForChildren() {
        return _lfSeqPermissions.getChoiceForChildren();
    }

    /**
    * Returns <code>true</code> if this l f seq permissions is choice for children.
    *
    * @return <code>true</code> if this l f seq permissions is choice for children; <code>false</code> otherwise
    */
    @Override
    public boolean isChoiceForChildren() {
        return _lfSeqPermissions.isChoiceForChildren();
    }

    /**
    * Sets whether this l f seq permissions is choice for children.
    *
    * @param choiceForChildren the choice for children of this l f seq permissions
    */
    @Override
    public void setChoiceForChildren(boolean choiceForChildren) {
        _lfSeqPermissions.setChoiceForChildren(choiceForChildren);
    }

    /**
    * Returns the choice for non descendants of this l f seq permissions.
    *
    * @return the choice for non descendants of this l f seq permissions
    */
    @Override
    public boolean getChoiceForNonDescendants() {
        return _lfSeqPermissions.getChoiceForNonDescendants();
    }

    /**
    * Returns <code>true</code> if this l f seq permissions is choice for non descendants.
    *
    * @return <code>true</code> if this l f seq permissions is choice for non descendants; <code>false</code> otherwise
    */
    @Override
    public boolean isChoiceForNonDescendants() {
        return _lfSeqPermissions.isChoiceForNonDescendants();
    }

    /**
    * Sets whether this l f seq permissions is choice for non descendants.
    *
    * @param choiceForNonDescendants the choice for non descendants of this l f seq permissions
    */
    @Override
    public void setChoiceForNonDescendants(boolean choiceForNonDescendants) {
        _lfSeqPermissions.setChoiceForNonDescendants(choiceForNonDescendants);
    }

    /**
    * Returns the flow for children of this l f seq permissions.
    *
    * @return the flow for children of this l f seq permissions
    */
    @Override
    public boolean getFlowForChildren() {
        return _lfSeqPermissions.getFlowForChildren();
    }

    /**
    * Returns <code>true</code> if this l f seq permissions is flow for children.
    *
    * @return <code>true</code> if this l f seq permissions is flow for children; <code>false</code> otherwise
    */
    @Override
    public boolean isFlowForChildren() {
        return _lfSeqPermissions.isFlowForChildren();
    }

    /**
    * Sets whether this l f seq permissions is flow for children.
    *
    * @param flowForChildren the flow for children of this l f seq permissions
    */
    @Override
    public void setFlowForChildren(boolean flowForChildren) {
        _lfSeqPermissions.setFlowForChildren(flowForChildren);
    }

    /**
    * Returns the forward only for children of this l f seq permissions.
    *
    * @return the forward only for children of this l f seq permissions
    */
    @Override
    public boolean getForwardOnlyForChildren() {
        return _lfSeqPermissions.getForwardOnlyForChildren();
    }

    /**
    * Returns <code>true</code> if this l f seq permissions is forward only for children.
    *
    * @return <code>true</code> if this l f seq permissions is forward only for children; <code>false</code> otherwise
    */
    @Override
    public boolean isForwardOnlyForChildren() {
        return _lfSeqPermissions.isForwardOnlyForChildren();
    }

    /**
    * Sets whether this l f seq permissions is forward only for children.
    *
    * @param forwardOnlyForChildren the forward only for children of this l f seq permissions
    */
    @Override
    public void setForwardOnlyForChildren(boolean forwardOnlyForChildren) {
        _lfSeqPermissions.setForwardOnlyForChildren(forwardOnlyForChildren);
    }

    @Override
    public boolean isNew() {
        return _lfSeqPermissions.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfSeqPermissions.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfSeqPermissions.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfSeqPermissions.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfSeqPermissions.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSeqPermissions.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSeqPermissions.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSeqPermissions.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfSeqPermissions.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfSeqPermissions.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSeqPermissions.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSeqPermissionsWrapper((LFSeqPermissions) _lfSeqPermissions.clone());
    }

    @Override
    public int compareTo(LFSeqPermissions lfSeqPermissions) {
        return _lfSeqPermissions.compareTo(lfSeqPermissions);
    }

    @Override
    public int hashCode() {
        return _lfSeqPermissions.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFSeqPermissions> toCacheModel() {
        return _lfSeqPermissions.toCacheModel();
    }

    @Override
    public LFSeqPermissions toEscapedModel() {
        return new LFSeqPermissionsWrapper(_lfSeqPermissions.toEscapedModel());
    }

    @Override
    public LFSeqPermissions toUnescapedModel() {
        return new LFSeqPermissionsWrapper(_lfSeqPermissions.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSeqPermissions.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfSeqPermissions.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSeqPermissions.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFSeqPermissionsWrapper)) {
            return false;
        }

        LFSeqPermissionsWrapper lfSeqPermissionsWrapper = (LFSeqPermissionsWrapper) obj;

        if (Validator.equals(_lfSeqPermissions,
                    lfSeqPermissionsWrapper._lfSeqPermissions)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFSeqPermissions getWrappedLFSeqPermissions() {
        return _lfSeqPermissions;
    }

    @Override
    public LFSeqPermissions getWrappedModel() {
        return _lfSeqPermissions;
    }

    @Override
    public void resetOriginalValues() {
        _lfSeqPermissions.resetOriginalValues();
    }
}
