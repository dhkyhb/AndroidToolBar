package com.example.administrator.androidtoolbar.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.androidtoolbar.APP;
import com.example.administrator.androidtoolbar.R;
import com.example.administrator.androidtoolbar.Utils.sup.Settings;

import static android.content.ContentValues.TAG;

/**
 * 作者: wdh <br>
 * 内容摘要: <br>
 * 创建时间:  2016/6/20 18:08<br>
 * 描述:  <br>
 */
public class TLog {
    public static boolean isTest = true;
    public static boolean isDebug = true;

    private static Settings settings = new Settings();

    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }

    public static void e(String msg) {
//        Logger.e(msg);
        settings.getLogAdapter().e(getModule(), msg);
    }

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    private static int i = 0;

    public static void pos(String tag, String msg) {
        e(tag, msg);
    }

    public static void l(String msg) {
        e(TAG + "." + (++i), msg);
    }

//    public static void d(String msg) {
//        d(TAG + "." + (++i), msg);
//    }

    public static void e(Activity o, String msg) {
        e(o.getClass().getName(), msg);
    }

    public static void e(Dialog o, String msg) {
        e(o.getClass().getName(), msg);
    }

    public static void d(String msg) {
//        Logger.d(msg);
        settings.getLogAdapter().d(getModule(), msg);
    }

    //    public static void l(String msg) {
//        Logger.d(msg);
//    }
    private static String getSimpleClassName(String name) {
        int lastIndex = name.lastIndexOf(".");
        return name.substring(lastIndex + 1);
    }

    public static void p(String msg) {
        settings.getLogAdapter().e(getModule(), msg);
    }

    private static String getModule() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        int stackOffset = -1;
        int methodCount = 2;
        for (int i = 3; i < trace.length; i++) {
            StackTraceElement e = trace[i];
            String name = e.getClassName();
            if (!name.equals(TLog.class.getName())) {
                stackOffset = i;
                break;
            }
        }
        for (int i = methodCount; i > 0; i--) {
            int stackIndex = stackOffset;
            String simpleClassName = getSimpleClassName(trace[stackIndex].getClassName());
            if (simpleClassName.startsWith("TLog")) {
                continue;
            } else {
                i = 0;
            }
            StringBuilder builder = new StringBuilder();
            builder.append("")
                    .append(" (")
                    .append(trace[stackIndex].getFileName())
                    .append(":")
                    .append(trace[stackIndex].getLineNumber())
                    .append(") [")
                    .append(getSimpleClassName(trace[stackIndex].getClassName()))
                    .append(".")
                    .append(trace[stackIndex].getMethodName()).append("]");
            return builder.toString();
        }
        return "-----";
    }

    public static APP context() {
        return APP.getInstance();
    }

    public static void showToast(int message) {
        showToast(message, Toast.LENGTH_LONG, 0);
    }

    public static void showToast(String message) {
        showToast(message, Toast.LENGTH_LONG, 0, Gravity.BOTTOM);
    }

    public static void showToast(final Context context, final String message) {
        Activity context1 = (Activity) context;
        context1.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showToast(context, message, Toast.LENGTH_LONG, 0, Gravity.BOTTOM);
            }
        });
    }

    public static void showToast(int message, int icon) {
        showToast(message, Toast.LENGTH_LONG, icon);
    }

    public static void showToast(String message, int icon) {
        showToast(message, Toast.LENGTH_LONG, icon, Gravity.BOTTOM);
    }

    public static void showToastShort(int message) {
        showToast(message, Toast.LENGTH_SHORT, 0);
    }

    public static void showToastShort(String message) {
        showToast(message, Toast.LENGTH_SHORT, 0, Gravity.BOTTOM);
    }

    public static void showToastShort(int message, Object... args) {
        showToast(message, Toast.LENGTH_SHORT, 0, Gravity.BOTTOM, args);
    }

    public static void showToast(int message, int duration, int icon) {
        showToast(message, duration, icon, Gravity.BOTTOM);
    }

    public static void showToast(int message, int duration, int icon,
                                 int gravity) {
        showToast(context().getString(message), duration, icon, gravity);
    }

    public static void showToast(int message, int duration, int icon,
                                 int gravity, Object... args) {
        showToast(context().getString(message, args), duration, icon, gravity);
    }

    private static long lastToastTime;
    private static String lastToast = "";

    public static void showToast(Context context, String message, int duration, int icon,
                                 int gravity) {
        TLog.e("showToast(String message, int duration, int icon, int gravity) message=" + message);
        if (message != null && !message.equalsIgnoreCase("")) {
            long time = System.currentTimeMillis();
            //|| Math.abs(time - lastToastTime) > 2000
            if (!message.equalsIgnoreCase(lastToast) || Math.abs(time - lastToastTime) > 2000
                    ) {
                View view = LayoutInflater.from(context).inflate(
                        R.layout.view_toast, null);
                ((TextView) view.findViewById(R.id.title_tv)).setText(message);
                if (icon != 0) {
                    ((ImageView) view.findViewById(R.id.icon_iv))
                            .setImageResource(icon);
                    ((ImageView) view.findViewById(R.id.icon_iv))
                            .setVisibility(View.VISIBLE);
                }
                Toast toast = new Toast(context);
                toast.setView(view);
                if (gravity == Gravity.CENTER) {
                    toast.setGravity(gravity, 0, 0);
                } else {
                    toast.setGravity(gravity, 0, 35);
                }

                toast.setDuration(duration);
                toast.show();
                lastToast = message;
                lastToastTime = System.currentTimeMillis();
            }
        }
    }

    public static void showToast(String message, int duration, int icon,
                                 int gravity) {
        showToast(context(), message, Toast.LENGTH_LONG, 0, Gravity.BOTTOM);
    }

    public static String getString(int id) {
        try {
            if (id != 0) {
                return context().getString(id);
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }
}
