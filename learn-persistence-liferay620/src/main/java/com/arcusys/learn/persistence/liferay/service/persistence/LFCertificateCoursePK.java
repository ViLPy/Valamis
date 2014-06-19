package com.arcusys.learn.persistence.liferay.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class LFCertificateCoursePK implements Comparable<LFCertificateCoursePK>,
    Serializable {
    public Long certificateID;
    public Long courseID;

    public LFCertificateCoursePK() {
    }

    public LFCertificateCoursePK(Long certificateID, Long courseID) {
        this.certificateID = certificateID;
        this.courseID = courseID;
    }

    public Long getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(Long certificateID) {
        this.certificateID = certificateID;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    @Override
    public int compareTo(LFCertificateCoursePK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (certificateID < pk.certificateID) {
            value = -1;
        } else if (certificateID > pk.certificateID) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (courseID < pk.courseID) {
            value = -1;
        } else if (courseID > pk.courseID) {
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateCoursePK)) {
            return false;
        }

        LFCertificateCoursePK pk = (LFCertificateCoursePK) obj;

        if ((certificateID == pk.certificateID) && (courseID == pk.courseID)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(certificateID) + String.valueOf(courseID)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(10);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("certificateID");
        sb.append(StringPool.EQUAL);
        sb.append(certificateID);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("courseID");
        sb.append(StringPool.EQUAL);
        sb.append(courseID);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
