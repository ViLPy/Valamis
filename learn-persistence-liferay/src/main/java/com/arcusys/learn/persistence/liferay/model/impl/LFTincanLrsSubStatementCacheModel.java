package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanLrsSubStatement in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsSubStatement
* @generated
*/
public class LFTincanLrsSubStatementCacheModel implements CacheModel<LFTincanLrsSubStatement>,
    Serializable {
    public long id;
    public Integer actorID;
    public String verbID;
    public String verbDisplay;
    public String objType;
    public Integer objID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", actorID=");
        sb.append(actorID);
        sb.append(", verbID=");
        sb.append(verbID);
        sb.append(", verbDisplay=");
        sb.append(verbDisplay);
        sb.append(", objType=");
        sb.append(objType);
        sb.append(", objID=");
        sb.append(objID);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanLrsSubStatement toEntityModel() {
        LFTincanLrsSubStatementImpl lfTincanLrsSubStatementImpl = new LFTincanLrsSubStatementImpl();

        lfTincanLrsSubStatementImpl.setId(id);
        lfTincanLrsSubStatementImpl.setActorID(actorID);
        lfTincanLrsSubStatementImpl.setVerbID(verbID);
        lfTincanLrsSubStatementImpl.setVerbDisplay(verbDisplay);
        lfTincanLrsSubStatementImpl.setObjType(objType);
        lfTincanLrsSubStatementImpl.setObjID(objID);

        lfTincanLrsSubStatementImpl.resetOriginalValues();

        return lfTincanLrsSubStatementImpl;
    }
}
