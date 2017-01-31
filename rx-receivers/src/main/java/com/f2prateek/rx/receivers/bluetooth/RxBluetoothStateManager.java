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

/**
 * Created by michael on 1/31/2017.
 */

public class RxBluetoothStateManager {

    private RxBluetoothStateManager() {
        throw new AssertionError("no instances");
    }

    @CheckResult
    @NonNull //
    public static Observable<Integer> bluetoothStateChanges(@NonNull final Context context) {
        checkNotNull(context, "context == null");
        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        return RxBroadcastReceiver.create(context, filter).map(new Func1<Intent, Integer>() {
            @Override public Integer call(Intent intent) {
                return intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                        BluetoothAdapter.ERROR);
            }
        });
    }
}
