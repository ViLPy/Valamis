package com.arcusys.learn.persistence.liferay.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class LFCoursePK implements Comparable<LFCoursePK>, Serializable {
    public Integer courseId;
    public Integer userID;

    public LFCoursePK() {
    }

    public LFCoursePK(Integer courseId, Integer userID) {
        this.courseId = courseId;
        this.userID = userID;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public int compareTo(LFCoursePK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (courseId < pk.courseId) {
            value = -1;
        } else if (courseId > pk.courseId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (userID < pk.userID) {
            value = -1;
        } else if (userID > pk.userID) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LFCoursePK pk = null;

        try {
            pk = (LFCoursePK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((courseId == pk.courseId) && (userID == pk.userID)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(courseId) + String.valueOf(userID)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(10);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("courseId");
        sb.append(StringPool.EQUAL);
        sb.append(courseId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("userID");
        sb.append(StringPool.EQUAL);
        sb.append(userID);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
