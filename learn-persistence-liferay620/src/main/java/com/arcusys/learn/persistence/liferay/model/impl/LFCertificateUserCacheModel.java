package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificateUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFCertificateUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateUser
 * @generated
 */
public class LFCertificateUserCacheModel implements CacheModel<LFCertificateUser>,
    Externalizable {
    public long id;
    public Integer certificateID;
    public Integer userID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(id);
        sb.append(", certificateID=");
        sb.append(certificateID);
        sb.append(", userID=");
        sb.append(userID);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFCertificateUser toEntityModel() {
        LFCertificateUserImpl lfCertificateUserImpl = new LFCertificateUserImpl();

        lfCertificateUserImpl.setId(id);
        lfCertificateUserImpl.setCertificateID(certificateID);
        lfCertificateUserImpl.setUserID(userID);

        lfCertificateUserImpl.resetOriginalValues();

        return lfCertificateUserImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        certificateID = objectInput.readInt();
        userID = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(certificateID);
        objectOutput.writeInt(userID);
    }
}
