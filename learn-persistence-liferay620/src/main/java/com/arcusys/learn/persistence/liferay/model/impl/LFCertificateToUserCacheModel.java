package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificateToUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LFCertificateToUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateToUser
 * @generated
 */
public class LFCertificateToUserCacheModel implements CacheModel<LFCertificateToUser>,
    Externalizable {
    public Integer certificateID;
    public Integer userID;
    public String status;
    public long addedToUserDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{certificateID=");
        sb.append(certificateID);
        sb.append(", userID=");
        sb.append(userID);
        sb.append(", status=");
        sb.append(status);
        sb.append(", addedToUserDate=");
        sb.append(addedToUserDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFCertificateToUser toEntityModel() {
        LFCertificateToUserImpl lfCertificateToUserImpl = new LFCertificateToUserImpl();

        lfCertificateToUserImpl.setCertificateID(certificateID);
        lfCertificateToUserImpl.setUserID(userID);

        if (status == null) {
            lfCertificateToUserImpl.setStatus(StringPool.BLANK);
        } else {
            lfCertificateToUserImpl.setStatus(status);
        }

        if (addedToUserDate == Long.MIN_VALUE) {
            lfCertificateToUserImpl.setAddedToUserDate(null);
        } else {
            lfCertificateToUserImpl.setAddedToUserDate(new Date(addedToUserDate));
        }

        lfCertificateToUserImpl.resetOriginalValues();

        return lfCertificateToUserImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        certificateID = objectInput.readInt();
        userID = objectInput.readInt();
        status = objectInput.readUTF();
        addedToUserDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(certificateID);
        objectOutput.writeInt(userID);

        if (status == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(status);
        }

        objectOutput.writeLong(addedToUserDate);
    }
}
