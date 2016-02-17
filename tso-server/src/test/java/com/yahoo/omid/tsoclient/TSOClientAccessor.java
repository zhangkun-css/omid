package com.yahoo.omid.tsoclient;

import com.yahoo.omid.tsoclient.TSOClient.ConnectedState;
import com.yahoo.statemachine.StateMachine.FsmImpl;

public class TSOClientAccessor {

    public static void closeChannel(TSOClient tsoClient) throws InterruptedException {
        FsmImpl fsm = (FsmImpl) tsoClient.fsm;
        ConnectedState connectedState = (ConnectedState) fsm.getState();
        connectedState.channel.close().await();
    }
}
