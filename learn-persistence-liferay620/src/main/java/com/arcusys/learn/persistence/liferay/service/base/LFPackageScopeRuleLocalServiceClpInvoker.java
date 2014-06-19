package com.arcusys.learn.persistence.liferay.service.base;

import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFPackageScopeRuleLocalServiceClpInvoker {
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
    private String _methodName296;
    private String[] _methodParameterTypes296;
    private String _methodName297;
    private String[] _methodParameterTypes297;
    private String _methodName302;
    private String[] _methodParameterTypes302;
    private String _methodName303;
    private String[] _methodParameterTypes303;
    private String _methodName304;
    private String[] _methodParameterTypes304;
    private String _methodName305;
    private String[] _methodParameterTypes305;
    private String _methodName306;
    private String[] _methodParameterTypes306;
    private String _methodName307;
    private String[] _methodParameterTypes307;
    private String _methodName308;
    private String[] _methodParameterTypes308;
    private String _methodName309;
    private String[] _methodParameterTypes309;
    private String _methodName310;
    private String[] _methodParameterTypes310;
    private String _methodName311;
    private String[] _methodParameterTypes311;
    private String _methodName312;
    private String[] _methodParameterTypes312;

    public LFPackageScopeRuleLocalServiceClpInvoker() {
        _methodName0 = "addLFPackageScopeRule";

        _methodParameterTypes0 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule"
            };

        _methodName1 = "createLFPackageScopeRule";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteLFPackageScopeRule";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteLFPackageScopeRule";

        _methodParameterTypes3 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule"
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

        _methodName10 = "fetchLFPackageScopeRule";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getLFPackageScopeRule";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getLFPackageScopeRules";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getLFPackageScopeRulesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateLFPackageScopeRule";

        _methodParameterTypes15 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule"
            };

        _methodName296 = "getBeanIdentifier";

        _methodParameterTypes296 = new String[] {  };

        _methodName297 = "setBeanIdentifier";

        _methodParameterTypes297 = new String[] { "java.lang.String" };

        _methodName302 = "createLFPackageScopeRule";

        _methodParameterTypes302 = new String[] {  };

        _methodName303 = "findByPackageID";

        _methodParameterTypes303 = new String[] { "java.lang.Integer" };

        _methodName304 = "findByScopeAndIsDefault";

        _methodParameterTypes304 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.Boolean"
            };

        _methodName305 = "findByScope";

        _methodParameterTypes305 = new String[] {
                "java.lang.String", "java.lang.String"
            };

        _methodName306 = "findByPackageIDAndScope";

        _methodParameterTypes306 = new String[] {
                "java.lang.Integer", "java.lang.String", "java.lang.String"
            };

        _methodName307 = "fetchByPackageIDAndScope";

        _methodParameterTypes307 = new String[] {
                "java.lang.Integer", "java.lang.String", "java.lang.String"
            };

        _methodName308 = "findByAllByPackageIDAndScope";

        _methodParameterTypes308 = new String[] {
                "java.lang.Integer", "java.lang.String", "java.lang.String"
            };

        _methodName309 = "findByVisibility";

        _methodParameterTypes309 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.Boolean"
            };

        _methodName310 = "removeByPackageID";

        _methodParameterTypes310 = new String[] { "java.lang.Integer" };

        _methodName311 = "removeAll";

        _methodParameterTypes311 = new String[] {  };

        _methodName312 = "getLFPackageScopeRule";

        _methodParameterTypes312 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.addLFPackageScopeRule((com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.createLFPackageScopeRule(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.deleteLFPackageScopeRule(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.deleteLFPackageScopeRule((com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.fetchLFPackageScopeRule(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getLFPackageScopeRule(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getLFPackageScopeRules(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getLFPackageScopeRulesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.updateLFPackageScopeRule((com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule) arguments[0]);
        }

        if (_methodName296.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes296, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName297.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes297, parameterTypes)) {
            LFPackageScopeRuleLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName302.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes302, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.createLFPackageScopeRule();
        }

        if (_methodName303.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes303, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByPackageID((java.lang.Integer) arguments[0]);
        }

        if (_methodName304.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes304, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByScopeAndIsDefault((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.Boolean) arguments[2]);
        }

        if (_methodName305.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes305, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByScope((java.lang.String) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName306.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes306, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByPackageIDAndScope((java.lang.Integer) arguments[0],
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName307.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes307, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.fetchByPackageIDAndScope((java.lang.Integer) arguments[0],
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName308.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes308, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByAllByPackageIDAndScope((java.lang.Integer) arguments[0],
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName309.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes309, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByVisibility((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.Boolean) arguments[2]);
        }

        if (_methodName310.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes310, parameterTypes)) {
            LFPackageScopeRuleLocalServiceUtil.removeByPackageID((java.lang.Integer) arguments[0]);

            return null;
        }

        if (_methodName311.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes311, parameterTypes)) {
            LFPackageScopeRuleLocalServiceUtil.removeAll();

            return null;
        }

        if (_methodName312.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes312, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getLFPackageScopeRule(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
