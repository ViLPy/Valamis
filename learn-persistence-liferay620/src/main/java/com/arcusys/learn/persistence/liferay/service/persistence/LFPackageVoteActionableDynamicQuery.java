package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPackageVote;
import com.arcusys.learn.persistence.liferay.service.LFPackageVoteLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFPackageVoteActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFPackageVoteActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFPackageVoteLocalServiceUtil.getService());
        setClass(LFPackageVote.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
