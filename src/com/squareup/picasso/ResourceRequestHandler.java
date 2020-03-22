/**
  * Generated by smali2java 1.0.0.558
  * Copyright (C) 2013 Hensence.com
  */

package com.squareup.picasso;

import java.io.IOException;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;

class ResourceRequestHandler extends RequestHandler {
    private final Context context;
    
    ResourceRequestHandler(Context p1) {
        context = p1;
    }
    
    public boolean canHandleRequest(Request p1) {
        if(p1.resourceId != 0) {
            return true;
        }
        return "android.resource".equals(p1.uri.getScheme());
    }
    
    public RequestHandler.Result load(Request p1, int p2) throws IOException {
        // :( Parsing error. Please contact me.
    }
    
    private static Bitmap decodeResource(Resources p1, int p2, Request p3) {
        // :( Parsing error. Please contact me.
    }
}