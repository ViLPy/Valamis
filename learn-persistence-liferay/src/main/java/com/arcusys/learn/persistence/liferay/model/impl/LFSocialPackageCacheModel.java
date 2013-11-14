package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSocialPackage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
* The cache model class for representing LFSocialPackage in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFSocialPackage
* @generated
*/
public class LFSocialPackageCacheModel implements CacheModel<LFSocialPackage>,
    Serializable {
    public long id;
    public Integer packageID;
    public String aboutPackage;
    public long publishDate;
    public Integer authorID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", aboutPackage=");
        sb.append(aboutPackage);
        sb.append(", publishDate=");
        sb.append(publishDate);
        sb.append(", authorID=");
        sb.append(authorID);
        sb.append("}");

        return sb.toString();
    }

    public LFSocialPackage toEntityModel() {
        LFSocialPackageImpl lfSocialPackageImpl = new LFSocialPackageImpl();

        lfSocialPackageImpl.setId(id);
        lfSocialPackageImpl.setPackageID(packageID);
        lfSocialPackageImpl.setAboutPackage(aboutPackage);

        if (publishDate == Long.MIN_VALUE) {
            lfSocialPackageImpl.setPublishDate(null);
        } else {
            lfSocialPackageImpl.setPublishDate(new Date(publishDate));
        }

        lfSocialPackageImpl.setAuthorID(authorID);

        lfSocialPackageImpl.resetOriginalValues();

        return lfSocialPackageImpl;
    }
}
