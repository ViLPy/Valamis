package com.arcusys.learn.persistence.liferay.service.base;

import com.arcusys.learn.persistence.liferay.service.LFCertificateToUserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFCertificateToUserLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName284;
    private String[] _methodParameterTypes284;
    private String _methodName285;
    private String[] _methodParameterTypes285;
    private String _methodName290;
    private String[] _methodParameterTypes290;
    private String _methodName291;
    private String[] _methodParameterTypes291;
    private String _methodName292;
    private String[] _methodParameterTypes292;
    private String _methodName293;
    private String[] _methodParameterTypes293;
    private String _methodName294;
    private String[] _methodParameterTypes294;
    private String _methodName295;
    private String[] _methodParameterTypes295;

    public LFCertificateToUserLocalServiceClpInvoker() {
        _methodName0 = "addLFCertificateToUser";

        _methodParameterTypes0 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFCertificateToUser"
            };

        _methodName1 = "createLFCertificateToUser";

        _methodParameterTypes1 = new String[] {
                "com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK"
            };

        _methodName2 = "deleteLFCertificateToUser";

        _methodParameterTypes2 = new String[] {
                "com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK"
            };

        _methodName3 = "deleteLFCertificateToUser";

        _methodParameterTypes3 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFCertificateToUser"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchLFCertificateToUser";

        _methodParameterTypes10 = new String[] {
                "com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK"
            };

        _methodName11 = "getLFCertificateToUser";

        _methodParameterTypes11 = new String[] {
                "com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK"
            };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getLFCertificateToUsers";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getLFCertificateToUsersCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateLFCertificateToUser";

        _methodParameterTypes15 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFCertificateToUser"
            };

        _methodName284 = "getBeanIdentifier";

        _methodParameterTypes284 = new String[] {  };

        _methodName285 = "setBeanIdentifier";

        _methodParameterTypes285 = new String[] { "java.lang.String" };

        _methodName290 = "createLFCertificateUser";

        _methodParameterTypes290 = new String[] {
                "java.lang.Integer", "java.lang.Integer"
            };

        _methodName291 = "findByCertificateID";

        _methodParameterTypes291 = new String[] { "java.lang.Integer" };

        _methodName292 = "findByUserID";

        _methodParameterTypes292 = new String[] { "java.lang.Integer" };

        _methodName293 = "findByUserIDAndCertificateID";

        _methodParameterTypes293 = new String[] {
                "java.lang.Integer", "java.lang.Integer"
            };

        _methodName294 = "removeByUserIDAndCertificateID";

        _methodParameterTypes294 = new String[] {
                "java.lang.Integer", "java.lang.Integer"
            };

        _methodName295 = "removeAll";

        _methodParameterTypes295 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.addLFCertificateToUser((com.arcusys.learn.persistence.liferay.model.LFCertificateToUser) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.createLFCertificateToUser((com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.deleteLFCertificateToUser((com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.deleteLFCertificateToUser((com.arcusys.learn.persistence.liferay.model.LFCertificateToUser) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.fetchLFCertificateToUser((com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.getLFCertificateToUser((com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.getLFCertificateToUsers(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.getLFCertificateToUsersCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.updateLFCertificateToUser((com.arcusys.learn.persistence.liferay.model.LFCertificateToUser) arguments[0]);
        }

        if (_methodName284.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes284, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName285.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes285, parameterTypes)) {
            LFCertificateToUserLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName290.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes290, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.createLFCertificateUser((java.lang.Integer) arguments[0],
                (java.lang.Integer) arguments[1]);
        }

        if (_methodName291.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes291, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.findByCertificateID((java.lang.Integer) arguments[0]);
        }

        if (_methodName292.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes292, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.findByUserID((java.lang.Integer) arguments[0]);
        }

        if (_methodName293.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes293, parameterTypes)) {
            return LFCertificateToUserLocalServiceUtil.findByUserIDAndCertificateID((java.lang.Integer) arguments[0],
                (java.lang.Integer) arguments[1]);
        }

        if (_methodName294.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes294, parameterTypes)) {
            LFCertificateToUserLocalServiceUtil.removeByUserIDAndCertificateID((java.lang.Integer) arguments[0],
                (java.lang.Integer) arguments[1]);

            return null;
        }

        if (_methodName295.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes295, parameterTypes)) {
            LFCertificateToUserLocalServiceUtil.removeAll();

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
