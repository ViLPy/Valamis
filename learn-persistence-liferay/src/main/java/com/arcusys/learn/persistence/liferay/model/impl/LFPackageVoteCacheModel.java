package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackageVote;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFPackageVote in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageVote
 * @generated
 */
public class LFPackageVoteCacheModel implements CacheModel<LFPackageVote>,
    Externalizable {
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

    @Override
    public LFPackageVote toEntityModel() {
        LFPackageVoteImpl lfPackageVoteImpl = new LFPackageVoteImpl();

        lfPackageVoteImpl.setId(id);
        lfPackageVoteImpl.setUserID(userID);
        lfPackageVoteImpl.setSocialPackageID(socialPackageID);
        lfPackageVoteImpl.setVoteValue(voteValue);

        lfPackageVoteImpl.resetOriginalValues();

        return lfPackageVoteImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        userID = objectInput.readInt();
        socialPackageID = objectInput.readInt();
        voteValue = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(userID);
        objectOutput.writeInt(socialPackageID);
        objectOutput.writeInt(voteValue);
    }
}
