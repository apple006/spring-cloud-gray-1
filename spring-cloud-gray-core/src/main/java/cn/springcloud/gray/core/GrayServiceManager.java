package cn.springcloud.gray.core;

import java.util.Collection;


/**
 * 灰度服务管理类，属于服务端的类。主要是编辑服务实例，编辑灰度策略，以及维护最新的灰度列表。
 */
public interface GrayServiceManager {

    void addGrayInstance(GrayInstance instance);

    void deleteGrayInstance(String serviceId, String instanceId);

    void addGrayPolicy(String serviceId, String instanceId, String policyGroupId, GrayPolicy policy);

    void deleteGrayPolicy(String serviceId, String instanceId, String policyGroupId, String policyId);

    void addGrayPolicyGroup(String serviceId, String instanceId, GrayPolicyGroup policyGroup);

    void deleteGrayPolicyGroup(String serviceId, String instanceId, String policyGroupId);

    Collection<GrayService> allGrayService();

    GrayService getGrayService(String serviceId);

    GrayInstance getGrayInstane(String serviceId, String instanceId);


    /**
     * 更新实例实例灰度状态
     *
     * @param serviceId
     * @param instanceId
     * @param status     0:关闭, 1:启用
     * @return
     */
    boolean updateInstanceStatus(String serviceId, String instanceId, int status);


    /**
     * 更新实例策略组启用状态
     *
     * @param serviceId
     * @param instanceId
     * @param groupId
     * @param enable     0:关闭, 1:启用
     */
    boolean updatePolicyGroupStatus(String serviceId, String instanceId, String groupId, int enable);

    /**
     * 打开检查
     */
    void openForWork();


    void shutdown();
}
