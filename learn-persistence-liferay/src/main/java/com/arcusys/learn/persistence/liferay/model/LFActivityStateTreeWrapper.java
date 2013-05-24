package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFActivityStateTree}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFActivityStateTree
* @generated
*/
public class LFActivityStateTreeWrapper implements LFActivityStateTree,
    ModelWrapper<LFActivityStateTree> {
    private LFActivityStateTree _lfActivityStateTree;

    public LFActivityStateTreeWrapper(LFActivityStateTree lfActivityStateTree) {
        _lfActivityStateTree = lfActivityStateTree;
    }

    public Class<?> getModelClass() {
        return LFActivityStateTree.class;
    }

    public String getModelClassName() {
        return LFActivityStateTree.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("currentActivityID", getCurrentActivityID());
        attributes.put("suspendedActivityID", getSuspendedActivityID());
        attributes.put("attemptID", getAttemptID());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String currentActivityID = (String) attributes.get("currentActivityID");

        if (currentActivityID != null) {
            setCurrentActivityID(currentActivityID);
        }

        String suspendedActivityID = (String) attributes.get(
                "suspendedActivityID");

        if (suspendedActivityID != null) {
            setSuspendedActivityID(suspendedActivityID);
        }

        Integer attemptID = (Integer) attributes.get("attemptID");

        if (attemptID != null) {
            setAttemptID(attemptID);
        }
    }

    /**
     * Returns the primary key of this l f activity state tree.
     *
     * @return the primary key of this l f activity state tree
     */
    public long getPrimaryKey() {
        return _lfActivityStateTree.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f activity state tree.
     *
     * @param primaryKey the primary key of this l f activity state tree
     */
    public void setPrimaryKey(long primaryKey) {
        _lfActivityStateTree.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f activity state tree.
     *
     * @return the ID of this l f activity state tree
     */
    public long getId() {
        return _lfActivityStateTree.getId();
    }

    /**
     * Sets the ID of this l f activity state tree.
     *
     * @param id the ID of this l f activity state tree
     */
    public void setId(long id) {
        _lfActivityStateTree.setId(id);
    }

    /**
     * Returns the current activity i d of this l f activity state tree.
     *
     * @return the current activity i d of this l f activity state tree
     */
    public java.lang.String getCurrentActivityID() {
        return _lfActivityStateTree.getCurrentActivityID();
    }

    /**
     * Sets the current activity i d of this l f activity state tree.
     *
     * @param currentActivityID the current activity i d of this l f activity state tree
     */
    public void setCurrentActivityID(java.lang.String currentActivityID) {
        _lfActivityStateTree.setCurrentActivityID(currentActivityID);
    }

    /**
     * Returns the suspended activity i d of this l f activity state tree.
     *
     * @return the suspended activity i d of this l f activity state tree
     */
    public java.lang.String getSuspendedActivityID() {
        return _lfActivityStateTree.getSuspendedActivityID();
    }

    /**
     * Sets the suspended activity i d of this l f activity state tree.
     *
     * @param suspendedActivityID the suspended activity i d of this l f activity state tree
     */
    public void setSuspendedActivityID(java.lang.String suspendedActivityID) {
        _lfActivityStateTree.setSuspendedActivityID(suspendedActivityID);
    }

    /**
     * Returns the attempt i d of this l f activity state tree.
     *
     * @return the attempt i d of this l f activity state tree
     */
    public java.lang.Integer getAttemptID() {
        return _lfActivityStateTree.getAttemptID();
    }

    /**
     * Sets the attempt i d of this l f activity state tree.
     *
     * @param attemptID the attempt i d of this l f activity state tree
     */
    public void setAttemptID(java.lang.Integer attemptID) {
        _lfActivityStateTree.setAttemptID(attemptID);
    }

    public boolean isNew() {
        return _lfActivityStateTree.isNew();
    }

    public void setNew(boolean n) {
        _lfActivityStateTree.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfActivityStateTree.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfActivityStateTree.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfActivityStateTree.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfActivityStateTree.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfActivityStateTree.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfActivityStateTree.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfActivityStateTree.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFActivityStateTreeWrapper((LFActivityStateTree) _lfActivityStateTree.clone());
    }

    public int compareTo(LFActivityStateTree lfActivityStateTree) {
        return _lfActivityStateTree.compareTo(lfActivityStateTree);
    }

    @Override
    public int hashCode() {
        return _lfActivityStateTree.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFActivityStateTree> toCacheModel() {
        return _lfActivityStateTree.toCacheModel();
    }

    public LFActivityStateTree toEscapedModel() {
        return new LFActivityStateTreeWrapper(_lfActivityStateTree.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfActivityStateTree.toString();
    }

    public java.lang.String toXmlString() {
        return _lfActivityStateTree.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityStateTree.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFActivityStateTree getWrappedLFActivityStateTree() {
        return _lfActivityStateTree;
    }

    public LFActivityStateTree getWrappedModel() {
        return _lfActivityStateTree;
    }

    public void resetOriginalValues() {
        _lfActivityStateTree.resetOriginalValues();
    }
}
