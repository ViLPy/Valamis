package com.arcusys.learn.persistence.liferay.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class LFCertificateActivityPK implements Comparable<LFCertificateActivityPK>,
    Serializable {
    public Long certificateID;
    public String activityName;

    public LFCertificateActivityPK() {
    }

    public LFCertificateActivityPK(Long certificateID, String activityName) {
        this.certificateID = certificateID;
        this.activityName = activityName;
    }

    public Long getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(Long certificateID) {
        this.certificateID = certificateID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public int compareTo(LFCertificateActivityPK pk) {
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

        value = activityName.compareTo(pk.activityName);

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

        if (!(obj instanceof LFCertificateActivityPK)) {
            return false;
        }

        LFCertificateActivityPK pk = (LFCertificateActivityPK) obj;

        if ((certificateID == pk.certificateID) &&
                (activityName.equals(pk.activityName))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(certificateID) + String.valueOf(activityName)).hashCode();
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
        sb.append("activityName");
        sb.append(StringPool.EQUAL);
        sb.append(activityName);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
