package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFResource;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFResource in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFResource
 * @generated
 */
public class LFResourceCacheModel implements CacheModel<LFResource>,
    Externalizable {
    public long id;
    public Integer packageID;
    public String scormType;
    public String resourceID;
    public String href;
    public String base;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", scormType=");
        sb.append(scormType);
        sb.append(", resourceID=");
        sb.append(resourceID);
        sb.append(", href=");
        sb.append(href);
        sb.append(", base=");
        sb.append(base);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFResource toEntityModel() {
        LFResourceImpl lfResourceImpl = new LFResourceImpl();

        lfResourceImpl.setId(id);
        lfResourceImpl.setPackageID(packageID);

        if (scormType == null) {
            lfResourceImpl.setScormType(StringPool.BLANK);
        } else {
            lfResourceImpl.setScormType(scormType);
        }

        if (resourceID == null) {
            lfResourceImpl.setResourceID(StringPool.BLANK);
        } else {
            lfResourceImpl.setResourceID(resourceID);
        }

        if (href == null) {
            lfResourceImpl.setHref(StringPool.BLANK);
        } else {
            lfResourceImpl.setHref(href);
        }

        if (base == null) {
            lfResourceImpl.setBase(StringPool.BLANK);
        } else {
            lfResourceImpl.setBase(base);
        }

        lfResourceImpl.resetOriginalValues();

        return lfResourceImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        packageID = objectInput.readInt();
        scormType = objectInput.readUTF();
        resourceID = objectInput.readUTF();
        href = objectInput.readUTF();
        base = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(packageID);

        if (scormType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(scormType);
        }

        if (resourceID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(resourceID);
        }

        if (href == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(href);
        }

        if (base == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(base);
        }
    }
}
