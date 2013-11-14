package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFResource;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFResource in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFResource
* @generated
*/
public class LFResourceCacheModel implements CacheModel<LFResource>,
    Serializable {
    public long id;
    public Integer packageID;
    public String scormType;
    public String resourceID;
    public String href;
    public String base;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", scormType=");
        sb.append(scormType);
        sb.append(", resourceID=");
        sb.append(resourceID);
        sb.append(", href=");
        sb.append(href);
        sb.append(", base=");
        sb.append(base);
        sb.append("}");

        return sb.toString();
    }

    public LFResource toEntityModel() {
        LFResourceImpl lfResourceImpl = new LFResourceImpl();

        lfResourceImpl.setId(id);
        lfResourceImpl.setPackageID(packageID);
        lfResourceImpl.setScormType(scormType);
        lfResourceImpl.setResourceID(resourceID);
        lfResourceImpl.setHref(href);
        lfResourceImpl.setBase(base);

        lfResourceImpl.resetOriginalValues();

        return lfResourceImpl;
    }
}
