package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFCourse;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
* The cache model class for representing LFCourse in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFCourse
* @generated
*/
public class LFCourseCacheModel implements CacheModel<LFCourse>, Serializable {
    public long id;
    public Integer courseID;
    public Integer userID;
    public String grade;
    public String comment;
    public long date;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", courseID=");
        sb.append(courseID);
        sb.append(", userID=");
        sb.append(userID);
        sb.append(", grade=");
        sb.append(grade);
        sb.append(", comment=");
        sb.append(comment);
        sb.append(", date=");
        sb.append(date);
        sb.append("}");

        return sb.toString();
    }

    public LFCourse toEntityModel() {
        LFCourseImpl lfCourseImpl = new LFCourseImpl();

        lfCourseImpl.setId(id);
        lfCourseImpl.setCourseID(courseID);
        lfCourseImpl.setUserID(userID);

        if (grade == null) {
            lfCourseImpl.setGrade(StringPool.BLANK);
        } else {
            lfCourseImpl.setGrade(grade);
        }

        if (comment == null) {
            lfCourseImpl.setComment(StringPool.BLANK);
        } else {
            lfCourseImpl.setComment(comment);
        }

        if (date == Long.MIN_VALUE) {
            lfCourseImpl.setDate(null);
        } else {
            lfCourseImpl.setDate(new Date(date));
        }

        lfCourseImpl.resetOriginalValues();

        return lfCourseImpl;
    }
}
