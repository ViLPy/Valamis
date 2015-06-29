package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException;
import com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage;
import com.arcusys.learn.persistence.liferay.service.base.LFTCClntApiStorageLocalServiceBaseImpl;

/**
 * The implementation of the l f t c clnt api storage local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTCClntApiStorageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTCClntApiStorageLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTCClntApiStorageLocalServiceUtil
 */
public class LFTCClntApiStorageLocalServiceImpl
    extends LFTCClntApiStorageLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTCClntApiStorageLocalServiceUtil} to access the l f t c clnt api storage local service.
     */

    public LFTCClntApiStorage findByToken(String token)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException, NoSuchLFTCClntApiStorageException {
        return lftcClntApiStoragePersistence.findByToken(token);
    }

    public LFTCClntApiStorage findByCode(String code)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException, NoSuchLFTCClntApiStorageException{
        return lftcClntApiStoragePersistence.fetchByCode(code);
    }
}
