package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanPackage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanPackage
 * @generated
 */
public class LFTincanPackageWrapper implements LFTincanPackage,
    ModelWrapper<LFTincanPackage> {
    private LFTincanPackage _lfTincanPackage;

    public LFTincanPackageWrapper(LFTincanPackage lfTincanPackage) {
        _lfTincanPackage = lfTincanPackage;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanPackage.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanPackage.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("summary", getSummary());
        attributes.put("assetRefID", getAssetRefID());
        attributes.put("courseID", getCourseID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String summary = (String) attributes.get("summary");

        if (summary != null) {
            setSummary(summary);
        }

        Long assetRefID = (Long) attributes.get("assetRefID");

        if (assetRefID != null) {
            setAssetRefID(assetRefID);
        }

        Integer courseID = (Integer) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }
    }

    /**
    * Returns the primary key of this l f tincan package.
    *
    * @return the primary key of this l f tincan package
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanPackage.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan package.
    *
    * @param primaryKey the primary key of this l f tincan package
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanPackage.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan package.
    *
    * @return the ID of this l f tincan package
    */
    @Override
    public long getId() {
        return _lfTincanPackage.getId();
    }

    /**
    * Sets the ID of this l f tincan package.
    *
    * @param id the ID of this l f tincan package
    */
    @Override
    public void setId(long id) {
        _lfTincanPackage.setId(id);
    }

    /**
    * Returns the title of this l f tincan package.
    *
    * @return the title of this l f tincan package
    */
    @Override
    public java.lang.String getTitle() {
        return _lfTincanPackage.getTitle();
    }

    /**
    * Sets the title of this l f tincan package.
    *
    * @param title the title of this l f tincan package
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lfTincanPackage.setTitle(title);
    }

    /**
    * Returns the summary of this l f tincan package.
    *
    * @return the summary of this l f tincan package
    */
    @Override
    public java.lang.String getSummary() {
        return _lfTincanPackage.getSummary();
    }

    /**
    * Sets the summary of this l f tincan package.
    *
    * @param summary the summary of this l f tincan package
    */
    @Override
    public void setSummary(java.lang.String summary) {
        _lfTincanPackage.setSummary(summary);
    }

    /**
    * Returns the asset ref i d of this l f tincan package.
    *
    * @return the asset ref i d of this l f tincan package
    */
    @Override
    public java.lang.Long getAssetRefID() {
        return _lfTincanPackage.getAssetRefID();
    }

    /**
    * Sets the asset ref i d of this l f tincan package.
    *
    * @param assetRefID the asset ref i d of this l f tincan package
    */
    @Override
    public void setAssetRefID(java.lang.Long assetRefID) {
        _lfTincanPackage.setAssetRefID(assetRefID);
    }

    /**
    * Returns the course i d of this l f tincan package.
    *
    * @return the course i d of this l f tincan package
    */
    @Override
    public java.lang.Integer getCourseID() {
        return _lfTincanPackage.getCourseID();
    }

    /**
    * Sets the course i d of this l f tincan package.
    *
    * @param courseID the course i d of this l f tincan package
    */
    @Override
    public void setCourseID(java.lang.Integer courseID) {
        _lfTincanPackage.setCourseID(courseID);
    }

    @Override
    public boolean isNew() {
        return _lfTincanPackage.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanPackage.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanPackage.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanPackage.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanPackage.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanPackage.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanPackage.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanPackage.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanPackage.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanPackage.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanPackage.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanPackageWrapper((LFTincanPackage) _lfTincanPackage.clone());
    }

    @Override
    public int compareTo(LFTincanPackage lfTincanPackage) {
        return _lfTincanPackage.compareTo(lfTincanPackage);
    }

    @Override
    public int hashCode() {
        return _lfTincanPackage.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanPackage> toCacheModel() {
        return _lfTincanPackage.toCacheModel();
    }

    @Override
    public LFTincanPackage toEscapedModel() {
        return new LFTincanPackageWrapper(_lfTincanPackage.toEscapedModel());
    }

    @Override
    public LFTincanPackage toUnescapedModel() {
        return new LFTincanPackageWrapper(_lfTincanPackage.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanPackage.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanPackage.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanPackage.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanPackageWrapper)) {
            return false;
        }

        LFTincanPackageWrapper lfTincanPackageWrapper = (LFTincanPackageWrapper) obj;

        if (Validator.equals(_lfTincanPackage,
                    lfTincanPackageWrapper._lfTincanPackage)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanPackage getWrappedLFTincanPackage() {
        return _lfTincanPackage;
    }

    @Override
    public LFTincanPackage getWrappedModel() {
        return _lfTincanPackage;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanPackage.resetOriginalValues();
    }
}
