package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFActivityStateNode}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFActivityStateNode
* @generated
*/
public class LFActivityStateNodeWrapper implements LFActivityStateNode,
    ModelWrapper<LFActivityStateNode> {
    private LFActivityStateNode _lfActivityStateNode;

    public LFActivityStateNodeWrapper(LFActivityStateNode lfActivityStateNode) {
        _lfActivityStateNode = lfActivityStateNode;
    }

    public Class<?> getModelClass() {
        return LFActivityStateNode.class;
    }

    public String getModelClassName() {
        return LFActivityStateNode.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("parentID", getParentID());
        attributes.put("treeID", getTreeID());
        attributes.put("availableChildrenIDs", getAvailableChildrenIDs());

        return attributes;
    }

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
    public long getPrimaryKey() {
        return _lfActivityStateNode.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f activity state node.
     *
     * @param primaryKey the primary key of this l f activity state node
     */
    public void setPrimaryKey(long primaryKey) {
        _lfActivityStateNode.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f activity state node.
     *
     * @return the ID of this l f activity state node
     */
    public long getId() {
        return _lfActivityStateNode.getId();
    }

    /**
     * Sets the ID of this l f activity state node.
     *
     * @param id the ID of this l f activity state node
     */
    public void setId(long id) {
        _lfActivityStateNode.setId(id);
    }

    /**
     * Returns the parent i d of this l f activity state node.
     *
     * @return the parent i d of this l f activity state node
     */
    public java.lang.Integer getParentID() {
        return _lfActivityStateNode.getParentID();
    }

    /**
     * Sets the parent i d of this l f activity state node.
     *
     * @param parentID the parent i d of this l f activity state node
     */
    public void setParentID(java.lang.Integer parentID) {
        _lfActivityStateNode.setParentID(parentID);
    }

    /**
     * Returns the tree i d of this l f activity state node.
     *
     * @return the tree i d of this l f activity state node
     */
    public java.lang.Integer getTreeID() {
        return _lfActivityStateNode.getTreeID();
    }

    /**
     * Sets the tree i d of this l f activity state node.
     *
     * @param treeID the tree i d of this l f activity state node
     */
    public void setTreeID(java.lang.Integer treeID) {
        _lfActivityStateNode.setTreeID(treeID);
    }

    /**
     * Returns the available children i ds of this l f activity state node.
     *
     * @return the available children i ds of this l f activity state node
     */
    public java.lang.String getAvailableChildrenIDs() {
        return _lfActivityStateNode.getAvailableChildrenIDs();
    }

    /**
     * Sets the available children i ds of this l f activity state node.
     *
     * @param availableChildrenIDs the available children i ds of this l f activity state node
     */
    public void setAvailableChildrenIDs(java.lang.String availableChildrenIDs) {
        _lfActivityStateNode.setAvailableChildrenIDs(availableChildrenIDs);
    }

    public boolean isNew() {
        return _lfActivityStateNode.isNew();
    }

    public void setNew(boolean n) {
        _lfActivityStateNode.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfActivityStateNode.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfActivityStateNode.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfActivityStateNode.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfActivityStateNode.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfActivityStateNode.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfActivityStateNode.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfActivityStateNode.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFActivityStateNodeWrapper((LFActivityStateNode) _lfActivityStateNode.clone());
    }

    public int compareTo(LFActivityStateNode lfActivityStateNode) {
        return _lfActivityStateNode.compareTo(lfActivityStateNode);
    }

    @Override
    public int hashCode() {
        return _lfActivityStateNode.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFActivityStateNode> toCacheModel() {
        return _lfActivityStateNode.toCacheModel();
    }

    public LFActivityStateNode toEscapedModel() {
        return new LFActivityStateNodeWrapper(_lfActivityStateNode.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfActivityStateNode.toString();
    }

    public java.lang.String toXmlString() {
        return _lfActivityStateNode.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityStateNode.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFActivityStateNode getWrappedLFActivityStateNode() {
        return _lfActivityStateNode;
    }

    public LFActivityStateNode getWrappedModel() {
        return _lfActivityStateNode;
    }

    public void resetOriginalValues() {
        _lfActivityStateNode.resetOriginalValues();
    }
}
