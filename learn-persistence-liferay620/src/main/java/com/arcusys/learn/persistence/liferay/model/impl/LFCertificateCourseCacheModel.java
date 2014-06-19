package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificateCourse;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFCertificateCourse in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateCourse
 * @generated
 */
public class LFCertificateCourseCacheModel implements CacheModel<LFCertificateCourse>,
    Externalizable {
    public Long certificateID;
    public Long courseID;
    public Integer arrangementIndex;
    public String periodType;
    public Integer period;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{certificateID=");
        sb.append(certificateID);
        sb.append(", courseID=");
        sb.append(courseID);
        sb.append(", arrangementIndex=");
        sb.append(arrangementIndex);
        sb.append(", periodType=");
        sb.append(periodType);
        sb.append(", period=");
        sb.append(period);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFCertificateCourse toEntityModel() {
        LFCertificateCourseImpl lfCertificateCourseImpl = new LFCertificateCourseImpl();

        lfCertificateCourseImpl.setCertificateID(certificateID);
        lfCertificateCourseImpl.setCourseID(courseID);
        lfCertificateCourseImpl.setArrangementIndex(arrangementIndex);

        if (periodType == null) {
            lfCertificateCourseImpl.setPeriodType(StringPool.BLANK);
        } else {
            lfCertificateCourseImpl.setPeriodType(periodType);
        }

        lfCertificateCourseImpl.setPeriod(period);

        lfCertificateCourseImpl.resetOriginalValues();

        return lfCertificateCourseImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        certificateID = objectInput.readLong();
        courseID = objectInput.readLong();
        arrangementIndex = objectInput.readInt();
        periodType = objectInput.readUTF();
        period = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(certificateID);
        objectOutput.writeLong(courseID);
        objectOutput.writeInt(arrangementIndex);

        if (periodType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(periodType);
        }

        objectOutput.writeInt(period);
    }
}
