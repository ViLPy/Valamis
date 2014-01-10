package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanManifestActivity in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanManifestActivity
* @generated
*/
public class LFTincanManifestActivityCacheModel implements CacheModel<LFTincanManifestActivity>,
    Serializable {
    public long id;
    public String tincanID;
    public Long packageID;
    public String activityType;
    public String name;
    public String description;
    public String launch;
    public String resource;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(id);
        sb.append(", tincanID=");
        sb.append(tincanID);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", activityType=");
        sb.append(activityType);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", launch=");
        sb.append(launch);
        sb.append(", resource=");
        sb.append(resource);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanManifestActivity toEntityModel() {
        LFTincanManifestActivityImpl lfTincanManifestActivityImpl = new LFTincanManifestActivityImpl();

        lfTincanManifestActivityImpl.setId(id);
        lfTincanManifestActivityImpl.setTincanID(tincanID);
        lfTincanManifestActivityImpl.setPackageID(packageID);
        lfTincanManifestActivityImpl.setActivityType(activityType);
        lfTincanManifestActivityImpl.setName(name);
        lfTincanManifestActivityImpl.setDescription(description);
        lfTincanManifestActivityImpl.setLaunch(launch);
        lfTincanManifestActivityImpl.setResource(resource);

        lfTincanManifestActivityImpl.resetOriginalValues();

        return lfTincanManifestActivityImpl;
    }
}
