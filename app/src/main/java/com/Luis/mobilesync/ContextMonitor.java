package com.Luis.mobilesync;
import android.content.Context;
public class ContextMonitor {
    private final SignalSensor signalSensor;
    private final WifiSensor wifiSensor;
    private final BatterySensor batterySensor;
    private final MotionSensor motionSensor;
    private final DecisionMaker decisionMaker;
    private final SyncEngine syncEngine;
    public ContextMonitor(Context context) {
        signalSensor = new SignalSensor(context);
        wifiSensor = new WifiSensor(context);
        batterySensor = new BatterySensor(context);
        motionSensor = new MotionSensor(context);
        decisionMaker = new DecisionMaker();
        syncEngine = new SyncEngine();
    }

    public void monitorCycle() {
        ContextData context = new ContextData();
        context.signal = signalSensor.getSignalStrength();
        context.wifi = wifiSensor.getWifiStrength();
        context.battery = batterySensor.getBatteryLevel();
        context.motion = motionSensor.getMotionState();
        String decision = decisionMaker.analyze(context);
        syncEngine.performSync(decision);
    }
}
