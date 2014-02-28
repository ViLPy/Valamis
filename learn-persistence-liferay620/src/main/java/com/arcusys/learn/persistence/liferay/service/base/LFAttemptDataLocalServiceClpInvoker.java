package com.arcusys.learn.persistence.liferay.service.base;

import com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFAttemptDataLocalServiceClpInvoker {
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
    private String _methodName292;
    private String[] _methodParameterTypes292;

    public LFAttemptDataLocalServiceClpInvoker() {
        _methodName0 = "addLFAttemptData";

        _methodParameterTypes0 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFAttemptData"
            };

        _methodName1 = "createLFAttemptData";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteLFAttemptData";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteLFAttemptData";

        _methodParameterTypes3 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFAttemptData"
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

        _methodName10 = "fetchLFAttemptData";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getLFAttemptData";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getLFAttemptDatas";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getLFAttemptDatasCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateLFAttemptData";

        _methodParameterTypes15 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFAttemptData"
            };

        _methodName280 = "getBeanIdentifier";

        _methodParameterTypes280 = new String[] {  };

        _methodName281 = "setBeanIdentifier";

        _methodParameterTypes281 = new String[] { "java.lang.String" };

        _methodName286 = "createLFAttemptData";

        _methodParameterTypes286 = new String[] {  };

        _methodName287 = "findByAttemptIDWithActivityID";

        _methodParameterTypes287 = new String[] {
                "java.lang.Integer", "java.lang.String"
            };

        _methodName288 = "findByAttemptIDWithDataKey";

        _methodParameterTypes288 = new String[] {
                "java.lang.Integer", "java.lang.String"
            };

        _methodName289 = "findBySingleKey";

        _methodParameterTypes289 = new String[] {
                "java.lang.Integer", "java.lang.String", "java.lang.String",
                "int", "int"
            };

        _methodName290 = "findByCollectionValues";

        _methodParameterTypes290 = new String[] {
                "java.lang.Integer", "java.lang.String", "java.lang.String"
            };

        _methodName291 = "removeAll";

        _methodParameterTypes291 = new String[] {  };

        _methodName292 = "getLFAttemptData";

        _methodParameterTypes292 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.addLFAttemptData((com.arcusys.learn.persistence.liferay.model.LFAttemptData) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.createLFAttemptData(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.deleteLFAttemptData(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.deleteLFAttemptData((com.arcusys.learn.persistence.liferay.model.LFAttemptData) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.fetchLFAttemptData(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.getLFAttemptData(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.getLFAttemptDatas(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.getLFAttemptDatasCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.updateLFAttemptData((com.arcusys.learn.persistence.liferay.model.LFAttemptData) arguments[0]);
        }

        if (_methodName280.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes280, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName281.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes281, parameterTypes)) {
            LFAttemptDataLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName286.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes286, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.createLFAttemptData();
        }

        if (_methodName287.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes287, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.findByAttemptIDWithActivityID((java.lang.Integer) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName288.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes288, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.findByAttemptIDWithDataKey((java.lang.Integer) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName289.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes289, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.findBySingleKey((java.lang.Integer) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                ((Integer) arguments[3]).intValue(),
                ((Integer) arguments[4]).intValue());
        }

        if (_methodName290.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes290, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.findByCollectionValues((java.lang.Integer) arguments[0],
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName291.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes291, parameterTypes)) {
            LFAttemptDataLocalServiceUtil.removeAll();

            return null;
        }

        if (_methodName292.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes292, parameterTypes)) {
            return LFAttemptDataLocalServiceUtil.getLFAttemptData(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
