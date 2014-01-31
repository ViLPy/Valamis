package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFRequiredActivity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFRequiredActivity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFRequiredActivity
 * @generated
 */
public class LFRequiredActivityCacheModel implements CacheModel<LFRequiredActivity>,
    Externalizable {
    public long id;
    public Integer achievementId;
    public String activityClassName;
    public Integer numberActivitiesRequired;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", achievementId=");
        sb.append(achievementId);
        sb.append(", activityClassName=");
        sb.append(activityClassName);
        sb.append(", numberActivitiesRequired=");
        sb.append(numberActivitiesRequired);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFRequiredActivity toEntityModel() {
        LFRequiredActivityImpl lfRequiredActivityImpl = new LFRequiredActivityImpl();

        lfRequiredActivityImpl.setId(id);
        lfRequiredActivityImpl.setAchievementId(achievementId);

        if (activityClassName == null) {
            lfRequiredActivityImpl.setActivityClassName(StringPool.BLANK);
        } else {
            lfRequiredActivityImpl.setActivityClassName(activityClassName);
        }

        lfRequiredActivityImpl.setNumberActivitiesRequired(numberActivitiesRequired);

        lfRequiredActivityImpl.resetOriginalValues();

        return lfRequiredActivityImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        achievementId = objectInput.readInt();
        activityClassName = objectInput.readUTF();
        numberActivitiesRequired = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(achievementId);

        if (activityClassName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(activityClassName);
        }

        objectOutput.writeInt(numberActivitiesRequired);
    }
}
