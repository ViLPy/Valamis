package com.arcusys.learn.persistence.liferay.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class LFCertificateToUserPK implements Comparable<LFCertificateToUserPK>,
    Serializable {
    public Integer certificateID;
    public Integer userID;

    public LFCertificateToUserPK() {
    }

    public LFCertificateToUserPK(Integer certificateID, Integer userID) {
        this.certificateID = certificateID;
        this.userID = userID;
    }

    public Integer getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(Integer certificateID) {
        this.certificateID = certificateID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public int compareTo(LFCertificateToUserPK pk) {
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateToUserPK)) {
            return false;
        }

        LFCertificateToUserPK pk = (LFCertificateToUserPK) obj;

        if ((certificateID == pk.certificateID) && (userID == pk.userID)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(certificateID) + String.valueOf(userID)).hashCode();
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
        sb.append("userID");
        sb.append(StringPool.EQUAL);
        sb.append(userID);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
