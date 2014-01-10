package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanLrsStatementRef in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsStatementRef
* @generated
*/
public class LFTincanLrsStatementRefCacheModel implements CacheModel<LFTincanLrsStatementRef>,
    Serializable {
    public long id;
    public String uuid;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{id=");
        sb.append(id);
        sb.append(", uuid=");
        sb.append(uuid);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanLrsStatementRef toEntityModel() {
        LFTincanLrsStatementRefImpl lfTincanLrsStatementRefImpl = new LFTincanLrsStatementRefImpl();

        lfTincanLrsStatementRefImpl.setId(id);
        lfTincanLrsStatementRefImpl.setUuid(uuid);

        lfTincanLrsStatementRefImpl.resetOriginalValues();

        return lfTincanLrsStatementRefImpl;
    }
}
