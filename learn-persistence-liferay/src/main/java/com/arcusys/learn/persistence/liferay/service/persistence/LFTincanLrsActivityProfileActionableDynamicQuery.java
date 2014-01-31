package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsActivityProfileLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanLrsActivityProfileActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanLrsActivityProfileActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanLrsActivityProfileLocalServiceUtil.getService());
        setClass(LFTincanLrsActivityProfile.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
