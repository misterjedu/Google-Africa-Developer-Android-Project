package com.misterjedu.gaadsleaderboard.helpers;

import android.view.View;

public class PageLoader {

    public static void loadOnline(View onlineView,View offlineView,View loadingView ){
        onlineView.setVisibility(View.VISIBLE);
        offlineView.setVisibility(View.GONE);
        loadingView.setVisibility(View.GONE);
    }

    public static void loadOffline(View onlineView,View offlineView,View loadingView ){
        onlineView.setVisibility(View.GONE);
        offlineView.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);
    }

    public static void loadLoading(View onlineView,View offlineView,View loadingView ){
        onlineView.setVisibility(View.GONE);
        offlineView.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);
    }
}
