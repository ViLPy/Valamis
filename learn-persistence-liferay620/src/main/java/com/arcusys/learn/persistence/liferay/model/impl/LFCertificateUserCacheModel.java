package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificateUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LFCertificateUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateUser
 * @generated
 */
public class LFCertificateUserCacheModel implements CacheModel<LFCertificateUser>,
    Externalizable {
    public Long certificateID;
    public Long userID;
    public long attachedDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{certificateID=");
        sb.append(certificateID);
        sb.append(", userID=");
        sb.append(userID);
        sb.append(", attachedDate=");
        sb.append(attachedDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFCertificateUser toEntityModel() {
        LFCertificateUserImpl lfCertificateUserImpl = new LFCertificateUserImpl();

        lfCertificateUserImpl.setCertificateID(certificateID);
        lfCertificateUserImpl.setUserID(userID);

        if (attachedDate == Long.MIN_VALUE) {
            lfCertificateUserImpl.setAttachedDate(null);
        } else {
            lfCertificateUserImpl.setAttachedDate(new Date(attachedDate));
        }

        lfCertificateUserImpl.resetOriginalValues();

        return lfCertificateUserImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        certificateID = objectInput.readLong();
        userID = objectInput.readLong();
        attachedDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(certificateID);
        objectOutput.writeLong(userID);
        objectOutput.writeLong(attachedDate);
    }
}
