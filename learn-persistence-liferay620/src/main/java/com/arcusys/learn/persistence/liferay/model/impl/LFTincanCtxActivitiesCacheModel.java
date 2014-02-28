package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanCtxActivities in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanCtxActivities
 * @generated
 */
public class LFTincanCtxActivitiesCacheModel implements CacheModel<LFTincanCtxActivities>,
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
    public LFTincanCtxActivities toEntityModel() {
        LFTincanCtxActivitiesImpl lfTincanCtxActivitiesImpl = new LFTincanCtxActivitiesImpl();

        lfTincanCtxActivitiesImpl.setId(id);

        if (parent == null) {
            lfTincanCtxActivitiesImpl.setParent(StringPool.BLANK);
        } else {
            lfTincanCtxActivitiesImpl.setParent(parent);
        }

        if (grouping == null) {
            lfTincanCtxActivitiesImpl.setGrouping(StringPool.BLANK);
        } else {
            lfTincanCtxActivitiesImpl.setGrouping(grouping);
        }

        if (category == null) {
            lfTincanCtxActivitiesImpl.setCategory(StringPool.BLANK);
        } else {
            lfTincanCtxActivitiesImpl.setCategory(category);
        }

        if (other == null) {
            lfTincanCtxActivitiesImpl.setOther(StringPool.BLANK);
        } else {
            lfTincanCtxActivitiesImpl.setOther(other);
        }

        lfTincanCtxActivitiesImpl.resetOriginalValues();

        return lfTincanCtxActivitiesImpl;
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
