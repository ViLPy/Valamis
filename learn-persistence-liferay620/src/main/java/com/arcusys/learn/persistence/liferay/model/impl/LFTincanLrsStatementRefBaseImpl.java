package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the LFTincanLrsStatementRef service. Represents a row in the &quot;Learn_LFTincanLrsStatementRef&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFTincanLrsStatementRefImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatementRefImpl
 * @see com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef
 * @generated
 */
public abstract class LFTincanLrsStatementRefBaseImpl
    extends LFTincanLrsStatementRefModelImpl implements LFTincanLrsStatementRef {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a l f tincan lrs statement ref model instance should use the {@link LFTincanLrsStatementRef} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsStatementRefLocalServiceUtil.addLFTincanLrsStatementRef(this);
        } else {
            LFTincanLrsStatementRefLocalServiceUtil.updateLFTincanLrsStatementRef(this);
        }
    }
}