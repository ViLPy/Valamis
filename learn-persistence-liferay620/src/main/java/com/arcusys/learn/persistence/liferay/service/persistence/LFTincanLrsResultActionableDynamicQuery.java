package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanLrsResultActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanLrsResultActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFTincanLrsResultLocalServiceUtil.getService());
        setClass(LFTincanLrsResult.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
