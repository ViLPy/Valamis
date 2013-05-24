package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivityStateNode;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFActivityStateNode in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFActivityStateNode
* @generated
*/
public class LFActivityStateNodeCacheModel implements CacheModel<LFActivityStateNode>,
    Serializable {
    public long id;
    public Integer parentID;
    public Integer treeID;
    public String availableChildrenIDs;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", parentID=");
        sb.append(parentID);
        sb.append(", treeID=");
        sb.append(treeID);
        sb.append(", availableChildrenIDs=");
        sb.append(availableChildrenIDs);
        sb.append("}");

        return sb.toString();
    }

    public LFActivityStateNode toEntityModel() {
        LFActivityStateNodeImpl lfActivityStateNodeImpl = new LFActivityStateNodeImpl();

        lfActivityStateNodeImpl.setId(id);
        lfActivityStateNodeImpl.setParentID(parentID);
        lfActivityStateNodeImpl.setTreeID(treeID);

        if (availableChildrenIDs == null) {
            lfActivityStateNodeImpl.setAvailableChildrenIDs(StringPool.BLANK);
        } else {
            lfActivityStateNodeImpl.setAvailableChildrenIDs(availableChildrenIDs);
        }

        lfActivityStateNodeImpl.resetOriginalValues();

        return lfActivityStateNodeImpl;
    }
}
