package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFConfig;
import com.arcusys.learn.persistence.liferay.service.LFConfigLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFConfigActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFConfigActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFConfigLocalServiceUtil.getService());
        setClass(LFConfig.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
