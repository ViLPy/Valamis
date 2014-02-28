package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificateSite;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFCertificateSite in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateSite
 * @generated
 */
public class LFCertificateSiteCacheModel implements CacheModel<LFCertificateSite>,
    Externalizable {
    public long id;
    public Integer certificateID;
    public Integer siteID;
    public Integer arrangementIndex;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", certificateID=");
        sb.append(certificateID);
        sb.append(", siteID=");
        sb.append(siteID);
        sb.append(", arrangementIndex=");
        sb.append(arrangementIndex);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFCertificateSite toEntityModel() {
        LFCertificateSiteImpl lfCertificateSiteImpl = new LFCertificateSiteImpl();

        lfCertificateSiteImpl.setId(id);
        lfCertificateSiteImpl.setCertificateID(certificateID);
        lfCertificateSiteImpl.setSiteID(siteID);
        lfCertificateSiteImpl.setArrangementIndex(arrangementIndex);

        lfCertificateSiteImpl.resetOriginalValues();

        return lfCertificateSiteImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        certificateID = objectInput.readInt();
        siteID = objectInput.readInt();
        arrangementIndex = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(certificateID);
        objectOutput.writeInt(siteID);
        objectOutput.writeInt(arrangementIndex);
    }
}
