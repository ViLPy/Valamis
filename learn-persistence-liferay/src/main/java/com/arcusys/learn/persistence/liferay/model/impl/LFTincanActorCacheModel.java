package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanActor;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanActor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActor
 * @generated
 */
public class LFTincanActorCacheModel implements CacheModel<LFTincanActor>,
    Externalizable {
    public long id;
    public String tincanID;
    public String objectType;
    public String name;
    public String mbox;
    public String mbox_sha1sum;
    public String openid;
    public String account;
    public String memberOf;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{id=");
        sb.append(id);
        sb.append(", tincanID=");
        sb.append(tincanID);
        sb.append(", objectType=");
        sb.append(objectType);
        sb.append(", name=");
        sb.append(name);
        sb.append(", mbox=");
        sb.append(mbox);
        sb.append(", mbox_sha1sum=");
        sb.append(mbox_sha1sum);
        sb.append(", openid=");
        sb.append(openid);
        sb.append(", account=");
        sb.append(account);
        sb.append(", memberOf=");
        sb.append(memberOf);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanActor toEntityModel() {
        LFTincanActorImpl lfTincanActorImpl = new LFTincanActorImpl();

        lfTincanActorImpl.setId(id);

        if (tincanID == null) {
            lfTincanActorImpl.setTincanID(StringPool.BLANK);
        } else {
            lfTincanActorImpl.setTincanID(tincanID);
        }

        if (objectType == null) {
            lfTincanActorImpl.setObjectType(StringPool.BLANK);
        } else {
            lfTincanActorImpl.setObjectType(objectType);
        }

        if (name == null) {
            lfTincanActorImpl.setName(StringPool.BLANK);
        } else {
            lfTincanActorImpl.setName(name);
        }

        if (mbox == null) {
            lfTincanActorImpl.setMbox(StringPool.BLANK);
        } else {
            lfTincanActorImpl.setMbox(mbox);
        }

        if (mbox_sha1sum == null) {
            lfTincanActorImpl.setMbox_sha1sum(StringPool.BLANK);
        } else {
            lfTincanActorImpl.setMbox_sha1sum(mbox_sha1sum);
        }

        if (openid == null) {
            lfTincanActorImpl.setOpenid(StringPool.BLANK);
        } else {
            lfTincanActorImpl.setOpenid(openid);
        }

        if (account == null) {
            lfTincanActorImpl.setAccount(StringPool.BLANK);
        } else {
            lfTincanActorImpl.setAccount(account);
        }

        if (memberOf == null) {
            lfTincanActorImpl.setMemberOf(StringPool.BLANK);
        } else {
            lfTincanActorImpl.setMemberOf(memberOf);
        }

        lfTincanActorImpl.resetOriginalValues();

        return lfTincanActorImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        tincanID = objectInput.readUTF();
        objectType = objectInput.readUTF();
        name = objectInput.readUTF();
        mbox = objectInput.readUTF();
        mbox_sha1sum = objectInput.readUTF();
        openid = objectInput.readUTF();
        account = objectInput.readUTF();
        memberOf = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (tincanID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(tincanID);
        }

        if (objectType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(objectType);
        }

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (mbox == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mbox);
        }

        if (mbox_sha1sum == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mbox_sha1sum);
        }

        if (openid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(openid);
        }

        if (account == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(account);
        }

        if (memberOf == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(memberOf);
        }
    }
}
