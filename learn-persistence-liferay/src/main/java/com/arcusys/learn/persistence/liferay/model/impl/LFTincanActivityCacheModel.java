package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanActivity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanActivity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActivity
 * @generated
 */
public class LFTincanActivityCacheModel implements CacheModel<LFTincanActivity>,
    Externalizable {
    public long id;
    public String tincanID;
    public Long packageID;
    public String objectType;
    public String name;
    public String description;
    public String theType;
    public String moreInfo;
    public String interactionType;
    public String correctResponsesPattern;
    public String choices;
    public String scale;
    public String source;
    public String target;
    public String steps;
    public String extensions;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(33);

        sb.append("{id=");
        sb.append(id);
        sb.append(", tincanID=");
        sb.append(tincanID);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", objectType=");
        sb.append(objectType);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", theType=");
        sb.append(theType);
        sb.append(", moreInfo=");
        sb.append(moreInfo);
        sb.append(", interactionType=");
        sb.append(interactionType);
        sb.append(", correctResponsesPattern=");
        sb.append(correctResponsesPattern);
        sb.append(", choices=");
        sb.append(choices);
        sb.append(", scale=");
        sb.append(scale);
        sb.append(", source=");
        sb.append(source);
        sb.append(", target=");
        sb.append(target);
        sb.append(", steps=");
        sb.append(steps);
        sb.append(", extensions=");
        sb.append(extensions);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanActivity toEntityModel() {
        LFTincanActivityImpl lfTincanActivityImpl = new LFTincanActivityImpl();

        lfTincanActivityImpl.setId(id);

        if (tincanID == null) {
            lfTincanActivityImpl.setTincanID(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setTincanID(tincanID);
        }

        lfTincanActivityImpl.setPackageID(packageID);

        if (objectType == null) {
            lfTincanActivityImpl.setObjectType(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setObjectType(objectType);
        }

        if (name == null) {
            lfTincanActivityImpl.setName(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setName(name);
        }

        if (description == null) {
            lfTincanActivityImpl.setDescription(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setDescription(description);
        }

        if (theType == null) {
            lfTincanActivityImpl.setTheType(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setTheType(theType);
        }

        if (moreInfo == null) {
            lfTincanActivityImpl.setMoreInfo(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setMoreInfo(moreInfo);
        }

        if (interactionType == null) {
            lfTincanActivityImpl.setInteractionType(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setInteractionType(interactionType);
        }

        if (correctResponsesPattern == null) {
            lfTincanActivityImpl.setCorrectResponsesPattern(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setCorrectResponsesPattern(correctResponsesPattern);
        }

        if (choices == null) {
            lfTincanActivityImpl.setChoices(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setChoices(choices);
        }

        if (scale == null) {
            lfTincanActivityImpl.setScale(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setScale(scale);
        }

        if (source == null) {
            lfTincanActivityImpl.setSource(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setSource(source);
        }

        if (target == null) {
            lfTincanActivityImpl.setTarget(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setTarget(target);
        }

        if (steps == null) {
            lfTincanActivityImpl.setSteps(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setSteps(steps);
        }

        if (extensions == null) {
            lfTincanActivityImpl.setExtensions(StringPool.BLANK);
        } else {
            lfTincanActivityImpl.setExtensions(extensions);
        }

        lfTincanActivityImpl.resetOriginalValues();

        return lfTincanActivityImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        tincanID = objectInput.readUTF();
        packageID = objectInput.readLong();
        objectType = objectInput.readUTF();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        theType = objectInput.readUTF();
        moreInfo = objectInput.readUTF();
        interactionType = objectInput.readUTF();
        correctResponsesPattern = objectInput.readUTF();
        choices = objectInput.readUTF();
        scale = objectInput.readUTF();
        source = objectInput.readUTF();
        target = objectInput.readUTF();
        steps = objectInput.readUTF();
        extensions = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (tincanID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(tincanID);
        }

        objectOutput.writeLong(packageID);

        if (objectType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(objectType);
        }

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (theType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(theType);
        }

        if (moreInfo == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(moreInfo);
        }

        if (interactionType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(interactionType);
        }

        if (correctResponsesPattern == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(correctResponsesPattern);
        }

        if (choices == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(choices);
        }

        if (scale == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(scale);
        }

        if (source == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(source);
        }

        if (target == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(target);
        }

        if (steps == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(steps);
        }

        if (extensions == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(extensions);
        }
    }
}
