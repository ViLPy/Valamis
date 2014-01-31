package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFChildrenSelection;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFChildrenSelection in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFChildrenSelection
 * @generated
 */
public class LFChildrenSelectionCacheModel implements CacheModel<LFChildrenSelection>,
    Externalizable {
    public long id;
    public Integer sequencingID;
    public Integer takeCount;
    public String takeTimingOnEachAttempt;
    public String reorderOnEachAttempt;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", sequencingID=");
        sb.append(sequencingID);
        sb.append(", takeCount=");
        sb.append(takeCount);
        sb.append(", takeTimingOnEachAttempt=");
        sb.append(takeTimingOnEachAttempt);
        sb.append(", reorderOnEachAttempt=");
        sb.append(reorderOnEachAttempt);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFChildrenSelection toEntityModel() {
        LFChildrenSelectionImpl lfChildrenSelectionImpl = new LFChildrenSelectionImpl();

        lfChildrenSelectionImpl.setId(id);
        lfChildrenSelectionImpl.setSequencingID(sequencingID);
        lfChildrenSelectionImpl.setTakeCount(takeCount);

        if (takeTimingOnEachAttempt == null) {
            lfChildrenSelectionImpl.setTakeTimingOnEachAttempt(StringPool.BLANK);
        } else {
            lfChildrenSelectionImpl.setTakeTimingOnEachAttempt(takeTimingOnEachAttempt);
        }

        if (reorderOnEachAttempt == null) {
            lfChildrenSelectionImpl.setReorderOnEachAttempt(StringPool.BLANK);
        } else {
            lfChildrenSelectionImpl.setReorderOnEachAttempt(reorderOnEachAttempt);
        }

        lfChildrenSelectionImpl.resetOriginalValues();

        return lfChildrenSelectionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        sequencingID = objectInput.readInt();
        takeCount = objectInput.readInt();
        takeTimingOnEachAttempt = objectInput.readUTF();
        reorderOnEachAttempt = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(sequencingID);
        objectOutput.writeInt(takeCount);

        if (takeTimingOnEachAttempt == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(takeTimingOnEachAttempt);
        }

        if (reorderOnEachAttempt == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(reorderOnEachAttempt);
        }
    }
}
