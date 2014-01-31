package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFAchievementUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFAchievementUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementUser
 * @generated
 */
public class LFAchievementUserCacheModel implements CacheModel<LFAchievementUser>,
    Externalizable {
    public long id;
    public Integer userId;
    public Integer achievementId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(id);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", achievementId=");
        sb.append(achievementId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFAchievementUser toEntityModel() {
        LFAchievementUserImpl lfAchievementUserImpl = new LFAchievementUserImpl();

        lfAchievementUserImpl.setId(id);
        lfAchievementUserImpl.setUserId(userId);
        lfAchievementUserImpl.setAchievementId(achievementId);

        lfAchievementUserImpl.resetOriginalValues();

        return lfAchievementUserImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        userId = objectInput.readInt();
        achievementId = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(userId);
        objectOutput.writeInt(achievementId);
    }
}
