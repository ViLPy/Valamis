package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanPackage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanPackage in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanPackage
* @generated
*/
public class LFTincanPackageCacheModel implements CacheModel<LFTincanPackage>,
    Serializable {
    public long id;
    public String title;
    public String summary;
    public Long assetRefID;
    public Integer courseID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", title=");
        sb.append(title);
        sb.append(", summary=");
        sb.append(summary);
        sb.append(", assetRefID=");
        sb.append(assetRefID);
        sb.append(", courseID=");
        sb.append(courseID);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanPackage toEntityModel() {
        LFTincanPackageImpl lfTincanPackageImpl = new LFTincanPackageImpl();

        lfTincanPackageImpl.setId(id);
        lfTincanPackageImpl.setTitle(title);
        lfTincanPackageImpl.setSummary(summary);
        lfTincanPackageImpl.setAssetRefID(assetRefID);
        lfTincanPackageImpl.setCourseID(courseID);

        lfTincanPackageImpl.resetOriginalValues();

        return lfTincanPackageImpl;
    }
}
