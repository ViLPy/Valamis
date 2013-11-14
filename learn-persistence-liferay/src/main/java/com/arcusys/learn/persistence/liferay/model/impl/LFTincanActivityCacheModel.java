package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanActivity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanActivity in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanActivity
* @generated
*/
public class LFTincanActivityCacheModel implements CacheModel<LFTincanActivity>,
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

    public LFTincanActivity toEntityModel() {
        LFTincanActivityImpl lfTincanActivityImpl = new LFTincanActivityImpl();

        lfTincanActivityImpl.setId(id);
        lfTincanActivityImpl.setTincanID(tincanID);
        lfTincanActivityImpl.setPackageID(packageID);
        lfTincanActivityImpl.setActivityType(activityType);
        lfTincanActivityImpl.setName(name);
        lfTincanActivityImpl.setDescription(description);
        lfTincanActivityImpl.setLaunch(launch);
        lfTincanActivityImpl.setResource(resource);

        lfTincanActivityImpl.resetOriginalValues();

        return lfTincanActivityImpl;
    }
}
