package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LFCertificate in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificate
 * @generated
 */
public class LFCertificateCacheModel implements CacheModel<LFCertificate>,
    Externalizable {
    public long id;
    public String title;
    public String description;
    public String logo;
    public Boolean isPermanent;
    public Boolean publishBadge;
    public String shortDescription;
    public Integer companyID;
    public String state;
    public String emails;
    public String validPeriodType;
    public Integer validPeriod;
    public long createdDate;
    public Boolean isPublished;
    public Long scope;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(31);

        sb.append("{id=");
        sb.append(id);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", logo=");
        sb.append(logo);
        sb.append(", isPermanent=");
        sb.append(isPermanent);
        sb.append(", publishBadge=");
        sb.append(publishBadge);
        sb.append(", shortDescription=");
        sb.append(shortDescription);
        sb.append(", companyID=");
        sb.append(companyID);
        sb.append(", state=");
        sb.append(state);
        sb.append(", emails=");
        sb.append(emails);
        sb.append(", validPeriodType=");
        sb.append(validPeriodType);
        sb.append(", validPeriod=");
        sb.append(validPeriod);
        sb.append(", createdDate=");
        sb.append(createdDate);
        sb.append(", isPublished=");
        sb.append(isPublished);
        sb.append(", scope=");
        sb.append(scope);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFCertificate toEntityModel() {
        LFCertificateImpl lfCertificateImpl = new LFCertificateImpl();

        lfCertificateImpl.setId(id);

        if (title == null) {
            lfCertificateImpl.setTitle(StringPool.BLANK);
        } else {
            lfCertificateImpl.setTitle(title);
        }

        if (description == null) {
            lfCertificateImpl.setDescription(StringPool.BLANK);
        } else {
            lfCertificateImpl.setDescription(description);
        }

        if (logo == null) {
            lfCertificateImpl.setLogo(StringPool.BLANK);
        } else {
            lfCertificateImpl.setLogo(logo);
        }

        lfCertificateImpl.setIsPermanent(isPermanent);
        lfCertificateImpl.setPublishBadge(publishBadge);

        if (shortDescription == null) {
            lfCertificateImpl.setShortDescription(StringPool.BLANK);
        } else {
            lfCertificateImpl.setShortDescription(shortDescription);
        }

        lfCertificateImpl.setCompanyID(companyID);

        if (state == null) {
            lfCertificateImpl.setState(StringPool.BLANK);
        } else {
            lfCertificateImpl.setState(state);
        }

        if (emails == null) {
            lfCertificateImpl.setEmails(StringPool.BLANK);
        } else {
            lfCertificateImpl.setEmails(emails);
        }

        if (validPeriodType == null) {
            lfCertificateImpl.setValidPeriodType(StringPool.BLANK);
        } else {
            lfCertificateImpl.setValidPeriodType(validPeriodType);
        }

        lfCertificateImpl.setValidPeriod(validPeriod);

        if (createdDate == Long.MIN_VALUE) {
            lfCertificateImpl.setCreatedDate(null);
        } else {
            lfCertificateImpl.setCreatedDate(new Date(createdDate));
        }

        lfCertificateImpl.setIsPublished(isPublished);
        lfCertificateImpl.setScope(scope);

        lfCertificateImpl.resetOriginalValues();

        return lfCertificateImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        logo = objectInput.readUTF();
        isPermanent = objectInput.readBoolean();
        publishBadge = objectInput.readBoolean();
        shortDescription = objectInput.readUTF();
        companyID = objectInput.readInt();
        state = objectInput.readUTF();
        emails = objectInput.readUTF();
        validPeriodType = objectInput.readUTF();
        validPeriod = objectInput.readInt();
        createdDate = objectInput.readLong();
        isPublished = objectInput.readBoolean();
        scope = objectInput.readLong();
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

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (logo == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(logo);
        }

        objectOutput.writeBoolean(isPermanent);
        objectOutput.writeBoolean(publishBadge);

        if (shortDescription == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shortDescription);
        }

        objectOutput.writeInt(companyID);

        if (state == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(state);
        }

        if (emails == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(emails);
        }

        if (validPeriodType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(validPeriodType);
        }

        objectOutput.writeInt(validPeriod);
        objectOutput.writeLong(createdDate);
        objectOutput.writeBoolean(isPublished);
        objectOutput.writeLong(scope);
    }
}
