package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFChildrenSelection;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFChildrenSelection in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFChildrenSelection
* @generated
*/
public class LFChildrenSelectionCacheModel implements CacheModel<LFChildrenSelection>,
    Serializable {
    public long id;
    public Integer sequencingID;
    public Integer takeCount;
    public String takeTimingOnEachAttempt;
    public String reorderOnEachAttempt;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", sequencingID=");
        sb.append(sequencingID);
        sb.append(", takeCount=");
        sb.append(takeCount);
        sb.append(", takeTimingOnEachAttempt=");
        sb.append(takeTimingOnEachAttempt);
        sb.append(", reorderOnEachAttempt=");
        sb.append(reorderOnEachAttempt);
        sb.append("}");

        return sb.toString();
    }

    public LFChildrenSelection toEntityModel() {
        LFChildrenSelectionImpl lfChildrenSelectionImpl = new LFChildrenSelectionImpl();

        lfChildrenSelectionImpl.setId(id);
        lfChildrenSelectionImpl.setSequencingID(sequencingID);
        lfChildrenSelectionImpl.setTakeCount(takeCount);
        lfChildrenSelectionImpl.setTakeTimingOnEachAttempt(takeTimingOnEachAttempt);
        lfChildrenSelectionImpl.setReorderOnEachAttempt(reorderOnEachAttempt);

        lfChildrenSelectionImpl.resetOriginalValues();

        return lfChildrenSelectionImpl;
    }
}
