package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat;
import com.arcusys.learn.persistence.liferay.service.LFQuizQuestCatLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFQuizQuestCatActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFQuizQuestCatActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFQuizQuestCatLocalServiceUtil.getService());
        setClass(LFQuizQuestCat.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
