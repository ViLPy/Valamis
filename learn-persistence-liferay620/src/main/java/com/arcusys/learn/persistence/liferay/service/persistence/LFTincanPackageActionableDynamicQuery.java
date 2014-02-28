package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanPackage;
import com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanPackageActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanPackageActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFTincanPackageLocalServiceUtil.getService());
        setClass(LFTincanPackage.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
