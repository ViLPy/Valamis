package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanPackage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

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
    public String logo;
    public long beginDate;
    public long endDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

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
        sb.append(", logo=");
        sb.append(logo);
        sb.append(", beginDate=");
        sb.append(beginDate);
        sb.append(", endDate=");
        sb.append(endDate);
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

        if (logo == null) {
            lfTincanPackageImpl.setLogo(StringPool.BLANK);
        } else {
            lfTincanPackageImpl.setLogo(logo);
        }

        if (beginDate == Long.MIN_VALUE) {
            lfTincanPackageImpl.setBeginDate(null);
        } else {
            lfTincanPackageImpl.setBeginDate(new Date(beginDate));
        }

        if (endDate == Long.MIN_VALUE) {
            lfTincanPackageImpl.setEndDate(null);
        } else {
            lfTincanPackageImpl.setEndDate(new Date(endDate));
        }

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
        logo = objectInput.readUTF();
        beginDate = objectInput.readLong();
        endDate = objectInput.readLong();
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

        if (logo == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(logo);
        }

        objectOutput.writeLong(beginDate);
        objectOutput.writeLong(endDate);
    }
}
