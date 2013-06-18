package com.arcusys.learn.persistence.liferay.service.base;

import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil;

import java.util.Arrays;


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
    private String _methodName164;
    private String[] _methodParameterTypes164;
    private String _methodName165;
    private String[] _methodParameterTypes165;
    private String _methodName170;
    private String[] _methodParameterTypes170;
    private String _methodName171;
    private String[] _methodParameterTypes171;
    private String _methodName172;
    private String[] _methodParameterTypes172;
    private String _methodName173;
    private String[] _methodParameterTypes173;
    private String _methodName174;
    private String[] _methodParameterTypes174;
    private String _methodName175;
    private String[] _methodParameterTypes175;
    private String _methodName176;
    private String[] _methodParameterTypes176;
    private String _methodName177;
    private String[] _methodParameterTypes177;
    private String _methodName178;
    private String[] _methodParameterTypes178;
    private String _methodName179;
    private String[] _methodParameterTypes179;
    private String _methodName180;
    private String[] _methodParameterTypes180;

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

        _methodName9 = "fetchLFPackageScopeRule";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getLFPackageScopeRule";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getLFPackageScopeRules";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getLFPackageScopeRulesCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateLFPackageScopeRule";

        _methodParameterTypes14 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule"
            };

        _methodName15 = "updateLFPackageScopeRule";

        _methodParameterTypes15 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule",
                "boolean"
            };

        _methodName164 = "getBeanIdentifier";

        _methodParameterTypes164 = new String[] {  };

        _methodName165 = "setBeanIdentifier";

        _methodParameterTypes165 = new String[] { "java.lang.String" };

        _methodName170 = "createLFPackageScopeRule";

        _methodParameterTypes170 = new String[] {  };

        _methodName171 = "findByPackageID";

        _methodParameterTypes171 = new String[] { "java.lang.Integer" };

        _methodName172 = "findByScopeAndIsDefault";

        _methodParameterTypes172 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.Boolean"
            };

        _methodName173 = "findByScope";

        _methodParameterTypes173 = new String[] {
                "java.lang.String", "java.lang.String"
            };

        _methodName174 = "findByPackageIDAndScope";

        _methodParameterTypes174 = new String[] {
                "java.lang.Integer", "java.lang.String", "java.lang.String"
            };

        _methodName175 = "fetchByPackageIDAndScope";

        _methodParameterTypes175 = new String[] {
                "java.lang.Integer", "java.lang.String", "java.lang.String"
            };

        _methodName176 = "findByAllByPackageIDAndScope";

        _methodParameterTypes176 = new String[] {
                "java.lang.Integer", "java.lang.String", "java.lang.String"
            };

        _methodName177 = "findByVisibility";

        _methodParameterTypes177 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.Boolean"
            };

        _methodName178 = "removeByPackageID";

        _methodParameterTypes178 = new String[] { "java.lang.Integer" };

        _methodName179 = "removeAll";

        _methodParameterTypes179 = new String[] {  };

        _methodName180 = "getLFPackageScopeRule";

        _methodParameterTypes180 = new String[] { "long" };
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
            return LFPackageScopeRuleLocalServiceUtil.fetchLFPackageScopeRule(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getLFPackageScopeRule(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getLFPackageScopeRules(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getLFPackageScopeRulesCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.updateLFPackageScopeRule((com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.updateLFPackageScopeRule((com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName164.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName165.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
            LFPackageScopeRuleLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName170.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.createLFPackageScopeRule();
        }

        if (_methodName171.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByPackageID((java.lang.Integer) arguments[0]);
        }

        if (_methodName172.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByScopeAndIsDefault((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.Boolean) arguments[2]);
        }

        if (_methodName173.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByScope((java.lang.String) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName174.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByPackageIDAndScope((java.lang.Integer) arguments[0],
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName175.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.fetchByPackageIDAndScope((java.lang.Integer) arguments[0],
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName176.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByAllByPackageIDAndScope((java.lang.Integer) arguments[0],
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName177.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.findByVisibility((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.Boolean) arguments[2]);
        }

        if (_methodName178.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.removeByPackageID((java.lang.Integer) arguments[0]);
        }

        if (_methodName179.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
            LFPackageScopeRuleLocalServiceUtil.removeAll();

            return null;
        }

        if (_methodName180.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
            return LFPackageScopeRuleLocalServiceUtil.getLFPackageScopeRule(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
