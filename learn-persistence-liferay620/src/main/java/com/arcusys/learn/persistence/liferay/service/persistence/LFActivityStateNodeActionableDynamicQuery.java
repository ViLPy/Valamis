package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityStateNode;
import com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFActivityStateNodeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFActivityStateNodeActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFActivityStateNodeLocalServiceUtil.getService());
        setClass(LFActivityStateNode.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
