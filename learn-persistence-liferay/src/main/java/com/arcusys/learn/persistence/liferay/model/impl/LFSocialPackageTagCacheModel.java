package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFSocialPackageTag in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFSocialPackageTag
* @generated
*/
public class LFSocialPackageTagCacheModel implements CacheModel<LFSocialPackageTag>,
    Serializable {
    public long id;
    public Integer socialPackageID;
    public String name;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(id);
        sb.append(", socialPackageID=");
        sb.append(socialPackageID);
        sb.append(", name=");
        sb.append(name);
        sb.append("}");

        return sb.toString();
    }

    public LFSocialPackageTag toEntityModel() {
        LFSocialPackageTagImpl lfSocialPackageTagImpl = new LFSocialPackageTagImpl();

        lfSocialPackageTagImpl.setId(id);
        lfSocialPackageTagImpl.setSocialPackageID(socialPackageID);

        if (name == null) {
            lfSocialPackageTagImpl.setName(StringPool.BLANK);
        } else {
            lfSocialPackageTagImpl.setName(name);
        }

        lfSocialPackageTagImpl.resetOriginalValues();

        return lfSocialPackageTagImpl;
    }
}
