package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanLrsContext in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsContext
* @generated
*/
public class LFTincanLrsContextCacheModel implements CacheModel<LFTincanLrsContext>,
    Serializable {
    public long id;
    public String registration;
    public Integer instructorID;
    public Integer teamID;
    public Integer contextActivitiesID;
    public String revision;
    public String platform;
    public String language;
    public String statement;
    public String extensions;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{id=");
        sb.append(id);
        sb.append(", registration=");
        sb.append(registration);
        sb.append(", instructorID=");
        sb.append(instructorID);
        sb.append(", teamID=");
        sb.append(teamID);
        sb.append(", contextActivitiesID=");
        sb.append(contextActivitiesID);
        sb.append(", revision=");
        sb.append(revision);
        sb.append(", platform=");
        sb.append(platform);
        sb.append(", language=");
        sb.append(language);
        sb.append(", statement=");
        sb.append(statement);
        sb.append(", extensions=");
        sb.append(extensions);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanLrsContext toEntityModel() {
        LFTincanLrsContextImpl lfTincanLrsContextImpl = new LFTincanLrsContextImpl();

        lfTincanLrsContextImpl.setId(id);
        lfTincanLrsContextImpl.setRegistration(registration);
        lfTincanLrsContextImpl.setInstructorID(instructorID);
        lfTincanLrsContextImpl.setTeamID(teamID);
        lfTincanLrsContextImpl.setContextActivitiesID(contextActivitiesID);
        lfTincanLrsContextImpl.setRevision(revision);
        lfTincanLrsContextImpl.setPlatform(platform);
        lfTincanLrsContextImpl.setLanguage(language);
        lfTincanLrsContextImpl.setStatement(statement);
        lfTincanLrsContextImpl.setExtensions(extensions);

        lfTincanLrsContextImpl.resetOriginalValues();

        return lfTincanLrsContextImpl;
    }
}
