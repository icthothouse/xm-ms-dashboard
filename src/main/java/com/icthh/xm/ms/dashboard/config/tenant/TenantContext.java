package com.icthh.xm.ms.dashboard.config.tenant;

import com.icthh.xm.commons.logging.util.MDCUtil;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TenantContext {

    public final static String DEFAULT_TENANT = "XM";

    private static ThreadLocal<TenantInfo> current = ThreadLocal
        .withInitial(() -> new TenantInfo(DEFAULT_TENANT, "", "", "", "","", ""));

    public static void setCurrent(TenantInfo userInfo) {
        current.set(userInfo);
        MDCUtil.putRid(MDCUtil.generateRid() + ":" + userInfo.getUserLogin() + ":" + userInfo.getTenant());
    }

    public static void setCurrent(String tenant) {
        setCurrent(new TenantInfo(tenant, "", "", "", "", "", ""));
    }

    public static TenantInfo getCurrent() {
        return current.get();
    }

    public static void clear() {
        current.remove();
        MDCUtil.clear();
    }

    public static void setCurrentQuite(TenantInfo tenant) {
        current.set(tenant);
    }

    public static void setCurrentQuite(String tenant) {
        setCurrentQuite(new TenantInfo(tenant, "", "", "", "", "", ""));
    }
}
