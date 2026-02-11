package com.Luis.mobilesync;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.SignalStrength;
import android.telephony.PhoneStateListener;


public class SignalSensor {
    private int lastSignal = 0;

    public SignalSensor(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(new PhoneStateListener() {
            @Override
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                super.onSignalStrengthsChanged(signalStrength);
                lastSignal = signalStrength.getGsmSignalStrength();
            }
        }, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
    }

    public int getSignalStrength() {
        return lastSignal;
    }
}