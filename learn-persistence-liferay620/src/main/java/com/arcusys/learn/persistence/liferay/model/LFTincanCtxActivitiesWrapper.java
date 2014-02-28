package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanCtxActivities}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanCtxActivities
 * @generated
 */
public class LFTincanCtxActivitiesWrapper implements LFTincanCtxActivities,
    ModelWrapper<LFTincanCtxActivities> {
    private LFTincanCtxActivities _lfTincanCtxActivities;

    public LFTincanCtxActivitiesWrapper(
        LFTincanCtxActivities lfTincanCtxActivities) {
        _lfTincanCtxActivities = lfTincanCtxActivities;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanCtxActivities.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanCtxActivities.class.getName();
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
    * Returns the primary key of this l f tincan ctx activities.
    *
    * @return the primary key of this l f tincan ctx activities
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanCtxActivities.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan ctx activities.
    *
    * @param primaryKey the primary key of this l f tincan ctx activities
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanCtxActivities.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan ctx activities.
    *
    * @return the ID of this l f tincan ctx activities
    */
    @Override
    public long getId() {
        return _lfTincanCtxActivities.getId();
    }

    /**
    * Sets the ID of this l f tincan ctx activities.
    *
    * @param id the ID of this l f tincan ctx activities
    */
    @Override
    public void setId(long id) {
        _lfTincanCtxActivities.setId(id);
    }

    /**
    * Returns the parent of this l f tincan ctx activities.
    *
    * @return the parent of this l f tincan ctx activities
    */
    @Override
    public java.lang.String getParent() {
        return _lfTincanCtxActivities.getParent();
    }

    /**
    * Sets the parent of this l f tincan ctx activities.
    *
    * @param parent the parent of this l f tincan ctx activities
    */
    @Override
    public void setParent(java.lang.String parent) {
        _lfTincanCtxActivities.setParent(parent);
    }

    /**
    * Returns the grouping of this l f tincan ctx activities.
    *
    * @return the grouping of this l f tincan ctx activities
    */
    @Override
    public java.lang.String getGrouping() {
        return _lfTincanCtxActivities.getGrouping();
    }

    /**
    * Sets the grouping of this l f tincan ctx activities.
    *
    * @param grouping the grouping of this l f tincan ctx activities
    */
    @Override
    public void setGrouping(java.lang.String grouping) {
        _lfTincanCtxActivities.setGrouping(grouping);
    }

    /**
    * Returns the category of this l f tincan ctx activities.
    *
    * @return the category of this l f tincan ctx activities
    */
    @Override
    public java.lang.String getCategory() {
        return _lfTincanCtxActivities.getCategory();
    }

    /**
    * Sets the category of this l f tincan ctx activities.
    *
    * @param category the category of this l f tincan ctx activities
    */
    @Override
    public void setCategory(java.lang.String category) {
        _lfTincanCtxActivities.setCategory(category);
    }

    /**
    * Returns the other of this l f tincan ctx activities.
    *
    * @return the other of this l f tincan ctx activities
    */
    @Override
    public java.lang.String getOther() {
        return _lfTincanCtxActivities.getOther();
    }

    /**
    * Sets the other of this l f tincan ctx activities.
    *
    * @param other the other of this l f tincan ctx activities
    */
    @Override
    public void setOther(java.lang.String other) {
        _lfTincanCtxActivities.setOther(other);
    }

    @Override
    public boolean isNew() {
        return _lfTincanCtxActivities.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanCtxActivities.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanCtxActivities.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanCtxActivities.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanCtxActivities.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanCtxActivities.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanCtxActivities.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanCtxActivities.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanCtxActivities.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanCtxActivities.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanCtxActivities.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanCtxActivitiesWrapper((LFTincanCtxActivities) _lfTincanCtxActivities.clone());
    }

    @Override
    public int compareTo(LFTincanCtxActivities lfTincanCtxActivities) {
        return _lfTincanCtxActivities.compareTo(lfTincanCtxActivities);
    }

    @Override
    public int hashCode() {
        return _lfTincanCtxActivities.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanCtxActivities> toCacheModel() {
        return _lfTincanCtxActivities.toCacheModel();
    }

    @Override
    public LFTincanCtxActivities toEscapedModel() {
        return new LFTincanCtxActivitiesWrapper(_lfTincanCtxActivities.toEscapedModel());
    }

    @Override
    public LFTincanCtxActivities toUnescapedModel() {
        return new LFTincanCtxActivitiesWrapper(_lfTincanCtxActivities.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanCtxActivities.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanCtxActivities.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanCtxActivities.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanCtxActivitiesWrapper)) {
            return false;
        }

        LFTincanCtxActivitiesWrapper lfTincanCtxActivitiesWrapper = (LFTincanCtxActivitiesWrapper) obj;

        if (Validator.equals(_lfTincanCtxActivities,
                    lfTincanCtxActivitiesWrapper._lfTincanCtxActivities)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanCtxActivities getWrappedLFTincanCtxActivities() {
        return _lfTincanCtxActivities;
    }

    @Override
    public LFTincanCtxActivities getWrappedModel() {
        return _lfTincanCtxActivities;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanCtxActivities.resetOriginalValues();
    }
}
