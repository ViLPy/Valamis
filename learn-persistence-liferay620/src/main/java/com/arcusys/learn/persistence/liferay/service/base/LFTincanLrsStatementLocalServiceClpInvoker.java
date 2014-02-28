package com.arcusys.learn.persistence.liferay.service.base;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFTincanLrsStatementLocalServiceClpInvoker {
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
    private String _methodName288;
    private String[] _methodParameterTypes288;
    private String _methodName289;
    private String[] _methodParameterTypes289;
    private String _methodName290;
    private String[] _methodParameterTypes290;
    private String _methodName291;
    private String[] _methodParameterTypes291;

    public LFTincanLrsStatementLocalServiceClpInvoker() {
        _methodName0 = "addLFTincanLrsStatement";

        _methodParameterTypes0 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement"
            };

        _methodName1 = "createLFTincanLrsStatement";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteLFTincanLrsStatement";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteLFTincanLrsStatement";

        _methodParameterTypes3 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement"
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

        _methodName10 = "fetchLFTincanLrsStatement";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getLFTincanLrsStatement";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getLFTincanLrsStatements";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getLFTincanLrsStatementsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateLFTincanLrsStatement";

        _methodParameterTypes15 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement"
            };

        _methodName280 = "getBeanIdentifier";

        _methodParameterTypes280 = new String[] {  };

        _methodName281 = "setBeanIdentifier";

        _methodParameterTypes281 = new String[] { "java.lang.String" };

        _methodName286 = "removeAll";

        _methodParameterTypes286 = new String[] {  };

        _methodName287 = "createLFTincanLrsStatement";

        _methodParameterTypes287 = new String[] {  };

        _methodName288 = "findByActorID";

        _methodParameterTypes288 = new String[] { "java.lang.Integer" };

        _methodName289 = "findByVerbID";

        _methodParameterTypes289 = new String[] { "java.lang.String" };

        _methodName290 = "findByObjTypeAndObjID";

        _methodParameterTypes290 = new String[] {
                "java.lang.String", "java.lang.Integer"
            };

        _methodName291 = "findByTincanID";

        _methodParameterTypes291 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.addLFTincanLrsStatement((com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.createLFTincanLrsStatement(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.deleteLFTincanLrsStatement(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.deleteLFTincanLrsStatement((com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.fetchLFTincanLrsStatement(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.getLFTincanLrsStatement(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.getLFTincanLrsStatements(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.getLFTincanLrsStatementsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.updateLFTincanLrsStatement((com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement) arguments[0]);
        }

        if (_methodName280.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes280, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName281.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes281, parameterTypes)) {
            LFTincanLrsStatementLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName286.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes286, parameterTypes)) {
            LFTincanLrsStatementLocalServiceUtil.removeAll();

            return null;
        }

        if (_methodName287.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes287, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.createLFTincanLrsStatement();
        }

        if (_methodName288.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes288, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.findByActorID((java.lang.Integer) arguments[0]);
        }

        if (_methodName289.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes289, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.findByVerbID((java.lang.String) arguments[0]);
        }

        if (_methodName290.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes290, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.findByObjTypeAndObjID((java.lang.String) arguments[0],
                (java.lang.Integer) arguments[1]);
        }

        if (_methodName291.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes291, parameterTypes)) {
            return LFTincanLrsStatementLocalServiceUtil.findByTincanID((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
