package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanActivity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanActivity in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanActivity
* @generated
*/
public class LFTincanActivityCacheModel implements CacheModel<LFTincanActivity>,
    Serializable {
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

    public LFTincanActivity toEntityModel() {
        LFTincanActivityImpl lfTincanActivityImpl = new LFTincanActivityImpl();

        lfTincanActivityImpl.setId(id);
        lfTincanActivityImpl.setTincanID(tincanID);
        lfTincanActivityImpl.setPackageID(packageID);
        lfTincanActivityImpl.setObjectType(objectType);
        lfTincanActivityImpl.setName(name);
        lfTincanActivityImpl.setDescription(description);
        lfTincanActivityImpl.setTheType(theType);
        lfTincanActivityImpl.setMoreInfo(moreInfo);
        lfTincanActivityImpl.setInteractionType(interactionType);
        lfTincanActivityImpl.setCorrectResponsesPattern(correctResponsesPattern);
        lfTincanActivityImpl.setChoices(choices);
        lfTincanActivityImpl.setScale(scale);
        lfTincanActivityImpl.setSource(source);
        lfTincanActivityImpl.setTarget(target);
        lfTincanActivityImpl.setSteps(steps);
        lfTincanActivityImpl.setExtensions(extensions);

        lfTincanActivityImpl.resetOriginalValues();

        return lfTincanActivityImpl;
    }
}
