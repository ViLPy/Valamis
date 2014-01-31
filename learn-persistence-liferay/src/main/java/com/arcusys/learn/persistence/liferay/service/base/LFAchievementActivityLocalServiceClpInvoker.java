package com.arcusys.learn.persistence.liferay.service.base;

import com.arcusys.learn.persistence.liferay.service.LFAchievementActivityLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFAchievementActivityLocalServiceClpInvoker {
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
    private String _methodName276;
    private String[] _methodParameterTypes276;
    private String _methodName277;
    private String[] _methodParameterTypes277;
    private String _methodName282;
    private String[] _methodParameterTypes282;
    private String _methodName283;
    private String[] _methodParameterTypes283;
    private String _methodName284;
    private String[] _methodParameterTypes284;
    private String _methodName285;
    private String[] _methodParameterTypes285;
    private String _methodName286;
    private String[] _methodParameterTypes286;

    public LFAchievementActivityLocalServiceClpInvoker() {
        _methodName0 = "addLFAchievementActivity";

        _methodParameterTypes0 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFAchievementActivity"
            };

        _methodName1 = "createLFAchievementActivity";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteLFAchievementActivity";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteLFAchievementActivity";

        _methodParameterTypes3 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFAchievementActivity"
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

        _methodName10 = "fetchLFAchievementActivity";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getLFAchievementActivity";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getLFAchievementActivities";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getLFAchievementActivitiesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateLFAchievementActivity";

        _methodParameterTypes15 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFAchievementActivity"
            };

        _methodName276 = "getBeanIdentifier";

        _methodParameterTypes276 = new String[] {  };

        _methodName277 = "setBeanIdentifier";

        _methodParameterTypes277 = new String[] { "java.lang.String" };

        _methodName282 = "findByAchievementId";

        _methodParameterTypes282 = new String[] { "java.lang.Integer" };

        _methodName283 = "findByUserId";

        _methodParameterTypes283 = new String[] { "java.lang.Integer" };

        _methodName284 = "findAll";

        _methodParameterTypes284 = new String[] {  };

        _methodName285 = "findAllByAchievementAndUserId";

        _methodParameterTypes285 = new String[] {
                "java.lang.Integer", "java.lang.Integer"
            };

        _methodName286 = "createLFAchievementActivity";

        _methodParameterTypes286 = new String[] {
                "java.lang.Integer", "java.lang.Integer"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.addLFAchievementActivity((com.arcusys.learn.persistence.liferay.model.LFAchievementActivity) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.createLFAchievementActivity(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.deleteLFAchievementActivity(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.deleteLFAchievementActivity((com.arcusys.learn.persistence.liferay.model.LFAchievementActivity) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.fetchLFAchievementActivity(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.getLFAchievementActivity(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.getLFAchievementActivities(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.getLFAchievementActivitiesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.updateLFAchievementActivity((com.arcusys.learn.persistence.liferay.model.LFAchievementActivity) arguments[0]);
        }

        if (_methodName276.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes276, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName277.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes277, parameterTypes)) {
            LFAchievementActivityLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName282.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes282, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.findByAchievementId((java.lang.Integer) arguments[0]);
        }

        if (_methodName283.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes283, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.findByUserId((java.lang.Integer) arguments[0]);
        }

        if (_methodName284.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes284, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.findAll();
        }

        if (_methodName285.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes285, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.findAllByAchievementAndUserId((java.lang.Integer) arguments[0],
                (java.lang.Integer) arguments[1]);
        }

        if (_methodName286.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes286, parameterTypes)) {
            return LFAchievementActivityLocalServiceUtil.createLFAchievementActivity((java.lang.Integer) arguments[0],
                (java.lang.Integer) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
