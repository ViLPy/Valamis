package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFCertificateTincanStatement in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateTincanStatement
 * @generated
 */
public class LFCertificateTincanStatementCacheModel implements CacheModel<LFCertificateTincanStatement>,
    Externalizable {
    public Long certificateID;
    public String verb;
    public String object;
    public String periodType;
    public Integer period;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{certificateID=");
        sb.append(certificateID);
        sb.append(", verb=");
        sb.append(verb);
        sb.append(", object=");
        sb.append(object);
        sb.append(", periodType=");
        sb.append(periodType);
        sb.append(", period=");
        sb.append(period);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFCertificateTincanStatement toEntityModel() {
        LFCertificateTincanStatementImpl lfCertificateTincanStatementImpl = new LFCertificateTincanStatementImpl();

        lfCertificateTincanStatementImpl.setCertificateID(certificateID);

        if (verb == null) {
            lfCertificateTincanStatementImpl.setVerb(StringPool.BLANK);
        } else {
            lfCertificateTincanStatementImpl.setVerb(verb);
        }

        if (object == null) {
            lfCertificateTincanStatementImpl.setObject(StringPool.BLANK);
        } else {
            lfCertificateTincanStatementImpl.setObject(object);
        }

        if (periodType == null) {
            lfCertificateTincanStatementImpl.setPeriodType(StringPool.BLANK);
        } else {
            lfCertificateTincanStatementImpl.setPeriodType(periodType);
        }

        lfCertificateTincanStatementImpl.setPeriod(period);

        lfCertificateTincanStatementImpl.resetOriginalValues();

        return lfCertificateTincanStatementImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        certificateID = objectInput.readLong();
        verb = objectInput.readUTF();
        object = objectInput.readUTF();
        periodType = objectInput.readUTF();
        period = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(certificateID);

        if (verb == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(verb);
        }

        if (object == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(object);
        }

        if (periodType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(periodType);
        }

        objectOutput.writeInt(period);
    }
}
