package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFPlayerScopeRule in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFPlayerScopeRule
 * @generated
 */
public class LFPlayerScopeRuleCacheModel implements CacheModel<LFPlayerScopeRule>,
    Externalizable {
    public long id;
    public String playerID;
    public String scope;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(id);
        sb.append(", playerID=");
        sb.append(playerID);
        sb.append(", scope=");
        sb.append(scope);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFPlayerScopeRule toEntityModel() {
        LFPlayerScopeRuleImpl lfPlayerScopeRuleImpl = new LFPlayerScopeRuleImpl();

        lfPlayerScopeRuleImpl.setId(id);

        if (playerID == null) {
            lfPlayerScopeRuleImpl.setPlayerID(StringPool.BLANK);
        } else {
            lfPlayerScopeRuleImpl.setPlayerID(playerID);
        }

        if (scope == null) {
            lfPlayerScopeRuleImpl.setScope(StringPool.BLANK);
        } else {
            lfPlayerScopeRuleImpl.setScope(scope);
        }

        lfPlayerScopeRuleImpl.resetOriginalValues();

        return lfPlayerScopeRuleImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        playerID = objectInput.readUTF();
        scope = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (playerID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(playerID);
        }

        if (scope == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(scope);
        }
    }
}
