package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFLessonLimit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFLessonLimit
 * @generated
 */
public class LFLessonLimitWrapper implements LFLessonLimit,
    ModelWrapper<LFLessonLimit> {
    private LFLessonLimit _lfLessonLimit;

    public LFLessonLimitWrapper(LFLessonLimit lfLessonLimit) {
        _lfLessonLimit = lfLessonLimit;
    }

    @Override
    public Class<?> getModelClass() {
        return LFLessonLimit.class;
    }

    @Override
    public String getModelClassName() {
        return LFLessonLimit.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("itemID", getItemID());
        attributes.put("itemType", getItemType());
        attributes.put("passingLimit", getPassingLimit());
        attributes.put("rerunInterval", getRerunInterval());
        attributes.put("rerunIntervalType", getRerunIntervalType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long itemID = (Long) attributes.get("itemID");

        if (itemID != null) {
            setItemID(itemID);
        }

        String itemType = (String) attributes.get("itemType");

        if (itemType != null) {
            setItemType(itemType);
        }

        Integer passingLimit = (Integer) attributes.get("passingLimit");

        if (passingLimit != null) {
            setPassingLimit(passingLimit);
        }

        Integer rerunInterval = (Integer) attributes.get("rerunInterval");

        if (rerunInterval != null) {
            setRerunInterval(rerunInterval);
        }

        String rerunIntervalType = (String) attributes.get("rerunIntervalType");

        if (rerunIntervalType != null) {
            setRerunIntervalType(rerunIntervalType);
        }
    }

    /**
    * Returns the primary key of this l f lesson limit.
    *
    * @return the primary key of this l f lesson limit
    */
    @Override
    public com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK getPrimaryKey() {
        return _lfLessonLimit.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f lesson limit.
    *
    * @param primaryKey the primary key of this l f lesson limit
    */
    @Override
    public void setPrimaryKey(
        com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK primaryKey) {
        _lfLessonLimit.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the item i d of this l f lesson limit.
    *
    * @return the item i d of this l f lesson limit
    */
    @Override
    public java.lang.Long getItemID() {
        return _lfLessonLimit.getItemID();
    }

    /**
    * Sets the item i d of this l f lesson limit.
    *
    * @param itemID the item i d of this l f lesson limit
    */
    @Override
    public void setItemID(java.lang.Long itemID) {
        _lfLessonLimit.setItemID(itemID);
    }

    /**
    * Returns the item type of this l f lesson limit.
    *
    * @return the item type of this l f lesson limit
    */
    @Override
    public java.lang.String getItemType() {
        return _lfLessonLimit.getItemType();
    }

    /**
    * Sets the item type of this l f lesson limit.
    *
    * @param itemType the item type of this l f lesson limit
    */
    @Override
    public void setItemType(java.lang.String itemType) {
        _lfLessonLimit.setItemType(itemType);
    }

    /**
    * Returns the passing limit of this l f lesson limit.
    *
    * @return the passing limit of this l f lesson limit
    */
    @Override
    public java.lang.Integer getPassingLimit() {
        return _lfLessonLimit.getPassingLimit();
    }

    /**
    * Sets the passing limit of this l f lesson limit.
    *
    * @param passingLimit the passing limit of this l f lesson limit
    */
    @Override
    public void setPassingLimit(java.lang.Integer passingLimit) {
        _lfLessonLimit.setPassingLimit(passingLimit);
    }

    /**
    * Returns the rerun interval of this l f lesson limit.
    *
    * @return the rerun interval of this l f lesson limit
    */
    @Override
    public java.lang.Integer getRerunInterval() {
        return _lfLessonLimit.getRerunInterval();
    }

    /**
    * Sets the rerun interval of this l f lesson limit.
    *
    * @param rerunInterval the rerun interval of this l f lesson limit
    */
    @Override
    public void setRerunInterval(java.lang.Integer rerunInterval) {
        _lfLessonLimit.setRerunInterval(rerunInterval);
    }

    /**
    * Returns the rerun interval type of this l f lesson limit.
    *
    * @return the rerun interval type of this l f lesson limit
    */
    @Override
    public java.lang.String getRerunIntervalType() {
        return _lfLessonLimit.getRerunIntervalType();
    }

    /**
    * Sets the rerun interval type of this l f lesson limit.
    *
    * @param rerunIntervalType the rerun interval type of this l f lesson limit
    */
    @Override
    public void setRerunIntervalType(java.lang.String rerunIntervalType) {
        _lfLessonLimit.setRerunIntervalType(rerunIntervalType);
    }

    @Override
    public boolean isNew() {
        return _lfLessonLimit.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfLessonLimit.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfLessonLimit.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfLessonLimit.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfLessonLimit.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfLessonLimit.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfLessonLimit.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfLessonLimit.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfLessonLimit.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfLessonLimit.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfLessonLimit.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFLessonLimitWrapper((LFLessonLimit) _lfLessonLimit.clone());
    }

    @Override
    public int compareTo(LFLessonLimit lfLessonLimit) {
        return _lfLessonLimit.compareTo(lfLessonLimit);
    }

    @Override
    public int hashCode() {
        return _lfLessonLimit.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFLessonLimit> toCacheModel() {
        return _lfLessonLimit.toCacheModel();
    }

    @Override
    public LFLessonLimit toEscapedModel() {
        return new LFLessonLimitWrapper(_lfLessonLimit.toEscapedModel());
    }

    @Override
    public LFLessonLimit toUnescapedModel() {
        return new LFLessonLimitWrapper(_lfLessonLimit.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfLessonLimit.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfLessonLimit.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfLessonLimit.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFLessonLimitWrapper)) {
            return false;
        }

        LFLessonLimitWrapper lfLessonLimitWrapper = (LFLessonLimitWrapper) obj;

        if (Validator.equals(_lfLessonLimit, lfLessonLimitWrapper._lfLessonLimit)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFLessonLimit getWrappedLFLessonLimit() {
        return _lfLessonLimit;
    }

    @Override
    public LFLessonLimit getWrappedModel() {
        return _lfLessonLimit;
    }

    @Override
    public void resetOriginalValues() {
        _lfLessonLimit.resetOriginalValues();
    }
}
