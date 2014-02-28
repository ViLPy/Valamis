package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFSequencingPermissions}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingPermissions
 * @generated
 */
public class LFSequencingPermissionsWrapper implements LFSequencingPermissions,
    ModelWrapper<LFSequencingPermissions> {
    private LFSequencingPermissions _lfSequencingPermissions;

    public LFSequencingPermissionsWrapper(
        LFSequencingPermissions lfSequencingPermissions) {
        _lfSequencingPermissions = lfSequencingPermissions;
    }

    @Override
    public Class<?> getModelClass() {
        return LFSequencingPermissions.class;
    }

    @Override
    public String getModelClassName() {
        return LFSequencingPermissions.class.getName();
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
    * Returns the primary key of this l f sequencing permissions.
    *
    * @return the primary key of this l f sequencing permissions
    */
    @Override
    public long getPrimaryKey() {
        return _lfSequencingPermissions.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f sequencing permissions.
    *
    * @param primaryKey the primary key of this l f sequencing permissions
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfSequencingPermissions.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f sequencing permissions.
    *
    * @return the ID of this l f sequencing permissions
    */
    @Override
    public long getId() {
        return _lfSequencingPermissions.getId();
    }

    /**
    * Sets the ID of this l f sequencing permissions.
    *
    * @param id the ID of this l f sequencing permissions
    */
    @Override
    public void setId(long id) {
        _lfSequencingPermissions.setId(id);
    }

    /**
    * Returns the sequencing i d of this l f sequencing permissions.
    *
    * @return the sequencing i d of this l f sequencing permissions
    */
    @Override
    public java.lang.Integer getSequencingID() {
        return _lfSequencingPermissions.getSequencingID();
    }

    /**
    * Sets the sequencing i d of this l f sequencing permissions.
    *
    * @param sequencingID the sequencing i d of this l f sequencing permissions
    */
    @Override
    public void setSequencingID(java.lang.Integer sequencingID) {
        _lfSequencingPermissions.setSequencingID(sequencingID);
    }

    /**
    * Returns the choice for children of this l f sequencing permissions.
    *
    * @return the choice for children of this l f sequencing permissions
    */
    @Override
    public boolean getChoiceForChildren() {
        return _lfSequencingPermissions.getChoiceForChildren();
    }

    /**
    * Returns <code>true</code> if this l f sequencing permissions is choice for children.
    *
    * @return <code>true</code> if this l f sequencing permissions is choice for children; <code>false</code> otherwise
    */
    @Override
    public boolean isChoiceForChildren() {
        return _lfSequencingPermissions.isChoiceForChildren();
    }

    /**
    * Sets whether this l f sequencing permissions is choice for children.
    *
    * @param choiceForChildren the choice for children of this l f sequencing permissions
    */
    @Override
    public void setChoiceForChildren(boolean choiceForChildren) {
        _lfSequencingPermissions.setChoiceForChildren(choiceForChildren);
    }

    /**
    * Returns the choice for non descendants of this l f sequencing permissions.
    *
    * @return the choice for non descendants of this l f sequencing permissions
    */
    @Override
    public boolean getChoiceForNonDescendants() {
        return _lfSequencingPermissions.getChoiceForNonDescendants();
    }

    /**
    * Returns <code>true</code> if this l f sequencing permissions is choice for non descendants.
    *
    * @return <code>true</code> if this l f sequencing permissions is choice for non descendants; <code>false</code> otherwise
    */
    @Override
    public boolean isChoiceForNonDescendants() {
        return _lfSequencingPermissions.isChoiceForNonDescendants();
    }

    /**
    * Sets whether this l f sequencing permissions is choice for non descendants.
    *
    * @param choiceForNonDescendants the choice for non descendants of this l f sequencing permissions
    */
    @Override
    public void setChoiceForNonDescendants(boolean choiceForNonDescendants) {
        _lfSequencingPermissions.setChoiceForNonDescendants(choiceForNonDescendants);
    }

    /**
    * Returns the flow for children of this l f sequencing permissions.
    *
    * @return the flow for children of this l f sequencing permissions
    */
    @Override
    public boolean getFlowForChildren() {
        return _lfSequencingPermissions.getFlowForChildren();
    }

    /**
    * Returns <code>true</code> if this l f sequencing permissions is flow for children.
    *
    * @return <code>true</code> if this l f sequencing permissions is flow for children; <code>false</code> otherwise
    */
    @Override
    public boolean isFlowForChildren() {
        return _lfSequencingPermissions.isFlowForChildren();
    }

    /**
    * Sets whether this l f sequencing permissions is flow for children.
    *
    * @param flowForChildren the flow for children of this l f sequencing permissions
    */
    @Override
    public void setFlowForChildren(boolean flowForChildren) {
        _lfSequencingPermissions.setFlowForChildren(flowForChildren);
    }

    /**
    * Returns the forward only for children of this l f sequencing permissions.
    *
    * @return the forward only for children of this l f sequencing permissions
    */
    @Override
    public boolean getForwardOnlyForChildren() {
        return _lfSequencingPermissions.getForwardOnlyForChildren();
    }

    /**
    * Returns <code>true</code> if this l f sequencing permissions is forward only for children.
    *
    * @return <code>true</code> if this l f sequencing permissions is forward only for children; <code>false</code> otherwise
    */
    @Override
    public boolean isForwardOnlyForChildren() {
        return _lfSequencingPermissions.isForwardOnlyForChildren();
    }

    /**
    * Sets whether this l f sequencing permissions is forward only for children.
    *
    * @param forwardOnlyForChildren the forward only for children of this l f sequencing permissions
    */
    @Override
    public void setForwardOnlyForChildren(boolean forwardOnlyForChildren) {
        _lfSequencingPermissions.setForwardOnlyForChildren(forwardOnlyForChildren);
    }

    @Override
    public boolean isNew() {
        return _lfSequencingPermissions.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfSequencingPermissions.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfSequencingPermissions.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfSequencingPermissions.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfSequencingPermissions.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSequencingPermissions.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSequencingPermissions.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSequencingPermissions.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfSequencingPermissions.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfSequencingPermissions.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSequencingPermissions.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSequencingPermissionsWrapper((LFSequencingPermissions) _lfSequencingPermissions.clone());
    }

    @Override
    public int compareTo(LFSequencingPermissions lfSequencingPermissions) {
        return _lfSequencingPermissions.compareTo(lfSequencingPermissions);
    }

    @Override
    public int hashCode() {
        return _lfSequencingPermissions.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFSequencingPermissions> toCacheModel() {
        return _lfSequencingPermissions.toCacheModel();
    }

    @Override
    public LFSequencingPermissions toEscapedModel() {
        return new LFSequencingPermissionsWrapper(_lfSequencingPermissions.toEscapedModel());
    }

    @Override
    public LFSequencingPermissions toUnescapedModel() {
        return new LFSequencingPermissionsWrapper(_lfSequencingPermissions.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSequencingPermissions.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfSequencingPermissions.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSequencingPermissions.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFSequencingPermissionsWrapper)) {
            return false;
        }

        LFSequencingPermissionsWrapper lfSequencingPermissionsWrapper = (LFSequencingPermissionsWrapper) obj;

        if (Validator.equals(_lfSequencingPermissions,
                    lfSequencingPermissionsWrapper._lfSequencingPermissions)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFSequencingPermissions getWrappedLFSequencingPermissions() {
        return _lfSequencingPermissions;
    }

    @Override
    public LFSequencingPermissions getWrappedModel() {
        return _lfSequencingPermissions;
    }

    @Override
    public void resetOriginalValues() {
        _lfSequencingPermissions.resetOriginalValues();
    }
}
