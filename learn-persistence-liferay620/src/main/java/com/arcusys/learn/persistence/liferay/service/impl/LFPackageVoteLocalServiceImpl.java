package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackageVote;
import com.arcusys.learn.persistence.liferay.service.base.LFPackageVoteLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f package vote local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFPackageVoteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFPackageVoteLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFPackageVoteLocalServiceUtil
 */
public class LFPackageVoteLocalServiceImpl
    extends LFPackageVoteLocalServiceBaseImpl {
    public LFPackageVote createLFPackageVote() throws SystemException {
        return super.createLFPackageVote(counterLocalService.increment(LFPackageVote.class.getName()));
    }

    public List<LFPackageVote> findBySocialPackageID(final Integer packageID) throws SystemException {
        return lfPackageVotePersistence.findBySocialPackageID(packageID);
    }

    public void removeAll() throws SystemException {
        lfPackageVotePersistence.removeAll();
    }
}
