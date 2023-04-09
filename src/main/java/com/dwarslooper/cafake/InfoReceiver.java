package com.dwarslooper.cafake;

import com.dwarslooper.cafake.ping.MCPingResponse;

public class InfoReceiver {

    public static MCPingResponse currentData;

    public static MCPingResponse getCurrentData() {
        return currentData;
    }

    public static void setCurrentData(MCPingResponse currentData) {
        InfoReceiver.currentData = currentData;
    }
}
