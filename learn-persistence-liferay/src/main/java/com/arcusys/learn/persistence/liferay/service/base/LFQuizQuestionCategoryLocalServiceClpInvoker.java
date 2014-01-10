package com.arcusys.learn.persistence.liferay.service.base;

import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalServiceUtil;

import java.util.Arrays;


public class LFQuizQuestionCategoryLocalServiceClpInvoker {
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
    private String _methodName264;
    private String[] _methodParameterTypes264;
    private String _methodName265;
    private String[] _methodParameterTypes265;
    private String _methodName270;
    private String[] _methodParameterTypes270;
    private String _methodName271;
    private String[] _methodParameterTypes271;
    private String _methodName272;
    private String[] _methodParameterTypes272;
    private String _methodName273;
    private String[] _methodParameterTypes273;
    private String _methodName274;
    private String[] _methodParameterTypes274;

    public LFQuizQuestionCategoryLocalServiceClpInvoker() {
        _methodName0 = "addLFQuizQuestionCategory";

        _methodParameterTypes0 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory"
            };

        _methodName1 = "createLFQuizQuestionCategory";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteLFQuizQuestionCategory";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteLFQuizQuestionCategory";

        _methodParameterTypes3 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory"
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

        _methodName9 = "fetchLFQuizQuestionCategory";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getLFQuizQuestionCategory";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getLFQuizQuestionCategories";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getLFQuizQuestionCategoriesCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateLFQuizQuestionCategory";

        _methodParameterTypes14 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory"
            };

        _methodName15 = "updateLFQuizQuestionCategory";

        _methodParameterTypes15 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory",
                "boolean"
            };

        _methodName264 = "getBeanIdentifier";

        _methodParameterTypes264 = new String[] {  };

        _methodName265 = "setBeanIdentifier";

        _methodParameterTypes265 = new String[] { "java.lang.String" };

        _methodName270 = "createLFQuizQuestionCategory";

        _methodParameterTypes270 = new String[] {  };

        _methodName271 = "findByQuizIdAndParentId";

        _methodParameterTypes271 = new String[] {
                "java.lang.Integer", "java.lang.Integer"
            };

        _methodName272 = "findByQuizId";

        _methodParameterTypes272 = new String[] { "java.lang.Integer" };

        _methodName273 = "removeAll";

        _methodParameterTypes273 = new String[] {  };

        _methodName274 = "getLFQuizQuestionCategory";

        _methodParameterTypes274 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.addLFQuizQuestionCategory((com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.createLFQuizQuestionCategory(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.deleteLFQuizQuestionCategory(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.deleteLFQuizQuestionCategory((com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.fetchLFQuizQuestionCategory(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.getLFQuizQuestionCategory(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.getLFQuizQuestionCategories(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.getLFQuizQuestionCategoriesCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.updateLFQuizQuestionCategory((com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.updateLFQuizQuestionCategory((com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName264.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes264, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName265.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes265, parameterTypes)) {
            LFQuizQuestionCategoryLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName270.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes270, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.createLFQuizQuestionCategory();
        }

        if (_methodName271.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes271, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.findByQuizIdAndParentId((java.lang.Integer) arguments[0],
                (java.lang.Integer) arguments[1]);
        }

        if (_methodName272.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes272, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.findByQuizId((java.lang.Integer) arguments[0]);
        }

        if (_methodName273.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes273, parameterTypes)) {
            LFQuizQuestionCategoryLocalServiceUtil.removeAll();

            return null;
        }

        if (_methodName274.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes274, parameterTypes)) {
            return LFQuizQuestionCategoryLocalServiceUtil.getLFQuizQuestionCategory(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
