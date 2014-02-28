package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFPackageScopeRule in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageScopeRule
 * @generated
 */
public class LFPackageScopeRuleCacheModel implements CacheModel<LFPackageScopeRule>,
    Externalizable {
    public long id;
    public Integer packageID;
    public String scope;
    public String scopeID;
    public Boolean visibility;
    public Boolean isDefault;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", scope=");
        sb.append(scope);
        sb.append(", scopeID=");
        sb.append(scopeID);
        sb.append(", visibility=");
        sb.append(visibility);
        sb.append(", isDefault=");
        sb.append(isDefault);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFPackageScopeRule toEntityModel() {
        LFPackageScopeRuleImpl lfPackageScopeRuleImpl = new LFPackageScopeRuleImpl();

        lfPackageScopeRuleImpl.setId(id);
        lfPackageScopeRuleImpl.setPackageID(packageID);

        if (scope == null) {
            lfPackageScopeRuleImpl.setScope(StringPool.BLANK);
        } else {
            lfPackageScopeRuleImpl.setScope(scope);
        }

        if (scopeID == null) {
            lfPackageScopeRuleImpl.setScopeID(StringPool.BLANK);
        } else {
            lfPackageScopeRuleImpl.setScopeID(scopeID);
        }

        lfPackageScopeRuleImpl.setVisibility(visibility);
        lfPackageScopeRuleImpl.setIsDefault(isDefault);

        lfPackageScopeRuleImpl.resetOriginalValues();

        return lfPackageScopeRuleImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        packageID = objectInput.readInt();
        scope = objectInput.readUTF();
        scopeID = objectInput.readUTF();
        visibility = objectInput.readBoolean();
        isDefault = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(packageID);

        if (scope == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(scope);
        }

        if (scopeID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(scopeID);
        }

        objectOutput.writeBoolean(visibility);
        objectOutput.writeBoolean(isDefault);
    }
}
