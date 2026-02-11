package com.Luis.mobilesync;
import android.content.Context;

private final SyncEngine syncEngine;


public class ContextMonitor {

    private final SignalSensor signalSensor;
    private final WifiSensor wifiSensor;
    private final BatterySensor batterySensor;
    private final MotionSensor motionSensor;
    private final DecisionMaker decisionMaker;

    public ContextMonitor(Context context) {
        signalSensor = new SignalSensor(context);
        wifiSensor = new WifiSensor(context);
        batterySensor = new BatterySensor(context);
        motionSensor = new MotionSensor(context);
        decisionMaker = new DecisionMaker();
    }

    public void monitorCycle() {
        ContextData context = new ContextData();
        context.signal = signalSensor.getSignalStrength();
        context.wifi = wifiSensor.getWifiStrength();
        context.battery = batterySensor.getBatteryLevel();
        context.motion = motionSensor.getMotionState();

        String decision = decisionMaker.analyze(context);

        String decision = decisionMaker.analyze(context);
        syncEngine.performSync(decision);

    }
}
