package com.dwarslooper.cafake.ping;


import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@ToString
public class MCPingResponse {

    private Description description;

    private Players players;

    private Version version;

    private String favicon;
    @Setter(value = AccessLevel.PACKAGE)
    private long ping;

    @Setter(value = AccessLevel.PACKAGE)
    private String hostname;

    @Setter(value = AccessLevel.PACKAGE)
    private long port;


    @Getter
    @ToString
    public class Description {

        private String text;

        public String getStrippedText() {
            return MCPingUtil.stripColors(this.text);
        }

    }

    @Getter
    @ToString
    public class Players {

        private int max;

        private int online;

        private List<Player> sample;

    }

    @Getter
    @ToString
    public class Player {

        private String name;

        private String id;

    }

    @Getter
    @ToString
    public class Version {

        private String name;
        private int protocol;

    }

}
