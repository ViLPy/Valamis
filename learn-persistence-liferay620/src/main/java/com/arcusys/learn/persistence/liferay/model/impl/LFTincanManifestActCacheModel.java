package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanManifestAct in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanManifestAct
 * @generated
 */
public class LFTincanManifestActCacheModel implements CacheModel<LFTincanManifestAct>,
    Externalizable {
    public long id;
    public String tincanID;
    public Long packageID;
    public String activityType;
    public String name;
    public String description;
    public String launch;
    public String resourceID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(id);
        sb.append(", tincanID=");
        sb.append(tincanID);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", activityType=");
        sb.append(activityType);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", launch=");
        sb.append(launch);
        sb.append(", resourceID=");
        sb.append(resourceID);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanManifestAct toEntityModel() {
        LFTincanManifestActImpl lfTincanManifestActImpl = new LFTincanManifestActImpl();

        lfTincanManifestActImpl.setId(id);

        if (tincanID == null) {
            lfTincanManifestActImpl.setTincanID(StringPool.BLANK);
        } else {
            lfTincanManifestActImpl.setTincanID(tincanID);
        }

        lfTincanManifestActImpl.setPackageID(packageID);

        if (activityType == null) {
            lfTincanManifestActImpl.setActivityType(StringPool.BLANK);
        } else {
            lfTincanManifestActImpl.setActivityType(activityType);
        }

        if (name == null) {
            lfTincanManifestActImpl.setName(StringPool.BLANK);
        } else {
            lfTincanManifestActImpl.setName(name);
        }

        if (description == null) {
            lfTincanManifestActImpl.setDescription(StringPool.BLANK);
        } else {
            lfTincanManifestActImpl.setDescription(description);
        }

        if (launch == null) {
            lfTincanManifestActImpl.setLaunch(StringPool.BLANK);
        } else {
            lfTincanManifestActImpl.setLaunch(launch);
        }

        if (resourceID == null) {
            lfTincanManifestActImpl.setResourceID(StringPool.BLANK);
        } else {
            lfTincanManifestActImpl.setResourceID(resourceID);
        }

        lfTincanManifestActImpl.resetOriginalValues();

        return lfTincanManifestActImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        tincanID = objectInput.readUTF();
        packageID = objectInput.readLong();
        activityType = objectInput.readUTF();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        launch = objectInput.readUTF();
        resourceID = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (tincanID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(tincanID);
        }

        objectOutput.writeLong(packageID);

        if (activityType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(activityType);
        }

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (launch == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(launch);
        }

        if (resourceID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(resourceID);
        }
    }
}
