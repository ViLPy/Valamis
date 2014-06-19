package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement;
import com.arcusys.learn.persistence.liferay.service.LFQuizTreeElementLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFQuizTreeElementActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFQuizTreeElementActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFQuizTreeElementLocalServiceUtil.getService());
        setClass(LFQuizTreeElement.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
