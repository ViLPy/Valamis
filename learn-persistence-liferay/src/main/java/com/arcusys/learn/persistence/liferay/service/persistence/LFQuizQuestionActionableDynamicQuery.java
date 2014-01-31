package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestion;
import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFQuizQuestionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFQuizQuestionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFQuizQuestionLocalServiceUtil.getService());
        setClass(LFQuizQuestion.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
