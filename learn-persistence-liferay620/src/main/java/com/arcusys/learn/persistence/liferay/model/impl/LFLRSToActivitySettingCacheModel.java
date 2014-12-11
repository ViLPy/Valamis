package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFLRSToActivitySetting in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFLRSToActivitySetting
 * @generated
 */
public class LFLRSToActivitySettingCacheModel implements CacheModel<LFLRSToActivitySetting>,
    Externalizable {
    public long id;
    public Integer courseID;
    public String title;
    public String activityFilter;
    public String verbFilter;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", courseID=");
        sb.append(courseID);
        sb.append(", title=");
        sb.append(title);
        sb.append(", activityFilter=");
        sb.append(activityFilter);
        sb.append(", verbFilter=");
        sb.append(verbFilter);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFLRSToActivitySetting toEntityModel() {
        LFLRSToActivitySettingImpl lflrsToActivitySettingImpl = new LFLRSToActivitySettingImpl();

        lflrsToActivitySettingImpl.setId(id);
        lflrsToActivitySettingImpl.setCourseID(courseID);

        if (title == null) {
            lflrsToActivitySettingImpl.setTitle(StringPool.BLANK);
        } else {
            lflrsToActivitySettingImpl.setTitle(title);
        }

        if (activityFilter == null) {
            lflrsToActivitySettingImpl.setActivityFilter(StringPool.BLANK);
        } else {
            lflrsToActivitySettingImpl.setActivityFilter(activityFilter);
        }

        if (verbFilter == null) {
            lflrsToActivitySettingImpl.setVerbFilter(StringPool.BLANK);
        } else {
            lflrsToActivitySettingImpl.setVerbFilter(verbFilter);
        }

        lflrsToActivitySettingImpl.resetOriginalValues();

        return lflrsToActivitySettingImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        courseID = objectInput.readInt();
        title = objectInput.readUTF();
        activityFilter = objectInput.readUTF();
        verbFilter = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(courseID);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (activityFilter == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(activityFilter);
        }

        if (verbFilter == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(verbFilter);
        }
    }
}
