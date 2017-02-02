package com.f2prateek.rx.receivers.bluetooth;

import android.bluetooth.BluetoothAdapter;

public enum BluetoothState {
    STATE_CONNECTED, STATE_CONNECTING, STATE_DISCONNECTED, STATE_OFF, STATE_ON, STATE_TURNING_OFF, STATE_TURNING_ON, UNKNOWN;

    static BluetoothState of(int state) {
        switch (state) {
            case BluetoothAdapter.STATE_CONNECTED:
                return STATE_CONNECTED;
            case BluetoothAdapter.STATE_CONNECTING:
                return STATE_CONNECTING;
            case BluetoothAdapter.STATE_DISCONNECTED:
                return STATE_DISCONNECTED;
            case BluetoothAdapter.STATE_OFF:
                return STATE_OFF;
            case BluetoothAdapter.STATE_ON:
                return STATE_ON;
            case BluetoothAdapter.STATE_TURNING_OFF:
                return STATE_TURNING_OFF;
            case BluetoothAdapter.STATE_TURNING_ON:
                return STATE_TURNING_ON;
            default:
                return UNKNOWN;
        }
    }
}
