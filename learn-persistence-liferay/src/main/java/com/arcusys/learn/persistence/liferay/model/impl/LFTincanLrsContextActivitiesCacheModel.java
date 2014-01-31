package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanLrsContextActivities in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsContextActivities
 * @generated
 */
public class LFTincanLrsContextActivitiesCacheModel implements CacheModel<LFTincanLrsContextActivities>,
    Externalizable {
    public long id;
    public String parent;
    public String grouping;
    public String category;
    public String other;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", parent=");
        sb.append(parent);
        sb.append(", grouping=");
        sb.append(grouping);
        sb.append(", category=");
        sb.append(category);
        sb.append(", other=");
        sb.append(other);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanLrsContextActivities toEntityModel() {
        LFTincanLrsContextActivitiesImpl lfTincanLrsContextActivitiesImpl = new LFTincanLrsContextActivitiesImpl();

        lfTincanLrsContextActivitiesImpl.setId(id);

        if (parent == null) {
            lfTincanLrsContextActivitiesImpl.setParent(StringPool.BLANK);
        } else {
            lfTincanLrsContextActivitiesImpl.setParent(parent);
        }

        if (grouping == null) {
            lfTincanLrsContextActivitiesImpl.setGrouping(StringPool.BLANK);
        } else {
            lfTincanLrsContextActivitiesImpl.setGrouping(grouping);
        }

        if (category == null) {
            lfTincanLrsContextActivitiesImpl.setCategory(StringPool.BLANK);
        } else {
            lfTincanLrsContextActivitiesImpl.setCategory(category);
        }

        if (other == null) {
            lfTincanLrsContextActivitiesImpl.setOther(StringPool.BLANK);
        } else {
            lfTincanLrsContextActivitiesImpl.setOther(other);
        }

        lfTincanLrsContextActivitiesImpl.resetOriginalValues();

        return lfTincanLrsContextActivitiesImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        parent = objectInput.readUTF();
        grouping = objectInput.readUTF();
        category = objectInput.readUTF();
        other = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (parent == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(parent);
        }

        if (grouping == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(grouping);
        }

        if (category == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(category);
        }

        if (other == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(other);
        }
    }
}
