package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFUser
 * @generated
 */
public class LFUserCacheModel implements CacheModel<LFUser>, Externalizable {
    public long lfid;
    public Integer id;
    public String name;
    public Double preferredAudioLevel;
    public String preferredLanguage;
    public Double preferredDeliverySpeed;
    public Integer preferredAudioCaptioning;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{lfid=");
        sb.append(lfid);
        sb.append(", id=");
        sb.append(id);
        sb.append(", name=");
        sb.append(name);
        sb.append(", preferredAudioLevel=");
        sb.append(preferredAudioLevel);
        sb.append(", preferredLanguage=");
        sb.append(preferredLanguage);
        sb.append(", preferredDeliverySpeed=");
        sb.append(preferredDeliverySpeed);
        sb.append(", preferredAudioCaptioning=");
        sb.append(preferredAudioCaptioning);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFUser toEntityModel() {
        LFUserImpl lfUserImpl = new LFUserImpl();

        lfUserImpl.setLfid(lfid);
        lfUserImpl.setId(id);

        if (name == null) {
            lfUserImpl.setName(StringPool.BLANK);
        } else {
            lfUserImpl.setName(name);
        }

        lfUserImpl.setPreferredAudioLevel(preferredAudioLevel);

        if (preferredLanguage == null) {
            lfUserImpl.setPreferredLanguage(StringPool.BLANK);
        } else {
            lfUserImpl.setPreferredLanguage(preferredLanguage);
        }

        lfUserImpl.setPreferredDeliverySpeed(preferredDeliverySpeed);
        lfUserImpl.setPreferredAudioCaptioning(preferredAudioCaptioning);

        lfUserImpl.resetOriginalValues();

        return lfUserImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        lfid = objectInput.readLong();
        id = objectInput.readInt();
        name = objectInput.readUTF();
        preferredAudioLevel = objectInput.readDouble();
        preferredLanguage = objectInput.readUTF();
        preferredDeliverySpeed = objectInput.readDouble();
        preferredAudioCaptioning = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(lfid);
        objectOutput.writeInt(id);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        objectOutput.writeDouble(preferredAudioLevel);

        if (preferredLanguage == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(preferredLanguage);
        }

        objectOutput.writeDouble(preferredDeliverySpeed);
        objectOutput.writeInt(preferredAudioCaptioning);
    }
}
