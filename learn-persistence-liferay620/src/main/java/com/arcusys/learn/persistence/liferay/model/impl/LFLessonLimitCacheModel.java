package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFLessonLimit;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFLessonLimit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFLessonLimit
 * @generated
 */
public class LFLessonLimitCacheModel implements CacheModel<LFLessonLimit>,
    Externalizable {
    public Long itemID;
    public String itemType;
    public Integer passingLimit;
    public Integer rerunInterval;
    public String rerunIntervalType;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{itemID=");
        sb.append(itemID);
        sb.append(", itemType=");
        sb.append(itemType);
        sb.append(", passingLimit=");
        sb.append(passingLimit);
        sb.append(", rerunInterval=");
        sb.append(rerunInterval);
        sb.append(", rerunIntervalType=");
        sb.append(rerunIntervalType);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFLessonLimit toEntityModel() {
        LFLessonLimitImpl lfLessonLimitImpl = new LFLessonLimitImpl();

        lfLessonLimitImpl.setItemID(itemID);

        if (itemType == null) {
            lfLessonLimitImpl.setItemType(StringPool.BLANK);
        } else {
            lfLessonLimitImpl.setItemType(itemType);
        }

        lfLessonLimitImpl.setPassingLimit(passingLimit);
        lfLessonLimitImpl.setRerunInterval(rerunInterval);

        if (rerunIntervalType == null) {
            lfLessonLimitImpl.setRerunIntervalType(StringPool.BLANK);
        } else {
            lfLessonLimitImpl.setRerunIntervalType(rerunIntervalType);
        }

        lfLessonLimitImpl.resetOriginalValues();

        return lfLessonLimitImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        itemID = objectInput.readLong();
        itemType = objectInput.readUTF();
        passingLimit = objectInput.readInt();
        rerunInterval = objectInput.readInt();
        rerunIntervalType = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(itemID);

        if (itemType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(itemType);
        }

        objectOutput.writeInt(passingLimit);
        objectOutput.writeInt(rerunInterval);

        if (rerunIntervalType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(rerunIntervalType);
        }
    }
}
