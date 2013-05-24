package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSequencingTracking;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFSequencingTracking in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFSequencingTracking
* @generated
*/
public class LFSequencingTrackingCacheModel implements CacheModel<LFSequencingTracking>,
    Serializable {
    public long id;
    public Integer sequencingID;
    public boolean completionSetByContent;
    public boolean objectiveSetByContent;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", sequencingID=");
        sb.append(sequencingID);
        sb.append(", completionSetByContent=");
        sb.append(completionSetByContent);
        sb.append(", objectiveSetByContent=");
        sb.append(objectiveSetByContent);
        sb.append("}");

        return sb.toString();
    }

    public LFSequencingTracking toEntityModel() {
        LFSequencingTrackingImpl lfSequencingTrackingImpl = new LFSequencingTrackingImpl();

        lfSequencingTrackingImpl.setId(id);
        lfSequencingTrackingImpl.setSequencingID(sequencingID);
        lfSequencingTrackingImpl.setCompletionSetByContent(completionSetByContent);
        lfSequencingTrackingImpl.setObjectiveSetByContent(objectiveSetByContent);

        lfSequencingTrackingImpl.resetOriginalValues();

        return lfSequencingTrackingImpl;
    }
}
