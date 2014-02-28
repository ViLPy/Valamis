package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuestion;
import com.arcusys.learn.persistence.liferay.service.LFQuestionLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFQuestionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFQuestionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFQuestionLocalServiceUtil.getService());
        setClass(LFQuestion.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
