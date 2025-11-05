package cn.wenzhuo4657.dailyWeb.domain.tell.model.entity;

import cn.wenzhuo4657.dailyWeb.domain.tell.service.strategy.Impl.GmailConfig;

public class GmailConfigDto {
    GmailConfig gmailConfig;

    public GmailConfigDto(GmailConfig gmailConfig) {
        this.gmailConfig = gmailConfig;
    }

    public GmailConfig getGmailConfig() {
        return gmailConfig;
    }

    public void setGmailConfig(GmailConfig gmailConfig) {
        this.gmailConfig = gmailConfig;
    }
}
