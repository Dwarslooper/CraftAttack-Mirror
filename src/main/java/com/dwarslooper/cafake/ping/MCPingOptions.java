package com.dwarslooper.cafake.ping;


import com.google.common.base.Charsets;
import lombok.Builder;
import lombok.Getter;

@Builder
public class MCPingOptions {

    @Getter
    private String hostname;

    @Getter
    @Builder.Default
    private String charset = Charsets.UTF_8.displayName();

    @Getter
    @Builder.Default
    private int port = 25565;

    @Getter
    @Builder.Default
    private int timeout = 5000;

    @Getter
    @Builder.Default
    private int protocolVersion = 4;

}
