package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.service.base.LFRollupContributionLocalServiceBaseImpl;
import com.arcusys.learn.persistence.liferay.model.LFRollupContribution;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f rollup contribution local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFRollupContributionLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalServiceUtil
 */
public class LFRollupContributionLocalServiceImpl
    extends LFRollupContributionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalServiceUtil} to access the l f rollup contribution local service.
     */

    public LFRollupContribution createLFRollupContribution() throws SystemException {
        return createLFRollupContribution(counterLocalService.increment(LFRollupContribution.class.getName()));
    }
    public LFRollupContribution findBySequencingID(Integer sequencingID)
            throws  com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException,
            com.liferay.portal.kernel.exception.SystemException{
        return lfRollupContributionPersistence.findBySequencingID(sequencingID);
    }
    public void removeBySequencingID(Integer sequencingID)
            throws   com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException,
            com.liferay.portal.kernel.exception.SystemException {
        lfRollupContributionPersistence.removeBySequencingID(sequencingID);
    }

    public void removeAll() throws SystemException {
        lfRollupContributionPersistence.removeAll();
    }

    @Override
    public LFRollupContribution getLFRollupContribution(final long id) throws PortalException, SystemException {
        try {
            return super.getLFRollupContribution(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}
