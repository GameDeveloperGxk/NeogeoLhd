/**
  * Generated by smali2java 1.0.0.558
  * Copyright (C) 2013 Hensence.com
  */

package com.squareup.picasso;

import android.widget.RemoteViews;
import android.content.Context;
import android.appwidget.AppWidgetManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;

abstract class RemoteViewsAction extends Action {
    final RemoteViews remoteViews;
    private RemoteViewsAction.RemoteViewsTarget target;
    final int viewId;
    
    abstract void update();
    
    
    RemoteViewsAction(Picasso p1, Request p2, RemoteViews p3, int p4, int p5, int p6, int p7, Object p8, String p9) {
        super(p1, 0x0, p2, p6, p7, p5, 0x0, p9, p8, false);
        remoteViews = p3;
        viewId = p4;
    }
    
    void complete(Bitmap p1, Picasso.LoadedFrom p2) {
        remoteViews.setImageViewBitmap(viewId, p1);
        update();
    }
    
    public void error() {
        if(errorResId != 0) {
            setImageResource(errorResId);
        }
    }
    
    RemoteViewsAction.RemoteViewsTarget getTarget() {
        if(target == null) {
            target = new RemoteViewsAction.RemoteViewsTarget(remoteViews, viewId);
        }
        return target;
    }
    
    void setImageResource(int p1) {
        remoteViews.setImageViewResource(viewId, p1);
        update();
    }
    
    class RemoteViewsTarget {
        final RemoteViews remoteViews;
        final int viewId;
        
        RemoteViewsTarget(RemoteViews p1, int p2) {
            remoteViews = p1;
            viewId = p2;
        }
        
        public boolean equals(Object p1) {
            boolean localconst/41 = this == p1;
            if((p1 == null) || (getClass() != p1.getClass())) {
                return false;
            }
            if((viewId == p1.viewId) && (remoteViews.equals(p1.remoteViews))) {
            }
            return false;
            return false;
        }
        
        public int hashCode() {
            return ((remoteViews.hashCode() * 0x1f) + viewId);
        }
    }
    
    class AppWidgetAction extends RemoteViewsAction {
        private final int[] appWidgetIds;
        
        AppWidgetAction(Picasso p1, Request p2, RemoteViews p3, int p4, int[] p5, int p6, int p7, String p8, Object p9, int p10) {
            super(p1, p2, p3, p4, p10, p6, p7, p9, p8);
            appWidgetIds = p5;
        }
        
        void update() {
            picasso.context = AppWidgetManager.getInstance(picasso.context);
            picasso.context.updateAppWidget(appWidgetIds, remoteViews);
        }
    }
    
    class NotificationAction extends RemoteViewsAction {
        private final Notification notification;
        private final int notificationId;
        
        NotificationAction(Picasso p1, Request p2, RemoteViews p3, int p4, int p5, Notification p6, int p7, int p8, String p9, Object p10, int p11) {
            super(p1, p2, p3, p4, p11, p7, p8, p10, p9);
            notificationId = p5;
            notification = p6;
        }
        
        void update() {
            picasso.context = (NotificationManager)Utils.getService(picasso.context, "notification");
            picasso.context.notify(notificationId, notification);
        }
    }
}