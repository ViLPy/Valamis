package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException;
import com.arcusys.learn.persistence.liferay.model.LFTincanActor;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanActorLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f tincan actor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanActorLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalServiceUtil
 */
public class LFTincanActorLocalServiceImpl
    extends LFTincanActorLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalServiceUtil} to access the l f tincan actor local service.
     */

    public void removeAll() throws SystemException {
        lfTincanActorPersistence.removeAll();
    }

    public LFTincanActor createLFTincanActor() throws SystemException {
        return createLFTincanActor(counterLocalService.increment(LFTincanActor.class.getName()));
    }

    public java.util.List<LFTincanActor> findByMemberOf(String memberOf) throws SystemException{
        return lfTincanActorPersistence.findByMemberOf(memberOf);
    }

    public LFTincanActor findByTincanID(String tincanID) throws SystemException, NoSuchLFTincanActorException {
        return lfTincanActorPersistence.findByTincanID(tincanID);
    }

    public List<LFTincanActor> findAgent(String name, String mbox, String mbox_sha1sum, String openid) throws SystemException {
        return lfTincanActorPersistence.findByAgent("Agent", name, mbox, mbox_sha1sum, openid);
    }
}
