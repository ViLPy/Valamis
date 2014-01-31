package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsContextActivities}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsContextActivities
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

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsContextActivities.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsContextActivities.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("parent", getParent());
        attributes.put("grouping", getGrouping());
        attributes.put("category", getCategory());
        attributes.put("other", getOther());

        return attributes;
    }

    @Override
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
    @Override
    public long getPrimaryKey() {
        return _lfTincanLrsContextActivities.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan lrs context activities.
    *
    * @param primaryKey the primary key of this l f tincan lrs context activities
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsContextActivities.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan lrs context activities.
    *
    * @return the ID of this l f tincan lrs context activities
    */
    @Override
    public long getId() {
        return _lfTincanLrsContextActivities.getId();
    }

    /**
    * Sets the ID of this l f tincan lrs context activities.
    *
    * @param id the ID of this l f tincan lrs context activities
    */
    @Override
    public void setId(long id) {
        _lfTincanLrsContextActivities.setId(id);
    }

    /**
    * Returns the parent of this l f tincan lrs context activities.
    *
    * @return the parent of this l f tincan lrs context activities
    */
    @Override
    public java.lang.String getParent() {
        return _lfTincanLrsContextActivities.getParent();
    }

    /**
    * Sets the parent of this l f tincan lrs context activities.
    *
    * @param parent the parent of this l f tincan lrs context activities
    */
    @Override
    public void setParent(java.lang.String parent) {
        _lfTincanLrsContextActivities.setParent(parent);
    }

    /**
    * Returns the grouping of this l f tincan lrs context activities.
    *
    * @return the grouping of this l f tincan lrs context activities
    */
    @Override
    public java.lang.String getGrouping() {
        return _lfTincanLrsContextActivities.getGrouping();
    }

    /**
    * Sets the grouping of this l f tincan lrs context activities.
    *
    * @param grouping the grouping of this l f tincan lrs context activities
    */
    @Override
    public void setGrouping(java.lang.String grouping) {
        _lfTincanLrsContextActivities.setGrouping(grouping);
    }

    /**
    * Returns the category of this l f tincan lrs context activities.
    *
    * @return the category of this l f tincan lrs context activities
    */
    @Override
    public java.lang.String getCategory() {
        return _lfTincanLrsContextActivities.getCategory();
    }

    /**
    * Sets the category of this l f tincan lrs context activities.
    *
    * @param category the category of this l f tincan lrs context activities
    */
    @Override
    public void setCategory(java.lang.String category) {
        _lfTincanLrsContextActivities.setCategory(category);
    }

    /**
    * Returns the other of this l f tincan lrs context activities.
    *
    * @return the other of this l f tincan lrs context activities
    */
    @Override
    public java.lang.String getOther() {
        return _lfTincanLrsContextActivities.getOther();
    }

    /**
    * Sets the other of this l f tincan lrs context activities.
    *
    * @param other the other of this l f tincan lrs context activities
    */
    @Override
    public void setOther(java.lang.String other) {
        _lfTincanLrsContextActivities.setOther(other);
    }

    @Override
    public boolean isNew() {
        return _lfTincanLrsContextActivities.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanLrsContextActivities.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanLrsContextActivities.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsContextActivities.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanLrsContextActivities.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsContextActivities.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsContextActivities.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsContextActivities.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanLrsContextActivities.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanLrsContextActivities.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsContextActivities.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsContextActivitiesWrapper((LFTincanLrsContextActivities) _lfTincanLrsContextActivities.clone());
    }

    @Override
    public int compareTo(
        LFTincanLrsContextActivities lfTincanLrsContextActivities) {
        return _lfTincanLrsContextActivities.compareTo(lfTincanLrsContextActivities);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsContextActivities.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanLrsContextActivities> toCacheModel() {
        return _lfTincanLrsContextActivities.toCacheModel();
    }

    @Override
    public LFTincanLrsContextActivities toEscapedModel() {
        return new LFTincanLrsContextActivitiesWrapper(_lfTincanLrsContextActivities.toEscapedModel());
    }

    @Override
    public LFTincanLrsContextActivities toUnescapedModel() {
        return new LFTincanLrsContextActivitiesWrapper(_lfTincanLrsContextActivities.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsContextActivities.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanLrsContextActivities.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsContextActivities.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanLrsContextActivitiesWrapper)) {
            return false;
        }

        LFTincanLrsContextActivitiesWrapper lfTincanLrsContextActivitiesWrapper = (LFTincanLrsContextActivitiesWrapper) obj;

        if (Validator.equals(_lfTincanLrsContextActivities,
                    lfTincanLrsContextActivitiesWrapper._lfTincanLrsContextActivities)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanLrsContextActivities getWrappedLFTincanLrsContextActivities() {
        return _lfTincanLrsContextActivities;
    }

    @Override
    public LFTincanLrsContextActivities getWrappedModel() {
        return _lfTincanLrsContextActivities;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanLrsContextActivities.resetOriginalValues();
    }
}
