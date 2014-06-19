package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFCertificateCourse}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateCourse
 * @generated
 */
public class LFCertificateCourseWrapper implements LFCertificateCourse,
    ModelWrapper<LFCertificateCourse> {
    private LFCertificateCourse _lfCertificateCourse;

    public LFCertificateCourseWrapper(LFCertificateCourse lfCertificateCourse) {
        _lfCertificateCourse = lfCertificateCourse;
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificateCourse.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificateCourse.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("certificateID", getCertificateID());
        attributes.put("courseID", getCourseID());
        attributes.put("arrangementIndex", getArrangementIndex());
        attributes.put("periodType", getPeriodType());
        attributes.put("period", getPeriod());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long certificateID = (Long) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        Long courseID = (Long) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
        }

        String periodType = (String) attributes.get("periodType");

        if (periodType != null) {
            setPeriodType(periodType);
        }

        Integer period = (Integer) attributes.get("period");

        if (period != null) {
            setPeriod(period);
        }
    }

    /**
    * Returns the primary key of this l f certificate course.
    *
    * @return the primary key of this l f certificate course
    */
    @Override
    public com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateCoursePK getPrimaryKey() {
        return _lfCertificateCourse.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f certificate course.
    *
    * @param primaryKey the primary key of this l f certificate course
    */
    @Override
    public void setPrimaryKey(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateCoursePK primaryKey) {
        _lfCertificateCourse.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the certificate i d of this l f certificate course.
    *
    * @return the certificate i d of this l f certificate course
    */
    @Override
    public java.lang.Long getCertificateID() {
        return _lfCertificateCourse.getCertificateID();
    }

    /**
    * Sets the certificate i d of this l f certificate course.
    *
    * @param certificateID the certificate i d of this l f certificate course
    */
    @Override
    public void setCertificateID(java.lang.Long certificateID) {
        _lfCertificateCourse.setCertificateID(certificateID);
    }

    /**
    * Returns the course i d of this l f certificate course.
    *
    * @return the course i d of this l f certificate course
    */
    @Override
    public java.lang.Long getCourseID() {
        return _lfCertificateCourse.getCourseID();
    }

    /**
    * Sets the course i d of this l f certificate course.
    *
    * @param courseID the course i d of this l f certificate course
    */
    @Override
    public void setCourseID(java.lang.Long courseID) {
        _lfCertificateCourse.setCourseID(courseID);
    }

    /**
    * Returns the arrangement index of this l f certificate course.
    *
    * @return the arrangement index of this l f certificate course
    */
    @Override
    public java.lang.Integer getArrangementIndex() {
        return _lfCertificateCourse.getArrangementIndex();
    }

    /**
    * Sets the arrangement index of this l f certificate course.
    *
    * @param arrangementIndex the arrangement index of this l f certificate course
    */
    @Override
    public void setArrangementIndex(java.lang.Integer arrangementIndex) {
        _lfCertificateCourse.setArrangementIndex(arrangementIndex);
    }

    /**
    * Returns the period type of this l f certificate course.
    *
    * @return the period type of this l f certificate course
    */
    @Override
    public java.lang.String getPeriodType() {
        return _lfCertificateCourse.getPeriodType();
    }

    /**
    * Sets the period type of this l f certificate course.
    *
    * @param periodType the period type of this l f certificate course
    */
    @Override
    public void setPeriodType(java.lang.String periodType) {
        _lfCertificateCourse.setPeriodType(periodType);
    }

    /**
    * Returns the period of this l f certificate course.
    *
    * @return the period of this l f certificate course
    */
    @Override
    public java.lang.Integer getPeriod() {
        return _lfCertificateCourse.getPeriod();
    }

    /**
    * Sets the period of this l f certificate course.
    *
    * @param period the period of this l f certificate course
    */
    @Override
    public void setPeriod(java.lang.Integer period) {
        _lfCertificateCourse.setPeriod(period);
    }

    @Override
    public boolean isNew() {
        return _lfCertificateCourse.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfCertificateCourse.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfCertificateCourse.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfCertificateCourse.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfCertificateCourse.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfCertificateCourse.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfCertificateCourse.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfCertificateCourse.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfCertificateCourse.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfCertificateCourse.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfCertificateCourse.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFCertificateCourseWrapper((LFCertificateCourse) _lfCertificateCourse.clone());
    }

    @Override
    public int compareTo(LFCertificateCourse lfCertificateCourse) {
        return _lfCertificateCourse.compareTo(lfCertificateCourse);
    }

    @Override
    public int hashCode() {
        return _lfCertificateCourse.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFCertificateCourse> toCacheModel() {
        return _lfCertificateCourse.toCacheModel();
    }

    @Override
    public LFCertificateCourse toEscapedModel() {
        return new LFCertificateCourseWrapper(_lfCertificateCourse.toEscapedModel());
    }

    @Override
    public LFCertificateCourse toUnescapedModel() {
        return new LFCertificateCourseWrapper(_lfCertificateCourse.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfCertificateCourse.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfCertificateCourse.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateCourse.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateCourseWrapper)) {
            return false;
        }

        LFCertificateCourseWrapper lfCertificateCourseWrapper = (LFCertificateCourseWrapper) obj;

        if (Validator.equals(_lfCertificateCourse,
                    lfCertificateCourseWrapper._lfCertificateCourse)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFCertificateCourse getWrappedLFCertificateCourse() {
        return _lfCertificateCourse;
    }

    @Override
    public LFCertificateCourse getWrappedModel() {
        return _lfCertificateCourse;
    }

    @Override
    public void resetOriginalValues() {
        _lfCertificateCourse.resetOriginalValues();
    }
}
