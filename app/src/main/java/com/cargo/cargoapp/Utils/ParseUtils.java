package com.cargo.cargoapp.Utils;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by marcosantonioaguilerely on 6/3/15.
 */
public class ParseUtils extends Application {
    Context context = this;

    @Override
    public void onCreate() {
        super.onCreate();
        // Add your initialization code here
        Parse.enableLocalDatastore(context);
        Parse.initialize(context, "M9x2BotJSmbiWtVD3TnADGBI6BZ8zk3NSJHVjA3U", "45LqN5IUKeMLsQbCuVBqn3moSxK4lrJ1EsqmFpE9");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
        Log.d("Init>", "-->"+ Parse.getLogLevel());
    }
}
