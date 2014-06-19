package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificateActivity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFCertificateActivity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateActivity
 * @generated
 */
public class LFCertificateActivityCacheModel implements CacheModel<LFCertificateActivity>,
    Externalizable {
    public Long certificateID;
    public String activityName;
    public Integer datacount;
    public String periodType;
    public Integer period;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{certificateID=");
        sb.append(certificateID);
        sb.append(", activityName=");
        sb.append(activityName);
        sb.append(", datacount=");
        sb.append(datacount);
        sb.append(", periodType=");
        sb.append(periodType);
        sb.append(", period=");
        sb.append(period);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFCertificateActivity toEntityModel() {
        LFCertificateActivityImpl lfCertificateActivityImpl = new LFCertificateActivityImpl();

        lfCertificateActivityImpl.setCertificateID(certificateID);

        if (activityName == null) {
            lfCertificateActivityImpl.setActivityName(StringPool.BLANK);
        } else {
            lfCertificateActivityImpl.setActivityName(activityName);
        }

        lfCertificateActivityImpl.setDatacount(datacount);

        if (periodType == null) {
            lfCertificateActivityImpl.setPeriodType(StringPool.BLANK);
        } else {
            lfCertificateActivityImpl.setPeriodType(periodType);
        }

        lfCertificateActivityImpl.setPeriod(period);

        lfCertificateActivityImpl.resetOriginalValues();

        return lfCertificateActivityImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        certificateID = objectInput.readLong();
        activityName = objectInput.readUTF();
        datacount = objectInput.readInt();
        periodType = objectInput.readUTF();
        period = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(certificateID);

        if (activityName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(activityName);
        }

        objectOutput.writeInt(datacount);

        if (periodType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(periodType);
        }

        objectOutput.writeInt(period);
    }
}
