package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAnswer;
import com.arcusys.learn.persistence.liferay.service.LFAnswerLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFAnswerActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFAnswerActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFAnswerLocalServiceUtil.getService());
        setClass(LFAnswer.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
