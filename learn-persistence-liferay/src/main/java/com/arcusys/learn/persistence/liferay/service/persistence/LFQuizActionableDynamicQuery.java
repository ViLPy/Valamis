package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuiz;
import com.arcusys.learn.persistence.liferay.service.LFQuizLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFQuizActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFQuizActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFQuizLocalServiceUtil.getService());
        setClass(LFQuiz.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
