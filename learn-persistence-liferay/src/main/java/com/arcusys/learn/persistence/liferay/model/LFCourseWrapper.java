package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFCourse}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCourse
 * @generated
 */
public class LFCourseWrapper implements LFCourse, ModelWrapper<LFCourse> {
    private LFCourse _lfCourse;

    public LFCourseWrapper(LFCourse lfCourse) {
        _lfCourse = lfCourse;
    }

    @Override
    public Class<?> getModelClass() {
        return LFCourse.class;
    }

    @Override
    public String getModelClassName() {
        return LFCourse.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("courseID", getCourseID());
        attributes.put("userID", getUserID());
        attributes.put("grade", getGrade());
        attributes.put("comment", getComment());
        attributes.put("date", getDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer courseID = (Integer) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }

        Integer userID = (Integer) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
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
    * Returns the primary key of this l f course.
    *
    * @return the primary key of this l f course
    */
    @Override
    public long getPrimaryKey() {
        return _lfCourse.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f course.
    *
    * @param primaryKey the primary key of this l f course
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfCourse.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f course.
    *
    * @return the ID of this l f course
    */
    @Override
    public long getId() {
        return _lfCourse.getId();
    }

    /**
    * Sets the ID of this l f course.
    *
    * @param id the ID of this l f course
    */
    @Override
    public void setId(long id) {
        _lfCourse.setId(id);
    }

    /**
    * Returns the course i d of this l f course.
    *
    * @return the course i d of this l f course
    */
    @Override
    public java.lang.Integer getCourseID() {
        return _lfCourse.getCourseID();
    }

    /**
    * Sets the course i d of this l f course.
    *
    * @param courseID the course i d of this l f course
    */
    @Override
    public void setCourseID(java.lang.Integer courseID) {
        _lfCourse.setCourseID(courseID);
    }

    /**
    * Returns the user i d of this l f course.
    *
    * @return the user i d of this l f course
    */
    @Override
    public java.lang.Integer getUserID() {
        return _lfCourse.getUserID();
    }

    /**
    * Sets the user i d of this l f course.
    *
    * @param userID the user i d of this l f course
    */
    @Override
    public void setUserID(java.lang.Integer userID) {
        _lfCourse.setUserID(userID);
    }

    /**
    * Returns the grade of this l f course.
    *
    * @return the grade of this l f course
    */
    @Override
    public java.lang.String getGrade() {
        return _lfCourse.getGrade();
    }

    /**
    * Sets the grade of this l f course.
    *
    * @param grade the grade of this l f course
    */
    @Override
    public void setGrade(java.lang.String grade) {
        _lfCourse.setGrade(grade);
    }

    /**
    * Returns the comment of this l f course.
    *
    * @return the comment of this l f course
    */
    @Override
    public java.lang.String getComment() {
        return _lfCourse.getComment();
    }

    /**
    * Sets the comment of this l f course.
    *
    * @param comment the comment of this l f course
    */
    @Override
    public void setComment(java.lang.String comment) {
        _lfCourse.setComment(comment);
    }

    /**
    * Returns the date of this l f course.
    *
    * @return the date of this l f course
    */
    @Override
    public java.util.Date getDate() {
        return _lfCourse.getDate();
    }

    /**
    * Sets the date of this l f course.
    *
    * @param date the date of this l f course
    */
    @Override
    public void setDate(java.util.Date date) {
        _lfCourse.setDate(date);
    }

    @Override
    public boolean isNew() {
        return _lfCourse.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfCourse.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfCourse.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfCourse.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfCourse.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfCourse.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfCourse.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfCourse.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfCourse.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfCourse.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfCourse.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFCourseWrapper((LFCourse) _lfCourse.clone());
    }

    @Override
    public int compareTo(LFCourse lfCourse) {
        return _lfCourse.compareTo(lfCourse);
    }

    @Override
    public int hashCode() {
        return _lfCourse.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFCourse> toCacheModel() {
        return _lfCourse.toCacheModel();
    }

    @Override
    public LFCourse toEscapedModel() {
        return new LFCourseWrapper(_lfCourse.toEscapedModel());
    }

    @Override
    public LFCourse toUnescapedModel() {
        return new LFCourseWrapper(_lfCourse.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfCourse.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfCourse.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCourse.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCourseWrapper)) {
            return false;
        }

        LFCourseWrapper lfCourseWrapper = (LFCourseWrapper) obj;

        if (Validator.equals(_lfCourse, lfCourseWrapper._lfCourse)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFCourse getWrappedLFCourse() {
        return _lfCourse;
    }

    @Override
    public LFCourse getWrappedModel() {
        return _lfCourse;
    }

    @Override
    public void resetOriginalValues() {
        _lfCourse.resetOriginalValues();
    }
}
