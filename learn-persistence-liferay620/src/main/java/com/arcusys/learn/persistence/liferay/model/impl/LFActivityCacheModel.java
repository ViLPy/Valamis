package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFActivity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFActivity
 * @generated
 */
public class LFActivityCacheModel implements CacheModel<LFActivity>,
    Externalizable {
    public long indexNumber;
    public String id;
    public Integer packageID;
    public String organizationID;
    public String parentID;
    public String title;
    public String identifierRef;
    public String resourceParameters;
    public String hideLMSUI;
    public boolean visible;
    public boolean objectivesGlobalToSystem;
    public boolean sharedDataGlobalToSystem;
    public String masteryScore;
    public String maxTimeAllowed;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{indexNumber=");
        sb.append(indexNumber);
        sb.append(", id=");
        sb.append(id);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", organizationID=");
        sb.append(organizationID);
        sb.append(", parentID=");
        sb.append(parentID);
        sb.append(", title=");
        sb.append(title);
        sb.append(", identifierRef=");
        sb.append(identifierRef);
        sb.append(", resourceParameters=");
        sb.append(resourceParameters);
        sb.append(", hideLMSUI=");
        sb.append(hideLMSUI);
        sb.append(", visible=");
        sb.append(visible);
        sb.append(", objectivesGlobalToSystem=");
        sb.append(objectivesGlobalToSystem);
        sb.append(", sharedDataGlobalToSystem=");
        sb.append(sharedDataGlobalToSystem);
        sb.append(", masteryScore=");
        sb.append(masteryScore);
        sb.append(", maxTimeAllowed=");
        sb.append(maxTimeAllowed);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFActivity toEntityModel() {
        LFActivityImpl lfActivityImpl = new LFActivityImpl();

        lfActivityImpl.setIndexNumber(indexNumber);

        if (id == null) {
            lfActivityImpl.setId(StringPool.BLANK);
        } else {
            lfActivityImpl.setId(id);
        }

        lfActivityImpl.setPackageID(packageID);

        if (organizationID == null) {
            lfActivityImpl.setOrganizationID(StringPool.BLANK);
        } else {
            lfActivityImpl.setOrganizationID(organizationID);
        }

        if (parentID == null) {
            lfActivityImpl.setParentID(StringPool.BLANK);
        } else {
            lfActivityImpl.setParentID(parentID);
        }

        if (title == null) {
            lfActivityImpl.setTitle(StringPool.BLANK);
        } else {
            lfActivityImpl.setTitle(title);
        }

        if (identifierRef == null) {
            lfActivityImpl.setIdentifierRef(StringPool.BLANK);
        } else {
            lfActivityImpl.setIdentifierRef(identifierRef);
        }

        if (resourceParameters == null) {
            lfActivityImpl.setResourceParameters(StringPool.BLANK);
        } else {
            lfActivityImpl.setResourceParameters(resourceParameters);
        }

        if (hideLMSUI == null) {
            lfActivityImpl.setHideLMSUI(StringPool.BLANK);
        } else {
            lfActivityImpl.setHideLMSUI(hideLMSUI);
        }

        lfActivityImpl.setVisible(visible);
        lfActivityImpl.setObjectivesGlobalToSystem(objectivesGlobalToSystem);
        lfActivityImpl.setSharedDataGlobalToSystem(sharedDataGlobalToSystem);

        if (masteryScore == null) {
            lfActivityImpl.setMasteryScore(StringPool.BLANK);
        } else {
            lfActivityImpl.setMasteryScore(masteryScore);
        }

        if (maxTimeAllowed == null) {
            lfActivityImpl.setMaxTimeAllowed(StringPool.BLANK);
        } else {
            lfActivityImpl.setMaxTimeAllowed(maxTimeAllowed);
        }

        lfActivityImpl.resetOriginalValues();

        return lfActivityImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        indexNumber = objectInput.readLong();
        id = objectInput.readUTF();
        packageID = objectInput.readInt();
        organizationID = objectInput.readUTF();
        parentID = objectInput.readUTF();
        title = objectInput.readUTF();
        identifierRef = objectInput.readUTF();
        resourceParameters = objectInput.readUTF();
        hideLMSUI = objectInput.readUTF();
        visible = objectInput.readBoolean();
        objectivesGlobalToSystem = objectInput.readBoolean();
        sharedDataGlobalToSystem = objectInput.readBoolean();
        masteryScore = objectInput.readUTF();
        maxTimeAllowed = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(indexNumber);

        if (id == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(id);
        }

        objectOutput.writeInt(packageID);

        if (organizationID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(organizationID);
        }

        if (parentID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(parentID);
        }

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (identifierRef == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(identifierRef);
        }

        if (resourceParameters == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(resourceParameters);
        }

        if (hideLMSUI == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(hideLMSUI);
        }

        objectOutput.writeBoolean(visible);
        objectOutput.writeBoolean(objectivesGlobalToSystem);
        objectOutput.writeBoolean(sharedDataGlobalToSystem);

        if (masteryScore == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(masteryScore);
        }

        if (maxTimeAllowed == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(maxTimeAllowed);
        }
    }
}
