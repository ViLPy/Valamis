package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivity;
import com.arcusys.learn.persistence.liferay.service.LFActivityLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFActivityActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFActivityActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFActivityLocalServiceUtil.getService());
        setClass(LFActivity.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("indexNumber");
    }
}
