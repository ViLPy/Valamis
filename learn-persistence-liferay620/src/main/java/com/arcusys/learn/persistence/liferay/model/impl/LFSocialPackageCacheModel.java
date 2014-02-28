package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSocialPackage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LFSocialPackage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFSocialPackage
 * @generated
 */
public class LFSocialPackageCacheModel implements CacheModel<LFSocialPackage>,
    Externalizable {
    public long id;
    public Integer packageID;
    public String aboutPackage;
    public long publishDate;
    public Integer authorID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", aboutPackage=");
        sb.append(aboutPackage);
        sb.append(", publishDate=");
        sb.append(publishDate);
        sb.append(", authorID=");
        sb.append(authorID);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFSocialPackage toEntityModel() {
        LFSocialPackageImpl lfSocialPackageImpl = new LFSocialPackageImpl();

        lfSocialPackageImpl.setId(id);
        lfSocialPackageImpl.setPackageID(packageID);

        if (aboutPackage == null) {
            lfSocialPackageImpl.setAboutPackage(StringPool.BLANK);
        } else {
            lfSocialPackageImpl.setAboutPackage(aboutPackage);
        }

        if (publishDate == Long.MIN_VALUE) {
            lfSocialPackageImpl.setPublishDate(null);
        } else {
            lfSocialPackageImpl.setPublishDate(new Date(publishDate));
        }

        lfSocialPackageImpl.setAuthorID(authorID);

        lfSocialPackageImpl.resetOriginalValues();

        return lfSocialPackageImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        packageID = objectInput.readInt();
        aboutPackage = objectInput.readUTF();
        publishDate = objectInput.readLong();
        authorID = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(packageID);

        if (aboutPackage == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(aboutPackage);
        }

        objectOutput.writeLong(publishDate);
        objectOutput.writeInt(authorID);
    }
}
