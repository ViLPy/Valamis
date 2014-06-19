package com.arcusys.learn.persistence.liferay.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class LFCertificateTincanStatementPK implements Comparable<LFCertificateTincanStatementPK>,
    Serializable {
    public Long certificateID;
    public String verb;
    public String object;

    public LFCertificateTincanStatementPK() {
    }

    public LFCertificateTincanStatementPK(Long certificateID, String verb,
        String object) {
        this.certificateID = certificateID;
        this.verb = verb;
        this.object = object;
    }

    public Long getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(Long certificateID) {
        this.certificateID = certificateID;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @Override
    public int compareTo(LFCertificateTincanStatementPK pk) {
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

        value = verb.compareTo(pk.verb);

        if (value != 0) {
            return value;
        }

        value = object.compareTo(pk.object);

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

        if (!(obj instanceof LFCertificateTincanStatementPK)) {
            return false;
        }

        LFCertificateTincanStatementPK pk = (LFCertificateTincanStatementPK) obj;

        if ((certificateID == pk.certificateID) && (verb.equals(pk.verb)) &&
                (object.equals(pk.object))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(certificateID) + String.valueOf(verb) +
        String.valueOf(object)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("certificateID");
        sb.append(StringPool.EQUAL);
        sb.append(certificateID);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("verb");
        sb.append(StringPool.EQUAL);
        sb.append(verb);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("object");
        sb.append(StringPool.EQUAL);
        sb.append(object);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
