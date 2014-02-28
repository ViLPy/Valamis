package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanLrsContext in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsContext
 * @generated
 */
public class LFTincanLrsContextCacheModel implements CacheModel<LFTincanLrsContext>,
    Externalizable {
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

    @Override
    public LFTincanLrsContext toEntityModel() {
        LFTincanLrsContextImpl lfTincanLrsContextImpl = new LFTincanLrsContextImpl();

        lfTincanLrsContextImpl.setId(id);

        if (registration == null) {
            lfTincanLrsContextImpl.setRegistration(StringPool.BLANK);
        } else {
            lfTincanLrsContextImpl.setRegistration(registration);
        }

        lfTincanLrsContextImpl.setInstructorID(instructorID);
        lfTincanLrsContextImpl.setTeamID(teamID);
        lfTincanLrsContextImpl.setContextActivitiesID(contextActivitiesID);

        if (revision == null) {
            lfTincanLrsContextImpl.setRevision(StringPool.BLANK);
        } else {
            lfTincanLrsContextImpl.setRevision(revision);
        }

        if (platform == null) {
            lfTincanLrsContextImpl.setPlatform(StringPool.BLANK);
        } else {
            lfTincanLrsContextImpl.setPlatform(platform);
        }

        if (language == null) {
            lfTincanLrsContextImpl.setLanguage(StringPool.BLANK);
        } else {
            lfTincanLrsContextImpl.setLanguage(language);
        }

        if (statement == null) {
            lfTincanLrsContextImpl.setStatement(StringPool.BLANK);
        } else {
            lfTincanLrsContextImpl.setStatement(statement);
        }

        if (extensions == null) {
            lfTincanLrsContextImpl.setExtensions(StringPool.BLANK);
        } else {
            lfTincanLrsContextImpl.setExtensions(extensions);
        }

        lfTincanLrsContextImpl.resetOriginalValues();

        return lfTincanLrsContextImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        registration = objectInput.readUTF();
        instructorID = objectInput.readInt();
        teamID = objectInput.readInt();
        contextActivitiesID = objectInput.readInt();
        revision = objectInput.readUTF();
        platform = objectInput.readUTF();
        language = objectInput.readUTF();
        statement = objectInput.readUTF();
        extensions = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (registration == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(registration);
        }

        objectOutput.writeInt(instructorID);
        objectOutput.writeInt(teamID);
        objectOutput.writeInt(contextActivitiesID);

        if (revision == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(revision);
        }

        if (platform == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(platform);
        }

        if (language == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(language);
        }

        if (statement == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statement);
        }

        if (extensions == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(extensions);
        }
    }
}
