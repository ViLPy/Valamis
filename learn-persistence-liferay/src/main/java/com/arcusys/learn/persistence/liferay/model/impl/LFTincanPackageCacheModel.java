package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanPackage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanPackage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanPackage
 * @generated
 */
public class LFTincanPackageCacheModel implements CacheModel<LFTincanPackage>,
    Externalizable {
    public long id;
    public String title;
    public String summary;
    public Long assetRefID;
    public Integer courseID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", title=");
        sb.append(title);
        sb.append(", summary=");
        sb.append(summary);
        sb.append(", assetRefID=");
        sb.append(assetRefID);
        sb.append(", courseID=");
        sb.append(courseID);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanPackage toEntityModel() {
        LFTincanPackageImpl lfTincanPackageImpl = new LFTincanPackageImpl();

        lfTincanPackageImpl.setId(id);

        if (title == null) {
            lfTincanPackageImpl.setTitle(StringPool.BLANK);
        } else {
            lfTincanPackageImpl.setTitle(title);
        }

        if (summary == null) {
            lfTincanPackageImpl.setSummary(StringPool.BLANK);
        } else {
            lfTincanPackageImpl.setSummary(summary);
        }

        lfTincanPackageImpl.setAssetRefID(assetRefID);
        lfTincanPackageImpl.setCourseID(courseID);

        lfTincanPackageImpl.resetOriginalValues();

        return lfTincanPackageImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        title = objectInput.readUTF();
        summary = objectInput.readUTF();
        assetRefID = objectInput.readLong();
        courseID = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (summary == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(summary);
        }

        objectOutput.writeLong(assetRefID);
        objectOutput.writeInt(courseID);
    }
}
