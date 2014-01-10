package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanActor;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanActor in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanActor
* @generated
*/
public class LFTincanActorCacheModel implements CacheModel<LFTincanActor>,
    Serializable {
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

    public LFTincanActor toEntityModel() {
        LFTincanActorImpl lfTincanActorImpl = new LFTincanActorImpl();

        lfTincanActorImpl.setId(id);
        lfTincanActorImpl.setTincanID(tincanID);
        lfTincanActorImpl.setObjectType(objectType);

        if (name == null) {
            lfTincanActorImpl.setName(StringPool.BLANK);
        } else {
            lfTincanActorImpl.setName(name);
        }

        lfTincanActorImpl.setMbox(mbox);
        lfTincanActorImpl.setMbox_sha1sum(mbox_sha1sum);
        lfTincanActorImpl.setOpenid(openid);
        lfTincanActorImpl.setAccount(account);
        lfTincanActorImpl.setMemberOf(memberOf);

        lfTincanActorImpl.resetOriginalValues();

        return lfTincanActorImpl;
    }
}
