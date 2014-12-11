package com.arcusys.learn.persistence.liferay.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class LFLessonLimitPK implements Comparable<LFLessonLimitPK>,
    Serializable {
    public Long itemID;
    public String itemType;

    public LFLessonLimitPK() {
    }

    public LFLessonLimitPK(Long itemID, String itemType) {
        this.itemID = itemID;
        this.itemType = itemType;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public int compareTo(LFLessonLimitPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (itemID < pk.itemID) {
            value = -1;
        } else if (itemID > pk.itemID) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        value = itemType.compareTo(pk.itemType);

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

        if (!(obj instanceof LFLessonLimitPK)) {
            return false;
        }

        LFLessonLimitPK pk = (LFLessonLimitPK) obj;

        if ((itemID == pk.itemID) && (itemType.equals(pk.itemType))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(itemID) + String.valueOf(itemType)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(10);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("itemID");
        sb.append(StringPool.EQUAL);
        sb.append(itemID);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("itemType");
        sb.append(StringPool.EQUAL);
        sb.append(itemType);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
