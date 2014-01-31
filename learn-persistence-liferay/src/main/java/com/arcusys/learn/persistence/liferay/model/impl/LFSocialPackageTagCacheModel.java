package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFSocialPackageTag in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFSocialPackageTag
 * @generated
 */
public class LFSocialPackageTagCacheModel implements CacheModel<LFSocialPackageTag>,
    Externalizable {
    public long id;
    public Integer socialPackageID;
    public String name;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(id);
        sb.append(", socialPackageID=");
        sb.append(socialPackageID);
        sb.append(", name=");
        sb.append(name);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFSocialPackageTag toEntityModel() {
        LFSocialPackageTagImpl lfSocialPackageTagImpl = new LFSocialPackageTagImpl();

        lfSocialPackageTagImpl.setId(id);
        lfSocialPackageTagImpl.setSocialPackageID(socialPackageID);

        if (name == null) {
            lfSocialPackageTagImpl.setName(StringPool.BLANK);
        } else {
            lfSocialPackageTagImpl.setName(name);
        }

        lfSocialPackageTagImpl.resetOriginalValues();

        return lfSocialPackageTagImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        socialPackageID = objectInput.readInt();
        name = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(socialPackageID);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }
    }
}
