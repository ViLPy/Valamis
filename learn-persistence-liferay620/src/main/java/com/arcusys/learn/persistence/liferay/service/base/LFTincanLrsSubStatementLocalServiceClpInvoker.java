package com.arcusys.learn.persistence.liferay.service.base;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFTincanLrsSubStatementLocalServiceClpInvoker {
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
    private String _methodName280;
    private String[] _methodParameterTypes280;
    private String _methodName281;
    private String[] _methodParameterTypes281;
    private String _methodName286;
    private String[] _methodParameterTypes286;
    private String _methodName287;
    private String[] _methodParameterTypes287;

    public LFTincanLrsSubStatementLocalServiceClpInvoker() {
        _methodName0 = "addLFTincanLrsSubStatement";

        _methodParameterTypes0 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement"
            };

        _methodName1 = "createLFTincanLrsSubStatement";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteLFTincanLrsSubStatement";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteLFTincanLrsSubStatement";

        _methodParameterTypes3 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement"
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

        _methodName10 = "fetchLFTincanLrsSubStatement";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getLFTincanLrsSubStatement";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getLFTincanLrsSubStatements";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getLFTincanLrsSubStatementsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateLFTincanLrsSubStatement";

        _methodParameterTypes15 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement"
            };

        _methodName280 = "getBeanIdentifier";

        _methodParameterTypes280 = new String[] {  };

        _methodName281 = "setBeanIdentifier";

        _methodParameterTypes281 = new String[] { "java.lang.String" };

        _methodName286 = "removeAll";

        _methodParameterTypes286 = new String[] {  };

        _methodName287 = "createLFTincanLrsSubStatement";

        _methodParameterTypes287 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.addLFTincanLrsSubStatement((com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.createLFTincanLrsSubStatement(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.deleteLFTincanLrsSubStatement(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.deleteLFTincanLrsSubStatement((com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.fetchLFTincanLrsSubStatement(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.getLFTincanLrsSubStatement(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.getLFTincanLrsSubStatements(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.getLFTincanLrsSubStatementsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.updateLFTincanLrsSubStatement((com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement) arguments[0]);
        }

        if (_methodName280.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes280, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName281.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes281, parameterTypes)) {
            LFTincanLrsSubStatementLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName286.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes286, parameterTypes)) {
            LFTincanLrsSubStatementLocalServiceUtil.removeAll();

            return null;
        }

        if (_methodName287.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes287, parameterTypes)) {
            return LFTincanLrsSubStatementLocalServiceUtil.createLFTincanLrsSubStatement();
        }

        throw new UnsupportedOperationException();
    }
}
