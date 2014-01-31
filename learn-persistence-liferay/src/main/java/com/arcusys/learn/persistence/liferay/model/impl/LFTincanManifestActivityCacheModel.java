package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanManifestActivity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanManifestActivity
 * @generated
 */
public class LFTincanManifestActivityCacheModel implements CacheModel<LFTincanManifestActivity>,
    Externalizable {
    public long id;
    public String tincanID;
    public Long packageID;
    public String activityType;
    public String name;
    public String description;
    public String launch;
    public String resource;

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
        sb.append(", resource=");
        sb.append(resource);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanManifestActivity toEntityModel() {
        LFTincanManifestActivityImpl lfTincanManifestActivityImpl = new LFTincanManifestActivityImpl();

        lfTincanManifestActivityImpl.setId(id);

        if (tincanID == null) {
            lfTincanManifestActivityImpl.setTincanID(StringPool.BLANK);
        } else {
            lfTincanManifestActivityImpl.setTincanID(tincanID);
        }

        lfTincanManifestActivityImpl.setPackageID(packageID);

        if (activityType == null) {
            lfTincanManifestActivityImpl.setActivityType(StringPool.BLANK);
        } else {
            lfTincanManifestActivityImpl.setActivityType(activityType);
        }

        if (name == null) {
            lfTincanManifestActivityImpl.setName(StringPool.BLANK);
        } else {
            lfTincanManifestActivityImpl.setName(name);
        }

        if (description == null) {
            lfTincanManifestActivityImpl.setDescription(StringPool.BLANK);
        } else {
            lfTincanManifestActivityImpl.setDescription(description);
        }

        if (launch == null) {
            lfTincanManifestActivityImpl.setLaunch(StringPool.BLANK);
        } else {
            lfTincanManifestActivityImpl.setLaunch(launch);
        }

        if (resource == null) {
            lfTincanManifestActivityImpl.setResource(StringPool.BLANK);
        } else {
            lfTincanManifestActivityImpl.setResource(resource);
        }

        lfTincanManifestActivityImpl.resetOriginalValues();

        return lfTincanManifestActivityImpl;
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
        resource = objectInput.readUTF();
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

        if (resource == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(resource);
        }
    }
}
