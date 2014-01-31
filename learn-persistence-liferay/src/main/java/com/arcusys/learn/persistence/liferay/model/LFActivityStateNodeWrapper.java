package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFActivityStateNode}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateNode
 * @generated
 */
public class LFActivityStateNodeWrapper implements LFActivityStateNode,
    ModelWrapper<LFActivityStateNode> {
    private LFActivityStateNode _lfActivityStateNode;

    public LFActivityStateNodeWrapper(LFActivityStateNode lfActivityStateNode) {
        _lfActivityStateNode = lfActivityStateNode;
    }

    @Override
    public Class<?> getModelClass() {
        return LFActivityStateNode.class;
    }

    @Override
    public String getModelClassName() {
        return LFActivityStateNode.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("parentID", getParentID());
        attributes.put("treeID", getTreeID());
        attributes.put("availableChildrenIDs", getAvailableChildrenIDs());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer parentID = (Integer) attributes.get("parentID");

        if (parentID != null) {
            setParentID(parentID);
        }

        Integer treeID = (Integer) attributes.get("treeID");

        if (treeID != null) {
            setTreeID(treeID);
        }

        String availableChildrenIDs = (String) attributes.get(
                "availableChildrenIDs");

        if (availableChildrenIDs != null) {
            setAvailableChildrenIDs(availableChildrenIDs);
        }
    }

    /**
    * Returns the primary key of this l f activity state node.
    *
    * @return the primary key of this l f activity state node
    */
    @Override
    public long getPrimaryKey() {
        return _lfActivityStateNode.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f activity state node.
    *
    * @param primaryKey the primary key of this l f activity state node
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfActivityStateNode.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f activity state node.
    *
    * @return the ID of this l f activity state node
    */
    @Override
    public long getId() {
        return _lfActivityStateNode.getId();
    }

    /**
    * Sets the ID of this l f activity state node.
    *
    * @param id the ID of this l f activity state node
    */
    @Override
    public void setId(long id) {
        _lfActivityStateNode.setId(id);
    }

    /**
    * Returns the parent i d of this l f activity state node.
    *
    * @return the parent i d of this l f activity state node
    */
    @Override
    public java.lang.Integer getParentID() {
        return _lfActivityStateNode.getParentID();
    }

    /**
    * Sets the parent i d of this l f activity state node.
    *
    * @param parentID the parent i d of this l f activity state node
    */
    @Override
    public void setParentID(java.lang.Integer parentID) {
        _lfActivityStateNode.setParentID(parentID);
    }

    /**
    * Returns the tree i d of this l f activity state node.
    *
    * @return the tree i d of this l f activity state node
    */
    @Override
    public java.lang.Integer getTreeID() {
        return _lfActivityStateNode.getTreeID();
    }

    /**
    * Sets the tree i d of this l f activity state node.
    *
    * @param treeID the tree i d of this l f activity state node
    */
    @Override
    public void setTreeID(java.lang.Integer treeID) {
        _lfActivityStateNode.setTreeID(treeID);
    }

    /**
    * Returns the available children i ds of this l f activity state node.
    *
    * @return the available children i ds of this l f activity state node
    */
    @Override
    public java.lang.String getAvailableChildrenIDs() {
        return _lfActivityStateNode.getAvailableChildrenIDs();
    }

    /**
    * Sets the available children i ds of this l f activity state node.
    *
    * @param availableChildrenIDs the available children i ds of this l f activity state node
    */
    @Override
    public void setAvailableChildrenIDs(java.lang.String availableChildrenIDs) {
        _lfActivityStateNode.setAvailableChildrenIDs(availableChildrenIDs);
    }

    @Override
    public boolean isNew() {
        return _lfActivityStateNode.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfActivityStateNode.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfActivityStateNode.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfActivityStateNode.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfActivityStateNode.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfActivityStateNode.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfActivityStateNode.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfActivityStateNode.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfActivityStateNode.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfActivityStateNode.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfActivityStateNode.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFActivityStateNodeWrapper((LFActivityStateNode) _lfActivityStateNode.clone());
    }

    @Override
    public int compareTo(LFActivityStateNode lfActivityStateNode) {
        return _lfActivityStateNode.compareTo(lfActivityStateNode);
    }

    @Override
    public int hashCode() {
        return _lfActivityStateNode.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFActivityStateNode> toCacheModel() {
        return _lfActivityStateNode.toCacheModel();
    }

    @Override
    public LFActivityStateNode toEscapedModel() {
        return new LFActivityStateNodeWrapper(_lfActivityStateNode.toEscapedModel());
    }

    @Override
    public LFActivityStateNode toUnescapedModel() {
        return new LFActivityStateNodeWrapper(_lfActivityStateNode.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfActivityStateNode.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfActivityStateNode.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityStateNode.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFActivityStateNodeWrapper)) {
            return false;
        }

        LFActivityStateNodeWrapper lfActivityStateNodeWrapper = (LFActivityStateNodeWrapper) obj;

        if (Validator.equals(_lfActivityStateNode,
                    lfActivityStateNodeWrapper._lfActivityStateNode)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFActivityStateNode getWrappedLFActivityStateNode() {
        return _lfActivityStateNode;
    }

    @Override
    public LFActivityStateNode getWrappedModel() {
        return _lfActivityStateNode;
    }

    @Override
    public void resetOriginalValues() {
        _lfActivityStateNode.resetOriginalValues();
    }
}
