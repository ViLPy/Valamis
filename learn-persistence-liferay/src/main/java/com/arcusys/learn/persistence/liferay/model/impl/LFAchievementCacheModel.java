package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFAchievement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LFAchievement in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievement
 * @generated
 */
public class LFAchievementCacheModel implements CacheModel<LFAchievement>,
    Externalizable {
    public long id;
    public String title;
    public String description;
    public String logo;
    public long creationDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", logo=");
        sb.append(logo);
        sb.append(", creationDate=");
        sb.append(creationDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFAchievement toEntityModel() {
        LFAchievementImpl lfAchievementImpl = new LFAchievementImpl();

        lfAchievementImpl.setId(id);

        if (title == null) {
            lfAchievementImpl.setTitle(StringPool.BLANK);
        } else {
            lfAchievementImpl.setTitle(title);
        }

        if (description == null) {
            lfAchievementImpl.setDescription(StringPool.BLANK);
        } else {
            lfAchievementImpl.setDescription(description);
        }

        if (logo == null) {
            lfAchievementImpl.setLogo(StringPool.BLANK);
        } else {
            lfAchievementImpl.setLogo(logo);
        }

        if (creationDate == Long.MIN_VALUE) {
            lfAchievementImpl.setCreationDate(null);
        } else {
            lfAchievementImpl.setCreationDate(new Date(creationDate));
        }

        lfAchievementImpl.resetOriginalValues();

        return lfAchievementImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        logo = objectInput.readUTF();
        creationDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (logo == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(logo);
        }

        objectOutput.writeLong(creationDate);
    }
}
