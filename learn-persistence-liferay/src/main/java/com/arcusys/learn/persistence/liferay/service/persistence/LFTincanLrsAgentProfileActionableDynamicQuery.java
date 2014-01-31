package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsAgentProfileLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanLrsAgentProfileActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanLrsAgentProfileActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanLrsAgentProfileLocalServiceUtil.getService());
        setClass(LFTincanLrsAgentProfile.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
