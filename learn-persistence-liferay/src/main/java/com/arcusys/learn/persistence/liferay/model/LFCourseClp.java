package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFCourseLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class LFCourseClp extends BaseModelImpl<LFCourse> implements LFCourse {
    private long _id;
    private Integer _courseID;
    private Integer _userID;
    private String _grade;
    private String _comment;
    private Date _date;
    private BaseModel<?> _lfCourseRemoteModel;

    public LFCourseClp() {
    }

    public Class<?> getModelClass() {
        return LFCourse.class;
    }

    public String getModelClassName() {
        return LFCourse.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getCourseID() {
        return _courseID;
    }

    public void setCourseID(Integer courseID) {
        _courseID = courseID;
    }

    public Integer getUserID() {
        return _userID;
    }

    public void setUserID(Integer userID) {
        _userID = userID;
    }

    public String getGrade() {
        return _grade;
    }

    public void setGrade(String grade) {
        _grade = grade;
    }

    public String getComment() {
        return _comment;
    }

    public void setComment(String comment) {
        _comment = comment;
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date date) {
        _date = date;
    }

    public BaseModel<?> getLFCourseRemoteModel() {
        return _lfCourseRemoteModel;
    }

    public void setLFCourseRemoteModel(BaseModel<?> lfCourseRemoteModel) {
        _lfCourseRemoteModel = lfCourseRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFCourseLocalServiceUtil.addLFCourse(this);
        } else {
            LFCourseLocalServiceUtil.updateLFCourse(this);
        }
    }

    @Override
    public LFCourse toEscapedModel() {
        return (LFCourse) Proxy.newProxyInstance(LFCourse.class.getClassLoader(),
            new Class[] { LFCourse.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFCourseClp clone = new LFCourseClp();

        clone.setId(getId());
        clone.setCourseID(getCourseID());
        clone.setUserID(getUserID());
        clone.setGrade(getGrade());
        clone.setComment(getComment());
        clone.setDate(getDate());

        return clone;
    }

    public int compareTo(LFCourse lfCourse) {
        long primaryKey = lfCourse.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LFCourseClp lfCourse = null;

        try {
            lfCourse = (LFCourseClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfCourse.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", courseID=");
        sb.append(getCourseID());
        sb.append(", userID=");
        sb.append(getUserID());
        sb.append(", grade=");
        sb.append(getGrade());
        sb.append(", comment=");
        sb.append(getComment());
        sb.append(", date=");
        sb.append(getDate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFCourse");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courseID</column-name><column-value><![CDATA[");
        sb.append(getCourseID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userID</column-name><column-value><![CDATA[");
        sb.append(getUserID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>grade</column-name><column-value><![CDATA[");
        sb.append(getGrade());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>comment</column-name><column-value><![CDATA[");
        sb.append(getComment());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>date</column-name><column-value><![CDATA[");
        sb.append(getDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
