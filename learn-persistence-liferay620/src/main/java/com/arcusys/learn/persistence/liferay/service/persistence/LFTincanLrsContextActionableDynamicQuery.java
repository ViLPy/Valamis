package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanLrsContextActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanLrsContextActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFTincanLrsContextLocalServiceUtil.getService());
        setClass(LFTincanLrsContext.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
