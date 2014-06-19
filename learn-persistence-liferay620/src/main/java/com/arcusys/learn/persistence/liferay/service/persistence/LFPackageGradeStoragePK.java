package com.arcusys.learn.persistence.liferay.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class LFPackageGradeStoragePK implements Comparable<LFPackageGradeStoragePK>,
    Serializable {
    public Long userId;
    public Long packageId;

    public LFPackageGradeStoragePK() {
    }

    public LFPackageGradeStoragePK(Long userId, Long packageId) {
        this.userId = userId;
        this.packageId = packageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    @Override
    public int compareTo(LFPackageGradeStoragePK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (userId < pk.userId) {
            value = -1;
        } else if (userId > pk.userId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (packageId < pk.packageId) {
            value = -1;
        } else if (packageId > pk.packageId) {
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

        if (!(obj instanceof LFPackageGradeStoragePK)) {
            return false;
        }

        LFPackageGradeStoragePK pk = (LFPackageGradeStoragePK) obj;

        if ((userId == pk.userId) && (packageId == pk.packageId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(userId) + String.valueOf(packageId)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(10);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("userId");
        sb.append(StringPool.EQUAL);
        sb.append(userId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("packageId");
        sb.append(StringPool.EQUAL);
        sb.append(packageId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
