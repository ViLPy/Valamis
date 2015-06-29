package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LFPackage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFPackage
 * @generated
 */
public class LFPackageCacheModel implements CacheModel<LFPackage>,
    Externalizable {
    public long id;
    public String defaultOrganizationID;
    public String title;
    public String base;
    public String resourcesBase;
    public String summary;
    public Long assetRefID;
    public Integer courseID;
    public String logo;
    public long beginDate;
    public long endDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{id=");
        sb.append(id);
        sb.append(", defaultOrganizationID=");
        sb.append(defaultOrganizationID);
        sb.append(", title=");
        sb.append(title);
        sb.append(", base=");
        sb.append(base);
        sb.append(", resourcesBase=");
        sb.append(resourcesBase);
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
    public LFPackage toEntityModel() {
        LFPackageImpl lfPackageImpl = new LFPackageImpl();

        lfPackageImpl.setId(id);

        if (defaultOrganizationID == null) {
            lfPackageImpl.setDefaultOrganizationID(StringPool.BLANK);
        } else {
            lfPackageImpl.setDefaultOrganizationID(defaultOrganizationID);
        }

        if (title == null) {
            lfPackageImpl.setTitle(StringPool.BLANK);
        } else {
            lfPackageImpl.setTitle(title);
        }

        if (base == null) {
            lfPackageImpl.setBase(StringPool.BLANK);
        } else {
            lfPackageImpl.setBase(base);
        }

        if (resourcesBase == null) {
            lfPackageImpl.setResourcesBase(StringPool.BLANK);
        } else {
            lfPackageImpl.setResourcesBase(resourcesBase);
        }

        if (summary == null) {
            lfPackageImpl.setSummary(StringPool.BLANK);
        } else {
            lfPackageImpl.setSummary(summary);
        }

        lfPackageImpl.setAssetRefID(assetRefID);
        lfPackageImpl.setCourseID(courseID);

        if (logo == null) {
            lfPackageImpl.setLogo(StringPool.BLANK);
        } else {
            lfPackageImpl.setLogo(logo);
        }

        if (beginDate == Long.MIN_VALUE) {
            lfPackageImpl.setBeginDate(null);
        } else {
            lfPackageImpl.setBeginDate(new Date(beginDate));
        }

        if (endDate == Long.MIN_VALUE) {
            lfPackageImpl.setEndDate(null);
        } else {
            lfPackageImpl.setEndDate(new Date(endDate));
        }

        lfPackageImpl.resetOriginalValues();

        return lfPackageImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        defaultOrganizationID = objectInput.readUTF();
        title = objectInput.readUTF();
        base = objectInput.readUTF();
        resourcesBase = objectInput.readUTF();
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

        if (defaultOrganizationID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(defaultOrganizationID);
        }

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (base == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(base);
        }

        if (resourcesBase == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(resourcesBase);
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
