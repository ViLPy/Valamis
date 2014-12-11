package com.arcusys.learn.persistence.liferay.service.base;

import com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFCertificateUserLocalServiceClpInvoker {
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
    private String _methodName316;
    private String[] _methodParameterTypes316;
    private String _methodName317;
    private String[] _methodParameterTypes317;
    private String _methodName322;
    private String[] _methodParameterTypes322;
    private String _methodName323;
    private String[] _methodParameterTypes323;
    private String _methodName324;
    private String[] _methodParameterTypes324;
    private String _methodName325;
    private String[] _methodParameterTypes325;
    private String _methodName326;
    private String[] _methodParameterTypes326;

    public LFCertificateUserLocalServiceClpInvoker() {
        _methodName0 = "addLFCertificateUser";

        _methodParameterTypes0 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFCertificateUser"
            };

        _methodName1 = "createLFCertificateUser";

        _methodParameterTypes1 = new String[] {
                "com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK"
            };

        _methodName2 = "deleteLFCertificateUser";

        _methodParameterTypes2 = new String[] {
                "com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK"
            };

        _methodName3 = "deleteLFCertificateUser";

        _methodParameterTypes3 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFCertificateUser"
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

        _methodName10 = "fetchLFCertificateUser";

        _methodParameterTypes10 = new String[] {
                "com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK"
            };

        _methodName11 = "getLFCertificateUser";

        _methodParameterTypes11 = new String[] {
                "com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK"
            };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getLFCertificateUsers";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getLFCertificateUsersCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateLFCertificateUser";

        _methodParameterTypes15 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFCertificateUser"
            };

        _methodName316 = "getBeanIdentifier";

        _methodParameterTypes316 = new String[] {  };

        _methodName317 = "setBeanIdentifier";

        _methodParameterTypes317 = new String[] { "java.lang.String" };

        _methodName322 = "findByCertificateID";

        _methodParameterTypes322 = new String[] { "java.lang.Long" };

        _methodName323 = "findByUserID";

        _methodParameterTypes323 = new String[] { "java.lang.Long" };

        _methodName324 = "findByUserIDAndCertificateID";

        _methodParameterTypes324 = new String[] {
                "java.lang.Long", "java.lang.Long"
            };

        _methodName325 = "removeByUserIDAndCertificateID";

        _methodParameterTypes325 = new String[] {
                "java.lang.Long", "java.lang.Long"
            };

        _methodName326 = "removeAll";

        _methodParameterTypes326 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.addLFCertificateUser((com.arcusys.learn.persistence.liferay.model.LFCertificateUser) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.createLFCertificateUser((com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.deleteLFCertificateUser((com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.deleteLFCertificateUser((com.arcusys.learn.persistence.liferay.model.LFCertificateUser) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.fetchLFCertificateUser((com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.getLFCertificateUser((com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.getLFCertificateUsers(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.getLFCertificateUsersCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.updateLFCertificateUser((com.arcusys.learn.persistence.liferay.model.LFCertificateUser) arguments[0]);
        }

        if (_methodName316.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes316, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName317.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes317, parameterTypes)) {
            LFCertificateUserLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName322.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes322, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.findByCertificateID((java.lang.Long) arguments[0]);
        }

        if (_methodName323.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes323, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.findByUserID((java.lang.Long) arguments[0]);
        }

        if (_methodName324.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes324, parameterTypes)) {
            return LFCertificateUserLocalServiceUtil.findByUserIDAndCertificateID((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1]);
        }

        if (_methodName325.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes325, parameterTypes)) {
            LFCertificateUserLocalServiceUtil.removeByUserIDAndCertificateID((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1]);

            return null;
        }

        if (_methodName326.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes326, parameterTypes)) {
            LFCertificateUserLocalServiceUtil.removeAll();

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
