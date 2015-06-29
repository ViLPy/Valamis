package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSeqPermissions;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFSeqPermissions in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFSeqPermissions
 * @generated
 */
public class LFSeqPermissionsCacheModel implements CacheModel<LFSeqPermissions>,
    Externalizable {
    public long id;
    public Integer sequencingID;
    public boolean choiceForChildren;
    public boolean choiceForNonDescendants;
    public boolean flowForChildren;
    public boolean forwardOnlyForChildren;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", sequencingID=");
        sb.append(sequencingID);
        sb.append(", choiceForChildren=");
        sb.append(choiceForChildren);
        sb.append(", choiceForNonDescendants=");
        sb.append(choiceForNonDescendants);
        sb.append(", flowForChildren=");
        sb.append(flowForChildren);
        sb.append(", forwardOnlyForChildren=");
        sb.append(forwardOnlyForChildren);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFSeqPermissions toEntityModel() {
        LFSeqPermissionsImpl lfSeqPermissionsImpl = new LFSeqPermissionsImpl();

        lfSeqPermissionsImpl.setId(id);
        lfSeqPermissionsImpl.setSequencingID(sequencingID);
        lfSeqPermissionsImpl.setChoiceForChildren(choiceForChildren);
        lfSeqPermissionsImpl.setChoiceForNonDescendants(choiceForNonDescendants);
        lfSeqPermissionsImpl.setFlowForChildren(flowForChildren);
        lfSeqPermissionsImpl.setForwardOnlyForChildren(forwardOnlyForChildren);

        lfSeqPermissionsImpl.resetOriginalValues();

        return lfSeqPermissionsImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        sequencingID = objectInput.readInt();
        choiceForChildren = objectInput.readBoolean();
        choiceForNonDescendants = objectInput.readBoolean();
        flowForChildren = objectInput.readBoolean();
        forwardOnlyForChildren = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(sequencingID);
        objectOutput.writeBoolean(choiceForChildren);
        objectOutput.writeBoolean(choiceForNonDescendants);
        objectOutput.writeBoolean(flowForChildren);
        objectOutput.writeBoolean(forwardOnlyForChildren);
    }
}
