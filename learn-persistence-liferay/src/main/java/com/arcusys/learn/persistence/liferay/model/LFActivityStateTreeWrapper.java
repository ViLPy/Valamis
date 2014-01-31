package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFActivityStateTree}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateTree
 * @generated
 */
public class LFActivityStateTreeWrapper implements LFActivityStateTree,
    ModelWrapper<LFActivityStateTree> {
    private LFActivityStateTree _lfActivityStateTree;

    public LFActivityStateTreeWrapper(LFActivityStateTree lfActivityStateTree) {
        _lfActivityStateTree = lfActivityStateTree;
    }

    @Override
    public Class<?> getModelClass() {
        return LFActivityStateTree.class;
    }

    @Override
    public String getModelClassName() {
        return LFActivityStateTree.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("currentActivityID", getCurrentActivityID());
        attributes.put("suspendedActivityID", getSuspendedActivityID());
        attributes.put("attemptID", getAttemptID());

        return attributes;
    }

    @Override
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
    @Override
    public long getPrimaryKey() {
        return _lfActivityStateTree.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f activity state tree.
    *
    * @param primaryKey the primary key of this l f activity state tree
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfActivityStateTree.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f activity state tree.
    *
    * @return the ID of this l f activity state tree
    */
    @Override
    public long getId() {
        return _lfActivityStateTree.getId();
    }

    /**
    * Sets the ID of this l f activity state tree.
    *
    * @param id the ID of this l f activity state tree
    */
    @Override
    public void setId(long id) {
        _lfActivityStateTree.setId(id);
    }

    /**
    * Returns the current activity i d of this l f activity state tree.
    *
    * @return the current activity i d of this l f activity state tree
    */
    @Override
    public java.lang.String getCurrentActivityID() {
        return _lfActivityStateTree.getCurrentActivityID();
    }

    /**
    * Sets the current activity i d of this l f activity state tree.
    *
    * @param currentActivityID the current activity i d of this l f activity state tree
    */
    @Override
    public void setCurrentActivityID(java.lang.String currentActivityID) {
        _lfActivityStateTree.setCurrentActivityID(currentActivityID);
    }

    /**
    * Returns the suspended activity i d of this l f activity state tree.
    *
    * @return the suspended activity i d of this l f activity state tree
    */
    @Override
    public java.lang.String getSuspendedActivityID() {
        return _lfActivityStateTree.getSuspendedActivityID();
    }

    /**
    * Sets the suspended activity i d of this l f activity state tree.
    *
    * @param suspendedActivityID the suspended activity i d of this l f activity state tree
    */
    @Override
    public void setSuspendedActivityID(java.lang.String suspendedActivityID) {
        _lfActivityStateTree.setSuspendedActivityID(suspendedActivityID);
    }

    /**
    * Returns the attempt i d of this l f activity state tree.
    *
    * @return the attempt i d of this l f activity state tree
    */
    @Override
    public java.lang.Integer getAttemptID() {
        return _lfActivityStateTree.getAttemptID();
    }

    /**
    * Sets the attempt i d of this l f activity state tree.
    *
    * @param attemptID the attempt i d of this l f activity state tree
    */
    @Override
    public void setAttemptID(java.lang.Integer attemptID) {
        _lfActivityStateTree.setAttemptID(attemptID);
    }

    @Override
    public boolean isNew() {
        return _lfActivityStateTree.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfActivityStateTree.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfActivityStateTree.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfActivityStateTree.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfActivityStateTree.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfActivityStateTree.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfActivityStateTree.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfActivityStateTree.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfActivityStateTree.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfActivityStateTree.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfActivityStateTree.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFActivityStateTreeWrapper((LFActivityStateTree) _lfActivityStateTree.clone());
    }

    @Override
    public int compareTo(LFActivityStateTree lfActivityStateTree) {
        return _lfActivityStateTree.compareTo(lfActivityStateTree);
    }

    @Override
    public int hashCode() {
        return _lfActivityStateTree.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFActivityStateTree> toCacheModel() {
        return _lfActivityStateTree.toCacheModel();
    }

    @Override
    public LFActivityStateTree toEscapedModel() {
        return new LFActivityStateTreeWrapper(_lfActivityStateTree.toEscapedModel());
    }

    @Override
    public LFActivityStateTree toUnescapedModel() {
        return new LFActivityStateTreeWrapper(_lfActivityStateTree.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfActivityStateTree.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfActivityStateTree.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityStateTree.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFActivityStateTreeWrapper)) {
            return false;
        }

        LFActivityStateTreeWrapper lfActivityStateTreeWrapper = (LFActivityStateTreeWrapper) obj;

        if (Validator.equals(_lfActivityStateTree,
                    lfActivityStateTreeWrapper._lfActivityStateTree)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFActivityStateTree getWrappedLFActivityStateTree() {
        return _lfActivityStateTree;
    }

    @Override
    public LFActivityStateTree getWrappedModel() {
        return _lfActivityStateTree;
    }

    @Override
    public void resetOriginalValues() {
        _lfActivityStateTree.resetOriginalValues();
    }
}
