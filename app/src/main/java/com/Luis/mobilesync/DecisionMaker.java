package com.Luis.mobilesync;
public class DecisionMaker {

    public String analyze(ContextData context) {
        if (context.battery < 20) return "LOW_POWER_SYNC";
        if (context.signal < 2 || context.wifi < 3) return "DELAY_SYNC";
        if ("moving".equals(context.motion)) return "REDUCE_DATA_USAGE";
        return "NORMAL_SYNC";
    }
}