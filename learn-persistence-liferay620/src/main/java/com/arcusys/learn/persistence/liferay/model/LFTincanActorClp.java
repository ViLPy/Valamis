package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class LFTincanActorClp extends BaseModelImpl<LFTincanActor>
    implements LFTincanActor {
    private long _id;
    private String _tincanID;
    private String _objectType;
    private String _name;
    private String _mbox;
    private String _mbox_sha1sum;
    private String _openid;
    private String _account;
    private String _memberOf;
    private BaseModel<?> _lfTincanActorRemoteModel;

    public LFTincanActorClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanActor.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanActor.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("tincanID", getTincanID());
        attributes.put("objectType", getObjectType());
        attributes.put("name", getName());
        attributes.put("mbox", getMbox());
        attributes.put("mbox_sha1sum", getMbox_sha1sum());
        attributes.put("openid", getOpenid());
        attributes.put("account", getAccount());
        attributes.put("memberOf", getMemberOf());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String tincanID = (String) attributes.get("tincanID");

        if (tincanID != null) {
            setTincanID(tincanID);
        }

        String objectType = (String) attributes.get("objectType");

        if (objectType != null) {
            setObjectType(objectType);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String mbox = (String) attributes.get("mbox");

        if (mbox != null) {
            setMbox(mbox);
        }

        String mbox_sha1sum = (String) attributes.get("mbox_sha1sum");

        if (mbox_sha1sum != null) {
            setMbox_sha1sum(mbox_sha1sum);
        }

        String openid = (String) attributes.get("openid");

        if (openid != null) {
            setOpenid(openid);
        }

        String account = (String) attributes.get("account");

        if (account != null) {
            setAccount(account);
        }

        String memberOf = (String) attributes.get("memberOf");

        if (memberOf != null) {
            setMemberOf(memberOf);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanActorRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActorRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanActorRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTincanID() {
        return _tincanID;
    }

    @Override
    public void setTincanID(String tincanID) {
        _tincanID = tincanID;

        if (_lfTincanActorRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActorRemoteModel.getClass();

                Method method = clazz.getMethod("setTincanID", String.class);

                method.invoke(_lfTincanActorRemoteModel, tincanID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getObjectType() {
        return _objectType;
    }

    @Override
    public void setObjectType(String objectType) {
        _objectType = objectType;

        if (_lfTincanActorRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActorRemoteModel.getClass();

                Method method = clazz.getMethod("setObjectType", String.class);

                method.invoke(_lfTincanActorRemoteModel, objectType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_lfTincanActorRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActorRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_lfTincanActorRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMbox() {
        return _mbox;
    }

    @Override
    public void setMbox(String mbox) {
        _mbox = mbox;

        if (_lfTincanActorRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActorRemoteModel.getClass();

                Method method = clazz.getMethod("setMbox", String.class);

                method.invoke(_lfTincanActorRemoteModel, mbox);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMbox_sha1sum() {
        return _mbox_sha1sum;
    }

    @Override
    public void setMbox_sha1sum(String mbox_sha1sum) {
        _mbox_sha1sum = mbox_sha1sum;

        if (_lfTincanActorRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActorRemoteModel.getClass();

                Method method = clazz.getMethod("setMbox_sha1sum", String.class);

                method.invoke(_lfTincanActorRemoteModel, mbox_sha1sum);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOpenid() {
        return _openid;
    }

    @Override
    public void setOpenid(String openid) {
        _openid = openid;

        if (_lfTincanActorRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActorRemoteModel.getClass();

                Method method = clazz.getMethod("setOpenid", String.class);

                method.invoke(_lfTincanActorRemoteModel, openid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAccount() {
        return _account;
    }

    @Override
    public void setAccount(String account) {
        _account = account;

        if (_lfTincanActorRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActorRemoteModel.getClass();

                Method method = clazz.getMethod("setAccount", String.class);

                method.invoke(_lfTincanActorRemoteModel, account);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMemberOf() {
        return _memberOf;
    }

    @Override
    public void setMemberOf(String memberOf) {
        _memberOf = memberOf;

        if (_lfTincanActorRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActorRemoteModel.getClass();

                Method method = clazz.getMethod("setMemberOf", String.class);

                method.invoke(_lfTincanActorRemoteModel, memberOf);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanActorRemoteModel() {
        return _lfTincanActorRemoteModel;
    }

    public void setLFTincanActorRemoteModel(
        BaseModel<?> lfTincanActorRemoteModel) {
        _lfTincanActorRemoteModel = lfTincanActorRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _lfTincanActorRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_lfTincanActorRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanActorLocalServiceUtil.addLFTincanActor(this);
        } else {
            LFTincanActorLocalServiceUtil.updateLFTincanActor(this);
        }
    }

    @Override
    public LFTincanActor toEscapedModel() {
        return (LFTincanActor) ProxyUtil.newProxyInstance(LFTincanActor.class.getClassLoader(),
            new Class[] { LFTincanActor.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanActorClp clone = new LFTincanActorClp();

        clone.setId(getId());
        clone.setTincanID(getTincanID());
        clone.setObjectType(getObjectType());
        clone.setName(getName());
        clone.setMbox(getMbox());
        clone.setMbox_sha1sum(getMbox_sha1sum());
        clone.setOpenid(getOpenid());
        clone.setAccount(getAccount());
        clone.setMemberOf(getMemberOf());

        return clone;
    }

    @Override
    public int compareTo(LFTincanActor lfTincanActor) {
        long primaryKey = lfTincanActor.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanActorClp)) {
            return false;
        }

        LFTincanActorClp lfTincanActor = (LFTincanActorClp) obj;

        long primaryKey = lfTincanActor.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", tincanID=");
        sb.append(getTincanID());
        sb.append(", objectType=");
        sb.append(getObjectType());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", mbox=");
        sb.append(getMbox());
        sb.append(", mbox_sha1sum=");
        sb.append(getMbox_sha1sum());
        sb.append(", openid=");
        sb.append(getOpenid());
        sb.append(", account=");
        sb.append(getAccount());
        sb.append(", memberOf=");
        sb.append(getMemberOf());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFTincanActor");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tincanID</column-name><column-value><![CDATA[");
        sb.append(getTincanID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectType</column-name><column-value><![CDATA[");
        sb.append(getObjectType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mbox</column-name><column-value><![CDATA[");
        sb.append(getMbox());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mbox_sha1sum</column-name><column-value><![CDATA[");
        sb.append(getMbox_sha1sum());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>openid</column-name><column-value><![CDATA[");
        sb.append(getOpenid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>account</column-name><column-value><![CDATA[");
        sb.append(getAccount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>memberOf</column-name><column-value><![CDATA[");
        sb.append(getMemberOf());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
