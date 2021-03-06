package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSlideSet;
import com.arcusys.learn.persistence.liferay.service.LFSlideSetLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the LFSlideSet service. Represents a row in the &quot;Learn_LFSlideSet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFSlideSetImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSlideSetImpl
 * @see com.arcusys.learn.persistence.liferay.model.LFSlideSet
 * @generated
 */
public abstract class LFSlideSetBaseImpl extends LFSlideSetModelImpl
    implements LFSlideSet {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a l f slide set model instance should use the {@link LFSlideSet} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSlideSetLocalServiceUtil.addLFSlideSet(this);
        } else {
            LFSlideSetLocalServiceUtil.updateLFSlideSet(this);
        }
    }
}
