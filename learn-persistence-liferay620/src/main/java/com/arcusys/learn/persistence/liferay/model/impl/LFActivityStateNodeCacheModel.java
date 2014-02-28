package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivityStateNode;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFActivityStateNode in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateNode
 * @generated
 */
public class LFActivityStateNodeCacheModel implements CacheModel<LFActivityStateNode>,
    Externalizable {
    public long id;
    public Integer parentID;
    public Integer treeID;
    public String availableChildrenIDs;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", parentID=");
        sb.append(parentID);
        sb.append(", treeID=");
        sb.append(treeID);
        sb.append(", availableChildrenIDs=");
        sb.append(availableChildrenIDs);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFActivityStateNode toEntityModel() {
        LFActivityStateNodeImpl lfActivityStateNodeImpl = new LFActivityStateNodeImpl();

        lfActivityStateNodeImpl.setId(id);
        lfActivityStateNodeImpl.setParentID(parentID);
        lfActivityStateNodeImpl.setTreeID(treeID);

        if (availableChildrenIDs == null) {
            lfActivityStateNodeImpl.setAvailableChildrenIDs(StringPool.BLANK);
        } else {
            lfActivityStateNodeImpl.setAvailableChildrenIDs(availableChildrenIDs);
        }

        lfActivityStateNodeImpl.resetOriginalValues();

        return lfActivityStateNodeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        parentID = objectInput.readInt();
        treeID = objectInput.readInt();
        availableChildrenIDs = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(parentID);
        objectOutput.writeInt(treeID);

        if (availableChildrenIDs == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(availableChildrenIDs);
        }
    }
}
