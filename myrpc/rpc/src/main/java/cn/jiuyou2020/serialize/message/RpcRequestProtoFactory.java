package cn.jiuyou2020.serialize.message;

import cn.jiuyou2020.proxy.FeignClientFactoryBean;
import cn.jiuyou2020.serialize.SerializationFacade;
import cn.jiuyou2020.serialize.SerializationType;

import java.lang.reflect.Method;

/**
 * @author: jiuyou2020
 * @description:
 */
public class RpcRequestProtoFactory extends RpcRequestFactory {

    @Override
    public RpcRequest createRpcRequest(Method method, Object[] args, FeignClientFactoryBean clientFactoryBean) throws Exception {
        RpcRequestOuterClass.RpcRequestProto.Builder requestBuilder = RpcRequestOuterClass.RpcRequestProto.newBuilder();
        String className = clientFactoryBean.getType().getName();
        String methodName = method.getName();
        requestBuilder.setClassName(className);
        requestBuilder.setMethodName(methodName);
        for (Class<?> parameterType : method.getParameterTypes()) {
            requestBuilder.addParameterTypes(parameterType.getName());
        }
        if (args != null) {
            for (Object arg : args) {
                byte[] serialize = SerializationFacade.getStrategy(SerializationType.JSON).serialize(arg);
                requestBuilder.addParameters(com.google.protobuf.ByteString.copyFrom(serialize));
            }
        }

        return new ProtobufRpcRequest(requestBuilder.build());
    }
}
