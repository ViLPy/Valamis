package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory;
import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFQuizQuestionCategoryActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFQuizQuestionCategoryActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFQuizQuestionCategoryLocalServiceUtil.getService());
        setClass(LFQuizQuestionCategory.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
