package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFTincanLrsContextActivities}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFTincanLrsContextActivities
* @generated
*/
public class LFTincanLrsContextActivitiesWrapper
    implements LFTincanLrsContextActivities,
        ModelWrapper<LFTincanLrsContextActivities> {
    private LFTincanLrsContextActivities _lfTincanLrsContextActivities;

    public LFTincanLrsContextActivitiesWrapper(
        LFTincanLrsContextActivities lfTincanLrsContextActivities) {
        _lfTincanLrsContextActivities = lfTincanLrsContextActivities;
    }

    public Class<?> getModelClass() {
        return LFTincanLrsContextActivities.class;
    }

    public String getModelClassName() {
        return LFTincanLrsContextActivities.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("parent", getParent());
        attributes.put("grouping", getGrouping());
        attributes.put("category", getCategory());
        attributes.put("other", getOther());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String parent = (String) attributes.get("parent");

        if (parent != null) {
            setParent(parent);
        }

        String grouping = (String) attributes.get("grouping");

        if (grouping != null) {
            setGrouping(grouping);
        }

        String category = (String) attributes.get("category");

        if (category != null) {
            setCategory(category);
        }

        String other = (String) attributes.get("other");

        if (other != null) {
            setOther(other);
        }
    }

    /**
     * Returns the primary key of this l f tincan lrs context activities.
     *
     * @return the primary key of this l f tincan lrs context activities
     */
    public long getPrimaryKey() {
        return _lfTincanLrsContextActivities.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f tincan lrs context activities.
     *
     * @param primaryKey the primary key of this l f tincan lrs context activities
     */
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsContextActivities.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f tincan lrs context activities.
     *
     * @return the ID of this l f tincan lrs context activities
     */
    public long getId() {
        return _lfTincanLrsContextActivities.getId();
    }

    /**
     * Sets the ID of this l f tincan lrs context activities.
     *
     * @param id the ID of this l f tincan lrs context activities
     */
    public void setId(long id) {
        _lfTincanLrsContextActivities.setId(id);
    }

    /**
     * Returns the parent of this l f tincan lrs context activities.
     *
     * @return the parent of this l f tincan lrs context activities
     */
    public java.lang.String getParent() {
        return _lfTincanLrsContextActivities.getParent();
    }

    /**
     * Sets the parent of this l f tincan lrs context activities.
     *
     * @param parent the parent of this l f tincan lrs context activities
     */
    public void setParent(java.lang.String parent) {
        _lfTincanLrsContextActivities.setParent(parent);
    }

    /**
     * Returns the grouping of this l f tincan lrs context activities.
     *
     * @return the grouping of this l f tincan lrs context activities
     */
    public java.lang.String getGrouping() {
        return _lfTincanLrsContextActivities.getGrouping();
    }

    /**
     * Sets the grouping of this l f tincan lrs context activities.
     *
     * @param grouping the grouping of this l f tincan lrs context activities
     */
    public void setGrouping(java.lang.String grouping) {
        _lfTincanLrsContextActivities.setGrouping(grouping);
    }

    /**
     * Returns the category of this l f tincan lrs context activities.
     *
     * @return the category of this l f tincan lrs context activities
     */
    public java.lang.String getCategory() {
        return _lfTincanLrsContextActivities.getCategory();
    }

    /**
     * Sets the category of this l f tincan lrs context activities.
     *
     * @param category the category of this l f tincan lrs context activities
     */
    public void setCategory(java.lang.String category) {
        _lfTincanLrsContextActivities.setCategory(category);
    }

    /**
     * Returns the other of this l f tincan lrs context activities.
     *
     * @return the other of this l f tincan lrs context activities
     */
    public java.lang.String getOther() {
        return _lfTincanLrsContextActivities.getOther();
    }

    /**
     * Sets the other of this l f tincan lrs context activities.
     *
     * @param other the other of this l f tincan lrs context activities
     */
    public void setOther(java.lang.String other) {
        _lfTincanLrsContextActivities.setOther(other);
    }

    public boolean isNew() {
        return _lfTincanLrsContextActivities.isNew();
    }

    public void setNew(boolean n) {
        _lfTincanLrsContextActivities.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfTincanLrsContextActivities.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsContextActivities.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfTincanLrsContextActivities.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsContextActivities.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsContextActivities.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsContextActivities.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsContextActivities.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsContextActivitiesWrapper((LFTincanLrsContextActivities) _lfTincanLrsContextActivities.clone());
    }

    public int compareTo(
        LFTincanLrsContextActivities lfTincanLrsContextActivities) {
        return _lfTincanLrsContextActivities.compareTo(lfTincanLrsContextActivities);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsContextActivities.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFTincanLrsContextActivities> toCacheModel() {
        return _lfTincanLrsContextActivities.toCacheModel();
    }

    public LFTincanLrsContextActivities toEscapedModel() {
        return new LFTincanLrsContextActivitiesWrapper(_lfTincanLrsContextActivities.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsContextActivities.toString();
    }

    public java.lang.String toXmlString() {
        return _lfTincanLrsContextActivities.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsContextActivities.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFTincanLrsContextActivities getWrappedLFTincanLrsContextActivities() {
        return _lfTincanLrsContextActivities;
    }

    public LFTincanLrsContextActivities getWrappedModel() {
        return _lfTincanLrsContextActivities;
    }

    public void resetOriginalValues() {
        _lfTincanLrsContextActivities.resetOriginalValues();
    }
}
