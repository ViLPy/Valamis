package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.service.base.LFTincanClientApiStorageLocalServiceBaseImpl;
import com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException;
import com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage;

/**
 * The implementation of the l f tincan client api storage local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanClientApiStorageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanClientApiStorageLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanClientApiStorageLocalServiceUtil
 */
public class LFTincanClientApiStorageLocalServiceImpl
    extends LFTincanClientApiStorageLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanClientApiStorageLocalServiceUtil} to access the l f tincan client api storage local service.
     */

    public LFTincanClientApiStorage findByToken(String token)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException, NoSuchLFTincanClientApiStorageException {
        return lfTincanClientApiStoragePersistence.findByToken(token);
    }

    public LFTincanClientApiStorage findByCode(String code)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException, NoSuchLFTincanClientApiStorageException{
        return lfTincanClientApiStoragePersistence.fetchByCode(code);
    }
}
