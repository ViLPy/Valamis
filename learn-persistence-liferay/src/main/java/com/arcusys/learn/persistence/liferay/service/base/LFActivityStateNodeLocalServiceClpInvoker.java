package com.arcusys.learn.persistence.liferay.service.base;

import com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalServiceUtil;

import java.util.Arrays;


public class LFActivityStateNodeLocalServiceClpInvoker {
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
    private String _methodName192;
    private String[] _methodParameterTypes192;
    private String _methodName193;
    private String[] _methodParameterTypes193;
    private String _methodName198;
    private String[] _methodParameterTypes198;
    private String _methodName199;
    private String[] _methodParameterTypes199;
    private String _methodName200;
    private String[] _methodParameterTypes200;
    private String _methodName201;
    private String[] _methodParameterTypes201;
    private String _methodName202;
    private String[] _methodParameterTypes202;

    public LFActivityStateNodeLocalServiceClpInvoker() {
        _methodName0 = "addLFActivityStateNode";

        _methodParameterTypes0 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFActivityStateNode"
            };

        _methodName1 = "createLFActivityStateNode";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteLFActivityStateNode";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteLFActivityStateNode";

        _methodParameterTypes3 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFActivityStateNode"
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

        _methodName9 = "fetchLFActivityStateNode";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getLFActivityStateNode";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getLFActivityStateNodes";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getLFActivityStateNodesCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateLFActivityStateNode";

        _methodParameterTypes14 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFActivityStateNode"
            };

        _methodName15 = "updateLFActivityStateNode";

        _methodParameterTypes15 = new String[] {
                "com.arcusys.learn.persistence.liferay.model.LFActivityStateNode",
                "boolean"
            };

        _methodName192 = "getBeanIdentifier";

        _methodParameterTypes192 = new String[] {  };

        _methodName193 = "setBeanIdentifier";

        _methodParameterTypes193 = new String[] { "java.lang.String" };

        _methodName198 = "createLFActivityStateNode";

        _methodParameterTypes198 = new String[] {  };

        _methodName199 = "findByTreeID";

        _methodParameterTypes199 = new String[] { "java.lang.Integer" };

        _methodName200 = "findByTreeIDAndParentID";

        _methodParameterTypes200 = new String[] {
                "java.lang.Integer", "java.lang.Integer"
            };

        _methodName201 = "removeAll";

        _methodParameterTypes201 = new String[] {  };

        _methodName202 = "getLFActivityStateNode";

        _methodParameterTypes202 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.addLFActivityStateNode((com.arcusys.learn.persistence.liferay.model.LFActivityStateNode) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.createLFActivityStateNode(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.deleteLFActivityStateNode(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.deleteLFActivityStateNode((com.arcusys.learn.persistence.liferay.model.LFActivityStateNode) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.fetchLFActivityStateNode(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.getLFActivityStateNode(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.getLFActivityStateNodes(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.getLFActivityStateNodesCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.updateLFActivityStateNode((com.arcusys.learn.persistence.liferay.model.LFActivityStateNode) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.updateLFActivityStateNode((com.arcusys.learn.persistence.liferay.model.LFActivityStateNode) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName192.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName193.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
            LFActivityStateNodeLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName198.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.createLFActivityStateNode();
        }

        if (_methodName199.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.findByTreeID((java.lang.Integer) arguments[0]);
        }

        if (_methodName200.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.findByTreeIDAndParentID((java.lang.Integer) arguments[0],
                (java.lang.Integer) arguments[1]);
        }

        if (_methodName201.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
            LFActivityStateNodeLocalServiceUtil.removeAll();

            return null;
        }

        if (_methodName202.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
            return LFActivityStateNodeLocalServiceUtil.getLFActivityStateNode(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
