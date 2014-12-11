package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore;
import com.arcusys.learn.persistence.liferay.service.LFQuizAnswerScoreLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFQuizAnswerScoreActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFQuizAnswerScoreActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFQuizAnswerScoreLocalServiceUtil.getService());
        setClass(LFQuizAnswerScore.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("answerId");
    }
}
