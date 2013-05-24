package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFActivity in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFActivity
* @generated
*/
public class LFActivityCacheModel implements CacheModel<LFActivity>,
    Serializable {
    public long indexNumber;
    public String id;
    public Integer packageID;
    public String organizationID;
    public String parentID;
    public String title;
    public String identifierRef;
    public String resourceParameters;
    public String hideLMSUI;
    public boolean visible;
    public boolean objectivesGlobalToSystem;
    public boolean sharedDataGlobalToSystem;
    public String masteryScore;
    public String maxTimeAllowed;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{indexNumber=");
        sb.append(indexNumber);
        sb.append(", id=");
        sb.append(id);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", organizationID=");
        sb.append(organizationID);
        sb.append(", parentID=");
        sb.append(parentID);
        sb.append(", title=");
        sb.append(title);
        sb.append(", identifierRef=");
        sb.append(identifierRef);
        sb.append(", resourceParameters=");
        sb.append(resourceParameters);
        sb.append(", hideLMSUI=");
        sb.append(hideLMSUI);
        sb.append(", visible=");
        sb.append(visible);
        sb.append(", objectivesGlobalToSystem=");
        sb.append(objectivesGlobalToSystem);
        sb.append(", sharedDataGlobalToSystem=");
        sb.append(sharedDataGlobalToSystem);
        sb.append(", masteryScore=");
        sb.append(masteryScore);
        sb.append(", maxTimeAllowed=");
        sb.append(maxTimeAllowed);
        sb.append("}");

        return sb.toString();
    }

    public LFActivity toEntityModel() {
        LFActivityImpl lfActivityImpl = new LFActivityImpl();

        lfActivityImpl.setIndexNumber(indexNumber);

        if (id == null) {
            lfActivityImpl.setId(StringPool.BLANK);
        } else {
            lfActivityImpl.setId(id);
        }

        lfActivityImpl.setPackageID(packageID);

        if (organizationID == null) {
            lfActivityImpl.setOrganizationID(StringPool.BLANK);
        } else {
            lfActivityImpl.setOrganizationID(organizationID);
        }

        if (parentID == null) {
            lfActivityImpl.setParentID(StringPool.BLANK);
        } else {
            lfActivityImpl.setParentID(parentID);
        }

        if (title == null) {
            lfActivityImpl.setTitle(StringPool.BLANK);
        } else {
            lfActivityImpl.setTitle(title);
        }

        if (identifierRef == null) {
            lfActivityImpl.setIdentifierRef(StringPool.BLANK);
        } else {
            lfActivityImpl.setIdentifierRef(identifierRef);
        }

        if (resourceParameters == null) {
            lfActivityImpl.setResourceParameters(StringPool.BLANK);
        } else {
            lfActivityImpl.setResourceParameters(resourceParameters);
        }

        if (hideLMSUI == null) {
            lfActivityImpl.setHideLMSUI(StringPool.BLANK);
        } else {
            lfActivityImpl.setHideLMSUI(hideLMSUI);
        }

        lfActivityImpl.setVisible(visible);
        lfActivityImpl.setObjectivesGlobalToSystem(objectivesGlobalToSystem);
        lfActivityImpl.setSharedDataGlobalToSystem(sharedDataGlobalToSystem);

        if (masteryScore == null) {
            lfActivityImpl.setMasteryScore(StringPool.BLANK);
        } else {
            lfActivityImpl.setMasteryScore(masteryScore);
        }

        if (maxTimeAllowed == null) {
            lfActivityImpl.setMaxTimeAllowed(StringPool.BLANK);
        } else {
            lfActivityImpl.setMaxTimeAllowed(maxTimeAllowed);
        }

        lfActivityImpl.resetOriginalValues();

        return lfActivityImpl;
    }
}
