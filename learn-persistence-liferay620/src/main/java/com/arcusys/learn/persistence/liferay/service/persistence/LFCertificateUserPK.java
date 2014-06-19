package com.arcusys.learn.persistence.liferay.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class LFCertificateUserPK implements Comparable<LFCertificateUserPK>,
    Serializable {
    public Long certificateID;
    public Long userID;

    public LFCertificateUserPK() {
    }

    public LFCertificateUserPK(Long certificateID, Long userID) {
        this.certificateID = certificateID;
        this.userID = userID;
    }

    public Long getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(Long certificateID) {
        this.certificateID = certificateID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public int compareTo(LFCertificateUserPK pk) {
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

        if (!(obj instanceof LFCertificateUserPK)) {
            return false;
        }

        LFCertificateUserPK pk = (LFCertificateUserPK) obj;

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
