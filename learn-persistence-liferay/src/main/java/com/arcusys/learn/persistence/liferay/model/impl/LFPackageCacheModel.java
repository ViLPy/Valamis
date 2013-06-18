package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFPackage in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFPackage
* @generated
*/
public class LFPackageCacheModel implements CacheModel<LFPackage>, Serializable {
    public long id;
    public String defaultOrganizationID;
    public String title;
    public String base;
    public String resourcesBase;
    public String summary;
    public Long assetRefID;
    public Integer courseID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(id);
        sb.append(", defaultOrganizationID=");
        sb.append(defaultOrganizationID);
        sb.append(", title=");
        sb.append(title);
        sb.append(", base=");
        sb.append(base);
        sb.append(", resourcesBase=");
        sb.append(resourcesBase);
        sb.append(", summary=");
        sb.append(summary);
        sb.append(", assetRefID=");
        sb.append(assetRefID);
        sb.append(", courseID=");
        sb.append(courseID);
        sb.append("}");

        return sb.toString();
    }

    public LFPackage toEntityModel() {
        LFPackageImpl lfPackageImpl = new LFPackageImpl();

        lfPackageImpl.setId(id);

        if (defaultOrganizationID == null) {
            lfPackageImpl.setDefaultOrganizationID(StringPool.BLANK);
        } else {
            lfPackageImpl.setDefaultOrganizationID(defaultOrganizationID);
        }

        if (title == null) {
            lfPackageImpl.setTitle(StringPool.BLANK);
        } else {
            lfPackageImpl.setTitle(title);
        }

        if (base == null) {
            lfPackageImpl.setBase(StringPool.BLANK);
        } else {
            lfPackageImpl.setBase(base);
        }

        if (resourcesBase == null) {
            lfPackageImpl.setResourcesBase(StringPool.BLANK);
        } else {
            lfPackageImpl.setResourcesBase(resourcesBase);
        }

        if (summary == null) {
            lfPackageImpl.setSummary(StringPool.BLANK);
        } else {
            lfPackageImpl.setSummary(summary);
        }

        lfPackageImpl.setAssetRefID(assetRefID);
        lfPackageImpl.setCourseID(courseID);

        lfPackageImpl.resetOriginalValues();

        return lfPackageImpl;
    }
}
