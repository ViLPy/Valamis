package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuestionCategory;
import com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFQuestionCategoryActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFQuestionCategoryActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFQuestionCategoryLocalServiceUtil.getService());
        setClass(LFQuestionCategory.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
