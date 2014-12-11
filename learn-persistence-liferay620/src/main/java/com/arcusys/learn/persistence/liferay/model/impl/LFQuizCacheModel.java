package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuiz;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFQuiz in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuiz
 * @generated
 */
public class LFQuizCacheModel implements CacheModel<LFQuiz>, Externalizable {
    public long id;
    public String title;
    public String description;
    public String logo;
    public String welcomePageContent;
    public String finalPageContent;
    public Integer courseID;
    public Integer maxDuration;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(id);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", logo=");
        sb.append(logo);
        sb.append(", welcomePageContent=");
        sb.append(welcomePageContent);
        sb.append(", finalPageContent=");
        sb.append(finalPageContent);
        sb.append(", courseID=");
        sb.append(courseID);
        sb.append(", maxDuration=");
        sb.append(maxDuration);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFQuiz toEntityModel() {
        LFQuizImpl lfQuizImpl = new LFQuizImpl();

        lfQuizImpl.setId(id);

        if (title == null) {
            lfQuizImpl.setTitle(StringPool.BLANK);
        } else {
            lfQuizImpl.setTitle(title);
        }

        if (description == null) {
            lfQuizImpl.setDescription(StringPool.BLANK);
        } else {
            lfQuizImpl.setDescription(description);
        }

        if (logo == null) {
            lfQuizImpl.setLogo(StringPool.BLANK);
        } else {
            lfQuizImpl.setLogo(logo);
        }

        if (welcomePageContent == null) {
            lfQuizImpl.setWelcomePageContent(StringPool.BLANK);
        } else {
            lfQuizImpl.setWelcomePageContent(welcomePageContent);
        }

        if (finalPageContent == null) {
            lfQuizImpl.setFinalPageContent(StringPool.BLANK);
        } else {
            lfQuizImpl.setFinalPageContent(finalPageContent);
        }

        lfQuizImpl.setCourseID(courseID);
        lfQuizImpl.setMaxDuration(maxDuration);

        lfQuizImpl.resetOriginalValues();

        return lfQuizImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        logo = objectInput.readUTF();
        welcomePageContent = objectInput.readUTF();
        finalPageContent = objectInput.readUTF();
        courseID = objectInput.readInt();
        maxDuration = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (logo == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(logo);
        }

        if (welcomePageContent == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(welcomePageContent);
        }

        if (finalPageContent == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(finalPageContent);
        }

        objectOutput.writeInt(courseID);
        objectOutput.writeInt(maxDuration);
    }
}
