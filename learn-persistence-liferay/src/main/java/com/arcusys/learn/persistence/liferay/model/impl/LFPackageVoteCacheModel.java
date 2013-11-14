package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackageVote;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFPackageVote in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFPackageVote
* @generated
*/
public class LFPackageVoteCacheModel implements CacheModel<LFPackageVote>,
    Serializable {
    public long id;
    public Integer userID;
    public Integer socialPackageID;
    public Integer voteValue;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", userID=");
        sb.append(userID);
        sb.append(", socialPackageID=");
        sb.append(socialPackageID);
        sb.append(", voteValue=");
        sb.append(voteValue);
        sb.append("}");

        return sb.toString();
    }

    public LFPackageVote toEntityModel() {
        LFPackageVoteImpl lfPackageVoteImpl = new LFPackageVoteImpl();

        lfPackageVoteImpl.setId(id);
        lfPackageVoteImpl.setUserID(userID);
        lfPackageVoteImpl.setSocialPackageID(socialPackageID);
        lfPackageVoteImpl.setVoteValue(voteValue);

        lfPackageVoteImpl.resetOriginalValues();

        return lfPackageVoteImpl;
    }
}
