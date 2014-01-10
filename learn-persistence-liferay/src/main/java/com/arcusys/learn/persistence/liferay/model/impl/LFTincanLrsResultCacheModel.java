package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanLrsResult in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsResult
* @generated
*/
public class LFTincanLrsResultCacheModel implements CacheModel<LFTincanLrsResult>,
    Serializable {
    public long id;
    public String score;
    public Boolean success;
    public Boolean completion;
    public String response;
    public Double duration;
    public String extension;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(id);
        sb.append(", score=");
        sb.append(score);
        sb.append(", success=");
        sb.append(success);
        sb.append(", completion=");
        sb.append(completion);
        sb.append(", response=");
        sb.append(response);
        sb.append(", duration=");
        sb.append(duration);
        sb.append(", extension=");
        sb.append(extension);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanLrsResult toEntityModel() {
        LFTincanLrsResultImpl lfTincanLrsResultImpl = new LFTincanLrsResultImpl();

        lfTincanLrsResultImpl.setId(id);
        lfTincanLrsResultImpl.setScore(score);
        lfTincanLrsResultImpl.setSuccess(success);
        lfTincanLrsResultImpl.setCompletion(completion);
        lfTincanLrsResultImpl.setResponse(response);
        lfTincanLrsResultImpl.setDuration(duration);
        lfTincanLrsResultImpl.setExtension(extension);

        lfTincanLrsResultImpl.resetOriginalValues();

        return lfTincanLrsResultImpl;
    }
}
