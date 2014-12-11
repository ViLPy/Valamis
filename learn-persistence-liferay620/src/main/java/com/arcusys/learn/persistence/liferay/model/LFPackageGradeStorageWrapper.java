package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFPackageGradeStorage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageGradeStorage
 * @generated
 */
public class LFPackageGradeStorageWrapper implements LFPackageGradeStorage,
    ModelWrapper<LFPackageGradeStorage> {
    private LFPackageGradeStorage _lfPackageGradeStorage;

    public LFPackageGradeStorageWrapper(
        LFPackageGradeStorage lfPackageGradeStorage) {
        _lfPackageGradeStorage = lfPackageGradeStorage;
    }

    @Override
    public Class<?> getModelClass() {
        return LFPackageGradeStorage.class;
    }

    @Override
    public String getModelClassName() {
        return LFPackageGradeStorage.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("userId", getUserId());
        attributes.put("packageId", getPackageId());
        attributes.put("grade", getGrade());
        attributes.put("comment", getComment());
        attributes.put("date", getDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Long packageId = (Long) attributes.get("packageId");

        if (packageId != null) {
            setPackageId(packageId);
        }

        String grade = (String) attributes.get("grade");

        if (grade != null) {
            setGrade(grade);
        }

        String comment = (String) attributes.get("comment");

        if (comment != null) {
            setComment(comment);
        }

        Date date = (Date) attributes.get("date");

        if (date != null) {
            setDate(date);
        }
    }

    /**
    * Returns the primary key of this l f package grade storage.
    *
    * @return the primary key of this l f package grade storage
    */
    @Override
    public com.arcusys.learn.persistence.liferay.service.persistence.LFPackageGradeStoragePK getPrimaryKey() {
        return _lfPackageGradeStorage.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f package grade storage.
    *
    * @param primaryKey the primary key of this l f package grade storage
    */
    @Override
    public void setPrimaryKey(
        com.arcusys.learn.persistence.liferay.service.persistence.LFPackageGradeStoragePK primaryKey) {
        _lfPackageGradeStorage.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the user ID of this l f package grade storage.
    *
    * @return the user ID of this l f package grade storage
    */
    @Override
    public java.lang.Long getUserId() {
        return _lfPackageGradeStorage.getUserId();
    }

    /**
    * Sets the user ID of this l f package grade storage.
    *
    * @param userId the user ID of this l f package grade storage
    */
    @Override
    public void setUserId(java.lang.Long userId) {
        _lfPackageGradeStorage.setUserId(userId);
    }

    /**
    * Returns the package ID of this l f package grade storage.
    *
    * @return the package ID of this l f package grade storage
    */
    @Override
    public java.lang.Long getPackageId() {
        return _lfPackageGradeStorage.getPackageId();
    }

    /**
    * Sets the package ID of this l f package grade storage.
    *
    * @param packageId the package ID of this l f package grade storage
    */
    @Override
    public void setPackageId(java.lang.Long packageId) {
        _lfPackageGradeStorage.setPackageId(packageId);
    }

    /**
    * Returns the grade of this l f package grade storage.
    *
    * @return the grade of this l f package grade storage
    */
    @Override
    public java.lang.String getGrade() {
        return _lfPackageGradeStorage.getGrade();
    }

    /**
    * Sets the grade of this l f package grade storage.
    *
    * @param grade the grade of this l f package grade storage
    */
    @Override
    public void setGrade(java.lang.String grade) {
        _lfPackageGradeStorage.setGrade(grade);
    }

    /**
    * Returns the comment of this l f package grade storage.
    *
    * @return the comment of this l f package grade storage
    */
    @Override
    public java.lang.String getComment() {
        return _lfPackageGradeStorage.getComment();
    }

    /**
    * Sets the comment of this l f package grade storage.
    *
    * @param comment the comment of this l f package grade storage
    */
    @Override
    public void setComment(java.lang.String comment) {
        _lfPackageGradeStorage.setComment(comment);
    }

    /**
    * Returns the date of this l f package grade storage.
    *
    * @return the date of this l f package grade storage
    */
    @Override
    public java.util.Date getDate() {
        return _lfPackageGradeStorage.getDate();
    }

    /**
    * Sets the date of this l f package grade storage.
    *
    * @param date the date of this l f package grade storage
    */
    @Override
    public void setDate(java.util.Date date) {
        _lfPackageGradeStorage.setDate(date);
    }

    @Override
    public boolean isNew() {
        return _lfPackageGradeStorage.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfPackageGradeStorage.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfPackageGradeStorage.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfPackageGradeStorage.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfPackageGradeStorage.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfPackageGradeStorage.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfPackageGradeStorage.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfPackageGradeStorage.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfPackageGradeStorage.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfPackageGradeStorage.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfPackageGradeStorage.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFPackageGradeStorageWrapper((LFPackageGradeStorage) _lfPackageGradeStorage.clone());
    }

    @Override
    public int compareTo(LFPackageGradeStorage lfPackageGradeStorage) {
        return _lfPackageGradeStorage.compareTo(lfPackageGradeStorage);
    }

    @Override
    public int hashCode() {
        return _lfPackageGradeStorage.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFPackageGradeStorage> toCacheModel() {
        return _lfPackageGradeStorage.toCacheModel();
    }

    @Override
    public LFPackageGradeStorage toEscapedModel() {
        return new LFPackageGradeStorageWrapper(_lfPackageGradeStorage.toEscapedModel());
    }

    @Override
    public LFPackageGradeStorage toUnescapedModel() {
        return new LFPackageGradeStorageWrapper(_lfPackageGradeStorage.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfPackageGradeStorage.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfPackageGradeStorage.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfPackageGradeStorage.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFPackageGradeStorageWrapper)) {
            return false;
        }

        LFPackageGradeStorageWrapper lfPackageGradeStorageWrapper = (LFPackageGradeStorageWrapper) obj;

        if (Validator.equals(_lfPackageGradeStorage,
                    lfPackageGradeStorageWrapper._lfPackageGradeStorage)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFPackageGradeStorage getWrappedLFPackageGradeStorage() {
        return _lfPackageGradeStorage;
    }

    @Override
    public LFPackageGradeStorage getWrappedModel() {
        return _lfPackageGradeStorage;
    }

    @Override
    public void resetOriginalValues() {
        _lfPackageGradeStorage.resetOriginalValues();
    }
}
