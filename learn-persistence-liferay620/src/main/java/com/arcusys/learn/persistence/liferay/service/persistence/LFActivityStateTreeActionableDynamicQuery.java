package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityStateTree;
import com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFActivityStateTreeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFActivityStateTreeActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFActivityStateTreeLocalServiceUtil.getService());
        setClass(LFActivityStateTree.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
