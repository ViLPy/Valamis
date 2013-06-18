package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFSequencingPermissions}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFSequencingPermissions
* @generated
*/
public class LFSequencingPermissionsWrapper implements LFSequencingPermissions,
    ModelWrapper<LFSequencingPermissions> {
    private LFSequencingPermissions _lfSequencingPermissions;

    public LFSequencingPermissionsWrapper(
        LFSequencingPermissions lfSequencingPermissions) {
        _lfSequencingPermissions = lfSequencingPermissions;
    }

    public Class<?> getModelClass() {
        return LFSequencingPermissions.class;
    }

    public String getModelClassName() {
        return LFSequencingPermissions.class.getName();
    }

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
    public long getPrimaryKey() {
        return _lfSequencingPermissions.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f sequencing permissions.
     *
     * @param primaryKey the primary key of this l f sequencing permissions
     */
    public void setPrimaryKey(long primaryKey) {
        _lfSequencingPermissions.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f sequencing permissions.
     *
     * @return the ID of this l f sequencing permissions
     */
    public long getId() {
        return _lfSequencingPermissions.getId();
    }

    /**
     * Sets the ID of this l f sequencing permissions.
     *
     * @param id the ID of this l f sequencing permissions
     */
    public void setId(long id) {
        _lfSequencingPermissions.setId(id);
    }

    /**
     * Returns the sequencing i d of this l f sequencing permissions.
     *
     * @return the sequencing i d of this l f sequencing permissions
     */
    public java.lang.Integer getSequencingID() {
        return _lfSequencingPermissions.getSequencingID();
    }

    /**
     * Sets the sequencing i d of this l f sequencing permissions.
     *
     * @param sequencingID the sequencing i d of this l f sequencing permissions
     */
    public void setSequencingID(java.lang.Integer sequencingID) {
        _lfSequencingPermissions.setSequencingID(sequencingID);
    }

    /**
     * Returns the choice for children of this l f sequencing permissions.
     *
     * @return the choice for children of this l f sequencing permissions
     */
    public boolean getChoiceForChildren() {
        return _lfSequencingPermissions.getChoiceForChildren();
    }

    /**
     * Returns <code>true</code> if this l f sequencing permissions is choice for children.
     *
     * @return <code>true</code> if this l f sequencing permissions is choice for children; <code>false</code> otherwise
     */
    public boolean isChoiceForChildren() {
        return _lfSequencingPermissions.isChoiceForChildren();
    }

    /**
     * Sets whether this l f sequencing permissions is choice for children.
     *
     * @param choiceForChildren the choice for children of this l f sequencing permissions
     */
    public void setChoiceForChildren(boolean choiceForChildren) {
        _lfSequencingPermissions.setChoiceForChildren(choiceForChildren);
    }

    /**
     * Returns the choice for non descendants of this l f sequencing permissions.
     *
     * @return the choice for non descendants of this l f sequencing permissions
     */
    public boolean getChoiceForNonDescendants() {
        return _lfSequencingPermissions.getChoiceForNonDescendants();
    }

    /**
     * Returns <code>true</code> if this l f sequencing permissions is choice for non descendants.
     *
     * @return <code>true</code> if this l f sequencing permissions is choice for non descendants; <code>false</code> otherwise
     */
    public boolean isChoiceForNonDescendants() {
        return _lfSequencingPermissions.isChoiceForNonDescendants();
    }

    /**
     * Sets whether this l f sequencing permissions is choice for non descendants.
     *
     * @param choiceForNonDescendants the choice for non descendants of this l f sequencing permissions
     */
    public void setChoiceForNonDescendants(boolean choiceForNonDescendants) {
        _lfSequencingPermissions.setChoiceForNonDescendants(choiceForNonDescendants);
    }

    /**
     * Returns the flow for children of this l f sequencing permissions.
     *
     * @return the flow for children of this l f sequencing permissions
     */
    public boolean getFlowForChildren() {
        return _lfSequencingPermissions.getFlowForChildren();
    }

    /**
     * Returns <code>true</code> if this l f sequencing permissions is flow for children.
     *
     * @return <code>true</code> if this l f sequencing permissions is flow for children; <code>false</code> otherwise
     */
    public boolean isFlowForChildren() {
        return _lfSequencingPermissions.isFlowForChildren();
    }

    /**
     * Sets whether this l f sequencing permissions is flow for children.
     *
     * @param flowForChildren the flow for children of this l f sequencing permissions
     */
    public void setFlowForChildren(boolean flowForChildren) {
        _lfSequencingPermissions.setFlowForChildren(flowForChildren);
    }

    /**
     * Returns the forward only for children of this l f sequencing permissions.
     *
     * @return the forward only for children of this l f sequencing permissions
     */
    public boolean getForwardOnlyForChildren() {
        return _lfSequencingPermissions.getForwardOnlyForChildren();
    }

    /**
     * Returns <code>true</code> if this l f sequencing permissions is forward only for children.
     *
     * @return <code>true</code> if this l f sequencing permissions is forward only for children; <code>false</code> otherwise
     */
    public boolean isForwardOnlyForChildren() {
        return _lfSequencingPermissions.isForwardOnlyForChildren();
    }

    /**
     * Sets whether this l f sequencing permissions is forward only for children.
     *
     * @param forwardOnlyForChildren the forward only for children of this l f sequencing permissions
     */
    public void setForwardOnlyForChildren(boolean forwardOnlyForChildren) {
        _lfSequencingPermissions.setForwardOnlyForChildren(forwardOnlyForChildren);
    }

    public boolean isNew() {
        return _lfSequencingPermissions.isNew();
    }

    public void setNew(boolean n) {
        _lfSequencingPermissions.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfSequencingPermissions.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfSequencingPermissions.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfSequencingPermissions.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSequencingPermissions.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSequencingPermissions.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSequencingPermissions.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSequencingPermissions.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSequencingPermissionsWrapper((LFSequencingPermissions) _lfSequencingPermissions.clone());
    }

    public int compareTo(LFSequencingPermissions lfSequencingPermissions) {
        return _lfSequencingPermissions.compareTo(lfSequencingPermissions);
    }

    @Override
    public int hashCode() {
        return _lfSequencingPermissions.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFSequencingPermissions> toCacheModel() {
        return _lfSequencingPermissions.toCacheModel();
    }

    public LFSequencingPermissions toEscapedModel() {
        return new LFSequencingPermissionsWrapper(_lfSequencingPermissions.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSequencingPermissions.toString();
    }

    public java.lang.String toXmlString() {
        return _lfSequencingPermissions.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSequencingPermissions.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFSequencingPermissions getWrappedLFSequencingPermissions() {
        return _lfSequencingPermissions;
    }

    public LFSequencingPermissions getWrappedModel() {
        return _lfSequencingPermissions;
    }

    public void resetOriginalValues() {
        _lfSequencingPermissions.resetOriginalValues();
    }
}
