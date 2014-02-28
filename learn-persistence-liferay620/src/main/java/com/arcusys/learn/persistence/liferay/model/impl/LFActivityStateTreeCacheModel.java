package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivityStateTree;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFActivityStateTree in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateTree
 * @generated
 */
public class LFActivityStateTreeCacheModel implements CacheModel<LFActivityStateTree>,
    Externalizable {
    public long id;
    public String currentActivityID;
    public String suspendedActivityID;
    public Integer attemptID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", currentActivityID=");
        sb.append(currentActivityID);
        sb.append(", suspendedActivityID=");
        sb.append(suspendedActivityID);
        sb.append(", attemptID=");
        sb.append(attemptID);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFActivityStateTree toEntityModel() {
        LFActivityStateTreeImpl lfActivityStateTreeImpl = new LFActivityStateTreeImpl();

        lfActivityStateTreeImpl.setId(id);

        if (currentActivityID == null) {
            lfActivityStateTreeImpl.setCurrentActivityID(StringPool.BLANK);
        } else {
            lfActivityStateTreeImpl.setCurrentActivityID(currentActivityID);
        }

        if (suspendedActivityID == null) {
            lfActivityStateTreeImpl.setSuspendedActivityID(StringPool.BLANK);
        } else {
            lfActivityStateTreeImpl.setSuspendedActivityID(suspendedActivityID);
        }

        lfActivityStateTreeImpl.setAttemptID(attemptID);

        lfActivityStateTreeImpl.resetOriginalValues();

        return lfActivityStateTreeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        currentActivityID = objectInput.readUTF();
        suspendedActivityID = objectInput.readUTF();
        attemptID = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (currentActivityID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(currentActivityID);
        }

        if (suspendedActivityID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(suspendedActivityID);
        }

        objectOutput.writeInt(attemptID);
    }
}
