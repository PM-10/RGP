package com.pm10.rgptest.util;

import android.text.TextUtils;

import okhttp3.Headers;

public class PageLinks {
    private static final String HEADER_LINK = "Link";
    private static final String META_REL_NEXT = "rel=\"next\"";


    public static boolean hasNextPage(Headers headers) {
        boolean hasNext = false;

        try {
            if (headers != null) {
                String linkHeader = headers.get(HEADER_LINK);
                if (!TextUtils.isEmpty(linkHeader)) {
                    hasNext = linkHeader.contains(META_REL_NEXT);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasNext;
    }
}
