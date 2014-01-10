package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanLrsContextActivities in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsContextActivities
* @generated
*/
public class LFTincanLrsContextActivitiesCacheModel implements CacheModel<LFTincanLrsContextActivities>,
    Serializable {
    public long id;
    public String parent;
    public String grouping;
    public String category;
    public String other;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", parent=");
        sb.append(parent);
        sb.append(", grouping=");
        sb.append(grouping);
        sb.append(", category=");
        sb.append(category);
        sb.append(", other=");
        sb.append(other);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanLrsContextActivities toEntityModel() {
        LFTincanLrsContextActivitiesImpl lfTincanLrsContextActivitiesImpl = new LFTincanLrsContextActivitiesImpl();

        lfTincanLrsContextActivitiesImpl.setId(id);
        lfTincanLrsContextActivitiesImpl.setParent(parent);
        lfTincanLrsContextActivitiesImpl.setGrouping(grouping);
        lfTincanLrsContextActivitiesImpl.setCategory(category);
        lfTincanLrsContextActivitiesImpl.setOther(other);

        lfTincanLrsContextActivitiesImpl.resetOriginalValues();

        return lfTincanLrsContextActivitiesImpl;
    }
}
