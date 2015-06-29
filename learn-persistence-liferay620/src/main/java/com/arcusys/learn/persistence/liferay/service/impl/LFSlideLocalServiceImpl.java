package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFSlide;
import com.liferay.portal.kernel.exception.SystemException;
import com.arcusys.learn.persistence.liferay.service.base.LFSlideLocalServiceBaseImpl;

/**
 * The implementation of the l f slide local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFSlideLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSlideLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFSlideLocalServiceUtil
 */
public class LFSlideLocalServiceImpl extends LFSlideLocalServiceBaseImpl {
    public LFSlide createLFSlide() throws SystemException {
        return super.createLFSlide(counterLocalService.increment(LFSlide.class.getName()));
    }
}
