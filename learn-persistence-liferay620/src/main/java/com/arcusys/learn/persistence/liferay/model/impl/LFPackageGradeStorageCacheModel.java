package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFPackageGradeStorage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageGradeStorage
 * @generated
 */
public class LFPackageGradeStorageCacheModel implements CacheModel<LFPackageGradeStorage>,
    Externalizable {
    public Long userId;
    public Long packageId;
    public String grade;
    public String comment;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{userId=");
        sb.append(userId);
        sb.append(", packageId=");
        sb.append(packageId);
        sb.append(", grade=");
        sb.append(grade);
        sb.append(", comment=");
        sb.append(comment);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFPackageGradeStorage toEntityModel() {
        LFPackageGradeStorageImpl lfPackageGradeStorageImpl = new LFPackageGradeStorageImpl();

        lfPackageGradeStorageImpl.setUserId(userId);
        lfPackageGradeStorageImpl.setPackageId(packageId);

        if (grade == null) {
            lfPackageGradeStorageImpl.setGrade(StringPool.BLANK);
        } else {
            lfPackageGradeStorageImpl.setGrade(grade);
        }

        if (comment == null) {
            lfPackageGradeStorageImpl.setComment(StringPool.BLANK);
        } else {
            lfPackageGradeStorageImpl.setComment(comment);
        }

        lfPackageGradeStorageImpl.resetOriginalValues();

        return lfPackageGradeStorageImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        userId = objectInput.readLong();
        packageId = objectInput.readLong();
        grade = objectInput.readUTF();
        comment = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(userId);
        objectOutput.writeLong(packageId);

        if (grade == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(grade);
        }

        if (comment == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(comment);
        }
    }
}
