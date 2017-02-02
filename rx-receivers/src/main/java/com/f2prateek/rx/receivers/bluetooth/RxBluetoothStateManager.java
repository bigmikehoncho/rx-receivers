package com.f2prateek.rx.receivers.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.f2prateek.rx.receivers.RxBroadcastReceiver;

import rx.Observable;
import rx.functions.Func1;

import static com.f2prateek.rx.receivers.internal.Preconditions.checkNotNull;

public class RxBluetoothStateManager {

    private RxBluetoothStateManager() {
        throw new AssertionError("no instances");
    }

    @CheckResult
    @NonNull //
    public static Observable<BluetoothState> bluetoothStateChanges(@NonNull final Context context) {
        checkNotNull(context, "context == null");
        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        return RxBroadcastReceiver.create(context, filter).map(new Func1<Intent, BluetoothState>() {
            @Override public BluetoothState call(Intent intent) {
                return BluetoothState.of(intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                        BluetoothAdapter.ERROR));
            }
        });
    }
}
