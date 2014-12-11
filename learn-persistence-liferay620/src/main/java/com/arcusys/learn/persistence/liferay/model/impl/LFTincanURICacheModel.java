package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanURI;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanURI in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanURI
 * @generated
 */
public class LFTincanURICacheModel implements CacheModel<LFTincanURI>,
    Externalizable {
    public String uri;
    public String objID;
    public String objType;
    public String content;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{uri=");
        sb.append(uri);
        sb.append(", objID=");
        sb.append(objID);
        sb.append(", objType=");
        sb.append(objType);
        sb.append(", content=");
        sb.append(content);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanURI toEntityModel() {
        LFTincanURIImpl lfTincanURIImpl = new LFTincanURIImpl();

        if (uri == null) {
            lfTincanURIImpl.setUri(StringPool.BLANK);
        } else {
            lfTincanURIImpl.setUri(uri);
        }

        if (objID == null) {
            lfTincanURIImpl.setObjID(StringPool.BLANK);
        } else {
            lfTincanURIImpl.setObjID(objID);
        }

        if (objType == null) {
            lfTincanURIImpl.setObjType(StringPool.BLANK);
        } else {
            lfTincanURIImpl.setObjType(objType);
        }

        if (content == null) {
            lfTincanURIImpl.setContent(StringPool.BLANK);
        } else {
            lfTincanURIImpl.setContent(content);
        }

        lfTincanURIImpl.resetOriginalValues();

        return lfTincanURIImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uri = objectInput.readUTF();
        objID = objectInput.readUTF();
        objType = objectInput.readUTF();
        content = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uri == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uri);
        }

        if (objID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(objID);
        }

        if (objType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(objType);
        }

        if (content == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(content);
        }
    }
}
