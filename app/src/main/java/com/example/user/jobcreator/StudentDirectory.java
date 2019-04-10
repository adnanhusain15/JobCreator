package com.example.user.jobcreator;

import android.net.Uri;
import android.provider.BaseColumns;

public class StudentDirectory {
    public static final String AUTHORITY = "com.example.user.jobcreator.Directory";
    public static final String PATH = "/details";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + PATH);
   public static final String CONTENT_DICTIONARY_LIST = "vnd.android.cursor.dir/vnd.com.example.user.jobcreator.details";
    public static final String CONTENT_DICTIONARY_ITEM = "vnd.android.cursor.item/vnd.com.example.user.jobcreator.details";
    public static final String DATABASE_NAME =  "StudentData1";
    public static final int DATABASE_VERSION = 1;
    public class Details implements BaseColumns
    {
        private Details(){}
        public static final String TABLE_NAME = "details";
        public static final String NAME = "_name";
        public static final String CGPA = "_cgpa";
        public static final String NUM = "_number";
        public static final String INSP = "_insp";
        public static final String BLOG = "_blog";

    }
}
